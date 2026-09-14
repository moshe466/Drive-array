package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzdp {
    private static final zzpr<zzdl, zzbe> zza = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzyn.zza((zzdl) zzbmVar);
        }
    }, zzdl.class, zzbe.class);
    private static final zzbl<zzbe> zzb = zzoc.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzbe.class, zzws.zza.SYMMETRIC, zztp.zzf());
    private static final zzou<zzdq> zzc = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdr
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            return zzdp.zza((zzdq) zzceVar, num);
        }
    };

    public static /* synthetic */ zzdl zza(zzdq zzdqVar, Integer num) {
        if (zzdqVar.zzc() != 24) {
            return zzdl.zze().zza(zzdqVar).zza(num).zza(zzaaf.zza(zzdqVar.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static void zza(boolean z3) {
        if (zzix.zza.zza.zza()) {
            zzgo.zza();
            zzoz.zza().zza(zza);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_EAX", zzfl.zzc);
            zzdq.zzb zzc2 = zzdq.zze().zza(16).zzb(16).zzc(16);
            zzdq.zza zzaVar = zzdq.zza.zzc;
            hashMap.put("AES128_EAX_RAW", zzc2.zza(zzaVar).zza());
            hashMap.put("AES256_EAX", zzfl.zzd);
            hashMap.put("AES256_EAX_RAW", zzdq.zze().zza(16).zzb(32).zzc(16).zza(zzaVar).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzos.zza().zza(zzc, zzdq.class);
            zznt.zza().zza((zzbl) zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }
}
