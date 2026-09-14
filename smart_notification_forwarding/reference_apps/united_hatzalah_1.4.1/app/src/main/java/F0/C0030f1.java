package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.f1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0030f1 extends AbstractC0046j1 {

    /* renamed from: b, reason: collision with root package name */
    public static final C0030f1 f508b;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0321. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r0v0, types: [F0.j1, F0.f1] */
    static {
        byte[] bArr;
        byte[] bArr2;
        int i;
        int i3;
        int i4;
        int i5;
        byte[] bArr3 = new byte[9];
        int i6 = 0;
        bArr3[0] = -37;
        int i7 = 1;
        bArr3[1] = 46;
        int i8 = ((~C0030f1.class.getName().length()) | (-21656287)) & (-2092877502);
        int length = C0030f1.class.getName().length();
        bArr3[(i8 + (270009345 | ((length | 290993218) - (length ^ 290993218)))) ^ (-1822868159)] = 39;
        bArr3[3] = 62;
        bArr3[4] = 7;
        bArr3[5] = 694135834 ^ ((((C0030f1.class.getName().length() & 140192768) | 17335360) + (~(-(((~C0030f1.class.getName().length()) | (-192101853)) & 676800545)))) + 1);
        bArr3[6] = -47;
        bArr3[7] = 5;
        bArr3[8] = 6;
        long j2 = 1479892992;
        long j3 = (~C0030f1.class.getName().length()) | 1286595434;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j5 = (j4 >>> 48) & 43690;
        int i9 = 2;
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
        int i10 = (int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11));
        long j18 = 269486112;
        long length2 = C0030f1.class.getName().length();
        long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        byte[] bArr4 = {-71, 2117429281 ^ (i10 + (((int) (((j33 | (j33 >>> 4)) & 16711935) | j30)) | 637536355)), 72, 93, 108, 23, -72, 118, 114};
        byte[] bArr5 = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = -585497720;
        byte[] bArr6 = null;
        while (true) {
            int i15 = ((i14 & 16777216) * (i14 | 16777216)) + ((i14 & (-16777217)) * ((~i14) & 16777216));
            int i16 = i14 >>> 8;
            int i17 = ~((((~i16) | (-238348293)) | i15) - ((i16 & (-238348293)) | i15));
            int i18 = (-1081514022) - ((i17 & i9) | ((-10362931) - i17));
            int i19 = 2100390411;
            switch (E1.a(i18 | (-428181225), i18, -428181225)) {
                case -1819084085:
                    bArr = bArr4;
                    bArr2 = bArr6;
                    int i20 = i11;
                    i = i6;
                    int length3 = bArr5.length;
                    int i21 = 0 - i20;
                    int length4 = bArr5.length;
                    int i22 = 0 - i21;
                    byte b4 = bArr5[(length4 & (~i22)) - ((~length4) & i22)];
                    int length5 = bArr5.length;
                    byte b5 = bArr2[((length5 | i21) - (((-1678010279) & (~i21)) & length5)) + ((i21 | (-1678010279)) & length5)];
                    bArr5[((length3 | i21) * 2) - (length3 ^ i21)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i13 = 4 - ((5 - i20) | (i20 & 2));
                    i3 = i20;
                    i4 = 2;
                    i5 = 1;
                    int i23 = ((i3 > 2 ? 1 : (i3 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i23 == 0) {
                        i19 = -897645243;
                    }
                    if (i23 != 0) {
                        i11 = i3;
                        i6 = i;
                        i9 = 2;
                        bArr6 = bArr2;
                        i7 = 1;
                        i14 = i19;
                        bArr4 = bArr;
                    }
                    i11 = i3;
                    i6 = i;
                    i9 = i4;
                    bArr6 = bArr2;
                    i7 = i5;
                    i14 = -2079636786;
                    bArr4 = bArr;
                case -1350640889:
                    bArr5 = bArr3;
                    i12 = i6;
                    bArr6 = bArr4;
                    i14 = -1469476344;
                case -477594107:
                    byte[] bArr7 = bArr4;
                    byte[] bArr8 = bArr6;
                    int i24 = i9;
                    int i25 = i11;
                    int length6 = bArr5.length;
                    int i26 = 0 - i25;
                    int i27 = ((length6 | i26) - (((-515406864) & (~i26)) & length6)) + ((i26 | (-515406864)) & length6);
                    byte b6 = bArr8[i27];
                    int length7 = bArr5.length;
                    byte b7 = bArr8[((i26 | length7) * 2) - (length7 ^ i26)];
                    int i28 = ((byte) 0) - b6;
                    int i29 = i28 | b7;
                    bArr8[i27] = (byte) (((byte) (((byte) i29) - ((byte) (((byte) i24) * ((byte) i28))))) + ((byte) ((b7 ^ i28) ^ i29)));
                    i6 = 0;
                    bArr6 = bArr8;
                    i14 = -1057239115;
                    i11 = i25;
                    bArr4 = bArr7;
                    i7 = 1;
                    i9 = 2;
                case 769572960:
                    break;
                case 783648904:
                    int i30 = i9;
                    int i31 = i11;
                    int i32 = i12 + 4 + (((-1) - i12) | (-4));
                    byte b8 = bArr6[i32];
                    int i33 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i34 = i12 & 2;
                    int i35 = (i12 + 2) - i34;
                    int i36 = bArr6[i35] & ForkServer.ERROR;
                    int i37 = i36 * ((~i36) & 65536);
                    int i38 = ~((i33 | ((~i37) | 467314697)) - ((i37 & 467314697) | i33));
                    int i39 = (i12 + 1) - (i12 & 1);
                    int i40 = bArr6[i39] & ForkServer.ERROR;
                    int i41 = i40 * ((~i40) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i42 = ~(((1328859631 | (~i41)) | i38) - ((i41 & 1328859631) | i38));
                    int i43 = bArr6[i12] & ForkServer.ERROR;
                    int a2 = S.a(i42, i43, i7, ((-1) - i42) | ((-1) - i43));
                    byte b9 = bArr5[i32];
                    int i44 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i45 = bArr5[i35] & ForkServer.ERROR;
                    int i46 = i45 * ((~i45) & 65536);
                    byte[] bArr9 = bArr4;
                    int a4 = j3.a((~i44) & 1647046022 & i46, i46, i44, (i44 | 1647046022) & i46);
                    int i47 = bArr5[i39] & ForkServer.ERROR;
                    int i48 = i47 * ((~i47) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i49 = ~((a4 | ((~i48) | (-2059442874))) - ((i48 & (-2059442874)) | a4));
                    int i50 = bArr5[i12] & ForkServer.ERROR;
                    int a5 = S.a(i49, i50, 1, ((-1) - i49) | ((-1) - i50));
                    byte[] bArr10 = bArr6;
                    int i51 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                    int i52 = (i51 + a5) - ((i51 & a5) * 2);
                    bArr5[i12] = (byte) i52;
                    bArr5[i39] = (byte) (i52 >>> 8);
                    bArr5[i35] = (byte) (i52 >>> 16);
                    bArr5[i32] = (byte) (i52 >>> 24);
                    i12 = (-11) - (((-15) - i12) | i34);
                    int length8 = bArr5.length;
                    int a6 = AbstractC0044j.a(bArr5.length);
                    int i53 = ((i12 > (((length8 & (~a6)) * 2) - (length8 ^ a6)) ? 1 : (i12 == (((length8 & (~a6)) * 2) - (length8 ^ a6)) ? 0 : -1)) >>> 31) & 1;
                    if (i53 != 0) {
                        i14 = -897645243;
                    } else {
                        i14 = 1251644638;
                    }
                    bArr6 = bArr10;
                    i11 = i31;
                    i9 = i30;
                    if (i53 != 0) {
                        bArr4 = bArr9;
                        i6 = 0;
                        i7 = 1;
                        i14 = -1469476344;
                    } else {
                        bArr4 = bArr9;
                        i6 = 0;
                        i7 = 1;
                    }
                case 1758587480:
                    int i54 = i9;
                    int length9 = bArr5.length;
                    int i55 = 0 - i13;
                    if ((bArr6[((length9 | i55) - (((~i55) & 822835569) & length9)) + ((i55 | 822835569) & length9)] > Double.NaN ? 1 : (bArr6[((length9 | i55) - (((~i55) & 822835569) & length9)) + ((i55 | 822835569) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i14 = -897645243;
                    } else {
                        i14 = -1057239115;
                    }
                    i11 = i13;
                    i9 = i54;
                case 2013813686:
                    i13 = bArr5.length % 4;
                    i4 = i9;
                    int i56 = i11;
                    int i57 = ((i13 > i7 ? 1 : (i13 == i7 ? 0 : -1)) >>> 31) & i7;
                    if (i57 == 0) {
                        i19 = -897645243;
                    }
                    if (i57 != 0) {
                        i9 = i4;
                        i14 = i19;
                        i11 = i56;
                    } else {
                        bArr = bArr4;
                        i5 = i7;
                        bArr2 = bArr6;
                        i = i6;
                        i3 = i56;
                        i11 = i3;
                        i6 = i;
                        i9 = i4;
                        bArr6 = bArr2;
                        i7 = i5;
                        i14 = -2079636786;
                        bArr4 = bArr;
                    }
                default:
                    i14 = -897645243;
            }
            f508b = new AbstractC0046j1(new String(bArr3, StandardCharsets.UTF_8).intern());
            return;
        }
    }
}
