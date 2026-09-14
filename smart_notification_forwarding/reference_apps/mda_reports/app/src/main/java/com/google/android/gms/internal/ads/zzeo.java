package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzeo {
    static zzdie a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzei zzeiVar) {
        Method zza;
        if (a != null) {
            return true;
        }
        String str = (String) zzve.zzoy().zzd(zzzn.zzcli);
        if (str == null || str.length() == 0) {
            str = (zzeiVar == null || (zza = zzeiVar.zza("ZT3tAbBtTEtCq6QAxk0/ceVyLEGcahIxKWW1sq8eFaJMNshmnsxr8BdGRJAdE4Rd", "SRbYMN68AMwZPDazOU0VwXZCPW/RYdycS0nF65kXvuU=")) == null) ? null : (String) zza.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            zzdij zzk = zzdin.zzk(zzci.zza(str, true));
            for (zzdnh zzdnhVar : zzdkf.zzgyy.zzawu()) {
                if (zzdnhVar.zzavi().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                }
                if (zzdnhVar.zzavq().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
                if (zzdnhVar.zzavt().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                }
                if (!zzdnhVar.zzavt().equals("TinkAead") && !zzdnhVar.zzavt().equals("TinkMac") && !zzdnhVar.zzavt().equals("TinkHybridDecrypt") && !zzdnhVar.zzavt().equals("TinkHybridEncrypt") && !zzdnhVar.zzavt().equals("TinkPublicKeySign") && !zzdnhVar.zzavt().equals("TinkPublicKeyVerify") && !zzdnhVar.zzavt().equals("TinkStreamingAead") && !zzdnhVar.zzavt().equals("TinkDeterministicAead")) {
                    zzdia<?> zzgy = zzdit.zzgy(zzdnhVar.zzavt());
                    zzdit.zza(zzgy.zzary());
                    zzdit.zza(zzgy.zzb(zzdnhVar.zzavi(), zzdnhVar.zzavq(), zzdnhVar.zzavr()), zzdnhVar.zzavs());
                }
            }
            a = zzdkj.zza(zzk, null);
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
        return a != null;
    }
}
