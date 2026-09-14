package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzhe {
    private static final zzaae zza;
    private static final zzpk<zzeg, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzeb, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhd
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey").zza(((zzuh) ((zzaky) zzuh.zzc().zza(r1.zzb()).zze())).a_()).zza(zzhe.zza(((zzeg) zzceVar).zzd())).zze()));
                return zzb3;
            }
        }, zzeg.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhg
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzeg zzb3;
                zzb3 = zzhe.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhf
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzue) ((zzaky) zzue.zzb().zza(zzajp.zza(r1.zzf().zza(zzck.zza(zzckVar)))).zze())).a_(), zzws.zza.SYMMETRIC, zzhe.zza(((zzeg) ((zzcx) r1.zza())).zzd()), ((zzeb) zzbmVar).zzb());
                return zza2;
            }
        }, zzeb.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhi
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzeb zzb3;
                zzb3 = zzhe.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzeb zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzue zza2 = zzue.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzeb.zze().zza(zzeg.zzc().zza(zza2.zzd().zzb()).zza(zza(zzqeVar.zzc())).zza()).zza(zzaaf.zza(zza2.zzd().zzd(), zzck.zza(zzckVar))).zza(zzqeVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
    }

    private static zzeg.zza zza(zzxu zzxuVar) {
        int i = zzhh.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzeg.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzeg.zza.zzb;
        }
        if (i == 4) {
            return zzeg.zza.zzc;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzeg zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzuh zza2 = zzuh.zza(zzqdVar.zza().zze(), zzakk.zza());
                if (zza2.zzb() == 0) {
                    return zzeg.zzc().zza(zza2.zza()).zza(zza(zzqdVar.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzeg.zza zzaVar) {
        if (zzeg.zza.zza.equals(zzaVar)) {
            return zzxu.TINK;
        }
        if (zzeg.zza.zzb.equals(zzaVar)) {
            return zzxu.CRUNCHY;
        }
        if (zzeg.zza.zzc.equals(zzaVar)) {
            return zzxu.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzaVar)));
    }

    public static void zza() {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
