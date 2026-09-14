package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import com.google.android.gms.internal.p002firebaseauthapi.zzve;
import com.google.android.gms.internal.p002firebaseauthapi.zzvk;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* loaded from: classes.dex */
public final class zzlt {
    private static final zzaae zza;
    private static final zzaae zzb;
    private static final zzpk<zzke, zzqd> zzc;
    private static final zzpg<zzqd> zzd;
    private static final zznw<zzkg, zzqe> zze;
    private static final zzns<zzqe> zzf;
    private static final zznw<zzkh, zzqe> zzg;
    private static final zzns<zzqe> zzh;
    private static final zznk<zzxu, zzke.zze> zzi;
    private static final zznk<zzvt, zzke.zzd> zzj;
    private static final zznk<zzvn, zzke.zza> zzk;
    private static final zznk<zzuw, zzke.zzc> zzl;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza = zzb2;
        zzaae zzb3 = zzqq.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzb = zzb3;
        zzc = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzls
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb4;
                zzb4 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zza(((zzuy) ((zzaky) zzuy.zza().zza(zzlt.zzb(r1)).zze())).a_()).zza(zzlt.zzi.zza((zznk<zzxu, zzke.zze>) ((zzke) zzceVar).zzg())).zze()));
                return zzb4;
            }
        }, zzke.class, zzqd.class);
        zzd = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlv
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzke zzb4;
                zzb4 = zzlt.zzb((zzqd) zzqiVar);
                return zzb4;
            }
        }, zzb2, zzqd.class);
        zze = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlu
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzlt.zza(r1).a_(), zzws.zza.ASYMMETRIC_PUBLIC, zzlt.zzi.zza((zznk<zzxu, zzke.zze>) ((zzke) ((zzlj) r1.zza())).zzg()), ((zzkg) zzbmVar).zzb());
                return zza2;
            }
        }, zzkg.class, zzqe.class);
        zzf = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlx
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzkg zzd2;
                zzd2 = zzlt.zzd((zzqe) zzqiVar, zzckVar);
                return zzd2;
            }
        }, zzb3, zzqe.class);
        zzg = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlw
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                return zzlt.zza((zzkh) zzbmVar, zzckVar);
            }
        }, zzkh.class, zzqe.class);
        zzh = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlz
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzkh zzc2;
                zzc2 = zzlt.zzc((zzqe) zzqiVar, zzckVar);
                return zzc2;
            }
        }, zzb2, zzqe.class);
        zznn zza2 = zznk.zza().zza(zzxu.RAW, zzke.zze.zzc).zza(zzxu.TINK, zzke.zze.zza);
        zzxu zzxuVar = zzxu.LEGACY;
        zzke.zze zzeVar = zzke.zze.zzb;
        zzi = zza2.zza(zzxuVar, zzeVar).zza(zzxu.CRUNCHY, zzeVar).zza();
        zzj = zznk.zza().zza(zzvt.SHA1, zzke.zzd.zza).zza(zzvt.SHA224, zzke.zzd.zzb).zza(zzvt.SHA256, zzke.zzd.zzc).zza(zzvt.SHA384, zzke.zzd.zzd).zza(zzvt.SHA512, zzke.zzd.zze).zza();
        zzk = zznk.zza().zza(zzvn.NIST_P256, zzke.zza.zza).zza(zzvn.NIST_P384, zzke.zza.zzb).zza(zzvn.NIST_P521, zzke.zza.zzc).zza(zzvn.CURVE25519, zzke.zza.zzd).zza();
        zzl = zznk.zza().zza(zzuw.UNCOMPRESSED, zzke.zzc.zzb).zza(zzuw.COMPRESSED, zzke.zzc.zza).zza(zzuw.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzke.zzc.zzc).zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkh zzc(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                zzve zza2 = zzve.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    zzvh zzd2 = zza2.zzd();
                    if (zzd2.zza() == 0) {
                        zzke zza3 = zza(zzqeVar.zzc(), zzd2.zzb());
                        if (zza3.zzd().equals(zzke.zza.zzd)) {
                            return zzkh.zza(zzkg.zza(zza3, zzaae.zza(zzd2.zzf().zzd()), zzqeVar.zze()), zzaaf.zza(zza2.zze().zzd(), zzck.zza(zzckVar)));
                        }
                        return zzkh.zza(zzkg.zza(zza3, new ECPoint(zznh.zza(zzd2.zzf().zzd()), zznh.zza(zzd2.b_().zzd())), zzqeVar.zze()), zzaad.zza(zznh.zza(zza2.zze().zzd()), zzck.zza(zzckVar)));
                    }
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: ", zzqeVar.zzf()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkg zzd(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            try {
                zzvh zza2 = zzvh.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    zzke zza3 = zza(zzqeVar.zzc(), zza2.zzb());
                    if (zza3.zzd().equals(zzke.zza.zzd)) {
                        if (zza2.b_().zzb() == 0) {
                            return zzkg.zza(zza3, zzaae.zza(zza2.zzf().zzd()), zzqeVar.zze());
                        }
                        throw new GeneralSecurityException("Y must be empty for X25519 points");
                    }
                    return zzkg.zza(zza3, new ECPoint(zznh.zza(zza2.zzf().zzd()), zznh.zza(zza2.b_().zzd())), zzqeVar.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: ", zzqeVar.zzf()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzke zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                return zza(zzqdVar.zza().zzd(), zzuy.zza(zzqdVar.zza().zze(), zzakk.zza()).zzc());
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing EciesParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to EciesProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static int zza(zzke.zza zzaVar) {
        if (zzke.zza.zza.equals(zzaVar)) {
            return 33;
        }
        if (zzke.zza.zzb.equals(zzaVar)) {
            return 49;
        }
        if (zzke.zza.zzc.equals(zzaVar)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType ".concat(String.valueOf(zzaVar)));
    }

    private static zzke zza(zzxu zzxuVar, zzvb zzvbVar) {
        zzke.zzb zza2 = zzke.zzc().zza(zzi.zza((zznk<zzxu, zzke.zze>) zzxuVar)).zza(zzk.zza((zznk<zzvn, zzke.zza>) zzvbVar.zzf().zzd())).zza(zzj.zza((zznk<zzvt, zzke.zzd>) zzvbVar.zzf().zze())).zza(zzcm.zza(((zzww) ((zzaky) zzww.zza().zza(zzvbVar.zzb().zzd().zzf()).zza(zzxu.RAW).zza(zzvbVar.zzb().zzd().zze()).zze())).zzk())).zza(zzaae.zza(zzvbVar.zzf().zzf().zzd()));
        if (!zzvbVar.zzf().zzd().equals(zzvn.CURVE25519)) {
            zza2.zza(zzl.zza((zznk<zzuw, zzke.zzc>) zzvbVar.zza()));
        } else if (!zzvbVar.zza().equals(zzuw.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zza2.zza();
    }

    private static zzvb zzb(zzke zzkeVar) {
        zzvk.zza zza2 = zzvk.zza().zza(zzk.zza((zznk<zzvn, zzke.zza>) zzkeVar.zzd())).zza(zzj.zza((zznk<zzvt, zzke.zzd>) zzkeVar.zze()));
        if (zzkeVar.zzh() != null && zzkeVar.zzh().zza() > 0) {
            zza2.zza(zzajp.zza(zzkeVar.zzh().zzb()));
        }
        zzvk zzvkVar = (zzvk) ((zzaky) zza2.zze());
        try {
            zzww zza3 = zzww.zza(zzcm.zza(zzkeVar.zzb()), zzakk.zza());
            zzuv zzuvVar = (zzuv) ((zzaky) zzuv.zza().zza((zzww) ((zzaky) zzww.zza().zza(zza3.zzf()).zza(zzxu.TINK).zza(zza3.zze()).zze())).zze());
            zzke.zzc zzf2 = zzkeVar.zzf();
            if (zzf2 == null) {
                zzf2 = zzke.zzc.zza;
            }
            return (zzvb) ((zzaky) zzvb.zzc().zza(zzvkVar).zza(zzuvVar).zza(zzl.zza((zznk<zzuw, zzke.zzc>) zzf2)).zze());
        } catch (zzalf e4) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e4);
        }
    }

    public static /* synthetic */ zzqe zza(zzkh zzkhVar, zzck zzckVar) {
        zzve.zza zza2 = zzve.zzb().zza(0).zza(zza((zzkg) ((zzll) zzkhVar.zzc())));
        if (((zzke) ((zzlj) zzkhVar.zza())).zzd().equals(zzke.zza.zzd)) {
            zza2.zza(zzajp.zza(zzkhVar.zzg().zza(zzck.zza(zzckVar))));
        } else {
            zza2.zza(zzajp.zza(zznh.zza(zzkhVar.zzf().zza(zzck.zza(zzckVar)), zza(((zzke) ((zzlj) zzkhVar.zza())).zzd()))));
        }
        return zzqe.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzve) ((zzaky) zza2.zze())).a_(), zzws.zza.ASYMMETRIC_PRIVATE, zzi.zza((zznk<zzxu, zzke.zze>) ((zzke) ((zzlj) zzkhVar.zza())).zzg()), zzkhVar.zzb());
    }

    private static zzvh zza(zzkg zzkgVar) {
        if (((zzke) ((zzlj) zzkgVar.zza())).zzd().equals(zzke.zza.zzd)) {
            return (zzvh) ((zzaky) zzvh.zzc().zza(0).zza(zzb((zzke) ((zzlj) zzkgVar.zza()))).zza(zzajp.zza(zzkgVar.zze().zzb())).zzb(zzajp.zza).zze());
        }
        int zza2 = zza(((zzke) ((zzlj) zzkgVar.zza())).zzd());
        ECPoint zzf2 = zzkgVar.zzf();
        if (zzf2 != null) {
            return (zzvh) ((zzaky) zzvh.zzc().zza(0).zza(zzb((zzke) ((zzlj) zzkgVar.zza()))).zza(zzajp.zza(zznh.zza(zzf2.getAffineX(), zza2))).zzb(zzajp.zza(zznh.zza(zzf2.getAffineY(), zza2))).zze());
        }
        throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
    }

    public static void zza() {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }
}
