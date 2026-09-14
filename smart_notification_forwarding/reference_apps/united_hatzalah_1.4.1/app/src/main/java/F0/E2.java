package F0;

import a.AbstractC0228a;
import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class E2 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f188a;

    /* renamed from: b, reason: collision with root package name */
    public final long f189b;

    public E2(String str, long j2) {
        byte[] bArr = new byte[11];
        bArr[0] = 74;
        long j3 = 134291522;
        long j4 = 0;
        long b4 = c3.b((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j5 = (b4 >>> 48) & 43690;
        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (b4 >>> 32) & 43690;
        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (b4 >>> 16) & 43690;
        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = b4 & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        bArr[176382031 ^ (42090508 + ((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))))] = 49;
        bArr[2] = -116;
        bArr[3] = 99;
        bArr[4] = -67;
        bArr[5] = -92;
        long j18 = 3207461;
        long j19 = -1;
        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) | ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        long j34 = 1346040291;
        long j35 = ((int) (((j33 | (j33 >>> 4)) & 16711935) | (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) + 1342832832;
        long j36 = (((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j37 = j36 + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j38 = (j37 >>> 48) & 21845;
        long j39 = (j38 | (j38 >>> 1)) & 858993459;
        long j40 = (j39 | (j39 >>> 2)) & 252645135;
        long j41 = (j37 >>> 32) & 21845;
        long j42 = (j41 | (j41 >>> 1)) & 858993459;
        long j43 = (j42 | (j42 >>> 2)) & 252645135;
        long j44 = (((j43 | (j43 >>> 4)) & 16711935) << 16) + (((j40 | (j40 >>> 4)) & 16711935) << 24);
        long j45 = (j37 >>> 16) & 21845;
        long j46 = (j45 | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        long j48 = j37 & 21845;
        long j49 = (j48 | (j48 >>> 1)) & 858993459;
        long j50 = (j49 | (j49 >>> 2)) & 252645135;
        bArr[(int) (((j50 | (j50 >>> 4)) & 16711935) + (((j47 | (j47 >>> 4)) & 16711935) << 8) + j44)] = 7;
        bArr[7] = -83;
        bArr[8] = -58;
        bArr[9] = -86;
        bArr[10] = 7;
        d(bArr, new byte[]{94, 126, 89, -82, -72, -15, -48, 29, -89, -57, 98});
        new String(bArr, StandardCharsets.UTF_8).intern();
        this.f188a = str;
        this.f189b = j2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~E2.class.getName().length();
        int length3 = (((~(((E2.class.getName().length() | 70245657) | i7) - (i7 | (E2.class.getName().length() & (-70245658))))) & (-1979440632)) + ((E2.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(E2.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((E2.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~E2.class.getName().length()) | (-576567005)) & 276971586) + ((E2.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~E2.class.getName().length()) | (-1157759625)) & 1755853004) + ((E2.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~E2.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = E2.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~E2.class.getName().length()) | (-1064961)) + 689325073) + ((E2.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~E2.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = E2.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~E2.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (E2.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((E2.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~E2.class.getName().length();
                    int length11 = (161497089 & (((((E2.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((E2.class.getName().length() | i14) & 797295576))) + ((E2.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~E2.class.getName().length()) | (-1085986263)) & 1078327440) + ((E2.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~E2.class.getName().length();
                    int length12 = length5 >>> ((((~(((E2.class.getName().length() | 626856794) | i15) - ((E2.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((E2.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~E2.class.getName().length()) | 1248713193) & 826417528) + ((E2.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~E2.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (E2.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~E2.class.getName().length()) | (-1005965450)) & 153223237) + ((E2.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((E2.class.getName().length() & (~length6)) & i9)) + ((E2.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~E2.class.getName().length()) | (-30261291)) & (-1534000062)) + ((E2.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~E2.class.getName().length()) | (-23496740)) & 827084804) + ((E2.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~E2.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (E2.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~E2.class.getName().length()) | (-961655275)) & 25184460) + ((E2.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~E2.class.getName().length()) | 1233459797) & 125923146) + ((E2.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~E2.class.getName().length()) | (-7107622)) & 402932290) + ((E2.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((E2.class.getName().length() | length15) - (b4 | length15)) + I2.a(E2.class, b4) + (E2.class.getName().length() & length15);
                    int length17 = ((((~E2.class.getName().length()) | (-81143879)) & 438583424) + ((E2.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~E2.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((E2.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(E2.class, 568748773 | i24) + (E2.class.getName().length() & (-2105278367)))) + ((E2.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~E2.class.getName().length()) | (-1592082969)) & 140665109) + ((E2.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~E2.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((E2.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~E2.class.getName().length()) | (-180811308));
                    int length19 = (E2.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((E2.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | E2.class.getName().length()))));
                    int i29 = ((~E2.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (E2.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~E2.class.getName().length()) | 75364313) & 1242301609) + ((E2.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = E2.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((E2.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~E2.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((E2.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~E2.class.getName().length();
                    int length24 = 1409942802 & (((((E2.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | E2.class.getName().length()) & 91135407));
                    int length25 = (E2.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~E2.class.getName().length()) | (-537919489)) - (-806798471)) + ((E2.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~E2.class.getName().length()) | (-382746167)) & 102532165) + ((E2.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~E2.class.getName().length()) | (-6036961)) & 1233145505) + ((E2.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~E2.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = E2.class.getName().length() & 268460041;
                    i5 = (((((E2.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | E2.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = E2.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((E2.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~E2.class.getName().length()) | (-1883938358)) & (-738125179)) + ((E2.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~E2.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (E2.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(E2.class, -1) | (-532481)) - (-67641369)) + ((E2.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~E2.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((E2.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(E2.class, -1) | (-33554434)) - (-1107366402)) + ((E2.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(E2.class, -1) | (-167014194)) & 1157999680) + ((E2.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = E2.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((E2.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(E2.class, -1) | 114408723) & 1183666176;
                    int length33 = E2.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~E2.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = E2.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~E2.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (E2.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~E2.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((E2.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~E2.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (E2.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~E2.class.getName().length()) | 991120067) & (-2113137661)) + ((E2.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(E2.class, -1) | 314136709) & 371231304) + (((E2.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~E2.class.getName().length()) | 366661365) & 1344150018) + ((E2.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~E2.class.getName().length()) | (-1359635359)) & 49026131) + ((E2.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~E2.class.getName().length();
                    if (length3 > 0) {
                        int length38 = E2.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (E2.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~E2.class.getName().length()) | 1110430873) & 1241612298) + ((E2.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~E2.class.getName().length()) | 1603962366) & 25199440) + (((E2.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~E2.class.getName().length()) | (-1388708984)) & 706816128) + ((E2.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~E2.class.getName().length()) | 367288948) & 548745488;
                    int length41 = E2.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~E2.class.getName().length()) | 2113158628) & 1026558002) + ((E2.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~E2.class.getName().length()) | 715175224) & 136512788) + ((E2.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~E2.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = E2.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~E2.class.getName().length()) | (-1084937228)) & 438503696) + ((E2.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~E2.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((E2.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(E2.class, 1197735420 | i53) + (E2.class.getName().length() & 674349280))) + ((E2.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~E2.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (E2.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~E2.class.getName().length()) | (-171976913)) & 318775824) + ((E2.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~E2.class.getName().length()) | (-616910267)) & 1303391760) + ((E2.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~E2.class.getName().length()) | 1297715640) & 556926729) + ((E2.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~E2.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((E2.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~E2.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (E2.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
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

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(E2 e22) {
        byte[] bArr = new byte[5];
        bArr[0] = 56;
        bArr[1] = -81;
        bArr[2] = 23;
        bArr[3] = 110;
        long j2 = 697103290;
        long j3 = 697103294;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
        bArr[(int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))] = 124;
        byte[] bArr2 = new byte[8];
        bArr2[0] = -99;
        long j18 = -722822968;
        long j19 = -2;
        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = 539242562;
        long j35 = 0;
        long b4 = c3.b((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j36 = (b4 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = ((j37 >>> 2) | j37) & 252645135;
        long j39 = (b4 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
        long j43 = (b4 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = b4 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = (j47 | (j47 >>> 2)) & 252645135;
        int i = (((int) ((((j33 >>> 4) | j33) & 16711935) | ((((j30 >>> 4) | j30) & 16711935) << 8) | j27)) & 1409843340) + ((int) (((j48 | (j48 >>> 4)) & 16711935) | (((((j45 >>> 4) | j45) & 16711935) << 8) + j42)));
        bArr2[(((~i) & 1949085903) - (1949085903 & i)) + i] = 14;
        bArr2[2] = -65;
        bArr2[3] = 69;
        bArr2[4] = 95;
        bArr2[5] = 51;
        bArr2[6] = -125;
        bArr2[7] = -76;
        b(bArr, bArr2);
        kotlin.jvm.internal.j.e(e22, new String(bArr, StandardCharsets.UTF_8).intern());
        return AbstractC0228a.e(this, e22, new C0029f0(2), new C0029f0(3));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0007. Please report as an issue. */
    public final boolean equals(Object obj) {
        E2 e22 = null;
        while (true) {
            char c4 = 23879;
            while (true) {
                switch (c4) {
                    case 41291:
                        if (this.f189b != e22.f189b) {
                            c4 = 28653;
                        } else {
                            c4 = 26533;
                        }
                    case 42850:
                        return false;
                    case 16925:
                        if (!(obj instanceof E2)) {
                            c4 = 42850;
                        } else {
                            c4 = 51094;
                        }
                    case 51094:
                        e22 = (E2) obj;
                        if (!kotlin.jvm.internal.j.a(this.f188a, e22.f188a)) {
                            c4 = 36601;
                        } else {
                            c4 = 41291;
                        }
                    case 36601:
                        return false;
                    case 23879:
                        if (this == obj) {
                            c4 = 54769;
                        } else {
                            c4 = 16925;
                        }
                    case 28653:
                        return false;
                    case 54769:
                    case 26533:
                        return true;
                }
            }
        }
    }

    public final int hashCode() {
        return Long.hashCode(this.f189b) + (this.f188a.hashCode() * 31);
    }

    public final String toString() {
        byte[] bArr = new byte[14];
        long j2 = 327157890;
        long j3 = 1;
        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j6 = j5 + j4;
        long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j9 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j8 | j7 | j6);
        long j10 = (j9 >>> 48) & 43690;
        long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
        long j12 = ((j11 >>> 2) | j11) & 252645135;
        long j13 = (j9 >>> 32) & 43690;
        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
        long j15 = ((j14 >>> 2) | j14) & 252645135;
        long j16 = ((((j15 >>> 4) | j15) & 16711935) << 16) + ((((j12 >>> 4) | j12) & 16711935) << 24);
        long j17 = (j9 >>> 16) & 43690;
        long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
        long j19 = ((j18 >>> 2) | j18) & 252645135;
        long j20 = j9 & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        bArr[329269234 ^ (18890176 + (((int) ((((j22 >>> 4) | j22) & 16711935) + (((((j19 >>> 4) | j19) & 16711935) << 8) | j16))) | 310379058))] = 87;
        bArr[1] = -54;
        bArr[2] = -15;
        bArr[3] = -127;
        bArr[4] = -13;
        bArr[5] = -39;
        bArr[6] = -117;
        bArr[7] = -21;
        long j23 = -1;
        long j24 = j7 + (j5 | j4) + j8;
        long j25 = (((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j26 = (((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j27 = j26 | j25;
        long j28 = (((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j29 = (((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j30 = j29 + (j28 | j27) + j24;
        long j31 = (j30 >>> 48) & 21845;
        long j32 = ((j31 >>> 1) | j31) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = (j30 >>> 32) & 21845;
        long j35 = ((j34 >>> 1) | j34) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        long j37 = ((((j36 >>> 4) | j36) & 16711935) << 16) | ((((j33 >>> 4) | j33) & 16711935) << 24);
        long j38 = (j30 >>> 16) & 21845;
        long j39 = ((j38 >>> 1) | j38) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = j30 & 21845;
        long j42 = ((j41 >>> 1) | j41) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        bArr[(((((int) ((((j43 >>> 4) | j43) & 16711935) | (((((j40 >>> 4) | j40) & 16711935) << 8) | j37))) | (-1108346898)) & 1212642368) - 1870659141) ^ (-658016781)] = -9;
        bArr[9] = -2;
        bArr[10] = 101;
        bArr[11] = 72;
        bArr[12] = 2;
        bArr[13] = -78;
        long j44 = 0;
        long j45 = ((((((((j44 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j44 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j46 = (((((((j44 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j47 = (((((((j44 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long b4 = c3.b(j28, j27, j29, j47 + j46 + j45);
        long j48 = (b4 >>> 48) & 21845;
        long j49 = ((j48 >>> 1) | j48) & 858993459;
        long j50 = ((j49 >>> 2) | j49) & 252645135;
        long j51 = (b4 >>> 32) & 21845;
        long j52 = ((j51 >>> 1) | j51) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = ((((j53 >>> 4) | j53) & 16711935) << 16) + ((((j50 >>> 4) | j50) & 16711935) << 24);
        long j55 = (b4 >>> 16) & 21845;
        long j56 = ((j55 >>> 1) | j55) & 858993459;
        long j57 = ((j56 >>> 2) | j56) & 252645135;
        long j58 = b4 & 21845;
        long j59 = ((j58 >>> 1) | j58) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        c(bArr, new byte[]{7, -85, -110, -22, -110, -66, -18, -53, -103, -97, (((((int) ((((j60 >>> 4) | j60) & 16711935) | (((((j57 >>> 4) | j57) & 16711935) << 8) + j54))) | (-8843839)) & 1476613121) + 119540288) ^ 1596153417, 45, 56, -110});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        long j61 = 347119680;
        long j62 = j29 | (j26 + j25 + j28);
        long j63 = ((((((((j61 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j61 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j61 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j61 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j62;
        long j64 = (j63 >>> 48) & 43690;
        long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
        long j66 = ((j65 >>> 2) | j65) & 252645135;
        long j67 = (j63 >>> 32) & 43690;
        long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
        long j69 = ((j68 >>> 2) | j68) & 252645135;
        long j70 = ((((j69 >>> 4) | j69) & 16711935) << 16) | ((((j66 >>> 4) | j66) & 16711935) << 24);
        long j71 = (j63 >>> 16) & 43690;
        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
        long j73 = ((j72 >>> 2) | j72) & 252645135;
        long j74 = j63 & 43690;
        long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
        long j76 = ((j75 >>> 2) | j75) & 252645135;
        long j77 = 351314249;
        long j78 = ((int) ((((j76 >>> 4) | j76) & 16711935) | (((((j73 >>> 4) | j73) & 16711935) << 8) + j70))) + 4194563;
        long j79 = ((((((((j77 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j77 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j77 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j77 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j78 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j78 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j78 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j78 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j80 = (j79 >>> 48) & 21845;
        long j81 = ((j80 >>> 1) | j80) & 858993459;
        long j82 = ((j81 >>> 2) | j81) & 252645135;
        long j83 = (j79 >>> 32) & 21845;
        long j84 = ((j83 >>> 1) | j83) & 858993459;
        long j85 = ((j84 >>> 2) | j84) & 252645135;
        long j86 = ((((j85 >>> 4) | j85) & 16711935) << 16) | ((((j82 >>> 4) | j82) & 16711935) << 24);
        long j87 = (j79 >>> 16) & 21845;
        long j88 = ((j87 >>> 1) | j87) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = j79 & 21845;
        long j91 = ((j90 >>> 1) | j90) & 858993459;
        long j92 = ((j91 >>> 2) | j91) & 252645135;
        byte[] bArr2 = new byte[(int) (((((j89 >>> 4) | j89) & 16711935) << 8) | j86 | (((j92 >>> 4) | j92) & 16711935))];
        bArr2[0] = -72;
        bArr2[1] = -13;
        bArr2[2] = 58;
        bArr2[3] = 57;
        bArr2[4] = -60;
        bArr2[5] = 44;
        bArr2[6] = 56;
        bArr2[7] = 118;
        bArr2[8] = -13;
        bArr2[9] = 72;
        byte[] bArr3 = new byte[10];
        bArr3[0] = -78;
        bArr3[1] = -91;
        bArr3[2] = 95;
        bArr3[3] = 75;
        bArr3[4] = -73;
        bArr3[5] = 69;
        long j93 = j62 + (j8 | (j7 + j6));
        long j94 = (j93 >>> 48) & 21845;
        long j95 = ((j94 >>> 1) | j94) & 858993459;
        long j96 = ((j95 >>> 2) | j95) & 252645135;
        long j97 = (j93 >>> 32) & 21845;
        long j98 = ((j97 >>> 1) | j97) & 858993459;
        long j99 = ((j98 >>> 2) | j98) & 252645135;
        long j100 = ((((j99 >>> 4) | j99) & 16711935) << 16) | ((((j96 >>> 4) | j96) & 16711935) << 24);
        long j101 = (j93 >>> 16) & 21845;
        long j102 = ((j101 >>> 1) | j101) & 858993459;
        long j103 = ((j102 >>> 2) | j102) & 252645135;
        long j104 = j93 & 21845;
        long j105 = ((j104 >>> 1) | j104) & 858993459;
        long j106 = ((j105 >>> 2) | j105) & 252645135;
        int i = (((int) ((((j106 >>> 4) | j106) & 16711935) + (((((j103 >>> 4) | j103) & 16711935) << 8) | j100))) | (-2064468843)) & (-1794561933);
        long j107 = 572572160;
        long j108 = (((((((((j107 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j107 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j107 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j107 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j47 | j46 | j45) + 6148914691236517205L;
        long j109 = (j108 >>> 48) & 43690;
        long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
        long j111 = ((j110 >>> 2) | j110) & 252645135;
        long j112 = (j108 >>> 32) & 43690;
        long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
        long j114 = ((j113 >>> 2) | j113) & 252645135;
        long j115 = ((((j114 >>> 4) | j114) & 16711935) << 16) + ((((j111 >>> 4) | j111) & 16711935) << 24);
        long j116 = (j108 >>> 16) & 43690;
        long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
        long j118 = ((j117 >>> 2) | j117) & 252645135;
        long j119 = j108 & 43690;
        long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
        long j121 = ((j120 >>> 2) | j120) & 252645135;
        int i3 = (int) ((((j121 >>> 4) | j121) & 16711935) | ((((j118 >>> 4) | j118) & 16711935) << 8) | j115);
        int i4 = ((i3 | i) - ((1 & (~i)) & i3)) + ((1 | i) & i3);
        long j122 = -1221989771;
        long j123 = i4;
        long j124 = ((((((((j122 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j122 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j122 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j122 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j123 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j123 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j123 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j123 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j125 = (j124 >>> 48) & 21845;
        long j126 = (j125 | (j125 >>> 1)) & 858993459;
        long j127 = (j126 | (j126 >>> 2)) & 252645135;
        long j128 = (j124 >>> 32) & 21845;
        long j129 = (j128 | (j128 >>> 1)) & 858993459;
        long j130 = (j129 | (j129 >>> 2)) & 252645135;
        long j131 = (((j127 | (j127 >>> 4)) & 16711935) << 24) | (((j130 | (j130 >>> 4)) & 16711935) << 16);
        long j132 = (j124 >>> 16) & 21845;
        long j133 = (j132 | (j132 >>> 1)) & 858993459;
        long j134 = (j133 | (j133 >>> 2)) & 252645135;
        long j135 = j124 & 21845;
        long j136 = (j135 | (j135 >>> 1)) & 858993459;
        long j137 = (j136 | (j136 >>> 2)) & 252645135;
        bArr3[(int) (((j137 | (j137 >>> 4)) & 16711935) | j131 | (((j134 | (j134 >>> 4)) & 16711935) << 8))] = 87;
        bArr3[7] = 24;
        bArr3[8] = -55;
        bArr3[9] = 104;
        c(bArr2, bArr3);
        return intern + this.f188a + new String(bArr2, charset).intern() + this.f189b;
    }
}
