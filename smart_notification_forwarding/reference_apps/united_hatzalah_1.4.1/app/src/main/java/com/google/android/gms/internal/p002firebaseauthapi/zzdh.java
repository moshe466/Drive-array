package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzdh {
    private static final zzpr<zzdd, zzbe> zza = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzze.zza((zzdd) zzbmVar);
        }
    }, zzdd.class, zzbe.class);
    private static final zzbl<zzbe> zzb = zzoc.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzbe.class, zzws.zza.SYMMETRIC, zzta.zzf());
    private static final zzow<zzdk> zzc = new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdj
    };
    private static final zzou<zzdk> zzd = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdi
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            return zzdh.zza((zzdk) zzceVar, num);
        }
    };
    private static final zzix.zza zze = zzix.zza.zzb;

    public static zzdd zza(zzdk zzdkVar, Integer num) {
        if (zzdkVar.zzb() != 16 && zzdkVar.zzb() != 32) {
            throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
        }
        return zzdd.zze().zza(zzdkVar).zza(num).zza(zzaaf.zza(zzdkVar.zzb())).zzb(zzaaf.zza(zzdkVar.zzc())).zza();
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public static void zza(boolean z3) {
        zzix.zza zzaVar = zze;
        if (zzaVar.zza()) {
            zzgi.zza();
            zzoz.zza().zza(zza);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_CTR_HMAC_SHA256", zzfl.zze);
            zzdk.zza zzc2 = zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16);
            zzdk.zzc zzcVar = zzdk.zzc.zzc;
            zzdk.zza zza3 = zzc2.zza(zzcVar);
            zzdk.zzb zzbVar = zzdk.zzb.zzc;
            hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zza3.zza(zzbVar).zza());
            hashMap.put("AES256_CTR_HMAC_SHA256", zzfl.zzf);
            hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdk.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzcVar).zza(zzbVar).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzot.zza().zza(zzc, zzdk.class);
            zzos.zza().zza(zzd, zzdk.class);
            zznt.zza().zza((zzbl) zzb, zzaVar, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
