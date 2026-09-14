package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzajn extends zzajj<Boolean> implements zzalc<Boolean>, RandomAccess {
    private static final boolean[] zza;
    private boolean[] zzb;
    private int zzc;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        new zzajn(zArr, 0, false);
    }

    public zzajn() {
        this(zza, 0, true);
    }

    private static int zzc(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzd(int i) {
        return AbstractC0008a.k("Index:", i, this.zzc, ", Size:");
    }

    private final void zze(int i) {
        if (i >= 0 && i < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(zzd(i));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i >= 0 && i <= (i3 = this.zzc)) {
            boolean[] zArr = this.zzb;
            if (i3 < zArr.length) {
                System.arraycopy(zArr, i, zArr, i + 1, i3 - i);
            } else {
                boolean[] zArr2 = new boolean[zzc(zArr.length)];
                System.arraycopy(this.zzb, 0, zArr2, 0, i);
                System.arraycopy(this.zzb, i, zArr2, i + 1, this.zzc - i);
                this.zzb = zArr2;
            }
            this.zzb[i] = booleanValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzd(i));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zza();
        zzalb.zza(collection);
        if (!(collection instanceof zzajn)) {
            return super.addAll(collection);
        }
        zzajn zzajnVar = (zzajn) collection;
        int i = zzajnVar.zzc;
        if (i == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 >= i) {
            int i4 = i3 + i;
            boolean[] zArr = this.zzb;
            if (i4 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(zzajnVar.zzb, 0, this.zzb, this.zzc, zzajnVar.zzc);
            this.zzc = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzajn)) {
            return super.equals(obj);
        }
        zzajn zzajnVar = (zzajn) obj;
        if (this.zzc != zzajnVar.zzc) {
            return false;
        }
        boolean[] zArr = zzajnVar.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Boolean.valueOf(zzb(i));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i = (i * 31) + zzalb.zza(this.zzb[i3]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzb[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zza();
        zze(i);
        boolean[] zArr = this.zzb;
        boolean z3 = zArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i3) {
        zza();
        if (i3 >= i) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i3, zArr, i, this.zzc - i3);
            this.zzc -= i3 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zze(i);
        boolean[] zArr = this.zzb;
        boolean z3 = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalc
    public final /* synthetic */ zzalc<Boolean> zza(int i) {
        if (i >= this.zzc) {
            return new zzajn(i == 0 ? zza : Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zzb(int i) {
        zze(i);
        return this.zzb[i];
    }

    private zzajn(boolean[] zArr, int i, boolean z3) {
        super(z3);
        this.zzb = zArr;
        this.zzc = i;
    }

    public final void zza(boolean z3) {
        zza();
        int i = this.zzc;
        boolean[] zArr = this.zzb;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[zzc(zArr.length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, this.zzc);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        zArr3[i3] = z3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Boolean) obj).booleanValue());
        return true;
    }
}
