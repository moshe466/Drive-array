package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzgo {
    private static final zzaae zza;
    private static final zzpk<zzdq, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzdl, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgn
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.AesEaxKey").zza(((zzts) ((zzaky) zzts.zzb().zza(zzgo.zzb(r1)).zza(r1.zzc()).zze())).a_()).zza(zzgo.zza(((zzdq) zzceVar).zzf())).zze()));
                return zzb3;
            }
        }, zzdq.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgq
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzdq zzb3;
                zzb3 = zzgo.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgp
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zztp) ((zzaky) zztp.zzb().zza(zzgo.zzb((zzdq) ((zzcx) r1.zza()))).zza(zzajp.zza(r1.zzf().zza(zzck.zza(zzckVar)))).zze())).a_(), zzws.zza.SYMMETRIC, zzgo.zza(((zzdq) ((zzcx) r1.zza())).zzf()), ((zzdl) zzbmVar).zzb());
                return zza2;
            }
        }, zzdl.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgs
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzdl zzb3;
                zzb3 = zzgo.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdl zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zztp zza2 = zztp.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzdl.zze().zza(zzdq.zze().zzb(zza2.zze().zzb()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzqeVar.zzc())).zza()).zza(zzaaf.zza(zza2.zze().zzd(), zzck.zza(zzckVar))).zza(zzqeVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
    }

    private static zzdq.zza zza(zzxu zzxuVar) {
        int i = zzgr.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzdq.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzdq.zza.zzb;
        }
        if (i == 4) {
            return zzdq.zza.zzc;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdq zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzts zza2 = zzts.zza(zzqdVar.zza().zze(), zzakk.zza());
                return zzdq.zze().zzb(zza2.zza()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzqdVar.zza().zzd())).zza();
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzdq.zza zzaVar) {
        if (zzdq.zza.zza.equals(zzaVar)) {
            return zzxu.TINK;
        }
        if (zzdq.zza.zzb.equals(zzaVar)) {
            return zzxu.CRUNCHY;
        }
        if (zzdq.zza.zzc.equals(zzaVar)) {
            return zzxu.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzaVar)));
    }

    private static zztv zzb(zzdq zzdqVar) {
        if (zzdqVar.zzd() == 16) {
            return (zztv) ((zzaky) zztv.zzb().zza(zzdqVar.zzb()).zze());
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(zzdqVar.zzd())));
    }

    public static void zza() {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
