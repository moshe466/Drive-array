package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
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

/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface CompletionListener {
        List<? extends Event> onListenComplete(DatabaseError databaseError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class KeepSyncedEventRegistration extends EventRegistration {
        private QuerySpec spec;

        public KeepSyncedEventRegistration(@NotNull QuerySpec querySpec) {
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
            return (obj instanceof KeepSyncedEventRegistration) && ((KeepSyncedEventRegistration) obj).spec.equals(this.spec);
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireCancelEvent(DatabaseError databaseError) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireEvent(DataEvent dataEvent) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        @NotNull
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
            if (databaseError == null) {
                QuerySpec query = this.view.getQuery();
                Tag tag = this.tag;
                return tag != null ? SyncTree.this.applyTaggedListenComplete(tag) : SyncTree.this.applyListenComplete(query.getPath());
            }
            SyncTree.this.logger.warn("Listen at " + this.view.getQuery().getPath() + " failed: " + databaseError.toString());
            return SyncTree.this.removeAllEventRegistrations(this.view.getQuery(), databaseError);
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public boolean shouldIncludeCompoundHash() {
            return NodeSizeEstimator.estimateSerializedNodeSize(this.view.getServerCache()) > 1024;
        }
    }

    /* loaded from: classes2.dex */
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
        final ArrayList arrayList = new ArrayList();
        final Node node2 = node;
        immutableTree.getChildren().inOrderTraversal(new LLRBNode.NodeVisitor<ChildKey, ImmutableTree<SyncPoint>>() { // from class: com.google.firebase.database.core.SyncTree.14
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
            arrayList.addAll(value.applyOperation(operation, writeTreeRef, node));
        }
        return arrayList;
    }

    private List<Event> applyOperationHelper(Operation operation, ImmutableTree<SyncPoint> immutableTree, Node node, WriteTreeRef writeTreeRef) {
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
            arrayList.addAll(applyOperationHelper(operationForChild, immutableTree2, node != null ? node.getImmediateChild(front) : null, writeTreeRef.child(front)));
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
        Path path = querySpec.getPath();
        return this.syncPointTree.get(path).applyOperation(operation, this.pendingWriteTree.childWrites(path), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<View> collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> immutableTree) {
        ArrayList arrayList = new ArrayList();
        collectDistinctViewsForSubTree(immutableTree, arrayList);
        return arrayList;
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

    /* JADX INFO: Access modifiers changed from: private */
    public Tag getNextQueryTag() {
        long j = this.nextQueryTag;
        this.nextQueryTag = 1 + j;
        return new Tag(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuerySpec queryForListening(QuerySpec querySpec) {
        return (!querySpec.loadsAllData() || querySpec.isDefault()) ? querySpec : QuerySpec.defaultQueryAtPath(querySpec.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuerySpec queryForTag(Tag tag) {
        return this.tagToQueryMap.get(tag);
    }

    private List<Event> removeEventRegistration(@NotNull final QuerySpec querySpec, @Nullable final EventRegistration eventRegistration, @Nullable final DatabaseError databaseError) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<Event>>() { // from class: com.google.firebase.database.core.SyncTree.12
            @Override // java.util.concurrent.Callable
            public List<Event> call() {
                boolean z;
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
                            z = z || querySpec2.loadsAllData();
                        }
                    }
                    ImmutableTree immutableTree = SyncTree.this.syncPointTree;
                    boolean z2 = immutableTree.getValue() != null && ((SyncPoint) immutableTree.getValue()).hasCompleteView();
                    Iterator<ChildKey> it = path.iterator();
                    while (it.hasNext()) {
                        immutableTree = immutableTree.getChild(it.next());
                        z2 = z2 || (immutableTree.getValue() != null && ((SyncPoint) immutableTree.getValue()).hasCompleteView());
                        if (z2 || immutableTree.isEmpty()) {
                            break;
                        }
                    }
                    if (z && !z2) {
                        ImmutableTree subtree = SyncTree.this.syncPointTree.subtree(path);
                        if (!subtree.isEmpty()) {
                            for (View view : SyncTree.this.collectDistinctViewsForSubTree(subtree)) {
                                ListenContainer listenContainer = new ListenContainer(view);
                                SyncTree.this.listenProvider.startListening(SyncTree.this.queryForListening(view.getQuery()), listenContainer.tag, listenContainer, listenContainer);
                            }
                        }
                    }
                    if (!z2 && !first.isEmpty() && databaseError == null) {
                        if (z) {
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(querySpec), null);
                        } else {
                            for (QuerySpec querySpec3 : first) {
                                SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(querySpec3), SyncTree.this.tagForQuery(querySpec3));
                            }
                        }
                    }
                    SyncTree.this.removeTags(first);
                }
                return arrayList;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTags(List<QuerySpec> list) {
        for (QuerySpec querySpec : list) {
            if (!querySpec.loadsAllData()) {
                Tag tagForQuery = tagForQuery(querySpec);
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
            return;
        }
        subtree.foreach(new ImmutableTree.TreeVisitor<SyncPoint, Void>() { // from class: com.google.firebase.database.core.SyncTree.13
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

    /* JADX INFO: Access modifiers changed from: private */
    public Tag tagForQuery(QuerySpec querySpec) {
        return this.queryToTagMap.get(querySpec);
    }

    public List<? extends Event> ackUserWrite(final long j, final boolean z, final boolean z2, final Clock clock) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.3
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z2) {
                    SyncTree.this.persistenceManager.removeUserWrite(j);
                }
                UserWriteRecord write = SyncTree.this.pendingWriteTree.getWrite(j);
                boolean removeWrite = SyncTree.this.pendingWriteTree.removeWrite(j);
                if (write.isVisible() && !z) {
                    Map<String, Object> generateServerValues = ServerValues.generateServerValues(clock);
                    if (write.isOverwrite()) {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), generateServerValues));
                    } else {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueMerge(write.getMerge(), generateServerValues));
                    }
                }
                if (!removeWrite) {
                    return Collections.emptyList();
                }
                ImmutableTree emptyInstance = ImmutableTree.emptyInstance();
                if (write.isOverwrite()) {
                    emptyInstance = emptyInstance.set(Path.getEmptyPath(), true);
                } else {
                    Iterator<Map.Entry<Path, Node>> it = write.getMerge().iterator();
                    while (it.hasNext()) {
                        emptyInstance = emptyInstance.set(it.next().getKey(), true);
                    }
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(write.getPath(), emptyInstance, z));
            }
        });
    }

    public List<? extends Event> addEventRegistration(@NotNull final EventRegistration eventRegistration) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.11
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CacheNode serverCache;
                Node completeServerCache;
                QuerySpec querySpec = eventRegistration.getQuerySpec();
                Path path = querySpec.getPath();
                ImmutableTree immutableTree = SyncTree.this.syncPointTree;
                Path path2 = path;
                Node node = null;
                boolean z = false;
                while (true) {
                    boolean z2 = true;
                    if (immutableTree.isEmpty()) {
                        break;
                    }
                    SyncPoint syncPoint = (SyncPoint) immutableTree.getValue();
                    if (syncPoint != null) {
                        if (node == null) {
                            node = syncPoint.getCompleteServerCache(path2);
                        }
                        if (!z && !syncPoint.hasCompleteView()) {
                            z2 = false;
                        }
                        z = z2;
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
                    z = z || syncPoint2.hasCompleteView();
                    if (node == null) {
                        node = syncPoint2.getCompleteServerCache(Path.getEmptyPath());
                    }
                }
                SyncTree.this.persistenceManager.setQueryActive(querySpec);
                if (node != null) {
                    serverCache = new CacheNode(IndexedNode.from(node, querySpec.getIndex()), true, false);
                } else {
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
                }
                boolean viewExistsForQuery = syncPoint2.viewExistsForQuery(querySpec);
                if (!viewExistsForQuery && !querySpec.loadsAllData()) {
                    Tag nextQueryTag = SyncTree.this.getNextQueryTag();
                    SyncTree.this.queryToTagMap.put(querySpec, nextQueryTag);
                    SyncTree.this.tagToQueryMap.put(nextQueryTag, querySpec);
                }
                List<DataEvent> addEventRegistration = syncPoint2.addEventRegistration(eventRegistration, SyncTree.this.pendingWriteTree.childWrites(path), serverCache);
                if (!viewExistsForQuery && !z) {
                    SyncTree.this.setupListener(querySpec, syncPoint2.viewForQuery(querySpec));
                }
                return addEventRegistration;
            }
        });
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
        View completeView;
        SyncPoint syncPoint = this.syncPointTree.get(path);
        if (syncPoint != null && (completeView = syncPoint.getCompleteView()) != null) {
            Node serverCache = completeView.getServerCache();
            Iterator<RangeMerge> it = list.iterator();
            while (it.hasNext()) {
                serverCache = it.next().applyTo(serverCache);
            }
            return applyServerOverwrite(path, serverCache);
        }
        return Collections.emptyList();
    }

    public List<? extends Event> applyTaggedListenComplete(final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.8
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag == null) {
                    return Collections.emptyList();
                }
                SyncTree.this.persistenceManager.setQueryComplete(queryForTag);
                return SyncTree.this.applyTaggedOperation(queryForTag, new ListenComplete(OperationSource.forServerTaggedQuery(queryForTag.getParams()), Path.getEmptyPath()));
            }
        });
    }

    public List<? extends Event> applyTaggedQueryMerge(final Path path, final Map<Path, Node> map, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.10
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag == null) {
                    return Collections.emptyList();
                }
                Path relative = Path.getRelative(queryForTag.getPath(), path);
                CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(map);
                SyncTree.this.persistenceManager.updateServerCache(path, fromPathMerge);
                return SyncTree.this.applyTaggedOperation(queryForTag, new Merge(OperationSource.forServerTaggedQuery(queryForTag.getParams()), relative, fromPathMerge));
            }
        });
    }

    public List<? extends Event> applyTaggedQueryOverwrite(final Path path, final Node node, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.9
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag == null) {
                    return Collections.emptyList();
                }
                Path relative = Path.getRelative(queryForTag.getPath(), path);
                SyncTree.this.persistenceManager.updateServerCache(relative.isEmpty() ? queryForTag : QuerySpec.defaultQueryAtPath(path), node);
                return SyncTree.this.applyTaggedOperation(queryForTag, new Overwrite(OperationSource.forServerTaggedQuery(queryForTag.getParams()), relative, node));
            }
        });
    }

    public List<? extends Event> applyTaggedRangeMerges(Path path, List<RangeMerge> list, Tag tag) {
        QuerySpec queryForTag = queryForTag(tag);
        if (queryForTag == null) {
            return Collections.emptyList();
        }
        Node serverCache = this.syncPointTree.get(queryForTag.getPath()).viewForQuery(queryForTag).getServerCache();
        Iterator<RangeMerge> it = list.iterator();
        while (it.hasNext()) {
            serverCache = it.next().applyTo(serverCache);
        }
        return applyTaggedQueryOverwrite(path, serverCache, tag);
    }

    public List<? extends Event> applyUserMerge(final Path path, final CompoundWrite compoundWrite, final CompoundWrite compoundWrite2, final long j, final boolean z) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.2
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z) {
                    SyncTree.this.persistenceManager.saveUserMerge(path, compoundWrite, j);
                }
                SyncTree.this.pendingWriteTree.addMerge(path, compoundWrite2, Long.valueOf(j));
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.USER, path, compoundWrite2));
            }
        });
    }

    public List<? extends Event> applyUserOverwrite(final Path path, final Node node, final Node node2, final long j, final boolean z, final boolean z2) {
        Utilities.hardAssert(z || !z2, "We shouldn't be persisting non-visible writes.");
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.1
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z2) {
                    SyncTree.this.persistenceManager.saveUserOverwrite(path, node, j);
                }
                SyncTree.this.pendingWriteTree.addOverwrite(path, node2, Long.valueOf(j), z);
                return !z ? Collections.emptyList() : SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.USER, path, node2));
            }
        });
    }

    public Node calcCompleteEventCache(Path path, List<Long> list) {
        ImmutableTree<SyncPoint> immutableTree = this.syncPointTree;
        immutableTree.getValue();
        Path emptyPath = Path.getEmptyPath();
        Node node = null;
        ImmutableTree<SyncPoint> immutableTree2 = immutableTree;
        Path path2 = path;
        do {
            ChildKey front = path2.getFront();
            path2 = path2.popFront();
            emptyPath = emptyPath.child(front);
            Path relative = Path.getRelative(emptyPath, path);
            immutableTree2 = front != null ? immutableTree2.getChild(front) : ImmutableTree.emptyInstance();
            SyncPoint value = immutableTree2.getValue();
            if (value != null) {
                node = value.getCompleteServerCache(relative);
            }
            if (path2.isEmpty()) {
                break;
            }
        } while (node == null);
        return this.pendingWriteTree.calcCompleteEventCache(path, node, list, true);
    }

    public boolean isEmpty() {
        return this.syncPointTree.isEmpty();
    }

    public void keepSynced(QuerySpec querySpec, boolean z) {
        if (z && !this.keepSyncedQueries.contains(querySpec)) {
            addEventRegistration(new KeepSyncedEventRegistration(querySpec));
            this.keepSyncedQueries.add(querySpec);
        } else {
            if (z || !this.keepSyncedQueries.contains(querySpec)) {
                return;
            }
            removeEventRegistration(new KeepSyncedEventRegistration(querySpec));
            this.keepSyncedQueries.remove(querySpec);
        }
    }

    public List<Event> removeAllEventRegistrations(@NotNull QuerySpec querySpec, @NotNull DatabaseError databaseError) {
        return removeEventRegistration(querySpec, null, databaseError);
    }

    public List<? extends Event> removeAllWrites() {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() { // from class: com.google.firebase.database.core.SyncTree.4
            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.removeAllUserWrites();
                if (SyncTree.this.pendingWriteTree.purgeAllWrites().isEmpty()) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(Path.getEmptyPath(), new ImmutableTree(true), true));
            }
        });
    }

    public List<Event> removeEventRegistration(@NotNull EventRegistration eventRegistration) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, null);
    }
}
