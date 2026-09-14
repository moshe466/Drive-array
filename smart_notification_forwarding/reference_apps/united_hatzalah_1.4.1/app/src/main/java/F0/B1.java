package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class B1 extends l3 {

    /* renamed from: g, reason: collision with root package name */
    public final C0050k1 f171g;

    static {
        long j2 = -1;
        long j3 = 10;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j5 = (j4 >>> 48) & 21845;
        long j6 = ((j5 >>> 1) | j5) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        long j18 = 201466120;
        long j19 = 0;
        long b4 = c3.b((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j20 = (b4 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = (j21 | (j21 >>> 2)) & 252645135;
        long j23 = (b4 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = (j24 | (j24 >>> 2)) & 252645135;
        long j26 = (((j25 | (j25 >>> 4)) & 16711935) << 16) + (((j22 | (j22 >>> 4)) & 16711935) << 24);
        long j27 = (b4 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = (j28 | (j28 >>> 2)) & 252645135;
        long j30 = b4 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = (j31 | (j31 >>> 2)) & 252645135;
        byte[] bArr = {64, (((((int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) | (-20686912)) & 302288960) + ((int) (((j32 | (j32 >>> 4)) & 16711935) | ((((j29 | (j29 >>> 4)) & 16711935) << 8) | j26)))) ^ (-503755038), 41, -37, -72, -78, 9, 103};
        k(bArr, new byte[]{-29, 48, 58, -5, 108, -104, -34, -115});
        new String(bArr, StandardCharsets.UTF_8).intern();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B1(C0093v1 c0093v1, C0054l1 c0054l1, C0050k1 c0050k1) {
        super(c0093v1, c0054l1);
        byte[] bArr = new byte[6];
        bArr[0] = 94;
        bArr[1] = -96;
        bArr[2] = 10;
        bArr[3] = 107;
        bArr[4] = -68;
        bArr[V2.a(-2101271998, -87294101, 2013977897) ^ (-2013977902)] = -53;
        v(bArr, new byte[]{110, -31, 27, -86, -39, -71, 9, 1});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = {-98, Byte.MIN_VALUE, -18, 33, 56, 79, 109, 51};
        long j2 = 1062532703;
        long j3 = -11;
        long j4 = ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j5 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j6 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j6 + (j5 | j4), 6148914691236517205L);
        long j7 = (b4 >>> 48) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = (b4 >>> 32) & 43690;
        long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
        long j12 = ((j11 >>> 2) | j11) & 252645135;
        long j13 = ((((j12 >>> 4) | j12) & 16711935) << 16) | ((((j9 >>> 4) | j9) & 16711935) << 24);
        long j14 = (b4 >>> 16) & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        long j17 = b4 & 43690;
        long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
        long j19 = ((j18 >>> 2) | j18) & 252645135;
        v(bArr2, new byte[]{48, ((((int) ((((j19 >>> 4) | j19) & 16711935) | (((((j16 >>> 4) | j16) & 16711935) << 8) + j13))) & 507848712) + 8929717) ^ 516778422, 1, -25, -88, 85, -80, -5});
        new String(bArr2, charset).intern();
        long j20 = 139593292;
        long j21 = -1;
        long j22 = ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j23 = (j22 >>> 48) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = (j22 >>> 32) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = ((((j28 >>> 4) | j28) & 16711935) << 16) + ((((j25 >>> 4) | j25) & 16711935) << 24);
        long j30 = (j22 >>> 16) & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        long j33 = j22 & 43690;
        long j34 = ((j33 >>> 2) | (j33 >>> 1)) & 858993459;
        long j35 = ((j34 >>> 2) | j34) & 252645135;
        byte[] bArr3 = {-56, (((int) ((((j35 >>> 4) | j35) & 16711935) | (((((j32 >>> 4) | j32) & 16711935) << 8) | j29))) - 2063540221) ^ (-1923946957), 74, V2.a(268444816, 1907322842, 1638878025) ^ (-1638877968), -67, 18, 94};
        byte[] bArr4 = new byte[8];
        bArr4[0] = 31;
        bArr4[1] = 30;
        bArr4[2] = -45;
        long j36 = 1791644744;
        long b5 = c3.b((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j6 | (j5 + j4), 6148914691236517205L);
        long j37 = (b5 >>> 48) & 43690;
        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
        long j39 = (j38 | (j38 >>> 2)) & 252645135;
        long j40 = (b5 >>> 32) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = (((j39 | (j39 >>> 4)) & 16711935) << 24) | ((((j42 >>> 4) | j42) & 16711935) << 16);
        long j44 = (b5 >>> 16) & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = b5 & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = (j48 | (j48 >>> 2)) & 252645135;
        bArr4[((((int) (((j49 | (j49 >>> 4)) & 16711935) + (j43 | ((((j46 >>> 4) | j46) & 16711935) << 8)))) & 2090862604) - 2142756832) ^ (-51894225)] = -43;
        bArr4[4] = -36;
        bArr4[5] = 117;
        bArr4[6] = 59;
        bArr4[7] = -30;
        v(bArr3, bArr4);
        kotlin.jvm.internal.j.e(c0050k1, new String(bArr3, charset).intern());
        this.f171g = c0050k1;
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
        int i7 = ~B1.class.getName().length();
        int length3 = (((~(((B1.class.getName().length() | 70245657) | i7) - (i7 | (B1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((B1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(B1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((B1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~B1.class.getName().length()) | (-576567005)) & 276971586) + ((B1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~B1.class.getName().length()) | (-1157759625)) & 1755853004) + ((B1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~B1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = B1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~B1.class.getName().length()) | (-1064961)) + 689325073) + ((B1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~B1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = B1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~B1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (B1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((B1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~B1.class.getName().length();
                    int length11 = (161497089 & (((((B1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((B1.class.getName().length() | i14) & 797295576))) + ((B1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~B1.class.getName().length()) | (-1085986263)) & 1078327440) + ((B1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~B1.class.getName().length();
                    int length12 = length5 >>> ((((~(((B1.class.getName().length() | 626856794) | i15) - ((B1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((B1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~B1.class.getName().length()) | 1248713193) & 826417528) + ((B1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~B1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (B1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~B1.class.getName().length()) | (-1005965450)) & 153223237) + ((B1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((B1.class.getName().length() & (~length6)) & i9)) + ((B1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~B1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((B1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~B1.class.getName().length()) | (-23496740)) & 827084804) + ((B1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~B1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (B1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~B1.class.getName().length()) | (-961655275)) & 25184460) + ((B1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~B1.class.getName().length()) | 1233459797) & 125923146) + ((B1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~B1.class.getName().length()) | (-7107622)) & 402932290) + ((B1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((B1.class.getName().length() | length15) - (b4 | length15)) + I2.a(B1.class, b4) + (B1.class.getName().length() & length15);
                    int length17 = ((((~B1.class.getName().length()) | (-81143879)) & 438583424) + ((B1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~B1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((B1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(B1.class, 568748773 | i24) + (B1.class.getName().length() & (-2105278367)))) + ((B1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~B1.class.getName().length()) | (-1592082969)) & 140665109) + ((B1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~B1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((B1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~B1.class.getName().length()) | (-180811308));
                    int length19 = (B1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((B1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | B1.class.getName().length()))));
                    int i29 = ((~B1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (B1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~B1.class.getName().length()) | 75364313) & 1242301609) + ((B1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = B1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((B1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~B1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((B1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~B1.class.getName().length();
                    int length24 = 1409942802 & (((((B1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | B1.class.getName().length()) & 91135407));
                    int length25 = (B1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~B1.class.getName().length()) | (-537919489)) - (-806798471)) + ((B1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~B1.class.getName().length()) | (-382746167)) & 102532165) + ((B1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~B1.class.getName().length()) | (-6036961)) & 1233145505) + ((B1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~B1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = B1.class.getName().length() & 268460041;
                    i5 = (((((B1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | B1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = B1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((B1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~B1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((B1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~B1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (B1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(B1.class, -1) | (-532481)) - (-67641369)) + ((B1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~B1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((B1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(B1.class, -1) | (-33554434)) - (-1107366402)) + ((B1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(B1.class, -1) | (-167014194)) & 1157999680) + ((B1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = B1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((B1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(B1.class, -1) | 114408723) & 1183666176;
                    int length33 = B1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~B1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = B1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~B1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (B1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~B1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((B1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~B1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (B1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~B1.class.getName().length()) | 991120067) & (-2113137661)) + ((B1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(B1.class, -1) | 314136709) & 371231304) + (((B1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~B1.class.getName().length()) | 366661365) & 1344150018) + ((B1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~B1.class.getName().length()) | (-1359635359)) & 49026131) + ((B1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~B1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = B1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (B1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~B1.class.getName().length()) | 1110430873) & 1241612298) + ((B1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~B1.class.getName().length()) | 1603962366) & 25199440) + (((B1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~B1.class.getName().length()) | (-1388708984)) & 706816128) + ((B1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~B1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = B1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~B1.class.getName().length()) | 2113158628) & 1026558002) + ((B1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~B1.class.getName().length()) | 715175224) & 136512788) + ((B1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~B1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = B1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~B1.class.getName().length()) | (-1084937228)) & 438503696) + ((B1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~B1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((B1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(B1.class, 1197735420 | i53) + (B1.class.getName().length() & 674349280))) + ((B1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~B1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (B1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~B1.class.getName().length()) | (-171976913)) & 318775824) + ((B1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~B1.class.getName().length()) | (-616910267)) & 1303391760) + ((B1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~B1.class.getName().length()) | 1297715640) & 556926729) + ((B1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~B1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((B1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~B1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (B1.class.getName().length() & 44040224) | (-1811807712)), 1);
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0050. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r2v6, types: [int, boolean] */
    public final void A() {
        long j2;
        long j3;
        long j4 = 0;
        long j5 = 0;
        char c4 = 13292;
        Long l3 = null;
        B1 b12 = null;
        long j6 = 0;
        while (true) {
            C0050k1 c0050k1 = this.f171g;
            switch (c4) {
                case 13292:
                    j2 = j6;
                    j3 = j5;
                    j4 = System.currentTimeMillis();
                    l3 = c0050k1.c();
                    if (l3 != null) {
                        c4 = 54867;
                        j6 = j2;
                        j5 = j3;
                    }
                    c4 = 58868;
                    j6 = j2;
                    j5 = j3;
                case 58868:
                    c4 = 46334;
                    b12 = this;
                case 224:
                    G2 g22 = c0050k1.f554a;
                    byte[] bArr = new byte[18];
                    bArr[0] = 15;
                    bArr[1] = -35;
                    bArr[2] = -63;
                    bArr[3] = -23;
                    bArr[4] = 37;
                    bArr[5] = 64;
                    bArr[6] = 97;
                    bArr[7] = -71;
                    bArr[8] = 61;
                    bArr[9] = -14;
                    bArr[10] = 34;
                    bArr[11] = 27;
                    bArr[12] = 26;
                    bArr[13] = -48;
                    bArr[14] = 2;
                    bArr[15] = -86;
                    bArr[16] = -71;
                    int i = ((~C0050k1.class.getName().length()) | (-1947928590)) & 618678464;
                    int length = C0050k1.class.getName().length() & 872454672;
                    int i3 = ((~length) & 1342214676) + length;
                    int a2 = D.a(i, 3, -(D1.a(i, i3) | (i3 & 2)), 1);
                    bArr[E1.a(a2 | 1960893125, 1960893125, a2)] = 93;
                    long j7 = -273743258;
                    j2 = j6;
                    long j8 = ~C0050k1.class.getName().length();
                    long j9 = (((((((((j7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                    long j10 = (j9 >>> 48) & 43690;
                    long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
                    long j12 = ((j11 >>> 2) | j11) & 252645135;
                    long j13 = (j9 >>> 32) & 43690;
                    long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                    long j15 = ((j14 >>> 2) | j14) & 252645135;
                    long j16 = ((((j15 >>> 4) | j15) & 16711935) << 16) | ((((j12 >>> 4) | j12) & 16711935) << 24);
                    long j17 = (j9 >>> 16) & 43690;
                    long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
                    long j19 = ((j18 >>> 2) | j18) & 252645135;
                    long j20 = ((((j19 >>> 4) | j19) & 16711935) << 8) + j16;
                    long j21 = j9 & 43690;
                    long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
                    long j23 = (j22 | (j22 >>> 2)) & 252645135;
                    int i4 = (int) (((j23 | (j23 >>> 4)) & 16711935) + j20);
                    C0050k1.k(bArr, new byte[]{24, -116, 37, 46, 44, 1627055168 ^ (((i4 + 15918092) - (i4 | 15918092)) + ((C0050k1.class.getName().length() & 1615914072) | 1611137104)), -124, 115, 46, ((((~C0050k1.class.getName().length()) | (-1756539827)) & 725685249) + ((C0050k1.class.getName().length() & 671367432) | 268716298)) ^ (-994401637), -13, -34, 9, -77, -30, 124, -36, 47});
                    Charset charset = StandardCharsets.UTF_8;
                    String intern = new String(bArr, charset).intern();
                    byte[] bArr2 = {-69};
                    int i5 = ~C0050k1.class.getName().length();
                    j3 = j5;
                    long j24 = 84413296;
                    long j25 = 1708842619 + i5 + (((-i5) - 1) | (-1708842619));
                    long j26 = (((((((((j25 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j25 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j25 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j25 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j24 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j24 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j24 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j24 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j27 = (j26 >>> 48) & 43690;
                    long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                    long j29 = ((j28 >>> 2) | j28) & 252645135;
                    long j30 = (j26 >>> 32) & 43690;
                    long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                    long j32 = ((j31 >>> 2) | j31) & 252645135;
                    long j33 = ((((j32 >>> 4) | j32) & 16711935) << 16) | ((((j29 >>> 4) | j29) & 16711935) << 24);
                    long j34 = (j26 >>> 16) & 43690;
                    long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                    long j36 = ((j35 >>> 2) | j35) & 252645135;
                    long j37 = j26 & 43690;
                    long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                    long j39 = ((j38 >>> 2) | j38) & 252645135;
                    C0050k1.k(bArr2, new byte[]{-117, 32, 44, (((int) ((((j39 >>> 4) | j39) & 16711935) + (((((j36 >>> 4) | j36) & 16711935) << 8) | j33))) + ((C0050k1.class.getName().length() & 134242562) | (-1744769022))) ^ 1660355722, 31, 115, 93, 126});
                    g22.d(intern, new String(bArr2, charset).intern());
                    c4 = 58868;
                    j6 = j2;
                    j5 = j3;
                case 7229:
                    break;
                case 20499:
                    c0050k1.j();
                    byte[] bArr3 = {-16, -14, -68, -27, 86, 78, -55, 89};
                    y(bArr3, new byte[]{125, -57, -78, -103, 30, 106, -106, 86});
                    Charset charset2 = StandardCharsets.UTF_8;
                    String intern2 = new String(bArr3, charset2).intern();
                    byte[] bArr4 = {-11, -100, 113, -51};
                    y(bArr4, new byte[]{106, 30, -17, -64, 9, -74, -89, -43});
                    t(intern2, new String(bArr4, charset2).intern());
                case 54867:
                    j5 = l3.longValue();
                    c4 = 37004;
                    j6 = j4;
                case 37004:
                    if (j6 - j5 > 86400000) {
                        c4 = 224;
                    } else {
                        j2 = j6;
                        j3 = j5;
                        c4 = 58868;
                        j6 = j2;
                        j5 = j3;
                    }
                case 46334:
                    c4 = b12.f171g.f() < 10 ? (char) 20499 : (char) 7229;
                default:
                    c4 = 46334;
            }
            long j40 = 1895825952;
            long j41 = -11;
            long j42 = ((((((((j40 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j40 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j40 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j40 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j41 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j41 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j41 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j41 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j43 = (j42 >>> 48) & 43690;
            long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
            long j45 = (j44 | (j44 >>> 2)) & 252645135;
            long j46 = (j42 >>> 32) & 43690;
            long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
            long j48 = ((j47 >>> 2) | j47) & 252645135;
            long j49 = ((((j48 >>> 4) | j48) & 16711935) << 16) + (((j45 | (j45 >>> 4)) & 16711935) << 24);
            long j50 = (j42 >>> 16) & 43690;
            long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
            long j52 = ((j51 >>> 2) | j51) & 252645135;
            long j53 = j42 & 43690;
            long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
            long j55 = (j54 | (j54 >>> 2)) & 252645135;
            int i6 = (int) (((j55 | (j55 >>> 4)) & 16711935) + (((((j52 >>> 4) | j52) & 16711935) << 8) | j49));
            long j56 = 1090519560;
            long j57 = 10;
            long j58 = ((((((((j56 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j56 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j56 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j56 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j57 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j57 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j57 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j57 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j59 = (j58 >>> 48) & 43690;
            long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
            long j61 = (j60 | (j60 >>> 2)) & 252645135;
            long j62 = (j58 >>> 32) & 43690;
            long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
            long j64 = ((j63 >>> 2) | j63) & 252645135;
            long j65 = (((j61 | (j61 >>> 4)) & 16711935) << 24) | ((((j64 >>> 4) | j64) & 16711935) << 16);
            long j66 = (j58 >>> 16) & 43690;
            long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
            long j68 = ((j67 >>> 2) | j67) & 252645135;
            long j69 = j58 & 43690;
            long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
            long j71 = (j70 | (j70 >>> 2)) & 252645135;
            int i7 = (int) (((j71 | (j71 >>> 4)) & 16711935) | j65 | ((((j68 >>> 4) | j68) & 16711935) << 8));
            int i8 = (2261000 + i7) - (i7 & 2261000);
            int i9 = ((i8 | i6) - (((~i6) & 10) & i8)) + ((i6 | 10) & i8);
            long j72 = 1898086952;
            long j73 = i9;
            long j74 = ((((((((j72 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j72 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j73 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j73 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j73 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j73 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j75 = (j74 >>> 48) & 21845;
            long j76 = (j75 | (j75 >>> 1)) & 858993459;
            long j77 = (j76 | (j76 >>> 2)) & 252645135;
            long j78 = (j74 >>> 32) & 21845;
            long j79 = ((j78 >>> 1) | j78) & 858993459;
            long j80 = ((j79 >>> 2) | j79) & 252645135;
            long j81 = (((j77 | (j77 >>> 4)) & 16711935) << 24) | ((((j80 >>> 4) | j80) & 16711935) << 16);
            long j82 = (j74 >>> 16) & 21845;
            long j83 = ((j82 >>> 1) | j82) & 858993459;
            long j84 = ((j83 >>> 2) | j83) & 252645135;
            long j85 = j74 & 21845;
            long j86 = (j85 | (j85 >>> 1)) & 858993459;
            long j87 = (j86 | (j86 >>> 2)) & 252645135;
            C0031f2 c0031f2 = new C0031f2((int) (((j87 | (j87 >>> 4)) & 16711935) | (((((j84 >>> 4) | j84) & 16711935) << 8) + j81)), true, true);
            byte[] bArr5 = new byte[6];
            bArr5[0] = 116;
            bArr5[1] = -75;
            bArr5[(((-1273742971) & (1783754632 - ((~(~l3.class.getName().length())) | 1783754633))) + ((l3.class.getName().length() & (-1777593324)) | 55100432)) ^ (-1218642537)] = 102;
            bArr5[3] = 49;
            bArr5[4] = 110;
            bArr5[5] = -36;
            byte[] bArr6 = new byte[8];
            bArr6[((((~l3.class.getName().length()) | (-16389)) + 67399877) + ((l3.class.getName().length() & 538460164) | 823853056)) ^ 891252932] = 98;
            bArr6[1] = -26;
            bArr6[2] = -125;
            bArr6[3] = -26;
            bArr6[4] = 2;
            bArr6[5] = -88;
            bArr6[6] = -61;
            bArr6[((((~l3.class.getName().length()) | (-885394243)) & (-1202386943)) + ((l3.class.getName().length() & 826550288) | 25174288)) ^ (-1177212650)] = -68;
            l3.z(bArr5, bArr6);
            Charset charset3 = StandardCharsets.UTF_8;
            new String(bArr5, charset3).intern();
            C0054l1 c0054l1 = this.f577f;
            c0054l1.f573a.getClass();
            int i10 = AbstractC0041i0.f535a;
            byte[] bArr7 = {20, -85, -65, 26, -35, -94, 114, 8, -103, 114};
            l3.z(bArr7, new byte[]{3, -6, 91, -35, -44, -2, -105, ((((~l3.class.getName().length()) | (-1023458228)) & 1758462224) + ((l3.class.getName().length() & 671351120) | 393416)) ^ (-1758855654), -10, 6});
            d(new String(bArr7, charset3).intern(), c0031f2);
            if (c0031f2.b()) {
                byte[] bArr8 = {122, 46, -28, 26, -51, -75, 23, 89, -11, -19};
                int i11 = ~l3.class.getName().length();
                int length2 = (-1873733631) & (((((l3.class.getName().length() & (~i11)) & (-232998118)) - 232998118) + i11) - ((l3.class.getName().length() | i11) & (-232998118)));
                int length3 = l3.class.getName().length() & 4293137;
                l3.z(bArr8, new byte[]{109, Byte.MAX_VALUE, 0, 1873437900 ^ (((295697 + length3) + (((-length3) - 1) | (-295697))) + length2), -60, -23, -14, -109, -102, -103});
                String intern3 = new String(bArr8, charset3).intern();
                c0054l1.f573a.getClass();
                s(intern3);
            }
            if (c0031f2.a()) {
                c0054l1.f573a.getClass();
                byte[] bArr9 = new byte[10];
                bArr9[0] = -70;
                bArr9[1] = 25;
                bArr9[2] = 84;
                bArr9[3] = Byte.MAX_VALUE;
                bArr9[4] = -56;
                bArr9[5] = -103;
                bArr9[6] = 34;
                int i12 = ((~l3.class.getName().length()) | 953265372) & 16846784;
                long j88 = 17044244;
                long length4 = l3.class.getName().length();
                long j89 = (((((((((j88 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j88 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j88 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j88 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j90 = (j89 >>> 48) & 43690;
                long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                long j92 = ((j91 >>> 2) | j91) & 252645135;
                long j93 = (j89 >>> 32) & 43690;
                long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                long j95 = ((j94 >>> 2) | j94) & 252645135;
                long j96 = ((((j95 >>> 4) | j95) & 16711935) << 16) + ((((j92 >>> 4) | j92) & 16711935) << 24);
                long j97 = (j89 >>> 16) & 43690;
                long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                long j99 = ((j98 >>> 2) | j98) & 252645135;
                long j100 = j89 & 43690;
                long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                long j102 = ((j101 >>> 2) | j101) & 252645135;
                bArr9[(i12 + (((int) ((((j102 >>> 4) | j102) & 16711935) + (((((j99 >>> 4) | j99) & 16711935) << 8) + j96))) | (-2138828780))) ^ (-2121981997)] = -65;
                int i13 = ((~l3.class.getName().length()) | (-1743980845)) & 177406137;
                long j103 = 328400936;
                long length5 = l3.class.getName().length();
                long j104 = (((((((((j103 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j103 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j103 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j103 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j105 = (j104 >>> 48) & 43690;
                long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
                long j107 = ((j106 >>> 2) | j106) & 252645135;
                long j108 = (j104 >>> 32) & 43690;
                long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                long j110 = ((j109 >>> 2) | j109) & 252645135;
                long j111 = ((((j110 >>> 4) | j110) & 16711935) << 16) + ((((j107 >>> 4) | j107) & 16711935) << 24);
                long j112 = (j104 >>> 16) & 43690;
                long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
                long j114 = ((j113 >>> 2) | j113) & 252645135;
                long j115 = j104 & 43690;
                long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
                long j117 = ((j116 >>> 2) | j116) & 252645135;
                bArr9[8] = (i13 + (((int) ((((j117 >>> 4) | j117) & 16711935) | (((((j114 >>> 4) | j114) & 16711935) << 8) + j111))) | 291504132)) ^ (-468910308);
                bArr9[9] = 34;
                int length6 = (((~l3.class.getName().length()) | 2044395776) & 546445924) + ((l3.class.getName().length() & 39524) | 33653768);
                l3.z(bArr9, new byte[]{-83, 72, -80, -72, -63, -59, -57, 117, ((length6 & 580099677) * 2) + ((-580099678) - length6), 86});
                c0054l1.c(new String(bArr9, charset3).intern(), null);
                return;
            }
            return;
        }
    }

    @Override // F0.T2
    public final void a(Context context) {
        byte[] bArr = {4, -58, 32, 63, 83, -49, -65};
        byte[] bArr2 = new byte[8];
        bArr2[0] = 80;
        long j2 = 672401936;
        long j3 = -3;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        int i = (int) (((j17 | (j17 >>> 4)) & 16711935) + ((((j14 >>> 4) | j14) & 16711935) << 8) + j11);
        bArr2[(-1152120301) ^ (((-1824522238) & i) + (i | (-1824522238)))] = -39;
        bArr2[2] = 56;
        bArr2[3] = 100;
        bArr2[4] = 54;
        bArr2[5] = -73;
        bArr2[6] = -53;
        long j18 = -2144664752;
        long j19 = 10;
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = (j22 | (j22 >>> 2)) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = (j25 | (j25 >>> 2)) & 252645135;
        long j27 = (((j26 | (j26 >>> 4)) & 16711935) << 16) + (((j23 | (j23 >>> 4)) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = (j29 | (j29 >>> 2)) & 252645135;
        long j31 = j20 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        int i3 = ((int) (((j33 | (j33 >>> 4)) & 16711935) | ((((j30 | (j30 >>> 4)) & 16711935) << 8) + j27))) | 34736448;
        bArr2[7] = D.a(-2127740264, 3, -(D1.a(-2127740264, i3) | (i3 & 2)), 1) ^ (-2093003794);
        y(bArr, bArr2);
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
    }
}
