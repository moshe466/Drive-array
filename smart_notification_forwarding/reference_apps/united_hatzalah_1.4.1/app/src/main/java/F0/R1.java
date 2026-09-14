package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class R1 implements S1 {

    /* renamed from: a, reason: collision with root package name */
    public static final R1 f371a = new Object();

    public final boolean equals(Object obj) {
        if (this == obj || (obj instanceof R1)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return -1493369073;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00f9. Please report as an issue. */
    public final String toString() {
        byte[] bArr;
        char c4;
        int i;
        int i3;
        byte[] bArr2 = new byte[7];
        int i4 = 0;
        bArr2[0] = 48;
        int i5 = 1;
        bArr2[1] = -50;
        int i6 = 2;
        bArr2[2] = -63;
        bArr2[3] = 100;
        char c5 = 4;
        bArr2[4] = 119;
        bArr2[5] = 117;
        bArr2[((((~R1.class.getName().length()) | 1710619737) & 8444456) + ((R1.class.getName().length() & 268698144) | 889462784)) ^ 897907246] = -35;
        int i7 = ((~R1.class.getName().length()) | (-812049160)) & 1242335798;
        int length = R1.class.getName().length() & (-1325039034);
        byte length2 = 74610158 ^ ((((((R1.class.getName().length() & (~length)) & (-1316945848)) - 1316945848) + length) - ((R1.class.getName().length() | length) & (-1316945848))) + i7);
        int i8 = 8;
        char c6 = 24;
        byte[] bArr3 = {101, -96, -86, 10, 24, 2, -77, length2};
        byte[] bArr4 = null;
        int i9 = -585497720;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        byte[] bArr5 = null;
        while (true) {
            int i13 = ((i9 & 16777216) * (i9 | 16777216)) + ((i9 & (-16777217)) * ((~i9) & 16777216));
            int i14 = i9 >>> i8;
            int i15 = ~((((~i14) | (-238348293)) | i13) - ((i14 & (-238348293)) | i13));
            int i16 = (-1081514022) - ((i15 & i6) | ((-10362931) - i15));
            char c7 = c6;
            int i17 = 2100390411;
            switch (E1.a(i16 | (-428181225), i16, -428181225)) {
                case -1819084085:
                    bArr = bArr5;
                    c4 = c5;
                    int length3 = bArr4.length;
                    int i18 = 0 - i10;
                    int length4 = bArr4.length;
                    int i19 = 0 - i18;
                    byte b4 = bArr4[(length4 & (~i19)) - ((~length4) & i19)];
                    int length5 = bArr4.length;
                    byte b5 = bArr[((length5 | i18) - (((-1678010279) & (~i18)) & length5)) + ((i18 | (-1678010279)) & length5)];
                    bArr4[((length3 | i18) * 2) - (length3 ^ i18)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i12 = 4 - ((5 - i10) | (i10 & 2));
                    i = 2;
                    i3 = 1;
                    int i20 = ((i10 > 2 ? 1 : (i10 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i20 == 0) {
                        i17 = -897645243;
                    }
                    if (i20 != 0) {
                        bArr5 = bArr;
                        i6 = 2;
                        i5 = 1;
                        c6 = c7;
                        i9 = i17;
                        c5 = c4;
                        i4 = 0;
                        i8 = 8;
                    } else {
                        i6 = i;
                        c6 = c7;
                        c5 = c4;
                        i4 = 0;
                        i8 = 8;
                        i9 = -2079636786;
                        bArr5 = bArr;
                        i5 = i3;
                    }
                case -1350640889:
                    bArr4 = bArr2;
                    i11 = i4;
                    bArr5 = bArr3;
                    c6 = c7;
                    i9 = -1469476344;
                case -477594107:
                    byte[] bArr6 = bArr5;
                    int i21 = i6;
                    char c8 = c5;
                    int length6 = bArr4.length;
                    int i22 = 0 - i10;
                    int i23 = ((length6 | i22) - (((-515406864) & (~i22)) & length6)) + ((i22 | (-515406864)) & length6);
                    byte b6 = bArr6[i23];
                    int length7 = bArr4.length;
                    byte b7 = bArr6[((i22 | length7) * 2) - (length7 ^ i22)];
                    int i24 = ((byte) 0) - b6;
                    int i25 = i24 | b7;
                    bArr6[i23] = (byte) (((byte) (((byte) i25) - ((byte) (((byte) i21) * ((byte) i24))))) + ((byte) ((b7 ^ i24) ^ i25)));
                    bArr5 = bArr6;
                    i4 = 0;
                    i9 = -1057239115;
                    c6 = c7;
                    c5 = c8;
                    i5 = 1;
                    i6 = 2;
                    i8 = 8;
                case 769572960:
                    break;
                case 783648904:
                    char c9 = c5;
                    int i26 = i11 + 4 + (((-1) - i11) | (-4));
                    byte b8 = bArr5[i26];
                    int i27 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i28 = i11 & 2;
                    int i29 = (i11 + 2) - i28;
                    int i30 = bArr5[i29] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & 65536);
                    int i32 = ~((i27 | ((~i31) | 467314697)) - ((i31 & 467314697) | i27));
                    int i33 = (i11 + 1) - (i11 & 1);
                    int i34 = bArr5[i33] & ForkServer.ERROR;
                    int i35 = i6;
                    int i36 = i34 * ((~i34) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i37 = ~(((1328859631 | (~i36)) | i32) - ((i36 & 1328859631) | i32));
                    int i38 = bArr5[i11] & ForkServer.ERROR;
                    int a2 = S.a(i37, i38, i5, ((-1) - i37) | ((-1) - i38));
                    byte b9 = bArr4[i26];
                    int i39 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i40 = bArr4[i29] & ForkServer.ERROR;
                    int i41 = i40 * ((~i40) & 65536);
                    int a4 = j3.a((~i39) & 1647046022 & i41, i41, i39, (i39 | 1647046022) & i41);
                    int i42 = bArr4[i33] & ForkServer.ERROR;
                    int i43 = i42 * ((~i42) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i44 = ~((a4 | ((~i43) | (-2059442874))) - ((i43 & (-2059442874)) | a4));
                    int i45 = bArr4[i11] & ForkServer.ERROR;
                    int a5 = S.a(i44, i45, 1, ((-1) - i44) | ((-1) - i45));
                    byte[] bArr7 = bArr5;
                    int i46 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                    int i47 = (i46 + a5) - ((i46 & a5) * 2);
                    bArr4[i11] = (byte) i47;
                    bArr4[i33] = (byte) (i47 >>> 8);
                    bArr4[i29] = (byte) (i47 >>> 16);
                    bArr4[i26] = (byte) (i47 >>> 24);
                    i11 = (-11) - (((-15) - i11) | i28);
                    int length8 = bArr4.length;
                    int a6 = AbstractC0044j.a(bArr4.length);
                    int i48 = ((i11 > (((length8 & (~a6)) * 2) - (length8 ^ a6)) ? 1 : (i11 == (((length8 & (~a6)) * 2) - (length8 ^ a6)) ? 0 : -1)) >>> 31) & 1;
                    if (i48 != 0) {
                        i9 = -897645243;
                    } else {
                        i9 = 1251644638;
                    }
                    if (i48 != 0) {
                        bArr5 = bArr7;
                        c6 = c7;
                        c5 = c9;
                        i6 = i35;
                        i4 = 0;
                        i5 = 1;
                        i9 = -1469476344;
                    } else {
                        bArr5 = bArr7;
                        c6 = c7;
                        c5 = c9;
                        i6 = i35;
                        i4 = 0;
                        i5 = 1;
                    }
                    i8 = 8;
                case 1758587480:
                    c4 = c5;
                    int length9 = bArr4.length;
                    int i49 = 0 - i12;
                    if ((bArr5[((length9 | i49) - (((~i49) & 822835569) & length9)) + ((i49 | 822835569) & length9)] > Double.NaN ? 1 : (bArr5[((length9 | i49) - (((~i49) & 822835569) & length9)) + ((i49 | 822835569) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i9 = -897645243;
                    } else {
                        i9 = -1057239115;
                    }
                    i10 = i12;
                    c6 = c7;
                    c5 = c4;
                case 2013813686:
                    i12 = bArr4.length % 4;
                    c4 = c5;
                    int i50 = ((i12 > i5 ? 1 : (i12 == i5 ? 0 : -1)) >>> 31) & i5;
                    if (i50 != 0) {
                        i9 = 2100390411;
                    } else {
                        i9 = -897645243;
                    }
                    if (i50 != 0) {
                        c6 = c7;
                        c5 = c4;
                    } else {
                        i3 = i5;
                        i = i6;
                        bArr = bArr5;
                        i6 = i;
                        c6 = c7;
                        c5 = c4;
                        i4 = 0;
                        i8 = 8;
                        i9 = -2079636786;
                        bArr5 = bArr;
                        i5 = i3;
                    }
                default:
                    c6 = c7;
                    i9 = -897645243;
            }
            return new String(bArr2, StandardCharsets.UTF_8).intern();
        }
    }
}
