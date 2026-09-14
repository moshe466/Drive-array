package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzdrs extends zzdqe<Float> implements zzdsb<Float>, zzdtq, RandomAccess {
    private static final zzdrs zzhmi;
    private int size;
    private float[] zzhmj;

    static {
        zzdrs zzdrsVar = new zzdrs(new float[0], 0);
        zzhmi = zzdrsVar;
        zzdrsVar.zzaxq();
    }

    zzdrs() {
        this(new float[10], 0);
    }

    private zzdrs(float[] fArr, int i) {
        this.zzhmj = fArr;
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
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfc(i));
        }
        float[] fArr = this.zzhmj;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzhmj, i, fArr2, i + 1, this.size - i);
            this.zzhmj = fArr2;
        }
        this.zzhmj[i] = floatValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        a();
        zzdrv.a(collection);
        if (!(collection instanceof zzdrs)) {
            return super.addAll(collection);
        }
        zzdrs zzdrsVar = (zzdrs) collection;
        int i = zzdrsVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.zzhmj;
        if (i3 > fArr.length) {
            this.zzhmj = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(zzdrsVar.zzhmj, 0, this.zzhmj, this.size, zzdrsVar.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdrs)) {
            return super.equals(obj);
        }
        zzdrs zzdrsVar = (zzdrs) obj;
        if (this.size != zzdrsVar.size) {
            return false;
        }
        float[] fArr = zzdrsVar.zzhmj;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzhmj[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzfb(i);
        return Float.valueOf(this.zzhmj[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzhmj[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        zzfb(i);
        float[] fArr = this.zzhmj;
        float f = fArr[i];
        if (i < this.size - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzhmj[i]))) {
                float[] fArr = this.zzhmj;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
        float[] fArr = this.zzhmj;
        System.arraycopy(fArr, i2, fArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        a();
        zzfb(i);
        float[] fArr = this.zzhmj;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdsb
    public final /* synthetic */ zzdsb<Float> zzfd(int i) {
        if (i >= this.size) {
            return new zzdrs(Arrays.copyOf(this.zzhmj, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(float f) {
        a();
        int i = this.size;
        float[] fArr = this.zzhmj;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzhmj = fArr2;
        }
        float[] fArr3 = this.zzhmj;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }
}
