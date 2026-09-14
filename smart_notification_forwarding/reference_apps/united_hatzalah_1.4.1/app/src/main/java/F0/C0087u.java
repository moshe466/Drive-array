package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0087u {

    /* renamed from: a, reason: collision with root package name */
    public String f679a;

    /* renamed from: b, reason: collision with root package name */
    public String f680b;

    /* renamed from: c, reason: collision with root package name */
    public String f681c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f682d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f683e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f684f;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
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

    public final String toString() {
        String str = this.f679a;
        String str2 = this.f680b;
        String str3 = this.f681c;
        boolean z3 = this.f684f;
        boolean z4 = this.f682d;
        boolean z5 = this.f683e;
        byte[] bArr = {126, -100, -115, 49};
        int i = ~(z4 ? 1 : 0);
        int i3 = (((-1272824813) | (z4 ? 1 : 0)) - (i | (-1224851881))) + ((115225172 | i) - (z4 ? 1 : 0)) + ((z4 ? 1 : 0) & (-1272824813)) + (((-1335292925) & (z4 ? 1 : 0)) | 139002368);
        a(bArr, new byte[]{31, 37, -28, 99, -35, (i3 - 1133822396) - (((-1133822396) & i3) * 2), -67, -122});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr2 = {112, -117, 36, 96, 40, -40, 0};
        boolean z6 = this.f683e;
        int i4 = (-1) - (z6 ? 1 : 0);
        boolean z7 = this.f684f;
        a(bArr2, new byte[]{57, (((((z7 ? 1 : 0) | (-2147459022)) - (i4 | (-553622030))) + (((i4 | (-553622062)) - (z7 ? 1 : 0)) + ((z7 ? 1 : 0) & (-2147459022)))) + ((((z6 ? 1 : 0) | 262240) - ((z6 ? 1 : 0) ^ 262240)) | 539230400)) ^ (-1608228635), 48, 27, 77, -76, 61, 11});
        String intern2 = new String(bArr2, charset).intern();
        boolean z8 = this.f683e;
        int i5 = ~(z8 ? 1 : 0);
        byte[] bArr3 = {-112, 27, S.a(0, -1, 276826627, (i5 | (-2093900549)) & 151848336) ^ (-428675023), 19, -25};
        int i6 = (i5 | (-1170031045)) & (-1539242478);
        long j2 = 84254976;
        long j3 = z8 ? 1L : 0L;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        int i7 = i6 + (((int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) | 25473280);
        long j18 = -1513769190;
        long j19 = i7;
        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j21 = (j20 >>> 48) & 21845;
        long j22 = ((j21 >>> 1) | j21) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 21845;
        long j25 = ((j24 >>> 1) | j24) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 21845;
        long j29 = ((j28 >>> 1) | j28) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 21845;
        long j32 = ((j31 >>> 1) | j31) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        byte[] bArr4 = new byte[(int) ((((j33 >>> 4) | j33) & 16711935) + ((((j30 >>> 4) | j30) & 16711935) << 8) + j27)];
        bArr4[0] = -103;
        bArr4[1] = -99;
        bArr4[2] = -80;
        bArr4[3] = 122;
        bArr4[4] = -38;
        bArr4[5] = 42;
        bArr4[6] = 41;
        bArr4[7] = -85;
        a(bArr3, bArr4);
        String intern3 = new String(bArr3, charset).intern();
        byte[] bArr5 = {-121, -81, 54, 9, -65, 52, -2, 102, 56, -91, -5};
        boolean z9 = this.f682d;
        a(bArr5, new byte[]{-112, 1180881956 ^ ((((~(z9 ? 1 : 0)) | (-77699686)) & 1111539752) + ((((z9 ? 1 : 0) + 69239840) - ((z9 ? 1 : 0) | 69239840)) | 69342208)), 46, -110, -72, -117, 118, 43, 93, -63, -58});
        String intern4 = new String(bArr5, charset).intern();
        byte[] bArr6 = new byte[4];
        bArr6[0] = 54;
        bArr6[1] = -18;
        long j34 = -1;
        long j35 = 0;
        long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j37 = (j36 >>> 48) & 21845;
        long j38 = ((j37 >>> 1) | j37) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = (j36 >>> 32) & 21845;
        long j41 = ((j40 >>> 1) | j40) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) + ((((j39 >>> 4) | j39) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 21845;
        long j45 = ((j44 >>> 1) | j44) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = j36 & 21845;
        long j48 = ((j47 >>> 1) | j47) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        bArr6[(((((int) ((((j49 >>> 4) | j49) & 16711935) | (((((j46 >>> 4) | j46) & 16711935) << 8) + j43))) | 419101983) & 814409984) - 966523864) ^ (-152113878)] = 91;
        bArr6[3] = 40;
        a(bArr6, new byte[]{-1, -71, 31, 46, 5, -97, 105, -37});
        String intern5 = new String(bArr6, charset).intern();
        byte[] bArr7 = {-29, 66, 109, 68, 51, 88, -121, -87};
        a(bArr7, new byte[]{-84, 92, -20, 29, 42, 91, -50, -83});
        String intern6 = new String(bArr7, charset).intern();
        byte[] bArr8 = {24, 47, 16, 55, 56, 103};
        a(bArr8, new byte[]{33, 113, 105, 122, 11, 90, -5, -11});
        String intern7 = new String(bArr8, charset).intern();
        byte[] bArr9 = {70};
        a(bArr9, new byte[]{59, -97, -97, -35, -100, -2, 102, -56});
        return intern + str + intern2 + str2 + intern3 + str3 + intern4 + z3 + intern5 + z4 + intern6 + z5 + intern7 + false + new String(bArr9, charset).intern();
    }
}
