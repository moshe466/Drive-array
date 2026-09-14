package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.s1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0081s1 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0021d0 f657f;

    /* renamed from: g, reason: collision with root package name */
    public final C0054l1 f658g;

    static {
        long j2 = -1;
        long j3 = 4;
        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j8 = ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j9 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j10 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j11 = j10 + j9 + j8 + j7 + j6 + (j5 | j4);
        long j12 = (j11 >>> 48) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = (j11 >>> 32) & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        long j18 = ((((j17 >>> 4) | j17) & 16711935) << 16) + ((((j14 >>> 4) | j14) & 16711935) << 24);
        long j19 = (j11 >>> 16) & 21845;
        long j20 = ((j19 >>> 1) | j19) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = j11 & 21845;
        long j23 = ((j22 >>> 1) | j22) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = 268435532;
        long j26 = 4;
        long j27 = (((((((((j25 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j25 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j25 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j25 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j26 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j26 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j26 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j26 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
        long j28 = (j27 >>> 48) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = (j27 >>> 32) & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = ((((j33 >>> 4) | j33) & 16711935) << 16) + ((((j30 >>> 4) | j30) & 16711935) << 24);
        long j35 = (j27 >>> 16) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        long j38 = j27 & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = (j39 | (j39 >>> 2)) & 252645135;
        byte[] bArr = {39, -21, -75, 22, -49, -14, 25, -90, (((((int) ((((j24 >>> 4) | j24) & 16711935) | (((((j21 >>> 4) | j21) & 16711935) << 8) + j18))) | (-2138739238)) & (-1504345984)) + ((int) (((j40 | (j40 >>> 4)) & 16711935) | (((((j37 >>> 4) | j37) & 16711935) << 8) | j34)))) ^ (-1235910459)};
        byte[] bArr2 = new byte[9];
        bArr2[0] = 48;
        bArr2[1] = -68;
        bArr2[2] = 106;
        bArr2[3] = -63;
        long j41 = j10 + (j9 | j8) + (j7 | (j5 + j4 + j6));
        long j42 = (j41 >>> 48) & 21845;
        long j43 = (j42 | (j42 >>> 1)) & 858993459;
        long j44 = (j43 | (j43 >>> 2)) & 252645135;
        long j45 = (j41 >>> 32) & 21845;
        long j46 = (j45 | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        long j48 = (((j44 | (j44 >>> 4)) & 16711935) << 24) | (((j47 | (j47 >>> 4)) & 16711935) << 16);
        long j49 = (j41 >>> 16) & 21845;
        long j50 = (j49 | (j49 >>> 1)) & 858993459;
        long j51 = (j50 | (j50 >>> 2)) & 252645135;
        long j52 = (((j51 | (j51 >>> 4)) & 16711935) << 8) + j48;
        long j53 = j41 & 21845;
        long j54 = (j53 | (j53 >>> 1)) & 858993459;
        long j55 = (j54 | (j54 >>> 2)) & 252645135;
        int i = (int) (((j55 | (j55 >>> 4)) & 16711935) + j52);
        int i3 = -((1111504244 - (i | 1732671350)) + ((1694918262 | i) - 4));
        bArr2[1130411896 ^ (((~i3) & 18907660) - (i3 & (-18907661)))] = -33;
        bArr2[5] = -67;
        bArr2[6] = -1;
        bArr2[7] = 119;
        bArr2[8] = 123;
        z(bArr, bArr2);
        new String(bArr, StandardCharsets.UTF_8).intern();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0081s1(C0093v1 c0093v1, C0021d0 c0021d0, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = {-35, 3, -72, 28, -95, 42};
        k(bArr, new byte[]{-91, 88, -60, 41, 19, 44, -105, -84});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = {-81, 1, 119, 68, 65, 19};
        k(bArr2, new byte[]{95, 97, 46, -36, -46, -93, -6, -17});
        kotlin.jvm.internal.j.e(c0021d0, new String(bArr2, charset).intern());
        byte[] bArr3 = {118, 78, -61, 63, -23, -77, -101, -126};
        k(bArr3, new byte[]{10, 117, -66, -114, 96, 21, -31, 92});
        new String(bArr3, charset).intern();
        this.f657f = c0021d0;
        this.f658g = c0054l1;
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
        int i7 = ~AbstractC0081s1.class.getName().length();
        int length3 = (((~(((AbstractC0081s1.class.getName().length() | 70245657) | i7) - (i7 | (AbstractC0081s1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((AbstractC0081s1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(AbstractC0081s1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((AbstractC0081s1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~AbstractC0081s1.class.getName().length()) | (-576567005)) & 276971586) + ((AbstractC0081s1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~AbstractC0081s1.class.getName().length()) | (-1157759625)) & 1755853004) + ((AbstractC0081s1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~AbstractC0081s1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = AbstractC0081s1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~AbstractC0081s1.class.getName().length()) | (-1064961)) + 689325073) + ((AbstractC0081s1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~AbstractC0081s1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = AbstractC0081s1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~AbstractC0081s1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (AbstractC0081s1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((AbstractC0081s1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~AbstractC0081s1.class.getName().length();
                    int length11 = (161497089 & (((((AbstractC0081s1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((AbstractC0081s1.class.getName().length() | i14) & 797295576))) + ((AbstractC0081s1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~AbstractC0081s1.class.getName().length()) | (-1085986263)) & 1078327440) + ((AbstractC0081s1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~AbstractC0081s1.class.getName().length();
                    int length12 = length5 >>> ((((~(((AbstractC0081s1.class.getName().length() | 626856794) | i15) - ((AbstractC0081s1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((AbstractC0081s1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~AbstractC0081s1.class.getName().length()) | 1248713193) & 826417528) + ((AbstractC0081s1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~AbstractC0081s1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (AbstractC0081s1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~AbstractC0081s1.class.getName().length()) | (-1005965450)) & 153223237) + ((AbstractC0081s1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((AbstractC0081s1.class.getName().length() & (~length6)) & i9)) + ((AbstractC0081s1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~AbstractC0081s1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((AbstractC0081s1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~AbstractC0081s1.class.getName().length()) | (-23496740)) & 827084804) + ((AbstractC0081s1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~AbstractC0081s1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (AbstractC0081s1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~AbstractC0081s1.class.getName().length()) | (-961655275)) & 25184460) + ((AbstractC0081s1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~AbstractC0081s1.class.getName().length()) | 1233459797) & 125923146) + ((AbstractC0081s1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~AbstractC0081s1.class.getName().length()) | (-7107622)) & 402932290) + ((AbstractC0081s1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((AbstractC0081s1.class.getName().length() | length15) - (b4 | length15)) + I2.a(AbstractC0081s1.class, b4) + (AbstractC0081s1.class.getName().length() & length15);
                    int length17 = ((((~AbstractC0081s1.class.getName().length()) | (-81143879)) & 438583424) + ((AbstractC0081s1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~AbstractC0081s1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((AbstractC0081s1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(AbstractC0081s1.class, 568748773 | i24) + (AbstractC0081s1.class.getName().length() & (-2105278367)))) + ((AbstractC0081s1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~AbstractC0081s1.class.getName().length()) | (-1592082969)) & 140665109) + ((AbstractC0081s1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~AbstractC0081s1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((AbstractC0081s1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~AbstractC0081s1.class.getName().length()) | (-180811308));
                    int length19 = (AbstractC0081s1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((AbstractC0081s1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | AbstractC0081s1.class.getName().length()))));
                    int i29 = ((~AbstractC0081s1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (AbstractC0081s1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~AbstractC0081s1.class.getName().length()) | 75364313) & 1242301609) + ((AbstractC0081s1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = AbstractC0081s1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((AbstractC0081s1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~AbstractC0081s1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((AbstractC0081s1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~AbstractC0081s1.class.getName().length();
                    int length24 = 1409942802 & (((((AbstractC0081s1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | AbstractC0081s1.class.getName().length()) & 91135407));
                    int length25 = (AbstractC0081s1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~AbstractC0081s1.class.getName().length()) | (-537919489)) - (-806798471)) + ((AbstractC0081s1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~AbstractC0081s1.class.getName().length()) | (-382746167)) & 102532165) + ((AbstractC0081s1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~AbstractC0081s1.class.getName().length()) | (-6036961)) & 1233145505) + ((AbstractC0081s1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~AbstractC0081s1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = AbstractC0081s1.class.getName().length() & 268460041;
                    i5 = (((((AbstractC0081s1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | AbstractC0081s1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = AbstractC0081s1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((AbstractC0081s1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~AbstractC0081s1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((AbstractC0081s1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~AbstractC0081s1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (AbstractC0081s1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(AbstractC0081s1.class, -1) | (-532481)) - (-67641369)) + ((AbstractC0081s1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~AbstractC0081s1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((AbstractC0081s1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(AbstractC0081s1.class, -1) | (-33554434)) - (-1107366402)) + ((AbstractC0081s1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(AbstractC0081s1.class, -1) | (-167014194)) & 1157999680) + ((AbstractC0081s1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = AbstractC0081s1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((AbstractC0081s1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(AbstractC0081s1.class, -1) | 114408723) & 1183666176;
                    int length33 = AbstractC0081s1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~AbstractC0081s1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = AbstractC0081s1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~AbstractC0081s1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (AbstractC0081s1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~AbstractC0081s1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((AbstractC0081s1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~AbstractC0081s1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (AbstractC0081s1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~AbstractC0081s1.class.getName().length()) | 991120067) & (-2113137661)) + ((AbstractC0081s1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(AbstractC0081s1.class, -1) | 314136709) & 371231304) + (((AbstractC0081s1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~AbstractC0081s1.class.getName().length()) | 366661365) & 1344150018) + ((AbstractC0081s1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~AbstractC0081s1.class.getName().length()) | (-1359635359)) & 49026131) + ((AbstractC0081s1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~AbstractC0081s1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = AbstractC0081s1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (AbstractC0081s1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~AbstractC0081s1.class.getName().length()) | 1110430873) & 1241612298) + ((AbstractC0081s1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~AbstractC0081s1.class.getName().length()) | 1603962366) & 25199440) + (((AbstractC0081s1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~AbstractC0081s1.class.getName().length()) | (-1388708984)) & 706816128) + ((AbstractC0081s1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~AbstractC0081s1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = AbstractC0081s1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~AbstractC0081s1.class.getName().length()) | 2113158628) & 1026558002) + ((AbstractC0081s1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~AbstractC0081s1.class.getName().length()) | 715175224) & 136512788) + ((AbstractC0081s1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~AbstractC0081s1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = AbstractC0081s1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~AbstractC0081s1.class.getName().length()) | (-1084937228)) & 438503696) + ((AbstractC0081s1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~AbstractC0081s1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((AbstractC0081s1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(AbstractC0081s1.class, 1197735420 | i53) + (AbstractC0081s1.class.getName().length() & 674349280))) + ((AbstractC0081s1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~AbstractC0081s1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (AbstractC0081s1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~AbstractC0081s1.class.getName().length()) | (-171976913)) & 318775824) + ((AbstractC0081s1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~AbstractC0081s1.class.getName().length()) | (-616910267)) & 1303391760) + ((AbstractC0081s1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~AbstractC0081s1.class.getName().length()) | 1297715640) & 556926729) + ((AbstractC0081s1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~AbstractC0081s1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((AbstractC0081s1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~AbstractC0081s1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (AbstractC0081s1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
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
}
