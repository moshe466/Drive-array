package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class LeafNode<T extends LeafNode> implements Node {
    protected final Node a;
    private String lazyHash;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.snapshot.LeafNode$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Node.HashVersion.values().length];

        static {
            try {
                a[Node.HashVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Node.HashVersion.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum LeafType {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeafNode(Node node) {
        this.a = node;
    }

    private static int compareLongDoubleNodes(LongNode longNode, DoubleNode doubleNode) {
        return Double.valueOf(((Long) longNode.getValue()).longValue()).compareTo((Double) doubleNode.getValue());
    }

    protected abstract int a(T t);

    protected abstract LeafType a();

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(Node.HashVersion hashVersion) {
        int i = AnonymousClass1.a[hashVersion.ordinal()];
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Unknown hash version: " + hashVersion);
        }
        if (this.a.isEmpty()) {
            return "";
        }
        return "priority:" + this.a.getHashRepresentation(hashVersion) + ":";
    }

    protected int b(LeafNode<?> leafNode) {
        LeafType a = a();
        LeafType a2 = leafNode.a();
        return a.equals(a2) ? a((LeafNode<T>) leafNode) : a.compareTo(a2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Node node) {
        if (node.isEmpty()) {
            return 1;
        }
        if (node instanceof ChildrenNode) {
            return -1;
        }
        return ((this instanceof LongNode) && (node instanceof DoubleNode)) ? compareLongDoubleNodes((LongNode) this, (DoubleNode) node) : ((this instanceof DoubleNode) && (node instanceof LongNode)) ? compareLongDoubleNodes((LongNode) node, (DoubleNode) this) * (-1) : b((LeafNode) node);
    }

    public abstract boolean equals(Object obj);

    @Override // com.google.firebase.database.snapshot.Node
    public Node getChild(Path path) {
        return path.isEmpty() ? this : path.getFront().isPriorityChildName() ? this.a : EmptyNode.Empty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        if (this.lazyHash == null) {
            this.lazyHash = Utilities.sha1HexDigest(getHashRepresentation(Node.HashVersion.V1));
        }
        return this.lazyHash;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getImmediateChild(ChildKey childKey) {
        return childKey.isPriorityChildName() ? this.a : EmptyNode.Empty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getPredecessorChildKey(ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this.a;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey getSuccessorChildKey(ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue(boolean z) {
        if (!z || this.a.isEmpty()) {
            return getValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.a.getValue());
        return hashMap;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean hasChild(ChildKey childKey) {
        return false;
    }

    public abstract int hashCode();

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isLeafNode() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Iterator<NamedNode> reverseIterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = getValue(true).toString();
        if (obj.length() <= 100) {
            return obj;
        }
        return obj.substring(0, 100) + "...";
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateChild(Path path, Node node) {
        ChildKey front = path.getFront();
        return front == null ? node : (!node.isEmpty() || front.isPriorityChildName()) ? updateImmediateChild(front, EmptyNode.Empty().updateChild(path.popFront(), node)) : this;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node updateImmediateChild(ChildKey childKey, Node node) {
        return childKey.isPriorityChildName() ? updatePriority(node) : node.isEmpty() ? this : EmptyNode.Empty().updateImmediateChild(childKey, node).updatePriority(this.a);
    }
}
