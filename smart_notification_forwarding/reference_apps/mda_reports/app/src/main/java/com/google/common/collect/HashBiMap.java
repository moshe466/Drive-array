package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes2.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    transient K[] a;
    transient V[] b;
    transient int c;
    transient int d;
    private transient Set<Map.Entry<K, V>> entrySet;

    @NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @RetainedWith
    @MonotonicNonNullDecl
    private transient BiMap<V, K> inverse;
    private transient Set<K> keySet;

    @NullableDecl
    private transient int lastInInsertionOrder;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    private transient Set<V> valueSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class EntryForKey extends AbstractMapEntry<K, V> {

        @NullableDecl
        final K a;
        int b;

        EntryForKey(int i) {
            this.a = HashBiMap.this.a[i];
            this.b = i;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            updateIndex();
            int i = this.b;
            if (i == -1) {
                return null;
            }
            return HashBiMap.this.b[i];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            updateIndex();
            int i = this.b;
            if (i == -1) {
                return (V) HashBiMap.this.put(this.a, v);
            }
            V v2 = HashBiMap.this.b[i];
            if (Objects.equal(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.b, v, false);
            return v2;
        }

        void updateIndex() {
            int i = this.b;
            if (i != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i <= hashBiMap.c && Objects.equal(hashBiMap.a[i], this.a)) {
                    return;
                }
            }
            this.b = HashBiMap.this.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> a;
        final V b;
        int c;

        EntryForValue(HashBiMap<K, V> hashBiMap, int i) {
            this.a = hashBiMap;
            this.b = hashBiMap.b[i];
            this.c = i;
        }

        private void updateIndex() {
            int i = this.c;
            if (i != -1) {
                HashBiMap<K, V> hashBiMap = this.a;
                if (i <= hashBiMap.c && Objects.equal(this.b, hashBiMap.b[i])) {
                    return;
                }
            }
            this.c = this.a.b(this.b);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getKey() {
            return this.b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getValue() {
            updateIndex();
            int i = this.c;
            if (i == -1) {
                return null;
            }
            return this.a.a[i];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K setValue(K k) {
            updateIndex();
            int i = this.c;
            if (i == -1) {
                return this.a.b(this.b, k, false);
            }
            K k2 = this.a.a[i];
            if (Objects.equal(k2, k)) {
                return k;
            }
            this.a.replaceKeyInEntry(this.c, k, false);
            return k2;
        }
    }

    /* loaded from: classes2.dex */
    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<K, V> a(int i) {
            return new EntryForKey(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int a = HashBiMap.this.a(key);
            return a != -1 && Objects.equal(value, HashBiMap.this.b[a]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int a = Hashing.a(key);
            int a2 = HashBiMap.this.a(key, a);
            if (a2 == -1 || !Objects.equal(value, HashBiMap.this.b[a2])) {
                return false;
            }
            HashBiMap.this.a(a2, a);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K forcePut(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.b(v, k, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object obj) {
            return this.forward.c(obj);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.b(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K remove(@NullableDecl Object obj) {
            return this.forward.d(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.c;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* loaded from: classes2.dex */
    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<V, K> a(int i) {
            return new EntryForValue(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int b = this.a.b(key);
            return b != -1 && Objects.equal(this.a.a[b], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int a = Hashing.a(key);
            int b = this.a.b(key, a);
            if (b == -1 || !Objects.equal(this.a.a[b], value)) {
                return false;
            }
            this.a.b(b, a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        K a(int i) {
            return HashBiMap.this.a[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int a = Hashing.a(obj);
            int a2 = HashBiMap.this.a(obj, a);
            if (a2 == -1) {
                return false;
            }
            HashBiMap.this.a(a2, a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        V a(int i) {
            return HashBiMap.this.b[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int a = Hashing.a(obj);
            int b = HashBiMap.this.b(obj, a);
            if (b == -1) {
                return false;
            }
            HashBiMap.this.b(b, a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> a;

        View(HashBiMap<K, V> hashBiMap) {
            this.a = hashBiMap;
        }

        abstract T a(int i);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = ((HashBiMap) View.this.a).firstInInsertionOrder;
                    HashBiMap<K, V> hashBiMap = View.this.a;
                    this.expectedModCount = hashBiMap.d;
                    this.remaining = hashBiMap.c;
                }

                private void checkForComodification() {
                    if (View.this.a.d != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    checkForComodification();
                    return this.index != -2 && this.remaining > 0;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    T t = (T) View.this.a(this.index);
                    this.indexToRemove = this.index;
                    this.index = ((HashBiMap) View.this.a).nextInInsertionOrder[this.index];
                    this.remaining--;
                    return t;
                }

                @Override // java.util.Iterator
                public void remove() {
                    checkForComodification();
                    CollectPreconditions.a(this.indexToRemove != -1);
                    View.this.a.b(this.indexToRemove);
                    if (this.index == View.this.a.c) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = View.this.a.d;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.c;
        }
    }

    private HashBiMap(int i) {
        a(i);
    }

    private int bucket(int i) {
        return i & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private static int[] createFilledWithAbsent(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketKToV[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.a[i]);
            }
            if (i3 == i) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.nextInBucketKToV[i3];
        }
    }

    private void deleteFromTableVToK(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketVToK[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.b[i]);
            }
            if (i3 == i) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.nextInBucketVToK[i3];
        }
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i) {
            int a = ImmutableCollection.Builder.a(iArr.length, i);
            this.a = (K[]) Arrays.copyOf(this.a, a);
            this.b = (V[]) Arrays.copyOf(this.b, a);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, a);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, a);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, a);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, a);
        }
        if (this.hashTableKToV.length < i) {
            int a2 = Hashing.a(i, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a2);
            this.hashTableVToK = createFilledWithAbsent(a2);
            for (int i2 = 0; i2 < this.c; i2++) {
                int bucket = bucket(Hashing.a(this.a[i2]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i2] = iArr3[bucket];
                iArr3[bucket] = i2;
                int bucket2 = bucket(Hashing.a(this.b[i2]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i2] = iArr5[bucket2];
                iArr5[bucket2] = i2;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void insertIntoTableVToK(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void moveEntryToIndex(int i, int i2) {
        int i3;
        int i4;
        if (i == i2) {
            return;
        }
        int i5 = this.prevInInsertionOrder[i];
        int i6 = this.nextInInsertionOrder[i];
        setSucceeds(i5, i2);
        setSucceeds(i2, i6);
        K[] kArr = this.a;
        K k = kArr[i];
        V[] vArr = this.b;
        V v = vArr[i];
        kArr[i2] = k;
        vArr[i2] = v;
        int bucket = bucket(Hashing.a(k));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            iArr[bucket] = i2;
        } else {
            int i7 = iArr[bucket];
            int i8 = this.nextInBucketKToV[i7];
            while (true) {
                int i9 = i8;
                i3 = i7;
                i7 = i9;
                if (i7 == i) {
                    break;
                } else {
                    i8 = this.nextInBucketKToV[i7];
                }
            }
            this.nextInBucketKToV[i3] = i2;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i2] = iArr2[i];
        iArr2[i] = -1;
        int bucket2 = bucket(Hashing.a(v));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i) {
            iArr3[bucket2] = i2;
        } else {
            int i10 = iArr3[bucket2];
            int i11 = this.nextInBucketVToK[i10];
            while (true) {
                int i12 = i11;
                i4 = i10;
                i10 = i12;
                if (i10 == i) {
                    break;
                } else {
                    i11 = this.nextInBucketVToK[i10];
                }
            }
            this.nextInBucketVToK[i4] = i2;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i2] = iArr4[i];
        iArr4[i] = -1;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = Serialization.a(objectInputStream);
        a(16);
        Serialization.a(this, objectInputStream, a);
    }

    private void removeEntry(int i, int i2, int i3) {
        Preconditions.checkArgument(i != -1);
        deleteFromTableKToV(i, i2);
        deleteFromTableVToK(i, i3);
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        moveEntryToIndex(this.c - 1, i);
        K[] kArr = this.a;
        int i4 = this.c;
        kArr[i4 - 1] = null;
        this.b[i4 - 1] = null;
        this.c = i4 - 1;
        this.d++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i, @NullableDecl K k, boolean z) {
        int i2;
        int i3;
        Preconditions.checkArgument(i != -1);
        int a = Hashing.a(k);
        int a2 = a(k, a);
        int i4 = this.lastInInsertionOrder;
        if (a2 == -1) {
            i2 = i4;
            i3 = -2;
        } else {
            if (!z) {
                throw new IllegalArgumentException("Key already present in map: " + k);
            }
            i2 = this.prevInInsertionOrder[a2];
            i3 = this.nextInInsertionOrder[a2];
            a(a2, a);
            if (i == this.c) {
                i = a2;
            }
        }
        if (i2 == i) {
            i2 = this.prevInInsertionOrder[i];
        } else if (i2 == this.c) {
            i2 = a2;
        }
        if (i3 == i) {
            a2 = this.nextInInsertionOrder[i];
        } else if (i3 != this.c) {
            a2 = i3;
        }
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        deleteFromTableKToV(i, Hashing.a(this.a[i]));
        this.a[i] = k;
        insertIntoTableKToV(i, Hashing.a(k));
        setSucceeds(i2, i);
        setSucceeds(i, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i, @NullableDecl V v, boolean z) {
        Preconditions.checkArgument(i != -1);
        int a = Hashing.a(v);
        int b = b(v, a);
        if (b != -1) {
            if (!z) {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
            b(b, a);
            if (i == this.c) {
                i = b;
            }
        }
        deleteFromTableVToK(i, Hashing.a(this.b[i]));
        this.b[i] = v;
        insertIntoTableVToK(i, a);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstInInsertionOrder = i2;
        } else {
            this.nextInInsertionOrder[i] = i2;
        }
        if (i2 == -2) {
            this.lastInInsertionOrder = i;
        } else {
            this.prevInInsertionOrder[i2] = i;
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.a(this, objectOutputStream);
    }

    int a(@NullableDecl Object obj) {
        return a(obj, Hashing.a(obj));
    }

    int a(@NullableDecl Object obj, int i) {
        return a(obj, i, this.hashTableKToV, this.nextInBucketKToV, this.a);
    }

    int a(@NullableDecl Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[bucket(i)];
        while (i2 != -1) {
            if (Objects.equal(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    @NullableDecl
    V a(@NullableDecl K k, @NullableDecl V v, boolean z) {
        int a = Hashing.a(k);
        int a2 = a(k, a);
        if (a2 != -1) {
            V v2 = this.b[a2];
            if (Objects.equal(v2, v)) {
                return v;
            }
            replaceValueInEntry(a2, v, z);
            return v2;
        }
        int a3 = Hashing.a(v);
        int b = b(v, a3);
        if (!z) {
            Preconditions.checkArgument(b == -1, "Value already present: %s", v);
        } else if (b != -1) {
            b(b, a3);
        }
        ensureCapacity(this.c + 1);
        K[] kArr = this.a;
        int i = this.c;
        kArr[i] = k;
        this.b[i] = v;
        insertIntoTableKToV(i, a);
        insertIntoTableVToK(this.c, a3);
        setSucceeds(this.lastInInsertionOrder, this.c);
        setSucceeds(this.c, -2);
        this.c++;
        this.d++;
        return null;
    }

    void a(int i) {
        CollectPreconditions.a(i, "expectedSize");
        int a = Hashing.a(i, 1.0d);
        this.c = 0;
        this.a = (K[]) new Object[i];
        this.b = (V[]) new Object[i];
        this.hashTableKToV = createFilledWithAbsent(a);
        this.hashTableVToK = createFilledWithAbsent(a);
        this.nextInBucketKToV = createFilledWithAbsent(i);
        this.nextInBucketVToK = createFilledWithAbsent(i);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i);
        this.nextInInsertionOrder = createFilledWithAbsent(i);
    }

    void a(int i, int i2) {
        removeEntry(i, i2, Hashing.a(this.b[i]));
    }

    int b(@NullableDecl Object obj) {
        return b(obj, Hashing.a(obj));
    }

    int b(@NullableDecl Object obj, int i) {
        return a(obj, i, this.hashTableVToK, this.nextInBucketVToK, this.b);
    }

    @NullableDecl
    K b(@NullableDecl V v, @NullableDecl K k, boolean z) {
        int a = Hashing.a(v);
        int b = b(v, a);
        if (b != -1) {
            K k2 = this.a[b];
            if (Objects.equal(k2, k)) {
                return k;
            }
            replaceKeyInEntry(b, k, z);
            return k2;
        }
        int i = this.lastInInsertionOrder;
        int a2 = Hashing.a(k);
        int a3 = a(k, a2);
        if (!z) {
            Preconditions.checkArgument(a3 == -1, "Key already present: %s", k);
        } else if (a3 != -1) {
            i = this.prevInInsertionOrder[a3];
            a(a3, a2);
        }
        ensureCapacity(this.c + 1);
        K[] kArr = this.a;
        int i2 = this.c;
        kArr[i2] = k;
        this.b[i2] = v;
        insertIntoTableKToV(i2, a2);
        insertIntoTableVToK(this.c, a);
        int i3 = i == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i];
        setSucceeds(i, this.c);
        setSucceeds(this.c, i3);
        this.c++;
        this.d++;
        return null;
    }

    void b(int i) {
        a(i, Hashing.a(this.a[i]));
    }

    void b(int i, int i2) {
        removeEntry(i, Hashing.a(this.a[i]), i2);
    }

    @NullableDecl
    K c(@NullableDecl Object obj) {
        int b = b(obj);
        if (b == -1) {
            return null;
        }
        return this.a[b];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.c, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.c, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.c, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.c, -1);
        this.c = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return a(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return b(obj) != -1;
    }

    @NullableDecl
    K d(@NullableDecl Object obj) {
        int a = Hashing.a(obj);
        int b = b(obj, a);
        if (b == -1) {
            return null;
        }
        K k = this.a[b];
        b(b, a);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @NullableDecl
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return a(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int a = a(obj);
        if (a == -1) {
            return null;
        }
        return this.b[a];
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return a(k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        int a = Hashing.a(obj);
        int a2 = a(obj, a);
        if (a2 == -1) {
            return null;
        }
        V v = this.b[a2];
        a(a2, a);
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.valueSet = valueSet;
        return valueSet;
    }
}
