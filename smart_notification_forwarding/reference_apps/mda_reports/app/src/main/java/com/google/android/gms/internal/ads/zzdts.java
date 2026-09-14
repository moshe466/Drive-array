package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzdts<E> extends zzdqe<E> implements RandomAccess {
    private static final zzdts<Object> zzhpt;
    private int size;
    private E[] zzguu;

    static {
        zzdts<Object> zzdtsVar = new zzdts<>(new Object[0], 0);
        zzhpt = zzdtsVar;
        zzdtsVar.zzaxq();
    }

    zzdts() {
        this(new Object[10], 0);
    }

    private zzdts(E[] eArr, int i) {
        this.zzguu = eArr;
        this.size = i;
    }

    public static <E> zzdts<E> zzbbp() {
        return (zzdts<E>) zzhpt;
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
    public final void add(int i, E e) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfc(i));
        }
        E[] eArr = this.zzguu;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzguu, i, eArr2, i + 1, this.size - i);
            this.zzguu = eArr2;
        }
        this.zzguu[i] = e;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        a();
        int i = this.size;
        E[] eArr = this.zzguu;
        if (i == eArr.length) {
            this.zzguu = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzguu;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzfb(i);
        return this.zzguu[i];
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        a();
        zzfb(i);
        E[] eArr = this.zzguu;
        E e = eArr[i];
        if (i < this.size - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        a();
        zzfb(i);
        E[] eArr = this.zzguu;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdsb
    public final /* synthetic */ zzdsb zzfd(int i) {
        if (i >= this.size) {
            return new zzdts(Arrays.copyOf(this.zzguu, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
