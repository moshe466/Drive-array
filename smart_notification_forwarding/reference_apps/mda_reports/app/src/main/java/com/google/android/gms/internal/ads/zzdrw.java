package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdrw extends zzdqe<Integer> implements zzdrz, zzdtq, RandomAccess {
    private static final zzdrw zzhnj;
    private int size;
    private int[] zzhnk;

    static {
        zzdrw zzdrwVar = new zzdrw(new int[0], 0);
        zzhnj = zzdrwVar;
        zzdrwVar.zzaxq();
    }

    zzdrw() {
        this(new int[10], 0);
    }

    private zzdrw(int[] iArr, int i) {
        this.zzhnk = iArr;
        this.size = i;
    }

    public static zzdrw zzbai() {
        return zzhnj;
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
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfc(i));
        }
        int[] iArr = this.zzhnk;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzhnk, i, iArr2, i + 1, this.size - i);
            this.zzhnk = iArr2;
        }
        this.zzhnk[i] = intValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzgl(((Integer) obj).intValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        zzdrv.a(collection);
        if (!(collection instanceof zzdrw)) {
            return super.addAll(collection);
        }
        zzdrw zzdrwVar = (zzdrw) collection;
        int i = zzdrwVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.zzhnk;
        if (i3 > iArr.length) {
            this.zzhnk = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(zzdrwVar.zzhnk, 0, this.zzhnk, this.size, zzdrwVar.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdrw)) {
            return super.equals(obj);
        }
        zzdrw zzdrwVar = (zzdrw) obj;
        if (this.size != zzdrwVar.size) {
            return false;
        }
        int[] iArr = zzdrwVar.zzhnk;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhnk[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzfb(i);
        return this.zzhnk[i];
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzhnk[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        zzfb(i);
        int[] iArr = this.zzhnk;
        int i2 = iArr[i];
        if (i < this.size - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzhnk[i]))) {
                int[] iArr = this.zzhnk;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int[] iArr = this.zzhnk;
        System.arraycopy(iArr, i2, iArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        zzfb(i);
        int[] iArr = this.zzhnk;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdsb
    /* renamed from: zzgk, reason: merged with bridge method [inline-methods] */
    public final zzdrz zzfd(int i) {
        if (i >= this.size) {
            return new zzdrw(Arrays.copyOf(this.zzhnk, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final void zzgl(int i) {
        a();
        int i2 = this.size;
        int[] iArr = this.zzhnk;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzhnk = iArr2;
        }
        int[] iArr3 = this.zzhnk;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }
}
