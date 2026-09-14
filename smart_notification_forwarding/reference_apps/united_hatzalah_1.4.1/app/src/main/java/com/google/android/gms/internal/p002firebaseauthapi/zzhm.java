package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzhm {
    private static final zzaae zza;
    private static final zzpk<zzem, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzei, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhl
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zza(zzut.zzb().a_()).zza(zzhm.zza(((zzem) zzceVar).zzb())).zze()));
                return zzb3;
            }
        }, zzem.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzho
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzem zzb3;
                zzb3 = zzhm.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhn
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzuq) ((zzaky) zzuq.zzb().zza(zzajp.zza(r1.zze().zza(zzck.zza(zzckVar)))).zze())).a_(), zzws.zza.SYMMETRIC, zzhm.zza(((zzem) ((zzcx) r1.zza())).zzb()), ((zzei) zzbmVar).zzb());
                return zza2;
            }
        }, zzei.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhq
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzei zzb3;
                zzb3 = zzhm.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzei zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzuq zza2 = zzuq.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzei.zza(zza(zzqeVar.zzc()), zzaaf.zza(zza2.zzd().zzd(), zzck.zza(zzckVar)), zzqeVar.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
    }

    private static zzem.zza zza(zzxu zzxuVar) {
        int i = zzhp.zza[zzxuVar.ordinal()];
        if (i == 1) {
            return zzem.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzem.zza.zzb;
        }
        if (i == 4) {
            return zzem.zza.zzc;
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzem zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzut.zza(zzqdVar.zza().zze(), zzakk.zza());
                return zzem.zza(zza(zzqdVar.zza().zzd()));
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzem.zza zzaVar) {
        if (zzem.zza.zza.equals(zzaVar)) {
            return zzxu.TINK;
        }
        if (zzem.zza.zzb.equals(zzaVar)) {
            return zzxu.CRUNCHY;
        }
        if (zzem.zza.zzc.equals(zzaVar)) {
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
