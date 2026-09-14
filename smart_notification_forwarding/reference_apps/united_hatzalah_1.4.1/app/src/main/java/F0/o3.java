package F0;

import android.R;
import android.content.Context;
import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class o3 {

    /* renamed from: a, reason: collision with root package name */
    public final G2 f600a;

    static {
        long j2 = -1;
        long length = o3.class.getName().length();
        long j3 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j4 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j5 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j6 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j7 = (j6 | j5 | (j4 + j3)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j8 = (j7 >>> 48) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = (j7 >>> 32) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 16) + ((((j10 >>> 4) | j10) & 16711935) << 24);
        long j15 = (j7 >>> 16) & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        long j18 = j7 & 21845;
        long j19 = ((j18 >>> 1) | j18) & 858993459;
        long j20 = ((j19 >>> 2) | j19) & 252645135;
        int i = (((int) ((((j20 >>> 4) | j20) & 16711935) + (((((j17 >>> 4) | j17) & 16711935) << 8) | j14))) | 118256685) & (-1628396532);
        int length2 = (o3.class.getName().length() & (-1729068832)) | 65777;
        byte[] bArr = {-113, 77, -58, -108, -43, 72, -114, 8, -103, 42, -22, 121, -120, -36, -85, ((length2 & i) + (i | length2)) ^ 1628330806, 111, 102, 89, 111, 1, 4, 20};
        byte[] bArr2 = new byte[23];
        bArr2[0] = -42;
        bArr2[1] = 84;
        bArr2[2] = -110;
        bArr2[3] = 9;
        bArr2[4] = -91;
        bArr2[5] = 86;
        bArr2[6] = -45;
        bArr2[7] = 112;
        bArr2[8] = -29;
        bArr2[9] = 117;
        bArr2[10] = 113;
        bArr2[11] = 34;
        bArr2[12] = -48;
        bArr2[13] = -33;
        bArr2[14] = -84;
        bArr2[15] = -40;
        int i3 = ((~o3.class.getName().length()) | (-21284042)) & 411380744;
        int length3 = (o3.class.getName().length() & 1644430346) | 1645216258;
        int i4 = -i3;
        bArr2[2056597018 ^ (((length3 & (~i4)) * 2) - (length3 ^ i4))] = -13;
        bArr2[17] = 104;
        bArr2[18] = 26;
        bArr2[19] = 36;
        int i5 = ((~o3.class.getName().length()) | (-314180363)) & (-1589624523);
        long j21 = 11606658;
        long length4 = o3.class.getName().length() & 11606784;
        long b4 = c3.b((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j22 = (b4 >>> 48) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = (b4 >>> 32) & 43690;
        long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
        long j27 = ((j26 >>> 2) | j26) & 252645135;
        long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) + ((((j24 >>> 4) | j24) & 16711935) << 24);
        long j29 = (b4 >>> 16) & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        long j32 = b4 & 43690;
        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
        long j34 = ((j33 >>> 2) | j33) & 252645135;
        bArr2[(i5 + ((int) ((((j34 >>> 4) | j34) & 16711935) | (((((j31 >>> 4) | j31) & 16711935) << 8) + j28)))) ^ (-1578017885)] = 94;
        bArr2[21] = 114;
        bArr2[22] = 38;
        k(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr3 = new byte[18];
        bArr3[0] = 60;
        bArr3[1] = 16;
        bArr3[2] = -7;
        bArr3[3] = -113;
        bArr3[4] = 15;
        bArr3[5] = -111;
        bArr3[6] = 18;
        bArr3[7] = ((((~o3.class.getName().length()) | (-175625588)) & 1342441676) + (((o3.class.getName().length() | (-672399427)) + 672399427) | 672153603)) ^ (-2014595324);
        bArr3[8] = 85;
        bArr3[9] = -28;
        bArr3[10] = 0;
        bArr3[(((AbstractC0008a.f(o3.class, -1) | (-1242406717)) & 826409986) + ((o3.class.getName().length() & 136905988) | 1210646788)) ^ 2037056781] = -95;
        bArr3[12] = 9;
        bArr3[13] = -80;
        bArr3[14] = 111;
        bArr3[15] = 76;
        bArr3[16] = -111;
        bArr3[17] = 119;
        byte[] bArr4 = new byte[18];
        bArr4[0] = 71;
        bArr4[1] = -87;
        bArr4[2] = -127;
        bArr4[3] = 4;
        bArr4[4] = 79;
        bArr4[5] = 47;
        bArr4[6] = 96;
        long j35 = 1014454205;
        long f4 = AbstractC0008a.f(o3.class, -1);
        long b5 = c3.b((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j36 = (b5 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = ((j37 >>> 2) | j37) & 252645135;
        long j39 = (b5 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
        long j43 = (b5 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = b5 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = ((j47 >>> 2) | j47) & 252645135;
        bArr4[((((int) ((((j48 >>> 4) | j48) & 16711935) + (((((j45 >>> 4) | j45) & 16711935) << 8) + j42))) & 235311360) + ((o3.class.getName().length() & 38314048) | 273178696)) ^ 508490063] = -83;
        bArr4[8] = 14;
        bArr4[9] = -63;
        bArr4[10] = 76;
        bArr4[11] = -26;
        bArr4[12] = 73;
        bArr4[13] = 3;
        bArr4[14] = 27;
        bArr4[15] = ((((~o3.class.getName().length()) | 1164489709) & (-1325390719)) + ((o3.class.getName().length() & (-1340079070)) | 2097698)) ^ (-1323292957);
        bArr4[16] = -12;
        bArr4[17] = 14;
        k(bArr3, bArr4);
        new String(bArr3, charset).intern();
        byte[] bArr5 = new byte[18];
        bArr5[0] = 71;
        bArr5[1] = -118;
        bArr5[2] = -19;
        bArr5[3] = 80;
        bArr5[4] = -30;
        bArr5[5] = 82;
        bArr5[6] = -8;
        bArr5[7] = -115;
        bArr5[8] = 6;
        bArr5[9] = 57;
        bArr5[10] = -110;
        int i6 = ((~o3.class.getName().length()) | 2066805005) & (-2147093501);
        int length5 = o3.class.getName().length();
        bArr5[(-502924224) ^ (((((-1073411070) & length5) ^ 1644169288) + (length5 & 1073743872)) + i6)] = 106;
        bArr5[12] = 39;
        bArr5[13] = 70;
        bArr5[14] = 74;
        bArr5[15] = -13;
        bArr5[16] = 102;
        long length6 = o3.class.getName().length();
        long j49 = j6 + (j5 | j4 | j3) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j50 = (j49 >>> 48) & 21845;
        long j51 = (j50 | (j50 >>> 1)) & 858993459;
        long j52 = (j51 | (j51 >>> 2)) & 252645135;
        long j53 = (j49 >>> 32) & 21845;
        long j54 = ((j53 >>> 1) | j53) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        long j56 = ((((j55 >>> 4) | j55) & 16711935) << 16) + (((j52 | (j52 >>> 4)) & 16711935) << 24);
        long j57 = (j49 >>> 16) & 21845;
        long j58 = ((j57 >>> 1) | j57) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = j49 & 21845;
        long j61 = (j60 | (j60 >>> 1)) & 858993459;
        long j62 = (j61 | (j61 >>> 2)) & 252645135;
        bArr5[(((((int) (((j62 | (j62 >>> 4)) & 16711935) | (((((j59 >>> 4) | j59) & 16711935) << 8) + j56))) | (-515387200)) & 805524032) + ((o3.class.getName().length() & 268706320) | 176431121)) ^ 981955136] = 90;
        byte[] bArr6 = new byte[18];
        bArr6[0] = 14;
        bArr6[1] = 19;
        bArr6[2] = 110;
        bArr6[3] = 77;
        bArr6[4] = 116;
        bArr6[5] = 108;
        bArr6[6] = -119;
        bArr6[7] = -21;
        long j63 = 1567349774;
        long j64 = ~o3.class.getName().length();
        long b6 = c3.b((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j65 = (b6 >>> 48) & 43690;
        long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
        long j67 = (j66 | (j66 >>> 2)) & 252645135;
        long j68 = (b6 >>> 32) & 43690;
        long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
        long j70 = ((j69 >>> 2) | j69) & 252645135;
        long j71 = (((j67 | (j67 >>> 4)) & 16711935) << 24) | ((((j70 >>> 4) | j70) & 16711935) << 16);
        long j72 = (b6 >>> 16) & 43690;
        long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
        long j74 = ((j73 >>> 2) | j73) & 252645135;
        long j75 = b6 & 43690;
        long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
        long j77 = (j76 | (j76 >>> 2)) & 252645135;
        int length7 = (o3.class.getName().length() & 41088) | 277909696;
        int i7 = -(((int) (((j77 | (j77 >>> 4)) & 16711935) | j71 | ((((j74 >>> 4) | j74) & 16711935) << 8))) & 86125568);
        bArr6[364035272 ^ ((length7 ^ i7) - ((i7 & (~length7)) * 2))] = 80;
        bArr6[9] = -121;
        int i8 = ~o3.class.getName().length();
        long j78 = 2001956671;
        long length8 = (((231696265 | i8) + 1980852785) - (i8 | 2145349561)) + ((o3.class.getName().length() & 1917848884) | 21103876);
        long j79 = ((((((((j78 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j78 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j78 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j78 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j80 = (j79 >>> 48) & 21845;
        long j81 = (j80 | (j80 >>> 1)) & 858993459;
        long j82 = (j81 | (j81 >>> 2)) & 252645135;
        long j83 = (j79 >>> 32) & 21845;
        long j84 = ((j83 >>> 1) | j83) & 858993459;
        long j85 = ((j84 >>> 2) | j84) & 252645135;
        long j86 = ((((j85 >>> 4) | j85) & 16711935) << 16) + (((j82 | (j82 >>> 4)) & 16711935) << 24);
        long j87 = (j79 >>> 16) & 21845;
        long j88 = ((j87 >>> 1) | j87) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = j79 & 21845;
        long j91 = (j90 | (j90 >>> 1)) & 858993459;
        long j92 = (j91 | (j91 >>> 2)) & 252645135;
        bArr6[(int) (((j92 | (j92 >>> 4)) & 16711935) + ((((j89 >>> 4) | j89) & 16711935) << 8) + j86)] = -32;
        bArr6[11] = 49;
        bArr6[12] = 49;
        bArr6[13] = 95;
        bArr6[14] = 24;
        int i9 = ~o3.class.getName().length();
        long j93 = -1167809258;
        long length9 = (93389523 & (((~i9) & (-315755304)) + i9)) + ((o3.class.getName().length() & 9574915) | 1074419712);
        long j94 = ((((((((j93 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j93 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j93 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j93 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j95 = (j94 >>> 48) & 21845;
        long j96 = (j95 | (j95 >>> 1)) & 858993459;
        long j97 = (j96 | (j96 >>> 2)) & 252645135;
        long j98 = (j94 >>> 32) & 21845;
        long j99 = (j98 | (j98 >>> 1)) & 858993459;
        long j100 = (j99 | (j99 >>> 2)) & 252645135;
        long j101 = (((j100 | (j100 >>> 4)) & 16711935) << 16) + (((j97 | (j97 >>> 4)) & 16711935) << 24);
        long j102 = (j94 >>> 16) & 21845;
        long j103 = (j102 | (j102 >>> 1)) & 858993459;
        long j104 = (j103 | (j103 >>> 2)) & 252645135;
        long j105 = j94 & 21845;
        long j106 = (j105 | (j105 >>> 1)) & 858993459;
        long j107 = (j106 | (j106 >>> 2)) & 252645135;
        bArr6[15] = (int) (((j107 | (j107 >>> 4)) & 16711935) + (((j104 | (j104 >>> 4)) & 16711935) << 8) + j101);
        bArr6[16] = 15;
        bArr6[17] = 62;
        k(bArr5, bArr6);
        new String(bArr5, charset).intern();
    }

    public o3(Context context) {
        this.f600a = new G2(context);
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
        int i7 = ~o3.class.getName().length();
        int length3 = (((~(((o3.class.getName().length() | 70245657) | i7) - (i7 | (o3.class.getName().length() & (-70245658))))) & (-1979440632)) + ((o3.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(o3.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((o3.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~o3.class.getName().length()) | (-576567005)) & 276971586) + ((o3.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~o3.class.getName().length()) | (-1157759625)) & 1755853004) + ((o3.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~o3.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = o3.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~o3.class.getName().length()) | (-1064961)) + 689325073) + ((o3.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~o3.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = o3.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~o3.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (o3.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((o3.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~o3.class.getName().length();
                    int length11 = (161497089 & (((((o3.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((o3.class.getName().length() | i14) & 797295576))) + ((o3.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~o3.class.getName().length()) | (-1085986263)) & 1078327440) + ((o3.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~o3.class.getName().length();
                    int length12 = length5 >>> ((((~(((o3.class.getName().length() | 626856794) | i15) - ((o3.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((o3.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~o3.class.getName().length()) | 1248713193) & 826417528) + ((o3.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~o3.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (o3.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~o3.class.getName().length()) | (-1005965450)) & 153223237) + ((o3.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((o3.class.getName().length() & (~length6)) & i9)) + ((o3.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~o3.class.getName().length()) | (-30261291)) & (-1534000062)) + ((o3.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~o3.class.getName().length()) | (-23496740)) & 827084804) + ((o3.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~o3.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (o3.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~o3.class.getName().length()) | (-961655275)) & 25184460) + ((o3.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~o3.class.getName().length()) | 1233459797) & 125923146) + ((o3.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~o3.class.getName().length()) | (-7107622)) & 402932290) + ((o3.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((o3.class.getName().length() | length15) - (b4 | length15)) + I2.a(o3.class, b4) + (o3.class.getName().length() & length15);
                    int length17 = ((((~o3.class.getName().length()) | (-81143879)) & 438583424) + ((o3.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~o3.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((o3.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(o3.class, 568748773 | i24) + (o3.class.getName().length() & (-2105278367)))) + ((o3.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~o3.class.getName().length()) | (-1592082969)) & 140665109) + ((o3.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~o3.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((o3.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~o3.class.getName().length()) | (-180811308));
                    int length19 = (o3.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((o3.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | o3.class.getName().length()))));
                    int i29 = ((~o3.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (o3.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~o3.class.getName().length()) | 75364313) & 1242301609) + ((o3.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = o3.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((o3.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~o3.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((o3.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~o3.class.getName().length();
                    int length24 = 1409942802 & (((((o3.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | o3.class.getName().length()) & 91135407));
                    int length25 = (o3.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~o3.class.getName().length()) | (-537919489)) - (-806798471)) + ((o3.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~o3.class.getName().length()) | (-382746167)) & 102532165) + ((o3.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~o3.class.getName().length()) | (-6036961)) & 1233145505) + ((o3.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~o3.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = o3.class.getName().length() & 268460041;
                    i5 = (((((o3.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | o3.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = o3.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((o3.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~o3.class.getName().length()) | (-1883938358)) & (-738125179)) + ((o3.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~o3.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (o3.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(o3.class, -1) | (-532481)) - (-67641369)) + ((o3.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~o3.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((o3.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(o3.class, -1) | (-33554434)) - (-1107366402)) + ((o3.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(o3.class, -1) | (-167014194)) & 1157999680) + ((o3.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = o3.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((o3.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(o3.class, -1) | 114408723) & 1183666176;
                    int length33 = o3.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~o3.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = o3.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~o3.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (o3.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~o3.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((o3.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~o3.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (o3.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~o3.class.getName().length()) | 991120067) & (-2113137661)) + ((o3.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(o3.class, -1) | 314136709) & 371231304) + (((o3.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~o3.class.getName().length()) | 366661365) & 1344150018) + ((o3.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~o3.class.getName().length()) | (-1359635359)) & 49026131) + ((o3.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~o3.class.getName().length();
                    if (length3 > 0) {
                        int length38 = o3.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (o3.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~o3.class.getName().length()) | 1110430873) & 1241612298) + ((o3.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~o3.class.getName().length()) | 1603962366) & 25199440) + (((o3.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~o3.class.getName().length()) | (-1388708984)) & 706816128) + ((o3.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~o3.class.getName().length()) | 367288948) & 548745488;
                    int length41 = o3.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~o3.class.getName().length()) | 2113158628) & 1026558002) + ((o3.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~o3.class.getName().length()) | 715175224) & 136512788) + ((o3.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~o3.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = o3.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~o3.class.getName().length()) | (-1084937228)) & 438503696) + ((o3.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~o3.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((o3.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(o3.class, 1197735420 | i53) + (o3.class.getName().length() & 674349280))) + ((o3.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~o3.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (o3.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~o3.class.getName().length()) | (-171976913)) & 318775824) + ((o3.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~o3.class.getName().length()) | (-616910267)) & 1303391760) + ((o3.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~o3.class.getName().length()) | 1297715640) & 556926729) + ((o3.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~o3.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((o3.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~o3.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (o3.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void g(byte[] bArr, byte[] bArr2) {
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
    public static void j(byte[] bArr, byte[] bArr2) {
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
    public static void k(byte[] bArr, byte[] bArr2) {
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

    public final void a(String str) {
        byte[] bArr = new byte[18];
        bArr[0] = -9;
        bArr[1] = 120;
        bArr[2] = -48;
        int i = ((~o3.class.getName().length()) | 997041594) & 318834184;
        int length = o3.class.getName().length();
        bArr[(i + (1080557617 | (((o3.class.getName().length() | 1076363793) - (length | 1076363793)) + (AbstractC0008a.f(o3.class, length) + (o3.class.getName().length() & 1076363793))))) ^ 1399391802] = 37;
        int i3 = ((~o3.class.getName().length()) | (-803198225)) & 2047428784;
        int length2 = o3.class.getName().length();
        long j2 = 274754;
        long j3 = (705249362 | length2) - (length2 ^ 705249362);
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
        long j15 = ((((j14 >>> 4) | j14) & 16711935) << 8) + j11;
        long j16 = j4 & 43690;
        long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
        long j18 = (j17 | (j17 >>> 2)) & 252645135;
        int i4 = i3 + ((int) (((j18 | (j18 >>> 4)) & 16711935) | j15));
        long j19 = 2047703433;
        long j20 = i4;
        long j21 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j22 = (j21 >>> 48) & 21845;
        long j23 = (j22 | (j22 >>> 1)) & 858993459;
        long j24 = (j23 | (j23 >>> 2)) & 252645135;
        long j25 = (j21 >>> 32) & 21845;
        long j26 = ((j25 >>> 1) | j25) & 858993459;
        long j27 = ((j26 >>> 2) | j26) & 252645135;
        long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) + (((j24 | (j24 >>> 4)) & 16711935) << 24);
        long j29 = (j21 >>> 16) & 21845;
        long j30 = ((j29 >>> 1) | j29) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        long j32 = j21 & 21845;
        long j33 = (j32 | (j32 >>> 1)) & 858993459;
        long j34 = (j33 | (j33 >>> 2)) & 252645135;
        bArr[4] = (int) (((j34 | (j34 >>> 4)) & 16711935) + (((((j31 >>> 4) | j31) & 16711935) << 8) | j28));
        bArr[5] = 126;
        bArr[6] = 122;
        bArr[7] = 104;
        bArr[8] = 82;
        bArr[9] = 1548013253 ^ ((729135 - ((~(o3.class.getName().length() & (-1599074012))) | 729136)) + (((~o3.class.getName().length()) | 1397312123) & (-1548742323)));
        bArr[10] = 34;
        bArr[11] = 96;
        bArr[12] = 24;
        bArr[13] = 112;
        bArr[14] = 111;
        bArr[15] = 65;
        bArr[16] = -70;
        bArr[17] = 33;
        byte[] bArr2 = new byte[18];
        bArr2[0] = 126;
        long j35 = -1;
        long length3 = o3.class.getName().length();
        long j36 = ((((((((255 & (j35 >>> 24)) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j37 = (j36 >>> 48) & 21845;
        long j38 = (j37 | (j37 >>> 1)) & 858993459;
        long j39 = (j38 | (j38 >>> 2)) & 252645135;
        long j40 = (j36 >>> 32) & 21845;
        long j41 = (j40 | (j40 >>> 1)) & 858993459;
        long j42 = (j41 | (j41 >>> 2)) & 252645135;
        long j43 = (((j42 | (j42 >>> 4)) & 16711935) << 16) + (((j39 | (j39 >>> 4)) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 21845;
        long j45 = (j44 | (j44 >>> 1)) & 858993459;
        long j46 = (j45 | (j45 >>> 2)) & 252645135;
        long j47 = j36 & 21845;
        long j48 = (j47 | (j47 >>> 1)) & 858993459;
        long j49 = (j48 | (j48 >>> 2)) & 252645135;
        bArr2[1] = (((((int) (((((j46 | (j46 >>> 4)) & 16711935) << 8) | j43) | ((j49 | (j49 >>> 4)) & 16711935))) | (-566508058)) & (-2109554144)) + ((o3.class.getName().length() & 79692289) | 92275777)) ^ (-2017278432);
        bArr2[2] = -88;
        bArr2[3] = 90;
        bArr2[4] = -5;
        bArr2[5] = 63;
        bArr2[6] = 7;
        bArr2[7] = 80;
        bArr2[8] = 28;
        bArr2[9] = 6;
        bArr2[10] = 49;
        bArr2[11] = 43;
        bArr2[12] = 96;
        bArr2[13] = 73;
        bArr2[(-479311366) ^ ((((~o3.class.getName().length()) | 173859119) & (-479459132)) + ((o3.class.getName().length() & (-517862944)) | 147760))] = -11;
        bArr2[15] = 54;
        bArr2[16] = -45;
        bArr2[17] = 69;
        k(bArr, bArr2);
        this.f600a.d(new String(bArr, StandardCharsets.UTF_8).intern(), str);
    }

    public final void b(PublicKey publicKey) {
        String encodeToString = Base64.encodeToString(publicKey.getEncoded(), 2);
        byte[] bArr = new byte[18];
        bArr[0] = 26;
        bArr[1] = 76;
        bArr[2] = (-1873804394) ^ (((((o3.class.getName().length() | (-169973809)) - (-169973809)) | 539153440) - (~((AbstractC0008a.f(o3.class, -1) | (-980618938)) & 1334650896))) - 1);
        bArr[3] = -20;
        bArr[4] = 29;
        bArr[5] = ((((~o3.class.getName().length()) | 1532040739) & 1159730866) + ((o3.class.getName().length() & 112328912) | 580517952)) ^ (-1740248758);
        bArr[6] = 41;
        bArr[7] = 19;
        bArr[8] = -43;
        bArr[9] = 99;
        bArr[10] = 114;
        bArr[11] = -46;
        bArr[12] = -10;
        int i = ((~o3.class.getName().length()) | (-2123105785)) & (-2063247200);
        int length = (o3.class.getName().length() & 201589152) | 438436096;
        bArr[13] = (((length & i) * 2) + (length ^ i)) ^ (-1624811131);
        bArr[14] = 16;
        bArr[15] = 102;
        int i3 = ~o3.class.getName().length();
        int i4 = ~((o3.class.getName().length() & 1077822980) | 1073906208);
        int i5 = -(((i3 | 2139339193) + 339567636) - (i3 | 2143288765));
        int a2 = V2.a(~i5, i4, i4 + i5 + 1);
        bArr[B0.a((~a2) | 1413473828, 1413473828 - a2)] = 12;
        bArr[17] = 30;
        byte[] bArr2 = new byte[18];
        int i6 = ((~o3.class.getName().length()) | (-334447716)) & 201757080;
        int length2 = o3.class.getName().length();
        bArr2[0] = (i6 + ((((o3.class.getName().length() | 3031104) - (length2 | 3031104)) + (AbstractC0008a.f(o3.class, length2) + (o3.class.getName().length() & 3031104))) | 1119371328)) ^ (-1321128426);
        bArr2[1] = 103;
        bArr2[2] = 105;
        bArr2[3] = 116;
        bArr2[4] = -60;
        bArr2[5] = -37;
        bArr2[6] = 27;
        int i7 = ((~o3.class.getName().length()) | (-1691460292)) & (-387954942);
        long j2 = 269320321;
        long length3 = o3.class.getName().length() & 1892516482;
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        int i8 = (int) ((((j16 >>> 4) | j16) & 16711935) | ((((j13 >>> 4) | j13) & 16711935) << 8) | j10);
        bArr2[7] = (((i7 & i8) * 2) + (i8 ^ i7)) ^ (-118634569);
        bArr2[8] = -56;
        bArr2[9] = 83;
        bArr2[10] = 58;
        bArr2[11] = -35;
        int i9 = ~o3.class.getName().length();
        long j17 = 75644930;
        long length4 = o3.class.getName().length() & 536870914;
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j29 = ((((j28 >>> 4) | j28) & 16711935) << 8) + j25;
        long j30 = j18 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = (j31 | (j31 >>> 2)) & 252645135;
        bArr2[(-1532836818) ^ (((((-1863587985) | i9) - 1608481760) - (i9 | (-1326717073))) + ((int) (((j32 | (j32 >>> 4)) & 16711935) + j29)))] = -87;
        bArr2[13] = -38;
        bArr2[14] = 91;
        bArr2[15] = -15;
        bArr2[16] = -124;
        bArr2[17] = 96;
        c(bArr, bArr2);
        this.f600a.d(new String(bArr, StandardCharsets.UTF_8).intern(), encodeToString);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0236. Please report as an issue. */
    public final boolean d() {
        boolean z3;
        int i = 8;
        byte[] bArr = {-67, -124, 21, 4, 123, 89, 114, -64, 39, -19, -28, -55, 59, 109, -82, -76, -9, -76};
        byte[] bArr2 = new byte[18];
        bArr2[0] = -33;
        bArr2[1] = -19;
        long j2 = -50915965;
        long f4 = AbstractC0008a.f(o3.class, -1);
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        bArr2[((((int) ((((((j13 >>> 4) | j13) & 16711935) << 8) | j10) | (((j16 >>> 4) | j16) & 16711935))) & 507889253) + ((o3.class.getName().length() & 1116785252) | 1085286658)) ^ 1593175909] = 123;
        bArr2[3] = 96;
        bArr2[4] = 18;
        bArr2[5] = 55;
        bArr2[6] = 21;
        bArr2[7] = -97;
        bArr2[8] = 70;
        bArr2[9] = -125;
        bArr2[10] = Byte.MIN_VALUE;
        bArr2[11] = -69;
        bArr2[12] = 84;
        bArr2[13] = 4;
        bArr2[14] = -54;
        bArr2[15] = -21;
        bArr2[16] = -98;
        bArr2[17] = -48;
        byte[] bArr3 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1850458006;
        byte[] bArr4 = null;
        while (true) {
            int i6 = ((16777216 & i5) * (i5 | 16777216)) + (((-16777217) & i5) * ((~i5) & 16777216));
            int i7 = i5 >>> i;
            int i8 = (i7 - 1) - ((~i6) | i7);
            int i9 = (-1700147435) - ((i8 & 2) | (2028104049 - i8));
            int i10 = (-1363443157) ^ ((~i9) + ((i9 | 1) * 2));
            int i11 = 614229416;
            int i12 = -1396193641;
            switch (i10) {
                case -1940167324:
                    byte b4 = bArr3[i3];
                    int i13 = ((byte) 0) - b4;
                    bArr3[i3] = (byte) (((byte) (b4 & (~i13))) - ((byte) ((~b4) & i13)));
                    i5 = i11;
                    i = 8;
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
                    i = 8;
                case 399486784:
                    break;
                case 585276366:
                    i5 = 1985663266;
                    bArr4 = bArr;
                    i4 = 0;
                    bArr3 = bArr2;
                    i = 8;
                case 1733787683:
                    byte b5 = bArr4[i3];
                    byte b6 = bArr3[i3];
                    bArr4[i3] = (byte) (((byte) (b6 + b5)) - ((byte) (((byte) 2) * ((byte) (b6 & b5)))));
                    i4 = (i3 ^ 1) + ((i3 & 1) * 2);
                    if ((((i4 > bArr4.length ? 1 : (i4 == bArr4.length ? 0 : -1)) >>> 31) & 1) != 0) {
                        i5 = 1985663266;
                    } else {
                        i5 = -1396193641;
                    }
                    i = 8;
                default:
                    i5 = -1396193641;
            }
            return this.f600a.f(new String(bArr, StandardCharsets.UTF_8).intern());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x094d, code lost:
    
        if (r5 != 0) goto L28;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x08bc. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            Method dump skipped, instructions count: 2762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.o3.e():boolean");
    }

    public final String f() {
        byte[] bArr = new byte[18];
        bArr[0] = 26;
        long j2 = -791504755;
        long j3 = ~o3.class.getName().length();
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        bArr[((((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) & 183376384) + ((o3.class.getName().length() & 170656258) | R.attr.sharedUserId)) ^ 200219146] = 96;
        bArr[2] = -118;
        bArr[3] = (((AbstractC0008a.f(o3.class, -1) | (-856085483)) & (-521793278)) + ((o3.class.getName().length() & 637964546) | 100696097)) ^ 421097177;
        bArr[4] = 7;
        bArr[5] = -48;
        bArr[6] = 91;
        bArr[7] = -49;
        int i = ((~o3.class.getName().length()) | (-807540563)) & 235277321;
        long j18 = 8553536;
        long length = o3.class.getName().length();
        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
        long j33 = 293650512;
        long j34 = (int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26));
        long j35 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j36 = (j35 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = (j37 | (j37 >>> 2)) & 252645135;
        long j39 = (j35 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = (((j38 | (j38 >>> 4)) & 16711935) << 24) | ((((j41 >>> 4) | j41) & 16711935) << 16);
        long j43 = (j35 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = j35 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = (j47 | (j47 >>> 2)) & 252645135;
        bArr[8] = 528927870 ^ (i + ((int) (((j48 | (j48 >>> 4)) & 16711935) | (j42 | ((((j45 >>> 4) | j45) & 16711935) << 8)))));
        bArr[9] = 109;
        bArr[10] = 0;
        bArr[11] = 106;
        bArr[12] = 16;
        long j49 = 1658340732;
        long j50 = ~o3.class.getName().length();
        long b4 = c3.b((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j51 = (b4 >>> 48) & 43690;
        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = (b4 >>> 32) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) | ((((j53 >>> 4) | j53) & 16711935) << 24);
        long j58 = (b4 >>> 16) & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = ((((j60 >>> 4) | j60) & 16711935) << 8) + j57;
        long j62 = b4 & 43690;
        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
        long j64 = (j63 | (j63 >>> 2)) & 252645135;
        int length2 = o3.class.getName().length();
        long j65 = 1896382464;
        long j66 = (length2 | 1627985920) - (length2 ^ 1627985920);
        long b5 = c3.b((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j67 = (b5 >>> 48) & 43690;
        long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
        long j69 = ((j68 >>> 2) | j68) & 252645135;
        long j70 = (b5 >>> 32) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = ((j71 >>> 2) | j71) & 252645135;
        long j73 = ((((j72 >>> 4) | j72) & 16711935) << 16) + ((((j69 >>> 4) | j69) & 16711935) << 24);
        long j74 = (b5 >>> 16) & 43690;
        long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
        long j76 = ((j75 >>> 2) | j75) & 252645135;
        long j77 = b5 & 43690;
        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
        long j79 = ((j78 >>> 2) | j78) & 252645135;
        bArr[13] = ((((int) (((j64 | (j64 >>> 4)) & 16711935) + j61)) & 9509960) + ((int) ((((j79 >>> 4) | j79) & 16711935) + (((((j76 >>> 4) | j76) & 16711935) << 8) | j73)))) ^ (-1905892354);
        bArr[14] = -51;
        bArr[15] = -117;
        long j80 = -125743463;
        long j81 = ~o3.class.getName().length();
        long b6 = c3.b((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j82 = (b6 >>> 48) & 43690;
        long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
        long j84 = ((j83 >>> 2) | j83) & 252645135;
        long j85 = (b6 >>> 32) & 43690;
        long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
        long j87 = ((j86 >>> 2) | j86) & 252645135;
        long j88 = ((((j87 >>> 4) | j87) & 16711935) << 16) + ((((j84 >>> 4) | j84) & 16711935) << 24);
        long j89 = (b6 >>> 16) & 43690;
        long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
        long j91 = ((j90 >>> 2) | j90) & 252645135;
        long j92 = b6 & 43690;
        long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
        long j94 = ((j93 >>> 2) | j93) & 252645135;
        long j95 = 1645220609;
        long j96 = (int) ((((j94 >>> 4) | j94) & 16711935) + (((((j91 >>> 4) | j91) & 16711935) << 8) | j88));
        long j97 = ((((((((j95 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j95 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j95 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j95 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j98 = (j97 >>> 48) & 43690;
        long j99 = ((j98 >>> 2) | (j98 >>> 1)) & 858993459;
        long j100 = (j99 | (j99 >>> 2)) & 252645135;
        long j101 = (j97 >>> 32) & 43690;
        long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
        long j103 = (j102 | (j102 >>> 2)) & 252645135;
        long j104 = (((j103 | (j103 >>> 4)) & 16711935) << 16) + (((j100 | (j100 >>> 4)) & 16711935) << 24);
        long j105 = (j97 >>> 16) & 43690;
        long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
        long j107 = (j106 | (j106 >>> 2)) & 252645135;
        long j108 = j97 & 43690;
        long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
        long j110 = (j109 | (j109 >>> 2)) & 252645135;
        int length3 = o3.class.getName().length() & 35131714;
        bArr[16] = 1914180421 ^ ((((~length3) & 268959810) + length3) + ((int) (((j110 | (j110 >>> 4)) & 16711935) + ((((j107 | (j107 >>> 4)) & 16711935) << 8) | j104))));
        bArr[17] = -32;
        g(bArr, new byte[]{-36, 36, -110, 56, -62, -45, -86, 110, -86, 52, 22, -66, -37, -54, 91, -79, 111, -124});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        G2 g22 = this.f600a;
        if (!g22.f(intern)) {
            return null;
        }
        int length4 = (((~o3.class.getName().length()) | (-1565375895)) & (-2090424050)) + ((o3.class.getName().length() & 29681926) | 815284224);
        byte[] bArr2 = {-90, -20, 111, 88, 62, -45, 93, 42, B0.a((~length4) | (-1275139795), (-1275139795) - length4), 68, -23, -14, -34, 64, -63, -21, 122, -56};
        int i3 = ~o3.class.getName().length();
        g(bArr2, new byte[]{40, ((((o3.class.getName().length() & 805331968) | 813907968) - (~(((i3 + (((-i3) - 1) | 1384349190)) - 1384349190) & 1582536))) - 1) ^ (-815490437), -113, -34, -117, -82, -88, -45, -90, 95, 63, 39, -19, 71, 87, 17, 19, -84});
        return g22.c(new String(bArr2, charset).intern());
    }

    public final String h() {
        int i = ((~o3.class.getName().length()) | (-411371887)) & 743457377;
        int length = (o3.class.getName().length() & 167839840) | (-1037760510);
        byte[] bArr = new byte[(((i & length) * 2) + (length ^ i)) ^ (-294303116)];
        bArr[0] = -7;
        bArr[1] = -87;
        int i3 = ((~o3.class.getName().length()) | (-438310186)) & (-1063777717);
        int length2 = o3.class.getName().length() & 539001001;
        bArr[2] = S.a(length2, ((-length2) - 1) | (-593596577), 593596577, i3) ^ 470181203;
        bArr[3] = -60;
        bArr[4] = 54;
        bArr[5] = -91;
        bArr[6] = -23;
        bArr[7] = 82;
        bArr[8] = -95;
        bArr[9] = 23;
        bArr[10] = 61;
        bArr[11] = -39;
        bArr[12] = -51;
        bArr[13] = 113;
        bArr[14] = -63;
        bArr[15] = 71;
        bArr[16] = -11;
        bArr[17] = 12;
        bArr[18] = -50;
        bArr[19] = 100;
        bArr[20] = -60;
        bArr[21] = -6;
        bArr[22] = 87;
        byte[] bArr2 = new byte[23];
        bArr2[0] = -101;
        bArr2[1] = -64;
        bArr2[2] = -42;
        bArr2[3] = -96;
        bArr2[4] = 95;
        bArr2[5] = -53;
        bArr2[6] = -114;
        bArr2[((((~o3.class.getName().length()) | 1280732896) & 1837139812) + ((o3.class.getName().length() & 835223836) | 275253272)) ^ 2112393083] = 13;
        bArr2[8] = -62;
        bArr2[9] = 120;
        bArr2[10] = 80;
        bArr2[11] = -87;
        bArr2[12] = -94;
        bArr2[13] = 2;
        bArr2[14] = -88;
        long j2 = -1375219241;
        long j3 = ~o3.class.getName().length();
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
        int length3 = (((int) ((((j17 >>> 4) | j17) & 16711935) + ((((j14 >>> 4) | j14) & 16711935) << 8) + j11)) & 71308305) + ((o3.class.getName().length() & 6358016) | 304152576);
        long j18 = 375460898;
        long j19 = length3;
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j21 = (j20 >>> 48) & 21845;
        long j22 = ((j21 >>> 1) | j21) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 21845;
        long j25 = ((j24 >>> 1) | j24) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 21845;
        long j29 = ((j28 >>> 1) | j28) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 21845;
        long j32 = ((j31 >>> 1) | j31) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        bArr2[15] = (int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) | j27));
        bArr2[16] = -112;
        bArr2[17] = 83;
        bArr2[18] = -89;
        bArr2[19] = 0;
        bArr2[20] = -101;
        bArr2[21] = -116;
        bArr2[22] = 101;
        j(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        G2 g22 = this.f600a;
        if (!g22.f(intern)) {
            return null;
        }
        int i4 = ((~o3.class.getName().length()) | 1571020639) & (-928972024);
        int length4 = o3.class.getName().length();
        byte[] bArr3 = new byte[(i4 + (((length4 | (-2113770496)) - (length4 ^ (-2113770496))) | 100822019)) ^ (-828149988)];
        bArr3[0] = 76;
        bArr3[1] = -124;
        bArr3[2] = 67;
        bArr3[3] = 3;
        bArr3[4] = 3;
        bArr3[5] = 13;
        bArr3[6] = -39;
        bArr3[7] = -43;
        bArr3[8] = 69;
        bArr3[9] = -66;
        bArr3[10] = 86;
        bArr3[11] = 67;
        int i5 = ~o3.class.getName().length();
        int length5 = o3.class.getName().length();
        bArr3[12] = ((((i5 + (((-i5) - 1) | (-885058442))) + 885058442) & 970063923) + (69993472 | ((221905970 | length5) - (length5 ^ 221905970)))) ^ 1040057422;
        bArr3[13] = 16;
        bArr3[14] = 27;
        bArr3[15] = 115;
        bArr3[16] = -55;
        bArr3[17] = 101;
        bArr3[18] = 14;
        int i6 = ~o3.class.getName().length();
        long j34 = 1611693329;
        long j35 = (445466896 + i6) - (i6 & 445466896);
        long j36 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j37 = (j36 >>> 48) & 43690;
        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
        long j39 = (j38 | (j38 >>> 2)) & 252645135;
        long j40 = (j36 >>> 32) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = (((j39 | (j39 >>> 4)) & 16711935) << 24) | ((((j42 >>> 4) | j42) & 16711935) << 16);
        long j44 = (j36 >>> 16) & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = j36 & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = (j48 | (j48 >>> 2)) & 252645135;
        bArr3[(-527401054) ^ (((int) (((j49 | (j49 >>> 4)) & 16711935) + (((((j46 >>> 4) | j46) & 16711935) << 8) + j43))) + ((o3.class.getName().length() & 1620063233) | (-2139094368)))] = -45;
        bArr3[20] = -4;
        bArr3[21] = 46;
        bArr3[22] = -45;
        j(bArr3, new byte[]{46, -19, 45, 103, 106, 99, -66, -118, 38, -47, 59, 51, 18, 99, 114, 7, -84, 58, 103, -73, -93, 88, -31});
        return g22.c(new String(bArr3, charset).intern());
    }

    public final PublicKey i() {
        byte[] bArr = new byte[18];
        bArr[0] = 118;
        bArr[1] = -11;
        bArr[2] = -93;
        bArr[3] = -32;
        bArr[4] = -96;
        bArr[5] = -7;
        bArr[6] = 51;
        bArr[7] = -65;
        bArr[8] = -90;
        bArr[9] = -121;
        bArr[10] = 115;
        bArr[11] = -114;
        int i = ((~o3.class.getName().length()) | (-657044562)) & 234977330;
        int length = o3.class.getName().length();
        bArr[12] = (i + (((length | 109129809) - (length ^ 109129809)) | 11534657)) ^ 246511894;
        int f4 = (AbstractC0008a.f(o3.class, -1) | 1527942265) & 1434636684;
        int length2 = (o3.class.getName().length() & 79712662) | 4456979;
        long j2 = 1439093650;
        long j3 = ((length2 & f4) * 2) + (length2 ^ f4);
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j5 = (j4 >>> 48) & 21845;
        long j6 = ((j5 >>> 1) | j5) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        bArr[(int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))] = -69;
        bArr[14] = 11;
        bArr[15] = 10;
        bArr[16] = 36;
        bArr[17] = -117;
        byte[] bArr2 = new byte[18];
        bArr2[0] = -3;
        bArr2[1] = -53;
        bArr2[2] = -73;
        bArr2[((((~o3.class.getName().length()) | 1541236897) & 19341480) + ((o3.class.getName().length() & 2232600) | (-2080368368))) ^ (-2061026885)] = -99;
        int i3 = ((~o3.class.getName().length()) | (-553648385)) - (-558055689);
        int length3 = (o3.class.getName().length() & 830505728) | 411075200;
        int i4 = -i3;
        int i5 = i4 | length3;
        bArr2[4] = ((i5 - (i4 * 2)) + ((i4 ^ length3) ^ i5)) ^ (-969130950);
        bArr2[5] = -57;
        bArr2[6] = 62;
        bArr2[7] = -7;
        bArr2[8] = -65;
        bArr2[9] = 34;
        bArr2[10] = -4;
        bArr2[11] = -6;
        bArr2[12] = -11;
        bArr2[13] = 7;
        bArr2[14] = 63;
        long j18 = 142083077;
        long j19 = (~o3.class.getName().length()) | (-63716075);
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) | ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = (j32 | (j32 >>> 2)) & 252645135;
        bArr2[15] = (((int) (((j33 | (j33 >>> 4)) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) + ((o3.class.getName().length() & 13238432) | 8880288)) ^ 150963423;
        bArr2[16] = 65;
        bArr2[17] = -14;
        k(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        G2 g22 = this.f600a;
        if (!g22.f(intern)) {
            return null;
        }
        byte[] bArr3 = {-106, -34, 59, 89, 47, 122, Byte.MIN_VALUE, -96, 62, 65, 45, -88, -18, 84, 97, 114, 46, -40};
        byte[] bArr4 = new byte[18];
        bArr4[0] = -35;
        bArr4[1] = -25;
        int i6 = ((~o3.class.getName().length()) | (-1008329039)) & 39933200;
        int i7 = (-(D1.a(i6, (o3.class.getName().length() & 152158465) | 152084483) | 2)) - (i6 * 3);
        bArr4[2] = (i7 + 192017709) - (((i7 + 1) & 192017708) * 2);
        bArr4[3] = 86;
        bArr4[((((~o3.class.getName().length()) | (-1073755393)) - (-1342485899)) + ((o3.class.getName().length() & 1090533124) | 152044100)) ^ 1494529994] = 47;
        bArr4[5] = 68;
        bArr4[6] = -47;
        bArr4[7] = 24;
        bArr4[8] = 55;
        bArr4[9] = 100;
        bArr4[10] = 57;
        bArr4[11] = -35;
        bArr4[12] = 112;
        bArr4[13] = 103;
        bArr4[14] = 40;
        bArr4[15] = 50;
        bArr4[16] = 75;
        bArr4[17] = -95;
        k(bArr3, bArr4);
        byte[] decode = Base64.decode(g22.c(new String(bArr3, charset).intern()), 2);
        try {
            byte[] bArr5 = {30, -93, 90};
            k(bArr5, new byte[]{76, -16, 27, -121, -30, -115, 85, -48});
            return KeyFactory.getInstance(new String(bArr5, charset).intern()).generatePublic(new X509EncodedKeySpec(decode));
        } catch (Exception unused) {
            return null;
        }
    }
}
