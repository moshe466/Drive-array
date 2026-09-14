package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.e1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0026e1 extends G2 {

    /* renamed from: d, reason: collision with root package name */
    public final String f501d;

    /* renamed from: e, reason: collision with root package name */
    public final C0084t0 f502e;

    static {
        byte[] bArr = {44, 56, 35, 54, 80};
        e(bArr, new byte[]{107, 35, 60, 62, 102, -8, -110, 109});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = new byte[((((C0026e1.class.getName().length() & 35784716) | 34078880) - (~(((~C0026e1.class.getName().length()) | 1674168195) & 10717197))) - 1) ^ 44796086];
        bArr2[0] = -45;
        bArr2[1] = 54;
        bArr2[2] = -32;
        bArr2[3] = 110;
        bArr2[4] = -100;
        bArr2[5] = 34;
        bArr2[6] = 109;
        int length = (((~C0026e1.class.getName().length()) | (-1223103327)) & 156508215) + ((C0026e1.class.getName().length() & 139345942) | 705536);
        bArr2[E1.a(length | 157213744, 157213744, length)] = -69;
        bArr2[8] = -68;
        bArr2[9] = 118;
        bArr2[10] = -49;
        bArr2[11] = 56;
        bArr2[12] = 69;
        bArr2[13] = -87;
        bArr2[14] = -43;
        bArr2[15] = -11;
        bArr2[16] = 84;
        bArr2[17] = 106;
        bArr2[18] = 5;
        bArr2[19] = -66;
        bArr2[20] = -61;
        bArr2[21] = 29;
        bArr2[22] = -37;
        bArr2[23] = -51;
        bArr2[24] = 108;
        bArr2[25] = -71;
        bArr2[26] = 63;
        byte[] bArr3 = new byte[27];
        bArr3[0] = 14;
        bArr3[1] = 91;
        bArr3[2] = -36;
        bArr3[3] = 24;
        bArr3[4] = -44;
        bArr3[5] = 114;
        bArr3[6] = 82;
        bArr3[7] = 6;
        bArr3[8] = -103;
        int i = ~C0026e1.class.getName().length();
        int length2 = C0026e1.class.getName().length();
        bArr3[((((i - 1767915094) - (i & (-1767915094))) & (-1609978091)) + (((length2 | 553659967) - (length2 ^ 553659967)) | 20971562)) ^ (-1589006538)] = -40;
        bArr3[10] = 44;
        bArr3[11] = -92;
        bArr3[12] = -112;
        bArr3[13] = 40;
        bArr3[14] = -60;
        bArr3[15] = 72;
        bArr3[16] = -62;
        bArr3[17] = -84;
        bArr3[18] = 5;
        bArr3[19] = -28;
        bArr3[20] = -20;
        bArr3[21] = 100;
        bArr3[22] = 54;
        bArr3[23] = 39;
        bArr3[24] = -37;
        bArr3[25] = 6;
        bArr3[26] = -53;
        e(bArr2, bArr3);
        new String(bArr2, charset).intern();
        byte[] bArr4 = {118, -34, -3, -70, -52, -69, 8, -39, 25, 26};
        byte[] bArr5 = new byte[10];
        bArr5[(-99399866) ^ ((((~C0026e1.class.getName().length()) | (-921532477)) & (-1072691388)) + ((C0026e1.class.getName().length() & 671236102) | 973291522))] = 11;
        bArr5[1] = 126;
        bArr5[2] = 80;
        bArr5[3] = -22;
        bArr5[4] = -29;
        bArr5[5] = 39;
        bArr5[6] = 94;
        bArr5[7] = 28;
        bArr5[8] = -63;
        bArr5[9] = -14;
        e(bArr4, bArr5);
        new String(bArr4, charset).intern();
    }

    public C0026e1(Context context, C0084t0 c0084t0) {
        super(context);
        int i = ((~C0026e1.class.getName().length()) | 503021683) & 75630867;
        int length = C0026e1.class.getName().length() & 39880960;
        byte[] bArr = new byte[653429017 ^ ((((~length) & 577798144) + length) + i)];
        bArr[0] = -106;
        bArr[1] = -60;
        bArr[2] = 32;
        bArr[3] = 46;
        bArr[4] = -10;
        bArr[5] = 55;
        bArr[6] = 87;
        bArr[7] = 76;
        bArr[8] = -125;
        bArr[9] = 18;
        o(bArr, new byte[]{22, 123, 105, 65, -82, 41, 74, 16, -54, 118});
        Charset charset = StandardCharsets.UTF_8;
        String c4 = c(new String(bArr, charset).intern());
        if (c4 == null) {
            String uuid = UUID.randomUUID().toString();
            this.f501d = uuid;
            byte[] bArr2 = new byte[10];
            bArr2[0] = -95;
            bArr2[1] = -122;
            bArr2[2] = -96;
            int i3 = ((~C0026e1.class.getName().length()) | 1742943175) & 370742336;
            long j2 = 14680085;
            long length2 = C0026e1.class.getName().length() & 280495121;
            long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
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
            int i4 = i3 + ((int) (((j15 | (j15 >>> 4)) & 16711935) | (((((j12 >>> 4) | j12) & 16711935) << 8) + j9)));
            long j16 = 385422422;
            long j17 = i4;
            long j18 = (((((((((j16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
            long j19 = (j18 >>> 48) & 21845;
            long j20 = (j19 | (j19 >>> 1)) & 858993459;
            long j21 = (j20 | (j20 >>> 2)) & 252645135;
            long j22 = (j18 >>> 32) & 21845;
            long j23 = ((j22 >>> 1) | j22) & 858993459;
            long j24 = ((j23 >>> 2) | j23) & 252645135;
            long j25 = (((j21 | (j21 >>> 4)) & 16711935) << 24) | ((((j24 >>> 4) | j24) & 16711935) << 16);
            long j26 = (j18 >>> 16) & 21845;
            long j27 = ((j26 >>> 1) | j26) & 858993459;
            long j28 = ((j27 >>> 2) | j27) & 252645135;
            long j29 = j18 & 21845;
            long j30 = (j29 | (j29 >>> 1)) & 858993459;
            long j31 = (j30 | (j30 >>> 2)) & 252645135;
            bArr2[(int) (((j31 | (j31 >>> 4)) & 16711935) + ((((j28 >>> 4) | j28) & 16711935) << 8) + j25)] = -67;
            bArr2[4] = -26;
            bArr2[5] = 52;
            bArr2[6] = -40;
            bArr2[7] = -102;
            bArr2[8] = 5;
            bArr2[9] = -113;
            int i5 = ((~C0026e1.class.getName().length()) | 1783679528) & 1090702642;
            int length3 = (C0026e1.class.getName().length() & 19539218) | 69738501;
            o(bArr2, new byte[]{-33, -72, -23, -80, -98, 42, -47, -26, 1160441211 ^ (((length3 | i5) * 2) - (length3 ^ i5)), -21});
            d(new String(bArr2, charset).intern(), uuid);
        } else {
            this.f501d = c4;
        }
        this.f502e = c0084t0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~C0026e1.class.getName().length();
        int length3 = (((~(((C0026e1.class.getName().length() | 70245657) | i7) - (i7 | (C0026e1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C0026e1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C0026e1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C0026e1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C0026e1.class.getName().length()) | (-576567005)) & 276971586) + ((C0026e1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C0026e1.class.getName().length()) | (-1157759625)) & 1755853004) + ((C0026e1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C0026e1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C0026e1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C0026e1.class.getName().length()) | (-1064961)) + 689325073) + ((C0026e1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C0026e1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C0026e1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C0026e1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C0026e1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C0026e1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C0026e1.class.getName().length();
                    int length11 = (161497089 & (((((C0026e1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C0026e1.class.getName().length() | i14) & 797295576))) + ((C0026e1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C0026e1.class.getName().length()) | (-1085986263)) & 1078327440) + ((C0026e1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C0026e1.class.getName().length();
                    int length12 = length5 >>> ((((~(((C0026e1.class.getName().length() | 626856794) | i15) - ((C0026e1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C0026e1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C0026e1.class.getName().length()) | 1248713193) & 826417528) + ((C0026e1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C0026e1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C0026e1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C0026e1.class.getName().length()) | (-1005965450)) & 153223237) + ((C0026e1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C0026e1.class.getName().length() & (~length6)) & i9)) + ((C0026e1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C0026e1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C0026e1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C0026e1.class.getName().length()) | (-23496740)) & 827084804) + ((C0026e1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C0026e1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C0026e1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C0026e1.class.getName().length()) | (-961655275)) & 25184460) + ((C0026e1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C0026e1.class.getName().length()) | 1233459797) & 125923146) + ((C0026e1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C0026e1.class.getName().length()) | (-7107622)) & 402932290) + ((C0026e1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C0026e1.class.getName().length() | length15) - (b4 | length15)) + I2.a(C0026e1.class, b4) + (C0026e1.class.getName().length() & length15);
                    int length17 = ((((~C0026e1.class.getName().length()) | (-81143879)) & 438583424) + ((C0026e1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C0026e1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C0026e1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C0026e1.class, 568748773 | i24) + (C0026e1.class.getName().length() & (-2105278367)))) + ((C0026e1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C0026e1.class.getName().length()) | (-1592082969)) & 140665109) + ((C0026e1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C0026e1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C0026e1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C0026e1.class.getName().length()) | (-180811308));
                    int length19 = (C0026e1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C0026e1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C0026e1.class.getName().length()))));
                    int i29 = ((~C0026e1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C0026e1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C0026e1.class.getName().length()) | 75364313) & 1242301609) + ((C0026e1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C0026e1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C0026e1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C0026e1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C0026e1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C0026e1.class.getName().length();
                    int length24 = 1409942802 & (((((C0026e1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C0026e1.class.getName().length()) & 91135407));
                    int length25 = (C0026e1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C0026e1.class.getName().length()) | (-537919489)) - (-806798471)) + ((C0026e1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C0026e1.class.getName().length()) | (-382746167)) & 102532165) + ((C0026e1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C0026e1.class.getName().length()) | (-6036961)) & 1233145505) + ((C0026e1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C0026e1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C0026e1.class.getName().length() & 268460041;
                    i5 = (((((C0026e1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C0026e1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C0026e1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C0026e1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C0026e1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C0026e1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C0026e1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C0026e1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C0026e1.class, -1) | (-532481)) - (-67641369)) + ((C0026e1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C0026e1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C0026e1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C0026e1.class, -1) | (-33554434)) - (-1107366402)) + ((C0026e1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C0026e1.class, -1) | (-167014194)) & 1157999680) + ((C0026e1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C0026e1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C0026e1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C0026e1.class, -1) | 114408723) & 1183666176;
                    int length33 = C0026e1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C0026e1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C0026e1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C0026e1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C0026e1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C0026e1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C0026e1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C0026e1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C0026e1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C0026e1.class.getName().length()) | 991120067) & (-2113137661)) + ((C0026e1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C0026e1.class, -1) | 314136709) & 371231304) + (((C0026e1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C0026e1.class.getName().length()) | 366661365) & 1344150018) + ((C0026e1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C0026e1.class.getName().length()) | (-1359635359)) & 49026131) + ((C0026e1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C0026e1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C0026e1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C0026e1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C0026e1.class.getName().length()) | 1110430873) & 1241612298) + ((C0026e1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C0026e1.class.getName().length()) | 1603962366) & 25199440) + (((C0026e1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C0026e1.class.getName().length()) | (-1388708984)) & 706816128) + ((C0026e1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C0026e1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C0026e1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C0026e1.class.getName().length()) | 2113158628) & 1026558002) + ((C0026e1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C0026e1.class.getName().length()) | 715175224) & 136512788) + ((C0026e1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C0026e1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C0026e1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C0026e1.class.getName().length()) | (-1084937228)) & 438503696) + ((C0026e1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C0026e1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C0026e1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C0026e1.class, 1197735420 | i53) + (C0026e1.class.getName().length() & 674349280))) + ((C0026e1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C0026e1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C0026e1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C0026e1.class.getName().length()) | (-171976913)) & 318775824) + ((C0026e1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C0026e1.class.getName().length()) | (-616910267)) & 1303391760) + ((C0026e1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C0026e1.class.getName().length()) | 1297715640) & 556926729) + ((C0026e1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C0026e1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C0026e1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C0026e1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C0026e1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void o(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        byte[] bArr3 = null;
        int i4 = 1516727821;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i4 & 16777216) * (i4 | 16777216)) + ((i4 & (-16777217)) * ((~i4) & 16777216));
            int i9 = i4 >>> 8;
            int a2 = j3.a(650911840 & (~i8) & i9, i9, i8, (i8 | 650911840) & i9);
            int i10 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
            int i11 = -365117735;
            boolean z3 = true;
            switch (((~i10) + ((i10 | 1) * 2)) ^ 962785775) {
                case -1896910703:
                    int length = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = (length ^ i12) + ((length & i12) * 2);
                    byte b4 = bArr3[i13];
                    int length2 = bArr4.length;
                    int i14 = 0 - i12;
                    int i15 = i14 | length2;
                    byte b5 = bArr3[D.a(i14, 2, i15, (length2 ^ i14) ^ i15)];
                    bArr3[i13] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i4 = -746753280;
                case -1725904394:
                    i7 = bArr4.length % 4;
                    if ((((i7 > 1 ? 1 : (i7 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case -1399959314:
                    int a4 = j3.a((-1205100636) & i6, i6, 3, (-1205100633) & i6);
                    byte b6 = bArr3[a4];
                    int i16 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i17 = i6 - 1;
                    int i18 = i17 - (i6 | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int a5 = S.a(i20, i16, 1, ((-1) - i20) | ((-1) - i16));
                    int i21 = i17 - (i6 | (-2));
                    int i22 = bArr3[i21] & ForkServer.ERROR;
                    int i23 = i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i24 = (i23 - 1) - ((~a5) | i23);
                    int i25 = bArr3[i6] & ForkServer.ERROR;
                    int a6 = S.a(i24, i25, 1, ((-1) - i24) | ((-1) - i25));
                    byte b7 = bArr4[a4];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i18] & ForkServer.ERROR;
                    int i28 = ((i27 * ((~i27) & 65536)) & (~i26)) + i26;
                    int i29 = bArr4[i21] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = ~((((~i30) | 911399251) | i28) - ((i30 & 911399251) | i28));
                    int i32 = bArr4[i6] & ForkServer.ERROR;
                    int i33 = ~((((~i31) | 1433568692) | i32) - ((i31 & 1433568692) | i32));
                    int i34 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (-1254002618) - ((i34 & 2) | ((-1672003491) - i34));
                    int i36 = (i35 + i33) - ((i35 & i33) * 2);
                    bArr4[i6] = (byte) i36;
                    bArr4[i21] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[a4] = (byte) (i36 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 1 : (i6 == AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i = -1605440657;
                    } else {
                        i = -365117735;
                    }
                    if (i37 != 0) {
                        i4 = i;
                    } else {
                        i4 = -169475207;
                    }
                case -1135475043:
                    break;
                case 180635757:
                    int length5 = bArr.length;
                    int length6 = 0 - (bArr.length % 4);
                    if ((length5 ^ (~length6)) + ((length5 | length6) * 2) + 1 <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (z3) {
                        i4 = i3;
                    } else {
                        i4 = -169475207;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case 511524454:
                    int length7 = bArr4.length;
                    int i38 = 0 - i5;
                    int i39 = 0 - i38;
                    int i40 = ((~length7) & i39) * 2;
                    int length8 = bArr4.length;
                    byte b8 = bArr4[((length8 | i38) * 2) - (length8 ^ i38)];
                    int length9 = bArr4.length;
                    byte b9 = bArr3[(i38 ^ length9) + ((length9 & i38) * 2)];
                    bArr4[(length7 ^ i39) - i40] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i7 = AbstractC0099x.a(i5, 3, (~i5) * 2);
                    if ((((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case 961838909:
                    int length10 = bArr4.length;
                    int i41 = 0 - i7;
                    if ((bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] > Double.NaN ? 1 : (bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        i11 = 1093626513;
                    }
                    if (z3) {
                        i4 = -746753280;
                    } else {
                        i4 = i11;
                    }
                    i5 = i7;
                default:
                    i4 = -365117735;
            }
            return;
        }
    }

    public final String n() {
        return (String) this.f502e.f663a;
    }

    public final String p() {
        return this.f501d;
    }

    public final String q() {
        return (String) this.f502e.f664b;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x05a3. Please report as an issue. */
    public final void r() {
        byte[] bArr = new byte[27];
        bArr[0] = 99;
        bArr[1] = -42;
        int i = 2;
        bArr[2] = -7;
        bArr[3] = -71;
        bArr[4] = -87;
        bArr[5] = 77;
        bArr[6] = 97;
        bArr[7] = -118;
        bArr[8] = -81;
        bArr[9] = 81;
        bArr[10] = 110;
        bArr[11] = 92;
        bArr[12] = -42;
        bArr[13] = 97;
        bArr[14] = Byte.MIN_VALUE;
        bArr[15] = -37;
        bArr[16] = -116;
        bArr[17] = 53;
        bArr[18] = 4;
        bArr[19] = -59;
        bArr[20] = 12;
        bArr[21] = 122;
        long j2 = -1;
        long length = C0026e1.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j4 = (j3 >>> 48) & 21845;
        long j5 = ((j4 >>> 1) | j4) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        bArr[(((((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | 388434845) & 36832281) + ((C0026e1.class.getName().length() & 269520032) | 268470500)) ^ 305302763] = 52;
        bArr[23] = 75;
        bArr[24] = -10;
        bArr[25] = 78;
        bArr[26] = 94;
        byte[] bArr2 = new byte[27];
        bArr2[((((-1319520402) | ((946720261 + (~C0026e1.class.getName().length())) + (((-r8) - 1) | (-946720261)))) + 1319520402) + ((C0026e1.class.getName().length() & (-696118639)) | (-1877962240))) ^ (-558441839)] = 6;
        bArr2[1] = -82;
        bArr2[2] = -119;
        bArr2[3] = -36;
        int i3 = ((~C0026e1.class.getName().length()) | 726885614) & 570645057;
        long j17 = 270015109;
        long length2 = C0026e1.class.getName().length();
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j19 = (j18 >>> 48) & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> 32) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << 24);
        long j26 = (j18 >>> 16) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        int i4 = ((int) ((((j31 >>> 4) | j31) & 16711935) + ((((j28 >>> 4) | j28) & 16711935) << 8) + j25)) | 286785668;
        int i5 = ((i4 | i3) * 2) - (i3 ^ i4);
        long j32 = 857430721;
        long j33 = i5;
        long j34 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j35 = (j34 >>> 48) & 21845;
        long j36 = (j35 | (j35 >>> 1)) & 858993459;
        long j37 = (j36 | (j36 >>> 2)) & 252645135;
        long j38 = (j34 >>> 32) & 21845;
        long j39 = ((j38 >>> 1) | j38) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + (((j37 | (j37 >>> 4)) & 16711935) << 24);
        long j42 = (j34 >>> 16) & 21845;
        long j43 = ((j42 >>> 1) | j42) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 21845;
        long j46 = (j45 | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        bArr2[(int) (((j47 | (j47 >>> 4)) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41))] = -37;
        bArr2[5] = 36;
        bArr2[6] = 12;
        bArr2[7] = -17;
        bArr2[8] = -63;
        bArr2[9] = 37;
        bArr2[10] = 15;
        bArr2[11] = 48;
        bArr2[12] = -123;
        bArr2[13] = 21;
        bArr2[14] = -17;
        bArr2[15] = -87;
        bArr2[16] = -19;
        bArr2[17] = 82;
        bArr2[18] = 97;
        int i6 = ((~C0026e1.class.getName().length()) | (-902709825)) & 210243736;
        long j48 = 348651524;
        long length3 = C0026e1.class.getName().length();
        long j49 = ((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j50 = (j49 >>> 48) & 43690;
        long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
        long j52 = (j51 | (j51 >>> 2)) & 252645135;
        long j53 = (j49 >>> 32) & 43690;
        long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        long j56 = (((j52 | (j52 >>> 4)) & 16711935) << 24) | ((((j55 >>> 4) | j55) & 16711935) << 16);
        long j57 = (j49 >>> 16) & 43690;
        long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = j49 & 43690;
        long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
        long j62 = (j61 | (j61 >>> 2)) & 252645135;
        bArr2[19] = (i6 + (((int) (((j62 | (j62 >>> 4)) & 16711935) | (((((j59 >>> 4) | j59) & 16711935) << 8) + j56))) | 274989062)) ^ (-485232866);
        bArr2[20] = 116;
        bArr2[21] = 31;
        bArr2[22] = 87;
        bArr2[23] = 62;
        bArr2[24] = -126;
        bArr2[25] = 43;
        bArr2[26] = 58;
        byte[] bArr3 = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1850458006;
        byte[] bArr4 = null;
        while (true) {
            int i10 = ((16777216 & i9) * (i9 | 16777216)) + (((-16777217) & i9) * ((~i9) & 16777216));
            int i11 = i9 >>> 8;
            int i12 = (i11 - 1) - ((~i10) | i11);
            int i13 = (-1700147435) - ((i12 & i) | (2028104049 - i12));
            switch ((-1363443157) ^ ((~i13) + ((i13 | 1) * i))) {
                case -1940167324:
                    byte b4 = bArr3[i7];
                    int i14 = ((byte) 0) - b4;
                    bArr3[i7] = (byte) (((byte) (b4 & (~i14))) - ((byte) ((~b4) & i14)));
                    i9 = 614229416;
                    i = 2;
                case -360299937:
                    boolean z3 = (((double) ((byte) bArr3[i8])) > Double.NaN ? 1 : (((double) ((byte) bArr3[i8])) == Double.NaN ? 0 : -1)) > -1;
                    i9 = z3 ? 614229416 : z3 ? -1396193641 : 427928065;
                    i7 = i8;
                    i = 2;
                case 399486784:
                    break;
                case 585276366:
                    i9 = 1985663266;
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i8 = 0;
                    i = 2;
                case 1733787683:
                    byte b5 = bArr4[i7];
                    byte b6 = bArr3[i7];
                    bArr4[i7] = (byte) (((byte) (b6 + b5)) - ((byte) (((byte) i) * ((byte) (b6 & b5)))));
                    i8 = (i7 ^ 1) + ((i7 & 1) * i);
                    i9 = (((((long) i8) > ((long) bArr4.length) ? 1 : (((long) i8) == ((long) bArr4.length) ? 0 : -1)) >>> 31) & 1) != 0 ? 1985663266 : -1396193641;
                    i = 2;
                default:
                    i9 = -1396193641;
            }
            d(new String(bArr, StandardCharsets.UTF_8).intern(), Boolean.toString(true));
            return;
        }
    }
}
