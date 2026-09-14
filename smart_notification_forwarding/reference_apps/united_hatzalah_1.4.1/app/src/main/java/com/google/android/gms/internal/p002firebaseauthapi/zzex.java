package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzev;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzex {
    private static final zzaae zza;
    private static final zzpk<zzev, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzew, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzez
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.KmsAeadKey").zza(((zzxl) ((zzaky) zzxl.zza().zza(r1.zzc()).zze())).a_()).zza(zzex.zza(((zzev) zzceVar).zzb())).zze()));
                return zzb3;
            }
        }, zzev.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzey
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzev zzb3;
                zzb3 = zzex.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzxi) ((zzaky) zzxi.zzb().zza((zzxl) ((zzaky) zzxl.zza().zza(((zzev) ((zzcx) r1.zza())).zzc()).zze())).zze())).a_(), zzws.zza.REMOTE, zzex.zza(((zzev) ((zzcx) r1.zza())).zzb()), ((zzew) zzbmVar).zzb());
                return zza2;
            }
        }, zzew.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfa
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzew zzb3;
                zzb3 = zzex.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzew zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzxi zza2 = zzxi.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzew.zza(zzev.zza(zza2.zzd().zzd(), zza(zzqeVar.zzc())), zzqeVar.zze());
                }
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got ".concat(String.valueOf(zza2)));
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
    }

    private static zzev.zza zza(zzxu zzxuVar) {
        int i = zzfd.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzev.zza.zza;
        }
        if (i == 2) {
            return zzev.zza.zzb;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzev zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzev.zza(zzxl.zza(zzqdVar.zza().zze(), zzakk.zza()).zzd(), zza(zzqdVar.zza().zzd()));
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzev.zza zzaVar) {
        if (zzev.zza.zza.equals(zzaVar)) {
            return zzxu.TINK;
        }
        if (zzev.zza.zzb.equals(zzaVar)) {
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
