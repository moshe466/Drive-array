package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzer {
    private static final zzbl<zzbe> zza = zzoc.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzbe.class, zzws.zza.SYMMETRIC, zzxo.zze());
    private static final zzou<zzfe> zzb = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            zzfc zza2;
            zza2 = zzfc.zza((zzfe) zzceVar, num);
            return zza2;
        }
    };
    private static final zzpr<zzfc, zzbe> zzc = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzet
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzer.zza((zzfc) zzbmVar);
        }
    }, zzfc.class, zzbe.class);

    public static /* synthetic */ zzbe zza(zzfc zzfcVar) {
        String zzd = ((zzfe) ((zzcx) zzfcVar.zza())).zzd();
        return zzhz.zza(zzes.zza(((zzfe) ((zzcx) zzfcVar.zza())).zzb(), zzbz.zza(zzd).zza(zzd)), zzfcVar.zzd());
    }

    public static void zza(boolean z3) {
        if (zzix.zza.zza.zza()) {
            zzff.zza();
            zzos.zza().zza(zzb, zzfe.class);
            zzoz.zza().zza(zzc);
            zznt.zza().zza((zzbl) zza, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }
}
