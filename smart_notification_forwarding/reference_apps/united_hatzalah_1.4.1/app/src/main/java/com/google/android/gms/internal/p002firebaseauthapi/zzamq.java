package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzamq<E> extends zzajj<E> implements RandomAccess {
    private static final Object[] zza;
    private static final zzamq<Object> zzb;
    private E[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzamq<>(objArr, 0, false);
    }

    public zzamq() {
        this(zza, 0, true);
    }

    private static int zzb(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzc(int i) {
        return AbstractC0008a.k("Index:", i, this.zzd, ", Size:");
    }

    public static <E> zzamq<E> zzd() {
        return (zzamq<E>) zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final void add(int i, E e4) {
        int i3;
        zza();
        if (i >= 0 && i <= (i3 = this.zzd)) {
            E[] eArr = this.zzc;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i, eArr, i + 1, i3 - i);
            } else {
                E[] eArr2 = (E[]) new Object[zzb(eArr.length)];
                System.arraycopy(this.zzc, 0, eArr2, 0, i);
                System.arraycopy(this.zzc, i, eArr2, i + 1, this.zzd - i);
                this.zzc = eArr2;
            }
            this.zzc[i] = e4;
            this.zzd++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzc(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzd(i);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zza();
        zzd(i);
        E[] eArr = this.zzc;
        E e4 = eArr[i];
        if (i < this.zzd - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final E set(int i, E e4) {
        zza();
        zzd(i);
        E[] eArr = this.zzc;
        E e5 = eArr[i];
        eArr[i] = e4;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalc
    public final /* synthetic */ zzalc zza(int i) {
        Object[] copyOf;
        if (i >= this.zzd) {
            if (i == 0) {
                copyOf = zza;
            } else {
                copyOf = Arrays.copyOf(this.zzc, i);
            }
            return new zzamq(copyOf, this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zzamq(E[] eArr, int i, boolean z3) {
        super(z3);
        this.zzc = eArr;
        this.zzd = i;
    }

    private final void zzd(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e4) {
        zza();
        int i = this.zzd;
        E[] eArr = this.zzc;
        if (i == eArr.length) {
            this.zzc = (E[]) Arrays.copyOf(this.zzc, zzb(eArr.length));
        }
        E[] eArr2 = this.zzc;
        int i3 = this.zzd;
        this.zzd = i3 + 1;
        eArr2[i3] = e4;
        ((AbstractList) this).modCount++;
        return true;
    }
}
