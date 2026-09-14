package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l8 extends x5<Long> implements v7, j9, RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    private static final l8 f5456i;

    /* renamed from: g, reason: collision with root package name */
    private long[] f5457g;

    /* renamed from: h, reason: collision with root package name */
    private int f5458h;

    static {
        l8 l8Var = new l8(new long[0], 0);
        f5456i = l8Var;
        l8Var.n();
    }

    l8() {
        this(new long[10], 0);
    }

    private l8(long[] jArr, int i10) {
        this.f5457g = jArr;
        this.f5458h = i10;
    }

    public static l8 g() {
        return f5456i;
    }

    private final void j(int i10) {
        if (i10 < 0 || i10 >= this.f5458h) {
            throw new IndexOutOfBoundsException(l(i10));
        }
    }

    private final String l(int i10) {
        int i11 = this.f5458h;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long longValue = ((Long) obj).longValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f5458h)) {
            throw new IndexOutOfBoundsException(l(i10));
        }
        long[] jArr = this.f5457g;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f5457g, i10, jArr2, i10 + 1, this.f5458h - i10);
            this.f5457g = jArr2;
        }
        this.f5457g[i10] = longValue;
        this.f5458h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        o7.d(collection);
        if (!(collection instanceof l8)) {
            return super.addAll(collection);
        }
        l8 l8Var = (l8) collection;
        int i10 = l8Var.f5458h;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5458h;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f5457g;
        if (i12 > jArr.length) {
            this.f5457g = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(l8Var.f5457g, 0, this.f5457g, this.f5458h, l8Var.f5458h);
        this.f5458h = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.v7
    public final long d(int i10) {
        j(i10);
        return this.f5457g[i10];
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l8)) {
            return super.equals(obj);
        }
        l8 l8Var = (l8) obj;
        if (this.f5458h != l8Var.f5458h) {
            return false;
        }
        long[] jArr = l8Var.f5457g;
        for (int i10 = 0; i10 < this.f5458h; i10++) {
            if (this.f5457g[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(long j10) {
        c();
        int i10 = this.f5458h;
        long[] jArr = this.f5457g;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f5457g = jArr2;
        }
        long[] jArr3 = this.f5457g;
        int i11 = this.f5458h;
        this.f5458h = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Long.valueOf(d(i10));
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5458h; i11++) {
            i10 = (i10 * 31) + o7.b(this.f5457g[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f5457g[i10] == longValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.u7
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final v7 b(int i10) {
        if (i10 >= this.f5458h) {
            return new l8(Arrays.copyOf(this.f5457g, i10), this.f5458h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        c();
        j(i10);
        long[] jArr = this.f5457g;
        long j10 = jArr[i10];
        if (i10 < this.f5458h - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f5458h--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f5457g;
        System.arraycopy(jArr, i11, jArr, i10, this.f5458h - i11);
        this.f5458h -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        j(i10);
        long[] jArr = this.f5457g;
        long j10 = jArr[i10];
        jArr[i10] = longValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5458h;
    }
}
