package F0;

import android.location.Location;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class a3 {

    /* renamed from: a, reason: collision with root package name */
    public final Location f462a;

    /* renamed from: b, reason: collision with root package name */
    public final long f463b;

    public a3(Location location, long j2) {
        byte[] bArr = new byte[((((~a3.class.getName().length()) | (-344255535)) & 626103360) + ((a3.class.getName().length() & (-1945590784)) | (-2001985520))) ^ (-1375882152)];
        bArr[0] = 22;
        bArr[1] = -67;
        bArr[((((~a3.class.getName().length()) | 2036758243) & (-2138346480)) + (((a3.class.getName().length() | 2138503023) - 2138503023) | 1610612897)) ^ (-527733581)] = 120;
        bArr[3] = -31;
        bArr[4] = 48;
        bArr[5] = 65;
        bArr[6] = 96;
        bArr[7] = -98;
        a(bArr, new byte[]{((((~a3.class.getName().length()) | 1952743722) & 638894893) + ((a3.class.getName().length() & (-2110234043)) | (-2144847808))) ^ (-1505952917), 1964067485 ^ ((((~a3.class.getName().length()) | 996712742) & (-2006802060)) + ((a3.class.getName().length() & (-2105146288)) | 42734601)), -83, 34, 40, 22, -127, 78});
        kotlin.jvm.internal.j.e(location, new String(bArr, StandardCharsets.UTF_8).intern());
        this.f462a = location;
        this.f463b = j2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    public final boolean equals(Object obj) {
        a3 a3Var = null;
        char c4 = 15402;
        while (true) {
            switch (c4) {
                case 45500:
                    if (!(obj instanceof a3)) {
                        c4 = 40775;
                    } else {
                        c4 = 40548;
                    }
                case 40775:
                    return false;
                case 45949:
                    if (this.f463b != a3Var.f463b) {
                        c4 = 38471;
                    } else {
                        c4 = 58727;
                    }
                case 15402:
                    if (this == obj) {
                        c4 = 9450;
                    } else {
                        c4 = 45500;
                    }
                case 38471:
                    return false;
                case 58727:
                    return true;
                case 64462:
                    return false;
                case 9450:
                    return true;
                case 40548:
                    a3Var = (a3) obj;
                    if (!kotlin.jvm.internal.j.a(this.f462a, a3Var.f462a)) {
                        c4 = 64462;
                    } else {
                        c4 = 45949;
                    }
                default:
                    c4 = 40775;
            }
        }
    }

    public final int hashCode() {
        return Long.hashCode(this.f463b) + (this.f462a.hashCode() * 31);
    }

    public final String toString() {
        byte[] bArr = new byte[26];
        bArr[0] = -111;
        bArr[1] = -125;
        bArr[2] = 36;
        bArr[3] = -26;
        bArr[4] = 54;
        bArr[5] = 83;
        bArr[6] = 39;
        int i = ((~a3.class.getName().length()) | (-65418025)) & 36316185;
        int length = a3.class.getName().length();
        int length2 = (((a3.class.getName().length() | 44457996) - (length | 44457996)) + AbstractC0008a.f(a3.class, length) + (a3.class.getName().length() & 44457996)) | 8667142;
        int i3 = (length2 & i) + (length2 | i);
        bArr[E1.a(i3 | 44983320, 44983320, i3)] = -8;
        bArr[8] = 115;
        int i4 = ((~a3.class.getName().length()) | (-1373051056)) & 838910372;
        int length3 = ((a3.class.getName().length() | (-285474981)) - (-285474981)) | 18088010;
        bArr[9] = (((length3 | i4) * 2) - (length3 ^ i4)) ^ 856998398;
        bArr[10] = -6;
        bArr[11] = -95;
        bArr[12] = 60;
        bArr[13] = -124;
        bArr[14] = -20;
        bArr[15] = 83;
        bArr[16] = 10;
        bArr[17] = 18;
        bArr[18] = -109;
        bArr[19] = 51;
        bArr[20] = -28;
        bArr[21] = -81;
        bArr[22] = 36;
        bArr[23] = -72;
        long j2 = -381976882;
        long j3 = ~a3.class.getName().length();
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        bArr[24] = ((((int) ((((((j14 >>> 4) | j14) & 16711935) << 8) | j11) | (((j17 >>> 4) | j17) & 16711935))) & 1140987080) + ((a3.class.getName().length() & 71837984) | 4794657)) ^ (-1145781710);
        bArr[25] = 64;
        byte[] bArr2 = new byte[26];
        bArr2[0] = 97;
        bArr2[1] = -33;
        bArr2[2] = -15;
        bArr2[3] = 37;
        bArr2[4] = 46;
        bArr2[((((~a3.class.getName().length()) | 986837904) & (-803327416)) + (((a3.class.getName().length() | 1072824214) - 1072824214) | 25166881)) ^ (-778160532)] = 4;
        bArr2[6] = -58;
        bArr2[((((~a3.class.getName().length()) | 1975917911) & 1246097581) + ((a3.class.getName().length() & 185852328) | 823263488)) ^ 2069361066] = 40;
        bArr2[8] = -124;
        int i5 = ((~a3.class.getName().length()) | (-1576643472)) & (-1820016440);
        long j18 = 296323208;
        long length4 = a3.class.getName().length();
        long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        bArr2[9] = (i5 + (((int) (((j33 | (j33 >>> 4)) & 16711935) + j30)) | 2689056)) ^ (-1817327453);
        bArr2[10] = 41;
        bArr2[11] = 115;
        bArr2[12] = 43;
        bArr2[13] = -46;
        bArr2[14] = 13;
        bArr2[15] = -123;
        bArr2[16] = -58;
        bArr2[17] = 75;
        bArr2[18] = 114;
        bArr2[19] = -10;
        bArr2[20] = -31;
        bArr2[21] = -51;
        int i6 = ~a3.class.getName().length();
        long j34 = 355076878;
        long j35 = ~(((a3.class.getName().length() | 1080430508) | i6) - (i6 | (a3.class.getName().length() & (-1080430509))));
        long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j37 = (j36 >>> 48) & 43690;
        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = (j36 >>> 32) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) | ((((j39 >>> 4) | j39) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = j36 & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = (j48 | (j48 >>> 2)) & 252645135;
        long j50 = 367962936;
        long length5 = ((int) (((j49 | (j49 >>> 4)) & 16711935) | (((((j46 >>> 4) | j46) & 16711935) << 8) + j43))) + ((a3.class.getName().length() & 15076140) | 12886048);
        long j51 = ((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j52 = (j51 >>> 48) & 21845;
        long j53 = ((j52 >>> 1) | j52) & 858993459;
        long j54 = ((j53 >>> 2) | j53) & 252645135;
        long j55 = (j51 >>> 32) & 21845;
        long j56 = ((j55 >>> 1) | j55) & 858993459;
        long j57 = ((j56 >>> 2) | j56) & 252645135;
        long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) + ((((j54 >>> 4) | j54) & 16711935) << 24);
        long j59 = (j51 >>> 16) & 21845;
        long j60 = ((j59 >>> 1) | j59) & 858993459;
        long j61 = ((j60 >>> 2) | j60) & 252645135;
        long j62 = j51 & 21845;
        long j63 = ((j62 >>> 1) | j62) & 858993459;
        long j64 = ((j63 >>> 2) | j63) & 252645135;
        bArr2[(int) ((((j64 >>> 4) | j64) & 16711935) + ((((j61 >>> 4) | j61) & 16711935) << 8) + j58)] = -1;
        bArr2[23] = 105;
        bArr2[24] = -75;
        bArr2[25] = 125;
        a(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr3 = {103, 73, -62, -47, -87, -91, -87, -36, -86, 82, -49, -12, 59, -116, 50, 2, -69, -32};
        int i7 = ((~a3.class.getName().length()) | 1394653927) & (-1524592344);
        int length6 = a3.class.getName().length();
        a(bArr3, new byte[]{-73, 68, 36, 26, -72, -10, 76, 10, -81, 9, 45, 91, 54, (i7 + (1212219458 | (((-469696246) + length6) - (length6 | (-469696246))))) ^ 312372924, -20, -55, -56, -35});
        String intern2 = new String(bArr3, charset).intern();
        byte[] bArr4 = {90};
        int f4 = AbstractC0008a.f(a3.class, -1);
        int length7 = ((a3.class.getName().length() & 402965604) | 268976138) + (~(-(((-160728166) | (((((a3.class.getName().length() & (~f4)) & (-1749483117)) - 1749483117) + f4) - ((f4 | a3.class.getName().length()) & (-1749483117)))) + 160728166))) + 1;
        a(bArr4, new byte[]{115, 57, 86, (((~length7) & (-429704291)) - ((-429704291) & length7)) + length7, 36, 23, -39, 46});
        return intern + this.f462a + intern2 + this.f463b + new String(bArr4, charset).intern();
    }
}
