package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import com.google.android.gms.internal.p002firebaseauthapi.zzxf;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzcl {
    static {
        Charset.forName("UTF-8");
    }

    public static zzxf zza(zzxc zzxcVar) {
        zzxf.zzb zza = zzxf.zza().zza(zzxcVar.zzb());
        for (zzxc.zza zzaVar : zzxcVar.zze()) {
            zza.zza((zzxf.zza) ((zzaky) zzxf.zza.zza().zza(zzaVar.zzb().zzf()).zza(zzaVar.zzc()).zza(zzaVar.zzf()).zza(zzaVar.zza()).zze()));
        }
        return (zzxf) ((zzaky) zza.zze());
    }

    public static void zzb(zzxc zzxcVar) {
        int zzb = zzxcVar.zzb();
        int i = 0;
        boolean z3 = false;
        boolean z4 = true;
        for (zzxc.zza zzaVar : zzxcVar.zze()) {
            if (zzaVar.zzc() == zzwt.ENABLED) {
                if (zzaVar.e_()) {
                    if (zzaVar.zzf() != zzxu.UNKNOWN_PREFIX) {
                        if (zzaVar.zzc() != zzwt.UNKNOWN_STATUS) {
                            if (zzaVar.zza() == zzb) {
                                if (!z3) {
                                    z3 = true;
                                } else {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                            }
                            if (zzaVar.zzb().zzb() != zzws.zza.ASYMMETRIC_PUBLIC) {
                                z4 = false;
                            }
                            i++;
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaVar.zza())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaVar.zza())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaVar.zza())));
                }
            }
        }
        if (i != 0) {
            if (!z3 && !z4) {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
            return;
        }
        throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
    }
}
