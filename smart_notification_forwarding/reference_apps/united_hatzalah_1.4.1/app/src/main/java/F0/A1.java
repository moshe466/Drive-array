package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class A1 implements J {

    /* renamed from: a, reason: collision with root package name */
    public final String f167a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f168b;

    public A1(JSONObject jSONObject, String str) {
        int f4 = (AbstractC0008a.f(A1.class, -1) | (-932436089)) & (-1050146559);
        long j2 = 201334814;
        long length = (A1.class.getName().length() | (-16779265)) - (-16779265);
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j3 = (b4 >>> 48) & 43690;
        long j4 = ((j3 >>> 2) | (j3 >>> 1)) & 858993459;
        long j5 = ((j4 >>> 2) | j4) & 252645135;
        long j6 = (b4 >>> 32) & 43690;
        long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
        long j8 = ((j7 >>> 2) | j7) & 252645135;
        long j9 = ((((j8 >>> 4) | j8) & 16711935) << 16) | ((((j5 >>> 4) | j5) & 16711935) << 24);
        long j10 = (b4 >>> 16) & 43690;
        long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
        long j12 = ((j11 >>> 2) | j11) & 252645135;
        long j13 = b4 & 43690;
        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
        long j15 = (j14 | (j14 >>> 2)) & 252645135;
        byte[] bArr = {72, -105, -111, -114, -82, (f4 + ((int) (((j15 | (j15 >>> 4)) & 16711935) + (((((j12 >>> 4) | j12) & 16711935) << 8) + j9)))) ^ 848811675, 37, -28, 110};
        c(bArr, new byte[]{43, -1, -12, -19, -59, -54, ((((~A1.class.getName().length()) | 990564417) & 8959067) + ((A1.class.getName().length() & 79701530) | (-2076179712))) ^ (-2067220705), -119, 11});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(str, new String(bArr, charset).intern());
        byte[] bArr2 = new byte[4];
        bArr2[0] = -44;
        bArr2[1] = 126;
        bArr2[((((~A1.class.getName().length()) | (-88659692)) & 1347781242) + ((A1.class.getName().length() & 37782506) | 33572228)) ^ 1381353468] = -105;
        bArr2[3] = -85;
        byte[] bArr3 = new byte[8];
        bArr3[0] = -67;
        int f5 = ((AbstractC0008a.f(A1.class, -1) | 481813047) & (-2077777792)) + (((A1.class.getName().length() | 2147479145) - 2147479145) | 138418454);
        bArr3[((f5 & 1939359336) * 2) + ((-1939359337) - f5)] = 16;
        bArr3[2] = -15;
        bArr3[3] = -60;
        bArr3[4] = -59;
        bArr3[5] = 48;
        bArr3[6] = 71;
        bArr3[7] = ((((A1.class.getName().length() & 1376256004) | 1577222152) + (~(-(((~A1.class.getName().length()) | (-1544176911)) & 9181796)))) + 1) ^ (-1586403879);
        c(bArr2, bArr3);
        new String(bArr2, charset).intern();
        this.f167a = str;
        this.f168b = jSONObject;
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
        int i7 = ~A1.class.getName().length();
        int length3 = (((~(((A1.class.getName().length() | 70245657) | i7) - (i7 | (A1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((A1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(A1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((A1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~A1.class.getName().length()) | (-576567005)) & 276971586) + ((A1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~A1.class.getName().length()) | (-1157759625)) & 1755853004) + ((A1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~A1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = A1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~A1.class.getName().length()) | (-1064961)) + 689325073) + ((A1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~A1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = A1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~A1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (A1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((A1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~A1.class.getName().length();
                    int length11 = (161497089 & (((((A1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((A1.class.getName().length() | i14) & 797295576))) + ((A1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~A1.class.getName().length()) | (-1085986263)) & 1078327440) + ((A1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~A1.class.getName().length();
                    int length12 = length5 >>> ((((~(((A1.class.getName().length() | 626856794) | i15) - ((A1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((A1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~A1.class.getName().length()) | 1248713193) & 826417528) + ((A1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~A1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (A1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~A1.class.getName().length()) | (-1005965450)) & 153223237) + ((A1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((A1.class.getName().length() & (~length6)) & i9)) + ((A1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~A1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((A1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~A1.class.getName().length()) | (-23496740)) & 827084804) + ((A1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~A1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (A1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~A1.class.getName().length()) | (-961655275)) & 25184460) + ((A1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~A1.class.getName().length()) | 1233459797) & 125923146) + ((A1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~A1.class.getName().length()) | (-7107622)) & 402932290) + ((A1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((A1.class.getName().length() | length15) - (b4 | length15)) + I2.a(A1.class, b4) + (A1.class.getName().length() & length15);
                    int length17 = ((((~A1.class.getName().length()) | (-81143879)) & 438583424) + ((A1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~A1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((A1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(A1.class, 568748773 | i24) + (A1.class.getName().length() & (-2105278367)))) + ((A1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~A1.class.getName().length()) | (-1592082969)) & 140665109) + ((A1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~A1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((A1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~A1.class.getName().length()) | (-180811308));
                    int length19 = (A1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((A1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | A1.class.getName().length()))));
                    int i29 = ((~A1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (A1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~A1.class.getName().length()) | 75364313) & 1242301609) + ((A1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = A1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((A1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~A1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((A1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~A1.class.getName().length();
                    int length24 = 1409942802 & (((((A1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | A1.class.getName().length()) & 91135407));
                    int length25 = (A1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~A1.class.getName().length()) | (-537919489)) - (-806798471)) + ((A1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~A1.class.getName().length()) | (-382746167)) & 102532165) + ((A1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~A1.class.getName().length()) | (-6036961)) & 1233145505) + ((A1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~A1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = A1.class.getName().length() & 268460041;
                    i5 = (((((A1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | A1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = A1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((A1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~A1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((A1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~A1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (A1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(A1.class, -1) | (-532481)) - (-67641369)) + ((A1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~A1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((A1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(A1.class, -1) | (-33554434)) - (-1107366402)) + ((A1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(A1.class, -1) | (-167014194)) & 1157999680) + ((A1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = A1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((A1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(A1.class, -1) | 114408723) & 1183666176;
                    int length33 = A1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~A1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = A1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~A1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (A1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~A1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((A1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~A1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (A1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~A1.class.getName().length()) | 991120067) & (-2113137661)) + ((A1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(A1.class, -1) | 314136709) & 371231304) + (((A1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~A1.class.getName().length()) | 366661365) & 1344150018) + ((A1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~A1.class.getName().length()) | (-1359635359)) & 49026131) + ((A1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~A1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = A1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (A1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~A1.class.getName().length()) | 1110430873) & 1241612298) + ((A1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~A1.class.getName().length()) | 1603962366) & 25199440) + (((A1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~A1.class.getName().length()) | (-1388708984)) & 706816128) + ((A1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~A1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = A1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~A1.class.getName().length()) | 2113158628) & 1026558002) + ((A1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~A1.class.getName().length()) | 715175224) & 136512788) + ((A1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~A1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = A1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~A1.class.getName().length()) | (-1084937228)) & 438503696) + ((A1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~A1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((A1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(A1.class, 1197735420 | i53) + (A1.class.getName().length() & 674349280))) + ((A1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~A1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (A1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~A1.class.getName().length()) | (-171976913)) & 318775824) + ((A1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~A1.class.getName().length()) | (-616910267)) & 1303391760) + ((A1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~A1.class.getName().length()) | 1297715640) & 556926729) + ((A1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~A1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((A1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~A1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (A1.class.getName().length() & 44040224) | (-1811807712)), 1);
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x03e9. Please report as an issue. */
    @Override // F0.J
    public final void a(JSONObject jSONObject) {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 1;
        int i7 = 2;
        byte[] bArr3 = {((((~A1.class.getName().length()) | 459506067) & 405843488) + ((A1.class.getName().length() & 1095839266) | 1094778882)) ^ (-1500622406), -47, -48, -99};
        byte[] bArr4 = new byte[8];
        bArr4[0] = -14;
        bArr4[1] = -94;
        bArr4[2] = -65;
        long j2 = -1538782468;
        long j3 = (~A1.class.getName().length()) | 139446164;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
        long j18 = -1267148033;
        boolean z3 = 4;
        long length = ((int) (((j17 | (j17 >>> 4)) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) + ((A1.class.getName().length() & (-1541367704)) | 271634432);
        long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j20 = (j19 >>> 48) & 21845;
        long j21 = ((j20 >>> 1) | j20) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 21845;
        long j24 = ((j23 >>> 1) | j23) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 21845;
        long j31 = ((j30 >>> 1) | j30) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        bArr4[(int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26))] = -13;
        bArr4[4] = -49;
        bArr4[5] = 11;
        int length2 = A1.class.getName().length();
        long j33 = 133490299;
        long j34 = ((~length2) - length2) + length2;
        long j35 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j36 = (j35 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = (j37 | (j37 >>> 2)) & 252645135;
        long j39 = (j35 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + (((j38 | (j38 >>> 4)) & 16711935) << 24);
        long j43 = (j35 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = j35 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = (j47 | (j47 >>> 2)) & 252645135;
        bArr4[(-1493967181) ^ ((((int) ((((((j45 >>> 4) | j45) & 16711935) << 8) | j42) | ((j48 | (j48 >>> 4)) & 16711935))) & (-1566484303)) + ((A1.class.getName().length() & (-1609360764)) | 72517124))] = 68;
        bArr4[7] = -91;
        byte[] bArr5 = null;
        int i8 = -585497720;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        byte[] bArr6 = null;
        while (true) {
            int i12 = ((i8 & 16777216) * (i8 | 16777216)) + ((i8 & (-16777217)) * ((~i8) & 16777216));
            int i13 = i8 >>> 8;
            int i14 = ~((((~i13) | (-238348293)) | i12) - ((i13 & (-238348293)) | i12));
            int i15 = (-1081514022) - ((i14 & i7) | ((-10362931) - i14));
            boolean z4 = z3;
            int i16 = 2100390411;
            switch (E1.a(i15 | (-428181225), i15, -428181225)) {
                case -1819084085:
                    bArr = bArr6;
                    i = i5;
                    bArr2 = bArr4;
                    int length3 = bArr5.length;
                    int i17 = 0 - i9;
                    int length4 = bArr5.length;
                    int i18 = 0 - i17;
                    byte b4 = bArr5[(length4 & (~i18)) - ((~length4) & i18)];
                    int length5 = bArr5.length;
                    byte b5 = bArr[((length5 | i17) - (((~i17) & (-1678010279)) & length5)) + ((i17 | (-1678010279)) & length5)];
                    bArr5[((length3 | i17) * 2) - (length3 ^ i17)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i11 = 4 - ((5 - i9) | (i9 & 2));
                    i3 = 2;
                    i4 = 1;
                    int i19 = ((i9 > 2 ? 1 : (i9 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i19 == 0) {
                        i16 = -897645243;
                    }
                    if (i19 != 0) {
                        i7 = 2;
                        i5 = i;
                        z3 = z4;
                        i8 = i16;
                        bArr4 = bArr2;
                        i6 = 1;
                        bArr6 = bArr;
                    }
                    i7 = i3;
                    i5 = i;
                    z3 = z4;
                    bArr4 = bArr2;
                    i6 = i4;
                    i8 = -2079636786;
                    bArr6 = bArr;
                case -1350640889:
                    bArr5 = bArr3;
                    i10 = i5;
                    z3 = z4;
                    bArr6 = bArr4;
                    bArr4 = bArr6;
                    i8 = -1469476344;
                    i6 = 1;
                case -477594107:
                    byte[] bArr7 = bArr6;
                    int i20 = i7;
                    int length6 = bArr5.length;
                    int i21 = 0 - i9;
                    int i22 = ((length6 | i21) - (((-515406864) & (~i21)) & length6)) + ((i21 | (-515406864)) & length6);
                    byte b6 = bArr7[i22];
                    int length7 = bArr5.length;
                    byte b7 = bArr7[((i21 | length7) * 2) - (length7 ^ i21)];
                    int i23 = ((byte) 0) - b6;
                    int i24 = i23 | b7;
                    bArr7[i22] = (byte) (((byte) (((byte) i24) - ((byte) (((byte) i20) * ((byte) i23))))) + ((byte) ((b7 ^ i23) ^ i24)));
                    i5 = 0;
                    i8 = -1057239115;
                    z3 = z4;
                    bArr4 = bArr4;
                    bArr6 = bArr7;
                    i6 = 1;
                    i7 = 2;
                case 769572960:
                    break;
                case 783648904:
                    int i25 = i7;
                    byte[] bArr8 = bArr4;
                    int i26 = i10 + 4 + (((-1) - i10) | (-4));
                    byte b8 = bArr6[i26];
                    int i27 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i28 = i10 & 2;
                    int i29 = (i10 + 2) - i28;
                    int i30 = bArr6[i29] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & 65536);
                    int i32 = ~((i27 | (467314697 | (~i31))) - ((i31 & 467314697) | i27));
                    int i33 = (i10 + 1) - (i10 & 1);
                    int i34 = bArr6[i33] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i36 = ~((i32 | ((~i35) | 1328859631)) - ((i35 & 1328859631) | i32));
                    int i37 = bArr6[i10] & ForkServer.ERROR;
                    byte[] bArr9 = bArr6;
                    int a2 = S.a(i36, i37, 1, ((-1) - i36) | ((-1) - i37));
                    byte b9 = bArr5[i26];
                    int i38 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i39 = bArr5[i29] & ForkServer.ERROR;
                    int i40 = i39 * ((~i39) & 65536);
                    int a4 = j3.a((~i38) & 1647046022 & i40, i40, i38, (i38 | 1647046022) & i40);
                    int i41 = bArr5[i33] & ForkServer.ERROR;
                    int i42 = i41 * ((~i41) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i43 = ~((a4 | ((~i42) | (-2059442874))) - ((i42 & (-2059442874)) | a4));
                    int i44 = bArr5[i10] & ForkServer.ERROR;
                    int a5 = S.a(i43, i44, 1, ((-1) - i43) | ((-1) - i44));
                    int i45 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                    int i46 = (i45 + a5) - ((i45 & a5) * 2);
                    bArr5[i10] = (byte) i46;
                    bArr5[i33] = (byte) (i46 >>> 8);
                    bArr5[i29] = (byte) (i46 >>> 16);
                    bArr5[i26] = (byte) (i46 >>> 24);
                    i10 = (-11) - (((-15) - i10) | i28);
                    int length8 = bArr5.length;
                    int a6 = AbstractC0044j.a(bArr5.length);
                    int i47 = ((i10 > (((length8 & (~a6)) * 2) - (length8 ^ a6)) ? 1 : (i10 == (((length8 & (~a6)) * 2) - (length8 ^ a6)) ? 0 : -1)) >>> 31) & 1;
                    if (i47 != 0) {
                        i8 = -897645243;
                    } else {
                        i8 = 1251644638;
                    }
                    z3 = z4;
                    bArr4 = bArr8;
                    i7 = i25;
                    if (i47 != 0) {
                        bArr6 = bArr9;
                        i8 = -1469476344;
                    } else {
                        bArr6 = bArr9;
                    }
                    i5 = 0;
                    i6 = 1;
                case 1758587480:
                    int i48 = i7;
                    byte[] bArr10 = bArr4;
                    int length9 = bArr5.length;
                    int i49 = 0 - i11;
                    if ((bArr6[((length9 | i49) - (((~i49) & 822835569) & length9)) + ((i49 | 822835569) & length9)] > Double.NaN ? 1 : (bArr6[((length9 | i49) - (((~i49) & 822835569) & length9)) + ((i49 | 822835569) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i8 = -897645243;
                    } else {
                        i8 = -1057239115;
                    }
                    i9 = i11;
                    z3 = z4;
                    bArr4 = bArr10;
                    i7 = i48;
                case 2013813686:
                    i11 = bArr5.length % 4;
                    i3 = i7;
                    bArr2 = bArr4;
                    int i50 = ((i11 > i6 ? 1 : (i11 == i6 ? 0 : -1)) >>> 31) & i6;
                    if (i50 == 0) {
                        i16 = -897645243;
                    }
                    if (i50 != 0) {
                        i7 = i3;
                        z3 = z4;
                        i8 = i16;
                        bArr4 = bArr2;
                    } else {
                        bArr = bArr6;
                        i4 = i6;
                        i = i5;
                        i7 = i3;
                        i5 = i;
                        z3 = z4;
                        bArr4 = bArr2;
                        i6 = i4;
                        i8 = -2079636786;
                        bArr6 = bArr;
                    }
                default:
                    z3 = z4;
                    i8 = -897645243;
            }
            kotlin.jvm.internal.j.e(jSONObject, new String(bArr3, StandardCharsets.UTF_8).intern());
            jSONObject.put(this.f167a, this.f168b);
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0008. Please report as an issue. */
    public final boolean equals(Object obj) {
        A1 a12 = null;
        char c4 = 45403;
        A1 a13 = null;
        while (true) {
            switch (c4) {
                case 913:
                    if (!(obj instanceof A1)) {
                        c4 = 2220;
                    } else {
                        c4 = 63510;
                    }
                case 45445:
                    c4 = 26822;
                    a12 = this;
                case 63510:
                    a13 = (A1) obj;
                    if (!kotlin.jvm.internal.j.a(this.f167a, a13.f167a)) {
                        c4 = 20646;
                    } else {
                        c4 = 45445;
                    }
                case 26432:
                    return true;
                case 20646:
                    return false;
                case 26822:
                    if (!kotlin.jvm.internal.j.a(a12.f168b, a13.f168b)) {
                        c4 = 2932;
                    } else {
                        c4 = 18427;
                    }
                case 2220:
                    return false;
                case 18427:
                    return true;
                case 2932:
                    return false;
                case 45403:
                    if (this == obj) {
                        c4 = 26432;
                    } else {
                        c4 = 913;
                    }
                default:
                    c4 = 2220;
            }
        }
    }

    public final int hashCode() {
        int hashCode = this.f167a.hashCode();
        int f4 = AbstractC0008a.f(A1.class, -1);
        return this.f168b.hashCode() + (hashCode * ((((f4 | (-67142242)) - (((-83928802) | f4) ^ 1661482112)) + ((A1.class.getName().length() & 16934016) | 134365281)) ^ 1795847422));
    }

    public final String toString() {
        byte[] bArr = new byte[23];
        bArr[0] = -54;
        bArr[(((AbstractC0008a.f(A1.class, -1) | 1091003018) & 149169028) + (((A1.class.getName().length() | (-149422405)) - (-149422405)) | 558144)) ^ 149727173] = -120;
        bArr[2] = -92;
        bArr[3] = -58;
        bArr[4] = 123;
        bArr[5] = -7;
        bArr[6] = 25;
        bArr[7] = 23;
        bArr[8] = -106;
        long j2 = 13414624;
        long j3 = (~A1.class.getName().length()) | (-1598443463);
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        bArr[(((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) + ((A1.class.getName().length() & (-2143026496)) | (-2063596016))) ^ (-2050181383)] = 95;
        bArr[10] = 43;
        bArr[11] = 3;
        bArr[12] = 6;
        bArr[13] = -120;
        bArr[14] = -102;
        bArr[15] = -68;
        bArr[16] = -11;
        bArr[17] = -102;
        bArr[18] = -4;
        bArr[19] = -90;
        bArr[20] = -32;
        bArr[21] = -15;
        long j18 = -1;
        long length = A1.class.getName().length();
        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j20 = (j19 >>> 48) & 21845;
        long j21 = ((j20 >>> 1) | j20) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 21845;
        long j24 = ((j23 >>> 1) | j23) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 21845;
        long j31 = ((j30 >>> 1) | j30) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        bArr[22] = (((((int) ((((j32 >>> 4) | j32) & 16711935) | (((((j29 >>> 4) | j29) & 16711935) << 8) | j26))) | (-1268387331)) & 1094980865) + ((A1.class.getName().length() & 1090651140) | 67241996)) ^ (-1162222924);
        int length2 = A1.class.getName().length();
        int length3 = (A1.class.getName().length() & 3481890) | 1074922592;
        int i = -(((-95364567) | ((length2 - 1) - (length2 * 2))) & (-2006634237));
        int i3 = ((~i) & length3) - (i & (~length3));
        long j33 = 931711711;
        long j34 = i3;
        long j35 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j36 = (j35 >>> 48) & 21845;
        long j37 = ((j36 >>> 1) | j36) & 858993459;
        long j38 = ((j37 >>> 2) | j37) & 252645135;
        long j39 = (j35 >>> 32) & 21845;
        long j40 = ((j39 >>> 1) | j39) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) | ((((j38 >>> 4) | j38) & 16711935) << 24);
        long j43 = (j35 >>> 16) & 21845;
        long j44 = ((j43 >>> 1) | j43) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = j35 & 21845;
        long j47 = ((j46 >>> 1) | j46) & 858993459;
        long j48 = ((j47 >>> 2) | j47) & 252645135;
        b(bArr, new byte[]{120, -124, -108, -115, -97, 94, -39, 31, -78, 37, 102, -102, 12, -20, 75, 99, (int) ((((j48 >>> 4) | j48) & 16711935) | ((((j45 >>> 4) | j45) & 16711935) << 8) | j42), 57, -84, 116, 16, 100, -91});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr2 = new byte[7];
        bArr2[0] = -6;
        bArr2[1] = 90;
        bArr2[2] = -3;
        bArr2[3] = -91;
        bArr2[4] = -8;
        bArr2[5] = 62;
        bArr2[(((AbstractC0008a.f(A1.class, -1) | 1378929195) & (-198141936)) + ((A1.class.getName().length() & (-1543155182)) | 345606)) ^ (-197796336)] = -72;
        b(bArr2, new byte[]{36, -123, 81, -98, 24, 33, 85, 11});
        String intern2 = new String(bArr2, charset).intern();
        byte[] bArr3 = {-21};
        byte[] bArr4 = new byte[8];
        bArr4[0] = ((((~A1.class.getName().length()) | (-1891157445)) & 287326296) + ((A1.class.getName().length() & 270553156) | 1052708)) ^ 288378983;
        bArr4[1] = -62;
        bArr4[2] = -64;
        int f4 = (AbstractC0008a.f(A1.class, -1) | (-763985250)) & (-1140764536);
        long j49 = 1846628384;
        long length4 = A1.class.getName().length();
        long j50 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j51 = (j50 >>> 48) & 43690;
        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = (j50 >>> 32) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) + ((((j53 >>> 4) | j53) & 16711935) << 24);
        long j58 = (j50 >>> 16) & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = j50 & 43690;
        long j62 = ((j61 >>> 1) | (j61 >>> 2)) & 858993459;
        long j63 = (j62 | (j62 >>> 2)) & 252645135;
        bArr4[(-32419157) ^ (f4 + (((int) (((j63 | (j63 >>> 4)) & 16711935) + (((((j60 >>> 4) | j60) & 16711935) << 8) | j57))) | 1108345376))] = -7;
        bArr4[4] = -95;
        bArr4[5] = -9;
        bArr4[6] = 114;
        bArr4[7] = -14;
        b(bArr3, bArr4);
        return intern + this.f167a + intern2 + this.f168b + new String(bArr3, charset).intern();
    }
}
