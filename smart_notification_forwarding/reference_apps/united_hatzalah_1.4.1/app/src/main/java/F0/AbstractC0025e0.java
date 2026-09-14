package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0025e0 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f500f;

    static {
        byte[] bArr = new byte[10];
        bArr[0] = -60;
        bArr[1] = -19;
        bArr[2] = 16;
        bArr[3] = 15;
        bArr[4] = 45;
        bArr[5] = -28;
        long j2 = -355471529;
        long length = (((~AbstractC0025e0.class.getName().length()) | (-724167784)) & (-490362799)) + ((AbstractC0025e0.class.getName().length() & 571206209) | 134891264);
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 21845;
        long j5 = ((j4 >>> 1) | j4) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        bArr[(int) ((((j16 >>> 4) | j16) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))] = -102;
        int i = ((~AbstractC0025e0.class.getName().length()) | (-683311795)) & 1359773792;
        long j17 = 8945704;
        long length2 = AbstractC0025e0.class.getName().length();
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j19 = (j18 >>> 48) & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> 32) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) | ((((j21 >>> 4) | j21) & 16711935) << 24);
        long j26 = (j18 >>> 16) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        int i3 = i + (((int) (((((j28 >>> 4) | j28) & 16711935) << 8) | j25 | (((j31 >>> 4) | j31) & 16711935))) | 43057161);
        long j32 = 1402830958;
        long j33 = i3;
        long j34 = ((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j35 = (j34 >>> 48) & 21845;
        long j36 = (j35 | (j35 >>> 1)) & 858993459;
        long j37 = (j36 | (j36 >>> 2)) & 252645135;
        long j38 = (j34 >>> 32) & 21845;
        long j39 = (j38 | (j38 >>> 1)) & 858993459;
        long j40 = (j39 | (j39 >>> 2)) & 252645135;
        long j41 = (((j37 | (j37 >>> 4)) & 16711935) << 24) | (((j40 | (j40 >>> 4)) & 16711935) << 16);
        long j42 = (j34 >>> 16) & 21845;
        long j43 = (j42 | (j42 >>> 1)) & 858993459;
        long j44 = (j43 | (j43 >>> 2)) & 252645135;
        long j45 = j34 & 21845;
        long j46 = (j45 | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        bArr[(int) (((j47 | (j47 >>> 4)) & 16711935) + (((j44 | (j44 >>> 4)) & 16711935) << 8) + j41)] = -97;
        bArr[8] = -113;
        bArr[9] = -80;
        byte[] bArr2 = new byte[10];
        bArr2[0] = 24;
        bArr2[1] = -62;
        bArr2[2] = -22;
        bArr2[3] = -73;
        bArr2[4] = 47;
        bArr2[5] = -21;
        bArr2[6] = 21;
        bArr2[7] = 41;
        bArr2[8] = -113;
        int i4 = ~AbstractC0025e0.class.getName().length();
        int i5 = ((-39977193) | (((~i4) & (-370007625)) + i4)) + 39977193;
        int length3 = AbstractC0025e0.class.getName().length() & 588514376;
        bArr2[(i5 + (~(((AbstractC0025e0.class.getName().length() | (-554959873)) | length3) - (length3 | (AbstractC0025e0.class.getName().length() & 554959872))))) ^ 594937057] = -29;
        k(bArr, bArr2);
        new String(bArr, StandardCharsets.UTF_8).intern();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0025e0(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = {-114, 114, -44, 51, 0, -45};
        byte[] bArr2 = new byte[8];
        long j2 = -1;
        long length = AbstractC0025e0.class.getName().length();
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j4 = (j3 >>> 48) & 21845;
        long j5 = ((j4 >>> 1) | j4) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        bArr2[(((((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | 1387764217) & (-2139044028)) + ((AbstractC0025e0.class.getName().length() & (-1879030268)) | 336070656)) ^ (-1802973372)] = -53;
        bArr2[1] = 77;
        bArr2[2] = -99;
        bArr2[3] = 109;
        bArr2[4] = 101;
        bArr2[5] = -95;
        bArr2[6] = -24;
        int i = ((~AbstractC0025e0.class.getName().length()) | 703163094) & 29901058;
        long j17 = 402756868;
        long length2 = AbstractC0025e0.class.getName().length();
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j19 = (j18 >>> 48) & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = (j20 | (j20 >>> 2)) & 252645135;
        long j22 = (j18 >>> 32) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = (((j21 | (j21 >>> 4)) & 16711935) << 24) | ((((j24 >>> 4) | j24) & 16711935) << 16);
        long j26 = (j18 >>> 16) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = (j30 | (j30 >>> 2)) & 252645135;
        bArr2[432657665 ^ (i + (((int) (((j31 | (j31 >>> 4)) & 16711935) | (((((j28 >>> 4) | j28) & 16711935) << 8) + j25))) | 402756612))] = 44;
        y(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr3 = new byte[8];
        int length3 = AbstractC0025e0.class.getName().length();
        bArr3[((((-134217729) | (((~length3) - length3) + length3)) - (-221256209)) + ((AbstractC0025e0.class.getName().length() & 1476420608) | 1351115808)) ^ 1572372016] = -89;
        bArr3[1] = -106;
        bArr3[2] = -4;
        bArr3[3] = 118;
        int i3 = ~AbstractC0025e0.class.getName().length();
        bArr3[((201336072 & ((i3 ^ 1490302888) + (i3 & 1490302888))) + ((AbstractC0025e0.class.getName().length() & 67387392) | 280624)) ^ 201616700] = -94;
        bArr3[5] = 96;
        bArr3[6] = 115;
        bArr3[7] = 63;
        int i4 = ~AbstractC0025e0.class.getName().length();
        int i5 = (-486107903) & ((i4 ^ 1589636608) + (i4 & 1589636608));
        int length4 = AbstractC0025e0.class.getName().length();
        int i6 = (((-1593822935) & length4) ^ 134228522) + (length4 & 8232);
        byte length5 = 351879317 ^ (((i6 | i5) - ((AbstractC0025e0.class.getName().length() & (~i5)) & i6)) + ((i5 | AbstractC0025e0.class.getName().length()) & i6));
        int length6 = (((~AbstractC0025e0.class.getName().length()) | 2043644042) & 18014864) + ((AbstractC0025e0.class.getName().length() & 34628112) | (-1040187328));
        y(bArr3, new byte[]{length5, 35, -120, 46, B0.a(1022172527 | (~length6), 1022172527 - length6), 57, 6, 106});
        new String(bArr3, charset).intern();
        this.f500f = c0054l1;
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
        int i7 = ~AbstractC0025e0.class.getName().length();
        int length3 = (((~(((AbstractC0025e0.class.getName().length() | 70245657) | i7) - (i7 | (AbstractC0025e0.class.getName().length() & (-70245658))))) & (-1979440632)) + ((AbstractC0025e0.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(AbstractC0025e0.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((AbstractC0025e0.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~AbstractC0025e0.class.getName().length()) | (-576567005)) & 276971586) + ((AbstractC0025e0.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~AbstractC0025e0.class.getName().length()) | (-1157759625)) & 1755853004) + ((AbstractC0025e0.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~AbstractC0025e0.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = AbstractC0025e0.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~AbstractC0025e0.class.getName().length()) | (-1064961)) + 689325073) + ((AbstractC0025e0.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~AbstractC0025e0.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = AbstractC0025e0.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~AbstractC0025e0.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (AbstractC0025e0.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((AbstractC0025e0.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~AbstractC0025e0.class.getName().length();
                    int length11 = (161497089 & (((((AbstractC0025e0.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((AbstractC0025e0.class.getName().length() | i14) & 797295576))) + ((AbstractC0025e0.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~AbstractC0025e0.class.getName().length()) | (-1085986263)) & 1078327440) + ((AbstractC0025e0.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~AbstractC0025e0.class.getName().length();
                    int length12 = length5 >>> ((((~(((AbstractC0025e0.class.getName().length() | 626856794) | i15) - ((AbstractC0025e0.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((AbstractC0025e0.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~AbstractC0025e0.class.getName().length()) | 1248713193) & 826417528) + ((AbstractC0025e0.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~AbstractC0025e0.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (AbstractC0025e0.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~AbstractC0025e0.class.getName().length()) | (-1005965450)) & 153223237) + ((AbstractC0025e0.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((AbstractC0025e0.class.getName().length() & (~length6)) & i9)) + ((AbstractC0025e0.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~AbstractC0025e0.class.getName().length()) | (-30261291)) & (-1534000062)) + ((AbstractC0025e0.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~AbstractC0025e0.class.getName().length()) | (-23496740)) & 827084804) + ((AbstractC0025e0.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~AbstractC0025e0.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (AbstractC0025e0.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~AbstractC0025e0.class.getName().length()) | (-961655275)) & 25184460) + ((AbstractC0025e0.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~AbstractC0025e0.class.getName().length()) | 1233459797) & 125923146) + ((AbstractC0025e0.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~AbstractC0025e0.class.getName().length()) | (-7107622)) & 402932290) + ((AbstractC0025e0.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((AbstractC0025e0.class.getName().length() | length15) - (b4 | length15)) + I2.a(AbstractC0025e0.class, b4) + (AbstractC0025e0.class.getName().length() & length15);
                    int length17 = ((((~AbstractC0025e0.class.getName().length()) | (-81143879)) & 438583424) + ((AbstractC0025e0.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~AbstractC0025e0.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((AbstractC0025e0.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(AbstractC0025e0.class, 568748773 | i24) + (AbstractC0025e0.class.getName().length() & (-2105278367)))) + ((AbstractC0025e0.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~AbstractC0025e0.class.getName().length()) | (-1592082969)) & 140665109) + ((AbstractC0025e0.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~AbstractC0025e0.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((AbstractC0025e0.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~AbstractC0025e0.class.getName().length()) | (-180811308));
                    int length19 = (AbstractC0025e0.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((AbstractC0025e0.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | AbstractC0025e0.class.getName().length()))));
                    int i29 = ((~AbstractC0025e0.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (AbstractC0025e0.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~AbstractC0025e0.class.getName().length()) | 75364313) & 1242301609) + ((AbstractC0025e0.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = AbstractC0025e0.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((AbstractC0025e0.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~AbstractC0025e0.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((AbstractC0025e0.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~AbstractC0025e0.class.getName().length();
                    int length24 = 1409942802 & (((((AbstractC0025e0.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | AbstractC0025e0.class.getName().length()) & 91135407));
                    int length25 = (AbstractC0025e0.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~AbstractC0025e0.class.getName().length()) | (-537919489)) - (-806798471)) + ((AbstractC0025e0.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~AbstractC0025e0.class.getName().length()) | (-382746167)) & 102532165) + ((AbstractC0025e0.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~AbstractC0025e0.class.getName().length()) | (-6036961)) & 1233145505) + ((AbstractC0025e0.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~AbstractC0025e0.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = AbstractC0025e0.class.getName().length() & 268460041;
                    i5 = (((((AbstractC0025e0.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | AbstractC0025e0.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = AbstractC0025e0.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((AbstractC0025e0.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~AbstractC0025e0.class.getName().length()) | (-1883938358)) & (-738125179)) + ((AbstractC0025e0.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~AbstractC0025e0.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (AbstractC0025e0.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(AbstractC0025e0.class, -1) | (-532481)) - (-67641369)) + ((AbstractC0025e0.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~AbstractC0025e0.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((AbstractC0025e0.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(AbstractC0025e0.class, -1) | (-33554434)) - (-1107366402)) + ((AbstractC0025e0.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(AbstractC0025e0.class, -1) | (-167014194)) & 1157999680) + ((AbstractC0025e0.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = AbstractC0025e0.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((AbstractC0025e0.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(AbstractC0025e0.class, -1) | 114408723) & 1183666176;
                    int length33 = AbstractC0025e0.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~AbstractC0025e0.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = AbstractC0025e0.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~AbstractC0025e0.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (AbstractC0025e0.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~AbstractC0025e0.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((AbstractC0025e0.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~AbstractC0025e0.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (AbstractC0025e0.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~AbstractC0025e0.class.getName().length()) | 991120067) & (-2113137661)) + ((AbstractC0025e0.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(AbstractC0025e0.class, -1) | 314136709) & 371231304) + (((AbstractC0025e0.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~AbstractC0025e0.class.getName().length()) | 366661365) & 1344150018) + ((AbstractC0025e0.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~AbstractC0025e0.class.getName().length()) | (-1359635359)) & 49026131) + ((AbstractC0025e0.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~AbstractC0025e0.class.getName().length();
                    if (length3 > 0) {
                        int length38 = AbstractC0025e0.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (AbstractC0025e0.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~AbstractC0025e0.class.getName().length()) | 1110430873) & 1241612298) + ((AbstractC0025e0.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~AbstractC0025e0.class.getName().length()) | 1603962366) & 25199440) + (((AbstractC0025e0.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~AbstractC0025e0.class.getName().length()) | (-1388708984)) & 706816128) + ((AbstractC0025e0.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~AbstractC0025e0.class.getName().length()) | 367288948) & 548745488;
                    int length41 = AbstractC0025e0.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~AbstractC0025e0.class.getName().length()) | 2113158628) & 1026558002) + ((AbstractC0025e0.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~AbstractC0025e0.class.getName().length()) | 715175224) & 136512788) + ((AbstractC0025e0.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~AbstractC0025e0.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = AbstractC0025e0.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~AbstractC0025e0.class.getName().length()) | (-1084937228)) & 438503696) + ((AbstractC0025e0.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~AbstractC0025e0.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((AbstractC0025e0.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(AbstractC0025e0.class, 1197735420 | i53) + (AbstractC0025e0.class.getName().length() & 674349280))) + ((AbstractC0025e0.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~AbstractC0025e0.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (AbstractC0025e0.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~AbstractC0025e0.class.getName().length()) | (-171976913)) & 318775824) + ((AbstractC0025e0.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~AbstractC0025e0.class.getName().length()) | (-616910267)) & 1303391760) + ((AbstractC0025e0.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~AbstractC0025e0.class.getName().length()) | 1297715640) & 556926729) + ((AbstractC0025e0.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~AbstractC0025e0.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((AbstractC0025e0.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~AbstractC0025e0.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (AbstractC0025e0.class.getName().length() & 44040224) | (-1811807712)), 1);
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

    @Override // F0.T0, F0.T2
    public final boolean a() {
        return true;
    }
}
