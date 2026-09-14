package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import e0.a;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzyl implements zzzu {
    private static final zzix.zza zza = zzix.zza.zzb;
    private static final ThreadLocal<Cipher> zzb = new zzyo();
    private final SecretKeySpec zzc;
    private final int zzd;
    private final int zze;

    public zzyl(byte[] bArr, int i) {
        if (zza.zza()) {
            zzzz.zza(bArr.length);
            this.zzc = new SecretKeySpec(bArr, "AES");
            int blockSize = zzb.get().getBlockSize();
            this.zze = blockSize;
            if (i >= 12 && i <= blockSize) {
                this.zzd = i;
                return;
            }
            throw new GeneralSecurityException("invalid IV size");
        }
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    private final void zza(byte[] bArr, int i, int i3, byte[] bArr2, int i4, byte[] bArr3, boolean z3) {
        Cipher cipher = zzb.get();
        byte[] bArr4 = new byte[this.zze];
        System.arraycopy(bArr3, 0, bArr4, 0, this.zzd);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z3) {
            cipher.init(1, this.zzc, ivParameterSpec);
        } else {
            cipher.init(2, this.zzc, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i3, bArr2, i4) != i3) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzu
    public final byte[] zzb(byte[] bArr) {
        int length = bArr.length;
        int i = this.zzd;
        if (length <= Api.BaseClientBuilder.API_PRIORITY_OTHER - i) {
            byte[] bArr2 = new byte[bArr.length + i];
            byte[] zza2 = zzqg.zza(i);
            System.arraycopy(zza2, 0, bArr2, 0, this.zzd);
            zza(bArr, 0, bArr.length, bArr2, this.zzd, zza2, true);
            return bArr2;
        }
        throw new GeneralSecurityException(a.c(Api.BaseClientBuilder.API_PRIORITY_OTHER - this.zzd, "plaintext length can not exceed "));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzu
    public final byte[] zza(byte[] bArr) {
        int length = bArr.length;
        int i = this.zzd;
        if (length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int length2 = bArr.length;
            int i3 = this.zzd;
            byte[] bArr3 = new byte[length2 - i3];
            zza(bArr, i3, bArr.length - i3, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
