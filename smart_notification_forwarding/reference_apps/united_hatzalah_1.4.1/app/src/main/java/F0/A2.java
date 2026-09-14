package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class A2 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public boolean f169f;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00d7. Please report as an issue. */
    static {
        int i;
        char c4;
        byte[] bArr;
        int i3 = 0;
        int i4 = 1;
        int i5 = 2;
        char c5 = 4;
        byte[] bArr2 = {-59, 73, -44, -51, (((AbstractC0008a.f(A2.class, -1) | (-666641436)) & 6359808) + ((A2.class.getName().length() & 1075871872) | 1342341264)) ^ 1348701098, 14, (-1380853147) ^ ((((~A2.class.getName().length()) | (-2063636761)) & 219251314) + ((A2.class.getName().length() & (-1457485808)) | (-1600104448)))};
        int i6 = 8;
        byte[] bArr3 = {6, 65, 35, 66, 86, 111, 110, 98};
        byte[] bArr4 = null;
        int i7 = -1003175592;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        byte[] bArr5 = null;
        while (true) {
            int i11 = ((i7 & 16777216) * (i7 | 16777216)) + ((i7 & (-16777217)) * ((~i7) & 16777216));
            int i12 = i7 >>> i6;
            int i13 = ~((((~i12) | (-1095531540)) | i11) - ((i12 & (-1095531540)) | i11));
            int i14 = (-1171264002) - ((i13 & i5) | ((-130029571) - i13));
            int i15 = -1216566512;
            switch ((-1109882652) ^ ((~i14) + ((i14 | 1) * i5))) {
                case -1922532006:
                    char c6 = c5;
                    int i16 = i3;
                    byte[] bArr6 = bArr4;
                    int i17 = i4;
                    int length = bArr5.length;
                    int i18 = 0 - i8;
                    if ((bArr6[AbstractC0014b1.a((length & 2) | D1.a(i18, length), i18 * 3)] > Double.NaN ? 1 : (bArr6[AbstractC0014b1.a((length & 2) | D1.a(i18, length), i18 * 3)] == Double.NaN ? 0 : -1)) <= -1) {
                        i = -1671996003;
                    } else {
                        i = 935800592;
                    }
                    i4 = i17;
                    bArr4 = bArr6;
                    i9 = i8;
                    c5 = c6;
                    i3 = i16;
                    i5 = 2;
                    i7 = i;
                    i6 = 8;
                case -1486048729:
                    bArr5 = bArr2;
                    bArr4 = bArr3;
                    i10 = i3;
                    i7 = -1515449616;
                case -497756741:
                    char c7 = c5;
                    int i19 = i3;
                    int i20 = i4;
                    byte[] bArr7 = bArr4;
                    int length2 = bArr5.length;
                    int i21 = 0 - i9;
                    int i22 = ((length2 | i21) * 2) - (length2 ^ i21);
                    byte b4 = bArr7[i22];
                    int length3 = bArr5.length;
                    byte b5 = bArr7[((i21 | length3) - ((1163302289 & (~i21)) & length3)) + ((i21 | 1163302289) & length3)];
                    bArr7[i22] = (byte) (((byte) (((byte) (b5 ^ (~b4))) + ((byte) (((byte) i5) * ((byte) (b5 | b4)))))) + ((byte) i20));
                    i4 = i20;
                    bArr4 = bArr7;
                    i7 = 935800592;
                    c5 = c7;
                    i3 = i19;
                    i6 = 8;
                    i5 = 2;
                case 256719606:
                    char c8 = c5;
                    byte[] bArr8 = bArr4;
                    int i23 = (i10 - 1) - (i10 | (-4));
                    byte b6 = bArr8[i23];
                    int i24 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i25 = i10 + 2;
                    int i26 = i25 - (i10 & 2);
                    int i27 = bArr8[i26] & ForkServer.ERROR;
                    int i28 = i3;
                    int i29 = i27 * ((~i27) & 65536);
                    int a2 = S.a(i29, i24, i4, ((-1) - i29) | ((-1) - i24));
                    int i30 = i25 + (((-1) - i10) | (-2));
                    int i31 = bArr8[i30] & ForkServer.ERROR;
                    int i32 = i31 * ((~i31) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i33 = (i32 - i4) - ((~a2) | i32);
                    int i34 = bArr8[i10] & ForkServer.ERROR;
                    int i35 = ~((i34 | ((~i33) | (-755325340))) - ((i33 & (-755325340)) | i34));
                    byte b7 = bArr5[i23];
                    int i36 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i37 = bArr5[i26] & ForkServer.ERROR;
                    int i38 = i37 * ((~i37) & 65536);
                    int i39 = bArr5[i30] & ForkServer.ERROR;
                    int i40 = i4;
                    int i41 = i39 * ((~i39) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i42 = bArr5[i10] & ForkServer.ERROR;
                    int i43 = i5;
                    int i44 = i35 << ((i35 > Double.NaN ? 1 : (i35 == Double.NaN ? 0 : -1)) >>> 31);
                    int i45 = (-659933419) - ((i36 & 2) | (1983400305 - i36));
                    int i46 = ((~i38) ^ i45) + ((i45 | i38) * 2) + 1;
                    int i47 = (i46 ^ i42) + ((i46 & i42) * 2);
                    int i48 = ((i47 | i41) - (((-2109111237) & (~i41)) & i47)) + ((i41 | (-2109111237)) & i47);
                    int a4 = E1.a(i44 | i48, i44, i48);
                    bArr5[i10] = (byte) a4;
                    bArr5[i30] = (byte) (a4 >>> 8);
                    bArr5[i26] = (byte) (a4 >>> 16);
                    bArr5[i23] = (byte) (a4 >>> 24);
                    i10 = (i10 ^ 4) + ((i10 & 4) * 2);
                    int length4 = bArr5.length;
                    int length5 = 0 - (bArr5.length % 4);
                    int i49 = ((i10 > (((length4 | length5) * 2) - (length4 ^ length5)) ? 1 : (i10 == (((length4 | length5) * 2) - (length4 ^ length5)) ? 0 : -1)) >>> 31) & 1;
                    if (i49 != 0) {
                        i7 = -1515449616;
                    } else {
                        i7 = 935800592;
                    }
                    if (i49 == 0) {
                        i7 = -10521562;
                    }
                    bArr4 = bArr8;
                    i4 = i40;
                    c5 = c8;
                    i3 = i28;
                    i5 = i43;
                    i6 = 8;
                case 1429728656:
                    c4 = c5;
                    bArr = bArr4;
                    int length6 = bArr5.length % 4;
                    int i50 = ((length6 > i4 ? 1 : (length6 == i4 ? 0 : -1)) >>> 31) & i4;
                    if (i50 != 0) {
                        i7 = -1216566512;
                    } else {
                        i7 = 935800592;
                    }
                    if (i50 != 0) {
                        bArr4 = bArr;
                        i8 = length6;
                        c5 = c4;
                        i6 = 8;
                    } else {
                        i8 = length6;
                        i7 = -1058029970;
                        bArr4 = bArr;
                        c5 = c4;
                        i6 = 8;
                    }
                case 1870596681:
                    break;
                case 1879000533:
                    int length7 = bArr5.length;
                    int i51 = 0 - i9;
                    int i52 = 0 - i51;
                    int i53 = i52 | length7;
                    int length8 = bArr5.length;
                    c4 = c5;
                    byte b8 = bArr5[(length8 ^ i52) - (((~length8) & i52) * i5)];
                    int length9 = bArr5.length;
                    byte b9 = bArr4[((length9 | i51) * i5) - (length9 ^ i51)];
                    bArr5[(i53 - (i52 * 2)) + ((length7 ^ i52) ^ i53)] = (byte) ((b8 ^ (((byte) (~b9)) + ((byte) (((byte) i5) * ((byte) (b9 | 1)))))) ^ i4);
                    i8 = (~i9) + (i9 * 2);
                    bArr = bArr4;
                    int i54 = ((i9 > i5 ? 1 : (i9 == i5 ? 0 : -1)) >>> 31) & i4;
                    if (i54 == 0) {
                        i15 = 935800592;
                    }
                    if (i54 != 0) {
                        bArr4 = bArr;
                        i7 = i15;
                        c5 = c4;
                        i6 = 8;
                    }
                    i7 = -1058029970;
                    bArr4 = bArr;
                    c5 = c4;
                    i6 = 8;
                default:
                    i7 = 935800592;
            }
            new String(bArr2, StandardCharsets.UTF_8).intern();
            return;
        }
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
        int i7 = ~A2.class.getName().length();
        int length3 = (((~(((A2.class.getName().length() | 70245657) | i7) - (i7 | (A2.class.getName().length() & (-70245658))))) & (-1979440632)) + ((A2.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(A2.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((A2.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~A2.class.getName().length()) | (-576567005)) & 276971586) + ((A2.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~A2.class.getName().length()) | (-1157759625)) & 1755853004) + ((A2.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~A2.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = A2.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~A2.class.getName().length()) | (-1064961)) + 689325073) + ((A2.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~A2.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = A2.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~A2.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (A2.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((A2.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~A2.class.getName().length();
                    int length11 = (161497089 & (((((A2.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((A2.class.getName().length() | i14) & 797295576))) + ((A2.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~A2.class.getName().length()) | (-1085986263)) & 1078327440) + ((A2.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~A2.class.getName().length();
                    int length12 = length5 >>> ((((~(((A2.class.getName().length() | 626856794) | i15) - ((A2.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((A2.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~A2.class.getName().length()) | 1248713193) & 826417528) + ((A2.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~A2.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (A2.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~A2.class.getName().length()) | (-1005965450)) & 153223237) + ((A2.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((A2.class.getName().length() & (~length6)) & i9)) + ((A2.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~A2.class.getName().length()) | (-30261291)) & (-1534000062)) + ((A2.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~A2.class.getName().length()) | (-23496740)) & 827084804) + ((A2.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~A2.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (A2.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~A2.class.getName().length()) | (-961655275)) & 25184460) + ((A2.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~A2.class.getName().length()) | 1233459797) & 125923146) + ((A2.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~A2.class.getName().length()) | (-7107622)) & 402932290) + ((A2.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((A2.class.getName().length() | length15) - (b4 | length15)) + I2.a(A2.class, b4) + (A2.class.getName().length() & length15);
                    int length17 = ((((~A2.class.getName().length()) | (-81143879)) & 438583424) + ((A2.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~A2.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((A2.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(A2.class, 568748773 | i24) + (A2.class.getName().length() & (-2105278367)))) + ((A2.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~A2.class.getName().length()) | (-1592082969)) & 140665109) + ((A2.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~A2.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((A2.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~A2.class.getName().length()) | (-180811308));
                    int length19 = (A2.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((A2.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | A2.class.getName().length()))));
                    int i29 = ((~A2.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (A2.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~A2.class.getName().length()) | 75364313) & 1242301609) + ((A2.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = A2.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((A2.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~A2.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((A2.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~A2.class.getName().length();
                    int length24 = 1409942802 & (((((A2.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | A2.class.getName().length()) & 91135407));
                    int length25 = (A2.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~A2.class.getName().length()) | (-537919489)) - (-806798471)) + ((A2.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~A2.class.getName().length()) | (-382746167)) & 102532165) + ((A2.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~A2.class.getName().length()) | (-6036961)) & 1233145505) + ((A2.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~A2.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = A2.class.getName().length() & 268460041;
                    i5 = (((((A2.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | A2.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = A2.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((A2.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~A2.class.getName().length()) | (-1883938358)) & (-738125179)) + ((A2.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~A2.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (A2.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(A2.class, -1) | (-532481)) - (-67641369)) + ((A2.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~A2.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((A2.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(A2.class, -1) | (-33554434)) - (-1107366402)) + ((A2.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(A2.class, -1) | (-167014194)) & 1157999680) + ((A2.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = A2.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((A2.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(A2.class, -1) | 114408723) & 1183666176;
                    int length33 = A2.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~A2.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = A2.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~A2.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (A2.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~A2.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((A2.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~A2.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (A2.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~A2.class.getName().length()) | 991120067) & (-2113137661)) + ((A2.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(A2.class, -1) | 314136709) & 371231304) + (((A2.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~A2.class.getName().length()) | 366661365) & 1344150018) + ((A2.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~A2.class.getName().length()) | (-1359635359)) & 49026131) + ((A2.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~A2.class.getName().length();
                    if (length3 > 0) {
                        int length38 = A2.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (A2.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~A2.class.getName().length()) | 1110430873) & 1241612298) + ((A2.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~A2.class.getName().length()) | 1603962366) & 25199440) + (((A2.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~A2.class.getName().length()) | (-1388708984)) & 706816128) + ((A2.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~A2.class.getName().length()) | 367288948) & 548745488;
                    int length41 = A2.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~A2.class.getName().length()) | 2113158628) & 1026558002) + ((A2.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~A2.class.getName().length()) | 715175224) & 136512788) + ((A2.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~A2.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = A2.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~A2.class.getName().length()) | (-1084937228)) & 438503696) + ((A2.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~A2.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((A2.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(A2.class, 1197735420 | i53) + (A2.class.getName().length() & 674349280))) + ((A2.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~A2.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (A2.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~A2.class.getName().length()) | (-171976913)) & 318775824) + ((A2.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~A2.class.getName().length()) | (-616910267)) & 1303391760) + ((A2.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~A2.class.getName().length()) | 1297715640) & 556926729) + ((A2.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~A2.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((A2.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~A2.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (A2.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void r(byte[] bArr, byte[] bArr2) {
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

    @Override // F0.T2
    public final void a(Context context) {
        byte[] bArr = {-47, 84, 19, -45, 89, 62, -120};
        boolean z3 = this.f169f;
        int i = ~(z3 ? 1 : 0);
        int i3 = (((i + (((-i) - 1) | 1300016647)) - 1300016647) & 1654079653) + (((z3 ? 1 : 0) & (-1051459513)) | (-2126507438));
        k(bArr, new byte[]{95, -4, (i3 - 472427855) - (((-472427855) & i3) * 2), 60, -19, 18, -41, -111});
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
    }
}
