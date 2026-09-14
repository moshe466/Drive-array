package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class zznp {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    public static void zza(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        zzb(jArr3, jArr2);
        zzb(jArr12, jArr3);
        zzb(jArr11, jArr12);
        zza(jArr4, jArr11, jArr2);
        zza(jArr5, jArr4, jArr3);
        zzb(jArr11, jArr5);
        zza(jArr6, jArr11, jArr4);
        zzb(jArr11, jArr6);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zza(jArr7, jArr11, jArr6);
        zzb(jArr11, jArr7);
        zzb(jArr12, jArr11);
        for (int i = 2; i < 10; i += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr8, jArr12, jArr7);
        zzb(jArr11, jArr8);
        zzb(jArr12, jArr11);
        for (int i3 = 2; i3 < 20; i3 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr8);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        for (int i4 = 2; i4 < 10; i4 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr9, jArr11, jArr7);
        zzb(jArr11, jArr9);
        zzb(jArr12, jArr11);
        for (int i5 = 2; i5 < 50; i5 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr10, jArr12, jArr9);
        zzb(jArr12, jArr10);
        zzb(jArr11, jArr12);
        for (int i6 = 2; i6 < 100; i6 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr12, jArr11, jArr10);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        for (int i7 = 2; i7 < 50; i7 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr9);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zza(jArr, jArr12, jArr5);
    }

    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j2 = jArr2[0];
        long j3 = jArr3[1] * j2;
        long j4 = jArr2[1];
        long j5 = jArr3[0];
        jArr[1] = (j4 * j5) + j3;
        long j6 = jArr2[1];
        long j7 = jArr3[1];
        jArr[2] = (jArr2[2] * j5) + (jArr3[2] * j2) + (j6 * 2 * j7);
        long j8 = jArr3[2];
        long j9 = jArr2[2];
        jArr[3] = (jArr2[3] * j5) + (jArr3[3] * j2) + (j9 * j7) + (j6 * j8);
        long j10 = jArr3[3];
        long j11 = jArr2[3];
        jArr[4] = (jArr2[4] * j5) + (jArr3[4] * j2) + (((j11 * j7) + (j6 * j10)) * 2) + (j9 * j8);
        long j12 = jArr3[4];
        long j13 = (j6 * j12) + (j11 * j8) + (j9 * j10);
        long j14 = jArr2[4];
        jArr[5] = (jArr2[5] * j5) + (jArr3[5] * j2) + (j14 * j7) + j13;
        long j15 = jArr3[5];
        long j16 = jArr2[5];
        jArr[6] = (jArr2[6] * j5) + (jArr3[6] * j2) + (j14 * j8) + (j9 * j12) + (((j16 * j7) + (j6 * j15) + (j11 * j10)) * 2);
        long j17 = (j16 * j8) + (j9 * j15) + (j14 * j10) + (j11 * j12);
        long j18 = jArr3[6];
        long j19 = (j6 * j18) + j17;
        long j20 = jArr2[6];
        jArr[7] = (jArr2[7] * j5) + (jArr3[7] * j2) + (j20 * j7) + j19;
        long j21 = jArr3[7];
        long j22 = (j6 * j21) + (j16 * j10) + (j11 * j15);
        long j23 = jArr2[7];
        long j24 = (((j23 * j7) + j22) * 2) + (j14 * j12);
        jArr[8] = (jArr2[8] * j5) + (jArr3[8] * j2) + (j20 * j8) + (j9 * j18) + j24;
        long j25 = (j23 * j8) + (j9 * j21) + (j20 * j10) + (j11 * j18) + (j16 * j12) + (j14 * j15);
        long j26 = jArr3[8];
        long j27 = (j6 * j26) + j25;
        long j28 = jArr2[8];
        jArr[9] = (jArr2[9] * j5) + (j2 * jArr3[9]) + (j28 * j7) + j27;
        long j29 = (j23 * j10) + (j11 * j21) + (j16 * j15);
        long j30 = jArr3[9];
        long j31 = jArr2[9];
        long j32 = j14 * j18;
        jArr[10] = (j28 * j8) + (j9 * j26) + (j20 * j12) + j32 + (((j7 * j31) + (j6 * j30) + j29) * 2);
        long j33 = j9 * j30;
        long j34 = j8 * j31;
        jArr[11] = j34 + j33 + (j28 * j10) + (j11 * j26) + (j23 * j12) + (j14 * j21) + (j20 * j15) + (j16 * j18);
        long j35 = j11 * j30;
        long j36 = j10 * j31;
        long j37 = j28 * j12;
        jArr[12] = j37 + (j14 * j26) + ((j36 + j35 + (j23 * j15) + (j16 * j21)) * 2) + (j20 * j18);
        long j38 = j14 * j30;
        long j39 = j12 * j31;
        jArr[13] = j39 + j38 + (j28 * j15) + (j16 * j26) + (j23 * j18) + (j20 * j21);
        long j40 = j15 * j31;
        long j41 = j28 * j18;
        jArr[14] = j41 + (j20 * j26) + ((j40 + (j16 * j30) + (j23 * j21)) * 2);
        long j42 = j20 * j30;
        long j43 = j18 * j31;
        jArr[15] = j43 + j42 + (j28 * j21) + (j23 * j26);
        jArr[16] = (((j21 * j31) + (j23 * j30)) * 2) + (j28 * j26);
        jArr[17] = (j26 * j31) + (j28 * j30);
        jArr[18] = j31 * 2 * j30;
    }

    public static void zzc(long[] jArr, long[] jArr2) {
        zzc(jArr, jArr2, jArr);
    }

    public static void zzd(long[] jArr, long[] jArr2) {
        zzd(jArr, jArr, jArr2);
    }

    private static void zze(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        zzb(jArr);
        zza(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void zzc(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    public static void zzd(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    public static byte[] zzc(long[] jArr) {
        int i;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                break;
            }
            int i5 = 0;
            while (i5 < 9) {
                long j2 = copyOf[i5];
                int i6 = -((int) (((j2 >> 31) & j2) >> zzd[i5 & 1]));
                copyOf[i5] = j2 + (i6 << r14);
                i5++;
                copyOf[i5] = copyOf[i5] - i6;
            }
            long j3 = copyOf[9];
            copyOf[9] = j3 + (r6 << 25);
            copyOf[0] = copyOf[0] - ((-((int) (((j3 >> 31) & j3) >> 25))) * 19);
            i4++;
        }
        long j4 = copyOf[0];
        copyOf[0] = j4 + (r3 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j4 >> 31) & j4) >> 26)));
        int i7 = 0;
        while (i7 < 2) {
            int i8 = i3;
            while (i8 < 9) {
                long j5 = copyOf[i8];
                int i9 = i3;
                int i10 = (int) (j5 >> zzd[i8 & 1]);
                copyOf[i8] = j5 & zzc[r15];
                i8++;
                copyOf[i8] = copyOf[i8] + i10;
                i3 = i9;
                i7 = i7;
            }
            i7++;
        }
        int i11 = i3;
        copyOf[9] = copyOf[9] & 33554431;
        long j6 = (((int) (r2 >> 25)) * 19) + copyOf[i11];
        copyOf[i11] = j6;
        int i12 = ~((((int) j6) - 67108845) >> 31);
        for (int i13 = 1; i13 < 10; i13++) {
            int i14 = ~(((int) copyOf[i13]) ^ zzc[i13 & 1]);
            int i15 = i14 & (i14 << 16);
            int i16 = i15 & (i15 << 8);
            int i17 = i16 & (i16 << 4);
            int i18 = i17 & (i17 << 2);
            i12 &= (i18 & (i18 << 1)) >> 31;
        }
        copyOf[i11] = copyOf[i11] - (67108845 & i12);
        long j7 = 33554431 & i12;
        copyOf[1] = copyOf[1] - j7;
        for (i = 2; i < 10; i += 2) {
            copyOf[i] = copyOf[i] - (67108863 & i12);
            int i19 = i + 1;
            copyOf[i19] = copyOf[i19] - j7;
        }
        for (int i20 = i11; i20 < 10; i20++) {
            copyOf[i20] = copyOf[i20] << zzb[i20];
        }
        byte[] bArr = new byte[32];
        for (int i21 = i11; i21 < 10; i21++) {
            int i22 = zza[i21];
            long j8 = bArr[i22];
            long j9 = copyOf[i21];
            bArr[i22] = (byte) (j8 | (j9 & 255));
            bArr[i22 + 1] = (byte) (bArr[r5] | ((j9 >> 8) & 255));
            bArr[i22 + 2] = (byte) (bArr[r5] | ((j9 >> 16) & 255));
            bArr[i22 + 3] = (byte) (bArr[r4] | ((j9 >> 24) & 255));
        }
        return bArr;
    }

    public static void zzb(long[] jArr) {
        long j2 = jArr[8];
        long j3 = jArr[18];
        long j4 = j2 + (j3 << 4);
        jArr[8] = j4;
        long j5 = j4 + (j3 << 1);
        jArr[8] = j5;
        jArr[8] = j5 + j3;
        long j6 = jArr[7];
        long j7 = jArr[17];
        long j8 = j6 + (j7 << 4);
        jArr[7] = j8;
        long j9 = j8 + (j7 << 1);
        jArr[7] = j9;
        jArr[7] = j9 + j7;
        long j10 = jArr[6];
        long j11 = jArr[16];
        long j12 = j10 + (j11 << 4);
        jArr[6] = j12;
        long j13 = j12 + (j11 << 1);
        jArr[6] = j13;
        jArr[6] = j13 + j11;
        long j14 = jArr[5];
        long j15 = jArr[15];
        long j16 = j14 + (j15 << 4);
        jArr[5] = j16;
        long j17 = j16 + (j15 << 1);
        jArr[5] = j17;
        jArr[5] = j17 + j15;
        long j18 = jArr[4];
        long j19 = jArr[14];
        long j20 = j18 + (j19 << 4);
        jArr[4] = j20;
        long j21 = j20 + (j19 << 1);
        jArr[4] = j21;
        jArr[4] = j21 + j19;
        long j22 = jArr[3];
        long j23 = jArr[13];
        long j24 = j22 + (j23 << 4);
        jArr[3] = j24;
        long j25 = j24 + (j23 << 1);
        jArr[3] = j25;
        jArr[3] = j25 + j23;
        long j26 = jArr[2];
        long j27 = jArr[12];
        long j28 = j26 + (j27 << 4);
        jArr[2] = j28;
        long j29 = j28 + (j27 << 1);
        jArr[2] = j29;
        jArr[2] = j29 + j27;
        long j30 = jArr[1];
        long j31 = jArr[11];
        long j32 = j30 + (j31 << 4);
        jArr[1] = j32;
        long j33 = j32 + (j31 << 1);
        jArr[1] = j33;
        jArr[1] = j33 + j31;
        long j34 = jArr[0];
        long j35 = jArr[10];
        long j36 = j34 + (j35 << 4);
        jArr[0] = j36;
        long j37 = j36 + (j35 << 1);
        jArr[0] = j37;
        jArr[0] = j37 + j35;
    }

    public static void zzb(long[] jArr, long[] jArr2) {
        long j2 = jArr2[0];
        long j3 = jArr2[1];
        long j4 = jArr2[2];
        long j5 = jArr2[3];
        long j6 = jArr2[4];
        long j7 = jArr2[5];
        long j8 = jArr2[6];
        long j9 = jArr2[7];
        long j10 = jArr2[8];
        long j11 = jArr2[9];
        zze(new long[]{j2 * j2, j2 * 2 * j3, ((j2 * j4) + (j3 * j3)) * 2, ((j2 * j5) + (j3 * j4)) * 2, (j2 * 2 * j6) + (j3 * 4 * j5) + (j4 * j4), ((j2 * j7) + (j3 * j6) + (j4 * j5)) * 2, ((j3 * 2 * j7) + (j2 * j8) + (j4 * j6) + (j5 * j5)) * 2, ((j2 * j9) + (j3 * j8) + (j4 * j7) + (j5 * j6)) * 2, (((((j5 * j7) + (j3 * j9)) * 2) + (j2 * j10) + (j4 * j8)) * 2) + (j6 * j6), ((j2 * j11) + (j3 * j10) + (j4 * j9) + (j5 * j8) + (j6 * j7)) * 2, ((((j3 * j11) + (j5 * j9)) * 2) + (j4 * j10) + (j6 * j8) + (j7 * j7)) * 2, ((j4 * j11) + (j5 * j10) + (j6 * j9) + (j7 * j8)) * 2, (((((j5 * j11) + (j7 * j9)) * 2) + (j6 * j10)) * 2) + (j8 * j8), ((j6 * j11) + (j7 * j10) + (j8 * j9)) * 2, ((j7 * 2 * j11) + (j8 * j10) + (j9 * j9)) * 2, ((j8 * j11) + (j9 * j10)) * 2, (j9 * 4 * j11) + (j10 * j10), j10 * 2 * j11, 2 * j11 * j11}, jArr);
    }

    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zze(jArr4, jArr);
    }

    public static void zza(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j2 = jArr[i];
            long j3 = j2 / 67108864;
            jArr[i] = j2 - (j3 << 26);
            int i3 = i + 1;
            long j4 = jArr[i3] + j3;
            jArr[i3] = j4;
            long j5 = j4 / 33554432;
            jArr[i3] = j4 - (j5 << 25);
            i += 2;
            jArr[i] = jArr[i] + j5;
        }
        long j6 = jArr[0];
        long j7 = jArr[10];
        long j8 = j6 + (j7 << 4);
        jArr[0] = j8;
        long j9 = j8 + (j7 << 1);
        jArr[0] = j9;
        long j10 = j9 + j7;
        jArr[0] = j10;
        jArr[10] = 0;
        long j11 = j10 / 67108864;
        jArr[0] = j10 - (j11 << 26);
        jArr[1] = jArr[1] + j11;
    }

    public static void zza(long[] jArr, long[] jArr2, long j2) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j2;
        }
    }

    public static long[] zza(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i3 = zza[i];
            jArr[i] = (((((bArr[i3] & ForkServer.ERROR) | ((bArr[i3 + 1] & ForkServer.ERROR) << 8)) | ((bArr[i3 + 2] & ForkServer.ERROR) << 16)) | ((bArr[i3 + 3] & ForkServer.ERROR) << 24)) >> zzb[i]) & zzc[i & 1];
        }
        return jArr;
    }
}
