package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: classes2.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;

    @MonotonicNonNullDecl
    transient Object[] a;
    transient float b;
    transient int c;

    @MonotonicNonNullDecl
    private transient long[] entries;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet() {
        a(3, DEFAULT_LOAD_FACTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet(int i) {
        a(i, DEFAULT_LOAD_FACTOR);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i) {
        return new CompactHashSet<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
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
        a(3, DEFAULT_LOAD_FACTOR);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            } else {
                add(objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && Objects.equal(obj, this.a[i2])) {
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                b(i2);
                this.size--;
                this.c++;
                return true;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return false;
            }
            i3 = i2;
            i2 = next;
        }
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                c(max);
            }
        }
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.b)) + 1;
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
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
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    int a() {
        return isEmpty() ? -1 : 0;
    }

    int a(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    int a(int i, int i2) {
        return i - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f > 0.0f, "Illegal load factor");
        int a = Hashing.a(i, f);
        this.table = newTable(a);
        this.b = f;
        this.a = new Object[i];
        this.entries = newEntries(i);
        this.threshold = Math.max(1, (int) (a * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, E e, int i2) {
        this.entries[i] = (i2 << 32) | NEXT_MASK;
        this.a[i] = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e) {
        long[] jArr = this.entries;
        Object[] objArr = this.a;
        int a = Hashing.a(e);
        int hashTableMask = hashTableMask() & a;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == a && Objects.equal(e, objArr[i2])) {
                    return false;
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
        a(i, (int) e, a);
        this.size = i3;
        if (i >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.c++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.a[i] = null;
            this.entries[i] = -1;
            return;
        }
        Object[] objArr = this.a;
        objArr[i] = objArr[size];
        objArr[size] = null;
        long[] jArr = this.entries;
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
            long j2 = this.entries[i2];
            int next = getNext(j2);
            if (next == size) {
                this.entries[i2] = swapNext(j2, i);
                return;
            }
            i2 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.a = Arrays.copyOf(this.a, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.c++;
        Arrays.fill(this.a, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        int a = Hashing.a(obj);
        int i = this.table[hashTableMask() & a];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == a && Objects.equal(obj, this.a[i])) {
                return true;
            }
            i = getNext(j);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: com.google.common.collect.CompactHashSet.1
            int a;
            int b;
            int c;

            {
                CompactHashSet compactHashSet = CompactHashSet.this;
                this.a = compactHashSet.c;
                this.b = compactHashSet.a();
                this.c = -1;
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.c != this.a) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b >= 0;
            }

            @Override // java.util.Iterator
            public E next() {
                checkForConcurrentModification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.b;
                this.c = i;
                CompactHashSet compactHashSet = CompactHashSet.this;
                E e = (E) compactHashSet.a[i];
                this.b = compactHashSet.a(i);
                return e;
            }

            @Override // java.util.Iterator
            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.a(this.c >= 0);
                this.a++;
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.a[this.c], CompactHashSet.getHash(compactHashSet.entries[this.c]));
                this.b = CompactHashSet.this.a(this.b, this.c);
                this.c = -1;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.a(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.a, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.a(this.a, 0, this.size, tArr);
    }

    public void trimToSize() {
        int i = this.size;
        if (i < this.entries.length) {
            c(i);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i / this.b)));
        if (max < 1073741824) {
            double d = i;
            double d2 = max;
            Double.isNaN(d);
            Double.isNaN(d2);
            if (d / d2 > this.b) {
                max <<= 1;
            }
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }
}
