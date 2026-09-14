package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class g3 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f527f;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0271. Please report as an issue. */
    static {
        int i;
        int i3;
        char c4;
        long j2 = -179112532;
        long length = (((~g3.class.getName().length()) | 694872677) & 170199568) + ((g3.class.getName().length() & 42270748) | 8912940);
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j4 = (j3 >>> 48) & 21845;
        int i4 = 1;
        long j5 = (j4 | (j4 >>> 1)) & 858993459;
        int i5 = 2;
        long j6 = (j5 | (j5 >>> 2)) & 252645135;
        char c5 = 4;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = (((j6 | (j6 >>> 4)) & 16711935) << 24) | ((((j9 >>> 4) | j9) & 16711935) << 16);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = (j14 | (j14 >>> 1)) & 858993459;
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        int i6 = 0;
        byte[] bArr = {-114, -64, -70, -99, 82, (int) (((j16 | (j16 >>> 4)) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10), 62, -95, -90, 101, -84, 1, -110, -112, -28};
        byte[] bArr2 = new byte[15];
        bArr2[0] = -103;
        bArr2[1] = -111;
        bArr2[2] = 94;
        int i7 = -1;
        bArr2[(((AbstractC0008a.f(g3.class, -1) | (-1150785079)) & 49948675) + ((g3.class.getName().length() & 1083376274) | 1073809048)) ^ 1123757720] = 90;
        int i8 = ((~g3.class.getName().length()) | 1377183523) & (-2003230208);
        int length2 = g3.class.getName().length() & (-1937178624);
        bArr2[(((length2 + 67241089) + (((-length2) - 1) | (-67241089))) + i8) ^ (-1935989116)] = 91;
        bArr2[5] = -52;
        bArr2[6] = -6;
        bArr2[7] = 102;
        bArr2[8] = -95;
        bArr2[9] = 56;
        bArr2[10] = 72;
        int i9 = ~g3.class.getName().length();
        int length3 = g3.class.getName().length() & 14680593;
        int i10 = ((~length3) & 810025472) + length3;
        int i11 = -((i9 | (-487431939)) - (((-497917716) | i9) ^ 11534429));
        int i12 = i11 | i10;
        bArr2[11] = (-821559910) ^ ((i12 - (i11 * 2)) + ((i11 ^ i10) ^ i12));
        bArr2[12] = -5;
        bArr2[13] = -2;
        bArr2[14] = -125;
        byte[] bArr3 = null;
        int i13 = -894652659;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i17 = ((i13 & 16777216) * (i13 | 16777216)) + ((i13 & (-16777217)) * ((~i13) & 16777216));
            int i18 = i13 >>> 8;
            int i19 = (i18 + i17) - (i18 & i17);
            int i20 = (i19 ^ 1458005263) + ((i19 & 1458005263) * 2);
            int i21 = 1298988808;
            int i22 = 196573321;
            switch ((i20 - 1434379843) + (((~i20) & 1434379843) * i5)) {
                case -1970406716:
                    int i23 = i6;
                    int i24 = i5;
                    int i25 = i15;
                    char c6 = c5;
                    int length4 = bArr4.length;
                    int i26 = 0 - i14;
                    int i27 = ~i26;
                    int i28 = ((length4 | i26) - ((602749225 & i27) & length4)) + ((i26 | 602749225) & length4);
                    byte b4 = bArr3[i28];
                    int length5 = bArr4.length;
                    byte b5 = bArr3[(length5 ^ i27) + ((i26 | length5) * i24) + 1];
                    int i29 = ((byte) i23) - b4;
                    bArr3[i28] = (byte) (((byte) (((byte) i24) * ((byte) (b5 & (~i29))))) - ((byte) (b5 ^ i29)));
                    i5 = i24;
                    i6 = i23;
                    i13 = -34715366;
                    i15 = i25;
                    c5 = c6;
                    i4 = 1;
                    i7 = -1;
                case -1882653318:
                    int i30 = i4;
                    int i31 = i6;
                    char c7 = c5;
                    int i32 = (i15 - 1) - (i15 | (-4));
                    byte b6 = bArr3[i32];
                    int i33 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i34 = i15 + 3 + (((-1) - i15) | (-3));
                    int i35 = bArr3[i34] & ForkServer.ERROR;
                    int i36 = i35 * ((~i35) & 65536);
                    int i37 = ~((i33 | ((~i36) | 1169991170)) - ((i36 & 1169991170) | i33));
                    int a2 = j3.a(689061172 & i15, i15, i30, 689061173 & i15);
                    int i38 = bArr3[a2] & ForkServer.ERROR;
                    int i39 = ((i38 * ((~i38) & UserVerificationMethods.USER_VERIFY_HANDPRINT)) & (~i37)) + i37;
                    int i40 = (i39 - 1) - ((~(bArr3[i15] & ForkServer.ERROR)) | i39);
                    byte b7 = bArr4[i32];
                    int i41 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i42 = bArr4[i34] & ForkServer.ERROR;
                    int i43 = i42 * ((~i42) & 65536);
                    int i44 = ~((i41 | ((~i43) | (-445685625))) - ((i43 & (-445685625)) | i41));
                    int i45 = bArr4[a2] & ForkServer.ERROR;
                    int i46 = i45 * ((~i45) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i47 = (i46 + i44) - (i46 & i44);
                    int i48 = bArr4[i15] & ForkServer.ERROR;
                    int i49 = (i47 & (~i48)) + i48;
                    int i50 = i5;
                    int i51 = i15;
                    int i52 = i40 << ((i40 > Double.NaN ? 1 : (i40 == Double.NaN ? 0 : -1)) >>> 31);
                    int i53 = (i52 + i49) - ((i52 & i49) * i50);
                    int i54 = 659933421 - ((i53 & i50) | ((-1983400303) - i53));
                    bArr4[i51] = (byte) i54;
                    bArr4[a2] = (byte) (i54 >>> 8);
                    bArr4[i34] = (byte) (i54 >>> 16);
                    bArr4[i32] = (byte) (i54 >>> 24);
                    i15 = (i51 ^ 4) + ((i51 & 4) * i50);
                    int length6 = bArr4.length;
                    int length7 = 0 - (bArr4.length % 4);
                    int i55 = ((i15 > ((length6 ^ length7) + ((length6 & length7) * i50)) ? 1 : (i15 == ((length6 ^ length7) + ((length6 & length7) * i50)) ? 0 : -1)) >>> 31) & 1;
                    if (i55 == 0) {
                        i22 = 145880015;
                    }
                    i5 = i50;
                    if (i55 != 0) {
                        i13 = -826922365;
                    } else {
                        i13 = i22;
                    }
                    c5 = c7;
                    i6 = i31;
                    i4 = 1;
                    i7 = -1;
                case -625567707:
                    break;
                case 172635213:
                    i = i4;
                    i3 = i6;
                    c4 = c5;
                    int length8 = bArr4.length;
                    int i56 = 0 - i16;
                    if ((bArr3[(length8 ^ i56) + ((length8 & i56) * i5)] > Double.NaN ? 1 : (bArr3[(length8 ^ i56) + ((length8 & i56) * i5)] == Double.NaN ? 0 : -1)) <= i7) {
                        i13 = 196573321;
                    } else {
                        i13 = -34715366;
                    }
                    i14 = i16;
                    c5 = c4;
                    i6 = i3;
                    i4 = i;
                case 614184219:
                    char c8 = c5;
                    int length9 = bArr4.length;
                    int i57 = 0 - i14;
                    int i58 = i57 * 3;
                    int a4 = D1.a(i57, length9);
                    c4 = c8;
                    int length10 = bArr4.length;
                    byte b8 = bArr4[(length10 ^ i57) + ((length10 & i57) * 2)];
                    i3 = i6;
                    int length11 = bArr4.length;
                    int i59 = 0 - i57;
                    byte b9 = bArr3[((length11 & (~i59)) * i5) - (length11 ^ i59)];
                    i = i4;
                    bArr4[AbstractC0014b1.a((length9 & 2) | a4, i58)] = (byte) (((byte) (b9 + b8)) - ((byte) (((byte) i5) * ((byte) (b9 & b8)))));
                    i16 = ((-338014207) | i14) + (338014206 | i14);
                    int i60 = ((i14 > i5 ? 1 : (i14 == i5 ? 0 : -1)) >>> 31) & 1;
                    if (i60 != 0) {
                        i21 = 196573321;
                    }
                    if (i60 == 0) {
                        i13 = i21;
                        c5 = c4;
                        i6 = i3;
                        i4 = i;
                    }
                    i13 = -518432968;
                    c5 = c4;
                    i6 = i3;
                    i4 = i;
                case 835516413:
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i15 = i6;
                    i13 = -826922365;
                case 1888416065:
                    i16 = bArr4.length % 4;
                    char c9 = c5;
                    int i61 = ((i16 > i4 ? 1 : (i16 == i4 ? 0 : -1)) >>> 31) & i4;
                    if (i61 != 0) {
                        i21 = 196573321;
                    }
                    if (i61 != 0) {
                        c4 = c9;
                        i = i4;
                        i3 = i6;
                        i13 = -518432968;
                        c5 = c4;
                        i6 = i3;
                        i4 = i;
                    } else {
                        c5 = c9;
                        i13 = i21;
                    }
                default:
                    i13 = 196573321;
            }
            new String(bArr, StandardCharsets.UTF_8).intern();
            return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        int i = ~g3.class.getName().length();
        byte[] bArr = new byte[(-1924341571) ^ (((i | (-135681605)) - (((-152458839) | i) ^ (-2125954918))) + ((g3.class.getName().length() & 16793619) | 201613345))];
        bArr[0] = -69;
        bArr[1] = -106;
        bArr[2] = 104;
        bArr[3] = -47;
        bArr[4] = 19;
        bArr[5] = 94;
        k(bArr, new byte[]{1, 44, 118, -80, -14, -75, -65, -45});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = {28, 34, 41, -83, -49, -32, -21, -84};
        k(bArr2, new byte[]{72, -86, 58, -101, 44, 106, 93, -41});
        new String(bArr2, charset).intern();
        this.f527f = c0054l1;
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
        int i7 = ~g3.class.getName().length();
        int length3 = (((~(((g3.class.getName().length() | 70245657) | i7) - (i7 | (g3.class.getName().length() & (-70245658))))) & (-1979440632)) + ((g3.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(g3.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((g3.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~g3.class.getName().length()) | (-576567005)) & 276971586) + ((g3.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~g3.class.getName().length()) | (-1157759625)) & 1755853004) + ((g3.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~g3.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = g3.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~g3.class.getName().length()) | (-1064961)) + 689325073) + ((g3.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~g3.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = g3.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~g3.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (g3.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((g3.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~g3.class.getName().length();
                    int length11 = (161497089 & (((((g3.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((g3.class.getName().length() | i14) & 797295576))) + ((g3.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~g3.class.getName().length()) | (-1085986263)) & 1078327440) + ((g3.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~g3.class.getName().length();
                    int length12 = length5 >>> ((((~(((g3.class.getName().length() | 626856794) | i15) - ((g3.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((g3.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~g3.class.getName().length()) | 1248713193) & 826417528) + ((g3.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~g3.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (g3.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~g3.class.getName().length()) | (-1005965450)) & 153223237) + ((g3.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((g3.class.getName().length() & (~length6)) & i9)) + ((g3.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~g3.class.getName().length()) | (-30261291)) & (-1534000062)) + ((g3.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~g3.class.getName().length()) | (-23496740)) & 827084804) + ((g3.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~g3.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (g3.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~g3.class.getName().length()) | (-961655275)) & 25184460) + ((g3.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~g3.class.getName().length()) | 1233459797) & 125923146) + ((g3.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~g3.class.getName().length()) | (-7107622)) & 402932290) + ((g3.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((g3.class.getName().length() | length15) - (b4 | length15)) + I2.a(g3.class, b4) + (g3.class.getName().length() & length15);
                    int length17 = ((((~g3.class.getName().length()) | (-81143879)) & 438583424) + ((g3.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~g3.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((g3.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(g3.class, 568748773 | i24) + (g3.class.getName().length() & (-2105278367)))) + ((g3.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~g3.class.getName().length()) | (-1592082969)) & 140665109) + ((g3.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~g3.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((g3.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~g3.class.getName().length()) | (-180811308));
                    int length19 = (g3.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((g3.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | g3.class.getName().length()))));
                    int i29 = ((~g3.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (g3.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~g3.class.getName().length()) | 75364313) & 1242301609) + ((g3.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = g3.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((g3.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~g3.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((g3.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~g3.class.getName().length();
                    int length24 = 1409942802 & (((((g3.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | g3.class.getName().length()) & 91135407));
                    int length25 = (g3.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~g3.class.getName().length()) | (-537919489)) - (-806798471)) + ((g3.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~g3.class.getName().length()) | (-382746167)) & 102532165) + ((g3.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~g3.class.getName().length()) | (-6036961)) & 1233145505) + ((g3.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~g3.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = g3.class.getName().length() & 268460041;
                    i5 = (((((g3.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | g3.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = g3.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((g3.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~g3.class.getName().length()) | (-1883938358)) & (-738125179)) + ((g3.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~g3.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (g3.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(g3.class, -1) | (-532481)) - (-67641369)) + ((g3.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~g3.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((g3.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(g3.class, -1) | (-33554434)) - (-1107366402)) + ((g3.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(g3.class, -1) | (-167014194)) & 1157999680) + ((g3.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = g3.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((g3.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(g3.class, -1) | 114408723) & 1183666176;
                    int length33 = g3.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~g3.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = g3.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~g3.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (g3.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~g3.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((g3.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~g3.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (g3.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~g3.class.getName().length()) | 991120067) & (-2113137661)) + ((g3.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(g3.class, -1) | 314136709) & 371231304) + (((g3.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~g3.class.getName().length()) | 366661365) & 1344150018) + ((g3.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~g3.class.getName().length()) | (-1359635359)) & 49026131) + ((g3.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~g3.class.getName().length();
                    if (length3 > 0) {
                        int length38 = g3.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (g3.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~g3.class.getName().length()) | 1110430873) & 1241612298) + ((g3.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~g3.class.getName().length()) | 1603962366) & 25199440) + (((g3.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~g3.class.getName().length()) | (-1388708984)) & 706816128) + ((g3.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~g3.class.getName().length()) | 367288948) & 548745488;
                    int length41 = g3.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~g3.class.getName().length()) | 2113158628) & 1026558002) + ((g3.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~g3.class.getName().length()) | 715175224) & 136512788) + ((g3.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~g3.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = g3.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~g3.class.getName().length()) | (-1084937228)) & 438503696) + ((g3.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~g3.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((g3.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(g3.class, 1197735420 | i53) + (g3.class.getName().length() & 674349280))) + ((g3.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~g3.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (g3.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~g3.class.getName().length()) | (-171976913)) & 318775824) + ((g3.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~g3.class.getName().length()) | (-616910267)) & 1303391760) + ((g3.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~g3.class.getName().length()) | 1297715640) & 556926729) + ((g3.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~g3.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((g3.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~g3.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (g3.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
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

    public final void A(C0031f2 c0031f2) {
        byte[] bArr = new byte[6];
        bArr[0] = 42;
        bArr[1] = 52;
        bArr[2] = -42;
        bArr[3] = -83;
        bArr[4] = -40;
        bArr[((((~g3.class.getName().length()) | (-50398182)) & (-2127806175)) + ((g3.class.getName().length() & 293667105) | 310450176)) ^ (-1817355996)] = 73;
        long j2 = 513962727;
        long length = (((~g3.class.getName().length()) | 1505704737) & 513937481) + (((g3.class.getName().length() | (-100672207)) + 100672207) | 25254);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 21845;
        long j5 = ((j4 >>> 1) | j4) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        byte[] bArr2 = new byte[(int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))];
        bArr2[0] = 88;
        bArr2[1] = 81;
        bArr2[2] = ((((~g3.class.getName().length()) | (-857162216)) & (-804506864)) + ((g3.class.getName().length() & 268894504) | 25362600)) ^ 779144221;
        long j17 = -1070130895;
        long j18 = (~g3.class.getName().length()) | (-1872622711);
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        long j34 = 1075122288;
        long length2 = g3.class.getName().length();
        long j35 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j36 = (j35 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = ((j37 >>> 2) | j37) & 252645135;
        long j39 = (j35 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
        long j43 = (j35 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = j35 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = ((j47 >>> 2) | j47) & 252645135;
        int i = (int) ((((j48 >>> 4) | j48) & 16711935) + ((((j45 >>> 4) | j45) & 16711935) << 8) + j42);
        bArr2[(((int) (((j33 | (j33 >>> 4)) & 16711935) | j30)) + (~(((g3.class.getName().length() | (-46661829)) | i) - (i | (g3.class.getName().length() & 46661828))))) ^ (-1023469066)] = -40;
        bArr2[4] = -76;
        bArr2[5] = 61;
        bArr2[6] = 66;
        bArr2[7] = -123;
        x(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        C0054l1 c0054l1 = this.f527f;
        c0054l1.f().getClass();
        int i3 = AbstractC0041i0.f535a;
        byte[] bArr3 = {-124, -103, -106, -109, -115, 58, -49, 115, -7, 112, -94, -95, 94, -18, -110};
        byte[] bArr4 = new byte[15];
        bArr4[0] = -9;
        bArr4[1] = -6;
        bArr4[2] = -28;
        bArr4[3] = -10;
        bArr4[4] = -24;
        bArr4[5] = 84;
        bArr4[6] = -99;
        bArr4[7] = 22;
        long j49 = -1;
        long length3 = g3.class.getName().length();
        long j50 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j51 = (j50 >>> 48) & 21845;
        long j52 = ((j51 >>> 1) | j51) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = (j50 >>> 32) & 21845;
        long j55 = ((j54 >>> 1) | j54) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) + ((((j53 >>> 4) | j53) & 16711935) << 24);
        long j58 = (j50 >>> 16) & 21845;
        long j59 = ((j58 >>> 1) | j58) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = j50 & 21845;
        long j62 = ((j61 >>> 1) | j61) & 858993459;
        long j63 = ((j62 >>> 2) | j62) & 252645135;
        bArr4[8] = (((((int) ((((j63 >>> 4) | j63) & 16711935) + (((((j60 >>> 4) | j60) & 16711935) << 8) + j57))) | (-2065302763)) & 11127336) + ((g3.class.getName().length() & 856162477) | 989855877)) ^ (-1000983241);
        bArr4[9] = ((((~g3.class.getName().length()) | 458229684) & 228139037) + ((g3.class.getName().length() & (-2071355381)) | (-2143256062))) ^ ForkServer.DONE;
        bArr4[10] = -48;
        bArr4[11] = -59;
        bArr4[12] = 55;
        bArr4[13] = Byte.MIN_VALUE;
        int i4 = ((~g3.class.getName().length()) | 1233638357) & (-863986992);
        int length4 = g3.class.getName().length();
        int length5 = i4 + ((((g3.class.getName().length() | (-1541339131)) - (length4 | (-1541339131))) + I2.a(g3.class, length4) + (g3.class.getName().length() & (-1541339131))) | 555811855);
        bArr4[E1.a(length5 | (-308175151), -308175151, length5)] = -11;
        x(bArr3, bArr4);
        d(new String(bArr3, charset).intern(), c0031f2);
        if (c0031f2.b()) {
            byte[] bArr5 = {-79, 121, 97, -6, -67, 2, -54, -45, -110, 5, -121, -123, 5, 74, -127};
            x(bArr5, new byte[]{-62, 26, 19, -97, -40, 108, -104, -74, -15, 106, -11, -31, 108, 36, -26});
            String intern = new String(bArr5, charset).intern();
            c0054l1.f().getClass();
            s(intern);
        }
        if (c0031f2.a()) {
            c0054l1.f().getClass();
            byte[] bArr6 = new byte[15];
            bArr6[0] = -55;
            bArr6[1] = -106;
            bArr6[2] = 26;
            bArr6[3] = 49;
            bArr6[4] = -8;
            int length6 = g3.class.getName().length();
            long j64 = -229574404;
            long length7 = ((1268086068 | (((~length6) - length6) + length6)) & 228852736) + ((g3.class.getName().length() & 69402656) | 721696);
            long j65 = (((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j66 = (j65 >>> 48) & 21845;
            long j67 = ((j66 >>> 1) | j66) & 858993459;
            long j68 = ((j67 >>> 2) | j67) & 252645135;
            long j69 = (j65 >>> 32) & 21845;
            long j70 = ((j69 >>> 1) | j69) & 858993459;
            long j71 = ((j70 >>> 2) | j70) & 252645135;
            long j72 = ((((j71 >>> 4) | j71) & 16711935) << 16) | ((((j68 >>> 4) | j68) & 16711935) << 24);
            long j73 = (j65 >>> 16) & 21845;
            long j74 = ((j73 >>> 1) | j73) & 858993459;
            long j75 = ((j74 >>> 2) | j74) & 252645135;
            long j76 = j65 & 21845;
            long j77 = ((j76 >>> 1) | j76) & 858993459;
            long j78 = ((j77 >>> 2) | j77) & 252645135;
            bArr6[5] = (int) ((((j78 >>> 4) | j78) & 16711935) + (((((j75 >>> 4) | j75) & 16711935) << 8) | j72));
            bArr6[6] = -70;
            bArr6[7] = -32;
            bArr6[8] = 68;
            long j79 = -1328021288;
            long j80 = (~g3.class.getName().length()) | 888935679;
            long j81 = (((((((((j79 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j79 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j79 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j79 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j82 = (j81 >>> 48) & 43690;
            long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
            long j84 = ((j83 >>> 2) | j83) & 252645135;
            long j85 = (j81 >>> 32) & 43690;
            long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
            long j87 = ((j86 >>> 2) | j86) & 252645135;
            long j88 = ((((j87 >>> 4) | j87) & 16711935) << 16) + ((((j84 >>> 4) | j84) & 16711935) << 24);
            long j89 = (j81 >>> 16) & 43690;
            long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
            long j91 = ((j90 >>> 2) | j90) & 252645135;
            long j92 = j81 & 43690;
            long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
            long j94 = ((j93 >>> 2) | j93) & 252645135;
            int length8 = ((int) ((((((j91 >>> 4) | j91) & 16711935) << 8) + j88) | (((j94 >>> 4) | j94) & 16711935))) + ((g3.class.getName().length() & (-1994373118)) | 153246978);
            long j95 = -1174774317;
            long j96 = length8;
            long j97 = ((((((((j95 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j95 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j95 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j95 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j98 = (j97 >>> 48) & 21845;
            long j99 = ((j98 >>> 1) | j98) & 858993459;
            long j100 = ((j99 >>> 2) | j99) & 252645135;
            long j101 = (j97 >>> 32) & 21845;
            long j102 = ((j101 >>> 1) | j101) & 858993459;
            long j103 = ((j102 >>> 2) | j102) & 252645135;
            long j104 = ((((j103 >>> 4) | j103) & 16711935) << 16) + ((((j100 >>> 4) | j100) & 16711935) << 24);
            long j105 = (j97 >>> 16) & 21845;
            long j106 = ((j105 >>> 1) | j105) & 858993459;
            long j107 = ((j106 >>> 2) | j106) & 252645135;
            long j108 = j97 & 21845;
            long j109 = ((j108 >>> 1) | j108) & 858993459;
            long j110 = ((j109 >>> 2) | j109) & 252645135;
            bArr6[(int) ((((j110 >>> 4) | j110) & 16711935) + ((((j107 >>> 4) | j107) & 16711935) << 8) + j104)] = -48;
            bArr6[10] = 34;
            bArr6[11] = 53;
            bArr6[12] = 8;
            bArr6[13] = 38;
            bArr6[14] = -44;
            byte[] bArr7 = new byte[15];
            bArr7[0] = -70;
            bArr7[1] = -11;
            int i5 = ~g3.class.getName().length();
            int length9 = 1812042656 & (((((g3.class.getName().length() & (~i5)) & 462172152) + 462172152) + i5) - ((i5 | g3.class.getName().length()) & 462172152));
            long j111 = 1686474752;
            long length10 = g3.class.getName().length();
            long j112 = ((((((((j111 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j111 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j111 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j111 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length10 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length10 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length10 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length10 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j113 = (j112 >>> 48) & 43690;
            long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
            long j115 = ((j114 >>> 2) | j114) & 252645135;
            long j116 = (j112 >>> 32) & 43690;
            long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
            long j118 = ((j117 >>> 2) | j117) & 252645135;
            long j119 = ((((j118 >>> 4) | j118) & 16711935) << 16) + ((((j115 >>> 4) | j115) & 16711935) << 24);
            long j120 = (j112 >>> 16) & 43690;
            long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
            long j122 = ((j121 >>> 2) | j121) & 252645135;
            long j123 = j112 & 43690;
            long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
            long j125 = ((j124 >>> 2) | j124) & 252645135;
            bArr7[2] = (-326265908) ^ (length9 + (((int) ((((((j122 >>> 4) | j122) & 16711935) << 8) | j119) | (((j125 >>> 4) | j125) & 16711935))) | (-2138308604)));
            bArr7[3] = 84;
            bArr7[4] = -99;
            bArr7[5] = -78;
            int i6 = ((~g3.class.getName().length()) | (-136314881)) + 140787881;
            long j126 = 136347648;
            long length11 = g3.class.getName().length();
            long j127 = (((((((((j126 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j126 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j126 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j126 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j128 = (j127 >>> 48) & 43690;
            long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
            long j130 = ((j129 >>> 2) | j129) & 252645135;
            long j131 = (j127 >>> 32) & 43690;
            long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
            long j133 = ((j132 >>> 2) | j132) & 252645135;
            long j134 = ((((j133 >>> 4) | j133) & 16711935) << 16) + ((((j130 >>> 4) | j130) & 16711935) << 24);
            long j135 = (j127 >>> 16) & 43690;
            long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
            long j137 = ((j136 >>> 2) | j136) & 252645135;
            long j138 = j127 & 43690;
            long j139 = ((j138 >>> 2) | (j138 >>> 1)) & 858993459;
            long j140 = ((j139 >>> 2) | j139) & 252645135;
            bArr7[(i6 + (((int) ((((j140 >>> 4) | j140) & 16711935) + (((((j137 >>> 4) | j137) & 16711935) << 8) | j134))) | 805535808)) ^ 946323694] = -24;
            bArr7[7] = -123;
            bArr7[8] = 39;
            bArr7[9] = -65;
            bArr7[10] = 80;
            bArr7[11] = 81;
            bArr7[12] = 97;
            bArr7[13] = 72;
            bArr7[14] = -77;
            x(bArr6, bArr7);
            c0054l1.c(new String(bArr6, charset).intern(), null);
        }
    }
}
