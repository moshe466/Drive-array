package F0;

import android.R;
import java.nio.charset.StandardCharsets;
import s2.C0682g;

/* loaded from: classes.dex */
public abstract class U1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0682g f387a = T.b.A(new T1(0));

    public static String a() {
        Object a2 = f387a.a();
        int i = ((~U1.class.getName().length()) | 1951506287) & 268518663;
        int length = U1.class.getName().length();
        int i3 = (length | 167796800) - (length ^ 167796800);
        long j2 = 177217728;
        long j3 = i3;
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
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
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        int i4 = i + ((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10)));
        byte[] bArr = {-96, 54, ((i4 & 445736402) * 2) + ((-445736403) - i4), -60, 27, 31, 102, -85, -79, 80, -76, 61, -115};
        int i5 = ((~U1.class.getName().length()) | (-583842423)) & 562103568;
        long j17 = 545522192;
        long length2 = U1.class.getName().length();
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j19 = (j18 >>> 48) & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = (j20 | (j20 >>> 2)) & 252645135;
        long j22 = (j18 >>> 32) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = (j23 | (j23 >>> 2)) & 252645135;
        long j25 = (((j21 | (j21 >>> 4)) & 16711935) << 24) | (((j24 | (j24 >>> 4)) & 16711935) << 16);
        long j26 = (j18 >>> 16) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = (j27 | (j27 >>> 2)) & 252645135;
        long j29 = (((j28 | (j28 >>> 4)) & 16711935) << 8) + j25;
        long j30 = j18 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = (j31 | (j31 >>> 2)) & 252645135;
        int i6 = i5 + (((int) (((j32 | (j32 >>> 4)) & 16711935) | j29)) | 819712);
        byte[] bArr2 = new byte[B0.a((~i6) | 562923293, 562923293 - i6)];
        bArr2[0] = 15;
        bArr2[1] = -92;
        bArr2[2] = -57;
        bArr2[3] = -121;
        bArr2[4] = 28;
        bArr2[5] = -87;
        int length3 = U1.class.getName().length();
        bArr2[404937504 ^ ((((-66596654) | ((length3 - 1) - (length3 * 2))) & 402660134) + (((U1.class.getName().length() | (-19237)) + 19237) | 2277376))] = 31;
        bArr2[7] = 42;
        bArr2[8] = 79;
        bArr2[9] = -38;
        bArr2[10] = -87;
        bArr2[11] = 32;
        bArr2[12] = -125;
        b(bArr, bArr2);
        kotlin.jvm.internal.j.d(a2, new String(bArr, StandardCharsets.UTF_8).intern());
        return (String) a2;
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
        int i7 = ~U1.class.getName().length();
        int length3 = (((~(((U1.class.getName().length() | 70245657) | i7) - (i7 | (U1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((U1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(U1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((U1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~U1.class.getName().length()) | (-576567005)) & 276971586) + ((U1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~U1.class.getName().length()) | (-1157759625)) & 1755853004) + ((U1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~U1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = U1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~U1.class.getName().length()) | (-1064961)) + 689325073) + ((U1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~U1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = U1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~U1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (U1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((U1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~U1.class.getName().length();
                    int length11 = (161497089 & (((((U1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((U1.class.getName().length() | i14) & 797295576))) + ((U1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~U1.class.getName().length()) | (-1085986263)) & 1078327440) + ((U1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~U1.class.getName().length();
                    int length12 = length5 >>> ((((~(((U1.class.getName().length() | 626856794) | i15) - ((U1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((U1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~U1.class.getName().length()) | 1248713193) & 826417528) + ((U1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~U1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (U1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~U1.class.getName().length()) | (-1005965450)) & 153223237) + ((U1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((U1.class.getName().length() & (~length6)) & i9)) + ((U1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~U1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((U1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~U1.class.getName().length()) | (-23496740)) & 827084804) + ((U1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~U1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (U1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~U1.class.getName().length()) | (-961655275)) & 25184460) + ((U1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~U1.class.getName().length()) | 1233459797) & 125923146) + ((U1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~U1.class.getName().length()) | (-7107622)) & 402932290) + ((U1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((U1.class.getName().length() | length15) - (b4 | length15)) + I2.a(U1.class, b4) + (U1.class.getName().length() & length15);
                    int length17 = ((((~U1.class.getName().length()) | (-81143879)) & 438583424) + ((U1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~U1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((U1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(U1.class, 568748773 | i24) + (U1.class.getName().length() & (-2105278367)))) + ((U1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~U1.class.getName().length()) | (-1592082969)) & 140665109) + ((U1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~U1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((U1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~U1.class.getName().length()) | (-180811308));
                    int length19 = (U1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((U1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | U1.class.getName().length()))));
                    int i29 = ((~U1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (U1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~U1.class.getName().length()) | 75364313) & 1242301609) + ((U1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = U1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((U1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~U1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((U1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~U1.class.getName().length();
                    int length24 = 1409942802 & (((((U1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | U1.class.getName().length()) & 91135407));
                    int length25 = (U1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~U1.class.getName().length()) | (-537919489)) - (-806798471)) + ((U1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~U1.class.getName().length()) | (-382746167)) & 102532165) + ((U1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~U1.class.getName().length()) | (-6036961)) & 1233145505) + ((U1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~U1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = U1.class.getName().length() & 268460041;
                    i5 = (((((U1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | U1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = U1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((U1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~U1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((U1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~U1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (U1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(U1.class, -1) | (-532481)) - (-67641369)) + ((U1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~U1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((U1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(U1.class, -1) | (-33554434)) - (-1107366402)) + ((U1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(U1.class, -1) | (-167014194)) & 1157999680) + ((U1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = U1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((U1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(U1.class, -1) | 114408723) & 1183666176;
                    int length33 = U1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~U1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = U1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~U1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (U1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~U1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((U1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~U1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (U1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~U1.class.getName().length()) | 991120067) & (-2113137661)) + ((U1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(U1.class, -1) | 314136709) & 371231304) + (((U1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~U1.class.getName().length()) | 366661365) & 1344150018) + ((U1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~U1.class.getName().length()) | (-1359635359)) & 49026131) + ((U1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~U1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = U1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (U1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~U1.class.getName().length()) | 1110430873) & 1241612298) + ((U1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~U1.class.getName().length()) | 1603962366) & 25199440) + (((U1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~U1.class.getName().length()) | (-1388708984)) & 706816128) + ((U1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~U1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = U1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~U1.class.getName().length()) | 2113158628) & 1026558002) + ((U1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~U1.class.getName().length()) | 715175224) & 136512788) + ((U1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~U1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = U1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~U1.class.getName().length()) | (-1084937228)) & 438503696) + ((U1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~U1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((U1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(U1.class, 1197735420 | i53) + (U1.class.getName().length() & 674349280))) + ((U1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~U1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (U1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~U1.class.getName().length()) | (-171976913)) & 318775824) + ((U1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~U1.class.getName().length()) | (-616910267)) & 1303391760) + ((U1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~U1.class.getName().length()) | 1297715640) & 556926729) + ((U1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~U1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((U1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~U1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (U1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }
}
