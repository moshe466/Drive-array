package F0;

import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0053l0 extends C1 {

    /* renamed from: h, reason: collision with root package name */
    public final C0062n1 f572h;

    static {
        byte[] bArr = new byte[20];
        bArr[0] = -125;
        bArr[1] = -81;
        bArr[2] = -28;
        bArr[3] = -65;
        bArr[4] = -76;
        bArr[5] = 75;
        long j2 = -704879244;
        long j3 = ~C0053l0.class.getName().length();
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j4 = (b4 >>> 48) & 43690;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (b4 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (b4 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = b4 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        int length = (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) & 1210097732) + ((C0053l0.class.getName().length() & 402685953) | 268436009);
        bArr[B0.a((~length) | 1478533739, 1478533739 - length)] = -17;
        bArr[7] = 19;
        bArr[8] = -29;
        long j17 = -1462094274;
        long f4 = AbstractC0008a.f(C0053l0.class, -1);
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((f4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((f4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((f4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((f4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j31 = (j30 | (j30 >>> 2)) & 252645135;
        int i = (int) (((j31 | (j31 >>> 4)) & 16711935) + ((((j28 >>> 4) | j28) & 16711935) << 8) + j25);
        bArr[30317407 ^ (((i + 692502) - (i | 692502)) + ((C0053l0.class.getName().length() & 8423744) | 29624896))] = -56;
        bArr[10] = -82;
        bArr[11] = -105;
        bArr[12] = -77;
        bArr[13] = 63;
        bArr[14] = 58;
        bArr[15] = -124;
        bArr[16] = ((((~C0053l0.class.getName().length()) | (-17867777)) - (-1091626114)) + ((C0053l0.class.getName().length() & 84976640) | 205783104)) ^ (-1297409175);
        bArr[((((~C0053l0.class.getName().length()) | 810724636) & 839147532) + ((C0053l0.class.getName().length() & 33964033) | 16942593)) ^ 856090140] = -83;
        bArr[18] = 18;
        bArr[19] = 119;
        x(bArr, new byte[]{-32, -64, -119, -111, -36, 62, -114, 100, -122, -95, Byte.MIN_VALUE, -10, -61, 79, 87, -27, -38, -58, 119, 3});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        int i3 = ((~C0053l0.class.getName().length()) | 139669759) & (-1987558854);
        int length2 = C0053l0.class.getName().length() & (-2117582080);
        int i4 = ((~length2) & 37913856) + length2 + i3;
        byte[] bArr2 = {90, -67, (((~i4) & (-1949644985)) - ((-1949644985) & i4)) + i4, 75, -76, 71, 62, 69, 106, -116, 67, -15, -41, -48, 13, -118, -36, 123, -92};
        long j32 = -1;
        long length3 = C0053l0.class.getName().length();
        long j33 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j34 = (j33 >>> 48) & 21845;
        long j35 = ((j34 >>> 1) | j34) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        long j37 = (j33 >>> 32) & 21845;
        long j38 = ((j37 >>> 1) | j37) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = ((((j39 >>> 4) | j39) & 16711935) << 16) | ((((j36 >>> 4) | j36) & 16711935) << 24);
        long j41 = (j33 >>> 16) & 21845;
        long j42 = ((j41 >>> 1) | j41) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        long j44 = ((((j43 >>> 4) | j43) & 16711935) << 8) + j40;
        long j45 = j33 & 21845;
        long j46 = ((j45 >>> 1) | j45) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        byte length4 = (((((int) ((((j47 >>> 4) | j47) & 16711935) + j44)) | 1829794240) & 1623740672) + ((C0053l0.class.getName().length() & 13107200) | 83927680)) ^ (-1707668379);
        long j48 = 286262289;
        long j49 = (~C0053l0.class.getName().length()) | (-575606125);
        long j50 = ((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
        long j63 = ((j62 >>> 2) | j62) & 252645135;
        byte a2 = S.a(C0053l0.class.getName().length() & 300160, ((-r6) - 1) | (-33853633), 33853633, (int) ((((j63 >>> 4) | j63) & 16711935) | (((((j60 >>> 4) | j60) & 16711935) << 8) + j57))) ^ (-320115905);
        byte length5 = ((((~C0053l0.class.getName().length()) | 78027980) & 94466050) + (((C0053l0.class.getName().length() | 1995349981) - 1995349981) | (-2012217312))) ^ 1917751191;
        int i5 = ((~C0053l0.class.getName().length()) | 453201563) & 1784756264;
        long j64 = 1625305122;
        long length6 = C0053l0.class.getName().length();
        long j65 = (((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j66 = (j65 >>> 48) & 43690;
        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
        long j68 = ((j67 >>> 2) | j67) & 252645135;
        long j69 = (j65 >>> 32) & 43690;
        long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
        long j71 = ((j70 >>> 2) | j70) & 252645135;
        long j72 = ((((j71 >>> 4) | j71) & 16711935) << 16) + ((((j68 >>> 4) | j68) & 16711935) << 24);
        long j73 = (j65 >>> 16) & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        long j76 = j65 & 43690;
        long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
        long j78 = ((j77 >>> 2) | j77) & 252645135;
        x(bArr2, new byte[]{57, -46, 16, 101, -43, 41, 90, 55, 5, length4, 39, -33, -95, -75, 99, a2, length5, (i5 + (((int) ((((((j75 >>> 4) | j75) & 16711935) << 8) | j72) | (((j78 >>> 4) | j78) & 16711935))) | (-1870135294))) ^ (-85379009), -61});
        new String(bArr2, charset).intern();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0053l0(C0093v1 c0093v1, C0021d0 c0021d0, C0054l1 c0054l1, C0062n1 c0062n1) {
        super(c0093v1, c0021d0, c0054l1);
        byte[] bArr = {99, 119, 113, -112, 62, 113};
        x(bArr, new byte[]{15, 24, 22, -9, 91, 3, 80, -64});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = new byte[6];
        int i = (((-1854319635) | r6) - 1442557564) - ((~C0053l0.class.getName().length()) | (-1149414419));
        int length = C0053l0.class.getName().length();
        bArr2[(-1152986732) ^ (i + (289570832 | ((length + 709263376) - (length | 709263376))))] = Byte.MIN_VALUE;
        bArr2[1] = -64;
        bArr2[2] = 82;
        bArr2[3] = 54;
        bArr2[4] = 63;
        bArr2[5] = -72;
        x(bArr2, new byte[]{-27, -92, 59, 66, 80, -54, -99, -101});
        kotlin.jvm.internal.j.e(c0021d0, new String(bArr2, charset).intern());
        byte[] bArr3 = new byte[8];
        bArr3[0] = 49;
        bArr3[1] = -86;
        bArr3[2] = 43;
        bArr3[3] = 38;
        bArr3[4] = 45;
        bArr3[5] = 49;
        bArr3[(((AbstractC0008a.f(C0053l0.class, -1) | (-1630058854)) & 302737693) + ((C0053l0.class.getName().length() & 134785285) | 1763737632)) ^ 2066475323] = 126;
        bArr3[((((-1499742630) - ((~(~C0053l0.class.getName().length())) | (-1499742629))) & 281591809) + ((C0053l0.class.getName().length() & 811614208) | 673447936)) ^ 955039750] = -104;
        x(bArr3, new byte[]{67, -49, 74, 69, 89, 88, 17, -10});
        new String(bArr3, charset).intern();
        byte[] bArr4 = {-57, -10, 111, -113, 83, 14, 123, 58, -61, -44};
        byte[] bArr5 = new byte[10];
        bArr5[0] = -90;
        bArr5[1] = -122;
        bArr5[2] = 31;
        bArr5[3] = -64;
        bArr5[4] = 35;
        bArr5[5] = 122;
        int length2 = C0053l0.class.getName().length();
        long j2 = 848103607;
        long length3 = (((-1130732545) | (((~length2) - length2) + length2)) & 310970496) + (((C0053l0.class.getName().length() | (-33884210)) - (-33884210)) | 537133105);
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
        bArr5[(int) (((j16 | (j16 >>> 4)) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))] = 18;
        bArr5[7] = 85;
        bArr5[8] = -83;
        bArr5[9] = -89;
        x(bArr4, bArr5);
        kotlin.jvm.internal.j.e(c0062n1, new String(bArr4, charset).intern());
        this.f572h = c0062n1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void C(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void x(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Code restructure failed: missing block: B:48:0x2969, code lost:
    
        if (java.util.Arrays.equals(r1, F0.AbstractC0089u1.f685a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A(android.content.Context r102) {
        /*
            Method dump skipped, instructions count: 14855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0053l0.A(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean B() {
        int i;
        byte b4;
        char c4;
        byte b5;
        char c5;
        int i3;
        boolean z3;
        C0062n1 c0062n1 = this.f572h;
        String str = c0062n1.f587b;
        if (str == null) {
            b4 = -82;
            i = 0;
            c4 = '0';
            long j2 = -1;
            b5 = 32;
            c5 = 24;
            long length = C0053l0.class.getName().length();
            long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
            long j15 = (j14 | (j14 >>> 1)) & 858993459;
            long j16 = (j15 | (j15 >>> 2)) & 252645135;
            int i4 = (int) (((j16 | (j16 >>> 4)) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10);
            int length2 = C0053l0.class.getName().length();
            byte[] bArr = {(((i4 | (-335547413)) - (((-336596053) | i4) ^ 697368642)) + (698500 | (((C0053l0.class.getName().length() | 1605700) - (length2 | 1605700)) + (I2.a(C0053l0.class, length2) + (C0053l0.class.getName().length() & 1605700))))) ^ 698067092, -90, -82};
            r(bArr, new byte[]{51, -62, -52, -9, 96, 116, 65, -79});
            str = new String(bArr, StandardCharsets.UTF_8).intern();
        } else {
            i = 0;
            b4 = -82;
            c4 = '0';
            b5 = 32;
            c5 = 24;
        }
        byte[] bArr2 = new byte[19];
        bArr2[i] = -106;
        bArr2[1] = 11;
        bArr2[2] = -23;
        bArr2[3] = 124;
        bArr2[((((~C0053l0.class.getName().length()) | 1059987334) & 1313683) + ((C0053l0.class.getName().length() & 271712277) | 287440940)) ^ 288754619] = 126;
        bArr2[5] = -69;
        bArr2[6] = 79;
        bArr2[7] = -30;
        bArr2[8] = -38;
        bArr2[9] = -78;
        bArr2[10] = 107;
        int i5 = (1684993525 - ((~(~C0053l0.class.getName().length())) | 1684993526)) & 1078990144;
        long j17 = 135692289;
        long length3 = C0053l0.class.getName().length();
        long j18 = (((((((((j17 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length3 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j19 = (j18 >>> c4) & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> b5) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << c5);
        long j26 = (j18 >>> 16) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        bArr2[11] = (i5 + (((int) ((((j31 >>> 4) | j31) & 16711935) | (((((j28 >>> 4) | j28) & 16711935) << 8) + j25))) | 136757249)) ^ 1215747437;
        bArr2[12] = -123;
        bArr2[13] = 93;
        bArr2[14] = 56;
        bArr2[681913022 ^ ((((C0053l0.class.getName().length() & 271025) | 671097344) + (~(-((I2.a(C0053l0.class, -1) | (-1376536062)) & 10815665)))) + 1)] = -70;
        bArr2[16] = -4;
        bArr2[17] = b4;
        bArr2[18] = -67;
        byte[] bArr3 = new byte[19];
        long j32 = 41945820;
        long j33 = (~C0053l0.class.getName().length()) | (-2055405839);
        long j34 = (((((((((j32 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j33 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j35 = (j34 >>> c4) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        long j38 = (j34 >>> b5) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << c5);
        long j42 = (j34 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        bArr3[(((int) ((((j47 >>> 4) | j47) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) | j41))) + ((C0053l0.class.getName().length() & 109838348) | 873209856)) ^ 915155676] = 12;
        bArr3[1] = 53;
        bArr3[2] = -102;
        bArr3[3] = 57;
        bArr3[4] = 54;
        bArr3[5] = -91;
        bArr3[6] = 65;
        bArr3[7] = 119;
        long j48 = -452169878;
        long a2 = ((I2.a(C0053l0.class, -1) | (-5739556)) & 1074277986) + ((C0053l0.class.getName().length() & (-1526709214)) | (-1526447872));
        long j49 = ((((((((j48 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((a2 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + (((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) | ((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j50 = (j49 >>> c4) & 21845;
        long j51 = ((j50 >>> 1) | j50) & 858993459;
        long j52 = ((j51 >>> 2) | j51) & 252645135;
        long j53 = (j49 >>> b5) & 21845;
        long j54 = ((j53 >>> 1) | j53) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        long j56 = ((((j55 >>> 4) | j55) & 16711935) << 16) | ((((j52 >>> 4) | j52) & 16711935) << c5);
        long j57 = (j49 >>> 16) & 21845;
        long j58 = ((j57 >>> 1) | j57) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = j49 & 21845;
        long j61 = ((j60 >>> 1) | j60) & 858993459;
        long j62 = ((j61 >>> 2) | j61) & 252645135;
        bArr3[(int) (((((j59 >>> 4) | j59) & 16711935) << 8) | j56 | (((j62 >>> 4) | j62) & 16711935))] = -52;
        bArr3[9] = -85;
        bArr3[10] = 37;
        bArr3[11] = -23;
        bArr3[12] = 10;
        bArr3[13] = 9;
        bArr3[14] = 108;
        bArr3[15] = -59;
        bArr3[16] = -107;
        bArr3[17] = -64;
        bArr3[18] = -38;
        r(bArr2, bArr3);
        Charset charset = StandardCharsets.UTF_8;
        boolean M3 = N2.n.M(str, new String(bArr2, charset).intern());
        int i6 = ((~C0053l0.class.getName().length()) | 1194180322) & (-1038077408);
        int length4 = C0053l0.class.getName().length() & (-2013265663);
        byte b6 = (i6 + (~(((C0053l0.class.getName().length() | (-134318342)) | length4) - ((C0053l0.class.getName().length() & 134318341) | length4)))) ^ 903759020;
        byte[] bArr4 = new byte[20];
        bArr4[i] = 123;
        bArr4[1] = -89;
        bArr4[2] = -18;
        bArr4[3] = b6;
        bArr4[4] = -26;
        bArr4[5] = -23;
        bArr4[6] = -115;
        bArr4[7] = -68;
        bArr4[8] = 35;
        bArr4[9] = 69;
        bArr4[10] = 18;
        bArr4[11] = 5;
        bArr4[12] = -88;
        bArr4[13] = -106;
        bArr4[14] = -101;
        bArr4[15] = 66;
        bArr4[16] = 41;
        bArr4[17] = 111;
        bArr4[18] = -103;
        bArr4[19] = -10;
        byte[] bArr5 = new byte[20];
        bArr5[i] = 47;
        long j63 = -1;
        long length5 = C0053l0.class.getName().length();
        long j64 = (((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j65 = (((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j66 = (((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5;
        long j67 = (((((((j63 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4;
        long j68 = (j67 | (j66 + j65 + j64)) + (((((((((length5 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j69 = (j68 >>> c4) & 21845;
        long j70 = ((j69 >>> 1) | j69) & 858993459;
        long j71 = ((j70 >>> 2) | j70) & 252645135;
        long j72 = (j68 >>> b5) & 21845;
        long j73 = ((j72 >>> 1) | j72) & 858993459;
        long j74 = ((j73 >>> 2) | j73) & 252645135;
        long j75 = ((((j74 >>> 4) | j74) & 16711935) << 16) + ((((j71 >>> 4) | j71) & 16711935) << c5);
        long j76 = (j68 >>> 16) & 21845;
        long j77 = ((j76 >>> 1) | j76) & 858993459;
        long j78 = ((j77 >>> 2) | j77) & 252645135;
        long j79 = j68 & 21845;
        long j80 = ((j79 >>> 1) | j79) & 858993459;
        long j81 = ((j80 >>> 2) | j80) & 252645135;
        int i7 = (int) ((((((j78 >>> 4) | j78) & 16711935) << 8) + j75) | (((j81 >>> 4) | j81) & 16711935));
        long j82 = -989282245;
        long length6 = ((((C0053l0.class.getName().length() & (~i7)) & (-510831)) - 510831) + i7) - ((i7 | C0053l0.class.getName().length()) & (-510831));
        long j83 = (((((((((j82 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + ((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length6 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j84 = (j83 >>> c4) & 43690;
        long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
        long j86 = ((j85 >>> 2) | j85) & 252645135;
        long j87 = (j83 >>> b5) & 43690;
        long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = ((((j89 >>> 4) | j89) & 16711935) << 16) + ((((j86 >>> 4) | j86) & 16711935) << c5);
        long j91 = (j83 >>> 16) & 43690;
        long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
        long j93 = ((j92 >>> 2) | j92) & 252645135;
        long j94 = j83 & 43690;
        long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
        long j96 = ((j95 >>> 2) | j95) & 252645135;
        bArr5[(((int) ((((((j93 >>> 4) | j93) & 16711935) << 8) | j90) | (((j96 >>> 4) | j96) & 16711935))) + ((C0053l0.class.getName().length() & 4506282) | 275124864)) ^ (-714157382)] = -104;
        bArr5[2] = -103;
        bArr5[3] = -114;
        bArr5[4] = -91;
        bArr5[5] = 108;
        bArr5[6] = 2;
        bArr5[7] = -77;
        bArr5[8] = 93;
        bArr5[9] = -4;
        bArr5[10] = 81;
        bArr5[11] = 75;
        bArr5[12] = -17;
        bArr5[13] = -74;
        bArr5[14] = 12;
        bArr5[15] = 11;
        bArr5[16] = 114;
        bArr5[17] = -44;
        bArr5[18] = 17;
        long j97 = 1246168897;
        long length7 = (((~C0053l0.class.getName().length()) | 1544804952) & 172361227) + ((C0053l0.class.getName().length() & 1111753987) | 1073807648);
        long j98 = (((((((((j97 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | ((((((((j97 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) | ((((((((j97 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j97 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length7 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j99 = (j98 >>> c4) & 21845;
        long j100 = ((j99 >>> 1) | j99) & 858993459;
        long j101 = ((j100 >>> 2) | j100) & 252645135;
        long j102 = (j98 >>> b5) & 21845;
        long j103 = ((j102 >>> 1) | j102) & 858993459;
        long j104 = ((j103 >>> 2) | j103) & 252645135;
        long j105 = ((((j104 >>> 4) | j104) & 16711935) << 16) + ((((j101 >>> 4) | j101) & 16711935) << c5);
        long j106 = (j98 >>> 16) & 21845;
        long j107 = ((j106 >>> 1) | j106) & 858993459;
        long j108 = ((j107 >>> 2) | j107) & 252645135;
        long j109 = j98 & 21845;
        long j110 = ((j109 >>> 1) | j109) & 858993459;
        long j111 = ((j110 >>> 2) | j110) & 252645135;
        bArr5[19] = (int) (((((j108 >>> 4) | j108) & 16711935) << 8) | j105 | (((j111 >>> 4) | j111) & 16711935));
        r(bArr4, bArr5);
        boolean M4 = N2.n.M(str, new String(bArr4, charset).intern());
        String[] strArr = (String[]) c0062n1.f592g;
        int length8 = strArr.length;
        int i8 = i;
        while (true) {
            if (i8 >= length8) {
                i3 = i;
                break;
            }
            if (N2.n.M(str, strArr[i8])) {
                i3 = 1;
                break;
            }
            i8++;
        }
        if (M4 || M3 || i3 != 0) {
            long j112 = -1409072095;
            long j113 = (~C0053l0.class.getName().length()) | 1818808772;
            long j114 = ((((((((j112 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((j112 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + (((((((((j112 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j112 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j113 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j115 = (j114 >>> c4) & 43690;
            long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
            long j117 = (j116 | (j116 >>> 2)) & 252645135;
            long j118 = (j114 >>> b5) & 43690;
            long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
            long j120 = ((j119 >>> 2) | j119) & 252645135;
            long j121 = (((j117 | (j117 >>> 4)) & 16711935) << c5) | ((((j120 >>> 4) | j120) & 16711935) << 16);
            long j122 = (j114 >>> 16) & 43690;
            long j123 = ((j122 >>> 2) | (j122 >>> 1)) & 858993459;
            long j124 = ((j123 >>> 2) | j123) & 252645135;
            long j125 = j114 & 43690;
            long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
            long j127 = (j126 | (j126 >>> 2)) & 252645135;
            z3 = (((int) (((j127 | (j127 >>> 4)) & 16711935) + (((((j124 >>> 4) | j124) & 16711935) << 8) + j121))) + ((C0053l0.class.getName().length() & (-2147285599)) | 4194704)) ^ (-1404877392);
        } else {
            z3 = i;
        }
        if (z3 != 0) {
            byte[] bArr6 = new byte[28];
            bArr6[i] = -7;
            bArr6[1] = 33;
            bArr6[2] = 95;
            bArr6[3] = 14;
            bArr6[4] = -84;
            long length9 = C0053l0.class.getName().length();
            long a4 = AbstractC0088u0.a(j65, j64, j66, j67, ((((((((length9 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j128 = (a4 >>> c4) & 21845;
            long j129 = ((j128 >>> 1) | j128) & 858993459;
            long j130 = ((j129 >>> 2) | j129) & 252645135;
            long j131 = (a4 >>> b5) & 21845;
            long j132 = ((j131 >>> 1) | j131) & 858993459;
            long j133 = ((j132 >>> 2) | j132) & 252645135;
            long j134 = ((((j133 >>> 4) | j133) & 16711935) << 16) + ((((j130 >>> 4) | j130) & 16711935) << c5);
            long j135 = (a4 >>> 16) & 21845;
            long j136 = ((j135 >>> 1) | j135) & 858993459;
            long j137 = ((j136 >>> 2) | j136) & 252645135;
            long j138 = a4 & 21845;
            long j139 = ((j138 >>> 1) | j138) & 858993459;
            long j140 = ((j139 >>> 2) | j139) & 252645135;
            bArr6[5] = (((((int) ((((j140 >>> 4) | j140) & 16711935) + (((((j137 >>> 4) | j137) & 16711935) << 8) | j134))) | (-339102412)) & 1107478880) + ((C0053l0.class.getName().length() & 142761028) | 142611460)) ^ (-1250090312);
            bArr6[6] = -55;
            bArr6[7] = -52;
            bArr6[8] = -41;
            bArr6[9] = 88;
            bArr6[10] = 70;
            bArr6[11] = 40;
            int i9 = ((~C0053l0.class.getName().length()) | (-19084834)) & 88116264;
            int length10 = C0053l0.class.getName().length();
            bArr6[(i9 + ((-1876946687) | ((287315233 | length10) - (length10 ^ 287315233)))) ^ (-1788830427)] = -46;
            bArr6[13] = -90;
            bArr6[14] = -28;
            bArr6[15] = 8;
            bArr6[16] = -17;
            bArr6[17] = 38;
            bArr6[18] = 102;
            bArr6[19] = -87;
            bArr6[20] = 76;
            int i10 = ((~C0053l0.class.getName().length()) | 1638200745) & 403544129;
            long j141 = 42074116;
            long length11 = C0053l0.class.getName().length() & 403376192;
            long j142 = (((((((((j141 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j141 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + ((((((((j141 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j141 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length11 >>> c5) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << b5) + ((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
            long j143 = (j142 >>> c4) & 43690;
            long j144 = ((j143 >>> 2) | (j143 >>> 1)) & 858993459;
            long j145 = ((j144 >>> 2) | j144) & 252645135;
            long j146 = (j142 >>> b5) & 43690;
            long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
            long j148 = ((j147 >>> 2) | j147) & 252645135;
            long j149 = ((((j148 >>> 4) | j148) & 16711935) << 16) + ((((j145 >>> 4) | j145) & 16711935) << c5);
            long j150 = (j142 >>> 16) & 43690;
            long j151 = ((j150 >>> 2) | (j150 >>> 1)) & 858993459;
            long j152 = ((j151 >>> 2) | j151) & 252645135;
            long j153 = j142 & 43690;
            long j154 = ((j153 >>> 2) | (j153 >>> 1)) & 858993459;
            long j155 = ((j154 >>> 2) | j154) & 252645135;
            bArr6[(i10 + ((int) (((j155 | (j155 >>> 4)) & 16711935) + (((((j152 >>> 4) | j152) & 16711935) << 8) + j149)))) ^ 445618256] = -110;
            bArr6[22] = 29;
            bArr6[23] = 69;
            bArr6[c5] = 124;
            bArr6[25] = 91;
            bArr6[26] = -17;
            int i11 = ((~C0053l0.class.getName().length()) | 1020516248) & 146801692;
            int length12 = C0053l0.class.getName().length();
            bArr6[27] = (-150496288) ^ ((((1064964 & length12) + 3694594) - (length12 & 1064960)) + i11);
            byte[] bArr7 = new byte[28];
            bArr7[i] = -93;
            bArr7[1] = 31;
            bArr7[2] = 70;
            bArr7[3] = 79;
            bArr7[4] = -31;
            int i12 = ((~C0053l0.class.getName().length()) | 1474539214) & (-2113058815);
            int length13 = (C0053l0.class.getName().length() & (-2146680447)) | 285213056;
            int i13 = -i12;
            int i14 = (length13 ^ i13) - ((i13 & (~length13)) * 2);
            bArr7[((-1827845756) | i14) - ((-1827845756) & i14)] = -123;
            int i15 = ~C0053l0.class.getName().length();
            int i16 = 25370115 & (((~i15) & (-1293444557)) + i15);
            int length14 = (C0053l0.class.getName().length() & 20972808) | 1481376012;
            int i17 = -i16;
            int i18 = i17 | length14;
            bArr7[1506746121 ^ ((i18 - (i17 * 2)) + ((i17 ^ length14) ^ i18))] = -64;
            bArr7[7] = -116;
            bArr7[8] = -51;
            bArr7[9] = 4;
            bArr7[10] = 37;
            bArr7[11] = 45;
            bArr7[12] = -72;
            bArr7[13] = -94;
            bArr7[14] = -101;
            bArr7[15] = 75;
            bArr7[16] = -102;
            bArr7[17] = 23;
            bArr7[18] = 40;
            bArr7[19] = -89;
            bArr7[20] = 58;
            bArr7[21] = -52;
            bArr7[22] = 100;
            bArr7[23] = 17;
            bArr7[c5] = b5;
            bArr7[25] = -7;
            bArr7[26] = -95;
            bArr7[27] = -126;
            r(bArr6, bArr7);
            t(new String(bArr6, StandardCharsets.UTF_8).intern(), str);
        }
        return z3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0168. Please report as an issue. */
    @Override // F0.T2
    public final void a(Context context) {
        int i;
        int i3;
        char c4;
        int i4;
        int i5;
        char c5;
        C0053l0 c0053l0 = this;
        byte[] bArr = {22, 81, 108, 0, 67, 120, -126};
        int i6 = 8;
        byte[] bArr2 = new byte[8];
        bArr2[((((~C0053l0.class.getName().length()) | 668255169) & 704972827) + ((C0053l0.class.getName().length() & 1208551450) | 1076400128)) ^ 1781372955] = 117;
        int i7 = 1;
        bArr2[1] = 62;
        int i8 = 2;
        bArr2[2] = 2;
        bArr2[3] = 116;
        bArr2[4] = 38;
        bArr2[5] = 0;
        int i9 = ~C0053l0.class.getName().length();
        char c6 = 6;
        bArr2[6] = ((((i9 + 1880395042) + (((-i9) - 1) | (-1880395042))) & 608503196) + ((C0053l0.class.getName().length() & 71372956) | 142626817)) ^ (-751130005);
        bArr2[7] = -9;
        C(bArr, bArr2);
        kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
        int length = C0053l0.class.getName().length();
        int length2 = (((-603820942) | ((length - 1) - (length * 2))) & 1350830444) + (((C0053l0.class.getName().length() | (-566624527)) + 566624527) | 557973506);
        byte[] bArr3 = {-126, -74, 39, 103, 123, -92, E1.a(length2 | (-1908803868), -1908803868, length2)};
        char c7 = '\t';
        byte[] bArr4 = {-54, 9, 52, 44, 30, -36, -2, 116};
        byte[] bArr5 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1180709023;
        byte[] bArr6 = null;
        while (true) {
            int i14 = ((i13 & 16777216) * (i13 | 16777216)) + ((i13 & (-16777217)) * ((~i13) & 16777216));
            int i15 = i13 >>> i6;
            char c8 = c7;
            int a2 = S.a(i15, i14, i7, ((-1) - i15) | ((-1) - i14));
            int i16 = (a2 ^ (-201803027)) + ((a2 & (-201803027)) * i8);
            int i17 = 1565752577;
            int i18 = 1621215041;
            switch ((i16 - 814310662) - ((i16 & (-814310662)) * i8)) {
                case -2000520841:
                    int i19 = i6;
                    int i20 = i7;
                    char c9 = c6;
                    int length3 = bArr6.length;
                    int i21 = 0 - (0 - i12);
                    if ((bArr5[((length3 & (~i21)) * 2) - (length3 ^ i21)] > Double.NaN ? 1 : (bArr5[((length3 & (~i21)) * 2) - (length3 ^ i21)] == Double.NaN ? 0 : -1)) <= -1) {
                        i = 0;
                    } else {
                        i = i20;
                    }
                    if (i == 0) {
                        i17 = 1621215041;
                    }
                    if (i != 0) {
                        i13 = i17;
                    } else {
                        i13 = -1164716566;
                    }
                    c0053l0 = this;
                    i11 = i12;
                    c7 = c8;
                    i7 = i20;
                    i6 = i19;
                    c6 = c9;
                    i8 = 2;
                case -870579640:
                    i3 = i6;
                    c4 = c6;
                    int i22 = (i10 - 1) - (i10 | (-4));
                    byte b4 = bArr5[i22];
                    int i23 = ((b4 & ForkServer.DONE) * (b4 | ForkServer.DONE)) + ((b4 & ForkServer.ERROR) * ((~b4) & 16777216));
                    int i24 = i10 + 3 + (((-1) - i10) | (-3));
                    int i25 = bArr5[i24] & ForkServer.ERROR;
                    int i26 = i25 * ((~i25) & 65536);
                    int i27 = ~((i23 | ((~i26) | (-1268032266))) - ((i26 & (-1268032266)) | i23));
                    int a4 = j3.a((-132004404) & i10, i10, 1, (-132004403) & i10);
                    int i28 = bArr5[a4] & ForkServer.ERROR;
                    int i29 = i28 * ((~i28) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i30 = (i29 + i27) - (i29 & i27);
                    int i31 = bArr5[i10] & ForkServer.ERROR;
                    int i32 = (i30 & (~i31)) + i31;
                    byte b5 = bArr6[i22];
                    int i33 = ((b5 & ForkServer.DONE) * (b5 | ForkServer.DONE)) + ((b5 & ForkServer.ERROR) * ((~b5) & 16777216));
                    int i34 = bArr6[i24] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & 65536);
                    int i36 = ~((i33 | ((-1355861741) | (~i35))) - ((i35 & (-1355861741)) | i33));
                    int i37 = bArr6[a4] & ForkServer.ERROR;
                    int i38 = i37 * ((~i37) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int a5 = S.a(i38, i36, 1, ((-1) - i38) | ((-1) - i36));
                    int i39 = (a5 - 1) - ((~(bArr6[i10] & ForkServer.ERROR)) | a5);
                    int i40 = i32 << ((i32 > Double.NaN ? 1 : (i32 == Double.NaN ? 0 : -1)) >>> 31);
                    int i41 = (i40 ^ (-418000873)) + ((i40 & (-418000873)) * 2);
                    int i42 = (i41 + i39) - ((i41 & i39) * 2);
                    bArr6[i10] = (byte) i42;
                    bArr6[a4] = (byte) (i42 >>> 8);
                    bArr6[i24] = (byte) (i42 >>> 16);
                    bArr6[i22] = (byte) (i42 >>> 24);
                    i10 = (i10 ^ 4) + ((i10 & 4) * 2);
                    int length4 = bArr6.length;
                    int a6 = AbstractC0044j.a(bArr6.length);
                    i4 = 1;
                    if ((((i10 > (((length4 & (~a6)) * 2) - (length4 ^ a6)) ? 1 : (i10 == (((length4 & (~a6)) * 2) - (length4 ^ a6)) ? 0 : -1)) >>> 31) & 1) != 0) {
                        c0053l0 = this;
                        c7 = c8;
                        i13 = 1910359311;
                    } else {
                        c0053l0 = this;
                        c7 = c8;
                        i13 = 1621215041;
                    }
                    i7 = i4;
                    i6 = i3;
                    c6 = c4;
                    i8 = 2;
                case -97532338:
                    i5 = i6;
                    c5 = c6;
                    int length5 = bArr6.length % 4;
                    int i43 = ((length5 > i7 ? 1 : (length5 == i7 ? 0 : -1)) >>> 31) & i7;
                    if (i43 != 0) {
                        i18 = 986083301;
                    }
                    i12 = length5;
                    if (i43 != 0) {
                        c7 = c8;
                        i13 = i18;
                        i6 = i5;
                        c6 = c5;
                        i8 = 2;
                        i7 = 1;
                    }
                    i13 = -1138188205;
                    c7 = c8;
                    i6 = i5;
                    c6 = c5;
                    i8 = 2;
                    i7 = 1;
                case 298177592:
                    i3 = i6;
                    i4 = i7;
                    c4 = c6;
                    int length6 = bArr6.length;
                    int i44 = 0 - i11;
                    int a7 = AbstractC0014b1.a((length6 & 2) | D1.a(i44, length6), i44 * 3);
                    byte b6 = bArr5[a7];
                    int length7 = bArr6.length;
                    int i45 = 0 - i44;
                    int i46 = i45 | length7;
                    byte b7 = bArr5[D.a(i45, 2, i46, (length7 ^ i45) ^ i46)];
                    bArr5[a7] = (byte) (((byte) (b7 ^ b6)) + ((byte) (((byte) 2) * ((byte) (b7 & b6)))));
                    i13 = 1565752577;
                    c7 = c8;
                    i7 = i4;
                    i6 = i3;
                    c6 = c4;
                    i8 = 2;
                case 373627814:
                    break;
                case 975213712:
                    int length8 = bArr6.length;
                    int i47 = 0 - i11;
                    int i48 = i7;
                    int length9 = bArr6.length;
                    i5 = i6;
                    int i49 = ~i47;
                    byte b8 = bArr6[((length9 | i47) - ((i49 & (-656070458)) & length9)) + ((i47 | (-656070458)) & length9)];
                    int length10 = bArr6.length;
                    byte b9 = bArr5[(i49 ^ length10) + ((length10 | i47) * 2) + 1];
                    bArr6[((length8 | i47) * 2) - (length8 ^ i47)] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i8) * ((byte) ((~b9) & b8)))));
                    i12 = (~i11) + (i11 * 2);
                    int i50 = ((i11 > i8 ? 1 : (i11 == i8 ? 0 : -1)) >>> 31) & 1;
                    if (i50 != 0) {
                        i13 = 986083301;
                    } else {
                        i13 = 1621215041;
                    }
                    if (i50 != 0) {
                        c7 = c8;
                        i7 = i48;
                        i6 = i5;
                        i8 = 2;
                        c6 = 6;
                    } else {
                        c5 = 6;
                        i13 = -1138188205;
                        c7 = c8;
                        i6 = i5;
                        c6 = c5;
                        i8 = 2;
                        i7 = 1;
                    }
                case 1548321255:
                    bArr5 = bArr4;
                    bArr6 = bArr3;
                    i10 = 0;
                    c7 = c8;
                    i13 = 1910359311;
                default:
                    c7 = c8;
                    i13 = 1621215041;
            }
            int i51 = i6;
            int i52 = i7;
            Charset charset = StandardCharsets.UTF_8;
            new String(bArr3, charset).intern();
            C0031f2 n4 = T0.n(new C0016c(c0053l0, context, 2));
            byte[] bArr7 = new byte[6];
            long j2 = 286812296;
            long j3 = -33;
            long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> i51) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> i51) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j5 = (j4 >>> 48) & 43690;
            long j6 = ((j5 >>> 2) | (j5 >>> i52)) & 858993459;
            long j7 = ((j6 >>> 2) | j6) & 252645135;
            long j8 = (j4 >>> 32) & 43690;
            long j9 = ((j8 >>> 2) | (j8 >>> i52)) & 858993459;
            long j10 = ((j9 >>> 2) | j9) & 252645135;
            long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
            long j12 = (j4 >>> 16) & 43690;
            long j13 = ((j12 >>> 2) | (j12 >>> i52)) & 858993459;
            long j14 = ((j13 >>> 2) | j13) & 252645135;
            long j15 = j4 & 43690;
            long j16 = ((j15 >>> 2) | (j15 >>> i52)) & 858993459;
            long j17 = (j16 | (j16 >>> 2)) & 252645135;
            long j18 = -1726382936;
            long j19 = ((int) (((j17 | (j17 >>> 4)) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << i51) + j11))) - 2013195232;
            long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> i51) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> i51) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j21 = (j20 >>> 48) & 21845;
            long j22 = (j21 | (j21 >>> i52)) & 858993459;
            long j23 = (j22 | (j22 >>> 2)) & 252645135;
            long j24 = (j20 >>> 32) & 21845;
            long j25 = ((j24 >>> i52) | j24) & 858993459;
            long j26 = ((j25 >>> 2) | j25) & 252645135;
            long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + (((j23 | (j23 >>> 4)) & 16711935) << 24);
            long j28 = (j20 >>> 16) & 21845;
            long j29 = ((j28 >>> i52) | j28) & 858993459;
            long j30 = ((j29 >>> 2) | j29) & 252645135;
            long j31 = j20 & 21845;
            long j32 = (j31 | (j31 >>> i52)) & 858993459;
            long j33 = (j32 | (j32 >>> 2)) & 252645135;
            bArr7[(int) (((j33 | (j33 >>> 4)) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << i51) | j27))] = 54;
            bArr7[i52] = 20;
            bArr7[2] = 100;
            bArr7[3] = -96;
            bArr7[4] = -36;
            bArr7[5] = 30;
            byte[] bArr8 = new byte[i51];
            // fill-array-data instruction
            bArr8[0] = 91;
            bArr8[1] = 65;
            bArr8[2] = 45;
            bArr8[3] = -68;
            bArr8[4] = -80;
            bArr8[5] = 106;
            bArr8[6] = -125;
            bArr8[7] = 97;
            C1.r(bArr7, bArr8);
            new String(bArr7, charset).intern();
            C0054l1 c0054l1 = c0053l0.f181g;
            C0047j2 c0047j2 = c0054l1.f573a;
            c0047j2.s();
            byte[] bArr9 = {-105, 4, -96, -4, 43, -22, 71, -87, -109, 92, 33, -121, 55, -1, 111};
            C1.r(bArr9, new byte[]{-7, 58, -27, -127, 100, 83, 58, -89, 9, 1, -120, -38, 88, -115, 10});
            c0053l0.d(new String(bArr9, charset).intern(), n4);
            if (n4.b()) {
                byte[] bArr10 = {83, 53, -79, 62, -21, -118, -3, -34, 40, -20, -11, 101, -102, 39, 122};
                long j34 = -1;
                long j35 = 32;
                long j36 = ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                long j37 = (((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j38 = (((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j39 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j38 + j37 + j36;
                long j40 = (j39 >>> 48) & 21845;
                long j41 = ((j40 >>> i52) | j40) & 858993459;
                long j42 = ((j41 >>> 2) | j41) & 252645135;
                long j43 = (j39 >>> 32) & 21845;
                long j44 = ((j43 >>> i52) | j43) & 858993459;
                long j45 = ((j44 >>> 2) | j44) & 252645135;
                long j46 = ((((j45 >>> 4) | j45) & 16711935) << 16) + ((((j42 >>> 4) | j42) & 16711935) << 24);
                long j47 = (j39 >>> 16) & 21845;
                long j48 = ((j47 >>> i52) | j47) & 858993459;
                long j49 = ((j48 >>> 2) | j48) & 252645135;
                long j50 = j39 & 21845;
                long j51 = ((j50 >>> i52) | j50) & 858993459;
                long j52 = ((j51 >>> 2) | j51) & 252645135;
                byte b10 = 534217895 ^ ((-536860406) + ((((int) ((((j52 >>> 4) | j52) & 16711935) | (((((j49 >>> 4) | j49) & 16711935) << 8) + j46))) | (-1771089803)) & 2642517));
                long j53 = -1598025728;
                long j54 = (((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j38 + (j37 | j36);
                long j55 = (j54 >>> 48) & 43690;
                long j56 = ((j55 >>> 2) | (j55 >>> i52)) & 858993459;
                long j57 = ((j56 >>> 2) | j56) & 252645135;
                long j58 = (j54 >>> 32) & 43690;
                long j59 = ((j58 >>> 2) | (j58 >>> i52)) & 858993459;
                long j60 = ((j59 >>> 2) | j59) & 252645135;
                long j61 = ((((j60 >>> 4) | j60) & 16711935) << 16) | ((((j57 >>> 4) | j57) & 16711935) << 24);
                long j62 = (j54 >>> 16) & 43690;
                long j63 = ((j62 >>> 2) | (j62 >>> i52)) & 858993459;
                long j64 = ((j63 >>> 2) | j63) & 252645135;
                long j65 = ((((j64 >>> 4) | j64) & 16711935) << 8) + j61;
                long j66 = j54 & 43690;
                long j67 = ((j66 >>> 2) | (j66 >>> i52)) & 858993459;
                long j68 = (j67 | (j67 >>> 2)) & 252645135;
                byte b11 = 1579125237 ^ ((-2145356800) + (((int) (((j68 | (j68 >>> 4)) & 16711935) + j65)) | 566231552));
                byte[] bArr11 = new byte[15];
                bArr11[0] = 61;
                bArr11[i52] = 43;
                bArr11[2] = -12;
                bArr11[3] = 63;
                bArr11[4] = -92;
                bArr11[5] = -77;
                bArr11[6] = -76;
                bArr11[7] = -98;
                bArr11[8] = 96;
                bArr11[c8] = 80;
                bArr11[10] = -68;
                bArr11[11] = b10;
                bArr11[12] = b11;
                bArr11[13] = 85;
                bArr11[14] = 31;
                C1.r(bArr10, bArr11);
                String intern = new String(bArr10, charset).intern();
                c0047j2.s();
                c0053l0.s(intern);
            }
            if (n4.a()) {
                Integer s3 = c0047j2.s();
                byte[] bArr12 = {90, -100, -87, 65, 44, -58, -64, -124, -33, 6, 46, -53, -38, -46, 48};
                C1.r(bArr12, new byte[]{70, -62, -36, 14, 97, Byte.MAX_VALUE, -71, -44, -43, 58, -109, -90, -75, -96, 85});
                c0054l1.c(new String(bArr12, charset).intern(), s3);
                return;
            }
            return;
        }
    }
}
