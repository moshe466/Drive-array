package F0;

import android.R;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class q3 {

    /* renamed from: a, reason: collision with root package name */
    public final String f612a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f613b;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public q3(java.lang.String r28, java.lang.String[] r29) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.q3.<init>(java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~q3.class.getName().length();
        int length3 = (((~(((q3.class.getName().length() | 70245657) | i7) - (i7 | (q3.class.getName().length() & (-70245658))))) & (-1979440632)) + ((q3.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(q3.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((q3.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~q3.class.getName().length()) | (-576567005)) & 276971586) + ((q3.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~q3.class.getName().length()) | (-1157759625)) & 1755853004) + ((q3.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~q3.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = q3.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~q3.class.getName().length()) | (-1064961)) + 689325073) + ((q3.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~q3.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = q3.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~q3.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (q3.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((q3.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~q3.class.getName().length();
                    int length11 = (161497089 & (((((q3.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((q3.class.getName().length() | i14) & 797295576))) + ((q3.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~q3.class.getName().length()) | (-1085986263)) & 1078327440) + ((q3.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~q3.class.getName().length();
                    int length12 = length5 >>> ((((~(((q3.class.getName().length() | 626856794) | i15) - ((q3.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((q3.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~q3.class.getName().length()) | 1248713193) & 826417528) + ((q3.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~q3.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (q3.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~q3.class.getName().length()) | (-1005965450)) & 153223237) + ((q3.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((q3.class.getName().length() & (~length6)) & i9)) + ((q3.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~q3.class.getName().length()) | (-30261291)) & (-1534000062)) + ((q3.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~q3.class.getName().length()) | (-23496740)) & 827084804) + ((q3.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~q3.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (q3.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~q3.class.getName().length()) | (-961655275)) & 25184460) + ((q3.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~q3.class.getName().length()) | 1233459797) & 125923146) + ((q3.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~q3.class.getName().length()) | (-7107622)) & 402932290) + ((q3.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((q3.class.getName().length() | length15) - (b4 | length15)) + I2.a(q3.class, b4) + (q3.class.getName().length() & length15);
                    int length17 = ((((~q3.class.getName().length()) | (-81143879)) & 438583424) + ((q3.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~q3.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((q3.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(q3.class, 568748773 | i24) + (q3.class.getName().length() & (-2105278367)))) + ((q3.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~q3.class.getName().length()) | (-1592082969)) & 140665109) + ((q3.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~q3.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((q3.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~q3.class.getName().length()) | (-180811308));
                    int length19 = (q3.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((q3.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | q3.class.getName().length()))));
                    int i29 = ((~q3.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (q3.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~q3.class.getName().length()) | 75364313) & 1242301609) + ((q3.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = q3.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((q3.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~q3.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((q3.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~q3.class.getName().length();
                    int length24 = 1409942802 & (((((q3.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | q3.class.getName().length()) & 91135407));
                    int length25 = (q3.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~q3.class.getName().length()) | (-537919489)) - (-806798471)) + ((q3.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~q3.class.getName().length()) | (-382746167)) & 102532165) + ((q3.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~q3.class.getName().length()) | (-6036961)) & 1233145505) + ((q3.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~q3.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = q3.class.getName().length() & 268460041;
                    i5 = (((((q3.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | q3.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = q3.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((q3.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~q3.class.getName().length()) | (-1883938358)) & (-738125179)) + ((q3.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~q3.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (q3.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(q3.class, -1) | (-532481)) - (-67641369)) + ((q3.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~q3.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((q3.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(q3.class, -1) | (-33554434)) - (-1107366402)) + ((q3.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(q3.class, -1) | (-167014194)) & 1157999680) + ((q3.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = q3.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((q3.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(q3.class, -1) | 114408723) & 1183666176;
                    int length33 = q3.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~q3.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = q3.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~q3.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (q3.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~q3.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((q3.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~q3.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (q3.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~q3.class.getName().length()) | 991120067) & (-2113137661)) + ((q3.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(q3.class, -1) | 314136709) & 371231304) + (((q3.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~q3.class.getName().length()) | 366661365) & 1344150018) + ((q3.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~q3.class.getName().length()) | (-1359635359)) & 49026131) + ((q3.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~q3.class.getName().length();
                    if (length3 > 0) {
                        int length38 = q3.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (q3.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~q3.class.getName().length()) | 1110430873) & 1241612298) + ((q3.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~q3.class.getName().length()) | 1603962366) & 25199440) + (((q3.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~q3.class.getName().length()) | (-1388708984)) & 706816128) + ((q3.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~q3.class.getName().length()) | 367288948) & 548745488;
                    int length41 = q3.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~q3.class.getName().length()) | 2113158628) & 1026558002) + ((q3.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~q3.class.getName().length()) | 715175224) & 136512788) + ((q3.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~q3.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = q3.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~q3.class.getName().length()) | (-1084937228)) & 438503696) + ((q3.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~q3.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((q3.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(q3.class, 1197735420 | i53) + (q3.class.getName().length() & 674349280))) + ((q3.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~q3.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (q3.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~q3.class.getName().length()) | (-171976913)) & 318775824) + ((q3.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~q3.class.getName().length()) | (-616910267)) & 1303391760) + ((q3.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~q3.class.getName().length()) | 1297715640) & 556926729) + ((q3.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~q3.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((q3.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~q3.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (q3.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0012. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean equals(Object obj) {
        byte b4;
        byte b5 = 0;
        String[] strArr = new String[0];
        char c4 = 27478;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        while (true) {
            Class<?> cls = null;
            while (true) {
                switch (c4) {
                    case 12230:
                        b4 = b5;
                        if (!Arrays.equals(strArr, ((q3) obj).f613b)) {
                            c4 = 31743;
                            b5 = b4;
                        }
                        c4 = 58174;
                        b5 = b4;
                    case 19351:
                    case 31743:
                    case 5406:
                    case 5327:
                    case 3854:
                        return b5;
                    case 17986:
                        b4 = b5;
                        c4 = ((q3) obj2).f613b == null ? (char) 19351 : (char) 45974;
                        b5 = b4;
                    case 59813:
                        b4 = b5;
                        c4 = obj != null ? (char) 4811 : (char) 6638;
                        obj3 = obj;
                        obj4 = q3.class;
                        b5 = b4;
                    case 4811:
                        cls = obj3.getClass();
                        c4 = 37862;
                        obj5 = obj4;
                    case 1407:
                        byte[] bArr = new byte[79];
                        bArr[b5] = 12;
                        bArr[1] = 106;
                        bArr[2] = 62;
                        b4 = b5;
                        bArr[3] = ((((~q3.class.getName().length()) | (-487944346)) & 1615398299) + ((q3.class.getName().length() & 53551293) | 53485668)) ^ (-1668883931);
                        bArr[4] = -112;
                        bArr[((((~q3.class.getName().length()) | 1688113919) & 1279112) + ((q3.class.getName().length() & 201393216) | 205525058)) ^ 206804175] = 122;
                        bArr[6] = -90;
                        bArr[7] = 77;
                        bArr[8] = 70;
                        bArr[9] = -47;
                        bArr[10] = -7;
                        bArr[11] = 92;
                        bArr[12] = -66;
                        bArr[13] = 75;
                        bArr[14] = 3;
                        bArr[15] = 121;
                        long j2 = -1;
                        long length = q3.class.getName().length();
                        long j3 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                        long j4 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                        long j5 = j4 | j3;
                        long j6 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j7 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j8 = j7 + (j6 | j5) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                        long j9 = (j8 >>> 48) & 21845;
                        long j10 = ((j9 >>> 1) | j9) & 858993459;
                        long j11 = ((j10 >>> 2) | j10) & 252645135;
                        long j12 = (j8 >>> 32) & 21845;
                        long j13 = ((j12 >>> 1) | j12) & 858993459;
                        long j14 = ((j13 >>> 2) | j13) & 252645135;
                        long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) + ((((j11 >>> 4) | j11) & 16711935) << 24);
                        long j16 = (j8 >>> 16) & 21845;
                        long j17 = ((j16 >>> 1) | j16) & 858993459;
                        long j18 = ((j17 >>> 2) | j17) & 252645135;
                        long j19 = j8 & 21845;
                        long j20 = ((j19 >>> 1) | j19) & 858993459;
                        long j21 = ((j20 >>> 2) | j20) & 252645135;
                        bArr[16] = (((((int) ((((j21 >>> 4) | j21) & 16711935) | (((((j18 >>> 4) | j18) & 16711935) << 8) + j15))) | 46779342) & 82051976) + ((q3.class.getName().length() & 69484576) | 537944160)) ^ (-619996088);
                        bArr[17] = 65;
                        bArr[18] = 118;
                        bArr[19] = -111;
                        int length2 = (((~q3.class.getName().length()) | 258732615) & 142647480) + ((q3.class.getName().length() & 42467516) | 34078726);
                        bArr[20] = (length2 + 176726161) - ((length2 & 176726161) * 2);
                        bArr[21] = -44;
                        bArr[22] = 14;
                        bArr[23] = 102;
                        bArr[24] = 102;
                        bArr[25] = -38;
                        bArr[26] = 6;
                        bArr[27] = 26;
                        bArr[28] = -7;
                        bArr[29] = -5;
                        bArr[30] = -46;
                        bArr[31] = -91;
                        bArr[32] = -121;
                        bArr[33] = -103;
                        bArr[34] = 84;
                        bArr[35] = 106;
                        int length3 = (((~q3.class.getName().length()) | (-76789027)) & (-2134900159)) + ((q3.class.getName().length() & 8421376) | 1611694338);
                        bArr[((length3 & 523205784) * 2) + ((-523205785) - length3)] = b4;
                        bArr[37] = -102;
                        bArr[38] = -39;
                        int i = ~q3.class.getName().length();
                        long j22 = 1142949901;
                        long j23 = i + (((-i) - 1) | (-2142930734)) + 2142930734;
                        long j24 = ((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j25 = (j24 >>> 48) & 43690;
                        long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                        long j27 = ((j26 >>> 2) | j26) & 252645135;
                        long j28 = (j24 >>> 32) & 43690;
                        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                        long j30 = ((j29 >>> 2) | j29) & 252645135;
                        long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) | ((((j27 >>> 4) | j27) & 16711935) << 24);
                        long j32 = (j24 >>> 16) & 43690;
                        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                        long j34 = ((j33 >>> 2) | j33) & 252645135;
                        long j35 = ((((j34 >>> 4) | j34) & 16711935) << 8) + j31;
                        long j36 = j24 & 43690;
                        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                        long j38 = (j37 | (j37 >>> 2)) & 252645135;
                        int length4 = ((int) (((j38 | (j38 >>> 4)) & 16711935) | j35)) + (((q3.class.getName().length() | (-6225)) + 6225) | (-2145906096));
                        bArr[B0.a((~length4) | (-1002956166), (-1002956166) - length4)] = 29;
                        bArr[40] = -83;
                        bArr[41] = 59;
                        bArr[42] = -74;
                        bArr[43] = 75;
                        bArr[44] = 26;
                        bArr[45] = -77;
                        bArr[46] = -14;
                        bArr[47] = -108;
                        bArr[48] = -43;
                        bArr[49] = 113;
                        bArr[50] = -53;
                        bArr[51] = 61;
                        bArr[52] = 91;
                        long j39 = 1478023985;
                        long length5 = (((~q3.class.getName().length()) | 1239424958) & (-2090523565)) + ((q3.class.getName().length() & (-1568333627)) | 612499588);
                        long j40 = (((((((((j39 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j39 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j39 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j39 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j41 = (j40 >>> 48) & 21845;
                        long j42 = ((j41 >>> 1) | j41) & 858993459;
                        long j43 = ((j42 >>> 2) | j42) & 252645135;
                        long j44 = (j40 >>> 32) & 21845;
                        long j45 = ((j44 >>> 1) | j44) & 858993459;
                        long j46 = ((j45 >>> 2) | j45) & 252645135;
                        long j47 = ((((j46 >>> 4) | j46) & 16711935) << 16) | ((((j43 >>> 4) | j43) & 16711935) << 24);
                        long j48 = (j40 >>> 16) & 21845;
                        long j49 = ((j48 >>> 1) | j48) & 858993459;
                        long j50 = ((j49 >>> 2) | j49) & 252645135;
                        long j51 = j40 & 21845;
                        long j52 = ((j51 >>> 1) | j51) & 858993459;
                        long j53 = ((j52 >>> 2) | j52) & 252645135;
                        bArr[53] = (int) (((((j50 >>> 4) | j50) & 16711935) << 8) | j47 | (((j53 >>> 4) | j53) & 16711935));
                        bArr[54] = -56;
                        bArr[55] = -47;
                        bArr[56] = 18;
                        bArr[57] = 28;
                        bArr[58] = -75;
                        bArr[59] = 35;
                        bArr[60] = 59;
                        bArr[61] = 100;
                        bArr[62] = -73;
                        bArr[63] = -18;
                        bArr[64] = -127;
                        bArr[65] = 7;
                        int length6 = q3.class.getName().length();
                        int i3 = ((~length6) - length6) + length6;
                        int i4 = i3 + (((-i3) - 1) | (-1045673180)) + 1045673180;
                        int i5 = (1745116168 | i4) - (i4 ^ 1745116168);
                        long j54 = 1075145025;
                        long length7 = q3.class.getName().length();
                        long j55 = (((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j56 = (j55 >>> 48) & 43690;
                        long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
                        long j58 = ((j57 >>> 2) | j57) & 252645135;
                        long j59 = (j55 >>> 32) & 43690;
                        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                        long j61 = ((j60 >>> 2) | j60) & 252645135;
                        long j62 = ((((j61 >>> 4) | j61) & 16711935) << 16) | ((((j58 >>> 4) | j58) & 16711935) << 24);
                        long j63 = (j55 >>> 16) & 43690;
                        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
                        long j65 = ((j64 >>> 2) | j64) & 252645135;
                        long j66 = ((((j65 >>> 4) | j65) & 16711935) << 8) + j62;
                        long j67 = j55 & 43690;
                        long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                        long j69 = (j68 | (j68 >>> 2)) & 252645135;
                        bArr[(i5 + (((int) (((j69 | (j69 >>> 4)) & 16711935) | j66)) | 1122625)) ^ 1746238731] = -124;
                        int i6 = ~q3.class.getName().length();
                        int length8 = ((q3.class.getName().length() | 373494144) - (i6 | (-564151329))) + I2.a(q3.class, (-601900449) | i6) + (q3.class.getName().length() & 373494144);
                        long j70 = 2622482;
                        long length9 = q3.class.getName().length() & 39847314;
                        long b6 = c3.b((((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                        long j71 = (b6 >>> 48) & 43690;
                        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                        long j73 = ((j72 >>> 2) | j72) & 252645135;
                        long j74 = (b6 >>> 32) & 43690;
                        long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                        long j76 = ((j75 >>> 2) | j75) & 252645135;
                        long j77 = ((((j76 >>> 4) | j76) & 16711935) << 16) | ((((j73 >>> 4) | j73) & 16711935) << 24);
                        long j78 = (b6 >>> 16) & 43690;
                        long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                        long j80 = ((j79 >>> 2) | j79) & 252645135;
                        long j81 = b6 & 43690;
                        long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                        long j83 = ((j82 >>> 2) | j82) & 252645135;
                        bArr[376116689 ^ (length8 + ((int) ((((j83 >>> 4) | j83) & 16711935) | (((((j80 >>> 4) | j80) & 16711935) << 8) | j77))))] = 53;
                        bArr[68] = -29;
                        bArr[69] = -126;
                        bArr[70] = 122;
                        bArr[71] = -53;
                        int i7 = ((~q3.class.getName().length()) | (-1385582433)) & (-230006752);
                        int length10 = q3.class.getName().length();
                        long j84 = -209788820;
                        long j85 = i7 + (20217860 | ((1378009124 | length10) - (length10 ^ 1378009124)));
                        long j86 = (((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j87 = (j86 >>> 48) & 21845;
                        long j88 = ((j87 >>> 1) | j87) & 858993459;
                        long j89 = ((j88 >>> 2) | j88) & 252645135;
                        long j90 = (j86 >>> 32) & 21845;
                        long j91 = ((j90 >>> 1) | j90) & 858993459;
                        long j92 = ((j91 >>> 2) | j91) & 252645135;
                        long j93 = ((((j92 >>> 4) | j92) & 16711935) << 16) | ((((j89 >>> 4) | j89) & 16711935) << 24);
                        long j94 = (j86 >>> 16) & 21845;
                        long j95 = ((j94 >>> 1) | j94) & 858993459;
                        long j96 = ((j95 >>> 2) | j95) & 252645135;
                        long j97 = j86 & 21845;
                        long j98 = ((j97 >>> 1) | j97) & 858993459;
                        long j99 = ((j98 >>> 2) | j98) & 252645135;
                        bArr[(int) ((((j99 >>> 4) | j99) & 16711935) + (((((j96 >>> 4) | j96) & 16711935) << 8) | j93))] = -18;
                        bArr[73] = 84;
                        bArr[74] = -124;
                        bArr[75] = -59;
                        bArr[76] = 112;
                        bArr[77] = 33;
                        bArr[78] = -45;
                        byte[] bArr2 = new byte[79];
                        bArr2[b4] = 98;
                        bArr2[1] = 31;
                        int i8 = ((~q3.class.getName().length()) | 419059455) & 306329605;
                        long j100 = 33564680;
                        long length11 = q3.class.getName().length();
                        long j101 = ((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j102 = (j101 >>> 48) & 43690;
                        long j103 = ((j102 >>> 2) | (j102 >>> 1)) & 858993459;
                        long j104 = ((j103 >>> 2) | j103) & 252645135;
                        long j105 = (j101 >>> 32) & 43690;
                        long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
                        long j107 = ((j106 >>> 2) | j106) & 252645135;
                        long j108 = ((((j107 >>> 4) | j107) & 16711935) << 16) + ((((j104 >>> 4) | j104) & 16711935) << 24);
                        long j109 = (j101 >>> 16) & 43690;
                        long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
                        long j111 = ((j110 >>> 2) | j110) & 252645135;
                        long j112 = j101 & 43690;
                        long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
                        long j114 = ((j113 >>> 2) | j113) & 252645135;
                        int i9 = (int) ((((j114 >>> 4) | j114) & 16711935) + (((((j111 >>> 4) | j111) & 16711935) << 8) | j108));
                        int i10 = (1073774650 ^ i9) + (i9 & 1073774650);
                        bArr2[D.a(i8, 3, -((i10 & 2) | D1.a(i8, i10)), 1) ^ 1380104253] = 82;
                        bArr2[3] = -74;
                        bArr2[4] = -80;
                        bArr2[5] = 25;
                        bArr2[6] = -57;
                        bArr2[7] = 35;
                        bArr2[8] = 40;
                        bArr2[9] = -66;
                        bArr2[10] = -115;
                        bArr2[11] = 124;
                        bArr2[12] = -36;
                        int i11 = ~q3.class.getName().length();
                        int length12 = q3.class.getName().length();
                        bArr2[13] = (((-532334286) & (((-763595394) + i11) - (i11 & (-763595394)))) + (355501133 | ((605097025 | length12) - (length12 ^ 605097025)))) ^ (-176833199);
                        bArr2[14] = 35;
                        bArr2[15] = 26;
                        bArr2[16] = -63;
                        bArr2[17] = 50;
                        int i12 = ((~q3.class.getName().length()) | 112182678) & 378198;
                        long j115 = -1006628128;
                        long length13 = q3.class.getName().length();
                        long j116 = ((((((((j115 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j115 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j115 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j115 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length13 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length13 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length13 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length13 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j117 = (j116 >>> 48) & 43690;
                        long j118 = ((j117 >>> 2) | (j117 >>> 1)) & 858993459;
                        long j119 = ((j118 >>> 2) | j118) & 252645135;
                        long j120 = (j116 >>> 32) & 43690;
                        long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
                        long j122 = ((j121 >>> 2) | j121) & 252645135;
                        long j123 = ((((j122 >>> 4) | j122) & 16711935) << 16) | ((((j119 >>> 4) | j119) & 16711935) << 24);
                        long j124 = (j116 >>> 16) & 43690;
                        long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
                        long j126 = ((j125 >>> 2) | j125) & 252645135;
                        long j127 = j116 & 43690;
                        long j128 = ((j127 >>> 2) | (j127 >>> 1)) & 858993459;
                        long j129 = ((j128 >>> 2) | j128) & 252645135;
                        bArr2[(i12 + (((int) ((((((j126 >>> 4) | j126) & 16711935) << 8) | j123) | (((j129 >>> 4) | j129) & 16711935))) | (-1002425696))) ^ (-1002047516)] = 2;
                        bArr2[19] = -79;
                        bArr2[20] = 91;
                        bArr2[21] = -69;
                        bArr2[22] = 46;
                        bArr2[23] = 8;
                        bArr2[24] = 9;
                        bArr2[25] = ((((~q3.class.getName().length()) | (-5)) - (-54341)) + ((q3.class.getName().length() & 22) | 1073743922)) ^ (-1073798206);
                        bArr2[26] = 43;
                        bArr2[27] = 116;
                        bArr2[28] = -116;
                        bArr2[29] = -105;
                        bArr2[((((~q3.class.getName().length()) | (-233653155)) & (-1536617388)) + ((q3.class.getName().length() & 208209921) | 151005345)) ^ (-1385612053)] = -66;
                        bArr2[31] = -123;
                        bArr2[32] = -13;
                        bArr2[33] = -32;
                        bArr2[34] = 36;
                        bArr2[35] = 15;
                        bArr2[36] = 32;
                        int i13 = ~q3.class.getName().length();
                        long j130 = 8459676;
                        long length14 = ((((q3.class.getName().length() & (~i13)) & 1086897385) + 1086897385) + i13) - ((i13 | q3.class.getName().length()) & 1086897385);
                        long j131 = ((((((((j130 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j130 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j130 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j130 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length14 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length14 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length14 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length14 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j132 = (j131 >>> 48) & 43690;
                        long j133 = ((j132 >>> 2) | (j132 >>> 1)) & 858993459;
                        long j134 = ((j133 >>> 2) | j133) & 252645135;
                        long j135 = (j131 >>> 32) & 43690;
                        long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
                        long j137 = ((j136 >>> 2) | j136) & 252645135;
                        long j138 = ((((j137 >>> 4) | j137) & 16711935) << 16) + ((((j134 >>> 4) | j134) & 16711935) << 24);
                        long j139 = (j131 >>> 16) & 43690;
                        long j140 = ((j139 >>> 2) | (j139 >>> 1)) & 858993459;
                        long j141 = ((j140 >>> 2) | j140) & 252645135;
                        long j142 = j131 & 43690;
                        long j143 = ((j142 >>> 2) | (j142 >>> 1)) & 858993459;
                        long j144 = ((j143 >>> 2) | j143) & 252645135;
                        int i14 = (int) (((((j141 >>> 4) | j141) & 16711935) << 8) | j138 | (((j144 >>> 4) | j144) & 16711935));
                        int length15 = q3.class.getName().length();
                        bArr2[(i14 + (184549890 | ((33620244 + length15) - (length15 | 33620244)))) ^ 193009595] = -5;
                        int length16 = (((~q3.class.getName().length()) | 1936169247) & 4394004) + ((q3.class.getName().length() & 67372320) | 202129696);
                        long length17 = q3.class.getName().length();
                        long j145 = (j7 | (j6 + j5)) + ((((((((length17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j146 = (j145 >>> 48) & 21845;
                        long j147 = ((j146 >>> 1) | j146) & 858993459;
                        long j148 = ((j147 >>> 2) | j147) & 252645135;
                        long j149 = (j145 >>> 32) & 21845;
                        long j150 = ((j149 >>> 1) | j149) & 858993459;
                        long j151 = ((j150 >>> 2) | j150) & 252645135;
                        long j152 = ((((j151 >>> 4) | j151) & 16711935) << 16) + ((((j148 >>> 4) | j148) & 16711935) << 24);
                        long j153 = (j145 >>> 16) & 21845;
                        long j154 = ((j153 >>> 1) | j153) & 858993459;
                        long j155 = ((j154 >>> 2) | j154) & 252645135;
                        long j156 = j145 & 21845;
                        long j157 = ((j156 >>> 1) | j156) & 858993459;
                        long j158 = ((j157 >>> 2) | j157) & 252645135;
                        int i15 = (int) ((((j158 >>> 4) | j158) & 16711935) + ((((j155 >>> 4) | j155) & 16711935) << 8) + j152);
                        bArr2[((length16 & (-206523667)) * 2) + (206523666 - length16)] = ((639510600 & (((-1225350923) ^ i15) + (i15 & (-1225350923)))) + ((q3.class.getName().length() & 1093143048) | 1092716288)) ^ (-1732226847);
                        bArr2[39] = 109;
                        bArr2[40] = -125;
                        bArr2[41] = 79;
                        bArr2[42] = -41;
                        bArr2[43] = 39;
                        bArr2[44] = 105;
                        int i16 = ~q3.class.getName().length();
                        bArr2[((1373241344 & (((-1052184) + i16) - (i16 & (-1052184)))) + ((q3.class.getName().length() & 1048656) | 706740568)) ^ 2079981941] = -42;
                        bArr2[46] = -111;
                        bArr2[47] = -70;
                        bArr2[48] = -89;
                        bArr2[49] = 16;
                        bArr2[50] = -72;
                        bArr2[51] = 77;
                        int i17 = ((~q3.class.getName().length()) | 101574520) & 304881921;
                        int length18 = (q3.class.getName().length() & (-1876918231)) | (-2147449816);
                        int i18 = -i17;
                        bArr2[(-1842567907) ^ (((~i18) & length18) - (i18 & (~length18)))] = 117;
                        bArr2[53] = -107;
                        bArr2[54] = -83;
                        bArr2[55] = -78;
                        bArr2[56] = 103;
                        bArr2[57] = 110;
                        bArr2[58] = -36;
                        bArr2[59] = 87;
                        bArr2[60] = 66;
                        bArr2[61] = 74;
                        bArr2[62] = -46;
                        bArr2[63] = -125;
                        bArr2[64] = -12;
                        bArr2[65] = 107;
                        bArr2[66] = -27;
                        long length19 = q3.class.getName().length();
                        long j159 = (j7 | j6 | (j4 + j3)) + (((((((((length19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                        long j160 = (j159 >>> 48) & 21845;
                        long j161 = ((j160 >>> 1) | j160) & 858993459;
                        long j162 = ((j161 >>> 2) | j161) & 252645135;
                        long j163 = (j159 >>> 32) & 21845;
                        long j164 = ((j163 >>> 1) | j163) & 858993459;
                        long j165 = ((j164 >>> 2) | j164) & 252645135;
                        long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) | ((((j162 >>> 4) | j162) & 16711935) << 24);
                        long j167 = (j159 >>> 16) & 21845;
                        long j168 = ((j167 >>> 1) | j167) & 858993459;
                        long j169 = ((j168 >>> 2) | j168) & 252645135;
                        long j170 = j159 & 21845;
                        long j171 = ((j170 >>> 1) | j170) & 858993459;
                        long j172 = ((j171 >>> 2) | j171) & 252645135;
                        int i19 = (((int) ((((j172 >>> 4) | j172) & 16711935) + (((((j169 >>> 4) | j169) & 16711935) << 8) | j166))) | (-220809291)) & (-1869585918);
                        int length20 = q3.class.getName().length();
                        int i20 = i19 + (201459729 | ((67258386 + length20) - (length20 | 67258386)));
                        bArr2[E1.a((-1668126128) | i20, -1668126128, i20)] = 65;
                        bArr2[68] = -116;
                        bArr2[69] = -16;
                        bArr2[70] = 84;
                        bArr2[71] = -101;
                        bArr2[72] = -100;
                        bArr2[73] = 59;
                        int i21 = ((~q3.class.getName().length()) | (-180562957)) & 545349187;
                        long j173 = 8457360;
                        long length21 = q3.class.getName().length();
                        long j174 = (((((((((j173 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j173 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j173 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j173 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j175 = (j174 >>> 48) & 43690;
                        long j176 = ((j175 >>> 2) | (j175 >>> 1)) & 858993459;
                        long j177 = (j176 | (j176 >>> 2)) & 252645135;
                        long j178 = (j174 >>> 32) & 43690;
                        long j179 = ((j178 >>> 2) | (j178 >>> 1)) & 858993459;
                        long j180 = ((j179 >>> 2) | j179) & 252645135;
                        long j181 = (((j177 | (j177 >>> 4)) & 16711935) << 24) | ((((j180 >>> 4) | j180) & 16711935) << 16);
                        long j182 = (j174 >>> 16) & 43690;
                        long j183 = ((j182 >>> 2) | (j182 >>> 1)) & 858993459;
                        long j184 = ((j183 >>> 2) | j183) & 252645135;
                        long j185 = j174 & 43690;
                        long j186 = ((j185 >>> 2) | (j185 >>> 1)) & 858993459;
                        long j187 = (j186 | (j186 >>> 2)) & 252645135;
                        bArr2[(i21 + (((int) (((j187 | (j187 >>> 4)) & 16711935) + (j181 | ((((j184 >>> 4) | j184) & 16711935) << 8)))) | 1074561204)) ^ 1619910333] = -12;
                        bArr2[75] = -96;
                        bArr2[76] = 2;
                        bArr2[77] = 85;
                        bArr2[78] = -86;
                        b(bArr, bArr2);
                        kotlin.jvm.internal.j.c(obj, new String(bArr, StandardCharsets.UTF_8).intern());
                        c4 = !kotlin.jvm.internal.j.a(this.f612a, ((q3) obj).f612a) ? (char) 3854 : (char) 60271;
                        b5 = b4;
                    case 37862:
                        c4 = !kotlin.jvm.internal.j.a(obj5, cls) ? (char) 5406 : (char) 1407;
                    case 60271:
                        c4 = this.f613b != null ? (char) 63333 : (char) 36249;
                    case 20992:
                    case 58174:
                        return true;
                    case 36249:
                        if (((q3) obj).f613b != null) {
                            c4 = 5327;
                        } else {
                            b4 = b5;
                            c4 = 58174;
                            b5 = b4;
                        }
                    case 63333:
                        c4 = 17986;
                        obj2 = obj;
                    case 6638:
                        break;
                    case 45974:
                        strArr = this.f613b;
                        c4 = 12230;
                    case 27478:
                        c4 = this == obj ? (char) 20992 : (char) 59813;
                    default:
                        c4 = 5327;
                }
            }
            c4 = 37862;
            obj5 = obj4;
        }
    }

    public final int hashCode() {
        String[] strArr = new String[0];
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        char c4 = 54166;
        while (true) {
            if (c4 != 54166) {
                if (c4 != 24204) {
                    if (c4 != 12494) {
                        if (c4 == 48344) {
                            return i3 + i4;
                        }
                        c4 = 24204;
                    } else {
                        i4 = 0;
                    }
                } else {
                    i4 = Arrays.hashCode(strArr);
                }
                i3 = i;
                c4 = 48344;
            } else {
                i = this.f612a.hashCode() * 31;
                strArr = this.f613b;
                if (strArr != null) {
                    c4 = 24204;
                } else {
                    c4 = 12494;
                }
            }
        }
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f613b);
        byte[] bArr = new byte[14];
        bArr[0] = 59;
        bArr[1] = 46;
        bArr[2] = 35;
        bArr[3] = 115;
        bArr[4] = 81;
        int i = ~q3.class.getName().length();
        bArr[(((i | 1902550783) - ((1902550771 | i) ^ 1097075805)) + ((q3.class.getName().length() & (-2013265650)) | (-1711247070))) ^ (-614171270)] = -24;
        bArr[6] = 125;
        bArr[7] = 30;
        bArr[8] = 124;
        bArr[9] = 78;
        bArr[10] = 71;
        bArr[11] = 71;
        bArr[12] = 70;
        bArr[13] = -95;
        a(bArr, new byte[]{75, -100, 35, -56, -62, 48, 84, 84, 39, 2, 80, -110, -36, -59});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        int length = q3.class.getName().length();
        int length2 = (q3.class.getName().length() & 8413312) | 11028496;
        int i3 = -(((1219990886 - length) - (((-1) - length) & 1219990887)) & 135307425);
        byte[] bArr2 = {-90, 41, (-146335995) ^ (((~i3) & length2) - ((~length2) & i3)), 85, -102, -116, -57, -13};
        a(bArr2, new byte[]{-4, -67, 73, 98, -75, 26, 113, -58});
        String intern2 = new String(bArr2, charset).intern();
        byte[] bArr3 = {10};
        a(bArr3, new byte[]{-51, 35, 55, -96, 47, -13, 27, -55});
        return intern + this.f612a + intern2 + arrays + new String(bArr3, charset).intern();
    }
}
