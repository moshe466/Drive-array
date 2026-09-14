package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzaac {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b4 = (byte) (copyOf[31] & Byte.MAX_VALUE);
            copyOf[31] = b4;
            copyOf[31] = (byte) (b4 | 64);
            zznj.zza(jArr, copyOf, bArr2);
            return zznp.zzc(jArr);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] zza() {
        byte[] zza = zzqg.zza(32);
        zza[0] = (byte) (zza[0] | 7);
        byte b4 = (byte) (zza[31] & 63);
        zza[31] = b4;
        zza[31] = (byte) (b4 | 128);
        return zza;
    }

    public static byte[] zza(byte[] bArr) {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
