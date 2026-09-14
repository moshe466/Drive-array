package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzsj {
    private static final zzaae zza;
    private static final zznk<zzxu, zzrj.zzb> zzb;
    private static final zznk<zzvt, zzrj.zzc> zzc;
    private static final zzpk<zzrj, zzqd> zzd;
    private static final zzpg<zzqd> zze;
    private static final zznw<zzrc, zzqe> zzf;
    private static final zzns<zzqe> zzg;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        zzb = zznk.zza().zza(zzxu.RAW, zzrj.zzb.zzd).zza(zzxu.TINK, zzrj.zzb.zza).zza(zzxu.LEGACY, zzrj.zzb.zzc).zza(zzxu.CRUNCHY, zzrj.zzb.zzb).zza();
        zzc = zznk.zza().zza(zzvt.SHA1, zzrj.zzc.zza).zza(zzvt.SHA224, zzrj.zzc.zzb).zza(zzvt.SHA256, zzrj.zzc.zzc).zza(zzvt.SHA384, zzrj.zzc.zzd).zza(zzvt.SHA512, zzrj.zzc.zze).zza();
        zzd = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsi
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.HmacKey").zza(((zzvv) ((zzaky) zzvv.zzc().zza(zzsj.zzb(r1)).zza(r1.zzc()).zze())).a_()).zza(zzsj.zzb.zza((zznk<zzxu, zzrj.zzb>) ((zzrj) zzceVar).zzf())).zze()));
                return zzb3;
            }
        }, zzrj.class, zzqd.class);
        zze = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsl
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzrj zzb3;
                zzb3 = zzsj.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzf = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsk
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzvs) ((zzaky) zzvs.zzb().zza(zzsj.zzb((zzrj) ((zzrm) r1.zza()))).zza(zzajp.zza(r1.zzf().zza(zzck.zza(zzckVar)))).zze())).a_(), zzws.zza.SYMMETRIC, zzsj.zzb.zza((zznk<zzxu, zzrj.zzb>) ((zzrj) ((zzrm) r1.zza())).zzf()), ((zzrc) zzbmVar).zzb());
                return zza2;
            }
        }, zzrc.class, zzqe.class);
        zzg = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsn
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzrc zzb3;
                zzb3 = zzsj.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzrc zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzvs zza2 = zzvs.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzrc.zzc().zza(zzrj.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza(zzc.zza((zznk<zzvt, zzrj.zzc>) zza2.zze().zzb())).zza(zzb.zza((zznk<zzxu, zzrj.zzb>) zzqeVar.zzc())).zza()).zza(zzaaf.zza(zza2.zzf().zzd(), zzck.zza(zzckVar))).zza(zzqeVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzrj zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzvv zza2 = zzvv.zza(zzqdVar.zza().zze(), zzakk.zza());
                if (zza2.zzb() == 0) {
                    return zzrj.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza(zzc.zza((zznk<zzvt, zzrj.zzc>) zza2.zzf().zzb())).zza(zzb.zza((zznk<zzxu, zzrj.zzb>) zzqdVar.zza().zzd())).zza();
                }
                throw new GeneralSecurityException(a.c(zza2.zzb(), "Parsing HmacParameters failed: unknown Version "));
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to HmacProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    public static void zza() {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }

    private static zzvy zzb(zzrj zzrjVar) {
        return (zzvy) ((zzaky) zzvy.zzc().zza(zzrjVar.zzb()).zza(zzc.zza((zznk<zzvt, zzrj.zzc>) zzrjVar.zze())).zze());
    }
}
