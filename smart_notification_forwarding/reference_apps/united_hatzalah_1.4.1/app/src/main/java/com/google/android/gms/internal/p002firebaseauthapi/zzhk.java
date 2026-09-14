package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzhk implements zzbe {
    private static final zzix.zza zza = zzix.zza.zza;
    private static final byte[] zzb = zzzr.zza("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");
    private static final byte[] zzc = zzzr.zza("070000004041424344454647");
    private static final byte[] zzd = zzzr.zza("a0784d7a4716f3feb4f64e7f4b39bf04");
    private static final ThreadLocal<Cipher> zze = new zzhj();
    private final SecretKey zzf;
    private final byte[] zzg;

    private zzhk(byte[] bArr, byte[] bArr2) {
        if (zza.zza()) {
            if (zzb()) {
                if (bArr.length == 32) {
                    this.zzf = new SecretKeySpec(bArr, "ChaCha20");
                    this.zzg = bArr2;
                    return;
                }
                throw new InvalidKeyException("The key length in bytes must be 32.");
            }
            throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public static boolean zzb() {
        return zze.get() != null;
    }

    public static zzbe zza(zzei zzeiVar) {
        return new zzhk(zzeiVar.zze().zza(zzbj.zza()), zzeiVar.zzd().zzb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzb(Cipher cipher) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(zzc);
            byte[] bArr = zzb;
            cipher.init(2, new SecretKeySpec(bArr, "ChaCha20"), ivParameterSpec);
            byte[] bArr2 = zzd;
            if (cipher.doFinal(bArr2).length != 0) {
                return false;
            }
            cipher.init(2, new SecretKeySpec(bArr, "ChaCha20"), ivParameterSpec);
            return cipher.doFinal(bArr2).length == 0;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public static Cipher zza() {
        return zze.get();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zzg;
            if (length >= bArr3.length + 28) {
                if (zzqq.zza(bArr3, bArr)) {
                    byte[] bArr4 = new byte[12];
                    System.arraycopy(bArr, this.zzg.length, bArr4, 0, 12);
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
                    Cipher cipher = zze.get();
                    cipher.init(2, this.zzf, ivParameterSpec);
                    if (bArr2 != null && bArr2.length != 0) {
                        cipher.updateAAD(bArr2);
                    }
                    byte[] bArr5 = this.zzg;
                    return cipher.doFinal(bArr, bArr5.length + 12, (bArr.length - bArr5.length) - 12);
                }
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new NullPointerException("ciphertext is null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] zza2 = zzqg.zza(12);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(zza2);
            Cipher cipher = zze.get();
            cipher.init(1, this.zzf, ivParameterSpec);
            if (bArr2 != null && bArr2.length != 0) {
                cipher.updateAAD(bArr2);
            }
            int outputSize = cipher.getOutputSize(bArr.length);
            byte[] bArr3 = this.zzg;
            if (outputSize <= 2147483635 - bArr3.length) {
                byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
                System.arraycopy(zza2, 0, copyOf, this.zzg.length, 12);
                if (cipher.doFinal(bArr, 0, bArr.length, copyOf, this.zzg.length + 12) == outputSize) {
                    return copyOf;
                }
                throw new GeneralSecurityException("not enough data written");
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new NullPointerException("plaintext is null");
    }
}
