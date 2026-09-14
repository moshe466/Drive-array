package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzdss extends zzdqe<Long> implements zzdsb<Long>, zzdtq, RandomAccess {
    private static final zzdss zzhon;
    private int size;
    private long[] zzhoo;

    static {
        zzdss zzdssVar = new zzdss(new long[0], 0);
        zzhon = zzdssVar;
        zzdssVar.zzaxq();
    }

    zzdss() {
        this(new long[10], 0);
    }

    private zzdss(long[] jArr, int i) {
        this.zzhoo = jArr;
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
        long longValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfc(i));
        }
        long[] jArr = this.zzhoo;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzhoo, i, jArr2, i + 1, this.size - i);
            this.zzhoo = jArr2;
        }
        this.zzhoo[i] = longValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzfr(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        zzdrv.a(collection);
        if (!(collection instanceof zzdss)) {
            return super.addAll(collection);
        }
        zzdss zzdssVar = (zzdss) collection;
        int i = zzdssVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.zzhoo;
        if (i3 > jArr.length) {
            this.zzhoo = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(zzdssVar.zzhoo, 0, this.zzhoo, this.size, zzdssVar.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdss)) {
            return super.equals(obj);
        }
        zzdss zzdssVar = (zzdss) obj;
        if (this.size != zzdssVar.size) {
            return false;
        }
        long[] jArr = zzdssVar.zzhoo;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhoo[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzfb(i);
        return this.zzhoo[i];
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdrv.zzfq(this.zzhoo[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        zzfb(i);
        long[] jArr = this.zzhoo;
        long j = jArr[i];
        if (i < this.size - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzhoo[i]))) {
                long[] jArr = this.zzhoo;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
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
        long[] jArr = this.zzhoo;
        System.arraycopy(jArr, i2, jArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        a();
        zzfb(i);
        long[] jArr = this.zzhoo;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdsb
    public final /* synthetic */ zzdsb<Long> zzfd(int i) {
        if (i >= this.size) {
            return new zzdss(Arrays.copyOf(this.zzhoo, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzfr(long j) {
        a();
        int i = this.size;
        long[] jArr = this.zzhoo;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzhoo = jArr2;
        }
        long[] jArr3 = this.zzhoo;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }
}
