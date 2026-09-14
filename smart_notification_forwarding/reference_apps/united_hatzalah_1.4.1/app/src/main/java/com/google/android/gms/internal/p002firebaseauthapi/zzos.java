package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzos {
    private static final zzou<zzoh> zza = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzor
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            return zzos.zza((zzoh) zzceVar, num);
        }
    };
    private static final zzos zzb = zzb();
    private final Map<Class<? extends zzce>, zzou<? extends zzce>> zzc = new HashMap();

    private final synchronized <ParametersT extends zzce> zzbm zzb(ParametersT parameterst, Integer num) {
        zzou<? extends zzce> zzouVar;
        zzouVar = this.zzc.get(parameterst.getClass());
        if (zzouVar != null) {
        } else {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + String.valueOf(parameterst) + ": no key creator for this class was registered.");
        }
        return zzouVar.zza(parameterst, num);
    }

    public final zzbm zza(zzce zzceVar, Integer num) {
        return zzb(zzceVar, num);
    }

    public static /* synthetic */ zzoe zza(zzoh zzohVar, Integer num) {
        zzww zza2 = zzohVar.zzb().zza();
        zzbl<?> zza3 = zznt.zza().zza(zza2.zzf());
        if (zznt.zza().zzb(zza2.zzf())) {
            zzws zza4 = zza3.zza(zza2.zze());
            return new zzoe(zzqe.zza(zza4.zzf(), zza4.zze(), zza4.zzb(), zza2.zzd(), num), zzbj.zza());
        }
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }

    private static zzos zzb() {
        zzos zzosVar = new zzos();
        try {
            zzosVar.zza(zza, zzoh.class);
            return zzosVar;
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException("unexpected error.", e4);
        }
    }

    public static zzos zza() {
        return zzb;
    }

    public final synchronized <ParametersT extends zzce> void zza(zzou<ParametersT> zzouVar, Class<ParametersT> cls) {
        try {
            zzou<? extends zzce> zzouVar2 = this.zzc.get(cls);
            if (zzouVar2 != null && !zzouVar2.equals(zzouVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class " + String.valueOf(cls) + " already inserted");
            }
            this.zzc.put(cls, zzouVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
