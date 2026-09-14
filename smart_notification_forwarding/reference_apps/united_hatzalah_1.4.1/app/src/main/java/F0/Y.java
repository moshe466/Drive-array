package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class Y extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f428f;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x04bd. Please report as an issue. */
    static {
        int i;
        int i3;
        int i4;
        int i5;
        byte[] bArr = new byte[10];
        bArr[0] = 94;
        int i6 = 1;
        bArr[1] = -62;
        int i7 = 2;
        bArr[2] = 89;
        long j2 = 529015303;
        long j3 = (~Y.class.getName().length()) | 1070404715;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        bArr[(-1236332) ^ ((((1074012820 & r10) - 530251632) - (Y.class.getName().length() & 1074004112)) + ((int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))))] = -76;
        int i8 = 3;
        bArr[4] = 3;
        bArr[5] = 118;
        int length = Y.class.getName().length();
        long j18 = -1180787983;
        long j19 = (length - 1) - (length * 2);
        long b4 = c3.b((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j20 = (b4 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (b4 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (b4 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = b4 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = (j31 | (j31 >>> 2)) & 252645135;
        int i9 = ((int) (((j32 | (j32 >>> 4)) & 16711935) | (((((j29 >>> 4) | j29) & 16711935) << 8) + j26))) & (-2004615096);
        long j33 = 538968072;
        long length2 = Y.class.getName().length();
        long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j35 = (j34 >>> 48) & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        long j38 = (j34 >>> 32) & 43690;
        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) | ((((j37 >>> 4) | j37) & 16711935) << 24);
        long j42 = (j34 >>> 16) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = j34 & 43690;
        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        int i10 = (int) (((((j44 >>> 4) | j44) & 16711935) << 8) | j41 | (((j47 >>> 4) | j47) & 16711935));
        long j48 = 639633408;
        long j49 = i10;
        long b5 = c3.b((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
        long j50 = (b5 >>> 48) & 43690;
        long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
        long j52 = (j51 | (j51 >>> 2)) & 252645135;
        long j53 = (b5 >>> 32) & 43690;
        long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        long j56 = (((j52 | (j52 >>> 4)) & 16711935) << 24) | ((((j55 >>> 4) | j55) & 16711935) << 16);
        long j57 = (b5 >>> 16) & 43690;
        long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
        long j59 = ((j58 >>> 2) | j58) & 252645135;
        long j60 = b5 & 43690;
        long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
        long j62 = (j61 | (j61 >>> 2)) & 252645135;
        bArr[6] = (-1364981708) ^ ((((int) (((j62 | (j62 >>> 4)) & 16711935) | (j56 | ((((j59 >>> 4) | j59) & 16711935) << 8)))) - (~i9)) - 1);
        bArr[7] = -12;
        bArr[8] = -9;
        bArr[9] = -36;
        byte[] bArr2 = {86, -121, 67, -62, -123, -25, 29, -124, -104, -78};
        byte[] bArr3 = null;
        int i11 = 1516727821;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i15 = ((i11 & 16777216) * (i11 | 16777216)) + ((i11 & (-16777217)) * ((~i11) & 16777216));
            int i16 = i11 >>> 8;
            int a2 = j3.a((~i15) & 650911840 & i16, i16, i15, (i15 | 650911840) & i16);
            int i17 = (a2 ^ 642535957) + ((a2 & 642535957) * i7);
            switch (((~i17) + ((i17 | 1) * i7)) ^ 962785775) {
                case -1896910703:
                    int i18 = i7;
                    int i19 = i12;
                    int length3 = bArr4.length;
                    int i20 = 0 - i19;
                    int i21 = (length3 ^ i20) + ((length3 & i20) * i18);
                    byte b6 = bArr3[i21];
                    int length4 = bArr4.length;
                    int i22 = 0 - i20;
                    int i23 = i22 | length4;
                    byte b7 = bArr3[D.a(i22, i18, i23, (length4 ^ i22) ^ i23)];
                    bArr3[i21] = (byte) (((byte) (((byte) i18) * ((byte) (b7 | b6)))) - ((byte) (b7 ^ b6)));
                    i7 = i18;
                    i12 = i19;
                    i11 = -746753280;
                    i8 = 3;
                case -1725904394:
                    i = i7;
                    i3 = i12;
                    i14 = bArr4.length % 4;
                    i6 = 1;
                    if ((((i14 > 1 ? 1 : (i14 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i7 = i;
                        i12 = i3;
                        i11 = -365117735;
                        i8 = 3;
                    }
                    i11 = -458924450;
                    i7 = i;
                    i12 = i3;
                    i8 = 3;
                case -1399959314:
                    int i24 = i6;
                    int a4 = j3.a((-1205100636) & i13, i13, i8, (-1205100633) & i13);
                    byte b8 = bArr3[a4];
                    int i25 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i26 = i13 - 1;
                    int i27 = i26 - (i13 | (-3));
                    int i28 = bArr3[i27] & ForkServer.ERROR;
                    int i29 = i28 * ((~i28) & 65536);
                    int a5 = S.a(i29, i25, i24, ((-1) - i29) | ((-1) - i25));
                    int i30 = i26 - (i13 | (-2));
                    int i31 = bArr3[i30] & ForkServer.ERROR;
                    int i32 = i31 * ((~i31) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i33 = (i32 - 1) - ((~a5) | i32);
                    int i34 = bArr3[i13] & ForkServer.ERROR;
                    int a6 = S.a(i33, i34, 1, ((-1) - i33) | ((-1) - i34));
                    byte b9 = bArr4[a4];
                    int i35 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i36 = bArr4[i27] & ForkServer.ERROR;
                    int i37 = ((i36 * ((~i36) & 65536)) & (~i35)) + i35;
                    int i38 = bArr4[i30] & ForkServer.ERROR;
                    int i39 = i38 * ((~i38) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i40 = ~((((~i39) | 911399251) | i37) - ((i39 & 911399251) | i37));
                    int i41 = bArr4[i13] & ForkServer.ERROR;
                    int i42 = ~((((~i40) | 1433568692) | i41) - ((i40 & 1433568692) | i41));
                    i4 = i7;
                    i5 = i12;
                    int i43 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i44 = (-1254002618) - ((i43 & i4) | ((-1672003491) - i43));
                    int i45 = (i44 + i42) - ((i44 & i42) * i4);
                    bArr4[i13] = (byte) i45;
                    bArr4[i30] = (byte) (i45 >>> 8);
                    bArr4[i27] = (byte) (i45 >>> 16);
                    bArr4[a4] = (byte) (i45 >>> 24);
                    i13 = (i13 ^ 4) + ((i13 & 4) * i4);
                    int length5 = bArr4.length;
                    int length6 = 0 - (bArr4.length % 4);
                    int i46 = ((i13 > AbstractC0014b1.a((length5 & i4) | D1.a(length6, length5), length6 * 3) ? 1 : (i13 == AbstractC0014b1.a((length5 & i4) | D1.a(length6, length5), length6 * 3) ? 0 : -1)) >>> 31) & 1;
                    r18 = i46 != 0 ? -1605440657 : -365117735;
                    if (i46 == 0) {
                        i11 = -169475207;
                        i7 = i4;
                        i12 = i5;
                        i6 = 1;
                        i8 = 3;
                    }
                    i11 = r18;
                    i7 = i4;
                    i12 = i5;
                    i6 = 1;
                    i8 = 3;
                case -1135475043:
                    break;
                case 180635757:
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i13 = 0;
                    i11 = -1605440657;
                case 511524454:
                    int length7 = bArr4.length;
                    int i47 = 0 - i12;
                    int i48 = 0 - i47;
                    int i49 = ((~length7) & i48) * i7;
                    int length8 = bArr4.length;
                    byte b10 = bArr4[((length8 | i47) * i7) - (length8 ^ i47)];
                    int length9 = bArr4.length;
                    byte b11 = bArr3[(i47 ^ length9) + ((length9 & i47) * 2)];
                    int i50 = i6;
                    bArr4[(length7 ^ i48) - i49] = (byte) (((byte) (b11 - b10)) + ((byte) (((byte) i7) * ((byte) ((~b11) & b10)))));
                    i14 = AbstractC0099x.a(i12, i8, (~i12) * i7);
                    if ((((i12 > i7 ? 1 : (i12 == i7 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i = i7;
                        i3 = i12;
                        i6 = i50;
                        i11 = -458924450;
                        i7 = i;
                        i12 = i3;
                        i8 = 3;
                    } else {
                        i11 = -365117735;
                        i6 = i50;
                    }
                case 961838909:
                    int length10 = bArr4.length;
                    int i51 = 0 - i14;
                    int i52 = (((double) ((byte) bArr3[((length10 | i51) - (((~i51) & 165327505) & length10)) + ((i51 | 165327505) & length10)])) > Double.NaN ? 1 : (((double) ((byte) bArr3[((length10 | i51) - (((~i51) & 165327505) & length10)) + ((i51 | 165327505) & length10)])) == Double.NaN ? 0 : -1)) <= -1 ? 0 : i6;
                    i11 = i52 != 0 ? -746753280 : i52 == 0 ? 1093626513 : -365117735;
                    i12 = i14;
                default:
                    i4 = i7;
                    i5 = i12;
                    i11 = r18;
                    i7 = i4;
                    i12 = i5;
                    i6 = 1;
                    i8 = 3;
            }
            new String(bArr, StandardCharsets.UTF_8).intern();
            return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = new byte[6];
        bArr[0] = 107;
        bArr[1] = 7;
        bArr[2] = -33;
        bArr[3] = Byte.MAX_VALUE;
        bArr[4] = 54;
        bArr[((((~Y.class.getName().length()) | 1243398161) & (-1473230335)) + ((Y.class.getName().length() & (-1608446464)) | 268502024)) ^ (-1204728308)] = Byte.MIN_VALUE;
        x(bArr, new byte[]{7, 104, -72, 24, 83, -14, -30, -45});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        int i = ((~Y.class.getName().length()) | (-2100729298)) & 1158433536;
        int length = Y.class.getName().length() & 1426325772;
        byte b4 = (-1431063415) ^ (((272629773 + length) + (((-length) - 1) | (-272629773))) + i);
        long j2 = -1813793459;
        long j3 = ~Y.class.getName().length();
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        int i3 = ((int) (((((j14 >>> 4) | j14) & 16711935) << 8) | j11 | (((j17 >>> 4) | j17) & 16711935))) & 628371521;
        long j18 = 605308928;
        long length2 = Y.class.getName().length();
        long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        int i4 = i3 + (((int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26))) | 182322);
        byte[] bArr2 = {b4, -57, (i4 - 628553790) - ((i4 & (-628553790)) * 2), 47, -60, -91, 75, 66};
        x(bArr2, new byte[]{-9, -94, -48, 76, -80, -52, 36, 44});
        new String(bArr2, charset).intern();
        this.f428f = c0054l1;
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
        int i7 = ~Y.class.getName().length();
        int length3 = (((~(((Y.class.getName().length() | 70245657) | i7) - (i7 | (Y.class.getName().length() & (-70245658))))) & (-1979440632)) + ((Y.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(Y.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((Y.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~Y.class.getName().length()) | (-576567005)) & 276971586) + ((Y.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~Y.class.getName().length()) | (-1157759625)) & 1755853004) + ((Y.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~Y.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = Y.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~Y.class.getName().length()) | (-1064961)) + 689325073) + ((Y.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~Y.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = Y.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~Y.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (Y.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((Y.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~Y.class.getName().length();
                    int length11 = (161497089 & (((((Y.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((Y.class.getName().length() | i14) & 797295576))) + ((Y.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~Y.class.getName().length()) | (-1085986263)) & 1078327440) + ((Y.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~Y.class.getName().length();
                    int length12 = length5 >>> ((((~(((Y.class.getName().length() | 626856794) | i15) - ((Y.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((Y.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~Y.class.getName().length()) | 1248713193) & 826417528) + ((Y.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~Y.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (Y.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~Y.class.getName().length()) | (-1005965450)) & 153223237) + ((Y.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((Y.class.getName().length() & (~length6)) & i9)) + ((Y.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~Y.class.getName().length()) | (-30261291)) & (-1534000062)) + ((Y.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~Y.class.getName().length()) | (-23496740)) & 827084804) + ((Y.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~Y.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (Y.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~Y.class.getName().length()) | (-961655275)) & 25184460) + ((Y.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~Y.class.getName().length()) | 1233459797) & 125923146) + ((Y.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~Y.class.getName().length()) | (-7107622)) & 402932290) + ((Y.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((Y.class.getName().length() | length15) - (b4 | length15)) + I2.a(Y.class, b4) + (Y.class.getName().length() & length15);
                    int length17 = ((((~Y.class.getName().length()) | (-81143879)) & 438583424) + ((Y.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~Y.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((Y.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(Y.class, 568748773 | i24) + (Y.class.getName().length() & (-2105278367)))) + ((Y.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~Y.class.getName().length()) | (-1592082969)) & 140665109) + ((Y.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~Y.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((Y.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~Y.class.getName().length()) | (-180811308));
                    int length19 = (Y.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((Y.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | Y.class.getName().length()))));
                    int i29 = ((~Y.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (Y.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~Y.class.getName().length()) | 75364313) & 1242301609) + ((Y.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = Y.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((Y.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~Y.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((Y.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~Y.class.getName().length();
                    int length24 = 1409942802 & (((((Y.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | Y.class.getName().length()) & 91135407));
                    int length25 = (Y.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~Y.class.getName().length()) | (-537919489)) - (-806798471)) + ((Y.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~Y.class.getName().length()) | (-382746167)) & 102532165) + ((Y.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~Y.class.getName().length()) | (-6036961)) & 1233145505) + ((Y.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~Y.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = Y.class.getName().length() & 268460041;
                    i5 = (((((Y.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | Y.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = Y.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((Y.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~Y.class.getName().length()) | (-1883938358)) & (-738125179)) + ((Y.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~Y.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (Y.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(Y.class, -1) | (-532481)) - (-67641369)) + ((Y.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~Y.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((Y.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(Y.class, -1) | (-33554434)) - (-1107366402)) + ((Y.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(Y.class, -1) | (-167014194)) & 1157999680) + ((Y.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = Y.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((Y.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(Y.class, -1) | 114408723) & 1183666176;
                    int length33 = Y.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~Y.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = Y.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~Y.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (Y.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~Y.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((Y.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~Y.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (Y.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~Y.class.getName().length()) | 991120067) & (-2113137661)) + ((Y.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(Y.class, -1) | 314136709) & 371231304) + (((Y.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~Y.class.getName().length()) | 366661365) & 1344150018) + ((Y.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~Y.class.getName().length()) | (-1359635359)) & 49026131) + ((Y.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~Y.class.getName().length();
                    if (length3 > 0) {
                        int length38 = Y.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (Y.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~Y.class.getName().length()) | 1110430873) & 1241612298) + ((Y.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~Y.class.getName().length()) | 1603962366) & 25199440) + (((Y.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~Y.class.getName().length()) | (-1388708984)) & 706816128) + ((Y.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~Y.class.getName().length()) | 367288948) & 548745488;
                    int length41 = Y.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~Y.class.getName().length()) | 2113158628) & 1026558002) + ((Y.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~Y.class.getName().length()) | 715175224) & 136512788) + ((Y.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~Y.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = Y.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~Y.class.getName().length()) | (-1084937228)) & 438503696) + ((Y.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~Y.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((Y.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(Y.class, 1197735420 | i53) + (Y.class.getName().length() & 674349280))) + ((Y.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~Y.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (Y.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~Y.class.getName().length()) | (-171976913)) & 318775824) + ((Y.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~Y.class.getName().length()) | (-616910267)) & 1303391760) + ((Y.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~Y.class.getName().length()) | 1297715640) & 556926729) + ((Y.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~Y.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((Y.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~Y.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (Y.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
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

    @Override // F0.T0, F0.T2
    public final boolean a() {
        return true;
    }
}
