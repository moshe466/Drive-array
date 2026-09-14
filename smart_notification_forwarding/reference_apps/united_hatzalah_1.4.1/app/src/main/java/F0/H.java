package F0;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class H extends AbstractC0095w {
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void D(byte[] bArr, byte[] bArr2) {
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
    public static void y(byte[] bArr, byte[] bArr2) {
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
    public static void z(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x01d6. Please report as an issue. */
    public final void A(Context context) {
        int i;
        int i3;
        byte[] bArr;
        int i4 = 0;
        int i5 = 1;
        int i6 = 2;
        int i7 = 6;
        byte[] bArr2 = {123, 3, 73, -52, -126, -8, -65};
        int i8 = ((~H.class.getName().length()) | (-156873649)) & (-1285486446);
        long j2 = 8975360;
        long length = H.class.getName().length() & 29479056;
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j3 = (b4 >>> 48) & 43690;
        long j4 = ((j3 >>> 2) | (j3 >>> 1)) & 858993459;
        long j5 = ((j4 >>> 2) | j4) & 252645135;
        long j6 = (b4 >>> 32) & 43690;
        long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
        long j8 = ((j7 >>> 2) | j7) & 252645135;
        long j9 = ((((j8 >>> 4) | j8) & 16711935) << 16) + ((((j5 >>> 4) | j5) & 16711935) << 24);
        long j10 = (b4 >>> 16) & 43690;
        long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
        long j12 = ((j11 >>> 2) | j11) & 252645135;
        long j13 = b4 & 43690;
        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
        long j15 = ((j14 >>> 2) | j14) & 252645135;
        byte[] bArr3 = {24, 108, 39, 1276511018 ^ (i8 + ((int) ((((j15 >>> 4) | j15) & 16711935) + (((((j12 >>> 4) | j12) & 16711935) << 8) + j9)))), -25, Byte.MIN_VALUE, -53, -8};
        byte[] bArr4 = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1850458006;
        byte[] bArr5 = null;
        while (true) {
            int i12 = ((i11 & 16777216) * (i11 | 16777216)) + ((i11 & (-16777217)) * ((~i11) & 16777216));
            int i13 = i11 >>> 8;
            int i14 = (i13 - 1) - ((~i12) | i13);
            int i15 = (-1700147435) - ((i14 & i6) | (2028104049 - i14));
            switch ((-1363443157) ^ ((~i15) + ((i15 | 1) * i6))) {
                case -1940167324:
                    int i16 = i4;
                    byte[] bArr6 = bArr4;
                    byte[] bArr7 = bArr5;
                    byte b5 = bArr6[i9];
                    int i17 = ((byte) i16) - b5;
                    bArr6[i9] = (byte) (((byte) (b5 & (~i17))) - ((byte) ((~b5) & i17)));
                    i4 = i16;
                    bArr4 = bArr6;
                    i11 = 614229416;
                    i6 = i6;
                    bArr5 = bArr7;
                case -360299937:
                    i = i4;
                    byte[] bArr8 = bArr4;
                    i3 = i6;
                    bArr = bArr5;
                    int i18 = i7;
                    int i19 = (((double) ((byte) bArr8[i10])) > Double.NaN ? 1 : (((double) ((byte) bArr8[i10])) == Double.NaN ? 0 : -1)) <= -1 ? i : 1;
                    r47 = i19 == 0 ? 427928065 : -1396193641;
                    if (i19 != 0) {
                        r47 = 614229416;
                    }
                    bArr4 = bArr8;
                    i9 = i10;
                    i7 = i18;
                    i11 = r47;
                    i6 = i3;
                    bArr5 = bArr;
                    i4 = i;
                case 399486784:
                    break;
                case 585276366:
                    bArr5 = bArr2;
                    bArr4 = bArr3;
                    i11 = 1985663266;
                    i10 = i4;
                case 1733787683:
                    byte b6 = bArr5[i9];
                    byte b7 = bArr4[i9];
                    i3 = i6;
                    bArr5[i9] = (byte) (((byte) (b7 + b6)) - ((byte) (((byte) i6) * ((byte) (b7 & b6)))));
                    i10 = (i9 ^ 1) + ((i9 & 1) * 2);
                    i = i4;
                    bArr = bArr5;
                    bArr4 = bArr4;
                    if ((((i10 > bArr5.length ? 1 : (i10 == bArr5.length ? 0 : -1)) >>> 31) & 1) != 0) {
                        i11 = 1985663266;
                        i6 = i3;
                        bArr5 = bArr;
                        i4 = i;
                    }
                    i11 = r47;
                    i6 = i3;
                    bArr5 = bArr;
                    i4 = i;
                default:
                    i11 = -1396193641;
            }
            int i20 = i4;
            int i21 = i6;
            Charset charset = StandardCharsets.UTF_8;
            kotlin.jvm.internal.j.e(context, new String(bArr2, charset).intern());
            C0031f2 n4 = T0.n(new C0016c(this, context, i5));
            byte[] bArr9 = new byte[i7];
            bArr9[i20] = 103;
            bArr9[1] = 57;
            long j16 = 1401438608;
            long f4 = AbstractC0008a.f(AbstractC0095w.class, -1) | 1362413470;
            long j17 = (((((((((j16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j18 = (j17 >>> 48) & 43690;
            long j19 = ((j18 >>> i21) | (j18 >>> 1)) & 858993459;
            long j20 = ((j19 >>> i21) | j19) & 252645135;
            long j21 = (j17 >>> 32) & 43690;
            long j22 = ((j21 >>> i21) | (j21 >>> 1)) & 858993459;
            long j23 = ((j22 >>> i21) | j22) & 252645135;
            long j24 = ((((j23 >>> 4) | j23) & 16711935) << 16) | ((((j20 >>> 4) | j20) & 16711935) << 24);
            long j25 = (j17 >>> 16) & 43690;
            long j26 = ((j25 >>> i21) | (j25 >>> 1)) & 858993459;
            long j27 = ((j26 >>> i21) | j26) & 252645135;
            long j28 = j17 & 43690;
            long j29 = ((j28 >>> i21) | (j28 >>> 1)) & 858993459;
            long j30 = ((j29 >>> i21) | j29) & 252645135;
            long j31 = -741445194;
            long length2 = ((int) ((((j30 >>> 4) | j30) & 16711935) | ((((j27 >>> 4) | j27) & 16711935) << 8) | j24)) + ((AbstractC0095w.class.getName().length() & 46665764) | (-2142883804));
            long j32 = ((((((((j31 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j31 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j31 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j31 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j33 = (j32 >>> 48) & 21845;
            long j34 = ((j33 >>> 1) | j33) & 858993459;
            long j35 = ((j34 >>> i21) | j34) & 252645135;
            long j36 = (j32 >>> 32) & 21845;
            long j37 = ((j36 >>> 1) | j36) & 858993459;
            long j38 = ((j37 >>> i21) | j37) & 252645135;
            long j39 = ((((j38 >>> 4) | j38) & 16711935) << 16) + ((((j35 >>> 4) | j35) & 16711935) << 24);
            long j40 = (j32 >>> 16) & 21845;
            long j41 = ((j40 >>> 1) | j40) & 858993459;
            long j42 = ((j41 >>> i21) | j41) & 252645135;
            long j43 = j32 & 21845;
            long j44 = ((j43 >>> 1) | j43) & 858993459;
            long j45 = ((j44 >>> i21) | j44) & 252645135;
            bArr9[(int) ((((j45 >>> 4) | j45) & 16711935) | (((((j42 >>> 4) | j42) & 16711935) << 8) + j39))] = -110;
            bArr9[3] = -66;
            bArr9[4] = 27;
            bArr9[5] = 56;
            byte[] bArr10 = new byte[8];
            bArr10[i20] = 121;
            bArr10[1] = 66;
            bArr10[i21] = 119;
            bArr10[3] = 84;
            bArr10[4] = 119;
            bArr10[5] = 76;
            bArr10[i7] = -126;
            int length3 = (((~AbstractC0095w.class.getName().length()) | (-1354536592)) & (-398187965)) + ((AbstractC0095w.class.getName().length() & 1157890595) | 84934700);
            bArr10[(length3 | (-313253272)) - (length3 & (-313253272))] = 70;
            AbstractC0095w.v(bArr9, bArr10);
            new String(bArr9, charset).intern();
            C0054l1 c0054l1 = this.f700f;
            c0054l1.f573a.r();
            int length4 = AbstractC0095w.class.getName().length();
            long j46 = 1994221957;
            long j47 = ((~length4) - length4) + length4;
            long j48 = (((((((((j46 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j46 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j46 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j46 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j47 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j47 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j47 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j47 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
            long j49 = (j48 >>> 48) & 43690;
            long j50 = ((j49 >>> i21) | (j49 >>> 1)) & 858993459;
            long j51 = ((j50 >>> i21) | j50) & 252645135;
            long j52 = (j48 >>> 32) & 43690;
            long j53 = ((j52 >>> i21) | (j52 >>> 1)) & 858993459;
            long j54 = ((j53 >>> i21) | j53) & 252645135;
            long j55 = ((((j54 >>> 4) | j54) & 16711935) << 16) | ((((j51 >>> 4) | j51) & 16711935) << 24);
            long j56 = (j48 >>> 16) & 43690;
            long j57 = ((j56 >>> i21) | (j56 >>> 1)) & 858993459;
            long j58 = ((j57 >>> i21) | j57) & 252645135;
            long j59 = ((((j58 >>> 4) | j58) & 16711935) << 8) + j55;
            long j60 = j48 & 43690;
            long j61 = ((j60 >>> i21) | (j60 >>> 1)) & 858993459;
            long j62 = (j61 | (j61 >>> i21)) & 252645135;
            int i22 = (int) (((j62 | (j62 >>> 4)) & 16711935) + j59);
            int length5 = ((AbstractC0095w.class.getName().length() & 2142216) | 553689162) + (~(-((i22 | 36706565) - (i22 ^ 36706565)))) + 1;
            byte b8 = (length5 | 590395691) - (length5 & 590395691);
            byte length6 = ((((~AbstractC0095w.class.getName().length()) | (-656042045)) & 139600968) + ((AbstractC0095w.class.getName().length() & 34807976) | 570491040)) ^ 710091944;
            byte[] bArr11 = new byte[10];
            bArr11[i20] = 92;
            bArr11[1] = 67;
            bArr11[i21] = -37;
            bArr11[3] = -54;
            bArr11[4] = -51;
            bArr11[5] = 35;
            bArr11[i7] = b8;
            bArr11[7] = length6;
            bArr11[8] = 43;
            bArr11[9] = 18;
            byte length7 = ((((~AbstractC0095w.class.getName().length()) | 1033997526) & 805619809) + ((AbstractC0095w.class.getName().length() & 1076248609) | 1075978624)) ^ (-1881598379);
            byte[] bArr12 = new byte[10];
            bArr12[i20] = 97;
            bArr12[1] = 85;
            bArr12[i21] = 47;
            bArr12[3] = 104;
            bArr12[4] = 31;
            bArr12[5] = 112;
            bArr12[i7] = length7;
            bArr12[7] = -50;
            bArr12[8] = 78;
            bArr12[9] = 118;
            AbstractC0095w.v(bArr11, bArr12);
            d(new String(bArr11, charset).intern(), n4);
            if (n4.b()) {
                int i23 = ((~AbstractC0095w.class.getName().length()) | (-1301697913)) & (-2002751918);
                int i24 = i7;
                long j63 = 67702920;
                long length8 = AbstractC0095w.class.getName().length() & 143148248;
                long b9 = c3.b((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                long j64 = (b9 >>> 48) & 43690;
                long j65 = ((j64 >>> i21) | (j64 >>> 1)) & 858993459;
                long j66 = ((j65 >>> i21) | j65) & 252645135;
                long j67 = (b9 >>> 32) & 43690;
                long j68 = ((j67 >>> i21) | (j67 >>> 1)) & 858993459;
                long j69 = ((j68 >>> i21) | j68) & 252645135;
                long j70 = ((((j69 >>> 4) | j69) & 16711935) << 16) + ((((j66 >>> 4) | j66) & 16711935) << 24);
                long j71 = (b9 >>> 16) & 43690;
                long j72 = ((j71 >>> i21) | (j71 >>> 1)) & 858993459;
                long j73 = ((j72 >>> i21) | j72) & 252645135;
                long j74 = b9 & 43690;
                long j75 = ((j74 >>> i21) | (j74 >>> 1)) & 858993459;
                long j76 = ((j75 >>> i21) | j75) & 252645135;
                byte[] bArr13 = new byte[(i23 + ((int) ((((j76 >>> 4) | j76) & 16711935) + (((((j73 >>> 4) | j73) & 16711935) << 8) + j70)))) ^ (-1935049008)];
                bArr13[i20] = 117;
                bArr13[1] = -117;
                bArr13[i21] = -94;
                bArr13[3] = -35;
                int i25 = ~AbstractC0095w.class.getName().length();
                int i26 = i25 + (((-i25) - 1) | (-862680826)) + 862680826;
                int length9 = ((i26 | (-2144941532)) - (i26 ^ (-2144941532))) + ((AbstractC0095w.class.getName().length() & (-1576753020)) | 587210888);
                long j77 = -1557730648;
                long j78 = length9;
                long j79 = ((((((((j77 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j77 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j77 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j77 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j78 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j78 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j78 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j78 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j80 = (j79 >>> 48) & 21845;
                long j81 = ((j80 >>> 1) | j80) & 858993459;
                long j82 = ((j81 >>> i21) | j81) & 252645135;
                long j83 = (j79 >>> 32) & 21845;
                long j84 = ((j83 >>> 1) | j83) & 858993459;
                long j85 = ((j84 >>> i21) | j84) & 252645135;
                long j86 = ((((j85 >>> 4) | j85) & 16711935) << 16) | ((((j82 >>> 4) | j82) & 16711935) << 24);
                long j87 = (j79 >>> 16) & 21845;
                long j88 = ((j87 >>> 1) | j87) & 858993459;
                long j89 = ((j88 >>> i21) | j88) & 252645135;
                long j90 = j79 & 21845;
                long j91 = (j90 | (j90 >>> 1)) & 858993459;
                long j92 = (j91 | (j91 >>> i21)) & 252645135;
                bArr13[(int) (((j92 | (j92 >>> 4)) & 16711935) | (((((j89 >>> 4) | j89) & 16711935) << 8) + j86))] = -1;
                bArr13[5] = 69;
                bArr13[i24] = -74;
                int i27 = ((~AbstractC0095w.class.getName().length()) | (-150107371)) & 839713160;
                long j93 = 131721;
                long length10 = AbstractC0095w.class.getName().length();
                long j94 = (((((((((j93 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j93 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j93 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j93 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length10 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length10 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length10 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length10 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                long j95 = (j94 >>> 48) & 43690;
                long j96 = ((j95 >>> i21) | (j95 >>> 1)) & 858993459;
                long j97 = ((j96 >>> i21) | j96) & 252645135;
                long j98 = (j94 >>> 32) & 43690;
                long j99 = ((j98 >>> i21) | (j98 >>> 1)) & 858993459;
                long j100 = ((j99 >>> i21) | j99) & 252645135;
                long j101 = ((((j100 >>> 4) | j100) & 16711935) << 16) | ((((j97 >>> 4) | j97) & 16711935) << 24);
                long j102 = (j94 >>> 16) & 43690;
                long j103 = ((j102 >>> i21) | (j102 >>> 1)) & 858993459;
                long j104 = ((j103 >>> i21) | j103) & 252645135;
                long j105 = j94 & 43690;
                long j106 = ((j105 >>> i21) | (j105 >>> 1)) & 858993459;
                long j107 = ((j106 >>> i21) | j106) & 252645135;
                bArr13[7] = (-978291666) ^ (i27 + (((int) ((((j107 >>> 4) | j107) & 16711935) + (((((j104 >>> 4) | j104) & 16711935) << 8) | j101))) | 138578435));
                bArr13[8] = -82;
                int i28 = ((~AbstractC0095w.class.getName().length()) | (-881779095)) & 495818010;
                int length11 = AbstractC0095w.class.getName().length();
                bArr13[9] = 1607327496 ^ ((((1456245522 & length11) ^ 1111509504) + (length11 & 1111493120)) + i28);
                AbstractC0095w.v(bArr13, new byte[]{120, 29, 118, 5, -51, 82, 74, 100, -53, 118});
                String intern = new String(bArr13, charset).intern();
                c0054l1.f573a.r();
                c(intern);
            }
            if (n4.a()) {
                Integer r3 = c0054l1.f573a.r();
                byte[] bArr14 = {31, -86, -107, 21, 71, -51, -79, 92, 61, 95};
                AbstractC0095w.v(bArr14, new byte[]{-94, -13, 101, 61, -123, -37, 65, -45, 88, 59});
                c0054l1.c(new String(bArr14, charset).intern(), r3);
                return;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x005a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean B() {
        char c4;
        Charset charset;
        Method method;
        byte[] bArr;
        Charset charset2;
        String intern;
        byte[] bArr2;
        char c5 = 48615;
        String str = null;
        Object obj = null;
        boolean z3 = false;
        boolean z4 = false;
        Exception exc = null;
        while (true) {
            switch (c5) {
                case 26347:
                    byte[] bArr3 = {-10};
                    z(bArr3, new byte[]{-57, -17, 59, -109, -46, -94, -75, 56});
                    z4 = kotlin.jvm.internal.j.a(str, new String(bArr3, StandardCharsets.UTF_8).intern());
                    c5 = z4 ? (char) 31429 : (char) 9630;
                case 30470:
                    try {
                        c4 = 26347;
                        str = (String) obj;
                        c5 = c4;
                    } catch (Exception e4) {
                        e = e4;
                        exc = e;
                        c5 = 54338;
                    }
                case 23762:
                    break;
                case 9630:
                    c5 = 58195;
                    z3 = z4;
                case 58195:
                    c5 = 23762;
                case 4101:
                    c5 = 26347;
                    str = null;
                case 54338:
                    exc = exc;
                    c5 = 23762;
                    z3 = false;
                case 48615:
                    try {
                        byte[] bArr4 = new byte[27];
                        bArr4[0] = -69;
                        bArr4[1] = 7199094 ^ ((((H.class.getName().length() & 4722944) | 2195712) + (~(-(((~H.class.getName().length()) | 579225786) & 5003264)))) + 1);
                        bArr4[2] = 78;
                        bArr4[3] = -25;
                        bArr4[4] = -5;
                        bArr4[5] = -47;
                        bArr4[6] = -117;
                        bArr4[7] = -42;
                        bArr4[8] = 9;
                        bArr4[9] = -66;
                        bArr4[10] = -55;
                        bArr4[11] = 2;
                        long j2 = -1;
                        long length = H.class.getName().length();
                        long j3 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                        long j4 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                        long j5 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j6 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j7 = j6 + j5 + (j4 | j3) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j8 = (j7 >>> 48) & 21845;
                        long j9 = (j8 | (j8 >>> 1)) & 858993459;
                        long j10 = (j9 | (j9 >>> 2)) & 252645135;
                        long j11 = (j7 >>> 32) & 21845;
                        long j12 = ((j11 >>> 1) | j11) & 858993459;
                        long j13 = ((j12 >>> 2) | j12) & 252645135;
                        long j14 = (((j10 | (j10 >>> 4)) & 16711935) << 24) | ((((j13 >>> 4) | j13) & 16711935) << 16);
                        long j15 = (j7 >>> 16) & 21845;
                        long j16 = ((j15 >>> 1) | j15) & 858993459;
                        long j17 = ((j16 >>> 2) | j16) & 252645135;
                        long j18 = ((((j17 >>> 4) | j17) & 16711935) << 8) + j14;
                        long j19 = j7 & 21845;
                        long j20 = ((j19 >>> 1) | j19) & 858993459;
                        long j21 = ((j20 >>> 2) | j20) & 252645135;
                        bArr4[12] = (((((int) ((((j21 >>> 4) | j21) & 16711935) + j18)) | (-1017446981)) & (-2058711016)) + ((H.class.getName().length() & 201326723) | 1476731523)) ^ (-581979412);
                        bArr4[13] = -116;
                        bArr4[14] = 20;
                        long length2 = H.class.getName().length();
                        long a2 = AbstractC0088u0.a(j4, j3, j5, j6, ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j22 = (a2 >>> 48) & 21845;
                        long j23 = ((j22 >>> 1) | j22) & 858993459;
                        long j24 = ((j23 >>> 2) | j23) & 252645135;
                        long j25 = (a2 >>> 32) & 21845;
                        long j26 = ((j25 >>> 1) | j25) & 858993459;
                        long j27 = ((j26 >>> 2) | j26) & 252645135;
                        long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) | ((((j24 >>> 4) | j24) & 16711935) << 24);
                        long j29 = (a2 >>> 16) & 21845;
                        long j30 = ((j29 >>> 1) | j29) & 858993459;
                        long j31 = ((j30 >>> 2) | j30) & 252645135;
                        long j32 = a2 & 21845;
                        long j33 = (j32 | (j32 >>> 1)) & 858993459;
                        long j34 = (j33 | (j33 >>> 2)) & 252645135;
                        int i = (((int) (((j34 | (j34 >>> 4)) & 16711935) | (((((j31 >>> 4) | j31) & 16711935) << 8) + j28))) | (-1075840066)) + 1130400842;
                        long j35 = 1075922001;
                        long length3 = H.class.getName().length();
                        long j36 = ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
                        long j49 = ((j48 >>> 2) | j48) & 252645135;
                        bArr4[(i + (((int) ((((j49 >>> 4) | j49) & 16711935) + (((((j46 >>> 4) | j46) & 16711935) << 8) | j43))) | 67977360)) ^ 1198378198] = 19;
                        bArr4[16] = -102;
                        int i3 = ((~H.class.getName().length()) | (-1107891172)) & 6628448;
                        long j50 = 42139744;
                        long length4 = H.class.getName().length();
                        long j51 = (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j52 = (j51 >>> 48) & 43690;
                        long j53 = ((j52 >>> 2) | (j52 >>> 1)) & 858993459;
                        long j54 = ((j53 >>> 2) | j53) & 252645135;
                        long j55 = (j51 >>> 32) & 43690;
                        long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
                        long j57 = ((j56 >>> 2) | j56) & 252645135;
                        long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) + ((((j54 >>> 4) | j54) & 16711935) << 24);
                        long j59 = (j51 >>> 16) & 43690;
                        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                        long j61 = ((j60 >>> 2) | j60) & 252645135;
                        long j62 = j51 & 43690;
                        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                        long j64 = ((j63 >>> 2) | j63) & 252645135;
                        bArr4[(i3 + (((int) ((((j64 >>> 4) | j64) & 16711935) | (((((j61 >>> 4) | j61) & 16711935) << 8) | j58))) | 847904768)) ^ 854533233] = -45;
                        bArr4[18] = -118;
                        bArr4[19] = -20;
                        bArr4[20] = 123;
                        bArr4[21] = -29;
                        bArr4[22] = -90;
                        bArr4[23] = -35;
                        bArr4[24] = 124;
                        bArr4[25] = -115;
                        bArr4[26] = 121;
                        int i4 = ~H.class.getName().length();
                        int i5 = (-2145826302) & (((-1010147589) ^ i4) + (i4 & (-1010147589)));
                        long j65 = 235177216;
                        long length5 = H.class.getName().length() & 135332864;
                        long j66 = (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                        long j67 = (j66 >>> 48) & 43690;
                        long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                        long j69 = ((j68 >>> 2) | j68) & 252645135;
                        long j70 = (j66 >>> 32) & 43690;
                        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
                        long j72 = ((j71 >>> 2) | j71) & 252645135;
                        long j73 = ((((j72 >>> 4) | j72) & 16711935) << 16) + ((((j69 >>> 4) | j69) & 16711935) << 24);
                        long j74 = (j66 >>> 16) & 43690;
                        long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                        long j76 = ((j75 >>> 2) | j75) & 252645135;
                        long j77 = j66 & 43690;
                        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                        long j79 = ((j78 >>> 2) | j78) & 252645135;
                        int i6 = (int) ((((j79 >>> 4) | j79) & 16711935) | ((((j76 >>> 4) | j76) & 16711935) << 8) | j73);
                        z(bArr4, new byte[]{-66, 42, -104, 51, -24, -122, 93, 70, 26, -33, 105, -73, 106, -19, -14, -44, -117, -19, 110, 61, 111, -80, AbstractC0099x.a(i5 | i6, 2, (~i5) ^ i6) ^ (-1910649024), 11, 21, -24, 10});
                        charset = StandardCharsets.UTF_8;
                        Class<?> cls = Class.forName(new String(bArr4, charset).intern());
                        byte[] bArr5 = {32, -16, 3};
                        int i7 = ~H.class.getName().length();
                        long j80 = 102053376;
                        long j81 = (1740579477 ^ i7) + (i7 & 1740579477);
                        long j82 = (((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j83 = (j82 >>> 48) & 43690;
                        long j84 = ((j83 >>> 2) | (j83 >>> 1)) & 858993459;
                        long j85 = ((j84 >>> 2) | j84) & 252645135;
                        long j86 = (j82 >>> 32) & 43690;
                        long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                        long j88 = ((j87 >>> 2) | j87) & 252645135;
                        long j89 = ((((j88 >>> 4) | j88) & 16711935) << 16) | ((((j85 >>> 4) | j85) & 16711935) << 24);
                        long j90 = (j82 >>> 16) & 43690;
                        long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                        long j92 = ((j91 >>> 2) | j91) & 252645135;
                        long j93 = ((((j92 >>> 4) | j92) & 16711935) << 8) + j89;
                        long j94 = j82 & 43690;
                        long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
                        long j96 = (j95 | (j95 >>> 2)) & 252645135;
                        z(bArr5, new byte[]{71, -107, 119, (((int) (((j96 | (j96 >>> 4)) & 16711935) | j93)) + ((H.class.getName().length() & 276862208) | 411091217)) ^ (-513144591), 68, 22, 109, -78});
                        method = cls.getMethod(new String(bArr5, charset).intern(), String.class);
                        byte[] bArr6 = {70, -35, -67, -59, 43, 112, -74, 66, 99, -82, 48, -23, 107, -95};
                        z(bArr6, new byte[]{77, -114, 91, 106, 34, 18, 108, -109, 107, -72, -112, 121, 69, -120});
                        kotlin.jvm.internal.j.d(method, new String(bArr6, charset).intern());
                        bArr = new byte[]{-83, 109, -2, 126, 7, -62, 65, -33, 105, 82, -70, -74, -74, -7, -98, -103};
                        long length6 = H.class.getName().length();
                        long j97 = (j6 | (j4 + j3 + j5)) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j98 = (j97 >>> 48) & 21845;
                        long j99 = ((j98 >>> 1) | j98) & 858993459;
                        long j100 = ((j99 >>> 2) | j99) & 252645135;
                        long j101 = (j97 >>> 32) & 21845;
                        long j102 = ((j101 >>> 1) | j101) & 858993459;
                        long j103 = ((j102 >>> 2) | j102) & 252645135;
                        long j104 = ((((j103 >>> 4) | j103) & 16711935) << 16) | ((((j100 >>> 4) | j100) & 16711935) << 24);
                        long j105 = (j97 >>> 16) & 21845;
                        long j106 = ((j105 >>> 1) | j105) & 858993459;
                        long j107 = ((j106 >>> 2) | j106) & 252645135;
                        long j108 = ((((j107 >>> 4) | j107) & 16711935) << 8) + j104;
                        long j109 = j97 & 21845;
                        long j110 = ((j109 >>> 1) | j109) & 858993459;
                        long j111 = ((j110 >>> 2) | j110) & 252645135;
                        z(bArr, new byte[]{-88, 63, 42, -65, 28, -107, -103, 20, (((((int) ((((j111 >>> 4) | j111) & 16711935) | j108)) | (-16777217)) - (-419446950)) + ((H.class.getName().length() & 29360128) | 80258112)) ^ 499704975, 1, 90, ((((~H.class.getName().length()) | 986381230) & (-1878849535)) + ((H.class.getName().length() & (-1996161021)) | 151257090)) ^ (-1727592330), -80, -93, 73, 95});
                    } catch (Exception e5) {
                        e = e5;
                    }
                    try {
                        obj = method.invoke(null, new String(bArr, charset).intern());
                        c4 = obj instanceof String ? (char) 30470 : (char) 4101;
                        exc = method;
                        c5 = c4;
                    } catch (Exception e6) {
                        e = e6;
                        exc = e;
                        c5 = 54338;
                    }
                case 31429:
                    try {
                        long j112 = 411312128;
                        long j113 = (~H.class.getName().length()) | 1022614438;
                        long j114 = ((((((((j112 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j112 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j112 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j112 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j115 = (j114 >>> 48) & 43690;
                        long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
                        long j117 = ((j116 >>> 2) | j116) & 252645135;
                        long j118 = (j114 >>> 32) & 43690;
                        long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
                        long j120 = ((j119 >>> 2) | j119) & 252645135;
                        long j121 = ((((j120 >>> 4) | j120) & 16711935) << 16) + ((((j117 >>> 4) | j117) & 16711935) << 24);
                        long j122 = (j114 >>> 16) & 43690;
                        long j123 = ((j122 >>> 2) | (j122 >>> 1)) & 858993459;
                        long j124 = ((j123 >>> 2) | j123) & 252645135;
                        long j125 = j114 & 43690;
                        long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
                        long j127 = ((j126 >>> 2) | j126) & 252645135;
                        int length7 = ((int) ((((j127 >>> 4) | j127) & 16711935) + (((((j124 >>> 4) | j124) & 16711935) << 8) | j121))) + ((H.class.getName().length() & 17047552) | 1124073504);
                        byte[] bArr7 = {124, -19, 72, -69, 75, -38, 68, -18, 54, 2, -127, E1.a(length7 | (-1535385639), -1535385639, length7), -90, 86, -116, 7, 25, -100, 97, -58, -67, 112, -69, -66};
                        byte[] bArr8 = new byte[24];
                        bArr8[0] = 113;
                        bArr8[1] = -116;
                        bArr8[2] = ((((~H.class.getName().length()) | (-1040873597)) & 1251041282) + (((H.class.getName().length() | (-167796737)) - (-167796737)) | 67896640)) ^ (-1318937912);
                        int i8 = ~H.class.getName().length();
                        int length8 = 1074010129 + (H.class.getName().length() & 86018232) + (((-r13) - 1) | (-1074010129)) + (624476329 & (706308678 + i8 + (((-i8) - 1) | (-706308678))));
                        int i9 = ~H.class.getName().length();
                        bArr8[(((-1698486459) & length8) * 2) + (1698486458 - length8)] = ((((H.class.getName().length() | 579556544) - (i9 | (-488679701))) + ((((-488876373) | i9) - H.class.getName().length()) + (H.class.getName().length() & 579556544))) + ((H.class.getName().length() & 1275265089) | 1291845899)) ^ 1871402404;
                        int i10 = ((~H.class.getName().length()) | (-183482126)) & 1663325341;
                        int length9 = H.class.getName().length();
                        int length10 = i10 + ((((H.class.getName().length() | 36975661) - (length9 | 36975661)) + (length9 - H.class.getName().length()) + (H.class.getName().length() & 36975661)) | 1057570);
                        bArr8[(length10 | 1664382907) - (length10 & 1664382907)] = 88;
                        bArr8[5] = -124;
                        bArr8[6] = -109;
                        bArr8[7] = 58;
                        bArr8[8] = 46;
                        bArr8[9] = 101;
                        bArr8[10] = 50;
                        bArr8[11] = 63;
                        long j128 = 1445023881;
                        long j129 = (~H.class.getName().length()) | (-1156181945);
                        long j130 = (((((((((j128 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j128 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j128 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j128 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j129 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j129 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j129 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j129 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j131 = (j130 >>> 48) & 43690;
                        long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
                        long j133 = ((j132 >>> 2) | j132) & 252645135;
                        long j134 = (j130 >>> 32) & 43690;
                        long j135 = ((j134 >>> 2) | (j134 >>> 1)) & 858993459;
                        long j136 = ((j135 >>> 2) | j135) & 252645135;
                        long j137 = ((((j136 >>> 4) | j136) & 16711935) << 16) | ((((j133 >>> 4) | j133) & 16711935) << 24);
                        long j138 = (j130 >>> 16) & 43690;
                        long j139 = ((j138 >>> 2) | (j138 >>> 1)) & 858993459;
                        long j140 = ((j139 >>> 2) | j139) & 252645135;
                        long j141 = j130 & 43690;
                        long j142 = ((j141 >>> 2) | (j141 >>> 1)) & 858993459;
                        long j143 = ((j142 >>> 2) | j142) & 252645135;
                        int i11 = (int) ((((j143 >>> 4) | j143) & 16711935) + (((((j140 >>> 4) | j140) & 16711935) << 8) | j137));
                        int length11 = H.class.getName().length();
                        int length12 = i11 + (553787648 | (((H.class.getName().length() | 1696809096) - (length11 | 1696809096)) + (length11 - H.class.getName().length()) + (H.class.getName().length() & 1696809096)));
                        bArr8[12] = (length12 - 1998811607) - ((length12 & (-1998811607)) * 2);
                        bArr8[13] = 19;
                        bArr8[14] = 87;
                        bArr8[15] = -49;
                        bArr8[16] = 20;
                        bArr8[17] = -81;
                        bArr8[18] = -127;
                        bArr8[19] = 5;
                        bArr8[20] = -69;
                        bArr8[21] = 42;
                        bArr8[22] = 108;
                        bArr8[23] = 120;
                        z(bArr7, bArr8);
                        charset2 = StandardCharsets.UTF_8;
                        intern = new String(bArr7, charset2).intern();
                        bArr2 = new byte[4];
                        bArr2[0] = -102;
                        bArr2[(-1045708029) ^ ((((1397746361 | r10) - 1065107454) - ((~H.class.getName().length()) | (-741348677))) + ((H.class.getName().length() & (-2139094782)) | 19399424))] = 118;
                        bArr2[2] = -57;
                        bArr2[3] = -45;
                        z(bArr2, new byte[]{-126, 22, 32, 20, -121, -124, 24, -93});
                    } catch (Exception e7) {
                        e = e7;
                    }
                    try {
                        t(intern, new String(bArr2, charset2).intern());
                    } catch (Exception e8) {
                        e = e8;
                        exc = e;
                        c5 = 54338;
                    }
                default:
            }
            return z3;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x004a. Please report as an issue. */
    public final boolean C(Context context) {
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            char c4 = 38768;
            while (true) {
                switch (c4) {
                    case 19328:
                        break;
                    case 35172:
                        z4 = false;
                        c4 = 22968;
                    case 64011:
                        byte[] bArr = new byte[23];
                        bArr[0] = -22;
                        bArr[1] = 27;
                        bArr[2] = -1;
                        int i = ~H.class.getName().length();
                        long j2 = 67643552;
                        long length = H.class.getName().length();
                        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        int i3 = (((65341016 | i) + 105385184) - (i | 132976376)) + (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | 1075879936);
                        long j17 = 1181265123;
                        long j18 = i3;
                        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        bArr[(int) ((((j32 >>> 4) | j32) & 16711935) + ((((j29 >>> 4) | j29) & 16711935) << 8) + j26)] = 108;
                        bArr[4] = -77;
                        bArr[5] = 18;
                        bArr[6] = 27;
                        bArr[7] = -118;
                        bArr[8] = -98;
                        bArr[9] = 55;
                        bArr[10] = -40;
                        bArr[11] = -76;
                        bArr[12] = 36;
                        bArr[13] = (((((~H.class.getName().length()) + (((-r8) - 1) | (-686218126))) + 686218126) & (-1390394730)) + ((H.class.getName().length() & (-1786085262)) | 277774432)) ^ 1112620331;
                        bArr[14] = -116;
                        bArr[15] = 16;
                        bArr[16] = Byte.MAX_VALUE;
                        bArr[17] = -70;
                        bArr[18] = -69;
                        bArr[19] = 43;
                        bArr[20] = 87;
                        bArr[21] = -56;
                        bArr[22] = 63;
                        int i4 = ~H.class.getName().length();
                        long j33 = -240955540;
                        long length2 = ((((-1893085418) | i4) + 173842560) - (i4 | (-1887572074))) + ((H.class.getName().length() & 5513424) | 67113040);
                        long j34 = ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j35 = (j34 >>> 48) & 21845;
                        long j36 = ((j35 >>> 1) | j35) & 858993459;
                        long j37 = ((j36 >>> 2) | j36) & 252645135;
                        long j38 = (j34 >>> 32) & 21845;
                        long j39 = ((j38 >>> 1) | j38) & 858993459;
                        long j40 = ((j39 >>> 2) | j39) & 252645135;
                        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
                        long j42 = (j34 >>> 16) & 21845;
                        long j43 = ((j42 >>> 1) | j42) & 858993459;
                        long j44 = ((j43 >>> 2) | j43) & 252645135;
                        long j45 = j34 & 21845;
                        long j46 = ((j45 >>> 1) | j45) & 858993459;
                        long j47 = ((j46 >>> 2) | j46) & 252645135;
                        D(bArr, new byte[]{-125, 104, -84, 9, -57, 102, 114, -28, -7, 118, (int) ((((j47 >>> 4) | j47) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41)), -42, 115, -76, -22, 121, 58, ((((~H.class.getName().length()) | 1750005044) & 4874520) + ((H.class.getName().length() & 1879146536) | 1913749536)) ^ (-1918624020), -38, 73, 59, -83, 91});
                        Charset charset = StandardCharsets.UTF_8;
                        String intern = new String(bArr, charset).intern();
                        byte[] bArr2 = {-100, 103, -122, -51};
                        byte[] bArr3 = new byte[8];
                        bArr3[0] = -24;
                        bArr3[1] = 21;
                        bArr3[2] = -13;
                        bArr3[3] = -88;
                        bArr3[4] = -82;
                        long j48 = 101896168;
                        long j49 = (~H.class.getName().length()) | 185564343;
                        long j50 = (((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j51 = (j50 >>> 48) & 43690;
                        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                        long j53 = (j52 | (j52 >>> 2)) & 252645135;
                        long j54 = (j50 >>> 32) & 43690;
                        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
                        long j56 = ((j55 >>> 2) | j55) & 252645135;
                        long j57 = (((j53 | (j53 >>> 4)) & 16711935) << 24) | ((((j56 >>> 4) | j56) & 16711935) << 16);
                        long j58 = (j50 >>> 16) & 43690;
                        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                        long j60 = ((j59 >>> 2) | j59) & 252645135;
                        long j61 = j50 & 43690;
                        long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
                        long j63 = (j62 | (j62 >>> 2)) & 252645135;
                        int i5 = ~((H.class.getName().length() & 1947239240) | 2030370816);
                        int i6 = -((int) (((j63 | (j63 >>> 4)) & 16711935) + (j57 | ((((j60 >>> 4) | j60) & 16711935) << 8))));
                        bArr3[V2.a(~i6, i5, (i5 + i6) + 1) ^ 2132266989] = 87;
                        bArr3[6] = -114;
                        bArr3[7] = -25;
                        D(bArr2, bArr3);
                        try {
                            t(intern, new String(bArr2, charset).intern());
                            c4 = 6922;
                        } catch (Exception unused) {
                            c4 = 38739;
                        }
                    case 22968:
                        if (z4) {
                            c4 = 64011;
                            z3 = z4;
                        } else {
                            z3 = z4;
                            c4 = 6922;
                        }
                    case 38739:
                        z3 = false;
                        c4 = 19328;
                    case 46935:
                        c4 = 19328;
                    case 6922:
                        c4 = 46935;
                    case 41091:
                        c4 = 22968;
                        z4 = true;
                    case 38768:
                        try {
                            ContentResolver contentResolver = context.getContentResolver();
                            byte[] bArr4 = new byte[16];
                            bArr4[0] = 33;
                            bArr4[1] = ((((~H.class.getName().length()) | (-575073482)) & 243796484) + ((H.class.getName().length() & 301991936) | 805441569)) ^ 1049238073;
                            bArr4[2] = 28;
                            bArr4[3] = -6;
                            bArr4[4] = -108;
                            bArr4[5] = 2;
                            bArr4[6] = -105;
                            int length3 = (((~H.class.getName().length()) | (-572602869)) & (-1912447982)) + ((H.class.getName().length() & 50371120) | 25723680);
                            bArr4[((length3 & 1886724298) * 2) + ((-1886724299) - length3)] = -52;
                            bArr4[8] = 85;
                            int i7 = ((~H.class.getName().length()) | (-1820472002)) & 1764278568;
                            int length4 = (H.class.getName().length() & 1744834564) | 269628422;
                            int i8 = -i7;
                            bArr4[2033906983 ^ ((((~i8) & length4) * 2) - (i8 ^ length4))] = -73;
                            bArr4[10] = -65;
                            bArr4[11] = 84;
                            bArr4[12] = 104;
                            bArr4[13] = -13;
                            bArr4[14] = 101;
                            bArr4[15] = -110;
                            byte[] bArr5 = new byte[16];
                            bArr5[0] = 64;
                            bArr5[1] = 120;
                            bArr5[2] = 126;
                            bArr5[(((((-1) - H.class.getName().length()) | (-58658789)) & 1680080921) + ((H.class.getName().length() & 10748930) | 12747906)) ^ 1692828824] = -91;
                            bArr5[4] = -29;
                            long j64 = -2120843400;
                            long length5 = (((~H.class.getName().length()) | (-576906881)) & 8661309) + ((H.class.getName().length() & 160320) | (-2129504704));
                            long j65 = (((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j66 = (j65 >>> 48) & 21845;
                            long j67 = ((j66 >>> 1) | j66) & 858993459;
                            long j68 = ((j67 >>> 2) | j67) & 252645135;
                            long j69 = (j65 >>> 32) & 21845;
                            long j70 = ((j69 >>> 1) | j69) & 858993459;
                            long j71 = ((j70 >>> 2) | j70) & 252645135;
                            long j72 = ((((j71 >>> 4) | j71) & 16711935) << 16) | ((((j68 >>> 4) | j68) & 16711935) << 24);
                            long j73 = (j65 >>> 16) & 21845;
                            long j74 = ((j73 >>> 1) | j73) & 858993459;
                            long j75 = ((j74 >>> 2) | j74) & 252645135;
                            long j76 = ((((j75 >>> 4) | j75) & 16711935) << 8) + j72;
                            long j77 = j65 & 21845;
                            long j78 = (j77 | (j77 >>> 1)) & 858993459;
                            long j79 = (j78 | (j78 >>> 2)) & 252645135;
                            bArr5[(int) (((j79 | (j79 >>> 4)) & 16711935) | j76)] = 107;
                            long j80 = -1;
                            long length6 = H.class.getName().length();
                            long j81 = (((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j82 = (j81 >>> 48) & 21845;
                            long j83 = (j82 | (j82 >>> 1)) & 858993459;
                            long j84 = (j83 | (j83 >>> 2)) & 252645135;
                            long j85 = (j81 >>> 32) & 21845;
                            long j86 = ((j85 >>> 1) | j85) & 858993459;
                            long j87 = ((j86 >>> 2) | j86) & 252645135;
                            long j88 = ((((j87 >>> 4) | j87) & 16711935) << 16) + (((j84 | (j84 >>> 4)) & 16711935) << 24);
                            long j89 = (j81 >>> 16) & 21845;
                            long j90 = ((j89 >>> 1) | j89) & 858993459;
                            long j91 = ((j90 >>> 2) | j90) & 252645135;
                            long j92 = j81 & 21845;
                            long j93 = (j92 | (j92 >>> 1)) & 858993459;
                            long j94 = (j93 | (j93 >>> 2)) & 252645135;
                            int i9 = (((int) (((((j91 >>> 4) | j91) & 16711935) << 8) | j88 | ((j94 | (j94 >>> 4)) & 16711935))) | 1783893942) & 682762818;
                            int length7 = (H.class.getName().length() & 10641505) | 18481;
                            bArr5[682781301 ^ ((length7 & i9) + (i9 | length7))] = -15;
                            bArr5[7] = -91;
                            bArr5[8] = 10;
                            bArr5[9] = -46;
                            bArr5[10] = -47;
                            bArr5[11] = 53;
                            bArr5[12] = 10;
                            bArr5[13] = -97;
                            bArr5[14] = 0;
                            bArr5[15] = -10;
                            D(bArr4, bArr5);
                            c4 = Settings.Global.getInt(contentResolver, new String(bArr4, StandardCharsets.UTF_8).intern(), 0) == 1 ? (char) 41091 : (char) 35172;
                        } catch (Exception unused2) {
                            c4 = 38739;
                        }
                }
                return z3;
            }
        }
    }

    @Override // F0.T2
    public final void a(Context context) {
        byte[] bArr = new byte[7];
        bArr[0] = 109;
        bArr[1] = -31;
        bArr[2] = -57;
        int i = 1342457297 & ((-95360236) - ((~(~H.class.getName().length())) | (-95360235)));
        int length = H.class.getName().length() & 394432;
        bArr[S.a(length, ((-length) - 1) | 2080176125, -2080176125, i) ^ (-737718832)] = 65;
        bArr[4] = -125;
        bArr[5] = 63;
        bArr[6] = -22;
        int i3 = ((~H.class.getName().length()) | (-1261175867)) & 453023656;
        long j2 = 1270875241;
        long length2 = H.class.getName().length();
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        int i4 = ((int) (((j16 | (j16 >>> 4)) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | (-524287935);
        int i5 = -i3;
        z(bArr, new byte[]{106, -68, (-71264306) ^ ((((~i5) & i4) * 2) - (i4 ^ i5)), -105, -26, 71, -98, -10});
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
        A(context);
    }
}
