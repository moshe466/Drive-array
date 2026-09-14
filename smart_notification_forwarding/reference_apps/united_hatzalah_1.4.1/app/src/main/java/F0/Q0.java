package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class Q0 extends S0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f365b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f366c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q0(String str, Throwable th) {
        super(str, th);
        long j2 = 1869571853;
        long j3 = ~Q0.class.getName().length();
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j4 = (b4 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (b4 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (b4 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = b4 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        long j17 = -122183592;
        long length = (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) & 1753554947) + ((Q0.class.getName().length() & 278003714) | (-1875738588));
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        byte[] bArr = {-8, 45, (int) (((j31 | (j31 >>> 4)) & 16711935) | j25 | (((j28 | (j28 >>> 4)) & 16711935) << 8)), 52, -19, 87};
        b(bArr, new byte[]{115, 120, 8, 96, -126, 57, 40, -64});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(str, new String(bArr, charset).intern());
        byte[] bArr2 = {-40, 23, -71, -90, 101};
        b(bArr2, new byte[]{-92, -90, -74, -18, 0, -73, 105, 31});
        kotlin.jvm.internal.j.e(th, new String(bArr2, charset).intern());
        this.f365b = str;
        this.f366c = th;
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

    @Override // F0.S0
    public final String a() {
        return this.f365b;
    }

    @Override // F0.S0, java.lang.Throwable
    public final Throwable getCause() {
        return this.f366c;
    }
}
