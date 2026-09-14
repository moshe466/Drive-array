package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.fork.ForkServer;
import t2.AbstractC0708j;

/* renamed from: F0.e2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0027e2 implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public static final C0019c2 f503c = new C0019c2(0);

    /* renamed from: a, reason: collision with root package name */
    public final List f504a;

    /* renamed from: b, reason: collision with root package name */
    public final List f505b;

    public C0027e2(List list, List list2) {
        this.f504a = list;
        this.f505b = list2;
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
        int i7 = ~C0027e2.class.getName().length();
        int length3 = (((~(((C0027e2.class.getName().length() | 70245657) | i7) - (i7 | (C0027e2.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C0027e2.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C0027e2.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C0027e2.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C0027e2.class.getName().length()) | (-576567005)) & 276971586) + ((C0027e2.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C0027e2.class.getName().length()) | (-1157759625)) & 1755853004) + ((C0027e2.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C0027e2.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C0027e2.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C0027e2.class.getName().length()) | (-1064961)) + 689325073) + ((C0027e2.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C0027e2.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C0027e2.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C0027e2.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C0027e2.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C0027e2.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C0027e2.class.getName().length();
                    int length11 = (161497089 & (((((C0027e2.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C0027e2.class.getName().length() | i14) & 797295576))) + ((C0027e2.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C0027e2.class.getName().length()) | (-1085986263)) & 1078327440) + ((C0027e2.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C0027e2.class.getName().length();
                    int length12 = length5 >>> ((((~(((C0027e2.class.getName().length() | 626856794) | i15) - ((C0027e2.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C0027e2.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C0027e2.class.getName().length()) | 1248713193) & 826417528) + ((C0027e2.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C0027e2.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C0027e2.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C0027e2.class.getName().length()) | (-1005965450)) & 153223237) + ((C0027e2.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C0027e2.class.getName().length() & (~length6)) & i9)) + ((C0027e2.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C0027e2.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C0027e2.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C0027e2.class.getName().length()) | (-23496740)) & 827084804) + ((C0027e2.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C0027e2.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C0027e2.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C0027e2.class.getName().length()) | (-961655275)) & 25184460) + ((C0027e2.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C0027e2.class.getName().length()) | 1233459797) & 125923146) + ((C0027e2.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C0027e2.class.getName().length()) | (-7107622)) & 402932290) + ((C0027e2.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C0027e2.class.getName().length() | length15) - (b4 | length15)) + I2.a(C0027e2.class, b4) + (C0027e2.class.getName().length() & length15);
                    int length17 = ((((~C0027e2.class.getName().length()) | (-81143879)) & 438583424) + ((C0027e2.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C0027e2.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C0027e2.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C0027e2.class, 568748773 | i24) + (C0027e2.class.getName().length() & (-2105278367)))) + ((C0027e2.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C0027e2.class.getName().length()) | (-1592082969)) & 140665109) + ((C0027e2.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C0027e2.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C0027e2.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C0027e2.class.getName().length()) | (-180811308));
                    int length19 = (C0027e2.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C0027e2.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C0027e2.class.getName().length()))));
                    int i29 = ((~C0027e2.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C0027e2.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C0027e2.class.getName().length()) | 75364313) & 1242301609) + ((C0027e2.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C0027e2.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C0027e2.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C0027e2.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C0027e2.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C0027e2.class.getName().length();
                    int length24 = 1409942802 & (((((C0027e2.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C0027e2.class.getName().length()) & 91135407));
                    int length25 = (C0027e2.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C0027e2.class.getName().length()) | (-537919489)) - (-806798471)) + ((C0027e2.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C0027e2.class.getName().length()) | (-382746167)) & 102532165) + ((C0027e2.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C0027e2.class.getName().length()) | (-6036961)) & 1233145505) + ((C0027e2.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C0027e2.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C0027e2.class.getName().length() & 268460041;
                    i5 = (((((C0027e2.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C0027e2.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C0027e2.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C0027e2.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C0027e2.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C0027e2.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C0027e2.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C0027e2.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C0027e2.class, -1) | (-532481)) - (-67641369)) + ((C0027e2.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C0027e2.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C0027e2.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C0027e2.class, -1) | (-33554434)) - (-1107366402)) + ((C0027e2.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C0027e2.class, -1) | (-167014194)) & 1157999680) + ((C0027e2.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C0027e2.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C0027e2.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C0027e2.class, -1) | 114408723) & 1183666176;
                    int length33 = C0027e2.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C0027e2.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C0027e2.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C0027e2.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C0027e2.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C0027e2.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C0027e2.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C0027e2.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C0027e2.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C0027e2.class.getName().length()) | 991120067) & (-2113137661)) + ((C0027e2.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C0027e2.class, -1) | 314136709) & 371231304) + (((C0027e2.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C0027e2.class.getName().length()) | 366661365) & 1344150018) + ((C0027e2.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C0027e2.class.getName().length()) | (-1359635359)) & 49026131) + ((C0027e2.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C0027e2.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C0027e2.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C0027e2.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C0027e2.class.getName().length()) | 1110430873) & 1241612298) + ((C0027e2.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C0027e2.class.getName().length()) | 1603962366) & 25199440) + (((C0027e2.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C0027e2.class.getName().length()) | (-1388708984)) & 706816128) + ((C0027e2.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C0027e2.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C0027e2.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C0027e2.class.getName().length()) | 2113158628) & 1026558002) + ((C0027e2.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C0027e2.class.getName().length()) | 715175224) & 136512788) + ((C0027e2.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C0027e2.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C0027e2.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C0027e2.class.getName().length()) | (-1084937228)) & 438503696) + ((C0027e2.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C0027e2.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C0027e2.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C0027e2.class, 1197735420 | i53) + (C0027e2.class.getName().length() & 674349280))) + ((C0027e2.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C0027e2.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C0027e2.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C0027e2.class.getName().length()) | (-171976913)) & 318775824) + ((C0027e2.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C0027e2.class.getName().length()) | (-616910267)) & 1303391760) + ((C0027e2.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C0027e2.class.getName().length()) | 1297715640) & 556926729) + ((C0027e2.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C0027e2.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C0027e2.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C0027e2.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C0027e2.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x01c1. Please report as an issue. */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0027e2 c0027e2) {
        byte[] bArr;
        int i;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 1;
        int i8 = 2;
        byte[] bArr2 = {-46, -98, 112, -97, -9};
        byte[] bArr3 = new byte[8];
        bArr3[0] = -67;
        bArr3[1] = -22;
        char c4 = 24;
        bArr3[2] = 24;
        bArr3[3] = -6;
        bArr3[4] = -123;
        long j2 = 142606536;
        long j3 = 1;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j5 = (j4 >>> 48) & 43690;
        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 43690;
        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 43690;
        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        bArr3[2109358796 ^ (825246344 + (((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) | 1284112449))] = -77;
        bArr3[6] = 14;
        bArr3[7] = -32;
        byte[] bArr4 = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = -585497720;
        int i12 = 0;
        byte[] bArr5 = null;
        while (true) {
            int i13 = ((i11 & 16777216) * (i11 | 16777216)) + ((i11 & (-16777217)) * ((~i11) & 16777216));
            int i14 = i11 >>> 8;
            int i15 = ~((((~i14) | (-238348293)) | i13) - ((i14 & (-238348293)) | i13));
            int i16 = (-1081514022) - ((i15 & i8) | ((-10362931) - i15));
            char c5 = c4;
            int i17 = 2100390411;
            switch (E1.a(i16 | (-428181225), i16, -428181225)) {
                case -1819084085:
                    bArr = bArr3;
                    int length = bArr4.length;
                    int i18 = 0 - i12;
                    int length2 = bArr4.length;
                    int i19 = 0 - i18;
                    byte b4 = bArr4[(length2 & (~i19)) - ((~length2) & i19)];
                    int length3 = bArr4.length;
                    byte b5 = bArr5[((length3 | i18) - (((~i18) & (-1678010279)) & length3)) + ((i18 | (-1678010279)) & length3)];
                    bArr4[((length | i18) * 2) - (length ^ i18)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i10 = 4 - ((5 - i12) | (i12 & 2));
                    i = 2;
                    i3 = 1;
                    int i20 = ((i12 > 2 ? 1 : (i12 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i20 == 0) {
                        i17 = -897645243;
                    }
                    if (i20 != 0) {
                        i8 = 2;
                        bArr3 = bArr;
                        c4 = c5;
                        i11 = i17;
                        i7 = i3;
                        i6 = 0;
                    }
                    int i21 = i;
                    i11 = -2079636786;
                    i8 = i21;
                    bArr3 = bArr;
                    c4 = c5;
                    i7 = i3;
                    i6 = 0;
                case -1350640889:
                    bArr4 = bArr2;
                    bArr5 = bArr3;
                    c4 = c5;
                    i6 = 0;
                    i11 = -1469476344;
                    i9 = 0;
                case -477594107:
                    int i22 = i8;
                    int i23 = i6;
                    byte[] bArr6 = bArr3;
                    int length4 = bArr4.length;
                    int i24 = 0 - i12;
                    int i25 = ((length4 | i24) - (((-515406864) & (~i24)) & length4)) + ((i24 | (-515406864)) & length4);
                    byte b6 = bArr5[i25];
                    int length5 = bArr4.length;
                    byte b7 = bArr5[((i24 | length5) * 2) - (length5 ^ i24)];
                    int i26 = ((byte) i23) - b6;
                    int i27 = i26 | b7;
                    bArr5[i25] = (byte) (((byte) (((byte) i27) - ((byte) (((byte) i22) * ((byte) i26))))) + ((byte) ((b7 ^ i26) ^ i27)));
                    i11 = -1057239115;
                    bArr3 = bArr6;
                    c4 = c5;
                    i8 = 2;
                    i6 = 0;
                    i7 = 1;
                case 769572960:
                    break;
                case 783648904:
                    int i28 = i8;
                    int i29 = i6;
                    int i30 = i9 + 4 + (((-1) - i9) | (-4));
                    byte b8 = bArr5[i30];
                    int i31 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i32 = i9 & 2;
                    int i33 = (i9 + 2) - i32;
                    int i34 = bArr5[i33] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & 65536);
                    int i36 = ~((i31 | (467314697 | (~i35))) - ((i35 & 467314697) | i31));
                    int i37 = (i9 + 1) - (i9 & 1);
                    int i38 = bArr5[i37] & ForkServer.ERROR;
                    int i39 = i38 * ((~i38) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i40 = ~(((1328859631 | (~i39)) | i36) - ((i39 & 1328859631) | i36));
                    int i41 = bArr5[i9] & ForkServer.ERROR;
                    int a2 = S.a(i40, i41, 1, ((-1) - i40) | ((-1) - i41));
                    byte b9 = bArr4[i30];
                    int i42 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i43 = bArr4[i33] & ForkServer.ERROR;
                    int i44 = i43 * ((~i43) & 65536);
                    byte[] bArr7 = bArr3;
                    int a4 = j3.a((~i42) & 1647046022 & i44, i44, i42, (i42 | 1647046022) & i44);
                    int i45 = bArr4[i37] & ForkServer.ERROR;
                    int i46 = i45 * ((~i45) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i47 = ~((a4 | ((~i46) | (-2059442874))) - ((i46 & (-2059442874)) | a4));
                    int i48 = bArr4[i9] & ForkServer.ERROR;
                    int a5 = S.a(i47, i48, 1, ((-1) - i47) | ((-1) - i48));
                    int i49 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                    int i50 = (i49 + a5) - ((i49 & a5) * 2);
                    bArr4[i9] = (byte) i50;
                    bArr4[i37] = (byte) (i50 >>> 8);
                    bArr4[i33] = (byte) (i50 >>> 16);
                    bArr4[i30] = (byte) (i50 >>> 24);
                    int i51 = (-11) - (i32 | ((-15) - i9));
                    int length6 = bArr4.length;
                    int a6 = AbstractC0044j.a(bArr4.length);
                    int i52 = ((i51 > (((length6 & (~a6)) * 2) - (length6 ^ a6)) ? 1 : (i51 == (((length6 & (~a6)) * 2) - (length6 ^ a6)) ? 0 : -1)) >>> 31) & 1;
                    if (i52 != 0) {
                        i11 = -897645243;
                    } else {
                        i11 = 1251644638;
                    }
                    i9 = i51;
                    bArr3 = bArr7;
                    c4 = c5;
                    if (i52 != 0) {
                        i6 = i29;
                        i8 = i28;
                        i7 = 1;
                        i11 = -1469476344;
                    } else {
                        i6 = i29;
                        i8 = i28;
                        i7 = 1;
                    }
                case 1758587480:
                    i4 = i8;
                    i5 = i6;
                    int length7 = bArr4.length;
                    int i53 = 0 - i10;
                    if ((bArr5[((length7 | i53) - ((822835569 & (~i53)) & length7)) + ((i53 | 822835569) & length7)] > Double.NaN ? 1 : (bArr5[((length7 | i53) - ((822835569 & (~i53)) & length7)) + ((i53 | 822835569) & length7)] == Double.NaN ? 0 : -1)) <= -1) {
                        i11 = -897645243;
                    } else {
                        i11 = -1057239115;
                    }
                    i12 = i10;
                    c4 = c5;
                    i6 = i5;
                    i8 = i4;
                case 2013813686:
                    int length8 = bArr4.length % 4;
                    i4 = i8;
                    i5 = i6;
                    int i54 = ((length8 > j3 ? 1 : (length8 == j3 ? 0 : -1)) >>> 31) & i7;
                    if (i54 != 0) {
                        i11 = 2100390411;
                    } else {
                        i11 = -897645243;
                    }
                    if (i54 != 0) {
                        i10 = length8;
                        c4 = c5;
                        i6 = i5;
                        i8 = i4;
                    } else {
                        i3 = i7;
                        i10 = length8;
                        bArr = bArr3;
                        i = i4;
                        int i212 = i;
                        i11 = -2079636786;
                        i8 = i212;
                        bArr3 = bArr;
                        c4 = c5;
                        i7 = i3;
                        i6 = 0;
                    }
                default:
                    c4 = c5;
                    i11 = -897645243;
            }
            int i55 = i6;
            kotlin.jvm.internal.j.e(c0027e2, new String(bArr2, StandardCharsets.UTF_8).intern());
            List list = c0027e2.f505b;
            List list2 = c0027e2.f504a;
            List list3 = this.f504a;
            int f4 = kotlin.jvm.internal.j.f(list3.size(), list2.size());
            if (f4 != 0) {
                return f4;
            }
            int size = list3.size();
            for (int i56 = i55; i56 < size; i56++) {
                int compareTo = ((E2) list3.get(i56)).compareTo((E2) list2.get(i56));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            List list4 = this.f505b;
            int f5 = kotlin.jvm.internal.j.f(list4.size(), list.size());
            if (f5 != 0) {
                return f5;
            }
            int size2 = list4.size();
            for (int i57 = i55; i57 < size2; i57++) {
                int compare = f503c.compare(list4.get(i57), list.get(i57));
                if (compare != 0) {
                    return compare;
                }
            }
            return i55;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0008. Please report as an issue. */
    public final boolean equals(Object obj) {
        char c4 = 50935;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 60137:
                    break;
                case 53542:
                    z3 = true;
                    c4 = 60137;
                case 43114:
                    if (compareTo((C0027e2) obj) == 0) {
                        c4 = 53542;
                    } else {
                        c4 = 38412;
                    }
                case 38412:
                    z3 = false;
                    c4 = 60137;
                case 50935:
                    if (obj instanceof C0027e2) {
                        c4 = 43114;
                    } else {
                        c4 = 38412;
                    }
                default:
                    c4 = 53542;
            }
            return z3;
        }
    }

    public final int hashCode() {
        Iterator it = null;
        int i = 0;
        int i3 = 0;
        char c4 = 59867;
        while (c4 != 12008) {
            if (c4 != 59867) {
                if (c4 != 18804) {
                    if (c4 != 34954 || it.hasNext()) {
                        c4 = 18804;
                    } else {
                        c4 = 12008;
                    }
                } else {
                    int hashCode = Arrays.hashCode((byte[]) it.next());
                    i3 = V2.a(hashCode, ~(i3 * 31), ((~hashCode) - r5) - 1);
                }
            } else {
                int hashCode2 = this.f504a.hashCode();
                i = ((hashCode2 & (-32)) * ((~hashCode2) & 31)) + ((hashCode2 & 31) * (hashCode2 | 31));
                it = this.f505b.iterator();
                i3 = 0;
            }
            c4 = 34954;
        }
        return i + i3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0071. Please report as an issue. */
    public final String toString() {
        byte[] bArr;
        Object obj;
        int i;
        int i3;
        int i4;
        Iterator it;
        int i5;
        int i6;
        byte[] bArr2;
        Object obj2;
        int i7;
        Iterator it2;
        int i8;
        int i9 = 0;
        byte[] bArr3 = new byte[0];
        char c4 = 40287;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        Object obj3 = null;
        StringBuilder sb = null;
        Iterator it3 = null;
        StringBuilder sb2 = null;
        Object obj4 = null;
        while (true) {
            int i18 = i9;
            switch (c4) {
                case 5416:
                    i10 = this.f505b.size();
                    obj3 = this.f505b.iterator();
                    c4 = 666;
                    i9 = i18;
                    i11 = i9;
                    i16 = i11;
                case 11757:
                    c4 = 666;
                    i9 = i18;
                    i11 = i11;
                case 666:
                    bArr = bArr3;
                    obj = obj3;
                    i = i11;
                    i3 = i14;
                    i4 = i15;
                    it = it3;
                    i5 = i16;
                    i6 = i10;
                    c4 = ((Iterator) obj).hasNext() ? (char) 61783 : (char) 37227;
                    i10 = i6;
                    i15 = i4;
                    i9 = i18;
                    obj3 = obj;
                    bArr3 = bArr;
                    it3 = it;
                    i11 = i;
                    i16 = i5;
                    i14 = i3;
                case 61783:
                    byte[] bArr4 = bArr3;
                    Object obj5 = obj3;
                    int i19 = i11;
                    int i20 = i14;
                    int i21 = i15;
                    Iterator it4 = it3;
                    int i22 = i16;
                    int i23 = i10;
                    obj4 = ((Iterator) obj5).next();
                    int i24 = i19 + 1;
                    c4 = i19 < 0 ? (char) 5261 : (char) 4097;
                    i10 = i23;
                    i15 = i21;
                    i9 = i18;
                    bArr3 = bArr4;
                    it3 = it4;
                    i17 = i19;
                    i16 = i22;
                    i14 = i20;
                    i11 = i24;
                    obj3 = obj5;
                case 41616:
                    AbstractC0708j.X();
                    throw null;
                case 33227:
                    bArr = bArr3;
                    obj = obj3;
                    i = i11;
                    i3 = i14;
                    i4 = i15;
                    it = it3;
                    i5 = i16;
                    i6 = i10;
                    c4 = i12 < i13 ? (char) 64074 : (char) 11757;
                    i10 = i6;
                    i15 = i4;
                    i9 = i18;
                    obj3 = obj;
                    bArr3 = bArr;
                    it3 = it;
                    i11 = i;
                    i16 = i5;
                    i14 = i3;
                case 40287:
                    byte[] bArr5 = bArr3;
                    int i25 = i11;
                    i3 = i14;
                    int i26 = i10;
                    sb2 = new StringBuilder();
                    byte[] bArr6 = new byte[25];
                    bArr6[0] = -67;
                    bArr6[1] = -93;
                    bArr6[2] = 72;
                    bArr6[3] = 78;
                    bArr6[4] = -113;
                    bArr6[5] = 52;
                    bArr6[6] = 21;
                    bArr6[7] = -10;
                    bArr6[8] = 64;
                    bArr6[9] = -92;
                    bArr6[10] = -82;
                    bArr6[11] = -2;
                    bArr6[12] = -125;
                    bArr6[13] = -17;
                    bArr6[14] = -82;
                    bArr6[15] = -33;
                    bArr6[16] = 120;
                    bArr6[17] = -25;
                    bArr6[18] = 31;
                    bArr6[19] = -75;
                    long j2 = -1;
                    long j3 = 0;
                    long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j5 = (j4 >>> 48) & 21845;
                    long j6 = (j5 | (j5 >>> 1)) & 858993459;
                    long j7 = (j6 | (j6 >>> 2)) & 252645135;
                    long j8 = (j4 >>> 32) & 21845;
                    long j9 = ((j8 >>> 1) | j8) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + (((j7 | (j7 >>> 4)) & 16711935) << 24);
                    long j12 = (j4 >>> 16) & 21845;
                    long j13 = ((j12 >>> 1) | j12) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = j4 & 21845;
                    long j16 = (j15 | (j15 >>> 1)) & 858993459;
                    long j17 = (j16 | (j16 >>> 2)) & 252645135;
                    int i27 = (((int) (((j17 | (j17 >>> 4)) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) | (-478365724)) & 1405093504;
                    bArr6[AbstractC0099x.a(i27 | (-2012217228), 2, (~i27) ^ (-2012217228)) ^ (-607123744)] = -57;
                    bArr6[21] = 42;
                    bArr6[22] = -85;
                    bArr6[23] = -8;
                    bArr6[24] = 19;
                    byte[] bArr7 = new byte[25];
                    bArr7[0] = -86;
                    bArr7[1] = 41;
                    bArr7[2] = 55;
                    bArr7[3] = 88;
                    bArr7[4] = 41;
                    bArr7[5] = -96;
                    bArr7[6] = 120;
                    bArr7[7] = -102;
                    bArr7[8] = -57;
                    bArr7[9] = -109;
                    bArr7[10] = 12;
                    bArr7[11] = 117;
                    bArr7[12] = -62;
                    bArr7[13] = 52;
                    bArr7[AbstractC0099x.a(1304694828, 2, -1304694829) ^ 1304694818] = -92;
                    bArr7[15] = -39;
                    bArr7[16] = 86;
                    bArr7[17] = 103;
                    bArr7[18] = 90;
                    bArr7[19] = 64;
                    bArr7[20] = -97;
                    bArr7[21] = -121;
                    bArr7[22] = -122;
                    bArr7[23] = -54;
                    bArr7[24] = 40;
                    b(bArr6, bArr7);
                    sb2.append(new String(bArr6, StandardCharsets.UTF_8).intern());
                    i15 = this.f504a.size();
                    it3 = this.f504a.iterator();
                    c4 = 4399;
                    i10 = i26;
                    sb = sb2;
                    i9 = 0;
                    i16 = 0;
                    obj3 = obj3;
                    bArr3 = bArr5;
                    i11 = i25;
                    i14 = i3;
                case 38304:
                    byte[] bArr8 = bArr3;
                    Object obj6 = obj3;
                    int i28 = i11;
                    Iterator it5 = it3;
                    int i29 = i16;
                    long j18 = 82720;
                    int i30 = i10;
                    long j19 = 1;
                    long j20 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j21 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j20;
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
                    byte[] bArr9 = {84, -40, -96, -46, 24, -8, 88, 84, -25, 10, -83, -82, (-519486691) ^ (1610694929 + (((int) ((((j34 >>> 4) | j34) & 16711935) + (((((j31 >>> 4) | j31) & 16711935) << 8) + j28))) | (-2130181600))), -47, 97, 75, -75, -79};
                    b(bArr9, new byte[]{-83, -111, -38, -121, -39, 119, 39, -13, -47, 71, 82, -43, 17, 79, -22, -22, 106, -81});
                    Charset charset = StandardCharsets.UTF_8;
                    sb.append(new String(bArr9, charset).intern());
                    sb.append(i14 + 1);
                    byte[] bArr10 = {-118};
                    b(bArr10, new byte[]{39, -91, -84, -126, 123, 102, 118, 66});
                    sb.append(new String(bArr10, charset).intern());
                    sb.append(i15);
                    byte[] bArr11 = new byte[5];
                    bArr11[0] = -62;
                    bArr11[1] = -103;
                    bArr11[2] = 28;
                    bArr11[3] = 114;
                    long j35 = 773423616;
                    int i31 = i14;
                    int i32 = i15;
                    long j36 = 0;
                    long j37 = ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j38 = (j37 >>> 48) & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    long j41 = (j37 >>> 32) & 43690;
                    long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) + ((((j40 >>> 4) | j40) & 16711935) << 24);
                    long j45 = (j37 >>> 16) & 43690;
                    long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                    long j47 = ((j46 >>> 2) | j46) & 252645135;
                    long j48 = j37 & 43690;
                    long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
                    long j50 = ((j49 >>> 2) | j49) & 252645135;
                    bArr11[1847168630 ^ (1310198322 + (((int) ((((((j47 >>> 4) | j47) & 16711935) << 8) | j44) | (((j50 >>> 4) | j50) & 16711935))) | 536970304))] = -11;
                    byte[] bArr12 = new byte[8];
                    bArr12[0] = -109;
                    bArr12[1] = -1;
                    bArr12[2] = 57;
                    bArr12[3] = -6;
                    long j51 = -1;
                    long j52 = ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j20;
                    long j53 = (j52 >>> 48) & 21845;
                    long j54 = ((j53 >>> 1) | j53) & 858993459;
                    long j55 = ((j54 >>> 2) | j54) & 252645135;
                    long j56 = (j52 >>> 32) & 21845;
                    long j57 = ((j56 >>> 1) | j56) & 858993459;
                    long j58 = ((j57 >>> 2) | j57) & 252645135;
                    long j59 = ((((j58 >>> 4) | j58) & 16711935) << 16) + ((((j55 >>> 4) | j55) & 16711935) << 24);
                    long j60 = (j52 >>> 16) & 21845;
                    long j61 = ((j60 >>> 1) | j60) & 858993459;
                    long j62 = ((j61 >>> 2) | j61) & 252645135;
                    long j63 = j52 & 21845;
                    long j64 = ((j63 >>> 1) | j63) & 858993459;
                    long j65 = ((j64 >>> 2) | j64) & 252645135;
                    bArr12[(((((int) ((((j65 >>> 4) | j65) & 16711935) + (((((j62 >>> 4) | j62) & 16711935) << 8) | j59))) | 1510754638) & (-2104191534)) + 4194829) ^ (-2099996709)] = 58;
                    bArr12[5] = 72;
                    bArr12[6] = -21;
                    bArr12[7] = 5;
                    b(bArr11, bArr12);
                    sb.append(new String(bArr11, charset).intern());
                    sb.append((E2) obj6);
                    c4 = 4399;
                    i10 = i30;
                    i15 = i32;
                    obj3 = obj6;
                    bArr3 = bArr8;
                    it3 = it5;
                    i11 = i28;
                    i16 = i29;
                    i14 = i31;
                    i9 = 0;
                case 4399:
                    bArr2 = bArr3;
                    obj2 = obj3;
                    i7 = i11;
                    it2 = it3;
                    i8 = i16;
                    c4 = it2.hasNext() ? (char) 5711 : (char) 5416;
                    obj3 = obj2;
                    bArr3 = bArr2;
                    it3 = it2;
                    i11 = i7;
                    i16 = i8;
                    i9 = 0;
                case 5261:
                    AbstractC0708j.X();
                    throw null;
                case 5711:
                    byte[] bArr13 = bArr3;
                    int i33 = i11;
                    Iterator it6 = it3;
                    int i34 = i16;
                    obj3 = it6.next();
                    int i35 = i34 + 1;
                    if (i34 < 0) {
                        i16 = i35;
                        c4 = 41616;
                    } else {
                        c4 = 38304;
                        i16 = i35;
                    }
                    bArr3 = bArr13;
                    it3 = it6;
                    i11 = i33;
                    i14 = i34;
                    i9 = 0;
                case 64074:
                    obj2 = obj3;
                    i7 = i11;
                    byte b4 = bArr3[i12];
                    byte[] bArr14 = {35, 9, 125, -46, 74};
                    bArr2 = bArr3;
                    long j66 = -1869467364;
                    long j67 = -1;
                    long j68 = (((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j69 = (j68 >>> 48) & 43690;
                    long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                    long j71 = ((j70 >>> 2) | j70) & 252645135;
                    long j72 = (j68 >>> 32) & 43690;
                    long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
                    long j74 = ((j73 >>> 2) | j73) & 252645135;
                    long j75 = ((((j74 >>> 4) | j74) & 16711935) << 16) | ((((j71 >>> 4) | j71) & 16711935) << 24);
                    long j76 = (j68 >>> 16) & 43690;
                    long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
                    long j78 = ((j77 >>> 2) | j77) & 252645135;
                    long j79 = ((((j78 >>> 4) | j78) & 16711935) << 8) + j75;
                    long j80 = j68 & 43690;
                    long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
                    long j82 = ((j81 >>> 2) | j81) & 252645135;
                    b(bArr14, new byte[]{37, 18, (((int) ((((j82 >>> 4) | j82) & 16711935) + j79)) + 157892832) ^ 1711574579, 16, -108, 33, 11, -57});
                    Charset charset2 = StandardCharsets.UTF_8;
                    String format = String.format(new String(bArr14, charset2).intern(), Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
                    byte[] bArr15 = {-13, 68, 53, -120, -41, -106, -112, -99, 46, -22, -106};
                    it2 = it3;
                    i8 = i16;
                    long j83 = -1307291814;
                    long j84 = 1307291835;
                    long j85 = (((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j86 = (j85 >>> 48) & 21845;
                    long j87 = ((j86 >>> 1) | j86) & 858993459;
                    long j88 = ((j87 >>> 2) | j87) & 252645135;
                    long j89 = (j85 >>> 32) & 21845;
                    long j90 = ((j89 >>> 1) | j89) & 858993459;
                    long j91 = ((j90 >>> 2) | j90) & 252645135;
                    long j92 = ((((j91 >>> 4) | j91) & 16711935) << 16) + ((((j88 >>> 4) | j88) & 16711935) << 24);
                    long j93 = (j85 >>> 16) & 21845;
                    long j94 = ((j93 >>> 1) | j93) & 858993459;
                    long j95 = ((j94 >>> 2) | j94) & 252645135;
                    long j96 = j85 & 21845;
                    long j97 = ((j96 >>> 1) | j96) & 858993459;
                    long j98 = ((j97 >>> 2) | j97) & 252645135;
                    b(bArr15, new byte[]{-44, -65, -60, 0, 27, -127, (int) ((((j98 >>> 4) | j98) & 16711935) | (((((j95 >>> 4) | j95) & 16711935) << 8) + j92)), 121, 94, 111, 88});
                    new String(bArr15, charset2).intern();
                    sb.append(format);
                    i12++;
                    c4 = 33227;
                    obj3 = obj2;
                    bArr3 = bArr2;
                    it3 = it2;
                    i11 = i7;
                    i16 = i8;
                    i9 = 0;
                case 37227:
                    String sb3 = sb2.toString();
                    byte[] bArr16 = {34, -16, -57, -89, 101, -85, 14, -82, -1, -47, -70, -71, -23};
                    long j99 = -2143221728;
                    long j100 = 1;
                    long j101 = ((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
                    long j102 = (j101 >>> 48) & 43690;
                    long j103 = ((j102 >>> 2) | (j102 >>> 1)) & 858993459;
                    long j104 = (j103 | (j103 >>> 2)) & 252645135;
                    long j105 = (j101 >>> 32) & 43690;
                    long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
                    long j107 = (j106 | (j106 >>> 2)) & 252645135;
                    long j108 = (((j104 | (j104 >>> 4)) & 16711935) << 24) | (((j107 | (j107 >>> 4)) & 16711935) << 16);
                    long j109 = (j101 >>> 16) & 43690;
                    long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
                    long j111 = (j110 | (j110 >>> 2)) & 252645135;
                    long j112 = j101 & 43690;
                    long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
                    long j114 = (j113 | (j113 >>> 2)) & 252645135;
                    int i36 = (-2009051099) + (((int) (((j114 | (j114 >>> 4)) & 16711935) | ((((j111 | (j111 >>> 4)) & 16711935) << 8) + j108))) | 268544008);
                    b(bArr16, new byte[]{-96, -64, ((-1740507135) | i36) - (i36 & (-1740507135)), 114, 96, 106, 79, -65, -22, -81, -122, -40, 119});
                    kotlin.jvm.internal.j.d(sb3, new String(bArr16, StandardCharsets.UTF_8).intern());
                    return sb3;
                case 4097:
                    byte[] bArr17 = (byte[]) obj4;
                    byte[] bArr18 = new byte[18];
                    Object obj7 = obj3;
                    bArr18[i18] = AbstractC0099x.a(-1843740214, 2, 1843740213) ^ (-1843740177);
                    bArr18[1] = 68;
                    bArr18[2] = -94;
                    bArr18[3] = -97;
                    bArr18[4] = 66;
                    bArr18[5] = -63;
                    bArr18[6] = 99;
                    bArr18[7] = -84;
                    bArr18[8] = 115;
                    bArr18[9] = -24;
                    bArr18[10] = 98;
                    bArr18[11] = 66;
                    bArr18[12] = 32;
                    bArr18[AbstractC0099x.a(-2070098472, 2, 2070098471) ^ (-2070098475)] = 38;
                    long j115 = 1912733968;
                    long j116 = i18;
                    long j117 = ((((((((j116 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j116 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j118 = (((((((j116 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j119 = (((((((j116 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j120 = (((((((((j115 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j115 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j115 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j115 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j119 | j118 | j117) + 6148914691236517205L;
                    long j121 = (j120 >>> 48) & 43690;
                    long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                    long j123 = ((j122 >>> 2) | j122) & 252645135;
                    long j124 = (j120 >>> 32) & 43690;
                    long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
                    long j126 = ((j125 >>> 2) | j125) & 252645135;
                    long j127 = ((((j126 >>> 4) | j126) & 16711935) << 16) | ((((j123 >>> 4) | j123) & 16711935) << 24);
                    long j128 = (j120 >>> 16) & 43690;
                    long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
                    long j130 = ((j129 >>> 2) | j129) & 252645135;
                    long j131 = j120 & 43690;
                    long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
                    long j133 = ((j132 >>> 2) | j132) & 252645135;
                    bArr18[(-207146215) ^ ((-2119880185) + ((int) ((((j133 >>> 4) | j133) & 16711935) + (((((j130 >>> 4) | j130) & 16711935) << 8) | j127))))] = -2;
                    bArr18[15] = 24;
                    bArr18[16] = -126;
                    bArr18[17] = -12;
                    byte[] bArr19 = new byte[18];
                    bArr19[0] = -13;
                    bArr19[1] = -44;
                    bArr19[2] = -10;
                    bArr19[3] = -12;
                    bArr19[4] = -74;
                    bArr19[5] = 29;
                    bArr19[6] = -17;
                    bArr19[7] = 36;
                    bArr19[8] = 93;
                    int i37 = i11;
                    long j134 = -1;
                    long j135 = 1;
                    long j136 = (((((((((j134 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j134 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j134 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j134 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j135 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j135 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j135 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j135 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j137 = (j136 >>> 48) & 21845;
                    long j138 = ((j137 >>> 1) | j137) & 858993459;
                    long j139 = ((j138 >>> 2) | j138) & 252645135;
                    long j140 = (j136 >>> 32) & 21845;
                    long j141 = ((j140 >>> 1) | j140) & 858993459;
                    long j142 = ((j141 >>> 2) | j141) & 252645135;
                    long j143 = ((((j142 >>> 4) | j142) & 16711935) << 16) + ((((j139 >>> 4) | j139) & 16711935) << 24);
                    long j144 = (j136 >>> 16) & 21845;
                    long j145 = ((j144 >>> 1) | j144) & 858993459;
                    long j146 = ((j145 >>> 2) | j145) & 252645135;
                    long j147 = j136 & 21845;
                    long j148 = ((j147 >>> 1) | j147) & 858993459;
                    long j149 = ((j148 >>> 2) | j148) & 252645135;
                    int i38 = (int) ((((j149 >>> 4) | j149) & 16711935) + (((((j146 >>> 4) | j146) & 16711935) << 8) | j143));
                    bArr19[((268568098 & (((~i38) & (-1964365954)) + i38)) + 25956352) ^ 294524459] = 37;
                    bArr19[10] = -66;
                    bArr19[11] = -2;
                    bArr19[12] = 15;
                    bArr19[13] = -13;
                    bArr19[14] = -88;
                    bArr19[15] = 106;
                    bArr19[16] = -54;
                    bArr19[17] = -51;
                    b(bArr18, bArr19);
                    Charset charset3 = StandardCharsets.UTF_8;
                    sb.append(new String(bArr18, charset3).intern());
                    sb.append(i17 + 1);
                    byte[] bArr20 = {-91};
                    long j150 = 6554144;
                    long b5 = c3.b((((((((j150 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j150 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j150 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j150 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j118 + j117 + j119, 6148914691236517205L);
                    long j151 = (b5 >>> 48) & 43690;
                    long j152 = ((j151 >>> 2) | (j151 >>> 1)) & 858993459;
                    long j153 = ((j152 >>> 2) | j152) & 252645135;
                    long j154 = (b5 >>> 32) & 43690;
                    long j155 = ((j154 >>> 2) | (j154 >>> 1)) & 858993459;
                    long j156 = ((j155 >>> 2) | j155) & 252645135;
                    long j157 = ((((j156 >>> 4) | j156) & 16711935) << 16) + ((((j153 >>> 4) | j153) & 16711935) << 24);
                    long j158 = (b5 >>> 16) & 43690;
                    long j159 = ((j158 >>> 2) | (j158 >>> 1)) & 858993459;
                    long j160 = ((j159 >>> 2) | j159) & 252645135;
                    long j161 = b5 & 43690;
                    long j162 = ((j161 >>> 2) | (j161 >>> 1)) & 858993459;
                    long j163 = ((j162 >>> 2) | j162) & 252645135;
                    b(bArr20, new byte[]{-8, -118, 124, -112, 9, 43, 98, 681305562 ^ ((-687859705) + ((int) ((((j163 >>> 4) | j163) & 16711935) + (((((j160 >>> 4) | j160) & 16711935) << 8) + j157))))});
                    sb.append(new String(bArr20, charset3).intern());
                    sb.append(i10);
                    byte[] bArr21 = {94};
                    b(bArr21, new byte[]{-24, 100, -120, -33, -100, -91, 111, -45});
                    sb.append(new String(bArr21, charset3).intern());
                    i13 = bArr17.length;
                    c4 = 33227;
                    bArr3 = bArr17;
                    obj3 = obj7;
                    i11 = i37;
                    i9 = 0;
                    i12 = 0;
                default:
                    c4 = 41616;
                    i9 = i18;
            }
        }
    }
}
