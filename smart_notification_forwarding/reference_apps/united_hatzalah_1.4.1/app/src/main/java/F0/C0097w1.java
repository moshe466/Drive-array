package F0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.w1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0097w1 extends AbstractC0012b {

    /* renamed from: g, reason: collision with root package name */
    public final ReentrantLock f708g;

    /* renamed from: h, reason: collision with root package name */
    public long f709h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public Q f710j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0097w1(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1, c0054l1);
        byte[] bArr = {-4, (((AbstractC0008a.f(C0097w1.class, -1) | 1683211756) & (-2076081976)) + ((C0097w1.class.getName().length() & (-2138300383)) | 143402017)) ^ (-1932679942), -69, 6, -96, -41};
        x(bArr, new byte[]{((((~C0097w1.class.getName().length()) | 1955856142) & 470844416) + ((C0097w1.class.getName().length() & 136448032) | 35784736)) ^ (-506629200), 124, -36, 97, -59, -91, -51, 67});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = new byte[8];
        bArr2[0] = -70;
        bArr2[1] = -98;
        bArr2[((((~C0097w1.class.getName().length()) | 2115720629) & 1083688064) + ((C0097w1.class.getName().length() & 143429648) | 218632216)) ^ 1302320282] = -94;
        bArr2[3] = 117;
        bArr2[4] = 80;
        bArr2[5] = -25;
        bArr2[6] = 14;
        bArr2[7] = 16;
        byte[] bArr3 = new byte[8];
        bArr3[0] = -56;
        bArr3[1] = -5;
        bArr3[2] = -61;
        bArr3[3] = 22;
        bArr3[4] = 36;
        bArr3[5] = -114;
        bArr3[6] = 97;
        long j2 = -2013122045;
        long j3 = (~C0097w1.class.getName().length()) | 1698666926;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j5 = (j4 >>> 48) & 43690;
        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 43690;
        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 43690;
        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        int length = ((C0097w1.class.getName().length() | 1741675006) - 1741675006) | 271582208;
        int i = -((int) ((((((j14 >>> 4) | j14) & 16711935) << 8) + j11) | ((j17 | (j17 >>> 4)) & 16711935)));
        int i3 = i | length;
        bArr3[(-1741539836) ^ ((i3 - (i * 2)) + ((i ^ length) ^ i3))] = 126;
        x(bArr2, bArr3);
        new String(bArr2, charset).intern();
        this.f708g = new ReentrantLock();
        this.f709h = System.currentTimeMillis();
        this.i = SystemClock.elapsedRealtime();
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0018. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    public final boolean B(Context context) {
        boolean z3;
        long j2;
        Object obj;
        ?? r18;
        boolean z4;
        long j3;
        long j4;
        long j5;
        boolean z5;
        boolean z6;
        boolean z7;
        long j6 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        Object obj2 = null;
        char c4 = 602;
        long j7 = 0;
        while (true) {
            switch (c4) {
                case 602:
                    z3 = z8 ? 1 : 0;
                    j2 = j7;
                    obj = obj2;
                    try {
                        obj2 = context.getPackageManager();
                    } catch (Exception unused) {
                        c4 = 32471;
                        z4 = z3;
                        z8 = z4;
                        j7 = j2;
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        c4 = 30783;
                        obj2 = obj2;
                        z5 = z3;
                        z8 = z5;
                        j7 = j2;
                    }
                    c4 = 7112;
                    obj2 = obj2;
                    z5 = z3;
                    z8 = z5;
                    j7 = j2;
                case 48695:
                    return z9;
                case 7112:
                    return z8 ? 1 : 0;
                case 6860:
                    boolean z12 = z8 ? 1 : 0;
                    c4 = 44380;
                    z11 = z8 ? 1 : 0;
                case 43931:
                    r18 = z8 ? 1 : 0;
                    obj = obj2;
                    PackageInfo packageInfo = (PackageInfo) obj;
                    j6 = packageInfo.firstInstallTime;
                    j7 = packageInfo.lastUpdateTime;
                    try {
                        z7 = r18;
                    } catch (Exception unused2) {
                        break;
                    }
                    if (Build.TIME <= this.f709h) {
                        c4 = 3284;
                        z6 = r18;
                        z8 = z6;
                        obj2 = obj;
                    }
                    c4 = 52948;
                    z6 = z7;
                    z8 = z6;
                    obj2 = obj;
                case 39998:
                    boolean z13 = z8 ? 1 : 0;
                    c4 = 38689;
                    z9 = z10;
                case 44380:
                    z4 = z8 ? 1 : 0;
                    j2 = j7;
                    obj = obj2;
                    if (z11) {
                        c4 = 43096;
                    } else {
                        c4 = 39998;
                    }
                    z10 = z11;
                    z8 = z4;
                    j7 = j2;
                    obj2 = obj;
                case 43096:
                    byte[] bArr = new byte[19];
                    bArr[z8 ? 1 : 0] = 44;
                    bArr[1] = -21;
                    bArr[2] = 59;
                    bArr[3] = -68;
                    r18 = z8 ? 1 : 0;
                    try {
                        bArr[4] = 72;
                        j2 = j7;
                        long j8 = -1;
                        obj = obj2;
                        long length = C0097w1.class.getName().length();
                        long j9 = ((((((((j8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j10 = (j9 >>> 48) & 21845;
                        long j11 = ((j10 >>> 1) | j10) & 858993459;
                        long j12 = ((j11 >>> 2) | j11) & 252645135;
                        long j13 = (j9 >>> 32) & 21845;
                        long j14 = ((j13 >>> 1) | j13) & 858993459;
                        long j15 = ((j14 >>> 2) | j14) & 252645135;
                        j3 = ((((j15 >>> 4) | j15) & 16711935) << 16) | ((((j12 >>> 4) | j12) & 16711935) << 24);
                        long j16 = (j9 >>> 16) & 21845;
                        long j17 = ((j16 >>> 1) | j16) & 858993459;
                        j4 = ((j17 >>> 2) | j17) & 252645135;
                        long j18 = j9 & 21845;
                        long j19 = ((j18 >>> 1) | j18) & 858993459;
                        j5 = ((j19 >>> 2) | j19) & 252645135;
                    } catch (Exception unused3) {
                        j2 = j7;
                        obj = obj2;
                        j7 = j2;
                        c4 = 32471;
                        z6 = r18;
                        z8 = z6;
                        obj2 = obj;
                    }
                    try {
                        bArr[(((((int) ((((j5 >>> 4) | j5) & 16711935) + (((((j4 >>> 4) | j4) & 16711935) << 8) | j3))) | 307026618) & (-476947440)) + ((C0097w1.class.getName().length() & (-174980088)) | 336142344)) ^ (-140805091)] = -123;
                        bArr[6] = 9;
                        bArr[7] = 74;
                        bArr[8] = -117;
                        bArr[9] = -5;
                        bArr[10] = 69;
                        bArr[11] = -9;
                        bArr[12] = 18;
                        bArr[13] = -96;
                        bArr[14] = -116;
                        bArr[15] = -62;
                        bArr[16] = 99;
                        bArr[17] = -127;
                        bArr[18] = 64;
                        byte[] bArr2 = new byte[19];
                        bArr2[r18] = 69;
                        bArr2[1] = -104;
                        bArr2[2] = 121;
                        bArr2[3] = -55;
                        bArr2[4] = 33;
                        bArr2[5] = -23;
                        bArr2[((((~C0097w1.class.getName().length()) | 1407882250) & 17060379) + ((C0097w1.class.getName().length() & 344785) | 8454368)) ^ 25514749] = 109;
                        bArr2[7] = 30;
                        bArr2[8] = -30;
                        bArr2[9] = -106;
                        bArr2[10] = 32;
                        bArr2[11] = -66;
                        bArr2[12] = 124;
                        bArr2[13] = -26;
                        bArr2[14] = -7;
                        bArr2[15] = -74;
                        int length2 = C0097w1.class.getName().length();
                        int i = (length2 - 1) - (length2 * 2);
                        int length3 = ((((((~i) & C0097w1.class.getName().length()) & 1851084926) + 1851084926) + i) - (1851084926 & (C0097w1.class.getName().length() | i))) & 564172965;
                        long j20 = 1102088323;
                        long length4 = C0097w1.class.getName().length();
                        long j21 = ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
                        bArr2[16] = (length3 + (((int) ((((j34 >>> 4) | j34) & 16711935) + (((((j31 >>> 4) | j31) & 16711935) << 8) | j28))) | 1075314698)) ^ 1639487673;
                        bArr2[17] = -13;
                        bArr2[18] = 37;
                        x(bArr, bArr2);
                        Charset charset = StandardCharsets.UTF_8;
                        String intern = new String(bArr, charset).intern();
                        byte[] bArr3 = {-55, 92, 54, -112};
                        int i3 = ~C0097w1.class.getName().length();
                        long j35 = 1075481152;
                        long length5 = C0097w1.class.getName().length();
                        long j36 = ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                        int i4 = (int) ((((j49 >>> 4) | j49) & 16711935) + ((((j46 >>> 4) | j46) & 16711935) << 8) + j43);
                        long j50 = 1084444672;
                        long j51 = i4;
                        long b4 = c3.b((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                        long j52 = (b4 >>> 48) & 43690;
                        long j53 = ((j52 >>> 2) | (j52 >>> 1)) & 858993459;
                        long j54 = ((j53 >>> 2) | j53) & 252645135;
                        long j55 = (b4 >>> 32) & 43690;
                        long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
                        long j57 = ((j56 >>> 2) | j56) & 252645135;
                        long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) | ((((j54 >>> 4) | j54) & 16711935) << 24);
                        long j59 = (b4 >>> 16) & 43690;
                        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                        long j61 = ((j60 >>> 2) | j60) & 252645135;
                        long j62 = ((((j61 >>> 4) | j61) & 16711935) << 8) + j58;
                        long j63 = b4 & 43690;
                        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
                        long j65 = ((j64 >>> 2) | j64) & 252645135;
                        byte b5 = ((((int) ((((j65 >>> 4) | j65) & 16711935) + j62)) - (~(((i3 + (((-i3) - 1) | 1230544458)) - 1230544458) & (-1843885104)))) - 1) ^ 759440421;
                        byte[] bArr4 = new byte[8];
                        bArr4[r18] = -67;
                        bArr4[1] = 46;
                        bArr4[2] = 67;
                        bArr4[3] = b5;
                        bArr4[4] = -82;
                        bArr4[5] = -36;
                        bArr4[6] = 116;
                        bArr4[7] = -1;
                        x(bArr3, bArr4);
                        t(intern, new String(bArr3, charset).intern());
                        c4 = 39998;
                        z4 = r18;
                        z8 = z4;
                        j7 = j2;
                    } catch (Exception unused4) {
                        j7 = j2;
                        c4 = 32471;
                        z6 = r18;
                        z8 = z6;
                        obj2 = obj;
                    }
                    obj2 = obj;
                case 38689:
                    c4 = 48695;
                case 3284:
                    if (j6 <= this.f709h) {
                        c4 = 45885;
                    } else {
                        z7 = z8 ? 1 : 0;
                        obj = obj2;
                        c4 = 52948;
                        z6 = z7;
                        z8 = z6;
                        obj2 = obj;
                    }
                case 52948:
                    c4 = 44380;
                    z11 = true;
                case 30783:
                    try {
                        String packageName = context.getPackageName();
                        int i5 = ~C0097w1.class.getName().length();
                        obj2 = ((PackageManager) obj2).getPackageInfo(packageName, ((296360961 & ((i5 ^ 1438031485) + (i5 & 1438031485))) + ((C0097w1.class.getName().length() & 202145800) | 201695246)) ^ 498056207);
                    } catch (Exception unused5) {
                        r18 = z8 ? 1 : 0;
                        j2 = j7;
                        obj = obj2;
                        j7 = j2;
                        c4 = 32471;
                        z6 = r18;
                        z8 = z6;
                        obj2 = obj;
                    }
                    if (obj2 == null) {
                        z3 = z8 ? 1 : 0;
                        j2 = j7;
                        c4 = 7112;
                        obj2 = obj2;
                        z5 = z3;
                        z8 = z5;
                        j7 = j2;
                    } else {
                        c4 = 43931;
                    }
                case 32471:
                    z9 = z8 ? 1 : 0;
                    c4 = 48695;
                case 45885:
                    try {
                    } catch (Exception unused6) {
                        z3 = z8 ? 1 : 0;
                        j2 = j7;
                        obj = obj2;
                        c4 = 32471;
                        z4 = z3;
                        z8 = z4;
                        j7 = j2;
                        obj2 = obj;
                    }
                    if (j7 <= this.f709h) {
                        c4 = 6860;
                    } else {
                        z7 = z8 ? 1 : 0;
                        obj = obj2;
                        c4 = 52948;
                        z6 = z7;
                        z8 = z6;
                        obj2 = obj;
                    }
                default:
                    r18 = z8 ? 1 : 0;
                    obj = obj2;
                    c4 = 32471;
                    z6 = r18;
                    z8 = z6;
                    obj2 = obj;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v30 */
    public final boolean C() {
        ?? r20;
        Class<C0097w1> cls;
        Q q3;
        int i;
        int i3;
        int i4;
        Class<C0097w1> cls2 = C0097w1.class;
        Q q4 = null;
        boolean z3 = false;
        long j2 = 0;
        boolean z4 = false;
        boolean z5 = false;
        Q q5 = null;
        char c4 = 41348;
        long j3 = 0;
        while (true) {
            switch (c4) {
                case 56662:
                    byte[] bArr = new byte[19];
                    bArr[z3 ? 1 : 0] = -94;
                    bArr[1] = 60;
                    bArr[2] = -106;
                    bArr[3] = -56;
                    String name = cls2.getName();
                    r20 = z3 ? 1 : 0;
                    try {
                        bArr[4] = ((((~name.length()) | 1389756652) & 33849993) + ((cls2.getName().length() & 1082881) | 3146756)) ^ 36996756;
                        bArr[5] = 34;
                        bArr[6] = Byte.MIN_VALUE;
                        bArr[7] = 82;
                        bArr[8] = 94;
                        bArr[9] = 64;
                        int i5 = ~cls2.getName().length();
                        int length = (-1803517720) & (((((cls2.getName().length() & (~i5)) & (-1111088645)) - 1111088645) + i5) - ((cls2.getName().length() | i5) & (-1111088645)));
                        long j4 = 22331904;
                        cls = cls2;
                        q3 = q4;
                        long length2 = cls2.getName().length();
                        long j5 = (((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j6 = (j5 >>> 48) & 43690;
                        long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
                        long j8 = ((j7 >>> 2) | j7) & 252645135;
                        long j9 = (j5 >>> 32) & 43690;
                        long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                        long j11 = ((j10 >>> 2) | j10) & 252645135;
                        long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) | ((((j8 >>> 4) | j8) & 16711935) << 24);
                        long j13 = (j5 >>> 16) & 43690;
                        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                        long j15 = ((j14 >>> 2) | j14) & 252645135;
                        long j16 = ((((j15 >>> 4) | j15) & 16711935) << 8) + j12;
                        long j17 = j5 & 43690;
                        long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
                        long j19 = (j18 | (j18 >>> 2)) & 252645135;
                        i = ((int) (((j19 | (j19 >>> 4)) & 16711935) | j16)) | 22364688;
                        i3 = -length;
                        i4 = i3 | i;
                    } catch (IllegalStateException unused) {
                        cls = cls2;
                        q3 = q4;
                    }
                    try {
                        bArr[(-1781153038) ^ ((i4 - (i3 * 2)) + ((i ^ i3) ^ i4))] = -62;
                        bArr[11] = -112;
                        bArr[12] = -20;
                        bArr[13] = -37;
                        bArr[14] = -94;
                        bArr[15] = -35;
                        bArr[16] = 24;
                        bArr[17] = -29;
                        bArr[18] = -55;
                        byte[] bArr2 = new byte[19];
                        bArr2[r20] = -91;
                        bArr2[1] = 106;
                        bArr2[2] = 65;
                        bArr2[3] = 13;
                        bArr2[4] = 22;
                        bArr2[5] = 96;
                        bArr2[6] = 91;
                        bArr2[7] = -99;
                        bArr2[8] = 87;
                        int i6 = ~cls.getName().length();
                        bArr2[9] = ((((i6 - 611982877) - (i6 & (-611982877))) & 302317860) + ((cls.getName().length() & 1073766916) | 1074817536)) ^ 1377135446;
                        int i7 = ((~cls.getName().length()) | (-1534324543)) & 44307854;
                        long j20 = 1413480449;
                        long length3 = cls.getName().length() & 371197199;
                        long b4 = c3.b((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                        long j21 = (b4 >>> 48) & 43690;
                        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
                        long j23 = ((j22 >>> 2) | j22) & 252645135;
                        long j24 = (b4 >>> 32) & 43690;
                        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                        long j26 = ((j25 >>> 2) | j25) & 252645135;
                        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
                        long j28 = (b4 >>> 16) & 43690;
                        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                        long j30 = ((j29 >>> 2) | j29) & 252645135;
                        long j31 = b4 & 43690;
                        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                        long j33 = ((j32 >>> 2) | j32) & 252645135;
                        bArr2[(((int) ((((j33 >>> 4) | j33) & 16711935) | (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) + i7) ^ 1457788293] = 25;
                        bArr2[11] = 88;
                        bArr2[12] = -26;
                        bArr2[13] = -120;
                        bArr2[14] = 70;
                        bArr2[15] = 26;
                        long j34 = -1;
                        long length4 = cls.getName().length();
                        long j35 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                        long j36 = (j35 >>> 48) & 21845;
                        long j37 = ((j36 >>> 1) | j36) & 858993459;
                        long j38 = ((j37 >>> 2) | j37) & 252645135;
                        long j39 = (j35 >>> 32) & 21845;
                        long j40 = ((j39 >>> 1) | j39) & 858993459;
                        long j41 = ((j40 >>> 2) | j40) & 252645135;
                        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
                        long j43 = (j35 >>> 16) & 21845;
                        long j44 = ((j43 >>> 1) | j43) & 858993459;
                        long j45 = ((j44 >>> 2) | j44) & 252645135;
                        long j46 = j35 & 21845;
                        long j47 = ((j46 >>> 1) | j46) & 858993459;
                        long j48 = ((j47 >>> 2) | j47) & 252645135;
                        bArr2[16] = (((((int) ((((j48 >>> 4) | j48) & 16711935) + (((((j45 >>> 4) | j45) & 16711935) << 8) | j42))) | (-210856644)) & 276103178) + ((cls.getName().length() & 1638406) | 34080260)) ^ 310183544;
                        bArr2[17] = Byte.MIN_VALUE;
                        bArr2[18] = -84;
                        z(bArr, bArr2);
                        t(new String(bArr, StandardCharsets.UTF_8).intern(), String.valueOf(j3));
                        cls2 = cls;
                        z4 = true;
                        z3 = r20;
                        q4 = q3;
                        c4 = 54590;
                    } catch (IllegalStateException unused2) {
                        c4 = 9211;
                        cls2 = cls;
                        z3 = r20;
                        q4 = q3;
                    }
                case 41348:
                    q5 = this.f710j;
                    c4 = q5 == null ? (char) 60751 : (char) 14548;
                case 60566:
                    try {
                        Thread.sleep(200L);
                        c4 = 50951;
                    } catch (InterruptedException unused3) {
                        c4 = 33689;
                    }
                case 29445:
                    c4 = kotlin.jvm.internal.j.a(Looper.getMainLooper().getThread(), Thread.currentThread()) ? (char) 51739 : (char) 26740;
                case 64603:
                    c4 = SystemClock.elapsedRealtime() < j2 ? (char) 60566 : (char) 43149;
                case 60751:
                case 51739:
                case 48984:
                    return z3;
                case 34188:
                    z4 = z3 ? 1 : 0;
                    c4 = 54590;
                case 54590:
                    z5 = z4;
                    c4 = 54397;
                case 50951:
                    c4 = 43595;
                case 43595:
                    if (((AtomicReference) ((G1) q4.f363d).f218b).get() == null) {
                        c4 = 64603;
                    }
                case 54397:
                    c4 = 60123;
                case 9211:
                    z5 = z3 ? 1 : 0;
                    c4 = 60123;
                case 60123:
                    return z5;
                case 33689:
                    Thread.currentThread().interrupt();
                    return z3;
                case 22612:
                    try {
                        j2 = q4.g().getTime();
                        j3 = Math.abs(System.currentTimeMillis() - j2);
                        c4 = j3 > 60000 ? (char) 56662 : (char) 34188;
                    } catch (IllegalStateException unused4) {
                        cls = cls2;
                        q3 = q4;
                        r20 = z3 ? 1 : 0;
                        c4 = 9211;
                        cls2 = cls;
                        z3 = r20;
                        q4 = q3;
                    }
                case 26740:
                    j2 = SystemClock.elapsedRealtime() + 4000;
                    c4 = 43595;
                case 43149:
                    c4 = ((AtomicReference) ((G1) q4.f363d).f218b).get() != null ? (char) 22612 : (char) 48984;
                case 14548:
                    if (((AtomicReference) ((G1) q5.f363d).f218b).get() != null) {
                        q4 = q5;
                    } else {
                        c4 = 29445;
                        q4 = q5;
                    }
                default:
                    c4 = 54397;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x03ae. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v68 */
    /* JADX WARN: Type inference failed for: r8v69 */
    /* JADX WARN: Type inference failed for: r8v70 */
    /* JADX WARN: Type inference failed for: r8v71, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r8v72 */
    /* JADX WARN: Type inference failed for: r8v73 */
    /* JADX WARN: Type inference failed for: r8v74, types: [F0.Q] */
    /* JADX WARN: Type inference failed for: r8v75 */
    @Override // F0.T2
    public final void a(Context context) {
        int i = 7;
        byte[] bArr = {-81, -101, -104, -114, -70, 30, 103};
        byte[] bArr2 = new byte[8];
        bArr2[0] = -52;
        bArr2[1] = -12;
        long j2 = 477747646;
        long j3 = ~C0097w1.class.getName().length();
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j4 = (b4 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (b4 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (b4 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = b4 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        long j17 = -1150879212;
        long length = (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) & 76088608) + ((C0097w1.class.getName().length() & 9438274) | 1074790594);
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j19 = (j18 >>> 48) & 21845;
        long j20 = ((j19 >>> 1) | j19) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> 32) & 21845;
        long j23 = ((j22 >>> 1) | j22) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << 24);
        long j26 = (j18 >>> 16) & 21845;
        long j27 = ((j26 >>> 1) | j26) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 21845;
        long j30 = ((j29 >>> 1) | j29) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        bArr2[2] = (int) ((((j31 >>> 4) | j31) & 16711935) + ((((j28 >>> 4) | j28) & 16711935) << 8) + j25);
        int i3 = ((~C0097w1.class.getName().length()) | 57873236) & 341353032;
        int length2 = (C0097w1.class.getName().length() & 336109592) | 1073873936;
        bArr2[(((i3 & length2) * 2) + (length2 ^ i3)) ^ 1415226971] = -6;
        bArr2[4] = -33;
        long j32 = 1616150753;
        long j33 = (~C0097w1.class.getName().length()) | 573879558;
        long j34 = ((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j35 = (j34 >>> 48) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = (j36 | (j36 >>> 2)) & 252645135;
        long j38 = (j34 >>> 32) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = (((j37 | (j37 >>> 4)) & 16711935) << 24) | ((((j40 >>> 4) | j40) & 16711935) << 16);
        long j42 = (j34 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        int i4 = (int) (((j47 | (j47 >>> 4)) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41));
        int length3 = (C0097w1.class.getName().length() & 1078485217) | 268986368;
        bArr2[1885137124 ^ ((length3 & i4) + (length3 | i4))] = 102;
        bArr2[6] = 19;
        bArr2[7] = 16;
        x(bArr, bArr2);
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
        ReentrantLock reentrantLock = this.f708g;
        reentrantLock.lock();
        ?? r8 = 0;
        while (true) {
            char c4 = 64003;
            while (true) {
                switch (c4) {
                    case 37207:
                        r8 = (Exception) r8;
                        c4 = 37614;
                    case 9978:
                        try {
                            r8 = new Q();
                            P2.G.r((U2.e) r8.f364e, new P2.D(), new e2.d(r8, null), 2);
                            this.f710j = r8;
                            c4 = 8348;
                        } catch (Exception e4) {
                            r8 = e4;
                            c4 = 37207;
                        }
                    case 53396:
                    case 37614:
                        A(T0.n(new C0016c(this, context, i)));
                        return;
                    case 64003:
                        try {
                            if (this.f710j != null) {
                                c4 = 53396;
                            } else {
                                c4 = 9978;
                            }
                        } finally {
                            reentrantLock.unlock();
                        }
                    case 8348:
                        c4 = 37614;
                }
            }
        }
    }
}
