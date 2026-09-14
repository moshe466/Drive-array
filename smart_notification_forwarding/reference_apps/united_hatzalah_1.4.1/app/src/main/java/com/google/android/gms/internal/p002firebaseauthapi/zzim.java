package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzgg;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzim {
    private static final zzaae zza;
    private static final zzpk<zzgg, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzgb, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzil
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key").zza(zzyi.zzc().a_()).zza(zzim.zza(((zzgg) zzceVar).zzb())).zze()));
                return zzb3;
            }
        }, zzgg.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzio
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzgg zzb3;
                zzb3 = zzim.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzin
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzyf) ((zzaky) zzyf.zzb().zza(zzajp.zza(r1.zze().zza(zzck.zza(zzckVar)))).zze())).a_(), zzws.zza.SYMMETRIC, zzim.zza(((zzgg) ((zzcx) r1.zza())).zzb()), ((zzgb) zzbmVar).zzb());
                return zza2;
            }
        }, zzgb.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zziq
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzgb zzb3;
                zzb3 = zzim.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgb zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzyf zza2 = zzyf.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzgb.zza(zza(zzqeVar.zzc()), zzaaf.zza(zza2.zzd().zzd(), zzck.zza(zzckVar)), zzqeVar.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
    }

    private static zzgg.zza zza(zzxu zzxuVar) {
        int i = zzip.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzgg.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzgg.zza.zzb;
        }
        if (i == 4) {
            return zzgg.zza.zzc;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgg zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzyi.zza(zzqdVar.zza().zze(), zzakk.zza()).zza() == 0) {
                    return zzgg.zza(zza(zzqdVar.zza().zzd()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzgg.zza zzaVar) {
        if (zzgg.zza.zza.equals(zzaVar)) {
            return zzxu.TINK;
        }
        if (zzgg.zza.zzb.equals(zzaVar)) {
            return zzxu.CRUNCHY;
        }
        if (zzgg.zza.zzc.equals(zzaVar)) {
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
