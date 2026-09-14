package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class E0 implements H0 {

    /* renamed from: a, reason: collision with root package name */
    public static final E0 f187a = new Object();

    public final boolean equals(Object obj) {
        if (this == obj || (obj instanceof E0)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return -552755968;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00db. Please report as an issue. */
    public final String toString() {
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        int i11 = 1;
        int i12 = 2;
        int i13 = 3;
        char c4 = 4;
        int i14 = 8;
        byte[] bArr = {17, 101, -116, 56, 109, -46, -93, 80, 122, -66, 112};
        int i15 = ((~E0.class.getName().length()) | 1960902474) & 235451136;
        int length = E0.class.getName().length() & (-1979121647);
        byte[] bArr2 = new byte[(-1643529446) ^ ((((~length) & (-1878980591)) + length) + i15)];
        bArr2[0] = 105;
        bArr2[1] = -38;
        bArr2[2] = -10;
        bArr2[3] = 47;
        bArr2[4] = 54;
        bArr2[5] = -115;
        bArr2[6] = -28;
        bArr2[7] = 32;
        bArr2[8] = 9;
        bArr2[9] = -37;
        bArr2[10] = 20;
        byte[] bArr3 = null;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1516727821;
        byte[] bArr4 = null;
        while (true) {
            int i20 = ((i19 & 16777216) * (i19 | 16777216)) + ((i19 & (-16777217)) * ((~i19) & 16777216));
            int i21 = i19 >>> i14;
            int i22 = i10;
            char c5 = c4;
            int a2 = j3.a((~i20) & 650911840 & i21, i21, i20, (i20 | 650911840) & i21);
            int i23 = (a2 ^ 642535957) + ((a2 & 642535957) * i12);
            switch (((~i23) + ((i23 | 1) * i12)) ^ 962785775) {
                case -1896910703:
                    int i24 = i12;
                    int i25 = i11;
                    int length2 = bArr4.length;
                    int i26 = 0 - i16;
                    int i27 = (length2 ^ i26) + ((length2 & i26) * i24);
                    byte b4 = bArr3[i27];
                    int length3 = bArr4.length;
                    int i28 = 0 - i26;
                    int i29 = i28 | length3;
                    byte b5 = bArr3[D.a(i28, i24, i29, (length3 ^ i28) ^ i29)];
                    bArr3[i27] = (byte) (((byte) (((byte) i24) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i11 = i25;
                    i12 = i24;
                    c4 = c5;
                    i10 = i22;
                    i13 = 3;
                    i19 = -746753280;
                    i14 = 8;
                case -1725904394:
                    i = i12;
                    i18 = bArr4.length % 4;
                    i3 = 1;
                    if ((((i18 > 1 ? 1 : (i18 == 1 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i7 = -458924450;
                        i11 = i3;
                        i12 = i;
                        c4 = c5;
                        i13 = 3;
                        i14 = 8;
                        i19 = i7;
                        i10 = i22;
                    } else {
                        i11 = 1;
                        i12 = i;
                        c4 = c5;
                        i10 = i22;
                        i13 = 3;
                        i19 = -365117735;
                        i14 = 8;
                    }
                case -1399959314:
                    int i30 = i11;
                    int a4 = j3.a((-1205100636) & i17, i17, i13, (-1205100633) & i17);
                    byte b6 = bArr3[a4];
                    int i31 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i32 = i17 - 1;
                    int i33 = i32 - (i17 | (-3));
                    int i34 = bArr3[i33] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & 65536);
                    int a5 = S.a(i35, i31, i30, ((-1) - i35) | ((-1) - i31));
                    int i36 = i32 - (i17 | (-2));
                    int i37 = bArr3[i36] & ForkServer.ERROR;
                    int i38 = i37 * ((~i37) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i39 = (i38 - 1) - ((~a5) | i38);
                    int i40 = bArr3[i17] & ForkServer.ERROR;
                    int a6 = S.a(i39, i40, 1, ((-1) - i39) | ((-1) - i40));
                    byte b7 = bArr4[a4];
                    int i41 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i42 = bArr4[i33] & ForkServer.ERROR;
                    int i43 = ((i42 * ((~i42) & 65536)) & (~i41)) + i41;
                    int i44 = bArr4[i36] & ForkServer.ERROR;
                    int i45 = i44 * ((~i44) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i46 = ~((((~i45) | 911399251) | i43) - ((i45 & 911399251) | i43));
                    int i47 = bArr4[i17] & ForkServer.ERROR;
                    int i48 = ~((((~i46) | 1433568692) | i47) - ((i46 & 1433568692) | i47));
                    i4 = i12;
                    int i49 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i50 = (-1254002618) - ((i49 & i4) | ((-1672003491) - i49));
                    int i51 = (i50 + i48) - ((i50 & i48) * i4);
                    bArr4[i17] = (byte) i51;
                    bArr4[i36] = (byte) (i51 >>> 8);
                    bArr4[i33] = (byte) (i51 >>> 16);
                    bArr4[a4] = (byte) (i51 >>> 24);
                    i17 = (i17 ^ 4) + ((i17 & 4) * i4);
                    int length4 = bArr4.length;
                    int length5 = 0 - (bArr4.length % 4);
                    int i52 = ((i17 > AbstractC0014b1.a((length4 & i4) | D1.a(length5, length4), length5 * 3) ? 1 : (i17 == AbstractC0014b1.a((length4 & i4) | D1.a(length5, length4), length5 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i52 != 0) {
                        i5 = -1605440657;
                    } else {
                        i5 = -365117735;
                    }
                    if (i52 != 0) {
                        i6 = i5;
                        i12 = i4;
                        i19 = i6;
                        c4 = c5;
                        i10 = i22;
                        i11 = 1;
                        i13 = 3;
                        i14 = 8;
                    } else {
                        i7 = -169475207;
                        i12 = i4;
                        c4 = c5;
                        i11 = 1;
                        i13 = 3;
                        i14 = 8;
                        i19 = i7;
                        i10 = i22;
                    }
                case -1135475043:
                    break;
                case 180635757:
                    bArr4 = bArr;
                    bArr3 = bArr2;
                    c4 = c5;
                    i10 = i22;
                    i17 = i10;
                    i19 = -1605440657;
                case 511524454:
                    int length6 = bArr4.length;
                    int i53 = 0 - i16;
                    int i54 = 0 - i53;
                    int i55 = ((~length6) & i54) * i12;
                    int length7 = bArr4.length;
                    byte b8 = bArr4[((length7 | i53) * i12) - (length7 ^ i53)];
                    int length8 = bArr4.length;
                    byte b9 = bArr3[(i53 ^ length8) + ((length8 & i53) * 2)];
                    int i56 = i11;
                    bArr4[(length6 ^ i54) - i55] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i12) * ((byte) ((~b9) & b8)))));
                    i18 = AbstractC0099x.a(i16, i13, (~i16) * i12);
                    if ((((i16 > i12 ? 1 : (i16 == i12 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i = i12;
                        i3 = i56;
                        i7 = -458924450;
                        i11 = i3;
                        i12 = i;
                        c4 = c5;
                        i13 = 3;
                        i14 = 8;
                        i19 = i7;
                        i10 = i22;
                    } else {
                        c4 = c5;
                        i10 = i22;
                        i11 = i56;
                        i19 = -365117735;
                        i14 = 8;
                    }
                case 961838909:
                    int length9 = bArr4.length;
                    int i57 = 0 - i18;
                    if ((bArr3[((length9 | i57) - (((~i57) & 165327505) & length9)) + ((i57 | 165327505) & length9)] > Double.NaN ? 1 : (bArr3[((length9 | i57) - (((~i57) & 165327505) & length9)) + ((i57 | 165327505) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i8 = i22;
                    } else {
                        i8 = i11;
                    }
                    if (i8 != 0) {
                        i9 = -365117735;
                    } else {
                        i9 = 1093626513;
                    }
                    if (i8 != 0) {
                        i19 = -746753280;
                    } else {
                        i19 = i9;
                    }
                    i16 = i18;
                    c4 = c5;
                    i10 = i22;
                    i14 = 8;
                default:
                    i4 = i12;
                    i6 = -365117735;
                    i12 = i4;
                    i19 = i6;
                    c4 = c5;
                    i10 = i22;
                    i11 = 1;
                    i13 = 3;
                    i14 = 8;
            }
            return new String(bArr, StandardCharsets.UTF_8).intern();
        }
    }
}
