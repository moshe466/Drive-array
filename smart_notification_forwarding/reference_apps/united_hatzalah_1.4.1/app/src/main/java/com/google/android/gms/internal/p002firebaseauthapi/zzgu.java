package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzgu {
    private static final ThreadLocal<Cipher> zza = new zzgt();

    public static AlgorithmParameterSpec zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static SecretKey zzb(byte[] bArr) {
        zzzz.zza(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec zza(byte[] bArr, int i, int i3) {
        Integer zzb = zzqq.zzb();
        if (zzb != null && zzb.intValue() <= 19) {
            return new IvParameterSpec(bArr, i, i3);
        }
        return new GCMParameterSpec(128, bArr, i, i3);
    }

    public static Cipher zza() {
        return zza.get();
    }
}
