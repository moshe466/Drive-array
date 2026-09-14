package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class F2 extends L0 {
    static {
        byte[] bArr = new byte[9];
        bArr[0] = 110;
        bArr[1] = 106;
        bArr[2] = -99;
        bArr[3] = -86;
        int i = ((~F2.class.getName().length()) | 644876463) & (-1925965880);
        long j2 = 281174016;
        long length = F2.class.getName().length() & (-1723574464);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j4 = (j3 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        bArr[(-1644791860) ^ ((((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) - (~i)) - 1)] = -32;
        bArr[5] = -88;
        bArr[6] = 65;
        bArr[7] = 63;
        bArr[8] = 54;
        int i3 = ((~F2.class.getName().length()) | (-1366832879)) & 1551962340;
        int length2 = (F2.class.getName().length() & (-769650452)) | (-2107637752);
        int i4 = -i3;
        byte[] bArr2 = new byte[(-555675419) ^ ((length2 ^ i4) - ((i4 & (~length2)) * 2))];
        bArr2[0] = 35;
        bArr2[1] = 72;
        bArr2[2] = -26;
        bArr2[3] = -30;
        bArr2[4] = 110;
        bArr2[5] = 10;
        bArr2[6] = -4;
        bArr2[((((~F2.class.getName().length()) | 469686144) & (-955723581)) + ((F2.class.getName().length() & (-335532957)) | 673262624)) ^ (-282460956)] = 110;
        bArr2[8] = 82;
        y(bArr, bArr2);
        new String(bArr, StandardCharsets.UTF_8).intern();
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
        int i7 = ~F2.class.getName().length();
        int length3 = (((~(((F2.class.getName().length() | 70245657) | i7) - (i7 | (F2.class.getName().length() & (-70245658))))) & (-1979440632)) + ((F2.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(F2.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((F2.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~F2.class.getName().length()) | (-576567005)) & 276971586) + ((F2.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~F2.class.getName().length()) | (-1157759625)) & 1755853004) + ((F2.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~F2.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = F2.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~F2.class.getName().length()) | (-1064961)) + 689325073) + ((F2.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~F2.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = F2.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~F2.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (F2.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((F2.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~F2.class.getName().length();
                    int length11 = (161497089 & (((((F2.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((F2.class.getName().length() | i14) & 797295576))) + ((F2.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~F2.class.getName().length()) | (-1085986263)) & 1078327440) + ((F2.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~F2.class.getName().length();
                    int length12 = length5 >>> ((((~(((F2.class.getName().length() | 626856794) | i15) - ((F2.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((F2.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~F2.class.getName().length()) | 1248713193) & 826417528) + ((F2.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~F2.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (F2.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~F2.class.getName().length()) | (-1005965450)) & 153223237) + ((F2.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((F2.class.getName().length() & (~length6)) & i9)) + ((F2.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~F2.class.getName().length()) | (-30261291)) & (-1534000062)) + ((F2.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~F2.class.getName().length()) | (-23496740)) & 827084804) + ((F2.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~F2.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (F2.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~F2.class.getName().length()) | (-961655275)) & 25184460) + ((F2.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~F2.class.getName().length()) | 1233459797) & 125923146) + ((F2.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~F2.class.getName().length()) | (-7107622)) & 402932290) + ((F2.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((F2.class.getName().length() | length15) - (b4 | length15)) + I2.a(F2.class, b4) + (F2.class.getName().length() & length15);
                    int length17 = ((((~F2.class.getName().length()) | (-81143879)) & 438583424) + ((F2.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~F2.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((F2.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(F2.class, 568748773 | i24) + (F2.class.getName().length() & (-2105278367)))) + ((F2.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~F2.class.getName().length()) | (-1592082969)) & 140665109) + ((F2.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~F2.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((F2.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~F2.class.getName().length()) | (-180811308));
                    int length19 = (F2.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((F2.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | F2.class.getName().length()))));
                    int i29 = ((~F2.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (F2.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~F2.class.getName().length()) | 75364313) & 1242301609) + ((F2.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = F2.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((F2.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~F2.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((F2.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~F2.class.getName().length();
                    int length24 = 1409942802 & (((((F2.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | F2.class.getName().length()) & 91135407));
                    int length25 = (F2.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~F2.class.getName().length()) | (-537919489)) - (-806798471)) + ((F2.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~F2.class.getName().length()) | (-382746167)) & 102532165) + ((F2.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~F2.class.getName().length()) | (-6036961)) & 1233145505) + ((F2.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~F2.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = F2.class.getName().length() & 268460041;
                    i5 = (((((F2.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | F2.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = F2.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((F2.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~F2.class.getName().length()) | (-1883938358)) & (-738125179)) + ((F2.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~F2.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (F2.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(F2.class, -1) | (-532481)) - (-67641369)) + ((F2.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~F2.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((F2.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(F2.class, -1) | (-33554434)) - (-1107366402)) + ((F2.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(F2.class, -1) | (-167014194)) & 1157999680) + ((F2.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = F2.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((F2.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(F2.class, -1) | 114408723) & 1183666176;
                    int length33 = F2.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~F2.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = F2.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~F2.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (F2.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~F2.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((F2.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~F2.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (F2.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~F2.class.getName().length()) | 991120067) & (-2113137661)) + ((F2.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(F2.class, -1) | 314136709) & 371231304) + (((F2.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~F2.class.getName().length()) | 366661365) & 1344150018) + ((F2.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~F2.class.getName().length()) | (-1359635359)) & 49026131) + ((F2.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~F2.class.getName().length();
                    if (length3 > 0) {
                        int length38 = F2.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (F2.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~F2.class.getName().length()) | 1110430873) & 1241612298) + ((F2.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~F2.class.getName().length()) | 1603962366) & 25199440) + (((F2.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~F2.class.getName().length()) | (-1388708984)) & 706816128) + ((F2.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~F2.class.getName().length()) | 367288948) & 548745488;
                    int length41 = F2.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~F2.class.getName().length()) | 2113158628) & 1026558002) + ((F2.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~F2.class.getName().length()) | 715175224) & 136512788) + ((F2.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~F2.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = F2.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~F2.class.getName().length()) | (-1084937228)) & 438503696) + ((F2.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~F2.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((F2.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(F2.class, 1197735420 | i53) + (F2.class.getName().length() & 674349280))) + ((F2.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~F2.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (F2.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~F2.class.getName().length()) | (-171976913)) & 318775824) + ((F2.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~F2.class.getName().length()) | (-616910267)) & 1303391760) + ((F2.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~F2.class.getName().length()) | 1297715640) & 556926729) + ((F2.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~F2.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((F2.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~F2.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (F2.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v4 */
    public final boolean A(Context context) {
        boolean z3;
        boolean z4;
        boolean z5 = false;
        char c4 = 15198;
        boolean z6 = false;
        char c5 = 15198;
        while (true) {
            if (c5 != c4) {
                if (c5 != 47089) {
                    if (c5 != 64382) {
                        if (c5 != 25632) {
                            z4 = z5 ? 1 : 0;
                        } else {
                            z6 = z5 ? 1 : 0;
                            c5 = 64382;
                        }
                    } else {
                        return z6;
                    }
                } else {
                    byte[] bArr = new byte[24];
                    bArr[z5 ? 1 : 0] = 92;
                    bArr[1] = -72;
                    bArr[2] = -51;
                    bArr[3] = 112;
                    int length = F2.class.getName().length();
                    int i = (1471713817 | (((~length) - length) + length)) & 270434344;
                    int length2 = F2.class.getName().length();
                    bArr[4] = (i + ((-2130704176) | (((F2.class.getName().length() | (-2130312992)) - (length2 | (-2130312992))) + (AbstractC0008a.f(F2.class, length2) + (F2.class.getName().length() & (-2130312992)))))) ^ 1860269945;
                    bArr[5] = -50;
                    bArr[6] = 10;
                    String name = F2.class.getName();
                    ?? r17 = z5 ? 1 : 0;
                    long j2 = 1410467875;
                    long j3 = (~name.length()) | 2100390899;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                    long j15 = ((((j14 >>> 4) | j14) & 16711935) << 8) + j11;
                    long j16 = j4 & 43690;
                    long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                    long j18 = (j17 | (j17 >>> 2)) & 252645135;
                    bArr[7] = (-191419217) ^ ((((F2.class.getName().length() & 8847364) | (-1601887100)) - (~((int) (((j18 | (j18 >>> 4)) & 16711935) + j15)))) - 1);
                    long j19 = -1;
                    long length3 = F2.class.getName().length();
                    long j20 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                    bArr[((((((int) ((((j33 >>> 4) | j33) & 16711935) | (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) + (((-r0) - 1) | (-463114668))) + 463114668) & 614958436) + (((F2.class.getName().length() | (-607994950)) + 607994950) | 286801921)) ^ 901760365] = -9;
                    bArr[9] = 33;
                    bArr[10] = -46;
                    bArr[11] = 2;
                    bArr[12] = 33;
                    bArr[13] = -7;
                    bArr[14] = ((((~F2.class.getName().length()) | (-134499477)) + 152391062) + ((F2.class.getName().length() & 1208241334) | 1073774634)) ^ (-1226165633);
                    bArr[15] = -64;
                    bArr[16] = -40;
                    bArr[17] = -72;
                    bArr[18] = 99;
                    bArr[19] = 76;
                    bArr[20] = 87;
                    bArr[21] = 44;
                    bArr[22] = -75;
                    bArr[23] = 63;
                    byte[] bArr2 = new byte[24];
                    bArr2[r17] = 30;
                    bArr2[1] = -5;
                    bArr2[2] = 118;
                    bArr2[3] = 25;
                    bArr2[4] = -38;
                    bArr2[5] = -46;
                    bArr2[6] = 77;
                    int length4 = (((~F2.class.getName().length()) | 1691350230) & 98582871) + ((F2.class.getName().length() & (-2128342783)) | (-1878543360));
                    bArr2[(length4 | (-1779960496)) - (length4 & (-1779960496))] = ((((~F2.class.getName().length()) | (-1319125629)) & 605831555) + (((F2.class.getName().length() | (-205537297)) - (-205537297)) | 140513372)) ^ (-746344869);
                    bArr2[8] = Byte.MAX_VALUE;
                    bArr2[9] = -123;
                    bArr2[10] = -91;
                    bArr2[11] = -122;
                    bArr2[12] = 56;
                    bArr2[13] = -17;
                    bArr2[14] = -106;
                    bArr2[15] = -70;
                    bArr2[16] = -88;
                    bArr2[17] = 45;
                    bArr2[18] = -8;
                    int f4 = (AbstractC0008a.f(F2.class, -1) | 452949614) & (-1841020862);
                    int length5 = F2.class.getName().length();
                    int i3 = ((-2130703615) + length5) - (length5 | (-2130703615));
                    bArr2[(-1824240804) ^ ((((((F2.class.getName().length() & (~i3)) & 16780045) + 16780045) + i3) - ((i3 | F2.class.getName().length()) & 16780045)) + f4)] = 69;
                    bArr2[20] = 30;
                    bArr2[21] = 112;
                    bArr2[22] = -70;
                    bArr2[23] = 116;
                    y(bArr, bArr2);
                    Charset charset = StandardCharsets.UTF_8;
                    String intern = new String(bArr, charset).intern();
                    byte[] bArr3 = {43, 108, -36, 67};
                    byte[] bArr4 = new byte[8];
                    bArr4[r17] = 72;
                    int i4 = ~F2.class.getName().length();
                    long j34 = 285258304;
                    long length6 = F2.class.getName().length() & 4219468;
                    long j35 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j36 = (j35 >>> 48) & 43690;
                    long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                    long j38 = ((j37 >>> 2) | j37) & 252645135;
                    long j39 = (j35 >>> 32) & 43690;
                    long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) | ((((j38 >>> 4) | j38) & 16711935) << 24);
                    long j43 = (j35 >>> 16) & 43690;
                    long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                    long j45 = ((j44 >>> 2) | j44) & 252645135;
                    long j46 = ((((j45 >>> 4) | j45) & 16711935) << 8) + j42;
                    long j47 = j35 & 43690;
                    long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                    long j49 = (j48 | (j48 >>> 2)) & 252645135;
                    int i5 = (((1779940769 | i4) + 676479117) - (i4 | 1784151469)) + ((int) (((j49 | (j49 >>> 4)) & 16711935) + j46));
                    bArr4[(961737420 + i5) - ((961737420 & i5) * 2)] = 78;
                    bArr4[2] = -109;
                    bArr4[3] = 63;
                    bArr4[4] = 64;
                    bArr4[(-41468637) ^ ((((1805593150 | r3) - 1853675230) - ((~F2.class.getName().length()) | (-73454786))) + ((F2.class.getName().length() & (-1744568060)) | 1812206596))] = 22;
                    bArr4[6] = 56;
                    bArr4[7] = 7;
                    y(bArr3, bArr4);
                    t(intern, new String(bArr3, charset).intern());
                    z5 = r17;
                    z6 = true;
                    c4 = 15198;
                    c5 = 64382;
                }
            } else {
                boolean z7 = z5 ? 1 : 0;
                z4 = z7;
                if ((context.getApplicationInfo().flags | (-3)) + 3 != 0) {
                    c5 = 47089;
                    z3 = z7;
                    z5 = z3;
                    c4 = 15198;
                }
            }
            c5 = 25632;
            z3 = z4;
            z5 = z3;
            c4 = 15198;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x013e. Please report as an issue. */
    public final void B(Context context) {
        int i;
        int i3;
        int i4;
        int i5;
        char c4;
        int i6;
        byte[] bArr = new byte[7];
        int i7 = 0;
        bArr[0] = -123;
        int i8 = 1;
        bArr[1] = -98;
        int i9 = 2;
        bArr[2] = 11;
        bArr[((((~F2.class.getName().length()) | 2114388230) & (-477230998)) + ((F2.class.getName().length() & (-1986524824)) | 135299348)) ^ (-341931651)] = -75;
        char c5 = '0';
        bArr[4] = 48;
        int i10 = 5;
        bArr[5] = -63;
        char c6 = 6;
        bArr[6] = ((((~F2.class.getName().length()) | 1848815006) & 567569) + (((F2.class.getName().length() | 2146959326) - 2146959326) | (-2080373662))) ^ (-2079806169);
        int i11 = ~F2.class.getName().length();
        byte length = ((((F2.class.getName().length() | 354451472) - (i11 | (-1658678084))) + (AbstractC0008a.f(F2.class, (-1725786948) | i11) + (F2.class.getName().length() & 354451472))) + (((F2.class.getName().length() | (-1149255681)) + 1149255681) | 1086734336)) ^ 1441185861;
        int i12 = 8;
        byte[] bArr2 = {-26, -15, 101, -63, length, -71, 32, 92};
        byte[] bArr3 = null;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = -585497720;
        byte[] bArr4 = null;
        while (true) {
            int i17 = ((i16 & 16777216) * (i16 | 16777216)) + ((i16 & (-16777217)) * ((~i16) & 16777216));
            int i18 = i16 >>> i12;
            int i19 = ~((((~i18) | (-238348293)) | i17) - ((i18 & (-238348293)) | i17));
            int i20 = (-1081514022) - ((i19 & i9) | ((-10362931) - i19));
            char c7 = c5;
            int i21 = -897645243;
            switch (E1.a(i20 | (-428181225), i20, -428181225)) {
                case -1819084085:
                    i = i7;
                    i3 = i8;
                    i4 = i10;
                    i5 = i12;
                    c4 = c6;
                    int length2 = bArr3.length;
                    int i22 = 0 - i13;
                    int length3 = bArr3.length;
                    int i23 = 0 - i22;
                    byte b4 = bArr3[(length3 & (~i23)) - ((~length3) & i23)];
                    int length4 = bArr3.length;
                    byte b5 = bArr4[((length4 | i22) - (((-1678010279) & (~i22)) & length4)) + ((i22 | (-1678010279)) & length4)];
                    bArr3[((length2 | i22) * 2) - (length2 ^ i22)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i15 = 4 - ((5 - i13) | (i13 & 2));
                    i9 = 2;
                    int i24 = ((i13 > 2 ? 1 : (i13 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i24 != 0) {
                        i21 = 2100390411;
                    }
                    if (i24 != 0) {
                        i7 = i;
                        i12 = i5;
                        c6 = c4;
                        c5 = c7;
                        i16 = i21;
                        i10 = i4;
                        i8 = i3;
                    }
                    i16 = -2079636786;
                    i7 = i;
                    i12 = i5;
                    c6 = c4;
                    c5 = c7;
                    i10 = i4;
                    i8 = i3;
                case -1350640889:
                    bArr3 = bArr;
                    i14 = i7;
                    bArr4 = bArr2;
                    c5 = c7;
                    i16 = -1469476344;
                case -477594107:
                    int i25 = i7;
                    int i26 = i8;
                    int length5 = bArr3.length;
                    int i27 = 0 - i13;
                    int i28 = ((length5 | i27) - (((-515406864) & (~i27)) & length5)) + ((i27 | (-515406864)) & length5);
                    byte b6 = bArr4[i28];
                    int length6 = bArr3.length;
                    byte b7 = bArr4[((i27 | length6) * 2) - (length6 ^ i27)];
                    int i29 = ((byte) i25) - b6;
                    int i30 = i29 | b7;
                    bArr4[i28] = (byte) (((byte) (((byte) i30) - ((byte) (((byte) 2) * ((byte) i29))))) + ((byte) ((b7 ^ i29) ^ i30)));
                    i7 = i25;
                    c5 = c7;
                    i16 = -1057239115;
                    i10 = i10;
                    i8 = i26;
                    i9 = 2;
                case 769572960:
                    break;
                case 783648904:
                    int i31 = i9;
                    int i32 = i14 + 4 + (((-1) - i14) | (-4));
                    byte b8 = bArr4[i32];
                    int i33 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i34 = i14 & 2;
                    int i35 = (i14 + 2) - i34;
                    int i36 = bArr4[i35] & ForkServer.ERROR;
                    int i37 = i7;
                    int i38 = i36 * ((~i36) & 65536);
                    int i39 = ~((i33 | (467314697 | (~i38))) - ((i38 & 467314697) | i33));
                    int i40 = (i14 + 1) - (i14 & 1);
                    int i41 = bArr4[i40] & ForkServer.ERROR;
                    int i42 = i10;
                    int i43 = i41 * ((~i41) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i44 = ~((i39 | ((~i43) | 1328859631)) - ((i43 & 1328859631) | i39));
                    int i45 = bArr4[i14] & ForkServer.ERROR;
                    int a2 = S.a(i44, i45, i8, ((-1) - i44) | ((-1) - i45));
                    byte b9 = bArr3[i32];
                    int i46 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i47 = bArr3[i35] & ForkServer.ERROR;
                    int i48 = i47 * ((~i47) & 65536);
                    int a4 = j3.a((~i46) & 1647046022 & i48, i48, i46, (i46 | 1647046022) & i48);
                    int i49 = bArr3[i40] & ForkServer.ERROR;
                    int i50 = i49 * ((~i49) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i51 = ~((a4 | ((~i50) | (-2059442874))) - ((i50 & (-2059442874)) | a4));
                    int i52 = bArr3[i14] & ForkServer.ERROR;
                    int a5 = S.a(i51, i52, i8, ((-1) - i51) | ((-1) - i52));
                    int i53 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                    int i54 = (i53 + a5) - ((i53 & a5) * 2);
                    bArr3[i14] = (byte) i54;
                    bArr3[i40] = (byte) (i54 >>> 8);
                    bArr3[i35] = (byte) (i54 >>> 16);
                    bArr3[i32] = (byte) (i54 >>> 24);
                    int i55 = (-11) - (((-15) - i14) | i34);
                    int length7 = bArr3.length;
                    int a6 = AbstractC0044j.a(bArr3.length);
                    int i56 = ((i55 > (((length7 & (~a6)) * 2) - (length7 ^ a6)) ? 1 : (i55 == (((length7 & (~a6)) * 2) - (length7 ^ a6)) ? 0 : -1)) >>> 31) & i8;
                    if (i56 == 0) {
                        i21 = 1251644638;
                    }
                    i14 = i55;
                    c5 = c7;
                    if (i56 != 0) {
                        i9 = i31;
                        i7 = i37;
                        i10 = i42;
                        i16 = -1469476344;
                    } else {
                        i16 = i21;
                        i9 = i31;
                        i7 = i37;
                        i10 = i42;
                    }
                    i12 = 8;
                    c6 = 6;
                case 1758587480:
                    i6 = i9;
                    int length8 = bArr3.length;
                    int i57 = 0 - i15;
                    if ((bArr4[((length8 | i57) - ((822835569 & (~i57)) & length8)) + ((i57 | 822835569) & length8)] > Double.NaN ? 1 : (bArr4[((length8 | i57) - ((822835569 & (~i57)) & length8)) + ((i57 | 822835569) & length8)] == Double.NaN ? 0 : -1)) <= -1) {
                        i16 = -897645243;
                    } else {
                        i16 = -1057239115;
                    }
                    i13 = i15;
                    c5 = c7;
                    i9 = i6;
                case 2013813686:
                    int length9 = bArr3.length % 4;
                    i6 = i9;
                    int i58 = ((length9 > i8 ? 1 : (length9 == i8 ? 0 : -1)) >>> 31) & i8;
                    if (i58 != 0) {
                        i21 = 2100390411;
                    }
                    i15 = length9;
                    if (i58 != 0) {
                        c5 = c7;
                        i16 = i21;
                        i9 = i6;
                    } else {
                        i = i7;
                        i3 = i8;
                        i4 = i10;
                        i5 = i12;
                        c4 = c6;
                        i9 = i6;
                        i16 = -2079636786;
                        i7 = i;
                        i12 = i5;
                        c6 = c4;
                        c5 = c7;
                        i10 = i4;
                        i8 = i3;
                    }
                default:
                    c5 = c7;
                    i16 = -897645243;
            }
            int i59 = i7;
            int i60 = i9;
            int i61 = i10;
            Charset charset = StandardCharsets.UTF_8;
            kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
            C0031f2 n4 = T0.n(new C0016c(this, context, 10));
            byte[] bArr5 = {-13, -30, -42, -36, 90, 121};
            byte[] bArr6 = new byte[8];
            bArr6[i59] = -104;
            bArr6[i8] = 87;
            long j2 = 42496669;
            long j3 = -3;
            long j4 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j5 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j4 + 6148914691236517205L;
            long j6 = (j5 >>> c7) & 43690;
            long j7 = ((j6 >>> i60) | (j6 >>> i8)) & 858993459;
            long j8 = ((j7 >>> i60) | j7) & 252645135;
            long j9 = (j5 >>> 32) & 43690;
            long j10 = ((j9 >>> i60) | (j9 >>> i8)) & 858993459;
            long j11 = ((j10 >>> i60) | j10) & 252645135;
            long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
            long j13 = (j5 >>> 16) & 43690;
            long j14 = ((j13 >>> i60) | (j13 >>> i8)) & 858993459;
            long j15 = ((j14 >>> i60) | j14) & 252645135;
            long j16 = j5 & 43690;
            long j17 = ((j16 >>> i60) | (j16 >>> i8)) & 858993459;
            long j18 = ((j17 >>> i60) | j17) & 252645135;
            int i62 = ((((int) ((((j18 >>> 4) | j18) & 16711935) + (((((j15 >>> 4) | j15) & 16711935) << 8) + j12))) | 356240735) - 288997405) ^ (-288997408);
            long j19 = 1508061064;
            int i63 = i8;
            long j20 = -1508061133;
            long j21 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j22 = (j21 >>> c7) & 21845;
            long j23 = ((j22 >>> i63) | j22) & 858993459;
            long j24 = ((j23 >>> i60) | j23) & 252645135;
            long j25 = (j21 >>> 32) & 21845;
            long j26 = ((j25 >>> i63) | j25) & 858993459;
            long j27 = ((j26 >>> i60) | j26) & 252645135;
            long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) | ((((j24 >>> 4) | j24) & 16711935) << 24);
            long j29 = (j21 >>> 16) & 21845;
            long j30 = ((j29 >>> i63) | j29) & 858993459;
            long j31 = ((j30 >>> i60) | j30) & 252645135;
            long j32 = ((((j31 >>> 4) | j31) & 16711935) << 8) + j28;
            long j33 = j21 & 21845;
            long j34 = (j33 | (j33 >>> i63)) & 858993459;
            long j35 = (j34 | (j34 >>> i60)) & 252645135;
            bArr6[i62] = (int) (((j35 | (j35 >>> 4)) & 16711935) | j32);
            bArr6[3] = -112;
            bArr6[4] = 54;
            bArr6[i61] = 13;
            bArr6[6] = 67;
            bArr6[7] = 49;
            L0.r(bArr5, bArr6);
            new String(bArr5, charset).intern();
            C0054l1 c0054l1 = this.f245g;
            C0047j2 c0047j2 = c0054l1.f573a;
            C0047j2 c0047j22 = c0054l1.f573a;
            c0047j2.t();
            this.f244f.f(W.f399d, n4.b());
            long j36 = 33554448;
            long j37 = i60;
            long j38 = ((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) + ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) | (((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
            long j39 = (j38 >>> c7) & 43690;
            long j40 = ((j39 >>> 2) | (j39 >>> i63)) & 858993459;
            long j41 = ((j40 >>> 2) | j40) & 252645135;
            long j42 = (j38 >>> 32) & 43690;
            long j43 = ((j42 >>> 2) | (j42 >>> i63)) & 858993459;
            long j44 = ((j43 >>> 2) | j43) & 252645135;
            long j45 = ((((j44 >>> 4) | j44) & 16711935) << 16) | ((((j41 >>> 4) | j41) & 16711935) << 24);
            long j46 = (j38 >>> 16) & 43690;
            long j47 = ((j46 >>> 2) | (j46 >>> i63)) & 858993459;
            long j48 = ((j47 >>> 2) | j47) & 252645135;
            long j49 = j38 & 43690;
            long j50 = ((j49 >>> 2) | (j49 >>> i63)) & 858993459;
            long j51 = ((j50 >>> 2) | j50) & 252645135;
            int i64 = ((int) ((((j51 >>> 4) | j51) & 16711935) + (((((j48 >>> 4) | j48) & 16711935) << 8) | j45))) | 168034880;
            long j52 = 1276794816;
            long j53 = (((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) | (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j4;
            long j54 = (j53 >>> c7) & 43690;
            long j55 = ((j54 >>> 2) | (j54 >>> i63)) & 858993459;
            long j56 = (j55 | (j55 >>> 2)) & 252645135;
            long j57 = (j53 >>> 32) & 43690;
            long j58 = ((j57 >>> 2) | (j57 >>> i63)) & 858993459;
            long j59 = ((j58 >>> 2) | j58) & 252645135;
            long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) + (((j56 | (j56 >>> 4)) & 16711935) << 24);
            long j61 = (j53 >>> 16) & 43690;
            long j62 = ((j61 >>> 2) | (j61 >>> i63)) & 858993459;
            long j63 = ((j62 >>> 2) | j62) & 252645135;
            long j64 = j53 & 43690;
            long j65 = ((j64 >>> 2) | (j64 >>> i63)) & 858993459;
            long j66 = (j65 | (j65 >>> 2)) & 252645135;
            byte b10 = 1572526064 ^ (295731202 + ((int) (((j66 | (j66 >>> 4)) & 16711935) + (((((j63 >>> 4) | j63) & 16711935) << 8) + j60))));
            byte[] bArr7 = new byte[i61];
            bArr7[i59] = (-176424500) ^ ((i64 ^ (-8389686)) - (((~i64) & (-8389686)) * 2));
            bArr7[i63] = b10;
            bArr7[2] = -107;
            bArr7[3] = 106;
            bArr7[4] = -77;
            L0.r(bArr7, new byte[]{-11, 39, 13, 7, -44, 67, Byte.MIN_VALUE, 38});
            d(new String(bArr7, charset).intern(), n4);
            if (n4.b()) {
                byte[] bArr8 = {59, 27, -75, 7, -10};
                L0.r(bArr8, new byte[]{118, 78, -19, 89, -111, 72, -114, -28});
                String intern = new String(bArr8, charset).intern();
                c0047j22.t();
                m(intern);
            }
            if (n4.a()) {
                Integer t3 = c0047j22.t();
                byte[] bArr9 = {-90, -103, 20, -9, -124};
                byte[] bArr10 = new byte[8];
                long j67 = 221262794;
                long j68 = ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                long j69 = (((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7;
                long j70 = (j69 | j68) + j69 + j68;
                long j71 = (j70 >>> c7) & 21845;
                long j72 = (j71 | (j71 >>> i63)) & 858993459;
                long j73 = (j72 | (j72 >>> 2)) & 252645135;
                long j74 = (j70 >>> 32) & 21845;
                long j75 = ((j74 >>> i63) | j74) & 858993459;
                long j76 = ((j75 >>> 2) | j75) & 252645135;
                long j77 = ((((j76 >>> 4) | j76) & 16711935) << 16) + (((j73 | (j73 >>> 4)) & 16711935) << 24);
                long j78 = (j70 >>> 16) & 21845;
                long j79 = ((j78 >>> i63) | j78) & 858993459;
                long j80 = ((j79 >>> 2) | j79) & 252645135;
                long j81 = j70 & 21845;
                long j82 = (j81 | (j81 >>> i63)) & 858993459;
                long j83 = (j82 | (j82 >>> 2)) & 252645135;
                bArr10[(int) (((j83 | (j83 >>> 4)) & 16711935) | ((((j80 >>> 4) | j80) & 16711935) << 8) | j77)] = -39;
                bArr10[i63] = -52;
                bArr10[2] = -116;
                bArr10[3] = 105;
                bArr10[4] = -29;
                bArr10[5] = -19;
                bArr10[6] = 117;
                bArr10[7] = -22;
                L0.r(bArr9, bArr10);
                c0054l1.c(new String(bArr9, charset).intern(), t3);
                return;
            }
            return;
        }
    }

    public final boolean C() {
        Throwable th;
        int i;
        int i3;
        int i4;
        long j2;
        int i5;
        byte b4;
        int i6;
        Object obj;
        boolean z3;
        try {
            byte[] bArr = new byte[17];
            bArr[0] = 124;
            bArr[1] = 73;
            bArr[2] = -96;
            bArr[3] = 69;
            bArr[4] = -11;
            bArr[5] = -44;
            bArr[6] = -47;
            bArr[7] = 54;
            int i7 = 8;
            bArr[8] = 94;
            int i8 = 9;
            bArr[9] = 62;
            bArr[10] = -106;
            bArr[11] = -61;
            try {
                try {
                    bArr[12] = -78;
                    bArr[13] = -51;
                    int i9 = ((~F2.class.getName().length()) | 964311465) & 555876501;
                    byte b5 = 4;
                    int i10 = 10;
                    long j3 = -1874522110;
                    long length = F2.class.getName().length() & (-1878720490);
                    long b6 = c3.b((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j4 = (b6 >>> 48) & 43690;
                    long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
                    long j6 = ((j5 >>> 2) | j5) & 252645135;
                    long j7 = (b6 >>> 32) & 43690;
                    long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                    long j9 = ((j8 >>> 2) | j8) & 252645135;
                    long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
                    long j11 = (b6 >>> 16) & 43690;
                    long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                    long j13 = ((j12 >>> 2) | j12) & 252645135;
                    long j14 = b6 & 43690;
                    long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                    long j16 = ((j15 >>> 2) | j15) & 252645135;
                    bArr[(i9 + ((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10)))) ^ (-1318645607)] = -21;
                    bArr[15] = 41;
                    bArr[16] = -88;
                    long j17 = -191213593;
                    long j18 = ~F2.class.getName().length();
                    long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j20 = 6148914691236517205L;
                    long j21 = j19 + 6148914691236517205L;
                    long j22 = (j21 >>> 48) & 43690;
                    long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                    long j24 = ((j23 >>> 2) | j23) & 252645135;
                    long j25 = (j21 >>> 32) & 43690;
                    long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                    long j27 = ((j26 >>> 2) | j26) & 252645135;
                    long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) | ((((j24 >>> 4) | j24) & 16711935) << 24);
                    long j29 = (j21 >>> 16) & 43690;
                    long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                    long j31 = ((j30 >>> 2) | j30) & 252645135;
                    long j32 = j21 & 43690;
                    long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                    long j34 = ((j33 >>> 2) | j33) & 252645135;
                    int i11 = (int) ((((j34 >>> 4) | j34) & 16711935) | ((((j31 >>> 4) | j31) & 16711935) << 8) | j28);
                    long j35 = -2146400236;
                    long j36 = i11;
                    long j37 = ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j38 = (j37 >>> 48) & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    long j41 = (j37 >>> 32) & 43690;
                    long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) | ((((j40 >>> 4) | j40) & 16711935) << 24);
                    long j45 = (j37 >>> 16) & 43690;
                    long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                    long j47 = ((j46 >>> 2) | j46) & 252645135;
                    long j48 = ((((j47 >>> 4) | j47) & 16711935) << 8) + j44;
                    long j49 = j37 & 43690;
                    long j50 = ((j49 >>> 2) | (j49 >>> 1)) & 858993459;
                    long j51 = (j50 | (j50 >>> 2)) & 252645135;
                    byte[] bArr2 = new byte[(((int) (((j51 | (j51 >>> 4)) & 16711935) | j48)) + ((F2.class.getName().length() & 37392) | 8475136)) ^ (-2137925115)];
                    int i12 = ~F2.class.getName().length();
                    bArr2[(((i12 | 2070859711) - ((996986811 | i12) ^ 1380336134)) + ((F2.class.getName().length() & 1627522308) | 620766480)) ^ 2001102614] = -93;
                    bArr2[1] = -37;
                    bArr2[2] = 97;
                    bArr2[3] = 16;
                    bArr2[4] = -12;
                    bArr2[5] = 10;
                    bArr2[6] = -72;
                    bArr2[7] = 46;
                    bArr2[8] = 22;
                    bArr2[9] = -87;
                    bArr2[10] = -17;
                    bArr2[((((~F2.class.getName().length()) | 1007613551) & 538837575) + (((F2.class.getName().length() | (-1078984705)) + 1078984705) | 1346490424)) ^ 1885327988] = Byte.MAX_VALUE;
                    int i13 = ((~F2.class.getName().length()) | 1549409510) & 1073742165;
                    int length2 = F2.class.getName().length();
                    bArr2[(i13 + ((((F2.class.getName().length() | 17169) - (length2 | 17169)) + ((length2 - F2.class.getName().length()) + (F2.class.getName().length() & 17169))) | 553665024)) ^ 1627407193] = -50;
                    bArr2[13] = 18;
                    int i14 = 14;
                    bArr2[14] = 126;
                    bArr2[15] = -16;
                    bArr2[16] = -120;
                    k(bArr, bArr2);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new String(bArr, StandardCharsets.UTF_8).intern())), 1000);
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        Iterator it = ((M2.a) E1.b.s(bufferedReader)).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = b5;
                                i3 = i14;
                                i4 = i8;
                                j2 = j20;
                                i5 = i10;
                                b4 = -45;
                                i6 = i7;
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            String str = (String) obj;
                            byte[] bArr3 = new byte[i8];
                            // fill-array-data instruction
                            bArr3[0] = 48;
                            bArr3[1] = -90;
                            bArr3[2] = -43;
                            bArr3[3] = -105;
                            bArr3[4] = -39;
                            bArr3[5] = 33;
                            bArr3[6] = -36;
                            bArr3[7] = 108;
                            bArr3[8] = -73;
                            b4 = -45;
                            byte[] bArr4 = new byte[i8];
                            bArr4[0] = -77;
                            bArr4[1] = -45;
                            bArr4[2] = 73;
                            bArr4[3] = 13;
                            bArr4[((((~F2.class.getName().length()) | (-1155757448)) & 1172310060) + ((F2.class.getName().length() & 1423966726) | 268567042)) ^ 1440877098] = b5;
                            bArr4[5] = -107;
                            bArr4[6] = 102;
                            bArr4[7] = -112;
                            int i15 = i7;
                            long j52 = -1;
                            j2 = j20;
                            long length3 = F2.class.getName().length();
                            long j53 = ((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j52 >>> i15) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> i15) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                            long j54 = (j53 >>> 48) & 21845;
                            long j55 = ((j54 >>> 1) | j54) & 858993459;
                            long j56 = ((j55 >>> 2) | j55) & 252645135;
                            long j57 = (j53 >>> 32) & 21845;
                            long j58 = ((j57 >>> 1) | j57) & 858993459;
                            long j59 = ((j58 >>> 2) | j58) & 252645135;
                            long j60 = ((((j59 >>> b5) | j59) & 16711935) << 16) + ((((j56 >>> b5) | j56) & 16711935) << 24);
                            long j61 = (j53 >>> 16) & 21845;
                            long j62 = ((j61 >>> 1) | j61) & 858993459;
                            long j63 = ((j62 >>> 2) | j62) & 252645135;
                            long j64 = j53 & 21845;
                            long j65 = ((j64 >>> 1) | j64) & 858993459;
                            long j66 = ((j65 >>> 2) | j65) & 252645135;
                            int length4 = F2.class.getName().length();
                            bArr4[i15] = (((((int) ((((j66 >>> b5) | j66) & 16711935) + (((((j63 >>> b5) | j63) & 16711935) << i15) + j60))) | 1965801826) & 285245478) + (68169984 | ((length4 | 68157444) - (length4 ^ 68157444)))) ^ (-353415481);
                            k(bArr3, bArr4);
                            String prefix = new String(bArr3, StandardCharsets.UTF_8).intern();
                            kotlin.jvm.internal.j.e(str, "<this>");
                            kotlin.jvm.internal.j.e(prefix, "prefix");
                            byte b7 = b5;
                            i5 = i10;
                            i6 = i15;
                            i3 = 14;
                            i4 = 9;
                            if (N2.n.K(0, 0, prefix.length(), str, prefix, true)) {
                                i = b7;
                                break;
                            }
                            b5 = b7;
                            i14 = 14;
                            i10 = i5;
                            i7 = i6;
                            i8 = 9;
                            j20 = j2;
                        }
                        String str2 = (String) obj;
                        if (str2 != null) {
                            String substring = str2.substring(i5);
                            byte[] bArr5 = new byte[i3];
                            long j67 = 88564245;
                            long length5 = ((((-1) - F2.class.getName().length()) | (-45522109)) & 71712789) + ((F2.class.getName().length() & 393748) | 16851456);
                            long j68 = ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j67 >>> i6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length5 >>> i6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j69 = (j68 >>> 48) & 21845;
                            long j70 = ((j69 >>> 1) | j69) & 858993459;
                            long j71 = ((j70 >>> 2) | j70) & 252645135;
                            long j72 = (j68 >>> 32) & 21845;
                            long j73 = ((j72 >>> 1) | j72) & 858993459;
                            long j74 = ((j73 >>> 2) | j73) & 252645135;
                            long j75 = ((((j74 >>> i) | j74) & 16711935) << 16) | ((((j71 >>> i) | j71) & 16711935) << 24);
                            long j76 = (j68 >>> 16) & 21845;
                            long j77 = ((j76 >>> 1) | j76) & 858993459;
                            long j78 = ((j77 >>> 2) | j77) & 252645135;
                            long j79 = j68 & 21845;
                            long j80 = (j79 | (j79 >>> 1)) & 858993459;
                            long j81 = (j80 | (j80 >>> 2)) & 252645135;
                            bArr5[(int) (((j81 | (j81 >>> i)) & 16711935) | (((((j78 >>> i) | j78) & 16711935) << i6) + j75))] = -28;
                            bArr5[1] = -13;
                            bArr5[2] = 20;
                            bArr5[3] = ((((~F2.class.getName().length()) | 1495628717) & 1179912481) + ((F2.class.getName().length() & 644939856) | 941686864)) ^ (-2121599287);
                            int i16 = ~F2.class.getName().length();
                            int length6 = F2.class.getName().length();
                            int i17 = (length6 | 1083228162) - (length6 ^ 1083228162);
                            long j82 = 1485849100;
                            long j83 = i17;
                            long j84 = (((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j82 >>> i6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j83 >>> i6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j2;
                            long j85 = (j84 >>> 48) & 43690;
                            long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                            long j87 = ((j86 >>> 2) | j86) & 252645135;
                            long j88 = (j84 >>> 32) & 43690;
                            long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                            long j90 = ((j89 >>> 2) | j89) & 252645135;
                            long j91 = ((((j90 >>> i) | j90) & 16711935) << 16) | ((((j87 >>> i) | j87) & 16711935) << 24);
                            long j92 = (j84 >>> 16) & 43690;
                            long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                            long j94 = ((j93 >>> 2) | j93) & 252645135;
                            long j95 = j84 & 43690;
                            long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                            long j97 = (j96 | (j96 >>> 2)) & 252645135;
                            bArr5[((((i16 + (((-i16) - 1) | 1418784134)) - 1418784134) & (-1576890285)) + ((int) (((j97 | (j97 >>> i)) & 16711935) | (((((j94 >>> i) | j94) & 16711935) << i6) + j91)))) ^ (-91041189)] = -65;
                            int i18 = ((~F2.class.getName().length()) | (-84980896)) & (-234747632);
                            int a2 = V2.a((F2.class.getName().length() & 138944657) + (((-r10) - 1) | (-206315654)) + 206315654, ~i18, ((~r10) - i18) - 1);
                            long j98 = -28431984;
                            long j99 = a2;
                            long j100 = (((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j98 >>> i6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j99 >>> i6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j101 = (j100 >>> 48) & 21845;
                            long j102 = ((j101 >>> 1) | j101) & 858993459;
                            long j103 = ((j102 >>> 2) | j102) & 252645135;
                            long j104 = (j100 >>> 32) & 21845;
                            long j105 = ((j104 >>> 1) | j104) & 858993459;
                            long j106 = ((j105 >>> 2) | j105) & 252645135;
                            long j107 = ((((j106 >>> i) | j106) & 16711935) << 16) | ((((j103 >>> i) | j103) & 16711935) << 24);
                            long j108 = (j100 >>> 16) & 21845;
                            long j109 = ((j108 >>> 1) | j108) & 858993459;
                            long j110 = ((j109 >>> 2) | j109) & 252645135;
                            long j111 = j100 & 21845;
                            long j112 = (j111 | (j111 >>> 1)) & 858993459;
                            long j113 = (j112 | (j112 >>> 2)) & 252645135;
                            int i19 = (int) (((j113 | (j113 >>> i)) & 16711935) | (((((j110 >>> i) | j110) & 16711935) << i6) + j107));
                            int i20 = ((~F2.class.getName().length()) | 80940642) & 372320352;
                            long j114 = 304653312;
                            int i21 = i5;
                            int i22 = i6;
                            long length7 = F2.class.getName().length();
                            long j115 = ((((((((j114 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j114 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j114 >>> i22) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j114 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> i22) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j116 = (j115 >>> 48) & 43690;
                            long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
                            long j118 = (j117 | (j117 >>> 2)) & 252645135;
                            long j119 = (j115 >>> 32) & 43690;
                            long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
                            long j121 = ((j120 >>> 2) | j120) & 252645135;
                            long j122 = (((j118 | (j118 >>> i)) & 16711935) << 24) | ((((j121 >>> i) | j121) & 16711935) << 16);
                            long j123 = (j115 >>> 16) & 43690;
                            long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                            long j125 = ((j124 >>> 2) | j124) & 252645135;
                            long j126 = j115 & 43690;
                            long j127 = ((j126 >>> 2) | (j126 >>> 1)) & 858993459;
                            long j128 = (j127 | (j127 >>> 2)) & 252645135;
                            int i23 = i20 + (((int) (((j128 | (j128 >>> i)) & 16711935) + ((((j125 >>> i) | j125) & 16711935) << i22) + j122)) | 537708032);
                            long j129 = 910028333;
                            long j130 = i23;
                            long j131 = ((((((((j129 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j129 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j129 >>> i22) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j129 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j130 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j130 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j130 >>> i22) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j130 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j132 = (j131 >>> 48) & 21845;
                            long j133 = (j132 | (j132 >>> 1)) & 858993459;
                            long j134 = (j133 | (j133 >>> 2)) & 252645135;
                            long j135 = (j131 >>> 32) & 21845;
                            long j136 = ((j135 >>> 1) | j135) & 858993459;
                            long j137 = ((j136 >>> 2) | j136) & 252645135;
                            long j138 = (((j134 | (j134 >>> i)) & 16711935) << 24) | ((((j137 >>> i) | j137) & 16711935) << 16);
                            long j139 = (j131 >>> 16) & 21845;
                            long j140 = ((j139 >>> 1) | j139) & 858993459;
                            long j141 = ((j140 >>> 2) | j140) & 252645135;
                            long j142 = j131 & 21845;
                            long j143 = (j142 | (j142 >>> 1)) & 858993459;
                            long j144 = (j143 | (j143 >>> 2)) & 252645135;
                            bArr5[i19] = (int) (((j144 | (j144 >>> i)) & 16711935) + (j138 | ((((j141 >>> i) | j141) & 16711935) << i22)));
                            bArr5[6] = -42;
                            bArr5[7] = -26;
                            bArr5[i22] = -39;
                            bArr5[i4] = -67;
                            bArr5[i21] = b4;
                            bArr5[11] = 64;
                            bArr5[12] = -123;
                            bArr5[13] = 92;
                            byte[] bArr6 = new byte[i3];
                            // fill-array-data instruction
                            bArr6[0] = -91;
                            bArr6[1] = 117;
                            bArr6[2] = -85;
                            bArr6[3] = 16;
                            bArr6[4] = -13;
                            bArr6[5] = -127;
                            bArr6[6] = 73;
                            bArr6[7] = -33;
                            bArr6[8] = -94;
                            bArr6[9] = -49;
                            bArr6[10] = 105;
                            bArr6[11] = 80;
                            bArr6[12] = -110;
                            bArr6[13] = -74;
                            k(bArr5, bArr6);
                            Charset charset = StandardCharsets.UTF_8;
                            kotlin.jvm.internal.j.d(substring, new String(bArr5, charset).intern());
                            Integer F3 = N2.m.F(N2.f.e0(substring).toString());
                            if (F3 != null) {
                                if (F3.intValue() > 0) {
                                    byte[] bArr7 = {-45, -10, 7, -93, 75, -109, -113, -53, -77, 50, 41, -72};
                                    k(bArr7, new byte[]{-24, -68, 88, 123, -112, -102, -16, 48, 113, -76, 74, 34});
                                    String intern = new String(bArr7, charset).intern();
                                    byte[] bArr8 = new byte[i];
                                    // fill-array-data instruction
                                    bArr8[0] = 96;
                                    bArr8[1] = 55;
                                    bArr8[2] = 75;
                                    bArr8[3] = -11;
                                    byte[] bArr9 = new byte[i22];
                                    // fill-array-data instruction
                                    bArr9[0] = 77;
                                    bArr9[1] = -49;
                                    bArr9[2] = 15;
                                    bArr9[3] = -21;
                                    bArr9[4] = -48;
                                    bArr9[5] = 12;
                                    bArr9[6] = 67;
                                    bArr9[7] = -58;
                                    k(bArr8, bArr9);
                                    try {
                                        t(intern, new String(bArr8, charset).intern());
                                        z3 = true;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        th = th;
                                        try {
                                            throw th;
                                        } catch (Throwable th4) {
                                            p3.h.h(bufferedReader, th);
                                            throw th4;
                                        }
                                    }
                                } else {
                                    z3 = false;
                                }
                                p3.h.h(bufferedReader, null);
                                return z3;
                            }
                        }
                        p3.h.h(bufferedReader, null);
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        th = th;
                        throw th;
                    }
                } catch (Exception unused) {
                    return false;
                }
            } catch (Exception unused2) {
                return false;
            }
        } catch (Exception unused3) {
            return false;
        }
    }

    @Override // F0.T2
    public final void a(Context context) {
        byte[] bArr = {-106, 37, 16, (-971938171) ^ (((((-684588839) | r2) - 2112871199) - ((~F2.class.getName().length()) | (-684579591))) + ((F2.class.getName().length() & 67200544) | 1140933124)), 60, 8, 82};
        byte[] bArr2 = new byte[8];
        bArr2[0] = -34;
        bArr2[1] = 122;
        bArr2[2] = 104;
        bArr2[3] = 45;
        long j2 = -942721541;
        long f4 = AbstractC0008a.f(F2.class, -1);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j4 = (j3 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 8) + j10;
        long j15 = j3 & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        long j18 = -1476325882;
        long j19 = (int) (((j17 | (j17 >>> 4)) & 16711935) | j14);
        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
        int length = F2.class.getName().length();
        bArr2[4] = (-301654433) ^ ((((704645636 & length) + 1174671360) - (length & 33554432)) + ((int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))));
        bArr2[5] = 112;
        bArr2[6] = 38;
        long j34 = 2120848;
        long j35 = (~F2.class.getName().length()) | (-926499172);
        long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j37 = (j36 >>> 48) & 43690;
        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = (j36 >>> 32) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) + ((((j39 >>> 4) | j39) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = (j45 | (j45 >>> 2)) & 252645135;
        long j47 = j36 & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = (j48 | (j48 >>> 2)) & 252645135;
        bArr2[(-2043126121) ^ (((int) (((j49 | (j49 >>> 4)) & 16711935) + ((((j46 | (j46 >>> 4)) & 16711935) << 8) + j43))) + ((F2.class.getName().length() & 70270976) | (-2045246976)))] = 99;
        y(bArr, bArr2);
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
        B(context);
    }
}
