package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
final class b6 extends x5<Boolean> implements u7<Boolean>, j9 {

    /* renamed from: g, reason: collision with root package name */
    private boolean[] f5192g;

    /* renamed from: h, reason: collision with root package name */
    private int f5193h;

    static {
        new b6(new boolean[0], 0).n();
    }

    b6() {
        this(new boolean[10], 0);
    }

    private b6(boolean[] zArr, int i10) {
        this.f5192g = zArr;
        this.f5193h = i10;
    }

    private final void g(int i10) {
        if (i10 < 0 || i10 >= this.f5193h) {
            throw new IndexOutOfBoundsException(j(i10));
        }
    }

    private final String j(int i10) {
        int i11 = this.f5193h;
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f5193h)) {
            throw new IndexOutOfBoundsException(j(i10));
        }
        boolean[] zArr = this.f5192g;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f5192g, i10, zArr2, i10 + 1, this.f5193h - i10);
            this.f5192g = zArr2;
        }
        this.f5192g[i10] = booleanValue;
        this.f5193h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        o7.d(collection);
        if (!(collection instanceof b6)) {
            return super.addAll(collection);
        }
        b6 b6Var = (b6) collection;
        int i10 = b6Var.f5193h;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5193h;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.f5192g;
        if (i12 > zArr.length) {
            this.f5192g = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(b6Var.f5192g, 0, this.f5192g, this.f5193h, b6Var.f5193h);
        this.f5193h = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.u7
    public final /* synthetic */ u7<Boolean> b(int i10) {
        if (i10 >= this.f5193h) {
            return new b6(Arrays.copyOf(this.f5192g, i10), this.f5193h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b6)) {
            return super.equals(obj);
        }
        b6 b6Var = (b6) obj;
        if (this.f5193h != b6Var.f5193h) {
            return false;
        }
        boolean[] zArr = b6Var.f5192g;
        for (int i10 = 0; i10 < this.f5193h; i10++) {
            if (this.f5192g[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(boolean z10) {
        c();
        int i10 = this.f5193h;
        boolean[] zArr = this.f5192g;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f5192g = zArr2;
        }
        boolean[] zArr3 = this.f5192g;
        int i11 = this.f5193h;
        this.f5193h = i11 + 1;
        zArr3[i11] = z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Boolean.valueOf(this.f5192g[i10]);
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5193h; i11++) {
            i10 = (i10 * 31) + o7.c(this.f5192g[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f5192g[i10] == booleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        c();
        g(i10);
        boolean[] zArr = this.f5192g;
        boolean z10 = zArr[i10];
        if (i10 < this.f5193h - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.f5193h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f5192g;
        System.arraycopy(zArr, i11, zArr, i10, this.f5193h - i11);
        this.f5193h -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        g(i10);
        boolean[] zArr = this.f5192g;
        boolean z10 = zArr[i10];
        zArr[i10] = booleanValue;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5193h;
    }
}
