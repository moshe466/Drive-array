package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedHashTreeMap.1
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> a;
    Node<K, V>[] b;
    final Node<K, V> c;
    int d;
    int e;
    private LinkedHashTreeMap<K, V>.EntrySet entrySet;
    int f;
    private LinkedHashTreeMap<K, V>.KeySet keySet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        AvlBuilder() {
        }

        Node<K, V> a() {
            Node<K, V> node = this.stack;
            if (node.a == null) {
                return node;
            }
            throw new IllegalStateException();
        }

        void a(int i) {
            this.leavesToSkip = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        void a(Node<K, V> node) {
            node.c = null;
            node.a = null;
            node.b = null;
            node.i = 1;
            int i = this.leavesToSkip;
            if (i > 0) {
                int i2 = this.size;
                if ((i2 & 1) == 0) {
                    this.size = i2 + 1;
                    this.leavesToSkip = i - 1;
                    this.leavesSkipped++;
                }
            }
            node.a = this.stack;
            this.stack = node;
            this.size++;
            int i3 = this.leavesToSkip;
            if (i3 > 0) {
                int i4 = this.size;
                if ((i4 & 1) == 0) {
                    this.size = i4 + 1;
                    this.leavesToSkip = i3 - 1;
                    this.leavesSkipped++;
                }
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.size & i6) != i6) {
                    return;
                }
                int i7 = this.leavesSkipped;
                if (i7 == 0) {
                    Node<K, V> node2 = this.stack;
                    Node<K, V> node3 = node2.a;
                    Node<K, V> node4 = node3.a;
                    node3.a = node4.a;
                    this.stack = node3;
                    node3.b = node4;
                    node3.c = node2;
                    node3.i = node2.i + 1;
                    node4.a = node3;
                    node2.a = node3;
                } else {
                    if (i7 == 1) {
                        Node<K, V> node5 = this.stack;
                        Node<K, V> node6 = node5.a;
                        this.stack = node6;
                        node6.c = node5;
                        node6.i = node5.i + 1;
                        node5.a = node6;
                    } else if (i7 != 2) {
                    }
                    this.leavesSkipped = 0;
                }
                i5 *= 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        AvlIterator() {
        }

        void a(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (true) {
                Node<K, V> node3 = node2;
                node2 = node;
                if (node2 == null) {
                    this.stackTop = node3;
                    return;
                } else {
                    node2.a = node3;
                    node = node2.b;
                }
            }
        }

        public Node<K, V> next() {
            Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.a;
            node.a = null;
            Node<K, V> node3 = node.c;
            while (true) {
                Node<K, V> node4 = node2;
                node2 = node3;
                if (node2 == null) {
                    this.stackTop = node4;
                    return node;
                }
                node2.a = node4;
                node3 = node2.b;
            }
        }
    }

    /* loaded from: classes2.dex */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>(this) { // from class: com.google.gson.internal.LinkedHashTreeMap.EntrySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> a;
            if (!(obj instanceof Map.Entry) || (a = LinkedHashTreeMap.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.a((Node) a, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.d;
        }
    }

    /* loaded from: classes2.dex */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>(this) { // from class: com.google.gson.internal.LinkedHashTreeMap.KeySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return a().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        Node<K, V> a;
        Node<K, V> b;
        int c;

        LinkedTreeMapIterator() {
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            this.a = linkedHashTreeMap.c.d;
            this.b = null;
            this.c = linkedHashTreeMap.e;
        }

        final Node<K, V> a() {
            Node<K, V> node = this.a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.c) {
                throw new NoSuchElementException();
            }
            if (linkedHashTreeMap.e != this.c) {
                throw new ConcurrentModificationException();
            }
            this.a = node.d;
            this.b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedHashTreeMap.this.c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.a((Node) node, true);
            this.b = null;
            this.c = LinkedHashTreeMap.this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {
        Node<K, V> a;
        Node<K, V> b;
        Node<K, V> c;
        Node<K, V> d;
        Node<K, V> e;
        final K f;
        final int g;
        V h;
        int i;

        Node() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        Node(Node<K, V> node, K k, int i, Node<K, V> node2, Node<K, V> node3) {
            this.a = node;
            this.f = k;
            this.g = i;
            this.i = 1;
            this.d = node2;
            this.e = node3;
            node3.d = this;
            node2.e = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.h;
            Object value = entry.getValue();
            if (v == null) {
                if (value != null) {
                    return false;
                }
            } else if (!v.equals(value)) {
                return false;
            }
            return true;
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.b; node2 != null; node2 = node2.b) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.c; node2 != null; node2 = node2.c) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.h;
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.d = 0;
        this.e = 0;
        this.a = comparator == null ? NATURAL_ORDER : comparator;
        this.c = new Node<>();
        this.b = new Node[16];
        Node<K, V>[] nodeArr = this.b;
        this.f = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    static <K, V> Node<K, V>[] a(Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[length * 2];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i = 0; i < length; i++) {
            Node<K, V> node = nodeArr[i];
            if (node != null) {
                avlIterator.a(node);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    Node<K, V> next = avlIterator.next();
                    if (next == null) {
                        break;
                    }
                    if ((next.g & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.a(i2);
                avlBuilder2.a(i3);
                avlIterator.a(node);
                while (true) {
                    Node<K, V> next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    }
                    if ((next2.g & length) == 0) {
                        avlBuilder.a(next2);
                    } else {
                        avlBuilder2.a(next2);
                    }
                }
                nodeArr2[i] = i2 > 0 ? avlBuilder.a() : null;
                nodeArr2[i + length] = i3 > 0 ? avlBuilder2.a() : null;
            }
        }
        return nodeArr2;
    }

    private void doubleCapacity() {
        this.b = a((Node[]) this.b);
        Node<K, V>[] nodeArr = this.b;
        this.f = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.b;
            Node<K, V> node3 = node.c;
            int i = node2 != null ? node2.i : 0;
            int i2 = node3 != null ? node3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node<K, V> node4 = node3.b;
                Node<K, V> node5 = node3.c;
                int i4 = (node4 != null ? node4.i : 0) - (node5 != null ? node5.i : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    rotateRight(node3);
                }
                rotateLeft(node);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                Node<K, V> node6 = node2.b;
                Node<K, V> node7 = node2.c;
                int i5 = (node6 != null ? node6.i : 0) - (node7 != null ? node7.i : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(node2);
                }
                rotateRight(node);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.i = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.a;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.a;
        node.a = null;
        if (node2 != null) {
            node2.a = node3;
        }
        if (node3 == null) {
            int i = node.g;
            this.b[i & (r0.length - 1)] = node2;
        } else if (node3.b == node) {
            node3.b = node2;
        } else {
            node3.c = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node.b;
        Node<K, V> node3 = node.c;
        Node<K, V> node4 = node3.b;
        Node<K, V> node5 = node3.c;
        node.c = node4;
        if (node4 != null) {
            node4.a = node;
        }
        replaceInParent(node, node3);
        node3.b = node;
        node.a = node3;
        node.i = Math.max(node2 != null ? node2.i : 0, node4 != null ? node4.i : 0) + 1;
        node3.i = Math.max(node.i, node5 != null ? node5.i : 0) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node.b;
        Node<K, V> node3 = node.c;
        Node<K, V> node4 = node2.b;
        Node<K, V> node5 = node2.c;
        node.b = node5;
        if (node5 != null) {
            node5.a = node;
        }
        replaceInParent(node, node2);
        node2.c = node;
        node.a = node2;
        node.i = Math.max(node3 != null ? node3.i : 0, node5 != null ? node5.i : 0) + 1;
        node2.i = Math.max(node.i, node4 != null ? node4.i : 0) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    Node<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a((LinkedHashTreeMap<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    Node<K, V> a(K k, boolean z) {
        Node<K, V> node;
        int i;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.a;
        Node<K, V>[] nodeArr = this.b;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                K k2 = node3.f;
                int compareTo = comparable != null ? comparable.compareTo(k2) : comparator.compare(k, k2);
                if (compareTo == 0) {
                    return node3;
                }
                Node<K, V> node4 = compareTo < 0 ? node3.b : node3.c;
                if (node4 == null) {
                    node = node3;
                    i = compareTo;
                    break;
                }
                node3 = node4;
            }
        } else {
            node = node3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        Node<K, V> node5 = this.c;
        if (node != null) {
            node2 = new Node<>(node, k, secondaryHash, node5, node5.e);
            if (i < 0) {
                node.b = node2;
            } else {
                node.c = node2;
            }
            rebalance(node, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            node2 = new Node<>(node, k, secondaryHash, node5, node5.e);
            nodeArr[length] = node2;
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 > this.f) {
            doubleCapacity();
        }
        this.e++;
        return node2;
    }

    Node<K, V> a(Map.Entry<?, ?> entry) {
        Node<K, V> a = a(entry.getKey());
        if (a != null && equal(a.h, entry.getValue())) {
            return a;
        }
        return null;
    }

    void a(Node<K, V> node, boolean z) {
        int i;
        if (z) {
            Node<K, V> node2 = node.e;
            node2.d = node.d;
            node.d.e = node2;
            node.e = null;
            node.d = null;
        }
        Node<K, V> node3 = node.b;
        Node<K, V> node4 = node.c;
        Node<K, V> node5 = node.a;
        int i2 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                replaceInParent(node, node3);
                node.b = null;
            } else if (node4 != null) {
                replaceInParent(node, node4);
                node.c = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node5, false);
            this.d--;
            this.e++;
            return;
        }
        Node<K, V> last = node3.i > node4.i ? node3.last() : node4.first();
        a((Node) last, false);
        Node<K, V> node6 = node.b;
        if (node6 != null) {
            i = node6.i;
            last.b = node6;
            node6.a = last;
            node.b = null;
        } else {
            i = 0;
        }
        Node<K, V> node7 = node.c;
        if (node7 != null) {
            i2 = node7.i;
            last.c = node7;
            node7.a = last;
            node.c = null;
        }
        last.i = Math.max(i, i2) + 1;
        replaceInParent(node, last);
    }

    Node<K, V> b(Object obj) {
        Node<K, V> a = a(obj);
        if (a != null) {
            a((Node) a, true);
        }
        return a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.b, (Object) null);
        this.d = 0;
        this.e++;
        Node<K, V> node = this.c;
        Node<K, V> node2 = node.d;
        while (node2 != node) {
            Node<K, V> node3 = node2.d;
            node2.e = null;
            node2.d = null;
            node2 = node3;
        }
        node.e = node;
        node.d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> a = a(obj);
        if (a != null) {
            return a.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        LinkedHashTreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        Node<K, V> a = a((LinkedHashTreeMap<K, V>) k, true);
        V v2 = a.h;
        a.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> b = b(obj);
        if (b != null) {
            return b.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }
}
