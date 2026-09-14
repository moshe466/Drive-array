package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p7 extends x5<Integer> implements s7, j9, RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    private static final p7 f5533i;

    /* renamed from: g, reason: collision with root package name */
    private int[] f5534g;

    /* renamed from: h, reason: collision with root package name */
    private int f5535h;

    static {
        p7 p7Var = new p7(new int[0], 0);
        f5533i = p7Var;
        p7Var.n();
    }

    p7() {
        this(new int[10], 0);
    }

    private p7(int[] iArr, int i10) {
        this.f5534g = iArr;
        this.f5535h = i10;
    }

    public static p7 g() {
        return f5533i;
    }

    private final void l(int i10) {
        if (i10 < 0 || i10 >= this.f5535h) {
            throw new IndexOutOfBoundsException(s(i10));
        }
    }

    private final String s(int i10) {
        int i11 = this.f5535h;
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
        int intValue = ((Integer) obj).intValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f5535h)) {
            throw new IndexOutOfBoundsException(s(i10));
        }
        int[] iArr = this.f5534g;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i11 - i10);
        } else {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f5534g, i10, iArr2, i10 + 1, this.f5535h - i10);
            this.f5534g = iArr2;
        }
        this.f5534g[i10] = intValue;
        this.f5535h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        j(((Integer) obj).intValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        o7.d(collection);
        if (!(collection instanceof p7)) {
            return super.addAll(collection);
        }
        p7 p7Var = (p7) collection;
        int i10 = p7Var.f5535h;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5535h;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f5534g;
        if (i12 > iArr.length) {
            this.f5534g = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(p7Var.f5534g, 0, this.f5534g, this.f5535h, p7Var.f5535h);
        this.f5535h = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.u7
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final s7 b(int i10) {
        if (i10 >= this.f5535h) {
            return new p7(Arrays.copyOf(this.f5534g, i10), this.f5535h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p7)) {
            return super.equals(obj);
        }
        p7 p7Var = (p7) obj;
        if (this.f5535h != p7Var.f5535h) {
            return false;
        }
        int[] iArr = p7Var.f5534g;
        for (int i10 = 0; i10 < this.f5535h; i10++) {
            if (this.f5534g[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i10) {
        l(i10);
        return this.f5534g[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Integer.valueOf(f(i10));
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5535h; i11++) {
            i10 = (i10 * 31) + this.f5534g[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f5534g[i10] == intValue) {
                return i10;
            }
        }
        return -1;
    }

    public final void j(int i10) {
        c();
        int i11 = this.f5535h;
        int[] iArr = this.f5534g;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f5534g = iArr2;
        }
        int[] iArr3 = this.f5534g;
        int i12 = this.f5535h;
        this.f5535h = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        c();
        l(i10);
        int[] iArr = this.f5534g;
        int i11 = iArr[i10];
        if (i10 < this.f5535h - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f5535h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f5534g;
        System.arraycopy(iArr, i11, iArr, i10, this.f5535h - i11);
        this.f5535h -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        l(i10);
        int[] iArr = this.f5534g;
        int i11 = iArr[i10];
        iArr[i10] = intValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5535h;
    }
}
