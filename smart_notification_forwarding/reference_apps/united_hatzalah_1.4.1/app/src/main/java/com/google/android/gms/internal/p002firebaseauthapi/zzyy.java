package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* loaded from: classes.dex */
public final class zzyy implements zzbk {
    static final zznk<zzzc, zzke.zza> zza = zznk.zza().zza(zzzc.NIST_P256, zzke.zza.zza).zza(zzzc.NIST_P384, zzke.zza.zzb).zza(zzzc.NIST_P521, zzke.zza.zzc).zza();
    static final zznk<zzzb, zzke.zzc> zzb = zznk.zza().zza(zzzb.UNCOMPRESSED, zzke.zzc.zzb).zza(zzzb.COMPRESSED, zzke.zzc.zza).zza(zzzb.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzke.zzc.zzc).zza();

    private zzyy(ECPublicKey eCPublicKey, byte[] bArr, String str, zzzb zzzbVar, zzlq zzlqVar, byte[] bArr2) {
        zzni.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        new zzza(eCPublicKey);
    }

    public static zzbk zza(zzkg zzkgVar) {
        zzzc zza2 = zza.zza((zznk<zzzc, zzke.zza>) ((zzke) ((zzlj) zzkgVar.zza())).zzd());
        byte[] byteArray = zzkgVar.zzf().getAffineX().toByteArray();
        byte[] byteArray2 = zzkgVar.zzf().getAffineY().toByteArray();
        ECParameterSpec zza3 = zzyz.zza(zza2);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zzni.zza(eCPoint, zza3.getCurve());
        ECPublicKey eCPublicKey = (ECPublicKey) zzzd.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza3));
        byte[] bArr = new byte[0];
        if (((zzke) ((zzlj) zzkgVar.zza())).zzh() != null) {
            bArr = ((zzke) ((zzlj) zzkgVar.zza())).zzh().zzb();
        }
        return new zzyy(eCPublicKey, bArr, zza(((zzke) ((zzlj) zzkgVar.zza())).zze()), zzb.zza((zznk<zzzb, zzke.zzc>) ((zzke) ((zzlj) zzkgVar.zza())).zzf()), zzlm.zza((zzke) ((zzlj) zzkgVar.zza())), zzkgVar.zzd().zzb());
    }

    public static final String zza(zzke.zzd zzdVar) {
        if (zzdVar.equals(zzke.zzd.zza)) {
            return "HmacSha1";
        }
        if (zzdVar.equals(zzke.zzd.zzb)) {
            return "HmacSha224";
        }
        if (zzdVar.equals(zzke.zzd.zzc)) {
            return "HmacSha256";
        }
        if (zzdVar.equals(zzke.zzd.zzd)) {
            return "HmacSha384";
        }
        if (zzdVar.equals(zzke.zzd.zze)) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: ".concat(String.valueOf(zzdVar)));
    }
}
