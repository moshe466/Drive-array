package F0;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityManager;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.fork.ForkServer;
import t2.AbstractC0707i;
import t2.AbstractC0709k;
import t2.C0716r;

/* loaded from: classes.dex */
public final class P0 {

    /* renamed from: d, reason: collision with root package name */
    public static final Set f351d;

    /* renamed from: e, reason: collision with root package name */
    public static final HashSet f352e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashSet f353f;

    /* renamed from: g, reason: collision with root package name */
    public static final HashSet f354g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashSet f355h;

    /* renamed from: a, reason: collision with root package name */
    public final Context f356a;

    /* renamed from: b, reason: collision with root package name */
    public final AppOpsManager f357b;

    /* renamed from: c, reason: collision with root package name */
    public final A0 f358c;

    static {
        byte[] bArr = new byte[42];
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = -123;
        bArr[2] = -42;
        bArr[3] = 9;
        bArr[4] = -85;
        bArr[5] = -24;
        bArr[6] = 25;
        bArr[7] = 34;
        bArr[8] = 81;
        bArr[9] = -28;
        bArr[10] = -79;
        bArr[11] = -116;
        bArr[12] = 107;
        bArr[13] = 19;
        bArr[14] = -120;
        int i = ((~P0.class.getName().length()) | 694888006) & 1624083204;
        int length = (P0.class.getName().length() & 1082444032) | (-2013240184);
        bArr[AbstractC0099x.a(length | i, 2, length ^ (~i)) ^ (-389156989)] = -83;
        int i3 = ((~P0.class.getName().length()) | 1924232284) & 856688905;
        bArr[16] = D.a(i3, 3, -D1.a(i3, (P0.class.getName().length() & 16779525) | 134742068), 1) ^ 991430966;
        bArr[17] = 120;
        int length2 = (((~P0.class.getName().length()) | 1387336684) & (-242199192)) + ((P0.class.getName().length() & (-1386167150)) | 207653010);
        bArr[18] = ((length2 & 34546270) * 2) + ((-34546271) - length2);
        bArr[19] = 110;
        bArr[20] = -62;
        bArr[21] = 102;
        bArr[22] = -94;
        bArr[23] = 114;
        bArr[24] = 61;
        bArr[25] = 61;
        bArr[26] = 92;
        bArr[27] = -109;
        bArr[28] = -2;
        bArr[29] = -76;
        bArr[30] = -30;
        bArr[31] = -50;
        bArr[32] = -102;
        bArr[33] = -45;
        bArr[34] = 32;
        bArr[35] = -45;
        bArr[36] = 15;
        bArr[37] = 123;
        bArr[38] = -117;
        bArr[39] = -73;
        bArr[40] = -8;
        bArr[41] = -79;
        byte[] bArr2 = new byte[42];
        bArr2[0] = 4;
        int length3 = (((~P0.class.getName().length()) | (-1933465013)) & 1883336710) + ((P0.class.getName().length() & 1888506436) | 9438016);
        bArr2[E1.a(length3 | 1892774727, 1892774727, length3)] = -75;
        bArr2[2] = -48;
        bArr2[3] = 101;
        bArr2[4] = -31;
        bArr2[5] = 106;
        bArr2[6] = -110;
        bArr2[7] = 75;
        bArr2[((((~P0.class.getName().length()) | 259398374) & 90357920) + ((P0.class.getName().length() & (-2147429888)) | (-536595966))) ^ (-446238038)] = 71;
        bArr2[9] = 89;
        bArr2[10] = -18;
        bArr2[11] = -57;
        bArr2[12] = ((((~P0.class.getName().length()) | 30302246) & (-1559084284)) + ((P0.class.getName().length() & (-1576008895)) | 71303233)) ^ (-1487781012);
        bArr2[13] = 32;
        bArr2[14] = -1;
        bArr2[15] = -88;
        bArr2[16] = 126;
        bArr2[17] = 1;
        bArr2[18] = 75;
        bArr2[19] = 1;
        int i4 = ((~P0.class.getName().length()) | (-541529321)) & 675029252;
        int length4 = (P0.class.getName().length() & 537133091) | 272696355;
        bArr2[20] = ((length4 & i4) + (i4 | length4)) ^ (-947725671);
        bArr2[21] = ((((~P0.class.getName().length()) | (-1151535868)) & (-2135836413)) + ((P0.class.getName().length() & 1621297675) | 1627521544)) ^ 508314863;
        bArr2[22] = -42;
        bArr2[23] = -2;
        bArr2[24] = 100;
        bArr2[25] = 25;
        bArr2[26] = 75;
        bArr2[27] = -28;
        bArr2[28] = -80;
        bArr2[29] = -58;
        bArr2[30] = -103;
        bArr2[31] = -121;
        bArr2[32] = 8;
        bArr2[33] = -117;
        bArr2[34] = 100;
        bArr2[35] = -101;
        bArr2[36] = 114;
        bArr2[37] = -39;
        bArr2[38] = -7;
        bArr2[39] = -60;
        bArr2[40] = -103;
        bArr2[41] = -33;
        k(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr3 = new byte[36];
        bArr3[0] = -60;
        bArr3[1] = -83;
        bArr3[2] = 114;
        bArr3[3] = -120;
        bArr3[4] = -65;
        bArr3[5] = 55;
        bArr3[6] = -67;
        bArr3[7] = -39;
        bArr3[8] = 1;
        bArr3[9] = 62;
        bArr3[10] = -17;
        bArr3[11] = 93;
        bArr3[12] = 101;
        bArr3[13] = 10;
        bArr3[14] = -40;
        bArr3[15] = 84;
        bArr3[16] = 6;
        bArr3[17] = -10;
        bArr3[18] = 11;
        bArr3[19] = -29;
        bArr3[20] = 47;
        bArr3[21] = 12;
        bArr3[22] = -82;
        int length5 = ((((~P0.class.getName().length()) | 584882554) & 1778943105) + ((P0.class.getName().length() & 1212286081) | 4343810)) ^ 1783286932;
        int i5 = ~P0.class.getName().length();
        bArr3[length5] = (((i5 | (-1160273851)) - ((i5 | (-1161682939)) ^ 173375556)) + ((P0.class.getName().length() & 1426504) | 1073759240)) ^ (-1247134809);
        bArr3[24] = -40;
        bArr3[25] = 89;
        bArr3[26] = -17;
        int length6 = (((~P0.class.getName().length()) | 1916596091) & 1612090880) + ((P0.class.getName().length() & 8585280) | 478240833);
        bArr3[27] = ((length6 & 2090331759) * 2) + ((-2090331760) - length6);
        bArr3[28] = -109;
        bArr3[29] = 109;
        bArr3[30] = 51;
        bArr3[31] = 80;
        bArr3[32] = (-1373652066) ^ ((((P0.class.getName().length() & 14696480) | 17412) + (~(-((I2.a(P0.class, -1) | (-16320299)) & 1373634592)))) + 1);
        bArr3[33] = -69;
        bArr3[34] = -99;
        bArr3[35] = -16;
        byte[] bArr4 = new byte[36];
        bArr4[0] = -64;
        bArr4[1] = -100;
        bArr4[2] = 52;
        bArr4[3] = -26;
        bArr4[4] = -11;
        bArr4[5] = 21;
        bArr4[6] = -18;
        bArr4[7] = -122;
        bArr4[8] = 119;
        int a2 = (I2.a(P0.class, -1) | 2022667120) & 1379943587;
        int length7 = P0.class.getName().length();
        int i6 = ((length7 | 38803075) - (length7 ^ 38803075)) | 546312704;
        int i7 = -a2;
        int i8 = ((~i7) & i6) - (i7 & (~i6));
        bArr4[9] = (((-1926256257) & i8) * 2) + (1926256256 - i8);
        bArr4[10] = -100;
        bArr4[11] = 24;
        bArr4[12] = 51;
        int length8 = (((~P0.class.getName().length()) | (-941367169)) & 1177829425) + ((P0.class.getName().length() & 135602176) | 419506248);
        bArr4[13] = (((~length8) & 1597335632) - (1597335632 & length8)) + length8;
        bArr4[14] = -47;
        bArr4[15] = 13;
        bArr4[16] = 122;
        bArr4[17] = 99;
        bArr4[18] = 123;
        bArr4[19] = -106;
        bArr4[20] = 87;
        bArr4[21] = 63;
        bArr4[22] = -37;
        bArr4[23] = 105;
        bArr4[24] = -51;
        bArr4[25] = 14;
        bArr4[26] = -45;
        bArr4[27] = -105;
        bArr4[28] = 20;
        bArr4[29] = -17;
        bArr4[30] = 113;
        bArr4[31] = 36;
        bArr4[32] = -28;
        bArr4[33] = -86;
        bArr4[34] = ((((~P0.class.getName().length()) | (-1334192561)) & 36212784) + ((P0.class.getName().length() & 37767218) | 4212742)) ^ 40425523;
        bArr4[((((~P0.class.getName().length()) | 380704383) & 50397766) + ((P0.class.getName().length() & 25428224) | 545521944)) ^ 595919741] = 125;
        k(bArr3, bArr4);
        new String(bArr3, charset).intern();
        byte[] bArr5 = new byte[32];
        bArr5[0] = 55;
        bArr5[1] = -56;
        bArr5[2] = 59;
        int i9 = ~P0.class.getName().length();
        bArr5[(((-565164016) & (((~i9) & 1624138363) + i9)) + ((P0.class.getName().length() & (-1643116288)) | 2097542)) ^ (-563066475)] = 120;
        bArr5[4] = 118;
        bArr5[5] = -123;
        bArr5[6] = 104;
        bArr5[7] = 27;
        bArr5[8] = -78;
        bArr5[9] = -107;
        bArr5[10] = -1;
        bArr5[11] = -4;
        bArr5[12] = -31;
        int i10 = ((~P0.class.getName().length()) | (-521222909)) & 1083847632;
        int length9 = P0.class.getName().length();
        int i11 = i10 + (50610177 | ((1340113 + length9) - (length9 | 1340113)));
        bArr5[E1.a(1134457820 | i11, 1134457820, i11)] = -101;
        bArr5[14] = -76;
        bArr5[15] = -64;
        bArr5[16] = 95;
        bArr5[17] = -24;
        bArr5[18] = -93;
        bArr5[19] = -37;
        bArr5[20] = 114;
        bArr5[21] = -25;
        bArr5[22] = 61;
        bArr5[23] = 100;
        bArr5[24] = 32;
        bArr5[25] = (((I2.a(P0.class, -1) | (-1704902952)) & (-1543419914)) + ((P0.class.getName().length() & 604127526) | 1481244673)) ^ 62175279;
        bArr5[26] = -71;
        bArr5[27] = 13;
        bArr5[28] = 23;
        bArr5[29] = 73;
        bArr5[30] = -69;
        bArr5[31] = 102;
        byte[] bArr6 = new byte[32];
        bArr6[0] = 113;
        bArr6[1] = 121;
        bArr6[2] = 109;
        bArr6[3] = -10;
        bArr6[4] = 46;
        bArr6[5] = -57;
        bArr6[6] = 35;
        bArr6[7] = 68;
        bArr6[8] = -22;
        int i12 = ~P0.class.getName().length();
        bArr6[680527061 ^ ((((P0.class.getName().length() | 8388764) - (i12 | 298940927)) + (I2.a(P0.class, 298940923 | i12) + (P0.class.getName().length() & 8388764))) + ((P0.class.getName().length() & 672138244) | 672138304))] = -56;
        bArr6[10] = -84;
        bArr6[11] = 119;
        bArr6[12] = -81;
        bArr6[13] = -104;
        bArr6[14] = -41;
        bArr6[15] = -103;
        bArr6[16] = 64;
        bArr6[17] = 93;
        bArr6[18] = -32;
        bArr6[19] = ((((~P0.class.getName().length()) | (-320145523)) & (-2003516352)) + ((P0.class.getName().length() & 35389516) | 1376256012)) ^ 627260370;
        bArr6[20] = 53;
        bArr6[21] = 86;
        bArr6[22] = 105;
        int i13 = 53036093 & (761953499 + (~P0.class.getName().length()) + (((-r10) - 1) | (-761953499)));
        int length10 = (P0.class.getName().length() & 302057765) | (-1873802944);
        bArr6[(((i13 & length10) * 2) + (length10 ^ i13)) ^ (-1820766870)] = -18;
        bArr6[24] = 92;
        bArr6[25] = 91;
        bArr6[26] = -33;
        bArr6[27] = 91;
        bArr6[28] = 119;
        bArr6[29] = -8;
        bArr6[30] = -34;
        bArr6[31] = -22;
        k(bArr5, bArr6);
        new String(bArr5, charset).intern();
        byte[] bArr7 = new byte[33];
        bArr7[0] = -42;
        bArr7[1] = -99;
        bArr7[2] = 54;
        bArr7[3] = -102;
        int length11 = (((~P0.class.getName().length()) | (-644644113)) & (-1052702438)) + ((P0.class.getName().length() & 4208912) | 303181952);
        bArr7[4] = ((length11 & (-749520463)) * 2) + (749520462 - length11);
        bArr7[5] = -103;
        bArr7[6] = 74;
        bArr7[7] = 115;
        bArr7[8] = -14;
        int length12 = (((~P0.class.getName().length()) | 1713065802) & 25330504) + ((P0.class.getName().length() & (-2050981888)) | (-2075590655));
        bArr7[9] = (((~length12) & (-2050260161)) - ((-2050260161) & length12)) + length12;
        bArr7[10] = -79;
        int length13 = (((~P0.class.getName().length()) | (-1895846369)) & 42209603) + ((P0.class.getName().length() & 660320) | 656928);
        bArr7[B0.a((~length13) | 42866536, 42866536 - length13)] = -8;
        bArr7[12] = -62;
        bArr7[13] = -4;
        bArr7[14] = -104;
        bArr7[15] = 45;
        bArr7[16] = -79;
        bArr7[17] = -5;
        bArr7[18] = -121;
        bArr7[19] = 41;
        bArr7[20] = -25;
        bArr7[21] = 28;
        int length14 = (((~P0.class.getName().length()) | (-2096852312)) & (-1811000548)) + ((P0.class.getName().length() & 1948928276) | 1629490176);
        bArr7[22] = (((~length14) & 181510331) - (181510331 & length14)) + length14;
        bArr7[23] = 36;
        bArr7[((((~P0.class.getName().length()) | (-536901761)) + 1637906627) + ((P0.class.getName().length() & 536967296) | 406913537)) ^ 2044820187] = -60;
        bArr7[25] = 7;
        bArr7[26] = 26;
        bArr7[27] = 121;
        bArr7[28] = 116;
        bArr7[29] = 35;
        bArr7[30] = -104;
        bArr7[31] = -111;
        bArr7[32] = -83;
        byte[] bArr8 = new byte[33];
        bArr8[0] = -46;
        bArr8[1] = -52;
        bArr8[2] = 112;
        bArr8[3] = -44;
        bArr8[4] = -52;
        bArr8[5] = -69;
        bArr8[6] = 69;
        bArr8[7] = 28;
        bArr8[8] = -86;
        bArr8[9] = -21;
        bArr8[10] = -19;
        bArr8[11] = 123;
        bArr8[12] = -46;
        bArr8[13] = -125;
        bArr8[14] = 4;
        bArr8[15] = 48;
        bArr8[16] = -38;
        bArr8[17] = 103;
        bArr8[18] = -4;
        bArr8[19] = 55;
        bArr8[20] = -68;
        bArr8[21] = 77;
        bArr8[22] = -33;
        bArr8[23] = 54;
        bArr8[24] = -60;
        int i14 = ((~P0.class.getName().length()) | 35777226) & 124781184;
        int length15 = (P0.class.getName().length() & 89154560) | 536896512;
        int i15 = -i14;
        bArr8[((((~i15) & length15) * 2) - (i15 ^ length15)) ^ 661677721] = 57;
        bArr8[26] = -109;
        bArr8[27] = 20;
        bArr8[28] = 29;
        bArr8[29] = 28;
        bArr8[((((~P0.class.getName().length()) | 735951406) & (-2013133966)) + ((P0.class.getName().length() & (-2137390760)) | 43515912)) ^ (-1969618076)] = 8;
        bArr8[31] = -40;
        bArr8[32] = -61;
        k(bArr7, bArr8);
        new String(bArr7, charset).intern();
        byte[] bArr9 = new byte[12];
        bArr9[0] = -118;
        bArr9[1] = 67;
        bArr9[((((~P0.class.getName().length()) | 1982331130) & 2483716) + ((P0.class.getName().length() & (-1593833979)) | (-1585444863))) ^ (-1582961145)] = 32;
        bArr9[3] = 35;
        bArr9[4] = 38;
        bArr9[5] = -97;
        bArr9[6] = -126;
        bArr9[7] = -23;
        bArr9[8] = 95;
        bArr9[(((I2.a(P0.class, -1) | 693898586) & 1091012650) + ((P0.class.getName().length() & 1074495536) | 807927888)) ^ 1898940531] = ((((~P0.class.getName().length()) | (-598878726)) & 134890714) + ((P0.class.getName().length() & 269647876) | 311726340)) ^ 446617072;
        bArr9[10] = 36;
        bArr9[11] = -52;
        k(bArr9, new byte[]{15, -9, 98, (((I2.a(P0.class, -1) | (-600150074)) & 338976770) + (((P0.class.getName().length() | (-579076113)) + 579076113) | 713031960)) ^ 1052008745, 105, -54, -39, 113, 83, 27, 109, -90});
        new String(bArr9, charset).intern();
        byte[] bArr10 = new byte[10];
        bArr10[0] = 5;
        bArr10[1] = 73;
        bArr10[2] = 2;
        bArr10[3] = -85;
        bArr10[4] = -60;
        bArr10[5] = 69;
        bArr10[6] = 89;
        bArr10[7] = 2;
        bArr10[((((~P0.class.getName().length()) | (-381882960)) & 403768451) + ((P0.class.getName().length() & 302088195) | 33718304)) ^ 437486763] = -23;
        bArr10[9] = 74;
        byte[] bArr11 = new byte[10];
        bArr11[0] = 125;
        bArr11[1] = -8;
        bArr11[2] = -125;
        bArr11[3] = -82;
        bArr11[4] = -72;
        bArr11[5] = 7;
        bArr11[6] = 46;
        bArr11[7] = 89;
        bArr11[((((~P0.class.getName().length()) | (-16385)) - (-135414850)) + ((P0.class.getName().length() & 570445824) | 838906112)) ^ 974320969] = -103;
        bArr11[9] = 57;
        k(bArr10, bArr11);
        new String(bArr10, charset).intern();
        byte[] bArr12 = {-45, 13, 25, 46, 56, -26, -91, -99, 120, 19, 24, 94, 59};
        byte length16 = ((((~P0.class.getName().length()) | 637232978) & 1169309952) + ((P0.class.getName().length() & 1610612736) | 537460903)) ^ (-1706770928);
        int i16 = ((~P0.class.getName().length()) | 669185823) & 486687236;
        int length17 = (P0.class.getName().length() & 402923936) | 537141672;
        int i17 = -i16;
        int i18 = i17 | length17;
        int i19 = (i18 - (i17 * 2)) + ((i17 ^ length17) ^ i18);
        k(bArr12, new byte[]{length16, 48, Byte.MIN_VALUE, 79, 110, (((~i19) & 1023828936) - (1023828936 & i19)) + i19, -24, -29, 33, 71, -109, 19, 72});
        new String(bArr12, charset).intern();
        byte[] bArr13 = new byte[9];
        bArr13[0] = -110;
        bArr13[(((I2.a(P0.class, -1) | (-1768474072)) & 290211916) + ((P0.class.getName().length() & 692600932) | 673185824)) ^ 963397741] = Byte.MIN_VALUE;
        bArr13[2] = -105;
        bArr13[3] = 85;
        bArr13[4] = (((I2.a(P0.class, -1) | 1019355454) & (-1608075687)) + ((P0.class.getName().length() & (-2145067451)) | 138954756)) ^ (-1469120903);
        bArr13[5] = 69;
        bArr13[6] = -34;
        bArr13[7] = 31;
        bArr13[8] = -10;
        byte[] bArr14 = new byte[9];
        bArr14[0] = 16;
        bArr14[1] = -74;
        bArr14[2] = 4;
        bArr14[3] = 1;
        bArr14[4] = 98;
        bArr14[((((~P0.class.getName().length()) | (-805568513)) + 1879376136) + ((P0.class.getName().length() & 828639232) | 56626688)) ^ 1936002818] = -14;
        bArr14[6] = -50;
        bArr14[7] = 97;
        bArr14[8] = -124;
        k(bArr13, bArr14);
        new String(bArr13, charset).intern();
        byte[] bArr15 = new byte[19];
        bArr15[0] = 86;
        bArr15[1] = 110;
        bArr15[2] = -54;
        bArr15[3] = 5;
        bArr15[4] = 23;
        bArr15[5] = 112;
        bArr15[6] = ((((~P0.class.getName().length()) | (-1463207629)) & (-2125704607)) + ((P0.class.getName().length() & 84166212) | 201458820)) ^ 1924245796;
        bArr15[7] = -65;
        int i20 = ((~P0.class.getName().length()) | 539351424) & 570501416;
        int length18 = P0.class.getName().length();
        int i21 = ((33579053 & length18) ^ 278533) + (length18 & 16389) + i20;
        bArr15[(((~i21) & 570779941) - (570779941 & i21)) + i21] = -46;
        bArr15[9] = -28;
        bArr15[10] = 29;
        bArr15[11] = ((((~P0.class.getName().length()) | (-2134357363)) & (-1453817728)) + ((P0.class.getName().length() & 689078273) | 67256321)) ^ 1386561328;
        bArr15[12] = 68;
        bArr15[13] = -115;
        bArr15[14] = -11;
        bArr15[15] = 12;
        bArr15[16] = 55;
        bArr15[17] = 27;
        bArr15[18] = 7;
        byte[] bArr16 = new byte[19];
        int i22 = ((~P0.class.getName().length()) | (-1630626)) & (-1711077264);
        int length19 = P0.class.getName().length();
        bArr16[(-15524236) ^ (((1695553029 + ((1694502944 | length19) - (length19 ^ 1694502944))) + (((-r14) - 1) | (-1695553029))) + i22)] = 78;
        bArr16[1] = -35;
        bArr16[2] = -66;
        bArr16[3] = 71;
        bArr16[4] = ((((~P0.class.getName().length()) | (-1094741942)) & 202709559) + ((P0.class.getName().length() & (-1040150987)) | (-763329472))) ^ (-560620020);
        bArr16[5] = -45;
        bArr16[6] = -67;
        bArr16[7] = -60;
        bArr16[8] = -46;
        bArr16[9] = 88;
        bArr16[10] = -118;
        bArr16[11] = -84;
        bArr16[12] = 84;
        bArr16[13] = -112;
        bArr16[14] = -78;
        bArr16[15] = 102;
        bArr16[16] = 66;
        bArr16[17] = 104;
        bArr16[18] = 98;
        k(bArr15, bArr16);
        new String(bArr15, charset).intern();
        byte[] bArr17 = new byte[19];
        bArr17[0] = 124;
        bArr17[1] = -84;
        bArr17[2] = 18;
        bArr17[3] = -50;
        bArr17[((((~P0.class.getName().length()) | (-840061071)) & 420021848) + ((P0.class.getName().length() & 270563336) | 35944449)) ^ 455966301] = 95;
        bArr17[5] = -10;
        bArr17[6] = ((((~P0.class.getName().length()) | (-4195)) + 34623587) + ((P0.class.getName().length() & 150999138) | 150994948)) ^ (-185618507);
        bArr17[7] = 43;
        bArr17[8] = -20;
        bArr17[9] = 19;
        bArr17[10] = 16;
        int i23 = ((~P0.class.getName().length()) | (-1808834139)) & 186361217;
        int length20 = P0.class.getName().length();
        bArr17[11] = (i23 + (272650266 | ((189842434 + length20) - (length20 | 189842434)))) ^ 459011533;
        bArr17[12] = -108;
        bArr17[13] = -50;
        bArr17[14] = -114;
        bArr17[15] = 67;
        bArr17[16] = 104;
        bArr17[17] = -13;
        bArr17[18] = -74;
        byte[] bArr18 = new byte[19];
        bArr18[0] = 8;
        bArr18[1] = -13;
        bArr18[2] = 105;
        bArr18[3] = -7;
        bArr18[4] = ((((~P0.class.getName().length()) | 1222250361) & (-1572790056)) + ((P0.class.getName().length() & (-1442241919)) | 134743553)) ^ (-1438046466);
        bArr18[5] = -56;
        bArr18[6] = -95;
        bArr18[7] = 114;
        bArr18[8] = 108;
        bArr18[9] = -86;
        bArr18[10] = 94;
        bArr18[11] = -111;
        bArr18[12] = -53;
        int i24 = ((~P0.class.getName().length()) | 764299995) & 125829392;
        int length21 = P0.class.getName().length() & (-2112749184);
        bArr18[(-2020212323) ^ ((((~length21) & (-2146041728)) + length21) + i24)] = -37;
        bArr18[14] = -54;
        bArr18[15] = 64;
        bArr18[16] = 1;
        bArr18[17] = -99;
        bArr18[18] = -47;
        w(bArr17, bArr18);
        String intern = new String(bArr17, charset).intern();
        byte[] bArr19 = {-56, 39, -14, 87, 36, -72, 21, 32, -26, 38, -41, -8, 67, -94, -23, -33, -58, 121, -127, 6, -65, 7};
        byte length22 = ((((~P0.class.getName().length()) | 2087811355) & 1613252648) + ((P0.class.getName().length() & 525344) | 168822018)) ^ ForkServer.INIT_PARSER_FACTORY_FACTORY;
        int i25 = ((~P0.class.getName().length()) | 129630091) & (-2101067320);
        int length23 = P0.class.getName().length();
        int i26 = ((((-2140929472) & length23) + 539492867) - (length23 & 2097664)) + i25;
        w(bArr19, new byte[]{-108, 120, -119, -110, length22, 7, 101, 96, B0.a((~i26) | (-1561574472), (-1561574472) - i26), 115, -29, -78, 22, -10, -123, -55, -104, 77, -103, 122, -46, 116});
        String intern2 = new String(bArr19, charset).intern();
        byte[] bArr20 = new byte[31];
        bArr20[0] = 60;
        bArr20[1] = 22;
        bArr20[2] = 112;
        bArr20[3] = -29;
        bArr20[4] = 96;
        bArr20[5] = -75;
        bArr20[6] = -116;
        bArr20[7] = 6;
        bArr20[8] = -49;
        int i27 = ((~P0.class.getName().length()) | 968785919) - 967589615;
        int length24 = P0.class.getName().length();
        bArr20[9] = (i27 + (17041505 | (((-951746464) + length24) - (length24 | (-951746464))))) ^ 950548185;
        bArr20[10] = 74;
        bArr20[11] = -71;
        int i28 = ((~P0.class.getName().length()) | 838330696) & 679512459;
        int length25 = P0.class.getName().length() & 134238871;
        bArr20[696310675 ^ ((((~length25) & 16798228) + length25) + i28)] = -112;
        bArr20[13] = 32;
        bArr20[14] = -71;
        bArr20[15] = 69;
        bArr20[16] = -68;
        bArr20[17] = 80;
        bArr20[1760026847 ^ (((((P0.class.getName().length() | (-1212186698)) - (-1212186698)) | 8847552) + (~(-(((~P0.class.getName().length()) | (-1498974970)) & 1751179277)))) + 1)] = 0;
        bArr20[19] = 40;
        bArr20[20] = 43;
        bArr20[21] = 31;
        bArr20[22] = 104;
        bArr20[23] = -86;
        bArr20[24] = 15;
        bArr20[25] = -57;
        bArr20[26] = 113;
        bArr20[27] = -68;
        bArr20[28] = -60;
        bArr20[29] = 21;
        bArr20[30] = 9;
        byte[] bArr21 = new byte[31];
        bArr21[0] = 72;
        bArr21[1] = -87;
        bArr21[2] = 7;
        bArr21[3] = -26;
        bArr21[4] = -4;
        bArr21[5] = -1;
        bArr21[6] = -39;
        bArr21[7] = 65;
        bArr21[8] = -105;
        int i29 = ~P0.class.getName().length();
        bArr21[1913042866 ^ (((570458260 + (P0.class.getName().length() & 302286371)) + (((-r11) - 1) | (-570458260))) + (1342584616 & (((((P0.class.getName().length() & (~i29)) & 1719284043) + 1719284043) + i29) - ((i29 | P0.class.getName().length()) & 1719284043))))] = -10;
        bArr21[10] = 24;
        bArr21[11] = -28;
        bArr21[12] = -24;
        bArr21[13] = 121;
        int length26 = ((((~P0.class.getName().length()) | (-635522617)) & 2008023842) + ((P0.class.getName().length() & 636224168) | 5013656)) ^ 2013037492;
        int i30 = ((~P0.class.getName().length()) | (-131489)) - 1593671255;
        int length27 = P0.class.getName().length();
        bArr21[length26] = (i30 + ((((P0.class.getName().length() | 134877602) - (length27 | 134877602)) + (I2.a(P0.class, length27) + (P0.class.getName().length() & 134877602))) | 1212682242)) ^ 380989037;
        bArr21[15] = -124;
        bArr21[16] = -58;
        bArr21[17] = 80;
        bArr21[18] = 90;
        bArr21[19] = 31;
        bArr21[20] = 65;
        bArr21[21] = -82;
        int i31 = (~(~P0.class.getName().length())) | (-128207634);
        bArr21[22] = 133579897 ^ ((((-2140903693) - i31) - ((-2012696058) | ((-128207635) - i31))) + ((P0.class.getName().length() & 536939136) | 1879116176));
        bArr21[23] = -15;
        bArr21[24] = 99;
        bArr21[25] = -39;
        bArr21[26] = 0;
        bArr21[27] = -10;
        bArr21[28] = -76;
        bArr21[29] = 101;
        bArr21[30] = 122;
        w(bArr20, bArr21);
        String intern3 = new String(bArr20, charset).intern();
        byte[] bArr22 = {62, -125, -124, -7, -66, 37, -64, 93, 15, -16, -11, -127, 118, 66, -24, 36, 115, -72, -14, 5};
        int i32 = ((~P0.class.getName().length()) | 1371494009) & 1688249476;
        int i33 = ~(((P0.class.getName().length() | (-604020885)) - (-604020885)) | 4259921);
        int i34 = -i32;
        w(bArr22, new byte[]{70, V2.a(~i34, i33, (i33 + i34) + 1) ^ 1692509385, -44, -16, -65, Byte.MIN_VALUE, -117, 67, 83, -55, -59, -7, -17, 97, 111, 94, -22, 2, -126, -118});
        String intern4 = new String(bArr22, charset).intern();
        byte[] bArr23 = {11, -32, 54, -47, -103, 9, 101, -102, 96, 111, 7, 22, -35, 88, 25, -36, 92};
        w(bArr23, new byte[]{81, -65, 69, 24, -54, -112, -18, 13, -10, 53, 19, -108, -91, 90, 92, -46, 40});
        String intern5 = new String(bArr23, charset).intern();
        byte[] bArr24 = new byte[18];
        bArr24[((((~P0.class.getName().length()) | 1915506523) & 1788194818) + (((P0.class.getName().length() | 2003701719) - 2003701719) | (-1879029720))) ^ (-90834902)] = 50;
        bArr24[1] = -5;
        bArr24[2] = 123;
        bArr24[3] = -7;
        bArr24[4] = 74;
        bArr24[5] = -90;
        bArr24[6] = -113;
        bArr24[7] = -111;
        bArr24[8] = 114;
        bArr24[9] = 63;
        bArr24[10] = 21;
        bArr24[11] = 108;
        bArr24[12] = -20;
        bArr24[13] = -105;
        bArr24[14] = -84;
        bArr24[15] = -27;
        bArr24[16] = -98;
        bArr24[17] = 6;
        w(bArr24, new byte[]{58, -60, 0, -16, 27, -1, -40, 23, 8, -122, 37, 26, 110, 23, -80, -97, -11, 117});
        String intern6 = new String(bArr24, charset).intern();
        byte[] bArr25 = new byte[15];
        bArr25[0] = -109;
        bArr25[(-2084306127) ^ (((((P0.class.getName().length() | (-17040145)) + R.string.face_acquired_pan_too_extreme) | (-2143288832)) - (~(((~P0.class.getName().length()) | (-1634612574)) & 58982704))) - 1)] = 110;
        bArr25[2] = 48;
        bArr25[3] = 109;
        bArr25[4] = 113;
        bArr25[5] = 54;
        bArr25[6] = -74;
        bArr25[7] = 2;
        bArr25[8] = -66;
        bArr25[9] = 112;
        bArr25[10] = 114;
        bArr25[11] = 22;
        bArr25[12] = 102;
        bArr25[13] = -78;
        bArr25[14] = -107;
        w(bArr25, new byte[]{-39, 49, 71, 92, 7, 118, -80, -122, 121, 77, -3, 124, 13, -41, -31});
        String intern7 = new String(bArr25, charset).intern();
        byte[] bArr26 = new byte[17];
        bArr26[0] = -59;
        bArr26[1] = -97;
        bArr26[2] = 109;
        bArr26[3] = 125;
        bArr26[((((~P0.class.getName().length()) | 634334502) & 608306313) + ((P0.class.getName().length() & 1073741981) | 1358954516)) ^ 1967260825] = 78;
        bArr26[5] = -37;
        bArr26[6] = 37;
        bArr26[7] = -73;
        bArr26[8] = 79;
        bArr26[9] = -35;
        bArr26[10] = -109;
        bArr26[11] = 67;
        bArr26[12] = 25;
        bArr26[13] = 75;
        bArr26[14] = 0;
        bArr26[15] = 96;
        bArr26[16] = 28;
        int i35 = ((~P0.class.getName().length()) | (-35651591)) - (-723665415);
        int length28 = (P0.class.getName().length() & 35684367) | 67405897;
        int i36 = -i35;
        w(bArr26, new byte[]{-113, 32, -21, 107, 15, -18, 70, -36, 791071320 ^ ((((~i36) & length28) * 2) - (i36 ^ length28)), -35, -89, 71, 97, 105, 85, 30, 104});
        String intern8 = new String(bArr26, charset).intern();
        byte[] bArr27 = new byte[17];
        int i37 = ~P0.class.getName().length();
        bArr27[0] = (-1164867318) ^ ((((P0.class.getName().length() | (-1609529058)) - (i37 | (-298737698))) + (I2.a(P0.class, (-299786296) | i37) + (P0.class.getName().length() & (-1609529058)))) + ((P0.class.getName().length() & 135266326) | 444661824));
        bArr27[1] = 26;
        int i38 = ~P0.class.getName().length();
        int length29 = ((P0.class.getName().length() | 1315197313) - (i38 | 1593203679)) + I2.a(P0.class, 1420954463 | i38) + (P0.class.getName().length() & 1315197313);
        int length30 = P0.class.getName().length();
        bArr27[1333154275 ^ (length29 + (17956960 | ((172380384 | length30) - (length30 ^ 172380384))))] = 33;
        bArr27[3] = 118;
        bArr27[4] = 84;
        bArr27[5] = -87;
        bArr27[6] = 12;
        bArr27[7] = 91;
        bArr27[((((~P0.class.getName().length()) | (-78491866)) & 9628771) + ((P0.class.getName().length() & 612672065) | (-1375469048))) ^ (-1365840285)] = -13;
        bArr27[9] = 85;
        bArr27[10] = -56;
        bArr27[11] = -10;
        bArr27[12] = -7;
        bArr27[13] = 85;
        bArr27[14] = -61;
        bArr27[15] = 115;
        bArr27[16] = -17;
        w(bArr27, new byte[]{32, -91, 54, 113, 36, -9, 83, 68, -120, 80, -91, -15, 115, 81, -106, 26, -118});
        String intern9 = new String(bArr27, charset).intern();
        byte[] bArr28 = {88, 78, -73, -80, 75, 124, -72, 96, -54, 66, 28, -118, -49, -84, 95, -93, -50};
        w(bArr28, new byte[]{36, 81, -60, -73, 38, 69, -72, 40, -51, 83, 86, 19, -91, 8, 27, -22, -85});
        String intern10 = new String(bArr28, charset).intern();
        byte[] bArr29 = new byte[((((~P0.class.getName().length()) | (-1288156750)) & 33642544) + ((P0.class.getName().length() & 545329282) | 746586242)) ^ 780228778];
        bArr29[0] = -62;
        bArr29[1] = -47;
        bArr29[2] = 124;
        bArr29[3] = -12;
        bArr29[4] = -17;
        bArr29[5] = 46;
        bArr29[6] = -48;
        bArr29[7] = -103;
        bArr29[8] = 122;
        bArr29[9] = 16;
        bArr29[10] = 16;
        bArr29[11] = -35;
        bArr29[12] = -105;
        bArr29[13] = 68;
        bArr29[14] = 84;
        bArr29[15] = -96;
        bArr29[16] = -106;
        bArr29[17] = 40;
        bArr29[151462345 ^ (((16777482 + (P0.class.getName().length() & 134676739)) + (((-r10) - 1) | (-16777482))) + (((~P0.class.getName().length()) | 1348530141) & 134684882))] = -115;
        bArr29[19] = 116;
        bArr29[20] = -1;
        bArr29[21] = 113;
        bArr29[22] = 19;
        bArr29[23] = -20;
        byte[] bArr30 = new byte[24];
        bArr30[0] = -118;
        bArr30[1] = -18;
        bArr30[2] = -5;
        bArr30[3] = -14;
        bArr30[4] = ((((~P0.class.getName().length()) | (-624998922)) & 171122754) + ((P0.class.getName().length() & 604004353) | 624969217)) ^ 796091951;
        bArr30[5] = 123;
        bArr30[6] = -88;
        bArr30[7] = 15;
        int length31 = (46574200 & ((-1332010754) + (~P0.class.getName().length()) + (((-r4) - 1) | 1332010754))) + ((P0.class.getName().length() & 1263307264) | 1495793794);
        bArr30[(1542367986 + length31) - ((length31 & 1542367986) * 2)] = -11;
        bArr30[9] = -82;
        bArr30[10] = (-130155919) ^ (((1479018506 + (P0.class.getName().length() & (-2145900031))) + (((-r11) - 1) | (-1479018506))) + (((~P0.class.getName().length()) | 573431283) & (-1609174448)));
        bArr30[11] = -54;
        bArr30[12] = -37;
        bArr30[13] = 91;
        bArr30[14] = 17;
        bArr30[15] = -89;
        bArr30[16] = -32;
        bArr30[17] = -120;
        bArr30[18] = -25;
        bArr30[19] = 32;
        bArr30[20] = 116;
        bArr30[21] = 78;
        int length32 = P0.class.getName().length();
        bArr30[((((-495200327) | (((~length32) - length32) + length32)) & 1899703298) + ((P0.class.getName().length() & 365176962) | (-2067496824))) ^ (-167793508)] = 75;
        bArr30[23] = -94;
        w(bArr29, bArr30);
        String intern11 = new String(bArr29, charset).intern();
        byte[] bArr31 = {-118, -113, -120, 11, 121, 23, 74, -23, Byte.MAX_VALUE, 89, -2, 40, 79, 126, -26, 23, 6, -29, -85, -29};
        int i39 = ~P0.class.getName().length();
        w(bArr31, new byte[]{-46, 16, -48, 62, -3, -89, 40, -97, -10, (((~(((P0.class.getName().length() | 1558601929) | i39) - (i39 | (P0.class.getName().length() & (-1558601930))))) & 1153604368) + ((P0.class.getName().length() & (-991821760)) | (-2145304480))) ^ (-991700203), 124, 98, 74, 77, 111, -115, 17, -68, -55, -101});
        String intern12 = new String(bArr31, charset).intern();
        byte[] bArr32 = new byte[18];
        bArr32[0] = 3;
        bArr32[1] = -98;
        bArr32[2] = -77;
        bArr32[3] = -105;
        bArr32[4] = -22;
        bArr32[5] = 35;
        bArr32[6] = -112;
        bArr32[7] = -78;
        bArr32[8] = -103;
        int length33 = P0.class.getName().length();
        bArr32[((22056733 & ((-731378242) - ((~((length33 - 1) - (length33 * 2))) | (-731378241)))) + ((P0.class.getName().length() & 18653696) | 1410146432)) ^ 1432203156] = 71;
        bArr32[10] = -125;
        bArr32[11] = -18;
        bArr32[12] = ((((~P0.class.getName().length()) | 1511948626) & 1854406874) + ((P0.class.getName().length() & 633340040) | (-2124408576))) ^ 270001733;
        bArr32[13] = 81;
        bArr32[14] = -30;
        bArr32[15] = 121;
        bArr32[16] = 6;
        bArr32[17] = -4;
        byte[] bArr33 = new byte[18];
        bArr33[0] = 73;
        bArr33[1] = 33;
        bArr33[2] = -55;
        int i40 = ((~P0.class.getName().length()) | (-440959858)) & 546571280;
        int length34 = P0.class.getName().length();
        bArr33[(i40 + ((-2006908896) | ((134217744 + length34) - (length34 | 134217744)))) ^ (-1460337613)] = -46;
        bArr33[4] = 116;
        bArr33[5] = Byte.MIN_VALUE;
        bArr33[6] = ((((~P0.class.getName().length()) | (-1090539589)) & (-2145056656)) + ((P0.class.getName().length() & 33601) | 1077970689)) ^ 1067086014;
        bArr33[7] = -38;
        bArr33[8] = -96;
        bArr33[9] = 86;
        bArr33[10] = -35;
        bArr33[11] = -73;
        bArr33[12] = -37;
        bArr33[13] = 96;
        bArr33[14] = 122;
        bArr33[15] = 43;
        bArr33[16] = 99;
        bArr33[17] = -120;
        w(bArr32, bArr33);
        String intern13 = new String(bArr32, charset).intern();
        byte[] bArr34 = {-90, ((((~P0.class.getName().length()) | (-1413745691)) & 1149247624) + ((P0.class.getName().length() & 1140850760) | 50332736)) ^ 1199580329, 108, -83, 126, 2, 112, 31, -37, 124, -7, -116, -102, 59};
        w(bArr34, new byte[]{-59, 69, -13, -101, 6, -99, 7, 74, -97, 77, 117, 0, -1, 79});
        String intern14 = new String(bArr34, charset).intern();
        byte[] bArr35 = {-87, 111, -104, 95, -70, 18, 59, -67, -93, 49, -9, -35, -58, 113, -39, 112};
        w(bArr35, new byte[]{-77, 48, -33, -118, -64, -89, 60, -32, -65, 79, -124, -57, -101, 78, -107, 46});
        f351d = m3.b.N(intern, intern2, intern3, intern4, intern5, intern6, intern7, intern8, intern9, intern10, intern11, intern12, intern13, intern14, new String(bArr35, charset).intern());
        byte[] bArr36 = {45, 118, (((I2.a(P0.class, -1) | 114747004) & 100946024) + ((P0.class.getName().length() & 25170176) | 25723139)) ^ 126669059, -85, -6, -93, 104, 97, -94, 14, -93, -74, 87, 116, -28, 90, -38, -81, 31, 115, -98, -80, 114, 1, 46, 65, 117, 6, -60, -6, 71, -114, -20, 14, -112, 116, -60, 124, 120, 39, -103, -76, 92, 6, 46};
        byte[] bArr37 = new byte[45];
        bArr37[((((~P0.class.getName().length()) | 239778011) & 281111810) + ((P0.class.getName().length() & 310462208) | 185074176)) ^ 466185986] = 53;
        bArr37[1] = 72;
        bArr37[2] = -10;
        bArr37[3] = -15;
        bArr37[4] = 126;
        bArr37[5] = -6;
        bArr37[6] = -10;
        bArr37[7] = 103;
        bArr37[8] = -69;
        int i41 = ((~P0.class.getName().length()) | 451897638) & 1140919052;
        int length35 = P0.class.getName().length();
        bArr37[9] = (i41 + (453017600 | ((1174405640 + length35) - (length35 | 1174405640)))) ^ (-1593936745);
        bArr37[10] = -69;
        bArr37[11] = -12;
        bArr37[12] = 39;
        bArr37[13] = 55;
        bArr37[14] = -127;
        bArr37[15] = 76;
        bArr37[16] = -98;
        bArr37[17] = -15;
        bArr37[18] = 27;
        bArr37[19] = 74;
        bArr37[20] = -64;
        bArr37[21] = 46;
        int i42 = ((~P0.class.getName().length()) | 1007307720) & 305242700;
        int length36 = P0.class.getName().length() & 45211783;
        int length37 = (((((~length36) & P0.class.getName().length()) & 8405123) + 8405123) + length36) - ((length36 | P0.class.getName().length()) & 8405123);
        int i43 = -i42;
        bArr37[22] = 313647854 ^ ((((~i43) & length37) * 2) - (length37 ^ i43));
        bArr37[((((~P0.class.getName().length()) | (-1287729176)) & 734003200) + ((P0.class.getName().length() & 148897798) | 2621446)) ^ 736624657] = 119;
        bArr37[24] = 88;
        bArr37[25] = 50;
        bArr37[26] = 32;
        bArr37[27] = 92;
        bArr37[28] = Byte.MIN_VALUE;
        int i44 = ((~P0.class.getName().length()) | 1977703721) & 348197000;
        int length38 = (P0.class.getName().length() & 537002113) | 570558273;
        int i45 = -i44;
        bArr37[918755284 ^ ((((~i45) & length38) * 2) - (i45 ^ length38))] = -39;
        bArr37[30] = -8;
        bArr37[31] = -28;
        bArr37[32] = -114;
        bArr37[33] = 114;
        bArr37[34] = -61;
        bArr37[35] = 57;
        int length39 = (((~P0.class.getName().length()) | 1463052021) & 1645871912) + ((P0.class.getName().length() & 548012300) | 14680196);
        bArr37[36] = B0.a((~length39) | (-1660552150), (-1660552150) - length39);
        bArr37[37] = 83;
        bArr37[38] = 21;
        bArr37[39] = 123;
        bArr37[40] = -76;
        bArr37[41] = 18;
        bArr37[42] = 0;
        bArr37[43] = 94;
        bArr37[44] = 107;
        w(bArr36, bArr37);
        String intern15 = new String(bArr36, charset).intern();
        byte[] bArr38 = new byte[38];
        bArr38[0] = Byte.MAX_VALUE;
        bArr38[1] = -121;
        int i46 = (-353221016) - ((~(~P0.class.getName().length())) | (-353221015));
        bArr38[2] = (-1936231283) ^ ((((P0.class.getName().length() | 1883802184) - (i46 | 1883802184)) + (I2.a(P0.class, i46) + (P0.class.getName().length() & 1883802184))) + ((P0.class.getName().length() & 287869186) | 52429074));
        bArr38[3] = 24;
        bArr38[4] = 19;
        bArr38[((((~P0.class.getName().length()) | 987312339) & 302035536) + ((P0.class.getName().length() & 553681412) | 1694760964)) ^ 1996796497] = 42;
        bArr38[6] = -52;
        bArr38[7] = 18;
        int i47 = ((~P0.class.getName().length()) | (-370378067)) & (-1731845339);
        int length40 = (P0.class.getName().length() & 369233160) | 1728617480;
        int length41 = ((length40 | i47) - (((~i47) & P0.class.getName().length()) & length40)) + ((i47 | P0.class.getName().length()) & length40);
        bArr38[8] = (((~length41) & (-3227824)) - ((-3227824) & length41)) + length41;
        bArr38[9] = ((((~P0.class.getName().length()) | (-1656924459)) & 201785993) + ((P0.class.getName().length() & (-1874722808)) | (-1866430460))) ^ (-1664644463);
        bArr38[10] = -122;
        bArr38[11] = ((((~P0.class.getName().length()) | 2068292173) & 268895806) + ((P0.class.getName().length() & 2131058) | 86540736)) ^ 355436506;
        int length42 = (((~P0.class.getName().length()) | (-1055861123)) & (-1339420560)) + ((P0.class.getName().length() & 1882849537) | 1091567873);
        bArr38[((length42 & 247852674) * 2) + ((-247852675) - length42)] = -32;
        bArr38[13] = 76;
        int i48 = ~P0.class.getName().length();
        int length43 = ((P0.class.getName().length() | 1141921800) - (i48 | 1955879546)) + I2.a(P0.class, 1955875442 | i48) + (P0.class.getName().length() & 1141921800) + ((P0.class.getName().length() & 536940552) | 805380228);
        bArr38[14] = ((-1947302075) + length43) - (((-1947302075) & length43) * 2);
        bArr38[15] = 39;
        bArr38[16] = -40;
        bArr38[17] = -114;
        bArr38[(-2133215183) ^ ((((P0.class.getName().length() & (-2142693343)) | 4792321) + (~(-(((~P0.class.getName().length()) | 1771561291) & (-2138007518))))) + 1)] = -65;
        int i49 = ~P0.class.getName().length();
        int length44 = ((-1306359776) & (((-1968919257) ^ i49) + (i49 & (-1968919257)))) + ((P0.class.getName().length() & 1887576324) | 1082142982);
        bArr38[19] = E1.a((-224216766) | length44, -224216766, length44);
        bArr38[20] = 22;
        bArr38[21] = 47;
        bArr38[22] = -103;
        bArr38[23] = 119;
        bArr38[24] = -84;
        bArr38[25] = 26;
        bArr38[26] = 110;
        bArr38[27] = 57;
        int i50 = ((~P0.class.getName().length()) | 1043922127) & 1023952416;
        int length45 = (P0.class.getName().length() & (-2130705616)) | (-2104491628);
        int i51 = -i50;
        bArr38[28] = 1080539196 ^ (((~i51) & length45) - (i51 & (~length45)));
        bArr38[29] = -94;
        int i52 = ((~P0.class.getName().length()) | 1275157925) & 1184794660;
        int length46 = (P0.class.getName().length() & 312401920) | 285238272;
        int i53 = -i52;
        bArr38[1470032954 ^ ((length46 ^ i53) - ((i53 & (~length46)) * 2))] = 11;
        bArr38[31] = 33;
        bArr38[32] = 72;
        bArr38[33] = ((((~P0.class.getName().length()) | 436674147) & 1092748311) + ((P0.class.getName().length() & 1092616212) | 570429568)) ^ 1663177982;
        bArr38[34] = -88;
        bArr38[35] = 99;
        bArr38[36] = 28;
        int i54 = ((~P0.class.getName().length()) | 2010084810) & 1377519644;
        int length47 = P0.class.getName().length();
        bArr38[37] = (i54 + (146834627 | ((13666516 + length47) - (length47 | 13666516)))) ^ 1524354275;
        byte[] bArr39 = new byte[38];
        int i55 = ((~P0.class.getName().length()) | (-1747852687)) & (-1069021595);
        int length48 = (P0.class.getName().length() & 1208495124) | 151037968;
        int i56 = -i55;
        bArr39[0] = (-917983630) ^ (((~i56) & length48) - (i56 & (~length48)));
        bArr39[1] = 25;
        bArr39[2] = -98;
        bArr39[3] = -125;
        bArr39[4] = 101;
        bArr39[5] = 115;
        bArr39[6] = -110;
        bArr39[7] = 85;
        bArr39[8] = -10;
        bArr39[9] = -88;
        bArr39[10] = -34;
        bArr39[11] = 98;
        int i57 = ~P0.class.getName().length();
        int length49 = 404132545 & (((((P0.class.getName().length() & (~i57)) & 2029344861) + 2029344861) + i57) - ((i57 | P0.class.getName().length()) & 2029344861));
        int length50 = P0.class.getName().length();
        int length51 = ((P0.class.getName().length() | 1078100610) - (length50 | 1078100610)) + I2.a(P0.class, length50) + (P0.class.getName().length() & 1078100610);
        int i58 = (1136656646 + length51) - (1136656646 & length51);
        bArr39[12] = 1540789173 ^ (((i58 | length49) * 2) - (length49 ^ i58));
        bArr39[13] = 111;
        bArr39[14] = -92;
        bArr39[15] = 103;
        bArr39[16] = -96;
        bArr39[17] = 16;
        bArr39[18] = 124;
        bArr39[19] = 80;
        bArr39[20] = 56;
        bArr39[21] = -84;
        bArr39[22] = -73;
        bArr39[23] = 75;
        bArr39[24] = -54;
        bArr39[25] = 117;
        bArr39[26] = 25;
        bArr39[27] = -114;
        bArr39[28] = -74;
        bArr39[29] = 32;
        bArr39[30] = 74;
        bArr39[31] = -105;
        bArr39[((((~P0.class.getName().length()) | (-1294014731)) & 1075248) + ((P0.class.getName().length() & 270632961) | 271155201)) ^ 272230417] = 8;
        bArr39[33] = 80;
        bArr39[34] = ((((~P0.class.getName().length()) | (-1084852497)) - (-1172938065)) + ((P0.class.getName().length() & 1085114648) | 35012616)) ^ (-1207950712);
        bArr39[35] = 64;
        bArr39[36] = 83;
        bArr39[37] = 107;
        w(bArr38, bArr39);
        String intern16 = new String(bArr38, charset).intern();
        byte[] bArr40 = new byte[27];
        bArr40[0] = -29;
        bArr40[1] = 57;
        bArr40[2] = 72;
        bArr40[3] = 111;
        bArr40[4] = -79;
        bArr40[5] = 10;
        bArr40[6] = -93;
        bArr40[7] = -59;
        bArr40[8] = -64;
        bArr40[9] = 13;
        bArr40[10] = -82;
        bArr40[11] = ((((~P0.class.getName().length()) | 254838310) & 1543504956) + ((P0.class.getName().length() & 1343291480) | 17940544)) ^ 1561445404;
        bArr40[12] = 81;
        bArr40[13] = 43;
        bArr40[14] = -14;
        bArr40[15] = 79;
        bArr40[16] = 82;
        bArr40[17] = -110;
        bArr40[18] = 86;
        bArr40[19] = 3;
        int i59 = ~P0.class.getName().length();
        int length52 = P0.class.getName().length();
        int i60 = (272754949 + length52) - (length52 | 272754949);
        bArr40[507767057 ^ (((4276480 + i60) - (i60 & 4276480)) + (((-503490566) | (((-275365072) ^ i59) + (i59 & (-275365072)))) - (-503490566)))] = -70;
        bArr40[21] = 37;
        bArr40[22] = -90;
        bArr40[23] = 33;
        bArr40[24] = 2;
        bArr40[25] = -58;
        bArr40[26] = -92;
        byte[] bArr41 = new byte[27];
        bArr41[0] = 107;
        bArr41[((((~P0.class.getName().length()) | (-1216468548)) & 864643841) + ((P0.class.getName().length() & 1082475021) | 1208352828)) ^ 2072996668] = -121;
        bArr41[2] = 22;
        bArr41[3] = 54;
        bArr41[4] = -57;
        bArr41[5] = -109;
        int a4 = (I2.a(P0.class, -1) | (-1747662375)) & (-533455790);
        int length53 = (P0.class.getName().length() & 1948300578) | 339779872;
        int i61 = -a4;
        bArr41[6] = 193675971 ^ ((((~i61) & length53) * 2) - (i61 ^ length53));
        bArr41[7] = 4;
        bArr41[8] = -103;
        bArr41[9] = -104;
        bArr41[10] = -58;
        bArr41[11] = 38;
        bArr41[12] = 33;
        bArr41[13] = -120;
        bArr41[14] = 107;
        bArr41[15] = 63;
        bArr41[16] = 38;
        bArr41[17] = 44;
        bArr41[18] = 99;
        bArr41[19] = 106;
        bArr41[20] = -24;
        bArr41[((((~P0.class.getName().length()) | 1799037716) & (-1735982889)) + ((P0.class.getName().length() & (-1867249461)) | 3148808)) ^ (-1732834102)] = -108;
        bArr41[22] = -52;
        bArr41[23] = -105;
        bArr41[24] = 81;
        bArr41[25] = -117;
        bArr41[26] = -9;
        w(bArr40, bArr41);
        f352e = m3.b.y(intern15, intern16, new String(bArr40, charset).intern());
        byte[] bArr42 = {1, -125, 59, 57, 107, 63, -71, -99, 80, 35, 81, -72, 16, -79, -68, -108, -12, -119, 107, 64, 88, -10, 4, 21, -7};
        byte[] bArr43 = new byte[(-1302068497) ^ ((((722668973 | r3) - 1577057562) - ((~P0.class.getName().length()) | (-1424814097))) + ((P0.class.getName().length() & (-2140929470)) | 274989072))];
        int length54 = (((~P0.class.getName().length()) + (((-r4) - 1) | (-2032469352)) + 2032469352) & (-1325263804)) + ((P0.class.getName().length() & (-2079714816)) | 201851522);
        bArr43[0] = ((length54 & 1123412336) * 2) + ((-1123412337) - length54);
        bArr43[1] = 29;
        bArr43[2] = 74;
        bArr43[3] = 100;
        int i62 = ((~P0.class.getName().length()) | 395733439) & 1409813176;
        int length55 = P0.class.getName().length();
        int i63 = (-2096873212) | ((1107837440 | length55) - (length55 ^ 1107837440));
        bArr43[(((i62 & i63) * 2) + (i63 ^ i62)) ^ (-687060040)] = -19;
        bArr43[5] = -123;
        bArr43[6] = -57;
        bArr43[7] = -52;
        bArr43[8] = 9;
        bArr43[9] = 118;
        bArr43[10] = 13;
        bArr43[11] = -18;
        bArr43[12] = 98;
        bArr43[13] = -14;
        bArr43[14] = -71;
        bArr43[((((~P0.class.getName().length()) | (-1573121)) - (-169706753)) + ((P0.class.getName().length() & 18358528) | (-1052745720))) ^ (-883038969)] = 22;
        bArr43[16] = -124;
        bArr43[17] = 23;
        bArr43[18] = 48;
        bArr43[19] = 28;
        bArr43[20] = 2;
        bArr43[21] = -21;
        bArr43[22] = 43;
        bArr43[23] = 96;
        bArr43[24] = -72;
        w(bArr42, bArr43);
        String intern17 = new String(bArr42, charset).intern();
        int length56 = (((~P0.class.getName().length()) | (-1478980453)) & 12591373) + ((P0.class.getName().length() & 10500) | 268437552);
        byte b4 = (281028897 + length56) - ((length56 & 281028897) * 2);
        int length57 = (((~P0.class.getName().length()) | (-1824887639)) & 3180302) + ((P0.class.getName().length() & 71336710) | 79691936);
        byte[] bArr44 = {-44, 108, -92, 10, -30, 120, 75, 19, 73, b4, 51, 78, 67, -11, 37, 36, -29, -120, -114, -70, 56, ((-82872297) | length57) - (length57 & (-82872297)), 4, 72, -45, -98, 31, 69, 49, -66, 44};
        byte[] bArr45 = new byte[31];
        bArr45[0] = -98;
        bArr45[1] = 50;
        bArr45[2] = -86;
        bArr45[3] = -111;
        bArr45[4] = 118;
        bArr45[5] = 65;
        bArr45[6] = 25;
        bArr45[7] = 86;
        bArr45[8] = 34;
        bArr45[9] = -87;
        int i64 = ~P0.class.getName().length();
        int length58 = ((P0.class.getName().length() | 1275171908) - (i64 | (-306725009))) + I2.a(P0.class, (-306790545) | i64) + (P0.class.getName().length() & 1275171908);
        int length59 = P0.class.getName().length();
        int i65 = (4546690 | length59) - (length59 ^ 4546690);
        bArr45[1329984972 ^ (length58 + (~(((P0.class.getName().length() | (-54813059)) | i65) - (i65 | (P0.class.getName().length() & 54813058)))))] = 43;
        int i66 = ((~P0.class.getName().length()) | (-410614810)) & (-2147024548);
        int length60 = P0.class.getName().length() & 2162712;
        bArr45[11] = (-1461235360) ^ ((((~length60) & 685789184) + length60) + i66);
        bArr45[12] = 19;
        bArr45[13] = -74;
        bArr45[14] = 64;
        bArr45[15] = 102;
        bArr45[16] = 117;
        bArr45[17] = 22;
        bArr45[18] = -117;
        bArr45[19] = 1;
        int i67 = ~P0.class.getName().length();
        bArr45[20] = (((~(((P0.class.getName().length() | 399609527) | i67) - (i67 | (P0.class.getName().length() & (-399609528))))) & 43262025) + ((P0.class.getName().length() & 59805697) | 16815104)) ^ 60077103;
        bArr45[21] = 42;
        bArr45[22] = 54;
        bArr45[23] = 51;
        bArr45[24] = Byte.MIN_VALUE;
        bArr45[25] = -15;
        bArr45[26] = 72;
        bArr45[27] = 41;
        bArr45[28] = 117;
        bArr45[29] = -9;
        bArr45[30] = 99;
        w(bArr44, bArr45);
        String intern18 = new String(bArr44, charset).intern();
        byte[] bArr46 = {-80, -78, -10, 95, 25, 124, 126, ((((~P0.class.getName().length()) | (-825821912)) & 1433150470) + ((P0.class.getName().length() & 287834118) | (-2138013648))) ^ 704863220, -109, -106, 1, 71, 80, -93, 8, 20, 3, 92, -36, -23, -100, -57, 91, -105, 82, 0, 125, 10, -90, 19, -59, 81, -47, -73, -58, ((((~P0.class.getName().length()) | 920111095) & 805343394) + ((P0.class.getName().length() & 167908352) | 1247937536)) ^ 2053280967, -23, -54, -119};
        byte[] bArr47 = new byte[39];
        int i68 = ((~P0.class.getName().length()) | (-1242849607)) & 310381136;
        int length61 = (P0.class.getName().length() & 34607168) | 1611698208;
        bArr47[1922079344 ^ (((length61 | i68) - ((P0.class.getName().length() & (~i68)) & length61)) + ((i68 | P0.class.getName().length()) & length61))] = -70;
        bArr47[1] = 12;
        bArr47[2] = 125;
        bArr47[3] = 70;
        bArr47[4] = 95;
        bArr47[5] = ((((~P0.class.getName().length()) | 2026217244) & 1368859276) + ((P0.class.getName().length() & (-2062393184)) | (-1912061854))) ^ (-543202645);
        bArr47[6] = 4;
        bArr47[7] = 5;
        bArr47[8] = -52;
        bArr47[9] = 35;
        bArr47[10] = 94;
        bArr47[11] = 67;
        bArr47[((((~P0.class.getName().length()) | (-247176005)) & 1996581376) + ((P0.class.getName().length() & 109415168) | 10256768)) ^ 2006838156] = 34;
        bArr47[13] = 0;
        bArr47[14] = 102;
        int i69 = ~P0.class.getName().length();
        bArr47[15] = (-995144257) ^ (((((-926026396) | i69) + 323006984) - (i69 | (-607258772))) + ((P0.class.getName().length() & 452985385) | 672137249));
        bArr47[16] = 85;
        bArr47[17] = 98;
        bArr47[18] = -36;
        bArr47[19] = -63;
        bArr47[20] = -56;
        bArr47[21] = -76;
        bArr47[22] = 8;
        bArr47[23] = -35;
        bArr47[24] = -22;
        bArr47[((((~P0.class.getName().length()) | (-141460529)) & (-2089811560)) + ((P0.class.getName().length() & 6291473) | 143133701)) ^ (-1946677884)] = -114;
        bArr47[26] = 37;
        bArr47[27] = 92;
        bArr47[28] = -47;
        bArr47[29] = -122;
        bArr47[30] = -124;
        bArr47[31] = 54;
        bArr47[32] = -121;
        bArr47[33] = 36;
        bArr47[34] = 114;
        bArr47[35] = 74;
        bArr47[(((I2.a(P0.class, -1) | (-1802280719)) & (-1429617888)) + ((P0.class.getName().length() & 777552772) | 84942980)) ^ (-1344674944)] = -96;
        bArr47[37] = -123;
        bArr47[38] = -57;
        w(bArr46, bArr47);
        String intern19 = new String(bArr46, charset).intern();
        byte[] bArr48 = new byte[36];
        bArr48[0] = -82;
        bArr48[1] = -27;
        bArr48[2] = 19;
        bArr48[3] = -26;
        bArr48[4] = -78;
        bArr48[5] = -78;
        bArr48[6] = -90;
        bArr48[7] = 62;
        bArr48[8] = 25;
        bArr48[9] = -66;
        bArr48[10] = -109;
        bArr48[11] = -69;
        bArr48[12] = 42;
        bArr48[13] = 8;
        bArr48[14] = -4;
        bArr48[15] = 20;
        bArr48[16] = 47;
        int a5 = (I2.a(P0.class, -1) | (-11105290)) & (-2045489120);
        int length62 = P0.class.getName().length();
        bArr48[(-971124439) ^ ((((544776 & length62) ^ 1074364696) + (length62 & 524296)) + a5)] = 85;
        bArr48[18] = 38;
        bArr48[19] = -110;
        bArr48[20] = -4;
        bArr48[21] = 40;
        bArr48[22] = 111;
        bArr48[23] = 50;
        bArr48[24] = -123;
        bArr48[25] = -31;
        bArr48[26] = -50;
        bArr48[27] = 46;
        bArr48[28] = Byte.MAX_VALUE;
        bArr48[29] = -121;
        bArr48[30] = 89;
        bArr48[31] = 11;
        bArr48[32] = -69;
        bArr48[33] = -63;
        bArr48[34] = 5;
        bArr48[35] = -6;
        byte[] bArr49 = new byte[36];
        int i70 = ((~P0.class.getName().length()) | (-1417927068)) & 805579050;
        int length63 = P0.class.getName().length();
        int i71 = ~((((P0.class.getName().length() | 268437770) - (length63 | 268437770)) + I2.a(P0.class, length63) + (P0.class.getName().length() & 268437770)) | 142610448);
        int i72 = -i70;
        bArr49[V2.a(~i72, i71, (i71 + i72) + 1) ^ 948189498] = -72;
        bArr49[1] = -69;
        bArr49[2] = 97;
        bArr49[3] = -83;
        bArr49[((((~P0.class.getName().length()) | (-1064576281)) & 1103645578) + ((P0.class.getName().length() & (-1958739688)) | (-1977606092))) ^ (-873960518)] = -58;
        bArr49[5] = 11;
        bArr49[6] = -83;
        bArr49[7] = 41;
        bArr49[8] = 82;
        bArr49[9] = 11;
        bArr49[10] = -52;
        bArr49[11] = -17;
        bArr49[12] = 44;
        bArr49[13] = -85;
        bArr49[14] = 121;
        bArr49[15] = -106;
        bArr49[16] = 41;
        bArr49[17] = 107;
        bArr49[18] = -14;
        bArr49[19] = -24;
        bArr49[20] = -98;
        bArr49[21] = -106;
        bArr49[22] = 21;
        bArr49[23] = -122;
        bArr49[24] = -86;
        bArr49[25] = -44;
        bArr49[26] = -126;
        bArr49[27] = Byte.MIN_VALUE;
        bArr49[28] = 37;
        bArr49[29] = -14;
        bArr49[30] = -16;
        bArr49[31] = 98;
        bArr49[32] = -24;
        bArr49[33] = -68;
        bArr49[34] = 54;
        bArr49[35] = -51;
        w(bArr48, bArr49);
        f353f = m3.b.y(intern17, intern18, intern19, new String(bArr48, charset).intern());
        byte[] bArr50 = new byte[36];
        bArr50[0] = 122;
        bArr50[1] = 74;
        bArr50[2] = -91;
        bArr50[3] = -39;
        bArr50[4] = 98;
        bArr50[5] = -84;
        bArr50[6] = -102;
        bArr50[7] = -42;
        bArr50[8] = 116;
        bArr50[9] = 6;
        bArr50[10] = -115;
        bArr50[11] = 58;
        bArr50[12] = 32;
        bArr50[13] = -49;
        bArr50[14] = -114;
        bArr50[15] = 90;
        bArr50[16] = -45;
        bArr50[((((~P0.class.getName().length()) | (-1634185219)) & 576821152) + ((P0.class.getName().length() & 1684115456) | 1158152272)) ^ 1734973409] = 91;
        bArr50[18] = -95;
        bArr50[19] = -9;
        bArr50[20] = -70;
        bArr50[21] = -17;
        bArr50[22] = -72;
        bArr50[23] = -113;
        bArr50[24] = 59;
        bArr50[25] = 37;
        bArr50[26] = 64;
        bArr50[27] = -49;
        bArr50[28] = -26;
        bArr50[29] = 19;
        bArr50[30] = 17;
        bArr50[31] = 55;
        bArr50[32] = 59;
        bArr50[33] = 101;
        bArr50[34] = 1140700979 ^ ((((1866334726 | r3) - 1140834168) - (I2.a(P0.class, -1) | (-12696946))) + ((P0.class.getName().length() & (-1878898550)) | 133126));
        bArr50[35] = -98;
        byte[] bArr51 = new byte[36];
        bArr51[0] = 4;
        bArr51[1] = 84;
        bArr51[2] = -85;
        bArr51[3] = -60;
        bArr51[4] = -10;
        bArr51[5] = -12;
        bArr51[6] = -24;
        bArr51[7] = 17;
        bArr51[8] = -19;
        bArr51[9] = -110;
        int length64 = P0.class.getName().length();
        bArr51[((((-893411590) | (((~length64) - length64) + length64)) & 1099999242) + ((P0.class.getName().length() & 17327232) | (-1878244224))) ^ (-778244992)] = -23;
        bArr51[11] = 112;
        bArr51[12] = 50;
        bArr51[13] = -20;
        bArr51[14] = -25;
        bArr51[15] = 76;
        bArr51[16] = -91;
        bArr51[17] = 101;
        bArr51[18] = 121;
        bArr51[19] = -50;
        bArr51[20] = -36;
        bArr51[21] = -47;
        bArr51[22] = -26;
        bArr51[23] = -23;
        bArr51[24] = 104;
        bArr51[25] = -112;
        bArr51[26] = 0;
        bArr51[27] = -97;
        bArr51[28] = -114;
        bArr51[29] = -122;
        bArr51[30] = 56;
        bArr51[31] = -113;
        bArr51[32] = 104;
        bArr51[33] = 88;
        bArr51[34] = -34;
        bArr51[35] = -23;
        w(bArr50, bArr51);
        String intern20 = new String(bArr50, charset).intern();
        byte[] bArr52 = new byte[38];
        bArr52[0] = 122;
        bArr52[1] = -77;
        bArr52[2] = -24;
        bArr52[3] = -104;
        bArr52[4] = -20;
        bArr52[5] = ((((~P0.class.getName().length()) | 1800172479) & 713056560) + ((P0.class.getName().length() & 1084229696) | (-1067317056))) ^ (-354260499);
        bArr52[6] = -89;
        bArr52[7] = -116;
        bArr52[8] = -61;
        bArr52[9] = ((((~P0.class.getName().length()) | 1924892637) & 474252673) + ((P0.class.getName().length() & 205783556) | 1073758742)) ^ 1548011486;
        bArr52[10] = -81;
        bArr52[11] = -76;
        bArr52[12] = -120;
        bArr52[13] = 37;
        bArr52[14] = 82;
        bArr52[15] = 32;
        bArr52[16] = -23;
        bArr52[17] = 38;
        bArr52[18] = -6;
        bArr52[19] = -108;
        bArr52[20] = -76;
        bArr52[21] = 3;
        bArr52[22] = -44;
        bArr52[23] = 74;
        bArr52[24] = 14;
        bArr52[25] = 18;
        bArr52[26] = -18;
        bArr52[27] = 96;
        int a6 = (I2.a(P0.class, -1) | 1475384172) & 1904362901;
        int length65 = (P0.class.getName().length() & (-1476246383)) | (-1945894398);
        int i73 = -a6;
        int i74 = (length65 ^ i73) - ((i73 & (~length65)) * 2);
        bArr52[28] = (41531421 | i74) - (41531421 & i74);
        bArr52[29] = -69;
        bArr52[30] = -92;
        bArr52[31] = -122;
        bArr52[32] = 102;
        int length66 = P0.class.getName().length();
        int i75 = ((~length66) - length66) + length66;
        int length67 = ((P0.class.getName().length() | (-2095034048)) - (i75 | (-878421693))) + I2.a(P0.class, 1235503171 | i75) + (P0.class.getName().length() & (-2095034048)) + ((P0.class.getName().length() & (-2113662720)) | 268828708);
        bArr52[((1826205370 & length67) * 2) + ((-1826205371) - length67)] = -117;
        bArr52[((184600801 & (((-635551633) + (~P0.class.getName().length())) + (((-r3) - 1) | 635551633))) + ((P0.class.getName().length() & 18910593) | 3671808)) ^ 188272579] = -90;
        bArr52[35] = 106;
        bArr52[36] = -90;
        bArr52[37] = 41;
        byte[] bArr53 = new byte[38];
        bArr53[0] = 4;
        bArr53[1] = 13;
        bArr53[2] = 119;
        int i76 = ~P0.class.getName().length();
        int i77 = ((-1919336459) ^ i76) + (i76 & (-1919336459));
        int length68 = ((P0.class.getName().length() | 42468384) - (i77 | 42468384)) + I2.a(P0.class, i77) + (P0.class.getName().length() & 42468384);
        int i78 = ~(((P0.class.getName().length() | (-33558531)) - (-33558531)) | 1208225794);
        int i79 = -length68;
        bArr53[V2.a(~i79, i78, (i78 + i79) + 1) ^ 1250694177] = 3;
        bArr53[4] = 108;
        bArr53[5] = -92;
        bArr53[6] = -83;
        bArr53[7] = -69;
        bArr53[8] = ((((~P0.class.getName().length()) | (-540018693)) - (-1613760789)) + ((P0.class.getName().length() & 540026886) | 24610)) ^ (-1613785430);
        bArr53[9] = 92;
        bArr53[10] = -57;
        bArr53[11] = -14;
        bArr53[12] = -54;
        bArr53[13] = -122;
        bArr53[14] = 11;
        bArr53[15] = 98;
        bArr53[16] = 111;
        int i80 = ((~P0.class.getName().length()) | (-1842259181)) & 627316486;
        int length69 = P0.class.getName().length();
        bArr53[(i80 + ((-2012209136) | (((-1522269164) + length69) - (length69 | (-1522269164))))) ^ (-1384892665)] = 120;
        bArr53[18] = -66;
        bArr53[19] = -32;
        bArr53[20] = -42;
        bArr53[((((~P0.class.getName().length()) | 744904181) & 678445389) + ((P0.class.getName().length() & 269779466) | (-1861973470))) ^ (-1183528070)] = ((((~P0.class.getName().length()) | 1900475630) & 293659699) + ((P0.class.getName().length() & 616562841) | 608180364)) ^ (-901840065);
        bArr53[22] = 106;
        bArr53[23] = 40;
        bArr53[24] = 44;
        bArr53[25] = 125;
        bArr53[26] = -103;
        bArr53[27] = 69;
        bArr53[28] = -72;
        bArr53[29] = 25;
        bArr53[30] = -37;
        bArr53[31] = -14;
        bArr53[32] = 26;
        bArr53[33] = -14;
        bArr53[34] = -46;
        bArr53[35] = 71;
        bArr53[36] = -23;
        bArr53[37] = 126;
        w(bArr52, bArr53);
        String intern21 = new String(bArr52, charset).intern();
        byte[] bArr54 = new byte[35];
        bArr54[0] = -27;
        bArr54[1] = -8;
        bArr54[2] = 52;
        bArr54[3] = 95;
        bArr54[4] = 59;
        bArr54[5] = Byte.MIN_VALUE;
        bArr54[(-188637012) ^ (((((P0.class.getName().length() | 998244343) - 998244343) | 75530408) + (~(-(((~P0.class.getName().length()) | 835714539) & (-264167422))))) + 1)] = -44;
        bArr54[7] = -96;
        bArr54[8] = -22;
        bArr54[9] = 70;
        bArr54[10] = -38;
        bArr54[11] = 2;
        bArr54[12] = -45;
        bArr54[13] = 33;
        bArr54[14] = 53;
        bArr54[15] = -64;
        bArr54[16] = 14;
        bArr54[17] = -47;
        bArr54[18] = 74;
        bArr54[19] = -86;
        bArr54[20] = 125;
        bArr54[21] = 122;
        bArr54[22] = 125;
        bArr54[23] = 38;
        bArr54[24] = 29;
        int i81 = ~P0.class.getName().length();
        int length70 = P0.class.getName().length() & 1149241376;
        int i82 = (219291696 & (435567507 + i81 + (((-i81) - 1) | (-435567507)))) + (~(((P0.class.getName().length() | (-1652559361)) | length70) - (length70 | (P0.class.getName().length() & 1652559360))));
        bArr54[25] = (((~i82) & 1871851027) - (1871851027 & i82)) + i82;
        bArr54[26] = ((((~P0.class.getName().length()) | (-1920362675)) & 1294140453) + ((P0.class.getName().length() & 1075986594) | 545278162)) ^ 1839418549;
        bArr54[27] = 52;
        bArr54[28] = 120;
        bArr54[29] = 45;
        bArr54[30] = 30;
        bArr54[31] = -92;
        bArr54[32] = 25;
        bArr54[33] = 78;
        bArr54[34] = 76;
        byte[] bArr55 = new byte[35];
        bArr55[0] = 109;
        bArr55[1] = -58;
        bArr55[2] = 58;
        bArr55[3] = 70;
        bArr55[4] = 61;
        bArr55[5] = 25;
        bArr55[6] = -101;
        bArr55[7] = -89;
        bArr55[8] = -125;
        bArr55[9] = 83;
        bArr55[10] = -110;
        bArr55[11] = -120;
        bArr55[12] = -93;
        bArr55[13] = -126;
        bArr55[14] = 48;
        bArr55[15] = -62;
        int length71 = ((~P0.class.getName().length()) | (-33816641)) + 1112801505 + ((P0.class.getName().length() & 100925504) | 335577601);
        bArr55[B0.a((~length71) | 1448379121, 1448379121 - length71)] = 74;
        bArr55[17] = -17;
        bArr55[18] = 78;
        bArr55[19] = 7;
        int i83 = ~P0.class.getName().length();
        bArr55[20] = ((1197848 & (((((P0.class.getName().length() & (~i83)) & 679995385) + 679995385) + i83) - ((i83 | P0.class.getName().length()) & 679995385))) + ((P0.class.getName().length() & 5242881) | 943720577)) ^ 944918404;
        bArr55[21] = 89;
        bArr55[22] = 38;
        bArr55[23] = 125;
        bArr55[24] = 58;
        bArr55[((((~P0.class.getName().length()) | 1680797212) & 805860392) + ((P0.class.getName().length() & 306188324) | (-2109603580))) ^ (-1303743179)] = -106;
        int i84 = ~P0.class.getName().length();
        int length72 = ((((P0.class.getName().length() & (~i84)) & (-1161234654)) - 1161234654) + i84) - ((i84 | P0.class.getName().length()) & (-1161234654));
        int i85 = (233343680 + length72) - (length72 | 233343680);
        int length73 = (P0.class.getName().length() & 85985732) | (-1610465020);
        bArr55[(-1377121314) ^ ((length73 & i85) + (i85 | length73))] = 7;
        bArr55[27] = -104;
        bArr55[28] = (((I2.a(P0.class, -1) | (-127357063)) & (-1207947253)) + ((P0.class.getName().length() & 431110) | 6718468)) ^ (-1201228759);
        bArr55[29] = -92;
        bArr55[30] = 67;
        bArr55[31] = 10;
        bArr55[32] = 88;
        bArr55[33] = 28;
        bArr55[34] = 8;
        w(bArr54, bArr55);
        f354g = m3.b.y(intern20, intern21, new String(bArr54, charset).intern());
        byte[] bArr56 = new byte[35];
        bArr56[0] = -57;
        bArr56[1] = -45;
        int length74 = P0.class.getName().length();
        int i86 = ((-362275516) | (((~length74) - length74) + length74)) & 1493438517;
        int length75 = ((P0.class.getName().length() | 1325129678) - 1325129678) | (-1610604352);
        bArr56[2] = AbstractC0099x.a(i86 | length75, 2, (~i86) ^ length75) ^ 117165896;
        bArr56[3] = 84;
        bArr56[4] = 53;
        bArr56[5] = -52;
        bArr56[6] = -46;
        bArr56[7] = 99;
        bArr56[8] = ((((~P0.class.getName().length()) | (-844278030)) & 67127014) + ((P0.class.getName().length() & 1074266380) | (-1071898360))) ^ 1004771373;
        bArr56[9] = -111;
        bArr56[10] = -71;
        bArr56[11] = -27;
        bArr56[12] = -79;
        bArr56[13] = 88;
        bArr56[14] = -14;
        bArr56[15] = 96;
        bArr56[16] = 22;
        bArr56[17] = 116;
        bArr56[18] = 92;
        bArr56[19] = 26;
        bArr56[20] = -98;
        bArr56[21] = 76;
        bArr56[22] = -15;
        bArr56[23] = -51;
        int a7 = I2.a(P0.class, -1);
        bArr56[24] = ((152505634 & (((~a7) & (-875783246)) + a7)) + ((P0.class.getName().length() & 1246340) | 1612710092)) ^ (-1765215621);
        bArr56[25] = -96;
        bArr56[26] = -26;
        bArr56[27] = 42;
        bArr56[28] = 13;
        bArr56[29] = 20;
        bArr56[30] = 106;
        bArr56[31] = -29;
        bArr56[32] = -24;
        bArr56[33] = -78;
        bArr56[((((~P0.class.getName().length()) | (-105282147)) & (-393969456)) + ((P0.class.getName().length() & 262210) | 320425986)) ^ (-73543440)] = -46;
        byte[] bArr57 = new byte[35];
        bArr57[0] = -113;
        bArr57[1] = -19;
        bArr57[2] = -61;
        bArr57[3] = 63;
        bArr57[4] = 67;
        bArr57[5] = -43;
        bArr57[6] = -96;
        int length76 = P0.class.getName().length();
        bArr57[7] = ((((-1431006746) | (((~length76) - length76) + length76)) & 105017736) + ((P0.class.getName().length() & 340418568) | 403177476)) ^ 508195306;
        bArr57[8] = -100;
        bArr57[9] = 36;
        bArr57[10] = -74;
        bArr57[11] = -95;
        bArr57[12] = -63;
        bArr57[13] = 91;
        bArr57[14] = 107;
        bArr57[15] = 34;
        bArr57[16] = 98;
        bArr57[17] = 74;
        bArr57[18] = 92;
        bArr57[19] = 97;
        bArr57[20] = -60;
        bArr57[21] = 61;
        bArr57[22] = -97;
        bArr57[23] = -85;
        bArr57[24] = -82;
        bArr57[25] = 24;
        bArr57[26] = -108;
        int i87 = ((~P0.class.getName().length()) | (-219927577)) & (-438824566);
        int length77 = (P0.class.getName().length() & 521771016) | 436308993;
        bArr57[27] = (-2515466) ^ (((length77 | i87) - ((P0.class.getName().length() & (~i87)) & length77)) + ((i87 | P0.class.getName().length()) & length77));
        bArr57[28] = 49;
        bArr57[29] = 123;
        bArr57[30] = 35;
        bArr57[31] = -48;
        int a8 = I2.a(P0.class, -1);
        bArr57[(((a8 | 534501372) - ((513365980 | a8) ^ 356680800)) + ((P0.class.getName().length() & 1094885420) | 1073750028)) ^ 1430430796] = -87;
        int i88 = ~P0.class.getName().length();
        int length78 = P0.class.getName().length();
        bArr57[33] = ((581975108 & ((1184160196 ^ i88) + (i88 & 1184160196))) + (377386 | ((538994184 + length78) - (length78 | 538994184)))) ^ (-582352504);
        bArr57[34] = -105;
        w(bArr56, bArr57);
        String intern22 = new String(bArr56, charset).intern();
        byte[] bArr58 = {-62, ((((~P0.class.getName().length()) | (-100696101)) + 102803637) + ((P0.class.getName().length() & 101221412) | 134743360)) ^ ForkServer.INIT_PARSER_FACTORY_FACTORY_LOADER, -63, -12, 123, -110, -54, -28, 3, -82, -91, -68, -26, ((((~P0.class.getName().length()) | (-1613372268)) & 880838849) + ((P0.class.getName().length() & 538974289) | 1076367376)) ^ (-1957206206), -63, ((((~P0.class.getName().length()) | (-554733633)) - 1592552894) + ((P0.class.getName().length() & 588550468) | 35913988)) ^ (-1556638899), -83, -16, 80, 63, ((((~P0.class.getName().length()) | (-713198199)) & 1769984) + (((P0.class.getName().length() | (-131587)) - (-131587)) | 138)) ^ 1770162, ((((~P0.class.getName().length()) | (-197213136)) & (-2144179424)) + ((P0.class.getName().length() & 536947457) | 872484865)) ^ (-1271694515), -20, 100, -114, 110, -29, 6, -52, 10, -7};
        byte[] bArr59 = new byte[31];
        bArr59[0] = -116;
        bArr59[1] = -62;
        bArr59[2] = -113;
        bArr59[3] = -97;
        bArr59[4] = -3;
        bArr59[5] = 42;
        bArr59[6] = -103;
        bArr59[7] = -29;
        bArr59[8] = 92;
        bArr59[9] = -5;
        bArr59[10] = -63;
        bArr59[((((~P0.class.getName().length()) | (-536883201)) - 1574945593) + ((P0.class.getName().length() & 541667328) | 98124288)) ^ (-1476821299)] = -22;
        bArr59[12] = 120;
        bArr59[13] = 16;
        bArr59[14] = -99;
        bArr59[15] = 122;
        bArr59[16] = -85;
        bArr59[17] = ((((~P0.class.getName().length()) | (-672148542)) & 75825411) + ((P0.class.getName().length() & 16777225) | 50464840)) ^ (-126290299);
        bArr59[18] = 104;
        bArr59[19] = -122;
        bArr59[20] = 102;
        bArr59[21] = 95;
        bArr59[22] = -115;
        bArr59[23] = 79;
        int i89 = ~P0.class.getName().length();
        bArr59[24] = (((i89 | (-1477542939)) - (((-1477543327) | i89) ^ (-1570240123))) + ((P0.class.getName().length() & 8585604) | 1099371008)) ^ 470869046;
        bArr59[25] = 97;
        bArr59[26] = -116;
        bArr59[27] = 108;
        bArr59[28] = -120;
        bArr59[29] = 67;
        bArr59[30] = -74;
        w(bArr58, bArr59);
        String intern23 = new String(bArr58, charset).intern();
        byte[] bArr60 = new byte[32];
        bArr60[0] = -62;
        bArr60[1] = 109;
        bArr60[2] = -64;
        int i90 = ~P0.class.getName().length();
        bArr60[(((-1160748279) & (((((P0.class.getName().length() & (~i90)) & 186154642) + 186154642) + i90) - ((i90 | P0.class.getName().length()) & 186154642))) + ((P0.class.getName().length() & (-1329557223)) | 2396178)) ^ (-1158352104)] = -104;
        bArr60[4] = -59;
        bArr60[5] = 10;
        bArr60[6] = -112;
        bArr60[7] = -91;
        bArr60[8] = 40;
        bArr60[9] = -79;
        bArr60[10] = 10;
        bArr60[11] = -71;
        bArr60[12] = 91;
        bArr60[13] = 0;
        bArr60[14] = 126;
        bArr60[15] = ((((~P0.class.getName().length()) | (-1975736053)) & 191117824) + ((P0.class.getName().length() & 21500440) | (-2138570600))) ^ (-1947452689);
        bArr60[16] = -5;
        bArr60[17] = -75;
        bArr60[18] = 102;
        bArr60[19] = 24;
        bArr60[20] = 25;
        bArr60[21] = -50;
        bArr60[22] = -127;
        bArr60[((((~P0.class.getName().length()) | (-616174156)) & 4260014) + ((P0.class.getName().length() & 537001994) | 671224832)) ^ 675484857] = -98;
        bArr60[24] = 37;
        bArr60[25] = 88;
        bArr60[26] = -25;
        bArr60[27] = -122;
        bArr60[28] = 93;
        bArr60[29] = 72;
        bArr60[30] = 88;
        bArr60[31] = -84;
        int i91 = ((~P0.class.getName().length()) | 391820249) & 1141539144;
        int length79 = (P0.class.getName().length() & 1078001664) | (-2118055808);
        byte b5 = (((i91 & length79) * 2) + (length79 ^ i91)) ^ 976516716;
        int i92 = ((~P0.class.getName().length()) | (-1612064428)) & 311821828;
        int length80 = P0.class.getName().length() & 5645825;
        w(bArr60, new byte[]{-116, 51, -114, 3, -109, -109, -34, b5, 65, 4, 99, -19, 27, -93, -9, 54, 125, 11, 383133238 ^ ((((((P0.class.getName().length() & (~length80)) & 71311361) + 71311361) + length80) - ((length80 | P0.class.getName().length()) & 71311361)) + i92), 99, 69, -65, -81, -38, 79, 73, -107, -29, -21, 51, 1, 4});
        f355h = m3.b.y(intern22, intern23, new String(bArr60, charset).intern());
    }

    public P0(Context context, AppOpsManager appOpsManager, A0 a02) {
        byte[] bArr = {27, 118, -58, -93, 106, 121, 112};
        w(bArr, new byte[]{97, 73, -110, ((((~P0.class.getName().length()) | (-1631650817)) + 1642136707) + ((P0.class.getName().length() & (-247397376)) | (-1878917088))) ^ 236780370, 15, 1, 4, -122});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        byte[] bArr2 = {-61, 81, 36, 98, 86, -65, 32, 99, -34, 89, -19, 27, -80, 80, 112, -75, -76, 53, -123, 22, -1, 9, -23, -101, 73, Byte.MIN_VALUE, -107};
        byte[] bArr3 = new byte[27];
        bArr3[0] = -107;
        bArr3[1] = 111;
        long j2 = -1;
        long length = P0.class.getName().length();
        long j3 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j4 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j5 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j6 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j7 = (j6 | j5 | j4 | j3) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        int i = (((int) ((((j20 >>> 4) | j20) & 16711935) | ((((j17 >>> 4) | j17) & 16711935) << 8) | j14)) | (-1624406032)) & 12683904;
        long j21 = 29362208;
        long length2 = P0.class.getName().length();
        long j22 = ((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j23 = (j22 >>> 48) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = (j22 >>> 32) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = ((((j28 >>> 4) | j28) & 16711935) << 16) | ((((j25 >>> 4) | j25) & 16711935) << 24);
        long j30 = (j22 >>> 16) & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        long j33 = j22 & 43690;
        long j34 = ((j33 >>> 2) | (j33 >>> 1)) & 858993459;
        long j35 = ((j34 >>> 2) | j34) & 252645135;
        int i3 = (int) (((((j32 >>> 4) | j32) & 16711935) << 8) | j29 | (((j35 >>> 4) | j35) & 16711935));
        bArr3[30517922 ^ (((i3 ^ 17834016) + (i3 & 17834016)) + i)] = 79;
        bArr3[3] = 31;
        long j36 = 310300817;
        long j37 = ~P0.class.getName().length();
        long j38 = (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
        long j39 = (j38 >>> 48) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = (j38 >>> 32) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = ((((j44 >>> 4) | j44) & 16711935) << 16) | ((((j41 >>> 4) | j41) & 16711935) << 24);
        long j46 = (j38 >>> 16) & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = ((j47 >>> 2) | j47) & 252645135;
        long j49 = j38 & 43690;
        long j50 = ((j49 >>> 2) | (j49 >>> 1)) & 858993459;
        long j51 = (j50 | (j50 >>> 2)) & 252645135;
        int i4 = (int) (((j51 | (j51 >>> 4)) & 16711935) + ((((j48 >>> 4) | j48) & 16711935) << 8) + j45);
        bArr3[(-868649781) ^ ((((P0.class.getName().length() | (-1072139058)) - (i4 | (-1072139058))) + (AbstractC0008a.f(P0.class, i4) + (P0.class.getName().length() & (-1072139058)))) + ((P0.class.getName().length() & (-870308786)) | 203489281))] = 27;
        int i5 = ((~P0.class.getName().length()) | 1230421857) & (-2071669108);
        int length3 = P0.class.getName().length();
        int i6 = (length3 | (-1266466676)) - (length3 ^ (-1266466676));
        long j52 = 805502979;
        long j53 = i6;
        long b4 = c3.b((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j54 = (b4 >>> 48) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = (b4 >>> 32) & 43690;
        long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) | ((((j56 >>> 4) | j56) & 16711935) << 24);
        long j61 = (b4 >>> 16) & 43690;
        long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
        long j63 = ((j62 >>> 2) | j62) & 252645135;
        long j64 = b4 & 43690;
        long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
        long j66 = ((j65 >>> 2) | j65) & 252645135;
        bArr3[5] = (i5 + ((int) ((((j66 >>> 4) | j66) & 16711935) | (((((j63 >>> 4) | j63) & 16711935) << 8) | j60)))) ^ (-1266166106);
        int i7 = ~P0.class.getName().length();
        int length4 = ((P0.class.getName().length() | 264911) - (i7 | (-43668753))) + AbstractC0008a.f(P0.class, (-43671507) | i7) + (P0.class.getName().length() & 264911);
        long j67 = 42076866;
        long length5 = P0.class.getName().length();
        long j68 = ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j69 = (j68 >>> 48) & 43690;
        long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
        long j71 = ((j70 >>> 2) | j70) & 252645135;
        long j72 = (j68 >>> 32) & 43690;
        long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
        long j74 = ((j73 >>> 2) | j73) & 252645135;
        long j75 = ((((j74 >>> 4) | j74) & 16711935) << 16) + ((((j71 >>> 4) | j71) & 16711935) << 24);
        long j76 = (j68 >>> 16) & 43690;
        long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
        long j78 = ((j77 >>> 2) | j77) & 252645135;
        long j79 = j68 & 43690;
        long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
        long j81 = ((j80 >>> 2) | j80) & 252645135;
        bArr3[6] = 1116080895 ^ (length4 + (((int) ((((j81 >>> 4) | j81) & 16711935) + (((((j78 >>> 4) | j78) & 16711935) << 8) | j75))) | 1115815936));
        bArr3[7] = 27;
        bArr3[8] = -109;
        bArr3[9] = 92;
        int i8 = ((~P0.class.getName().length()) | (-1365926473)) & 403933202;
        long j82 = 268583300;
        long length6 = P0.class.getName().length();
        long j83 = ((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j84 = (j83 >>> 48) & 43690;
        long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
        long j86 = (j85 | (j85 >>> 2)) & 252645135;
        long j87 = (j83 >>> 32) & 43690;
        long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
        long j89 = (j88 | (j88 >>> 2)) & 252645135;
        long j90 = (((j86 | (j86 >>> 4)) & 16711935) << 24) | (((j89 | (j89 >>> 4)) & 16711935) << 16);
        long j91 = (j83 >>> 16) & 43690;
        long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
        long j93 = (j92 | (j92 >>> 2)) & 252645135;
        long j94 = j83 & 43690;
        long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
        long j96 = (j95 | (j95 >>> 2)) & 252645135;
        bArr3[10] = (i8 + (((int) (((j96 | (j96 >>> 4)) & 16711935) | ((((j93 | (j93 >>> 4)) & 16711935) << 8) + j90))) | 71324036)) ^ (-475257313);
        bArr3[11] = -105;
        bArr3[12] = -51;
        bArr3[13] = 101;
        int i9 = ((~P0.class.getName().length()) | (-877867996)) & 759511404;
        int length7 = P0.class.getName().length();
        bArr3[14] = (i9 + (310526992 | ((length7 + 918630728) - (length7 | 918630728)))) ^ (-1070038383);
        bArr3[15] = -39;
        bArr3[16] = -58;
        bArr3[17] = -117;
        bArr3[18] = -52;
        bArr3[19] = 120;
        bArr3[20] = 122;
        long length8 = P0.class.getName().length();
        long a2 = AbstractC0088u0.a(j4, j3, j5, j6, ((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)));
        long j97 = (a2 >>> 48) & 21845;
        long j98 = (j97 | (j97 >>> 1)) & 858993459;
        long j99 = (j98 | (j98 >>> 2)) & 252645135;
        long j100 = (a2 >>> 32) & 21845;
        long j101 = (j100 | (j100 >>> 1)) & 858993459;
        long j102 = (j101 | (j101 >>> 2)) & 252645135;
        long j103 = (((j102 | (j102 >>> 4)) & 16711935) << 16) + (((j99 | (j99 >>> 4)) & 16711935) << 24);
        long j104 = (a2 >>> 16) & 21845;
        long j105 = (j104 | (j104 >>> 1)) & 858993459;
        long j106 = (j105 | (j105 >>> 2)) & 252645135;
        long j107 = a2 & 21845;
        long j108 = (j107 | (j107 >>> 1)) & 858993459;
        long j109 = (j108 | (j108 >>> 2)) & 252645135;
        int i10 = (int) (((j109 | (j109 >>> 4)) & 16711935) + ((((j106 | (j106 >>> 4)) & 16711935) << 8) | j103));
        int length9 = ((P0.class.getName().length() | (-1054471784)) - (i10 | (-215564903))) + AbstractC0008a.f(P0.class, (-1289437935) | i10) + (P0.class.getName().length() & (-1054471784));
        int length10 = P0.class.getName().length();
        bArr3[21] = 747238471 ^ (length9 + (307233349 | (((P0.class.getName().length() | 1073873097) - (length10 | 1073873097)) + (AbstractC0008a.f(P0.class, length10) + (P0.class.getName().length() & 1073873097)))));
        bArr3[22] = 106;
        bArr3[23] = 24;
        long j110 = 140525696;
        long j111 = (~P0.class.getName().length()) | (-1166292407);
        long j112 = ((((((((j110 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j110 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j110 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j110 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j111 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j111 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j111 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j111 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16));
        long j113 = (j112 >>> 48) & 43690;
        long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
        long j115 = (j114 | (j114 >>> 2)) & 252645135;
        long j116 = (j112 >>> 32) & 43690;
        long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
        long j118 = (j117 | (j117 >>> 2)) & 252645135;
        long j119 = (((j115 | (j115 >>> 4)) & 16711935) << 24) | (((j118 | (j118 >>> 4)) & 16711935) << 16);
        long j120 = (j112 >>> 16) & 43690;
        long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
        long j122 = (j121 | (j121 >>> 2)) & 252645135;
        long j123 = j112 & 43690;
        long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
        long j125 = (j124 | (j124 >>> 2)) & 252645135;
        int length11 = (P0.class.getName().length() | (-164994)) + 164994;
        bArr3[140690589 ^ ((((((P0.class.getName().length() & (~length11)) & 164869) + 164869) + length11) - ((P0.class.getName().length() | length11) & 164869)) + ((int) (((j125 | (j125 >>> 4)) & 16711935) | ((((j122 | (j122 >>> 4)) & 16711935) << 8) + j119))))] = 44;
        bArr3[25] = -18;
        bArr3[26] = -31;
        w(bArr2, bArr3);
        new String(bArr2, charset).intern();
        this.f356a = context;
        this.f357b = appOpsManager;
        this.f358c = a02;
    }

    public static G0.j a(PackageInfo packageInfo, Set set) {
        HashSet hashSet = f355h;
        if (!set.containsAll(hashSet)) {
            return null;
        }
        long j2 = 1092756744;
        long f4 = AbstractC0008a.f(P0.class, -1) | (-690127122);
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        byte length = (((int) (((j16 | (j16 >>> 4)) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) + ((P0.class.getName().length() & 27394384) | 8393296)) ^ 1101150056;
        long j17 = 543310082;
        long j18 = (~P0.class.getName().length()) | 1279843285;
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        int i = (int) (((((j29 >>> 4) | j29) & 16711935) << 8) | j26 | (((j32 >>> 4) | j32) & 16711935));
        long j33 = 1612906498;
        long length2 = P0.class.getName().length();
        long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j35 = (j34 >>> 48) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = (j36 | (j36 >>> 2)) & 252645135;
        long j38 = (j34 >>> 32) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + (((j37 | (j37 >>> 4)) & 16711935) << 24);
        long j42 = (j34 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        byte b4 = (i + (((int) (((j47 | (j47 >>> 4)) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41))) | 1115750400)) ^ (-1659060598);
        long j48 = -1;
        long length3 = P0.class.getName().length();
        long j49 = (((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j50 = (((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j51 = (((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j52 = (((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j53 = j52 + j51 + (j50 | j49) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j54 = (j53 >>> 48) & 21845;
        long j55 = (j54 | (j54 >>> 1)) & 858993459;
        long j56 = (j55 | (j55 >>> 2)) & 252645135;
        long j57 = (j53 >>> 32) & 21845;
        long j58 = (j57 | (j57 >>> 1)) & 858993459;
        long j59 = (j58 | (j58 >>> 2)) & 252645135;
        long j60 = (((j56 | (j56 >>> 4)) & 16711935) << 24) | (((j59 | (j59 >>> 4)) & 16711935) << 16);
        long j61 = (j53 >>> 16) & 21845;
        long j62 = (j61 | (j61 >>> 1)) & 858993459;
        long j63 = (j62 | (j62 >>> 2)) & 252645135;
        long j64 = (((j63 | (j63 >>> 4)) & 16711935) << 8) + j60;
        long j65 = j53 & 21845;
        long j66 = (j65 | (j65 >>> 1)) & 858993459;
        long j67 = (j66 | (j66 >>> 2)) & 252645135;
        int i3 = (((int) (((j67 | (j67 >>> 4)) & 16711935) + j64)) | 1525823385) & 557941008;
        int length4 = P0.class.getName().length();
        int i4 = i3 + (276832320 | ((length4 | 822190080) - (length4 ^ 822190080)));
        byte[] bArr = {length, Byte.MAX_VALUE, Byte.MAX_VALUE, 72, b4, -104, -125, -73, 110, 106, -106, -16, 113, 47, (i4 - 834773351) - ((i4 & (-834773351)) * 2), 104, -27, -55, -45, -8, -101, 22, -89, 22, 56, 63, -97, 124, 121, 58, 102, 119, 41, -114, 93, 9, -15, 61, 13, -74, -19, 21};
        byte[] bArr2 = new byte[42];
        bArr2[0] = 55;
        bArr2[1] = 123;
        bArr2[2] = -116;
        int i5 = ~P0.class.getName().length();
        bArr2[3] = (((((~i5) & (-1120445477)) + i5) & 88244609) + ((P0.class.getName().length() & 4760576) | 42477060)) ^ 130721748;
        bArr2[4] = 73;
        bArr2[5] = -3;
        bArr2[6] = -15;
        bArr2[7] = -33;
        bArr2[8] = 62;
        bArr2[9] = 3;
        bArr2[10] = 22;
        bArr2[11] = 73;
        bArr2[12] = 23;
        bArr2[13] = -98;
        bArr2[14] = 45;
        bArr2[15] = 33;
        bArr2[16] = 117;
        bArr2[17] = 76;
        bArr2[18] = 99;
        bArr2[19] = -55;
        bArr2[20] = 68;
        bArr2[21] = 64;
        bArr2[22] = 80;
        bArr2[23] = 17;
        bArr2[24] = -122;
        bArr2[25] = 36;
        bArr2[26] = 62;
        int i6 = ~P0.class.getName().length();
        long j68 = 1313407001;
        long length5 = ((((P0.class.getName().length() & (~i6)) & (-1647334889)) - 1647334889) + i6) - ((i6 | P0.class.getName().length()) & (-1647334889));
        long j69 = ((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j70 = (j69 >>> 48) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = ((j71 >>> 2) | j71) & 252645135;
        long j73 = (j69 >>> 32) & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        long j76 = ((((j75 >>> 4) | j75) & 16711935) << 16) + ((((j72 >>> 4) | j72) & 16711935) << 24);
        long j77 = (j69 >>> 16) & 43690;
        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
        long j79 = ((j78 >>> 2) | j78) & 252645135;
        long j80 = j69 & 43690;
        long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
        long j82 = ((j81 >>> 2) | j81) & 252645135;
        bArr2[27] = (((int) ((((j82 >>> 4) | j82) & 16711935) + (((((j79 >>> 4) | j79) & 16711935) << 8) | j76))) + ((P0.class.getName().length() & 1108642056) | 806668544)) ^ ForkServer.INIT_LOADER_PARSER;
        int i7 = ~P0.class.getName().length();
        bArr2[28] = ((92418349 & (((~i7) & 611322673) + i7)) + ((P0.class.getName().length() & 25344012) | 402704384)) ^ (-495122720);
        bArr2[29] = -99;
        int length6 = (((~P0.class.getName().length()) | (-1163075619)) & 339820804) + ((P0.class.getName().length() & 105447424) | 35129344);
        bArr2[B0.a((~length6) | 374950170, 374950170 - length6)] = -6;
        bArr2[31] = 61;
        bArr2[32] = -107;
        int i8 = (-1879042040) & ((-1377790307) - ((~(~P0.class.getName().length())) | (-1377790306)));
        int length7 = P0.class.getName().length() & 268961808;
        long j83 = R.drawable.divider_horizontal_bright;
        long j84 = length7;
        long j85 = (((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j86 = (j85 >>> 48) & 43690;
        long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
        long j88 = (j87 | (j87 >>> 2)) & 252645135;
        long j89 = (j85 >>> 32) & 43690;
        long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
        long j91 = ((j90 >>> 2) | j90) & 252645135;
        long j92 = (((j88 | (j88 >>> 4)) & 16711935) << 24) | ((((j91 >>> 4) | j91) & 16711935) << 16);
        long j93 = (j85 >>> 16) & 43690;
        long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
        long j95 = ((j94 >>> 2) | j94) & 252645135;
        long j96 = j85 & 43690;
        long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
        long j98 = (j97 | (j97 >>> 2)) & 252645135;
        bArr2[33] = (i8 + ((int) (((j98 | (j98 >>> 4)) & 16711935) + (((((j95 >>> 4) | j95) & 16711935) << 8) + j92)))) ^ 1861740540;
        bArr2[34] = -15;
        bArr2[35] = -29;
        bArr2[36] = -22;
        bArr2[37] = -122;
        int i9 = ~P0.class.getName().length();
        int length8 = P0.class.getName().length();
        int i10 = (942183242 & ((i9 + 838594926) - (i9 & 838594926))) + (109259905 | ((length8 + 235020929) - (length8 | 235020929)));
        bArr2[(i10 + 1051443181) - ((i10 & 1051443181) * 2)] = 101;
        long length9 = P0.class.getName().length();
        long a2 = AbstractC0088u0.a(j50, j49, j51, j52, ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
        long j99 = (a2 >>> 48) & 21845;
        long j100 = (j99 | (j99 >>> 1)) & 858993459;
        long j101 = (j100 | (j100 >>> 2)) & 252645135;
        long j102 = (a2 >>> 32) & 21845;
        long j103 = (j102 | (j102 >>> 1)) & 858993459;
        long j104 = (j103 | (j103 >>> 2)) & 252645135;
        long j105 = (((j101 | (j101 >>> 4)) & 16711935) << 24) | (((j104 | (j104 >>> 4)) & 16711935) << 16);
        long j106 = (a2 >>> 16) & 21845;
        long j107 = (j106 | (j106 >>> 1)) & 858993459;
        long j108 = (j107 | (j107 >>> 2)) & 252645135;
        long j109 = a2 & 21845;
        long j110 = (j109 | (j109 >>> 1)) & 858993459;
        long j111 = (j110 | (j110 >>> 2)) & 252645135;
        int i11 = (int) (((j111 | (j111 >>> 4)) & 16711935) | j105 | (((j108 | (j108 >>> 4)) & 16711935) << 8));
        int length10 = ((i11 | (-1909232034)) - (((-1909232036) | i11) ^ (-2046801322))) + ((P0.class.getName().length() & 3212290) | 552702976);
        bArr2[39] = E1.a(length10 | (-1494098345), -1494098345, length10);
        bArr2[40] = 31;
        bArr2[41] = 92;
        f(bArr, bArr2);
        return new G0.j(packageInfo, m3.b.M(new String(bArr, StandardCharsets.UTF_8).intern()), hashSet);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0013. Please report as an issue. */
    public static Set e(String[] strArr, int[] iArr) {
        Iterator it = null;
        ArrayList arrayList = null;
        Object obj = null;
        boolean z3 = false;
        while (true) {
            char c4 = 29216;
            while (true) {
                switch (c4) {
                    case 52929:
                        if (it.hasNext()) {
                            c4 = 43310;
                        } else {
                            c4 = 9903;
                        }
                    case 10239:
                        obj = it.next();
                        int i = iArr[((Number) obj).intValue()];
                        if ((i | 2) - (i ^ 2) != 0) {
                            c4 = 13329;
                        } else {
                            c4 = 7039;
                        }
                    case 43310:
                        obj = it.next();
                        arrayList.add(strArr[((Number) obj).intValue()]);
                        c4 = 52929;
                    case 50277:
                        if (it.hasNext()) {
                            c4 = 10239;
                        } else {
                            c4 = 60268;
                        }
                    case 53557:
                        if (!z3) {
                            c4 = 50277;
                        } else {
                            c4 = 39117;
                        }
                    case 29216:
                        K2.d dVar = new K2.d(0, strArr.length - 1, 1);
                        arrayList = new ArrayList();
                        it = dVar.iterator();
                        c4 = 50277;
                    case 60268:
                        ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(arrayList, 10));
                        Iterator it2 = arrayList.iterator();
                        arrayList = arrayList2;
                        it = it2;
                        c4 = 52929;
                    case 39117:
                        arrayList.add(obj);
                        c4 = 50277;
                    case 7039:
                        z3 = false;
                        c4 = 53557;
                    case 9903:
                        break;
                    case 13329:
                        z3 = true;
                        c4 = 53557;
                }
                return AbstractC0707i.u0(arrayList);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void f(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~P0.class.getName().length();
        int length3 = (((~(((P0.class.getName().length() | 70245657) | i7) - (i7 | (P0.class.getName().length() & (-70245658))))) & (-1979440632)) + ((P0.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(P0.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((P0.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~P0.class.getName().length()) | (-576567005)) & 276971586) + ((P0.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~P0.class.getName().length()) | (-1157759625)) & 1755853004) + ((P0.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~P0.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = P0.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~P0.class.getName().length()) | (-1064961)) + 689325073) + ((P0.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~P0.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = P0.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~P0.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (P0.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((P0.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~P0.class.getName().length();
                    int length11 = (161497089 & (((((P0.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((P0.class.getName().length() | i14) & 797295576))) + ((P0.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~P0.class.getName().length()) | (-1085986263)) & 1078327440) + ((P0.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~P0.class.getName().length();
                    int length12 = length5 >>> ((((~(((P0.class.getName().length() | 626856794) | i15) - ((P0.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((P0.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~P0.class.getName().length()) | 1248713193) & 826417528) + ((P0.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~P0.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (P0.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~P0.class.getName().length()) | (-1005965450)) & 153223237) + ((P0.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((P0.class.getName().length() & (~length6)) & i9)) + ((P0.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~P0.class.getName().length()) | (-30261291)) & (-1534000062)) + ((P0.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~P0.class.getName().length()) | (-23496740)) & 827084804) + ((P0.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~P0.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (P0.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~P0.class.getName().length()) | (-961655275)) & 25184460) + ((P0.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~P0.class.getName().length()) | 1233459797) & 125923146) + ((P0.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~P0.class.getName().length()) | (-7107622)) & 402932290) + ((P0.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((P0.class.getName().length() | length15) - (b4 | length15)) + I2.a(P0.class, b4) + (P0.class.getName().length() & length15);
                    int length17 = ((((~P0.class.getName().length()) | (-81143879)) & 438583424) + ((P0.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~P0.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((P0.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(P0.class, 568748773 | i24) + (P0.class.getName().length() & (-2105278367)))) + ((P0.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~P0.class.getName().length()) | (-1592082969)) & 140665109) + ((P0.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~P0.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((P0.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~P0.class.getName().length()) | (-180811308));
                    int length19 = (P0.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((P0.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | P0.class.getName().length()))));
                    int i29 = ((~P0.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (P0.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~P0.class.getName().length()) | 75364313) & 1242301609) + ((P0.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = P0.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((P0.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~P0.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((P0.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~P0.class.getName().length();
                    int length24 = 1409942802 & (((((P0.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | P0.class.getName().length()) & 91135407));
                    int length25 = (P0.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~P0.class.getName().length()) | (-537919489)) - (-806798471)) + ((P0.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~P0.class.getName().length()) | (-382746167)) & 102532165) + ((P0.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~P0.class.getName().length()) | (-6036961)) & 1233145505) + ((P0.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~P0.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = P0.class.getName().length() & 268460041;
                    i5 = (((((P0.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | P0.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = P0.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((P0.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~P0.class.getName().length()) | (-1883938358)) & (-738125179)) + ((P0.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~P0.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (P0.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(P0.class, -1) | (-532481)) - (-67641369)) + ((P0.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~P0.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((P0.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(P0.class, -1) | (-33554434)) - (-1107366402)) + ((P0.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(P0.class, -1) | (-167014194)) & 1157999680) + ((P0.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = P0.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((P0.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(P0.class, -1) | 114408723) & 1183666176;
                    int length33 = P0.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~P0.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = P0.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~P0.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (P0.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~P0.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((P0.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~P0.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (P0.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~P0.class.getName().length()) | 991120067) & (-2113137661)) + ((P0.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(P0.class, -1) | 314136709) & 371231304) + (((P0.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~P0.class.getName().length()) | 366661365) & 1344150018) + ((P0.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~P0.class.getName().length()) | (-1359635359)) & 49026131) + ((P0.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~P0.class.getName().length();
                    if (length3 > 0) {
                        int length38 = P0.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (P0.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~P0.class.getName().length()) | 1110430873) & 1241612298) + ((P0.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~P0.class.getName().length()) | 1603962366) & 25199440) + (((P0.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~P0.class.getName().length()) | (-1388708984)) & 706816128) + ((P0.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~P0.class.getName().length()) | 367288948) & 548745488;
                    int length41 = P0.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~P0.class.getName().length()) | 2113158628) & 1026558002) + ((P0.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~P0.class.getName().length()) | 715175224) & 136512788) + ((P0.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~P0.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = P0.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~P0.class.getName().length()) | (-1084937228)) & 438503696) + ((P0.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~P0.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((P0.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(P0.class, 1197735420 | i53) + (P0.class.getName().length() & 674349280))) + ((P0.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~P0.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (P0.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~P0.class.getName().length()) | (-171976913)) & 318775824) + ((P0.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~P0.class.getName().length()) | (-616910267)) & 1303391760) + ((P0.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~P0.class.getName().length()) | 1297715640) & 556926729) + ((P0.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~P0.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((P0.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~P0.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (P0.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    public static boolean g(Context context, String str) {
        boolean z3;
        ?? r16;
        char c4;
        boolean z4;
        byte[] bArr;
        boolean z5 = false;
        char c5 = 24933;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        Object obj = null;
        Iterator it = null;
        List<ComponentName> list = null;
        DevicePolicyManager devicePolicyManager = null;
        DevicePolicyManager devicePolicyManager2 = null;
        List<ComponentName> list2 = null;
        while (true) {
            switch (c5) {
                case 54804:
                    c5 = 12706;
                    z5 = z5 ? 1 : 0;
                    devicePolicyManager2 = null;
                case 29192:
                    z3 = z5 ? 1 : 0;
                    devicePolicyManager2 = (DevicePolicyManager) obj;
                    c5 = 12706;
                    z5 = z3;
                case 30978:
                    r16 = z5 ? 1 : 0;
                    try {
                    } catch (Exception unused) {
                        z5 = r16;
                        c5 = 55542;
                    }
                    if (kotlin.jvm.internal.j.a(((ComponentName) it.next()).getPackageName(), str)) {
                        c4 = 7935;
                        z4 = r16;
                        c5 = c4;
                        z3 = z4;
                        z5 = z3;
                    }
                    c4 = 49809;
                    z4 = r16;
                    c5 = c4;
                    z3 = z4;
                    z5 = z3;
                case 7935:
                    z3 = z5 ? 1 : 0;
                    z8 = true;
                    c5 = 11842;
                    z5 = z3;
                case 5272:
                    z3 = z5 ? 1 : 0;
                    c5 = 30898;
                    z7 = z6;
                    z5 = z3;
                case 24933:
                    try {
                        bArr = new byte[13];
                        bArr[z5 ? 1 : 0] = 126;
                        bArr[1] = 105;
                        bArr[2] = 55;
                        r16 = z5 ? 1 : 0;
                    } catch (Exception unused2) {
                        r16 = z5 ? 1 : 0;
                    }
                    try {
                        bArr[3] = 3;
                        bArr[4] = 23;
                        bArr[5] = 124;
                        bArr[6] = -70;
                        bArr[7] = 17;
                        bArr[8] = 82;
                        bArr[9] = -117;
                        bArr[10] = -40;
                        bArr[11] = 74;
                        long j2 = -2097077357;
                        long j3 = (~P0.class.getName().length()) | (-417365218);
                        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        int length = ((int) ((((j17 >>> 4) | j17) & 16711935) + ((((j14 >>> 4) | j14) & 16711935) << 8) + j11)) + ((P0.class.getName().length() & 434369) | 1611059264);
                        bArr[E1.a(length | (-486018081), -486018081, length)] = 63;
                        byte[] bArr2 = new byte[13];
                        bArr2[r16] = 118;
                        bArr2[1] = 58;
                        bArr2[2] = -33;
                        bArr2[3] = -56;
                        bArr2[4] = 16;
                        bArr2[5] = 47;
                        int length2 = (((-1) - P0.class.getName().length()) | (-189429643)) & 822547362;
                        long j18 = 1078494208;
                        long length3 = P0.class.getName().length() & 1090687874;
                        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                        long j20 = (j19 >>> 48) & 43690;
                        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                        long j22 = ((j21 >>> 2) | j21) & 252645135;
                        long j23 = (j19 >>> 32) & 43690;
                        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
                        long j25 = ((j24 >>> 2) | j24) & 252645135;
                        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
                        long j27 = (j19 >>> 16) & 43690;
                        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                        long j29 = ((j28 >>> 2) | j28) & 252645135;
                        long j30 = j19 & 43690;
                        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                        long j32 = ((j31 >>> 2) | j31) & 252645135;
                        int i = length2 + ((int) ((((((j29 >>> 4) | j29) & 16711935) << 8) + j26) | (((j32 >>> 4) | j32) & 16711935)));
                        long j33 = 1901041572;
                        long j34 = i;
                        long j35 = ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                        long j46 = ((((j45 >>> 4) | j45) & 16711935) << 8) + j42;
                        long j47 = j35 & 21845;
                        long j48 = (j47 | (j47 >>> 1)) & 858993459;
                        long j49 = (j48 | (j48 >>> 2)) & 252645135;
                        bArr2[(int) (((j49 | (j49 >>> 4)) & 16711935) + j46)] = 107;
                        bArr2[7] = -61;
                        int i3 = ~P0.class.getName().length();
                        int length4 = ((P0.class.getName().length() | (-1065140023)) - (i3 | (-625783847))) + ((1521699801 | i3) - P0.class.getName().length()) + (P0.class.getName().length() & (-1065140023));
                        int length5 = P0.class.getName().length();
                        int length6 = 51653904 | (((P0.class.getName().length() | (-2130696176)) - (length5 | (-2130696176))) + (length5 - P0.class.getName().length()) + (P0.class.getName().length() & (-2130696176)));
                        bArr2[D.a(length4, 3, -(D1.a(length4, length6) | (length6 & 2)), 1) ^ (-1013486127)] = 65;
                        bArr2[9] = -47;
                        bArr2[10] = 3;
                        bArr2[11] = -113;
                        bArr2[12] = 70;
                        y(bArr, bArr2);
                    } catch (Exception unused3) {
                        z5 = r16;
                        c5 = 55542;
                    }
                    try {
                        obj = context.getSystemService(new String(bArr, StandardCharsets.UTF_8).intern());
                        if (obj instanceof DevicePolicyManager) {
                            c5 = 29192;
                            z3 = r16;
                        } else {
                            c5 = 54804;
                            z3 = r16;
                        }
                        z5 = z3;
                    } catch (Exception unused4) {
                        z5 = r16;
                        c5 = 55542;
                    }
                case 21042:
                    return z5;
                case 24130:
                    it = list.iterator();
                    r16 = z5 ? 1 : 0;
                    c4 = 49809;
                    z4 = r16;
                    c5 = c4;
                    z3 = z4;
                    z5 = z3;
                case 55542:
                    z7 = z5 ? 1 : 0;
                    c5 = 13684;
                case 61038:
                    list2 = devicePolicyManager.getActiveAdmins();
                    if (list2 != null) {
                        c5 = 28598;
                    } else {
                        c5 = 2000;
                    }
                case 7746:
                case 20090:
                    z8 = z5 ? 1 : 0;
                    c5 = 11842;
                case 2000:
                    z6 = z5 ? 1 : 0;
                    c5 = 5272;
                case 30898:
                    c5 = 13684;
                case 13684:
                    return z7;
                case 11842:
                    z6 = z8;
                    c5 = 5272;
                case 12706:
                    if (devicePolicyManager2 == null) {
                        c5 = 21042;
                    } else {
                        c5 = 61038;
                    }
                    devicePolicyManager = devicePolicyManager2;
                case 49809:
                    if (it.hasNext()) {
                        c5 = 30978;
                    } else {
                        c5 = 20090;
                    }
                case 28598:
                    if (list2 != null) {
                        c5 = 56886;
                        list = list2;
                    } else {
                        list = list2;
                        c5 = 24130;
                    }
                case 56886:
                    try {
                    } catch (Exception unused5) {
                        r16 = z5 ? 1 : 0;
                        z5 = r16;
                        c5 = 55542;
                    }
                    if (list.isEmpty()) {
                        c5 = 7746;
                    } else {
                        c5 = 24130;
                    }
                default:
                    c5 = 7746;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void p(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void u(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void w(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void y(byte[] bArr, byte[] bArr2) {
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

    public final G0.j b(String str, String str2) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = this.f356a.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 4096)) != null) {
                return new G0.j(packageInfo, m3.b.M(str2), null);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public final String c(G0.j jVar) {
        String str = jVar.f818a.packageName;
        byte[] bArr = {53, 0, 69, -73, 62, -89, -22, 88, 45, 105, 75};
        long j2 = 1761137990;
        long j3 = ~P0.class.getName().length();
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        int i = ((int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) & 1476493380;
        long j18 = 26215936;
        long length = P0.class.getName().length() & 269550080;
        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = (j21 | (j21 >>> 2)) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + (((j22 | (j22 >>> 4)) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 8) + j26;
        long j31 = j19 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        byte[] bArr2 = new byte[1502709327 ^ (i + ((int) (j30 | ((j33 | (j33 >>> 4)) & 16711935))))];
        bArr2[0] = 69;
        bArr2[1] = 97;
        bArr2[2] = 38;
        bArr2[3] = -36;
        bArr2[4] = 95;
        bArr2[5] = -64;
        int f4 = (AbstractC0008a.f(P0.class, -1) | (-836520161)) & 60621968;
        long j34 = 98312320;
        long length2 = P0.class.getName().length();
        long j35 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j36 = (j35 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = (j37 | (j37 >>> 2)) & 252645135;
        long j39 = (j35 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = (j40 | (j40 >>> 2)) & 252645135;
        long j42 = (((j41 | (j41 >>> 4)) & 16711935) << 16) + (((j38 | (j38 >>> 4)) & 16711935) << 24);
        long j43 = (j35 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = (j44 | (j44 >>> 2)) & 252645135;
        long j46 = j35 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = (j47 | (j47 >>> 2)) & 252645135;
        bArr2[6] = V2.a(((int) (((j48 | (j48 >>> 4)) & 16711935) + ((((j45 | (j45 >>> 4)) & 16711935) << 8) + j42))) | 1145053184, ~f4, ((~r6) - f4) - 1) ^ (-1205675233);
        int i3 = (-2006449888) & ((-1536266904) - ((~(~P0.class.getName().length())) | (-1536266903)));
        int length3 = P0.class.getName().length();
        bArr2[7] = (-1989514890) ^ ((((151128064 & length3) + 16934976) - (length3 & 16910336)) + i3);
        bArr2[8] = 76;
        bArr2[9] = 4;
        bArr2[10] = 46;
        u(bArr, bArr2);
        kotlin.jvm.internal.j.d(str, new String(bArr, StandardCharsets.UTF_8).intern());
        return d(str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    public final String d(String str) {
        String installerPackageName;
        InstallSourceInfo installSourceInfo;
        char c4 = 12873;
        P0 p02 = null;
        String str2 = null;
        String str3 = null;
        while (true) {
            char c5 = 57914;
            switch (c4) {
                case 3941:
                    installerPackageName = p02.f356a.getPackageManager().getInstallerPackageName(str);
                    str3 = installerPackageName;
                    c4 = 38805;
                case 38087:
                    break;
                case 41125:
                    installSourceInfo = this.f356a.getPackageManager().getInstallSourceInfo(str);
                    installerPackageName = installSourceInfo.getInitiatingPackageName();
                    str3 = installerPackageName;
                    c4 = 38805;
                case 57914:
                    str2 = null;
                    c4 = 38087;
                case 12873:
                    try {
                        c5 = 30;
                        if (Build.VERSION.SDK_INT < 30) {
                            c4 = 59917;
                        } else {
                            c4 = 41125;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        c4 = c5;
                    }
                case 59917:
                    c4 = 3941;
                    p02 = this;
                case 38805:
                    c4 = 2621;
                    str2 = str3;
                default:
                    c4 = 38087;
            }
            return str2;
        }
    }

    public final boolean h(PackageInfo packageInfo) {
        String str;
        String str2 = null;
        char c4 = 58028;
        char c5 = 58028;
        while (true) {
            if (c5 != c4) {
                if (c5 != 41085) {
                    if (c5 == 14835) {
                        return false;
                    }
                    str = str2;
                } else {
                    return f351d.contains(str2);
                }
            } else {
                String str3 = packageInfo.packageName;
                int length = (((~P0.class.getName().length()) | 1824204963) & (-1458945920)) + ((P0.class.getName().length() & (-2121252607)) | 76546305);
                byte[] bArr = {-18, E1.a(length | (-1382399575), -1382399575, length), -119, -27, -1, 116, -47, -92, -14, -14, -65};
                long j2 = 67767341;
                long j3 = (~P0.class.getName().length()) | (-961888816);
                long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                u(bArr, new byte[]{(((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) + ((P0.class.getName().length() & 2375725) | 556023808)) ^ (-623791181), 73, -22, -114, -98, 19, -76, -22, -109, -97, -38});
                kotlin.jvm.internal.j.d(str3, new String(bArr, StandardCharsets.UTF_8).intern());
                str = d(str3);
                if (str != null) {
                    str2 = str;
                    c4 = 58028;
                    c5 = 41085;
                }
            }
            str2 = str;
            c4 = 58028;
            c5 = 14835;
        }
    }

    public final G0.j i(PackageInfo packageInfo, Set set) {
        String str = packageInfo.packageName;
        byte[] bArr = {113, -122, 0, 74, 16, -67, 94, -62, 75, 69, 31};
        byte[] bArr2 = new byte[11];
        int i = ((~P0.class.getName().length()) | 2000520471) & (-1071836512);
        int length = (P0.class.getName().length() | 1543466335) - 1543466335;
        bArr2[S.a(length, ((-length) - 1) | (-604014609), 604014609, i) ^ (-467821904)] = 24;
        bArr2[1] = -73;
        bArr2[2] = 121;
        bArr2[3] = 8;
        bArr2[4] = -120;
        long j2 = 171531824;
        long a2 = I2.a(P0.class, -1);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j4 = (j3 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        long j17 = -1677440984;
        long j18 = (int) ((((j16 >>> 4) | j16) & 16711935) | ((((j13 >>> 4) | j13) & 16711935) << 8) | j10);
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 8) + j26;
        long j31 = j19 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        int length2 = P0.class.getName().length() & (-1274806005);
        bArr2[5] = 1107015297 ^ ((((~length2) & 570425603) + length2) + ((int) (((j33 | (j33 >>> 4)) & 16711935) | j30)));
        bArr2[6] = 81;
        bArr2[7] = 115;
        bArr2[8] = 42;
        bArr2[9] = 40;
        bArr2[10] = 122;
        k(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.d(str, new String(bArr, charset).intern());
        if (!l(str)) {
            return null;
        }
        String str2 = packageInfo.packageName;
        byte[] bArr3 = new byte[11];
        bArr3[0] = 11;
        bArr3[1] = -116;
        bArr3[2] = 29;
        bArr3[3] = -32;
        bArr3[4] = 53;
        int a4 = (I2.a(P0.class, -1) | (-1684128342)) & 7884549;
        int length3 = (P0.class.getName().length() & 14696965) | 42143752;
        bArr3[(((length3 | a4) * 2) - (length3 ^ a4)) ^ 50028296] = -71;
        bArr3[6] = ((((~P0.class.getName().length()) | 1751500433) & (-805252093)) + ((P0.class.getName().length() & (-1809837950)) | 69206200)) ^ (-736045890);
        bArr3[7] = -104;
        bArr3[8] = -9;
        bArr3[9] = 38;
        bArr3[10] = -91;
        byte[] bArr4 = new byte[11];
        bArr4[0] = -110;
        bArr4[1] = -67;
        bArr4[2] = -108;
        bArr4[3] = 114;
        bArr4[4] = 107;
        bArr4[5] = -82;
        bArr4[6] = 118;
        bArr4[7] = -67;
        int i3 = ((-352877843) - ((~(~P0.class.getName().length())) | (-352877842))) & 1151369222;
        int length4 = (P0.class.getName().length() & 637602176) | 570624384;
        int a5 = V2.a(length4, ~i3, ((~length4) - i3) - 1);
        long j34 = 1721993614;
        long j35 = a5;
        long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j37 = (j36 >>> 48) & 21845;
        long j38 = ((j37 >>> 1) | j37) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = (j36 >>> 32) & 21845;
        long j41 = ((j40 >>> 1) | j40) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) | ((((j39 >>> 4) | j39) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 21845;
        long j45 = ((j44 >>> 1) | j44) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = j36 & 21845;
        long j48 = ((j47 >>> 1) | j47) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        bArr4[(int) ((((j49 >>> 4) | j49) & 16711935) | ((((j46 >>> 4) | j46) & 16711935) << 8) | j43)] = -106;
        bArr4[9] = 75;
        bArr4[10] = -64;
        k(bArr3, bArr4);
        kotlin.jvm.internal.j.d(str2, new String(bArr3, charset).intern());
        if (!q(str2)) {
            return null;
        }
        byte[] bArr5 = new byte[27];
        bArr5[0] = 97;
        bArr5[1] = 70;
        bArr5[2] = 106;
        bArr5[3] = -41;
        bArr5[4] = -17;
        bArr5[5] = -14;
        bArr5[6] = 74;
        bArr5[7] = -64;
        bArr5[8] = 110;
        bArr5[9] = 86;
        bArr5[10] = -118;
        bArr5[11] = 34;
        bArr5[12] = -123;
        bArr5[13] = -102;
        bArr5[14] = -98;
        bArr5[15] = -66;
        bArr5[16] = 107;
        bArr5[17] = -33;
        bArr5[18] = 6;
        bArr5[19] = -4;
        bArr5[((((~P0.class.getName().length()) | (-341331787)) & (-1998892288)) + ((P0.class.getName().length() & 7882500) | 270803974)) ^ (-1728088302)] = -70;
        int length5 = P0.class.getName().length();
        bArr5[21] = (((969348846 | (((~length5) - length5) + length5)) & 59113571) + ((P0.class.getName().length() & 570966017) | 805853188)) ^ 864966742;
        bArr5[22] = -29;
        bArr5[23] = -84;
        bArr5[24] = 20;
        bArr5[25] = 9;
        bArr5[26] = 56;
        byte[] bArr6 = new byte[27];
        bArr6[0] = 23;
        bArr6[1] = -8;
        bArr6[2] = 35;
        bArr6[3] = -116;
        bArr6[4] = -105;
        bArr6[5] = 107;
        bArr6[6] = 68;
        bArr6[7] = -43;
        bArr6[8] = 53;
        bArr6[9] = 3;
        bArr6[10] = 14;
        bArr6[11] = 55;
        bArr6[12] = 3;
        bArr6[13] = -70;
        bArr6[14] = 3;
        bArr6[15] = -65;
        long j50 = 77760528;
        long j51 = (~P0.class.getName().length()) | (-735143848);
        long j52 = (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j53 = (j52 >>> 48) & 43690;
        long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        long j56 = (j52 >>> 32) & 43690;
        long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
        long j58 = ((j57 >>> 2) | j57) & 252645135;
        long j59 = ((((j58 >>> 4) | j58) & 16711935) << 16) + ((((j55 >>> 4) | j55) & 16711935) << 24);
        long j60 = (j52 >>> 16) & 43690;
        long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
        long j62 = ((j61 >>> 2) | j61) & 252645135;
        long j63 = j52 & 43690;
        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
        long j65 = ((j64 >>> 2) | j64) & 252645135;
        bArr6[16] = (-2069455798) ^ ((((-2147216318) + (P0.class.getName().length() & 8392705)) + (((-r9) - 1) | 2147216318)) + ((int) ((((j65 >>> 4) | j65) & 16711935) + (((((j62 >>> 4) | j62) & 16711935) << 8) | j59))));
        bArr6[17] = -127;
        int length6 = P0.class.getName().length();
        int i4 = ((~length6) - length6) + length6;
        bArr6[(((((((P0.class.getName().length() & (~i4)) & (-1121054126)) - 1121054126) + i4) - ((i4 | P0.class.getName().length()) & (-1121054126))) & 1126193702) + ((P0.class.getName().length() & 1115834405) | 9044353)) ^ 1135238069] = 62;
        bArr6[19] = -107;
        bArr6[20] = 22;
        bArr6[21] = 65;
        bArr6[22] = -67;
        bArr6[23] = -38;
        bArr6[24] = 71;
        bArr6[25] = 68;
        bArr6[26] = 107;
        k(bArr5, bArr6);
        if (!set.contains(new String(bArr5, charset).intern())) {
            return null;
        }
        int i5 = ((~P0.class.getName().length()) | (-811923147)) & (-863894236);
        long j66 = 39846976;
        long length7 = P0.class.getName().length();
        long j67 = ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j68 = (j67 >>> 48) & 43690;
        long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
        long j70 = ((j69 >>> 2) | j69) & 252645135;
        long j71 = (j67 >>> 32) & 43690;
        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
        long j73 = ((j72 >>> 2) | j72) & 252645135;
        long j74 = ((((j73 >>> 4) | j73) & 16711935) << 16) | ((((j70 >>> 4) | j70) & 16711935) << 24);
        long j75 = (j67 >>> 16) & 43690;
        long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
        long j77 = ((j76 >>> 2) | j76) & 252645135;
        long j78 = j67 & 43690;
        long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
        long j80 = (j79 | (j79 >>> 2)) & 252645135;
        byte b4 = (i5 + (((int) (((j80 | (j80 >>> 4)) & 16711935) | (((((j77 >>> 4) | j77) & 16711935) << 8) + j74))) | 326115393)) ^ (-537778838);
        byte length8 = ((((~P0.class.getName().length()) | 1913189916) & 104370848) + ((P0.class.getName().length() & (-1942880096)) | (-939393000))) ^ 835022179;
        int i6 = ((~P0.class.getName().length()) | (-896222177)) & 1241549314;
        long j81 = -2145385980;
        long length9 = P0.class.getName().length();
        long j82 = ((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j83 = (j82 >>> 48) & 43690;
        long j84 = ((j83 >>> 2) | (j83 >>> 1)) & 858993459;
        long j85 = ((j84 >>> 2) | j84) & 252645135;
        long j86 = (j82 >>> 32) & 43690;
        long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
        long j88 = ((j87 >>> 2) | j87) & 252645135;
        long j89 = ((((j88 >>> 4) | j88) & 16711935) << 16) | ((((j85 >>> 4) | j85) & 16711935) << 24);
        long j90 = (j82 >>> 16) & 43690;
        long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
        long j92 = ((j91 >>> 2) | j91) & 252645135;
        long j93 = j82 & 43690;
        long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
        long j95 = ((j94 >>> 2) | j94) & 252645135;
        byte[] bArr7 = {-107, 88, 4, 87, -122, -87, 90, b4, 124, -118, 126, -26, length8, -114, 88, -69, -40, 52, -67, -70, -80, 35, 64, 76, 29, -29, 84, 114, -32, -10, 902771843 ^ (i6 + (((int) ((((j95 >>> 4) | j95) & 16711935) + (((((j92 >>> 4) | j92) & 16711935) << 8) | j89))) | (-2144321260))), 49, 109};
        byte[] bArr8 = new byte[33];
        bArr8[0] = 15;
        bArr8[1] = 10;
        bArr8[2] = 126;
        bArr8[3] = 7;
        bArr8[4] = -2;
        bArr8[5] = -85;
        int i7 = ~P0.class.getName().length();
        long j96 = -922580608;
        long j97 = (i7 + (((-i7) - 1) | 856444737)) - 856444737;
        long j98 = (((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j97 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j97 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j97 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j97 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j99 = (j98 >>> 48) & 43690;
        long j100 = ((j99 >>> 2) | (j99 >>> 1)) & 858993459;
        long j101 = ((j100 >>> 2) | j100) & 252645135;
        long j102 = (j98 >>> 32) & 43690;
        long j103 = ((j102 >>> 2) | (j102 >>> 1)) & 858993459;
        long j104 = ((j103 >>> 2) | j103) & 252645135;
        long j105 = ((((j104 >>> 4) | j104) & 16711935) << 16) + ((((j101 >>> 4) | j101) & 16711935) << 24);
        long j106 = (j98 >>> 16) & 43690;
        long j107 = ((j106 >>> 2) | (j106 >>> 1)) & 858993459;
        long j108 = ((j107 >>> 2) | j107) & 252645135;
        long j109 = j98 & 43690;
        long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
        long j111 = ((j110 >>> 2) | j110) & 252645135;
        int i8 = (int) ((((j111 >>> 4) | j111) & 16711935) + (((((j108 >>> 4) | j108) & 16711935) << 8) | j105));
        int a6 = S.a(P0.class.getName().length() & 16779591, ((-r10) - 1) | (-1048680), 1048680, i8);
        long j112 = -921531982;
        long j113 = a6;
        long j114 = (((((((((j112 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j112 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j112 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j112 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j115 = (j114 >>> 48) & 21845;
        long j116 = ((j115 >>> 1) | j115) & 858993459;
        long j117 = ((j116 >>> 2) | j116) & 252645135;
        long j118 = (j114 >>> 32) & 21845;
        long j119 = ((j118 >>> 1) | j118) & 858993459;
        long j120 = ((j119 >>> 2) | j119) & 252645135;
        long j121 = ((((j120 >>> 4) | j120) & 16711935) << 16) | ((((j117 >>> 4) | j117) & 16711935) << 24);
        long j122 = (j114 >>> 16) & 21845;
        long j123 = ((j122 >>> 1) | j122) & 858993459;
        long j124 = ((j123 >>> 2) | j123) & 252645135;
        long j125 = j114 & 21845;
        long j126 = (j125 | (j125 >>> 1)) & 858993459;
        long j127 = (j126 | (j126 >>> 2)) & 252645135;
        bArr8[6] = (int) (((j127 | (j127 >>> 4)) & 16711935) + ((((j124 >>> 4) | j124) & 16711935) << 8) + j121);
        bArr8[7] = 48;
        bArr8[8] = 52;
        bArr8[9] = -73;
        bArr8[10] = 45;
        long j128 = 1149337808;
        long j129 = (~P0.class.getName().length()) | 1340985312;
        long j130 = ((((((((j128 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j128 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j128 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j128 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j129 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j129 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j129 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j129 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j131 = (j130 >>> 48) & 43690;
        long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
        long j133 = ((j132 >>> 2) | j132) & 252645135;
        long j134 = (j130 >>> 32) & 43690;
        long j135 = ((j134 >>> 2) | (j134 >>> 1)) & 858993459;
        long j136 = ((j135 >>> 2) | j135) & 252645135;
        long j137 = ((((j136 >>> 4) | j136) & 16711935) << 16) | ((((j133 >>> 4) | j133) & 16711935) << 24);
        long j138 = (j130 >>> 16) & 43690;
        long j139 = ((j138 >>> 2) | (j138 >>> 1)) & 858993459;
        long j140 = ((j139 >>> 2) | j139) & 252645135;
        long j141 = j130 & 43690;
        long j142 = ((j141 >>> 2) | (j141 >>> 1)) & 858993459;
        long j143 = (j142 | (j142 >>> 2)) & 252645135;
        bArr8[11] = (-324556639) ^ ((((P0.class.getName().length() & 539107344) | (-1473894400)) - (~((int) (((j143 | (j143 >>> 4)) & 16711935) + (((((j140 >>> 4) | j140) & 16711935) << 8) + j137))))) - 1);
        bArr8[12] = -71;
        bArr8[13] = -111;
        bArr8[14] = 68;
        bArr8[15] = -59;
        bArr8[16] = -63;
        long j144 = -1;
        long length10 = P0.class.getName().length();
        long j145 = ((((((((j144 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j144 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j144 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j144 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((length10 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length10 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length10 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length10 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        int i9 = (((int) ((((j158 >>> 4) | j158) & 16711935) + (((((j155 >>> 4) | j155) & 16711935) << 8) | j152))) | (-1395674058)) & (-1335160063);
        long j159 = 371484417;
        long length11 = P0.class.getName().length();
        long j160 = (((((((((j159 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j159 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j159 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j159 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j161 = (j160 >>> 48) & 43690;
        long j162 = ((j161 >>> 2) | (j161 >>> 1)) & 858993459;
        long j163 = ((j162 >>> 2) | j162) & 252645135;
        long j164 = (j160 >>> 32) & 43690;
        long j165 = ((j164 >>> 2) | (j164 >>> 1)) & 858993459;
        long j166 = ((j165 >>> 2) | j165) & 252645135;
        long j167 = ((((j166 >>> 4) | j166) & 16711935) << 16) | ((((j163 >>> 4) | j163) & 16711935) << 24);
        long j168 = (j160 >>> 16) & 43690;
        long j169 = ((j168 >>> 2) | (j168 >>> 1)) & 858993459;
        long j170 = ((j169 >>> 2) | j169) & 252645135;
        long j171 = j160 & 43690;
        long j172 = ((j171 >>> 2) | (j171 >>> 1)) & 858993459;
        long j173 = ((j172 >>> 2) | j172) & 252645135;
        int i10 = (int) (((((j170 >>> 4) | j170) & 16711935) << 8) | j167 | (((j173 >>> 4) | j173) & 16711935));
        bArr8[17] = (-1234208991) ^ (((100951048 ^ i10) + (i10 & 100951048)) + i9);
        bArr8[18] = ((((~P0.class.getName().length()) | 925322779) & (-2046818302)) + ((P0.class.getName().length() & (-1476395008)) | 679739392)) ^ 1367078896;
        bArr8[19] = -86;
        bArr8[20] = 9;
        bArr8[21] = 19;
        bArr8[22] = 68;
        int i11 = ((~P0.class.getName().length()) | 1050476103) & (-535813632);
        int length12 = P0.class.getName().length();
        bArr8[(-497868266) ^ (i11 + (37945345 | (((-1040121856) + length12) - (length12 | (-1040121856)))))] = 14;
        bArr8[24] = -117;
        bArr8[25] = 93;
        bArr8[26] = 73;
        bArr8[27] = 13;
        bArr8[28] = -87;
        bArr8[29] = 105;
        bArr8[30] = 21;
        bArr8[31] = 56;
        bArr8[32] = 3;
        k(bArr7, bArr8);
        return new G0.j(packageInfo, m3.b.M(new String(bArr7, charset).intern()), f352e);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0054. Please report as an issue. */
    public final List j() {
        char c4;
        String str;
        char c5;
        char c6 = 47279;
        Parcelable parcelable = null;
        Iterator it = null;
        String str2 = null;
        AccessibilityManager accessibilityManager = null;
        ArrayList arrayList = null;
        String str3 = null;
        AccessibilityManager accessibilityManager2 = null;
        Object obj = null;
        while (true) {
            switch (c6) {
                case 25981:
                    c4 = 22751;
                    obj = obj;
                    c6 = c4;
                case 57132:
                    c4 = 25981;
                    obj = obj;
                    c6 = c4;
                case 34936:
                    str = str3;
                    parcelable = ((ResolveInfo) parcelable).serviceInfo;
                    if (parcelable != null) {
                        c5 = 29413;
                        c6 = c5;
                        str3 = str;
                    }
                    c5 = 7327;
                    c6 = c5;
                    str3 = str;
                case 27933:
                    str = str3;
                    parcelable = ((AccessibilityServiceInfo) it.next()).getResolveInfo();
                    if (parcelable != null) {
                        c5 = 34936;
                        c6 = c5;
                        str3 = str;
                    }
                    c5 = 7327;
                    c6 = c5;
                    str3 = str;
                case 7327:
                    c6 = 16030;
                    str2 = null;
                case 16030:
                    c6 = str2 != null ? (char) 51573 : (char) 57132;
                    str3 = str2;
                case 65228:
                    str = str3;
                    c6 = accessibilityManager == null ? (char) 49180 : (char) 8477;
                    accessibilityManager2 = accessibilityManager;
                    str3 = str;
                case 29413:
                    str2 = ((ServiceInfo) parcelable).packageName;
                    c4 = 16030;
                    obj = obj;
                    c6 = c4;
                case 51573:
                    arrayList.add(str3);
                    c4 = 25981;
                    obj = obj;
                    c6 = c4;
                case 49180:
                    return C0716r.f6476a;
                case 16152:
                    c6 = 65228;
                    accessibilityManager = null;
                case 8477:
                    List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager2.getEnabledAccessibilityServiceList(-1);
                    byte[] bArr = new byte[39];
                    bArr[0] = 26;
                    int i = ~P0.class.getName().length();
                    bArr[((558473105 & ((i + 503877104) - (i & 503877104))) + ((P0.class.getName().length() & 2034438657) | 1476526154)) ^ 2034999258] = -112;
                    bArr[2] = 23;
                    bArr[3] = -53;
                    long j2 = -103313284;
                    str = str3;
                    long j3 = ~P0.class.getName().length();
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
                    int length = (((int) ((((j17 >>> 4) | j17) & 16711935) + ((((j14 >>> 4) | j14) & 16711935) << 8) + j11)) & (-1807482464)) + ((P0.class.getName().length() & 101187970) | 185204738);
                    bArr[(((~length) & (-1622277722)) - ((-1622277722) & length)) + length] = -52;
                    bArr[((((~P0.class.getName().length()) | 1895328973) & 1393049653) + ((P0.class.getName().length() & 52433072) | 2365632)) ^ 1395415280] = -69;
                    bArr[((((~P0.class.getName().length()) | (-2068905047)) & (-1470742259)) + ((P0.class.getName().length() & 1760583700) | 1084302352)) ^ (-386439909)] = 46;
                    bArr[7] = 39;
                    bArr[8] = -19;
                    bArr[9] = -31;
                    bArr[10] = 118;
                    int i3 = ~P0.class.getName().length();
                    int i4 = (i3 ^ (-575419908)) + (i3 & (-575419908));
                    long j18 = -1040182966;
                    long j19 = i4;
                    long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                    bArr[11] = (((int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) + ((P0.class.getName().length() & 33558530) | 4342785)) ^ 1035840161;
                    bArr[12] = -104;
                    bArr[13] = -96;
                    bArr[14] = 113;
                    bArr[15] = 38;
                    bArr[16] = 100;
                    bArr[17] = -40;
                    bArr[18] = 1;
                    bArr[19] = -94;
                    bArr[20] = -107;
                    bArr[21] = -59;
                    bArr[22] = 103;
                    bArr[23] = 71;
                    int i5 = ((~P0.class.getName().length()) | 1390863940) & (-998027692);
                    long j34 = -1946081262;
                    long length2 = P0.class.getName().length();
                    long j35 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j36 = (j35 >>> 48) & 43690;
                    long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                    long j38 = ((j37 >>> 2) | j37) & 252645135;
                    long j39 = (j35 >>> 32) & 43690;
                    long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) | ((((j38 >>> 4) | j38) & 16711935) << 24);
                    long j43 = (j35 >>> 16) & 43690;
                    long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                    long j45 = ((j44 >>> 2) | j44) & 252645135;
                    long j46 = j35 & 43690;
                    long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    int i6 = i5 + (((int) ((((j48 >>> 4) | j48) & 16711935) + (((((j45 >>> 4) | j45) & 16711935) << 8) | j42))) | 172531842);
                    bArr[24] = (825495855 | i6) - (825495855 & i6);
                    bArr[25] = -20;
                    bArr[26] = -17;
                    bArr[27] = 104;
                    bArr[28] = 93;
                    bArr[29] = Byte.MAX_VALUE;
                    bArr[30] = 47;
                    bArr[31] = 23;
                    bArr[32] = -119;
                    bArr[33] = -71;
                    bArr[34] = -53;
                    bArr[35] = -72;
                    bArr[36] = -71;
                    bArr[37] = 110;
                    bArr[38] = -93;
                    byte[] bArr2 = new byte[39];
                    bArr2[0] = 102;
                    bArr2[1] = 37;
                    bArr2[2] = 78;
                    bArr2[3] = -89;
                    bArr2[4] = -117;
                    bArr2[5] = 10;
                    bArr2[6] = 55;
                    bArr2[7] = 100;
                    bArr2[8] = 113;
                    bArr2[9] = -75;
                    bArr2[10] = 33;
                    bArr2[11] = -94;
                    bArr2[12] = -28;
                    bArr2[13] = -11;
                    bArr2[14] = -20;
                    bArr2[15] = 109;
                    bArr2[16] = -10;
                    bArr2[17] = -23;
                    bArr2[18] = 82;
                    bArr2[19] = -25;
                    bArr2[20] = -27;
                    bArr2[21] = -31;
                    bArr2[22] = 8;
                    bArr2[23] = 45;
                    bArr2[24] = -123;
                    bArr2[25] = -50;
                    bArr2[26] = -125;
                    bArr2[27] = 26;
                    bArr2[28] = 39;
                    bArr2[29] = 74;
                    bArr2[30] = 77;
                    bArr2[((((~P0.class.getName().length()) | 368928399) & 362291786) + ((P0.class.getName().length() & (-2011152284)) | (-903397340))) ^ (-541105551)] = -105;
                    bArr2[32] = -29;
                    bArr2[33] = -3;
                    bArr2[34] = -51;
                    bArr2[35] = -81;
                    bArr2[36] = -105;
                    bArr2[37] = 64;
                    bArr2[38] = -118;
                    w(bArr, bArr2);
                    kotlin.jvm.internal.j.d(enabledAccessibilityServiceList, new String(bArr, StandardCharsets.UTF_8).intern());
                    arrayList = new ArrayList();
                    it = enabledAccessibilityServiceList.iterator();
                    c5 = 22751;
                    c6 = c5;
                    str3 = str;
                case 47279:
                    int i7 = ~P0.class.getName().length();
                    long j49 = -666621728;
                    long length3 = ((((P0.class.getName().length() & (~i7)) & 243242897) + 243242897) + i7) - ((P0.class.getName().length() | i7) & 243242897);
                    long j50 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j51 = (j50 >>> 48) & 43690;
                    long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                    long j54 = (j50 >>> 32) & 43690;
                    long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) | ((((j53 >>> 4) | j53) & 16711935) << 24);
                    long j58 = (j50 >>> 16) & 43690;
                    long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                    long j60 = ((j59 >>> 2) | j59) & 252645135;
                    long j61 = j50 & 43690;
                    long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
                    long j63 = (j62 | (j62 >>> 2)) & 252645135;
                    byte length4 = (((int) (((j63 | (j63 >>> 4)) & 16711935) + (((((j60 >>> 4) | j60) & 16711935) << 8) + j57))) + ((P0.class.getName().length() & (-762827680)) | 42533888)) ^ (-624087914);
                    int length5 = 475530276 + (P0.class.getName().length() & 1142423552) + (((-r10) - 1) | (-475530276)) + (((~P0.class.getName().length()) | (-1073741825)) - 1031448447);
                    long j64 = -555918159;
                    long j65 = length5;
                    long j66 = ((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j67 = (j66 >>> 48) & 21845;
                    long j68 = ((j67 >>> 1) | j67) & 858993459;
                    long j69 = ((j68 >>> 2) | j68) & 252645135;
                    long j70 = (j66 >>> 32) & 21845;
                    long j71 = ((j70 >>> 1) | j70) & 858993459;
                    long j72 = ((j71 >>> 2) | j71) & 252645135;
                    long j73 = ((((j72 >>> 4) | j72) & 16711935) << 16) | ((((j69 >>> 4) | j69) & 16711935) << 24);
                    long j74 = (j66 >>> 16) & 21845;
                    long j75 = ((j74 >>> 1) | j74) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    long j77 = j66 & 21845;
                    long j78 = (j77 | (j77 >>> 1)) & 858993459;
                    long j79 = (j78 | (j78 >>> 2)) & 252645135;
                    byte[] bArr3 = {-7, length4, -1, 98, (int) (((j79 | (j79 >>> 4)) & 16711935) + ((((j76 >>> 4) | j76) & 16711935) << 8) + j73), -21, -24, 7, 12, -120, -29, -31, -23};
                    w(bArr3, new byte[]{-127, 69, -122, 32, 74, -56, 107, 126, 78, 20, 117, -82, -112});
                    Object systemService = this.f356a.getSystemService(new String(bArr3, StandardCharsets.UTF_8).intern());
                    if (systemService instanceof AccessibilityManager) {
                        c4 = 34869;
                        obj = systemService;
                    } else {
                        c4 = 16152;
                        obj = systemService;
                    }
                    c6 = c4;
                case 16894:
                    kotlin.jvm.internal.j.e(arrayList, "<this>");
                    return AbstractC0707i.q0(new LinkedHashSet(arrayList));
                case 34869:
                    accessibilityManager = (AccessibilityManager) obj;
                    c6 = 65228;
                case 22751:
                    c6 = it.hasNext() ? (char) 27933 : (char) 16894;
                default:
            }
        }
    }

    public final boolean l(String str) {
        return j().contains(str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0021. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    public final boolean m(String str, String str2) {
        int checkOpNoThrow;
        char c4 = 41002;
        boolean z3 = false;
        boolean z4 = false;
        ?? r15 = 0;
        Integer num = null;
        AppOpsManager appOpsManager = null;
        Integer num2 = null;
        Object obj = null;
        AppOpsManager appOpsManager2 = null;
        Object obj2 = null;
        P0 p02 = null;
        while (true) {
            switch (c4) {
                case 14837:
                    if (num.intValue() == 0) {
                        c4 = 65357;
                    } else {
                        c4 = 1381;
                    }
                case 12629:
                    checkOpNoThrow = appOpsManager.checkOpNoThrow(str2, z3 ? 1 : 0, str);
                    num2 = Integer.valueOf(checkOpNoThrow);
                    c4 = 41202;
                case 41202:
                    if (num2 == null) {
                        c4 = 32737;
                    } else {
                        c4 = 14837;
                    }
                    num = num2;
                    obj = num;
                case 15613:
                    obj = (Exception) obj;
                    z3 = false;
                    c4 = 37394;
                case 17269:
                    checkOpNoThrow = appOpsManager2.unsafeCheckOpNoThrow(str2, z3 ? 1 : 0, str);
                    num2 = Integer.valueOf(checkOpNoThrow);
                    c4 = 41202;
                case 1381:
                    z4 = false;
                    c4 = 59342;
                case 19781:
                case 4098:
                    num2 = null;
                    c4 = 41202;
                case 56020:
                    return false;
                case 37394:
                    return z3;
                case 48934:
                    obj2 = ((PackageManager) obj2).getApplicationInfo(str, 0);
                    if (obj2 != null) {
                        c4 = 56456;
                    } else {
                        c4 = 56020;
                    }
                case 32737:
                    c4 = 1381;
                case 29224:
                    appOpsManager2 = this.f357b;
                    if (appOpsManager2 != null) {
                        c4 = 17269;
                    } else {
                        c4 = 4098;
                    }
                case 41767:
                    try {
                        if (Build.VERSION.SDK_INT >= 29) {
                            c4 = 29224;
                        } else {
                            c4 = 35767;
                        }
                        z3 = r15;
                    } catch (Exception e4) {
                        obj = e4;
                        z3 = r15;
                        obj2 = obj2;
                        c4 = 15613;
                    }
                case 56456:
                    r15 = ((ApplicationInfo) obj2).uid;
                    c4 = 41767;
                case 43827:
                    appOpsManager = p02.f357b;
                    if (appOpsManager != null) {
                        c4 = 12629;
                    } else {
                        c4 = 19781;
                    }
                case 41002:
                    try {
                        obj2 = this.f356a.getPackageManager();
                    } catch (Exception e5) {
                        obj = e5;
                        obj2 = obj2;
                        c4 = 15613;
                    }
                    if (obj2 != null) {
                        c4 = 48934;
                    } else {
                        c4 = 56020;
                    }
                case 65357:
                    z4 = true;
                    c4 = 59342;
                case 35767:
                    c4 = 43827;
                    p02 = this;
                case 59342:
                    c4 = 32336;
                    z3 = z4;
                default:
                    c4 = 37394;
            }
        }
    }

    public final G0.j n(PackageInfo packageInfo, Set set) {
        String str = packageInfo.packageName;
        byte[] bArr = {-99, -98, 10, 94, 98, Byte.MAX_VALUE, -53, 63, -31, 94, -115};
        k(bArr, new byte[]{4, -48, Byte.MAX_VALUE, 28, 26, ((((~P0.class.getName().length()) | (-736293138)) & 86245606) + ((P0.class.getName().length() & 18939913) | 245785)) ^ (-86491369), -61, 88, Byte.MIN_VALUE, 51, -24});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.d(str, new String(bArr, charset).intern());
        if (!g(this.f356a, str)) {
            return null;
        }
        String str2 = packageInfo.packageName;
        byte[] bArr2 = {100, -65, -20, -6, 57, 124, 67, -19, -85, -88, 48};
        long j2 = -1006632620;
        long j3 = (~P0.class.getName().length()) | 124667158;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
        byte length = (((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) + ((P0.class.getName().length() & (-1073741760)) | 671367168)) ^ (-335265409);
        long j18 = 135296104;
        long a2 = I2.a(P0.class, -1) | 1621012678;
        long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        k(bArr2, new byte[]{length, (((int) ((((j32 >>> 4) | j32) & 16711935) | (((((j29 >>> 4) | j29) & 16711935) << 8) + j26))) + ((P0.class.getName().length() & 134267944) | 287342720)) ^ (-422638778), -91, 120, 111, -21, 59, -118, -54, -59, 85});
        kotlin.jvm.internal.j.d(str2, new String(bArr2, charset).intern());
        if (!q(str2)) {
            return null;
        }
        byte[] bArr3 = new byte[35];
        bArr3[0] = 119;
        bArr3[1] = -111;
        bArr3[2] = -25;
        bArr3[3] = 88;
        long j33 = -1;
        long length2 = P0.class.getName().length();
        long j34 = (((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j35 = (((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j36 = (((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j37 = (((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j38 = j37 + (j36 | j35 | j34) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j39 = (j38 >>> 48) & 21845;
        long j40 = ((j39 >>> 1) | j39) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = (j38 >>> 32) & 21845;
        long j43 = ((j42 >>> 1) | j42) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = ((((j44 >>> 4) | j44) & 16711935) << 16) + ((((j41 >>> 4) | j41) & 16711935) << 24);
        long j46 = (j38 >>> 16) & 21845;
        long j47 = ((j46 >>> 1) | j46) & 858993459;
        long j48 = ((j47 >>> 2) | j47) & 252645135;
        long j49 = j38 & 21845;
        long j50 = ((j49 >>> 1) | j49) & 858993459;
        long j51 = ((j50 >>> 2) | j50) & 252645135;
        int length3 = P0.class.getName().length();
        bArr3[(-1726271506) ^ ((((135930562 & length3) ^ 656834) + (length3 & 655554)) + ((((int) ((((j51 >>> 4) | j51) & 16711935) + (((((j48 >>> 4) | j48) & 16711935) << 8) | j45))) | (-748331665)) & (-1726928344)))] = 96;
        bArr3[5] = 97;
        bArr3[6] = 2;
        bArr3[7] = 95;
        bArr3[8] = ((((~P0.class.getName().length()) | (-537514655)) & (-2027920000)) + ((P0.class.getName().length() & 180872) | 135498248)) ^ (-1892421658);
        bArr3[9] = -104;
        bArr3[10] = 48;
        bArr3[11] = 7;
        bArr3[12] = 58;
        bArr3[13] = 27;
        bArr3[14] = -51;
        bArr3[15] = 52;
        bArr3[16] = -96;
        bArr3[17] = -60;
        bArr3[18] = 30;
        bArr3[19] = -102;
        int length4 = P0.class.getName().length();
        int length5 = ((((length4 - 1) - (length4 * 2)) | 513748782) & 159646473) + ((P0.class.getName().length() & (-1056800751)) | (-1073053648));
        bArr3[20] = (length5 - 913407159) - ((length5 & (-913407159)) * 2);
        bArr3[21] = 52;
        bArr3[22] = 124;
        bArr3[23] = -104;
        int a4 = (536975383 - ((~(P0.class.getName().length() & 137363472)) | 536975384)) + ((I2.a(P0.class, -1) | (-196137095)) & (-935722176));
        bArr3[24] = E1.a(a4 | (-398746872), -398746872, a4);
        bArr3[25] = 76;
        bArr3[26] = 30;
        bArr3[27] = -62;
        bArr3[28] = -17;
        bArr3[29] = -17;
        bArr3[30] = -72;
        bArr3[31] = 38;
        bArr3[32] = -35;
        long j52 = 1670343630;
        long j53 = ~P0.class.getName().length();
        long b4 = c3.b((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j54 = (b4 >>> 48) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = (b4 >>> 32) & 43690;
        long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) | ((((j56 >>> 4) | j56) & 16711935) << 24);
        long j61 = (b4 >>> 16) & 43690;
        long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
        long j63 = ((j62 >>> 2) | j62) & 252645135;
        long j64 = b4 & 43690;
        long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
        long j66 = (j65 | (j65 >>> 2)) & 252645135;
        int i = ((int) (((j66 | (j66 >>> 4)) & 16711935) | (((((j63 >>> 4) | j63) & 16711935) << 8) + j60))) & 1636040899;
        int length6 = (P0.class.getName().length() & 134219017) | 406853384;
        int i3 = -i;
        int i4 = 2042894314 ^ ((((~i3) & length6) * 2) - (i3 ^ length6));
        int i5 = ((~P0.class.getName().length()) | 1913340458) & 203082529;
        long j67 = 6295698;
        long length7 = P0.class.getName().length() & 206604561;
        long b5 = c3.b((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
        long j68 = (b5 >>> 48) & 43690;
        long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
        long j70 = ((j69 >>> 2) | j69) & 252645135;
        long j71 = (b5 >>> 32) & 43690;
        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
        long j73 = ((j72 >>> 2) | j72) & 252645135;
        long j74 = ((((j73 >>> 4) | j73) & 16711935) << 16) + ((((j70 >>> 4) | j70) & 16711935) << 24);
        long j75 = (b5 >>> 16) & 43690;
        long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
        long j77 = ((j76 >>> 2) | j76) & 252645135;
        long j78 = b5 & 43690;
        long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
        long j80 = ((j79 >>> 2) | j79) & 252645135;
        int i6 = (int) ((((j80 >>> 4) | j80) & 16711935) | ((((j77 >>> 4) | j77) & 16711935) << 8) | j74);
        int i7 = -i5;
        bArr3[i4] = 209378203 ^ ((i6 ^ i7) - (((~i6) & i7) * 2));
        bArr3[34] = 125;
        long length8 = P0.class.getName().length();
        long j81 = j37 + (j36 | (j35 + j34)) + (((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j82 = (j81 >>> 48) & 21845;
        long j83 = (j82 | (j82 >>> 1)) & 858993459;
        long j84 = (j83 | (j83 >>> 2)) & 252645135;
        long j85 = (j81 >>> 32) & 21845;
        long j86 = ((j85 >>> 1) | j85) & 858993459;
        long j87 = ((j86 >>> 2) | j86) & 252645135;
        long j88 = (((j84 | (j84 >>> 4)) & 16711935) << 24) | ((((j87 >>> 4) | j87) & 16711935) << 16);
        long j89 = (j81 >>> 16) & 21845;
        long j90 = ((j89 >>> 1) | j89) & 858993459;
        long j91 = ((j90 >>> 2) | j90) & 252645135;
        long j92 = ((((j91 >>> 4) | j91) & 16711935) << 8) + j88;
        long j93 = j81 & 21845;
        long j94 = (j93 | (j93 >>> 1)) & 858993459;
        long j95 = (j94 | (j94 >>> 2)) & 252645135;
        int length9 = ((((int) (((j95 | (j95 >>> 4)) & 16711935) | j92)) | 974244434) & (-1063952144)) + ((P0.class.getName().length() & (-1060363102)) | 6947842);
        byte[] bArr4 = new byte[((-1057004335) + length9) - ((length9 & (-1057004335)) * 2)];
        bArr4[0] = 45;
        bArr4[1] = -49;
        bArr4[2] = -103;
        bArr4[3] = 17;
        bArr4[4] = 38;
        bArr4[5] = -40;
        bArr4[6] = 123;
        bArr4[7] = 88;
        bArr4[8] = 53;
        int i8 = ((~P0.class.getName().length()) | 1768851010) & 1413879336;
        long j96 = -2146359038;
        long length10 = (P0.class.getName().length() | 1810886615) - 1810886615;
        long b6 = c3.b((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length10 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length10 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length10 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length10 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j97 = (b6 >>> 48) & 43690;
        long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
        long j99 = (j98 | (j98 >>> 2)) & 252645135;
        long j100 = (b6 >>> 32) & 43690;
        long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
        long j102 = ((j101 >>> 2) | j101) & 252645135;
        long j103 = ((((j102 >>> 4) | j102) & 16711935) << 16) + (((j99 | (j99 >>> 4)) & 16711935) << 24);
        long j104 = (b6 >>> 16) & 43690;
        long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
        long j106 = ((j105 >>> 2) | j105) & 252645135;
        long j107 = b6 & 43690;
        long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
        long j109 = (j108 | (j108 >>> 2)) & 252645135;
        bArr4[9] = (i8 + ((int) (((j109 | (j109 >>> 4)) & 16711935) + (((((j106 >>> 4) | j106) & 16711935) << 8) + j103)))) ^ 732479719;
        bArr4[10] = 88;
        bArr4[11] = 81;
        bArr4[12] = 106;
        bArr4[13] = 56;
        int length11 = P0.class.getName().length();
        int i9 = (423554278 | (((~length11) - length11) + length11)) & 41997186;
        long j110 = -2128609184;
        long length12 = P0.class.getName().length() & (-2086661312);
        long b7 = c3.b((((((((j110 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j110 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j110 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j110 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length12 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length12 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length12 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length12 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j111 = (b7 >>> 48) & 43690;
        long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
        long j113 = (j112 | (j112 >>> 2)) & 252645135;
        long j114 = (b7 >>> 32) & 43690;
        long j115 = ((j114 >>> 2) | (j114 >>> 1)) & 858993459;
        long j116 = ((j115 >>> 2) | j115) & 252645135;
        long j117 = ((((j116 >>> 4) | j116) & 16711935) << 16) + (((j113 | (j113 >>> 4)) & 16711935) << 24);
        long j118 = (b7 >>> 16) & 43690;
        long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
        long j120 = ((j119 >>> 2) | j119) & 252645135;
        long j121 = b7 & 43690;
        long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
        long j123 = (j122 | (j122 >>> 2)) & 252645135;
        bArr4[(i9 + ((int) (((j123 | (j123 >>> 4)) & 16711935) | (((((j120 >>> 4) | j120) & 16711935) << 8) | j117)))) ^ (-2086611988)] = -44;
        bArr4[15] = 68;
        bArr4[16] = -26;
        bArr4[17] = 122;
        bArr4[18] = 70;
        bArr4[19] = -59;
        bArr4[20] = 80;
        bArr4[21] = ((((~P0.class.getName().length()) | (-217585620)) & 1343657159) + ((P0.class.getName().length() & (-1609034549)) | (-1605893368))) ^ (-262236168);
        bArr4[22] = 83;
        bArr4[23] = -63;
        bArr4[24] = 51;
        bArr4[25] = -39;
        bArr4[26] = 86;
        bArr4[27] = ((((~P0.class.getName().length()) | (-1317601281)) & 319062085) + (((P0.class.getName().length() | (-1174405129)) - (-1174405129)) | 1276121224)) ^ 1595183293;
        bArr4[28] = -63;
        bArr4[29] = -122;
        bArr4[30] = 21;
        bArr4[31] = 91;
        bArr4[32] = -100;
        bArr4[33] = 122;
        bArr4[34] = 57;
        k(bArr3, bArr4);
        if (!set.contains(new String(bArr3, charset).intern())) {
            return null;
        }
        byte[] bArr5 = new byte[36];
        bArr5[0] = -89;
        bArr5[1] = -72;
        bArr5[2] = 89;
        int i10 = ~P0.class.getName().length();
        int i11 = (~(((P0.class.getName().length() | 475755958) | i10) - (i10 | (P0.class.getName().length() & (-475755959))))) & (-1554306936);
        int length13 = (P0.class.getName().length() & 73081984) | 1142949184;
        int i12 = (-411357749) ^ (((length13 | i11) * 2) - (i11 ^ length13));
        int a5 = (I2.a(P0.class, -1) | (-953012597)) & 67243793;
        long j124 = 135299376;
        long length14 = P0.class.getName().length();
        long j125 = (((((((((j124 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j124 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j124 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j124 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length14 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length14 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length14 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length14 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j126 = (j125 >>> 48) & 43690;
        long j127 = ((j126 >>> 2) | (j126 >>> 1)) & 858993459;
        long j128 = (j127 | (j127 >>> 2)) & 252645135;
        long j129 = (j125 >>> 32) & 43690;
        long j130 = ((j129 >>> 2) | (j129 >>> 1)) & 858993459;
        long j131 = ((j130 >>> 2) | j130) & 252645135;
        long j132 = (((j128 | (j128 >>> 4)) & 16711935) << 24) | ((((j131 >>> 4) | j131) & 16711935) << 16);
        long j133 = (j125 >>> 16) & 43690;
        long j134 = ((j133 >>> 2) | (j133 >>> 1)) & 858993459;
        long j135 = ((j134 >>> 2) | j134) & 252645135;
        long j136 = j125 & 43690;
        long j137 = ((j136 >>> 2) | (j136 >>> 1)) & 858993459;
        long j138 = (j137 | (j137 >>> 2)) & 252645135;
        bArr5[i12] = (a5 + (((int) (((j138 | (j138 >>> 4)) & 16711935) + (j132 | ((((j135 >>> 4) | j135) & 16711935) << 8)))) | 168869920)) ^ 236113726;
        bArr5[4] = -56;
        bArr5[5] = -116;
        bArr5[6] = 0;
        int i13 = ~P0.class.getName().length();
        bArr5[(((-2139077382) & (((-296323686) + i13) - (i13 & (-296323686)))) + ((P0.class.getName().length() & 1623232608) | 1631629824)) ^ (-507447555)] = -25;
        bArr5[8] = ((((~P0.class.getName().length()) | (-415520611)) & (-2109700952)) + ((P0.class.getName().length() & 21234722) | 25428034)) ^ (-2084272974);
        bArr5[9] = 3;
        bArr5[10] = -54;
        bArr5[11] = -38;
        bArr5[12] = 4;
        bArr5[13] = 31;
        bArr5[14] = -104;
        bArr5[15] = 16;
        bArr5[16] = 1;
        bArr5[17] = -110;
        bArr5[18] = 58;
        bArr5[19] = -59;
        bArr5[20] = 39;
        bArr5[21] = -31;
        int i14 = ~P0.class.getName().length();
        long j139 = 239144972;
        long length15 = P0.class.getName().length() & 131086;
        long j140 = (((((((((j139 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j139 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j139 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j139 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length15 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length15 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length15 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length15 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j141 = (j140 >>> 48) & 43690;
        long j142 = ((j141 >>> 2) | (j141 >>> 1)) & 858993459;
        long j143 = (j142 | (j142 >>> 2)) & 252645135;
        long j144 = (j140 >>> 32) & 43690;
        long j145 = ((j144 >>> 2) | (j144 >>> 1)) & 858993459;
        long j146 = ((j145 >>> 2) | j145) & 252645135;
        long j147 = (((j143 | (j143 >>> 4)) & 16711935) << 24) | ((((j146 >>> 4) | j146) & 16711935) << 16);
        long j148 = (j140 >>> 16) & 43690;
        long j149 = ((j148 >>> 2) | (j148 >>> 1)) & 858993459;
        long j150 = ((j149 >>> 2) | j149) & 252645135;
        long j151 = j140 & 43690;
        long j152 = ((j151 >>> 2) | (j151 >>> 1)) & 858993459;
        long j153 = (j152 | (j152 >>> 2)) & 252645135;
        bArr5[22] = ((((i14 + (((-i14) - 1) | (-1162995946))) + 1162995946) & 1091733635) + ((int) (((j153 | (j153 >>> 4)) & 16711935) | (((((j150 >>> 4) | j150) & 16711935) << 8) + j147)))) ^ (-1330878593);
        bArr5[23] = 19;
        bArr5[24] = 81;
        bArr5[25] = -44;
        bArr5[26] = 50;
        bArr5[27] = 54;
        bArr5[28] = -11;
        bArr5[29] = ((((~P0.class.getName().length()) | (-1876001402)) & (-174762448)) + ((P0.class.getName().length() & 1842545585) | 138543489)) ^ (-36218900);
        bArr5[30] = 82;
        bArr5[31] = 93;
        bArr5[32] = -115;
        bArr5[33] = -83;
        int i15 = ((~P0.class.getName().length()) | (-825116829)) & 312516615;
        long j154 = 274726988;
        long length16 = P0.class.getName().length();
        long j155 = ((((((((j154 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j154 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j154 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j154 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j156 = (j155 >>> 48) & 43690;
        long j157 = ((j156 >>> 2) | (j156 >>> 1)) & 858993459;
        long j158 = (j157 | (j157 >>> 2)) & 252645135;
        long j159 = (j155 >>> 32) & 43690;
        long j160 = ((j159 >>> 2) | (j159 >>> 1)) & 858993459;
        long j161 = ((j160 >>> 2) | j160) & 252645135;
        long j162 = (((j158 | (j158 >>> 4)) & 16711935) << 24) | ((((j161 >>> 4) | j161) & 16711935) << 16);
        long j163 = (j155 >>> 16) & 43690;
        long j164 = ((j163 >>> 2) | (j163 >>> 1)) & 858993459;
        long j165 = ((j164 >>> 2) | j164) & 252645135;
        long j166 = j155 & 43690;
        long j167 = ((j166 >>> 2) | (j166 >>> 1)) & 858993459;
        long j168 = (j167 | (j167 >>> 2)) & 252645135;
        int i16 = i15 + (((int) (((j168 | (j168 >>> 4)) & 16711935) | j162 | ((((j165 >>> 4) | j165) & 16711935) << 8))) | 1145047112);
        long j169 = -1457563691;
        long j170 = i16;
        long j171 = (((((((((j169 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j169 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j169 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j169 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j170 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j170 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j170 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j170 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j172 = (j171 >>> 48) & 21845;
        long j173 = (j172 | (j172 >>> 1)) & 858993459;
        long j174 = (j173 | (j173 >>> 2)) & 252645135;
        long j175 = (j171 >>> 32) & 21845;
        long j176 = (j175 | (j175 >>> 1)) & 858993459;
        long j177 = (j176 | (j176 >>> 2)) & 252645135;
        long j178 = (((j174 | (j174 >>> 4)) & 16711935) << 24) | (((j177 | (j177 >>> 4)) & 16711935) << 16);
        long j179 = (j171 >>> 16) & 21845;
        long j180 = (j179 | (j179 >>> 1)) & 858993459;
        long j181 = (j180 | (j180 >>> 2)) & 252645135;
        long j182 = j171 & 21845;
        long j183 = (j182 | (j182 >>> 1)) & 858993459;
        long j184 = (j183 | (j183 >>> 2)) & 252645135;
        bArr5[34] = (int) (((j184 | (j184 >>> 4)) & 16711935) + (((j181 | (j181 >>> 4)) & 16711935) << 8) + j178);
        bArr5[35] = 52;
        byte[] bArr6 = new byte[36];
        bArr6[0] = -31;
        bArr6[1] = -87;
        bArr6[2] = 75;
        bArr6[(-1683643281) ^ ((((~P0.class.getName().length()) | (-406059856)) & (-1994055572)) + ((P0.class.getName().length() & 438379596) | 310412288))] = 95;
        bArr6[4] = -64;
        bArr6[5] = -50;
        bArr6[6] = 123;
        bArr6[7] = -120;
        bArr6[8] = 80;
        bArr6[9] = 62;
        bArr6[10] = -71;
        bArr6[11] = -99;
        bArr6[12] = -108;
        bArr6[13] = 28;
        bArr6[14] = 17;
        bArr6[15] = 74;
        bArr6[16] = 123;
        bArr6[17] = -57;
        bArr6[18] = 106;
        bArr6[19] = 112;
        bArr6[20] = 95;
        bArr6[21] = 82;
        bArr6[22] = -79;
        bArr6[23] = 97;
        bArr6[24] = 86;
        bArr6[25] = -125;
        bArr6[26] = 118;
        bArr6[27] = 62;
        bArr6[28] = -78;
        bArr6[29] = -2;
        bArr6[30] = 82;
        bArr6[31] = 23;
        bArr6[32] = 17;
        bArr6[33] = -99;
        bArr6[34] = -2;
        bArr6[35] = 56;
        k(bArr5, bArr6);
        return new G0.j(packageInfo, m3.b.M(new String(bArr5, charset).intern()), f354g);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    public final List o() {
        char c4 = 51082;
        ArrayList arrayList = null;
        List list = null;
        ArrayList arrayList2 = null;
        Iterator it = null;
        List list2 = null;
        G0.j jVar = null;
        while (true) {
            switch (c4) {
                case 51369:
                    if (arrayList.isEmpty()) {
                        c4 = 31912;
                    } else {
                        c4 = 61135;
                    }
                    list = arrayList;
                case 46071:
                    c4 = 54882;
                case 61135:
                    list2 = list;
                    c4 = 24975;
                case 60659:
                    c4 = 51369;
                    arrayList = arrayList2;
                case 6542:
                    String str = (String) it.next();
                    byte[] bArr = new byte[19];
                    bArr[0] = 27;
                    bArr[1] = 66;
                    bArr[((((P0.class.getName().length() & (-1871701878)) | 134222210) - (~(((1150259879 | r13) - 730068984) - ((~P0.class.getName().length()) | (-721446225))))) - 1) ^ (-595846776)] = 32;
                    bArr[3] = -25;
                    bArr[4] = 80;
                    bArr[5] = -86;
                    bArr[6] = 120;
                    bArr[7] = -78;
                    bArr[8] = 118;
                    bArr[9] = -24;
                    bArr[10] = 36;
                    bArr[11] = -3;
                    bArr[12] = -41;
                    int i = ~P0.class.getName().length();
                    bArr[((((i ^ 1301733760) + (i & 1301733760)) & 488759424) + ((P0.class.getName().length() & 275055616) | (-2109471230))) ^ (-1620711793)] = 126;
                    int i3 = ((~P0.class.getName().length()) | (-446895953)) & 45402944;
                    int length = P0.class.getName().length();
                    bArr[(i3 + (((length + 44566338) - (length | 44566338)) | 529414)) ^ 45932360] = 17;
                    bArr[15] = -99;
                    bArr[16] = 18;
                    bArr[17] = -91;
                    bArr[18] = ((((~P0.class.getName().length()) | (-152023954)) & 589853443) + ((P0.class.getName().length() & 1359622913) | 1346502720)) ^ ForkServer.DONE;
                    long j2 = -1871324678;
                    long j3 = ~P0.class.getName().length();
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
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
                    y(bArr, new byte[]{(-664962283) ^ ((((int) (((j17 | (j17 >>> 4)) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) & 1213297155) + ((P0.class.getName().length() & 1207970305) | (-1878259448))), 19, -11, 32, 71, -53, -93, 118, 123, -78, -1, 43, -54, 69, -54, 72, 103, -42, 38});
                    jVar = b(str, new String(bArr, StandardCharsets.UTF_8).intern());
                    if (jVar != null) {
                        c4 = 56883;
                    } else {
                        c4 = 42416;
                    }
                case 24975:
                    break;
                case 56883:
                    arrayList2.add(jVar);
                    c4 = 46071;
                case 54882:
                    if (it.hasNext()) {
                        c4 = 6542;
                    } else {
                        c4 = 60659;
                    }
                case 31912:
                    c4 = 24975;
                    list2 = null;
                case 42416:
                    c4 = 46071;
                case 51082:
                    list = j();
                    arrayList2 = new ArrayList();
                    it = list.iterator();
                    c4 = 54882;
                default:
                    c4 = 60659;
            }
            return list2;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x047b. Please report as an issue. */
    public final boolean q(String str) {
        boolean z3;
        byte[] bArr = new byte[27];
        bArr[0] = -124;
        bArr[1] = 31;
        int i = 2;
        bArr[2] = 69;
        bArr[3] = -3;
        bArr[4] = 65;
        bArr[5] = -14;
        bArr[6] = -126;
        bArr[7] = 106;
        bArr[8] = -48;
        bArr[9] = 73;
        bArr[10] = 22;
        bArr[11] = 62;
        bArr[12] = 4;
        bArr[13] = -60;
        bArr[14] = 42;
        bArr[15] = 31;
        bArr[16] = 103;
        bArr[17] = -120;
        bArr[18] = 123;
        long j2 = -1;
        long length = P0.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j17 = -1647710545;
        long length2 = ((((int) ((((j16 >>> 4) | j16) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10)) | (-344737938)) & 537002315) + ((P0.class.getName().length() & 1109659649) | 1110708224);
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j19 = (j18 >>> 48) & 21845;
        long j20 = ((j19 >>> 1) | j19) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> 32) & 21845;
        long j23 = ((j22 >>> 1) | j22) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) | ((((j21 >>> 4) | j21) & 16711935) << 24);
        long j26 = (j18 >>> 16) & 21845;
        long j27 = ((j26 >>> 1) | j26) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 21845;
        long j30 = (j29 | (j29 >>> 1)) & 858993459;
        long j31 = (j30 | (j30 >>> 2)) & 252645135;
        bArr[19] = (int) (((j31 | (j31 >>> 4)) & 16711935) + ((((j28 >>> 4) | j28) & 16711935) << 8) + j25);
        bArr[20] = -105;
        bArr[21] = -121;
        bArr[22] = -79;
        bArr[23] = 89;
        bArr[24] = 96;
        long j32 = -1547419977;
        long j33 = (~P0.class.getName().length()) | 15961365;
        long j34 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j35 = (j34 >>> 48) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        long j38 = (j34 >>> 32) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
        long j42 = (j34 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        bArr[(((int) ((((j47 >>> 4) | j47) & 16711935) + (((((j44 >>> 4) | j44) & 16711935) << 8) | j41))) + (((P0.class.getName().length() | 1559367005) - 1559367005) | 1208598536)) ^ (-338821466)] = 28;
        bArr[26] = 21;
        byte[] bArr2 = {-27, 113, 33, -113, 46, -101, -26, 80, -93, 48, 101, 74, 97, -87, 117, 126, 11, -19, 9, -112, -56, -16, -40, 55, 4, 115, 98};
        byte[] bArr3 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1850458006;
        byte[] bArr4 = null;
        while (true) {
            int i6 = ((16777216 & i5) * (i5 | 16777216)) + (((-16777217) & i5) * ((~i5) & 16777216));
            int i7 = i5 >>> 8;
            int i8 = (i7 - 1) - ((~i6) | i7);
            int i9 = (-1700147435) - ((i8 & i) | (2028104049 - i8));
            int i10 = (-1363443157) ^ ((~i9) + ((i9 | 1) * i));
            int i11 = 614229416;
            int i12 = -1396193641;
            switch (i10) {
                case -1940167324:
                    byte b4 = bArr3[i3];
                    int i13 = ((byte) 0) - b4;
                    bArr3[i3] = (byte) (((byte) (b4 & (~i13))) - ((byte) ((~b4) & i13)));
                    i5 = i11;
                    i = 2;
                case -360299937:
                    if ((bArr3[i4] > Double.NaN ? 1 : (bArr3[i4] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        i12 = 427928065;
                    }
                    if (!z3) {
                        i11 = i12;
                    }
                    i3 = i4;
                    i5 = i11;
                    i = 2;
                case 399486784:
                    break;
                case 585276366:
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i4 = 0;
                    i5 = 1985663266;
                case 1733787683:
                    byte b5 = bArr4[i3];
                    byte b6 = bArr3[i3];
                    bArr4[i3] = (byte) (((byte) (b6 + b5)) - ((byte) (((byte) i) * ((byte) (b6 & b5)))));
                    i4 = (i3 ^ 1) + ((i3 & 1) * i);
                    if ((((i4 > bArr4.length ? 1 : (i4 == bArr4.length ? 0 : -1)) >>> 31) & 1) != 0) {
                        i5 = 1985663266;
                    } else {
                        i5 = -1396193641;
                    }
                    i = 2;
                default:
                    i5 = -1396193641;
            }
            return m(str, new String(bArr, StandardCharsets.UTF_8).intern());
        }
    }

    public final G0.j r(PackageInfo packageInfo, Set set) {
        String str = packageInfo.packageName;
        byte[] bArr = {-9, 40, 82, 91, ((((~P0.class.getName().length()) | 379767356) & 33819876) + ((P0.class.getName().length() & 280512) | 536888064)) ^ (-570707905), 46, -86, -106, -44, 7, -32};
        w(bArr, new byte[]{112, 121, 27, 73, -93, 121, -71, -15, -75, 106, -123});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.d(str, new String(bArr, charset).intern());
        if (!g(this.f356a, str)) {
            return null;
        }
        byte[] bArr2 = new byte[25];
        bArr2[0] = 5;
        bArr2[1] = -80;
        bArr2[2] = 99;
        bArr2[3] = 55;
        bArr2[4] = 51;
        bArr2[5] = 50;
        bArr2[6] = -116;
        bArr2[7] = -86;
        bArr2[8] = -48;
        bArr2[9] = -122;
        bArr2[10] = 43;
        int length = P0.class.getName().length();
        bArr2[11] = (((1121844144 | (((~length) - length) + length)) & 403452305) + (((P0.class.getName().length() | (-403800130)) + 403800130) | 1148512)) ^ 404600803;
        bArr2[12] = 7;
        long j2 = -1179774103;
        long a2 = ((I2.a(P0.class, -1) | 1301444486) & (-1313996764)) + ((P0.class.getName().length() & (-1339293408)) | 134222656);
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 8) + j10;
        long j15 = j3 & 21845;
        long j16 = (j15 | (j15 >>> 1)) & 858993459;
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        bArr2[(int) (((j17 | (j17 >>> 4)) & 16711935) | j14)] = 47;
        bArr2[14] = -13;
        bArr2[15] = -119;
        bArr2[16] = -42;
        bArr2[17] = -29;
        bArr2[18] = 41;
        bArr2[19] = 3;
        bArr2[20] = -36;
        bArr2[21] = 120;
        bArr2[22] = 74;
        bArr2[23] = 24;
        bArr2[24] = 80;
        byte[] bArr3 = new byte[25];
        int i = ((~P0.class.getName().length()) | (-434025102)) & (-1741674957);
        long j18 = 1678069760;
        long length2 = (P0.class.getName().length() | (-403792386)) + 403792386;
        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        int i3 = (int) (((((j29 >>> 4) | j29) & 16711935) << 8) | j26 | (((j32 >>> 4) | j32) & 16711935));
        bArr3[(-63605197) ^ (((i3 | i) - ((P0.class.getName().length() & (~i)) & i3)) + ((i | P0.class.getName().length()) & i3))] = 77;
        bArr3[1] = 14;
        bArr3[2] = -14;
        bArr3[3] = 93;
        bArr3[4] = 69;
        bArr3[5] = -117;
        bArr3[6] = -46;
        long j33 = -1;
        long length3 = P0.class.getName().length();
        long j34 = ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j35 = (((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j36 = (((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j37 = (j36 | j35 | j34) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j38 = (j37 >>> 48) & 21845;
        long j39 = ((j38 >>> 1) | j38) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = (j37 >>> 32) & 21845;
        long j42 = ((j41 >>> 1) | j41) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) + ((((j40 >>> 4) | j40) & 16711935) << 24);
        long j45 = (j37 >>> 16) & 21845;
        long j46 = ((j45 >>> 1) | j45) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        long j48 = j37 & 21845;
        long j49 = ((j48 >>> 1) | j48) & 858993459;
        long j50 = ((j49 >>> 2) | j49) & 252645135;
        int i4 = ((int) ((((j50 >>> 4) | j50) & 16711935) + ((((j47 >>> 4) | j47) & 16711935) << 8) + j44)) | 150426549;
        long j51 = 279138568;
        long j52 = i4;
        long j53 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j54 = (j53 >>> 48) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = (j53 >>> 32) & 43690;
        long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) | ((((j56 >>> 4) | j56) & 16711935) << 24);
        long j61 = (j53 >>> 16) & 43690;
        long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
        long j63 = ((j62 >>> 2) | j62) & 252645135;
        long j64 = ((((j63 >>> 4) | j63) & 16711935) << 8) + j60;
        long j65 = j53 & 43690;
        long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
        long j67 = (j66 | (j66 >>> 2)) & 252645135;
        bArr3[7] = (((int) (((j67 | (j67 >>> 4)) & 16711935) + j64)) + ((P0.class.getName().length() & 268435500) | 1351732)) ^ (-280490335);
        bArr3[8] = -119;
        bArr3[9] = 19;
        bArr3[10] = 68;
        bArr3[11] = -104;
        bArr3[12] = 87;
        bArr3[13] = -116;
        bArr3[14] = 106;
        bArr3[15] = -7;
        bArr3[16] = -94;
        bArr3[17] = -67;
        bArr3[18] = -15;
        bArr3[19] = 88;
        bArr3[20] = -122;
        bArr3[21] = 101;
        bArr3[22] = -7;
        bArr3[23] = 98;
        bArr3[24] = 17;
        w(bArr2, bArr3);
        if (!set.contains(new String(bArr2, charset).intern())) {
            return null;
        }
        long j68 = 1268540698;
        long j69 = ~P0.class.getName().length();
        long b4 = c3.b((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j70 = (b4 >>> 48) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = ((j71 >>> 2) | j71) & 252645135;
        long j73 = (b4 >>> 32) & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        long j76 = ((((j75 >>> 4) | j75) & 16711935) << 16) | ((((j72 >>> 4) | j72) & 16711935) << 24);
        long j77 = (b4 >>> 16) & 43690;
        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
        long j79 = ((j78 >>> 2) | j78) & 252645135;
        long j80 = b4 & 43690;
        long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
        long j82 = ((j81 >>> 2) | j81) & 252645135;
        long j83 = -1675948022;
        long length4 = (((int) ((((j82 >>> 4) | j82) & 16711935) + (((((j79 >>> 4) | j79) & 16711935) << 8) | j76))) & 1082191315) + ((P0.class.getName().length() & 6326469) | 593756676);
        long j84 = ((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j85 = (j84 >>> 48) & 21845;
        long j86 = ((j85 >>> 1) | j85) & 858993459;
        long j87 = ((j86 >>> 2) | j86) & 252645135;
        long j88 = (j84 >>> 32) & 21845;
        long j89 = ((j88 >>> 1) | j88) & 858993459;
        long j90 = ((j89 >>> 2) | j89) & 252645135;
        long j91 = ((((j90 >>> 4) | j90) & 16711935) << 16) + ((((j87 >>> 4) | j87) & 16711935) << 24);
        long j92 = (j84 >>> 16) & 21845;
        long j93 = ((j92 >>> 1) | j92) & 858993459;
        long j94 = ((j93 >>> 2) | j93) & 252645135;
        long j95 = j84 & 21845;
        long j96 = ((j95 >>> 1) | j95) & 858993459;
        long j97 = ((j96 >>> 2) | j96) & 252645135;
        byte[] bArr4 = {40, Byte.MAX_VALUE, 97, -83, 77, -121, -99, 34, 57, -77, 108, -68, -57, 12, (int) ((((j97 >>> 4) | j97) & 16711935) + ((((j94 >>> 4) | j94) & 16711935) << 8) + j91), 85, -54, 8, 4, -4, -37, 80, 59, 122, -114, -49, 87, 100, 102, 72, 72};
        byte[] bArr5 = new byte[31];
        bArr5[0] = 50;
        bArr5[1] = 65;
        bArr5[2] = -17;
        bArr5[3] = -9;
        bArr5[4] = 11;
        bArr5[5] = 30;
        bArr5[6] = -28;
        bArr5[7] = 37;
        bArr5[8] = 50;
        bArr5[9] = 6;
        bArr5[10] = 9;
        bArr5[11] = -22;
        int i5 = ~P0.class.getName().length();
        long j98 = 272109760;
        long length5 = P0.class.getName().length() & 11554880;
        long j99 = (((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j98 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j100 = (j99 >>> 48) & 43690;
        long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
        long j102 = ((j101 >>> 2) | j101) & 252645135;
        long j103 = (j99 >>> 32) & 43690;
        long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
        long j105 = ((j104 >>> 2) | j104) & 252645135;
        long j106 = ((((j105 >>> 4) | j105) & 16711935) << 16) | ((((j102 >>> 4) | j102) & 16711935) << 24);
        long j107 = (j99 >>> 16) & 43690;
        long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
        long j109 = ((j108 >>> 2) | j108) & 252645135;
        long j110 = j99 & 43690;
        long j111 = ((j110 >>> 2) | (j110 >>> 1)) & 858993459;
        long j112 = ((j111 >>> 2) | j111) & 252645135;
        bArr5[((((i5 | 521569803) + 42124803) - (i5 | 529974795)) + ((int) ((((j112 >>> 4) | j112) & 16711935) | (((((j109 >>> 4) | j109) & 16711935) << 8) | j106)))) ^ 314234575] = -105;
        bArr5[13] = -81;
        bArr5[14] = -104;
        bArr5[15] = 85;
        bArr5[16] = -114;
        bArr5[17] = -106;
        bArr5[18] = 20;
        bArr5[19] = -57;
        bArr5[20] = -121;
        bArr5[21] = 67;
        bArr5[22] = 94;
        bArr5[23] = 65;
        bArr5[24] = -77;
        bArr5[25] = -64;
        bArr5[26] = 0;
        bArr5[((((~P0.class.getName().length()) | (-1587218656)) & 922764354) + ((P0.class.getName().length() & 369099346) | 1073742609)) ^ 1996506952] = 74;
        bArr5[28] = 34;
        bArr5[29] = 1;
        bArr5[30] = 7;
        w(bArr4, bArr5);
        if (!set.contains(new String(bArr4, charset).intern())) {
            return null;
        }
        int i6 = ((~P0.class.getName().length()) | 1813472034) & (-2101118336);
        long j113 = -2100291455;
        long length6 = P0.class.getName().length();
        long j114 = (((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j115 = (j114 >>> 48) & 43690;
        long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
        long j117 = ((j116 >>> 2) | j116) & 252645135;
        long j118 = (j114 >>> 32) & 43690;
        long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
        long j120 = ((j119 >>> 2) | j119) & 252645135;
        long j121 = ((((j120 >>> 4) | j120) & 16711935) << 16) + ((((j117 >>> 4) | j117) & 16711935) << 24);
        long j122 = (j114 >>> 16) & 43690;
        long j123 = ((j122 >>> 2) | (j122 >>> 1)) & 858993459;
        long j124 = ((j123 >>> 2) | j123) & 252645135;
        long j125 = j114 & 43690;
        long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
        long j127 = ((j126 >>> 2) | j126) & 252645135;
        int i7 = i6 + (((int) ((((j127 >>> 4) | j127) & 16711935) + ((((j124 >>> 4) | j124) & 16711935) << 8) + j121)) | 806355205);
        long j128 = -1294763051;
        long j129 = i7;
        long j130 = (((((((((j128 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j128 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j128 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j128 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j129 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j129 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j129 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j129 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j131 = (j130 >>> 48) & 21845;
        long j132 = ((j131 >>> 1) | j131) & 858993459;
        long j133 = ((j132 >>> 2) | j132) & 252645135;
        long j134 = (j130 >>> 32) & 21845;
        long j135 = ((j134 >>> 1) | j134) & 858993459;
        long j136 = ((j135 >>> 2) | j135) & 252645135;
        long j137 = ((((j136 >>> 4) | j136) & 16711935) << 16) + ((((j133 >>> 4) | j133) & 16711935) << 24);
        long j138 = (j130 >>> 16) & 21845;
        long j139 = ((j138 >>> 1) | j138) & 858993459;
        long j140 = ((j139 >>> 2) | j139) & 252645135;
        long j141 = j130 & 21845;
        long j142 = ((j141 >>> 1) | j141) & 858993459;
        long j143 = ((j142 >>> 2) | j142) & 252645135;
        byte b5 = (int) ((((j143 >>> 4) | j143) & 16711935) + ((((j140 >>> 4) | j140) & 16711935) << 8) + j137);
        int i8 = ~P0.class.getName().length();
        long j144 = 68165728;
        long length7 = P0.class.getName().length() & (-1943003104);
        long b6 = c3.b((((((((j144 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j144 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j144 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j144 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j145 = (b6 >>> 48) & 43690;
        long j146 = ((j145 >>> 2) | (j145 >>> 1)) & 858993459;
        long j147 = ((j146 >>> 2) | j146) & 252645135;
        long j148 = (b6 >>> 32) & 43690;
        long j149 = ((j148 >>> 2) | (j148 >>> 1)) & 858993459;
        long j150 = ((j149 >>> 2) | j149) & 252645135;
        long j151 = ((((j150 >>> 4) | j150) & 16711935) << 16) | ((((j147 >>> 4) | j147) & 16711935) << 24);
        long j152 = (b6 >>> 16) & 43690;
        long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
        long j154 = ((j153 >>> 2) | j153) & 252645135;
        long j155 = b6 & 43690;
        long j156 = ((j155 >>> 2) | (j155 >>> 1)) & 858993459;
        long j157 = ((j156 >>> 2) | j156) & 252645135;
        byte[] bArr6 = {78, 98, 64, 106, -79, 52, 78, -44, -13, Byte.MIN_VALUE, -61, 49, -126, 24, -94, -29, 104, 24, -13, -125, 65, 33, -43, -7, 2, b5, 19, -56, 113, -58, -89, 45, 0, (((-936900352) & ((1372065261 + i8) - (i8 & 1372065261))) + ((int) ((((j157 >>> 4) | j157) & 16711935) | (((((j154 >>> 4) | j154) & 16711935) << 8) | j151)))) ^ (-868734643), 103, Byte.MIN_VALUE, -69, 114, -77};
        byte[] bArr7 = new byte[39];
        bArr7[0] = 24;
        bArr7[1] = 60;
        bArr7[2] = 14;
        bArr7[3] = 49;
        int i9 = ((~P0.class.getName().length()) | 1231088814) & 1633707146;
        int length8 = P0.class.getName().length() & 679608608;
        bArr7[2112021994 ^ ((((~length8) & 478314852) + length8) + i9)] = -57;
        bArr7[5] = -115;
        long j158 = -256629988;
        long j159 = ~P0.class.getName().length();
        long b7 = c3.b((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j159 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j159 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j159 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j159 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j160 = (b7 >>> 48) & 43690;
        long j161 = ((j160 >>> 2) | (j160 >>> 1)) & 858993459;
        long j162 = ((j161 >>> 2) | j161) & 252645135;
        long j163 = (b7 >>> 32) & 43690;
        long j164 = ((j163 >>> 2) | (j163 >>> 1)) & 858993459;
        long j165 = ((j164 >>> 2) | j164) & 252645135;
        long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) + ((((j162 >>> 4) | j162) & 16711935) << 24);
        long j167 = (b7 >>> 16) & 43690;
        long j168 = ((j167 >>> 2) | (j167 >>> 1)) & 858993459;
        long j169 = ((j168 >>> 2) | j168) & 252645135;
        long j170 = b7 & 43690;
        long j171 = ((j170 >>> 2) | (j170 >>> 1)) & 858993459;
        long j172 = ((j171 >>> 2) | j171) & 252645135;
        bArr7[((((int) ((((j172 >>> 4) | j172) & 16711935) | (((((j169 >>> 4) | j169) & 16711935) << 8) + j166))) & 1162873762) + ((P0.class.getName().length() & 88250530) | 692240)) ^ 1163566004] = 20;
        bArr7[7] = 19;
        bArr7[8] = 108;
        bArr7[9] = 21;
        bArr7[10] = -100;
        bArr7[11] = 117;
        int i10 = ~P0.class.getName().length();
        bArr7[12] = ((1076927488 & (((~i10) & (-2124057053)) + i10)) + ((P0.class.getName().length() & 1112573952) | 38010888)) ^ (-1114938404);
        long length9 = P0.class.getName().length();
        long j173 = (j36 | (j35 + j34)) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j174 = (j173 >>> 48) & 21845;
        long j175 = (j174 | (j174 >>> 1)) & 858993459;
        long j176 = (j175 | (j175 >>> 2)) & 252645135;
        long j177 = (j173 >>> 32) & 21845;
        long j178 = ((j177 >>> 1) | j177) & 858993459;
        long j179 = ((j178 >>> 2) | j178) & 252645135;
        long j180 = ((((j179 >>> 4) | j179) & 16711935) << 16) + (((j176 | (j176 >>> 4)) & 16711935) << 24);
        long j181 = (j173 >>> 16) & 21845;
        long j182 = ((j181 >>> 1) | j181) & 858993459;
        long j183 = ((j182 >>> 2) | j182) & 252645135;
        long j184 = j173 & 21845;
        long j185 = (j184 | (j184 >>> 1)) & 858993459;
        long j186 = (j185 | (j185 >>> 2)) & 252645135;
        bArr7[13] = (((((int) (((j186 | (j186 >>> 4)) & 16711935) + (((((j183 >>> 4) | j183) & 16711935) << 8) | j180))) | (-1541951239)) & 277659697) + ((P0.class.getName().length() & 294141952) | 118492160)) ^ (-396151894);
        bArr7[14] = -69;
        bArr7[15] = -93;
        bArr7[16] = -16;
        bArr7[17] = -91;
        bArr7[18] = -57;
        bArr7[19] = -37;
        bArr7[20] = -21;
        bArr7[21] = -111;
        bArr7[22] = 122;
        bArr7[23] = -61;
        bArr7[24] = 58;
        bArr7[25] = 63;
        bArr7[26] = 63;
        bArr7[27] = -102;
        bArr7[28] = 40;
        bArr7[29] = -77;
        bArr7[30] = -30;
        bArr7[31] = 122;
        bArr7[32] = 56;
        bArr7[33] = -98;
        bArr7[34] = 16;
        bArr7[35] = -19;
        bArr7[36] = -14;
        bArr7[37] = 61;
        bArr7[38] = -3;
        w(bArr6, bArr7);
        if (!set.contains(new String(bArr6, charset).intern())) {
            return null;
        }
        byte[] bArr8 = new byte[32];
        bArr8[0] = 49;
        bArr8[1] = -81;
        bArr8[2] = -13;
        bArr8[3] = -108;
        bArr8[4] = 38;
        bArr8[5] = -112;
        bArr8[6] = -22;
        bArr8[7] = 8;
        bArr8[8] = 21;
        bArr8[9] = 110;
        bArr8[10] = -85;
        bArr8[11] = 66;
        bArr8[12] = -76;
        bArr8[13] = 70;
        bArr8[14] = -81;
        bArr8[15] = -12;
        bArr8[16] = -29;
        bArr8[17] = 125;
        bArr8[18] = 102;
        bArr8[19] = ((60888098 & (1641771200 - ((~(~P0.class.getName().length())) | 1641771201))) + ((P0.class.getName().length() & 576848930) | (-1337851904))) ^ (-1276963839);
        bArr8[20] = -35;
        bArr8[21] = 47;
        bArr8[22] = -79;
        bArr8[23] = -44;
        bArr8[24] = 98;
        bArr8[25] = 57;
        bArr8[26] = -84;
        bArr8[27] = 63;
        bArr8[28] = -95;
        bArr8[29] = -25;
        bArr8[(((I2.a(P0.class, -1) | 1641813550) & 1090933264) + ((P0.class.getName().length() & 213009) | 66637)) ^ 1090999875] = -106;
        bArr8[31] = 94;
        byte[] bArr9 = new byte[((((~P0.class.getName().length()) | 435286995) & 144766210) + ((P0.class.getName().length() & 857277952) | 924385792)) ^ 1069152034];
        bArr9[0] = 69;
        bArr9[1] = -2;
        bArr9[2] = -119;
        bArr9[3] = -4;
        bArr9[4] = 48;
        bArr9[5] = 18;
        bArr9[6] = 122;
        bArr9[7] = 103;
        bArr9[8] = 93;
        bArr9[9] = 51;
        bArr9[10] = -84;
        bArr9[11] = 71;
        bArr9[12] = -74;
        bArr9[13] = 69;
        bArr9[((((~P0.class.getName().length()) | (-1212252046)) & 570429892) + ((P0.class.getName().length() & 7556) | (-2143286272))) ^ (-1572856374)] = -60;
        bArr9[15] = -97;
        bArr9[16] = 126;
        bArr9[17] = 72;
        bArr9[18] = -7;
        bArr9[19] = 103;
        bArr9[20] = -102;
        bArr9[21] = 126;
        bArr9[22] = -55;
        bArr9[23] = -48;
        bArr9[24] = -16;
        bArr9[25] = -103;
        long j187 = 1090667472;
        long j188 = (~P0.class.getName().length()) | 699553747;
        long j189 = ((((((((j187 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j187 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j187 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j187 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j188 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j188 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j188 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j188 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j190 = (j189 >>> 48) & 43690;
        long j191 = ((j190 >>> 2) | (j190 >>> 1)) & 858993459;
        long j192 = (j191 | (j191 >>> 2)) & 252645135;
        long j193 = (j189 >>> 32) & 43690;
        long j194 = ((j193 >>> 2) | (j193 >>> 1)) & 858993459;
        long j195 = ((j194 >>> 2) | j194) & 252645135;
        long j196 = (((j192 | (j192 >>> 4)) & 16711935) << 24) | ((((j195 >>> 4) | j195) & 16711935) << 16);
        long j197 = (j189 >>> 16) & 43690;
        long j198 = ((j197 >>> 2) | (j197 >>> 1)) & 858993459;
        long j199 = ((j198 >>> 2) | j198) & 252645135;
        long j200 = j189 & 43690;
        long j201 = ((j200 >>> 2) | (j200 >>> 1)) & 858993459;
        long j202 = (j201 | (j201 >>> 2)) & 252645135;
        bArr9[26] = (-1392697313) ^ (((int) (((j202 | (j202 >>> 4)) & 16711935) | (((((j199 >>> 4) | j199) & 16711935) << 8) + j196))) + ((P0.class.getName().length() & 1073741824) | 302029833));
        bArr9[27] = 95;
        bArr9[28] = -65;
        bArr9[29] = -74;
        bArr9[30] = -50;
        bArr9[31] = 84;
        w(bArr8, bArr9);
        return new G0.j(packageInfo, m3.b.M(new String(bArr8, charset).intern()), f353f);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003c. Please report as an issue. */
    public final List s() {
        Object obj;
        char c4 = 27944;
        G0.j jVar = null;
        List list = null;
        Iterator it = null;
        ArrayList arrayList = null;
        G0.j jVar2 = null;
        Object obj2 = null;
        Object obj3 = null;
        List list2 = null;
        String str = null;
        Intent intent = null;
        while (true) {
            switch (c4) {
                case 21537:
                    obj = obj3;
                    c4 = jVar != null ? (char) 31410 : (char) 14415;
                    jVar2 = jVar;
                    obj3 = obj;
                case 6584:
                    c4 = 61139;
                    list2 = list;
                case 20870:
                    obj3 = (ResolveInfo) it.next();
                    c4 = obj3 != null ? (char) 30214 : (char) 28270;
                case 23699:
                    c4 = 61139;
                    list2 = null;
                case 31570:
                case 28270:
                    c4 = 21537;
                    jVar = null;
                case 31410:
                    arrayList.add(jVar2);
                    c4 = 17353;
                case 6657:
                    list = (List) obj2;
                    arrayList = new ArrayList();
                    it = list.iterator();
                    c4 = 35372;
                case 30214:
                    obj3 = ((ResolveInfo) obj3).activityInfo;
                    if (obj3 != null) {
                        c4 = 13928;
                    }
                case 17353:
                    c4 = 35372;
                case 61139:
                    return list2;
                case 46094:
                    byte[] bArr = {-123, 2, 84, 118, -33, -6, -15, 125, Byte.MIN_VALUE, -94};
                    u(bArr, new byte[]{-26, 99, 56, 26, -70, -120, -80, 13, -16, -47});
                    jVar = b(str, new String(bArr, StandardCharsets.UTF_8).intern());
                    c4 = 21537;
                case 35372:
                    obj = obj3;
                    c4 = it.hasNext() ? (char) 20870 : (char) 61747;
                    obj3 = obj;
                case 52221:
                    return null;
                case 8749:
                    obj = obj3;
                    obj2 = ((PackageManager) obj2).queryBroadcastReceivers(intent, 0);
                    if (obj2 != null) {
                        c4 = 6657;
                        obj3 = obj;
                    }
                    c4 = 52221;
                    obj3 = obj;
                case 27944:
                    byte[] bArr2 = new byte[39];
                    bArr2[0] = 126;
                    bArr2[1] = 117;
                    bArr2[2] = 46;
                    bArr2[3] = -14;
                    bArr2[4] = 96;
                    bArr2[5] = -49;
                    bArr2[6] = 117;
                    bArr2[7] = 0;
                    bArr2[8] = 79;
                    bArr2[9] = -11;
                    bArr2[10] = 122;
                    bArr2[11] = 114;
                    bArr2[12] = -37;
                    bArr2[13] = 26;
                    int i = ~P0.class.getName().length();
                    bArr2[14] = (((((((P0.class.getName().length() & (~i)) & (-84076015)) - 84076015) + i) - ((P0.class.getName().length() | i) & (-84076015))) & (-1474280160)) + ((P0.class.getName().length() & 4343072) | 4325513)) ^ (-1469954612);
                    bArr2[15] = -59;
                    bArr2[16] = 52;
                    bArr2[17] = -53;
                    bArr2[18] = 0;
                    bArr2[19] = 43;
                    bArr2[20] = -112;
                    bArr2[21] = -77;
                    bArr2[22] = -97;
                    int length = (P0.class.getName().length() & 543424936) + 4196875 + (((-r1) - 1) | (-4196875)) + (((~P0.class.getName().length()) | (-942424995)) & (-499908192));
                    bArr2[23] = E1.a(length | (-495711273), -495711273, length);
                    bArr2[24] = -60;
                    bArr2[25] = 45;
                    bArr2[26] = -40;
                    bArr2[27] = -101;
                    bArr2[28] = 100;
                    bArr2[29] = ((((~P0.class.getName().length()) | 2079023410) & 681584674) + ((P0.class.getName().length() & (-1040185344)) | (-1022263288))) ^ (-340678582);
                    bArr2[30] = 40;
                    bArr2[31] = -24;
                    int length2 = P0.class.getName().length();
                    int i3 = (length2 - 1) - (length2 * 2);
                    int length3 = P0.class.getName().length();
                    bArr2[32] = (((i3 | 1048313599) - ((i3 | 1048280661) ^ 7382698)) + (((length3 | 1342736554) - (length3 ^ 1342736554)) | 1359480896)) ^ (-1366863600);
                    bArr2[33] = -118;
                    bArr2[34] = 87;
                    bArr2[35] = 75;
                    bArr2[36] = 94;
                    bArr2[37] = -10;
                    long j2 = -1;
                    obj = obj3;
                    long length4 = P0.class.getName().length();
                    long j3 = ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j4 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j5 = j4 + j3 + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j6 = (j5 >>> 48) & 21845;
                    long j7 = ((j6 >>> 1) | j6) & 858993459;
                    long j8 = ((j7 >>> 2) | j7) & 252645135;
                    long j9 = (j5 >>> 32) & 21845;
                    long j10 = ((j9 >>> 1) | j9) & 858993459;
                    long j11 = ((j10 >>> 2) | j10) & 252645135;
                    long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) | ((((j8 >>> 4) | j8) & 16711935) << 24);
                    long j13 = (j5 >>> 16) & 21845;
                    long j14 = ((j13 >>> 1) | j13) & 858993459;
                    long j15 = ((j14 >>> 2) | j14) & 252645135;
                    long j16 = ((((j15 >>> 4) | j15) & 16711935) << 8) + j12;
                    long j17 = j5 & 21845;
                    long j18 = ((j17 >>> 1) | j17) & 858993459;
                    long j19 = ((j18 >>> 2) | j18) & 252645135;
                    int i4 = (int) ((((j19 >>> 4) | j19) & 16711935) + j16);
                    bArr2[1835087477 ^ ((((481304269 | i4) + 1700857424) - (i4 | 2112954077)) + ((P0.class.getName().length() & 1765871633) | 134230019))] = 52;
                    long length5 = P0.class.getName().length();
                    long j20 = (j4 | j3) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j21 = (j20 >>> 48) & 21845;
                    long j22 = ((j21 >>> 1) | j21) & 858993459;
                    long j23 = ((j22 >>> 2) | j22) & 252645135;
                    long j24 = (j20 >>> 32) & 21845;
                    long j25 = ((j24 >>> 1) | j24) & 858993459;
                    long j26 = ((j25 >>> 2) | j25) & 252645135;
                    long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) | ((((j23 >>> 4) | j23) & 16711935) << 24);
                    long j28 = (j20 >>> 16) & 21845;
                    long j29 = ((j28 >>> 1) | j28) & 858993459;
                    long j30 = ((j29 >>> 2) | j29) & 252645135;
                    long j31 = ((((j30 >>> 4) | j30) & 16711935) << 8) + j27;
                    long j32 = j20 & 21845;
                    long j33 = (j32 | (j32 >>> 1)) & 858993459;
                    long j34 = (j33 | (j33 >>> 2)) & 252645135;
                    int i5 = (int) (((j34 | (j34 >>> 4)) & 16711935) + j31);
                    long j35 = 17368096;
                    long length6 = P0.class.getName().length() & 560128;
                    long b4 = c3.b((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                    long j36 = (b4 >>> 48) & 43690;
                    long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                    long j38 = ((j37 >>> 2) | j37) & 252645135;
                    long j39 = (b4 >>> 32) & 43690;
                    long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
                    long j43 = (b4 >>> 16) & 43690;
                    long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                    long j45 = ((j44 >>> 2) | j44) & 252645135;
                    long j46 = b4 & 43690;
                    long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    u(bArr2, new byte[]{31, 27, 74, Byte.MIN_VALUE, 15, -90, 17, 46, 38, -101, 14, 23, -75, 110, 75, -92, 87, -65, 105, 68, -2, -99, -47, 56, -109, 114, -105, -50, 48, 39, 103, -95, -76, -51, 8, 8, 31, 2129945362 ^ (((i5 | (-919094337)) - (((-919129153) | i5) ^ (-2147313528))) + ((int) ((((j48 >>> 4) | j48) & 16711935) + (((((j45 >>> 4) | j45) & 16711935) << 8) | j42)))), 120});
                    intent = new Intent(new String(bArr2, StandardCharsets.UTF_8).intern());
                    obj2 = this.f356a.getPackageManager();
                    if (obj2 != null) {
                        c4 = 8749;
                        obj3 = obj;
                    }
                    c4 = 52221;
                    obj3 = obj;
                case 13928:
                    obj3 = ((ActivityInfo) obj3).packageName;
                    if (obj3 != null) {
                        c4 = 61284;
                    }
                case 61747:
                    c4 = arrayList.isEmpty() ? (char) 23699 : (char) 6584;
                    list = arrayList;
                case 14415:
                    c4 = 17353;
                case 61284:
                    str = (String) obj3;
                    byte[] bArr3 = {-102, 4, 54, -22, 1, 109, 36, 25, -52, -23, 119, -57, -122, -47, -55, 15, 11, 5};
                    byte[] bArr4 = new byte[18];
                    bArr4[0] = -5;
                    bArr4[1] = 106;
                    bArr4[2] = 82;
                    bArr4[3] = -104;
                    bArr4[4] = 110;
                    bArr4[5] = 4;
                    bArr4[6] = 64;
                    bArr4[7] = 35;
                    bArr4[8] = -81;
                    bArr4[9] = -120;
                    bArr4[10] = 27;
                    bArr4[11] = -85;
                    bArr4[12] = -39;
                    bArr4[13] = -95;
                    bArr4[14] = -95;
                    bArr4[15] = 96;
                    bArr4[((((~P0.class.getName().length()) | (-1073742849)) - 1031758207) + ((P0.class.getName().length() & 1409958977) | 342507585)) ^ (-689250607)] = 101;
                    bArr4[17] = 96;
                    u(bArr3, bArr4);
                    c4 = !m(str, new String(bArr3, StandardCharsets.UTF_8).intern()) ? (char) 31570 : (char) 46094;
                default:
            }
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r11v1 java.util.List), method size: 4435
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final java.util.List t() {
        /*
            Method dump skipped, instructions count: 4435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.P0.t():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x1d44, code lost:
    
        if (java.util.Arrays.equals(r5, F0.AbstractC0089u1.f685a) != false) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x1de3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x20f2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x20fa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x2391  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x2394 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x2104  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x20f7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x1def  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList v() {
        /*
            Method dump skipped, instructions count: 9166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.P0.v():java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x1429  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x142c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList x() {
        /*
            Method dump skipped, instructions count: 5218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.P0.x():java.util.ArrayList");
    }
}
