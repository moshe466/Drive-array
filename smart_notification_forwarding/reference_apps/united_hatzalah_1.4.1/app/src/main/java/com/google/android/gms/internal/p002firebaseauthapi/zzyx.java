package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzyx {
    private ECPrivateKey zza;

    public zzyx(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, zzzb zzzbVar) {
        byte[] zza = zzyt.zza(bArr, zzyz.zza(this.zza, zzyz.zza(this.zza.getParams(), zzzbVar, bArr)));
        Mac zza2 = zzzd.zzb.zza(str);
        if (i <= zza2.getMacLength() * 255) {
            if (bArr2 != null && bArr2.length != 0) {
                zza2.init(new SecretKeySpec(bArr2, str));
            } else {
                zza2.init(new SecretKeySpec(new byte[zza2.getMacLength()], str));
            }
            byte[] bArr4 = new byte[i];
            zza2.init(new SecretKeySpec(zza2.doFinal(zza), str));
            byte[] bArr5 = new byte[0];
            int i3 = 1;
            int i4 = 0;
            while (true) {
                zza2.update(bArr5);
                zza2.update(bArr3);
                zza2.update((byte) i3);
                bArr5 = zza2.doFinal();
                if (bArr5.length + i4 < i) {
                    System.arraycopy(bArr5, 0, bArr4, i4, bArr5.length);
                    i4 += bArr5.length;
                    i3++;
                } else {
                    System.arraycopy(bArr5, 0, bArr4, i4, i - i4);
                    return bArr4;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }
}
