package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class A {
    public static long a(long j2) {
        short s3 = (short) (j2 & 65535);
        short s4 = (short) ((j2 >>> 16) & 65535);
        short s5 = (short) (s3 + s4);
        short s6 = (short) (s4 ^ s3);
        return ((((short) ((s6 >>> 22) | (s6 << 10))) | (((short) (((short) ((s5 >>> 23) | (s5 << 9))) + s3)) << 16)) << 16) | ((short) (((short) (((short) ((s3 << 13) | (s3 >>> 19))) ^ s6)) ^ (s6 << 5)));
    }

    public static String b(G0.l lVar) {
        int i = ~A.class.getName().length();
        int i3 = ~(((A.class.getName().length() | (-1627074779)) | i) - (i | (A.class.getName().length() & 1627074778)));
        byte[] bArr = {46, 91, 29, -41, 114, (-1676082233) ^ ((((A.class.getName().length() | 593786949) - (i3 | 593786949)) + (AbstractC0008a.f(A.class, i3) + (A.class.getName().length() & 593786949))) + ((A.class.getName().length() & 1124355077) | 1082295312))};
        c(bArr, new byte[]{-79, 39, -31, 95, (((AbstractC0008a.f(A.class, -1) | 2022699877) & 683949314) + ((A.class.getName().length() & 1081085442) | (-1070530008))) ^ (-386580687), -11, -34, 81});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(lVar, new String(bArr, charset).intern());
        StringBuilder sb = new StringBuilder();
        byte[] bArr2 = new byte[4];
        bArr2[0] = -89;
        bArr2[1] = -57;
        bArr2[2] = 14;
        long j2 = 1786323649;
        long j3 = ~A.class.getName().length();
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
        long j18 = -2012807160;
        long length = A.class.getName().length() & (-1996089344);
        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
        bArr2[(-1955645429) ^ ((((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) & 57161728) + ((int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26))))] = 124;
        byte[] bArr3 = new byte[8];
        bArr3[0] = 37;
        bArr3[1] = -64;
        bArr3[2] = -20;
        bArr3[3] = -78;
        bArr3[((((~A.class.getName().length()) | 141448574) & 2101642371) + ((A.class.getName().length() & 1965064353) | (-2145386440))) ^ (-43744065)] = 51;
        int i4 = ((~A.class.getName().length()) | 1851947987) & (-1505703606);
        long j33 = 159659041;
        long length2 = A.class.getName().length() & (-2012965848);
        long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
        bArr3[(i4 + ((int) ((((((j44 >>> 4) | j44) & 16711935) << 8) | j41) | (((j47 >>> 4) | j47) & 16711935)))) ^ (-1346044562)] = -71;
        bArr3[6] = -119;
        bArr3[7] = 103;
        c(bArr2, bArr3);
        sb.append(new String(bArr2, charset).intern());
        byte[] bArr4 = {33, -114, -4, 101};
        byte[] bArr5 = new byte[8];
        long j48 = -1;
        long length3 = A.class.getName().length();
        long j49 = ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j50 = (((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j51 = (((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j52 = (j51 | j50 | j49) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        bArr5[(-2009379418) ^ ((((137364640 & r10) - 2144335612) - (A.class.getName().length() & 3145728)) + ((((int) ((((j65 >>> 4) | j65) & 16711935) | (((((j62 >>> 4) | j62) & 16711935) << 8) | j59))) | 1398788615) & 134956194))] = -85;
        bArr5[1] = 14;
        bArr5[2] = 2;
        int i5 = ~A.class.getName().length();
        int i6 = (~(((A.class.getName().length() | (-170047882)) | i5) - (i5 | (A.class.getName().length() & 170047881)))) & 37929568;
        long j66 = 142606345;
        long length4 = A.class.getName().length() & 12599904;
        long j67 = (((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j78 = ((((j77 >>> 4) | j77) & 16711935) << 8) + j74;
        long j79 = j67 & 43690;
        long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
        long j81 = (j80 | (j80 >>> 2)) & 252645135;
        bArr5[180535914 ^ ((((int) (((j81 | (j81 >>> 4)) & 16711935) | j78)) + (~(-i6))) + 1)] = -92;
        bArr5[4] = -53;
        bArr5[5] = -72;
        bArr5[6] = -77;
        bArr5[7] = 55;
        c(bArr4, bArr5);
        sb.append(new String(bArr4, charset).intern());
        byte[] bArr6 = new byte[4];
        bArr6[0] = -7;
        long j82 = -340873671;
        long length5 = (((~A.class.getName().length()) | (-1421253671)) & (-1557263864)) + ((A.class.getName().length() & 1210461185) | 1216390145);
        long j83 = ((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j84 = (j83 >>> 48) & 21845;
        long j85 = ((j84 >>> 1) | j84) & 858993459;
        long j86 = ((j85 >>> 2) | j85) & 252645135;
        long j87 = (j83 >>> 32) & 21845;
        long j88 = ((j87 >>> 1) | j87) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = ((((j89 >>> 4) | j89) & 16711935) << 16) | ((((j86 >>> 4) | j86) & 16711935) << 24);
        long j91 = (j83 >>> 16) & 21845;
        long j92 = ((j91 >>> 1) | j91) & 858993459;
        long j93 = ((j92 >>> 2) | j92) & 252645135;
        long j94 = j83 & 21845;
        long j95 = ((j94 >>> 1) | j94) & 858993459;
        long j96 = ((j95 >>> 2) | j95) & 252645135;
        bArr6[1] = (int) ((((j96 >>> 4) | j96) & 16711935) + (((((j93 >>> 4) | j93) & 16711935) << 8) | j90));
        bArr6[2] = 112;
        bArr6[((((~A.class.getName().length()) | 2093176473) & 402852096) + ((A.class.getName().length() & 4196609) | (-1606418431))) ^ (-1203566334)] = -110;
        c(bArr6, new byte[]{-13, 107, -114, -104, -51, 84, ((((~A.class.getName().length()) | (-1073793033)) - (-1640024073)) + ((A.class.getName().length() & 1075890188) | (-2078277628))) ^ (-438253529), -117});
        sb.append(new String(bArr6, charset).intern());
        byte[] bArr7 = {-79, -71, 0, 16};
        c(bArr7, new byte[]{59, -46, 30, 30, -8, -61, -10, 76});
        sb.append(new String(bArr7, charset).intern());
        String sb2 = sb.toString();
        byte[] bArr8 = new byte[13];
        bArr8[0] = -114;
        bArr8[1] = -122;
        bArr8[2] = 45;
        bArr8[3] = 69;
        bArr8[4] = 67;
        bArr8[5] = 117;
        bArr8[6] = 88;
        bArr8[7] = -39;
        bArr8[8] = 113;
        long length6 = A.class.getName().length();
        long j97 = (j51 | (j50 + j49)) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j98 = (j97 >>> 48) & 21845;
        long j99 = (j98 | (j98 >>> 1)) & 858993459;
        long j100 = (j99 | (j99 >>> 2)) & 252645135;
        long j101 = (j97 >>> 32) & 21845;
        long j102 = ((j101 >>> 1) | j101) & 858993459;
        long j103 = ((j102 >>> 2) | j102) & 252645135;
        long j104 = (((j100 | (j100 >>> 4)) & 16711935) << 24) | ((((j103 >>> 4) | j103) & 16711935) << 16);
        long j105 = (j97 >>> 16) & 21845;
        long j106 = ((j105 >>> 1) | j105) & 858993459;
        long j107 = ((j106 >>> 2) | j106) & 252645135;
        long j108 = j97 & 21845;
        long j109 = (j108 | (j108 >>> 1)) & 858993459;
        long j110 = (j109 | (j109 >>> 2)) & 252645135;
        int i7 = (((int) (((j110 | (j110 >>> 4)) & 16711935) + ((((j107 >>> 4) | j107) & 16711935) << 8) + j104)) | (-1552560704)) & (-1937599261);
        int length7 = ((A.class.getName().length() | (-210898996)) - (-210898996)) | 18352144;
        bArr8[D.a(i7, 3, -(D1.a(i7, length7) | (length7 & 2)), 1) ^ (-1919247110)] = 15;
        bArr8[10] = -65;
        bArr8[11] = 31;
        bArr8[12] = 33;
        int i8 = ((~A.class.getName().length()) | 1944722177) & 12747521;
        int length8 = A.class.getName().length() & 537428000;
        int i9 = ((~length8) & (-1607991132)) + length8 + i8;
        c(bArr8, new byte[]{70, 27, -52, -45, (i9 | 1595243568) - (1595243568 & i9), 11, -92, 92, 61, -45, 30, -84, 8});
        kotlin.jvm.internal.j.d(sb2, new String(bArr8, charset).intern());
        return sb2;
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x002a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x018b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String[][]] */
    public static C0084t0 d(G0.l lVar) {
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        String[] strArr7;
        String[] strArr8;
        boolean z6;
        int i3;
        boolean z7;
        int i4;
        String[] strArr9;
        String[] strArr10;
        String[] strArr11;
        G0.l lVar2 = lVar;
        int i5 = 0;
        String[] strArr12 = new String[0];
        String[] strArr13 = new String[0];
        char c4 = 59763;
        boolean z8 = false;
        boolean z9 = false;
        int i6 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (true) {
            byte[] bArr = null;
            switch (c4) {
                case 1276:
                    lVar2 = lVar;
                    c4 = 11433;
                    z9 = true;
                case 58889:
                    String[] strArr14 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    if (strArr12.length == 0) {
                        c4 = 48818;
                        strArr10 = strArr12;
                        strArr9 = strArr14;
                    } else {
                        c4 = 16997;
                        strArr10 = strArr12;
                        strArr9 = strArr14;
                    }
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 18350:
                    lVar2 = lVar;
                    c4 = 25683;
                    i5 = 0;
                    z13 = false;
                case 17978:
                    c4 = 61184;
                    lVar2 = lVar;
                    z14 = true;
                case 49818:
                    String[] strArr15 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    if (strArr12.length == 0) {
                        c4 = 10435;
                        strArr10 = strArr12;
                        strArr9 = strArr15;
                    } else {
                        c4 = 51641;
                        strArr10 = strArr12;
                        strArr9 = strArr15;
                    }
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 16997:
                    lVar2 = lVar;
                    c4 = 911;
                    i5 = 0;
                    z11 = false;
                case 10748:
                    String[] strArr16 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    strArr2 = strArr12;
                    strArr = strArr16;
                    if (!z3) {
                        c4 = 18350;
                        strArr10 = strArr12;
                        strArr9 = strArr16;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 55881;
                    strArr10 = strArr2;
                    strArr9 = strArr;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 49424:
                    lVar2 = lVar;
                    i5 = 0;
                    c4 = 61184;
                    z14 = false;
                case 52731:
                    return null;
                case 11433:
                    String[] strArr17 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    strArr11 = strArr17;
                    if (z4) {
                        c4 = 22612;
                        strArr10 = strArr12;
                        strArr9 = strArr17;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 60873;
                    strArr10 = strArr12;
                    strArr9 = strArr11;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 52553:
                    lVar2 = lVar;
                    c4 = 10748;
                    i5 = 0;
                    z8 = false;
                case 35374:
                    lVar2 = lVar;
                    c4 = 28854;
                    z10 = true;
                case 5602:
                    ?? r24 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    ?? r22 = (String[][]) r24;
                    strArr8 = r22;
                    strArr7 = r24;
                    if (r22 != 0) {
                        c4 = 49818;
                        strArr10 = r22;
                        strArr9 = r24;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 1276;
                    strArr10 = strArr8;
                    strArr9 = strArr7;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 51641:
                    lVar2 = lVar;
                    c4 = 21871;
                    i5 = 0;
                    z12 = false;
                case 63469:
                    lVar2 = lVar;
                    c4 = 11433;
                    i5 = 0;
                    z9 = false;
                case 16402:
                    lVar2 = lVar;
                    c4 = 28854;
                    i5 = 0;
                    z10 = false;
                case 61885:
                    String[] strArr18 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    strArr4 = strArr12;
                    strArr3 = strArr18;
                    if (i == 0) {
                        c4 = 16402;
                        strArr10 = strArr12;
                        strArr9 = strArr18;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 35374;
                    strArr10 = strArr4;
                    strArr9 = strArr3;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 28854:
                    String[] strArr19 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    strArr11 = strArr19;
                    if (z5) {
                        c4 = 1828;
                        strArr10 = strArr12;
                        strArr9 = strArr19;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 60873;
                    strArr10 = strArr12;
                    strArr9 = strArr11;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 3525:
                    String[] strArr20 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    if (strArr12.length == 0) {
                        c4 = 37266;
                        strArr10 = strArr12;
                        strArr9 = strArr20;
                    } else {
                        c4 = 52553;
                        strArr10 = strArr12;
                        strArr9 = strArr20;
                    }
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 58524:
                    lVar2 = lVar;
                    c4 = 61885;
                    i6 = 1;
                case 22612:
                    strArr = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    lVar.getClass();
                    strArr2 = null;
                    c4 = 55881;
                    strArr10 = strArr2;
                    strArr9 = strArr;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 51855:
                    lVar.getClass();
                    c4 = 5602;
                    lVar2 = lVar;
                    strArr13 = null;
                    strArr12 = strArr12;
                    i5 = 0;
                case 37266:
                    lVar2 = lVar;
                    c4 = 10748;
                    z8 = true;
                case 44554:
                    strArr3 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    lVar.getClass();
                    strArr4 = null;
                    c4 = 35374;
                    strArr10 = strArr4;
                    strArr9 = strArr3;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 911:
                    String[] strArr21 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    strArr6 = strArr12;
                    strArr5 = strArr21;
                    if (!z11) {
                        c4 = 49424;
                        strArr10 = strArr12;
                        strArr9 = strArr21;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 17978;
                    strArr10 = strArr6;
                    strArr9 = strArr5;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 1828:
                    strArr5 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    lVar.getClass();
                    strArr6 = null;
                    c4 = 17978;
                    strArr10 = strArr6;
                    strArr9 = strArr5;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 21871:
                    String[] strArr22 = strArr13;
                    z3 = z8;
                    z4 = z9;
                    i = i6;
                    z5 = z10;
                    strArr8 = strArr12;
                    strArr7 = strArr22;
                    if (!z12) {
                        c4 = 63469;
                        strArr10 = strArr12;
                        strArr9 = strArr22;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                    c4 = 1276;
                    strArr10 = strArr8;
                    strArr9 = strArr7;
                    lVar2 = lVar;
                    z10 = z5;
                    strArr13 = strArr9;
                    i6 = i;
                    z8 = z3;
                    z9 = z4;
                    strArr12 = strArr10;
                    i5 = 0;
                case 55881:
                    lVar2 = lVar;
                    c4 = 25683;
                    z13 = true;
                case 59763:
                    byte[] bArr2 = new byte[12];
                    bArr2[i5] = 27;
                    bArr2[1] = 93;
                    int i7 = i5;
                    bArr2[2] = -14;
                    bArr2[3] = 76;
                    bArr2[4] = -42;
                    bArr2[5] = -127;
                    bArr2[6] = 94;
                    bArr2[7] = -127;
                    int i8 = 2;
                    int i9 = 1;
                    int i10 = ~A.class.getName().length();
                    bArr2[((((A.class.getName().length() | 7738884) - (i10 | (-1904224497))) + (AbstractC0008a.f(A.class, i10 | (-1906321649)) + (A.class.getName().length() & 7738884))) + ((A.class.getName().length() & 136380736) | 780206416)) ^ 787945308] = 93;
                    bArr2[9] = 32;
                    bArr2[10] = -10;
                    bArr2[11] = 69;
                    byte[] bArr3 = new byte[12];
                    bArr3[i7] = 111;
                    bArr3[1] = 60;
                    bArr3[2] = -98;
                    bArr3[3] = 63;
                    bArr3[4] = -77;
                    bArr3[5] = -30;
                    bArr3[6] = 29;
                    bArr3[7] = -18;
                    bArr3[8] = 51;
                    bArr3[9] = 70;
                    bArr3[10] = -97;
                    bArr3[11] = 34;
                    int i11 = -585497720;
                    String[] strArr23 = strArr13;
                    byte[] bArr4 = null;
                    int i12 = i7;
                    int i13 = i12;
                    int i14 = i13;
                    while (true) {
                        int i15 = ((i11 & 16777216) * (i11 | 16777216)) + ((i11 & (-16777217)) * ((~i11) & 16777216));
                        int i16 = i11 >>> 8;
                        int i17 = ~((((~i16) | (-238348293)) | i15) - ((i16 & (-238348293)) | i15));
                        int i18 = (-1081514022) - ((i17 & 2) | ((-10362931) - i17));
                        boolean z15 = z8;
                        int i19 = 2100390411;
                        int i20 = -897645243;
                        switch (E1.a(i18 | (-428181225), i18, -428181225)) {
                            case -1819084085:
                                z6 = z9;
                                i3 = i6;
                                z7 = z10;
                                int length = bArr4.length;
                                int i21 = 0 - i12;
                                int length2 = bArr4.length;
                                int i22 = 0 - i21;
                                byte b4 = bArr4[(length2 & (~i22)) - ((~length2) & i22)];
                                int length3 = bArr4.length;
                                byte b5 = bArr[((length3 | i21) - (((~i21) & (-1678010279)) & length3)) + ((i21 | (-1678010279)) & length3)];
                                bArr4[((length | i21) * 2) - (length ^ i21)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                                i14 = 4 - ((5 - i12) | (i12 & 2));
                                i4 = 2;
                                i9 = 1;
                                int i23 = ((i12 > 2 ? 1 : (i12 == 2 ? 0 : -1)) >>> 31) & 1;
                                if (i23 == 0) {
                                    i19 = -897645243;
                                }
                                if (i23 != 0) {
                                    lVar2 = lVar;
                                    i8 = 2;
                                    z10 = z7;
                                    i6 = i3;
                                    z8 = z15;
                                    i11 = i19;
                                    z9 = z6;
                                    i7 = 0;
                                } else {
                                    i8 = i4;
                                    z10 = z7;
                                    i6 = i3;
                                    z8 = z15;
                                    z9 = z6;
                                    i7 = 0;
                                    i11 = -2079636786;
                                    lVar2 = lVar;
                                }
                            case -1350640889:
                                lVar2 = lVar;
                                bArr4 = bArr2;
                                bArr = bArr3;
                                z8 = z15;
                                i11 = -1469476344;
                                i13 = 0;
                                i8 = 2;
                                i7 = 0;
                                i9 = 1;
                            case -477594107:
                                boolean z16 = z9;
                                int i24 = i6;
                                boolean z17 = z10;
                                int length4 = bArr4.length;
                                int i25 = 0 - i12;
                                int i26 = ((length4 | i25) - (((-515406864) & (~i25)) & length4)) + ((i25 | (-515406864)) & length4);
                                byte b6 = bArr[i26];
                                int length5 = bArr4.length;
                                byte b7 = bArr[((i25 | length5) * 2) - (length5 ^ i25)];
                                int i27 = ((byte) i7) - b6;
                                int i28 = i27 | b7;
                                bArr[i26] = (byte) (((byte) (((byte) i28) - ((byte) (((byte) i8) * ((byte) i27))))) + ((byte) ((b7 ^ i27) ^ i28)));
                                lVar2 = lVar;
                                z10 = z17;
                                i6 = i24;
                                z8 = z15;
                                z9 = z16;
                                i11 = -1057239115;
                                i8 = 2;
                                i7 = 0;
                                i9 = 1;
                            case 769572960:
                                break;
                            case 783648904:
                                z6 = z9;
                                int i29 = i13 + 4 + (((-1) - i13) | (-4));
                                byte b8 = bArr[i29];
                                int i30 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                                int i31 = i13 & 2;
                                int i32 = (i13 + 2) - i31;
                                int i33 = bArr[i32] & ForkServer.ERROR;
                                int i34 = i33 * ((~i33) & 65536);
                                int i35 = ~(((467314697 | (~i34)) | i30) - ((i34 & 467314697) | i30));
                                int i36 = (i13 + 1) - (i13 & 1);
                                int i37 = bArr[i36] & ForkServer.ERROR;
                                int i38 = i37 * ((~i37) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                                int i39 = ~(((1328859631 | (~i38)) | i35) - ((i38 & 1328859631) | i35));
                                int i40 = bArr[i13] & ForkServer.ERROR;
                                int a2 = S.a(i39, i40, 1, ((-1) - i39) | ((-1) - i40));
                                byte b9 = bArr4[i29];
                                int i41 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                                int i42 = bArr4[i32] & ForkServer.ERROR;
                                int i43 = i42 * ((~i42) & 65536);
                                int i44 = i6;
                                int a4 = j3.a((~i41) & 1647046022 & i43, i43, i41, (i41 | 1647046022) & i43);
                                int i45 = bArr4[i36] & ForkServer.ERROR;
                                int i46 = i45 * ((~i45) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                                int i47 = ~((a4 | ((~i46) | (-2059442874))) - ((i46 & (-2059442874)) | a4));
                                int i48 = bArr4[i13] & ForkServer.ERROR;
                                int a5 = S.a(i47, i48, 1, ((-1) - i47) | ((-1) - i48));
                                int i49 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                                int i50 = (i49 + a5) - ((i49 & a5) * 2);
                                bArr4[i13] = (byte) i50;
                                bArr4[i36] = (byte) (i50 >>> 8);
                                bArr4[i32] = (byte) (i50 >>> 16);
                                bArr4[i29] = (byte) (i50 >>> 24);
                                int i51 = (-11) - (i31 | ((-15) - i13));
                                int length6 = bArr4.length;
                                int a6 = AbstractC0044j.a(bArr4.length);
                                boolean z18 = z10;
                                int i52 = ((i51 > (((length6 & (~a6)) * 2) - (length6 ^ a6)) ? 1 : (i51 == (((length6 & (~a6)) * 2) - (length6 ^ a6)) ? 0 : -1)) >>> 31) & 1;
                                if (i52 == 0) {
                                    i20 = 1251644638;
                                }
                                i13 = i51;
                                z10 = z18;
                                i6 = i44;
                                if (i52 != 0) {
                                    z8 = z15;
                                    z9 = z6;
                                    i11 = -1469476344;
                                    i9 = 1;
                                } else {
                                    z8 = z15;
                                    i11 = i20;
                                    z9 = z6;
                                    i9 = 1;
                                }
                            case 1758587480:
                                z6 = z9;
                                int length7 = bArr4.length;
                                int i53 = 0 - i14;
                                if ((bArr[((length7 | i53) - (((~i53) & 822835569) & length7)) + ((i53 | 822835569) & length7)] > Double.NaN ? 1 : (bArr[((length7 | i53) - (((~i53) & 822835569) & length7)) + ((i53 | 822835569) & length7)] == Double.NaN ? 0 : -1)) <= -1) {
                                    i11 = -897645243;
                                } else {
                                    i11 = -1057239115;
                                }
                                i12 = i14;
                                z8 = z15;
                                z9 = z6;
                                i9 = 1;
                            case 2013813686:
                                int length8 = bArr4.length % 4;
                                z6 = z9;
                                int i54 = i9;
                                int i55 = ((length8 > i54 ? 1 : (length8 == i54 ? 0 : -1)) >>> 31) & i54;
                                if (i55 != 0) {
                                    i11 = 2100390411;
                                } else {
                                    i11 = -897645243;
                                }
                                i14 = length8;
                                if (i55 != 0) {
                                    z8 = z15;
                                    z9 = z6;
                                    i9 = 1;
                                } else {
                                    i3 = i6;
                                    z7 = z10;
                                    i4 = i8;
                                    i9 = 1;
                                    i8 = i4;
                                    z10 = z7;
                                    i6 = i3;
                                    z8 = z15;
                                    z9 = z6;
                                    i7 = 0;
                                    i11 = -2079636786;
                                    lVar2 = lVar;
                                }
                            default:
                                z8 = z15;
                                i11 = -897645243;
                        }
                        boolean z19 = z9;
                        int i56 = i6;
                        boolean z20 = z10;
                        kotlin.jvm.internal.j.e(lVar2, new String(bArr2, StandardCharsets.UTF_8).intern());
                        if (lVar2.f831e != null) {
                            c4 = 35567;
                        } else {
                            c4 = 44554;
                        }
                        z10 = z20;
                        i5 = i7;
                        strArr13 = strArr23;
                        i6 = i56;
                        z8 = z15;
                        z9 = z19;
                    }
                case 10435:
                    z12 = true;
                    c4 = 21871;
                case 48818:
                    z11 = true;
                    c4 = 911;
                case 35567:
                    return new C0084t0(lVar2);
                case 25683:
                    if (!z13) {
                        strArr11 = strArr13;
                        z3 = z8;
                        z4 = z9;
                        i = i6;
                        z5 = z10;
                        c4 = 60873;
                        strArr10 = strArr12;
                        strArr9 = strArr11;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    } else {
                        c4 = 52731;
                    }
                case 19488:
                    i6 = i5;
                    c4 = 61885;
                case 60873:
                    return new C0084t0(lVar2);
                case 61184:
                    if (z14) {
                        c4 = 51855;
                    } else {
                        strArr11 = strArr13;
                        z3 = z8;
                        z4 = z9;
                        i = i6;
                        z5 = z10;
                        c4 = 60873;
                        strArr10 = strArr12;
                        strArr9 = strArr11;
                        lVar2 = lVar;
                        z10 = z5;
                        strArr13 = strArr9;
                        i6 = i;
                        z8 = z3;
                        z9 = z4;
                        strArr12 = strArr10;
                        i5 = 0;
                    }
                case 21092:
                    if (strArr12.length == 0) {
                        c4 = 58524;
                    } else {
                        c4 = 19488;
                    }
                default:
                    c4 = 58889;
            }
        }
    }
}
