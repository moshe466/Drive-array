package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.fork.ForkServer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class Y1 implements J {

    /* renamed from: a, reason: collision with root package name */
    public final String f431a;

    /* renamed from: b, reason: collision with root package name */
    public final List f432b;

    public Y1(String str, List list) {
        byte[] bArr = {-31, 54, -122, -39, 125, 8, 62, 34, -13};
        c(bArr, new byte[]{-126, 94, -29, -70, 22, 70, 95, 79, -106});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(str, new String(bArr, charset).intern());
        byte[] bArr2 = {-45, -67, 50, 124};
        c(bArr2, new byte[]{-70, -45, 84, 19, 112, 121, -46, 25});
        kotlin.jvm.internal.j.e(list, new String(bArr2, charset).intern());
        this.f431a = str;
        this.f432b = list;
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
        int i7 = ~Y1.class.getName().length();
        int length3 = (((~(((Y1.class.getName().length() | 70245657) | i7) - (i7 | (Y1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((Y1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(Y1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((Y1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~Y1.class.getName().length()) | (-576567005)) & 276971586) + ((Y1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~Y1.class.getName().length()) | (-1157759625)) & 1755853004) + ((Y1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~Y1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = Y1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~Y1.class.getName().length()) | (-1064961)) + 689325073) + ((Y1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~Y1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = Y1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~Y1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (Y1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((Y1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~Y1.class.getName().length();
                    int length11 = (161497089 & (((((Y1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((Y1.class.getName().length() | i14) & 797295576))) + ((Y1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~Y1.class.getName().length()) | (-1085986263)) & 1078327440) + ((Y1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~Y1.class.getName().length();
                    int length12 = length5 >>> ((((~(((Y1.class.getName().length() | 626856794) | i15) - ((Y1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((Y1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~Y1.class.getName().length()) | 1248713193) & 826417528) + ((Y1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~Y1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (Y1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~Y1.class.getName().length()) | (-1005965450)) & 153223237) + ((Y1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((Y1.class.getName().length() & (~length6)) & i9)) + ((Y1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~Y1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((Y1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~Y1.class.getName().length()) | (-23496740)) & 827084804) + ((Y1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~Y1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (Y1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~Y1.class.getName().length()) | (-961655275)) & 25184460) + ((Y1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~Y1.class.getName().length()) | 1233459797) & 125923146) + ((Y1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~Y1.class.getName().length()) | (-7107622)) & 402932290) + ((Y1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((Y1.class.getName().length() | length15) - (b4 | length15)) + I2.a(Y1.class, b4) + (Y1.class.getName().length() & length15);
                    int length17 = ((((~Y1.class.getName().length()) | (-81143879)) & 438583424) + ((Y1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~Y1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((Y1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(Y1.class, 568748773 | i24) + (Y1.class.getName().length() & (-2105278367)))) + ((Y1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~Y1.class.getName().length()) | (-1592082969)) & 140665109) + ((Y1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~Y1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((Y1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~Y1.class.getName().length()) | (-180811308));
                    int length19 = (Y1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((Y1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | Y1.class.getName().length()))));
                    int i29 = ((~Y1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (Y1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~Y1.class.getName().length()) | 75364313) & 1242301609) + ((Y1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = Y1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((Y1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~Y1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((Y1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~Y1.class.getName().length();
                    int length24 = 1409942802 & (((((Y1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | Y1.class.getName().length()) & 91135407));
                    int length25 = (Y1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~Y1.class.getName().length()) | (-537919489)) - (-806798471)) + ((Y1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~Y1.class.getName().length()) | (-382746167)) & 102532165) + ((Y1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~Y1.class.getName().length()) | (-6036961)) & 1233145505) + ((Y1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~Y1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = Y1.class.getName().length() & 268460041;
                    i5 = (((((Y1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | Y1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = Y1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((Y1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~Y1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((Y1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~Y1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (Y1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(Y1.class, -1) | (-532481)) - (-67641369)) + ((Y1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~Y1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((Y1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(Y1.class, -1) | (-33554434)) - (-1107366402)) + ((Y1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(Y1.class, -1) | (-167014194)) & 1157999680) + ((Y1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = Y1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((Y1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(Y1.class, -1) | 114408723) & 1183666176;
                    int length33 = Y1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~Y1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = Y1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~Y1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (Y1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~Y1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((Y1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~Y1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (Y1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~Y1.class.getName().length()) | 991120067) & (-2113137661)) + ((Y1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(Y1.class, -1) | 314136709) & 371231304) + (((Y1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~Y1.class.getName().length()) | 366661365) & 1344150018) + ((Y1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~Y1.class.getName().length()) | (-1359635359)) & 49026131) + ((Y1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~Y1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = Y1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (Y1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~Y1.class.getName().length()) | 1110430873) & 1241612298) + ((Y1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~Y1.class.getName().length()) | 1603962366) & 25199440) + (((Y1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~Y1.class.getName().length()) | (-1388708984)) & 706816128) + ((Y1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~Y1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = Y1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~Y1.class.getName().length()) | 2113158628) & 1026558002) + ((Y1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~Y1.class.getName().length()) | 715175224) & 136512788) + ((Y1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~Y1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = Y1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~Y1.class.getName().length()) | (-1084937228)) & 438503696) + ((Y1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~Y1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((Y1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(Y1.class, 1197735420 | i53) + (Y1.class.getName().length() & 674349280))) + ((Y1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~Y1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (Y1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~Y1.class.getName().length()) | (-171976913)) & 318775824) + ((Y1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~Y1.class.getName().length()) | (-616910267)) & 1303391760) + ((Y1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~Y1.class.getName().length()) | 1297715640) & 556926729) + ((Y1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~Y1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((Y1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~Y1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (Y1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] bArr3 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -585497720;
        byte[] bArr4 = null;
        while (true) {
            int i7 = ((i6 & 16777216) * (i6 | 16777216)) + ((i6 & (-16777217)) * ((~i6) & 16777216));
            int i8 = i6 >>> 8;
            int i9 = ~((((~i8) | (-238348293)) | i7) - ((i8 & (-238348293)) | i7));
            int i10 = (-1081514022) - ((i9 & 2) | ((-10362931) - i9));
            int a2 = E1.a(i10 | (-428181225), i10, -428181225);
            int i11 = 2100390411;
            int i12 = -897645243;
            boolean z3 = true;
            switch (a2) {
                case -1819084085:
                    int length = bArr3.length;
                    int i13 = 0 - i3;
                    int length2 = bArr3.length;
                    int i14 = 0 - i13;
                    byte b4 = bArr3[(length2 & (~i14)) - ((~length2) & i14)];
                    int length3 = bArr3.length;
                    byte b5 = bArr4[((length3 | i13) - (((-1678010279) & (~i13)) & length3)) + ((i13 | (-1678010279)) & length3)];
                    bArr3[((length | i13) * 2) - (length ^ i13)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i5 = 4 - ((5 - i3) | (i3 & 2));
                    int i15 = ((i3 > 2 ? 1 : (i3 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i15 == 0) {
                        i11 = -897645243;
                    }
                    if (i15 != 0) {
                        i6 = i11;
                    } else {
                        i6 = -2079636786;
                    }
                case -1350640889:
                    int length4 = bArr.length;
                    int length5 = 0 - (bArr.length % 4);
                    if (((length4 | length5) - ((942778902 & (~length5)) & length4)) + ((length5 | 942778902) & length4) <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i = -897645243;
                    } else {
                        i = 1251644638;
                    }
                    if (z3) {
                        i6 = -1469476344;
                    } else {
                        i6 = i;
                    }
                    bArr4 = bArr2;
                    bArr3 = bArr;
                    i4 = 0;
                case -477594107:
                    int length6 = bArr3.length;
                    int i16 = 0 - i3;
                    int i17 = ((length6 | i16) - (((-515406864) & (~i16)) & length6)) + ((i16 | (-515406864)) & length6);
                    byte b6 = bArr4[i17];
                    int length7 = bArr3.length;
                    byte b7 = bArr4[((i16 | length7) * 2) - (length7 ^ i16)];
                    int i18 = ((byte) 0) - b6;
                    int i19 = i18 | b7;
                    bArr4[i17] = (byte) (((byte) (((byte) i19) - ((byte) (((byte) 2) * ((byte) i18))))) + ((byte) ((b7 ^ i18) ^ i19)));
                    i6 = -1057239115;
                case 769572960:
                    break;
                case 783648904:
                    int i20 = i4 + 4 + (((-1) - i4) | (-4));
                    byte b8 = bArr4[i20];
                    int i21 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i22 = i4 & 2;
                    int i23 = (i4 + 2) - i22;
                    int i24 = bArr4[i23] & ForkServer.ERROR;
                    int i25 = i24 * ((~i24) & 65536);
                    int i26 = ~((i21 | ((~i25) | 467314697)) - ((i25 & 467314697) | i21));
                    int i27 = (i4 + 1) - (i4 & 1);
                    int i28 = bArr4[i27] & ForkServer.ERROR;
                    int i29 = i28 * ((~i28) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i30 = ~((i26 | ((~i29) | 1328859631)) - ((i29 & 1328859631) | i26));
                    int i31 = bArr4[i4] & ForkServer.ERROR;
                    int a4 = S.a(i30, i31, 1, ((-1) - i30) | ((-1) - i31));
                    byte b9 = bArr3[i20];
                    int i32 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i33 = bArr3[i23] & ForkServer.ERROR;
                    int i34 = i33 * ((~i33) & 65536);
                    int a5 = j3.a((~i32) & 1647046022 & i34, i34, i32, (i32 | 1647046022) & i34);
                    int i35 = bArr3[i27] & ForkServer.ERROR;
                    int i36 = i35 * ((~i35) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i37 = ~((a5 | ((~i36) | (-2059442874))) - ((i36 & (-2059442874)) | a5));
                    int i38 = bArr3[i4] & ForkServer.ERROR;
                    int a6 = S.a(i37, i38, 1, ((-1) - i37) | ((-1) - i38));
                    int i39 = a4 << ((a4 > Double.NaN ? 1 : (a4 == Double.NaN ? 0 : -1)) >>> 31);
                    int i40 = (i39 + a6) - ((i39 & a6) * 2);
                    bArr3[i4] = (byte) i40;
                    bArr3[i27] = (byte) (i40 >>> 8);
                    bArr3[i23] = (byte) (i40 >>> 16);
                    bArr3[i20] = (byte) (i40 >>> 24);
                    i4 = (-11) - (((-15) - i4) | i22);
                    int length8 = bArr3.length;
                    int a7 = AbstractC0044j.a(bArr3.length);
                    int i41 = ((i4 > (((length8 & (~a7)) * 2) - (length8 ^ a7)) ? 1 : (i4 == (((length8 & (~a7)) * 2) - (length8 ^ a7)) ? 0 : -1)) >>> 31) & 1;
                    if (i41 == 0) {
                        i12 = 1251644638;
                    }
                    if (i41 == 0) {
                        i6 = i12;
                    } else {
                        i6 = -1469476344;
                    }
                case 1758587480:
                    int length9 = bArr3.length;
                    int i42 = 0 - i5;
                    if ((bArr4[((length9 | i42) - ((822835569 & (~i42)) & length9)) + ((i42 | 822835569) & length9)] > Double.NaN ? 1 : (bArr4[((length9 | i42) - ((822835569 & (~i42)) & length9)) + ((i42 | 822835569) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i6 = -897645243;
                    } else {
                        i6 = -1057239115;
                    }
                    i3 = i5;
                case 2013813686:
                    i5 = bArr3.length % 4;
                    int i43 = ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i43 == 0) {
                        i11 = -897645243;
                    }
                    if (i43 != 0) {
                        i6 = i11;
                    } else {
                        i6 = -2079636786;
                    }
                default:
                    i6 = i12;
            }
            return;
        }
    }

    @Override // F0.J
    public final void a(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        Iterator it = null;
        JSONObject jSONObject2 = null;
        String str = null;
        JSONArray jSONArray2 = null;
        char c4 = 51184;
        while (true) {
            if (c4 != 51184) {
                if (c4 != 27700) {
                    if (c4 != 60297) {
                        if (c4 == 51769) {
                            jSONObject2.put(str, jSONArray2);
                            return;
                        }
                    } else if (!it.hasNext()) {
                        c4 = 51769;
                    }
                    c4 = 27700;
                } else {
                    jSONArray.put((String) it.next());
                }
            } else {
                byte[] bArr = {33, -19, 57, 102};
                byte[] bArr2 = new byte[8];
                int i = ~Y1.class.getName().length();
                int length = Y1.class.getName().length() & (-2063594972);
                bArr2[(-852632899) ^ ((((~length) & 1294008868) + length) + ((i | (-53610275)) - ((2093871325 | i) ^ (-2146641767))))] = -102;
                bArr2[1] = 103;
                bArr2[2] = Byte.MAX_VALUE;
                int length2 = (((~Y1.class.getName().length()) | (-541065221)) - (-1648495013)) + ((Y1.class.getName().length() & 692592661) | 151543825);
                bArr2[3] = (((~length2) & (-1800038856)) - ((-1800038856) & length2)) + length2;
                bArr2[4] = 87;
                bArr2[5] = 113;
                bArr2[6] = 92;
                bArr2[7] = 59;
                b(bArr, bArr2);
                kotlin.jvm.internal.j.e(jSONObject, new String(bArr, StandardCharsets.UTF_8).intern());
                jSONArray2 = new JSONArray();
                it = this.f432b.iterator();
                str = this.f431a;
                jSONObject2 = jSONObject;
                jSONArray = jSONArray2;
            }
            c4 = 60297;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    public final boolean equals(Object obj) {
        Y1 y12 = null;
        char c4 = 39247;
        while (true) {
            switch (c4) {
                case 65368:
                    y12 = (Y1) obj;
                    if (!kotlin.jvm.internal.j.a(this.f431a, y12.f431a)) {
                        c4 = 57314;
                    } else {
                        c4 = 59246;
                    }
                case 57314:
                    return false;
                case 39247:
                    if (this == obj) {
                        c4 = 14882;
                    } else {
                        c4 = 20934;
                    }
                case 41725:
                    return false;
                case 20934:
                    if (!(obj instanceof Y1)) {
                        c4 = 52643;
                    } else {
                        c4 = 65368;
                    }
                case 59246:
                    if (!kotlin.jvm.internal.j.a(this.f432b, y12.f432b)) {
                        c4 = 41725;
                    } else {
                        c4 = 48088;
                    }
                case 48088:
                    return true;
                case 52643:
                    return false;
                case 14882:
                    return true;
                default:
                    c4 = 41725;
            }
        }
    }

    public final int hashCode() {
        int hashCode = this.f431a.hashCode();
        return this.f432b.hashCode() + (((~hashCode) & 31) * (hashCode & (-32))) + ((hashCode & 31) * (hashCode | 31));
    }

    public final String toString() {
        byte[] bArr = new byte[26];
        bArr[0] = 114;
        bArr[1] = -106;
        bArr[2] = -116;
        bArr[3] = 115;
        bArr[4] = -34;
        bArr[5] = -88;
        bArr[6] = -63;
        bArr[7] = 44;
        bArr[8] = 98;
        bArr[9] = 126;
        bArr[10] = 92;
        bArr[11] = -58;
        bArr[12] = 3;
        bArr[13] = -32;
        int i = ((~Y1.class.getName().length()) | 831314808) & 1344685217;
        int length = (Y1.class.getName().length() & 1075979905) | 134226436;
        int i3 = -i;
        bArr[1478911659 ^ (((~i3) & length) - (i3 & (~length)))] = 85;
        bArr[15] = -119;
        bArr[16] = 17;
        bArr[17] = 100;
        bArr[18] = 55;
        bArr[19] = -37;
        bArr[20] = -26;
        bArr[21] = 76;
        int i4 = ((~Y1.class.getName().length()) | 642806622) & (-730857184);
        int length2 = (Y1.class.getName().length() & (-769654752)) | 167903361;
        int i5 = -i4;
        bArr[22] = 562953799 ^ (((~i5) & length2) - (i5 & (~length2)));
        bArr[23] = 96;
        bArr[24] = 91;
        bArr[25] = -47;
        byte[] bArr2 = new byte[26];
        long j2 = -1;
        long length3 = Y1.class.getName().length();
        long j3 = ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j4 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j5 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j6 = j5 | (j4 + j3);
        long j7 = j6 + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j8 = (j7 >>> 48) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = (j7 >>> 32) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 16) | ((((j10 >>> 4) | j10) & 16711935) << 24);
        long j15 = (j7 >>> 16) & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        long j18 = j7 & 21845;
        long j19 = ((j18 >>> 1) | j18) & 858993459;
        long j20 = ((j19 >>> 2) | j19) & 252645135;
        long j21 = -535783225;
        long j22 = ((int) ((((j20 >>> 4) | j20) & 16711935) + ((((j17 >>> 4) | j17) & 16711935) << 8) + j14)) | 1789408994;
        long j23 = (((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j24 = (j23 >>> 48) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = (j23 >>> 32) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 16) | ((((j26 >>> 4) | j26) & 16711935) << 24);
        long j31 = (j23 >>> 16) & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = j23 & 43690;
        long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        int i6 = (int) (((((j33 >>> 4) | j33) & 16711935) << 8) | j30 | (((j36 >>> 4) | j36) & 16711935));
        bArr2[D.a(i6, 3, -D1.a(i6, (Y1.class.getName().length() & (-2112845563)) | 101196048), 1) ^ (-434587177)] = 49;
        bArr2[1] = -7;
        bArr2[2] = -31;
        int f4 = ((AbstractC0008a.f(Y1.class, -1) | 886826599) & (-1557657550)) + ((Y1.class.getName().length() & (-2095048688)) | 274945);
        bArr2[E1.a(f4 | (-1557382608), -1557382608, f4)] = 3;
        bArr2[4] = -78;
        bArr2[5] = -51;
        bArr2[6] = -71;
        bArr2[7] = 101;
        bArr2[8] = 12;
        bArr2[9] = 29;
        bArr2[10] = 53;
        bArr2[11] = -94;
        bArr2[12] = 102;
        bArr2[13] = -114;
        bArr2[14] = 33;
        bArr2[15] = -95;
        bArr2[16] = 114;
        bArr2[17] = 12;
        bArr2[18] = 82;
        bArr2[19] = -72;
        long length4 = Y1.class.getName().length();
        long j37 = ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j6;
        long j38 = (j37 >>> 48) & 21845;
        long j39 = ((j38 >>> 1) | j38) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = (j37 >>> 32) & 21845;
        long j42 = ((j41 >>> 1) | j41) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) | ((((j40 >>> 4) | j40) & 16711935) << 24);
        long j45 = (j37 >>> 16) & 21845;
        long j46 = ((j45 >>> 1) | j45) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        long j48 = j37 & 21845;
        long j49 = ((j48 >>> 1) | j48) & 858993459;
        long j50 = ((j49 >>> 2) | j49) & 252645135;
        int i7 = (((int) ((((j50 >>> 4) | j50) & 16711935) + (((((j47 >>> 4) | j47) & 16711935) << 8) | j44))) | (-1510549029)) & 739409921;
        long j51 = 310395264;
        long length5 = Y1.class.getName().length() & 402653184;
        long j52 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j53 = (j52 >>> 48) & 43690;
        long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        long j56 = (j52 >>> 32) & 43690;
        long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
        long j58 = ((j57 >>> 2) | j57) & 252645135;
        long j59 = ((((j58 >>> 4) | j58) & 16711935) << 16) | ((((j55 >>> 4) | j55) & 16711935) << 24);
        long j60 = (j52 >>> 16) & 43690;
        long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
        long j62 = ((j61 >>> 2) | j61) & 252645135;
        long j63 = ((((j62 >>> 4) | j62) & 16711935) << 8) + j59;
        long j64 = j52 & 43690;
        long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
        long j66 = (j65 | (j65 >>> 2)) & 252645135;
        bArr2[1049805205 ^ (i7 + ((int) (((j66 | (j66 >>> 4)) & 16711935) + j63)))] = -115;
        bArr2[21] = 2;
        bArr2[22] = -121;
        bArr2[23] = 13;
        bArr2[24] = 62;
        bArr2[25] = -20;
        c(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr3 = new byte[7];
        bArr3[0] = -83;
        bArr3[1] = 3;
        bArr3[2] = 122;
        bArr3[3] = -110;
        bArr3[4] = -72;
        long length6 = Y1.class.getName().length();
        long j67 = j5 + (j4 | j3) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j68 = (j67 >>> 48) & 21845;
        long j69 = (j68 | (j68 >>> 1)) & 858993459;
        long j70 = (j69 | (j69 >>> 2)) & 252645135;
        long j71 = (j67 >>> 32) & 21845;
        long j72 = ((j71 >>> 1) | j71) & 858993459;
        long j73 = ((j72 >>> 2) | j72) & 252645135;
        long j74 = (((j70 | (j70 >>> 4)) & 16711935) << 24) | ((((j73 >>> 4) | j73) & 16711935) << 16);
        long j75 = (j67 >>> 16) & 21845;
        long j76 = ((j75 >>> 1) | j75) & 858993459;
        long j77 = ((j76 >>> 2) | j76) & 252645135;
        long j78 = j67 & 21845;
        long j79 = (j78 | (j78 >>> 1)) & 858993459;
        long j80 = (j79 | (j79 >>> 2)) & 252645135;
        int i8 = (int) (((j80 | (j80 >>> 4)) & 16711935) + (j74 | ((((j77 >>> 4) | j77) & 16711935) << 8)));
        int length7 = ((((-524406925) | i8) + 1342506792) - (i8 | (-255905925))) + ((Y1.class.getName().length() & (-1843855336)) | (-2112356208));
        bArr3[(((~length7) & (-769849411)) - ((-769849411) & length7)) + length7] = -72;
        bArr3[6] = -117;
        byte[] bArr4 = new byte[8];
        bArr4[0] = -127;
        int i9 = ((~Y1.class.getName().length()) | 305210206) & (-1858468655);
        long j81 = -2054552443;
        long length8 = Y1.class.getName().length();
        long j82 = (((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j83 = (j82 >>> 48) & 43690;
        long j84 = ((j83 >>> 2) | (j83 >>> 1)) & 858993459;
        long j85 = (j84 | (j84 >>> 2)) & 252645135;
        long j86 = (j82 >>> 32) & 43690;
        long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
        long j88 = ((j87 >>> 2) | j87) & 252645135;
        long j89 = ((((j88 >>> 4) | j88) & 16711935) << 16) + (((j85 | (j85 >>> 4)) & 16711935) << 24);
        long j90 = (j82 >>> 16) & 43690;
        long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
        long j92 = ((j91 >>> 2) | j91) & 252645135;
        long j93 = j82 & 43690;
        long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
        long j95 = (j94 | (j94 >>> 2)) & 252645135;
        bArr4[(-1782692652) ^ (i9 + (((int) (((j95 | (j95 >>> 4)) & 16711935) + (((((j92 >>> 4) | j92) & 16711935) << 8) | j89))) | 75776004))] = 35;
        bArr4[2] = 19;
        bArr4[3] = -4;
        bArr4[4] = -34;
        bArr4[5] = -41;
        bArr4[6] = -74;
        bArr4[7] = -23;
        c(bArr3, bArr4);
        String intern2 = new String(bArr3, charset).intern();
        byte[] bArr5 = {-115};
        c(bArr5, new byte[]{-92, -35, 46, 27, 10, -55, 3, 34});
        return intern + this.f431a + intern2 + this.f432b + new String(bArr5, charset).intern();
    }
}
