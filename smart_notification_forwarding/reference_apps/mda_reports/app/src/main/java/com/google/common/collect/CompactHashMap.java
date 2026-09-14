package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: classes2.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] a;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] b;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] c;
    transient float d;
    transient int e;

    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySetView;

    @MonotonicNonNullDecl
    private transient Set<K> keySetView;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    @MonotonicNonNullDecl
    private transient Collection<V> valuesView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            return indexOf != -1 && Objects.equal(CompactHashMap.this.c[indexOf], entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            if (indexOf == -1 || !Objects.equal(CompactHashMap.this.c[indexOf], entry.getValue())) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* loaded from: classes2.dex */
    private abstract class Itr<T> implements Iterator<T> {
        int a;
        int b;
        int c;

        private Itr() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            this.a = compactHashMap.e;
            this.b = compactHashMap.e();
            this.c = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.e != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T a(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.c = i;
            T a = a(i);
            this.b = CompactHashMap.this.b(this.b);
            return a;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.a(this.c >= 0);
            this.a++;
            CompactHashMap.this.removeEntry(this.c);
            this.b = CompactHashMap.this.a(this.b, this.c);
            this.c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int indexOf = CompactHashMap.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class MapEntry extends AbstractMapEntry<K, V> {

        @NullableDecl
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i) {
            this.key = (K) CompactHashMap.this.b[i];
            this.lastKnownIndex = i;
        }

        private void updateLastKnownIndex() {
            int i = this.lastKnownIndex;
            if (i == -1 || i >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.b[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            updateLastKnownIndex();
            int i = this.lastKnownIndex;
            if (i == -1) {
                return null;
            }
            return (V) CompactHashMap.this.c[i];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            updateLastKnownIndex();
            int i = this.lastKnownIndex;
            if (i == -1) {
                CompactHashMap.this.put(this.key, v);
                return null;
            }
            Object[] objArr = CompactHashMap.this.c;
            V v2 = (V) objArr[i];
            objArr[i] = v;
            return v2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    CompactHashMap() {
        a(3, 1.0f);
    }

    CompactHashMap(int i) {
        this(i, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashMap(int i, float f) {
        a(i, f);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    private static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        int a = Hashing.a(obj);
        int i = this.table[hashTableMask() & a];
        while (i != -1) {
            long j = this.a[i];
            if (getHash(j) == a && Objects.equal(obj, this.b[i])) {
                return i;
            }
            i = getNext(j);
        }
        return -1;
    }

    private static long[] newEntries(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        a(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            } else {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    @NullableDecl
    private V remove(@NullableDecl Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.a[i2]) == i && Objects.equal(obj, this.b[i2])) {
                V v = (V) this.c[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.a[i2]);
                } else {
                    long[] jArr = this.a;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                c(i2);
                this.size--;
                this.e++;
                return v;
            }
            int next = getNext(this.a[i2]);
            if (next == -1) {
                return null;
            }
            i3 = i2;
            i2 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeEntry(int i) {
        return remove(this.b[i], getHash(this.a[i]));
    }

    private void resizeMeMaybe(int i) {
        int length = this.a.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                d(max);
            }
        }
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.d)) + 1;
        int[] newTable = newTable(i);
        long[] jArr = this.a;
        int length = newTable.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int hash = getHash(jArr[i3]);
            int i4 = hash & length;
            int i5 = newTable[i4];
            newTable[i4] = i3;
            jArr[i3] = (hash << 32) | (NEXT_MASK & i5);
        }
        this.threshold = i2;
        this.table = newTable;
    }

    private static long swapNext(long j, int i) {
        return (j & HASH_MASK) | (i & NEXT_MASK);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        for (int i = 0; i < this.size; i++) {
            objectOutputStream.writeObject(this.b[i]);
            objectOutputStream.writeObject(this.c[i]);
        }
    }

    int a(int i, int i2) {
        return i - 1;
    }

    Set<Map.Entry<K, V>> a() {
        return new EntrySetView();
    }

    void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f > 0.0f, "Illegal load factor");
        int a = Hashing.a(i, f);
        this.table = newTable(a);
        this.d = f;
        this.b = new Object[i];
        this.c = new Object[i];
        this.a = newEntries(i);
        this.threshold = Math.max(1, (int) (a * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, @NullableDecl K k, @NullableDecl V v, int i2) {
        this.a[i] = (i2 << 32) | NEXT_MASK;
        this.b[i] = k;
        this.c[i] = v;
    }

    int b(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    Set<K> b() {
        return new KeySetView();
    }

    Collection<V> c() {
        return new ValuesView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.b[i] = null;
            this.c[i] = null;
            this.a[i] = -1;
            return;
        }
        Object[] objArr = this.b;
        objArr[i] = objArr[size];
        Object[] objArr2 = this.c;
        objArr2[i] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        long[] jArr = this.a;
        long j = jArr[size];
        jArr[i] = j;
        jArr[size] = -1;
        int hash = getHash(j) & hashTableMask();
        int[] iArr = this.table;
        int i2 = iArr[hash];
        if (i2 == size) {
            iArr[hash] = i;
            return;
        }
        while (true) {
            long j2 = this.a[i2];
            int next = getNext(j2);
            if (next == size) {
                this.a[i2] = swapNext(j2, i);
                return;
            }
            i2 = next;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.e++;
        Arrays.fill(this.b, 0, this.size, (Object) null);
        Arrays.fill(this.c, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.a, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equal(obj, this.c[i])) {
                return true;
            }
        }
        return false;
    }

    Iterator<Map.Entry<K, V>> d() {
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> a(int i) {
                return new MapEntry(i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        this.b = Arrays.copyOf(this.b, i);
        this.c = Arrays.copyOf(this.c, i);
        long[] jArr = this.a;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.a = copyOf;
    }

    int e() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> a = a();
        this.entrySetView = a;
        return a;
    }

    Iterator<K> f() {
        return new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            K a(int i) {
                return (K) CompactHashMap.this.b[i];
            }
        };
    }

    Iterator<V> g() {
        return new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            V a(int i) {
                return (V) CompactHashMap.this.c[i];
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        a(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.c[indexOf];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> b = b();
        this.keySetView = b;
        return b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        long[] jArr = this.a;
        Object[] objArr = this.b;
        Object[] objArr2 = this.c;
        int a = Hashing.a(k);
        int hashTableMask = hashTableMask() & a;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == a && Objects.equal(k, objArr[i2])) {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    a(i2);
                    return v2;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i2] = swapNext(j, i);
                    break;
                }
                i2 = next;
            }
        }
        if (i == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i3 = i + 1;
        resizeMeMaybe(i3);
        a(i, k, v, a);
        this.size = i3;
        if (i >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.e++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.a(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public void trimToSize() {
        int i = this.size;
        if (i < this.a.length) {
            d(i);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i / this.d)));
        if (max < 1073741824) {
            double d = i;
            double d2 = max;
            Double.isNaN(d);
            Double.isNaN(d2);
            if (d / d2 > this.d) {
                max <<= 1;
            }
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> c = c();
        this.valuesView = c;
        return c;
    }
}
