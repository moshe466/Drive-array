package G0;

import F0.AbstractC0008a;
import F0.AbstractC0014b1;
import F0.AbstractC0099x;
import F0.B0;
import F0.D;
import F0.D1;
import F0.E1;
import F0.S;
import F0.V2;
import F0.c3;
import F0.j3;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Set f811a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f812b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f813c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f814d;

    /* renamed from: e, reason: collision with root package name */
    public final d f815e;

    /* renamed from: f, reason: collision with root package name */
    public final f f816f;

    public h(Set set, Set set2, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, d dVar, f fVar) {
        byte[] bArr = new byte[16];
        bArr[0] = 45;
        bArr[1] = -50;
        bArr[2] = 98;
        bArr[3] = 54;
        bArr[4] = 122;
        bArr[5] = -33;
        bArr[6] = 90;
        bArr[7] = 103;
        bArr[8] = 81;
        bArr[9] = 60;
        bArr[10] = -122;
        bArr[11] = -93;
        bArr[12] = 80;
        bArr[13] = 34;
        long j2 = 921757005;
        long j3 = 921756995;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j5 = (j4 >>> 48) & 21845;
        long j6 = ((j5 >>> 1) | j5) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        bArr[(int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))] = -45;
        bArr[15] = 2;
        long j18 = -2080301055;
        long j19 = 0;
        long b4 = c3.b((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j20 = (b4 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (b4 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (b4 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = b4 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        c(bArr, new byte[]{-68, -38, -72, -17, Byte.MAX_VALUE, -65, -87, -102, -106, (((int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26))) + 1903433866) ^ (-176867133), -106, 86, -105, 96, 53, 0});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = {81, 79, 45, -125, -92, -69, -91, -42, 89, 71};
        c(bArr2, new byte[]{-121, 89, -2, -106, 39, -57, 90, 86, 61, 34});
        kotlin.jvm.internal.j.e(fVar, new String(bArr2, charset).intern());
        this.f811a = set;
        this.f812b = set2;
        this.f813c = linkedHashSet;
        this.f814d = linkedHashSet2;
        this.f815e = dVar;
        this.f816f = fVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
        short[] sArr = null;
        char c4 = 50438;
        int i = 0;
        int i3 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        int i4 = 0;
        while (true) {
            switch (c4) {
                case 60804:
                    if (i < i3) {
                        c4 = 3065;
                    } else {
                        c4 = 11261;
                    }
                case 22124:
                    int i5 = ((short) ((s4 << 4) + sArr[2])) ^ (s4 + s3);
                    short s6 = sArr[3];
                    int i6 = -(s4 >>> 5);
                    int i7 = i6 | s6;
                    int i8 = (i7 - (i6 * 2)) + ((i6 ^ s6) ^ i7);
                    int i9 = -B0.a(i8 | (~i5), i8 - i5);
                    s5 = (short) D.a(s5, 3, -(D1.a(s5, i9) | (i9 & 2)), 1);
                    s4 = (short) (s4 - ((((short) ((s5 << 4) + sArr[0])) ^ (((s3 | s5) - (((~s5) & 57) & s3)) + ((s5 | 57) & s3))) ^ ((s5 >>> 5) + sArr[1])));
                    s3 = (short) (s3 - 40503);
                    i4++;
                    c4 = 17109;
                case 3065:
                    byte b4 = bArr[i];
                    s4 = (short) (((bArr[((i & 1) * 2) + (i ^ 1)] & ForkServer.ERROR) << 8) | ((255 - (b4 | ForkServer.ERROR)) + b4));
                    int i10 = -i;
                    int i11 = i10 | 2;
                    s5 = (short) ((bArr[(i11 - (i10 * 2)) + ((i10 ^ 2) ^ i11)] & ForkServer.ERROR) | ((bArr[i + 3] & ForkServer.ERROR) << 8));
                    s3 = -14624;
                    i4 = 0;
                    c4 = 17109;
                case 50438:
                    sArr = new short[4];
                    i = 0;
                    c4 = 5848;
                case 49265:
                    sArr[i] = (short) ((bArr2[(((~i) & 2) * (i & (-3))) + ((i & 2) * (i | 2))] & ForkServer.ERROR) ^ ((bArr2[(i * 2) + 1] & ForkServer.ERROR) << 8));
                    i++;
                    c4 = 5848;
                case 5255:
                    int i12 = -i;
                    int i13 = -bArr.length;
                    int i14 = i13 | i12;
                    bArr[(i14 - (i13 * 2)) + ((i13 ^ i12) ^ i14)] = (byte) (bArr[bArr.length - i] ^ bArr2[i % 8]);
                    i--;
                    c4 = 33742;
                case 5848:
                    if (i < 4) {
                        c4 = 49265;
                    } else {
                        c4 = 18639;
                    }
                case 11261:
                    i = bArr.length % 4;
                    c4 = 33742;
                case 18639:
                    i3 = bArr.length - (bArr.length % 4);
                    i = 0;
                    c4 = 60804;
                case 15026:
                    break;
                case 33742:
                    if (i > 0) {
                        c4 = 5255;
                    } else {
                        c4 = 15026;
                    }
                case 42144:
                    bArr[i] = (byte) (s4 & 255);
                    bArr[i + 1] = (byte) ((s4 >> 8) & 255);
                    bArr[i + 2] = (byte) (s5 & 255);
                    bArr[i + 3] = (byte) ((s5 >> 8) & 255);
                    i += 4;
                    c4 = 60804;
                case 17109:
                    if (i4 < 32) {
                        c4 = 22124;
                    } else {
                        c4 = 42144;
                    }
                default:
                    c4 = 17109;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        byte[] bArr3 = null;
        int i4 = 1516727821;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i4 & 16777216) * (i4 | 16777216)) + ((i4 & (-16777217)) * ((~i4) & 16777216));
            int i9 = i4 >>> 8;
            int a2 = j3.a(650911840 & (~i8) & i9, i9, i8, (i8 | 650911840) & i9);
            int i10 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
            int i11 = -365117735;
            boolean z3 = true;
            switch (((~i10) + ((i10 | 1) * 2)) ^ 962785775) {
                case -1896910703:
                    int length = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = (length ^ i12) + ((length & i12) * 2);
                    byte b4 = bArr3[i13];
                    int length2 = bArr4.length;
                    int i14 = 0 - i12;
                    int i15 = i14 | length2;
                    byte b5 = bArr3[D.a(i14, 2, i15, (length2 ^ i14) ^ i15)];
                    bArr3[i13] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i4 = -746753280;
                case -1725904394:
                    i7 = bArr4.length % 4;
                    if ((((i7 > 1 ? 1 : (i7 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case -1399959314:
                    int a4 = j3.a((-1205100636) & i6, i6, 3, (-1205100633) & i6);
                    byte b6 = bArr3[a4];
                    int i16 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i17 = i6 - 1;
                    int i18 = i17 - (i6 | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int a5 = S.a(i20, i16, 1, ((-1) - i20) | ((-1) - i16));
                    int i21 = i17 - (i6 | (-2));
                    int i22 = bArr3[i21] & ForkServer.ERROR;
                    int i23 = i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i24 = (i23 - 1) - ((~a5) | i23);
                    int i25 = bArr3[i6] & ForkServer.ERROR;
                    int a6 = S.a(i24, i25, 1, ((-1) - i24) | ((-1) - i25));
                    byte b7 = bArr4[a4];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i18] & ForkServer.ERROR;
                    int i28 = ((i27 * ((~i27) & 65536)) & (~i26)) + i26;
                    int i29 = bArr4[i21] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = ~((((~i30) | 911399251) | i28) - ((i30 & 911399251) | i28));
                    int i32 = bArr4[i6] & ForkServer.ERROR;
                    int i33 = ~((((~i31) | 1433568692) | i32) - ((i31 & 1433568692) | i32));
                    int i34 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (-1254002618) - ((i34 & 2) | ((-1672003491) - i34));
                    int i36 = (i35 + i33) - ((i35 & i33) * 2);
                    bArr4[i6] = (byte) i36;
                    bArr4[i21] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[a4] = (byte) (i36 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 1 : (i6 == AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i = -1605440657;
                    } else {
                        i = -365117735;
                    }
                    if (i37 != 0) {
                        i4 = i;
                    } else {
                        i4 = -169475207;
                    }
                case -1135475043:
                    break;
                case 180635757:
                    int length5 = bArr.length;
                    int length6 = 0 - (bArr.length % 4);
                    if ((length5 ^ (~length6)) + ((length5 | length6) * 2) + 1 <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (z3) {
                        i4 = i3;
                    } else {
                        i4 = -169475207;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case 511524454:
                    int length7 = bArr4.length;
                    int i38 = 0 - i5;
                    int i39 = 0 - i38;
                    int i40 = ((~length7) & i39) * 2;
                    int length8 = bArr4.length;
                    byte b8 = bArr4[((length8 | i38) * 2) - (length8 ^ i38)];
                    int length9 = bArr4.length;
                    byte b9 = bArr3[(i38 ^ length9) + ((length9 & i38) * 2)];
                    bArr4[(length7 ^ i39) - i40] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i7 = AbstractC0099x.a(i5, 3, (~i5) * 2);
                    if ((((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case 961838909:
                    int length10 = bArr4.length;
                    int i41 = 0 - i7;
                    if ((bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] > Double.NaN ? 1 : (bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        i11 = 1093626513;
                    }
                    if (z3) {
                        i4 = -746753280;
                    } else {
                        i4 = i11;
                    }
                    i5 = i7;
                default:
                    i4 = -365117735;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
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

    public final Set d() {
        return this.f814d;
    }

    public final Set e() {
        return this.f812b;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    public final boolean equals(Object obj) {
        h hVar = null;
        char c4 = 19766;
        while (true) {
            switch (c4) {
                case 42762:
                    if (!kotlin.jvm.internal.j.a(this.f812b, hVar.f812b)) {
                        c4 = 59603;
                    } else {
                        c4 = 36737;
                    }
                case 34244:
                    return true;
                case 27854:
                    return false;
                case 34399:
                    if (this.f816f != hVar.f816f) {
                        c4 = 10097;
                    } else {
                        c4 = 46397;
                    }
                case 63508:
                    return false;
                case 55308:
                    if (!kotlin.jvm.internal.j.a(this.f815e, hVar.f815e)) {
                        c4 = 65180;
                    } else {
                        c4 = 34399;
                    }
                case 62783:
                    if (!(obj instanceof h)) {
                        c4 = 46720;
                    } else {
                        c4 = 30056;
                    }
                case 46397:
                    return true;
                case 46720:
                case 23027:
                case 65180:
                    return false;
                case 19766:
                    if (this == obj) {
                        c4 = 34244;
                    } else {
                        c4 = 62783;
                    }
                case 10097:
                    return false;
                case 36737:
                    if (!kotlin.jvm.internal.j.a(this.f813c, hVar.f813c)) {
                        c4 = 23027;
                    } else {
                        c4 = 58894;
                    }
                case 30056:
                    hVar = (h) obj;
                    if (!kotlin.jvm.internal.j.a(this.f811a, hVar.f811a)) {
                        c4 = 63508;
                    } else {
                        c4 = 42762;
                    }
                case 59603:
                    return false;
                case 58894:
                    if (!kotlin.jvm.internal.j.a(this.f814d, hVar.f814d)) {
                        c4 = 27854;
                    } else {
                        c4 = 55308;
                    }
                default:
                    c4 = 42762;
            }
        }
    }

    public final Set f() {
        return this.f811a;
    }

    public final f g() {
        return this.f816f;
    }

    public final Set h() {
        return this.f813c;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001d. Please report as an issue. */
    public final int hashCode() {
        char c4 = 25456;
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int i11 = 0;
            while (true) {
                Set set = this.f813c;
                Set set2 = this.f814d;
                Set set3 = this.f812b;
                Set set4 = this.f811a;
                switch (c4) {
                    case 55455:
                        break;
                    case 59475:
                        i5 = set.hashCode();
                        i4 = i3;
                        c4 = 24174;
                    case 8574:
                        c4 = 34286;
                        i9 = 0;
                    case 24174:
                        i = (i4 + i5) * 31;
                        if (set2 == null) {
                            c4 = 55455;
                        } else {
                            c4 = 5254;
                        }
                    case 32981:
                        i7 = i6;
                        c4 = 15478;
                        i8 = 0;
                    case 25456:
                        if (set4 == null) {
                            c4 = 8574;
                        } else {
                            c4 = 33778;
                        }
                    case 15478:
                        i3 = (i7 + i8) * 31;
                        if (set == null) {
                            c4 = 31909;
                        } else {
                            c4 = 59475;
                        }
                    case 42742:
                        i8 = set3.hashCode();
                        i7 = i6;
                        c4 = 15478;
                    case 5254:
                        i11 = set2.hashCode();
                        i10 = i;
                        c4 = 21439;
                    case 34286:
                        i6 = i9 * 31;
                        if (set3 == null) {
                            c4 = 32981;
                        } else {
                            c4 = 42742;
                        }
                    case 33778:
                        i9 = set4.hashCode();
                        c4 = 34286;
                    case 31909:
                        i4 = i3;
                        c4 = 24174;
                        i5 = 0;
                    case 21439:
                        break;
                    default:
                        c4 = 42742;
                }
                return this.f816f.hashCode() + (~(-((this.f815e.hashCode() + ((i10 + i11) * 31)) * 31))) + 1;
            }
            i10 = i;
            c4 = 21439;
        }
    }

    public final String toString() {
        byte[] bArr = new byte[42];
        long j2 = 319898698;
        long j3 = -2;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        bArr[(((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) + 70000640) ^ 389899338] = 72;
        bArr[1] = -13;
        bArr[2] = 109;
        bArr[3] = -30;
        bArr[4] = 21;
        bArr[5] = -49;
        bArr[6] = -76;
        bArr[7] = -100;
        bArr[8] = 44;
        bArr[9] = 123;
        bArr[10] = 18;
        bArr[11] = -23;
        bArr[12] = -101;
        bArr[13] = 16;
        bArr[14] = 59;
        bArr[15] = 70;
        bArr[16] = 103;
        bArr[17] = 10;
        bArr[18] = -122;
        bArr[19] = -112;
        bArr[20] = -126;
        bArr[21] = 65;
        bArr[22] = -102;
        bArr[23] = -85;
        bArr[24] = Byte.MAX_VALUE;
        bArr[25] = -41;
        bArr[26] = 73;
        long j18 = 666817515;
        long j19 = -58;
        long j20 = ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j21 = (((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j22 = (((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j23 = j22 | (j21 + j20);
        long b4 = c3.b((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j23, 6148914691236517205L);
        long j24 = (b4 >>> 48) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = (b4 >>> 32) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 16) | ((((j26 >>> 4) | j26) & 16711935) << 24);
        long j31 = (b4 >>> 16) & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = b4 & 43690;
        long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        bArr[27] = ((((int) ((((j36 >>> 4) | j36) & 16711935) + (((((j33 >>> 4) | j33) & 16711935) << 8) | j30))) & (-2104491963)) + 2196128) ^ (-2102295847);
        bArr[28] = 79;
        bArr[29] = -124;
        bArr[30] = 91;
        bArr[31] = 117;
        bArr[32] = -71;
        bArr[33] = 56;
        long j37 = -1798491884;
        long j38 = -18;
        long j39 = (((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j40 = (j39 >>> 48) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = (j39 >>> 32) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = ((((j45 >>> 4) | j45) & 16711935) << 16) + ((((j42 >>> 4) | j42) & 16711935) << 24);
        long j47 = (j39 >>> 16) & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        long j50 = j39 & 43690;
        long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
        long j52 = ((j51 >>> 2) | j51) & 252645135;
        bArr[34] = (((int) ((((((j49 >>> 4) | j49) & 16711935) << 8) + j46) | (((j52 >>> 4) | j52) & 16711935))) + 671105712) ^ 1127386113;
        bArr[35] = -21;
        bArr[36] = -7;
        bArr[37] = -91;
        bArr[38] = -63;
        bArr[39] = 88;
        bArr[40] = -12;
        bArr[41] = -32;
        long j53 = -1;
        long j54 = 57;
        long j55 = (((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j56 = (((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j57 = j56 + j55;
        long j58 = (((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j59 = j58 + j57;
        long j60 = (((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j61 = j60 + j59;
        long j62 = (((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j63 = (((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j64 = j63 | j62;
        long j65 = (((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j66 = (((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j67 = (j66 | (j65 + j64)) + j61;
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
        long j79 = ((j78 >>> 1) | j78) & 858993459;
        long j80 = ((j79 >>> 2) | j79) & 252645135;
        byte[] bArr2 = new byte[D.a((((int) ((((j80 >>> 4) | j80) & 16711935) | (((((j77 >>> 4) | j77) & 16711935) << 8) | j74))) | (-1583025238)) & 2055546497, 3, -(((r6 * (-4)) - 17858586) | 2), 1) ^ 2073405105];
        bArr2[0] = -107;
        bArr2[1] = -35;
        bArr2[2] = -121;
        bArr2[3] = 52;
        bArr2[4] = 30;
        bArr2[5] = -3;
        bArr2[6] = 39;
        bArr2[7] = 17;
        bArr2[8] = 21;
        bArr2[9] = -24;
        bArr2[10] = 37;
        bArr2[11] = Byte.MAX_VALUE;
        bArr2[12] = -125;
        bArr2[13] = 1;
        bArr2[14] = -73;
        bArr2[15] = -36;
        bArr2[16] = 72;
        bArr2[17] = 32;
        bArr2[18] = -76;
        bArr2[19] = -12;
        bArr2[20] = 79;
        bArr2[21] = 55;
        bArr2[22] = 117;
        bArr2[23] = 23;
        bArr2[24] = -45;
        bArr2[25] = 19;
        bArr2[26] = 32;
        bArr2[27] = -33;
        bArr2[28] = -93;
        bArr2[29] = 71;
        bArr2[30] = 13;
        bArr2[31] = -6;
        bArr2[32] = 106;
        bArr2[33] = -57;
        bArr2[34] = -17;
        bArr2[35] = -9;
        long j81 = j66 + (j65 | j64);
        long j82 = j81 + (j60 | j59);
        long j83 = (j82 >>> 48) & 21845;
        long j84 = ((j83 >>> 1) | j83) & 858993459;
        long j85 = ((j84 >>> 2) | j84) & 252645135;
        long j86 = (j82 >>> 32) & 21845;
        long j87 = ((j86 >>> 1) | j86) & 858993459;
        long j88 = ((j87 >>> 2) | j87) & 252645135;
        long j89 = ((((j88 >>> 4) | j88) & 16711935) << 16) + ((((j85 >>> 4) | j85) & 16711935) << 24);
        long j90 = (j82 >>> 16) & 21845;
        long j91 = ((j90 >>> 1) | j90) & 858993459;
        long j92 = ((j91 >>> 2) | j91) & 252645135;
        long j93 = j82 & 21845;
        long j94 = ((j93 >>> 1) | j93) & 858993459;
        long j95 = ((j94 >>> 2) | j94) & 252645135;
        int i = (int) ((((j95 >>> 4) | j95) & 16711935) | (((((j92 >>> 4) | j92) & 16711935) << 8) + j89));
        bArr2[(((-2074059774) & (((-1705306872) + i) + (((-i) - 1) | 1705306872))) + 33129) ^ (-2074026673)] = -111;
        bArr2[37] = -118;
        bArr2[38] = 95;
        bArr2[39] = 21;
        bArr2[40] = -117;
        bArr2[41] = 23;
        a(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        long j96 = 1901578542;
        long b5 = c3.b((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j23, 6148914691236517205L);
        long j97 = (b5 >>> 48) & 43690;
        long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
        long j99 = ((j98 >>> 2) | j98) & 252645135;
        long j100 = (b5 >>> 32) & 43690;
        long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
        long j102 = ((j101 >>> 2) | j101) & 252645135;
        long j103 = ((((j102 >>> 4) | j102) & 16711935) << 16) | ((((j99 >>> 4) | j99) & 16711935) << 24);
        long j104 = (b5 >>> 16) & 43690;
        long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
        long j106 = ((j105 >>> 2) | j105) & 252645135;
        long j107 = b5 & 43690;
        long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
        long j109 = ((j108 >>> 2) | j108) & 252645135;
        long j110 = 537141489;
        long j111 = 49;
        long j112 = (((((((((j110 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j110 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j110 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j110 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j111 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j111 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j111 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j111 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j113 = (j112 >>> 48) & 43690;
        long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
        long j115 = ((j114 >>> 2) | j114) & 252645135;
        long j116 = (j112 >>> 32) & 43690;
        long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
        long j118 = ((j117 >>> 2) | j117) & 252645135;
        long j119 = ((((j118 >>> 4) | j118) & 16711935) << 16) | ((((j115 >>> 4) | j115) & 16711935) << 24);
        long j120 = (j112 >>> 16) & 43690;
        long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
        long j122 = ((j121 >>> 2) | j121) & 252645135;
        long j123 = ((((j122 >>> 4) | j122) & 16711935) << 8) + j119;
        long j124 = j112 & 43690;
        long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
        long j126 = (j125 | (j125 >>> 2)) & 252645135;
        byte[] bArr3 = {35, 23, -22, ((((int) ((((j109 >>> 4) | j109) & 16711935) + (((((j106 >>> 4) | j106) & 16711935) << 8) | j103))) & (-916764672)) + ((int) (((j126 | (j126 >>> 4)) & 16711935) + j123))) ^ 379623184, 42, -111, 120, 38, -27};
        long j127 = 16836880;
        long j128 = ((((((((j127 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j127 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j127 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j127 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j61;
        long j129 = (j128 >>> 48) & 43690;
        long j130 = ((j129 >>> 2) | (j129 >>> 1)) & 858993459;
        long j131 = ((j130 >>> 2) | j130) & 252645135;
        long j132 = (j128 >>> 32) & 43690;
        long j133 = ((j132 >>> 2) | (j132 >>> 1)) & 858993459;
        long j134 = ((j133 >>> 2) | j133) & 252645135;
        long j135 = ((((j134 >>> 4) | j134) & 16711935) << 16) + ((((j131 >>> 4) | j131) & 16711935) << 24);
        long j136 = (j128 >>> 16) & 43690;
        long j137 = ((j136 >>> 2) | (j136 >>> 1)) & 858993459;
        long j138 = ((j137 >>> 2) | j137) & 252645135;
        long j139 = j128 & 43690;
        long j140 = ((j139 >>> 2) | (j139 >>> 1)) & 858993459;
        long j141 = ((j140 >>> 2) | j140) & 252645135;
        a(bArr3, new byte[]{-16, ((((int) ((((j141 >>> 4) | j141) & 16711935) + (((((j138 >>> 4) | j138) & 16711935) << 8) | j135))) | 151007489) + 571263168) ^ (-722270711), -47, -89, 10, -43, -80, 85, -104});
        String intern2 = new String(bArr3, charset).intern();
        byte[] bArr4 = new byte[23];
        bArr4[0] = 110;
        bArr4[1] = -72;
        bArr4[2] = -92;
        bArr4[3] = -103;
        bArr4[4] = 5;
        bArr4[5] = 49;
        bArr4[6] = -45;
        long j142 = -771521533;
        long j143 = -17;
        long j144 = ((((((((j142 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j142 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j142 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j142 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j143 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j143 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j143 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j143 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j145 = (j144 >>> 48) & 43690;
        long j146 = ((j145 >>> 2) | (j145 >>> 1)) & 858993459;
        long j147 = ((j146 >>> 2) | j146) & 252645135;
        long j148 = (j144 >>> 32) & 43690;
        long j149 = ((j148 >>> 2) | (j148 >>> 1)) & 858993459;
        long j150 = ((j149 >>> 2) | j149) & 252645135;
        long j151 = ((((j150 >>> 4) | j150) & 16711935) << 16) + ((((j147 >>> 4) | j147) & 16711935) << 24);
        long j152 = (j144 >>> 16) & 43690;
        long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
        long j154 = ((j153 >>> 2) | j153) & 252645135;
        long j155 = j144 & 43690;
        long j156 = ((j155 >>> 2) | (j155 >>> 1)) & 858993459;
        long j157 = ((j156 >>> 2) | j156) & 252645135;
        int i3 = -((int) ((((j157 >>> 4) | j157) & 16711935) | ((((j154 >>> 4) | j154) & 16711935) << 8) | j151));
        bArr4[V2.a(~i3, -160956525, (-160956524) + i3) ^ (-610565016)] = 64;
        bArr4[8] = 74;
        bArr4[9] = -99;
        bArr4[10] = 71;
        bArr4[11] = 14;
        bArr4[12] = -12;
        bArr4[13] = -123;
        bArr4[14] = 39;
        bArr4[15] = -82;
        bArr4[16] = -71;
        bArr4[17] = 27;
        bArr4[18] = 37;
        long j158 = 1161611718;
        long j159 = -1161611729;
        long j160 = ((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j159 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j159 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j159 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j159 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j161 = (j160 >>> 48) & 21845;
        long j162 = ((j161 >>> 1) | j161) & 858993459;
        long j163 = ((j162 >>> 2) | j162) & 252645135;
        long j164 = (j160 >>> 32) & 21845;
        long j165 = ((j164 >>> 1) | j164) & 858993459;
        long j166 = ((j165 >>> 2) | j165) & 252645135;
        long j167 = ((((j166 >>> 4) | j166) & 16711935) << 16) + ((((j163 >>> 4) | j163) & 16711935) << 24);
        long j168 = (j160 >>> 16) & 21845;
        long j169 = ((j168 >>> 1) | j168) & 858993459;
        long j170 = ((j169 >>> 2) | j169) & 252645135;
        long j171 = j160 & 21845;
        long j172 = ((j171 >>> 1) | j171) & 858993459;
        long j173 = ((j172 >>> 2) | j172) & 252645135;
        bArr4[19] = (int) ((((j173 >>> 4) | j173) & 16711935) + (((((j170 >>> 4) | j170) & 16711935) << 8) | j167));
        bArr4[20] = -31;
        bArr4[21] = -47;
        bArr4[22] = 124;
        a(bArr4, new byte[]{-113, 65, -94, -113, 96, 33, -73, 93, -31, -10, 9, 21, 106, 71, 78, -7, 93, -38, 123, -11, -112, 101, 2});
        String intern3 = new String(bArr4, charset).intern();
        byte[] bArr5 = new byte[21];
        bArr5[0] = -74;
        bArr5[1] = -119;
        bArr5[2] = -96;
        bArr5[3] = -110;
        bArr5[4] = 29;
        bArr5[5] = 123;
        bArr5[6] = 79;
        bArr5[7] = -79;
        bArr5[8] = 79;
        bArr5[9] = 109;
        bArr5[10] = -23;
        bArr5[11] = -13;
        bArr5[12] = 61;
        bArr5[13] = 102;
        bArr5[14] = -126;
        long j174 = 1075838996;
        long j175 = 32;
        long j176 = (((((((((j174 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j174 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j174 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j174 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j175 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j175 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j175 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j175 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j177 = (j176 >>> 48) & 43690;
        long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
        long j179 = ((j178 >>> 2) | j178) & 252645135;
        long j180 = (j176 >>> 32) & 43690;
        long j181 = ((j180 >>> 2) | (j180 >>> 1)) & 858993459;
        long j182 = ((j181 >>> 2) | j181) & 252645135;
        long j183 = ((((j182 >>> 4) | j182) & 16711935) << 16) | ((((j179 >>> 4) | j179) & 16711935) << 24);
        long j184 = (j176 >>> 16) & 43690;
        long j185 = ((j184 >>> 2) | (j184 >>> 1)) & 858993459;
        long j186 = ((j185 >>> 2) | j185) & 252645135;
        long j187 = ((((j186 >>> 4) | j186) & 16711935) << 8) + j183;
        long j188 = j176 & 43690;
        long j189 = ((j188 >>> 2) | (j188 >>> 1)) & 858993459;
        long j190 = ((j189 >>> 2) | j189) & 252645135;
        bArr5[(((int) ((((j190 >>> 4) | j190) & 16711935) + j187)) + 67903755) ^ 1143742768] = 0;
        bArr5[16] = 80;
        bArr5[17] = -60;
        bArr5[18] = 113;
        bArr5[19] = -66;
        bArr5[20] = 68;
        a(bArr5, new byte[]{26, 121, 25, 73, -72, -92, -42, -39, -2, -38, 62, -37, 56, -15, 55, -73, -115, -61, 84, -75, 102});
        String intern4 = new String(bArr5, charset).intern();
        byte[] bArr6 = {56, 108, 29, 118, -94, -97, -32, -69, -95, 6, -48, -47, 80, -29, -113, -114, 94, -43, 42};
        a(bArr6, new byte[]{95, 23, -80, 46, 31, -98, 19, 47, -3, -33, -81, -115, 110, -79, -93, -32, -73, 8, -41});
        String intern5 = new String(bArr6, charset).intern();
        long h2 = AbstractC0008a.h(j58, j56 | j55, j60, j81);
        long j191 = (h2 >>> 48) & 21845;
        long j192 = ((j191 >>> 1) | j191) & 858993459;
        long j193 = ((j192 >>> 2) | j192) & 252645135;
        long j194 = (h2 >>> 32) & 21845;
        long j195 = ((j194 >>> 1) | j194) & 858993459;
        long j196 = ((j195 >>> 2) | j195) & 252645135;
        long j197 = ((((j196 >>> 4) | j196) & 16711935) << 16) + ((((j193 >>> 4) | j193) & 16711935) << 24);
        long j198 = (h2 >>> 16) & 21845;
        long j199 = ((j198 >>> 1) | j198) & 858993459;
        long j200 = ((j199 >>> 2) | j199) & 252645135;
        long j201 = h2 & 21845;
        long j202 = ((j201 >>> 1) | j201) & 858993459;
        long j203 = ((j202 >>> 2) | j202) & 252645135;
        long j204 = -1604257607;
        long j205 = (int) ((((j203 >>> 4) | j203) & 16711935) | (((((j200 >>> 4) | j200) & 16711935) << 8) + j197));
        long j206 = (((((((((j204 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j204 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j204 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j204 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j205 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j205 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j205 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j205 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
        long j207 = (j206 >>> 48) & 43690;
        long j208 = ((j207 >>> 2) | (j207 >>> 1)) & 858993459;
        long j209 = ((j208 >>> 2) | j208) & 252645135;
        long j210 = (j206 >>> 32) & 43690;
        long j211 = ((j210 >>> 2) | (j210 >>> 1)) & 858993459;
        long j212 = ((j211 >>> 2) | j211) & 252645135;
        long j213 = ((((j212 >>> 4) | j212) & 16711935) << 16) | ((((j209 >>> 4) | j209) & 16711935) << 24);
        long j214 = (j206 >>> 16) & 43690;
        long j215 = ((j214 >>> 2) | (j214 >>> 1)) & 858993459;
        long j216 = ((j215 >>> 2) | j215) & 252645135;
        long j217 = j206 & 43690;
        long j218 = ((j217 >>> 2) | (j217 >>> 1)) & 858993459;
        long j219 = ((j218 >>> 2) | j218) & 252645135;
        byte[] bArr7 = new byte[((((int) ((((((j216 >>> 4) | j216) & 16711935) << 8) | j213) | (((j219 >>> 4) | j219) & 16711935))) & (-1811887464)) + 1627529254) ^ (-184358221)];
        bArr7[0] = 4;
        bArr7[1] = -58;
        bArr7[2] = 118;
        bArr7[3] = 95;
        bArr7[4] = 93;
        bArr7[5] = 11;
        bArr7[6] = 2;
        bArr7[7] = -73;
        bArr7[8] = 77;
        bArr7[9] = -80;
        bArr7[10] = 43;
        bArr7[11] = -78;
        bArr7[12] = -126;
        byte[] bArr8 = new byte[13];
        bArr8[0] = -123;
        bArr8[1] = -65;
        bArr8[2] = -51;
        bArr8[3] = 31;
        bArr8[4] = 126;
        bArr8[5] = -96;
        bArr8[6] = -62;
        bArr8[7] = -112;
        bArr8[8] = -53;
        bArr8[9] = -112;
        long j220 = j66 + (j65 | (j63 + j62)) + j60 + (j58 | j57);
        long j221 = (j220 >>> 48) & 21845;
        long j222 = ((j221 >>> 1) | j221) & 858993459;
        long j223 = ((j222 >>> 2) | j222) & 252645135;
        long j224 = (j220 >>> 32) & 21845;
        long j225 = ((j224 >>> 1) | j224) & 858993459;
        long j226 = ((j225 >>> 2) | j225) & 252645135;
        long j227 = ((((j226 >>> 4) | j226) & 16711935) << 16) + ((((j223 >>> 4) | j223) & 16711935) << 24);
        long j228 = (j220 >>> 16) & 21845;
        long j229 = ((j228 >>> 1) | j228) & 858993459;
        long j230 = ((j229 >>> 2) | j229) & 252645135;
        long j231 = j220 & 21845;
        long j232 = ((j231 >>> 1) | j231) & 858993459;
        long j233 = ((j232 >>> 2) | j232) & 252645135;
        int i4 = (int) ((((j233 >>> 4) | j233) & 16711935) | ((((j230 >>> 4) | j230) & 16711935) << 8) | j227);
        long j234 = -1556685032;
        long j235 = i4;
        long b6 = c3.b((((((((j234 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j234 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j234 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j234 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j235 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j235 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j235 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j235 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j236 = (b6 >>> 48) & 43690;
        long j237 = ((j236 >>> 2) | (j236 >>> 1)) & 858993459;
        long j238 = ((j237 >>> 2) | j237) & 252645135;
        long j239 = (b6 >>> 32) & 43690;
        long j240 = ((j239 >>> 2) | (j239 >>> 1)) & 858993459;
        long j241 = ((j240 >>> 2) | j240) & 252645135;
        long j242 = ((((j241 >>> 4) | j241) & 16711935) << 16) + ((((j238 >>> 4) | j238) & 16711935) << 24);
        long j243 = (b6 >>> 16) & 43690;
        long j244 = ((j243 >>> 2) | (j243 >>> 1)) & 858993459;
        long j245 = ((j244 >>> 2) | j244) & 252645135;
        long j246 = b6 & 43690;
        long j247 = ((j246 >>> 2) | (j246 >>> 1)) & 858993459;
        long j248 = ((j247 >>> 2) | j247) & 252645135;
        int i5 = (((int) ((((j248 >>> 4) | j248) & 16711935) | (((((j245 >>> 4) | j245) & 16711935) << 8) + j242))) & 36735874) + 8533065;
        bArr8[E1.a(45268929 | i5, 45268929, i5)] = Byte.MAX_VALUE;
        bArr8[11] = 57;
        bArr8[12] = 34;
        a(bArr7, bArr8);
        String intern6 = new String(bArr7, charset).intern();
        byte[] bArr9 = {84};
        byte[] bArr10 = new byte[8];
        bArr10[0] = -52;
        bArr10[1] = 125;
        bArr10[2] = -85;
        long j249 = 1076167812;
        long j250 = (((((((((j249 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j249 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j249 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j249 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j22 + (j21 | j20);
        long j251 = (j250 >>> 48) & 43690;
        long j252 = ((j251 >>> 2) | (j251 >>> 1)) & 858993459;
        long j253 = ((j252 >>> 2) | j252) & 252645135;
        long j254 = (j250 >>> 32) & 43690;
        long j255 = ((j254 >>> 2) | (j254 >>> 1)) & 858993459;
        long j256 = ((j255 >>> 2) | j255) & 252645135;
        long j257 = ((((j256 >>> 4) | j256) & 16711935) << 16) + ((((j253 >>> 4) | j253) & 16711935) << 24);
        long j258 = (j250 >>> 16) & 43690;
        long j259 = ((j258 >>> 2) | (j258 >>> 1)) & 858993459;
        long j260 = ((j259 >>> 2) | j259) & 252645135;
        long j261 = j250 & 43690;
        long j262 = ((j261 >>> 2) | (j261 >>> 1)) & 858993459;
        long j263 = ((j262 >>> 2) | j262) & 252645135;
        int i6 = ((int) ((((j263 >>> 4) | j263) & 16711935) | (((((j260 >>> 4) | j260) & 16711935) << 8) + j257))) - 2130698238;
        bArr10[(((~i6) & (-1054530427)) - ((-1054530427) & i6)) + i6] = 38;
        bArr10[4] = 5;
        bArr10[5] = 51;
        bArr10[6] = -111;
        bArr10[7] = 26;
        a(bArr9, bArr10);
        return intern + this.f811a + intern2 + this.f812b + intern3 + this.f813c + intern4 + this.f814d + intern5 + this.f815e + intern6 + this.f816f + new String(bArr9, charset).intern();
    }
}
