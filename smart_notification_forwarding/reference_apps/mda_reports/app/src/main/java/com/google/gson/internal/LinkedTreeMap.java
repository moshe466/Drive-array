package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> a;
    Node<K, V> b;
    int c;
    int d;
    final Node<K, V> e;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    private LinkedTreeMap<K, V>.KeySet keySet;

    /* loaded from: classes2.dex */
    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>(this) { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
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
            if (!(obj instanceof Map.Entry) || (a = LinkedTreeMap.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.a((Node) a, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.c;
        }
    }

    /* loaded from: classes2.dex */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>(this) { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return a().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        Node<K, V> a;
        Node<K, V> b;
        int c;

        LinkedTreeMapIterator() {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            this.a = linkedTreeMap.e.d;
            this.b = null;
            this.c = linkedTreeMap.d;
        }

        final Node<K, V> a() {
            Node<K, V> node = this.a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.e) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.d != this.c) {
                throw new ConcurrentModificationException();
            }
            this.a = node.d;
            this.b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedTreeMap.this.e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.a((Node) node, true);
            this.b = null;
            this.c = LinkedTreeMap.this.d;
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
        V g;
        int h;

        Node() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.a = node;
            this.f = k;
            this.h = 1;
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
            V v = this.g;
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
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
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
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.g;
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.c = 0;
        this.d = 0;
        this.e = new Node<>();
        this.a = comparator == null ? NATURAL_ORDER : comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.b;
            Node<K, V> node3 = node.c;
            int i = node2 != null ? node2.h : 0;
            int i2 = node3 != null ? node3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node<K, V> node4 = node3.b;
                Node<K, V> node5 = node3.c;
                int i4 = (node4 != null ? node4.h : 0) - (node5 != null ? node5.h : 0);
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
                int i5 = (node6 != null ? node6.h : 0) - (node7 != null ? node7.h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(node2);
                }
                rotateRight(node);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.h = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.h = Math.max(i, i2) + 1;
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
            this.b = node2;
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
        node.h = Math.max(node2 != null ? node2.h : 0, node4 != null ? node4.h : 0) + 1;
        node3.h = Math.max(node.h, node5 != null ? node5.h : 0) + 1;
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
        node.h = Math.max(node3 != null ? node3.h : 0, node5 != null ? node5.h : 0) + 1;
        node2.h = Math.max(node.h, node4 != null ? node4.h : 0) + 1;
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
            return a((LinkedTreeMap<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    Node<K, V> a(K k, boolean z) {
        int i;
        Node<K, V> node;
        Comparator<? super K> comparator = this.a;
        Node<K, V> node2 = this.b;
        if (node2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                K k2 = node2.f;
                i = comparable != null ? comparable.compareTo(k2) : comparator.compare(k, k2);
                if (i == 0) {
                    return node2;
                }
                Node<K, V> node3 = i < 0 ? node2.b : node2.c;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        Node<K, V> node4 = this.e;
        if (node2 != null) {
            node = new Node<>(node2, k, node4, node4.e);
            if (i < 0) {
                node2.b = node;
            } else {
                node2.c = node;
            }
            rebalance(node2, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            node = new Node<>(node2, k, node4, node4.e);
            this.b = node;
        }
        this.c++;
        this.d++;
        return node;
    }

    Node<K, V> a(Map.Entry<?, ?> entry) {
        Node<K, V> a = a(entry.getKey());
        if (a != null && equal(a.g, entry.getValue())) {
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
            this.c--;
            this.d++;
            return;
        }
        Node<K, V> last = node3.h > node4.h ? node3.last() : node4.first();
        a((Node) last, false);
        Node<K, V> node6 = node.b;
        if (node6 != null) {
            i = node6.h;
            last.b = node6;
            node6.a = last;
            node.b = null;
        } else {
            i = 0;
        }
        Node<K, V> node7 = node.c;
        if (node7 != null) {
            i2 = node7.h;
            last.c = node7;
            node7.a = last;
            node.c = null;
        }
        last.h = Math.max(i, i2) + 1;
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
        this.b = null;
        this.c = 0;
        this.d++;
        Node<K, V> node = this.e;
        node.e = node;
        node.d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> a = a(obj);
        if (a != null) {
            return a.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        Node<K, V> a = a((LinkedTreeMap<K, V>) k, true);
        V v2 = a.g;
        a.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> b = b(obj);
        if (b != null) {
            return b.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }
}
