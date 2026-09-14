package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import e0.a;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzjr {
    private static final zzaae zza;
    private static final zzpk<zzjh, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzja, zzqe> zzd;
    private static final zzns<zzqe> zze;
    private static final Map<zzjh.zzb, zzxu> zzf;
    private static final Map<zzxu, zzjh.zzb> zzg;

    static {
        zzaae zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zza = zzb2;
        zzb = zzpk.zza(new zzpm() { // from class: com.google.android.gms.internal.firebase-auth-api.zzju
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpm
            public final zzqi zza(zzce zzceVar) {
                zzqd zzb3;
                zzb3 = zzqd.zzb((zzww) ((zzaky) zzww.zza().zza("type.googleapis.com/google.crypto.tink.AesSivKey").zza(((zzun) ((zzaky) zzun.zzc().zza(r1.zzb()).zze())).a_()).zza(zzjr.zza(((zzjh) zzceVar).zzd())).zze()));
                return zzb3;
            }
        }, zzjh.class, zzqd.class);
        zzc = zzpg.zza(new zzpi() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjt
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpi
            public final zzce zza(zzqi zzqiVar) {
                zzjh zzb3;
                zzb3 = zzjr.zzb((zzqd) zzqiVar);
                return zzb3;
            }
        }, zzb2, zzqd.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjw
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzny
            public final zzqi zza(zzbm zzbmVar, zzck zzckVar) {
                zzqe zza2;
                zza2 = zzqe.zza("type.googleapis.com/google.crypto.tink.AesSivKey", ((zzuk) ((zzaky) zzuk.zzb().zza(zzajp.zza(r1.zzf().zza(zzck.zza(zzckVar)))).zze())).a_(), zzws.zza.SYMMETRIC, zzjr.zza(((zzjh) ((zzjm) r1.zza())).zzd()), ((zzja) zzbmVar).zzb());
                return zza2;
            }
        }, zzja.class, zzqe.class);
        zze = zzns.zza(new zznu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjv
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznu
            public final zzbm zza(zzqi zzqiVar, zzck zzckVar) {
                zzja zzb3;
                zzb3 = zzjr.zzb((zzqe) zzqiVar, zzckVar);
                return zzb3;
            }
        }, zzb2, zzqe.class);
        HashMap hashMap = new HashMap();
        zzjh.zzb zzbVar = zzjh.zzb.zzc;
        zzxu zzxuVar = zzxu.RAW;
        hashMap.put(zzbVar, zzxuVar);
        zzjh.zzb zzbVar2 = zzjh.zzb.zza;
        zzxu zzxuVar2 = zzxu.TINK;
        hashMap.put(zzbVar2, zzxuVar2);
        zzjh.zzb zzbVar3 = zzjh.zzb.zzb;
        zzxu zzxuVar3 = zzxu.CRUNCHY;
        hashMap.put(zzbVar3, zzxuVar3);
        zzf = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzxu.class);
        enumMap.put((EnumMap) zzxuVar, (zzxu) zzbVar);
        enumMap.put((EnumMap) zzxuVar2, (zzxu) zzbVar2);
        enumMap.put((EnumMap) zzxuVar3, (zzxu) zzbVar3);
        enumMap.put((EnumMap) zzxu.LEGACY, (zzxu) zzbVar3);
        zzg = Collections.unmodifiableMap(enumMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzja zzb(zzqe zzqeVar, zzck zzckVar) {
        if (zzqeVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzuk zza2 = zzuk.zza(zzqeVar.zzd(), zzakk.zza());
                if (zza2.zza() == 0) {
                    return zzja.zzc().zza(zzjh.zzc().zza(zza2.zzd().zzb()).zza(zza(zzqeVar.zzc())).zza()).zza(zzaaf.zza(zza2.zzd().zzd(), zzck.zza(zzckVar))).zza(zzqeVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
    }

    private static zzjh.zzb zza(zzxu zzxuVar) {
        Map<zzxu, zzjh.zzb> map = zzg;
        if (map.containsKey(zzxuVar)) {
            return map.get(zzxuVar);
        }
        throw new GeneralSecurityException(a.c(zzxuVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjh zzb(zzqd zzqdVar) {
        if (zzqdVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzun zza2 = zzun.zza(zzqdVar.zza().zze(), zzakk.zza());
                if (zza2.zzb() == 0) {
                    return zzjh.zzc().zza(zza2.zza()).zza(zza(zzqdVar.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalf e4) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException(a.d("Wrong type URL in call to AesSivParameters.parseParameters: ", zzqdVar.zza().zzf()));
    }

    private static zzxu zza(zzjh.zzb zzbVar) {
        Map<zzjh.zzb, zzxu> map = zzf;
        if (map.containsKey(zzbVar)) {
            return map.get(zzbVar);
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
