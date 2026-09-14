package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
final class w6 extends x5<Double> implements u7<Double>, j9 {

    /* renamed from: g, reason: collision with root package name */
    private double[] f5658g;

    /* renamed from: h, reason: collision with root package name */
    private int f5659h;

    static {
        new w6(new double[0], 0).n();
    }

    w6() {
        this(new double[10], 0);
    }

    private w6(double[] dArr, int i10) {
        this.f5658g = dArr;
        this.f5659h = i10;
    }

    private final void g(int i10) {
        if (i10 < 0 || i10 >= this.f5659h) {
            throw new IndexOutOfBoundsException(j(i10));
        }
    }

    private final String j(int i10) {
        int i11 = this.f5659h;
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
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f5659h)) {
            throw new IndexOutOfBoundsException(j(i10));
        }
        double[] dArr = this.f5658g;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.f5658g, i10, dArr2, i10 + 1, this.f5659h - i10);
            this.f5658g = dArr2;
        }
        this.f5658g[i10] = doubleValue;
        this.f5659h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        o7.d(collection);
        if (!(collection instanceof w6)) {
            return super.addAll(collection);
        }
        w6 w6Var = (w6) collection;
        int i10 = w6Var.f5659h;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5659h;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.f5658g;
        if (i12 > dArr.length) {
            this.f5658g = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy(w6Var.f5658g, 0, this.f5658g, this.f5659h, w6Var.f5659h);
        this.f5659h = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.u7
    public final /* synthetic */ u7<Double> b(int i10) {
        if (i10 >= this.f5659h) {
            return new w6(Arrays.copyOf(this.f5658g, i10), this.f5659h);
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
        if (!(obj instanceof w6)) {
            return super.equals(obj);
        }
        w6 w6Var = (w6) obj;
        if (this.f5659h != w6Var.f5659h) {
            return false;
        }
        double[] dArr = w6Var.f5658g;
        for (int i10 = 0; i10 < this.f5659h; i10++) {
            if (Double.doubleToLongBits(this.f5658g[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final void f(double d10) {
        c();
        int i10 = this.f5659h;
        double[] dArr = this.f5658g;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f5658g = dArr2;
        }
        double[] dArr3 = this.f5658g;
        int i11 = this.f5659h;
        this.f5659h = i11 + 1;
        dArr3[i11] = d10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Double.valueOf(this.f5658g[i10]);
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5659h; i11++) {
            i10 = (i10 * 31) + o7.b(Double.doubleToLongBits(this.f5658g[i11]));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f5658g[i10] == doubleValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        c();
        g(i10);
        double[] dArr = this.f5658g;
        double d10 = dArr[i10];
        if (i10 < this.f5659h - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.f5659h--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f5658g;
        System.arraycopy(dArr, i11, dArr, i10, this.f5659h - i11);
        this.f5659h -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        g(i10);
        double[] dArr = this.f5658g;
        double d10 = dArr[i10];
        dArr[i10] = doubleValue;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5659h;
    }
}
