package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzmm implements zzbh {
    private final zzbh zza;
    private final byte[] zzb;

    private zzmm(zzbh zzbhVar, byte[] bArr) {
        this.zza = zzbhVar;
        this.zzb = bArr;
    }

    public static zzbh zza(zzoe zzoeVar) {
        byte[] zzb;
        zzqe zza = zzoeVar.zza(zzbj.zza());
        zzbh zzbhVar = (zzbh) zznt.zza().zza(zza.zzf(), zzbh.class).zzb(zza.zzd());
        zzxu zzc = zza.zzc();
        int i = zzmp.zza[zzc.ordinal()];
        if (i == 1) {
            zzb = zzpd.zza.zzb();
        } else if (i == 2 || i == 3) {
            zzb = zzpd.zza(zzoeVar.zzb().intValue()).zzb();
        } else if (i == 4) {
            zzb = zzpd.zzb(zzoeVar.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzc)));
        }
        return new zzmm(zzbhVar, zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqq.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
