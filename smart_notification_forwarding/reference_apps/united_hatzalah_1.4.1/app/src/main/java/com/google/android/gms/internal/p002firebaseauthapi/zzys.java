package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import e0.a;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
public final class zzys implements zzbe {
    private static final zzix.zza zza = zzix.zza.zzb;
    private final SecretKey zzb;
    private final byte[] zzc;

    private zzys(byte[] bArr, zzaae zzaaeVar) {
        if (zza.zza()) {
            this.zzb = zzgu.zzb(bArr);
            this.zzc = zzaaeVar.zzb();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static zzbe zza(zzds zzdsVar) {
        if (((zzdz) ((zzcx) zzdsVar.zza())).zzb() == 12) {
            if (((zzdz) ((zzcx) zzdsVar.zza())).zzd() == 16) {
                return new zzys(zzdsVar.zzf().zza(zzbj.zza()), zzdsVar.zzd());
            }
            throw new GeneralSecurityException(a.c(((zzdz) ((zzcx) zzdsVar.zza())).zzd(), "Expected tag Size 16, got "));
        }
        throw new GeneralSecurityException(a.c(((zzdz) ((zzcx) zzdsVar.zza())).zzb(), "Expected IV Size 12, got "));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] zza2 = zzqg.zza(12);
            AlgorithmParameterSpec zza3 = zzgu.zza(zza2);
            Cipher zza4 = zzgu.zza();
            zza4.init(1, this.zzb, zza3);
            if (bArr2 != null && bArr2.length != 0) {
                zza4.updateAAD(bArr2);
            }
            int outputSize = zza4.getOutputSize(bArr.length);
            byte[] bArr3 = this.zzc;
            if (outputSize <= 2147483635 - bArr3.length) {
                byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
                System.arraycopy(zza2, 0, copyOf, this.zzc.length, 12);
                if (zza4.doFinal(bArr, 0, bArr.length, copyOf, this.zzc.length + 12) == outputSize) {
                    return copyOf;
                }
                throw new GeneralSecurityException("not enough data written");
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new NullPointerException("plaintext is null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zzc;
            if (length >= bArr3.length + 28) {
                if (zzqq.zza(bArr3, bArr)) {
                    AlgorithmParameterSpec zza2 = zzgu.zza(bArr, this.zzc.length, 12);
                    Cipher zza3 = zzgu.zza();
                    zza3.init(2, this.zzb, zza2);
                    if (bArr2 != null && bArr2.length != 0) {
                        zza3.updateAAD(bArr2);
                    }
                    byte[] bArr4 = this.zzc;
                    return zza3.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
                }
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new NullPointerException("ciphertext is null");
    }
}
