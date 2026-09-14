package F0;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class Z2 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f451f;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0266, code lost:
    
        if (r3 != 0) goto L19;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x01f3. Please report as an issue. */
    static {
        /*
            Method dump skipped, instructions count: 970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.Z2.<clinit>():void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z2(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = new byte[6];
        int i = ((~Z2.class.getName().length()) | 818189150) & (-963112892);
        long j2 = -971505664;
        long length = Z2.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        bArr[(i + (((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) | 2163968)) ^ (-960948924)] = 76;
        bArr[1] = 116;
        bArr[2] = 30;
        bArr[3] = 66;
        bArr[4] = -47;
        bArr[5] = -64;
        v(bArr, new byte[]{-100, 14, -9, -61, -76, -78, 45, 57});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = new byte[8];
        bArr2[0] = 35;
        bArr2[1] = 56;
        bArr2[((((~Z2.class.getName().length()) | (-756773562)) & 1613019408) + ((Z2.class.getName().length() & 537408208) | R.drawable.emo_im_embarrassed)) ^ 1630321630] = -39;
        bArr2[3] = 9;
        bArr2[4] = 89;
        bArr2[5] = -41;
        bArr2[6] = 98;
        bArr2[7] = -97;
        v(bArr2, new byte[]{-75, 64, 42, 15, -119, -83, -69, 111});
        new String(bArr2, charset).intern();
        byte[] bArr3 = {63, -58, -37, 66, 63, -13};
        D(bArr3, new byte[]{83, -87, -68, 37, 90, -127, -30, 116});
        new String(bArr3, charset).intern();
        byte[] bArr4 = new byte[8];
        bArr4[0] = -116;
        int length2 = Z2.class.getName().length();
        int i3 = ((~length2) - length2) + length2;
        int i4 = ((1796168321 | i3) + 23189) - (i3 | 1796168341);
        int length3 = Z2.class.getName().length() & 67207188;
        bArr4[(((((((~length3) & Z2.class.getName().length()) & 338002176) + 338002176) + length3) - ((Z2.class.getName().length() | length3) & 338002176)) + i4) ^ 338025364] = 78;
        bArr4[2] = 12;
        bArr4[3] = ((((~Z2.class.getName().length()) | 1462344027) & 1141135441) + ((Z2.class.getName().length() & 409760) | (-1844838240))) ^ (-703702799);
        bArr4[4] = 5;
        bArr4[5] = 6;
        long j17 = 971594634;
        long length4 = (((~Z2.class.getName().length()) | (-1015166232)) & 165697672) + ((Z2.class.getName().length() & 411046400) | 805896964);
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j19 = (j18 >>> 48) & 21845;
        long j20 = (j19 | (j19 >>> 1)) & 858993459;
        long j21 = (j20 | (j20 >>> 2)) & 252645135;
        long j22 = (j18 >>> 32) & 21845;
        long j23 = (j22 | (j22 >>> 1)) & 858993459;
        long j24 = (j23 | (j23 >>> 2)) & 252645135;
        long j25 = (((j21 | (j21 >>> 4)) & 16711935) << 24) | (((j24 | (j24 >>> 4)) & 16711935) << 16);
        long j26 = (j18 >>> 16) & 21845;
        long j27 = (j26 | (j26 >>> 1)) & 858993459;
        long j28 = (j27 | (j27 >>> 2)) & 252645135;
        long j29 = j18 & 21845;
        long j30 = (j29 | (j29 >>> 1)) & 858993459;
        long j31 = (j30 | (j30 >>> 2)) & 252645135;
        bArr4[(int) (((j31 | (j31 >>> 4)) & 16711935) + (j25 | (((j28 | (j28 >>> 4)) & 16711935) << 8)))] = 103;
        bArr4[7] = ((((~Z2.class.getName().length()) | 843557726) & 144012193) + ((Z2.class.getName().length() & (-2003808095)) | (-1069416438))) ^ (-925404267);
        D(bArr4, new byte[]{-2, 43, 109, 99, 113, 111, 8, 80});
        new String(bArr4, charset).intern();
        this.f451f = c0054l1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void C(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void v(byte[] bArr, byte[] bArr2) {
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
    public static void x(byte[] bArr, byte[] bArr2) {
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

    public final void A(Context context) {
        long j2 = 1674819924;
        long f4 = AbstractC0008a.f(Z2.class, -1);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
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
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        byte[] bArr = {-127, 120, 72, -118, 24, ((((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) & 822191114) + ((Z2.class.getName().length() & 277087370) | 8781953)) ^ 830973073, -62};
        v(bArr, new byte[]{70, 9, -44, -104, 125, 98, -74, -15});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        C0031f2 n4 = T0.n(new C0016c(this, context, 13));
        byte[] bArr2 = {49, 16, 101, 83, 88, 91};
        C(bArr2, new byte[]{-89, -104, -91, -64, 52, 47, -121, 45});
        new String(bArr2, charset).intern();
        C0054l1 c0054l1 = this.f451f;
        C0047j2 c0047j2 = c0054l1.f573a;
        C0047j2 c0047j22 = c0054l1.f573a;
        c0047j2.l();
        int i = ((~Z2.class.getName().length()) | 2146270647) - 1806507319;
        int length = (Z2.class.getName().length() & (-2012052918)) | 136577074;
        long j17 = 1669930356;
        long j18 = (length & i) + (i | length);
        long j19 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        byte b4 = (int) (((((j29 >>> 4) | j29) & 16711935) << 8) | j26 | (((j32 >>> 4) | j32) & 16711935));
        long j33 = -1;
        long length2 = Z2.class.getName().length();
        long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        int length3 = ((((int) ((((j47 >>> 4) | j47) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) | j41))) | (-3228163)) - (-1349601795)) + ((Z2.class.getName().length() & 3359250) | 8519832);
        long j48 = -1358121695;
        long j49 = length3;
        long j50 = ((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j51 = (j50 >>> 48) & 21845;
        long j52 = (j51 | (j51 >>> 1)) & 858993459;
        long j53 = (j52 | (j52 >>> 2)) & 252645135;
        long j54 = (j50 >>> 32) & 21845;
        long j55 = (j54 | (j54 >>> 1)) & 858993459;
        long j56 = (j55 | (j55 >>> 2)) & 252645135;
        long j57 = (((j56 | (j56 >>> 4)) & 16711935) << 16) + (((j53 | (j53 >>> 4)) & 16711935) << 24);
        long j58 = (j50 >>> 16) & 21845;
        long j59 = (j58 | (j58 >>> 1)) & 858993459;
        long j60 = (j59 | (j59 >>> 2)) & 252645135;
        long j61 = j50 & 21845;
        long j62 = (j61 | (j61 >>> 1)) & 858993459;
        long j63 = (j62 | (j62 >>> 2)) & 252645135;
        byte[] bArr3 = {b4, 97, 116, -29, -118, (int) (((j63 | (j63 >>> 4)) & 16711935) + (((j60 | (j60 >>> 4)) & 16711935) << 8) + j57), -51};
        C(bArr3, new byte[]{86, 42, -112, 8, -27, -33, -88, -27});
        d(new String(bArr3, charset).intern(), n4);
        if (n4.b()) {
            byte[] bArr4 = {-35, 118, 53, -108, 23, -59, -102};
            C(bArr4, new byte[]{-27, 1, -47, -69, 120, -95, -1, 4});
            String intern = new String(bArr4, charset).intern();
            c0047j22.l();
            c(intern);
        }
        if (n4.a()) {
            Integer l3 = c0047j22.l();
            byte[] bArr5 = {121, 52, 104, -69, -116, 91, -95};
            C(bArr5, new byte[]{121, 71, -84, 80, -29, 63, -60, 118});
            c0054l1.c(new String(bArr5, charset).intern(), l3);
        }
    }

    public final boolean B(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            byte[] bArr = new byte[28];
            bArr[0] = 11;
            bArr[1] = -62;
            bArr[2] = -95;
            bArr[3] = -112;
            bArr[4] = -18;
            bArr[5] = -67;
            bArr[6] = -51;
            bArr[7] = -103;
            bArr[8] = -31;
            bArr[9] = -83;
            bArr[10] = -107;
            bArr[11] = -59;
            bArr[12] = -71;
            int i = ((~Z2.class.getName().length()) | (-1190443538)) & 1109214080;
            int length = Z2.class.getName().length() & 1117028864;
            int a2 = S.a(length, ((-length) - 1) | (-545293315), 545293315, i);
            long j2 = 1654507480;
            long j3 = a2;
            long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
            long j15 = j4 & 21845;
            long j16 = ((j15 >>> 1) | j15) & 858993459;
            long j17 = ((j16 >>> 2) | j16) & 252645135;
            bArr[13] = (int) ((((j17 >>> 4) | j17) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11);
            bArr[14] = -122;
            bArr[15] = (((((-1) - Z2.class.getName().length()) | (-411693260)) & (-1063779759)) + ((Z2.class.getName().length() & 311099457) | 302187528)) ^ 761592204;
            bArr[16] = 60;
            bArr[17] = -18;
            bArr[18] = -121;
            bArr[19] = -23;
            long j18 = 10749712;
            long j19 = (~Z2.class.getName().length()) | 1839498980;
            long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
            long j31 = ((((j30 >>> 4) | j30) & 16711935) << 8) + j27;
            long j32 = j20 & 43690;
            long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
            long j34 = (j33 | (j33 >>> 2)) & 252645135;
            int i3 = (int) (((j34 | (j34 >>> 4)) & 16711935) + j31);
            int length2 = Z2.class.getName().length();
            int i4 = (length2 | 537919760) - (length2 ^ 537919760);
            int i5 = (i4 + 890372096) - (890372096 & i4);
            bArr[20] = AbstractC0099x.a(i3 | i5, 2, (~i3) ^ i5) ^ (-901121900);
            bArr[21] = 13;
            int length3 = Z2.class.getName().length();
            int i6 = ((-436586034) | ((length3 - 1) - (length3 * 2))) & 113541744;
            int length4 = (Z2.class.getName().length() & 34392624) | 17319936;
            bArr[22] = (((length4 | i6) - ((Z2.class.getName().length() & (~i6)) & length4)) + ((Z2.class.getName().length() | i6) & length4)) ^ (-130861669);
            bArr[23] = 118;
            bArr[24] = 46;
            bArr[25] = Byte.MIN_VALUE;
            long j35 = -847503376;
            long j36 = ~Z2.class.getName().length();
            long j37 = (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
            long j38 = (j37 >>> 48) & 43690;
            long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
            long j40 = ((j39 >>> 2) | j39) & 252645135;
            long j41 = (j37 >>> 32) & 43690;
            long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
            long j43 = ((j42 >>> 2) | j42) & 252645135;
            long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) + ((((j40 >>> 4) | j40) & 16711935) << 24);
            long j45 = (j37 >>> 16) & 43690;
            long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
            long j47 = ((j46 >>> 2) | j46) & 252645135;
            long j48 = j37 & 43690;
            long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
            long j50 = ((j49 >>> 2) | j49) & 252645135;
            int length5 = Z2.class.getName().length() & 545423466;
            bArr[1626774132 ^ ((((~length5) & 164460) + length5) + (((int) ((((j50 >>> 4) | j50) & 16711935) + (((((j47 >>> 4) | j47) & 16711935) << 8) | j44))) & 1626609666))] = 27;
            bArr[27] = -71;
            byte[] bArr2 = new byte[28];
            bArr2[0] = 3;
            bArr2[1] = -111;
            bArr2[2] = 73;
            bArr2[3] = 87;
            bArr2[4] = -2;
            bArr2[5] = -32;
            bArr2[6] = 47;
            bArr2[7] = 86;
            bArr2[8] = -24;
            bArr2[9] = -15;
            bArr2[10] = 115;
            bArr2[11] = 4;
            bArr2[12] = -82;
            bArr2[13] = 9;
            bArr2[14] = 96;
            bArr2[15] = 3;
            bArr2[16] = 49;
            bArr2[17] = -78;
            long j51 = -1;
            long length6 = Z2.class.getName().length();
            long j52 = ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j53 = (j52 >>> 48) & 21845;
            long j54 = ((j53 >>> 1) | j53) & 858993459;
            long j55 = ((j54 >>> 2) | j54) & 252645135;
            long j56 = (j52 >>> 32) & 21845;
            long j57 = ((j56 >>> 1) | j56) & 858993459;
            long j58 = ((j57 >>> 2) | j57) & 252645135;
            long j59 = ((((j58 >>> 4) | j58) & 16711935) << 16) + ((((j55 >>> 4) | j55) & 16711935) << 24);
            long j60 = (j52 >>> 16) & 21845;
            long j61 = ((j60 >>> 1) | j60) & 858993459;
            long j62 = ((j61 >>> 2) | j61) & 252645135;
            long j63 = j52 & 21845;
            long j64 = ((j63 >>> 1) | j63) & 858993459;
            long j65 = ((j64 >>> 2) | j64) & 252645135;
            long j66 = -799322892;
            long length7 = ((((int) ((((j65 >>> 4) | j65) & 16711935) + ((((j62 >>> 4) | j62) & 16711935) << 8) + j59)) | 1537172827) & (-804060988)) + ((Z2.class.getName().length() & (-2147481466)) | 4738082);
            long j67 = ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j68 = (j67 >>> 48) & 21845;
            long j69 = ((j68 >>> 1) | j68) & 858993459;
            long j70 = ((j69 >>> 2) | j69) & 252645135;
            long j71 = (j67 >>> 32) & 21845;
            long j72 = ((j71 >>> 1) | j71) & 858993459;
            long j73 = ((j72 >>> 2) | j72) & 252645135;
            long j74 = ((((j73 >>> 4) | j73) & 16711935) << 16) | ((((j70 >>> 4) | j70) & 16711935) << 24);
            long j75 = (j67 >>> 16) & 21845;
            long j76 = ((j75 >>> 1) | j75) & 858993459;
            long j77 = ((j76 >>> 2) | j76) & 252645135;
            long j78 = j67 & 21845;
            long j79 = (j78 | (j78 >>> 1)) & 858993459;
            long j80 = (j79 | (j79 >>> 2)) & 252645135;
            bArr2[(int) (((j80 | (j80 >>> 4)) & 16711935) + ((((j77 >>> 4) | j77) & 16711935) << 8) + j74)] = 94;
            bArr2[19] = 60;
            int i7 = 1363156631 & ((-1277901634) - ((~(~Z2.class.getName().length())) | (-1277901633)));
            int length8 = Z2.class.getName().length() & 1076894208;
            long j81 = -1937645520;
            long j82 = i7 + (~(((Z2.class.getName().length() | (-574488865)) | length8) - (length8 | (Z2.class.getName().length() & 574488864))));
            long j83 = (((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
            long j84 = (j83 >>> 48) & 21845;
            long j85 = ((j84 >>> 1) | j84) & 858993459;
            long j86 = ((j85 >>> 2) | j85) & 252645135;
            long j87 = (j83 >>> 32) & 21845;
            long j88 = ((j87 >>> 1) | j87) & 858993459;
            long j89 = ((j88 >>> 2) | j88) & 252645135;
            long j90 = ((((j89 >>> 4) | j89) & 16711935) << 16) + ((((j86 >>> 4) | j86) & 16711935) << 24);
            long j91 = (j83 >>> 16) & 21845;
            long j92 = ((j91 >>> 1) | j91) & 858993459;
            long j93 = ((j92 >>> 2) | j92) & 252645135;
            long j94 = j83 & 21845;
            long j95 = ((j94 >>> 1) | j94) & 858993459;
            long j96 = ((j95 >>> 2) | j95) & 252645135;
            bArr2[20] = (int) ((((((j93 >>> 4) | j93) & 16711935) << 8) + j90) | (((j96 >>> 4) | j96) & 16711935));
            bArr2[21] = 94;
            bArr2[22] = 11;
            bArr2[23] = -75;
            bArr2[24] = 40;
            bArr2[25] = -38;
            bArr2[26] = -52;
            bArr2[27] = Byte.MAX_VALUE;
            z(bArr, bArr2);
            Charset charset = StandardCharsets.UTF_8;
            boolean z3 = Settings.Global.getInt(contentResolver, new String(bArr, charset).intern(), 0) == 1;
            if (!z3) {
                return z3;
            }
            byte[] bArr3 = new byte[22];
            bArr3[0] = -73;
            bArr3[1] = -15;
            bArr3[((((~Z2.class.getName().length()) | 1781403679) & 1082429570) + ((Z2.class.getName().length() & 8569984) | (-2147335168))) ^ (-1064905600)] = -24;
            int i8 = ~Z2.class.getName().length();
            long j97 = 1310439171;
            boolean z4 = z3;
            long length9 = (((i8 + (((-i8) - 1) | 675796188)) - 675796188) & 202966820) + ((Z2.class.getName().length() & 1208194052) | 1107472384);
            long j98 = ((((((((j97 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j97 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j97 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j97 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j99 = (j98 >>> 48) & 21845;
            long j100 = ((j99 >>> 1) | j99) & 858993459;
            long j101 = ((j100 >>> 2) | j100) & 252645135;
            long j102 = (j98 >>> 32) & 21845;
            long j103 = ((j102 >>> 1) | j102) & 858993459;
            long j104 = ((j103 >>> 2) | j103) & 252645135;
            long j105 = ((((j104 >>> 4) | j104) & 16711935) << 16) | ((((j101 >>> 4) | j101) & 16711935) << 24);
            long j106 = (j98 >>> 16) & 21845;
            long j107 = ((j106 >>> 1) | j106) & 858993459;
            long j108 = ((j107 >>> 2) | j107) & 252645135;
            long j109 = ((((j108 >>> 4) | j108) & 16711935) << 8) + j105;
            long j110 = j98 & 21845;
            long j111 = (j110 | (j110 >>> 1)) & 858993459;
            long j112 = (j111 | (j111 >>> 2)) & 252645135;
            try {
                bArr3[3] = (int) (((j112 | (j112 >>> 4)) & 16711935) | j109);
                bArr3[4] = 36;
                bArr3[5] = ((((~Z2.class.getName().length()) | (-1123345217)) & (-108779984)) + ((Z2.class.getName().length() & 1149510400) | 104990982)) ^ 3788931;
                bArr3[6] = 85;
                bArr3[7] = -97;
                bArr3[8] = -107;
                bArr3[9] = -58;
                bArr3[10] = -19;
                bArr3[11] = 68;
                bArr3[12] = 5;
                bArr3[13] = -5;
                bArr3[14] = 98;
                bArr3[15] = 0;
                bArr3[16] = -75;
                bArr3[17] = 20;
                bArr3[18] = -73;
                bArr3[19] = -93;
                bArr3[20] = 70;
                bArr3[21] = 6;
                byte[] bArr4 = new byte[22];
                bArr4[0] = -70;
                bArr4[1] = -112;
                bArr4[2] = 94;
                bArr4[3] = -32;
                bArr4[4] = 62;
                bArr4[5] = -26;
                bArr4[6] = -117;
                bArr4[7] = 78;
                bArr4[8] = -127;
                bArr4[9] = -107;
                bArr4[10] = 9;
                bArr4[11] = -21;
                bArr4[12] = 22;
                bArr4[13] = -87;
                bArr4[14] = -75;
                bArr4[15] = -89;
                int i9 = ((~Z2.class.getName().length()) | (-1534987276)) & 1078257138;
                int length10 = Z2.class.getName().length() & 1096092678;
                bArr4[16] = S.a(length10, ((-length10) - 1) | 2093938675, -2093938675, i9) ^ 1015681625;
                long j113 = 671537251;
                long j114 = ~Z2.class.getName().length();
                long b4 = c3.b((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j114 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j114 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j114 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j114 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                long j115 = (b4 >>> 48) & 43690;
                long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
                long j117 = ((j116 >>> 2) | j116) & 252645135;
                long j118 = (b4 >>> 32) & 43690;
                long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
                long j120 = ((j119 >>> 2) | j119) & 252645135;
                long j121 = ((((j120 >>> 4) | j120) & 16711935) << 16) | ((((j117 >>> 4) | j117) & 16711935) << 24);
                long j122 = (b4 >>> 16) & 43690;
                long j123 = ((j122 >>> 2) | (j122 >>> 1)) & 858993459;
                long j124 = ((j123 >>> 2) | j123) & 252645135;
                long j125 = b4 & 43690;
                long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
                long j127 = ((j126 >>> 2) | j126) & 252645135;
                int i10 = ((int) ((((j127 >>> 4) | j127) & 16711935) + (((((j124 >>> 4) | j124) & 16711935) << 8) | j121))) & 2062950978;
                long j128 = -756014200;
                long length11 = Z2.class.getName().length();
                long j129 = ((((((((j128 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j128 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j128 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j128 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j130 = (j129 >>> 48) & 43690;
                long j131 = ((j130 >>> 2) | (j130 >>> 1)) & 858993459;
                long j132 = ((j131 >>> 2) | j131) & 252645135;
                long j133 = (j129 >>> 32) & 43690;
                long j134 = ((j133 >>> 2) | (j133 >>> 1)) & 858993459;
                long j135 = ((j134 >>> 2) | j134) & 252645135;
                long j136 = ((((j135 >>> 4) | j135) & 16711935) << 16) + ((((j132 >>> 4) | j132) & 16711935) << 24);
                long j137 = (j129 >>> 16) & 43690;
                long j138 = ((j137 >>> 2) | (j137 >>> 1)) & 858993459;
                long j139 = ((j138 >>> 2) | j138) & 252645135;
                long j140 = j129 & 43690;
                long j141 = ((j140 >>> 2) | (j140 >>> 1)) & 858993459;
                long j142 = ((j141 >>> 2) | j141) & 252645135;
                bArr4[(i10 + (((int) ((((j142 >>> 4) | j142) & 16711935) + (((((j139 >>> 4) | j139) & 16711935) << 8) | j136))) | (-2147384951))) ^ (-84433958)] = 91;
                bArr4[18] = 99;
                bArr4[19] = 109;
                bArr4[20] = 35;
                bArr4[21] = 98;
                z(bArr3, bArr4);
                String intern = new String(bArr3, charset).intern();
                byte[] bArr5 = {-23, -26, 101, 41};
                byte[] bArr6 = new byte[8];
                bArr6[0] = -15;
                bArr6[(-517776295) ^ ((((~Z2.class.getName().length()) | (-82770312)) & 553730136) + ((Z2.class.getName().length() & (-2145238016)) | (-1071506432)))] = -122;
                bArr6[2] = -126;
                bArr6[3] = -18;
                bArr6[4] = -5;
                bArr6[5] = -37;
                bArr6[6] = -38;
                bArr6[7] = -31;
                z(bArr5, bArr6);
                try {
                    t(intern, new String(bArr5, charset).intern());
                    return z4;
                } catch (Exception unused) {
                    return false;
                }
            } catch (Exception unused2) {
                return false;
            }
        } catch (Exception unused3) {
            return false;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00d9. Please report as an issue. */
    @Override // F0.T2
    public final void a(Context context) {
        int i;
        byte[] bArr;
        char c4;
        int i3;
        int i4;
        int i5;
        byte[] bArr2;
        int i6;
        int i7;
        byte[] bArr3 = new byte[7];
        int i8 = 0;
        bArr3[0] = ((((~Z2.class.getName().length()) | 1597208779) & 1091831872) + ((Z2.class.getName().length() & 442624) | 537051400)) ^ (-1628883248);
        int i9 = 1;
        bArr3[1] = 126;
        int i10 = 2;
        bArr3[2] = 64;
        int i11 = 3;
        bArr3[3] = 15;
        bArr3[(-692298038) ^ ((((~Z2.class.getName().length()) | (-1553400710)) & (-1774957376)) + ((Z2.class.getName().length() & 1419513990) | 1082659342))] = -60;
        bArr3[5] = -123;
        bArr3[6] = 11;
        int i12 = 8;
        char c5 = 4;
        byte[] bArr4 = {18, -30, 67, 98, -95, -3, Byte.MAX_VALUE, -34};
        byte[] bArr5 = null;
        int i13 = 1516727821;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        byte[] bArr6 = null;
        while (true) {
            int i17 = ((i13 & 16777216) * (i13 | 16777216)) + ((i13 & (-16777217)) * ((~i13) & 16777216));
            int i18 = i13 >>> i12;
            int i19 = i8;
            int a2 = j3.a((~i17) & 650911840 & i18, i18, i17, (i17 | 650911840) & i18);
            int i20 = (a2 ^ 642535957) + ((a2 & 642535957) * i10);
            switch (((~i20) + ((i20 | 1) * i10)) ^ 962785775) {
                case -1896910703:
                    int i21 = i9;
                    int i22 = i10;
                    byte[] bArr7 = bArr4;
                    char c6 = c5;
                    int i23 = i15;
                    int length = bArr6.length;
                    int i24 = 0 - i14;
                    int i25 = (length ^ i24) + ((length & i24) * 2);
                    byte b4 = bArr5[i25];
                    int length2 = bArr6.length;
                    int i26 = 0 - i24;
                    int i27 = i26 | length2;
                    byte b5 = bArr5[D.a(i26, i22, i27, (length2 ^ i26) ^ i27)];
                    bArr5[i25] = (byte) (((byte) (((byte) i22) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i15 = i23;
                    bArr4 = bArr7;
                    i9 = i21;
                    i10 = i22;
                    i8 = i19;
                    c5 = c6;
                    i12 = 8;
                    i11 = 3;
                    i13 = -746753280;
                case -1725904394:
                    i = i10;
                    bArr = bArr4;
                    c4 = c5;
                    i3 = i15;
                    i16 = bArr6.length % 4;
                    i4 = i9;
                    if ((((i16 > i4 ? 1 : (i16 == i4 ? 0 : -1)) >>> 31) & i4) != 0) {
                        int i28 = i4;
                        i13 = -458924450;
                        i9 = i28;
                        i15 = i3;
                        bArr4 = bArr;
                        i10 = i;
                        i8 = i19;
                        c5 = c4;
                        i12 = 8;
                        i11 = 3;
                    } else {
                        i15 = i3;
                        bArr4 = bArr;
                        i9 = i4;
                        i10 = i;
                        i8 = i19;
                        c5 = c4;
                        i12 = 8;
                        i11 = 3;
                        i13 = -365117735;
                    }
                case -1399959314:
                    c4 = c5;
                    int i29 = i15;
                    int a4 = j3.a(i29 & (-1205100636), i29, 3, i29 & (-1205100633));
                    byte b6 = bArr5[a4];
                    int i30 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i31 = i29 - 1;
                    int i32 = i31 - (i29 | (-3));
                    int i33 = bArr5[i32] & ForkServer.ERROR;
                    int i34 = i33 * ((~i33) & 65536);
                    int a5 = S.a(i34, i30, i9, ((-1) - i34) | ((-1) - i30));
                    int i35 = i31 - (i29 | (-2));
                    int i36 = bArr5[i35] & ForkServer.ERROR;
                    int i37 = i36 * ((~i36) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i38 = (i37 - i9) - ((~a5) | i37);
                    int i39 = bArr5[i29] & ForkServer.ERROR;
                    int a6 = S.a(i38, i39, i9, ((-1) - i38) | ((-1) - i39));
                    byte b7 = bArr6[a4];
                    int i40 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i41 = bArr6[i32] & ForkServer.ERROR;
                    i = i10;
                    int i42 = ((~i40) & (i41 * ((~i41) & 65536))) + i40;
                    int i43 = bArr6[i35] & ForkServer.ERROR;
                    int i44 = i43 * ((~i43) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i45 = ~((i42 | ((~i44) | 911399251)) - ((i44 & 911399251) | i42));
                    int i46 = bArr6[i29] & ForkServer.ERROR;
                    int i47 = ~((((~i45) | 1433568692) | i46) - ((i45 & 1433568692) | i46));
                    int i48 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i49 = (-1254002618) - ((i48 & 2) | ((-1672003491) - i48));
                    int i50 = (i49 + i47) - ((i49 & i47) * 2);
                    bArr6[i29] = (byte) i50;
                    bArr6[i35] = (byte) (i50 >>> 8);
                    bArr6[i32] = (byte) (i50 >>> 16);
                    bArr6[a4] = (byte) (i50 >>> 24);
                    i15 = (i29 ^ 4) + ((i29 & 4) * 2);
                    int length3 = bArr6.length;
                    int length4 = 0 - (bArr6.length % 4);
                    i5 = i9;
                    bArr2 = bArr4;
                    int i51 = ((i15 > AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 1 : (i15 == AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 0 : -1)) >>> 31) & i5;
                    if (i51 != 0) {
                        i13 = -1605440657;
                    } else {
                        i13 = -365117735;
                    }
                    if (i51 == 0) {
                        i13 = -169475207;
                    }
                    bArr4 = bArr2;
                    i9 = i5;
                    i10 = i;
                    i8 = i19;
                    c5 = c4;
                    i12 = 8;
                    i11 = 3;
                case -1135475043:
                    break;
                case 180635757:
                    bArr6 = bArr3;
                    bArr5 = bArr4;
                    i8 = i19;
                    i15 = i8;
                    i12 = 8;
                    i13 = -1605440657;
                case 511524454:
                    char c7 = c5;
                    int i52 = i15;
                    int length5 = bArr6.length;
                    int i53 = 0 - i14;
                    int i54 = 0 - i53;
                    int i55 = ((~length5) & i54) * i10;
                    int length6 = bArr6.length;
                    byte b8 = bArr6[((length6 | i53) * i10) - (length6 ^ i53)];
                    c4 = c7;
                    int length7 = bArr6.length;
                    byte b9 = bArr5[(length7 ^ i53) + ((length7 & i53) * 2)];
                    bArr6[(length5 ^ i54) - i55] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i10) * ((byte) ((~b9) & b8)))));
                    i16 = AbstractC0099x.a(i14, i11, (~i14) * i10);
                    if ((((i14 > i10 ? 1 : (i14 == i10 ? 0 : -1)) >>> 31) & i9) != 0) {
                        i4 = i9;
                        i = i10;
                        bArr = bArr4;
                        i3 = i52;
                        int i282 = i4;
                        i13 = -458924450;
                        i9 = i282;
                        i15 = i3;
                        bArr4 = bArr;
                        i10 = i;
                        i8 = i19;
                        c5 = c4;
                        i12 = 8;
                        i11 = 3;
                    } else {
                        i8 = i19;
                        i15 = i52;
                        c5 = c4;
                        i12 = 8;
                        i11 = 3;
                        i13 = -365117735;
                    }
                case 961838909:
                    int length8 = bArr6.length;
                    int i56 = 0 - i16;
                    char c8 = c5;
                    int i57 = i15;
                    if ((bArr5[((length8 | i56) - (((~i56) & 165327505) & length8)) + ((i56 | 165327505) & length8)] > Double.NaN ? 1 : (bArr5[((length8 | i56) - (((~i56) & 165327505) & length8)) + ((i56 | 165327505) & length8)] == Double.NaN ? 0 : -1)) <= -1) {
                        i6 = i19;
                    } else {
                        i6 = i9;
                    }
                    if (i6 != 0) {
                        i7 = -365117735;
                    } else {
                        i7 = 1093626513;
                    }
                    if (i6 != 0) {
                        i13 = -746753280;
                    } else {
                        i13 = i7;
                    }
                    c5 = c8;
                    i14 = i16;
                    i8 = i19;
                    i15 = i57;
                    i12 = 8;
                default:
                    i = i10;
                    bArr2 = bArr4;
                    c4 = c5;
                    i13 = -365117735;
                    i5 = i9;
                    bArr4 = bArr2;
                    i9 = i5;
                    i10 = i;
                    i8 = i19;
                    c5 = c4;
                    i12 = 8;
                    i11 = 3;
            }
            kotlin.jvm.internal.j.e(context, new String(bArr3, StandardCharsets.UTF_8).intern());
            A(context);
            return;
        }
    }
}
