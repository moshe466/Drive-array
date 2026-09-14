package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzeo {
    private static final zzpr<zzew, zzbe> zza = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            zzbe zza2;
            zza2 = zzhz.zza(zzbz.zza(((zzev) ((zzcx) r1.zza())).zzc()).zza(((zzev) ((zzcx) r1.zza())).zzc()), ((zzew) zzbmVar).zzd());
            return zza2;
        }
    }, zzew.class, zzbe.class);
    private static final zzbl<zzbe> zzb = zzoc.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzbe.class, zzws.zza.REMOTE, zzxi.zze());
    private static final zzou<zzev> zzc = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzep
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            zzew zza2;
            zza2 = zzew.zza((zzev) zzceVar, num);
            return zza2;
        }
    };

    public static void zza(boolean z3) {
        if (zzix.zza.zza.zza()) {
            zzex.zza();
            zzoz.zza().zza(zza);
            zzos.zza().zza(zzc, zzev.class);
            zznt.zza().zza((zzbl) zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
    }
}
