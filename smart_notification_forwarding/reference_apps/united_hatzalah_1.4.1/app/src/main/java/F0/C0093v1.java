package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.tika.fork.ForkServer;
import org.json.JSONObject;
import s2.C0679d;

/* renamed from: F0.v1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0093v1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f694a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f695b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f696c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f697d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f698e;

    /* JADX WARN: Multi-variable type inference failed */
    public C0093v1(AbstractC0083t abstractC0083t, Z z3, String str, Z1 z12, Q q3, JSONObject jSONObject) {
        boolean z4;
        byte[] bArr = new byte[16];
        bArr[0] = -63;
        bArr[1] = 122;
        bArr[2] = ((((~C0093v1.class.getName().length()) | (-1253599529)) & 696329) + ((C0093v1.class.getName().length() & 19406888) | 18874400)) ^ 19570714;
        bArr[3] = 39;
        long j2 = -1;
        long length = C0093v1.class.getName().length();
        long j3 = ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j4 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j5 = (j4 | j3) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j6 = (j5 >>> 48) & 21845;
        long j7 = ((j6 >>> 1) | j6) & 858993459;
        long j8 = ((j7 >>> 2) | j7) & 252645135;
        long j9 = (j5 >>> 32) & 21845;
        long j10 = ((j9 >>> 1) | j9) & 858993459;
        long j11 = ((j10 >>> 2) | j10) & 252645135;
        long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
        long j13 = (j5 >>> 16) & 21845;
        long j14 = ((j13 >>> 1) | j13) & 858993459;
        long j15 = ((j14 >>> 2) | j14) & 252645135;
        long j16 = j5 & 21845;
        long j17 = ((j16 >>> 1) | j16) & 858993459;
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        bArr[(((((int) ((((j18 >>> 4) | j18) & 16711935) | (((((j15 >>> 4) | j15) & 16711935) << 8) | j12))) | 1837118311) & (-1862139762)) + ((C0093v1.class.getName().length() & (-1845362535)) | 1107296273)) ^ (-754843493)] = -69;
        bArr[5] = 122;
        bArr[6] = 17;
        bArr[7] = 35;
        bArr[8] = 98;
        bArr[9] = -99;
        bArr[10] = -95;
        bArr[11] = 81;
        bArr[12] = 22;
        bArr[13] = -40;
        bArr[14] = -69;
        bArr[15] = -61;
        e(bArr, new byte[]{-52, 40, -28, -9, -93, 45, -55, -24, 107, -3, 68, -28, 14, -105, 93, 4});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(abstractC0083t, new String(bArr, charset).intern());
        byte[] bArr2 = {34, 115, 12, -83, -54, 99, 5};
        byte[] bArr3 = new byte[8];
        long length2 = C0093v1.class.getName().length();
        long j19 = j4 + j3;
        long j20 = ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j19;
        long j21 = (j20 >>> 48) & 21845;
        long j22 = ((j21 >>> 1) | j21) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 21845;
        long j25 = ((j24 >>> 1) | j24) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 21845;
        long j29 = ((j28 >>> 1) | j28) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 21845;
        long j32 = ((j31 >>> 1) | j31) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = -31387930;
        long j35 = (int) ((((j33 >>> 4) | j33) & 16711935) | ((((j30 >>> 4) | j30) & 16711935) << 8) | j27);
        long b4 = c3.b((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j36 = (b4 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = ((j37 >>> 2) | j37) & 252645135;
        long j39 = (b4 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) | ((((j38 >>> 4) | j38) & 16711935) << 24);
        long j43 = (b4 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = b4 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = ((j47 >>> 2) | j47) & 252645135;
        bArr3[(((((int) ((((j48 >>> 4) | j48) & 16711935) + (((((j45 >>> 4) | j45) & 16711935) << 8) | j42))) | (-488735237)) + 488735237) + ((C0093v1.class.getName().length() & 1099206656) | 1082397769)) ^ 1571133005] = 51;
        bArr3[1] = 60;
        bArr3[2] = -20;
        bArr3[3] = 110;
        bArr3[4] = -83;
        bArr3[5] = 6;
        bArr3[6] = 119;
        bArr3[7] = -84;
        e(bArr2, bArr3);
        new String(bArr2, charset).intern();
        byte[] bArr4 = {70, 60, 55, 113, -51, -2};
        byte[] bArr5 = new byte[8];
        bArr5[0] = 65;
        bArr5[1] = 97;
        bArr5[2] = -41;
        bArr5[3] = -71;
        bArr5[4] = -92;
        int i = ((~C0093v1.class.getName().length()) | (-420251326)) & 306823173;
        long j49 = 270041095;
        long length3 = C0093v1.class.getName().length();
        long j50 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j51 = (j50 >>> 48) & 43690;
        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = (j50 >>> 32) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) | ((((j53 >>> 4) | j53) & 16711935) << 24);
        long j58 = (j50 >>> 16) & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = ((((j60 >>> 4) | j60) & 16711935) << 8) + j57;
        long j62 = j50 & 43690;
        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
        long j64 = (j63 | (j63 >>> 2)) & 252645135;
        int i3 = i + (((int) (((j64 | (j64 >>> 4)) & 16711935) | j61)) | 1091567618);
        bArr5[B0.a((~i3) | 1398390786, 1398390786 - i3)] = -103;
        bArr5[6] = 78;
        bArr5[7] = 88;
        e(bArr4, bArr5);
        kotlin.jvm.internal.j.e(z12, new String(bArr4, charset).intern());
        byte[] bArr6 = new byte[7];
        bArr6[0] = -24;
        bArr6[1] = 87;
        bArr6[2] = 42;
        long length4 = C0093v1.class.getName().length();
        long j65 = ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j19;
        long j66 = (j65 >>> 48) & 21845;
        long j67 = (j66 | (j66 >>> 1)) & 858993459;
        long j68 = (j67 | (j67 >>> 2)) & 252645135;
        long j69 = (j65 >>> 32) & 21845;
        long j70 = ((j69 >>> 1) | j69) & 858993459;
        long j71 = ((j70 >>> 2) | j70) & 252645135;
        long j72 = (((j68 | (j68 >>> 4)) & 16711935) << 24) | ((((j71 >>> 4) | j71) & 16711935) << 16);
        long j73 = (j65 >>> 16) & 21845;
        long j74 = ((j73 >>> 1) | j73) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        long j76 = j65 & 21845;
        long j77 = (j76 | (j76 >>> 1)) & 858993459;
        long j78 = (j77 | (j77 >>> 2)) & 252645135;
        int i4 = (((int) (((j78 | (j78 >>> 4)) & 16711935) | (((((j75 >>> 4) | j75) & 16711935) << 8) + j72))) | (-1615568500)) & 268492206;
        int length5 = C0093v1.class.getName().length() & 570465314;
        int i5 = ~(((~length5) & 1720713217) + length5);
        int i6 = -i4;
        bArr6[V2.a(~i6, i5, (i5 + i6) + 1) ^ 1989205420] = -19;
        bArr6[4] = -98;
        bArr6[5] = 6;
        bArr6[6] = ((((~C0093v1.class.getName().length()) | 1488624125) & (-1876744192)) + ((C0093v1.class.getName().length() & (-1610537919)) | 545260609)) ^ (-1331483583);
        byte[] bArr7 = new byte[8];
        bArr7[0] = -28;
        int i7 = ((~C0093v1.class.getName().length()) | (-1840595330)) & 311429128;
        long j79 = 9437248;
        long length6 = C0093v1.class.getName().length();
        long j80 = (((((((((j79 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j79 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j79 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j79 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j81 = (j80 >>> 48) & 43690;
        long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
        long j83 = (j82 | (j82 >>> 2)) & 252645135;
        long j84 = (j80 >>> 32) & 43690;
        long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
        long j86 = ((j85 >>> 2) | j85) & 252645135;
        long j87 = (((j83 | (j83 >>> 4)) & 16711935) << 24) | ((((j86 >>> 4) | j86) & 16711935) << 16);
        long j88 = (j80 >>> 16) & 43690;
        long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
        long j90 = ((j89 >>> 2) | j89) & 252645135;
        long j91 = j80 & 43690;
        long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
        long j93 = (j92 | (j92 >>> 2)) & 252645135;
        bArr7[(i7 + (((int) (((j93 | (j93 >>> 4)) & 16711935) + (j87 | ((((j90 >>> 4) | j90) & 16711935) << 8)))) | 2130496)) ^ 313559625] = 24;
        int i8 = ~C0093v1.class.getName().length();
        int length7 = (((i8 | (-1143152885)) - ((731438858 | i8) ^ (-1739303933))) + ((C0093v1.class.getName().length() & (-1857814259)) | 587235596)) ^ (-1152068339);
        int i9 = ~C0093v1.class.getName().length();
        bArr7[length7] = (((2145087038 | ((i9 + 724279107) - (i9 & 724279107))) - 2145087038) + ((C0093v1.class.getName().length() & (-1537990512)) | 609247248)) ^ 1535839771;
        bArr7[3] = 43;
        bArr7[4] = -14;
        bArr7[5] = 99;
        bArr7[6] = 114;
        bArr7[7] = 21;
        e(bArr6, bArr7);
        new String(bArr6, charset).intern();
        this.f695b = abstractC0083t;
        this.f696c = z3;
        this.f697d = z12;
        if (str != null) {
            z4 = 1;
        } else {
            long j94 = -2126773862;
            long j95 = (~C0093v1.class.getName().length()) | 1117405401;
            long j96 = (((((((((j94 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j94 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j94 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j94 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j95 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j95 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j95 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j95 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
            long j97 = (j96 >>> 48) & 43690;
            long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
            long j99 = (j98 | (j98 >>> 2)) & 252645135;
            long j100 = (j96 >>> 32) & 43690;
            long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
            long j102 = (j101 | (j101 >>> 2)) & 252645135;
            long j103 = (((j102 | (j102 >>> 4)) & 16711935) << 16) + (((j99 | (j99 >>> 4)) & 16711935) << 24);
            long j104 = (j96 >>> 16) & 43690;
            long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
            long j106 = (j105 | (j105 >>> 2)) & 252645135;
            long j107 = j96 & 43690;
            long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
            long j109 = (j108 | (j108 >>> 2)) & 252645135;
            z4 = ((37838851 - ((~(C0093v1.class.getName().length() & (-2090573566))) | 37838852)) + ((int) (((j109 | (j109 >>> 4)) & 16711935) | ((((j106 | (j106 >>> 4)) & 16711935) << 8) + j103)))) ^ (-2088935010);
        }
        this.f694a = z4;
        this.f698e = new R2(z12, str, q3);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~C0093v1.class.getName().length();
        int length3 = (((~(((C0093v1.class.getName().length() | 70245657) | i7) - (i7 | (C0093v1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C0093v1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C0093v1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C0093v1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C0093v1.class.getName().length()) | (-576567005)) & 276971586) + ((C0093v1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C0093v1.class.getName().length()) | (-1157759625)) & 1755853004) + ((C0093v1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C0093v1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C0093v1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C0093v1.class.getName().length()) | (-1064961)) + 689325073) + ((C0093v1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C0093v1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C0093v1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C0093v1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C0093v1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C0093v1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C0093v1.class.getName().length();
                    int length11 = (161497089 & (((((C0093v1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C0093v1.class.getName().length() | i14) & 797295576))) + ((C0093v1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C0093v1.class.getName().length()) | (-1085986263)) & 1078327440) + ((C0093v1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C0093v1.class.getName().length();
                    int length12 = length5 >>> ((((~(((C0093v1.class.getName().length() | 626856794) | i15) - ((C0093v1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C0093v1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C0093v1.class.getName().length()) | 1248713193) & 826417528) + ((C0093v1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C0093v1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C0093v1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C0093v1.class.getName().length()) | (-1005965450)) & 153223237) + ((C0093v1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C0093v1.class.getName().length() & (~length6)) & i9)) + ((C0093v1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C0093v1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C0093v1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C0093v1.class.getName().length()) | (-23496740)) & 827084804) + ((C0093v1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C0093v1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C0093v1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C0093v1.class.getName().length()) | (-961655275)) & 25184460) + ((C0093v1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C0093v1.class.getName().length()) | 1233459797) & 125923146) + ((C0093v1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C0093v1.class.getName().length()) | (-7107622)) & 402932290) + ((C0093v1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C0093v1.class.getName().length() | length15) - (b4 | length15)) + I2.a(C0093v1.class, b4) + (C0093v1.class.getName().length() & length15);
                    int length17 = ((((~C0093v1.class.getName().length()) | (-81143879)) & 438583424) + ((C0093v1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C0093v1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C0093v1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C0093v1.class, 568748773 | i24) + (C0093v1.class.getName().length() & (-2105278367)))) + ((C0093v1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C0093v1.class.getName().length()) | (-1592082969)) & 140665109) + ((C0093v1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C0093v1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C0093v1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C0093v1.class.getName().length()) | (-180811308));
                    int length19 = (C0093v1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C0093v1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C0093v1.class.getName().length()))));
                    int i29 = ((~C0093v1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C0093v1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C0093v1.class.getName().length()) | 75364313) & 1242301609) + ((C0093v1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C0093v1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C0093v1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C0093v1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C0093v1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C0093v1.class.getName().length();
                    int length24 = 1409942802 & (((((C0093v1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C0093v1.class.getName().length()) & 91135407));
                    int length25 = (C0093v1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C0093v1.class.getName().length()) | (-537919489)) - (-806798471)) + ((C0093v1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C0093v1.class.getName().length()) | (-382746167)) & 102532165) + ((C0093v1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C0093v1.class.getName().length()) | (-6036961)) & 1233145505) + ((C0093v1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C0093v1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C0093v1.class.getName().length() & 268460041;
                    i5 = (((((C0093v1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C0093v1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C0093v1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C0093v1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C0093v1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C0093v1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C0093v1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C0093v1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C0093v1.class, -1) | (-532481)) - (-67641369)) + ((C0093v1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C0093v1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C0093v1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C0093v1.class, -1) | (-33554434)) - (-1107366402)) + ((C0093v1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C0093v1.class, -1) | (-167014194)) & 1157999680) + ((C0093v1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C0093v1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C0093v1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C0093v1.class, -1) | 114408723) & 1183666176;
                    int length33 = C0093v1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C0093v1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C0093v1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C0093v1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C0093v1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C0093v1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C0093v1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C0093v1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C0093v1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C0093v1.class.getName().length()) | 991120067) & (-2113137661)) + ((C0093v1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C0093v1.class, -1) | 314136709) & 371231304) + (((C0093v1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C0093v1.class.getName().length()) | 366661365) & 1344150018) + ((C0093v1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C0093v1.class.getName().length()) | (-1359635359)) & 49026131) + ((C0093v1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C0093v1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C0093v1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C0093v1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C0093v1.class.getName().length()) | 1110430873) & 1241612298) + ((C0093v1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C0093v1.class.getName().length()) | 1603962366) & 25199440) + (((C0093v1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C0093v1.class.getName().length()) | (-1388708984)) & 706816128) + ((C0093v1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C0093v1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C0093v1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C0093v1.class.getName().length()) | 2113158628) & 1026558002) + ((C0093v1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C0093v1.class.getName().length()) | 715175224) & 136512788) + ((C0093v1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C0093v1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C0093v1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C0093v1.class.getName().length()) | (-1084937228)) & 438503696) + ((C0093v1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C0093v1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C0093v1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C0093v1.class, 1197735420 | i53) + (C0093v1.class.getName().length() & 674349280))) + ((C0093v1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C0093v1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C0093v1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C0093v1.class.getName().length()) | (-171976913)) & 318775824) + ((C0093v1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C0093v1.class.getName().length()) | (-616910267)) & 1303391760) + ((C0093v1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C0093v1.class.getName().length()) | 1297715640) & 556926729) + ((C0093v1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C0093v1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C0093v1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C0093v1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C0093v1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    public static boolean c(C0093v1 c0093v1) {
        if (((ArrayList) c0093v1.f698e).isEmpty()) {
            ArrayList arrayList = (ArrayList) c0093v1.f695b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (!((P0.c) obj).f1566d.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static void d(C0093v1 c0093v1, L0.e eVar, Object[] objArr) {
        ((ArrayList) c0093v1.f698e).add(new L0.f(eVar, objArr));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
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

    public void a(Context context) {
        byte[] bArr = {-30, -111, 44, 54, -1, 107, 46};
        b(bArr, new byte[]{-23, 90, 19, -102, -82, 64, 122, -117});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        R2 r22 = (R2) this.f698e;
        AbstractC0083t abstractC0083t = (AbstractC0083t) this.f695b;
        Z z3 = (Z) this.f696c;
        C0018c1 c0018c1 = (C0018c1) abstractC0083t.f662a;
        Z1 z12 = (Z1) this.f697d;
        C0043i2 c0043i2 = ((C0051k2) z12).f558b;
        z12.getClass();
        boolean z4 = this.f694a;
        byte[] bArr2 = {-8, -32, -125, -52, 89, 17, -103, 47, -15, -123, 70, -6, -106, -41, -86, 92};
        byte[] bArr3 = new byte[16];
        bArr3[0] = -88;
        bArr3[1] = 84;
        int i = ~(z4 ? 1 : 0);
        bArr3[((((i + 1700139694) + (((-i) - 1) | (-1700139694))) & 841234568) + (((z4 ? 1 : 0) & 304098340) | 66676)) ^ 841301246] = -4;
        bArr3[3] = -119;
        bArr3[4] = 68;
        bArr3[5] = 72;
        bArr3[(((i | 869420322) & (-1326435296)) + ((((z4 ? 1 : 0) - 1071108026) - ((z4 ? 1 : 0) | (-1071108026))) | 1074266326)) ^ (-252168976)] = 21;
        bArr3[7] = 46;
        bArr3[8] = -85;
        long j2 = -1476229304;
        long j3 = i | (-828141840);
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
        bArr3[(((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) + ((553648520 & (z4 ? 1 : 0)) | 327155888)) ^ (-1149073423)] = -57;
        bArr3[10] = 75;
        bArr3[11] = -112;
        bArr3[12] = -7;
        bArr3[13] = -122;
        bArr3[14] = -12;
        bArr3[15] = 32;
        T.g(bArr2, bArr3);
        new String(bArr2, charset).intern();
        byte[] bArr4 = {111, 115, 2, 51, -106, -50, 78};
        T.g(bArr4, new byte[]{25, -30, -127, 57, -15, -85, 60, -100});
        kotlin.jvm.internal.j.e(z3, new String(bArr4, charset).intern());
        byte[] bArr5 = {-101, -13, -106, -71, 107, -8};
        long j18 = 19005525;
        long j19 = 1544554580 & (z4 ? 1 : 0);
        long b4 = c3.b((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
        long j20 = (b4 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (b4 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (b4 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = b4 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        byte[] bArr6 = new byte[1568020725 ^ (((568709356 | i) & 1549015208) + ((int) ((((j32 >>> 4) | j32) & 16711935) | (((((j29 >>> 4) | j29) & 16711935) << 8) + j26))))];
        bArr6[0] = 15;
        bArr6[1] = 108;
        bArr6[2] = 9;
        bArr6[3] = -62;
        bArr6[4] = 0;
        bArr6[5] = -117;
        bArr6[6] = 65;
        bArr6[7] = -119;
        T.g(bArr5, bArr6);
        kotlin.jvm.internal.j.e(c0018c1, new String(bArr5, charset).intern());
        k3 k3Var = new k3(abstractC0083t, z3, c0018c1, z4);
        String e4 = ((C0107z) abstractC0083t).f722f.e();
        r22.getClass();
        byte[] bArr7 = {-24, 18, 102, -101, 91, 112, 104};
        byte[] bArr8 = new byte[8];
        bArr8[0] = -2;
        bArr8[1] = 65;
        bArr8[2] = -123;
        int i3 = ((~R2.class.getName().length()) | (-2047907151)) & 646015520;
        int length = R2.class.getName().length() & 1645216128;
        int i4 = ~(((R2.class.getName().length() | (-1362100673)) | length) - ((R2.class.getName().length() & 1362100672) | length));
        int i5 = -i3;
        bArr8[2008116195 ^ ((((~i5) & i4) * 2) - (i4 ^ i5))] = 76;
        bArr8[4] = 62;
        bArr8[5] = 3;
        bArr8[6] = 28;
        bArr8[7] = -94;
        R2.e(bArr7, bArr8);
        new String(bArr7, charset).intern();
        ((ConcurrentLinkedQueue) r22.f376e).offer(new C0679d(k3Var, e4));
    }

    public C0093v1() {
        this.f695b = new ArrayList();
        this.f696c = new ArrayList();
        this.f697d = new ArrayList();
        this.f698e = new ArrayList();
    }
}
