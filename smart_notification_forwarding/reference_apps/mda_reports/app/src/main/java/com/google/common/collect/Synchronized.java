package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.j2objc.annotations.RetainedWith;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Synchronized {

    /* loaded from: classes2.dex */
    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, Collection<V>>> f;

        @MonotonicNonNullDecl
        transient Collection<Collection<V>> g;

        SynchronizedAsMap(Map<K, Collection<V>> map, @NullableDecl Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.b) {
                if (this.f == null) {
                    this.f = new SynchronizedAsMapEntries(a().entrySet(), this.b);
                }
                set = this.f;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> typePreservingCollection;
            synchronized (this.b) {
                Collection collection = (Collection) super.get(obj);
                typePreservingCollection = collection == null ? null : Synchronized.typePreservingCollection(collection, this.b);
            }
            return typePreservingCollection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.b) {
                if (this.g == null) {
                    this.g = new SynchronizedAsMapValues(a().values(), this.b);
                }
                collection = this.g;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @NullableDecl Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean a;
            synchronized (this.b) {
                a = Maps.a(a(), obj);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean a;
            synchronized (this.b) {
                a = Collections2.a((Collection<?>) a(), collection);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean a;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                a = Sets.a(a(), obj);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public Map.Entry<K, Collection<V>> a(final Map.Entry<K, Collection<V>> entry) {
                    return new ForwardingMapEntry<K, Collection<V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        public Map.Entry<K, Collection<V>> delegate() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public Collection<V> getValue() {
                            return Synchronized.typePreservingCollection((Collection) entry.getValue(), SynchronizedAsMapEntries.this.b);
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean b;
            synchronized (this.b) {
                b = Maps.b(a(), obj);
            }
            return b;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.b) {
                removeAll = Iterators.removeAll(a().iterator(), collection);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.b) {
                retainAll = Iterators.retainAll(a().iterator(), collection);
            }
            return retainAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] a;
            synchronized (this.b) {
                a = ObjectArrays.a(a());
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.b) {
                tArr2 = (T[]) ObjectArrays.a(a(), tArr);
            }
            return tArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, @NullableDecl Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public Collection<V> a(Collection<V> collection) {
                    return Synchronized.typePreservingCollection(collection, SynchronizedAsMapValues.this.b);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @RetainedWith
        @MonotonicNonNullDecl
        private transient BiMap<V, K> inverse;

        @MonotonicNonNullDecl
        private transient Set<V> valueSet;

        private SynchronizedBiMap(BiMap<K, V> biMap, @NullableDecl Object obj, @NullableDecl BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.inverse = biMap2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public BiMap<K, V> a() {
            return (BiMap) super.a();
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            V forcePut;
            synchronized (this.b) {
                forcePut = a().forcePut(k, v);
            }
            return forcePut;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap;
            synchronized (this.b) {
                if (this.inverse == null) {
                    this.inverse = new SynchronizedBiMap(a().inverse(), this.b, this);
                }
                biMap = this.inverse;
            }
            return biMap;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.b) {
                if (this.valueSet == null) {
                    this.valueSet = Synchronized.b((Set) a().values(), this.b);
                }
                set = this.valueSet;
            }
            return set;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        private SynchronizedCollection(Collection<E> collection, @NullableDecl Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Collection<E> a() {
            return (Collection) super.a();
        }

        @Override // java.util.Collection
        public boolean add(E e) {
            boolean add;
            synchronized (this.b) {
                add = a().add(e);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.b) {
                addAll = a().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.b) {
                a().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.b) {
                contains = a().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.b) {
                containsAll = a().containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.b) {
                isEmpty = a().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return a().iterator();
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.b) {
                remove = a().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.b) {
                removeAll = a().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.b) {
                retainAll = a().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.b) {
                size = a().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.b) {
                array = a().toArray();
            }
            return array;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.b) {
                tArr2 = (T[]) a().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* loaded from: classes2.dex */
    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        SynchronizedDeque(Deque<E> deque, @NullableDecl Object obj) {
            super(deque, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> a() {
            return (Deque) super.a();
        }

        @Override // java.util.Deque
        public void addFirst(E e) {
            synchronized (this.b) {
                a().addFirst(e);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e) {
            synchronized (this.b) {
                a().addLast(e);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.b) {
                descendingIterator = a().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.b) {
                first = a().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.b) {
                last = a().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e) {
            boolean offerFirst;
            synchronized (this.b) {
                offerFirst = a().offerFirst(e);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e) {
            boolean offerLast;
            synchronized (this.b) {
                offerLast = a().offerLast(e);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E peekFirst;
            synchronized (this.b) {
                peekFirst = a().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E peekLast;
            synchronized (this.b) {
                peekLast = a().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E pollFirst;
            synchronized (this.b) {
                pollFirst = a().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E pollLast;
            synchronized (this.b) {
                pollLast = a().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.b) {
                pop = a().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e) {
            synchronized (this.b) {
                a().push(e);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.b) {
                removeFirst = a().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.b) {
                removeFirstOccurrence = a().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.b) {
                removeLast = a().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.b) {
                removeLastOccurrence = a().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry<K, V> entry, @NullableDecl Object obj) {
            super(entry, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map.Entry<K, V> a() {
            return (Map.Entry) super.a();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.b) {
                key = a().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.b) {
                value = a().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V value;
            synchronized (this.b) {
                value = a().setValue(v);
            }
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> list, @NullableDecl Object obj) {
            super(list, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> a() {
            return (List) super.a();
        }

        @Override // java.util.List
        public void add(int i, E e) {
            synchronized (this.b) {
                a().add(i, e);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.b) {
                addAll = a().addAll(i, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i) {
            E e;
            synchronized (this.b) {
                e = a().get(i);
            }
            return e;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.b) {
                indexOf = a().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.b) {
                lastIndexOf = a().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return a().listIterator();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i) {
            return a().listIterator(i);
        }

        @Override // java.util.List
        public E remove(int i) {
            E remove;
            synchronized (this.b) {
                remove = a().remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i, E e) {
            E e2;
            synchronized (this.b) {
                e2 = a().set(i, e);
            }
            return e2;
        }

        @Override // java.util.List
        public List<E> subList(int i, int i2) {
            List<E> list;
            synchronized (this.b) {
                list = Synchronized.list(a().subList(i, i2), this.b);
            }
            return list;
        }
    }

    /* loaded from: classes2.dex */
    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, @NullableDecl Object obj) {
            super(listMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public ListMultimap<K, V> a() {
            return (ListMultimap) super.a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> get(K k) {
            List<V> list;
            synchronized (this.b) {
                list = Synchronized.list(a().get((ListMultimap<K, V>) k), this.b);
            }
            return list;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object obj) {
            List<V> removeAll;
            synchronized (this.b) {
                removeAll = a().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.b) {
                replaceValues = a().replaceValues((ListMultimap<K, V>) k, (Iterable) iterable);
            }
            return replaceValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<K> c;

        @MonotonicNonNullDecl
        transient Collection<V> d;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> e;

        SynchronizedMap(Map<K, V> map, @NullableDecl Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map<K, V> a() {
            return (Map) super.a();
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.b) {
                a().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.b) {
                containsKey = a().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.b) {
                containsValue = a().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.b) {
                if (this.e == null) {
                    this.e = Synchronized.b((Set) a().entrySet(), this.b);
                }
                set = this.e;
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        public V get(Object obj) {
            V v;
            synchronized (this.b) {
                v = a().get(obj);
            }
            return v;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.b) {
                isEmpty = a().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.b) {
                if (this.c == null) {
                    this.c = Synchronized.b((Set) a().keySet(), this.b);
                }
                set = this.c;
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            V put;
            synchronized (this.b) {
                put = a().put(k, v);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.b) {
                a().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.b) {
                remove = a().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.b) {
                size = a().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.b) {
                if (this.d == null) {
                    this.d = Synchronized.collection(a().values(), this.b);
                }
                collection = this.d;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<K> c;

        @MonotonicNonNullDecl
        transient Collection<V> d;

        @MonotonicNonNullDecl
        transient Collection<Map.Entry<K, V>> e;

        @MonotonicNonNullDecl
        transient Map<K, Collection<V>> f;

        @MonotonicNonNullDecl
        transient Multiset<K> g;

        SynchronizedMultimap(Multimap<K, V> multimap, @NullableDecl Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Multimap<K, V> a() {
            return (Multimap) super.a();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.b) {
                if (this.f == null) {
                    this.f = new SynchronizedAsMap(a().asMap(), this.b);
                }
                map = this.f;
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.b) {
                a().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            boolean containsEntry;
            synchronized (this.b) {
                containsEntry = a().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.b) {
                containsKey = a().containsKey(obj);
            }
            return containsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.b) {
                containsValue = a().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.b) {
                if (this.e == null) {
                    this.e = Synchronized.typePreservingCollection(a().entries(), this.b);
                }
                collection = this.e;
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        public Collection<V> get(K k) {
            Collection<V> typePreservingCollection;
            synchronized (this.b) {
                typePreservingCollection = Synchronized.typePreservingCollection(a().get(k), this.b);
            }
            return typePreservingCollection;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.b) {
                isEmpty = a().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.b) {
                if (this.c == null) {
                    this.c = Synchronized.typePreservingSet(a().keySet(), this.b);
                }
                set = this.c;
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset;
            synchronized (this.b) {
                if (this.g == null) {
                    this.g = Synchronized.a((Multiset) a().keys(), this.b);
                }
                multiset = this.g;
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            boolean put;
            synchronized (this.b) {
                put = a().put(k, v);
            }
            return put;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            boolean putAll;
            synchronized (this.b) {
                putAll = a().putAll(multimap);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.b) {
                putAll = a().putAll(k, iterable);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.b) {
                remove = a().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(Object obj) {
            Collection<V> removeAll;
            synchronized (this.b) {
                removeAll = a().removeAll(obj);
            }
            return removeAll;
        }

        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.b) {
                replaceValues = a().replaceValues(k, iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.b) {
                size = a().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.b) {
                if (this.d == null) {
                    this.d = Synchronized.collection(a().values(), this.b);
                }
                collection = this.d;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<E> c;

        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> d;

        SynchronizedMultiset(Multiset<E> multiset, @NullableDecl Object obj) {
            super(multiset, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Multiset<E> a() {
            return (Multiset) super.a();
        }

        @Override // com.google.common.collect.Multiset
        public int add(E e, int i) {
            int add;
            synchronized (this.b) {
                add = a().add(e, i);
            }
            return add;
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int count;
            synchronized (this.b) {
                count = a().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.b) {
                if (this.c == null) {
                    this.c = Synchronized.typePreservingSet(a().elementSet(), this.b);
                }
                set = this.c;
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set;
            synchronized (this.b) {
                if (this.d == null) {
                    this.d = Synchronized.typePreservingSet(a().entrySet(), this.b);
                }
                set = this.d;
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            int remove;
            synchronized (this.b) {
                remove = a().remove(obj, i);
            }
            return remove;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(E e, int i) {
            int count;
            synchronized (this.b) {
                count = a().setCount(e, i);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(E e, int i, int i2) {
            boolean count;
            synchronized (this.b) {
                count = a().setCount(e, i, i2);
            }
            return count;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient NavigableSet<K> f;

        @MonotonicNonNullDecl
        transient NavigableMap<K, V> g;

        @MonotonicNonNullDecl
        transient NavigableSet<K> h;

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
            super(navigableMap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> a() {
            return (NavigableMap) super.a();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().ceilingEntry(k), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            K ceilingKey;
            synchronized (this.b) {
                ceilingKey = a().ceilingKey(k);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.b) {
                if (this.f != null) {
                    return this.f;
                }
                NavigableSet<K> a = Synchronized.a((NavigableSet) a().descendingKeySet(), this.b);
                this.f = a;
                return a;
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.b) {
                if (this.g != null) {
                    return this.g;
                }
                NavigableMap<K, V> a = Synchronized.a((NavigableMap) a().descendingMap(), this.b);
                this.g = a;
                return a;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().firstEntry(), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().floorEntry(k), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            K floorKey;
            synchronized (this.b) {
                floorKey = a().floorKey(k);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            NavigableMap<K, V> a;
            synchronized (this.b) {
                a = Synchronized.a((NavigableMap) a().headMap(k, z), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().higherEntry(k), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            K higherKey;
            synchronized (this.b) {
                higherKey = a().higherKey(k);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().lastEntry(), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().lowerEntry(k), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            K lowerKey;
            synchronized (this.b) {
                lowerKey = a().lowerKey(k);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.b) {
                if (this.h != null) {
                    return this.h;
                }
                NavigableSet<K> a = Synchronized.a((NavigableSet) a().navigableKeySet(), this.b);
                this.h = a;
                return a;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().pollFirstEntry(), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.b) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(a().pollLastEntry(), this.b);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            NavigableMap<K, V> a;
            synchronized (this.b) {
                a = Synchronized.a((NavigableMap) a().subMap(k, z, k2, z2), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            NavigableMap<K, V> a;
            synchronized (this.b) {
                a = Synchronized.a((NavigableMap) a().tailMap(k, z), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient NavigableSet<E> c;

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
            super(navigableSet, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> a() {
            return (NavigableSet) super.a();
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            E ceiling;
            synchronized (this.b) {
                ceiling = a().ceiling(e);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return a().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.b) {
                if (this.c != null) {
                    return this.c;
                }
                NavigableSet<E> a = Synchronized.a((NavigableSet) a().descendingSet(), this.b);
                this.c = a;
                return a;
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            E floor;
            synchronized (this.b) {
                floor = a().floor(e);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            NavigableSet<E> a;
            synchronized (this.b) {
                a = Synchronized.a((NavigableSet) a().headSet(e, z), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e) {
            return headSet(e, false);
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            E higher;
            synchronized (this.b) {
                higher = a().higher(e);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            E lower;
            synchronized (this.b) {
                lower = a().lower(e);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.b) {
                pollFirst = a().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.b) {
                pollLast = a().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            NavigableSet<E> a;
            synchronized (this.b) {
                a = Synchronized.a((NavigableSet) a().subSet(e, z, e2, z2), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e, E e2) {
            return subSet(e, true, e2, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            NavigableSet<E> a;
            synchronized (this.b) {
                a = Synchronized.a((NavigableSet) a().tailSet(e, z), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e) {
            return tailSet(e, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SynchronizedObject implements Serializable {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object a;
        final Object b;

        SynchronizedObject(Object obj, @NullableDecl Object obj2) {
            this.a = Preconditions.checkNotNull(obj);
            this.b = obj2 == null ? this : obj2;
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) {
            synchronized (this.b) {
                objectOutputStream.defaultWriteObject();
            }
        }

        Object a() {
            return this.a;
        }

        public String toString() {
            String obj;
            synchronized (this.b) {
                obj = this.a.toString();
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue<E> queue, @NullableDecl Object obj) {
            super(queue, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> a() {
            return (Queue) super.a();
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.b) {
                element = a().element();
            }
            return element;
        }

        @Override // java.util.Queue
        public boolean offer(E e) {
            boolean offer;
            synchronized (this.b) {
                offer = a().offer(e);
            }
            return offer;
        }

        @Override // java.util.Queue
        public E peek() {
            E peek;
            synchronized (this.b) {
                peek = a().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        public E poll() {
            E poll;
            synchronized (this.b) {
                poll = a().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.b) {
                remove = a().remove();
            }
            return remove;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> list, @NullableDecl Object obj) {
            super(list, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> set, @NullableDecl Object obj) {
            super(set, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> a() {
            return (Set) super.a();
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> h;

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, @NullableDecl Object obj) {
            super(setMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SetMultimap<K, V> a() {
            return (SetMultimap) super.a();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.b) {
                if (this.h == null) {
                    this.h = Synchronized.b((Set) a().entries(), this.b);
                }
                set = this.h;
            }
            return set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> get(K k) {
            Set<V> b;
            synchronized (this.b) {
                b = Synchronized.b((Set) a().get((SetMultimap<K, V>) k), this.b);
            }
            return b;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> removeAll(Object obj) {
            Set<V> removeAll;
            synchronized (this.b) {
                removeAll = a().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.b) {
                replaceValues = a().replaceValues((SetMultimap<K, V>) k, (Iterable) iterable);
            }
            return replaceValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
            super(sortedMap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.b) {
                comparator = a().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.b) {
                firstKey = a().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k) {
            SortedMap<K, V> a;
            synchronized (this.b) {
                a = Synchronized.a((SortedMap) a().headMap(k), this.b);
            }
            return a;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.b) {
                lastKey = a().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            SortedMap<K, V> a;
            synchronized (this.b) {
                a = Synchronized.a((SortedMap) a().subMap(k, k2), this.b);
            }
            return a;
        }

        public SortedMap<K, V> tailMap(K k) {
            SortedMap<K, V> a;
            synchronized (this.b) {
                a = Synchronized.a((SortedMap) a().tailMap(k), this.b);
            }
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet<E> sortedSet, @NullableDecl Object obj) {
            super(sortedSet, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> a() {
            return (SortedSet) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.b) {
                comparator = a().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.b) {
                first = a().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e) {
            SortedSet<E> sortedSet;
            synchronized (this.b) {
                sortedSet = Synchronized.sortedSet(a().headSet(e), this.b);
            }
            return sortedSet;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.b) {
                last = a().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e, E e2) {
            SortedSet<E> sortedSet;
            synchronized (this.b) {
                sortedSet = Synchronized.sortedSet(a().subSet(e, e2), this.b);
            }
            return sortedSet;
        }

        public SortedSet<E> tailSet(E e) {
            SortedSet<E> sortedSet;
            synchronized (this.b) {
                sortedSet = Synchronized.sortedSet(a().tailSet(e), this.b);
            }
            return sortedSet;
        }
    }

    /* loaded from: classes2.dex */
    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @NullableDecl Object obj) {
            super(sortedSetMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSetMultimap<K, V> a() {
            return (SortedSetMultimap) super.a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> get(K k) {
            SortedSet<V> sortedSet;
            synchronized (this.b) {
                sortedSet = Synchronized.sortedSet(a().get((SortedSetMultimap<K, V>) k), this.b);
            }
            return sortedSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> removeAll(Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.b) {
                removeAll = a().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.b) {
                replaceValues = a().replaceValues((SortedSetMultimap<K, V>) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.b) {
                valueComparator = a().valueComparator();
            }
            return valueComparator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        SynchronizedTable(Table<R, C, V> table, Object obj) {
            super(table, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Table<R, C, V> a() {
            return (Table) super.a();
        }

        @Override // com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            Set<Table.Cell<R, C, V>> b;
            synchronized (this.b) {
                b = Synchronized.b((Set) a().cellSet(), this.b);
            }
            return b;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.b) {
                a().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C c) {
            Map<R, V> a;
            synchronized (this.b) {
                a = Synchronized.a(a().column(c), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Table
        public Set<C> columnKeySet() {
            Set<C> b;
            synchronized (this.b) {
                b = Synchronized.b((Set) a().columnKeySet(), this.b);
            }
            return b;
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> a;
            synchronized (this.b) {
                a = Synchronized.a(Maps.transformValues(a().columnMap(), new Function<Map<R, V>, Map<R, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.2
                    @Override // com.google.common.base.Function
                    public Map<R, V> apply(Map<R, V> map) {
                        return Synchronized.a(map, SynchronizedTable.this.b);
                    }
                }), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
            boolean contains;
            synchronized (this.b) {
                contains = a().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(@NullableDecl Object obj) {
            boolean containsColumn;
            synchronized (this.b) {
                containsColumn = a().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(@NullableDecl Object obj) {
            boolean containsRow;
            synchronized (this.b) {
                containsRow = a().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(@NullableDecl Object obj) {
            boolean containsValue;
            synchronized (this.b) {
                containsValue = a().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Table
        public boolean equals(@NullableDecl Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.b) {
                equals = a().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Table
        public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
            V v;
            synchronized (this.b) {
                v = a().get(obj, obj2);
            }
            return v;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int hashCode;
            synchronized (this.b) {
                hashCode = a().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.b) {
                isEmpty = a().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Table
        public V put(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
            V put;
            synchronized (this.b) {
                put = a().put(r, c, v);
            }
            return put;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.b) {
                a().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
            V remove;
            synchronized (this.b) {
                remove = a().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r) {
            Map<C, V> a;
            synchronized (this.b) {
                a = Synchronized.a(a().row(r), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Table
        public Set<R> rowKeySet() {
            Set<R> b;
            synchronized (this.b) {
                b = Synchronized.b((Set) a().rowKeySet(), this.b);
            }
            return b;
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> a;
            synchronized (this.b) {
                a = Synchronized.a(Maps.transformValues(a().rowMap(), new Function<Map<C, V>, Map<C, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.1
                    @Override // com.google.common.base.Function
                    public Map<C, V> apply(Map<C, V> map) {
                        return Synchronized.a(map, SynchronizedTable.this.b);
                    }
                }), this.b);
            }
            return a;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.b) {
                size = a().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.b) {
                collection = Synchronized.collection(a().values(), this.b);
            }
            return collection;
        }
    }

    private Synchronized() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> BiMap<K, V> a(BiMap<K, V> biMap, @NullableDecl Object obj) {
        return ((biMap instanceof SynchronizedBiMap) || (biMap instanceof ImmutableBiMap)) ? biMap : new SynchronizedBiMap(biMap, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ListMultimap<K, V> a(ListMultimap<K, V> listMultimap, @NullableDecl Object obj) {
        return ((listMultimap instanceof SynchronizedListMultimap) || (listMultimap instanceof BaseImmutableMultimap)) ? listMultimap : new SynchronizedListMultimap(listMultimap, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Multimap<K, V> a(Multimap<K, V> multimap, @NullableDecl Object obj) {
        return ((multimap instanceof SynchronizedMultimap) || (multimap instanceof BaseImmutableMultimap)) ? multimap : new SynchronizedMultimap(multimap, obj);
    }

    static <E> Multiset<E> a(Multiset<E> multiset, @NullableDecl Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> SetMultimap<K, V> a(SetMultimap<K, V> setMultimap, @NullableDecl Object obj) {
        return ((setMultimap instanceof SynchronizedSetMultimap) || (setMultimap instanceof BaseImmutableMultimap)) ? setMultimap : new SynchronizedSetMultimap(setMultimap, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> SortedSetMultimap<K, V> a(SortedSetMultimap<K, V> sortedSetMultimap, @NullableDecl Object obj) {
        return sortedSetMultimap instanceof SynchronizedSortedSetMultimap ? sortedSetMultimap : new SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R, C, V> Table<R, C, V> a(Table<R, C, V> table, Object obj) {
        return new SynchronizedTable(table, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Deque<E> a(Deque<E> deque, @NullableDecl Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    @VisibleForTesting
    static <K, V> Map<K, V> a(Map<K, V> map, @NullableDecl Object obj) {
        return new SynchronizedMap(map, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> a(NavigableMap<K, V> navigableMap) {
        return a((NavigableMap) navigableMap, (Object) null);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> a(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static <E> NavigableSet<E> a(NavigableSet<E> navigableSet) {
        return a((NavigableSet) navigableSet, (Object) null);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> a(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Queue<E> a(Queue<E> queue, @NullableDecl Object obj) {
        return queue instanceof SynchronizedQueue ? queue : new SynchronizedQueue(queue, obj);
    }

    static <K, V> SortedMap<K, V> a(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    @VisibleForTesting
    static <E> Set<E> b(Set<E> set, @NullableDecl Object obj) {
        return new SynchronizedSet(set, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> collection(Collection<E> collection, @NullableDecl Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> List<E> list(List<E> list, @NullableDecl Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    public static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@NullableDecl Map.Entry<K, V> entry, @NullableDecl Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> SortedSet<E> sortedSet(SortedSet<E> sortedSet, @NullableDecl Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> typePreservingCollection(Collection<E> collection, @NullableDecl Object obj) {
        return collection instanceof SortedSet ? sortedSet((SortedSet) collection, obj) : collection instanceof Set ? b((Set) collection, obj) : collection instanceof List ? list((List) collection, obj) : collection(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> typePreservingSet(Set<E> set, @NullableDecl Object obj) {
        return set instanceof SortedSet ? sortedSet((SortedSet) set, obj) : b((Set) set, obj);
    }
}
