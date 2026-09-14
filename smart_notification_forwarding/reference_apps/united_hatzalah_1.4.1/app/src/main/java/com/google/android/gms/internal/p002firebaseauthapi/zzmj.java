package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzmj {
    private static final zzpr<zzkl, zzbh> zza = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmi
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzmd.zza((zzkl) zzbmVar);
        }
    }, zzkl.class, zzbh.class);
    private static final zzpr<zzkt, zzbk> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzml
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzmc.zza((zzkt) zzbmVar);
        }
    }, zzkt.class, zzbk.class);
    private static final zzcg<zzbh> zzc = zzoc.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbh.class, zzwm.zzf());
    private static final zzbl<zzbk> zzd = zzoc.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbk.class, zzws.zza.ASYMMETRIC_PUBLIC, zzwp.d_());
    private static final zzou<zzki> zze = new zzou() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmk
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
        public final zzbm zza(zzce zzceVar, Integer num) {
            return zzmj.zza((zzki) zzceVar, num);
        }
    };

    public static /* synthetic */ zzkl zza(zzki zzkiVar, Integer num) {
        byte[] bArr;
        zzaae zza2;
        zzaaf zza3;
        if (zzkiVar.zze().equals(zzki.zzd.zzd)) {
            byte[] zza4 = zzaac.zza();
            zza3 = zzaaf.zza(zza4, zzbj.zza());
            zza2 = zzaae.zza(zzaac.zza(zza4));
        } else {
            if (!zzkiVar.zze().equals(zzki.zzd.zza) && !zzkiVar.zze().equals(zzki.zzd.zzb) && !zzkiVar.zze().equals(zzki.zzd.zzc)) {
                throw new GeneralSecurityException("Unknown KEM ID");
            }
            zzzc zzc2 = zzmn.zzc(zzkiVar.zze());
            KeyPair zza5 = zzyz.zza(zzyz.zza(zzc2));
            zzzb zzzbVar = zzzb.UNCOMPRESSED;
            ECPoint w3 = ((ECPublicKey) zza5.getPublic()).getW();
            EllipticCurve curve = zzyz.zza(zzc2).getCurve();
            zzni.zza(w3, curve);
            int zza6 = zzyz.zza(curve);
            int ordinal = zzzbVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    int i = zza6 + 1;
                    bArr = new byte[i];
                    byte[] zza7 = zznh.zza(w3.getAffineX());
                    System.arraycopy(zza7, 0, bArr, i - zza7.length, zza7.length);
                    bArr[0] = (byte) (w3.getAffineY().testBit(0) ? 3 : 2);
                } else if (ordinal == 2) {
                    int i3 = zza6 * 2;
                    bArr = new byte[i3];
                    byte[] zza8 = zznh.zza(w3.getAffineX());
                    if (zza8.length > zza6) {
                        zza8 = Arrays.copyOfRange(zza8, zza8.length - zza6, zza8.length);
                    }
                    byte[] zza9 = zznh.zza(w3.getAffineY());
                    if (zza9.length > zza6) {
                        zza9 = Arrays.copyOfRange(zza9, zza9.length - zza6, zza9.length);
                    }
                    System.arraycopy(zza9, 0, bArr, i3 - zza9.length, zza9.length);
                    System.arraycopy(zza8, 0, bArr, zza6 - zza8.length, zza8.length);
                } else {
                    throw new GeneralSecurityException("invalid format:".concat(String.valueOf(zzzbVar)));
                }
            } else {
                int i4 = (zza6 * 2) + 1;
                bArr = new byte[i4];
                byte[] zza10 = zznh.zza(w3.getAffineX());
                byte[] zza11 = zznh.zza(w3.getAffineY());
                System.arraycopy(zza11, 0, bArr, i4 - zza11.length, zza11.length);
                System.arraycopy(zza10, 0, bArr, (zza6 + 1) - zza10.length, zza10.length);
                bArr[0] = 4;
            }
            zza2 = zzaae.zza(bArr);
            zza3 = zzaaf.zza(zznh.zza(((ECPrivateKey) zza5.getPrivate()).getS(), zzmn.zza(zzkiVar.zze())), zzbj.zza());
        }
        return zzkl.zza(zzkt.zza(zzkiVar, zza2, num), zza3);
    }

    public static void zza(boolean z3) {
        if (zzix.zza.zza.zza()) {
            zzkk.zza();
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            zzki.zzb zzc2 = zzki.zzc();
            zzki.zzf zzfVar = zzki.zzf.zza;
            zzki.zzb zza3 = zzc2.zza(zzfVar);
            zzki.zzd zzdVar = zzki.zzd.zzd;
            zzki.zzb zza4 = zza3.zza(zzdVar);
            zzki.zze zzeVar = zzki.zze.zza;
            zzki.zzb zza5 = zza4.zza(zzeVar);
            zzki.zza zzaVar = zzki.zza.zza;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza5.zza(zzaVar).zza());
            zzki.zzb zzc3 = zzki.zzc();
            zzki.zzf zzfVar2 = zzki.zzf.zzc;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc3.zza(zzfVar2).zza(zzdVar).zza(zzeVar).zza(zzaVar).zza());
            zzki.zzb zza6 = zzki.zzc().zza(zzfVar).zza(zzdVar).zza(zzeVar);
            zzki.zza zzaVar2 = zzki.zza.zzb;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zza6.zza(zzaVar2).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar).zza(zzeVar).zza(zzaVar2).zza());
            zzki.zzb zza7 = zzki.zzc().zza(zzfVar).zza(zzdVar).zza(zzeVar);
            zzki.zza zzaVar3 = zzki.zza.zzc;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zza7.zza(zzaVar3).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar).zza(zzeVar).zza(zzaVar3).zza());
            zzki.zzb zza8 = zzki.zzc().zza(zzfVar);
            zzki.zzd zzdVar2 = zzki.zzd.zza;
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza8.zza(zzdVar2).zza(zzeVar).zza(zzaVar).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar2).zza(zzeVar).zza(zzaVar).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzki.zzc().zza(zzfVar).zza(zzdVar2).zza(zzeVar).zza(zzaVar2).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar2).zza(zzeVar).zza(zzaVar2).zza());
            zzki.zzb zza9 = zzki.zzc().zza(zzfVar);
            zzki.zzd zzdVar3 = zzki.zzd.zzb;
            zzki.zzb zza10 = zza9.zza(zzdVar3);
            zzki.zze zzeVar2 = zzki.zze.zzb;
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zza10.zza(zzeVar2).zza(zzaVar).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar3).zza(zzeVar2).zza(zzaVar).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzki.zzc().zza(zzfVar).zza(zzdVar3).zza(zzeVar2).zza(zzaVar2).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar3).zza(zzeVar2).zza(zzaVar2).zza());
            zzki.zzb zza11 = zzki.zzc().zza(zzfVar);
            zzki.zzd zzdVar4 = zzki.zzd.zzc;
            zzki.zzb zza12 = zza11.zza(zzdVar4);
            zzki.zze zzeVar3 = zzki.zze.zzc;
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zza12.zza(zzeVar3).zza(zzaVar).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar4).zza(zzeVar3).zza(zzaVar).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzki.zzc().zza(zzfVar).zza(zzdVar4).zza(zzeVar3).zza(zzaVar2).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzki.zzc().zza(zzfVar2).zza(zzdVar4).zza(zzeVar3).zza(zzaVar2).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzoz.zza().zza(zza);
            zzoz.zza().zza(zzb);
            zzos.zza().zza(zze, zzki.class);
            zznt.zza().zza((zzbl) zzc, true);
            zznt.zza().zza((zzbl) zzd, false);
            return;
        }
        throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
    }
}
