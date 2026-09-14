package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzid {
    private static final zzaae zza;
    private static final zzpk<zzfz, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzfv, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzig
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.XAesGcmKey").zza(((zzxz) ((zzaky) zzxz.zzb().zza((zzyc) ((zzaky) zzyc.zzb().zza(r1.zzb()).zze())).zze())).a_()).zza(zzid.zza(((zzfz) zzceVar).zzc())).zze()));
                return zzb3;
            }
        }, zzfz.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzif
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzfz zzb3;
                zzb3 = zzid.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzii
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzxw) ((zzaky) zzxw.zzb().zza(zzajp.zza(r1.zze().zza(zzck.zza(zzckVar)))).zza((zzyc) ((zzaky) zzyc.zzb().zza(((zzfz) ((zzcx) r1.zza())).zzb()).zze())).zze())).a_(), zzws.zza.SYMMETRIC, zzid.zza(((zzfz) ((zzcx) r1.zza())).zzc()), ((zzfv) zzbmVar).zzb());
                return zza2;
            }
        }, zzfv.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzih
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzfv zzb3;
                zzb3 = zzid.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfv zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            try {
                zzxw zza2 = zzxw.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    if (zza2.zze().zzb() == 32) {
                        return zzfv.zza(zzfz.zza(zza(zzqeVar.zzc()), zza2.zzd().zza()), zzaaf.zza(zza2.zze().zzd(), zzck.zza(zzckVar)), zzqeVar.zze());
                    }
                    throw new GeneralSecurityException("Only 32 byte key size is accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing XAesGcmKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
    }

    private static zzfz.zza zza(zzxu zzxuVar) {
        int i = zzik.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzfz.zza.zza;
        }
        if (i == 2) {
            return zzfz.zza.zzb;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfz zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            try {
                zzxz zza2 = zzxz.zza(zzqdVar.zza().zze(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzfz.zza(zza(zzqdVar.zza().zzd()), zza2.zzd().zza());
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzfz.zza zzaVar) {
        if (Objects.equals(zzaVar, zzfz.zza.zza)) {
            return zzxu.TINK;
        }
        if (Objects.equals(zzaVar, zzfz.zza.zzb)) {
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
