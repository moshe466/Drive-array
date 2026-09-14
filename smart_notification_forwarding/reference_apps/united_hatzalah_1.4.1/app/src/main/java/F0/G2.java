package F0;

import android.content.SharedPreferences;
import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public class G2 extends AbstractC0011a2 {
    static {
        byte[] bArr = new byte[44];
        bArr[0] = -10;
        bArr[1] = -69;
        bArr[2] = 48;
        bArr[3] = 5;
        bArr[4] = 37;
        bArr[5] = -86;
        bArr[6] = -107;
        bArr[7] = -2;
        bArr[8] = -4;
        bArr[9] = 122;
        long j2 = 335678584;
        long f4 = AbstractC0008a.f(G2.class, -1) | (-1273083078);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        bArr[10] = (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) + ((G2.class.getName().length() & 34088004) | 46673926)) ^ 382352483;
        bArr[11] = -74;
        bArr[12] = -50;
        bArr[13] = 90;
        bArr[14] = ((((~G2.class.getName().length()) | (-319433133)) & (-2118504360)) + ((G2.class.getName().length() & 21635592) | 306250243)) ^ 1812254164;
        bArr[15] = -24;
        bArr[16] = 46;
        bArr[17] = 48;
        bArr[18] = 46;
        bArr[19] = -19;
        bArr[20] = 90;
        bArr[21] = -4;
        long j17 = -1;
        long length = G2.class.getName().length();
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j19 = (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j18;
        long j20 = (j19 >>> 48) & 21845;
        long j21 = ((j20 >>> 1) | j20) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 21845;
        long j24 = ((j23 >>> 1) | j23) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 21845;
        long j31 = ((j30 >>> 1) | j30) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        long j33 = -2045947514;
        long j34 = (int) ((((j32 >>> 4) | j32) & 16711935) | ((((j29 >>> 4) | j29) & 16711935) << 8) | j26);
        long b4 = c3.b((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j35 = (b4 >>> 48) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        long j38 = (b4 >>> 32) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
        long j42 = (b4 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = b4 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        bArr[((((int) ((((j47 >>> 4) | j47) & 16711935) + (((((j44 >>> 4) | j44) & 16711935) << 8) + j41))) & (-1796923263)) + ((G2.class.getName().length() & 417392897) | 134269186)) ^ (-1662654059)] = -71;
        bArr[23] = 64;
        bArr[24] = 88;
        bArr[25] = -50;
        long length2 = G2.class.getName().length();
        long j48 = ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j18;
        long j49 = (j48 >>> 48) & 21845;
        long j50 = (j49 | (j49 >>> 1)) & 858993459;
        long j51 = (j50 | (j50 >>> 2)) & 252645135;
        long j52 = (j48 >>> 32) & 21845;
        long j53 = ((j52 >>> 1) | j52) & 858993459;
        long j54 = ((j53 >>> 2) | j53) & 252645135;
        long j55 = ((((j54 >>> 4) | j54) & 16711935) << 16) + (((j51 | (j51 >>> 4)) & 16711935) << 24);
        long j56 = (j48 >>> 16) & 21845;
        long j57 = ((j56 >>> 1) | j56) & 858993459;
        long j58 = ((j57 >>> 2) | j57) & 252645135;
        long j59 = j48 & 21845;
        long j60 = (j59 | (j59 >>> 1)) & 858993459;
        long j61 = (j60 | (j60 >>> 2)) & 252645135;
        bArr[26] = (((((int) ((((((j58 >>> 4) | j58) & 16711935) << 8) + j55) | ((j61 | (j61 >>> 4)) & 16711935))) | (-1825192658)) & 69452814) + ((G2.class.getName().length() & 75636737) | 1083191617)) ^ (-1152644425);
        long j62 = -299215943;
        long f5 = AbstractC0008a.f(G2.class, -1);
        long b5 = c3.b((((((((j62 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j62 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j62 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j62 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((f5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((f5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((f5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((f5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j63 = (b5 >>> 48) & 43690;
        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
        long j65 = (j64 | (j64 >>> 2)) & 252645135;
        long j66 = (b5 >>> 32) & 43690;
        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
        long j68 = (j67 | (j67 >>> 2)) & 252645135;
        long j69 = (((j68 | (j68 >>> 4)) & 16711935) << 16) + (((j65 | (j65 >>> 4)) & 16711935) << 24);
        long j70 = (b5 >>> 16) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = (j71 | (j71 >>> 2)) & 252645135;
        long j73 = b5 & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = (j74 | (j74 >>> 2)) & 252645135;
        int i = ((int) (((j75 | (j75 >>> 4)) & 16711935) + (((j72 | (j72 >>> 4)) & 16711935) << 8) + j69)) & 204226602;
        int length3 = (G2.class.getName().length() & (-2147221374)) | (-2134900284);
        bArr[27] = (-1930673671) ^ (((length3 | i) * 2) - (i ^ length3));
        bArr[28] = 59;
        bArr[29] = 18;
        bArr[30] = 99;
        bArr[31] = -19;
        bArr[32] = -104;
        bArr[33] = -37;
        bArr[34] = -125;
        bArr[35] = 4;
        int i3 = ~G2.class.getName().length();
        bArr[1087375039 ^ ((((1168236313 | i3) + 1073743512) - (i3 | 1168236441)) + ((G2.class.getName().length() & 9437312) | 13631491))] = -62;
        bArr[37] = -22;
        bArr[38] = 4;
        bArr[39] = 12;
        bArr[40] = -103;
        bArr[41] = 97;
        bArr[42] = -47;
        bArr[43] = 37;
        int i4 = ((~G2.class.getName().length()) | (-1262317639)) & 2032416;
        int length4 = (G2.class.getName().length() & 1075650560) | 1082138628;
        i(bArr, new byte[]{-73, -13, 114, 109, 76, -3, -52, -78, -113, 48, 88, -28, -118, 59, -51, -48, 94, 119, 108, -118, 44, -84, -3, 3, 109, -122, -71, 34, 76, 57, 19, -69, -31, -88, -5, 81, -121, -91, 108, 1084171033 ^ (((length4 | i4) * 2) - (length4 ^ i4)), -6, 19, -23, 24});
        new String(bArr, StandardCharsets.UTF_8).intern();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public G2(android.content.Context r43) {
        /*
            Method dump skipped, instructions count: 1432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.G2.<init>(android.content.Context):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void h(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.security.MessageDigest] */
    public static String m(String str) {
        String str2 = null;
        ?? e4 = 0;
        while (true) {
            char c4 = 18165;
            while (c4 != 20075) {
                if (c4 != 33950) {
                    if (c4 != 18165) {
                        break;
                    }
                    try {
                        int i = ((~G2.class.getName().length()) | (-2050038243)) & 423645440;
                        int length = G2.class.getName().length() & 403706120;
                        int length2 = ((((G2.class.getName().length() & (~length)) & 1048588) + 1048588) + length) - ((length | G2.class.getName().length()) & 1048588);
                        int i3 = -i;
                        byte[] bArr = {-14, 424694073 ^ ((length2 ^ i3) - ((i3 & (~length2)) * 2)), -120, 54, 64, -91, -27};
                        h(bArr, new byte[]{-59, 107, -69, -75, 114, -112, -45, -112});
                        e4 = MessageDigest.getInstance(new String(bArr, StandardCharsets.UTF_8).intern());
                        str2 = Base64.encodeToString(e4.digest(str.getBytes(N2.a.f1508a)), 2);
                        c4 = 20075;
                    } catch (Exception e5) {
                        e4 = e5;
                        c4 = 33950;
                    }
                } else {
                    return str;
                }
            }
            return str2;
        }
    }

    @Override // F0.AbstractC0011a2
    public final String c(String str) {
        String str2 = null;
        String str3 = null;
        char c4 = 3722;
        while (true) {
            if (c4 != 3722) {
                if (c4 != 60771) {
                    if (c4 != 14754) {
                        if (c4 == 56855) {
                            return super.c(str);
                        }
                    } else {
                        return super.c(str3);
                    }
                } else if (super.f(str2)) {
                    str3 = str2;
                    c4 = 14754;
                } else {
                    str3 = str2;
                }
                c4 = 56855;
            } else {
                str2 = m(str);
                c4 = 60771;
            }
        }
    }

    @Override // F0.AbstractC0011a2
    public final void d(String str, String str2) {
        super.d(m(str), str2);
    }

    @Override // F0.AbstractC0011a2
    public final boolean f(String str) {
        char c4;
        boolean z3 = false;
        do {
            c4 = 53751;
            while (true) {
                if (c4 != 36956) {
                    if (c4 != 53751) {
                        if (c4 != 11729) {
                            break;
                        }
                        z3 = true;
                    } else if (c(str) != null) {
                        c4 = 11729;
                    } else {
                        c4 = 36956;
                    }
                } else {
                    z3 = false;
                }
                c4 = 34504;
            }
        } while (c4 != 34504);
        return z3;
    }

    public final void l() {
        SharedPreferences.Editor edit = this.f461a.edit();
        byte[] bArr = {51, 72, 60, 17, 77, 116};
        byte[] bArr2 = new byte[8];
        bArr2[0] = 86;
        bArr2[1] = 44;
        bArr2[2] = 85;
        bArr2[3] = 101;
        bArr2[4] = 34;
        bArr2[5] = 6;
        int i = ((~AbstractC0011a2.class.getName().length()) | 1303863731) & 152593296;
        int length = (AbstractC0011a2.class.getName().length() & 1074299394) | 1076334658;
        bArr2[1228927956 ^ (((length | i) * 2) - (length ^ i))] = -34;
        bArr2[7] = -68;
        AbstractC0011a2.j(bArr, bArr2);
        kotlin.jvm.internal.j.d(edit, new String(bArr, StandardCharsets.UTF_8).intern());
        edit.clear();
        edit.apply();
    }
}
