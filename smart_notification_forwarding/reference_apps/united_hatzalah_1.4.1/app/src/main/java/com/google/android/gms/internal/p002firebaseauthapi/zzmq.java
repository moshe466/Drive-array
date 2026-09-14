package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
final class zzmq implements zzme {
    private final zzzc zza;
    private final zzly zzb;

    private zzmq(zzly zzlyVar, zzzc zzzcVar) {
        this.zzb = zzlyVar;
        this.zza = zzzcVar;
    }

    public static zzmq zza(zzzc zzzcVar) {
        int i = zzmt.zza[zzzcVar.ordinal()];
        if (i == 1) {
            return new zzmq(new zzly("HmacSha256"), zzzc.NIST_P256);
        }
        if (i == 2) {
            return new zzmq(new zzly("HmacSha384"), zzzc.NIST_P384);
        }
        if (i == 3) {
            return new zzmq(new zzly("HmacSha512"), zzzc.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: ".concat(String.valueOf(zzzcVar)));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzme
    public final byte[] zza(byte[] bArr, zzmh zzmhVar) {
        ECPrivateKey zza = zzyz.zza(this.zza, zzmhVar.zza().zzb());
        zzzc zzzcVar = this.zza;
        byte[] zza2 = zzyz.zza(zza, zzyz.zza(zzyz.zza(zzzcVar), zzzb.UNCOMPRESSED, bArr));
        byte[] zza3 = zzyt.zza(bArr, zzmhVar.zzb().zzb());
        byte[] zza4 = zzmn.zza(zza());
        zzly zzlyVar = this.zzb;
        return zzlyVar.zza(null, zza2, "eae_prk", zza3, "shared_secret", zza4, zzlyVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzme
    public final byte[] zza() {
        int i = zzmt.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzmn.zzc;
        }
        if (i == 2) {
            return zzmn.zzd;
        }
        if (i == 3) {
            return zzmn.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
