package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzdre extends zzdqe<Double> implements zzdsb<Double>, zzdtq, RandomAccess {
    private static final zzdre zzhje;
    private int size;
    private double[] zzhjf;

    static {
        zzdre zzdreVar = new zzdre(new double[0], 0);
        zzhje = zzdreVar;
        zzdreVar.zzaxq();
    }

    zzdre() {
        this(new double[10], 0);
    }

    private zzdre(double[] dArr, int i) {
        this.zzhjf = dArr;
        this.size = i;
    }

    private final void zzfb(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfc(i));
        }
    }

    private final String zzfc(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        a();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfc(i));
        }
        double[] dArr = this.zzhjf;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzhjf, i, dArr2, i + 1, this.size - i);
            this.zzhjf = dArr2;
        }
        this.zzhjf[i] = doubleValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzd(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        a();
        zzdrv.a(collection);
        if (!(collection instanceof zzdre)) {
            return super.addAll(collection);
        }
        zzdre zzdreVar = (zzdre) collection;
        int i = zzdreVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.zzhjf;
        if (i3 > dArr.length) {
            this.zzhjf = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(zzdreVar.zzhjf, 0, this.zzhjf, this.size, zzdreVar.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdre)) {
            return super.equals(obj);
        }
        zzdre zzdreVar = (zzdre) obj;
        if (this.size != zzdreVar.size) {
            return false;
        }
        double[] dArr = zzdreVar.zzhjf;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzhjf[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzfb(i);
        return Double.valueOf(this.zzhjf[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdrv.zzfq(Double.doubleToLongBits(this.zzhjf[i2]));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        zzfb(i);
        double[] dArr = this.zzhjf;
        double d = dArr[i];
        if (i < this.size - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzhjf[i]))) {
                double[] dArr = this.zzhjf;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzhjf;
        System.arraycopy(dArr, i2, dArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        zzfb(i);
        double[] dArr = this.zzhjf;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        a();
        int i = this.size;
        double[] dArr = this.zzhjf;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzhjf = dArr2;
        }
        double[] dArr3 = this.zzhjf;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // com.google.android.gms.internal.ads.zzdsb
    public final /* synthetic */ zzdsb<Double> zzfd(int i) {
        if (i >= this.size) {
            return new zzdre(Arrays.copyOf(this.zzhjf, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
