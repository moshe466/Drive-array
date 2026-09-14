package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class B2 implements J {

    /* renamed from: a, reason: collision with root package name */
    public final String f172a;

    /* renamed from: b, reason: collision with root package name */
    public final String f173b;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public B2(java.lang.String r48, java.lang.String r49) {
        /*
            Method dump skipped, instructions count: 1356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.B2.<init>(java.lang.String, java.lang.String):void");
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
        int i7 = ~B2.class.getName().length();
        int length3 = (((~(((B2.class.getName().length() | 70245657) | i7) - (i7 | (B2.class.getName().length() & (-70245658))))) & (-1979440632)) + ((B2.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(B2.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((B2.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~B2.class.getName().length()) | (-576567005)) & 276971586) + ((B2.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~B2.class.getName().length()) | (-1157759625)) & 1755853004) + ((B2.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~B2.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = B2.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~B2.class.getName().length()) | (-1064961)) + 689325073) + ((B2.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~B2.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = B2.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~B2.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (B2.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((B2.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~B2.class.getName().length();
                    int length11 = (161497089 & (((((B2.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((B2.class.getName().length() | i14) & 797295576))) + ((B2.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~B2.class.getName().length()) | (-1085986263)) & 1078327440) + ((B2.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~B2.class.getName().length();
                    int length12 = length5 >>> ((((~(((B2.class.getName().length() | 626856794) | i15) - ((B2.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((B2.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~B2.class.getName().length()) | 1248713193) & 826417528) + ((B2.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~B2.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (B2.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~B2.class.getName().length()) | (-1005965450)) & 153223237) + ((B2.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((B2.class.getName().length() & (~length6)) & i9)) + ((B2.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~B2.class.getName().length()) | (-30261291)) & (-1534000062)) + ((B2.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~B2.class.getName().length()) | (-23496740)) & 827084804) + ((B2.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~B2.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (B2.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~B2.class.getName().length()) | (-961655275)) & 25184460) + ((B2.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~B2.class.getName().length()) | 1233459797) & 125923146) + ((B2.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~B2.class.getName().length()) | (-7107622)) & 402932290) + ((B2.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((B2.class.getName().length() | length15) - (b4 | length15)) + I2.a(B2.class, b4) + (B2.class.getName().length() & length15);
                    int length17 = ((((~B2.class.getName().length()) | (-81143879)) & 438583424) + ((B2.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~B2.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((B2.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(B2.class, 568748773 | i24) + (B2.class.getName().length() & (-2105278367)))) + ((B2.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~B2.class.getName().length()) | (-1592082969)) & 140665109) + ((B2.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~B2.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((B2.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~B2.class.getName().length()) | (-180811308));
                    int length19 = (B2.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((B2.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | B2.class.getName().length()))));
                    int i29 = ((~B2.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (B2.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~B2.class.getName().length()) | 75364313) & 1242301609) + ((B2.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = B2.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((B2.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~B2.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((B2.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~B2.class.getName().length();
                    int length24 = 1409942802 & (((((B2.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | B2.class.getName().length()) & 91135407));
                    int length25 = (B2.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~B2.class.getName().length()) | (-537919489)) - (-806798471)) + ((B2.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~B2.class.getName().length()) | (-382746167)) & 102532165) + ((B2.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~B2.class.getName().length()) | (-6036961)) & 1233145505) + ((B2.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~B2.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = B2.class.getName().length() & 268460041;
                    i5 = (((((B2.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | B2.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = B2.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((B2.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~B2.class.getName().length()) | (-1883938358)) & (-738125179)) + ((B2.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~B2.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (B2.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(B2.class, -1) | (-532481)) - (-67641369)) + ((B2.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~B2.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((B2.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(B2.class, -1) | (-33554434)) - (-1107366402)) + ((B2.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(B2.class, -1) | (-167014194)) & 1157999680) + ((B2.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = B2.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((B2.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(B2.class, -1) | 114408723) & 1183666176;
                    int length33 = B2.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~B2.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = B2.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~B2.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (B2.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~B2.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((B2.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~B2.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (B2.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~B2.class.getName().length()) | 991120067) & (-2113137661)) + ((B2.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(B2.class, -1) | 314136709) & 371231304) + (((B2.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~B2.class.getName().length()) | 366661365) & 1344150018) + ((B2.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~B2.class.getName().length()) | (-1359635359)) & 49026131) + ((B2.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~B2.class.getName().length();
                    if (length3 > 0) {
                        int length38 = B2.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (B2.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~B2.class.getName().length()) | 1110430873) & 1241612298) + ((B2.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~B2.class.getName().length()) | 1603962366) & 25199440) + (((B2.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~B2.class.getName().length()) | (-1388708984)) & 706816128) + ((B2.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~B2.class.getName().length()) | 367288948) & 548745488;
                    int length41 = B2.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~B2.class.getName().length()) | 2113158628) & 1026558002) + ((B2.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~B2.class.getName().length()) | 715175224) & 136512788) + ((B2.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~B2.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = B2.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~B2.class.getName().length()) | (-1084937228)) & 438503696) + ((B2.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~B2.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((B2.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(B2.class, 1197735420 | i53) + (B2.class.getName().length() & 674349280))) + ((B2.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~B2.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (B2.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~B2.class.getName().length()) | (-171976913)) & 318775824) + ((B2.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~B2.class.getName().length()) | (-616910267)) & 1303391760) + ((B2.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~B2.class.getName().length()) | 1297715640) & 556926729) + ((B2.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~B2.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((B2.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~B2.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (B2.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
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

    @Override // F0.J
    public final void a(JSONObject jSONObject) {
        int i = ~B2.class.getName().length();
        byte[] bArr = new byte[(((i | (-1373657674)) - (((-1440766540) | i) ^ 67502482)) + ((B2.class.getName().length() & 1158676482) | 1091586056)) ^ 1159088542];
        bArr[0] = 83;
        bArr[1] = -87;
        bArr[2] = 123;
        bArr[3] = -5;
        byte[] bArr2 = new byte[8];
        bArr2[0] = 101;
        long j2 = -1;
        long length = B2.class.getName().length();
        long j3 = ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j5 = j4 + j3 + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j6 = (j5 >>> 48) & 21845;
        long j7 = ((j6 >>> 1) | j6) & 858993459;
        long j8 = ((j7 >>> 2) | j7) & 252645135;
        long j9 = (j5 >>> 32) & 21845;
        long j10 = ((j9 >>> 1) | j9) & 858993459;
        long j11 = ((j10 >>> 2) | j10) & 252645135;
        long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
        long j13 = (j5 >>> 16) & 21845;
        long j14 = ((j13 >>> 1) | j13) & 858993459;
        long j15 = ((j14 >>> 2) | j14) & 252645135;
        long j16 = j5 & 21845;
        long j17 = ((j16 >>> 1) | j16) & 858993459;
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        long j19 = 62949888;
        long length2 = B2.class.getName().length();
        long j20 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        bArr2[(((((int) ((((j18 >>> 4) | j18) & 16711935) | (((((j15 >>> 4) | j15) & 16711935) << 8) + j12))) | (-1073339185)) & (-2084534076)) + (((int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) | 201331232)) ^ (-1883202843)] = -85;
        bArr2[2] = -54;
        bArr2[3] = 59;
        bArr2[4] = -12;
        bArr2[5] = -17;
        bArr2[6] = 28;
        bArr2[7] = -34;
        b(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(jSONObject, new String(bArr, charset).intern());
        String str = this.f173b;
        if (str == null) {
            long j34 = 1873611710;
            long length3 = (((~B2.class.getName().length()) | (-1246308403)) & 791413252) + ((B2.class.getName().length() & 1242038528) | 1082198433);
            long j35 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j36 = (j35 >>> 48) & 21845;
            long j37 = ((j36 >>> 1) | j36) & 858993459;
            long j38 = ((j37 >>> 2) | j37) & 252645135;
            long j39 = (j35 >>> 32) & 21845;
            long j40 = ((j39 >>> 1) | j39) & 858993459;
            long j41 = ((j40 >>> 2) | j40) & 252645135;
            long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
            long j43 = (j35 >>> 16) & 21845;
            long j44 = ((j43 >>> 1) | j43) & 858993459;
            long j45 = ((j44 >>> 2) | j44) & 252645135;
            long j46 = j35 & 21845;
            long j47 = ((j46 >>> 1) | j46) & 858993459;
            long j48 = ((j47 >>> 2) | j47) & 252645135;
            byte[] bArr3 = {(int) ((((j48 >>> 4) | j48) & 16711935) | ((((j45 >>> 4) | j45) & 16711935) << 8) | j42), -5, 34, -49};
            byte[] bArr4 = new byte[8];
            bArr4[0] = -38;
            bArr4[1] = 23;
            bArr4[2] = 84;
            bArr4[3] = -68;
            bArr4[4] = 124;
            int i3 = 2000541260 ^ ((553652800 - ((~((B2.class.getName().length() | (-1645006857)) - (-1645006857))) | 553652801)) + (((~B2.class.getName().length()) | (-1271712192)) & 1446888456));
            long j49 = -2084196081;
            long j50 = ~B2.class.getName().length();
            long j51 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
            long j52 = (j51 >>> 48) & 43690;
            long j53 = ((j52 >>> 2) | (j52 >>> 1)) & 858993459;
            long j54 = ((j53 >>> 2) | j53) & 252645135;
            long j55 = (j51 >>> 32) & 43690;
            long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
            long j57 = ((j56 >>> 2) | j56) & 252645135;
            long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) | ((((j54 >>> 4) | j54) & 16711935) << 24);
            long j59 = (j51 >>> 16) & 43690;
            long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
            long j61 = ((j60 >>> 2) | j60) & 252645135;
            long j62 = ((((j61 >>> 4) | j61) & 16711935) << 8) + j58;
            long j63 = j51 & 43690;
            long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
            long j65 = (j64 | (j64 >>> 2)) & 252645135;
            bArr4[i3] = ((((int) (((j65 | (j65 >>> 4)) & 16711935) | j62)) & (-1804957687)) + ((B2.class.getName().length() & 1428818176) | 1098973456)) ^ (-705984251);
            bArr4[6] = -15;
            long length4 = B2.class.getName().length();
            long j66 = (j4 | j3) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
            long j67 = (j66 >>> 48) & 21845;
            long j68 = ((j67 >>> 1) | j67) & 858993459;
            long j69 = ((j68 >>> 2) | j68) & 252645135;
            long j70 = (j66 >>> 32) & 21845;
            long j71 = ((j70 >>> 1) | j70) & 858993459;
            long j72 = ((j71 >>> 2) | j71) & 252645135;
            long j73 = ((((j72 >>> 4) | j72) & 16711935) << 16) + ((((j69 >>> 4) | j69) & 16711935) << 24);
            long j74 = (j66 >>> 16) & 21845;
            long j75 = ((j74 >>> 1) | j74) & 858993459;
            long j76 = ((j75 >>> 2) | j75) & 252645135;
            long j77 = j66 & 21845;
            long j78 = (j77 | (j77 >>> 1)) & 858993459;
            long j79 = (j78 | (j78 >>> 2)) & 252645135;
            bArr4[7] = 87274534 ^ (((((int) (((j79 | (j79 >>> 4)) & 16711935) + (((((j76 >>> 4) | j76) & 16711935) << 8) + j73))) | (-1719155787)) & (-1702100094)) + ((B2.class.getName().length() & 570968138) | 1614825548));
            b(bArr3, bArr4);
            str = new String(bArr3, charset).intern();
        }
        jSONObject.put(this.f172a, str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    public final boolean equals(Object obj) {
        B2 b22 = null;
        char c4 = 44815;
        while (true) {
            switch (c4) {
                case 53608:
                    return false;
                case 62116:
                    return true;
                case 2069:
                    return false;
                case 58702:
                    if (!kotlin.jvm.internal.j.a(this.f173b, b22.f173b)) {
                        c4 = 53608;
                    } else {
                        c4 = 22842;
                    }
                case 12609:
                    if (!(obj instanceof B2)) {
                        c4 = 2069;
                    } else {
                        c4 = 5532;
                    }
                case 64068:
                    return false;
                case 44815:
                    if (this == obj) {
                        c4 = 62116;
                    } else {
                        c4 = 12609;
                    }
                case 22842:
                    return true;
                case 5532:
                    b22 = (B2) obj;
                    if (!kotlin.jvm.internal.j.a(this.f172a, b22.f172a)) {
                        c4 = 64068;
                    } else {
                        c4 = 58702;
                    }
                default:
                    c4 = 53608;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    public final int hashCode() {
        String str = null;
        char c4 = 41366;
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String str2 = this.f173b;
            switch (c4) {
                case 41366:
                    str = this.f172a;
                    c4 = 52954;
                case 52954:
                    i = str.hashCode() * 31;
                    if (str2 == null) {
                        c4 = 24229;
                    } else {
                        c4 = 12567;
                    }
                case 12567:
                    i4 = str2.hashCode();
                    i3 = i;
                    c4 = 2998;
                case 2998:
                    break;
                case 24229:
                    i4 = 0;
                    i3 = i;
                    c4 = 2998;
                default:
                    c4 = 12567;
            }
            return i3 + i4;
        }
    }

    public final String toString() {
        long j2 = 545984096;
        long j3 = (~B2.class.getName().length()) | (-142244782);
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        byte[] bArr = {-110, (((int) (((j17 | (j17 >>> 4)) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) + ((B2.class.getName().length() & 940576) | 315536)) ^ 546299548, -63, ((((~B2.class.getName().length()) | (-406777528)) & 86118661) + ((B2.class.getName().length() & 136445957) | (-2003566592))) ^ 1917447851, 52, -81, 93, 86, -101, -64, 90, 10, -45, -48, 8, -44, 35, 98, 123, 118, -114, 54, 125, 23, 96};
        byte[] bArr2 = new byte[25];
        bArr2[0] = 101;
        bArr2[1] = 51;
        bArr2[2] = 93;
        int i = ((~B2.class.getName().length()) | (-1048577)) - (-5243234);
        int length = B2.class.getName().length() & 1572884;
        int length2 = (((((B2.class.getName().length() & (~length)) & 277348374) + 277348374) + length) - ((B2.class.getName().length() | length) & 277348374)) + i;
        bArr2[3] = (length2 + 282591489) - ((282591489 & length2) * 2);
        bArr2[4] = -76;
        bArr2[5] = -7;
        int length3 = (((~B2.class.getName().length()) | (-144124853)) & (-2112191599)) + ((B2.class.getName().length() & 17974224) | 17064000);
        bArr2[6] = B0.a((~length3) | 2095127639, 2095127639 - length3);
        bArr2[7] = -42;
        bArr2[8] = 92;
        bArr2[9] = -57;
        bArr2[10] = -88;
        bArr2[11] = 9;
        bArr2[12] = 25;
        int i3 = ~B2.class.getName().length();
        int i4 = 172122763 & (((~i3) & (-935053025)) + i3);
        int length4 = B2.class.getName().length() & 578996096;
        bArr2[(i4 + (~(((B2.class.getName().length() | (-612402433)) | length4) - (length4 | (B2.class.getName().length() & 612402432))))) ^ 784525190] = -54;
        bArr2[14] = 82;
        bArr2[15] = 85;
        bArr2[16] = -81;
        bArr2[17] = 42;
        bArr2[18] = -114;
        int i5 = ((~B2.class.getName().length()) | 1933280678) & (-1222228928);
        int length5 = B2.class.getName().length() & (-1937483583);
        bArr2[19] = 1079616352 ^ (((142612628 + length5) + (((-length5) - 1) | (-142612628))) + i5);
        bArr2[20] = 124;
        bArr2[21] = 69;
        bArr2[22] = -126;
        bArr2[23] = 28;
        bArr2[24] = 93;
        c(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        long j18 = 51253340;
        long j19 = (~B2.class.getName().length()) | (-72698755);
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        byte[] bArr3 = {33, (((int) (((j33 | (j33 >>> 4)) & 16711935) | ((((j30 | (j30 >>> 4)) & 16711935) << 8) | j27))) + ((B2.class.getName().length() & 273943040) | (-1798305279))) ^ 1747051986, -73, -91, -97, 17, 122};
        int i6 = ((~B2.class.getName().length()) | (-402654209)) - 1199569405;
        int length6 = B2.class.getName().length() & 406914048;
        c(bArr3, new byte[]{1193081067 ^ ((((((B2.class.getName().length() & (~length6)) & 6488320) + 6488320) + length6) - ((B2.class.getName().length() | length6) & 6488320)) + i6), 92, 64, 102, -7, 126, 71, 37});
        String intern2 = new String(bArr3, charset).intern();
        byte[] bArr4 = {105};
        c(bArr4, new byte[]{64, -38, 114, -50, -60, -118, -58, -73});
        return intern + this.f172a + intern2 + this.f173b + new String(bArr4, charset).intern();
    }
}
