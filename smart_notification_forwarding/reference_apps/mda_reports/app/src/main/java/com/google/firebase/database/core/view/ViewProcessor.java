package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ViewProcessor {
    private static NodeFilter.CompleteChildSource NO_COMPLETE_SOURCE = new NodeFilter.CompleteChildSource() { // from class: com.google.firebase.database.core.view.ViewProcessor.1
        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode, boolean z) {
            return null;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            return null;
        }
    };
    private final NodeFilter filter;

    /* renamed from: com.google.firebase.database.core.view.ViewProcessor$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[Operation.OperationType.values().length];

        static {
            try {
                a[Operation.OperationType.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Operation.OperationType.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Operation.OperationType.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Operation.OperationType.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ProcessorResult {
        public final List<Change> changes;
        public final ViewCache viewCache;

        public ProcessorResult(ViewCache viewCache, List<Change> list) {
            this.viewCache = viewCache;
            this.changes = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class WriteTreeCompleteChildSource implements NodeFilter.CompleteChildSource {
        private final Node optCompleteServerCache;
        private final ViewCache viewCache;
        private final WriteTreeRef writes;

        public WriteTreeCompleteChildSource(WriteTreeRef writeTreeRef, ViewCache viewCache, Node node) {
            this.writes = writeTreeRef;
            this.viewCache = viewCache;
            this.optCompleteServerCache = node;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode, boolean z) {
            Node node = this.optCompleteServerCache;
            if (node == null) {
                node = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(node, namedNode, z, index);
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            CacheNode eventCache = this.viewCache.getEventCache();
            if (eventCache.isCompleteForChild(childKey)) {
                return eventCache.getNode().getImmediateChild(childKey);
            }
            Node node = this.optCompleteServerCache;
            return this.writes.calcCompleteChild(childKey, node != null ? new CacheNode(IndexedNode.from(node, KeyIndex.getInstance()), true, false) : this.viewCache.getServerCache());
        }
    }

    public ViewProcessor(NodeFilter nodeFilter) {
        this.filter = nodeFilter;
    }

    private ViewCache ackUserWrite(ViewCache viewCache, Path path, ImmutableTree<Boolean> immutableTree, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        boolean isFiltered = viewCache.getServerCache().isFiltered();
        CacheNode serverCache = viewCache.getServerCache();
        if (immutableTree.getValue() == null) {
            CompoundWrite emptyWrite = CompoundWrite.emptyWrite();
            Iterator<Map.Entry<Path, Boolean>> it = immutableTree.iterator();
            CompoundWrite compoundWrite = emptyWrite;
            while (it.hasNext()) {
                Path key = it.next().getKey();
                Path child = path.child(key);
                if (serverCache.isCompleteForPath(child)) {
                    compoundWrite = compoundWrite.addWrite(key, serverCache.getNode().getChild(child));
                }
            }
            return applyServerMerge(viewCache, path, compoundWrite, writeTreeRef, node, isFiltered, childChangeAccumulator);
        }
        if ((path.isEmpty() && serverCache.isFullyInitialized()) || serverCache.isCompleteForPath(path)) {
            return applyServerOverwrite(viewCache, path, serverCache.getNode().getChild(path), writeTreeRef, node, isFiltered, childChangeAccumulator);
        }
        if (!path.isEmpty()) {
            return viewCache;
        }
        CompoundWrite emptyWrite2 = CompoundWrite.emptyWrite();
        CompoundWrite compoundWrite2 = emptyWrite2;
        for (NamedNode namedNode : serverCache.getNode()) {
            compoundWrite2 = compoundWrite2.addWrite(namedNode.getName(), namedNode.getNode());
        }
        return applyServerMerge(viewCache, path, compoundWrite2, writeTreeRef, node, isFiltered, childChangeAccumulator);
    }

    private ViewCache applyServerMerge(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, boolean z, ChildChangeAccumulator childChangeAccumulator) {
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            return viewCache;
        }
        CompoundWrite addWrites = path.isEmpty() ? compoundWrite : CompoundWrite.emptyWrite().addWrites(path, compoundWrite);
        Node node2 = viewCache.getServerCache().getNode();
        Map<ChildKey, CompoundWrite> childCompoundWrites = addWrites.childCompoundWrites();
        ViewCache viewCache2 = viewCache;
        for (Map.Entry<ChildKey, CompoundWrite> entry : childCompoundWrites.entrySet()) {
            ChildKey key = entry.getKey();
            if (node2.hasChild(key)) {
                viewCache2 = applyServerOverwrite(viewCache2, new Path(key), entry.getValue().apply(node2.getImmediateChild(key)), writeTreeRef, node, z, childChangeAccumulator);
            }
        }
        ViewCache viewCache3 = viewCache2;
        for (Map.Entry<ChildKey, CompoundWrite> entry2 : childCompoundWrites.entrySet()) {
            ChildKey key2 = entry2.getKey();
            boolean z2 = !viewCache.getServerCache().isCompleteForChild(key2) && entry2.getValue().rootWrite() == null;
            if (!node2.hasChild(key2) && !z2) {
                viewCache3 = applyServerOverwrite(viewCache3, new Path(key2), entry2.getValue().apply(node2.getImmediateChild(key2)), writeTreeRef, node, z, childChangeAccumulator);
            }
        }
        return viewCache3;
    }

    private ViewCache applyServerOverwrite(ViewCache viewCache, Path path, Node node, WriteTreeRef writeTreeRef, Node node2, boolean z, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode updateChild;
        IndexedNode updateChild2;
        IndexedNode indexedNode;
        CacheNode serverCache = viewCache.getServerCache();
        NodeFilter nodeFilter = this.filter;
        if (!z) {
            nodeFilter = nodeFilter.getIndexedFilter();
        }
        boolean z2 = true;
        if (path.isEmpty()) {
            indexedNode = serverCache.getIndexedNode();
            updateChild2 = IndexedNode.from(node, nodeFilter.getIndex());
        } else {
            if (!nodeFilter.filtersNodes() || serverCache.isFiltered()) {
                ChildKey front = path.getFront();
                if (!serverCache.isCompleteForPath(path) && path.size() > 1) {
                    return viewCache;
                }
                Path popFront = path.popFront();
                Node updateChild3 = serverCache.getNode().getImmediateChild(front).updateChild(popFront, node);
                if (front.isPriorityChildName()) {
                    updateChild = nodeFilter.updatePriority(serverCache.getIndexedNode(), updateChild3);
                } else {
                    updateChild = nodeFilter.updateChild(serverCache.getIndexedNode(), front, updateChild3, popFront, NO_COMPLETE_SOURCE, null);
                }
                if (!serverCache.isFullyInitialized() && !path.isEmpty()) {
                    z2 = false;
                }
                ViewCache updateServerSnap = viewCache.updateServerSnap(updateChild, z2, nodeFilter.filtersNodes());
                return generateEventCacheAfterServerEvent(updateServerSnap, path, writeTreeRef, new WriteTreeCompleteChildSource(writeTreeRef, updateServerSnap, node2), childChangeAccumulator);
            }
            ChildKey front2 = path.getFront();
            updateChild2 = serverCache.getIndexedNode().updateChild(front2, serverCache.getNode().getImmediateChild(front2).updateChild(path.popFront(), node));
            indexedNode = serverCache.getIndexedNode();
        }
        updateChild = nodeFilter.updateFullNode(indexedNode, updateChild2, null);
        if (!serverCache.isFullyInitialized()) {
            z2 = false;
        }
        ViewCache updateServerSnap2 = viewCache.updateServerSnap(updateChild, z2, nodeFilter.filtersNodes());
        return generateEventCacheAfterServerEvent(updateServerSnap2, path, writeTreeRef, new WriteTreeCompleteChildSource(writeTreeRef, updateServerSnap2, node2), childChangeAccumulator);
    }

    private ViewCache applyUserMerge(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        ViewCache viewCache2 = viewCache;
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            Path child = path.child(next.getKey());
            if (cacheHasChild(viewCache, child.getFront())) {
                viewCache2 = applyUserOverwrite(viewCache2, child, next.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        Iterator<Map.Entry<Path, Node>> it2 = compoundWrite.iterator();
        ViewCache viewCache3 = viewCache2;
        while (it2.hasNext()) {
            Map.Entry<Path, Node> next2 = it2.next();
            Path child2 = path.child(next2.getKey());
            if (!cacheHasChild(viewCache, child2.getFront())) {
                viewCache3 = applyUserOverwrite(viewCache3, child2, next2.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        return viewCache3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.firebase.database.core.view.ViewCache applyUserOverwrite(com.google.firebase.database.core.view.ViewCache r9, com.google.firebase.database.core.Path r10, com.google.firebase.database.snapshot.Node r11, com.google.firebase.database.core.WriteTreeRef r12, com.google.firebase.database.snapshot.Node r13, com.google.firebase.database.core.view.filter.ChildChangeAccumulator r14) {
        /*
            r8 = this;
            com.google.firebase.database.core.view.CacheNode r0 = r9.getEventCache()
            com.google.firebase.database.core.view.ViewProcessor$WriteTreeCompleteChildSource r6 = new com.google.firebase.database.core.view.ViewProcessor$WriteTreeCompleteChildSource
            r6.<init>(r12, r9, r13)
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L34
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r8.filter
            com.google.firebase.database.snapshot.Index r10 = r10.getIndex()
            com.google.firebase.database.snapshot.IndexedNode r10 = com.google.firebase.database.snapshot.IndexedNode.from(r11, r10)
            com.google.firebase.database.core.view.filter.NodeFilter r11 = r8.filter
            com.google.firebase.database.core.view.CacheNode r12 = r9.getEventCache()
            com.google.firebase.database.snapshot.IndexedNode r12 = r12.getIndexedNode()
            com.google.firebase.database.snapshot.IndexedNode r10 = r11.updateFullNode(r12, r10, r14)
            r11 = 1
        L28:
            com.google.firebase.database.core.view.filter.NodeFilter r12 = r8.filter
            boolean r12 = r12.filtersNodes()
        L2e:
            com.google.firebase.database.core.view.ViewCache r9 = r9.updateEventSnap(r10, r11, r12)
            goto Laa
        L34:
            com.google.firebase.database.snapshot.ChildKey r3 = r10.getFront()
            boolean r12 = r3.isPriorityChildName()
            if (r12 == 0) goto L55
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r8.filter
            com.google.firebase.database.core.view.CacheNode r12 = r9.getEventCache()
            com.google.firebase.database.snapshot.IndexedNode r12 = r12.getIndexedNode()
            com.google.firebase.database.snapshot.IndexedNode r10 = r10.updatePriority(r12, r11)
            boolean r11 = r0.isFullyInitialized()
            boolean r12 = r0.isFiltered()
            goto L2e
        L55:
            com.google.firebase.database.core.Path r5 = r10.popFront()
            com.google.firebase.database.snapshot.Node r10 = r0.getNode()
            com.google.firebase.database.snapshot.Node r10 = r10.getImmediateChild(r3)
            boolean r12 = r5.isEmpty()
            if (r12 == 0) goto L69
        L67:
            r4 = r11
            goto L93
        L69:
            com.google.firebase.database.snapshot.Node r12 = r6.getCompleteChild(r3)
            if (r12 == 0) goto L8e
            com.google.firebase.database.snapshot.ChildKey r13 = r5.getBack()
            boolean r13 = r13.isPriorityChildName()
            if (r13 == 0) goto L89
            com.google.firebase.database.core.Path r13 = r5.getParent()
            com.google.firebase.database.snapshot.Node r13 = r12.getChild(r13)
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L89
            r4 = r12
            goto L93
        L89:
            com.google.firebase.database.snapshot.Node r11 = r12.updateChild(r5, r11)
            goto L67
        L8e:
            com.google.firebase.database.snapshot.EmptyNode r11 = com.google.firebase.database.snapshot.EmptyNode.Empty()
            goto L67
        L93:
            boolean r10 = r10.equals(r4)
            if (r10 != 0) goto Laa
            com.google.firebase.database.core.view.filter.NodeFilter r1 = r8.filter
            com.google.firebase.database.snapshot.IndexedNode r2 = r0.getIndexedNode()
            r7 = r14
            com.google.firebase.database.snapshot.IndexedNode r10 = r1.updateChild(r2, r3, r4, r5, r6, r7)
            boolean r11 = r0.isFullyInitialized()
            goto L28
        Laa:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.view.ViewProcessor.applyUserOverwrite(com.google.firebase.database.core.view.ViewCache, com.google.firebase.database.core.Path, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.WriteTreeRef, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.view.filter.ChildChangeAccumulator):com.google.firebase.database.core.view.ViewCache");
    }

    private static boolean cacheHasChild(ViewCache viewCache, ChildKey childKey) {
        return viewCache.getEventCache().isCompleteForChild(childKey);
    }

    private ViewCache generateEventCacheAfterServerEvent(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        Node calcCompleteChild;
        IndexedNode updateChild;
        Node calcCompleteEventCache;
        CacheNode eventCache = viewCache.getEventCache();
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        if (path.isEmpty()) {
            if (viewCache.getServerCache().isFiltered()) {
                Node completeServerSnap = viewCache.getCompleteServerSnap();
                if (!(completeServerSnap instanceof ChildrenNode)) {
                    completeServerSnap = EmptyNode.Empty();
                }
                calcCompleteEventCache = writeTreeRef.calcCompleteEventChildren(completeServerSnap);
            } else {
                calcCompleteEventCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            updateChild = this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(calcCompleteEventCache, this.filter.getIndex()), childChangeAccumulator);
        } else {
            ChildKey front = path.getFront();
            if (front.isPriorityChildName()) {
                Node calcEventCacheAfterServerOverwrite = writeTreeRef.calcEventCacheAfterServerOverwrite(path, eventCache.getNode(), viewCache.getServerCache().getNode());
                if (calcEventCacheAfterServerOverwrite != null) {
                    updateChild = this.filter.updatePriority(eventCache.getIndexedNode(), calcEventCacheAfterServerOverwrite);
                }
                updateChild = eventCache.getIndexedNode();
            } else {
                Path popFront = path.popFront();
                if (eventCache.isCompleteForChild(front)) {
                    Node calcEventCacheAfterServerOverwrite2 = writeTreeRef.calcEventCacheAfterServerOverwrite(path, eventCache.getNode(), viewCache.getServerCache().getNode());
                    calcCompleteChild = calcEventCacheAfterServerOverwrite2 != null ? eventCache.getNode().getImmediateChild(front).updateChild(popFront, calcEventCacheAfterServerOverwrite2) : eventCache.getNode().getImmediateChild(front);
                } else {
                    calcCompleteChild = writeTreeRef.calcCompleteChild(front, viewCache.getServerCache());
                }
                Node node = calcCompleteChild;
                if (node != null) {
                    updateChild = this.filter.updateChild(eventCache.getIndexedNode(), front, node, popFront, completeChildSource, childChangeAccumulator);
                }
                updateChild = eventCache.getIndexedNode();
            }
        }
        return viewCache.updateEventSnap(updateChild, eventCache.isFullyInitialized() || path.isEmpty(), this.filter.filtersNodes());
    }

    private ViewCache listenComplete(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        CacheNode serverCache = viewCache.getServerCache();
        return generateEventCacheAfterServerEvent(viewCache.updateServerSnap(serverCache.getIndexedNode(), serverCache.isFullyInitialized() || path.isEmpty(), serverCache.isFiltered()), path, writeTreeRef, NO_COMPLETE_SOURCE, childChangeAccumulator);
    }

    private void maybeAddValueEvent(ViewCache viewCache, ViewCache viewCache2, List<Change> list) {
        CacheNode eventCache = viewCache2.getEventCache();
        if (eventCache.isFullyInitialized()) {
            boolean z = eventCache.getNode().isLeafNode() || eventCache.getNode().isEmpty();
            if (list.isEmpty() && viewCache.getEventCache().isFullyInitialized() && ((!z || eventCache.getNode().equals(viewCache.getCompleteEventSnap())) && eventCache.getNode().getPriority().equals(viewCache.getCompleteEventSnap().getPriority()))) {
                return;
            }
            list.add(Change.valueChange(eventCache.getIndexedNode()));
        }
    }

    public ProcessorResult applyOperation(ViewCache viewCache, Operation operation, WriteTreeRef writeTreeRef, Node node) {
        ViewCache applyServerOverwrite;
        ChildChangeAccumulator childChangeAccumulator = new ChildChangeAccumulator();
        int i = AnonymousClass2.a[operation.getType().ordinal()];
        if (i == 1) {
            Overwrite overwrite = (Overwrite) operation;
            if (overwrite.getSource().isFromUser()) {
                applyServerOverwrite = applyUserOverwrite(viewCache, overwrite.getPath(), overwrite.getSnapshot(), writeTreeRef, node, childChangeAccumulator);
            } else {
                applyServerOverwrite = applyServerOverwrite(viewCache, overwrite.getPath(), overwrite.getSnapshot(), writeTreeRef, node, overwrite.getSource().isTagged() || (viewCache.getServerCache().isFiltered() && !overwrite.getPath().isEmpty()), childChangeAccumulator);
            }
        } else if (i == 2) {
            Merge merge = (Merge) operation;
            if (merge.getSource().isFromUser()) {
                applyServerOverwrite = applyUserMerge(viewCache, merge.getPath(), merge.getChildren(), writeTreeRef, node, childChangeAccumulator);
            } else {
                applyServerOverwrite = applyServerMerge(viewCache, merge.getPath(), merge.getChildren(), writeTreeRef, node, merge.getSource().isTagged() || viewCache.getServerCache().isFiltered(), childChangeAccumulator);
            }
        } else if (i == 3) {
            AckUserWrite ackUserWrite = (AckUserWrite) operation;
            boolean isRevert = ackUserWrite.isRevert();
            Path path = ackUserWrite.getPath();
            applyServerOverwrite = !isRevert ? ackUserWrite(viewCache, path, ackUserWrite.getAffectedTree(), writeTreeRef, node, childChangeAccumulator) : revertUserWrite(viewCache, path, writeTreeRef, node, childChangeAccumulator);
        } else {
            if (i != 4) {
                throw new AssertionError("Unknown operation: " + operation.getType());
            }
            applyServerOverwrite = listenComplete(viewCache, operation.getPath(), writeTreeRef, node, childChangeAccumulator);
        }
        ArrayList arrayList = new ArrayList(childChangeAccumulator.getChanges());
        maybeAddValueEvent(viewCache, applyServerOverwrite, arrayList);
        return new ProcessorResult(applyServerOverwrite, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
    
        if (r10.isLeafNode() == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.firebase.database.core.view.ViewCache revertUserWrite(com.google.firebase.database.core.view.ViewCache r9, com.google.firebase.database.core.Path r10, com.google.firebase.database.core.WriteTreeRef r11, com.google.firebase.database.snapshot.Node r12, com.google.firebase.database.core.view.filter.ChildChangeAccumulator r13) {
        /*
            r8 = this;
            com.google.firebase.database.snapshot.Node r0 = r11.shadowingWrite(r10)
            if (r0 == 0) goto L7
            return r9
        L7:
            com.google.firebase.database.core.view.ViewProcessor$WriteTreeCompleteChildSource r6 = new com.google.firebase.database.core.view.ViewProcessor$WriteTreeCompleteChildSource
            r6.<init>(r11, r9, r12)
            com.google.firebase.database.core.view.CacheNode r12 = r9.getEventCache()
            com.google.firebase.database.snapshot.IndexedNode r2 = r12.getIndexedNode()
            boolean r12 = r10.isEmpty()
            if (r12 != 0) goto L8e
            com.google.firebase.database.snapshot.ChildKey r12 = r10.getFront()
            boolean r12 = r12.isPriorityChildName()
            if (r12 == 0) goto L25
            goto L8e
        L25:
            com.google.firebase.database.snapshot.ChildKey r3 = r10.getFront()
            com.google.firebase.database.core.view.CacheNode r12 = r9.getServerCache()
            com.google.firebase.database.snapshot.Node r12 = r11.calcCompleteChild(r3, r12)
            if (r12 != 0) goto L45
            com.google.firebase.database.core.view.CacheNode r0 = r9.getServerCache()
            boolean r0 = r0.isCompleteForChild(r3)
            if (r0 == 0) goto L45
            com.google.firebase.database.snapshot.Node r12 = r2.getNode()
            com.google.firebase.database.snapshot.Node r12 = r12.getImmediateChild(r3)
        L45:
            r4 = r12
            if (r4 == 0) goto L54
            com.google.firebase.database.core.view.filter.NodeFilter r1 = r8.filter
        L4a:
            com.google.firebase.database.core.Path r5 = r10.popFront()
            r7 = r13
            com.google.firebase.database.snapshot.IndexedNode r2 = r1.updateChild(r2, r3, r4, r5, r6, r7)
            goto L6b
        L54:
            if (r4 != 0) goto L6b
            com.google.firebase.database.core.view.CacheNode r12 = r9.getEventCache()
            com.google.firebase.database.snapshot.Node r12 = r12.getNode()
            boolean r12 = r12.hasChild(r3)
            if (r12 == 0) goto L6b
            com.google.firebase.database.core.view.filter.NodeFilter r1 = r8.filter
            com.google.firebase.database.snapshot.EmptyNode r4 = com.google.firebase.database.snapshot.EmptyNode.Empty()
            goto L4a
        L6b:
            com.google.firebase.database.snapshot.Node r10 = r2.getNode()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto Lbd
            com.google.firebase.database.core.view.CacheNode r10 = r9.getServerCache()
            boolean r10 = r10.isFullyInitialized()
            if (r10 == 0) goto Lbd
            com.google.firebase.database.snapshot.Node r10 = r9.getCompleteServerSnap()
            com.google.firebase.database.snapshot.Node r10 = r11.calcCompleteEventCache(r10)
            boolean r12 = r10.isLeafNode()
            if (r12 == 0) goto Lbd
            goto Lad
        L8e:
            com.google.firebase.database.core.view.CacheNode r10 = r9.getServerCache()
            boolean r10 = r10.isFullyInitialized()
            if (r10 == 0) goto La1
            com.google.firebase.database.snapshot.Node r10 = r9.getCompleteServerSnap()
            com.google.firebase.database.snapshot.Node r10 = r11.calcCompleteEventCache(r10)
            goto Lad
        La1:
            com.google.firebase.database.core.view.CacheNode r10 = r9.getServerCache()
            com.google.firebase.database.snapshot.Node r10 = r10.getNode()
            com.google.firebase.database.snapshot.Node r10 = r11.calcCompleteEventChildren(r10)
        Lad:
            com.google.firebase.database.core.view.filter.NodeFilter r12 = r8.filter
            com.google.firebase.database.snapshot.Index r12 = r12.getIndex()
            com.google.firebase.database.snapshot.IndexedNode r10 = com.google.firebase.database.snapshot.IndexedNode.from(r10, r12)
            com.google.firebase.database.core.view.filter.NodeFilter r12 = r8.filter
            com.google.firebase.database.snapshot.IndexedNode r2 = r12.updateFullNode(r2, r10, r13)
        Lbd:
            com.google.firebase.database.core.view.CacheNode r10 = r9.getServerCache()
            boolean r10 = r10.isFullyInitialized()
            if (r10 != 0) goto Ld4
            com.google.firebase.database.core.Path r10 = com.google.firebase.database.core.Path.getEmptyPath()
            com.google.firebase.database.snapshot.Node r10 = r11.shadowingWrite(r10)
            if (r10 == 0) goto Ld2
            goto Ld4
        Ld2:
            r10 = 0
            goto Ld5
        Ld4:
            r10 = 1
        Ld5:
            com.google.firebase.database.core.view.filter.NodeFilter r11 = r8.filter
            boolean r11 = r11.filtersNodes()
            com.google.firebase.database.core.view.ViewCache r9 = r9.updateEventSnap(r2, r10, r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.view.ViewProcessor.revertUserWrite(com.google.firebase.database.core.view.ViewCache, com.google.firebase.database.core.Path, com.google.firebase.database.core.WriteTreeRef, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.view.filter.ChildChangeAccumulator):com.google.firebase.database.core.view.ViewCache");
    }
}
