package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
final class k7 extends x5<Float> implements u7<Float>, j9 {

    /* renamed from: g, reason: collision with root package name */
    private float[] f5426g;

    /* renamed from: h, reason: collision with root package name */
    private int f5427h;

    static {
        new k7(new float[0], 0).n();
    }

    k7() {
        this(new float[10], 0);
    }

    private k7(float[] fArr, int i10) {
        this.f5426g = fArr;
        this.f5427h = i10;
    }

    private final void g(int i10) {
        if (i10 < 0 || i10 >= this.f5427h) {
            throw new IndexOutOfBoundsException(j(i10));
        }
    }

    private final String j(int i10) {
        int i11 = this.f5427h;
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
        float floatValue = ((Float) obj).floatValue();
        c();
        if (i10 < 0 || i10 > (i11 = this.f5427h)) {
            throw new IndexOutOfBoundsException(j(i10));
        }
        float[] fArr = this.f5426g;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f5426g, i10, fArr2, i10 + 1, this.f5427h - i10);
            this.f5426g = fArr2;
        }
        this.f5426g[i10] = floatValue;
        this.f5427h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Float) obj).floatValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        o7.d(collection);
        if (!(collection instanceof k7)) {
            return super.addAll(collection);
        }
        k7 k7Var = (k7) collection;
        int i10 = k7Var.f5427h;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5427h;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.f5426g;
        if (i12 > fArr.length) {
            this.f5426g = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(k7Var.f5426g, 0, this.f5426g, this.f5427h, k7Var.f5427h);
        this.f5427h = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.u7
    public final /* synthetic */ u7<Float> b(int i10) {
        if (i10 >= this.f5427h) {
            return new k7(Arrays.copyOf(this.f5426g, i10), this.f5427h);
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
        if (!(obj instanceof k7)) {
            return super.equals(obj);
        }
        k7 k7Var = (k7) obj;
        if (this.f5427h != k7Var.f5427h) {
            return false;
        }
        float[] fArr = k7Var.f5426g;
        for (int i10 = 0; i10 < this.f5427h; i10++) {
            if (Float.floatToIntBits(this.f5426g[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final void f(float f10) {
        c();
        int i10 = this.f5427h;
        float[] fArr = this.f5426g;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f5426g = fArr2;
        }
        float[] fArr3 = this.f5426g;
        int i11 = this.f5427h;
        this.f5427h = i11 + 1;
        fArr3[i11] = f10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Float.valueOf(this.f5426g[i10]);
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5427h; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f5426g[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f5426g[i10] == floatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        c();
        g(i10);
        float[] fArr = this.f5426g;
        float f10 = fArr[i10];
        if (i10 < this.f5427h - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.f5427h--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        c();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f5426g;
        System.arraycopy(fArr, i11, fArr, i10, this.f5427h - i11);
        this.f5427h -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        g(i10);
        float[] fArr = this.f5426g;
        float f10 = fArr[i10];
        fArr[i10] = floatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5427h;
    }
}
