package com.google.android.gms.internal.p002firebaseauthapi;

import io.flutter.embedding.android.KeyboardMap;
import java.util.Arrays;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class zzib {
    private static long zza(byte[] bArr, int i, int i3) {
        return (zza(bArr, i) >> i3) & 67108863;
    }

    private static long zza(byte[] bArr, int i) {
        return (((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16)) & KeyboardMap.kValueMask;
    }

    private static void zza(byte[] bArr, long j2, int i) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i + i3] = (byte) (255 & j2);
            i3++;
            j2 >>= 8;
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long zza = zza(bArr, 0, 0) & 67108863;
            int i = 3;
            int i3 = 2;
            long zza2 = zza(bArr, 3, 2) & 67108611;
            long zza3 = zza(bArr, 6, 4) & 67092735;
            long zza4 = zza(bArr, 9, 6) & 66076671;
            long zza5 = zza(bArr, 12, 8) & 1048575;
            long j2 = zza2 * 5;
            long j3 = zza3 * 5;
            long j4 = zza4 * 5;
            long j5 = zza5 * 5;
            int i4 = 17;
            byte[] bArr3 = new byte[17];
            long j6 = 0;
            int i5 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            while (i5 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i5);
                System.arraycopy(bArr2, i5, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i4, (byte) 0);
                }
                long zza6 = j10 + zza(bArr3, 0, 0);
                long zza7 = j6 + zza(bArr3, i, i3);
                long zza8 = j7 + zza(bArr3, 6, 4);
                long zza9 = j8 + zza(bArr3, 9, 6);
                long j11 = zza2;
                long zza10 = j9 + (zza(bArr3, 12, 8) | (bArr3[16] << 24));
                long j12 = (zza10 * j2) + (zza9 * j3) + (zza8 * j4) + (zza7 * j5) + (zza6 * zza);
                long j13 = (zza10 * j3) + (zza9 * j4) + (zza8 * j5) + (zza7 * zza) + (zza6 * j11);
                long j14 = (zza10 * j4) + (zza9 * j5) + (zza8 * zza) + (zza7 * j11) + (zza6 * zza3);
                long j15 = (zza10 * j5) + (zza9 * zza) + (zza8 * j11) + (zza7 * zza3) + (zza6 * zza4);
                long j16 = zza9 * j11;
                long j17 = zza10 * zza;
                long j18 = j13 + (j12 >> 26);
                long j19 = j14 + (j18 >> 26);
                long j20 = j15 + (j19 >> 26);
                long j21 = j17 + j16 + (zza8 * zza3) + (zza7 * zza4) + (zza6 * zza5) + (j20 >> 26);
                long j22 = j21 >> 26;
                j9 = j21 & 67108863;
                long j23 = (j22 * 5) + (j12 & 67108863);
                i5 += 16;
                j7 = j19 & 67108863;
                j8 = j20 & 67108863;
                i4 = 17;
                i = 3;
                j10 = j23 & 67108863;
                j6 = (j18 & 67108863) + (j23 >> 26);
                zza2 = j11;
                i3 = 2;
            }
            long j24 = j7 + (j6 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j8 + (j24 >> 26);
            long j27 = j26 & 67108863;
            long j28 = j9 + (j26 >> 26);
            long j29 = j28 & 67108863;
            long j30 = ((j28 >> 26) * 5) + j10;
            long j31 = j30 >> 26;
            long j32 = j30 & 67108863;
            long j33 = (j6 & 67108863) + j31;
            long j34 = j32 + 5;
            long j35 = j34 & 67108863;
            long j36 = (j34 >> 26) + j33;
            long j37 = j25 + (j36 >> 26);
            long j38 = j27 + (j37 >> 26);
            long j39 = (j29 + (j38 >> 26)) - 67108864;
            long j40 = j39 >> 63;
            long j41 = ~j40;
            long j42 = (j32 & j40) | (j35 & j41);
            long j43 = (j33 & j40) | (j36 & 67108863 & j41);
            long j44 = (j25 & j40) | (j37 & 67108863 & j41);
            long j45 = (j27 & j40) | (j38 & 67108863 & j41);
            long j46 = (j42 | (j43 << 26)) & KeyboardMap.kValueMask;
            long j47 = ((j43 >> 6) | (j44 << 20)) & KeyboardMap.kValueMask;
            long j48 = ((j44 >> 12) | (j45 << 14)) & KeyboardMap.kValueMask;
            long j49 = ((((j39 & j41) | (j29 & j40)) << 8) | (j45 >> 18)) & KeyboardMap.kValueMask;
            long zza11 = j46 + zza(bArr, 16);
            long j50 = zza11 & KeyboardMap.kValueMask;
            long zza12 = j47 + zza(bArr, 20) + (zza11 >> 32);
            long j51 = zza12 & KeyboardMap.kValueMask;
            long zza13 = j48 + zza(bArr, 24) + (zza12 >> 32);
            long j52 = zza13 & KeyboardMap.kValueMask;
            long zza14 = (j49 + zza(bArr, 28) + (zza13 >> 32)) & KeyboardMap.kValueMask;
            byte[] bArr4 = new byte[16];
            zza(bArr4, j50, 0);
            zza(bArr4, j51, 4);
            zza(bArr4, j52, 8);
            zza(bArr4, zza14, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
