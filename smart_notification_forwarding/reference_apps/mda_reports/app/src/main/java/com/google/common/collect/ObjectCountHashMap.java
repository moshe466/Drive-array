package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public class ObjectCountHashMap<K> {
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    transient Object[] a;
    transient int[] b;
    transient int c;
    transient int d;

    @VisibleForTesting
    transient long[] e;
    private transient float loadFactor;
    private transient int[] table;
    private transient int threshold;

    /* loaded from: classes2.dex */
    class MapEntry extends Multisets.AbstractEntry<K> {

        @NullableDecl
        final K a;
        int b;

        MapEntry(int i) {
            this.a = (K) ObjectCountHashMap.this.a[i];
            this.b = i;
        }

        void a() {
            int i = this.b;
            if (i == -1 || i >= ObjectCountHashMap.this.b() || !Objects.equal(this.a, ObjectCountHashMap.this.a[this.b])) {
                this.b = ObjectCountHashMap.this.a(this.a);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            a();
            int i = this.b;
            if (i == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.b[i];
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.a;
        }

        @CanIgnoreReturnValue
        public int setCount(int i) {
            a();
            int i2 = this.b;
            if (i2 == -1) {
                ObjectCountHashMap.this.put(this.a, i);
                return 0;
            }
            int[] iArr = ObjectCountHashMap.this.b;
            int i3 = iArr[i2];
            iArr[i2] = i;
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap() {
        a(3, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(int i) {
        this(i, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(int i, float f) {
        a(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        a(objectCountHashMap.b(), 1.0f);
        int a = objectCountHashMap.a();
        while (a != -1) {
            put(objectCountHashMap.c(a), objectCountHashMap.d(a));
            a = objectCountHashMap.f(a);
        }
    }

    public static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap<>();
    }

    public static <K> ObjectCountHashMap<K> createWithExpectedSize(int i) {
        return new ObjectCountHashMap<>(i);
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

    private int remove(@NullableDecl Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.e[i2]) == i && Objects.equal(obj, this.a[i2])) {
                int i4 = this.b[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.e[i2]);
                } else {
                    long[] jArr = this.e;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                e(i2);
                this.c--;
                this.d++;
                return i4;
            }
            int next = getNext(this.e[i2]);
            if (next == -1) {
                return 0;
            }
            i3 = i2;
            i2 = next;
        }
    }

    private void resizeMeMaybe(int i) {
        int length = this.e.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                h(max);
            }
        }
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.loadFactor)) + 1;
        int[] newTable = newTable(i);
        long[] jArr = this.e;
        int length = newTable.length - 1;
        for (int i3 = 0; i3 < this.c; i3++) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.c == 0 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2) {
        return i - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(@NullableDecl Object obj) {
        int a = Hashing.a(obj);
        int i = this.table[hashTableMask() & a];
        while (i != -1) {
            long j = this.e[i];
            if (getHash(j) == a && Objects.equal(obj, this.a[i])) {
                return i;
            }
            i = getNext(j);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (i > this.e.length) {
            h(i);
        }
        if (i >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f > 0.0f, "Illegal load factor");
        int a = Hashing.a(i, f);
        this.table = newTable(a);
        this.loadFactor = f;
        this.a = new Object[i];
        this.b = new int[i];
        this.e = newEntries(i);
        this.threshold = Math.max(1, (int) (a * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, @NullableDecl K k, int i2, int i3) {
        this.e[i] = (i3 << 32) | NEXT_MASK;
        this.a[i] = k;
        this.b[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Multiset.Entry<K> b(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return new MapEntry(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2) {
        Preconditions.checkElementIndex(i, this.c);
        this.b[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public K c(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return (K) this.a[i];
    }

    public void clear() {
        this.d++;
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.e, -1L);
        this.c = 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return a(obj) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return this.b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int b = b() - 1;
        if (i >= b) {
            this.a[i] = null;
            this.b[i] = 0;
            this.e[i] = -1;
            return;
        }
        Object[] objArr = this.a;
        objArr[i] = objArr[b];
        int[] iArr = this.b;
        iArr[i] = iArr[b];
        objArr[b] = null;
        iArr[b] = 0;
        long[] jArr = this.e;
        long j = jArr[b];
        jArr[i] = j;
        jArr[b] = -1;
        int hash = getHash(j) & hashTableMask();
        int[] iArr2 = this.table;
        int i2 = iArr2[hash];
        if (i2 == b) {
            iArr2[hash] = i;
            return;
        }
        while (true) {
            long j2 = this.e[i2];
            int next = getNext(j2);
            if (next == b) {
                this.e[i2] = swapNext(j2, i);
                return;
            }
            i2 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int g(int i) {
        return remove(this.a[i], getHash(this.e[i]));
    }

    public int get(@NullableDecl Object obj) {
        int a = a(obj);
        if (a == -1) {
            return 0;
        }
        return this.b[a];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.e;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.e = copyOf;
    }

    @CanIgnoreReturnValue
    public int put(@NullableDecl K k, int i) {
        CollectPreconditions.b(i, "count");
        long[] jArr = this.e;
        Object[] objArr = this.a;
        int[] iArr = this.b;
        int a = Hashing.a(k);
        int hashTableMask = hashTableMask() & a;
        int i2 = this.c;
        int[] iArr2 = this.table;
        int i3 = iArr2[hashTableMask];
        if (i3 == -1) {
            iArr2[hashTableMask] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (getHash(j) == a && Objects.equal(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i3] = swapNext(j, i2);
                    break;
                }
                i3 = next;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i2 + 1;
        resizeMeMaybe(i5);
        a(i2, k, i, a);
        this.c = i5;
        if (i2 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.d++;
        return 0;
    }

    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.a(obj));
    }
}
