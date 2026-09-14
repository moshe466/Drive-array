package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Query;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class SyncTree {
    private static final long SIZE_THRESHOLD_FOR_COMPOUND_HASH = 1024;
    private final ListenProvider listenProvider;
    private final LogWrapper logger;
    private final PersistenceManager persistenceManager;
    private long nextQueryTag = 1;
    private ImmutableTree<SyncPoint> syncPointTree = ImmutableTree.emptyInstance();
    private final WriteTree pendingWriteTree = new WriteTree();
    private final Map<Tag, QuerySpec> tagToQueryMap = new HashMap();
    private final Map<QuerySpec, Tag> queryToTagMap = new HashMap();
    private final Set<QuerySpec> keepSyncedQueries = new HashSet();

    /* loaded from: classes.dex */
    public interface CompletionListener {
        List<? extends Event> onListenComplete(DatabaseError databaseError);
    }

    /* loaded from: classes.dex */
    public static class KeepSyncedEventRegistration extends EventRegistration {
        private QuerySpec spec;

        public KeepSyncedEventRegistration(QuerySpec querySpec) {
            this.spec = querySpec;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public EventRegistration clone(QuerySpec querySpec) {
            return new KeepSyncedEventRegistration(querySpec);
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public DataEvent createEvent(Change change, QuerySpec querySpec) {
            return null;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof KeepSyncedEventRegistration) && ((KeepSyncedEventRegistration) obj).spec.equals(this.spec)) {
                return true;
            }
            return false;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireCancelEvent(DatabaseError databaseError) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireEvent(DataEvent dataEvent) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public QuerySpec getQuerySpec() {
            return this.spec;
        }

        public int hashCode() {
            return this.spec.hashCode();
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean isSameListener(EventRegistration eventRegistration) {
            return eventRegistration instanceof KeepSyncedEventRegistration;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean respondsTo(Event.EventType eventType) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class ListenContainer implements ListenHashProvider, CompletionListener {
        private final Tag tag;
        private final View view;

        public ListenContainer(View view) {
            this.view = view;
            this.tag = SyncTree.this.tagForQuery(view.getQuery());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public CompoundHash getCompoundHash() {
            com.google.firebase.database.snapshot.CompoundHash fromNode = com.google.firebase.database.snapshot.CompoundHash.fromNode(this.view.getServerCache());
            List<Path> posts = fromNode.getPosts();
            ArrayList arrayList = new ArrayList(posts.size());
            Iterator<Path> it = posts.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().asList());
            }
            return new CompoundHash(arrayList, fromNode.getHashes());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public String getSimpleHash() {
            return this.view.getServerCache().getHash();
        }

        @Override // com.google.firebase.database.core.SyncTree.CompletionListener
        public List<? extends Event> onListenComplete(DatabaseError databaseError) {
            if (databaseError != null) {
                SyncTree.this.logger.warn("Listen at " + this.view.getQuery().getPath() + " failed: " + databaseError.toString());
                return SyncTree.this.removeAllEventRegistrations(this.view.getQuery(), databaseError);
            }
            QuerySpec query = this.view.getQuery();
            Tag tag = this.tag;
            if (tag != null) {
                return SyncTree.this.applyTaggedListenComplete(tag);
            }
            return SyncTree.this.applyListenComplete(query.getPath());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public boolean shouldIncludeCompoundHash() {
            if (NodeSizeEstimator.estimateSerializedNodeSize(this.view.getServerCache()) > SyncTree.SIZE_THRESHOLD_FOR_COMPOUND_HASH) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface ListenProvider {
        void startListening(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, CompletionListener completionListener);

        void stopListening(QuerySpec querySpec, Tag tag);
    }

    public SyncTree(Context context, PersistenceManager persistenceManager, ListenProvider listenProvider) {
        this.listenProvider = listenProvider;
        this.persistenceManager = persistenceManager;
        this.logger = context.getLogger("SyncTree");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Event> applyOperationDescendantsHelper(final Operation operation, ImmutableTree<SyncPoint> immutableTree, Node node, final WriteTreeRef writeTreeRef) {
        SyncPoint value = immutableTree.getValue();
        if (node == null && value != null) {
            node = value.getCompleteServerCache(Path.getEmptyPath());
        }
        final Node node2 = node;
        final ArrayList arrayList = new ArrayList();
        immutableTree.getChildren().inOrderTraversal(new LLRBNode.NodeVisitor<ChildKey, ImmutableTree<SyncPoint>>() { // from class: com.google.firebase.database.core.SyncTree.16
            @Override // com.google.firebase.database.collection.LLRBNode.NodeVisitor
            public void visitEntry(ChildKey childKey, ImmutableTree<SyncPoint> immutableTree2) {
                Node node3 = node2;
                Node immediateChild = node3 != null ? node3.getImmediateChild(childKey) : null;
                WriteTreeRef child = writeTreeRef.child(childKey);
                Operation operationForChild = operation.operationForChild(childKey);
                if (operationForChild != null) {
                    arrayList.addAll(SyncTree.this.applyOperationDescendantsHelper(operationForChild, immutableTree2, immediateChild, child));
                }
            }
        });
        if (value != null) {
            arrayList.addAll(value.applyOperation(operation, writeTreeRef, node2));
        }
        return arrayList;
    }

    private List<Event> applyOperationHelper(Operation operation, ImmutableTree<SyncPoint> immutableTree, Node node, WriteTreeRef writeTreeRef) {
        Node node2;
        if (operation.getPath().isEmpty()) {
            return applyOperationDescendantsHelper(operation, immutableTree, node, writeTreeRef);
        }
        SyncPoint value = immutableTree.getValue();
        if (node == null && value != null) {
            node = value.getCompleteServerCache(Path.getEmptyPath());
        }
        ArrayList arrayList = new ArrayList();
        ChildKey front = operation.getPath().getFront();
        Operation operationForChild = operation.operationForChild(front);
        ImmutableTree<SyncPoint> immutableTree2 = immutableTree.getChildren().get(front);
        if (immutableTree2 != null && operationForChild != null) {
            if (node != null) {
                node2 = node.getImmediateChild(front);
            } else {
                node2 = null;
            }
            arrayList.addAll(applyOperationHelper(operationForChild, immutableTree2, node2, writeTreeRef.child(front)));
        }
        if (value != null) {
            arrayList.addAll(value.applyOperation(operation, writeTreeRef, node));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Event> applyOperationToSyncPoints(Operation operation) {
        return applyOperationHelper(operation, this.syncPointTree, null, this.pendingWriteTree.childWrites(Path.getEmptyPath()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<? extends Event> applyTaggedOperation(QuerySpec querySpec, Operation operation) {
        boolean z3;
        Path path = querySpec.getPath();
        SyncPoint syncPoint = this.syncPointTree.get(path);
        if (syncPoint != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Utilities.hardAssert(z3, "Missing sync point for query tag that we're tracking");
        return syncPoint.applyOperation(operation, this.pendingWriteTree.childWrites(path), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<View> collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> immutableTree) {
        ArrayList arrayList = new ArrayList();
        collectDistinctViewsForSubTree(immutableTree, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Tag getNextQueryTag() {
        long j2 = this.nextQueryTag;
        this.nextQueryTag = 1 + j2;
        return new Tag(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Node lambda$getServerValue$0(QuerySpec querySpec) {
        boolean z3;
        Node Empty;
        ChildKey front;
        Path path = querySpec.getPath();
        ImmutableTree<SyncPoint> immutableTree = this.syncPointTree;
        Node node = null;
        Path path2 = path;
        boolean z4 = false;
        while (true) {
            z3 = true;
            if (immutableTree.isEmpty()) {
                break;
            }
            SyncPoint value = immutableTree.getValue();
            if (value != null) {
                if (node == null) {
                    node = value.getCompleteServerCache(path2);
                }
                if (!z4 && !value.hasCompleteView()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
            }
            if (path2.isEmpty()) {
                front = ChildKey.fromString("");
            } else {
                front = path2.getFront();
            }
            immutableTree = immutableTree.getChild(front);
            path2 = path2.popFront();
        }
        SyncPoint syncPoint = this.syncPointTree.get(path);
        if (syncPoint == null) {
            syncPoint = new SyncPoint(this.persistenceManager);
            this.syncPointTree = this.syncPointTree.set(path, syncPoint);
        } else if (node == null) {
            node = syncPoint.getCompleteServerCache(Path.getEmptyPath());
        }
        if (node != null) {
            Empty = node;
        } else {
            Empty = EmptyNode.Empty();
        }
        IndexedNode from = IndexedNode.from(Empty, querySpec.getIndex());
        if (node == null) {
            z3 = false;
        }
        return syncPoint.getView(querySpec, this.pendingWriteTree.childWrites(path), new CacheNode(from, z3, false)).getCompleteNode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuerySpec queryForListening(QuerySpec querySpec) {
        if (querySpec.loadsAllData() && !querySpec.isDefault()) {
            return QuerySpec.defaultQueryAtPath(querySpec.getPath());
        }
        return querySpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuerySpec queryForTag(Tag tag) {
        return this.tagToQueryMap.get(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTags(List<QuerySpec> list) {
        boolean z3;
        for (QuerySpec querySpec : list) {
            if (!querySpec.loadsAllData()) {
                Tag tagForQuery = tagForQuery(querySpec);
                if (tagForQuery != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Utilities.hardAssert(z3);
                this.queryToTagMap.remove(querySpec);
                this.tagToQueryMap.remove(tagForQuery);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupListener(QuerySpec querySpec, View view) {
        Path path = querySpec.getPath();
        Tag tagForQuery = tagForQuery(querySpec);
        ListenContainer listenContainer = new ListenContainer(view);
        this.listenProvider.startListening(queryForListening(querySpec), tagForQuery, listenContainer, listenContainer);
        ImmutableTree<SyncPoint> subtree = this.syncPointTree.subtree(path);
        if (tagForQuery != null) {
            Utilities.hardAssert(!subtree.getValue().hasCompleteView(), "If we're adding a query, it shouldn't be shadowed");
        } else {
            subtree.foreach(new ImmutableTree.TreeVisitor<SyncPoint, Void>() { // from class: com.google.firebase.database.core.SyncTree.15
                @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
                public Void onNodeValue(Path path2, SyncPoint syncPoint, Void r5) {
                    if (!path2.isEmpty() && syncPoint.hasCompleteView()) {
                        QuerySpec query = syncPoint.getCompleteView().getQuery();
                        SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query), SyncTree.this.tagForQuery(query));
                        return null;
                    }
                    Iterator<View> it = syncPoint.getQueryViews().iterator();
                    while (it.hasNext()) {
                        QuerySpec query2 = it.next().getQuery();
                        SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query2), SyncTree.this.tagForQuery(query2));
                    }
                    return null;
                }
            });
        }
    }

    public List<? extends Event> ackUserWrite(final long j2, final boolean z3, final boolean z4, final Clock clock) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.3
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z4) {
                    SyncTree.this.persistenceManager.removeUserWrite(j2);
                }
                UserWriteRecord write = SyncTree.this.pendingWriteTree.getWrite(j2);
                boolean removeWrite = SyncTree.this.pendingWriteTree.removeWrite(j2);
                if (write.isVisible() && !z3) {
                    Map<String, Object> generateServerValues = ServerValues.generateServerValues(clock);
                    if (write.isOverwrite()) {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), SyncTree.this, write.getPath(), generateServerValues));
                    } else {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueMerge(write.getMerge(), SyncTree.this, write.getPath(), generateServerValues));
                    }
                }
                if (!removeWrite) {
                    return Collections.EMPTY_LIST;
                }
                ImmutableTree emptyInstance = ImmutableTree.emptyInstance();
                if (write.isOverwrite()) {
                    emptyInstance = emptyInstance.set(Path.getEmptyPath(), Boolean.TRUE);
                } else {
                    Iterator<Map.Entry<Path, Node>> it = write.getMerge().iterator();
                    while (it.hasNext()) {
                        emptyInstance = emptyInstance.set(it.next().getKey(), Boolean.TRUE);
                    }
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(write.getPath(), emptyInstance, z3));
            }
        });
    }

    public List<? extends Event> addEventRegistration(EventRegistration eventRegistration) {
        return addEventRegistration(eventRegistration, false);
    }

    public List<? extends Event> applyListenComplete(final Path path) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.7
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.setQueryComplete(QuerySpec.defaultQueryAtPath(path));
                return SyncTree.this.applyOperationToSyncPoints(new ListenComplete(OperationSource.SERVER, path));
            }
        });
    }

    public List<? extends Event> applyServerMerge(final Path path, final Map<Path, Node> map) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.6
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(map);
                SyncTree.this.persistenceManager.updateServerCache(path, fromPathMerge);
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.SERVER, path, fromPathMerge));
            }
        });
    }

    public List<? extends Event> applyServerOverwrite(final Path path, final Node node) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.5
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.updateServerCache(QuerySpec.defaultQueryAtPath(path), node);
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.SERVER, path, node));
            }
        });
    }

    public List<? extends Event> applyServerRangeMerges(Path path, List<RangeMerge> list) {
        SyncPoint syncPoint = this.syncPointTree.get(path);
        if (syncPoint == null) {
            return Collections.EMPTY_LIST;
        }
        View completeView = syncPoint.getCompleteView();
        if (completeView != null) {
            Node serverCache = completeView.getServerCache();
            Iterator<RangeMerge> it = list.iterator();
            while (it.hasNext()) {
                serverCache = it.next().applyTo(serverCache);
            }
            return applyServerOverwrite(path, serverCache);
        }
        return Collections.EMPTY_LIST;
    }

    public List<? extends Event> applyTaggedListenComplete(final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.8
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag != null) {
                    SyncTree.this.persistenceManager.setQueryComplete(queryForTag);
                    return SyncTree.this.applyTaggedOperation(queryForTag, new ListenComplete(OperationSource.forServerTaggedQuery(queryForTag.getParams()), Path.getEmptyPath()));
                }
                return Collections.EMPTY_LIST;
            }
        });
    }

    public List<? extends Event> applyTaggedQueryMerge(final Path path, final Map<Path, Node> map, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.10
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag != null) {
                    Path relative = Path.getRelative(queryForTag.getPath(), path);
                    CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(map);
                    SyncTree.this.persistenceManager.updateServerCache(path, fromPathMerge);
                    return SyncTree.this.applyTaggedOperation(queryForTag, new Merge(OperationSource.forServerTaggedQuery(queryForTag.getParams()), relative, fromPathMerge));
                }
                return Collections.EMPTY_LIST;
            }
        });
    }

    public List<? extends Event> applyTaggedQueryOverwrite(final Path path, final Node node, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.9
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag != null) {
                    Path relative = Path.getRelative(queryForTag.getPath(), path);
                    SyncTree.this.persistenceManager.updateServerCache(relative.isEmpty() ? queryForTag : QuerySpec.defaultQueryAtPath(path), node);
                    return SyncTree.this.applyTaggedOperation(queryForTag, new Overwrite(OperationSource.forServerTaggedQuery(queryForTag.getParams()), relative, node));
                }
                return Collections.EMPTY_LIST;
            }
        });
    }

    public List<? extends Event> applyTaggedRangeMerges(Path path, List<RangeMerge> list, Tag tag) {
        boolean z3;
        QuerySpec queryForTag = queryForTag(tag);
        if (queryForTag != null) {
            Utilities.hardAssert(path.equals(queryForTag.getPath()));
            SyncPoint syncPoint = this.syncPointTree.get(queryForTag.getPath());
            boolean z4 = false;
            if (syncPoint != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Utilities.hardAssert(z3, "Missing sync point for query tag that we're tracking");
            View viewForQuery = syncPoint.viewForQuery(queryForTag);
            if (viewForQuery != null) {
                z4 = true;
            }
            Utilities.hardAssert(z4, "Missing view for query tag that we're tracking");
            Node serverCache = viewForQuery.getServerCache();
            Iterator<RangeMerge> it = list.iterator();
            while (it.hasNext()) {
                serverCache = it.next().applyTo(serverCache);
            }
            return applyTaggedQueryOverwrite(path, serverCache, tag);
        }
        return Collections.EMPTY_LIST;
    }

    public List<? extends Event> applyUserMerge(final Path path, final CompoundWrite compoundWrite, final CompoundWrite compoundWrite2, final long j2, final boolean z3) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.2
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z3) {
                    SyncTree.this.persistenceManager.saveUserMerge(path, compoundWrite, j2);
                }
                SyncTree.this.pendingWriteTree.addMerge(path, compoundWrite2, Long.valueOf(j2));
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.USER, path, compoundWrite2));
            }
        });
    }

    public List<? extends Event> applyUserOverwrite(final Path path, final Node node, final Node node2, final long j2, final boolean z3, final boolean z4) {
        boolean z5;
        if (!z3 && z4) {
            z5 = false;
        } else {
            z5 = true;
        }
        Utilities.hardAssert(z5, "We shouldn't be persisting non-visible writes.");
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.1
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z4) {
                    SyncTree.this.persistenceManager.saveUserOverwrite(path, node, j2);
                }
                SyncTree.this.pendingWriteTree.addOverwrite(path, node2, Long.valueOf(j2), z3);
                if (z3) {
                    return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.USER, path, node2));
                }
                return Collections.EMPTY_LIST;
            }
        });
    }

    public Node calcCompleteEventCache(Path path, List<Long> list) {
        ImmutableTree<SyncPoint> immutableTree = this.syncPointTree;
        immutableTree.getValue();
        Path emptyPath = Path.getEmptyPath();
        Node node = null;
        Path path2 = path;
        do {
            ChildKey front = path2.getFront();
            path2 = path2.popFront();
            emptyPath = emptyPath.child(front);
            Path relative = Path.getRelative(emptyPath, path);
            if (front != null) {
                immutableTree = immutableTree.getChild(front);
            } else {
                immutableTree = ImmutableTree.emptyInstance();
            }
            SyncPoint value = immutableTree.getValue();
            if (value != null) {
                node = value.getCompleteServerCache(relative);
            }
            if (path2.isEmpty()) {
                break;
            }
        } while (node == null);
        return this.pendingWriteTree.calcCompleteEventCache(path, node, list, true);
    }

    public Node calcCompleteEventCacheFromRoot(Path path, List<Long> list) {
        Node node;
        SyncPoint value = this.syncPointTree.getValue();
        if (value != null) {
            node = value.getCompleteServerCache(Path.getEmptyPath());
        } else {
            node = null;
        }
        if (node != null) {
            return this.pendingWriteTree.calcCompleteEventCache(path, node, list, true);
        }
        return calcCompleteEventCache(path, list);
    }

    public Node getServerValue(final QuerySpec querySpec) {
        return (Node) this.persistenceManager.runInTransaction(new Callable() { // from class: com.google.firebase.database.core.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Node lambda$getServerValue$0;
                lambda$getServerValue$0 = SyncTree.this.lambda$getServerValue$0(querySpec);
                return lambda$getServerValue$0;
            }
        });
    }

    public ImmutableTree<SyncPoint> getSyncPointTree() {
        return this.syncPointTree;
    }

    public boolean isEmpty() {
        return this.syncPointTree.isEmpty();
    }

    public void keepSynced(QuerySpec querySpec, boolean z3) {
        keepSynced(querySpec, z3, false);
    }

    public DataSnapshot persistenceServerCache(Query query) {
        return InternalHelpers.createDataSnapshot(query.getRef(), this.persistenceManager.serverCache(query.getSpec()).getIndexedNode());
    }

    public List<Event> removeAllEventRegistrations(QuerySpec querySpec, DatabaseError databaseError) {
        return removeEventRegistration(querySpec, null, databaseError, false);
    }

    public List<? extends Event> removeAllWrites() {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.4
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.removeAllUserWrites();
                if (SyncTree.this.pendingWriteTree.purgeAllWrites().isEmpty()) {
                    return Collections.EMPTY_LIST;
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(Path.getEmptyPath(), new ImmutableTree(Boolean.TRUE), true));
            }
        });
    }

    public List<Event> removeEventRegistration(EventRegistration eventRegistration) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, null, false);
    }

    public void setQueryActive(final QuerySpec querySpec) {
        this.persistenceManager.runInTransaction(new Callable<Void>() { // from class: com.google.firebase.database.core.SyncTree.11
            @Override // java.util.concurrent.Callable
            public Void call() {
                SyncTree.this.persistenceManager.setQueryActive(querySpec);
                return null;
            }
        });
    }

    public void setQueryInactive(final QuerySpec querySpec) {
        this.persistenceManager.runInTransaction(new Callable<Void>() { // from class: com.google.firebase.database.core.SyncTree.12
            @Override // java.util.concurrent.Callable
            public Void call() {
                SyncTree.this.persistenceManager.setQueryInactive(querySpec);
                return null;
            }
        });
    }

    public Tag tagForQuery(QuerySpec querySpec) {
        return this.queryToTagMap.get(querySpec);
    }

    public List<? extends Event> addEventRegistration(final EventRegistration eventRegistration, final boolean z3) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.13
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CacheNode serverCache;
                Node completeServerCache;
                QuerySpec querySpec = eventRegistration.getQuerySpec();
                Path path = querySpec.getPath();
                ImmutableTree immutableTree = SyncTree.this.syncPointTree;
                Node node = null;
                Path path2 = path;
                boolean z4 = false;
                while (!immutableTree.isEmpty()) {
                    SyncPoint syncPoint = (SyncPoint) immutableTree.getValue();
                    if (syncPoint != null) {
                        if (node == null) {
                            node = syncPoint.getCompleteServerCache(path2);
                        }
                        z4 = z4 || syncPoint.hasCompleteView();
                    }
                    immutableTree = immutableTree.getChild(path2.isEmpty() ? ChildKey.fromString("") : path2.getFront());
                    path2 = path2.popFront();
                }
                SyncPoint syncPoint2 = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                if (syncPoint2 == null) {
                    syncPoint2 = new SyncPoint(SyncTree.this.persistenceManager);
                    SyncTree syncTree = SyncTree.this;
                    syncTree.syncPointTree = syncTree.syncPointTree.set(path, syncPoint2);
                } else {
                    z4 = z4 || syncPoint2.hasCompleteView();
                    if (node == null) {
                        node = syncPoint2.getCompleteServerCache(Path.getEmptyPath());
                    }
                }
                SyncTree.this.persistenceManager.setQueryActive(querySpec);
                if (node == null) {
                    serverCache = SyncTree.this.persistenceManager.serverCache(querySpec);
                    if (!serverCache.isFullyInitialized()) {
                        Node Empty = EmptyNode.Empty();
                        Iterator it = SyncTree.this.syncPointTree.subtree(path).getChildren().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            SyncPoint syncPoint3 = (SyncPoint) ((ImmutableTree) entry.getValue()).getValue();
                            if (syncPoint3 != null && (completeServerCache = syncPoint3.getCompleteServerCache(Path.getEmptyPath())) != null) {
                                Empty = Empty.updateImmediateChild((ChildKey) entry.getKey(), completeServerCache);
                            }
                        }
                        for (NamedNode namedNode : serverCache.getNode()) {
                            if (!Empty.hasChild(namedNode.getName())) {
                                Empty = Empty.updateImmediateChild(namedNode.getName(), namedNode.getNode());
                            }
                        }
                        serverCache = new CacheNode(IndexedNode.from(Empty, querySpec.getIndex()), false, false);
                    }
                } else {
                    serverCache = new CacheNode(IndexedNode.from(node, querySpec.getIndex()), true, false);
                }
                boolean viewExistsForQuery = syncPoint2.viewExistsForQuery(querySpec);
                if (!viewExistsForQuery && !querySpec.loadsAllData()) {
                    Utilities.hardAssert(!SyncTree.this.queryToTagMap.containsKey(querySpec), "View does not exist but we have a tag");
                    Tag nextQueryTag = SyncTree.this.getNextQueryTag();
                    SyncTree.this.queryToTagMap.put(querySpec, nextQueryTag);
                    SyncTree.this.tagToQueryMap.put(nextQueryTag, querySpec);
                }
                List<DataEvent> addEventRegistration = syncPoint2.addEventRegistration(eventRegistration, SyncTree.this.pendingWriteTree.childWrites(path), serverCache);
                if (!viewExistsForQuery && !z4 && !z3) {
                    SyncTree.this.setupListener(querySpec, syncPoint2.viewForQuery(querySpec));
                }
                return addEventRegistration;
            }
        });
    }

    public void keepSynced(QuerySpec querySpec, boolean z3, boolean z4) {
        if (z3 && !this.keepSyncedQueries.contains(querySpec)) {
            addEventRegistration(new KeepSyncedEventRegistration(querySpec), z4);
            this.keepSyncedQueries.add(querySpec);
        } else {
            if (z3 || !this.keepSyncedQueries.contains(querySpec)) {
                return;
            }
            removeEventRegistration(new KeepSyncedEventRegistration(querySpec), z4);
            this.keepSyncedQueries.remove(querySpec);
        }
    }

    private void collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> immutableTree, List<View> list) {
        SyncPoint value = immutableTree.getValue();
        if (value != null && value.hasCompleteView()) {
            list.add(value.getCompleteView());
            return;
        }
        if (value != null) {
            list.addAll(value.getQueryViews());
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<SyncPoint>>> it = immutableTree.getChildren().iterator();
        while (it.hasNext()) {
            collectDistinctViewsForSubTree(it.next().getValue(), list);
        }
    }

    public List<Event> removeEventRegistration(EventRegistration eventRegistration, boolean z3) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, null, z3);
    }

    private List<Event> removeEventRegistration(final QuerySpec querySpec, final EventRegistration eventRegistration, final DatabaseError databaseError, final boolean z3) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<Event>>() { // from class: com.google.firebase.database.core.SyncTree.14
            @Override // java.util.concurrent.Callable
            public List<Event> call() {
                boolean z4;
                Path path = querySpec.getPath();
                SyncPoint syncPoint = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                List<Event> arrayList = new ArrayList<>();
                if (syncPoint != null && (querySpec.isDefault() || syncPoint.viewExistsForQuery(querySpec))) {
                    Pair<List<QuerySpec>, List<Event>> removeEventRegistration = syncPoint.removeEventRegistration(querySpec, eventRegistration, databaseError);
                    if (syncPoint.isEmpty()) {
                        SyncTree syncTree = SyncTree.this;
                        syncTree.syncPointTree = syncTree.syncPointTree.remove(path);
                    }
                    List<QuerySpec> first = removeEventRegistration.getFirst();
                    arrayList = removeEventRegistration.getSecond();
                    loop0: while (true) {
                        for (QuerySpec querySpec2 : first) {
                            SyncTree.this.persistenceManager.setQueryInactive(querySpec);
                            z4 = z4 || querySpec2.loadsAllData();
                        }
                    }
                    if (z3) {
                        return null;
                    }
                    ImmutableTree immutableTree = SyncTree.this.syncPointTree;
                    boolean z5 = immutableTree.getValue() != null && ((SyncPoint) immutableTree.getValue()).hasCompleteView();
                    Iterator<ChildKey> it = path.iterator();
                    while (it.hasNext()) {
                        immutableTree = immutableTree.getChild(it.next());
                        z5 = z5 || (immutableTree.getValue() != null && ((SyncPoint) immutableTree.getValue()).hasCompleteView());
                        if (z5 || immutableTree.isEmpty()) {
                            break;
                        }
                    }
                    if (z4 && !z5) {
                        ImmutableTree subtree = SyncTree.this.syncPointTree.subtree(path);
                        if (!subtree.isEmpty()) {
                            for (View view : SyncTree.this.collectDistinctViewsForSubTree(subtree)) {
                                ListenContainer listenContainer = new ListenContainer(view);
                                SyncTree.this.listenProvider.startListening(SyncTree.this.queryForListening(view.getQuery()), listenContainer.tag, listenContainer, listenContainer);
                            }
                        }
                    }
                    if (!z5 && !first.isEmpty() && databaseError == null) {
                        if (z4) {
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(querySpec), null);
                        } else {
                            for (QuerySpec querySpec3 : first) {
                                Tag tagForQuery = SyncTree.this.tagForQuery(querySpec3);
                                Utilities.hardAssert(tagForQuery != null);
                                SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(querySpec3), tagForQuery);
                            }
                        }
                    }
                    SyncTree.this.removeTags(first);
                }
                return arrayList;
            }
        });
    }
}
