package G0;

import F0.B0;
import F0.D;
import F0.D1;
import F0.c3;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f834a;

    /* renamed from: b, reason: collision with root package name */
    public static final m f835b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ m[] f836c;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, G0.m] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Enum, G0.m] */
    static {
        byte[] bArr = {-15, -99, -28, -8, 23, -53, 97, -28, -122, -111};
        byte[] bArr2 = new byte[10];
        bArr2[0] = 33;
        bArr2[1] = -43;
        bArr2[2] = -56;
        bArr2[3] = -64;
        bArr2[4] = 19;
        bArr2[5] = -78;
        bArr2[6] = -3;
        long j2 = 67739721;
        long j3 = 4;
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j4 = (b4 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (b4 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (b4 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = b4 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        bArr2[(((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) + 276041730) ^ 343781448] = 13;
        bArr2[8] = 42;
        bArr2[9] = -50;
        a(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        ?? r02 = new Enum(new String(bArr, charset).intern(), 0);
        f834a = r02;
        byte[] bArr3 = {91, -30, 21, -63, 110, -72, -60, -118, -9, 11};
        byte[] bArr4 = new byte[10];
        bArr4[0] = 123;
        bArr4[1] = 79;
        bArr4[2] = -71;
        bArr4[3] = -86;
        long j17 = 340525296;
        long j18 = -3;
        long j19 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 8) + j26;
        long j31 = j19 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        int i = ((int) (((j33 | (j33 >>> 4)) & 16711935) + j30)) + 33710083;
        bArr4[(((~i) & 374235383) - (374235383 & i)) + i] = -72;
        bArr4[5] = 89;
        bArr4[6] = 68;
        bArr4[7] = -87;
        bArr4[8] = -118;
        bArr4[9] = 38;
        a(bArr3, bArr4);
        ?? r12 = new Enum(new String(bArr3, charset).intern(), 1);
        f835b = r12;
        m[] mVarArr = {r02, r12};
        f836c = mVarArr;
        p3.h.p(mVarArr);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
        short[] sArr = null;
        char c4 = 50438;
        int i = 0;
        int i3 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        int i4 = 0;
        while (true) {
            switch (c4) {
                case 60804:
                    if (i < i3) {
                        c4 = 3065;
                    } else {
                        c4 = 11261;
                    }
                case 22124:
                    int i5 = ((short) ((s4 << 4) + sArr[2])) ^ (s4 + s3);
                    short s6 = sArr[3];
                    int i6 = -(s4 >>> 5);
                    int i7 = i6 | s6;
                    int i8 = (i7 - (i6 * 2)) + ((i6 ^ s6) ^ i7);
                    int i9 = -B0.a(i8 | (~i5), i8 - i5);
                    s5 = (short) D.a(s5, 3, -(D1.a(s5, i9) | (i9 & 2)), 1);
                    s4 = (short) (s4 - ((((short) ((s5 << 4) + sArr[0])) ^ (((s3 | s5) - (((~s5) & 39) & s3)) + ((s5 | 39) & s3))) ^ ((s5 >>> 5) + sArr[1])));
                    s3 = (short) (s3 - 40503);
                    i4++;
                    c4 = 17109;
                case 3065:
                    byte b4 = bArr[i];
                    s4 = (short) (((bArr[((i & 1) * 2) + (i ^ 1)] & ForkServer.ERROR) << 8) | ((255 - (b4 | ForkServer.ERROR)) + b4));
                    int i10 = -i;
                    int i11 = i10 | 2;
                    s5 = (short) ((bArr[(i11 - (i10 * 2)) + ((i10 ^ 2) ^ i11)] & ForkServer.ERROR) | ((bArr[i + 3] & ForkServer.ERROR) << 8));
                    s3 = -14624;
                    i4 = 0;
                    c4 = 17109;
                case 50438:
                    sArr = new short[4];
                    i = 0;
                    c4 = 5848;
                case 49265:
                    sArr[i] = (short) ((bArr2[(((~i) & 2) * (i & (-3))) + ((i & 2) * (i | 2))] & ForkServer.ERROR) ^ ((bArr2[(i * 2) + 1] & ForkServer.ERROR) << 8));
                    i++;
                    c4 = 5848;
                case 5255:
                    int i12 = -i;
                    int i13 = -bArr.length;
                    int i14 = i13 | i12;
                    bArr[(i14 - (i13 * 2)) + ((i13 ^ i12) ^ i14)] = (byte) (bArr[bArr.length - i] ^ bArr2[i % 8]);
                    i--;
                    c4 = 33742;
                case 5848:
                    if (i < 4) {
                        c4 = 49265;
                    } else {
                        c4 = 18639;
                    }
                case 11261:
                    i = bArr.length % 4;
                    c4 = 33742;
                case 18639:
                    i3 = bArr.length - (bArr.length % 4);
                    i = 0;
                    c4 = 60804;
                case 15026:
                    break;
                case 33742:
                    if (i > 0) {
                        c4 = 5255;
                    } else {
                        c4 = 15026;
                    }
                case 42144:
                    bArr[i] = (byte) (s4 & 255);
                    bArr[i + 1] = (byte) ((s4 >> 8) & 255);
                    bArr[i + 2] = (byte) (s5 & 255);
                    bArr[i + 3] = (byte) ((s5 >> 8) & 255);
                    i += 4;
                    c4 = 60804;
                case 17109:
                    if (i4 < 32) {
                        c4 = 22124;
                    } else {
                        c4 = 42144;
                    }
                default:
                    c4 = 17109;
            }
            return;
        }
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f836c.clone();
    }
}
