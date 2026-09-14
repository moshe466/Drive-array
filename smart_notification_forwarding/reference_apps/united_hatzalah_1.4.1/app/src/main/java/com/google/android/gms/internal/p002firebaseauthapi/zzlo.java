package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
final class zzlo implements zzlq {
    private final int zza;

    public zzlo(zzdz zzdzVar) {
        if (zzdzVar.zzb() == 12) {
            if (zzdzVar.zzd() == 16) {
                if (zzdzVar.zzf() == zzdz.zzb.zzc) {
                    this.zza = zzdzVar.zzc();
                    return;
                }
                throw new GeneralSecurityException("invalid variant");
            }
            throw new GeneralSecurityException("invalid tag size");
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length >= i) {
            if (bArr.length == this.zza) {
                SecretKey zzb = zzgu.zzb(bArr);
                int i3 = i + 12;
                if (bArr2.length >= i + 28) {
                    AlgorithmParameterSpec zza = zzgu.zza(bArr2, i, 12);
                    Cipher zza2 = zzgu.zza();
                    zza2.init(2, zzb, zza);
                    return zza2.doFinal(bArr2, i3, (bArr2.length - i) - 12);
                }
                throw new GeneralSecurityException("ciphertext too short");
            }
            throw new GeneralSecurityException("invalid key size");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
