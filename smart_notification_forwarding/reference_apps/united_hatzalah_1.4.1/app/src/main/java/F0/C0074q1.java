package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.q1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0074q1 extends g3 {

    /* renamed from: g, reason: collision with root package name */
    public final C0050k1 f610g;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x01b6. Please report as an issue. */
    static {
        byte[] bArr;
        int i;
        char c4;
        byte[] bArr2;
        char c5;
        int i3;
        int i4 = 8;
        int i5 = 0;
        int i6 = 1;
        char c6 = 4;
        byte[] bArr3 = {115, -52, 18, 57, -45, Byte.MAX_VALUE, -72, 90};
        byte[] bArr4 = new byte[8];
        bArr4[0] = 123;
        bArr4[1] = -97;
        bArr4[2] = -12;
        bArr4[3] = -2;
        bArr4[4] = -44;
        bArr4[5] = 29;
        long j2 = 735313617;
        long j3 = -11;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        bArr4[((((int) (((j17 | (j17 >>> 4)) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) & 1141482384) + 172361728) ^ 1313844118] = 111;
        bArr4[7] = -100;
        byte[] bArr5 = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = -894652659;
        byte[] bArr6 = null;
        while (true) {
            int i11 = ((i10 & 16777216) * (i10 | 16777216)) + ((i10 & (-16777217)) * ((~i10) & 16777216));
            int i12 = i10 >>> i4;
            int i13 = (i12 + i11) - (i12 & i11);
            int i14 = (i13 ^ 1458005263) + ((i13 & 1458005263) * 2);
            int i15 = 1298988808;
            int i16 = 196573321;
            switch ((i14 - 1434379843) + (((~i14) & 1434379843) * 2)) {
                case -1970406716:
                    int i17 = i5;
                    bArr = bArr4;
                    i = i6;
                    c4 = c6;
                    int i18 = i7;
                    int length = bArr6.length;
                    int i19 = 0 - i18;
                    int i20 = ~i19;
                    int i21 = ((length | i19) - ((602749225 & i20) & length)) + ((i19 | 602749225) & length);
                    byte b4 = bArr5[i21];
                    int length2 = bArr6.length;
                    byte b5 = bArr5[(length2 ^ i20) + ((i19 | length2) * 2) + 1];
                    int i22 = ((byte) i17) - b4;
                    bArr5[i21] = (byte) (((byte) (((byte) 2) * ((byte) (b5 & (~i22))))) - ((byte) (b5 ^ i22)));
                    i7 = i18;
                    i5 = i17;
                    i10 = -34715366;
                    bArr4 = bArr;
                    c6 = c4;
                    i6 = i;
                    i4 = 8;
                case -1882653318:
                    int i23 = i5;
                    bArr = bArr4;
                    c4 = c6;
                    int i24 = (i8 - 1) - (i8 | (-4));
                    byte b6 = bArr5[i24];
                    int i25 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i26 = i8 + 3 + (((-1) - i8) | (-3));
                    int i27 = bArr5[i26] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = ~((i25 | ((~i28) | 1169991170)) - ((i28 & 1169991170) | i25));
                    int a2 = j3.a(689061172 & i8, i8, i6, 689061173 & i8);
                    int i30 = bArr5[a2] & ForkServer.ERROR;
                    i = i6;
                    int i31 = ((~i29) & (i30 * ((~i30) & UserVerificationMethods.USER_VERIFY_HANDPRINT))) + i29;
                    int i32 = (i31 - 1) - ((~(bArr5[i8] & ForkServer.ERROR)) | i31);
                    byte b7 = bArr6[i24];
                    int i33 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i34 = bArr6[i26] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & 65536);
                    int i36 = ~((i33 | ((~i35) | (-445685625))) - ((i35 & (-445685625)) | i33));
                    int i37 = bArr6[a2] & ForkServer.ERROR;
                    int i38 = i37 * ((~i37) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i39 = (i38 + i36) - (i38 & i36);
                    int i40 = bArr6[i8] & ForkServer.ERROR;
                    int i41 = (i39 & (~i40)) + i40;
                    int i42 = i7;
                    int i43 = i32 << ((i32 > Double.NaN ? 1 : (i32 == Double.NaN ? 0 : -1)) >>> 31);
                    int i44 = (i43 + i41) - ((i43 & i41) * 2);
                    int i45 = 659933421 - ((i44 & 2) | ((-1983400303) - i44));
                    bArr6[i8] = (byte) i45;
                    bArr6[a2] = (byte) (i45 >>> 8);
                    bArr6[i26] = (byte) (i45 >>> 16);
                    bArr6[i24] = (byte) (i45 >>> 24);
                    i8 = (i8 ^ 4) + ((i8 & 4) * 2);
                    int length3 = bArr6.length;
                    int length4 = 0 - (bArr6.length % 4);
                    int i46 = ((i8 > ((length3 ^ length4) + ((length3 & length4) * 2)) ? 1 : (i8 == ((length3 ^ length4) + ((length3 & length4) * 2)) ? 0 : -1)) >>> 31) & 1;
                    if (i46 != 0) {
                        i10 = 196573321;
                    } else {
                        i10 = 145880015;
                    }
                    i7 = i42;
                    if (i46 != 0) {
                        i5 = i23;
                        i10 = -826922365;
                    } else {
                        i5 = i23;
                    }
                    bArr4 = bArr;
                    c6 = c4;
                    i6 = i;
                    i4 = 8;
                case -625567707:
                    break;
                case 172635213:
                    int i47 = i5;
                    bArr2 = bArr4;
                    c5 = c6;
                    int length5 = bArr6.length;
                    int i48 = 0 - i9;
                    if ((bArr5[(length5 ^ i48) + ((length5 & i48) * 2)] > Double.NaN ? 1 : (bArr5[(length5 ^ i48) + ((length5 & i48) * 2)] == Double.NaN ? 0 : -1)) > -1) {
                        i16 = -34715366;
                    }
                    i5 = i47;
                    i7 = i9;
                    i10 = i16;
                    bArr4 = bArr2;
                    c6 = c5;
                    i4 = 8;
                case 614184219:
                    i3 = i5;
                    bArr2 = bArr4;
                    int length6 = bArr6.length;
                    int i49 = 0 - i7;
                    int i50 = i49 * 3;
                    int a4 = D1.a(i49, length6);
                    int length7 = bArr6.length;
                    byte b8 = bArr6[(length7 ^ i49) + ((length7 & i49) * 2)];
                    int length8 = bArr6.length;
                    int i51 = 0 - i49;
                    byte b9 = bArr5[((length8 & (~i51)) * 2) - (length8 ^ i51)];
                    c5 = c6;
                    bArr6[AbstractC0014b1.a((length6 & 2) | a4, i50)] = (byte) (((byte) (b9 + b8)) - ((byte) (((byte) 2) * ((byte) (b9 & b8)))));
                    i9 = ((-338014207) | i7) + (338014206 | i7);
                    int i52 = ((i7 > 2 ? 1 : (i7 == 2 ? 0 : -1)) >>> 31) & i6;
                    if (i52 != 0) {
                        i15 = 196573321;
                    }
                    if (i52 == 0) {
                        i5 = i3;
                        i10 = i15;
                        bArr4 = bArr2;
                        c6 = c5;
                        i4 = 8;
                    }
                    i5 = i3;
                    bArr4 = bArr2;
                    c6 = c5;
                    i10 = -518432968;
                    i4 = 8;
                case 835516413:
                    bArr6 = bArr3;
                    i8 = i5;
                    i10 = -826922365;
                    bArr5 = bArr4;
                case 1888416065:
                    i9 = bArr6.length % 4;
                    i3 = i5;
                    bArr2 = bArr4;
                    int i53 = ((i9 > i6 ? 1 : (i9 == i6 ? 0 : -1)) >>> 31) & i6;
                    if (i53 != 0) {
                        i15 = 196573321;
                    }
                    if (i53 != 0) {
                        c5 = c6;
                        i5 = i3;
                        bArr4 = bArr2;
                        c6 = c5;
                        i10 = -518432968;
                        i4 = 8;
                    } else {
                        i5 = i3;
                        i10 = i15;
                        bArr4 = bArr2;
                    }
                default:
                    i10 = 196573321;
            }
            new String(bArr3, StandardCharsets.UTF_8).intern();
            return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0074q1(C0093v1 c0093v1, C0054l1 c0054l1, C0050k1 c0050k1) {
        super(c0093v1, c0054l1);
        byte[] bArr = {112, 13, 56, -100, -53, 28};
        long j2 = 786974318;
        long j3 = -786974214;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j5 = (j4 >>> 48) & 21845;
        long j6 = (j5 | (j5 >>> 1)) & 858993459;
        long j7 = (j6 | (j6 >>> 2)) & 252645135;
        long j8 = (j4 >>> 32) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | (((j7 | (j7 >>> 4)) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        v(bArr, new byte[]{120, (int) (((j17 | (j17 >>> 4)) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11), -50, -103, -82, 110, -84, -16});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = {-76, -18, 41, 37, 53, 54, 33, 87};
        v(bArr2, new byte[]{42, -71, -6, -28, -83, 74, -4, -41});
        new String(bArr2, charset).intern();
        byte[] bArr3 = {43, 42, 94, 75, -109, 48, 2};
        v(bArr3, new byte[]{-68, 99, -65, -33, -14, 87, 103, -126});
        kotlin.jvm.internal.j.e(c0050k1, new String(bArr3, charset).intern());
        this.f610g = c0050k1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~C0074q1.class.getName().length();
        int length3 = (((~(((C0074q1.class.getName().length() | 70245657) | i7) - (i7 | (C0074q1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C0074q1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C0074q1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C0074q1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C0074q1.class.getName().length()) | (-576567005)) & 276971586) + ((C0074q1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C0074q1.class.getName().length()) | (-1157759625)) & 1755853004) + ((C0074q1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C0074q1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C0074q1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C0074q1.class.getName().length()) | (-1064961)) + 689325073) + ((C0074q1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C0074q1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C0074q1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C0074q1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C0074q1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C0074q1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C0074q1.class.getName().length();
                    int length11 = (161497089 & (((((C0074q1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C0074q1.class.getName().length() | i14) & 797295576))) + ((C0074q1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C0074q1.class.getName().length()) | (-1085986263)) & 1078327440) + ((C0074q1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C0074q1.class.getName().length();
                    int length12 = length5 >>> ((((~(((C0074q1.class.getName().length() | 626856794) | i15) - ((C0074q1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C0074q1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C0074q1.class.getName().length()) | 1248713193) & 826417528) + ((C0074q1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C0074q1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C0074q1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C0074q1.class.getName().length()) | (-1005965450)) & 153223237) + ((C0074q1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C0074q1.class.getName().length() & (~length6)) & i9)) + ((C0074q1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C0074q1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C0074q1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C0074q1.class.getName().length()) | (-23496740)) & 827084804) + ((C0074q1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C0074q1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C0074q1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C0074q1.class.getName().length()) | (-961655275)) & 25184460) + ((C0074q1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C0074q1.class.getName().length()) | 1233459797) & 125923146) + ((C0074q1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C0074q1.class.getName().length()) | (-7107622)) & 402932290) + ((C0074q1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C0074q1.class.getName().length() | length15) - (b4 | length15)) + I2.a(C0074q1.class, b4) + (C0074q1.class.getName().length() & length15);
                    int length17 = ((((~C0074q1.class.getName().length()) | (-81143879)) & 438583424) + ((C0074q1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C0074q1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C0074q1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C0074q1.class, 568748773 | i24) + (C0074q1.class.getName().length() & (-2105278367)))) + ((C0074q1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C0074q1.class.getName().length()) | (-1592082969)) & 140665109) + ((C0074q1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C0074q1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C0074q1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C0074q1.class.getName().length()) | (-180811308));
                    int length19 = (C0074q1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C0074q1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C0074q1.class.getName().length()))));
                    int i29 = ((~C0074q1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C0074q1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C0074q1.class.getName().length()) | 75364313) & 1242301609) + ((C0074q1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C0074q1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C0074q1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C0074q1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C0074q1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C0074q1.class.getName().length();
                    int length24 = 1409942802 & (((((C0074q1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C0074q1.class.getName().length()) & 91135407));
                    int length25 = (C0074q1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C0074q1.class.getName().length()) | (-537919489)) - (-806798471)) + ((C0074q1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C0074q1.class.getName().length()) | (-382746167)) & 102532165) + ((C0074q1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C0074q1.class.getName().length()) | (-6036961)) & 1233145505) + ((C0074q1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C0074q1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C0074q1.class.getName().length() & 268460041;
                    i5 = (((((C0074q1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C0074q1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C0074q1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C0074q1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C0074q1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C0074q1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C0074q1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C0074q1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C0074q1.class, -1) | (-532481)) - (-67641369)) + ((C0074q1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C0074q1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C0074q1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C0074q1.class, -1) | (-33554434)) - (-1107366402)) + ((C0074q1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C0074q1.class, -1) | (-167014194)) & 1157999680) + ((C0074q1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C0074q1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C0074q1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C0074q1.class, -1) | 114408723) & 1183666176;
                    int length33 = C0074q1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C0074q1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C0074q1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C0074q1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C0074q1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C0074q1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C0074q1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C0074q1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C0074q1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C0074q1.class.getName().length()) | 991120067) & (-2113137661)) + ((C0074q1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C0074q1.class, -1) | 314136709) & 371231304) + (((C0074q1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C0074q1.class.getName().length()) | 366661365) & 1344150018) + ((C0074q1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C0074q1.class.getName().length()) | (-1359635359)) & 49026131) + ((C0074q1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C0074q1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C0074q1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C0074q1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C0074q1.class.getName().length()) | 1110430873) & 1241612298) + ((C0074q1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C0074q1.class.getName().length()) | 1603962366) & 25199440) + (((C0074q1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C0074q1.class.getName().length()) | (-1388708984)) & 706816128) + ((C0074q1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C0074q1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C0074q1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C0074q1.class.getName().length()) | 2113158628) & 1026558002) + ((C0074q1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C0074q1.class.getName().length()) | 715175224) & 136512788) + ((C0074q1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C0074q1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C0074q1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C0074q1.class.getName().length()) | (-1084937228)) & 438503696) + ((C0074q1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C0074q1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C0074q1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C0074q1.class, 1197735420 | i53) + (C0074q1.class.getName().length() & 674349280))) + ((C0074q1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C0074q1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C0074q1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C0074q1.class.getName().length()) | (-171976913)) & 318775824) + ((C0074q1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C0074q1.class.getName().length()) | (-616910267)) & 1303391760) + ((C0074q1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C0074q1.class.getName().length()) | 1297715640) & 556926729) + ((C0074q1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C0074q1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C0074q1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C0074q1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C0074q1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public final void B() {
        long j2 = 0;
        char c4 = 25508;
        Long l3 = null;
        while (true) {
            Class<C0050k1> cls = C0050k1.class;
            char c5 = 17;
            char c6 = 0;
            C0050k1 c0050k1 = this.f610g;
            char c7 = 1;
            switch (c4) {
                case 25508:
                    j2 = System.currentTimeMillis();
                    c0050k1.getClass();
                    char c8 = 1193;
                    char c9 = 1193;
                    l3 = null;
                    String str = null;
                    while (c9 != 60549) {
                        if (c9 == 53506) {
                            l3 = Long.valueOf(Long.parseLong(str));
                            c9 = 60549;
                        } else if (c9 == 15884) {
                            c9 = 60549;
                            l3 = null;
                        } else if (c9 != c8) {
                            c9 = c8;
                        } else {
                            G2 g22 = c0050k1.f554a;
                            byte[] bArr = new byte[19];
                            bArr[c6] = -76;
                            bArr[c7] = -3;
                            bArr[2] = -87;
                            bArr[3] = 77;
                            bArr[4] = 4;
                            bArr[5] = -42;
                            bArr[6] = -36;
                            bArr[7] = -62;
                            bArr[8] = Byte.MAX_VALUE;
                            bArr[9] = 93;
                            bArr[10] = 7;
                            bArr[((((~cls.getName().length()) | 658750045) & 610271829) + ((cls.getName().length() & 170000520) | 176562312)) ^ 786834134] = 9;
                            bArr[12] = -54;
                            bArr[13] = -118;
                            bArr[14] = 57;
                            char c10 = c7;
                            Class<C0050k1> cls2 = cls;
                            long j3 = -116538049;
                            char c11 = c5;
                            long j4 = ~cls.getName().length();
                            long j5 = (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                            long j6 = (j5 >>> 48) & 43690;
                            long j7 = ((j6 >>> 2) | (j6 >>> c10)) & 858993459;
                            long j8 = ((j7 >>> 2) | j7) & 252645135;
                            long j9 = (j5 >>> 32) & 43690;
                            long j10 = ((j9 >>> 2) | (j9 >>> c10)) & 858993459;
                            long j11 = ((j10 >>> 2) | j10) & 252645135;
                            long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
                            long j13 = (j5 >>> 16) & 43690;
                            long j14 = ((j13 >>> 2) | (j13 >>> c10)) & 858993459;
                            long j15 = ((j14 >>> 2) | j14) & 252645135;
                            long j16 = j5 & 43690;
                            long j17 = ((j16 >>> 2) | (j16 >>> c10)) & 858993459;
                            long j18 = ((j17 >>> 2) | j17) & 252645135;
                            bArr[((((int) ((((j18 >>> 4) | j18) & 16711935) | (((((j15 >>> 4) | j15) & 16711935) << 8) | j12))) & 1477518520) + ((cls2.getName().length() & 1323200) | (-1593566912))) ^ (-116048393)] = -48;
                            bArr[16] = -70;
                            bArr[c11] = 36;
                            bArr[18] = 93;
                            C0050k1.b(bArr, new byte[]{-17, 108, -16, 32, 114, 116, -49, -120, 39, -1, 120, 71, -69, -67, 124, -101, -37, 80, 56});
                            str = g22.c(new String(bArr, StandardCharsets.UTF_8).intern());
                            c5 = c11;
                            if (str != null) {
                                cls = cls2;
                                c7 = c10;
                                c8 = 1193;
                                c9 = 53506;
                                c6 = 0;
                            } else {
                                c9 = 15884;
                                cls = cls2;
                                c7 = c10;
                            }
                        }
                        c8 = 1193;
                        c6 = 0;
                    }
                    c4 = l3 != null ? (char) 3243 : (char) 50368;
                case 50368:
                    c4 = c0050k1.e() < 10 ? (char) 41604 : (char) 28840;
                case 28840:
                    break;
                case 41604:
                    c0050k1.h();
                    long j19 = 23204637;
                    long j20 = 10;
                    long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j22 = (j21 >>> 48) & 43690;
                    long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                    long j24 = (j23 | (j23 >>> 2)) & 252645135;
                    long j25 = (j21 >>> 32) & 43690;
                    long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                    long j27 = ((j26 >>> 2) | j26) & 252645135;
                    long j28 = (((j24 | (j24 >>> 4)) & 16711935) << 24) | ((((j27 >>> 4) | j27) & 16711935) << 16);
                    long j29 = (j21 >>> 16) & 43690;
                    long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                    long j31 = ((j30 >>> 2) | j30) & 252645135;
                    long j32 = j21 & 43690;
                    long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                    long j34 = (j33 | (j33 >>> 2)) & 252645135;
                    int i = 1788881173 + (((int) (((j34 | (j34 >>> 4)) & 16711935) | (((((j31 >>> 4) | j31) & 16711935) << 8) + j28))) | 89264768);
                    byte[] bArr2 = new byte[B0.a(1878145941 | (~i), 1878145941 - i)];
                    bArr2[0] = -95;
                    bArr2[1] = 94;
                    bArr2[2] = -57;
                    bArr2[3] = -57;
                    bArr2[4] = 61;
                    bArr2[5] = -53;
                    bArr2[6] = 77;
                    bArr2[7] = 22;
                    x(bArr2, new byte[]{-59, 59, -77, -94, 94, -65, 40, 114});
                    Charset charset = StandardCharsets.UTF_8;
                    String intern = new String(bArr2, charset).intern();
                    byte[] bArr3 = {-48, -115, 30, -94};
                    x(bArr3, new byte[]{-92, -1, 107, -57, 112, -36, 37, 45});
                    t(intern, new String(bArr3, charset).intern());
                case 43719:
                    G2 g23 = c0050k1.f554a;
                    byte[] bArr4 = {47, -25, -85, -16, 95, -14, -106, 44, -72, -114, 92, 83, -124, -52, -124, -30, 18};
                    byte[] bArr5 = new byte[17];
                    long j35 = -1;
                    long length = cls.getName().length();
                    long j36 = (((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j37 = (((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j38 = (((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j39 = (((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j40 = (j39 | j38 | j37 | j36) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j41 = (j40 >>> 48) & 21845;
                    long j42 = ((j41 >>> 1) | j41) & 858993459;
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    long j44 = (j40 >>> 32) & 21845;
                    long j45 = ((j44 >>> 1) | j44) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = ((((j46 >>> 4) | j46) & 16711935) << 16) + ((((j43 >>> 4) | j43) & 16711935) << 24);
                    long j48 = (j40 >>> 16) & 21845;
                    long j49 = ((j48 >>> 1) | j48) & 858993459;
                    long j50 = ((j49 >>> 2) | j49) & 252645135;
                    long j51 = j40 & 21845;
                    long j52 = ((j51 >>> 1) | j51) & 858993459;
                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                    bArr5[0] = 1009906720 ^ ((((cls.getName().length() & 271705129) | 540082193) + (~(-((((int) ((((j53 >>> 4) | j53) & 16711935) | (((((j50 >>> 4) | j50) & 16711935) << 8) | j47))) | 212277589) & 469824620)))) + 1);
                    bArr5[1] = -126;
                    bArr5[2] = -56;
                    bArr5[3] = -97;
                    bArr5[4] = 45;
                    bArr5[5] = -106;
                    bArr5[6] = -1;
                    bArr5[7] = 66;
                    long length2 = cls.getName().length();
                    long j54 = (j39 | j38 | (j37 + j36)) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j55 = (j54 >>> 48) & 21845;
                    long j56 = (j55 | (j55 >>> 1)) & 858993459;
                    long j57 = (j56 | (j56 >>> 2)) & 252645135;
                    long j58 = (j54 >>> 32) & 21845;
                    long j59 = ((j58 >>> 1) | j58) & 858993459;
                    long j60 = ((j59 >>> 2) | j59) & 252645135;
                    long j61 = ((((j60 >>> 4) | j60) & 16711935) << 16) + (((j57 | (j57 >>> 4)) & 16711935) << 24);
                    long j62 = (j54 >>> 16) & 21845;
                    long j63 = ((j62 >>> 1) | j62) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    long j65 = j54 & 21845;
                    long j66 = (j65 | (j65 >>> 1)) & 858993459;
                    long j67 = (j66 | (j66 >>> 2)) & 252645135;
                    bArr5[(((((int) (((j67 | (j67 >>> 4)) & 16711935) + (((((j64 >>> 4) | j64) & 16711935) << 8) + j61))) | 835431263) & 168797220) + ((cls.getName().length() & 444859488) | 814743624)) ^ 983540836] = -33;
                    bArr5[9] = -47;
                    bArr5[10] = 63;
                    bArr5[11] = 60;
                    bArr5[((((~cls.getName().length()) | (-1914184347)) & 626114700) + ((cls.getName().length() & 940703880) | (-1744695231))) ^ (-1118580543)] = -15;
                    bArr5[13] = -94;
                    bArr5[14] = -16;
                    bArr5[15] = -121;
                    bArr5[16] = 96;
                    C0050k1.g(bArr4, bArr5);
                    Charset charset2 = StandardCharsets.UTF_8;
                    String intern2 = new String(bArr4, charset2).intern();
                    byte[] bArr6 = {121};
                    byte[] bArr7 = new byte[8];
                    bArr7[0] = 73;
                    bArr7[1] = -79;
                    bArr7[2] = 110;
                    bArr7[3] = -93;
                    bArr7[4] = 110;
                    int i3 = ((~cls.getName().length()) | 1553436399) & 843583726;
                    int length3 = (cls.getName().length() & 575148032) | (-2070732784);
                    int i4 = -i3;
                    bArr7[(-1227149061) ^ ((((~i4) & length3) * 2) - (i4 ^ length3))] = -4;
                    bArr7[6] = 85;
                    bArr7[7] = 48;
                    C0050k1.g(bArr6, bArr7);
                    g23.d(intern2, new String(bArr6, charset2).intern());
                case 3243:
                    if (j2 - l3.longValue() > 86400000) {
                        c4 = 43719;
                    }
                default:
                    c4 = 43719;
            }
            A(new C0031f2(false, true, true));
            return;
        }
    }

    @Override // F0.T2
    public final void a(Context context) {
        byte[] bArr = new byte[7];
        long j2 = 539099652;
        long j3 = 10;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        bArr[884118223 ^ (345018561 + ((int) (((j17 | (j17 >>> 4)) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))))] = -33;
        bArr[1] = 68;
        bArr[2] = 47;
        bArr[3] = -6;
        bArr[4] = 4;
        bArr[5] = -76;
        bArr[6] = -61;
        long j18 = -194329852;
        long j19 = -1;
        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = (j22 | (j22 >>> 2)) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = (j25 | (j25 >>> 2)) & 252645135;
        long j27 = (((j23 | (j23 >>> 4)) & 16711935) << 24) | (((j26 | (j26 >>> 4)) & 16711935) << 16);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = (j29 | (j29 >>> 2)) & 252645135;
        long j31 = j20 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        int i = (int) (((j33 | (j33 >>> 4)) & 16711935) | ((((j30 | (j30 >>> 4)) & 16711935) << 8) + j27));
        k(bArr, new byte[]{V2.a(143723520, ~i, (-143723522) - i) ^ (-50606270), -73, -52, 97, 101, 91, 9, 88});
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
    }
}
