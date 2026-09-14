package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzot extends zzkr implements RandomAccess {
    private static final Object[] zza;
    private static final zzot zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzot(objArr, 0, false);
    }

    public zzot() {
        this(zza, 0, true);
    }

    public static zzot zze() {
        return zzb;
    }

    private static int zzg(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzh(int i) {
        return AbstractC0008a.k("Index:", i, this.zzd, ", Size:");
    }

    private final void zzi(int i) {
        if (i >= 0 && i < this.zzd) {
        } else {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        zza();
        if (i >= 0 && i <= (i3 = this.zzd)) {
            int i4 = i + 1;
            Object[] objArr = this.zzc;
            int length = objArr.length;
            if (i3 < length) {
                System.arraycopy(objArr, i, objArr, i4, i3 - i);
            } else {
                Object[] objArr2 = new Object[zzg(length)];
                System.arraycopy(this.zzc, 0, objArr2, 0, i);
                System.arraycopy(this.zzc, i, objArr2, i4, this.zzd - i);
                this.zzc = objArr2;
            }
            this.zzc[i] = obj;
            this.zzd++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzh(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zzi(i);
        return this.zzc[i];
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zza();
        zzi(i);
        Object[] objArr = this.zzc;
        Object obj = objArr[i];
        if (i < this.zzd - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zza();
        zzi(i);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.recaptcha.internal.zznk
    public final /* bridge */ /* synthetic */ zznk zzd(int i) {
        Object[] copyOf;
        if (i >= this.zzd) {
            if (i == 0) {
                copyOf = zza;
            } else {
                copyOf = Arrays.copyOf(this.zzc, i);
            }
            return new zzot(copyOf, this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(int i) {
        int length = this.zzc.length;
        if (i <= length) {
            return;
        }
        if (length != 0) {
            while (length < i) {
                length = zzg(length);
            }
            this.zzc = Arrays.copyOf(this.zzc, length);
            return;
        }
        this.zzc = new Object[Math.max(i, 10)];
    }

    private zzot(Object[] objArr, int i, boolean z3) {
        super(z3);
        this.zzc = objArr;
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i = this.zzd;
        int length = this.zzc.length;
        if (i == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzg(length));
        }
        Object[] objArr = this.zzc;
        int i3 = this.zzd;
        this.zzd = i3 + 1;
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
