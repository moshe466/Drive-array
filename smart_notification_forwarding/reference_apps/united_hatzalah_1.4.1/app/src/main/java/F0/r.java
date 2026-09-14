package F0;

import a.AbstractC0228a;
import android.R;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.C0278m;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import f1.AbstractC0416w;
import f1.C0378A;
import i1.AbstractC0449a;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import m1.AbstractC0587a;
import org.apache.tika.fork.ForkServer;
import s2.C0681f;
import s2.C0684i;
import t2.AbstractC0708j;

/* loaded from: classes.dex */
public final class r implements InterfaceC0056m {

    /* renamed from: e, reason: collision with root package name */
    public static final C0072q f614e;

    /* renamed from: f, reason: collision with root package name */
    public static r f615f;

    /* renamed from: g, reason: collision with root package name */
    public static final ReentrantLock f616g;

    /* renamed from: a, reason: collision with root package name */
    public c1.a f617a;

    /* renamed from: b, reason: collision with root package name */
    public String f618b;

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f619c;

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f620d;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, F0.q] */
    static {
        byte[] bArr = {37, 1583449311 ^ ((((~r.class.getName().length()) | (-1376422482)) & 270599308) + ((r.class.getName().length() & 301989890) | 1312849922)), -54, -57, 38, 30};
        h(bArr, new byte[]{75, 62, -25, -93, 84, 115, 55, -34});
        new String(bArr, StandardCharsets.UTF_8).intern();
        f614e = new Object();
        f616g = new ReentrantLock();
    }

    public r(Context context) {
        int f4 = AbstractC0008a.f(r.class, -1);
        this.f619c = new CountDownLatch(1493606413 ^ ((((r.class.getName().length() | 1493311491) - (f4 | 2039686351)) + (AbstractC0008a.f(r.class, 949028047 | f4) + (r.class.getName().length() & 1493311491))) + ((r.class.getName().length() & 1090691072) | 294924)));
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f620d = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new RunnableC0064o(0, context, this));
    }

    public static final void c(Context context, r rVar) {
        ExecutorService executorService = rVar.f620d;
        long j2 = -1;
        long length = r.class.getName().length();
        long j3 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j4 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j5 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j6 = j5 | (j4 + j3);
        long j7 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j8 = j7 + j6 + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j9 = (j8 >>> 48) & 21845;
        long j10 = ((j9 >>> 1) | j9) & 858993459;
        long j11 = ((j10 >>> 2) | j10) & 252645135;
        long j12 = (j8 >>> 32) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) | ((((j11 >>> 4) | j11) & 16711935) << 24);
        long j16 = (j8 >>> 16) & 21845;
        long j17 = ((j16 >>> 1) | j16) & 858993459;
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        long j19 = ((((j18 >>> 4) | j18) & 16711935) << 8) + j15;
        long j20 = j8 & 21845;
        long j21 = ((j20 >>> 1) | j20) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        int length2 = r.class.getName().length() & 874539024;
        byte[] bArr = {-22, 83, ((((~length2) & 272777728) + length2) + ((((int) ((((j22 >>> 4) | j22) & 16711935) | j19)) | (-2105305365)) & 606125073)) ^ (-878902882), 40, -25, -27, -119, 66};
        byte[] bArr2 = new byte[8];
        bArr2[0] = -90;
        bArr2[1] = 6;
        bArr2[2] = 9;
        bArr2[3] = 102;
        bArr2[((((~r.class.getName().length()) | (-1735531021)) & 1208254729) + ((r.class.getName().length() & 1082132556) | 8521796)) ^ 1216776521] = -91;
        bArr2[5] = -106;
        bArr2[6] = 98;
        bArr2[7] = 106;
        d(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        long j23 = 1809884873;
        long j24 = ~r.class.getName().length();
        long j25 = (((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j24 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j24 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j24 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j24 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j26 = (j25 >>> 48) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = (j25 >>> 32) & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        long j32 = ((((j31 >>> 4) | j31) & 16711935) << 16) + ((((j28 >>> 4) | j28) & 16711935) << 24);
        long j33 = (j25 >>> 16) & 43690;
        long j34 = ((j33 >>> 2) | (j33 >>> 1)) & 858993459;
        long j35 = ((j34 >>> 2) | j34) & 252645135;
        long j36 = j25 & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = ((j37 >>> 2) | j37) & 252645135;
        int i = (int) ((((j38 >>> 4) | j38) & 16711935) | ((((j35 >>> 4) | j35) & 16711935) << 8) | j32);
        int i3 = (i | 146801165) - (i ^ 146801165);
        int length3 = r.class.getName().length();
        byte[] bArr3 = new byte[197168715 ^ ((((length3 & 2116) + 50367552) - (length3 & 2112)) + i3)];
        bArr3[0] = 104;
        bArr3[1] = -124;
        bArr3[2] = 20;
        bArr3[3] = 29;
        bArr3[4] = 13;
        bArr3[5] = -85;
        d(bArr3, new byte[]{59, -101, 41, 20, -69, -103, 120, -86});
        new String(bArr3, charset).intern();
        CountDownLatch countDownLatch = rVar.f619c;
        try {
            C0084t0 a2 = c1.e.a(context);
            try {
                rVar.b(a2);
                countDownLatch.countDown();
                try {
                    rVar.f(a2);
                } finally {
                }
            } finally {
            }
        } catch (Exception unused) {
            byte length4 = ((((~r.class.getName().length()) | (-1392739044)) & 940113952) + ((r.class.getName().length() & 268502048) | (-2130697216))) ^ (-1190583204);
            long length5 = r.class.getName().length();
            long j39 = (j5 | j4 | j3 | j7) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j40 = (j39 >>> 48) & 21845;
            long j41 = ((j40 >>> 1) | j40) & 858993459;
            long j42 = ((j41 >>> 2) | j41) & 252645135;
            long j43 = (j39 >>> 32) & 21845;
            long j44 = ((j43 >>> 1) | j43) & 858993459;
            long j45 = ((j44 >>> 2) | j44) & 252645135;
            long j46 = ((((j45 >>> 4) | j45) & 16711935) << 16) + ((((j42 >>> 4) | j42) & 16711935) << 24);
            long j47 = (j39 >>> 16) & 21845;
            long j48 = ((j47 >>> 1) | j47) & 858993459;
            long j49 = ((j48 >>> 2) | j48) & 252645135;
            long j50 = j39 & 21845;
            long j51 = ((j50 >>> 1) | j50) & 858993459;
            long j52 = ((j51 >>> 2) | j51) & 252645135;
            byte[] bArr4 = {length4, 73, -16, 29, (((((int) ((((((j49 >>> 4) | j49) & 16711935) << 8) | j46) | (((j52 >>> 4) | j52) & 16711935))) | (-439610599)) & 1891651972) + ((r.class.getName().length() & 270156932) | 1713664)) ^ 1893365664, -122, 20, 94, 38, 13, 52, -34, 42, 76, 87, 9, 93};
            d(bArr4, new byte[]{31, ((((~r.class.getName().length()) | (-605503456)) & 115020320) + ((r.class.getName().length() & (-2078862848)) | (-1878777836))) ^ (-1763757542), 63, -4, 99, -67, -110, 28, 52, 9, 0, -54, -94, -32, 71, 109, -73});
            Charset charset2 = StandardCharsets.UTF_8;
            new String(bArr4, charset2).intern();
            byte[] bArr5 = new byte[37];
            bArr5[0] = 88;
            bArr5[1] = 36;
            bArr5[2] = -114;
            bArr5[3] = 109;
            bArr5[4] = 78;
            bArr5[5] = 62;
            bArr5[6] = -70;
            bArr5[7] = 21;
            bArr5[8] = 22;
            int i4 = ((~r.class.getName().length()) | (-353820825)) & (-1978594420);
            int length6 = r.class.getName().length();
            bArr5[((((length6 & 1492120) + 967792) - (length6 & 443408)) + i4) ^ (-1977626635)] = -125;
            bArr5[10] = -47;
            bArr5[11] = -119;
            bArr5[12] = -106;
            bArr5[13] = -44;
            bArr5[14] = 88;
            bArr5[15] = 63;
            bArr5[16] = -120;
            bArr5[17] = -38;
            bArr5[18] = -41;
            bArr5[19] = -49;
            bArr5[20] = 31;
            bArr5[21] = 21;
            long j53 = 795581886;
            long j54 = ~r.class.getName().length();
            long j55 = (((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
            long j56 = (j55 >>> 48) & 43690;
            long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
            long j58 = ((j57 >>> 2) | j57) & 252645135;
            long j59 = (j55 >>> 32) & 43690;
            long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
            long j61 = ((j60 >>> 2) | j60) & 252645135;
            long j62 = ((((j61 >>> 4) | j61) & 16711935) << 16) | ((((j58 >>> 4) | j58) & 16711935) << 24);
            long j63 = (j55 >>> 16) & 43690;
            long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
            long j65 = ((j64 >>> 2) | j64) & 252645135;
            long j66 = j55 & 43690;
            long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
            long j68 = ((j67 >>> 2) | j67) & 252645135;
            int i5 = ((int) ((((j68 >>> 4) | j68) & 16711935) + (((((j65 >>> 4) | j65) & 16711935) << 8) | j62))) & 46276260;
            bArr5[22] = S.a(r.class.getName().length() & (-1048247743), ((-r11) - 1) | 788168638, -788168638, i5) ^ (-741892455);
            bArr5[23] = 62;
            bArr5[24] = 30;
            bArr5[25] = -72;
            bArr5[26] = -93;
            bArr5[27] = -116;
            bArr5[28] = 47;
            bArr5[29] = 1;
            bArr5[30] = 35;
            bArr5[31] = 41;
            bArr5[32] = -126;
            bArr5[33] = 122;
            bArr5[34] = 117;
            bArr5[35] = 14;
            bArr5[36] = 6;
            byte[] bArr6 = new byte[37];
            bArr6[0] = 3;
            bArr6[1] = 40;
            long j69 = -743051209;
            long j70 = ~r.class.getName().length();
            long b4 = c3.b((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
            long j71 = (b4 >>> 48) & 43690;
            long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
            long j73 = ((j72 >>> 2) | j72) & 252645135;
            long j74 = (b4 >>> 32) & 43690;
            long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
            long j76 = ((j75 >>> 2) | j75) & 252645135;
            long j77 = ((((j76 >>> 4) | j76) & 16711935) << 16) | ((((j73 >>> 4) | j73) & 16711935) << 24);
            long j78 = (b4 >>> 16) & 43690;
            long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
            long j80 = ((j79 >>> 2) | j79) & 252645135;
            long j81 = b4 & 43690;
            long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
            long j83 = (j82 | (j82 >>> 2)) & 252645135;
            int length7 = r.class.getName().length();
            int i6 = ((84609184 & length7) ^ (-1048510423)) + (length7 & R.attr.description) + (((int) (((j83 | (j83 >>> 4)) & 16711935) + ((((j80 >>> 4) | j80) & 16711935) << 8) + j77)) & 370845842);
            bArr6[2] = (677664592 + i6) - ((677664592 & i6) * 2);
            bArr6[3] = -89;
            long j84 = 1774297093;
            long j85 = (~r.class.getName().length()) | 1933508320;
            long j86 = (((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j87 = (j86 >>> 48) & 43690;
            long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
            long j89 = ((j88 >>> 2) | j88) & 252645135;
            long j90 = (j86 >>> 32) & 43690;
            long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
            long j92 = ((j91 >>> 2) | j91) & 252645135;
            long j93 = ((((j92 >>> 4) | j92) & 16711935) << 16) + ((((j89 >>> 4) | j89) & 16711935) << 24);
            long j94 = (j86 >>> 16) & 43690;
            long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
            long j96 = ((j95 >>> 2) | j95) & 252645135;
            long j97 = j86 & 43690;
            long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
            long j99 = ((j98 >>> 2) | j98) & 252645135;
            bArr6[(((int) ((((j99 >>> 4) | j99) & 16711935) + (((((j96 >>> 4) | j96) & 16711935) << 8) | j93))) + ((r.class.getName().length() & 147149829) | 1332232)) ^ 1775629321] = 43;
            bArr6[((((~r.class.getName().length()) | (-412006112)) & (-1793588927)) + ((r.class.getName().length() & 268961897) | 133288)) ^ (-1793455636)] = 55;
            bArr6[6] = -59;
            bArr6[7] = 55;
            bArr6[8] = -100;
            bArr6[9] = 34;
            bArr6[10] = 104;
            bArr6[11] = 18;
            bArr6[12] = -123;
            bArr6[13] = 1;
            bArr6[14] = -5;
            bArr6[15] = 99;
            bArr6[16] = -74;
            bArr6[17] = 119;
            bArr6[18] = -1;
            bArr6[19] = -20;
            bArr6[20] = -100;
            bArr6[21] = -87;
            bArr6[22] = -79;
            bArr6[23] = -66;
            bArr6[24] = -45;
            bArr6[25] = 90;
            bArr6[26] = -104;
            bArr6[27] = -117;
            bArr6[28] = 81;
            long j100 = -387372912;
            long j101 = ~r.class.getName().length();
            long j102 = (((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j101 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j101 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j101 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j101 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
            long j103 = (j102 >>> 48) & 43690;
            long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
            long j105 = ((j104 >>> 2) | j104) & 252645135;
            long j106 = (j102 >>> 32) & 43690;
            long j107 = ((j106 >>> 2) | (j106 >>> 1)) & 858993459;
            long j108 = ((j107 >>> 2) | j107) & 252645135;
            long j109 = ((((j108 >>> 4) | j108) & 16711935) << 16) | ((((j105 >>> 4) | j105) & 16711935) << 24);
            long j110 = (j102 >>> 16) & 43690;
            long j111 = ((j110 >>> 2) | (j110 >>> 1)) & 858993459;
            long j112 = ((j111 >>> 2) | j111) & 252645135;
            long j113 = j102 & 43690;
            long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
            long j115 = ((j114 >>> 2) | j114) & 252645135;
            int i7 = ((int) (((((j112 >>> 4) | j112) & 16711935) << 8) | j109 | (((j115 >>> 4) | j115) & 16711935))) & (-1593455613);
            int length8 = r.class.getName().length();
            long j116 = 137367556;
            long j117 = (154457091 + length8) - (length8 | 154457091);
            long b5 = c3.b((((((((j116 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j116 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j116 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j116 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j117 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j117 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j117 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j117 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
            long j118 = (b5 >>> 48) & 43690;
            long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
            long j120 = ((j119 >>> 2) | j119) & 252645135;
            long j121 = (b5 >>> 32) & 43690;
            long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
            long j123 = ((j122 >>> 2) | j122) & 252645135;
            long j124 = ((((j123 >>> 4) | j123) & 16711935) << 16) + ((((j120 >>> 4) | j120) & 16711935) << 24);
            long j125 = (b5 >>> 16) & 43690;
            long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
            long j127 = ((j126 >>> 2) | j126) & 252645135;
            long j128 = b5 & 43690;
            long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
            long j130 = ((j129 >>> 2) | j129) & 252645135;
            bArr6[(i7 + ((int) ((((j130 >>> 4) | j130) & 16711935) + (((((j127 >>> 4) | j127) & 16711935) << 8) + j124)))) ^ (-1456088038)] = -23;
            bArr6[30] = 23;
            bArr6[31] = -78;
            bArr6[32] = -5;
            bArr6[33] = 13;
            long length9 = r.class.getName().length();
            long j131 = (j7 | j6) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j132 = (j131 >>> 48) & 21845;
            long j133 = (j132 | (j132 >>> 1)) & 858993459;
            long j134 = (j133 | (j133 >>> 2)) & 252645135;
            long j135 = (j131 >>> 32) & 21845;
            long j136 = (j135 | (j135 >>> 1)) & 858993459;
            long j137 = (j136 | (j136 >>> 2)) & 252645135;
            long j138 = (((j134 | (j134 >>> 4)) & 16711935) << 24) | (((j137 | (j137 >>> 4)) & 16711935) << 16);
            long j139 = (j131 >>> 16) & 21845;
            long j140 = (j139 | (j139 >>> 1)) & 858993459;
            long j141 = (j140 | (j140 >>> 2)) & 252645135;
            long j142 = j131 & 21845;
            long j143 = (j142 | (j142 >>> 1)) & 858993459;
            long j144 = (j143 | (j143 >>> 2)) & 252645135;
            bArr6[770061927 ^ (((((int) (((j144 | (j144 >>> 4)) & 16711935) | ((((j141 | (j141 >>> 4)) & 16711935) << 8) + j138))) | (-1863686927)) & 702812677) + ((r.class.getName().length() & 755242500) | 67249216))] = 126;
            bArr6[35] = -21;
            bArr6[36] = -36;
            d(bArr5, bArr6);
            new String(bArr5, charset2).intern();
            for (int i8 = 0; i8 < ((int) countDownLatch.getCount()); i8++) {
            }
        } finally {
            executorService.shutdown();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~r.class.getName().length();
        int length3 = (((~(((r.class.getName().length() | 70245657) | i7) - (i7 | (r.class.getName().length() & (-70245658))))) & (-1979440632)) + ((r.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(r.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((r.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~r.class.getName().length()) | (-576567005)) & 276971586) + ((r.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~r.class.getName().length()) | (-1157759625)) & 1755853004) + ((r.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~r.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = r.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~r.class.getName().length()) | (-1064961)) + 689325073) + ((r.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~r.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = r.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~r.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (r.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((r.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~r.class.getName().length();
                    int length11 = (161497089 & (((((r.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((r.class.getName().length() | i14) & 797295576))) + ((r.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~r.class.getName().length()) | (-1085986263)) & 1078327440) + ((r.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~r.class.getName().length();
                    int length12 = length5 >>> ((((~(((r.class.getName().length() | 626856794) | i15) - ((r.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((r.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~r.class.getName().length()) | 1248713193) & 826417528) + ((r.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~r.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (r.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~r.class.getName().length()) | (-1005965450)) & 153223237) + ((r.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((r.class.getName().length() & (~length6)) & i9)) + ((r.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~r.class.getName().length()) | (-30261291)) & (-1534000062)) + ((r.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~r.class.getName().length()) | (-23496740)) & 827084804) + ((r.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~r.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (r.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~r.class.getName().length()) | (-961655275)) & 25184460) + ((r.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~r.class.getName().length()) | 1233459797) & 125923146) + ((r.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~r.class.getName().length()) | (-7107622)) & 402932290) + ((r.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((r.class.getName().length() | length15) - (b4 | length15)) + I2.a(r.class, b4) + (r.class.getName().length() & length15);
                    int length17 = ((((~r.class.getName().length()) | (-81143879)) & 438583424) + ((r.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~r.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((r.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(r.class, 568748773 | i24) + (r.class.getName().length() & (-2105278367)))) + ((r.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~r.class.getName().length()) | (-1592082969)) & 140665109) + ((r.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~r.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((r.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~r.class.getName().length()) | (-180811308));
                    int length19 = (r.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((r.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | r.class.getName().length()))));
                    int i29 = ((~r.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (r.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~r.class.getName().length()) | 75364313) & 1242301609) + ((r.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = r.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((r.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~r.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((r.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~r.class.getName().length();
                    int length24 = 1409942802 & (((((r.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | r.class.getName().length()) & 91135407));
                    int length25 = (r.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~r.class.getName().length()) | (-537919489)) - (-806798471)) + ((r.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~r.class.getName().length()) | (-382746167)) & 102532165) + ((r.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~r.class.getName().length()) | (-6036961)) & 1233145505) + ((r.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~r.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = r.class.getName().length() & 268460041;
                    i5 = (((((r.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | r.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = r.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((r.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~r.class.getName().length()) | (-1883938358)) & (-738125179)) + ((r.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~r.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (r.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(r.class, -1) | (-532481)) - (-67641369)) + ((r.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~r.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((r.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(r.class, -1) | (-33554434)) - (-1107366402)) + ((r.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(r.class, -1) | (-167014194)) & 1157999680) + ((r.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = r.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((r.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(r.class, -1) | 114408723) & 1183666176;
                    int length33 = r.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~r.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = r.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~r.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (r.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~r.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((r.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~r.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (r.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~r.class.getName().length()) | 991120067) & (-2113137661)) + ((r.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(r.class, -1) | 314136709) & 371231304) + (((r.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~r.class.getName().length()) | 366661365) & 1344150018) + ((r.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~r.class.getName().length()) | (-1359635359)) & 49026131) + ((r.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~r.class.getName().length();
                    if (length3 > 0) {
                        int length38 = r.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (r.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~r.class.getName().length()) | 1110430873) & 1241612298) + ((r.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~r.class.getName().length()) | 1603962366) & 25199440) + (((r.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~r.class.getName().length()) | (-1388708984)) & 706816128) + ((r.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~r.class.getName().length()) | 367288948) & 548745488;
                    int length41 = r.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~r.class.getName().length()) | 2113158628) & 1026558002) + ((r.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~r.class.getName().length()) | 715175224) & 136512788) + ((r.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~r.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = r.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~r.class.getName().length()) | (-1084937228)) & 438503696) + ((r.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~r.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((r.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(r.class, 1197735420 | i53) + (r.class.getName().length() & 674349280))) + ((r.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~r.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (r.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~r.class.getName().length()) | (-171976913)) & 318775824) + ((r.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~r.class.getName().length()) | (-616910267)) & 1303391760) + ((r.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~r.class.getName().length()) | 1297715640) & 556926729) + ((r.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~r.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((r.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~r.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (r.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void g(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        byte[] bArr3 = null;
        int i4 = 1516727821;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i4 & 16777216) * (i4 | 16777216)) + ((i4 & (-16777217)) * ((~i4) & 16777216));
            int i9 = i4 >>> 8;
            int a2 = j3.a(650911840 & (~i8) & i9, i9, i8, (i8 | 650911840) & i9);
            int i10 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
            int i11 = -365117735;
            boolean z3 = true;
            switch (((~i10) + ((i10 | 1) * 2)) ^ 962785775) {
                case -1896910703:
                    int length = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = (length ^ i12) + ((length & i12) * 2);
                    byte b4 = bArr3[i13];
                    int length2 = bArr4.length;
                    int i14 = 0 - i12;
                    int i15 = i14 | length2;
                    byte b5 = bArr3[D.a(i14, 2, i15, (length2 ^ i14) ^ i15)];
                    bArr3[i13] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i4 = -746753280;
                case -1725904394:
                    i7 = bArr4.length % 4;
                    if ((((i7 > 1 ? 1 : (i7 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case -1399959314:
                    int a4 = j3.a((-1205100636) & i6, i6, 3, (-1205100633) & i6);
                    byte b6 = bArr3[a4];
                    int i16 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i17 = i6 - 1;
                    int i18 = i17 - (i6 | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int a5 = S.a(i20, i16, 1, ((-1) - i20) | ((-1) - i16));
                    int i21 = i17 - (i6 | (-2));
                    int i22 = bArr3[i21] & ForkServer.ERROR;
                    int i23 = i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i24 = (i23 - 1) - ((~a5) | i23);
                    int i25 = bArr3[i6] & ForkServer.ERROR;
                    int a6 = S.a(i24, i25, 1, ((-1) - i24) | ((-1) - i25));
                    byte b7 = bArr4[a4];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i18] & ForkServer.ERROR;
                    int i28 = ((i27 * ((~i27) & 65536)) & (~i26)) + i26;
                    int i29 = bArr4[i21] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = ~((((~i30) | 911399251) | i28) - ((i30 & 911399251) | i28));
                    int i32 = bArr4[i6] & ForkServer.ERROR;
                    int i33 = ~((((~i31) | 1433568692) | i32) - ((i31 & 1433568692) | i32));
                    int i34 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (-1254002618) - ((i34 & 2) | ((-1672003491) - i34));
                    int i36 = (i35 + i33) - ((i35 & i33) * 2);
                    bArr4[i6] = (byte) i36;
                    bArr4[i21] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[a4] = (byte) (i36 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 1 : (i6 == AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i = -1605440657;
                    } else {
                        i = -365117735;
                    }
                    if (i37 != 0) {
                        i4 = i;
                    } else {
                        i4 = -169475207;
                    }
                case -1135475043:
                    break;
                case 180635757:
                    int length5 = bArr.length;
                    int length6 = 0 - (bArr.length % 4);
                    if ((length5 ^ (~length6)) + ((length5 | length6) * 2) + 1 <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (z3) {
                        i4 = i3;
                    } else {
                        i4 = -169475207;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case 511524454:
                    int length7 = bArr4.length;
                    int i38 = 0 - i5;
                    int i39 = 0 - i38;
                    int i40 = ((~length7) & i39) * 2;
                    int length8 = bArr4.length;
                    byte b8 = bArr4[((length8 | i38) * 2) - (length8 ^ i38)];
                    int length9 = bArr4.length;
                    byte b9 = bArr3[(i38 ^ length9) + ((length9 & i38) * 2)];
                    bArr4[(length7 ^ i39) - i40] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i7 = AbstractC0099x.a(i5, 3, (~i5) * 2);
                    if ((((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case 961838909:
                    int length10 = bArr4.length;
                    int i41 = 0 - i7;
                    if ((bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] > Double.NaN ? 1 : (bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        i11 = 1093626513;
                    }
                    if (z3) {
                        i4 = -746753280;
                    } else {
                        i4 = i11;
                    }
                    i5 = i7;
                default:
                    i4 = -365117735;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void h(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void j(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
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

    public final String a() {
        c1.a aVar = null;
        String str = null;
        char c4 = 42161;
        while (true) {
            if (c4 != 22348) {
                if (c4 != 29919) {
                    if (c4 != 42161) {
                        if (c4 == 32797) {
                            return str;
                        }
                    } else {
                        this.f619c.await();
                        aVar = this.f617a;
                        if (aVar == null) {
                            c4 = 29919;
                        }
                    }
                    c4 = 22348;
                } else {
                    str = null;
                }
            } else {
                str = aVar.f3866d;
            }
            c4 = 32797;
        }
    }

    public final void b(C0084t0 c0084t0) {
        Object g3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        androidx.lifecycle.N n4 = c1.b.f3867a;
        C0068p c0068p = new C0068p(0, this, countDownLatch);
        try {
            AbstractC0587a.f5865a.submit(new Q2(new C0278m(c0084t0, c0068p, c0068p), 13));
            g3 = C0684i.f6340a;
        } catch (Throwable th) {
            g3 = AbstractC0228a.g(th);
        }
        Throwable a2 = C0681f.a(g3);
        if (a2 != null) {
            c0068p.invoke(AbstractC0449a.f4971a);
            E1.b.l(a2);
        }
        countDownLatch.await(5L, TimeUnit.SECONDS);
    }

    public final String e() {
        c1.a aVar = null;
        String str = null;
        char c4 = 38088;
        while (true) {
            if (c4 != 35098) {
                if (c4 != 38088) {
                    if (c4 != 55179) {
                        if (c4 == 48755) {
                            return str;
                        }
                    } else {
                        str = null;
                    }
                } else {
                    this.f619c.await();
                    aVar = this.f617a;
                    if (aVar != null) {
                        c4 = 35098;
                    } else {
                        c4 = 55179;
                    }
                }
            } else {
                str = aVar.f3865c;
            }
            c4 = 48755;
        }
    }

    public final void f(C0084t0 c0084t0) {
        C0378A c0378a = null;
        while (true) {
            char c4 = 20603;
            while (c4 != 2048) {
                if (c4 == 57178) {
                    byte[] bArr = new byte[76];
                    bArr[0] = 67;
                    bArr[1] = -109;
                    bArr[2] = 47;
                    bArr[3] = -66;
                    bArr[4] = -93;
                    bArr[5] = 28;
                    bArr[6] = -126;
                    bArr[7] = 59;
                    bArr[8] = -30;
                    bArr[9] = 66;
                    bArr[10] = 125;
                    bArr[11] = 86;
                    bArr[12] = 100;
                    long j2 = -1;
                    long length = r.class.getName().length();
                    long j3 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j4 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j5 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j6 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j7 = j6 + j5 + (j4 | j3) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j8 = (j7 >>> 48) & 21845;
                    long j9 = ((j8 >>> 1) | j8) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = (j7 >>> 32) & 21845;
                    long j12 = ((j11 >>> 1) | j11) & 858993459;
                    long j13 = ((j12 >>> 2) | j12) & 252645135;
                    long j14 = ((((j13 >>> 4) | j13) & 16711935) << 16) + ((((j10 >>> 4) | j10) & 16711935) << 24);
                    long j15 = (j7 >>> 16) & 21845;
                    long j16 = ((j15 >>> 1) | j15) & 858993459;
                    long j17 = ((j16 >>> 2) | j16) & 252645135;
                    long j18 = j7 & 21845;
                    long j19 = ((j18 >>> 1) | j18) & 858993459;
                    long j20 = ((j19 >>> 2) | j19) & 252645135;
                    long j21 = 145770501;
                    long j22 = (-1325647618) - ((~((int) ((((j20 >>> 4) | j20) & 16711935) + (((((j17 >>> 4) | j17) & 16711935) << 8) + j14)))) | (-1325647617));
                    long j23 = (((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j24 = (j23 >>> 48) & 43690;
                    long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                    long j26 = ((j25 >>> 2) | j25) & 252645135;
                    long j27 = (j23 >>> 32) & 43690;
                    long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                    long j29 = ((j28 >>> 2) | j28) & 252645135;
                    long j30 = ((((j29 >>> 4) | j29) & 16711935) << 16) + ((((j26 >>> 4) | j26) & 16711935) << 24);
                    long j31 = (j23 >>> 16) & 43690;
                    long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                    long j33 = ((j32 >>> 2) | j32) & 252645135;
                    long j34 = j23 & 43690;
                    long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                    long j36 = ((j35 >>> 2) | j35) & 252645135;
                    int i = (int) ((((((j33 >>> 4) | j33) & 16711935) << 8) + j30) | (((j36 >>> 4) | j36) & 16711935));
                    int length2 = (r.class.getName().length() & 402682064) | 272642256;
                    bArr[13] = (((i & length2) * 2) + (length2 ^ i)) ^ 418412721;
                    bArr[14] = -124;
                    bArr[15] = 13;
                    bArr[16] = 46;
                    bArr[17] = -126;
                    bArr[18] = -38;
                    bArr[19] = -48;
                    bArr[20] = 90;
                    bArr[21] = 69;
                    bArr[22] = 67;
                    bArr[23] = 77;
                    bArr[24] = 34;
                    bArr[25] = -25;
                    bArr[26] = -57;
                    bArr[27] = 50;
                    bArr[28] = -37;
                    bArr[29] = -120;
                    bArr[30] = -45;
                    bArr[31] = 62;
                    bArr[32] = -90;
                    bArr[33] = -119;
                    bArr[34] = 75;
                    long length3 = r.class.getName().length();
                    long j37 = j4 + j3;
                    long j38 = (j6 | (j37 + j5)) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j39 = (j38 >>> 48) & 21845;
                    long j40 = ((j39 >>> 1) | j39) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = (j38 >>> 32) & 21845;
                    long j43 = ((j42 >>> 1) | j42) & 858993459;
                    long j44 = ((j43 >>> 2) | j43) & 252645135;
                    long j45 = ((((j44 >>> 4) | j44) & 16711935) << 16) | ((((j41 >>> 4) | j41) & 16711935) << 24);
                    long j46 = (j38 >>> 16) & 21845;
                    long j47 = ((j46 >>> 1) | j46) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    long j49 = ((((j48 >>> 4) | j48) & 16711935) << 8) + j45;
                    long j50 = j38 & 21845;
                    long j51 = ((j50 >>> 1) | j50) & 858993459;
                    long j52 = ((j51 >>> 2) | j51) & 252645135;
                    long j53 = 1067440;
                    long length4 = (r.class.getName().length() | (-33554617)) - (-33554617);
                    long j54 = (((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                    long j55 = (j54 >>> 48) & 43690;
                    long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
                    long j57 = ((j56 >>> 2) | j56) & 252645135;
                    long j58 = (j54 >>> 32) & 43690;
                    long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                    long j60 = ((j59 >>> 2) | j59) & 252645135;
                    long j61 = ((((j60 >>> 4) | j60) & 16711935) << 16) | ((((j57 >>> 4) | j57) & 16711935) << 24);
                    long j62 = (j54 >>> 16) & 43690;
                    long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    long j65 = j54 & 43690;
                    long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
                    long j67 = (j66 | (j66 >>> 2)) & 252645135;
                    bArr[642809247 ^ (((((int) ((((j52 >>> 4) | j52) & 16711935) | j49)) | 1826078470) & 641741836) + ((int) (((j67 | (j67 >>> 4)) & 16711935) | (((((j64 >>> 4) | j64) & 16711935) << 8) + j61))))] = 79;
                    bArr[36] = 105;
                    bArr[37] = 89;
                    bArr[38] = Byte.MIN_VALUE;
                    bArr[39] = 37;
                    bArr[40] = -120;
                    bArr[41] = -43;
                    bArr[42] = -76;
                    bArr[43] = -77;
                    bArr[44] = 84;
                    bArr[45] = 68;
                    bArr[46] = 34;
                    bArr[47] = 113;
                    bArr[((((~r.class.getName().length()) | (-1880645807)) & 162531911) + ((r.class.getName().length() & 102105374) | 105267480)) ^ 267799407] = 6;
                    bArr[49] = 85;
                    bArr[50] = 63;
                    bArr[51] = -79;
                    bArr[52] = -8;
                    bArr[53] = ((((~r.class.getName().length()) | (-1926087392)) & (-2135937434)) + ((r.class.getName().length() & 8684118) | 1342537872)) ^ (-793399619);
                    bArr[54] = 88;
                    bArr[55] = 75;
                    bArr[56] = 57;
                    bArr[57] = -81;
                    bArr[58] = 122;
                    int length5 = r.class.getName().length();
                    long j68 = 312738948;
                    long j69 = (-553545308) | ((length5 - 1) - (length5 * 2));
                    long j70 = (((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j71 = (j70 >>> 48) & 43690;
                    long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                    long j73 = ((j72 >>> 2) | j72) & 252645135;
                    long j74 = (j70 >>> 32) & 43690;
                    long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    long j77 = ((((j76 >>> 4) | j76) & 16711935) << 16) + ((((j73 >>> 4) | j73) & 16711935) << 24);
                    long j78 = (j70 >>> 16) & 43690;
                    long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                    long j80 = ((j79 >>> 2) | j79) & 252645135;
                    long j81 = j70 & 43690;
                    long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                    long j83 = ((j82 >>> 2) | j82) & 252645135;
                    int i3 = (int) ((((j83 >>> 4) | j83) & 16711935) | ((((j80 >>> 4) | j80) & 16711935) << 8) | j77);
                    int length6 = r.class.getName().length();
                    bArr[59] = (i3 + (4727040 | ((14951424 | length6) - (length6 ^ 14951424)))) ^ (-317466030);
                    bArr[((((~r.class.getName().length()) | (-696256282)) & 818206721) + ((r.class.getName().length() & 629284865) | 1157767376)) ^ 1975974125] = 110;
                    bArr[61] = 11;
                    bArr[62] = 59;
                    bArr[63] = -7;
                    bArr[64] = 70;
                    bArr[65] = -92;
                    bArr[66] = 105;
                    bArr[67] = -19;
                    bArr[68] = 90;
                    bArr[69] = 35;
                    bArr[70] = ((((~r.class.getName().length()) | 574332751) & (-2144724915)) + ((r.class.getName().length() & (-1073446896)) | 1887748624)) ^ 256976346;
                    bArr[71] = -82;
                    bArr[72] = -32;
                    bArr[73] = -74;
                    bArr[74] = 90;
                    bArr[75] = 111;
                    byte[] bArr2 = new byte[76];
                    long length7 = r.class.getName().length();
                    long j84 = (j6 | j5 | j37) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j85 = (j84 >>> 48) & 21845;
                    long j86 = ((j85 >>> 1) | j85) & 858993459;
                    long j87 = ((j86 >>> 2) | j86) & 252645135;
                    long j88 = (j84 >>> 32) & 21845;
                    long j89 = ((j88 >>> 1) | j88) & 858993459;
                    long j90 = ((j89 >>> 2) | j89) & 252645135;
                    long j91 = ((((j90 >>> 4) | j90) & 16711935) << 16) | ((((j87 >>> 4) | j87) & 16711935) << 24);
                    long j92 = (j84 >>> 16) & 21845;
                    long j93 = ((j92 >>> 1) | j92) & 858993459;
                    long j94 = ((j93 >>> 2) | j93) & 252645135;
                    long j95 = j84 & 21845;
                    long j96 = ((j95 >>> 1) | j95) & 858993459;
                    long j97 = ((j96 >>> 2) | j96) & 252645135;
                    int i4 = (((int) ((((j97 >>> 4) | j97) & 16711935) + (((((j94 >>> 4) | j94) & 16711935) << 8) | j91))) | 1800956131) & 17359032;
                    long j98 = 5277720;
                    long length8 = r.class.getName().length();
                    long j99 = (((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j98 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j100 = (j99 >>> 48) & 43690;
                    long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                    long j102 = ((j101 >>> 2) | j101) & 252645135;
                    long j103 = (j99 >>> 32) & 43690;
                    long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
                    long j105 = ((j104 >>> 2) | j104) & 252645135;
                    long j106 = ((((j105 >>> 4) | j105) & 16711935) << 16) + ((((j102 >>> 4) | j102) & 16711935) << 24);
                    long j107 = (j99 >>> 16) & 43690;
                    long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
                    long j109 = ((j108 >>> 2) | j108) & 252645135;
                    long j110 = j99 & 43690;
                    long j111 = ((j110 >>> 2) | (j110 >>> 1)) & 858993459;
                    long j112 = ((j111 >>> 2) | j111) & 252645135;
                    int i5 = ~(((int) ((((j112 >>> 4) | j112) & 16711935) + ((((j109 >>> 4) | j109) & 16711935) << 8) + j106)) | 1112541248);
                    int i6 = -i4;
                    bArr2[0] = V2.a(~i6, i5, (i5 + i6) + 1) ^ 1129900285;
                    bArr2[1] = -14;
                    bArr2[2] = 70;
                    bArr2[3] = -46;
                    int i7 = ((~r.class.getName().length()) | 1974141103) & 201396771;
                    int length9 = r.class.getName().length();
                    bArr2[(i7 + (303038552 | ((437260800 | length9) - (length9 ^ 437260800)))) ^ 504435327] = -58;
                    bArr2[5] = 120;
                    bArr2[6] = -94;
                    bArr2[7] = 79;
                    bArr2[8] = -115;
                    bArr2[9] = 98;
                    bArr2[10] = 18;
                    bArr2[11] = 52;
                    bArr2[12] = 16;
                    bArr2[13] = 5;
                    bArr2[14] = -19;
                    bArr2[15] = 99;
                    bArr2[16] = 14;
                    bArr2[17] = -28;
                    bArr2[18] = -77;
                    int a2 = I2.a(r.class, -1);
                    int length10 = (185008480 & (((((r.class.getName().length() & (~a2)) & 720176381) + 720176381) + a2) - ((a2 | r.class.getName().length()) & 720176381))) + ((r.class.getName().length() & 16912640) | 69228545);
                    bArr2[(254237042 | length10) - (length10 & 254237042)] = -66;
                    bArr2[20] = 61;
                    bArr2[21] = 32;
                    bArr2[22] = 49;
                    bArr2[23] = ((((~r.class.getName().length()) | 1390194681) & 1151865908) + ((r.class.getName().length() & 69210116) | 269486728)) ^ 1421352577;
                    bArr2[24] = 80;
                    int length11 = r.class.getName().length();
                    bArr2[25] = ((((-231751) | (((~length11) - length11) + length11)) & 285372689) + ((r.class.getName().length() & 537002240) | 645955716)) ^ (-931328485);
                    bArr2[26] = -87;
                    bArr2[27] = 70;
                    long j113 = 959052686;
                    long a4 = I2.a(r.class, -1);
                    long b4 = c3.b((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16), ((((((((a4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((a4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((a4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((a4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                    long j114 = (b4 >>> 48) & 43690;
                    long j115 = ((j114 >>> 2) | (j114 >>> 1)) & 858993459;
                    long j116 = (j115 | (j115 >>> 2)) & 252645135;
                    long j117 = (b4 >>> 32) & 43690;
                    long j118 = ((j117 >>> 2) | (j117 >>> 1)) & 858993459;
                    long j119 = ((j118 >>> 2) | j118) & 252645135;
                    long j120 = (((j116 | (j116 >>> 4)) & 16711935) << 24) | ((((j119 >>> 4) | j119) & 16711935) << 16);
                    long j121 = (b4 >>> 16) & 43690;
                    long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                    long j123 = ((j122 >>> 2) | j122) & 252645135;
                    long j124 = b4 & 43690;
                    long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
                    long j126 = (j125 | (j125 >>> 2)) & 252645135;
                    int length12 = 537673745 + (r.class.getName().length() & 637550592) + (((-r6) - 1) | (-537673745)) + (((int) (((j126 | (j126 >>> 4)) & 16711935) + (j120 | ((((j123 >>> 4) | j123) & 16711935) << 8)))) & 100770304);
                    bArr2[28] = ((638444125 & length12) * 2) + ((-638444126) - length12);
                    bArr2[29] = -26;
                    bArr2[30] = -76;
                    bArr2[31] = 30;
                    bArr2[32] = -43;
                    bArr2[33] = -32;
                    bArr2[34] = 44;
                    bArr2[35] = 33;
                    bArr2[36] = 8;
                    bArr2[37] = 53;
                    bArr2[38] = -13;
                    bArr2[39] = 5;
                    bArr2[40] = -8;
                    int i8 = ~r.class.getName().length();
                    int i9 = (i8 | 747528020) - ((210132820 | i8) ^ 680134672);
                    int length13 = (r.class.getName().length() & 605552768) | 101716352;
                    bArr2[41] = (-781851081) ^ (((length13 | i9) - ((r.class.getName().length() & (~i9)) & length13)) + ((i9 | r.class.getName().length()) & length13));
                    int i10 = ((~r.class.getName().length()) | 1219469252) & 559452548;
                    int length14 = r.class.getName().length();
                    bArr2[(i10 + (67305994 | (((r.class.getName().length() | 559022088) - (length14 | 559022088)) + (I2.a(r.class, length14) + (r.class.getName().length() & 559022088))))) ^ 626758564] = -37;
                    bArr2[43] = -59;
                    bArr2[44] = 61;
                    bArr2[45] = 32;
                    bArr2[46] = 71;
                    bArr2[47] = 3;
                    bArr2[48] = 38;
                    bArr2[49] = 51;
                    bArr2[50] = 77;
                    int length15 = r.class.getName().length();
                    bArr2[((((-1313495164) | ((length15 - 1) - (length15 * 2))) & 270533264) + ((r.class.getName().length() & 1048596) | 605028364)) ^ 875561647] = -34;
                    bArr2[52] = -107;
                    bArr2[53] = 107;
                    bArr2[54] = 30;
                    bArr2[55] = 34;
                    bArr2[56] = 87;
                    bArr2[57] = -56;
                    bArr2[58] = 31;
                    bArr2[59] = -92;
                    bArr2[60] = 30;
                    bArr2[61] = 121;
                    long j127 = -329206542;
                    long j128 = ~r.class.getName().length();
                    long b5 = c3.b((((((((j127 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j127 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j127 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j127 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)), ((((((((j128 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j128 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j128 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j128 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j129 = (b5 >>> 48) & 43690;
                    long j130 = ((j129 >>> 2) | (j129 >>> 1)) & 858993459;
                    long j131 = (j130 | (j130 >>> 2)) & 252645135;
                    long j132 = (b5 >>> 32) & 43690;
                    long j133 = ((j132 >>> 2) | (j132 >>> 1)) & 858993459;
                    long j134 = (j133 | (j133 >>> 2)) & 252645135;
                    long j135 = (((j131 | (j131 >>> 4)) & 16711935) << 24) | (((j134 | (j134 >>> 4)) & 16711935) << 16);
                    long j136 = (b5 >>> 16) & 43690;
                    long j137 = ((j136 >>> 2) | (j136 >>> 1)) & 858993459;
                    long j138 = (j137 | (j137 >>> 2)) & 252645135;
                    long j139 = b5 & 43690;
                    long j140 = ((j139 >>> 2) | (j139 >>> 1)) & 858993459;
                    long j141 = (j140 | (j140 >>> 2)) & 252645135;
                    int i11 = (int) (((j141 | (j141 >>> 4)) & 16711935) | ((((j138 | (j138 >>> 4)) & 16711935) << 8) + j135));
                    long j142 = 88141862;
                    long j143 = i11;
                    long j144 = (((((((((j142 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j142 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j142 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j142 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j143 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j143 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j143 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j143 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16));
                    long j145 = (j144 >>> 48) & 43690;
                    long j146 = ((j145 >>> 2) | (j145 >>> 1)) & 858993459;
                    long j147 = (j146 | (j146 >>> 2)) & 252645135;
                    long j148 = (j144 >>> 32) & 43690;
                    long j149 = ((j148 >>> 2) | (j148 >>> 1)) & 858993459;
                    long j150 = (j149 | (j149 >>> 2)) & 252645135;
                    long j151 = (((j150 | (j150 >>> 4)) & 16711935) << 16) + (((j147 | (j147 >>> 4)) & 16711935) << 24);
                    long j152 = (j144 >>> 16) & 43690;
                    long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
                    long j154 = (j153 | (j153 >>> 2)) & 252645135;
                    long j155 = j144 & 43690;
                    long j156 = ((j155 >>> 2) | (j155 >>> 1)) & 858993459;
                    long j157 = (j156 | (j156 >>> 2)) & 252645135;
                    int i12 = (int) (((j157 | (j157 >>> 4)) & 16711935) + ((((j154 | (j154 >>> 4)) & 16711935) << 8) | j151));
                    int length16 = (r.class.getName().length() & 822362373) | 1879834881;
                    int i13 = (((i12 & length16) * 2) + (length16 ^ i12)) ^ 1967976729;
                    int i14 = ((~r.class.getName().length()) | 465150554) & (-632812150);
                    long j158 = 553910341;
                    long length17 = r.class.getName().length() & (-515895868);
                    long b6 = c3.b((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16), ((((((((length17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j159 = (b6 >>> 48) & 43690;
                    long j160 = ((j159 >>> 2) | (j159 >>> 1)) & 858993459;
                    long j161 = (j160 | (j160 >>> 2)) & 252645135;
                    long j162 = (b6 >>> 32) & 43690;
                    long j163 = ((j162 >>> 2) | (j162 >>> 1)) & 858993459;
                    long j164 = (j163 | (j163 >>> 2)) & 252645135;
                    long j165 = (((j164 | (j164 >>> 4)) & 16711935) << 16) + (((j161 | (j161 >>> 4)) & 16711935) << 24);
                    long j166 = (b6 >>> 16) & 43690;
                    long j167 = ((j166 >>> 2) | (j166 >>> 1)) & 858993459;
                    long j168 = (j167 | (j167 >>> 2)) & 252645135;
                    long j169 = b6 & 43690;
                    long j170 = ((j169 >>> 2) | (j169 >>> 1)) & 858993459;
                    long j171 = (j170 | (j170 >>> 2)) & 252645135;
                    bArr2[i13] = (-78901859) ^ (i14 + ((int) (((j171 | (j171 >>> 4)) & 16711935) | ((((j168 | (j168 >>> 4)) & 16711935) << 8) + j165))));
                    bArr2[63] = -105;
                    bArr2[64] = 50;
                    bArr2[65] = -63;
                    bArr2[66] = 27;
                    bArr2[67] = -51;
                    bArr2[68] = 51;
                    bArr2[69] = 77;
                    bArr2[70] = -12;
                    bArr2[71] = -38;
                    bArr2[72] = -127;
                    bArr2[73] = -40;
                    bArr2[74] = 57;
                    bArr2[75] = 10;
                    j(bArr, bArr2);
                    throw new IllegalArgumentException(new String(bArr, StandardCharsets.UTF_8).intern());
                }
                if (c4 != 20603) {
                    break;
                }
                c0378a = c0084t0.k();
                c4 = c0378a == null ? (char) 57178 : (char) 2048;
            }
            AbstractC0416w[] abstractC0416wArr = new AbstractC0416w[38];
            abstractC0416wArr[0] = c0378a.v();
            abstractC0416wArr[1] = c0378a.w();
            abstractC0416wArr[2] = c0378a.I();
            abstractC0416wArr[3] = c0378a.H();
            abstractC0416wArr[4] = c0378a.x();
            abstractC0416wArr[5] = c0378a.D();
            abstractC0416wArr[6] = c0378a.t();
            abstractC0416wArr[7] = c0378a.g();
            abstractC0416wArr[8] = c0378a.s();
            abstractC0416wArr[9] = c0378a.a();
            long j172 = 1610613056;
            long j173 = (~r.class.getName().length()) | (-834047503);
            long j174 = (((((((((j172 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j172 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j172 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j172 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + ((((((((j173 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j173 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j173 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j173 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
            long j175 = (j174 >>> 48) & 43690;
            long j176 = ((j175 >>> 2) | (j175 >>> 1)) & 858993459;
            long j177 = (j176 | (j176 >>> 2)) & 252645135;
            long j178 = (j174 >>> 32) & 43690;
            long j179 = ((j178 >>> 2) | (j178 >>> 1)) & 858993459;
            long j180 = (j179 | (j179 >>> 2)) & 252645135;
            long j181 = (((j177 | (j177 >>> 4)) & 16711935) << 24) | (((j180 | (j180 >>> 4)) & 16711935) << 16);
            long j182 = (j174 >>> 16) & 43690;
            long j183 = ((j182 >>> 2) | (j182 >>> 1)) & 858993459;
            long j184 = (j183 | (j183 >>> 2)) & 252645135;
            long j185 = j174 & 43690;
            long j186 = ((j185 >>> 2) | (j185 >>> 1)) & 858993459;
            long j187 = (j186 | (j186 >>> 2)) & 252645135;
            abstractC0416wArr[(((int) (((j187 | (j187 >>> 4)) & 16711935) + (j181 | (((j184 | (j184 >>> 4)) & 16711935) << 8)))) + ((r.class.getName().length() & 536870945) | 268435491)) ^ 1879048553] = c0378a.j();
            abstractC0416wArr[11] = c0378a.h();
            abstractC0416wArr[12] = c0378a.e();
            abstractC0416wArr[13] = c0378a.B();
            abstractC0416wArr[14] = c0378a.u();
            abstractC0416wArr[15] = c0378a.o();
            abstractC0416wArr[16] = c0378a.C();
            abstractC0416wArr[17] = c0378a.i();
            abstractC0416wArr[18] = c0378a.c();
            abstractC0416wArr[19] = c0378a.n();
            abstractC0416wArr[20] = c0378a.K();
            abstractC0416wArr[21] = c0378a.L();
            abstractC0416wArr[22] = c0378a.b();
            abstractC0416wArr[23] = c0378a.l();
            abstractC0416wArr[24] = c0378a.J();
            abstractC0416wArr[25] = c0378a.d();
            abstractC0416wArr[26] = c0378a.k();
            abstractC0416wArr[((((~r.class.getName().length()) | (-313416817)) & (-1522464760)) + ((r.class.getName().length() & 35888) | 2131506)) ^ (-1520333279)] = c0378a.p();
            abstractC0416wArr[28] = c0378a.r();
            abstractC0416wArr[29] = c0378a.A();
            abstractC0416wArr[30] = c0378a.F();
            abstractC0416wArr[31] = c0378a.M();
            abstractC0416wArr[32] = c0378a.q();
            abstractC0416wArr[33] = c0378a.z();
            abstractC0416wArr[34] = c0378a.f();
            abstractC0416wArr[35] = c0378a.y();
            abstractC0416wArr[36] = c0378a.G();
            abstractC0416wArr[37] = c0378a.m();
            ArrayList V2 = AbstractC0708j.V(abstractC0416wArr);
            V2.add(c0378a.E());
            this.f618b = C0084t0.j(c0084t0, V2);
            return;
        }
    }

    public final String i() {
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (true) {
            char c4 = 59836;
            while (c4 != 23055) {
                if (c4 != 59836) {
                    if (c4 != 61934) {
                        break;
                    }
                    byte[] bArr = new byte[6];
                    bArr[0] = 124;
                    bArr[1] = -121;
                    bArr[2] = 41;
                    bArr[3] = -45;
                    bArr[4] = -46;
                    int length = ((((~r.class.getName().length()) | (-225549633)) & (-2121087858)) + ((r.class.getName().length() & 1762694400) | 2082476320)) ^ (-38611541);
                    int i = ~r.class.getName().length();
                    int length2 = ((((r.class.getName().length() & (~i)) & (-1381440705)) - 1381440705) + i) - ((i | r.class.getName().length()) & (-1381440705));
                    int length3 = (r.class.getName().length() & (-2140764160)) | (-2145220524);
                    int i3 = -((length2 + 13386275) - (13386275 | length2));
                    bArr[length] = 2131834290 ^ ((length3 ^ i3) - (((~length3) & i3) * 2));
                    g(bArr, new byte[]{41, -72, 26, -98, -96, -88, -53, -23});
                    str5 = new String(bArr, StandardCharsets.UTF_8).intern();
                } else {
                    str4 = Build.BOARD;
                    str = Build.BRAND;
                    str2 = Build.MODEL;
                    str3 = Build.DEVICE;
                    str5 = a();
                    if (str5 == null) {
                        c4 = 61934;
                    }
                }
                c4 = 23055;
            }
            byte[] bArr2 = {49};
            int i4 = ((~r.class.getName().length()) | (-1261847001)) & 4931813;
            int length4 = (r.class.getName().length() & 1084375242) | 1151337482;
            int i5 = -i4;
            byte[] bArr3 = new byte[1156269287 ^ (((~i5) & length4) - ((~length4) & i5))];
            bArr3[0] = 77;
            bArr3[1] = 44;
            bArr3[2] = -39;
            bArr3[3] = 7;
            bArr3[4] = 84;
            bArr3[5] = 115;
            bArr3[6] = 92;
            bArr3[7] = -51;
            g(bArr2, bArr3);
            Charset charset = StandardCharsets.UTF_8;
            String intern = new String(bArr2, charset).intern();
            byte[] bArr4 = {109};
            byte[] bArr5 = new byte[8];
            bArr5[0] = 17;
            int i6 = ((-505086107) - ((~(~r.class.getName().length())) | (-505086106))) & 1779001984;
            int length5 = (r.class.getName().length() & 436797894) | 268439886;
            int i7 = -i6;
            bArr5[1] = 2047441872 ^ (((~i7) & length5) - (i7 & (~length5)));
            bArr5[2] = -119;
            bArr5[3] = -31;
            bArr5[4] = -74;
            int i8 = ~r.class.getName().length();
            bArr5[1972467595 ^ (((((-244806878) | i8) + 1964073346) - (i8 | (-176559198))) + ((r.class.getName().length() & 68247692) | 8394252))] = 94;
            long j2 = 2082758959;
            long j3 = ~r.class.getName().length();
            long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
            long j5 = (j4 >>> 48) & 43690;
            long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
            long j7 = ((j6 >>> 2) | j6) & 252645135;
            long j8 = (j4 >>> 32) & 43690;
            long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
            long j10 = ((j9 >>> 2) | j9) & 252645135;
            long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
            long j12 = (j4 >>> 16) & 43690;
            long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
            long j14 = ((j13 >>> 2) | j13) & 252645135;
            long j15 = j4 & 43690;
            long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
            long j17 = ((j16 >>> 2) | j16) & 252645135;
            bArr5[(((((int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) | (-1636057349)) - (-1636057349)) + ((r.class.getName().length() & 25166560) | 33506)) ^ 1636090848] = ((((~r.class.getName().length()) | (-2141203797)) & 158144805) + ((r.class.getName().length() & (-1993306810)) | (-1609530286))) ^ (-1451385488);
            bArr5[7] = 84;
            g(bArr4, bArr5);
            String intern2 = new String(bArr4, charset).intern();
            int i9 = ~r.class.getName().length();
            int i10 = (((i9 ^ 1399849713) + (i9 & 1399849713)) | (-1569721417)) - (-1569721417);
            int length6 = (r.class.getName().length() & 209718284) | 537559044;
            byte[] bArr6 = {2107280476 ^ ((length6 & i10) + (length6 | i10))};
            g(bArr6, new byte[]{108, -119, -45, 87, -63, -114, -88, -70});
            String intern3 = new String(bArr6, charset).intern();
            byte[] bArr7 = {-58};
            int length7 = r.class.getName().length();
            int i11 = ((-536936449) | (((~length7) - length7) + length7)) + 872495369;
            int length8 = r.class.getName().length();
            g(bArr7, new byte[]{-103, 70, 11, -50, -96, (i11 + ((-1966865404) | (((r.class.getName().length() | 574947328) - (length8 | 574947328)) + (AbstractC0008a.f(r.class, length8) + (r.class.getName().length() & 574947328))))) ^ 1094369991, 37, -2});
            return str + intern + str2 + intern2 + str3 + intern3 + str4 + new String(bArr7, charset).intern() + str5;
        }
    }

    public final String toString() {
        int i;
        Class cls;
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[32];
        long j2 = -954279067;
        long a2 = ((I2.a(r.class, -1) | 1398965020) & 404759637) + ((r.class.getName().length() & 138421313) | 549519488);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 21845;
        long j5 = ((j4 >>> 1) | j4) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        bArr[0] = (int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10));
        bArr[1] = -51;
        bArr[2] = 70;
        bArr[3] = -88;
        bArr[4] = -84;
        bArr[5] = 119;
        bArr[6] = -97;
        bArr[7] = -93;
        bArr[8] = -10;
        bArr[9] = 77;
        bArr[10] = 62;
        bArr[11] = 19;
        bArr[12] = -83;
        bArr[13] = 110;
        bArr[14] = 117;
        bArr[15] = 22;
        bArr[16] = 77;
        bArr[17] = -12;
        bArr[18] = -97;
        bArr[19] = 80;
        bArr[20] = 73;
        bArr[21] = 83;
        bArr[22] = 126;
        long j17 = 861548546;
        long j18 = (~r.class.getName().length()) | (-1646694471);
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        bArr[(((int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) + j26))) + ((r.class.getName().length() & 771969190) | 201408676)) ^ 1062957233] = 27;
        bArr[24] = 30;
        bArr[25] = 39;
        bArr[26] = 94;
        bArr[27] = -70;
        bArr[28] = -31;
        bArr[29] = 2;
        bArr[30] = -98;
        bArr[31] = 16;
        byte[] bArr2 = new byte[32];
        long j33 = -1838146828;
        long a4 = I2.a(r.class, -1);
        long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((a4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((a4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((a4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((a4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j35 = (j34 >>> 48) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        long j38 = (j34 >>> 32) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) | ((((j37 >>> 4) | j37) & 16711935) << 24);
        long j42 = (j34 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        int i3 = ((int) ((((j47 >>> 4) | j47) & 16711935) | ((((j44 >>> 4) | j44) & 16711935) << 8) | j41)) & 1879059400;
        int length = (r.class.getName().length() & 1614819592) | 71472128;
        int i4 = -i3;
        bArr2[0] = (-1950531494) ^ ((((~i4) & length) * 2) - (i4 ^ length));
        bArr2[1] = -87;
        int i5 = ((~r.class.getName().length()) | (-1701676944)) & (-697645024);
        long j48 = 1114446;
        long length2 = r.class.getName().length() & 1148813568;
        long b4 = c3.b((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j49 = (b4 >>> 48) & 43690;
        long j50 = ((j49 >>> 2) | (j49 >>> 1)) & 858993459;
        long j51 = ((j50 >>> 2) | j50) & 252645135;
        long j52 = (b4 >>> 32) & 43690;
        long j53 = ((j52 >>> 2) | (j52 >>> 1)) & 858993459;
        long j54 = ((j53 >>> 2) | j53) & 252645135;
        long j55 = ((((j54 >>> 4) | j54) & 16711935) << 16) | ((((j51 >>> 4) | j51) & 16711935) << 24);
        long j56 = (b4 >>> 16) & 43690;
        long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
        long j58 = ((j57 >>> 2) | j57) & 252645135;
        long j59 = b4 & 43690;
        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
        long j61 = ((j60 >>> 2) | j60) & 252645135;
        int i6 = i5 + ((int) ((((j61 >>> 4) | j61) & 16711935) | ((((j58 >>> 4) | j58) & 16711935) << 8) | j55));
        bArr2[((i6 & 696530579) * 2) + ((-696530580) - i6)] = 35;
        bArr2[3] = -34;
        int i7 = ~r.class.getName().length();
        bArr2[((((i7 + (((-i7) - 1) | (-1837249355))) + 1837249355) & 671308165) + ((r.class.getName().length() & 272976005) | 1380712448)) ^ 2052020609] = -59;
        bArr2[5] = 20;
        bArr2[6] = -6;
        int i8 = ~r.class.getName().length();
        int i9 = ((~i8) & (-148904887)) + i8;
        bArr2[7] = (((219511056 + i9) - (i9 | 219511056)) + ((r.class.getName().length() & 671127952) | 543326340)) ^ (-762837378);
        bArr2[8] = -110;
        int i10 = ((~r.class.getName().length()) | (-1082176609)) & 1091698792;
        int length3 = (r.class.getName().length() & 1107298402) | 301991942;
        bArr2[1393690727 ^ (((length3 | i10) * 2) - (i10 ^ length3))] = 111;
        bArr2[10] = 4;
        bArr2[11] = 104;
        bArr2[12] = -89;
        bArr2[13] = 78;
        bArr2[14] = 85;
        bArr2[15] = 54;
        bArr2[16] = 109;
        bArr2[17] = -44;
        bArr2[18] = -65;
        bArr2[19] = 114;
        bArr2[20] = 40;
        int i11 = ((~r.class.getName().length()) | (-772273907)) & (-1050132478);
        int length4 = r.class.getName().length();
        bArr2[(i11 + (68452497 | (((r.class.getName().length() | 1327106) - (length4 | 1327106)) + (I2.a(r.class, length4) + (r.class.getName().length() & 1327106))))) ^ (-981679994)] = 61;
        bArr2[22] = 26;
        bArr2[23] = 105;
        bArr2[24] = 113;
        bArr2[25] = 78;
        long j62 = -1099673178;
        long j63 = ~r.class.getName().length();
        long j64 = (((((((((j62 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j62 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j62 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j62 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j65 = (j64 >>> 48) & 43690;
        long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
        long j67 = ((j66 >>> 2) | j66) & 252645135;
        long j68 = (j64 >>> 32) & 43690;
        long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
        long j70 = ((j69 >>> 2) | j69) & 252645135;
        long j71 = ((((j70 >>> 4) | j70) & 16711935) << 16) | ((((j67 >>> 4) | j67) & 16711935) << 24);
        long j72 = (j64 >>> 16) & 43690;
        long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
        long j74 = ((j73 >>> 2) | j73) & 252645135;
        long j75 = j64 & 43690;
        long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
        long j77 = ((j76 >>> 2) | j76) & 252645135;
        bArr2[((((int) ((((((j74 >>> 4) | j74) & 16711935) << 8) | j71) | (((j77 >>> 4) | j77) & 16711935))) & 157296228) + ((r.class.getName().length() & 353513280) | 336726272)) ^ 494022526] = 58;
        int i12 = ((~r.class.getName().length()) | 692305797) & 557057157;
        long j78 = 37003328;
        long length5 = r.class.getName().length();
        long j79 = ((((((((j78 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j78 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j78 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j78 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j80 = (j79 >>> 48) & 43690;
        long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
        long j82 = ((j81 >>> 2) | j81) & 252645135;
        long j83 = (j79 >>> 32) & 43690;
        long j84 = ((j83 >>> 2) | (j83 >>> 1)) & 858993459;
        long j85 = ((j84 >>> 2) | j84) & 252645135;
        long j86 = ((((j85 >>> 4) | j85) & 16711935) << 16) + ((((j82 >>> 4) | j82) & 16711935) << 24);
        long j87 = (j79 >>> 16) & 43690;
        long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = j79 & 43690;
        long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
        long j92 = ((j91 >>> 2) | j91) & 252645135;
        bArr2[1735697630 ^ (((((int) ((((((j89 >>> 4) | j89) & 16711935) << 8) | j86) | (((j92 >>> 4) | j92) & 16711935))) | 1178640448) - (~i12)) - 1)] = -13;
        bArr2[28] = -123;
        bArr2[29] = 32;
        bArr2[30] = -92;
        long j93 = -1;
        long length6 = r.class.getName().length();
        long j94 = ((((((((j93 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j93 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j93 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j93 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j95 = (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j94;
        long j96 = (j95 >>> 48) & 21845;
        long j97 = ((j96 >>> 1) | j96) & 858993459;
        long j98 = ((j97 >>> 2) | j97) & 252645135;
        long j99 = (j95 >>> 32) & 21845;
        long j100 = ((j99 >>> 1) | j99) & 858993459;
        long j101 = ((j100 >>> 2) | j100) & 252645135;
        long j102 = ((((j101 >>> 4) | j101) & 16711935) << 16) + ((((j98 >>> 4) | j98) & 16711935) << 24);
        long j103 = (j95 >>> 16) & 21845;
        long j104 = ((j103 >>> 1) | j103) & 858993459;
        long j105 = ((j104 >>> 2) | j104) & 252645135;
        long j106 = j95 & 21845;
        long j107 = ((j106 >>> 1) | j106) & 858993459;
        long j108 = ((j107 >>> 2) | j107) & 252645135;
        int i13 = ((int) ((((j108 >>> 4) | j108) & 16711935) | (((((j105 >>> 4) | j105) & 16711935) << 8) + j102))) | 2039386787;
        long j109 = 807674387;
        long j110 = i13;
        long j111 = ((((((((j109 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j109 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j109 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j109 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j110 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j110 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j110 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j110 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j112 = (j111 >>> 48) & 43690;
        long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
        long j114 = ((j113 >>> 2) | j113) & 252645135;
        long j115 = (j111 >>> 32) & 43690;
        long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
        long j117 = ((j116 >>> 2) | j116) & 252645135;
        long j118 = ((((j117 >>> 4) | j117) & 16711935) << 16) + ((((j114 >>> 4) | j114) & 16711935) << 24);
        long j119 = (j111 >>> 16) & 43690;
        long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
        long j121 = ((j120 >>> 2) | j120) & 252645135;
        long j122 = j111 & 43690;
        long j123 = ((j122 >>> 2) | (j122 >>> 1)) & 858993459;
        long j124 = ((j123 >>> 2) | j123) & 252645135;
        int i14 = (int) (((((j121 >>> 4) | j121) & 16711935) << 8) | j118 | (((j124 >>> 4) | j124) & 16711935));
        int length7 = r.class.getName().length();
        bArr2[31] = (i14 + (1216351520 | (((r.class.getName().length() | 1084238864) - (length7 | 1084238864)) + (I2.a(r.class, length7) + (r.class.getName().length() & 1084238864))))) ^ 2024025857;
        h(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        sb.append(new String(bArr, charset).intern());
        String e4 = e();
        if (e4 == null) {
            byte[] bArr3 = new byte[1];
            bArr3[((((~r.class.getName().length()) | (-187038620)) & (-2078789053)) + ((r.class.getName().length() & 1073771019) | 1073891336)) ^ (-1004897717)] = -87;
            long j125 = 1728976113;
            i = 13;
            long j126 = ~r.class.getName().length();
            long j127 = (((((((((j125 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j125 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j125 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j125 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j126 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j126 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j126 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j126 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
            long j128 = (j127 >>> 48) & 43690;
            long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
            long j130 = ((j129 >>> 2) | j129) & 252645135;
            long j131 = (j127 >>> 32) & 43690;
            long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
            long j133 = ((j132 >>> 2) | j132) & 252645135;
            long j134 = ((((j133 >>> 4) | j133) & 16711935) << 16) + ((((j130 >>> 4) | j130) & 16711935) << 24);
            long j135 = (j127 >>> 16) & 43690;
            long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
            long j137 = ((j136 >>> 2) | j136) & 252645135;
            long j138 = j127 & 43690;
            long j139 = ((j138 >>> 2) | (j138 >>> 1)) & 858993459;
            long j140 = ((j139 >>> 2) | j139) & 252645135;
            h(bArr3, new byte[]{-124, -45, 70, -127, 66, -74, ((((int) ((((((j137 >>> 4) | j137) & 16711935) << 8) | j134) | (((j140 >>> 4) | j140) & 16711935))) & 691144193) + ((r.class.getName().length() & 472908418) | (-1811414910))) ^ 1120270653, 45});
            e4 = new String(bArr3, charset).intern();
        } else {
            i = 13;
        }
        sb.append(e4);
        byte[] bArr4 = new byte[21];
        bArr4[0] = 99;
        bArr4[1] = -24;
        bArr4[2] = ((((~r.class.getName().length()) | 1992365691) & (-1688200798)) + ((r.class.getName().length() & (-1457518207)) | 1611702273)) ^ (-76498435);
        bArr4[3] = 6;
        bArr4[4] = 17;
        int i15 = ~r.class.getName().length();
        bArr4[(((~(((r.class.getName().length() | 175616111) | i15) - (i15 | (r.class.getName().length() & (-175616112))))) & (-1744285694)) + ((r.class.getName().length() & 138424322) | 641736704)) ^ (-1102548985)] = -41;
        bArr4[6] = -11;
        bArr4[7] = 14;
        bArr4[8] = 51;
        bArr4[9] = -103;
        bArr4[10] = 58;
        bArr4[11] = -105;
        bArr4[12] = -1;
        bArr4[i] = 88;
        int i16 = ((~r.class.getName().length()) | (-1373175942)) & 206571072;
        int length8 = (r.class.getName().length() & 5242883) | 1074397187;
        int i17 = -i16;
        bArr4[14] = 1280968202 ^ ((((~i17) & length8) * 2) - (i17 ^ length8));
        bArr4[15] = 17;
        bArr4[16] = 112;
        bArr4[17] = 17;
        bArr4[18] = 117;
        bArr4[19] = -19;
        bArr4[20] = -17;
        int i18 = ((~r.class.getName().length()) | 1910492234) & (-1874573199);
        long j141 = -2145386189;
        long length9 = r.class.getName().length();
        long j142 = ((((((((j141 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j141 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j141 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j141 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j143 = (j142 >>> 48) & 43690;
        long j144 = ((j143 >>> 2) | (j143 >>> 1)) & 858993459;
        long j145 = ((j144 >>> 2) | j144) & 252645135;
        long j146 = (j142 >>> 32) & 43690;
        long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
        long j148 = ((j147 >>> 2) | j147) & 252645135;
        long j149 = ((((j148 >>> 4) | j148) & 16711935) << 16) | ((((j145 >>> 4) | j145) & 16711935) << 24);
        long j150 = (j142 >>> 16) & 43690;
        long j151 = ((j150 >>> 2) | (j150 >>> 1)) & 858993459;
        long j152 = ((j151 >>> 2) | j151) & 252645135;
        long j153 = ((((j152 >>> 4) | j152) & 16711935) << 8) + j149;
        long j154 = j142 & 43690;
        long j155 = ((j154 >>> 2) | (j154 >>> 1)) & 858993459;
        long j156 = (j155 | (j155 >>> 2)) & 252645135;
        int i19 = i18 + (((int) (((j156 | (j156 >>> 4)) & 16711935) | j153)) | 1109426434);
        byte b5 = (((~i19) & (-765146830)) - ((-765146830) & i19)) + i19;
        byte length10 = ((((~r.class.getName().length()) | (-1400608705)) & 220482061) + ((r.class.getName().length() & (-2127522112)) | (-2108648256))) ^ (-1888166247);
        long j157 = 2042018476;
        long j158 = ~r.class.getName().length();
        long j159 = (((((((((j157 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j157 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j157 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j157 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j160 = (j159 >>> 48) & 43690;
        long j161 = ((j160 >>> 2) | (j160 >>> 1)) & 858993459;
        long j162 = ((j161 >>> 2) | j161) & 252645135;
        long j163 = (j159 >>> 32) & 43690;
        long j164 = ((j163 >>> 2) | (j163 >>> 1)) & 858993459;
        long j165 = ((j164 >>> 2) | j164) & 252645135;
        long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) | ((((j162 >>> 4) | j162) & 16711935) << 24);
        long j167 = (j159 >>> 16) & 43690;
        long j168 = ((j167 >>> 2) | (j167 >>> 1)) & 858993459;
        long j169 = ((j168 >>> 2) | j168) & 252645135;
        long j170 = ((((j169 >>> 4) | j169) & 16711935) << 8) + j166;
        long j171 = j159 & 43690;
        long j172 = ((j171 >>> 2) | (j171 >>> 1)) & 858993459;
        long j173 = (j172 | (j172 >>> 2)) & 252645135;
        int length11 = r.class.getName().length() & 301991489;
        byte a5 = S.a(length11, ((-length11) - 1) | (-302009874), 302009874, ((int) (((j173 | (j173 >>> 4)) & 16711935) | j170)) & 1208254668) ^ 1510264458;
        byte[] bArr5 = new byte[21];
        bArr5[0] = b5;
        bArr5[1] = -60;
        bArr5[2] = length10;
        bArr5[3] = 38;
        bArr5[4] = 49;
        bArr5[5] = -9;
        bArr5[6] = -43;
        bArr5[7] = 46;
        bArr5[8] = 19;
        bArr5[9] = -69;
        bArr5[10] = 87;
        bArr5[11] = -14;
        bArr5[12] = -101;
        bArr5[i] = 49;
        bArr5[14] = 40;
        bArr5[15] = 85;
        bArr5[16] = 2;
        bArr5[17] = 124;
        bArr5[18] = a5;
        bArr5[19] = -41;
        bArr5[20] = -51;
        h(bArr4, bArr5);
        sb.append(new String(bArr4, charset).intern());
        String a6 = a();
        if (a6 == null) {
            byte[] bArr6 = new byte[1];
            int i20 = ((~r.class.getName().length()) | (-149227882)) & (-1204680704);
            long j174 = 161515520;
            long length12 = r.class.getName().length();
            long j175 = ((((((((j174 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j174 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j174 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j174 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length12 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length12 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length12 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length12 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j176 = (j175 >>> 48) & 43690;
            long j177 = ((j176 >>> 2) | (j176 >>> 1)) & 858993459;
            long j178 = (j177 | (j177 >>> 2)) & 252645135;
            long j179 = (j175 >>> 32) & 43690;
            long j180 = ((j179 >>> 2) | (j179 >>> 1)) & 858993459;
            long j181 = ((j180 >>> 2) | j180) & 252645135;
            long j182 = ((((j181 >>> 4) | j181) & 16711935) << 16) + (((j178 | (j178 >>> 4)) & 16711935) << 24);
            long j183 = (j175 >>> 16) & 43690;
            long j184 = ((j183 >>> 2) | (j183 >>> 1)) & 858993459;
            long j185 = ((j184 >>> 2) | j184) & 252645135;
            long j186 = j175 & 43690;
            long j187 = ((j186 >>> 2) | (j186 >>> 1)) & 858993459;
            long j188 = (j187 | (j187 >>> 2)) & 252645135;
            int i21 = ((int) ((((((j185 >>> 4) | j185) & 16711935) << 8) + j182) | ((j188 | (j188 >>> 4)) & 16711935))) | 29392960;
            int i22 = ((i20 & i21) * 2) + (i21 ^ i20);
            long j189 = -1175287744;
            long j190 = i22;
            long j191 = (((((((((j189 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j189 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j189 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j189 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j190 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j190 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j190 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j190 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j192 = (j191 >>> 48) & 21845;
            long j193 = (j192 | (j192 >>> 1)) & 858993459;
            long j194 = (j193 | (j193 >>> 2)) & 252645135;
            long j195 = (j191 >>> 32) & 21845;
            long j196 = ((j195 >>> 1) | j195) & 858993459;
            long j197 = ((j196 >>> 2) | j196) & 252645135;
            long j198 = (((j194 | (j194 >>> 4)) & 16711935) << 24) | ((((j197 >>> 4) | j197) & 16711935) << 16);
            long j199 = (j191 >>> 16) & 21845;
            long j200 = ((j199 >>> 1) | j199) & 858993459;
            long j201 = ((j200 >>> 2) | j200) & 252645135;
            long j202 = j191 & 21845;
            long j203 = (j202 | (j202 >>> 1)) & 858993459;
            long j204 = (j203 | (j203 >>> 2)) & 252645135;
            bArr6[(int) (((j204 | (j204 >>> 4)) & 16711935) + ((((j201 >>> 4) | j201) & 16711935) << 8) + j198)] = -93;
            int length13 = r.class.getName().length();
            int i23 = ((~length13) - length13) + length13;
            byte[] bArr7 = new byte[(((((-1717847469) + i23) + (((-i23) - 1) | 1717847469)) & 285683202) + ((r.class.getName().length() & 38011908) | 40910997)) ^ 326594207];
            int i24 = ((~r.class.getName().length()) | (-350956587)) & (-937637472);
            int length14 = r.class.getName().length();
            cls = r.class;
            int length15 = 931274760 | (((cls.getName().length() | 378144800) - (length14 | 378144800)) + I2.a(cls, length14) + (cls.getName().length() & 378144800));
            int i25 = ((i24 & length15) * 2) + (length15 ^ i24);
            bArr7[0] = B0.a((~i25) | 6362662, 6362662 - i25);
            bArr7[1] = 63;
            bArr7[2] = 66;
            bArr7[3] = 115;
            bArr7[4] = 118;
            bArr7[5] = -10;
            bArr7[6] = 87;
            bArr7[7] = 105;
            h(bArr6, bArr7);
            a6 = new String(bArr6, charset).intern();
        } else {
            cls = r.class;
        }
        sb.append(a6);
        long j205 = 1296331809;
        long j206 = (~cls.getName().length()) | (-1627783189);
        long j207 = ((((((((j205 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j205 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j205 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j205 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j206 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j206 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j206 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j206 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j208 = (j207 >>> 48) & 43690;
        long j209 = ((j208 >>> 2) | (j208 >>> 1)) & 858993459;
        long j210 = (j209 | (j209 >>> 2)) & 252645135;
        long j211 = (j207 >>> 32) & 43690;
        long j212 = ((j211 >>> 2) | (j211 >>> 1)) & 858993459;
        long j213 = ((j212 >>> 2) | j212) & 252645135;
        long j214 = (((j210 | (j210 >>> 4)) & 16711935) << 24) | ((((j213 >>> 4) | j213) & 16711935) << 16);
        long j215 = (j207 >>> 16) & 43690;
        long j216 = ((j215 >>> 2) | (j215 >>> 1)) & 858993459;
        long j217 = ((j216 >>> 2) | j216) & 252645135;
        long j218 = j207 & 43690;
        long j219 = ((j218 >>> 2) | (j218 >>> 1)) & 858993459;
        long j220 = (j219 | (j219 >>> 2)) & 252645135;
        byte[] bArr8 = new byte[(((int) (((j220 | (j220 >>> 4)) & 16711935) | (j214 | ((((j217 >>> 4) | j217) & 16711935) << 8)))) + ((cls.getName().length() & 1124403400) | (-2113828662))) ^ (-817496847)];
        bArr8[0] = 105;
        bArr8[1] = -71;
        bArr8[2] = 126;
        bArr8[3] = -42;
        int i26 = 537232251 & ((-1499500501) - ((~(~cls.getName().length())) | (-1499500500)));
        long j221 = 169907027;
        long length16 = cls.getName().length();
        long j222 = (((((((((j221 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j221 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j221 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j221 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j223 = (j222 >>> 48) & 43690;
        long j224 = ((j223 >>> 2) | (j223 >>> 1)) & 858993459;
        long j225 = ((j224 >>> 2) | j224) & 252645135;
        long j226 = (j222 >>> 32) & 43690;
        long j227 = ((j226 >>> 2) | (j226 >>> 1)) & 858993459;
        long j228 = ((j227 >>> 2) | j227) & 252645135;
        long j229 = ((((j228 >>> 4) | j228) & 16711935) << 16) + ((((j225 >>> 4) | j225) & 16711935) << 24);
        long j230 = (j222 >>> 16) & 43690;
        long j231 = ((j230 >>> 2) | (j230 >>> 1)) & 858993459;
        long j232 = ((j231 >>> 2) | j231) & 252645135;
        long j233 = j222 & 43690;
        long j234 = ((j233 >>> 2) | (j233 >>> 1)) & 858993459;
        long j235 = ((j234 >>> 2) | j234) & 252645135;
        int i27 = i26 + (((int) ((((j235 >>> 4) | j235) & 16711935) + ((((j232 >>> 4) | j232) & 16711935) << 8) + j229)) | 178262020);
        bArr8[4] = B0.a((~i27) | 715494186, 715494186 - i27);
        bArr8[5] = -72;
        bArr8[6] = 20;
        bArr8[7] = 106;
        bArr8[8] = -44;
        bArr8[9] = -14;
        bArr8[10] = -57;
        bArr8[11] = -81;
        bArr8[12] = 66;
        bArr8[i] = 42;
        bArr8[14] = 109;
        long length17 = cls.getName().length();
        long j236 = j94 + (((((((((length17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j237 = (j236 >>> 48) & 21845;
        long j238 = (j237 | (j237 >>> 1)) & 858993459;
        long j239 = (j238 | (j238 >>> 2)) & 252645135;
        long j240 = (j236 >>> 32) & 21845;
        long j241 = ((j240 >>> 1) | j240) & 858993459;
        long j242 = ((j241 >>> 2) | j241) & 252645135;
        long j243 = (((j239 | (j239 >>> 4)) & 16711935) << 24) | ((((j242 >>> 4) | j242) & 16711935) << 16);
        long j244 = (j236 >>> 16) & 21845;
        long j245 = ((j244 >>> 1) | j244) & 858993459;
        long j246 = ((j245 >>> 2) | j245) & 252645135;
        long j247 = ((((j246 >>> 4) | j246) & 16711935) << 8) + j243;
        long j248 = j236 & 21845;
        long j249 = (j248 | (j248 >>> 1)) & 858993459;
        long j250 = (j249 | (j249 >>> 2)) & 252645135;
        int length18 = ((((int) (((j250 | (j250 >>> 4)) & 16711935) + j247)) | 416242425) & (-790020096)) + ((cls.getName().length() & (-1071382496)) | 33952096);
        bArr8[((-756067985) + length18) - ((length18 & (-756067985)) * 2)] = 34;
        bArr8[16] = -96;
        bArr8[17] = -91;
        bArr8[18] = -2;
        bArr8[19] = -46;
        bArr8[20] = -51;
        bArr8[21] = -58;
        bArr8[22] = 48;
        long j251 = 1973761469;
        long length19 = (((~cls.getName().length()) | 1266302039) & 1157903784) + ((cls.getName().length() & 883229096) | 815857666);
        long j252 = (((((((((j251 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j251 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j251 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j251 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j253 = (j252 >>> 48) & 21845;
        long j254 = (j253 | (j253 >>> 1)) & 858993459;
        long j255 = (j254 | (j254 >>> 2)) & 252645135;
        long j256 = (j252 >>> 32) & 21845;
        long j257 = (j256 | (j256 >>> 1)) & 858993459;
        long j258 = (j257 | (j257 >>> 2)) & 252645135;
        long j259 = (((j258 | (j258 >>> 4)) & 16711935) << 16) + (((j255 | (j255 >>> 4)) & 16711935) << 24);
        long j260 = (j252 >>> 16) & 21845;
        long j261 = (j260 | (j260 >>> 1)) & 858993459;
        long j262 = (j261 | (j261 >>> 2)) & 252645135;
        long j263 = j252 & 21845;
        long j264 = (j263 | (j263 >>> 1)) & 858993459;
        long j265 = (j264 | (j264 >>> 2)) & 252645135;
        bArr8[(int) (((j265 | (j265 >>> 4)) & 16711935) | ((((j262 | (j262 >>> 4)) & 16711935) << 8) + j259))] = -40;
        bArr8[24] = -63;
        bArr8[25] = 66;
        byte[] bArr9 = new byte[26];
        bArr9[0] = 75;
        bArr9[1] = -107;
        bArr9[2] = 116;
        bArr9[3] = -10;
        bArr9[4] = 117;
        bArr9[5] = -104;
        bArr9[6] = 52;
        bArr9[7] = 74;
        bArr9[8] = -12;
        bArr9[9] = -48;
        bArr9[10] = -95;
        bArr9[11] = -58;
        bArr9[12] = 44;
        bArr9[i] = 77;
        bArr9[14] = 8;
        bArr9[15] = 80;
        bArr9[16] = -48;
        bArr9[17] = -41;
        bArr9[18] = -105;
        bArr9[19] = -68;
        bArr9[20] = -71;
        bArr9[21] = -112;
        bArr9[(((1173157412 | I2.a(cls, -1)) & (-771370944)) + ((cls.getName().length() & (-1711210176)) | 134218021)) ^ (-637152909)] = 3;
        bArr9[23] = -6;
        bArr9[24] = -5;
        bArr9[25] = 96;
        h(bArr8, bArr9);
        sb.append(new String(bArr8, charset).intern());
        this.f619c.await();
        String str = this.f618b;
        if (str == null) {
            byte[] bArr10 = {-74};
            byte[] bArr11 = new byte[8];
            int length20 = cls.getName().length();
            int i28 = ((-1263652153) | (((~length20) - length20) + length20)) & (-1331617776);
            int length21 = cls.getName().length();
            int i29 = i28 + (1079508995 | ((1638417 | length21) - (length21 ^ 1638417)));
            long j266 = -252108781;
            long j267 = i29;
            long j268 = (((((((((j266 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j266 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j266 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j266 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j267 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j267 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j267 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j267 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j269 = (j268 >>> 48) & 21845;
            long j270 = (j269 | (j269 >>> 1)) & 858993459;
            long j271 = (j270 | (j270 >>> 2)) & 252645135;
            long j272 = (j268 >>> 32) & 21845;
            long j273 = ((j272 >>> 1) | j272) & 858993459;
            long j274 = ((j273 >>> 2) | j273) & 252645135;
            long j275 = ((((j274 >>> 4) | j274) & 16711935) << 16) + (((j271 | (j271 >>> 4)) & 16711935) << 24);
            long j276 = (j268 >>> 16) & 21845;
            long j277 = ((j276 >>> 1) | j276) & 858993459;
            long j278 = ((j277 >>> 2) | j277) & 252645135;
            long j279 = j268 & 21845;
            long j280 = (j279 | (j279 >>> 1)) & 858993459;
            long j281 = (j280 | (j280 >>> 2)) & 252645135;
            bArr11[(int) (((j281 | (j281 >>> 4)) & 16711935) | (((((j278 >>> 4) | j278) & 16711935) << 8) + j275))] = -101;
            long j282 = -463119802;
            long j283 = ~cls.getName().length();
            long b6 = c3.b((((((((j282 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j282 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j282 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j282 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j283 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j283 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j283 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j283 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
            long j284 = (b6 >>> 48) & 43690;
            long j285 = ((j284 >>> 2) | (j284 >>> 1)) & 858993459;
            long j286 = (j285 | (j285 >>> 2)) & 252645135;
            long j287 = (b6 >>> 32) & 43690;
            long j288 = ((j287 >>> 2) | (j287 >>> 1)) & 858993459;
            long j289 = ((j288 >>> 2) | j288) & 252645135;
            long j290 = (((j286 | (j286 >>> 4)) & 16711935) << 24) | ((((j289 >>> 4) | j289) & 16711935) << 16);
            long j291 = (b6 >>> 16) & 43690;
            long j292 = ((j291 >>> 2) | (j291 >>> 1)) & 858993459;
            long j293 = ((j292 >>> 2) | j292) & 252645135;
            long j294 = b6 & 43690;
            long j295 = ((j294 >>> 2) | (j294 >>> 1)) & 858993459;
            long j296 = (j295 | (j295 >>> 2)) & 252645135;
            int i30 = ((int) (((j296 | (j296 >>> 4)) & 16711935) | (((((j293 >>> 4) | j293) & 16711935) << 8) + j290))) & (-2147352032);
            int length22 = (cls.getName().length() & 1610743840) | 1610874880;
            bArr11[(-536477151) ^ (((length22 | i30) * 2) - (i30 ^ length22))] = -2;
            int a7 = (2076096748 | I2.a(cls, -1)) & 562036898;
            long j297 = 71565322;
            long length23 = cls.getName().length();
            long j298 = ((((((((j297 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j297 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j297 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j297 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j299 = (j298 >>> 48) & 43690;
            long j300 = ((j299 >>> 2) | (j299 >>> 1)) & 858993459;
            long j301 = (j300 | (j300 >>> 2)) & 252645135;
            long j302 = (j298 >>> 32) & 43690;
            long j303 = ((j302 >>> 2) | (j302 >>> 1)) & 858993459;
            long j304 = ((j303 >>> 2) | j303) & 252645135;
            long j305 = ((((j304 >>> 4) | j304) & 16711935) << 16) + (((j301 | (j301 >>> 4)) & 16711935) << 24);
            long j306 = (j298 >>> 16) & 43690;
            long j307 = ((j306 >>> 2) | (j306 >>> 1)) & 858993459;
            long j308 = ((j307 >>> 2) | j307) & 252645135;
            long j309 = j298 & 43690;
            long j310 = ((j309 >>> 2) | (j309 >>> 1)) & 858993459;
            long j311 = (j310 | (j310 >>> 2)) & 252645135;
            int i31 = ((int) (((j311 | (j311 >>> 4)) & 16711935) | ((((j308 >>> 4) | j308) & 16711935) << 8) | j305)) | 71598104;
            bArr11[2] = (((a7 & i31) * 2) + (i31 ^ a7)) ^ (-633635001);
            bArr11[3] = 52;
            bArr11[4] = 57;
            bArr11[5] = 2;
            bArr11[6] = 17;
            bArr11[7] = 57;
            h(bArr10, bArr11);
            str = new String(bArr10, charset).intern();
        }
        sb.append(str);
        byte[] bArr12 = {0, -88};
        byte[] bArr13 = new byte[8];
        bArr13[0] = 34;
        bArr13[1] = -94;
        bArr13[2] = 68;
        bArr13[3] = -78;
        long j312 = 1629136763;
        long j313 = ~cls.getName().length();
        long j314 = (((((((((j312 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j312 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j312 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j312 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j313 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j313 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j313 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j313 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
        long j315 = (j314 >>> 48) & 43690;
        long j316 = ((j315 >>> 2) | (j315 >>> 1)) & 858993459;
        long j317 = (j316 | (j316 >>> 2)) & 252645135;
        long j318 = (j314 >>> 32) & 43690;
        long j319 = ((j318 >>> 2) | (j318 >>> 1)) & 858993459;
        long j320 = ((j319 >>> 2) | j319) & 252645135;
        long j321 = (((j317 | (j317 >>> 4)) & 16711935) << 24) | ((((j320 >>> 4) | j320) & 16711935) << 16);
        long j322 = (j314 >>> 16) & 43690;
        long j323 = ((j322 >>> 2) | (j322 >>> 1)) & 858993459;
        long j324 = ((j323 >>> 2) | j323) & 252645135;
        long j325 = j314 & 43690;
        long j326 = ((j325 >>> 2) | (j325 >>> 1)) & 858993459;
        long j327 = (j326 | (j326 >>> 2)) & 252645135;
        int i32 = ((int) (((j327 | (j327 >>> 4)) & 16711935) + (j321 | ((((j324 >>> 4) | j324) & 16711935) << 8)))) & 17862984;
        long j328 = 28832;
        long length24 = cls.getName().length();
        long j329 = ((((((((j328 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j328 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j328 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j328 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length24 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length24 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length24 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length24 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j330 = (j329 >>> 48) & 43690;
        long j331 = ((j330 >>> 2) | (j330 >>> 1)) & 858993459;
        long j332 = (j331 | (j331 >>> 2)) & 252645135;
        long j333 = (j329 >>> 32) & 43690;
        long j334 = ((j333 >>> 2) | (j333 >>> 1)) & 858993459;
        long j335 = (j334 | (j334 >>> 2)) & 252645135;
        long j336 = (((j332 | (j332 >>> 4)) & 16711935) << 24) | (((j335 | (j335 >>> 4)) & 16711935) << 16);
        long j337 = (j329 >>> 16) & 43690;
        long j338 = ((j337 >>> 2) | (j337 >>> 1)) & 858993459;
        long j339 = (j338 | (j338 >>> 2)) & 252645135;
        long j340 = j329 & 43690;
        long j341 = ((j340 >>> 2) | (j340 >>> 1)) & 858993459;
        long j342 = (j341 | (j341 >>> 2)) & 252645135;
        int i33 = ((int) (((j342 | (j342 >>> 4)) & 16711935) | ((((j339 | (j339 >>> 4)) & 16711935) << 8) + j336))) | 1073767584;
        bArr13[AbstractC0099x.a(i32 | i33, 2, (~i32) ^ i33) ^ 1091630572] = -45;
        bArr13[5] = ((((~cls.getName().length()) | (-845882363)) & 268709428) + ((cls.getName().length() & 268444400) | 1149239488)) ^ 1417948869;
        bArr13[6] = -46;
        bArr13[7] = 101;
        h(bArr12, bArr13);
        sb.append(new String(bArr12, charset).intern());
        String sb2 = sb.toString();
        byte[] bArr14 = new byte[i];
        // fill-array-data instruction
        bArr14[0] = 75;
        bArr14[1] = -15;
        bArr14[2] = 96;
        bArr14[3] = 118;
        bArr14[4] = -64;
        bArr14[5] = 8;
        bArr14[6] = -119;
        bArr14[7] = -21;
        bArr14[8] = -126;
        bArr14[9] = -108;
        bArr14[10] = -83;
        bArr14[11] = 44;
        bArr14[12] = 77;
        int a8 = (I2.a(cls, -1) | 1924253465) & 1883245184;
        int length25 = (cls.getName().length() & 4196480) | 69214240;
        int i34 = -a8;
        h(bArr14, new byte[]{63, -98, 51, 2, -78, 97, -25, (-1952459476) ^ (((~i34) & length25) - (i34 & (~length25))), -86, -70, -125, 2, 100});
        kotlin.jvm.internal.j.d(sb2, new String(bArr14, charset).intern());
        return sb2;
    }
}
