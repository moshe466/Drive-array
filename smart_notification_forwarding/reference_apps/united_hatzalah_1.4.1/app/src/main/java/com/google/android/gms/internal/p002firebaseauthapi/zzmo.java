package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzmo implements zzbk {
    private zzmo(zzbk zzbkVar, byte[] bArr) {
    }

    public static zzbk zza(zzoe zzoeVar) {
        byte[] zzb;
        zzqe zza = zzoeVar.zza(zzbj.zza());
        zzbk zzbkVar = (zzbk) zznt.zza().zza(zza.zzf(), zzbk.class).zzb(zza.zzd());
        zzxu zzc = zza.zzc();
        int i = zzmr.zza[zzc.ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i == 4) {
                    zzb = zzpd.zzb(zzoeVar.zzb().intValue()).zzb();
                } else {
                    throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzc)));
                }
            } else {
                zzb = zzpd.zza(zzoeVar.zzb().intValue()).zzb();
            }
        } else {
            zzb = zzpd.zza.zzb();
        }
        return new zzmo(zzbkVar, zzb);
    }
}
