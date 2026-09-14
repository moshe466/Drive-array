package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzec {
    private static final zzpr<zzeb, zzbe> zza = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzef
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzis.zza((zzeb) zzbmVar);
        }
    }, zzeb.class, zzbe.class);
    private static final zzou<zzeg> zzb = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzee
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            zzeb zza2;
            zza2 = zzeb.zze().zza(r1).zza(num).zza(zzaaf.zza(((zzeg) zzceVar).zzb())).zza();
            return zza2;
        }
    };
    private static final zzow<zzeg> zzc = new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeh
    };
    private static final zzbl<zzbe> zzd = zzoc.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzbe.class, zzws.zza.SYMMETRIC, zzue.zze());

    public static void zza(boolean z3) {
        if (zzix.zza.zza.zza()) {
            zzhe.zza();
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            zzeg.zzb zza3 = zzeg.zzc().zza(16);
            zzeg.zza zzaVar = zzeg.zza.zza;
            hashMap.put("AES128_GCM_SIV", zza3.zza(zzaVar).zza());
            zzeg.zzb zza4 = zzeg.zzc().zza(16);
            zzeg.zza zzaVar2 = zzeg.zza.zzc;
            hashMap.put("AES128_GCM_SIV_RAW", zza4.zza(zzaVar2).zza());
            hashMap.put("AES256_GCM_SIV", zzeg.zzc().zza(32).zza(zzaVar).zza());
            hashMap.put("AES256_GCM_SIV_RAW", zzeg.zzc().zza(32).zza(zzaVar2).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzot.zza().zza(zzc, zzeg.class);
            zzos.zza().zza(zzb, zzeg.class);
            zzoz.zza().zza(zza);
            zznt.zza().zza((zzbl) zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }
}
