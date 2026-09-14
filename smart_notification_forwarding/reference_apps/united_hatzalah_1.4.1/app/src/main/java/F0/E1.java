package F0;

import android.R;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public abstract class E1 {
    public static int a(int i, int i3, int i4) {
        return ((i * 2) - i3) - i4;
    }

    public static final InputStream b(String str) {
        char c4 = 47866;
        InputStream inputStream = null;
        Process process = null;
        while (true) {
            if (c4 != 47866) {
                if (c4 != 6400) {
                    if (c4 != 18581) {
                        if (c4 == 29343) {
                            inputStream = process.getInputStream();
                        }
                        c4 = 6400;
                    } else {
                        c4 = 6400;
                        inputStream = null;
                    }
                } else {
                    return inputStream;
                }
            } else {
                byte[] bArr = new byte[7];
                bArr[0] = -60;
                bArr[1] = -115;
                bArr[2] = -67;
                bArr[3] = 27;
                bArr[4] = -49;
                bArr[5] = ((((~E1.class.getName().length()) | (-1721287621)) & 1142984872) + ((E1.class.getName().length() & 1409319040) | 285474880)) ^ (-1428459737);
                int i = ((~E1.class.getName().length()) | (-1539372291)) & 87361540;
                int length = (E1.class.getName().length() & 20987968) | 1648510016;
                bArr[((length & i) + (length | i)) ^ 1735871554] = 105;
                int i3 = ((~E1.class.getName().length()) | (-55994649)) & 549521280;
                int length2 = E1.class.getName().length();
                c(bArr, new byte[]{(i3 + (((length2 | (-2143158007)) - (length2 ^ (-2143158007))) | (-2147327991))) ^ (-1597806653), 13, -95, -82, 0, -108, -10, 27});
                kotlin.jvm.internal.j.e(str, new String(bArr, StandardCharsets.UTF_8).intern());
                process = Runtime.getRuntime().exec(str);
                if (process != null) {
                    c4 = 29343;
                } else {
                    c4 = 18581;
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~E1.class.getName().length();
        int length3 = (((~(((E1.class.getName().length() | 70245657) | i7) - (i7 | (E1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((E1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(E1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((E1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~E1.class.getName().length()) | (-576567005)) & 276971586) + ((E1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~E1.class.getName().length()) | (-1157759625)) & 1755853004) + ((E1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~E1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = E1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~E1.class.getName().length()) | (-1064961)) + 689325073) + ((E1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~E1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = E1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~E1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (E1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((E1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~E1.class.getName().length();
                    int length11 = (161497089 & (((((E1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((E1.class.getName().length() | i14) & 797295576))) + ((E1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~E1.class.getName().length()) | (-1085986263)) & 1078327440) + ((E1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~E1.class.getName().length();
                    int length12 = length5 >>> ((((~(((E1.class.getName().length() | 626856794) | i15) - ((E1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((E1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~E1.class.getName().length()) | 1248713193) & 826417528) + ((E1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~E1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (E1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~E1.class.getName().length()) | (-1005965450)) & 153223237) + ((E1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((E1.class.getName().length() & (~length6)) & i9)) + ((E1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~E1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((E1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~E1.class.getName().length()) | (-23496740)) & 827084804) + ((E1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~E1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (E1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~E1.class.getName().length()) | (-961655275)) & 25184460) + ((E1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~E1.class.getName().length()) | 1233459797) & 125923146) + ((E1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~E1.class.getName().length()) | (-7107622)) & 402932290) + ((E1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((E1.class.getName().length() | length15) - (b4 | length15)) + I2.a(E1.class, b4) + (E1.class.getName().length() & length15);
                    int length17 = ((((~E1.class.getName().length()) | (-81143879)) & 438583424) + ((E1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~E1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((E1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(E1.class, 568748773 | i24) + (E1.class.getName().length() & (-2105278367)))) + ((E1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~E1.class.getName().length()) | (-1592082969)) & 140665109) + ((E1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~E1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((E1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~E1.class.getName().length()) | (-180811308));
                    int length19 = (E1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((E1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | E1.class.getName().length()))));
                    int i29 = ((~E1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (E1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~E1.class.getName().length()) | 75364313) & 1242301609) + ((E1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = E1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((E1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~E1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((E1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~E1.class.getName().length();
                    int length24 = 1409942802 & (((((E1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | E1.class.getName().length()) & 91135407));
                    int length25 = (E1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~E1.class.getName().length()) | (-537919489)) - (-806798471)) + ((E1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~E1.class.getName().length()) | (-382746167)) & 102532165) + ((E1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~E1.class.getName().length()) | (-6036961)) & 1233145505) + ((E1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~E1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = E1.class.getName().length() & 268460041;
                    i5 = (((((E1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | E1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = E1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((E1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~E1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((E1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~E1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (E1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(E1.class, -1) | (-532481)) - (-67641369)) + ((E1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~E1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((E1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(E1.class, -1) | (-33554434)) - (-1107366402)) + ((E1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(E1.class, -1) | (-167014194)) & 1157999680) + ((E1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = E1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((E1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(E1.class, -1) | 114408723) & 1183666176;
                    int length33 = E1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~E1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = E1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~E1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (E1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~E1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((E1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~E1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (E1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~E1.class.getName().length()) | 991120067) & (-2113137661)) + ((E1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(E1.class, -1) | 314136709) & 371231304) + (((E1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~E1.class.getName().length()) | 366661365) & 1344150018) + ((E1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~E1.class.getName().length()) | (-1359635359)) & 49026131) + ((E1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~E1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = E1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (E1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~E1.class.getName().length()) | 1110430873) & 1241612298) + ((E1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~E1.class.getName().length()) | 1603962366) & 25199440) + (((E1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~E1.class.getName().length()) | (-1388708984)) & 706816128) + ((E1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~E1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = E1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~E1.class.getName().length()) | 2113158628) & 1026558002) + ((E1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~E1.class.getName().length()) | 715175224) & 136512788) + ((E1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~E1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = E1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~E1.class.getName().length()) | (-1084937228)) & 438503696) + ((E1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~E1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((E1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(E1.class, 1197735420 | i53) + (E1.class.getName().length() & 674349280))) + ((E1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~E1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (E1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~E1.class.getName().length()) | (-171976913)) & 318775824) + ((E1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~E1.class.getName().length()) | (-616910267)) & 1303391760) + ((E1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~E1.class.getName().length()) | 1297715640) & 556926729) + ((E1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~E1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((E1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~E1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (E1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public static final java.lang.String d(java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.E1.d(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public static final java.lang.String e(java.lang.String r47) {
        /*
            Method dump skipped, instructions count: 1619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.E1.e(java.lang.String):java.lang.String");
    }
}
