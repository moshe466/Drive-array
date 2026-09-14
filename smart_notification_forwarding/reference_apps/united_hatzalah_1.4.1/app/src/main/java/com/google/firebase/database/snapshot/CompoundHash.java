package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* loaded from: classes.dex */
public class CompoundHash {
    private final List<String> hashes;
    private final List<Path> posts;

    /* loaded from: classes.dex */
    public static class CompoundHashBuilder {
        private int currentPathDepth;
        private final SplitStrategy splitStrategy;
        private StringBuilder optHashValueBuilder = null;
        private Stack<ChildKey> currentPath = new Stack<>();
        private int lastLeafDepth = -1;
        private boolean needsComma = true;
        private final List<Path> currentPaths = new ArrayList();
        private final List<String> currentHashes = new ArrayList();

        public CompoundHashBuilder(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
        }

        private void appendKey(StringBuilder sb, ChildKey childKey) {
            sb.append(Utilities.stringHashV2Representation(childKey.asString()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endChild() {
            this.currentPathDepth--;
            if (buildingRange()) {
                this.optHashValueBuilder.append(")");
            }
            this.needsComma = true;
        }

        private void endRange() {
            Utilities.hardAssert(buildingRange(), "Can't end range without starting a range!");
            for (int i = 0; i < this.currentPathDepth; i++) {
                this.optHashValueBuilder.append(")");
            }
            this.optHashValueBuilder.append(")");
            Path currentPath = currentPath(this.lastLeafDepth);
            this.currentHashes.add(Utilities.sha1HexDigest(this.optHashValueBuilder.toString()));
            this.currentPaths.add(currentPath);
            this.optHashValueBuilder = null;
        }

        private void ensureRange() {
            if (!buildingRange()) {
                StringBuilder sb = new StringBuilder();
                this.optHashValueBuilder = sb;
                sb.append("(");
                Iterator<ChildKey> it = currentPath(this.currentPathDepth).iterator();
                while (it.hasNext()) {
                    appendKey(this.optHashValueBuilder, it.next());
                    this.optHashValueBuilder.append(":(");
                }
                this.needsComma = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void finishHashing() {
            boolean z3;
            if (this.currentPathDepth == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Utilities.hardAssert(z3, "Can't finish hashing in the middle processing a child");
            if (buildingRange()) {
                endRange();
            }
            this.currentHashes.add("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processLeaf(LeafNode<?> leafNode) {
            ensureRange();
            this.lastLeafDepth = this.currentPathDepth;
            this.optHashValueBuilder.append(leafNode.getHashRepresentation(Node.HashVersion.V2));
            this.needsComma = true;
            if (this.splitStrategy.shouldSplit(this)) {
                endRange();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startChild(ChildKey childKey) {
            ensureRange();
            if (this.needsComma) {
                this.optHashValueBuilder.append(",");
            }
            appendKey(this.optHashValueBuilder, childKey);
            this.optHashValueBuilder.append(":(");
            if (this.currentPathDepth == this.currentPath.size()) {
                this.currentPath.add(childKey);
            } else {
                this.currentPath.set(this.currentPathDepth, childKey);
            }
            this.currentPathDepth++;
            this.needsComma = false;
        }

        public boolean buildingRange() {
            if (this.optHashValueBuilder != null) {
                return true;
            }
            return false;
        }

        public int currentHashLength() {
            return this.optHashValueBuilder.length();
        }

        public Path currentPath() {
            return currentPath(this.currentPathDepth);
        }

        private Path currentPath(int i) {
            ChildKey[] childKeyArr = new ChildKey[i];
            for (int i3 = 0; i3 < i; i3++) {
                childKeyArr[i3] = this.currentPath.get(i3);
            }
            return new Path(childKeyArr);
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleSizeSplitStrategy implements SplitStrategy {
        private final long splitThreshold;

        public SimpleSizeSplitStrategy(Node node) {
            this.splitThreshold = Math.max(512L, (long) Math.sqrt(NodeSizeEstimator.estimateSerializedNodeSize(node) * 100));
        }

        @Override // com.google.firebase.database.snapshot.CompoundHash.SplitStrategy
        public boolean shouldSplit(CompoundHashBuilder compoundHashBuilder) {
            if (compoundHashBuilder.currentHashLength() > this.splitThreshold) {
                if (compoundHashBuilder.currentPath().isEmpty() || !compoundHashBuilder.currentPath().getBack().equals(ChildKey.getPriorityKey())) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface SplitStrategy {
        boolean shouldSplit(CompoundHashBuilder compoundHashBuilder);
    }

    private CompoundHash(List<Path> list, List<String> list2) {
        if (list.size() == list2.size() - 1) {
            this.posts = list;
            this.hashes = list2;
            return;
        }
        throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
    }

    public static CompoundHash fromNode(Node node) {
        return fromNode(node, new SimpleSizeSplitStrategy(node));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processNode(Node node, final CompoundHashBuilder compoundHashBuilder) {
        if (node.isLeafNode()) {
            compoundHashBuilder.processLeaf((LeafNode) node);
            return;
        }
        if (!node.isEmpty()) {
            if (node instanceof ChildrenNode) {
                ((ChildrenNode) node).forEachChild(new ChildrenNode.ChildVisitor() { // from class: com.google.firebase.database.snapshot.CompoundHash.1
                    @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
                    public void visitChild(ChildKey childKey, Node node2) {
                        CompoundHashBuilder.this.startChild(childKey);
                        CompoundHash.processNode(node2, CompoundHashBuilder.this);
                        CompoundHashBuilder.this.endChild();
                    }
                }, true);
                return;
            } else {
                throw new IllegalStateException("Expected children node, but got: " + node);
            }
        }
        throw new IllegalArgumentException("Can't calculate hash on empty node!");
    }

    public List<String> getHashes() {
        return Collections.unmodifiableList(this.hashes);
    }

    public List<Path> getPosts() {
        return Collections.unmodifiableList(this.posts);
    }

    public static CompoundHash fromNode(Node node, SplitStrategy splitStrategy) {
        if (node.isEmpty()) {
            return new CompoundHash(Collections.EMPTY_LIST, Collections.singletonList(""));
        }
        CompoundHashBuilder compoundHashBuilder = new CompoundHashBuilder(splitStrategy);
        processNode(node, compoundHashBuilder);
        compoundHashBuilder.finishHashing();
        return new CompoundHash(compoundHashBuilder.currentPaths, compoundHashBuilder.currentHashes);
    }
}
