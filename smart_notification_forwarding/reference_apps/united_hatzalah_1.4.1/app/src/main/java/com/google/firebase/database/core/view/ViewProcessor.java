package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Utilities;
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

/* loaded from: classes.dex */
public class ViewProcessor {
    private static NodeFilter.CompleteChildSource NO_COMPLETE_SOURCE = new NodeFilter.CompleteChildSource() { // from class: com.google.firebase.database.core.view.ViewProcessor.1
        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode, boolean z3) {
            return null;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            return null;
        }
    };
    private final NodeFilter filter;

    /* renamed from: com.google.firebase.database.core.view.ViewProcessor$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType;

        static {
            int[] iArr = new int[Operation.OperationType.values().length];
            $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType = iArr;
            try {
                iArr[Operation.OperationType.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ProcessorResult {
        public final List<Change> changes;
        public final ViewCache viewCache;

        public ProcessorResult(ViewCache viewCache, List<Change> list) {
            this.viewCache = viewCache;
            this.changes = list;
        }
    }

    /* loaded from: classes.dex */
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
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode, boolean z3) {
            Node node = this.optCompleteServerCache;
            if (node == null) {
                node = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(node, namedNode, z3, index);
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            CacheNode serverCache;
            CacheNode eventCache = this.viewCache.getEventCache();
            if (eventCache.isCompleteForChild(childKey)) {
                return eventCache.getNode().getImmediateChild(childKey);
            }
            Node node = this.optCompleteServerCache;
            if (node != null) {
                serverCache = new CacheNode(IndexedNode.from(node, KeyIndex.getInstance()), true, false);
            } else {
                serverCache = this.viewCache.getServerCache();
            }
            return this.writes.calcCompleteChild(childKey, serverCache);
        }
    }

    public ViewProcessor(NodeFilter nodeFilter) {
        this.filter = nodeFilter;
    }

    private ViewCache ackUserWrite(ViewCache viewCache, Path path, ImmutableTree<Boolean> immutableTree, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        Path key;
        Path child;
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        boolean isFiltered = viewCache.getServerCache().isFiltered();
        CacheNode serverCache = viewCache.getServerCache();
        if (immutableTree.getValue() != null) {
            if ((path.isEmpty() && serverCache.isFullyInitialized()) || serverCache.isCompleteForPath(path)) {
                return applyServerOverwrite(viewCache, path, serverCache.getNode().getChild(path), writeTreeRef, node, isFiltered, childChangeAccumulator);
            }
            if (!path.isEmpty()) {
                return viewCache;
            }
            CompoundWrite emptyWrite = CompoundWrite.emptyWrite();
            CompoundWrite compoundWrite = emptyWrite;
            for (NamedNode namedNode : serverCache.getNode()) {
                compoundWrite = compoundWrite.addWrite(namedNode.getName(), namedNode.getNode());
            }
            return applyServerMerge(viewCache, path, compoundWrite, writeTreeRef, node, isFiltered, childChangeAccumulator);
        }
        CompoundWrite emptyWrite2 = CompoundWrite.emptyWrite();
        Iterator<Map.Entry<Path, Boolean>> it = immutableTree.iterator();
        while (true) {
            CompoundWrite compoundWrite2 = emptyWrite2;
            while (it.hasNext()) {
                key = it.next().getKey();
                child = path.child(key);
                if (serverCache.isCompleteForPath(child)) {
                    break;
                }
            }
            return applyServerMerge(viewCache, path, compoundWrite2, writeTreeRef, node, isFiltered, childChangeAccumulator);
            emptyWrite2 = compoundWrite2.addWrite(key, serverCache.getNode().getChild(child));
        }
    }

    private ViewCache applyServerMerge(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, boolean z3, ChildChangeAccumulator childChangeAccumulator) {
        boolean z4;
        CompoundWrite addWrites;
        boolean z5;
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            return viewCache;
        }
        if (compoundWrite.rootWrite() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Utilities.hardAssert(z4, "Can't have a merge that is an overwrite");
        if (path.isEmpty()) {
            addWrites = compoundWrite;
        } else {
            addWrites = CompoundWrite.emptyWrite().addWrites(path, compoundWrite);
        }
        Node node2 = viewCache.getServerCache().getNode();
        Map<ChildKey, CompoundWrite> childCompoundWrites = addWrites.childCompoundWrites();
        ViewCache viewCache2 = viewCache;
        for (Map.Entry<ChildKey, CompoundWrite> entry : childCompoundWrites.entrySet()) {
            ChildKey key = entry.getKey();
            if (node2.hasChild(key)) {
                viewCache2 = applyServerOverwrite(viewCache2, new Path(key), entry.getValue().apply(node2.getImmediateChild(key)), writeTreeRef, node, z3, childChangeAccumulator);
            }
        }
        ViewCache viewCache3 = viewCache2;
        for (Map.Entry<ChildKey, CompoundWrite> entry2 : childCompoundWrites.entrySet()) {
            ChildKey key2 = entry2.getKey();
            CompoundWrite value = entry2.getValue();
            if (!viewCache.getServerCache().isCompleteForChild(key2) && value.rootWrite() == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!node2.hasChild(key2) && !z5) {
                viewCache3 = applyServerOverwrite(viewCache3, new Path(key2), entry2.getValue().apply(node2.getImmediateChild(key2)), writeTreeRef, node, z3, childChangeAccumulator);
            }
        }
        return viewCache3;
    }

    private ViewCache applyServerOverwrite(ViewCache viewCache, Path path, Node node, WriteTreeRef writeTreeRef, Node node2, boolean z3, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode updateChild;
        CacheNode serverCache = viewCache.getServerCache();
        NodeFilter nodeFilter = this.filter;
        if (!z3) {
            nodeFilter = nodeFilter.getIndexedFilter();
        }
        NodeFilter nodeFilter2 = nodeFilter;
        boolean z4 = true;
        if (path.isEmpty()) {
            updateChild = nodeFilter2.updateFullNode(serverCache.getIndexedNode(), IndexedNode.from(node, nodeFilter2.getIndex()), null);
        } else if (nodeFilter2.filtersNodes() && !serverCache.isFiltered()) {
            Utilities.hardAssert(!path.isEmpty(), "An empty path should have been caught in the other branch");
            ChildKey front = path.getFront();
            updateChild = nodeFilter2.updateFullNode(serverCache.getIndexedNode(), serverCache.getIndexedNode().updateChild(front, serverCache.getNode().getImmediateChild(front).updateChild(path.popFront(), node)), null);
        } else {
            ChildKey front2 = path.getFront();
            if (!serverCache.isCompleteForPath(path) && path.size() > 1) {
                return viewCache;
            }
            Path popFront = path.popFront();
            Node updateChild2 = serverCache.getNode().getImmediateChild(front2).updateChild(popFront, node);
            if (front2.isPriorityChildName()) {
                updateChild = nodeFilter2.updatePriority(serverCache.getIndexedNode(), updateChild2);
            } else {
                updateChild = nodeFilter2.updateChild(serverCache.getIndexedNode(), front2, updateChild2, popFront, NO_COMPLETE_SOURCE, null);
            }
        }
        if (!serverCache.isFullyInitialized() && !path.isEmpty()) {
            z4 = false;
        }
        ViewCache updateServerSnap = viewCache.updateServerSnap(updateChild, z4, nodeFilter2.filtersNodes());
        return generateEventCacheAfterServerEvent(updateServerSnap, path, writeTreeRef, new WriteTreeCompleteChildSource(writeTreeRef, updateServerSnap, node2), childChangeAccumulator);
    }

    private ViewCache applyUserMerge(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        boolean z3;
        if (compoundWrite.rootWrite() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Utilities.hardAssert(z3, "Can't have a merge that is an overwrite");
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
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
            if (r12 == 0) goto L33
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r8.filter
            com.google.firebase.database.snapshot.Index r10 = r10.getIndex()
            com.google.firebase.database.snapshot.IndexedNode r10 = com.google.firebase.database.snapshot.IndexedNode.from(r11, r10)
            com.google.firebase.database.core.view.filter.NodeFilter r11 = r8.filter
            com.google.firebase.database.core.view.CacheNode r12 = r9.getEventCache()
            com.google.firebase.database.snapshot.IndexedNode r12 = r12.getIndexedNode()
            com.google.firebase.database.snapshot.IndexedNode r10 = r11.updateFullNode(r12, r10, r14)
            com.google.firebase.database.core.view.filter.NodeFilter r11 = r8.filter
            boolean r11 = r11.filtersNodes()
            r12 = 1
            com.google.firebase.database.core.view.ViewCache r9 = r9.updateEventSnap(r10, r12, r11)
            return r9
        L33:
            com.google.firebase.database.snapshot.ChildKey r3 = r10.getFront()
            boolean r12 = r3.isPriorityChildName()
            if (r12 == 0) goto L58
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r8.filter
            com.google.firebase.database.core.view.CacheNode r12 = r9.getEventCache()
            com.google.firebase.database.snapshot.IndexedNode r12 = r12.getIndexedNode()
            com.google.firebase.database.snapshot.IndexedNode r10 = r10.updatePriority(r12, r11)
            boolean r11 = r0.isFullyInitialized()
            boolean r12 = r0.isFiltered()
            com.google.firebase.database.core.view.ViewCache r9 = r9.updateEventSnap(r10, r11, r12)
            return r9
        L58:
            com.google.firebase.database.core.Path r5 = r10.popFront()
            com.google.firebase.database.snapshot.Node r10 = r0.getNode()
            com.google.firebase.database.snapshot.Node r10 = r10.getImmediateChild(r3)
            boolean r12 = r5.isEmpty()
            if (r12 == 0) goto L6c
        L6a:
            r4 = r11
            goto L96
        L6c:
            com.google.firebase.database.snapshot.Node r12 = r6.getCompleteChild(r3)
            if (r12 == 0) goto L91
            com.google.firebase.database.snapshot.ChildKey r13 = r5.getBack()
            boolean r13 = r13.isPriorityChildName()
            if (r13 == 0) goto L8c
            com.google.firebase.database.core.Path r13 = r5.getParent()
            com.google.firebase.database.snapshot.Node r13 = r12.getChild(r13)
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L8c
            r4 = r12
            goto L96
        L8c:
            com.google.firebase.database.snapshot.Node r11 = r12.updateChild(r5, r11)
            goto L6a
        L91:
            com.google.firebase.database.snapshot.EmptyNode r11 = com.google.firebase.database.snapshot.EmptyNode.Empty()
            goto L6a
        L96:
            boolean r10 = r10.equals(r4)
            if (r10 != 0) goto Lb5
            com.google.firebase.database.core.view.filter.NodeFilter r1 = r8.filter
            com.google.firebase.database.snapshot.IndexedNode r2 = r0.getIndexedNode()
            r7 = r14
            com.google.firebase.database.snapshot.IndexedNode r10 = r1.updateChild(r2, r3, r4, r5, r6, r7)
            boolean r11 = r0.isFullyInitialized()
            com.google.firebase.database.core.view.filter.NodeFilter r12 = r8.filter
            boolean r12 = r12.filtersNodes()
            com.google.firebase.database.core.view.ViewCache r9 = r9.updateEventSnap(r10, r11, r12)
        Lb5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.view.ViewProcessor.applyUserOverwrite(com.google.firebase.database.core.view.ViewCache, com.google.firebase.database.core.Path, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.WriteTreeRef, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.view.filter.ChildChangeAccumulator):com.google.firebase.database.core.view.ViewCache");
    }

    private static boolean cacheHasChild(ViewCache viewCache, ChildKey childKey) {
        return viewCache.getEventCache().isCompleteForChild(childKey);
    }

    private ViewCache generateEventCacheAfterServerEvent(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        Node calcCompleteChild;
        IndexedNode indexedNode;
        boolean z3;
        Node calcCompleteEventCache;
        CacheNode eventCache = viewCache.getEventCache();
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        boolean z4 = false;
        if (path.isEmpty()) {
            Utilities.hardAssert(viewCache.getServerCache().isFullyInitialized(), "If change path is empty, we must have complete server data");
            if (viewCache.getServerCache().isFiltered()) {
                Node completeServerSnap = viewCache.getCompleteServerSnap();
                if (!(completeServerSnap instanceof ChildrenNode)) {
                    completeServerSnap = EmptyNode.Empty();
                }
                calcCompleteEventCache = writeTreeRef.calcCompleteEventChildren(completeServerSnap);
            } else {
                calcCompleteEventCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            indexedNode = this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(calcCompleteEventCache, this.filter.getIndex()), childChangeAccumulator);
        } else {
            ChildKey front = path.getFront();
            if (front.isPriorityChildName()) {
                if (path.size() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Utilities.hardAssert(z3, "Can't have a priority with additional path components");
                Node calcEventCacheAfterServerOverwrite = writeTreeRef.calcEventCacheAfterServerOverwrite(path, eventCache.getNode(), viewCache.getServerCache().getNode());
                if (calcEventCacheAfterServerOverwrite != null) {
                    indexedNode = this.filter.updatePriority(eventCache.getIndexedNode(), calcEventCacheAfterServerOverwrite);
                } else {
                    indexedNode = eventCache.getIndexedNode();
                }
            } else {
                Path popFront = path.popFront();
                if (eventCache.isCompleteForChild(front)) {
                    Node calcEventCacheAfterServerOverwrite2 = writeTreeRef.calcEventCacheAfterServerOverwrite(path, eventCache.getNode(), viewCache.getServerCache().getNode());
                    if (calcEventCacheAfterServerOverwrite2 != null) {
                        calcCompleteChild = eventCache.getNode().getImmediateChild(front).updateChild(popFront, calcEventCacheAfterServerOverwrite2);
                    } else {
                        calcCompleteChild = eventCache.getNode().getImmediateChild(front);
                    }
                } else {
                    calcCompleteChild = writeTreeRef.calcCompleteChild(front, viewCache.getServerCache());
                }
                Node node = calcCompleteChild;
                if (node != null) {
                    indexedNode = this.filter.updateChild(eventCache.getIndexedNode(), front, node, popFront, completeChildSource, childChangeAccumulator);
                } else {
                    indexedNode = eventCache.getIndexedNode();
                }
            }
        }
        if (eventCache.isFullyInitialized() || path.isEmpty()) {
            z4 = true;
        }
        return viewCache.updateEventSnap(indexedNode, z4, this.filter.filtersNodes());
    }

    private ViewCache listenComplete(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        boolean z3;
        CacheNode serverCache = viewCache.getServerCache();
        IndexedNode indexedNode = serverCache.getIndexedNode();
        if (!serverCache.isFullyInitialized() && !path.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        return generateEventCacheAfterServerEvent(viewCache.updateServerSnap(indexedNode, z3, serverCache.isFiltered()), path, writeTreeRef, NO_COMPLETE_SOURCE, childChangeAccumulator);
    }

    private void maybeAddValueEvent(ViewCache viewCache, ViewCache viewCache2, List<Change> list) {
        boolean z3;
        CacheNode eventCache = viewCache2.getEventCache();
        if (eventCache.isFullyInitialized()) {
            if (!eventCache.getNode().isLeafNode() && !eventCache.getNode().isEmpty()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!list.isEmpty() || !viewCache.getEventCache().isFullyInitialized() || ((z3 && !eventCache.getNode().equals(viewCache.getCompleteEventSnap())) || !eventCache.getNode().getPriority().equals(viewCache.getCompleteEventSnap().getPriority()))) {
                list.add(Change.valueChange(eventCache.getIndexedNode()));
            }
        }
    }

    public ProcessorResult applyOperation(ViewCache viewCache, Operation operation, WriteTreeRef writeTreeRef, Node node) {
        ChildChangeAccumulator childChangeAccumulator;
        ViewCache viewCache2;
        ViewCache applyServerOverwrite;
        ChildChangeAccumulator childChangeAccumulator2 = new ChildChangeAccumulator();
        int i = AnonymousClass2.$SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[operation.getType().ordinal()];
        boolean z3 = false;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        viewCache2 = viewCache;
                        applyServerOverwrite = listenComplete(viewCache2, operation.getPath(), writeTreeRef, node, childChangeAccumulator2);
                    } else {
                        throw new AssertionError("Unknown operation: " + operation.getType());
                    }
                } else {
                    viewCache2 = viewCache;
                    AckUserWrite ackUserWrite = (AckUserWrite) operation;
                    if (!ackUserWrite.isRevert()) {
                        applyServerOverwrite = ackUserWrite(viewCache2, ackUserWrite.getPath(), ackUserWrite.getAffectedTree(), writeTreeRef, node, childChangeAccumulator2);
                    } else {
                        applyServerOverwrite = revertUserWrite(viewCache2, ackUserWrite.getPath(), writeTreeRef, node, childChangeAccumulator2);
                    }
                }
            } else {
                Merge merge = (Merge) operation;
                if (merge.getSource().isFromUser()) {
                    viewCache2 = viewCache;
                    applyServerOverwrite = applyUserMerge(viewCache2, merge.getPath(), merge.getChildren(), writeTreeRef, node, childChangeAccumulator2);
                } else {
                    Utilities.hardAssert(merge.getSource().isFromServer());
                    if (merge.getSource().isTagged() || viewCache.getServerCache().isFiltered()) {
                        z3 = true;
                    }
                    childChangeAccumulator = childChangeAccumulator2;
                    boolean z4 = z3;
                    viewCache2 = viewCache;
                    applyServerOverwrite = applyServerMerge(viewCache2, merge.getPath(), merge.getChildren(), writeTreeRef, node, z4, childChangeAccumulator);
                    childChangeAccumulator2 = childChangeAccumulator;
                }
            }
        } else {
            Overwrite overwrite = (Overwrite) operation;
            if (overwrite.getSource().isFromUser()) {
                viewCache2 = viewCache;
                applyServerOverwrite = applyUserOverwrite(viewCache2, overwrite.getPath(), overwrite.getSnapshot(), writeTreeRef, node, childChangeAccumulator2);
            } else {
                Utilities.hardAssert(overwrite.getSource().isFromServer());
                if (overwrite.getSource().isTagged() || (viewCache.getServerCache().isFiltered() && !overwrite.getPath().isEmpty())) {
                    z3 = true;
                }
                childChangeAccumulator = childChangeAccumulator2;
                boolean z5 = z3;
                viewCache2 = viewCache;
                applyServerOverwrite = applyServerOverwrite(viewCache2, overwrite.getPath(), overwrite.getSnapshot(), writeTreeRef, node, z5, childChangeAccumulator);
                childChangeAccumulator2 = childChangeAccumulator;
            }
        }
        ArrayList arrayList = new ArrayList(childChangeAccumulator2.getChanges());
        maybeAddValueEvent(viewCache2, applyServerOverwrite, arrayList);
        return new ProcessorResult(applyServerOverwrite, arrayList);
    }

    public ViewCache revertUserWrite(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        Node calcCompleteEventChildren;
        boolean z3;
        ChildChangeAccumulator childChangeAccumulator2;
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        WriteTreeCompleteChildSource writeTreeCompleteChildSource = new WriteTreeCompleteChildSource(writeTreeRef, viewCache, node);
        IndexedNode indexedNode = viewCache.getEventCache().getIndexedNode();
        if (!path.isEmpty() && !path.getFront().isPriorityChildName()) {
            ChildKey front = path.getFront();
            Node calcCompleteChild = writeTreeRef.calcCompleteChild(front, viewCache.getServerCache());
            if (calcCompleteChild == null && viewCache.getServerCache().isCompleteForChild(front)) {
                calcCompleteChild = indexedNode.getNode().getImmediateChild(front);
            }
            Node node2 = calcCompleteChild;
            if (node2 != null) {
                childChangeAccumulator2 = childChangeAccumulator;
                indexedNode = this.filter.updateChild(indexedNode, front, node2, path.popFront(), writeTreeCompleteChildSource, childChangeAccumulator2);
            } else {
                childChangeAccumulator2 = childChangeAccumulator;
                if (node2 == null && viewCache.getEventCache().getNode().hasChild(front)) {
                    indexedNode = this.filter.updateChild(indexedNode, front, EmptyNode.Empty(), path.popFront(), writeTreeCompleteChildSource, childChangeAccumulator2);
                }
            }
            if (indexedNode.getNode().isEmpty() && viewCache.getServerCache().isFullyInitialized()) {
                Node calcCompleteEventCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                if (calcCompleteEventCache.isLeafNode()) {
                    indexedNode = this.filter.updateFullNode(indexedNode, IndexedNode.from(calcCompleteEventCache, this.filter.getIndex()), childChangeAccumulator2);
                }
            }
        } else {
            if (viewCache.getServerCache().isFullyInitialized()) {
                calcCompleteEventChildren = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            } else {
                calcCompleteEventChildren = writeTreeRef.calcCompleteEventChildren(viewCache.getServerCache().getNode());
            }
            indexedNode = this.filter.updateFullNode(indexedNode, IndexedNode.from(calcCompleteEventChildren, this.filter.getIndex()), childChangeAccumulator);
        }
        if (!viewCache.getServerCache().isFullyInitialized() && writeTreeRef.shadowingWrite(Path.getEmptyPath()) == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        return viewCache.updateEventSnap(indexedNode, z3, this.filter.filtersNodes());
    }
}
