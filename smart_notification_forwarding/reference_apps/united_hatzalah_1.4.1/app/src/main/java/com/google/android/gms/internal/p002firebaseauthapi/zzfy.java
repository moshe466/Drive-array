package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzfy {
    private static final zzou<zzfz> zza = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            zzfv zza2;
            zza2 = zzfv.zza((zzfz) zzceVar, zzaaf.zza(32), num);
            return zza2;
        }
    };
    private static final zzpr<zzfv, zzbe> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzga
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzie.zza((zzfv) zzbmVar);
        }
    }, zzfv.class, zzbe.class);

    public static void zza(boolean z3) {
        zzid.zza();
        zzpa zza2 = zzpa.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XAES_256_GCM_192_BIT_NONCE", zzfl.zzg);
        hashMap.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzfl.zzh);
        hashMap.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzfl.zzi);
        hashMap.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzfl.zzj);
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzoz.zza().zza(zzb);
        zzos.zza().zza(zza, zzfz.class);
    }
}
