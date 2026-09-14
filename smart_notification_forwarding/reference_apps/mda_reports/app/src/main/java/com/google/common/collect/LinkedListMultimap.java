package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @NullableDecl
    private transient Node<K, V> head;
    private transient Map<K, KeyList<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;

    @NullableDecl
    private transient Node<K, V> tail;

    /* loaded from: classes2.dex */
    private class DistinctKeyIterator implements Iterator<K> {
        final Set<K> a;
        Node<K, V> b;

        @NullableDecl
        Node<K, V> c;
        int d;

        private DistinctKeyIterator() {
            this.a = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.b = LinkedListMultimap.this.head;
            this.d = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            Node<K, V> node;
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.b);
            this.c = this.b;
            this.a.add(this.c.a);
            do {
                this.b = this.b.c;
                node = this.b;
                if (node == null) {
                    break;
                }
            } while (!this.a.add(node.a));
            return this.c.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.a(this.c != null);
            LinkedListMultimap.this.removeAllNodes(this.c.a);
            this.c = null;
            this.d = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class KeyList<K, V> {
        Node<K, V> a;
        Node<K, V> b;
        int c;

        KeyList(Node<K, V> node) {
            this.a = node;
            this.b = node;
            node.f = null;
            node.e = null;
            this.c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Node<K, V> extends AbstractMapEntry<K, V> {

        @NullableDecl
        final K a;

        @NullableDecl
        V b;

        @NullableDecl
        Node<K, V> c;

        @NullableDecl
        Node<K, V> d;

        @NullableDecl
        Node<K, V> e;

        @NullableDecl
        Node<K, V> f;

        Node(@NullableDecl K k, @NullableDecl V v) {
            this.a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(@NullableDecl V v) {
            V v2 = this.b;
            this.b = v;
            return v2;
        }
    }

    /* loaded from: classes2.dex */
    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        int a;

        @NullableDecl
        Node<K, V> b;

        @NullableDecl
        Node<K, V> c;

        @NullableDecl
        Node<K, V> d;
        int e;

        NodeIterator(int i) {
            this.e = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i, size);
            if (i < size / 2) {
                this.b = LinkedListMultimap.this.head;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i2;
                }
            } else {
                this.d = LinkedListMultimap.this.tail;
                this.a = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.c = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.e) {
                throw new ConcurrentModificationException();
            }
        }

        void a(V v) {
            Preconditions.checkState(this.c != null);
            this.c.b = v;
        }

        @Override // java.util.ListIterator
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            checkForConcurrentModification();
            return this.d != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public Node<K, V> next() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.b);
            Node<K, V> node = this.b;
            this.c = node;
            this.d = node;
            this.b = node.c;
            this.a++;
            return this.c;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public Node<K, V> previous() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.d);
            Node<K, V> node = this.d;
            this.c = node;
            this.b = node;
            this.d = node.d;
            this.a--;
            return this.c;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.a(this.c != null);
            Node<K, V> node = this.c;
            if (node != this.b) {
                this.d = node.d;
                this.a--;
            } else {
                this.b = node.c;
            }
            LinkedListMultimap.this.removeNode(this.c);
            this.c = null;
            this.e = LinkedListMultimap.this.modCount;
        }

        @Override // java.util.ListIterator
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ValueForKeyIterator implements ListIterator<V> {

        @NullableDecl
        final Object a;
        int b;

        @NullableDecl
        Node<K, V> c;

        @NullableDecl
        Node<K, V> d;

        @NullableDecl
        Node<K, V> e;

        ValueForKeyIterator(@NullableDecl Object obj) {
            this.a = obj;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.c = keyList == null ? null : keyList.a;
        }

        public ValueForKeyIterator(@NullableDecl Object obj, int i) {
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = keyList == null ? 0 : keyList.c;
            Preconditions.checkPositionIndex(i, i2);
            if (i < i2 / 2) {
                this.c = keyList == null ? null : keyList.a;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            } else {
                this.e = keyList == null ? null : keyList.b;
                this.b = i2;
                while (true) {
                    int i4 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i4;
                }
            }
            this.a = obj;
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.e = LinkedListMultimap.this.addNode(this.a, v, this.c);
            this.b++;
            this.d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public V next() {
            LinkedListMultimap.checkElement(this.c);
            Node<K, V> node = this.c;
            this.d = node;
            this.e = node;
            this.c = node.e;
            this.b++;
            return this.d.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.checkElement(this.e);
            Node<K, V> node = this.e;
            this.d = node;
            this.c = node;
            this.e = node.f;
            this.b--;
            return this.d.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            CollectPreconditions.a(this.d != null);
            Node<K, V> node = this.d;
            if (node != this.c) {
                this.e = node.f;
                this.b--;
            } else {
                this.c = node.e;
            }
            LinkedListMultimap.this.removeNode(this.d);
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Preconditions.checkState(this.d != null);
            this.d.b = v;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int i) {
        this.keyToKeyList = Platform.a(i);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Node<K, V> addNode(@NullableDecl K k, @NullableDecl V v, @NullableDecl Node<K, V> node) {
        Map<K, KeyList<K, V>> map;
        KeyList<K, V> keyList;
        Node<K, V> node2 = new Node<>(k, v);
        if (this.head != null) {
            if (node == null) {
                Node<K, V> node3 = this.tail;
                node3.c = node2;
                node2.d = node3;
                this.tail = node2;
                KeyList<K, V> keyList2 = this.keyToKeyList.get(k);
                if (keyList2 == null) {
                    map = this.keyToKeyList;
                    keyList = new KeyList<>(node2);
                } else {
                    keyList2.c++;
                    Node<K, V> node4 = keyList2.b;
                    node4.e = node2;
                    node2.f = node4;
                    keyList2.b = node2;
                }
            } else {
                this.keyToKeyList.get(k).c++;
                node2.d = node.d;
                node2.f = node.f;
                node2.c = node;
                node2.e = node;
                Node<K, V> node5 = node.f;
                if (node5 == null) {
                    this.keyToKeyList.get(k).a = node2;
                } else {
                    node5.e = node2;
                }
                Node<K, V> node6 = node.d;
                if (node6 == null) {
                    this.head = node2;
                } else {
                    node6.c = node2;
                }
                node.d = node2;
                node.f = node2;
            }
            this.size++;
            return node2;
        }
        this.tail = node2;
        this.head = node2;
        map = this.keyToKeyList;
        keyList = new KeyList<>(node2);
        map.put(k, keyList);
        this.modCount++;
        this.size++;
        return node2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkElement(@NullableDecl Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    private List<V> getCopy(@NullableDecl Object obj) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(@NullableDecl Object obj) {
        Iterators.b(new ValueForKeyIterator(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(Node<K, V> node) {
        Node<K, V> node2 = node.d;
        if (node2 != null) {
            node2.c = node.c;
        } else {
            this.head = node.c;
        }
        Node<K, V> node3 = node.c;
        if (node3 != null) {
            node3.d = node.d;
        } else {
            this.tail = node.d;
        }
        if (node.f == null && node.e == null) {
            this.keyToKeyList.remove(node.a).c = 0;
            this.modCount++;
        } else {
            KeyList<K, V> keyList = this.keyToKeyList.get(node.a);
            keyList.c--;
            Node<K, V> node4 = node.f;
            if (node4 == null) {
                keyList.a = node.e;
            } else {
                node4.e = node.e;
            }
            Node<K, V> node5 = node.e;
            Node<K, V> node6 = node.f;
            if (node5 == null) {
                keyList.b = node6;
            } else {
                node5.f = node6;
            }
        }
        this.size--;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> a() {
        return new Multimaps.AsMap(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public List<Map.Entry<K, V>> b() {
        return new AbstractSequentialList<Map.Entry<K, V>>() { // from class: com.google.common.collect.LinkedListMultimap.1EntriesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator<Map.Entry<K, V>> listIterator(int i) {
                return new NodeIterator(i);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return LinkedListMultimap.this.size;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> c() {
        return new Sets.ImprovedAbstractSet<K>() { // from class: com.google.common.collect.LinkedListMultimap.1KeySetImpl
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return !LinkedListMultimap.this.removeAll(obj).isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }
        };
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> d() {
        return new Multimaps.Keys(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public List<V> e() {
        return new AbstractSequentialList<V>() { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator<V> listIterator(int i) {
                final NodeIterator nodeIterator = new NodeIterator(i);
                return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeIterator) { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.TransformedIterator
                    public V a(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    @Override // com.google.common.collect.TransformedListIterator, java.util.ListIterator
                    public void set(V v) {
                        nodeIterator.a(v);
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return LinkedListMultimap.this.size;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> f() {
        throw new AssertionError("should never be called");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Multimap
    public List<V> get(@NullableDecl final K k) {
        return new AbstractSequentialList<V>() { // from class: com.google.common.collect.LinkedListMultimap.1
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator<V> listIterator(int i) {
                return new ValueForKeyIterator(k, i);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(k);
                if (keyList == null) {
                    return 0;
                }
                return keyList.c;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> removeAll(@NullableDecl Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k);
        Iterator<? extends V> it = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it.hasNext()) {
            valueForKeyIterator.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }
}
