package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import e0.a;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class zzyn implements zzbe {
    private static final zzix.zza zza = zzix.zza.zza;
    private static final ThreadLocal<Cipher> zzb = new zzyq();
    private static final ThreadLocal<Cipher> zzc = new zzyp();
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private final SecretKeySpec zzg;
    private final int zzh;

    private zzyn(byte[] bArr, int i, byte[] bArr2) {
        if (zza.zza()) {
            if (i != 12 && i != 16) {
                throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
            }
            this.zzh = i;
            zzzz.zza(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zzg = secretKeySpec;
            Cipher cipher = zzb.get();
            cipher.init(1, secretKeySpec);
            byte[] zza2 = zza(cipher.doFinal(new byte[16]));
            this.zzd = zza2;
            this.zze = zza(zza2);
            this.zzf = bArr2;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    public static zzbe zza(zzdl zzdlVar) {
        if (zza.zza()) {
            if (((zzdq) ((zzcx) zzdlVar.zza())).zzd() == 16) {
                return new zzyn(zzdlVar.zzf().zza(zzbj.zza()), ((zzdq) ((zzcx) zzdlVar.zza())).zzb(), zzdlVar.zzd().zzb());
            }
            throw new GeneralSecurityException(a.c(((zzdq) ((zzcx) zzdlVar.zza())).zzd(), "AesEaxJce only supports 16 byte tag size, not "));
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    private static void zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        int length = bArr.length;
        byte[] bArr4 = this.zzf;
        int length2 = Api.BaseClientBuilder.API_PRIORITY_OTHER - bArr4.length;
        int i = this.zzh;
        if (length <= (length2 - i) - 16) {
            byte[] copyOf = Arrays.copyOf(bArr4, bArr4.length + i + bArr.length + 16);
            byte[] zza2 = zzqg.zza(this.zzh);
            System.arraycopy(zza2, 0, copyOf, this.zzf.length, this.zzh);
            Cipher cipher = zzb.get();
            cipher.init(1, this.zzg);
            byte[] zza3 = zza(cipher, 0, zza2, 0, zza2.length);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] zza4 = zza(cipher, 1, bArr3, 0, bArr3.length);
            Cipher cipher2 = zzc.get();
            cipher2.init(1, this.zzg, new IvParameterSpec(zza3));
            cipher2.doFinal(bArr, 0, bArr.length, copyOf, this.zzf.length + this.zzh);
            byte[] zza5 = zza(cipher, 2, copyOf, this.zzf.length + this.zzh, bArr.length);
            int length3 = this.zzf.length + bArr.length + this.zzh;
            for (int i3 = 0; i3 < 16; i3++) {
                copyOf[length3 + i3] = (byte) ((zza4[i3] ^ zza3[i3]) ^ zza5[i3]);
            }
            return copyOf;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = this.zzf;
        int length2 = ((length - bArr3.length) - this.zzh) - 16;
        if (length2 >= 0) {
            if (zzqq.zza(bArr3, bArr)) {
                Cipher cipher = zzb.get();
                cipher.init(1, this.zzg);
                byte[] zza2 = zza(cipher, 0, bArr, this.zzf.length, this.zzh);
                byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
                byte[] zza3 = zza(cipher, 1, bArr4, 0, bArr4.length);
                byte[] zza4 = zza(cipher, 2, bArr, this.zzf.length + this.zzh, length2);
                int length3 = bArr.length - 16;
                byte b4 = 0;
                for (int i = 0; i < 16; i++) {
                    b4 = (byte) (b4 | (((bArr[length3 + i] ^ zza3[i]) ^ zza2[i]) ^ zza4[i]));
                }
                if (b4 == 0) {
                    Cipher cipher2 = zzc.get();
                    cipher2.init(1, this.zzg, new IvParameterSpec(zza2));
                    return cipher2.doFinal(bArr, this.zzf.length + this.zzh, length2);
                }
                throw new AEADBadTagException("tag mismatch");
            }
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private static byte[] zza(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i3 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i3] & ForkServer.ERROR) >>> 7));
            i = i3;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i3, int i4) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i4 == 0) {
            zzc(bArr2, this.zzd);
            return cipher.doFinal(bArr2);
        }
        byte[] bArr3 = new byte[16];
        cipher.doFinal(bArr2, 0, 16, bArr3);
        byte[] bArr4 = bArr3;
        byte[] bArr5 = bArr2;
        int i5 = 0;
        while (i4 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                bArr4[i6] = (byte) (bArr4[i6] ^ bArr[(i3 + i5) + i6]);
            }
            cipher.doFinal(bArr4, 0, 16, bArr5);
            i5 += 16;
            byte[] bArr6 = bArr4;
            bArr4 = bArr5;
            bArr5 = bArr6;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i3, i3 + i4);
        if (copyOfRange.length == 16) {
            zzc(copyOfRange, this.zzd);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zze, 16);
            for (int i7 = 0; i7 < copyOfRange.length; i7++) {
                copyOf[i7] = (byte) (copyOf[i7] ^ copyOfRange[i7]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            copyOfRange = copyOf;
        }
        zzc(bArr4, copyOfRange);
        cipher.doFinal(bArr4, 0, 16, bArr5);
        return bArr5;
    }
}
