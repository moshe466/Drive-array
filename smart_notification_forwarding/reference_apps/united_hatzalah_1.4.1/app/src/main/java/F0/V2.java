package F0;

import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public abstract class V2 {
    public static int a(int i, int i3, int i4) {
        return ((i - i3) * 2) + i4;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
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

    public static final boolean c(Context context, String str) {
        char c4 = 17652;
        char c5 = 17652;
        while (true) {
            boolean z3 = false;
            while (c5 != 32833) {
                if (c5 != 3777) {
                    if (c5 != c4) {
                        if (c5 != 58748) {
                        }
                    } else {
                        byte[] bArr = new byte[7];
                        long j2 = -1;
                        long length = V2.class.getName().length();
                        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                        int length2 = V2.class.getName().length() & 1073742921;
                        bArr[1123159755 ^ ((((7472193 + length2) + (((-length2) - 1) | (-7472193))) + (~(-((((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | (-1361088842)) & 1115687563)))) + 1)] = 51;
                        bArr[1] = -84;
                        bArr[2] = 65;
                        bArr[((((~V2.class.getName().length()) | (-1621442711)) & 573458992) + ((V2.class.getName().length() & 807686162) | 1342181698)) ^ 1915640689] = 68;
                        bArr[4] = -85;
                        bArr[5] = -6;
                        bArr[6] = -12;
                        byte[] bArr2 = new byte[8];
                        bArr2[0] = 57;
                        int length3 = V2.class.getName().length();
                        int i = ((((~length3) - length3) + length3) | 2034327615) & 541477716;
                        int length4 = (V2.class.getName().length() | (-67570625)) - (-67570625);
                        bArr2[1] = (-1816611801) ^ ((((((V2.class.getName().length() & (~length4)) & 1275134080) + 1275134080) + length4) - ((V2.class.getName().length() | length4) & 1275134080)) + i);
                        bArr2[2] = 25;
                        bArr2[3] = 73;
                        int i3 = ((~V2.class.getName().length()) | (-1170853154)) & (-1601888208);
                        int length5 = V2.class.getName().length();
                        int i4 = ((length5 & 1082196257) ^ 1074790667) + (length5 & 1073742081) + i3;
                        bArr2[4] = E1.a(i4 | 527097589, 527097589, i4);
                        bArr2[5] = -126;
                        int f4 = (AbstractC0008a.f(V2.class, -1) | 714480939) & 1092518161;
                        long j17 = -1610544960;
                        long length6 = V2.class.getName().length() & (-1056405296);
                        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                        long j19 = (j18 >>> 48) & 43690;
                        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
                        long j21 = ((j20 >>> 2) | j20) & 252645135;
                        long j22 = (j18 >>> 32) & 43690;
                        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                        long j24 = ((j23 >>> 2) | j23) & 252645135;
                        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << 24);
                        long j26 = (j18 >>> 16) & 43690;
                        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
                        long j28 = ((j27 >>> 2) | j27) & 252645135;
                        long j29 = j18 & 43690;
                        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                        long j31 = ((j30 >>> 2) | j30) & 252645135;
                        bArr2[(f4 + ((int) ((((j31 >>> 4) | j31) & 16711935) | (((((j28 >>> 4) | j28) & 16711935) << 8) + j25)))) ^ (-518026793)] = Byte.MIN_VALUE;
                        bArr2[7] = -23;
                        b(bArr, bArr2);
                        Charset charset = StandardCharsets.UTF_8;
                        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
                        byte[] bArr3 = new byte[10];
                        bArr3[0] = -25;
                        bArr3[1] = 90;
                        bArr3[2] = 125;
                        bArr3[3] = -61;
                        bArr3[4] = -46;
                        bArr3[5] = 50;
                        bArr3[6] = 69;
                        bArr3[7] = -10;
                        bArr3[8] = 63;
                        int i5 = ((~V2.class.getName().length()) | (-661820847)) & 1477542528;
                        long j32 = 52437056;
                        long length7 = V2.class.getName().length() & 19964032;
                        long j33 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                        long j34 = (j33 >>> 48) & 43690;
                        long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                        long j36 = ((j35 >>> 2) | j35) & 252645135;
                        long j37 = (j33 >>> 32) & 43690;
                        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                        long j39 = ((j38 >>> 2) | j38) & 252645135;
                        long j40 = ((((j39 >>> 4) | j39) & 16711935) << 16) + ((((j36 >>> 4) | j36) & 16711935) << 24);
                        long j41 = (j33 >>> 16) & 43690;
                        long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                        long j43 = ((j42 >>> 2) | j42) & 252645135;
                        long j44 = j33 & 43690;
                        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                        long j46 = ((j45 >>> 2) | j45) & 252645135;
                        bArr3[1529979593 ^ (i5 + ((int) ((((j46 >>> 4) | j46) & 16711935) + (((((j43 >>> 4) | j43) & 16711935) << 8) | j40))))] = -117;
                        byte[] bArr4 = new byte[((((~V2.class.getName().length()) | (-1521214872)) & 705168332) + ((V2.class.getName().length() & 168428932) | 209920)) ^ 705378246];
                        bArr4[0] = Byte.MIN_VALUE;
                        bArr4[1] = 111;
                        bArr4[2] = -7;
                        bArr4[3] = -58;
                        bArr4[4] = -92;
                        bArr4[5] = 113;
                        bArr4[6] = 32;
                        bArr4[7] = -72;
                        bArr4[8] = 80;
                        bArr4[9] = -27;
                        b(bArr3, bArr4);
                        kotlin.jvm.internal.j.e(str, new String(bArr3, charset).intern());
                        if (AbstractC0773d.a(context, str) != 0) {
                            c4 = 17652;
                            c5 = 58748;
                        }
                    }
                    c4 = 17652;
                    c5 = 3777;
                } else {
                    c5 = 32833;
                    z3 = true;
                    c4 = 17652;
                }
            }
            return z3;
            c5 = 32833;
        }
    }
}
