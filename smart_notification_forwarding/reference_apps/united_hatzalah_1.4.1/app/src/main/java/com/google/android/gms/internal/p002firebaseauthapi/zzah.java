package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzah<E> extends zzak<E> {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzah(int i) {
        zzag.zza(4, "initialCapacity");
        this.zza = new Object[4];
        this.zzb = 0;
    }

    public zzah<E> zza(E e4) {
        zzw.zza(e4);
        Object[] objArr = this.zza;
        int zza = zzak.zza(objArr.length, this.zzb + 1);
        if (zza > objArr.length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, zza);
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr2[i] = e4;
        return this;
    }
}
