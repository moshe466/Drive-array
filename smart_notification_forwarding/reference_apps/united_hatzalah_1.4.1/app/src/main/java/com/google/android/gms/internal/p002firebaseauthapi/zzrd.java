package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzrd {
    private static final zzpr<zzrc, zzqz> zza = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return new zzsg((zzrc) zzbmVar);
        }
    }, zzrc.class, zzqz.class);
    private static final zzpr<zzrc, zzcb> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrf
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzzx.zza((zzrc) zzbmVar);
        }
    }, zzrc.class, zzcb.class);
    private static final zzbl<zzcb> zzc = zzoc.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzcb.class, zzws.zza.SYMMETRIC, zzvs.c_());
    private static final zzow<zzrj> zzd = new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzri
    };
    private static final zzou<zzrj> zze = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            return zzrd.zza((zzrj) zzceVar, num);
        }
    };
    private static final zzix.zza zzf = zzix.zza.zzb;

    public static zzrc zza(zzrj zzrjVar, Integer num) {
        return zzrc.zzc().zza(zzrjVar).zza(zzaaf.zza(zzrjVar.zzc())).zza(num).zza();
    }

    public static void zza(boolean z3) {
        zzix.zza zzaVar = zzf;
        if (zzaVar.zza()) {
            zzsj.zza();
            zzoz.zza().zza(zza);
            zzoz.zza().zza(zzb);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("HMAC_SHA256_128BITTAG", zzrs.zza);
            zzrj.zza zzb2 = zzrj.zzd().zza(32).zzb(16);
            zzrj.zzb zzbVar = zzrj.zzb.zzd;
            zzrj.zza zza3 = zzb2.zza(zzbVar);
            zzrj.zzc zzcVar = zzrj.zzc.zzc;
            hashMap.put("HMAC_SHA256_128BITTAG_RAW", zza3.zza(zzcVar).zza());
            zzrj.zza zzb3 = zzrj.zzd().zza(32).zzb(32);
            zzrj.zzb zzbVar2 = zzrj.zzb.zza;
            hashMap.put("HMAC_SHA256_256BITTAG", zzb3.zza(zzbVar2).zza(zzcVar).zza());
            hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzrj.zzd().zza(32).zzb(32).zza(zzbVar).zza(zzcVar).zza());
            zzrj.zza zza4 = zzrj.zzd().zza(64).zzb(16).zza(zzbVar2);
            zzrj.zzc zzcVar2 = zzrj.zzc.zze;
            hashMap.put("HMAC_SHA512_128BITTAG", zza4.zza(zzcVar2).zza());
            hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzrj.zzd().zza(64).zzb(16).zza(zzbVar).zza(zzcVar2).zza());
            hashMap.put("HMAC_SHA512_256BITTAG", zzrj.zzd().zza(64).zzb(32).zza(zzbVar2).zza(zzcVar2).zza());
            hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzrj.zzd().zza(64).zzb(32).zza(zzbVar).zza(zzcVar2).zza());
            hashMap.put("HMAC_SHA512_512BITTAG", zzrs.zzb);
            hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzrj.zzd().zza(64).zzb(64).zza(zzbVar).zza(zzcVar2).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzos.zza().zza(zze, zzrj.class);
            zzot.zza().zza(zzd, zzrj.class);
            zznt.zza().zza((zzbl) zzc, zzaVar, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
