package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class M1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f288a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f289b;

    /* renamed from: c, reason: collision with root package name */
    public final int f290c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f291d;

    public M1(byte[] bArr, int i, int i3, boolean z3) {
        byte[] bArr2 = new byte[7];
        bArr2[0] = -62;
        bArr2[1] = 28;
        bArr2[2] = 92;
        bArr2[3] = 59;
        bArr2[4] = 124;
        int i4 = (i & 275) | (-2128606958);
        int i5 = -(((~i) | (-1481939016)) & 109134465);
        bArr2[(-2019472490) ^ (((~i5) & i4) - (i5 & (~i4)))] = Byte.MAX_VALUE;
        bArr2[6] = -24;
        e(bArr2, new byte[]{((((~(z3 ? 1 : 0)) | (-295034923)) & 239767809) + ((((-99907) | (z3 ? 1 : 0)) + 99907) | 539313730)) ^ 779081542, 101, -96, -23, 25, 17, -100, -31});
        new String(bArr2, StandardCharsets.UTF_8).intern();
        this.f288a = i;
        this.f289b = z3;
        this.f290c = i3;
        this.f291d = bArr;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void f(byte[] bArr, byte[] bArr2) {
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
    public static void h(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x02d6. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x005d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:74:0x067d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final BigInteger a() {
        char c4 = 59801;
        boolean z3 = false;
        while (true) {
            byte[] bArr = this.f291d;
            boolean z4 = this.f289b;
            switch (c4) {
                case 59801:
                    M1 m12 = null;
                    char c5 = 43635;
                    while (true) {
                        Object[] objArr = false;
                        while (true) {
                            switch (c5) {
                                case 43635:
                                    c5 = 12215;
                                    m12 = this;
                                case 64077:
                                    break;
                                case 12215:
                                    c5 = m12.c(2) ? (char) 21361 : (char) 5770;
                                case 5770:
                                    break;
                                case 28981:
                                    c5 = 64077;
                                    objArr = true;
                                case 21361:
                                    if (!z4) {
                                        c5 = 28981;
                                    }
                                default:
                            }
                            if (objArr == false) {
                                c4 = 12576;
                            }
                        }
                        c4 = 35444;
                        c5 = 64077;
                    }
                    break;
                case 2189:
                    long j2 = -977277522;
                    long j3 = -977277533;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j5 = (j4 >>> 48) & 21845;
                    long j6 = ((j5 >>> 1) | j5) & 858993459;
                    long j7 = ((j6 >>> 2) | j6) & 252645135;
                    long j8 = (j4 >>> 32) & 21845;
                    long j9 = ((j8 >>> 1) | j8) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
                    long j12 = (j4 >>> 16) & 21845;
                    long j13 = ((j12 >>> 1) | j12) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = ((((j14 >>> 4) | j14) & 16711935) << 8) + j11;
                    long j16 = j4 & 21845;
                    long j17 = (j16 | (j16 >>> 1)) & 858993459;
                    long j18 = (j17 | (j17 >>> 2)) & 252645135;
                    byte[] bArr2 = new byte[(int) (((j18 | (j18 >>> 4)) & 16711935) | j15)];
                    bArr2[0] = Byte.MAX_VALUE;
                    bArr2[1] = 100;
                    bArr2[2] = -8;
                    bArr2[3] = -20;
                    long j19 = 471957587;
                    long j20 = (~(z4 ? 1 : 0)) | (-1204844074);
                    long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                    long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                    long j34 = ((j33 >>> 2) | j33) & 252645135;
                    int i = ((int) ((((((j31 >>> 4) | j31) & 16711935) << 8) + j28) | (((j34 >>> 4) | j34) & 16711935))) + ((67111937 & (z4 ? 1 : 0)) | (-2146037888));
                    bArr2[B0.a((~i) | (-1674080297), (-1674080297) - i)] = -51;
                    bArr2[5] = -119;
                    bArr2[6] = -37;
                    bArr2[7] = 67;
                    bArr2[8] = -49;
                    bArr2[9] = -1;
                    bArr2[10] = -85;
                    bArr2[11] = -56;
                    bArr2[12] = 113;
                    byte[] bArr3 = new byte[13];
                    bArr3[0] = -106;
                    bArr3[1] = 62;
                    bArr3[2] = 26;
                    bArr3[3] = 58;
                    bArr3[4] = -48;
                    long j35 = -1546018120;
                    long j36 = -1546018115;
                    long j37 = (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j38 = (j37 >>> 48) & 21845;
                    long j39 = (j38 | (j38 >>> 1)) & 858993459;
                    long j40 = (j39 | (j39 >>> 2)) & 252645135;
                    long j41 = (j37 >>> 32) & 21845;
                    long j42 = ((j41 >>> 1) | j41) & 858993459;
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    long j44 = (((j40 | (j40 >>> 4)) & 16711935) << 24) | ((((j43 >>> 4) | j43) & 16711935) << 16);
                    long j45 = (j37 >>> 16) & 21845;
                    long j46 = ((j45 >>> 1) | j45) & 858993459;
                    long j47 = ((j46 >>> 2) | j46) & 252645135;
                    long j48 = j37 & 21845;
                    long j49 = (j48 | (j48 >>> 1)) & 858993459;
                    long j50 = ((j49 >>> 2) | j49) & 252645135;
                    bArr3[(int) (((j50 | (j50 >>> 4)) & 16711935) + ((((j47 >>> 4) | j47) & 16711935) << 8) + j44)] = -121;
                    bArr3[6] = 96;
                    bArr3[7] = -13;
                    bArr3[8] = 55;
                    bArr3[9] = -51;
                    bArr3[10] = 18;
                    bArr3[V2.a(-1874329080, -10680323, 1863648756) ^ (-1863648767)] = 111;
                    bArr3[12] = 35;
                    h(bArr2, bArr3);
                    throw new CertificateParsingException(new String(bArr2, StandardCharsets.UTF_8).intern());
                case 58766:
                    c4 = z3 ? (char) 2189 : (char) 47141;
                case 47141:
                    return new BigInteger(bArr);
                case 12576:
                    char c6 = 53708;
                    while (true) {
                        Object[] objArr2 = false;
                        while (true) {
                            switch (c6) {
                                case 58930:
                                    break;
                                case 44022:
                                    c6 = !z4 ? (char) 43060 : (char) 8595;
                                case 43060:
                                    c6 = 58930;
                                    objArr2 = true;
                                case 53708:
                                    if (c(10)) {
                                        c6 = 44022;
                                    }
                                case 8595:
                                    break;
                                default:
                            }
                            if (objArr2 == false) {
                                c4 = 40867;
                            }
                        }
                        c4 = 35444;
                        c6 = 58930;
                    }
                    break;
                case 61070:
                    c4 = 58766;
                    z3 = false;
                case 40867:
                    String j51 = j();
                    byte[] bArr4 = new byte[33];
                    bArr4[0] = 14;
                    bArr4[1] = -83;
                    bArr4[2] = 11;
                    bArr4[3] = -79;
                    bArr4[4] = -47;
                    bArr4[5] = 111;
                    bArr4[6] = 4;
                    bArr4[7] = -49;
                    bArr4[8] = -33;
                    bArr4[9] = -107;
                    bArr4[10] = 113;
                    bArr4[11] = 118;
                    bArr4[12] = -73;
                    bArr4[13] = -1;
                    bArr4[14] = 118;
                    bArr4[15] = -31;
                    bArr4[16] = -127;
                    bArr4[17] = 101;
                    bArr4[18] = -110;
                    bArr4[19] = -115;
                    bArr4[20] = 126;
                    bArr4[21] = 82;
                    long j52 = 6291819;
                    long j53 = -1;
                    long j54 = (((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j55 = (j54 >>> 48) & 43690;
                    long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
                    long j57 = ((j56 >>> 2) | j56) & 252645135;
                    long j58 = (j54 >>> 32) & 43690;
                    long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                    long j60 = ((j59 >>> 2) | j59) & 252645135;
                    long j61 = ((((j60 >>> 4) | j60) & 16711935) << 16) + ((((j57 >>> 4) | j57) & 16711935) << 24);
                    long j62 = (j54 >>> 16) & 43690;
                    long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    long j65 = j54 & 43690;
                    long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
                    long j67 = ((j66 >>> 2) | j66) & 252645135;
                    int i3 = ((int) ((((j67 >>> 4) | j67) & 16711935) + (((((j64 >>> 4) | j64) & 16711935) << 8) | j61))) - 536870780;
                    bArr4[((i3 & 530578950) * 2) + ((-530578951) - i3)] = 18;
                    bArr4[23] = 58;
                    bArr4[24] = 24;
                    bArr4[25] = 118;
                    bArr4[26] = -68;
                    bArr4[27] = -74;
                    bArr4[28] = 11;
                    bArr4[29] = 119;
                    bArr4[30] = -23;
                    bArr4[31] = 72;
                    bArr4[32] = -66;
                    int i4 = this.f290c;
                    int i5 = ((~i4) | (-572346107)) & 74326732;
                    int i6 = this.f288a;
                    h(bArr4, new byte[]{-25, -56, -23, 118, -42, 13, -45, 9, 27, -93, -79, -64, 94, -53, -63, 85, 82, 87, 82, 1433346758 ^ (i5 + (1359020080 | (((i6 | 1074594504) - (i4 | 1074594504)) + ((i4 - i6) + (i6 & 1074594504))))), -113, 96, -42, -103, -32, 68, 10, 56, -49, 35, 8, -98, -98});
                    throw new CertificateParsingException(AbstractC0008a.n(new String(bArr4, StandardCharsets.UTF_8).intern(), j51));
                case 35444:
                    c4 = bArr.length == 0 ? (char) 36352 : (char) 61070;
                case 36352:
                    c4 = 58766;
                    z3 = true;
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0059. Please report as an issue. */
    public final boolean b() {
        char c4 = 28557;
        boolean z3 = false;
        byte b4 = 0;
        while (true) {
            switch (c4) {
                case 5066:
                    c4 = 30718;
                    z3 = false;
                case 57541:
                    String j2 = j();
                    byte[] bArr = new byte[22];
                    bArr[0] = -86;
                    bArr[1] = -14;
                    bArr[2] = 13;
                    bArr[3] = 80;
                    bArr[4] = -45;
                    bArr[5] = 9;
                    long j3 = -1;
                    long j4 = 1;
                    long j5 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j6 = (j5 >>> 48) & 21845;
                    long j7 = ((j6 >>> 1) | j6) & 858993459;
                    long j8 = ((j7 >>> 2) | j7) & 252645135;
                    long j9 = (j5 >>> 32) & 21845;
                    long j10 = ((j9 >>> 1) | j9) & 858993459;
                    long j11 = ((j10 >>> 2) | j10) & 252645135;
                    long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) | ((((j8 >>> 4) | j8) & 16711935) << 24);
                    long j13 = (j5 >>> 16) & 21845;
                    long j14 = ((j13 >>> 1) | j13) & 858993459;
                    long j15 = ((j14 >>> 2) | j14) & 252645135;
                    long j16 = j5 & 21845;
                    long j17 = ((j16 >>> 1) | j16) & 858993459;
                    long j18 = ((j17 >>> 2) | j17) & 252645135;
                    int i = (((int) ((((j18 >>> 4) | j18) & 16711935) + (((((j15 >>> 4) | j15) & 16711935) << 8) | j12))) | (-897809775)) & 73760785;
                    long j19 = -2122313120;
                    long j20 = 0;
                    long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                    long j22 = (j21 >>> 48) & 43690;
                    long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                    long j24 = ((j23 >>> 2) | j23) & 252645135;
                    long j25 = (j21 >>> 32) & 43690;
                    long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                    long j27 = ((j26 >>> 2) | j26) & 252645135;
                    long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) | ((((j24 >>> 4) | j24) & 16711935) << 24);
                    long j29 = (j21 >>> 16) & 43690;
                    long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                    long j31 = ((j30 >>> 2) | j30) & 252645135;
                    long j32 = j21 & 43690;
                    long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                    long j34 = ((j33 >>> 2) | j33) & 252645135;
                    bArr[(i + ((int) ((((j34 >>> 4) | j34) & 16711935) | (((((j31 >>> 4) | j31) & 16711935) << 8) | j28)))) ^ (-2048552329)] = -26;
                    bArr[7] = 48;
                    bArr[8] = -88;
                    bArr[9] = -98;
                    bArr[10] = 115;
                    bArr[11] = 102;
                    bArr[12] = 92;
                    bArr[13] = 7;
                    bArr[14] = 51;
                    bArr[15] = -28;
                    bArr[16] = 16;
                    bArr[17] = -38;
                    bArr[18] = 101;
                    bArr[19] = -19;
                    bArr[20] = -52;
                    bArr[21] = 60;
                    long j35 = -1056422624;
                    long j36 = -1;
                    long j37 = (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j38 = (j37 >>> 48) & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    long j41 = (j37 >>> 32) & 43690;
                    long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) | ((((j40 >>> 4) | j40) & 16711935) << 24);
                    long j45 = (j37 >>> 16) & 43690;
                    long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                    long j47 = ((j46 >>> 2) | j46) & 252645135;
                    long j48 = j37 & 43690;
                    long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
                    long j50 = (j49 | (j49 >>> 2)) & 252645135;
                    int i3 = (int) (((j50 | (j50 >>> 4)) & 16711935) | (((((j47 >>> 4) | j47) & 16711935) << 8) + j44));
                    long j51 = -1054030342;
                    long j52 = (2392273 & i3) + (i3 | 2392273);
                    long j53 = ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                    long j64 = ((((j63 >>> 4) | j63) & 16711935) << 8) + j60;
                    long j65 = j53 & 21845;
                    long j66 = (j65 | (j65 >>> 1)) & 858993459;
                    long j67 = (j66 | (j66 >>> 2)) & 252645135;
                    e(bArr, new byte[]{(int) (((j67 | (j67 >>> 4)) & 16711935) + j64), -104, 15, -41, 20, -125, 50, -9, 108, -50, -86, -121, 76, -80, -27, 8, -104, -25, -80, 32, -72, 28});
                    throw new CertificateParsingException(AbstractC0008a.n(new String(bArr, StandardCharsets.UTF_8).intern(), j2));
                case 48593:
                case 15432:
                    c4 = 30718;
                    z3 = true;
                case 41071:
                    b4 = this.f291d[0];
                    c4 = b4 == 0 ? (char) 5066 : (char) 57047;
                case 52237:
                    c4 = this.f291d.length != 1 ? (char) 63841 : (char) 41071;
                case 28557:
                    c4 = !m() ? (char) 57541 : (char) 52237;
                case 30718:
                    return z3;
                case 65412:
                    c4 = 58918;
                case 63841:
                    byte[] bArr2 = {-79, -59, -53, 23, -2, 61, 42, -55, -95, -32, -67, -74, 110, -13, 121, 80, -83};
                    byte[] bArr3 = new byte[17];
                    bArr3[0] = 24;
                    bArr3[1] = -46;
                    bArr3[2] = 81;
                    bArr3[3] = 28;
                    bArr3[4] = -51;
                    bArr3[5] = 89;
                    long j68 = 545024;
                    long j69 = 1;
                    long j70 = (((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + ((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j71 = (j70 >>> 48) & 43690;
                    long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                    long j73 = (j72 | (j72 >>> 2)) & 252645135;
                    long j74 = (j70 >>> 32) & 43690;
                    long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                    long j76 = (j75 | (j75 >>> 2)) & 252645135;
                    long j77 = (((j76 | (j76 >>> 4)) & 16711935) << 16) + (((j73 | (j73 >>> 4)) & 16711935) << 24);
                    long j78 = (j70 >>> 16) & 43690;
                    long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                    long j80 = (j79 | (j79 >>> 2)) & 252645135;
                    long j81 = j70 & 43690;
                    long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                    long j83 = (j82 | (j82 >>> 2)) & 252645135;
                    bArr3[386422221 ^ (335561802 + (((int) (((j83 | (j83 >>> 4)) & 16711935) + ((((j80 | (j80 >>> 4)) & 16711935) << 8) + j77))) | 50860417))] = -15;
                    long j84 = -335246848;
                    long j85 = -2;
                    long j86 = (((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j87 = (j86 >>> 48) & 43690;
                    long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
                    long j89 = (j88 | (j88 >>> 2)) & 252645135;
                    long j90 = (j86 >>> 32) & 43690;
                    long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                    long j92 = (j91 | (j91 >>> 2)) & 252645135;
                    long j93 = (((j89 | (j89 >>> 4)) & 16711935) << 24) | (((j92 | (j92 >>> 4)) & 16711935) << 16);
                    long j94 = (j86 >>> 16) & 43690;
                    long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
                    long j96 = (j95 | (j95 >>> 2)) & 252645135;
                    long j97 = j86 & 43690;
                    long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                    long j99 = (j98 | (j98 >>> 2)) & 252645135;
                    bArr3[7] = (((int) (((j99 | (j99 >>> 4)) & 16711935) | ((((j96 | (j96 >>> 4)) & 16711935) << 8) + j93))) + 304218372) ^ (-31028406);
                    bArr3[8] = 33;
                    bArr3[9] = -18;
                    bArr3[10] = 109;
                    bArr3[11] = 86;
                    bArr3[12] = 93;
                    bArr3[13] = -83;
                    bArr3[14] = -82;
                    bArr3[15] = -13;
                    bArr3[16] = -29;
                    e(bArr2, bArr3);
                    throw new CertificateParsingException(new String(bArr2, StandardCharsets.UTF_8).intern());
                case 58918:
                    byte[] bArr4 = new byte[59];
                    bArr4[0] = 53;
                    bArr4[1] = -24;
                    bArr4[2] = 14;
                    bArr4[3] = -46;
                    bArr4[4] = 62;
                    bArr4[5] = 45;
                    bArr4[6] = -34;
                    bArr4[7] = 114;
                    bArr4[8] = -31;
                    long j100 = -893790197;
                    long j101 = -1;
                    long j102 = (((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j101 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j101 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j101 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j101 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j103 = (j102 >>> 48) & 43690;
                    long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
                    long j105 = ((j104 >>> 2) | j104) & 252645135;
                    long j106 = (j102 >>> 32) & 43690;
                    long j107 = ((j106 >>> 2) | (j106 >>> 1)) & 858993459;
                    long j108 = ((j107 >>> 2) | j107) & 252645135;
                    long j109 = ((((j108 >>> 4) | j108) & 16711935) << 16) + ((((j105 >>> 4) | j105) & 16711935) << 24);
                    long j110 = (j102 >>> 16) & 43690;
                    long j111 = ((j110 >>> 2) | (j110 >>> 1)) & 858993459;
                    long j112 = ((j111 >>> 2) | j111) & 252645135;
                    long j113 = j102 & 43690;
                    long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
                    long j115 = ((j114 >>> 2) | j114) & 252645135;
                    bArr4[(((int) ((((j115 >>> 4) | j115) & 16711935) | (((((j112 >>> 4) | j112) & 16711935) << 8) | j109))) + 608437012) ^ (-285353194)] = -5;
                    bArr4[10] = 102;
                    bArr4[11] = 58;
                    bArr4[12] = 23;
                    bArr4[13] = Byte.MAX_VALUE;
                    bArr4[14] = -18;
                    bArr4[15] = -17;
                    bArr4[16] = -64;
                    bArr4[17] = -9;
                    bArr4[18] = -102;
                    bArr4[19] = 126;
                    bArr4[20] = -88;
                    bArr4[21] = -113;
                    bArr4[22] = -127;
                    bArr4[23] = -43;
                    bArr4[24] = -48;
                    bArr4[25] = -90;
                    bArr4[26] = 82;
                    bArr4[27] = -18;
                    bArr4[28] = 120;
                    bArr4[29] = 57;
                    bArr4[30] = -30;
                    bArr4[31] = 53;
                    bArr4[32] = -61;
                    bArr4[33] = -5;
                    bArr4[34] = -19;
                    bArr4[35] = -94;
                    bArr4[36] = 52;
                    bArr4[37] = -57;
                    long j116 = -1054727164;
                    long j117 = 1;
                    long j118 = (((((j117 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j119 = (((((((j117 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j120 = (((((((j117 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j121 = (((((((j117 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j122 = (((((((((j116 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j116 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j116 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j116 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j121 | (j120 + (j119 | j118)));
                    long j123 = (j122 >>> 48) & 43690;
                    long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                    long j125 = ((j124 >>> 2) | j124) & 252645135;
                    long j126 = (j122 >>> 32) & 43690;
                    long j127 = ((j126 >>> 2) | (j126 >>> 1)) & 858993459;
                    long j128 = ((j127 >>> 2) | j127) & 252645135;
                    long j129 = ((((j128 >>> 4) | j128) & 16711935) << 16) | ((((j125 >>> 4) | j125) & 16711935) << 24);
                    long j130 = (j122 >>> 16) & 43690;
                    long j131 = ((j130 >>> 2) | (j130 >>> 1)) & 858993459;
                    long j132 = ((j131 >>> 2) | j131) & 252645135;
                    long j133 = j122 & 43690;
                    long j134 = ((j133 >>> 2) | (j133 >>> 1)) & 858993459;
                    long j135 = ((j134 >>> 2) | j134) & 252645135;
                    bArr4[38] = (-450726703) ^ (18895023 + (((int) ((((j135 >>> 4) | j135) & 16711935) + (((((j132 >>> 4) | j132) & 16711935) << 8) | j129))) | (-469621696)));
                    long j136 = -1672069118;
                    long j137 = -1;
                    long j138 = (((((((((j136 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j136 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j136 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j136 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j137 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j137 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j137 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j137 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j139 = (j138 >>> 48) & 43690;
                    long j140 = ((j139 >>> 2) | (j139 >>> 1)) & 858993459;
                    long j141 = ((j140 >>> 2) | j140) & 252645135;
                    long j142 = (j138 >>> 32) & 43690;
                    long j143 = ((j142 >>> 2) | (j142 >>> 1)) & 858993459;
                    long j144 = ((j143 >>> 2) | j143) & 252645135;
                    long j145 = ((((j144 >>> 4) | j144) & 16711935) << 16) | ((((j141 >>> 4) | j141) & 16711935) << 24);
                    long j146 = (j138 >>> 16) & 43690;
                    long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
                    long j148 = ((j147 >>> 2) | j147) & 252645135;
                    long j149 = j138 & 43690;
                    long j150 = ((j149 >>> 2) | (j149 >>> 1)) & 858993459;
                    long j151 = ((j150 >>> 2) | j150) & 252645135;
                    bArr4[39] = (((int) ((((j151 >>> 4) | j151) & 16711935) | (((((j148 >>> 4) | j148) & 16711935) << 8) | j145))) + 50403496) ^ (-1621665568);
                    bArr4[40] = 51;
                    bArr4[41] = 28;
                    bArr4[42] = -88;
                    bArr4[43] = -51;
                    bArr4[44] = 89;
                    bArr4[45] = -40;
                    long j152 = 392277585;
                    long j153 = 392277631;
                    long j154 = (((((((((j152 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j152 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j152 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j152 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j153 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j153 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j153 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j153 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j155 = (j154 >>> 48) & 21845;
                    long j156 = ((j155 >>> 1) | j155) & 858993459;
                    long j157 = ((j156 >>> 2) | j156) & 252645135;
                    long j158 = (j154 >>> 32) & 21845;
                    long j159 = ((j158 >>> 1) | j158) & 858993459;
                    long j160 = ((j159 >>> 2) | j159) & 252645135;
                    long j161 = ((((j160 >>> 4) | j160) & 16711935) << 16) + ((((j157 >>> 4) | j157) & 16711935) << 24);
                    long j162 = (j154 >>> 16) & 21845;
                    long j163 = ((j162 >>> 1) | j162) & 858993459;
                    long j164 = ((j163 >>> 2) | j163) & 252645135;
                    long j165 = j154 & 21845;
                    long j166 = ((j165 >>> 1) | j165) & 858993459;
                    long j167 = ((j166 >>> 2) | j166) & 252645135;
                    bArr4[(int) ((((j167 >>> 4) | j167) & 16711935) | ((((j164 >>> 4) | j164) & 16711935) << 8) | j161)] = -74;
                    bArr4[47] = -76;
                    bArr4[48] = 13;
                    bArr4[49] = -51;
                    bArr4[50] = 93;
                    bArr4[51] = -23;
                    bArr4[52] = -14;
                    bArr4[53] = -65;
                    bArr4[54] = -79;
                    bArr4[55] = -44;
                    bArr4[56] = -115;
                    bArr4[57] = 82;
                    bArr4[58] = -125;
                    byte[] bArr5 = new byte[59];
                    bArr5[0] = -99;
                    bArr5[1] = -112;
                    bArr5[2] = -46;
                    bArr5[3] = 25;
                    bArr5[4] = -121;
                    bArr5[5] = 116;
                    bArr5[6] = 51;
                    bArr5[7] = -70;
                    bArr5[8] = -31;
                    bArr5[9] = -116;
                    bArr5[10] = -68;
                    bArr5[11] = -68;
                    bArr5[12] = -39;
                    bArr5[13] = 3;
                    bArr5[14] = 15;
                    bArr5[15] = 62;
                    bArr5[16] = 1;
                    bArr5[17] = -124;
                    bArr5[18] = 98;
                    bArr5[19] = -63;
                    bArr5[20] = 58;
                    bArr5[21] = 28;
                    bArr5[22] = -97;
                    bArr5[23] = 66;
                    bArr5[24] = 17;
                    bArr5[25] = -25;
                    bArr5[26] = -28;
                    bArr5[27] = 61;
                    bArr5[28] = 105;
                    bArr5[29] = 84;
                    bArr5[30] = 32;
                    bArr5[31] = -72;
                    bArr5[32] = 4;
                    bArr5[33] = -122;
                    bArr5[34] = 49;
                    long j168 = -1;
                    long j169 = ((((((((j168 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j168 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j168 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j168 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j121 | j120 | (j119 + j118));
                    long j170 = (j169 >>> 48) & 21845;
                    long j171 = (j170 | (j170 >>> 1)) & 858993459;
                    long j172 = (j171 | (j171 >>> 2)) & 252645135;
                    long j173 = (j169 >>> 32) & 21845;
                    long j174 = ((j173 >>> 1) | j173) & 858993459;
                    long j175 = ((j174 >>> 2) | j174) & 252645135;
                    long j176 = (((j172 | (j172 >>> 4)) & 16711935) << 24) | ((((j175 >>> 4) | j175) & 16711935) << 16);
                    long j177 = (j169 >>> 16) & 21845;
                    long j178 = ((j177 >>> 1) | j177) & 858993459;
                    long j179 = ((j178 >>> 2) | j178) & 252645135;
                    long j180 = j169 & 21845;
                    long j181 = (j180 | (j180 >>> 1)) & 858993459;
                    long j182 = (j181 | (j181 >>> 2)) & 252645135;
                    int i4 = (int) (j176 | ((((j179 >>> 4) | j179) & 16711935) << 8) | ((j182 | (j182 >>> 4)) & 16711935));
                    int i5 = (542641561 & (109365624 + i4 + (((-i4) - 1) | (-109365624)))) + 2130018;
                    bArr5[(((~i5) & 544771544) - (544771544 & i5)) + i5] = 113;
                    bArr5[36] = -71;
                    bArr5[37] = -35;
                    long j183 = 336864396;
                    long j184 = -2;
                    long j185 = (((((((((j183 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j183 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j183 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j183 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j184 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j184 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j184 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j184 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j186 = (j185 >>> 48) & 43690;
                    long j187 = ((j186 >>> 2) | (j186 >>> 1)) & 858993459;
                    long j188 = (j187 | (j187 >>> 2)) & 252645135;
                    long j189 = (j185 >>> 32) & 43690;
                    long j190 = ((j189 >>> 2) | (j189 >>> 1)) & 858993459;
                    long j191 = ((j190 >>> 2) | j190) & 252645135;
                    long j192 = (((j188 | (j188 >>> 4)) & 16711935) << 24) | ((((j191 >>> 4) | j191) & 16711935) << 16);
                    long j193 = (j185 >>> 16) & 43690;
                    long j194 = ((j193 >>> 2) | (j193 >>> 1)) & 858993459;
                    long j195 = ((j194 >>> 2) | j194) & 252645135;
                    long j196 = j185 & 43690;
                    long j197 = ((j196 >>> 2) | (j196 >>> 1)) & 858993459;
                    long j198 = (j197 | (j197 >>> 2)) & 252645135;
                    int i6 = (int) (((j198 | (j198 >>> 4)) & 16711935) | j192 | ((((j195 >>> 4) | j195) & 16711935) << 8));
                    long j199 = -1012737182;
                    long j200 = ((i6 & 675872816) * 2) + (675872816 ^ i6);
                    long j201 = ((((((((j199 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j199 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j199 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j199 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j200 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j200 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j200 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j200 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j202 = (j201 >>> 48) & 21845;
                    long j203 = (j202 | (j202 >>> 1)) & 858993459;
                    long j204 = (j203 | (j203 >>> 2)) & 252645135;
                    long j205 = (j201 >>> 32) & 21845;
                    long j206 = ((j205 >>> 1) | j205) & 858993459;
                    long j207 = ((j206 >>> 2) | j206) & 252645135;
                    long j208 = ((((j207 >>> 4) | j207) & 16711935) << 16) + (((j204 | (j204 >>> 4)) & 16711935) << 24);
                    long j209 = (j201 >>> 16) & 21845;
                    long j210 = ((j209 >>> 1) | j209) & 858993459;
                    long j211 = ((j210 >>> 2) | j210) & 252645135;
                    long j212 = j201 & 21845;
                    long j213 = ((j212 >>> 1) | j212) & 858993459;
                    long j214 = (j213 | (j213 >>> 2)) & 252645135;
                    bArr5[38] = (int) (((j214 | (j214 >>> 4)) & 16711935) + ((((j211 >>> 4) | j211) & 16711935) << 8) + j208);
                    bArr5[39] = -116;
                    bArr5[40] = -78;
                    bArr5[41] = 96;
                    bArr5[42] = 110;
                    bArr5[43] = 88;
                    bArr5[44] = -104;
                    bArr5[45] = -73;
                    bArr5[46] = 8;
                    bArr5[47] = 39;
                    bArr5[48] = -55;
                    bArr5[49] = -118;
                    bArr5[50] = -1;
                    bArr5[51] = 107;
                    bArr5[52] = -7;
                    bArr5[53] = -33;
                    bArr5[54] = 3;
                    bArr5[55] = 7;
                    bArr5[56] = -11;
                    bArr5[57] = 20;
                    bArr5[58] = -59;
                    e(bArr4, bArr5);
                    throw new CertificateParsingException(new String(bArr4, StandardCharsets.UTF_8).intern());
                case 57047:
                    c4 = b4 == -1 ? (char) 48593 : (char) 65412;
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0008. Please report as an issue. */
    public final boolean c(int i) {
        char c4 = 9758;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 12114:
                    if (this.f290c == i) {
                        c4 = 8042;
                    } else {
                        c4 = 34517;
                    }
                case 34517:
                    z3 = false;
                    c4 = 7564;
                case 9758:
                    if (this.f288a == 0) {
                        c4 = 12114;
                    } else {
                        c4 = 34517;
                    }
                case 8042:
                    z3 = true;
                    c4 = 7564;
                case 7564:
                    break;
                default:
                    c4 = 34517;
            }
            return z3;
        }
    }

    public final int d() {
        BigInteger bigInteger = null;
        while (true) {
            char c4 = 42271;
            while (c4 != 30285) {
                if (c4 != 44484) {
                    if (c4 != 42271) {
                        if (c4 != 26659) {
                            break;
                        }
                        if (bigInteger.compareTo(BigInteger.valueOf(2147483647L)) <= 0) {
                            c4 = 44484;
                        } else {
                            c4 = 30285;
                        }
                    } else {
                        bigInteger = a();
                        if (bigInteger.compareTo(BigInteger.ZERO) >= 0) {
                            c4 = 26659;
                        } else {
                            c4 = 30285;
                        }
                    }
                } else {
                    return bigInteger.intValue();
                }
            }
            byte[] bArr = {-105, 86, 32, 71, 86, -27, 122, -71, -55, 85, 61, 53, 102, -62, -41, -13, 14, -13, -22, 51, E1.a(-97, -846014827, 846014730)};
            int i = this.f288a;
            h(bArr, new byte[]{122, 109, -26, -32, -67, -41, -66, 59, -38, 54, -37, -73, 117, (-1558957113) ^ ((((~i) | (-1845530154)) & 1289817153) + ((i & 1275104257) | 269139984)), 69, 55, 29, -112, 10, -11, -20});
            throw new CertificateParsingException(new String(bArr, StandardCharsets.UTF_8).intern());
        }
    }

    public final ArrayList g() {
        if (p()) {
            return AbstractC0105y1.b(this.f291d);
        }
        String j2 = j();
        long j3 = -1;
        long j4 = 2;
        long j5 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
        int i = ((int) ((((j18 >>> 4) | j18) & 16711935) + (((((j15 >>> 4) | j15) & 16711935) << 8) | j12))) | (-1406729515);
        long j19 = 1770435776;
        long j20 = i;
        long j21 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j22 = (j21 >>> 48) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = (j21 >>> 32) & 43690;
        long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
        long j27 = ((j26 >>> 2) | j26) & 252645135;
        long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) | ((((j24 >>> 4) | j24) & 16711935) << 24);
        long j29 = (j21 >>> 16) & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        long j32 = j21 & 43690;
        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
        long j34 = ((j33 >>> 2) | j33) & 252645135;
        int i3 = ((int) ((((j34 >>> 4) | j34) & 16711935) + (((((j31 >>> 4) | j31) & 16711935) << 8) | j28))) + 38862873;
        byte[] bArr = {41, 9, -75, -51, -62, -63, -66, -43, 125, -110, -107, -95, -11, -94, -120, 38, 73, B0.a((~i3) | 1809298638, 1809298638 - i3), 119, -97, 84, -97, 62};
        byte[] bArr2 = new byte[23];
        bArr2[0] = 85;
        bArr2[1] = -95;
        bArr2[2] = -81;
        bArr2[3] = -63;
        bArr2[4] = -118;
        bArr2[5] = -27;
        bArr2[6] = -59;
        bArr2[7] = -54;
        long j35 = -1593769968;
        long j36 = 12;
        long j37 = (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j38 = (j37 >>> 48) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = (j39 | (j39 >>> 2)) & 252645135;
        long j41 = (j37 >>> 32) & 43690;
        long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
        long j43 = (j42 | (j42 >>> 2)) & 252645135;
        long j44 = (((j40 | (j40 >>> 4)) & 16711935) << 24) | (((j43 | (j43 >>> 4)) & 16711935) << 16);
        long j45 = (j37 >>> 16) & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        long j48 = j37 & 43690;
        long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
        long j50 = (j49 | (j49 >>> 2)) & 252645135;
        bArr2[(-1514056686) ^ ((-1543420918) + (((int) (((j50 | (j50 >>> 4)) & 16711935) | ((((j47 | (j47 >>> 4)) & 16711935) << 8) + j44))) | 29364240))] = 70;
        bArr2[9] = -15;
        bArr2[10] = -70;
        bArr2[11] = 9;
        bArr2[12] = -119;
        bArr2[13] = 23;
        bArr2[14] = -79;
        bArr2[15] = 126;
        bArr2[16] = -11;
        bArr2[17] = 106;
        bArr2[18] = 65;
        bArr2[19] = 17;
        bArr2[20] = 59;
        bArr2[21] = -21;
        bArr2[22] = 30;
        f(bArr, bArr2);
        throw new CertificateParsingException(AbstractC0008a.n(new String(bArr, StandardCharsets.UTF_8).intern(), j2));
    }

    public final ArrayList i() {
        if (q()) {
            return AbstractC0105y1.b(this.f291d);
        }
        String j2 = j();
        byte[] bArr = new byte[18];
        bArr[0] = -47;
        bArr[1] = -38;
        bArr[2] = -63;
        bArr[3] = -87;
        long j3 = 136331329;
        long j4 = 2;
        long j5 = (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        bArr[(-1079353017) ^ ((-1215684352) + ((int) ((((j18 >>> 4) | j18) & 16711935) + (((((j15 >>> 4) | j15) & 16711935) << 8) | j12))))] = 102;
        bArr[5] = 76;
        bArr[6] = -12;
        bArr[7] = -85;
        bArr[8] = 75;
        bArr[9] = 54;
        bArr[10] = 39;
        bArr[11] = 104;
        bArr[12] = -6;
        bArr[13] = -47;
        bArr[14] = -44;
        bArr[15] = -67;
        bArr[16] = -14;
        bArr[17] = 105;
        byte[] bArr2 = new byte[18];
        bArr2[0] = 56;
        bArr2[1] = -65;
        bArr2[2] = 35;
        bArr2[3] = 110;
        boolean z3 = this.f289b;
        int i = ~(z3 ? 1 : 0);
        int i3 = ((i | 1003116350) & (-1438209531)) + (((z3 ? 1 : 0) & (-2138788719)) | 75564432);
        bArr2[4] = (i3 - 1362645004) - ((i3 & (-1362645004)) * 2);
        bArr2[5] = 46;
        bArr2[6] = 35;
        int i4 = this.f290c;
        long j19 = -1395198341;
        long j20 = ~i4;
        long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j22 = (j21 >>> 48) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = (j23 | (j23 >>> 2)) & 252645135;
        long j25 = (j21 >>> 32) & 43690;
        long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
        long j27 = ((j26 >>> 2) | j26) & 252645135;
        long j28 = (((j24 | (j24 >>> 4)) & 16711935) << 24) | ((((j27 >>> 4) | j27) & 16711935) << 16);
        long j29 = (j21 >>> 16) & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        long j32 = j21 & 43690;
        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
        long j34 = (j33 | (j33 >>> 2)) & 252645135;
        int i5 = (int) (((j34 | (j34 >>> 4)) & 16711935) + (j28 | ((((j31 >>> 4) | j31) & 16711935) << 8)));
        long j35 = 1338890836;
        long j36 = (((1098995744 & i4) + 42488360) - (i4 & 8409120)) + ((i5 + 1296402449) - (i5 | 1296402449));
        long j37 = (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j38 = (j37 >>> 48) & 21845;
        long j39 = (j38 | (j38 >>> 1)) & 858993459;
        long j40 = (j39 | (j39 >>> 2)) & 252645135;
        long j41 = (j37 >>> 32) & 21845;
        long j42 = ((j41 >>> 1) | j41) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        long j44 = (((j40 | (j40 >>> 4)) & 16711935) << 24) | ((((j43 >>> 4) | j43) & 16711935) << 16);
        long j45 = (j37 >>> 16) & 21845;
        long j46 = ((j45 >>> 1) | j45) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        long j48 = j37 & 21845;
        long j49 = (j48 | (j48 >>> 1)) & 858993459;
        long j50 = (j49 | (j49 >>> 2)) & 252645135;
        bArr2[7] = (int) (((j50 | (j50 >>> 4)) & 16711935) + (j44 | ((((j47 >>> 4) | j47) & 16711935) << 8)));
        bArr2[8] = -113;
        bArr2[9] = 118;
        bArr2[10] = -112;
        bArr2[11] = -34;
        bArr2[12] = 42;
        int i6 = ~(((285254728 & (z3 ? 1 : 0)) ^ 29492225) + ((z3 ? 1 : 0) & 16778240));
        int i7 = -(((-1896129774) | i) & (-1876840374));
        bArr2[V2.a(~i7, i6, (i6 + i7) + 1) ^ (-1847348154)] = -36;
        bArr2[14] = 13;
        bArr2[15] = 108;
        bArr2[16] = -122;
        bArr2[17] = 73;
        h(bArr, bArr2);
        throw new CertificateParsingException(AbstractC0008a.n(new String(bArr, StandardCharsets.UTF_8).intern(), j2));
    }

    public final String j() {
        int i;
        char c4;
        int i3;
        char c5;
        long j2;
        long j3;
        int i4;
        int i5;
        String intern;
        char c6;
        String str;
        char c7;
        String str2;
        String str3;
        int i6 = this.f290c;
        int i7 = this.f288a;
        if (i7 != 0) {
            if (i7 != 1) {
                i = 2;
                if (i7 != 2) {
                    if (i7 != 3) {
                        j2 = 6148914691236517205L;
                        byte[] bArr = {-22};
                        f(bArr, new byte[]{-43, -82, -45, -114, 119, -42, -11, -68});
                        str3 = new String(bArr, StandardCharsets.UTF_8);
                    } else {
                        j2 = 6148914691236517205L;
                        byte[] bArr2 = {94, -72, 15, -78, -32, 99, 34};
                        f(bArr2, new byte[]{-9, 25, 49, -3, -95, 55, 103, -14});
                        str3 = new String(bArr2, StandardCharsets.UTF_8);
                    }
                    intern = str3.intern();
                    i4 = 8;
                    i5 = i6;
                    c4 = 7;
                    i3 = 3;
                    c5 = 5;
                    j3 = 43690;
                } else {
                    j2 = 6148914691236517205L;
                    byte[] bArr3 = {-77, -50, 19, -10, -55, 13, 83};
                    c7 = 7;
                    i3 = 3;
                    j3 = 43690;
                    long j4 = -2113403263;
                    c5 = 5;
                    long j5 = 0;
                    long j6 = (((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j7 = (j6 >>> 48) & 43690;
                    long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                    long j9 = ((j8 >>> 2) | j8) & 252645135;
                    long j10 = (j6 >>> 32) & 43690;
                    long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
                    long j12 = ((j11 >>> 2) | j11) & 252645135;
                    long j13 = ((((j12 >>> 4) | j12) & 16711935) << 16) | ((((j9 >>> 4) | j9) & 16711935) << 24);
                    long j14 = (j6 >>> 16) & 43690;
                    long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                    long j16 = ((j15 >>> 2) | j15) & 252645135;
                    long j17 = j6 & 43690;
                    long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
                    long j19 = ((j18 >>> 2) | j18) & 252645135;
                    f(bArr3, new byte[]{(((((-1) - i7) | (-1261620080)) & (-1597402352)) + ((i7 & 402965380) | 436617348)) ^ 1160784973, -79, 71, -69, -116, (-1502808336) ^ (610594852 + ((int) ((((((j16 >>> 4) | j16) & 16711935) << 8) | j13) | (((j19 >>> 4) | j19) & 16711935)))), 7, 103});
                    str2 = new String(bArr3, StandardCharsets.UTF_8);
                }
            } else {
                i = 2;
                c7 = 7;
                i3 = 3;
                c5 = 5;
                j2 = 6148914691236517205L;
                j3 = 43690;
                long j20 = -1;
                long j21 = 1;
                long j22 = ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j23 = (j22 >>> 48) & 21845;
                long j24 = (j23 | (j23 >>> 1)) & 858993459;
                long j25 = (j24 | (j24 >>> 2)) & 252645135;
                long j26 = (j22 >>> 32) & 21845;
                long j27 = ((j26 >>> 1) | j26) & 858993459;
                long j28 = ((j27 >>> 2) | j27) & 252645135;
                long j29 = (((j25 | (j25 >>> 4)) & 16711935) << 24) | ((((j28 >>> 4) | j28) & 16711935) << 16);
                long j30 = (j22 >>> 16) & 21845;
                long j31 = ((j30 >>> 1) | j30) & 858993459;
                long j32 = ((j31 >>> 2) | j31) & 252645135;
                long j33 = j22 & 21845;
                long j34 = (j33 | (j33 >>> 1)) & 858993459;
                long j35 = (j34 | (j34 >>> 2)) & 252645135;
                int i8 = (int) (((j35 | (j35 >>> 4)) & 16711935) + ((((j32 >>> 4) | j32) & 16711935) << 8) + j29);
                byte[] bArr4 = {107, -60, (((i8 | 1945581541) - ((1383217124 | i8) ^ 597102689)) + 1140893705) ^ (-1737996333), 85, 77, 52, 50, -92, -27, -40, -11};
                long j36 = -1742733312;
                long j37 = 12;
                long j38 = (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j39 = (j38 >>> 48) & 43690;
                long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                long j41 = ((j40 >>> 2) | j40) & 252645135;
                long j42 = (j38 >>> 32) & 43690;
                long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
                long j44 = ((j43 >>> 2) | j43) & 252645135;
                long j45 = ((((j44 >>> 4) | j44) & 16711935) << 16) | ((((j41 >>> 4) | j41) & 16711935) << 24);
                long j46 = (j38 >>> 16) & 43690;
                long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
                long j48 = ((j47 >>> 2) | j47) & 252645135;
                long j49 = ((((j48 >>> 4) | j48) & 16711935) << 8) + j45;
                long j50 = j38 & 43690;
                long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
                long j52 = (j51 | (j51 >>> 2)) & 252645135;
                byte[] bArr5 = new byte[(-651917034) ^ (1476657429 + (((int) (((j52 | (j52 >>> 4)) & 16711935) + j49)) | (-2128574456)))];
                bArr5[0] = 19;
                bArr5[1] = -60;
                bArr5[2] = -44;
                bArr5[3] = 50;
                bArr5[4] = -19;
                long j53 = -852739761;
                long j54 = 852739817;
                long j55 = (((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j56 = (j55 >>> 48) & 21845;
                long j57 = ((j56 >>> 1) | j56) & 858993459;
                long j58 = ((j57 >>> 2) | j57) & 252645135;
                long j59 = (j55 >>> 32) & 21845;
                long j60 = ((j59 >>> 1) | j59) & 858993459;
                long j61 = ((j60 >>> 2) | j60) & 252645135;
                long j62 = ((((j61 >>> 4) | j61) & 16711935) << 16) + ((((j58 >>> 4) | j58) & 16711935) << 24);
                long j63 = (j55 >>> 16) & 21845;
                long j64 = ((j63 >>> 1) | j63) & 858993459;
                long j65 = ((j64 >>> 2) | j64) & 252645135;
                long j66 = j55 & 21845;
                long j67 = ((j66 >>> 1) | j66) & 858993459;
                long j68 = ((j67 >>> 2) | j67) & 252645135;
                bArr5[5] = (int) ((((j68 >>> 4) | j68) & 16711935) + ((((j65 >>> 4) | j65) & 16711935) << 8) + j62);
                bArr5[6] = 93;
                bArr5[7] = 9;
                bArr5[8] = -84;
                bArr5[9] = -105;
                bArr5[10] = -69;
                f(bArr4, bArr5);
                str2 = new String(bArr4, StandardCharsets.UTF_8);
            }
            intern = str2.intern();
            i4 = 8;
            i5 = i6;
            c4 = c7;
        } else {
            i = 2;
            c4 = 7;
            i3 = 3;
            c5 = 5;
            j2 = 6148914691236517205L;
            j3 = 43690;
            byte[] bArr6 = {44, 119, 61, -23, 48, -72, 5, -68, 13};
            long j69 = -1925684096;
            long j70 = -17;
            long j71 = ((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j72 = (j71 >>> 48) & 43690;
            long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
            long j74 = ((j73 >>> 2) | j73) & 252645135;
            long j75 = (j71 >>> 32) & 43690;
            long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
            long j77 = ((j76 >>> 2) | j76) & 252645135;
            long j78 = ((((j77 >>> 4) | j77) & 16711935) << 16) + ((((j74 >>> 4) | j74) & 16711935) << 24);
            long j79 = (j71 >>> 16) & 43690;
            long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
            long j81 = ((j80 >>> 2) | j80) & 252645135;
            long j82 = j71 & 43690;
            long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
            long j84 = ((j83 >>> 2) | j83) & 252645135;
            byte b4 = (((int) ((((j84 >>> 4) | j84) & 16711935) | (((((j81 >>> 4) | j81) & 16711935) << 8) | j78))) + 1115752991) ^ (-809931071);
            long j85 = 4203172;
            i4 = 8;
            i5 = i6;
            long j86 = 545788452 & i6;
            long b5 = c3.b((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j86 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j86 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j86 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j86 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
            long j87 = (b5 >>> 48) & 43690;
            long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
            long j89 = ((j88 >>> 2) | j88) & 252645135;
            long j90 = (b5 >>> 32) & 43690;
            long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
            long j92 = ((j91 >>> 2) | j91) & 252645135;
            long j93 = ((((j92 >>> 4) | j92) & 16711935) << 16) | ((((j89 >>> 4) | j89) & 16711935) << 24);
            long j94 = (b5 >>> 16) & 43690;
            long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
            long j96 = ((j95 >>> 2) | j95) & 252645135;
            long j97 = b5 & 43690;
            long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
            long j99 = ((j98 >>> 2) | j98) & 252645135;
            int i9 = ((((-1) - i6) | (-549107144)) & (-427290600)) + ((int) ((((j99 >>> 4) | j99) & 16711935) + (((((j96 >>> 4) | j96) & 16711935) << 8) | j93)));
            f(bArr6, new byte[]{98, 105, b4, -40, 94, 26, 65, 22, E1.a(i9 | (-423087363), -423087363, i9)});
            intern = new String(bArr6, StandardCharsets.UTF_8).intern();
        }
        boolean z3 = this.f289b;
        if (z3) {
            byte[] bArr7 = new byte[11];
            long j100 = -1;
            long j101 = i3;
            long j102 = ((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j100 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j103 = ((((((((j101 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j101 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j101 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j101 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j102;
            long j104 = (j103 >>> 48) & 21845;
            long j105 = ((j104 >>> 1) | j104) & 858993459;
            long j106 = ((j105 >>> i) | j105) & 252645135;
            long j107 = (j103 >>> 32) & 21845;
            long j108 = ((j107 >>> 1) | j107) & 858993459;
            long j109 = ((j108 >>> i) | j108) & 252645135;
            long j110 = ((((j109 >>> 4) | j109) & 16711935) << 16) | ((((j106 >>> 4) | j106) & 16711935) << 24);
            long j111 = (j103 >>> 16) & 21845;
            long j112 = ((j111 >>> 1) | j111) & 858993459;
            long j113 = ((j112 >>> i) | j112) & 252645135;
            long j114 = j103 & 21845;
            long j115 = ((j114 >>> 1) | j114) & 858993459;
            long j116 = ((j115 >>> i) | j115) & 252645135;
            int i10 = (int) ((((j116 >>> 4) | j116) & 16711935) | ((((j113 >>> 4) | j113) & 16711935) << i4) | j110);
            int i11 = (((z3 ? 1 : 0) | 557077281) - (i10 | (-1447134411))) + (((-2002896075) | i10) - (z3 ? 1 : 0)) + ((z3 ? 1 : 0) & 557077281) + 1543669888;
            long j117 = 2100747169;
            c6 = 0;
            long j118 = i11;
            long j119 = (((((((((j117 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j117 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j117 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j117 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j118 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j118 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j118 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j118 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j120 = (j119 >>> 48) & 21845;
            long j121 = ((j120 >>> 1) | j120) & 858993459;
            long j122 = ((j121 >>> i) | j121) & 252645135;
            long j123 = (j119 >>> 32) & 21845;
            long j124 = ((j123 >>> 1) | j123) & 858993459;
            long j125 = ((j124 >>> i) | j124) & 252645135;
            long j126 = ((((j125 >>> 4) | j125) & 16711935) << 16) + ((((j122 >>> 4) | j122) & 16711935) << 24);
            long j127 = (j119 >>> 16) & 21845;
            long j128 = ((j127 >>> 1) | j127) & 858993459;
            long j129 = ((j128 >>> i) | j128) & 252645135;
            long j130 = j119 & 21845;
            long j131 = ((j130 >>> 1) | j130) & 858993459;
            long j132 = ((j131 >>> i) | j131) & 252645135;
            bArr7[(int) ((((((j129 >>> 4) | j129) & 16711935) << i4) + j126) | (((j132 >>> 4) | j132) & 16711935))] = -54;
            long j133 = -1198723147;
            long j134 = (((((((((j133 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j133 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j133 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j133 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j102 + j2;
            long j135 = (j134 >>> 48) & j3;
            long j136 = ((j135 >>> i) | (j135 >>> 1)) & 858993459;
            long j137 = (j136 | (j136 >>> i)) & 252645135;
            long j138 = (j134 >>> 32) & j3;
            long j139 = ((j138 >>> i) | (j138 >>> 1)) & 858993459;
            long j140 = ((j139 >>> i) | j139) & 252645135;
            long j141 = ((((j140 >>> 4) | j140) & 16711935) << 16) + (((j137 | (j137 >>> 4)) & 16711935) << 24);
            long j142 = (j134 >>> 16) & j3;
            long j143 = ((j142 >>> i) | (j142 >>> 1)) & 858993459;
            long j144 = ((j143 >>> i) | j143) & 252645135;
            long j145 = j134 & j3;
            long j146 = ((j145 >>> i) | (j145 >>> 1)) & 858993459;
            long j147 = (j146 | (j146 >>> i)) & 252645135;
            bArr7[D.a(1008796556, 3, -(i | D1.a(1008796556, 60573730)), 1) ^ 1069370287] = ((((int) (((j147 | (j147 >>> 4)) & 16711935) + (((((j144 >>> 4) | j144) & 16711935) << i4) | j141))) & (-2144804827)) + 788529346) ^ 1356275476;
            bArr7[i] = -19;
            bArr7[3] = -2;
            bArr7[4] = -1;
            bArr7[c5] = -113;
            bArr7[6] = -65;
            bArr7[c4] = -62;
            bArr7[i4] = -97;
            bArr7[9] = 11;
            bArr7[10] = 58;
            byte[] bArr8 = new byte[11];
            bArr8[0] = -110;
            long j148 = 546374404;
            long j149 = i7 & 1687257432;
            long j150 = (((((((((j148 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j148 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j148 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j148 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j149 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j149 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j149 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j149 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j2;
            long j151 = (j150 >>> 48) & j3;
            long j152 = ((j151 >>> i) | (j151 >>> 1)) & 858993459;
            long j153 = (j152 | (j152 >>> i)) & 252645135;
            long j154 = (j150 >>> 32) & j3;
            long j155 = ((j154 >>> i) | (j154 >>> 1)) & 858993459;
            long j156 = ((j155 >>> i) | j155) & 252645135;
            long j157 = ((((j156 >>> 4) | j156) & 16711935) << 16) + (((j153 | (j153 >>> 4)) & 16711935) << 24);
            long j158 = (j150 >>> 16) & j3;
            long j159 = ((j158 >>> i) | (j158 >>> 1)) & 858993459;
            long j160 = ((j159 >>> i) | j159) & 252645135;
            long j161 = j150 & j3;
            long j162 = ((j161 >>> i) | (j161 >>> 1)) & 858993459;
            long j163 = (j162 | (j162 >>> i)) & 252645135;
            bArr8[((((~i7) | (-1687791578)) & 1545914456) + ((int) (((j163 | (j163 >>> 4)) & 16711935) | (((((j160 >>> 4) | j160) & 16711935) << i4) + j157)))) ^ 2092288861] = -52;
            bArr8[i] = 109;
            bArr8[3] = -90;
            bArr8[4] = 116;
            bArr8[c5] = 45;
            bArr8[6] = -75;
            bArr8[c4] = -70;
            bArr8[i4] = -21;
            bArr8[9] = 110;
            bArr8[10] = 94;
            f(bArr7, bArr8);
            str = new String(bArr7, StandardCharsets.UTF_8);
        } else {
            c6 = 0;
            byte[] bArr9 = {92, -120, -76, 12, 77, 106, 82, -60, -90};
            long j164 = 1609401998;
            long j165 = ~(z3 ? 1 : 0);
            long b6 = c3.b((((((((j164 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j164 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j164 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j164 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)), ((((((((j165 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j165 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j165 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j165 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
            long j166 = (b6 >>> 48) & j3;
            long j167 = ((j166 >>> i) | (j166 >>> 1)) & 858993459;
            long j168 = (j167 | (j167 >>> i)) & 252645135;
            long j169 = (b6 >>> 32) & j3;
            long j170 = ((j169 >>> i) | (j169 >>> 1)) & 858993459;
            long j171 = (j170 | (j170 >>> i)) & 252645135;
            long j172 = (((j171 | (j171 >>> 4)) & 16711935) << 16) + (((j168 | (j168 >>> 4)) & 16711935) << 24);
            long j173 = (b6 >>> 16) & j3;
            long j174 = ((j173 >>> i) | (j173 >>> 1)) & 858993459;
            long j175 = (j174 | (j174 >>> i)) & 252645135;
            long j176 = (((j175 | (j175 >>> 4)) & 16711935) << i4) | j172;
            long j177 = b6 & j3;
            long j178 = ((j177 >>> i) | (j177 >>> 1)) & 858993459;
            long j179 = (j178 | (j178 >>> i)) & 252645135;
            long j180 = 8393489;
            long j181 = z3 ? 1L : 0L;
            long j182 = ((((((((j180 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j180 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j180 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j180 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j181 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j181 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j181 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j181 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j183 = (j182 >>> 48) & j3;
            long j184 = ((j183 >>> i) | (j183 >>> 1)) & 858993459;
            long j185 = (j184 | (j184 >>> i)) & 252645135;
            long j186 = (j182 >>> 32) & j3;
            long j187 = ((j186 >>> i) | (j186 >>> 1)) & 858993459;
            long j188 = ((j187 >>> i) | j187) & 252645135;
            long j189 = (((j185 | (j185 >>> 4)) & 16711935) << 24) | ((((j188 >>> 4) | j188) & 16711935) << 16);
            long j190 = (j182 >>> 16) & j3;
            long j191 = ((j190 >>> i) | (j190 >>> 1)) & 858993459;
            long j192 = ((j191 >>> i) | j191) & 252645135;
            long j193 = j182 & j3;
            long j194 = ((j193 >>> i) | (j193 >>> 1)) & 858993459;
            long j195 = (j194 | (j194 >>> i)) & 252645135;
            int i12 = (int) (((j195 | (j195 >>> 4)) & 16711935) | j189 | ((((j192 >>> 4) | j192) & 16711935) << i4));
            int i13 = ((i12 + 8390408) - (i12 & 8390408)) + (((int) (((j179 | (j179 >>> 4)) & 16711935) | j176)) & 1073844243);
            long j196 = 1082234709;
            long j197 = i13;
            long j198 = ((((((((j196 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j196 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j196 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j196 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)) + ((((((((j197 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j197 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j197 >>> i4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j197 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j199 = (j198 >>> 48) & 21845;
            long j200 = (j199 | (j199 >>> 1)) & 858993459;
            long j201 = (j200 | (j200 >>> i)) & 252645135;
            long j202 = (j198 >>> 32) & 21845;
            long j203 = (j202 | (j202 >>> 1)) & 858993459;
            long j204 = (j203 | (j203 >>> i)) & 252645135;
            long j205 = (((j204 | (j204 >>> 4)) & 16711935) << 16) + (((j201 | (j201 >>> 4)) & 16711935) << 24);
            long j206 = (j198 >>> 16) & 21845;
            long j207 = (j206 | (j206 >>> 1)) & 858993459;
            long j208 = (j207 | (j207 >>> i)) & 252645135;
            long j209 = j198 & 21845;
            long j210 = (j209 | (j209 >>> 1)) & 858993459;
            long j211 = (j210 | (j210 >>> i)) & 252645135;
            byte[] bArr10 = new byte[9];
            bArr10[0] = 21;
            bArr10[1] = 42;
            bArr10[i] = -56;
            bArr10[3] = 122;
            bArr10[4] = 13;
            bArr10[c5] = (int) (((j211 | (j211 >>> 4)) & 16711935) + ((((j208 | (j208 >>> 4)) & 16711935) << i4) | j205));
            bArr10[6] = 37;
            bArr10[c4] = -53;
            bArr10[i4] = -61;
            f(bArr9, bArr10);
            str = new String(bArr9, StandardCharsets.UTF_8);
        }
        String intern2 = str.intern();
        byte[] bArr11 = new byte[1];
        bArr11[c6] = -13;
        int i14 = i4;
        byte[] bArr12 = new byte[i14];
        // fill-array-data instruction
        bArr12[0] = -88;
        bArr12[1] = 106;
        bArr12[2] = 20;
        bArr12[3] = 87;
        bArr12[4] = 77;
        bArr12[5] = 121;
        bArr12[6] = 48;
        bArr12[7] = 17;
        f(bArr11, bArr12);
        Charset charset = StandardCharsets.UTF_8;
        String intern3 = new String(bArr11, charset).intern();
        byte[] bArr13 = new byte[1];
        bArr13[c6] = 65;
        byte[] bArr14 = new byte[i14];
        // fill-array-data instruction
        bArr14[0] = 97;
        bArr14[1] = 100;
        bArr14[2] = -124;
        bArr14[3] = -8;
        bArr14[4] = -35;
        bArr14[5] = 111;
        bArr14[6] = 90;
        bArr14[7] = 34;
        f(bArr13, bArr14);
        String intern4 = new String(bArr13, charset).intern();
        byte[] bArr15 = new byte[1];
        bArr15[c6] = -29;
        byte[] bArr16 = new byte[i14];
        // fill-array-data instruction
        bArr16[0] = -61;
        bArr16[1] = 120;
        bArr16[2] = -118;
        bArr16[3] = -93;
        bArr16[4] = 63;
        bArr16[5] = -70;
        bArr16[6] = -58;
        bArr16[7] = 126;
        f(bArr15, bArr16);
        String intern5 = new String(bArr15, charset).intern();
        byte[] bArr17 = new byte[1];
        bArr17[c6] = 46;
        byte[] bArr18 = new byte[i14];
        // fill-array-data instruction
        bArr18[0] = 115;
        bArr18[1] = 70;
        bArr18[2] = 51;
        bArr18[3] = 98;
        bArr18[4] = -97;
        bArr18[5] = 104;
        bArr18[6] = 36;
        bArr18[7] = 60;
        f(bArr17, bArr18);
        String intern6 = new String(bArr17, charset).intern();
        StringBuilder sb = new StringBuilder();
        sb.append(intern3);
        sb.append(intern);
        sb.append(intern4);
        sb.append(intern2);
        sb.append(intern5);
        return AbstractC0008a.r(sb, i5, intern6);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x02e1. Please report as an issue. */
    public final M1 k() {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int i3;
        int i4;
        int i5;
        if (n()) {
            return AbstractC0105y1.e(this.f291d);
        }
        String j2 = j();
        byte[] bArr3 = new byte[37];
        bArr3[0] = -11;
        int i6 = 1;
        bArr3[1] = 35;
        int i7 = 2;
        bArr3[2] = 25;
        bArr3[3] = -80;
        bArr3[4] = 8;
        bArr3[5] = 28;
        bArr3[6] = 56;
        bArr3[7] = 113;
        bArr3[8] = -117;
        bArr3[9] = -109;
        bArr3[10] = 9;
        bArr3[11] = -118;
        bArr3[12] = -42;
        bArr3[13] = -69;
        bArr3[14] = -93;
        bArr3[15] = -78;
        bArr3[16] = -66;
        bArr3[17] = -39;
        bArr3[18] = -97;
        bArr3[19] = 107;
        bArr3[20] = 102;
        bArr3[21] = 64;
        bArr3[22] = -124;
        bArr3[23] = 11;
        bArr3[24] = 10;
        long j3 = 472384032;
        long j4 = 12;
        long j5 = (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        bArr3[1554518589 ^ (411046436 + (((int) ((((j18 >>> 4) | j18) & 16711935) + (((((j15 >>> 4) | j15) & 16711935) << 8) | j12))) | 1143472128))] = 21;
        bArr3[26] = 118;
        bArr3[27] = -42;
        bArr3[28] = -50;
        bArr3[29] = 70;
        bArr3[30] = 93;
        char c4 = 31;
        bArr3[31] = -125;
        bArr3[32] = -18;
        bArr3[33] = 40;
        bArr3[34] = 10;
        bArr3[35] = 93;
        bArr3[36] = 0;
        byte[] bArr4 = {-57, 43, Byte.MAX_VALUE, -68, -126, 56, 115, -4, -62, -64, 124, -53, -71, -82, -15, -83, -86, 122, 5, -10, 28, -7, -9, 73, Byte.MIN_VALUE, 5, 22, -98, -71, 3, 78, -106, -27, 31, 123, 16, 32};
        byte[] bArr5 = null;
        int i8 = 1516727821;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        byte[] bArr6 = null;
        while (true) {
            int i12 = ((i8 & 16777216) * (i8 | 16777216)) + ((i8 & (-16777217)) * ((~i8) & 16777216));
            int i13 = i8 >>> 8;
            char c5 = c4;
            int i14 = i6;
            int a2 = j3.a((~i12) & 650911840 & i13, i13, i12, (i12 | 650911840) & i13);
            int i15 = (a2 ^ 642535957) + ((a2 & 642535957) * i7);
            switch (((~i15) + ((i15 | 1) * i7)) ^ 962785775) {
                case -1896910703:
                    byte[] bArr7 = bArr5;
                    int length = bArr6.length;
                    int i16 = 0 - i9;
                    int i17 = (length ^ i16) + ((length & i16) * 2);
                    byte b4 = bArr7[i17];
                    int length2 = bArr6.length;
                    int i18 = 0 - i16;
                    int i19 = i18 | length2;
                    byte b5 = bArr7[D.a(i18, 2, i19, (length2 ^ i18) ^ i19)];
                    bArr7[i17] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    bArr5 = bArr7;
                    i6 = i14;
                    i7 = 2;
                    c4 = c5;
                    i8 = -746753280;
                case -1725904394:
                    bArr = bArr5;
                    int length3 = bArr6.length % 4;
                    i = 1;
                    if ((((length3 > 1 ? 1 : (length3 == 1 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i11 = length3;
                        i8 = -458924450;
                        bArr5 = bArr;
                        i6 = i;
                        c4 = c5;
                        i7 = 2;
                    } else {
                        bArr5 = bArr;
                        i11 = length3;
                        i6 = 1;
                        c4 = c5;
                        i7 = 2;
                        i8 = -365117735;
                    }
                case -1399959314:
                    bArr2 = bArr5;
                    int a4 = j3.a((-1205100636) & i10, i10, 3, (-1205100633) & i10);
                    byte b6 = bArr2[a4];
                    int i20 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i21 = i10 - 1;
                    int i22 = i21 - (i10 | (-3));
                    int i23 = bArr2[i22] & ForkServer.ERROR;
                    int i24 = i23 * ((~i23) & 65536);
                    int a5 = S.a(i24, i20, i14, ((-1) - i24) | ((-1) - i20));
                    int i25 = i21 - (i10 | (-2));
                    int i26 = bArr2[i25] & ForkServer.ERROR;
                    int i27 = i26 * ((~i26) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i28 = (i27 - 1) - ((~a5) | i27);
                    int i29 = bArr2[i10] & ForkServer.ERROR;
                    int a6 = S.a(i28, i29, 1, ((-1) - i28) | ((-1) - i29));
                    byte b7 = bArr6[a4];
                    int i30 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i31 = bArr6[i22] & ForkServer.ERROR;
                    int i32 = ((i31 * ((~i31) & 65536)) & (~i30)) + i30;
                    int i33 = bArr6[i25] & ForkServer.ERROR;
                    int i34 = i33 * ((~i33) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i35 = ~((((~i34) | 911399251) | i32) - ((911399251 & i34) | i32));
                    int i36 = bArr6[i10] & ForkServer.ERROR;
                    int i37 = ~((((~i35) | 1433568692) | i36) - ((1433568692 & i35) | i36));
                    int i38 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i39 = (-1254002618) - ((i38 & 2) | ((-1672003491) - i38));
                    int i40 = (i39 + i37) - ((i39 & i37) * 2);
                    bArr6[i10] = (byte) i40;
                    bArr6[i25] = (byte) (i40 >>> 8);
                    bArr6[i22] = (byte) (i40 >>> 16);
                    bArr6[a4] = (byte) (i40 >>> 24);
                    i10 = (i10 ^ 4) + ((i10 & 4) * 2);
                    int length4 = bArr6.length;
                    int length5 = 0 - (bArr6.length % 4);
                    int i41 = ((i10 > AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 1 : (i10 == AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i41 != 0) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (i41 != 0) {
                        i8 = i3;
                    } else {
                        i8 = -169475207;
                    }
                    bArr5 = bArr2;
                    c4 = c5;
                    i6 = 1;
                    i7 = 2;
                case -1135475043:
                    break;
                case 180635757:
                    i8 = -1605440657;
                    bArr5 = bArr4;
                    bArr6 = bArr3;
                    i10 = 0;
                    i6 = i14;
                    c4 = c5;
                    i7 = 2;
                case 511524454:
                    int length6 = bArr6.length;
                    int i42 = 0 - i9;
                    int i43 = 0 - i42;
                    int i44 = ((~length6) & i43) * i7;
                    int length7 = bArr6.length;
                    byte b8 = bArr6[((length7 | i42) * i7) - (length7 ^ i42)];
                    int i45 = i7;
                    int length8 = bArr6.length;
                    byte b9 = bArr5[(i42 ^ length8) + ((length8 & i42) * 2)];
                    bArr6[(length6 ^ i43) - i44] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i45) * ((byte) ((~b9) & b8)))));
                    i11 = AbstractC0099x.a(i9, 3, (~i9) * 2);
                    bArr = bArr5;
                    if ((((i9 > 2 ? 1 : (i9 == 2 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i = i14;
                        i8 = -458924450;
                        bArr5 = bArr;
                        i6 = i;
                        c4 = c5;
                        i7 = 2;
                    } else {
                        bArr5 = bArr;
                        i6 = i14;
                        c4 = c5;
                        i7 = 2;
                        i8 = -365117735;
                    }
                case 961838909:
                    int length9 = bArr6.length;
                    int i46 = 0 - i11;
                    if ((bArr5[((length9 | i46) - (((~i46) & 165327505) & length9)) + ((i46 | 165327505) & length9)] > Double.NaN ? 1 : (bArr5[((length9 | i46) - (((~i46) & 165327505) & length9)) + ((i46 | 165327505) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i4 = 0;
                    } else {
                        i4 = i14;
                    }
                    if (i4 != 0) {
                        i5 = -365117735;
                    } else {
                        i5 = 1093626513;
                    }
                    if (i4 != 0) {
                        i8 = -746753280;
                    } else {
                        i8 = i5;
                    }
                    i9 = i11;
                    i6 = i14;
                    c4 = c5;
                default:
                    bArr2 = bArr5;
                    i8 = -365117735;
                    bArr5 = bArr2;
                    c4 = c5;
                    i6 = 1;
                    i7 = 2;
            }
            throw new CertificateParsingException(AbstractC0008a.n(new String(bArr3, StandardCharsets.UTF_8).intern(), j2));
        }
    }

    public final byte[] l() {
        return this.f291d;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0009. Please report as an issue. */
    public final boolean m() {
        char c4 = 44538;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 44538:
                    if (c(1)) {
                        c4 = 64959;
                    } else {
                        c4 = 8244;
                    }
                case 1735:
                    break;
                case 8459:
                    z3 = true;
                    c4 = 1735;
                case 8244:
                    z3 = false;
                    c4 = 1735;
                case 64959:
                    if (!this.f289b) {
                        c4 = 8459;
                    } else {
                        c4 = 8244;
                    }
                default:
                    c4 = 64959;
            }
            return z3;
        }
    }

    public final boolean n() {
        boolean z3 = false;
        char c4 = 20937;
        while (true) {
            if (c4 != 20937) {
                if (c4 != 9534) {
                    if (c4 != 56999) {
                        if (c4 == 36558) {
                            z3 = true;
                        } else {
                            c4 = 36558;
                        }
                    } else {
                        return z3;
                    }
                } else {
                    z3 = false;
                }
                c4 = 56999;
            } else if (this.f288a == 2) {
                c4 = 36558;
            } else {
                c4 = 9534;
            }
        }
    }

    public final boolean o() {
        return c(4);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean p() {
        boolean z3 = false;
        while (true) {
            char c4 = 40120;
            while (true) {
                switch (c4) {
                    case 54995:
                        if (this.f289b) {
                            c4 = 28083;
                        } else {
                            c4 = 38752;
                        }
                    case 28083:
                        z3 = true;
                        c4 = 24773;
                    case 24773:
                        break;
                    case 40120:
                        if (c(16)) {
                            c4 = 54995;
                        } else {
                            c4 = 38752;
                        }
                    case 38752:
                        int i = this.f288a;
                        int i3 = ((~i) | (-136160065)) & 113770625;
                        int i4 = (i & 524352) | 400704;
                        z3 = 114171329 ^ ((i4 & i3) + (i4 | i3));
                        c4 = 24773;
                }
                return z3;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0009. Please report as an issue. */
    public final boolean q() {
        M1 m12 = null;
        char c4 = 3549;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 3549:
                    c4 = 47719;
                    m12 = this;
                case 24069:
                    z3 = false;
                    c4 = 22838;
                case 47719:
                    if (m12.c(17)) {
                        c4 = 26300;
                    } else {
                        c4 = 24069;
                    }
                case 20849:
                    z3 = true;
                    c4 = 22838;
                case 22838:
                    break;
                case 26300:
                    if (this.f289b) {
                        c4 = 20849;
                    } else {
                        c4 = 24069;
                    }
                default:
                    c4 = 22838;
            }
            return z3;
        }
    }
}
