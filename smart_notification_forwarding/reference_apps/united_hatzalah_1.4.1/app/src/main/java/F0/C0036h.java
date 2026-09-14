package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0036h implements InterfaceC0040i {

    /* renamed from: a, reason: collision with root package name */
    public static final C0036h f528a = new Object();

    public final boolean equals(Object obj) {
        if (this == obj || (obj instanceof C0036h)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int length = C0036h.class.getName().length();
        int i = ((~length) - length) + length;
        return 1603464529 ^ (((~(((C0036h.class.getName().length() | 537269423) | i) - (i | (C0036h.class.getName().length() & (-537269424))))) & 12731200) + ((C0036h.class.getName().length() & (-2146302976)) | (-1542454232)));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0306. Please report as an issue. */
    public final String toString() {
        int i;
        int i3;
        int i4;
        int i5;
        byte[] bArr = new byte[9];
        int i6 = 0;
        bArr[0] = -83;
        int i7 = 1;
        bArr[1] = 86;
        int i8 = 2;
        bArr[2] = 61;
        bArr[3] = 107;
        char c4 = 4;
        bArr[4] = -25;
        bArr[5] = -69;
        bArr[6] = Byte.MAX_VALUE;
        int i9 = ~C0036h.class.getName().length();
        bArr[856223555 ^ ((((C0036h.class.getName().length() | 839443012) - (i9 | 1049493087)) + (AbstractC0008a.f(C0036h.class, 210599003 | i9) + (C0036h.class.getName().length() & 839443012))) + ((C0036h.class.getName().length() & 855674372) | 16780544))] = 13;
        int i10 = 8;
        bArr[8] = 28;
        byte[] bArr2 = new byte[9];
        bArr2[0] = -29;
        bArr2[1] = 57;
        bArr2[2] = 113;
        int i11 = ((~C0036h.class.getName().length()) | 1833261388) & (-1476308950);
        long j2 = -2147450782;
        long length = C0036h.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        int i12 = i11 + (((int) ((((j16 >>> 4) | j16) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) | 2917056);
        long j17 = -1473391895;
        long j18 = i12;
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j20 = (j19 >>> 48) & 21845;
        long j21 = ((j20 >>> 1) | j20) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 21845;
        long j24 = ((j23 >>> 1) | j23) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 21845;
        long j31 = ((j30 >>> 1) | j30) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        bArr2[(int) ((((j32 >>> 4) | j32) & 16711935) | ((((j29 >>> 4) | j29) & 16711935) << 8) | j26)] = 4;
        bArr2[4] = Byte.MIN_VALUE;
        bArr2[5] = -36;
        bArr2[6] = 22;
        bArr2[7] = 99;
        bArr2[8] = 123;
        byte[] bArr3 = null;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = -585497720;
        byte[] bArr4 = null;
        while (true) {
            int i17 = ((i16 & 16777216) * (i16 | 16777216)) + ((i16 & (-16777217)) * ((~i16) & 16777216));
            int i18 = i16 >>> i10;
            int i19 = ~((((~i18) | (-238348293)) | i17) - ((i18 & (-238348293)) | i17));
            int i20 = (-1081514022) - ((i19 & i8) | ((-10362931) - i19));
            char c5 = c4;
            int i21 = 2100390411;
            int i22 = -897645243;
            switch (E1.a(i20 | (-428181225), i20, -428181225)) {
                case -1819084085:
                    i = i6;
                    i3 = i7;
                    i4 = i14;
                    int length2 = bArr3.length;
                    int i23 = 0 - i13;
                    int length3 = bArr3.length;
                    int i24 = 0 - i23;
                    byte b4 = bArr3[(length3 & (~i24)) - ((~length3) & i24)];
                    int length4 = bArr3.length;
                    byte b5 = bArr4[((length4 | i23) - (((-1678010279) & (~i23)) & length4)) + ((i23 | (-1678010279)) & length4)];
                    bArr3[((length2 | i23) * 2) - (length2 ^ i23)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i15 = 4 - ((5 - i13) | (i13 & 2));
                    i5 = 2;
                    int i25 = ((i13 > 2 ? 1 : (i13 == 2 ? 0 : -1)) >>> 31) & i3;
                    if (i25 == 0) {
                        i21 = -897645243;
                    }
                    if (i25 != 0) {
                        i6 = i;
                        i7 = i3;
                        i8 = 2;
                        c4 = c5;
                        i16 = i21;
                        i14 = i4;
                        i10 = 8;
                    } else {
                        i7 = i3;
                        i8 = i5;
                        i14 = i4;
                        i10 = 8;
                        i16 = -2079636786;
                        i6 = i;
                        c4 = c5;
                    }
                case -1350640889:
                    bArr4 = bArr2;
                    bArr3 = bArr;
                    i14 = i6;
                    c4 = c5;
                    i16 = -1469476344;
                case -477594107:
                    int i26 = i7;
                    int i27 = i8;
                    int length5 = bArr3.length;
                    int i28 = 0 - i13;
                    int i29 = ((length5 | i28) - (((-515406864) & (~i28)) & length5)) + ((i28 | (-515406864)) & length5);
                    byte b6 = bArr4[i29];
                    int length6 = bArr3.length;
                    byte b7 = bArr4[((i28 | length6) * 2) - (length6 ^ i28)];
                    int i30 = ((byte) 0) - b6;
                    int i31 = i30 | b7;
                    bArr4[i29] = (byte) (((byte) (((byte) i31) - ((byte) (((byte) i27) * ((byte) i30))))) + ((byte) ((b7 ^ i30) ^ i31)));
                    i6 = 0;
                    i7 = i26;
                    i16 = -1057239115;
                    c4 = c5;
                    i14 = i14;
                    i8 = 2;
                    i10 = 8;
                case 769572960:
                    break;
                case 783648904:
                    int i32 = i14;
                    int i33 = i32 + 4 + (((-1) - i32) | (-4));
                    byte b8 = bArr4[i33];
                    int i34 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i35 = i32 & 2;
                    int i36 = (i32 + 2) - i35;
                    int i37 = bArr4[i36] & ForkServer.ERROR;
                    int i38 = i37 * ((~i37) & 65536);
                    int i39 = ~((((~i38) | 467314697) | i34) - ((i38 & 467314697) | i34));
                    int i40 = (i32 + 1) - (i32 & 1);
                    int i41 = bArr4[i40] & ForkServer.ERROR;
                    int i42 = i41 * ((~i41) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i43 = ~((i39 | ((~i42) | 1328859631)) - ((i42 & 1328859631) | i39));
                    int i44 = bArr4[i32] & ForkServer.ERROR;
                    int a2 = S.a(i43, i44, i7, ((-1) - i43) | ((-1) - i44));
                    byte b9 = bArr3[i33];
                    int i45 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i46 = bArr3[i36] & ForkServer.ERROR;
                    int i47 = i8;
                    int i48 = i46 * ((~i46) & 65536);
                    int a4 = j3.a((~i45) & 1647046022 & i48, i48, i45, (i45 | 1647046022) & i48);
                    int i49 = bArr3[i40] & ForkServer.ERROR;
                    int i50 = i49 * ((~i49) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i51 = ~((a4 | ((~i50) | (-2059442874))) - ((i50 & (-2059442874)) | a4));
                    int i52 = bArr3[i32] & ForkServer.ERROR;
                    int a5 = S.a(i51, i52, i7, ((-1) - i51) | ((-1) - i52));
                    int i53 = i7;
                    int i54 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                    int i55 = (i54 + a5) - ((i54 & a5) * 2);
                    bArr3[i32] = (byte) i55;
                    bArr3[i40] = (byte) (i55 >>> 8);
                    bArr3[i36] = (byte) (i55 >>> 16);
                    bArr3[i33] = (byte) (i55 >>> 24);
                    i14 = (-11) - (((-15) - i32) | i35);
                    int length7 = bArr3.length;
                    int a6 = AbstractC0044j.a(bArr3.length);
                    int i56 = ((i14 > (((length7 & (~a6)) * 2) - (length7 ^ a6)) ? 1 : (i14 == (((length7 & (~a6)) * 2) - (length7 ^ a6)) ? 0 : -1)) >>> 31) & i53;
                    if (i56 == 0) {
                        i22 = 1251644638;
                    }
                    i7 = i53;
                    i8 = i47;
                    c4 = c5;
                    if (i56 != 0) {
                        i6 = 0;
                        i16 = -1469476344;
                    } else {
                        i16 = i22;
                        i6 = 0;
                    }
                    i10 = 8;
                case 1758587480:
                    i4 = i14;
                    int length8 = bArr3.length;
                    int i57 = 0 - i15;
                    if ((bArr4[((length8 | i57) - ((822835569 & (~i57)) & length8)) + ((i57 | 822835569) & length8)] > Double.NaN ? 1 : (bArr4[((length8 | i57) - ((822835569 & (~i57)) & length8)) + ((i57 | 822835569) & length8)] == Double.NaN ? 0 : -1)) <= -1) {
                        i16 = -897645243;
                    } else {
                        i16 = -1057239115;
                    }
                    i13 = i15;
                    c4 = c5;
                    i14 = i4;
                    i10 = 8;
                case 2013813686:
                    i15 = bArr3.length % 4;
                    i4 = i14;
                    int i58 = ((i15 > i7 ? 1 : (i15 == i7 ? 0 : -1)) >>> 31) & i7;
                    if (i58 == 0) {
                        i21 = -897645243;
                    }
                    if (i58 != 0) {
                        c4 = c5;
                        i16 = i21;
                        i14 = i4;
                        i10 = 8;
                    } else {
                        i = i6;
                        i3 = i7;
                        i5 = i8;
                        i7 = i3;
                        i8 = i5;
                        i14 = i4;
                        i10 = 8;
                        i16 = -2079636786;
                        i6 = i;
                        c4 = c5;
                    }
                default:
                    c4 = c5;
                    i16 = -897645243;
            }
            return new String(bArr, StandardCharsets.UTF_8).intern();
        }
    }
}
