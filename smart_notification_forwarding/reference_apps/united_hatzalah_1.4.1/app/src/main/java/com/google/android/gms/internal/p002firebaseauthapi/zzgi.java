package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzvy;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzgi {
    private static final zzaae zza;
    private static final zzpk<zzdk, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzdd, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgh
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").zza(((zztd) ((zzaky) zztd.zza().zza((zztj) ((zzaky) zztj.zzb().zza((zztm) ((zzaky) zztm.zzb().zza(r1.zzd()).zze())).zza(r1.zzb()).zze())).zza((zzvv) ((zzaky) zzvv.zzc().zza(zzgi.zzb(r1)).zza(r1.zzc()).zze())).zze())).a_()).zza(zzgi.zza(((zzdk) zzceVar).zzh())).zze()));
                return zzb3;
            }
        }, zzdk.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgk
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzdk zzb3;
                zzb3 = zzgi.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgj
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzta) ((zzaky) zzta.zzb().zza((zztg) ((zzaky) zztg.zzb().zza((zztm) ((zzaky) zztm.zzb().zza(((zzdk) ((zzcx) r1.zza())).zzd()).zze())).zza(zzajp.zza(r1.zzf().zza(zzck.zza(zzckVar)))).zze())).zza((zzvs) ((zzaky) zzvs.zzb().zza(zzgi.zzb((zzdk) ((zzcx) r1.zza()))).zza(zzajp.zza(r1.zzg().zza(zzck.zza(zzckVar)))).zze())).zze())).a_(), zzws.zza.SYMMETRIC, zzgi.zza(((zzdk) ((zzcx) r1.zza())).zzh()), ((zzdd) zzbmVar).zzb());
                return zza2;
            }
        }, zzdd.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgm
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzdd zzb3;
                zzb3 = zzgi.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdd zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzta zza2 = zzta.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    if (zza2.zzd().zza() == 0) {
                        if (zza2.zze().zza() == 0) {
                            return zzdd.zze().zza(zzdk.zzf().zza(zza2.zzd().zzf().zzb()).zzb(zza2.zze().zzf().zzb()).zzc(zza2.zzd().zze().zza()).zzd(zza2.zze().zze().zza()).zza(zza(zza2.zze().zze().zzb())).zza(zza(zzqeVar.zzc())).zza()).zza(zzaaf.zza(zza2.zzd().zzf().zzd(), zzck.zza(zzckVar))).zzb(zzaaf.zza(zza2.zze().zzf().zzd(), zzck.zza(zzckVar))).zza(zzqeVar.zze()).zza();
                        }
                        throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                    }
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
    }

    private static zzdk.zzc zza(zzvt zzvtVar) {
        int i = zzgl.zzb[zzvtVar.ordinal()];
        if (i == 1) {
            return zzdk.zzc.zza;
        }
        if (i == 2) {
            return zzdk.zzc.zzb;
        }
        if (i == 3) {
            return zzdk.zzc.zzc;
        }
        if (i == 4) {
            return zzdk.zzc.zzd;
        }
        if (i == 5) {
            return zzdk.zzc.zze;
        }
        throw new GeneralSecurityException(a.c(zzvtVar.zza(), "Unable to parse HashType: "));
    }

    private static zzdk.zzb zza(zzxu zzxuVar) {
        int i = zzgl.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzdk.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzdk.zzb.zzb;
        }
        if (i == 4) {
            return zzdk.zzb.zzc;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdk zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zztd zza2 = zztd.zza(zzqdVar.zza().zze(), zzakk.zza());
                if (zza2.zzd().zzb() == 0) {
                    return zzdk.zzf().zza(zza2.zzc().zza()).zzb(zza2.zzd().zza()).zzc(zza2.zzc().zze().zza()).zzd(zza2.zzd().zzf().zza()).zza(zza(zza2.zzd().zzf().zzb())).zza(zza(zzqdVar.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzvy zzb(zzdk zzdkVar) {
        zzvt zzvtVar;
        zzvy.zza zza2 = zzvy.zzc().zza(zzdkVar.zze());
        zzdk.zzc zzg = zzdkVar.zzg();
        if (zzdk.zzc.zza.equals(zzg)) {
            zzvtVar = zzvt.SHA1;
        } else if (zzdk.zzc.zzb.equals(zzg)) {
            zzvtVar = zzvt.SHA224;
        } else if (zzdk.zzc.zzc.equals(zzg)) {
            zzvtVar = zzvt.SHA256;
        } else if (zzdk.zzc.zzd.equals(zzg)) {
            zzvtVar = zzvt.SHA384;
        } else if (zzdk.zzc.zze.equals(zzg)) {
            zzvtVar = zzvt.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzg)));
        }
        return (zzvy) ((zzaky) zza2.zza(zzvtVar).zze());
    }

    private static zzxu zza(zzdk.zzb zzbVar) {
        if (zzdk.zzb.zza.equals(zzbVar)) {
            return zzxu.TINK;
        }
        if (zzdk.zzb.zzb.equals(zzbVar)) {
            return zzxu.CRUNCHY;
        }
        if (zzdk.zzb.zzc.equals(zzbVar)) {
            return zzxu.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzbVar)));
    }

    public static void zza() {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
