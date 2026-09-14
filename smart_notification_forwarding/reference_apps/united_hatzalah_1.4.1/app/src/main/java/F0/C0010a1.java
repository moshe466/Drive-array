package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.a1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0010a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0010a1 f453a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final ReentrantLock f454b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public static G2 f455c;

    /* renamed from: d, reason: collision with root package name */
    public static G2 f456d;

    /* renamed from: e, reason: collision with root package name */
    public static G2 f457e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f458f;

    /* JADX WARN: Type inference failed for: r3v2, types: [F0.a2, F0.G2] */
    /* JADX WARN: Type inference failed for: r3v3, types: [F0.a2, F0.G2] */
    /* JADX WARN: Type inference failed for: r3v4, types: [F0.a2, F0.G2] */
    public static void a(Context context) {
        byte[] bArr = {-105, 15, -1, 15, 14, -118, 65};
        c(bArr, new byte[]{93, 53, -14, 107, 88, -119, 5, 54});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        ReentrantLock reentrantLock = f454b;
        reentrantLock.lock();
        try {
            if (!f458f) {
                byte[] bArr2 = new byte[10];
                bArr2[0] = 106;
                bArr2[1] = 38;
                bArr2[2] = 57;
                bArr2[3] = 3;
                bArr2[4] = 37;
                boolean z3 = f458f;
                bArr2[((((~(z3 ? 1 : 0)) | 1250845105) & 8863761) + 1646264840) ^ 1655128604] = -75;
                bArr2[6] = 11;
                bArr2[7] = -16;
                bArr2[8] = -19;
                bArr2[9] = (((((((-r15) - 1) | 466922579) + r15) - 466922579) | (-681093961)) - (-2040245193)) ^ 2040245216;
                long j2 = 352854024;
                long j3 = z3 ? 1L : 0L;
                long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                long j5 = (j4 >>> 48) & 43690;
                long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                long j7 = ((j6 >>> 2) | j6) & 252645135;
                long j8 = (j4 >>> 32) & 43690;
                long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                long j10 = ((j9 >>> 2) | j9) & 252645135;
                long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
                long j12 = (j4 >>> 16) & 43690;
                long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                long j14 = ((j13 >>> 2) | j13) & 252645135;
                long j15 = j4 & 43690;
                long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                long j17 = ((j16 >>> 2) | j16) & 252645135;
                c(bArr2, new byte[]{51, 99, -88, 356001053 ^ (((((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) | 19406852) - (~(((r15 - 927279823) - ((-927279823) & r15)) & 336594232))) - 1), 62, -108, 97, 67, -9, -13});
                f455c = new AbstractC0011a2(context, new String(bArr2, charset).intern(), AbstractC0079s.f652c);
                byte[] bArr3 = {-86, -17, 10, 47, 94, 64, 52, -66, 89, -95};
                c(bArr3, new byte[]{125, -29, 55, -58, -58, -119, 100, 64, 31, -76});
                f456d = new AbstractC0011a2(context, new String(bArr3, charset).intern(), AbstractC0079s.f653d);
                byte[] bArr4 = new byte[10];
                bArr4[0] = -28;
                bArr4[1] = 21;
                bArr4[2] = -20;
                bArr4[3] = -14;
                bArr4[4] = 60;
                bArr4[5] = 80;
                bArr4[6] = 99;
                boolean z4 = f458f;
                int i = ~(z4 ? 1 : 0);
                bArr4[((((-564067162) | i) & 1390412096) + 395290) ^ 1390807389] = -109;
                bArr4[8] = -60;
                bArr4[9] = 105;
                byte[] bArr5 = new byte[10];
                bArr5[0] = 110;
                bArr5[1] = 11;
                bArr5[2] = -96;
                int i3 = ~(((z4 ? 1 : 0) & 41947651) ^ 4272720);
                int i4 = -((1300215096 | i) & 1133379875);
                bArr5[3] = V2.a(~i4, i3, (i3 + i4) + 1) ^ (-1137652607);
                bArr5[4] = 80;
                bArr5[5] = -106;
                long j18 = -1;
                long j19 = z4 ? 1L : 0L;
                long j20 = (((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                long j21 = (((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                long j22 = (((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j23 = (((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j24 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j23 | (j22 + (j21 | j20)));
                long j25 = (j24 >>> 48) & 21845;
                long j26 = ((j25 >>> 1) | j25) & 858993459;
                long j27 = ((j26 >>> 2) | j26) & 252645135;
                long j28 = (j24 >>> 32) & 21845;
                long j29 = ((j28 >>> 1) | j28) & 858993459;
                long j30 = ((j29 >>> 2) | j29) & 252645135;
                long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) | ((((j27 >>> 4) | j27) & 16711935) << 24);
                long j32 = (j24 >>> 16) & 21845;
                long j33 = ((j32 >>> 1) | j32) & 858993459;
                long j34 = ((j33 >>> 2) | j33) & 252645135;
                long j35 = j24 & 21845;
                long j36 = ((j35 >>> 1) | j35) & 858993459;
                long j37 = ((j36 >>> 2) | j36) & 252645135;
                int i5 = (((int) ((((j37 >>> 4) | j37) & 16711935) | (((((j34 >>> 4) | j34) & 16711935) << 8) + j31))) | (-636085423)) & 1099958338;
                long j38 = 25690114;
                long j39 = ((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (j23 | (j21 + j20 + j22));
                long j40 = (j39 >>> 48) & 43690;
                long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                long j42 = (j41 | (j41 >>> 2)) & 252645135;
                long j43 = (j39 >>> 32) & 43690;
                long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                long j45 = ((j44 >>> 2) | j44) & 252645135;
                long j46 = (((j42 | (j42 >>> 4)) & 16711935) << 24) | ((((j45 >>> 4) | j45) & 16711935) << 16);
                long j47 = (j39 >>> 16) & 43690;
                long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                long j49 = ((j48 >>> 2) | j48) & 252645135;
                long j50 = ((((j49 >>> 4) | j49) & 16711935) << 8) + j46;
                long j51 = j39 & 43690;
                long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                long j53 = (j52 | (j52 >>> 2)) & 252645135;
                bArr5[6] = (i5 + (((int) (((j53 | (j53 >>> 4)) & 16711935) + j50)) | 642252800)) ^ 1742211140;
                long j54 = -872415104;
                long j55 = 0;
                long b4 = c3.b((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16), ((((((((j55 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j55 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j55 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j55 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)), 6148914691236517205L);
                long j56 = (b4 >>> 48) & 43690;
                long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
                long j58 = (j57 | (j57 >>> 2)) & 252645135;
                long j59 = (b4 >>> 32) & 43690;
                long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                long j61 = (j60 | (j60 >>> 2)) & 252645135;
                long j62 = (((j58 | (j58 >>> 4)) & 16711935) << 24) | (((j61 | (j61 >>> 4)) & 16711935) << 16);
                long j63 = (b4 >>> 16) & 43690;
                long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
                long j65 = (j64 | (j64 >>> 2)) & 252645135;
                long j66 = b4 & 43690;
                long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
                long j68 = (j67 | (j67 >>> 2)) & 252645135;
                int i6 = (((1145162927 | i) + 546375193) - (i | 1691471551)) + ((int) (((j68 | (j68 >>> 4)) & 16711935) + (((j65 | (j65 >>> 4)) & 16711935) << 8) + j62));
                long j69 = -326039906;
                long j70 = i6;
                long j71 = (((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j72 = (j71 >>> 48) & 21845;
                long j73 = (j72 | (j72 >>> 1)) & 858993459;
                long j74 = (j73 | (j73 >>> 2)) & 252645135;
                long j75 = (j71 >>> 32) & 21845;
                long j76 = (j75 | (j75 >>> 1)) & 858993459;
                long j77 = (j76 | (j76 >>> 2)) & 252645135;
                long j78 = (((j77 | (j77 >>> 4)) & 16711935) << 16) + (((j74 | (j74 >>> 4)) & 16711935) << 24);
                long j79 = (j71 >>> 16) & 21845;
                long j80 = (j79 | (j79 >>> 1)) & 858993459;
                long j81 = (j80 | (j80 >>> 2)) & 252645135;
                long j82 = j71 & 21845;
                long j83 = (j82 | (j82 >>> 1)) & 858993459;
                long j84 = (j83 | (j83 >>> 2)) & 252645135;
                bArr5[(int) (((j84 | (j84 >>> 4)) & 16711935) | ((((j81 | (j81 >>> 4)) & 16711935) << 8) + j78))] = -24;
                bArr5[8] = -114;
                bArr5[9] = -84;
                c(bArr4, bArr5);
                f457e = new AbstractC0011a2(context, new String(bArr4, charset).intern(), AbstractC0079s.f654e);
                f458f = true;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void b(String str, long j2) {
        char c4 = 46683;
        char c5 = 46683;
        G2 g22 = null;
        while (true) {
            if (c5 != c4) {
                if (c5 != 43001) {
                    if (c5 != 51270) {
                        c5 = c4;
                    } else {
                        boolean z3 = f458f;
                        int i = ~(z3 ? 1 : 0);
                        long j3 = 549413;
                        long j4 = z3 ? 1L : 0L;
                        long j5 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j6 = (j5 >>> 48) & 43690;
                        long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
                        long j8 = ((j7 >>> 2) | j7) & 252645135;
                        long j9 = (j5 >>> 32) & 43690;
                        long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                        long j11 = ((j10 >>> 2) | j10) & 252645135;
                        long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
                        long j13 = (j5 >>> 16) & 43690;
                        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                        long j15 = ((j14 >>> 2) | j14) & 252645135;
                        long j16 = j5 & 43690;
                        long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                        long j18 = (j17 | (j17 >>> 2)) & 252645135;
                        int i3 = (((-109111010) | i) & 420626720) + (((int) (((j18 | (j18 >>> 4)) & 16711935) | (((((j15 >>> 4) | j15) & 16711935) << 8) + j12))) | 538117);
                        byte[] bArr = {-114, -112, 86, -42, 15, ((421164841 & i3) * 2) + ((-421164842) - i3), 15, 4, 27, 62, Byte.MIN_VALUE, -97, 54, -3};
                        byte[] bArr2 = new byte[14];
                        bArr2[0] = -19;
                        bArr2[1] = -8;
                        bArr2[2] = 51;
                        bArr2[(((1849634940 | i) & 297374082) - 2046818240) ^ (-1749444159)] = -75;
                        bArr2[4] = 100;
                        bArr2[5] = -106;
                        bArr2[6] = 107;
                        bArr2[7] = 86;
                        bArr2[8] = 126;
                        bArr2[9] = 78;
                        bArr2[10] = -17;
                        bArr2[11] = -19;
                        bArr2[12] = 66;
                        bArr2[13] = -114;
                        l(bArr, bArr2);
                        kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                        throw null;
                    }
                } else {
                    g22.d(str, String.valueOf(j2));
                    return;
                }
            } else {
                byte[] bArr3 = new byte[11];
                bArr3[0] = 68;
                bArr3[1] = -33;
                bArr3[2] = 121;
                bArr3[3] = 70;
                bArr3[4] = 43;
                bArr3[5] = 99;
                bArr3[6] = -23;
                bArr3[7] = -41;
                bArr3[8] = 65;
                bArr3[9] = -93;
                boolean z4 = f458f;
                int i4 = ~(z4 ? 1 : 0);
                bArr3[((i4 | 233571058) & 70058066) ^ 70058072] = 35;
                byte[] bArr4 = new byte[11];
                bArr4[0] = 52;
                bArr4[1] = -66;
                int i5 = (214291960 | i4) & 9650819;
                bArr4[D.a(i5, 3, -D1.a(i5, ((z4 ? 1 : 0) & 1184267) | 530440), 1) ^ 10181257] = 26;
                bArr4[3] = 45;
                bArr4[4] = 74;
                bArr4[5] = 4;
                bArr4[6] = -116;
                bArr4[7] = -103;
                long j19 = 1379043849;
                long j20 = i4;
                long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                long j22 = (j21 >>> 48) & 43690;
                long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                long j24 = ((j23 >>> 2) | j23) & 252645135;
                long j25 = (j21 >>> 32) & 43690;
                long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                long j27 = ((j26 >>> 2) | j26) & 252645135;
                long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) + ((((j24 >>> 4) | j24) & 16711935) << 24);
                long j29 = (j21 >>> 16) & 43690;
                long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                long j31 = ((j30 >>> 2) | j30) & 252645135;
                long j32 = j21 & 43690;
                long j33 = ((j32 >>> 1) | (j32 >>> 2)) & 858993459;
                long j34 = (j33 | (j33 >>> 2)) & 252645135;
                bArr4[8] = ((((int) (((j34 | (j34 >>> 4)) & 16711935) + (((((j31 >>> 4) | j31) & 16711935) << 8) | j28))) & 3834444) + 33573154) ^ 37407566;
                bArr4[9] = -50;
                bArr4[10] = 70;
                l(bArr3, bArr4);
                new String(bArr3, StandardCharsets.UTF_8).intern();
                g22 = f455c;
                if (g22 == null) {
                    c5 = 51270;
                } else {
                    c5 = 43001;
                }
                c4 = 46683;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~C0010a1.class.getName().length();
        int length3 = (((~(((C0010a1.class.getName().length() | 70245657) | i7) - (i7 | (C0010a1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C0010a1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C0010a1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C0010a1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C0010a1.class.getName().length()) | (-576567005)) & 276971586) + ((C0010a1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C0010a1.class.getName().length()) | (-1157759625)) & 1755853004) + ((C0010a1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C0010a1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C0010a1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C0010a1.class.getName().length()) | (-1064961)) + 689325073) + ((C0010a1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C0010a1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C0010a1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C0010a1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C0010a1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C0010a1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C0010a1.class.getName().length();
                    int length11 = (161497089 & (((((C0010a1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C0010a1.class.getName().length() | i14) & 797295576))) + ((C0010a1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C0010a1.class.getName().length()) | (-1085986263)) & 1078327440) + ((C0010a1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C0010a1.class.getName().length();
                    int length12 = length5 >>> ((((~(((C0010a1.class.getName().length() | 626856794) | i15) - ((C0010a1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C0010a1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C0010a1.class.getName().length()) | 1248713193) & 826417528) + ((C0010a1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C0010a1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C0010a1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C0010a1.class.getName().length()) | (-1005965450)) & 153223237) + ((C0010a1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C0010a1.class.getName().length() & (~length6)) & i9)) + ((C0010a1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C0010a1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C0010a1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C0010a1.class.getName().length()) | (-23496740)) & 827084804) + ((C0010a1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C0010a1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C0010a1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C0010a1.class.getName().length()) | (-961655275)) & 25184460) + ((C0010a1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C0010a1.class.getName().length()) | 1233459797) & 125923146) + ((C0010a1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C0010a1.class.getName().length()) | (-7107622)) & 402932290) + ((C0010a1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C0010a1.class.getName().length() | length15) - (b4 | length15)) + I2.a(C0010a1.class, b4) + (C0010a1.class.getName().length() & length15);
                    int length17 = ((((~C0010a1.class.getName().length()) | (-81143879)) & 438583424) + ((C0010a1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C0010a1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C0010a1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C0010a1.class, 568748773 | i24) + (C0010a1.class.getName().length() & (-2105278367)))) + ((C0010a1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C0010a1.class.getName().length()) | (-1592082969)) & 140665109) + ((C0010a1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C0010a1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C0010a1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C0010a1.class.getName().length()) | (-180811308));
                    int length19 = (C0010a1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C0010a1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C0010a1.class.getName().length()))));
                    int i29 = ((~C0010a1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C0010a1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C0010a1.class.getName().length()) | 75364313) & 1242301609) + ((C0010a1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C0010a1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C0010a1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C0010a1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C0010a1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C0010a1.class.getName().length();
                    int length24 = 1409942802 & (((((C0010a1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C0010a1.class.getName().length()) & 91135407));
                    int length25 = (C0010a1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C0010a1.class.getName().length()) | (-537919489)) - (-806798471)) + ((C0010a1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C0010a1.class.getName().length()) | (-382746167)) & 102532165) + ((C0010a1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C0010a1.class.getName().length()) | (-6036961)) & 1233145505) + ((C0010a1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C0010a1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C0010a1.class.getName().length() & 268460041;
                    i5 = (((((C0010a1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C0010a1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C0010a1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C0010a1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C0010a1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C0010a1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C0010a1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C0010a1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C0010a1.class, -1) | (-532481)) - (-67641369)) + ((C0010a1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C0010a1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C0010a1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C0010a1.class, -1) | (-33554434)) - (-1107366402)) + ((C0010a1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C0010a1.class, -1) | (-167014194)) & 1157999680) + ((C0010a1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C0010a1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C0010a1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C0010a1.class, -1) | 114408723) & 1183666176;
                    int length33 = C0010a1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C0010a1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C0010a1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C0010a1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C0010a1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C0010a1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C0010a1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C0010a1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C0010a1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C0010a1.class.getName().length()) | 991120067) & (-2113137661)) + ((C0010a1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C0010a1.class, -1) | 314136709) & 371231304) + (((C0010a1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C0010a1.class.getName().length()) | 366661365) & 1344150018) + ((C0010a1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C0010a1.class.getName().length()) | (-1359635359)) & 49026131) + ((C0010a1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C0010a1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C0010a1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C0010a1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C0010a1.class.getName().length()) | 1110430873) & 1241612298) + ((C0010a1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C0010a1.class.getName().length()) | 1603962366) & 25199440) + (((C0010a1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C0010a1.class.getName().length()) | (-1388708984)) & 706816128) + ((C0010a1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C0010a1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C0010a1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C0010a1.class.getName().length()) | 2113158628) & 1026558002) + ((C0010a1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C0010a1.class.getName().length()) | 715175224) & 136512788) + ((C0010a1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C0010a1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C0010a1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C0010a1.class.getName().length()) | (-1084937228)) & 438503696) + ((C0010a1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C0010a1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C0010a1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C0010a1.class, 1197735420 | i53) + (C0010a1.class.getName().length() & 674349280))) + ((C0010a1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C0010a1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C0010a1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C0010a1.class.getName().length()) | (-171976913)) & 318775824) + ((C0010a1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C0010a1.class.getName().length()) | (-616910267)) & 1303391760) + ((C0010a1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C0010a1.class.getName().length()) | 1297715640) & 556926729) + ((C0010a1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C0010a1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C0010a1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C0010a1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C0010a1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d() {
        G2 g22 = null;
        Object[] objArr = 54085;
        while (true) {
            if (objArr != 54085) {
                if (objArr != 46643) {
                    if (objArr == 25213) {
                        g22.l();
                        return;
                    }
                } else {
                    byte[] bArr = {-53, -125, 40, -3, -29, -22, -117, 3, -53, -66, Byte.MAX_VALUE, 118, -2, 55};
                    byte[] bArr2 = new byte[14];
                    bArr2[0] = 12;
                    bArr2[1] = 25;
                    bArr2[2] = -1;
                    bArr2[3] = 60;
                    bArr2[4] = -20;
                    bArr2[5] = -67;
                    bArr2[6] = -103;
                    bArr2[7] = 55;
                    bArr2[8] = 10;
                    bArr2[9] = -36;
                    bArr2[10] = -98;
                    bArr2[((((~(f458f ? 1 : 0)) | 1202575022) & (-2147423710)) + 52691080) ^ (-2094732639)] = -86;
                    bArr2[12] = -118;
                    bArr2[13] = 68;
                    g(bArr, bArr2);
                    kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                    throw null;
                }
            } else {
                g22 = f455c;
                if (g22 != null) {
                    objArr = 25213;
                }
            }
            objArr = 46643;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String e(String str) {
        Object[] objArr = 15865;
        G2 g22 = null;
        String str2 = null;
        String str3 = null;
        while (true) {
            if (objArr != 15865) {
                if (objArr != 57871) {
                    if (objArr != 30706) {
                        if (objArr == 41822) {
                            boolean z3 = f458f;
                            int i = ~(z3 ? 1 : 0);
                            byte b4 = ((~(-((~(((342718554 | (z3 ? 1 : 0)) | i) - (((-342718555) & (z3 ? 1 : 0)) | i))) & 1212700042))) + 268698146) ^ (-1481398167);
                            long j2 = -1;
                            long j3 = z3 ? 1L : 0L;
                            long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                            long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                            long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j8 = ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                            long j9 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j10 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j11 = (j10 | (j9 + j8)) + j7 + (j6 | (j5 + j4));
                            long j12 = (j11 >>> 48) & 21845;
                            long j13 = ((j12 >>> 1) | j12) & 858993459;
                            long j14 = ((j13 >>> 2) | j13) & 252645135;
                            long j15 = (j11 >>> 32) & 21845;
                            long j16 = ((j15 >>> 1) | j15) & 858993459;
                            long j17 = ((j16 >>> 2) | j16) & 252645135;
                            long j18 = ((((j17 >>> 4) | j17) & 16711935) << 16) + ((((j14 >>> 4) | j14) & 16711935) << 24);
                            long j19 = (j11 >>> 16) & 21845;
                            long j20 = ((j19 >>> 1) | j19) & 858993459;
                            long j21 = ((j20 >>> 2) | j20) & 252645135;
                            long j22 = j11 & 21845;
                            long j23 = ((j22 >>> 1) | j22) & 858993459;
                            long j24 = ((j23 >>> 2) | j23) & 252645135;
                            long j25 = 572605441;
                            long j26 = ((z3 ? 1 : 0) | (-4734978)) - (-4734978);
                            long j27 = (((((((((j25 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j25 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j25 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j25 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j26 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j26 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j26 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j26 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
                            long j28 = (j27 >>> 48) & 43690;
                            long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                            long j30 = ((j29 >>> 2) | j29) & 252645135;
                            long j31 = (j27 >>> 32) & 43690;
                            long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                            long j33 = ((j32 >>> 2) | j32) & 252645135;
                            long j34 = ((((j33 >>> 4) | j33) & 16711935) << 16) + ((((j30 >>> 4) | j30) & 16711935) << 24);
                            long j35 = (j27 >>> 16) & 43690;
                            long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                            long j37 = ((j36 >>> 2) | j36) & 252645135;
                            long j38 = j27 & 43690;
                            long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                            long j40 = ((j39 >>> 2) | j39) & 252645135;
                            int i3 = ((((int) ((((j24 >>> 4) | j24) & 16711935) | ((((j21 >>> 4) | j21) & 16711935) << 8) | j18)) | (-1685822493)) & 273424736) + ((int) ((((((j37 >>> 4) | j37) & 16711935) << 8) + j34) | (((j40 >>> 4) | j40) & 16711935)));
                            byte[] bArr = {0, b4, 29, ((846030155 & i3) * 2) + ((-846030156) - i3), -41, 60, -107, -21, 47, -89, 27, 11, 63, -112, 19, -95, -115, 57, -87, -17, -41, 16, ((((-1629041755) | i) & (-2071707216)) + 573179394) ^ 1498527864, 108};
                            byte[] bArr2 = new byte[24];
                            bArr2[0] = 10;
                            long j41 = (j10 | j9 | j8) + (j7 | (j6 + (j5 | j4)));
                            long j42 = (j41 >>> 48) & 21845;
                            long j43 = (j42 | (j42 >>> 1)) & 858993459;
                            long j44 = (j43 | (j43 >>> 2)) & 252645135;
                            long j45 = (j41 >>> 32) & 21845;
                            long j46 = ((j45 >>> 1) | j45) & 858993459;
                            long j47 = ((j46 >>> 2) | j46) & 252645135;
                            long j48 = ((((j47 >>> 4) | j47) & 16711935) << 16) + (((j44 | (j44 >>> 4)) & 16711935) << 24);
                            long j49 = (j41 >>> 16) & 21845;
                            long j50 = ((j49 >>> 1) | j49) & 858993459;
                            long j51 = ((j50 >>> 2) | j50) & 252645135;
                            long j52 = j41 & 21845;
                            long j53 = (j52 | (j52 >>> 1)) & 858993459;
                            long j54 = (j53 | (j53 >>> 2)) & 252645135;
                            int i4 = ((int) (((j54 | (j54 >>> 4)) & 16711935) + (((((j51 >>> 4) | j51) & 16711935) << 8) | j48))) | 187745606;
                            long j55 = 1094713793;
                            long j56 = i4;
                            long j57 = (((((((((j55 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j55 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j55 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j55 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j56 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j56 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j56 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j56 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                            long j58 = (j57 >>> 48) & 43690;
                            long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                            long j60 = (j59 | (j59 >>> 2)) & 252645135;
                            long j61 = (j57 >>> 32) & 43690;
                            long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
                            long j63 = ((j62 >>> 2) | j62) & 252645135;
                            long j64 = ((((j63 >>> 4) | j63) & 16711935) << 16) + (((j60 | (j60 >>> 4)) & 16711935) << 24);
                            long j65 = (j57 >>> 16) & 43690;
                            long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
                            long j67 = ((j66 >>> 2) | j66) & 252645135;
                            long j68 = j57 & 43690;
                            long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
                            long j70 = (j69 | (j69 >>> 2)) & 252645135;
                            int i5 = ((z3 ? 1 : 0) & 1077941393) + 21521 + (((-r2) - 1) | (-21521)) + ((int) (((j70 | (j70 >>> 4)) & 16711935) | (((((j67 >>> 4) | j67) & 16711935) << 8) + j64)));
                            bArr2[B0.a(1094735312 | (~i5), 1094735312 - i5)] = -94;
                            bArr2[2] = -54;
                            bArr2[3] = 18;
                            bArr2[4] = -63;
                            bArr2[5] = 115;
                            bArr2[6] = 112;
                            bArr2[7] = 57;
                            bArr2[8] = -55;
                            bArr2[9] = -2;
                            bArr2[10] = -56;
                            bArr2[11] = -50;
                            bArr2[12] = 48;
                            bArr2[13] = -54;
                            bArr2[14] = -56;
                            bArr2[15] = 116;
                            bArr2[16] = -107;
                            bArr2[17] = 125;
                            bArr2[18] = 126;
                            bArr2[19] = 59;
                            bArr2[20] = -64;
                            bArr2[21] = 71;
                            bArr2[22] = 43;
                            bArr2[23] = -68;
                            n(bArr, bArr2);
                            kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.j.e(str2, str3);
                        g22 = f457e;
                        if (g22 == null) {
                            objArr = 41822;
                        }
                    }
                    objArr = 57871;
                } else {
                    return g22.c(str);
                }
            } else {
                str2 = str;
                byte[] bArr3 = {125, 53, 99, 93};
                n(bArr3, new byte[]{117, 122, -123, -98, -47, 15, 71, 29});
                str3 = new String(bArr3, StandardCharsets.UTF_8).intern();
                objArr = 30706;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f() {
        G2 g22 = null;
        Object[] objArr = 37117;
        while (true) {
            if (objArr != 37117) {
                if (objArr != 19066) {
                    if (objArr == 19030) {
                        byte[] bArr = new byte[9];
                        long j2 = -1006623872;
                        long j3 = 0;
                        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                        long j5 = (j4 >>> 48) & 43690;
                        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                        long j7 = (j6 | (j6 >>> 2)) & 252645135;
                        long j8 = (j4 >>> 32) & 43690;
                        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                        long j10 = ((j9 >>> 2) | j9) & 252645135;
                        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
                        long j12 = (j4 >>> 16) & 43690;
                        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                        long j14 = ((j13 >>> 2) | j13) & 252645135;
                        long j15 = j4 & 43690;
                        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                        long j17 = (j16 | (j16 >>> 2)) & 252645135;
                        bArr[((((~(f458f ? 1 : 0)) | (-1627427217)) & 956448880) + ((int) (((j17 | (j17 >>> 4)) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) + j11)))) ^ (-50174992)] = 109;
                        bArr[1] = -66;
                        bArr[2] = 103;
                        bArr[3] = 59;
                        bArr[4] = 98;
                        bArr[5] = 24;
                        bArr[6] = -6;
                        bArr[7] = 22;
                        bArr[8] = -12;
                        n(bArr, new byte[]{118, -24, -68, -19, 107, 66, 33, -61, Byte.MIN_VALUE});
                        kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                        throw null;
                    }
                } else {
                    g22.l();
                    return;
                }
            } else {
                g22 = f456d;
                if (g22 == null) {
                    objArr = 19030;
                }
            }
            objArr = 19066;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void g(byte[] bArr, byte[] bArr2) {
        boolean z3;
        int i;
        byte[] bArr3 = null;
        int i3 = -1003175592;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i7 = ((i3 & 16777216) * (i3 | 16777216)) + ((i3 & (-16777217)) * ((~i3) & 16777216));
            int i8 = i3 >>> 8;
            int i9 = ~((((~i8) | (-1095531540)) | i7) - ((i8 & (-1095531540)) | i7));
            int i10 = (-1171264002) - ((i9 & 2) | ((-130029571) - i9));
            switch ((-1109882652) ^ ((~i10) + ((i10 | 1) * 2))) {
                case -1922532006:
                    byte[] bArr5 = bArr3;
                    int length = bArr4.length;
                    int i11 = 0 - i4;
                    if ((bArr5[AbstractC0014b1.a((length & 2) | D1.a(i11, length), i11 * 3)] > Double.NaN ? 1 : (bArr5[AbstractC0014b1.a((length & 2) | D1.a(i11, length), i11 * 3)] == Double.NaN ? 0 : -1)) <= -1) {
                        i3 = -1671996003;
                    } else {
                        i3 = 935800592;
                    }
                    i5 = i4;
                    bArr3 = bArr5;
                case -1486048729:
                    int length2 = bArr.length;
                    int length3 = 0 - (0 - (bArr.length % 4));
                    if ((length2 & (~length3)) - ((~length2) & length3) <= 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        i = -1515449616;
                    } else {
                        i = 935800592;
                    }
                    if (z3) {
                        i3 = i;
                    } else {
                        i3 = -10521562;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case -497756741:
                    byte[] bArr6 = bArr3;
                    int length4 = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = ((length4 | i12) * 2) - (length4 ^ i12);
                    byte b4 = bArr6[i13];
                    int length5 = bArr4.length;
                    byte b5 = bArr6[((i12 | length5) - ((1163302289 & (~i12)) & length5)) + ((i12 | 1163302289) & length5)];
                    bArr6[i13] = (byte) (((byte) (((byte) (b5 ^ (~b4))) + ((byte) (((byte) 2) * ((byte) (b5 | b4)))))) + ((byte) 1));
                    bArr3 = bArr6;
                    i3 = 935800592;
                case 256719606:
                    int i14 = (i6 - 1) - (i6 | (-4));
                    byte b6 = bArr3[i14];
                    int i15 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i16 = i6 + 2;
                    int i17 = i16 - (i6 & 2);
                    int i18 = bArr3[i17] & ForkServer.ERROR;
                    int i19 = i18 * ((~i18) & 65536);
                    int a2 = S.a(i19, i15, 1, ((-1) - i19) | ((-1) - i15));
                    int i20 = i16 + (((-1) - i6) | (-2));
                    int i21 = bArr3[i20] & ForkServer.ERROR;
                    int i22 = i21 * ((~i21) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i23 = (i22 - 1) - ((~a2) | i22);
                    int i24 = bArr3[i6] & ForkServer.ERROR;
                    int i25 = ~((i24 | ((~i23) | (-755325340))) - ((i23 & (-755325340)) | i24));
                    byte b7 = bArr4[i14];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i17] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = bArr4[i20] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = bArr4[i6] & ForkServer.ERROR;
                    byte[] bArr7 = bArr3;
                    int i32 = i25 << ((i25 > Double.NaN ? 1 : (i25 == Double.NaN ? 0 : -1)) >>> 31);
                    int i33 = (-659933419) - ((1983400305 - i26) | (i26 & 2));
                    int i34 = (i33 ^ (~i28)) + ((i33 | i28) * 2) + 1;
                    int i35 = (i34 ^ i31) + ((i34 & i31) * 2);
                    int i36 = ((i35 | i30) - (((-2109111237) & (~i30)) & i35)) + ((i30 | (-2109111237)) & i35);
                    int a4 = E1.a(i32 | i36, i32, i36);
                    bArr4[i6] = (byte) a4;
                    bArr4[i20] = (byte) (a4 >>> 8);
                    bArr4[i17] = (byte) (a4 >>> 16);
                    bArr4[i14] = (byte) (a4 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length6 = bArr4.length;
                    int length7 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > (((length6 | length7) * 2) - (length6 ^ length7)) ? 1 : (i6 == (((length6 | length7) * 2) - (length6 ^ length7)) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i3 = -1515449616;
                    } else {
                        i3 = 935800592;
                    }
                    bArr3 = bArr7;
                    if (i37 == 0) {
                        i3 = -10521562;
                    }
                case 1429728656:
                    i4 = bArr4.length % 4;
                    int i38 = 1 & ((i4 > 1 ? 1 : (i4 == 1 ? 0 : -1)) >>> 31);
                    if (i38 != 0) {
                        i3 = -1216566512;
                    } else {
                        i3 = 935800592;
                    }
                    if (i38 == 0) {
                        i3 = -1058029970;
                    }
                case 1870596681:
                    break;
                case 1879000533:
                    int length8 = bArr4.length;
                    int i39 = 0 - i5;
                    int i40 = 0 - i39;
                    int i41 = i40 | length8;
                    int i42 = (length8 ^ i40) ^ i41;
                    int i43 = i40 * 2;
                    int length9 = bArr4.length;
                    byte b8 = bArr4[(i40 ^ length9) - (((~length9) & i40) * 2)];
                    int length10 = bArr4.length;
                    byte b9 = bArr3[((i39 | length10) * 2) - (length10 ^ i39)];
                    bArr4[(i41 - i43) + i42] = (byte) (((((byte) (~b9)) + ((byte) (((byte) 2) * ((byte) (b9 | 1))))) ^ b8) ^ 1);
                    i4 = (~i5) + (i5 * 2);
                    int i44 = 1 & ((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31);
                    if (i44 != 0) {
                        i3 = -1216566512;
                    } else {
                        i3 = 935800592;
                    }
                    if (i44 == 0) {
                        i3 = -1058029970;
                    }
                default:
                    i3 = 935800592;
            }
            return;
        }
    }

    public static boolean h(String str, long j2) {
        String str2 = null;
        G2 g22 = null;
        char c4 = 25062;
        while (true) {
            char c5 = 10472;
            if (c4 != 10472) {
                if (c4 != 25062) {
                    c5 = 5357;
                    if (c4 != 5357) {
                        if (c4 == 60290) {
                            str2 = g22.c(str);
                        }
                    } else {
                        return kotlin.jvm.internal.j.a(str2, String.valueOf(j2));
                    }
                } else {
                    byte[] bArr = new byte[11];
                    bArr[0] = 78;
                    bArr[1] = -24;
                    bArr[2] = 85;
                    bArr[3] = -21;
                    boolean z3 = f458f;
                    bArr[(((((-1) - (z3 ? 1 : 0)) | (-789894560)) & (-536381178)) + 19923153) ^ (-516458029)] = 77;
                    bArr[5] = 4;
                    bArr[6] = 25;
                    bArr[7] = -60;
                    bArr[8] = 93;
                    bArr[9] = -114;
                    bArr[10] = 71;
                    byte[] bArr2 = new byte[11];
                    bArr2[0] = -126;
                    bArr2[1] = -76;
                    bArr2[(-1372647725) ^ ((((~(z3 ? 1 : 0)) | 454810244) & 671812177) + (((z3 ? 1 : 0) & (-1507852207)) | (-2044459904)))] = -92;
                    bArr2[3] = 38;
                    bArr2[4] = -112;
                    bArr2[5] = -106;
                    bArr2[6] = -17;
                    bArr2[7] = 104;
                    bArr2[8] = 60;
                    bArr2[9] = -29;
                    bArr2[10] = 34;
                    g(bArr, bArr2);
                    kotlin.jvm.internal.j.e(str, new String(bArr, StandardCharsets.UTF_8).intern());
                    g22 = f455c;
                    if (g22 != null) {
                        c4 = 60290;
                    }
                }
                c4 = c5;
            } else {
                byte[] bArr3 = {3, -22, -31, -60, -55, 28, -126, 12, 32, -11, -75, 97, -29, 94};
                g(bArr3, new byte[]{-60, -65, 54, 68, 6, 111, -112, 60, -95, -110, 72, -74, -105, 45});
                kotlin.jvm.internal.j.i(new String(bArr3, StandardCharsets.UTF_8).intern());
                throw null;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void i(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i = 0;
        int i3 = 0;
        int i4 = -1850458006;
        byte[] bArr4 = null;
        while (true) {
            int i5 = ((16777216 & i4) * (i4 | 16777216)) + (((-16777217) & i4) * ((~i4) & 16777216));
            int i6 = i4 >>> 8;
            int i7 = (~i5) | i6;
            boolean z3 = true;
            int i8 = (i6 - 1) - i7;
            int i9 = (-1700147435) - ((i8 & 2) | (2028104049 - i8));
            int i10 = -1396193641;
            switch ((-1363443157) ^ ((~i9) + ((i9 | 1) * 2))) {
                case -1940167324:
                    byte b4 = bArr3[i];
                    int i11 = ((byte) 0) - b4;
                    bArr3[i] = (byte) (((byte) (b4 & (~i11))) - ((byte) ((~b4) & i11)));
                    i4 = 614229416;
                case -360299937:
                    if ((bArr3[i3] > Double.NaN ? 1 : (bArr3[i3] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        i10 = 427928065;
                    }
                    if (z3) {
                        i4 = 614229416;
                    } else {
                        i4 = i10;
                    }
                    i = i3;
                case 399486784:
                    break;
                case 585276366:
                    if (bArr.length <= 0) {
                        i4 = -1396193641;
                    } else {
                        i4 = 1985663266;
                    }
                    bArr4 = bArr;
                    bArr3 = bArr2;
                    i3 = 0;
                case 1733787683:
                    byte b5 = bArr4[i];
                    byte b6 = bArr3[i];
                    bArr4[i] = (byte) (((byte) (b6 + b5)) - ((byte) (((byte) 2) * ((byte) (b6 & b5)))));
                    i3 = (i ^ 1) + ((i & 1) * 2);
                    if ((((i3 > bArr4.length ? 1 : (i3 == bArr4.length ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -1396193641;
                    } else {
                        i4 = 1985663266;
                    }
                default:
                    i4 = -1396193641;
            }
            return;
        }
    }

    public static boolean j(String str) {
        char c4 = 54338;
        char c5 = 54338;
        G2 g22 = null;
        while (c5 != 23767) {
            if (c5 != c4) {
                if (c5 != 62910) {
                    c5 = c4;
                } else {
                    byte[] bArr = {-59, -94, 108, 99, 123, 38, -63, 97, -56};
                    boolean z3 = f458f;
                    int i = ~(z3 ? 1 : 0);
                    long j2 = 427056388;
                    long j3 = ((2021539714 | i) & 288624658) + 138431745;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j5 = (j4 >>> 48) & 21845;
                    long j6 = ((j5 >>> 1) | j5) & 858993459;
                    long j7 = ((j6 >>> 2) | j6) & 252645135;
                    long j8 = (j4 >>> 32) & 21845;
                    long j9 = ((j8 >>> 1) | j8) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
                    long j12 = (j4 >>> 16) & 21845;
                    long j13 = ((j12 >>> 1) | j12) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = j4 & 21845;
                    long j16 = ((j15 >>> 1) | j15) & 858993459;
                    long j17 = ((j16 >>> 2) | j16) & 252645135;
                    long j18 = -500165620;
                    long j19 = z3 ? 1L : 0L;
                    long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j21 = (j20 >>> 48) & 43690;
                    long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
                    long j23 = ((j22 >>> 2) | j22) & 252645135;
                    long j24 = (j20 >>> 32) & 43690;
                    long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                    long j26 = ((j25 >>> 2) | j25) & 252645135;
                    long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) | ((((j23 >>> 4) | j23) & 16711935) << 24);
                    long j28 = (j20 >>> 16) & 43690;
                    long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                    long j30 = ((j29 >>> 2) | j29) & 252645135;
                    long j31 = j20 & 43690;
                    long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                    long j33 = ((j32 >>> 2) | j32) & 252645135;
                    i(bArr, new byte[]{-78, -54, 5, (int) ((((j17 >>> 4) | j17) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11), 30, 74, 277858948 ^ ((1111495691 - ((~((int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) | j27)))) | 1111495692)) + ((i | 1296097722) & (-1389354720))), 18, -68});
                    kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                    throw null;
                }
            } else {
                boolean z4 = f458f;
                int i3 = ~(z4 ? 1 : 0);
                int i4 = ((-1573691165) | i3) & (-2144271670);
                long j34 = 525640;
                long j35 = 0;
                long j36 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                long j37 = (j36 >>> 48) & 43690;
                long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                long j39 = ((j38 >>> 2) | j38) & 252645135;
                long j40 = (j36 >>> 32) & 43690;
                long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                long j42 = ((j41 >>> 2) | j41) & 252645135;
                long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) + ((((j39 >>> 4) | j39) & 16711935) << 24);
                long j44 = (j36 >>> 16) & 43690;
                long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                long j46 = ((j45 >>> 2) | j45) & 252645135;
                long j47 = j36 & 43690;
                long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                long j49 = ((j48 >>> 2) | j48) & 252645135;
                byte b4 = 581570424 ^ ((((1753186837 + i3) + (((-i3) - 1) | (-1753186837))) & 581044754) + ((int) ((((((j46 >>> 4) | j46) & 16711935) << 8) + j43) | (((j49 >>> 4) | j49) & 16711935))));
                long j50 = 268553798;
                long j51 = 327277302 | i3;
                long j52 = (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j53 = (j52 >>> 48) & 43690;
                long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
                long j55 = ((j54 >>> 2) | j54) & 252645135;
                long j56 = (j52 >>> 32) & 43690;
                long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
                long j58 = ((j57 >>> 2) | j57) & 252645135;
                long j59 = ((((j58 >>> 4) | j58) & 16711935) << 16) | ((((j55 >>> 4) | j55) & 16711935) << 24);
                long j60 = (j52 >>> 16) & 43690;
                long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
                long j62 = ((j61 >>> 2) | j61) & 252645135;
                long j63 = ((((j62 >>> 4) | j62) & 16711935) << 8) + j59;
                long j64 = j52 & 43690;
                long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
                long j66 = (j65 | (j65 >>> 2)) & 252645135;
                int i5 = ((int) (((j66 | (j66 >>> 4)) & 16711935) + j63)) + ((-2098847736) | (((z4 ? 1 : 0) | 35922944) - (35922944 ^ (z4 ? 1 : 0))));
                byte[] bArr2 = {-62, (i4 + 2144271663) - (((809772320 + i4) & 1334499343) * 2), 31, -101, 37, b4, (i5 - 1830293965) - ((i5 & (-1830293965)) * 2), 96, -119, ((((-2058213595) | i3) & 72422416) + 16777769) ^ (-89200243), 57};
                byte[] bArr3 = new byte[11];
                bArr3[0] = -78;
                bArr3[1] = -124;
                bArr3[2] = 124;
                long j67 = 2137364;
                long j68 = 957011344 | i3;
                long j69 = (((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j70 = (j69 >>> 48) & 43690;
                long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
                long j72 = ((j71 >>> 2) | j71) & 252645135;
                long j73 = (j69 >>> 32) & 43690;
                long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
                long j75 = ((j74 >>> 2) | j74) & 252645135;
                long j76 = ((((j75 >>> 4) | j75) & 16711935) << 16) + ((((j72 >>> 4) | j72) & 16711935) << 24);
                long j77 = (j69 >>> 16) & 43690;
                long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                long j79 = ((j78 >>> 2) | j78) & 252645135;
                long j80 = j69 & 43690;
                long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
                long j82 = ((j81 >>> 2) | j81) & 252645135;
                bArr3[3] = (-170040724) ^ (167903368 + ((int) ((((j82 >>> 4) | j82) & 16711935) + (((((j79 >>> 4) | j79) & 16711935) << 8) | j76))));
                bArr3[4] = 68;
                bArr3[5] = 69;
                bArr3[6] = 24;
                bArr3[7] = 46;
                int i6 = ((1493240576 | (z4 ? 1 : 0)) - (1498774497 | i3)) + ((1347779553 | i3) - (z4 ? 1 : 0));
                long j83 = 219152385;
                long j84 = z4 ? 1L : 0L;
                long j85 = (((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j86 = (j85 >>> 48) & 43690;
                long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                long j88 = ((j87 >>> 2) | j87) & 252645135;
                long j89 = (j85 >>> 32) & 43690;
                long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                long j91 = ((j90 >>> 2) | j90) & 252645135;
                long j92 = ((((j91 >>> 4) | j91) & 16711935) << 16) | ((((j88 >>> 4) | j88) & 16711935) << 24);
                long j93 = (j85 >>> 16) & 43690;
                long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                long j95 = ((j94 >>> 2) | j94) & 252645135;
                long j96 = j85 & 43690;
                long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
                long j98 = (j97 | (j97 >>> 2)) & 252645135;
                bArr3[1564035913 ^ (i6 + (((int) (((j98 | (j98 >>> 4)) & 16711935) + (((((j95 >>> 4) | j95) & 16711935) << 8) + j92))) | 70795329))] = -24;
                long j99 = -1629715529;
                long j100 = i3;
                long b5 = c3.b((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                long j101 = (b5 >>> 48) & 43690;
                long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
                long j103 = (j102 | (j102 >>> 2)) & 252645135;
                long j104 = (b5 >>> 32) & 43690;
                long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
                long j106 = ((j105 >>> 2) | j105) & 252645135;
                long j107 = ((((j106 >>> 4) | j106) & 16711935) << 16) + (((j103 | (j103 >>> 4)) & 16711935) << 24);
                long j108 = (b5 >>> 16) & 43690;
                long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                long j110 = ((j109 >>> 2) | j109) & 252645135;
                long j111 = b5 & 43690;
                long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
                long j113 = (j112 | (j112 >>> 2)) & 252645135;
                bArr3[(-907753673) ^ (1231307263 - (~((((int) (((j113 | (j113 >>> 4)) & 16711935) | (((((j110 >>> 4) | j110) & 16711935) << 8) + j107))) | 2139060929) - 2139060929)))] = -39;
                bArr3[10] = 92;
                i(bArr2, bArr3);
                new String(bArr2, StandardCharsets.UTF_8).intern();
                g22 = f456d;
                if (g22 == null) {
                    c4 = 54338;
                    c5 = 62910;
                } else {
                    c5 = 23767;
                    c4 = 54338;
                }
            }
        }
        return g22.f(str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0064. Please report as an issue. */
    public static void k(String str) {
        char c4 = 13708;
        G2 g22 = null;
        G2 g23 = null;
        while (true) {
            switch (c4) {
                case 55530:
                    byte[] bArr = new byte[24];
                    bArr[0] = 121;
                    bArr[1] = 126;
                    bArr[2] = -32;
                    bArr[3] = -110;
                    bArr[4] = 47;
                    bArr[5] = 6;
                    bArr[6] = -116;
                    bArr[7] = 0;
                    bArr[8] = -100;
                    bArr[9] = -40;
                    boolean z3 = f458f;
                    bArr[10] = (((((-1) - (z3 ? 1 : 0)) | (-72472026)) & 1178658309) + ((71877641 & (z3 ? 1 : 0)) | 8917032)) ^ (-1187575354);
                    bArr[11] = -30;
                    bArr[12] = -25;
                    bArr[13] = -9;
                    bArr[14] = -13;
                    bArr[15] = 26;
                    bArr[16] = -50;
                    bArr[17] = 76;
                    bArr[18] = 125;
                    int i = ~(z3 ? 1 : 0);
                    long j2 = 582530594;
                    long j3 = (-355973795) | i;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j5 = (j4 >>> 48) & 43690;
                    long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                    long j7 = (j6 | (j6 >>> 2)) & 252645135;
                    long j8 = (j4 >>> 32) & 43690;
                    long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = (((j7 | (j7 >>> 4)) & 16711935) << 24) | ((((j10 >>> 4) | j10) & 16711935) << 16);
                    long j12 = (j4 >>> 16) & 43690;
                    long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = j4 & 43690;
                    long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                    long j17 = (j16 | (j16 >>> 2)) & 252645135;
                    long j18 = 939308593;
                    long j19 = ((int) (((j17 | (j17 >>> 4)) & 16711935) | j11 | ((((j14 >>> 4) | j14) & 16711935) << 8))) + 356777984;
                    long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j21 = (j20 >>> 48) & 21845;
                    long j22 = (j21 | (j21 >>> 1)) & 858993459;
                    long j23 = (j22 | (j22 >>> 2)) & 252645135;
                    long j24 = (j20 >>> 32) & 21845;
                    long j25 = ((j24 >>> 1) | j24) & 858993459;
                    long j26 = ((j25 >>> 2) | j25) & 252645135;
                    long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + (((j23 | (j23 >>> 4)) & 16711935) << 24);
                    long j28 = (j20 >>> 16) & 21845;
                    long j29 = ((j28 >>> 1) | j28) & 858993459;
                    long j30 = ((j29 >>> 2) | j29) & 252645135;
                    long j31 = j20 & 21845;
                    long j32 = (j31 | (j31 >>> 1)) & 858993459;
                    long j33 = (j32 | (j32 >>> 2)) & 252645135;
                    bArr[(int) (((j33 | (j33 >>> 4)) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) | j27))] = 25;
                    bArr[20] = -28;
                    bArr[21] = 15;
                    bArr[22] = 93;
                    bArr[23] = -27;
                    byte[] bArr2 = new byte[24];
                    bArr2[0] = 8;
                    bArr2[1] = 60;
                    bArr2[2] = 111;
                    bArr2[3] = 16;
                    bArr2[4] = 70;
                    bArr2[5] = -105;
                    bArr2[6] = -23;
                    bArr2[7] = -119;
                    bArr2[8] = -57;
                    bArr2[9] = -28;
                    bArr2[10] = 116;
                    bArr2[11] = -102;
                    bArr2[12] = 117;
                    bArr2[13] = -53;
                    bArr2[14] = -124;
                    bArr2[15] = -126;
                    bArr2[(((491596727 | i) & 1644241793) + 153618472) ^ 1797860281] = -93;
                    bArr2[17] = 74;
                    bArr2[18] = 2;
                    bArr2[19] = -124;
                    bArr2[20] = (((((~i) & (-201651925)) + i) & 88933164) - 2144157568) ^ 2055224364;
                    bArr2[21] = -106;
                    bArr2[22] = 28;
                    bArr2[23] = -92;
                    m(bArr, bArr2);
                    kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                    throw null;
                case 57782:
                    g22.l();
                    g23 = f457e;
                    c4 = g23 == null ? (char) 506 : (char) 18628;
                case 18628:
                    byte[] bArr3 = {125};
                    m(bArr3, new byte[]{76, 34, 19, -50, -48, 72, -25, -31});
                    g23.d(str, new String(bArr3, StandardCharsets.UTF_8).intern());
                    return;
                case 13708:
                    boolean z4 = f458f;
                    byte[] bArr4 = new byte[(-1684118877) ^ ((((~(z4 ? 1 : 0)) | (-1814395822)) & (-2087296991)) + (((z4 ? 1 : 0) & 268722213) | 403178118))];
                    bArr4[0] = 107;
                    bArr4[1] = -109;
                    bArr4[2] = -34;
                    bArr4[3] = -67;
                    m(bArr4, new byte[]{-8, 33, -107, -11, -99, -112, 3, 69});
                    new String(bArr4, StandardCharsets.UTF_8).intern();
                    g22 = f457e;
                    c4 = g22 == null ? (char) 55530 : (char) 57782;
                case 506:
                    byte[] bArr5 = new byte[24];
                    bArr5[0] = -78;
                    bArr5[1] = 30;
                    bArr5[2] = 88;
                    bArr5[3] = 26;
                    bArr5[4] = -53;
                    boolean z5 = f458f;
                    int i3 = ~(z5 ? 1 : 0);
                    bArr5[5] = ((((i3 ^ 1321705329) + (i3 & 1321705329)) & 740417537) + 1115816992) ^ (-1856234604);
                    bArr5[6] = -87;
                    bArr5[7] = 37;
                    bArr5[8] = -6;
                    int i4 = (i3 | (-13961217)) - 1512105692;
                    bArr5[((i4 & 1512105685) * 2) + ((-1512105686) - i4)] = 46;
                    bArr5[10] = 55;
                    bArr5[11] = 95;
                    bArr5[12] = 13;
                    bArr5[13] = 121;
                    bArr5[14] = 121;
                    long j34 = 941961536;
                    long j35 = ((1711976182 | i3) & 807735364) + 134226192;
                    long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j37 = (j36 >>> 48) & 21845;
                    long j38 = ((j37 >>> 1) | j37) & 858993459;
                    long j39 = ((j38 >>> 2) | j38) & 252645135;
                    long j40 = (j36 >>> 32) & 21845;
                    long j41 = ((j40 >>> 1) | j40) & 858993459;
                    long j42 = ((j41 >>> 2) | j41) & 252645135;
                    long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) | ((((j39 >>> 4) | j39) & 16711935) << 24);
                    long j44 = (j36 >>> 16) & 21845;
                    long j45 = ((j44 >>> 1) | j44) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = j36 & 21845;
                    long j48 = (j47 | (j47 >>> 1)) & 858993459;
                    long j49 = (j48 | (j48 >>> 2)) & 252645135;
                    bArr5[15] = (int) (((j49 | (j49 >>> 4)) & 16711935) | (((((j46 >>> 4) | j46) & 16711935) << 8) + j43));
                    bArr5[16] = -37;
                    bArr5[17] = -90;
                    long j50 = -1;
                    long j51 = z5 ? 1L : 0L;
                    long j52 = ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j53 = (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j52;
                    long j54 = (j53 >>> 48) & 21845;
                    long j55 = ((j54 >>> 1) | j54) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    long j57 = (j53 >>> 32) & 21845;
                    long j58 = ((j57 >>> 1) | j57) & 858993459;
                    long j59 = ((j58 >>> 2) | j58) & 252645135;
                    long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) | ((((j56 >>> 4) | j56) & 16711935) << 24);
                    long j61 = (j53 >>> 16) & 21845;
                    long j62 = ((j61 >>> 1) | j61) & 858993459;
                    long j63 = ((j62 >>> 2) | j62) & 252645135;
                    long j64 = j53 & 21845;
                    long j65 = ((j64 >>> 1) | j64) & 858993459;
                    long j66 = ((j65 >>> 2) | j65) & 252645135;
                    int i5 = ((int) ((((j66 >>> 4) | j66) & 16711935) | ((((j63 >>> 4) | j63) & 16711935) << 8) | j60)) | 1491524049;
                    long j67 = 13895234;
                    long j68 = i5;
                    long j69 = ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j70 = (j69 >>> 48) & 43690;
                    long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
                    long j72 = ((j71 >>> 2) | j71) & 252645135;
                    long j73 = (j69 >>> 32) & 43690;
                    long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
                    long j75 = ((j74 >>> 2) | j74) & 252645135;
                    long j76 = ((((j75 >>> 4) | j75) & 16711935) << 16) + ((((j72 >>> 4) | j72) & 16711935) << 24);
                    long j77 = (j69 >>> 16) & 43690;
                    long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                    long j79 = ((j78 >>> 2) | j78) & 252645135;
                    long j80 = j69 & 43690;
                    long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
                    long j82 = ((j81 >>> 2) | j81) & 252645135;
                    int i6 = (int) ((((j82 >>> 4) | j82) & 16711935) | (((((j79 >>> 4) | j79) & 16711935) << 8) + j76));
                    long j83 = -2145304575;
                    long j84 = 0;
                    long b4 = c3.b((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j85 = (b4 >>> 48) & 43690;
                    long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                    long j87 = ((j86 >>> 2) | j86) & 252645135;
                    long j88 = (b4 >>> 32) & 43690;
                    long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                    long j90 = ((j89 >>> 2) | j89) & 252645135;
                    long j91 = ((((j90 >>> 4) | j90) & 16711935) << 16) | ((((j87 >>> 4) | j87) & 16711935) << 24);
                    long j92 = (b4 >>> 16) & 43690;
                    long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                    long j94 = ((j93 >>> 2) | j93) & 252645135;
                    long j95 = b4 & 43690;
                    long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                    long j97 = ((j96 >>> 2) | j96) & 252645135;
                    bArr5[18] = (i6 + ((int) ((((j97 >>> 4) | j97) & 16711935) | (((((j94 >>> 4) | j94) & 16711935) << 8) | j91)))) ^ 2131409369;
                    bArr5[19] = -9;
                    bArr5[20] = -126;
                    bArr5[21] = 30;
                    bArr5[22] = 110;
                    bArr5[23] = 106;
                    byte[] bArr6 = new byte[24];
                    bArr6[0] = -67;
                    bArr6[1] = -100;
                    bArr6[2] = 39;
                    int i7 = ((z5 ? 1 : 0) & (-1065844219)) | 67144352;
                    int i8 = -((981810954 | i3) & (-755493883));
                    int i9 = (((~i8) & i7) * 2) - (i8 ^ i7);
                    bArr6[3] = (i9 + 688349501) - ((688349501 & i9) * 2);
                    bArr6[4] = -94;
                    long j98 = -1056772088;
                    long j99 = 1227616900 | (((z5 ? 1 : 0) - 1) - ((z5 ? 1 : 0) * 2));
                    long j100 = ((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j98 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j101 = (j100 >>> 48) & 43690;
                    long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
                    long j103 = ((j102 >>> 2) | j102) & 252645135;
                    long j104 = (j100 >>> 32) & 43690;
                    long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
                    long j106 = ((j105 >>> 2) | j105) & 252645135;
                    long j107 = ((((j106 >>> 4) | j106) & 16711935) << 16) + ((((j103 >>> 4) | j103) & 16711935) << 24);
                    long j108 = (j100 >>> 16) & 43690;
                    long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                    long j110 = ((j109 >>> 2) | j109) & 252645135;
                    long j111 = j100 & 43690;
                    long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
                    long j113 = ((j112 >>> 2) | j112) & 252645135;
                    bArr6[(((int) ((((j113 >>> 4) | j113) & 16711935) + (((((j110 >>> 4) | j110) & 16711935) << 8) + j107))) + 69470032) ^ (-987302051)] = 4;
                    long j114 = 126025794;
                    long j115 = ((((((((j114 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j114 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j114 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j114 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j52;
                    long j116 = (j115 >>> 48) & 43690;
                    long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
                    long j118 = (j117 | (j117 >>> 2)) & 252645135;
                    long j119 = (j115 >>> 32) & 43690;
                    long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
                    long j121 = (j120 | (j120 >>> 2)) & 252645135;
                    long j122 = (((j118 | (j118 >>> 4)) & 16711935) << 24) | (((j121 | (j121 >>> 4)) & 16711935) << 16);
                    long j123 = (j115 >>> 16) & 43690;
                    long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                    long j125 = (j124 | (j124 >>> 2)) & 252645135;
                    long j126 = j115 & 43690;
                    long j127 = ((j126 >>> 2) | (j126 >>> 1)) & 858993459;
                    long j128 = (j127 | (j127 >>> 2)) & 252645135;
                    bArr6[(((914116257 | i3) & 294783074) + (((int) (((j128 | (j128 >>> 4)) & 16711935) | ((((j125 | (j125 >>> 4)) & 16711935) << 8) + j122))) | 100990992)) ^ 395774068] = -59;
                    bArr6[7] = 110;
                    bArr6[8] = -95;
                    bArr6[9] = 114;
                    bArr6[10] = 64;
                    bArr6[11] = 85;
                    bArr6[12] = 79;
                    bArr6[13] = 69;
                    bArr6[14] = -6;
                    bArr6[15] = Byte.MAX_VALUE;
                    bArr6[16] = -104;
                    bArr6[17] = 32;
                    bArr6[18] = -22;
                    bArr6[19] = -98;
                    bArr6[20] = -38;
                    int i10 = (-1) - (z5 ? 1 : 0);
                    bArr6[(-1592772570) ^ ((((-2130698221) - (i10 | (-512802981))) + ((((-512802999) | i10) - (z5 ? 1 : 0)) + ((z5 ? 1 : 0) & (-2130698221)))) + 537925664)] = -89;
                    bArr6[22] = -21;
                    bArr6[23] = 28;
                    m(bArr5, bArr6);
                    kotlin.jvm.internal.j.i(new String(bArr5, StandardCharsets.UTF_8).intern());
                    throw null;
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void l(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] bArr3 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -585497720;
        byte[] bArr4 = null;
        while (true) {
            int i7 = ((i6 & 16777216) * (i6 | 16777216)) + ((i6 & (-16777217)) * ((~i6) & 16777216));
            int i8 = i6 >>> 8;
            int i9 = ~((((~i8) | (-238348293)) | i7) - ((i8 & (-238348293)) | i7));
            int i10 = (-1081514022) - ((i9 & 2) | ((-10362931) - i9));
            int a2 = E1.a(i10 | (-428181225), i10, -428181225);
            int i11 = 2100390411;
            int i12 = -897645243;
            boolean z3 = true;
            switch (a2) {
                case -1819084085:
                    int length = bArr3.length;
                    int i13 = 0 - i3;
                    int length2 = bArr3.length;
                    int i14 = 0 - i13;
                    byte b4 = bArr3[(length2 & (~i14)) - ((~length2) & i14)];
                    int length3 = bArr3.length;
                    byte b5 = bArr4[((length3 | i13) - (((-1678010279) & (~i13)) & length3)) + ((i13 | (-1678010279)) & length3)];
                    bArr3[((length | i13) * 2) - (length ^ i13)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i5 = 4 - ((5 - i3) | (i3 & 2));
                    int i15 = ((i3 > 2 ? 1 : (i3 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i15 == 0) {
                        i11 = -897645243;
                    }
                    if (i15 != 0) {
                        i6 = i11;
                    } else {
                        i6 = -2079636786;
                    }
                case -1350640889:
                    int length4 = bArr.length;
                    int length5 = 0 - (bArr.length % 4);
                    if (((length4 | length5) - ((942778902 & (~length5)) & length4)) + ((length5 | 942778902) & length4) <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i = -897645243;
                    } else {
                        i = 1251644638;
                    }
                    if (z3) {
                        i6 = -1469476344;
                    } else {
                        i6 = i;
                    }
                    bArr4 = bArr2;
                    bArr3 = bArr;
                    i4 = 0;
                case -477594107:
                    int length6 = bArr3.length;
                    int i16 = 0 - i3;
                    int i17 = ((length6 | i16) - (((-515406864) & (~i16)) & length6)) + ((i16 | (-515406864)) & length6);
                    byte b6 = bArr4[i17];
                    int length7 = bArr3.length;
                    byte b7 = bArr4[((i16 | length7) * 2) - (length7 ^ i16)];
                    int i18 = ((byte) 0) - b6;
                    int i19 = i18 | b7;
                    bArr4[i17] = (byte) (((byte) (((byte) i19) - ((byte) (((byte) 2) * ((byte) i18))))) + ((byte) ((b7 ^ i18) ^ i19)));
                    i6 = -1057239115;
                case 769572960:
                    break;
                case 783648904:
                    int i20 = i4 + 4 + (((-1) - i4) | (-4));
                    byte b8 = bArr4[i20];
                    int i21 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i22 = i4 & 2;
                    int i23 = (i4 + 2) - i22;
                    int i24 = bArr4[i23] & ForkServer.ERROR;
                    int i25 = i24 * ((~i24) & 65536);
                    int i26 = ~((i21 | ((~i25) | 467314697)) - ((i25 & 467314697) | i21));
                    int i27 = (i4 + 1) - (i4 & 1);
                    int i28 = bArr4[i27] & ForkServer.ERROR;
                    int i29 = i28 * ((~i28) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i30 = ~((i26 | ((~i29) | 1328859631)) - ((i29 & 1328859631) | i26));
                    int i31 = bArr4[i4] & ForkServer.ERROR;
                    int a4 = S.a(i30, i31, 1, ((-1) - i30) | ((-1) - i31));
                    byte b9 = bArr3[i20];
                    int i32 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i33 = bArr3[i23] & ForkServer.ERROR;
                    int i34 = i33 * ((~i33) & 65536);
                    int a5 = j3.a((~i32) & 1647046022 & i34, i34, i32, (i32 | 1647046022) & i34);
                    int i35 = bArr3[i27] & ForkServer.ERROR;
                    int i36 = i35 * ((~i35) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i37 = ~((a5 | ((~i36) | (-2059442874))) - ((i36 & (-2059442874)) | a5));
                    int i38 = bArr3[i4] & ForkServer.ERROR;
                    int a6 = S.a(i37, i38, 1, ((-1) - i37) | ((-1) - i38));
                    int i39 = a4 << ((a4 > Double.NaN ? 1 : (a4 == Double.NaN ? 0 : -1)) >>> 31);
                    int i40 = (i39 + a6) - ((i39 & a6) * 2);
                    bArr3[i4] = (byte) i40;
                    bArr3[i27] = (byte) (i40 >>> 8);
                    bArr3[i23] = (byte) (i40 >>> 16);
                    bArr3[i20] = (byte) (i40 >>> 24);
                    i4 = (-11) - (((-15) - i4) | i22);
                    int length8 = bArr3.length;
                    int a7 = AbstractC0044j.a(bArr3.length);
                    int i41 = ((i4 > (((length8 & (~a7)) * 2) - (length8 ^ a7)) ? 1 : (i4 == (((length8 & (~a7)) * 2) - (length8 ^ a7)) ? 0 : -1)) >>> 31) & 1;
                    if (i41 == 0) {
                        i12 = 1251644638;
                    }
                    if (i41 == 0) {
                        i6 = i12;
                    } else {
                        i6 = -1469476344;
                    }
                case 1758587480:
                    int length9 = bArr3.length;
                    int i42 = 0 - i5;
                    if ((bArr4[((length9 | i42) - ((822835569 & (~i42)) & length9)) + ((i42 | 822835569) & length9)] > Double.NaN ? 1 : (bArr4[((length9 | i42) - ((822835569 & (~i42)) & length9)) + ((i42 | 822835569) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i6 = -897645243;
                    } else {
                        i6 = -1057239115;
                    }
                    i3 = i5;
                case 2013813686:
                    i5 = bArr3.length % 4;
                    int i43 = ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i43 == 0) {
                        i11 = -897645243;
                    }
                    if (i43 != 0) {
                        i6 = i11;
                    } else {
                        i6 = -2079636786;
                    }
                default:
                    i6 = i12;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void m(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        int i4 = 0;
        byte[] bArr3 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1180709023;
        byte[] bArr4 = null;
        while (true) {
            int i9 = ((i8 & 16777216) * (i8 | 16777216)) + ((i8 & (-16777217)) * ((~i8) & 16777216));
            int i10 = i8 >>> 8;
            int a2 = S.a(i10, i9, 1, ((-1) - i10) | ((-1) - i9));
            int i11 = (a2 ^ (-201803027)) + ((a2 & (-201803027)) * 2);
            int i12 = 1565752577;
            int i13 = 1621215041;
            switch ((i11 - 814310662) - ((i11 & (-814310662)) * 2)) {
                case -2000520841:
                    i = i4;
                    int length = bArr4.length;
                    int i14 = 0 - (0 - i5);
                    if ((bArr3[((length & (~i14)) * 2) - (length ^ i14)] > Double.NaN ? 1 : (bArr3[((length & (~i14)) * 2) - (length ^ i14)] == Double.NaN ? 0 : -1)) <= -1) {
                        i3 = i;
                    } else {
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        i12 = 1621215041;
                    }
                    if (i3 != 0) {
                        i8 = i12;
                    } else {
                        i8 = -1164716566;
                    }
                    i7 = i5;
                    i4 = i;
                case -870579640:
                    int i15 = (i6 - 1) - (i6 | (-4));
                    byte b4 = bArr3[i15];
                    int i16 = ((b4 & ForkServer.DONE) * (b4 | ForkServer.DONE)) + ((b4 & ForkServer.ERROR) * ((~b4) & 16777216));
                    int i17 = i6 + 3 + (((-1) - i6) | (-3));
                    int i18 = bArr3[i17] & ForkServer.ERROR;
                    i = i4;
                    int i19 = i18 * ((~i18) & 65536);
                    int i20 = ~((((-1268032266) | (~i19)) | i16) - ((i19 & (-1268032266)) | i16));
                    int a4 = j3.a((-132004404) & i6, i6, 1, (-132004403) & i6);
                    int i21 = bArr3[a4] & ForkServer.ERROR;
                    int i22 = i21 * ((~i21) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i23 = (i22 + i20) - (i22 & i20);
                    int i24 = bArr3[i6] & ForkServer.ERROR;
                    int i25 = ((~i24) & i23) + i24;
                    byte b5 = bArr4[i15];
                    int i26 = ((b5 & ForkServer.DONE) * (b5 | ForkServer.DONE)) + (((-16777217) & b5) * ((~b5) & 16777216));
                    int i27 = bArr4[i17] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = ~((i26 | ((~i28) | (-1355861741))) - ((i28 & (-1355861741)) | i26));
                    int i30 = bArr4[a4] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int a5 = S.a(i31, i29, 1, ((-1) - i31) | ((-1) - i29));
                    int i32 = (a5 - 1) - ((~(bArr4[i6] & ForkServer.ERROR)) | a5);
                    int i33 = i25 << ((i25 > Double.NaN ? 1 : (i25 == Double.NaN ? 0 : -1)) >>> 31);
                    int i34 = (i33 ^ (-418000873)) + ((i33 & (-418000873)) * 2);
                    int i35 = (i34 + i32) - ((i34 & i32) * 2);
                    bArr4[i6] = (byte) i35;
                    bArr4[a4] = (byte) (i35 >>> 8);
                    bArr4[i17] = (byte) (i35 >>> 16);
                    bArr4[i15] = (byte) (i35 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length2 = bArr4.length;
                    int a6 = AbstractC0044j.a(bArr4.length);
                    if ((((i6 > (((length2 & (~a6)) * 2) - (length2 ^ a6)) ? 1 : (i6 == (((length2 & (~a6)) * 2) - (length2 ^ a6)) ? 0 : -1)) >>> 31) & 1) != 0) {
                        i8 = 1910359311;
                    } else {
                        i8 = 1621215041;
                    }
                    i4 = i;
                case -97532338:
                    i5 = bArr4.length % 4;
                    int i36 = ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i36 != 0) {
                        i13 = 986083301;
                    }
                    if (i36 != 0) {
                        i8 = i13;
                    } else {
                        i8 = -1138188205;
                    }
                case 298177592:
                    int length3 = bArr4.length;
                    int i37 = 0 - i7;
                    int a7 = AbstractC0014b1.a((length3 & 2) | D1.a(i37, length3), i37 * 3);
                    byte b6 = bArr3[a7];
                    int length4 = bArr4.length;
                    int i38 = 0 - i37;
                    int i39 = i38 | length4;
                    byte b7 = bArr3[D.a(i38, 2, i39, (length4 ^ i38) ^ i39)];
                    bArr3[a7] = (byte) (((byte) (b7 ^ b6)) + ((byte) (((byte) 2) * ((byte) (b7 & b6)))));
                    i8 = 1565752577;
                case 373627814:
                    break;
                case 975213712:
                    int length5 = bArr4.length;
                    int i40 = 0 - i7;
                    int length6 = bArr4.length;
                    int i41 = ~i40;
                    byte b8 = bArr4[((length6 | i40) - (((-656070458) & i41) & length6)) + ((i40 | (-656070458)) & length6)];
                    int length7 = bArr4.length;
                    byte b9 = bArr3[(length7 ^ i41) + ((length7 | i40) * 2) + 1];
                    bArr4[((length5 | i40) * 2) - (length5 ^ i40)] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i5 = (~i7) + (i7 * 2);
                    int i42 = ((i7 > 2 ? 1 : (i7 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i42 != 0) {
                        i13 = 986083301;
                    }
                    if (i42 != 0) {
                        i8 = i13;
                    } else {
                        i8 = -1138188205;
                    }
                case 1548321255:
                    int length8 = bArr.length;
                    int length9 = 0 - (0 - (bArr.length % 4));
                    if ((length8 & (~length9)) - ((~length8) & length9) <= 0) {
                        i8 = 1621215041;
                    } else {
                        i8 = 1910359311;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = i4;
                default:
                    i8 = i13;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void n(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -894652659;
        byte[] bArr4 = null;
        while (true) {
            int i6 = ((i5 & 16777216) * (i5 | 16777216)) + ((i5 & (-16777217)) * ((~i5) & 16777216));
            int i7 = i5 >>> 8;
            int i8 = (i7 + i6) - (i7 & i6);
            int i9 = (i8 ^ 1458005263) + ((i8 & 1458005263) * 2);
            int i10 = 145880015;
            int i11 = 1298988808;
            boolean z3 = true;
            switch ((i9 - 1434379843) + (((~i9) & 1434379843) * 2)) {
                case -1970406716:
                    int length = bArr4.length;
                    int i12 = 0 - i;
                    int i13 = ~i12;
                    int i14 = ((length | i12) - ((602749225 & i13) & length)) + ((i12 | 602749225) & length);
                    byte b4 = bArr3[i14];
                    int length2 = bArr4.length;
                    byte b5 = bArr3[(length2 ^ i13) + ((i12 | length2) * 2) + 1];
                    int i15 = ((byte) 0) - b4;
                    bArr3[i14] = (byte) (((byte) (((byte) 2) * ((byte) (b5 & (~i15))))) - ((byte) (b5 ^ i15)));
                    i5 = -34715366;
                case -1882653318:
                    int i16 = (i3 - 1) - (i3 | (-4));
                    byte b6 = bArr3[i16];
                    int i17 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i18 = i3 + 3 + (((-1) - i3) | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int i21 = ~((i17 | ((~i20) | 1169991170)) - ((i20 & 1169991170) | i17));
                    int a2 = j3.a(689061172 & i3, i3, 1, 689061173 & i3);
                    int i22 = bArr3[a2] & ForkServer.ERROR;
                    int i23 = ((~i21) & (i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT))) + i21;
                    int i24 = (i23 - 1) - ((~(bArr3[i3] & ForkServer.ERROR)) | i23);
                    byte b7 = bArr4[i16];
                    int i25 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i26 = bArr4[i18] & ForkServer.ERROR;
                    int i27 = i26 * ((~i26) & 65536);
                    int i28 = ~((i25 | ((~i27) | (-445685625))) - ((i27 & (-445685625)) | i25));
                    int i29 = bArr4[a2] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = (i30 + i28) - (i30 & i28);
                    int i32 = bArr4[i3] & ForkServer.ERROR;
                    int i33 = (i31 & (~i32)) + i32;
                    int i34 = i24 << ((i24 > Double.NaN ? 1 : (i24 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (i34 + i33) - ((i34 & i33) * 2);
                    int i36 = 659933421 - ((i35 & 2) | ((-1983400303) - i35));
                    bArr4[i3] = (byte) i36;
                    bArr4[a2] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[i16] = (byte) (i36 >>> 24);
                    i3 = (i3 ^ 4) + ((i3 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i3 > ((length3 ^ length4) + ((length3 & length4) * 2)) ? 1 : (i3 == ((length3 ^ length4) + ((length3 & length4) * 2)) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i10 = 196573321;
                    }
                    if (i37 != 0) {
                        i5 = -826922365;
                    } else {
                        i5 = i10;
                    }
                case -625567707:
                    break;
                case 172635213:
                    int length5 = bArr4.length;
                    int i38 = 0 - i4;
                    if ((bArr3[(length5 ^ i38) + ((length5 & i38) * 2)] > Double.NaN ? 1 : (bArr3[(length5 ^ i38) + ((length5 & i38) * 2)] == Double.NaN ? 0 : -1)) <= -1) {
                        i5 = 196573321;
                    } else {
                        i5 = -34715366;
                    }
                    i = i4;
                case 614184219:
                    int length6 = bArr4.length;
                    int i39 = 0 - i;
                    int i40 = i39 * 3;
                    int a4 = D1.a(i39, length6);
                    int length7 = bArr4.length;
                    byte b8 = bArr4[(length7 ^ i39) + ((length7 & i39) * 2)];
                    int length8 = bArr4.length;
                    int i41 = 0 - i39;
                    byte b9 = bArr3[(((~i41) & length8) * 2) - (length8 ^ i41)];
                    bArr4[AbstractC0014b1.a((length6 & 2) | a4, i40)] = (byte) (((byte) (b9 + b8)) - ((byte) (((byte) 2) * ((byte) (b9 & b8)))));
                    i4 = ((-338014207) | i) + (338014206 | i);
                    int i42 = ((i > 2 ? 1 : (i == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i42 != 0) {
                        i11 = 196573321;
                    }
                    if (i42 == 0) {
                        i5 = i11;
                    } else {
                        i5 = -518432968;
                    }
                case 835516413:
                    int length9 = bArr.length;
                    int length10 = 0 - (0 - (bArr.length % 4));
                    if ((length9 ^ length10) - (((~length9) & length10) * 2) <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i10 = 196573321;
                    }
                    if (z3) {
                        i5 = -826922365;
                    } else {
                        i5 = i10;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i3 = 0;
                case 1888416065:
                    i4 = bArr4.length % 4;
                    int i43 = ((i4 > 1 ? 1 : (i4 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i43 != 0) {
                        i11 = 196573321;
                    }
                    if (i43 == 0) {
                        i5 = i11;
                    } else {
                        i5 = -518432968;
                    }
                default:
                    i5 = 196573321;
            }
            return;
        }
    }
}
