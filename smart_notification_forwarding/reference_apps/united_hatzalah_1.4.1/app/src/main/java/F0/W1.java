package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class W1 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f407f;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0432. Please report as an issue. */
    static {
        int i;
        int i3;
        int i4;
        int i5;
        int i6 = -1;
        int f4 = (AbstractC0008a.f(W1.class, -1) | 1365152754) & 1786535940;
        long j2 = 983621644;
        long length = W1.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j4 = (j3 >>> 48) & 43690;
        int i7 = 1;
        int i8 = 2;
        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 43690;
        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        int i9 = f4 + (((int) ((((j16 >>> 4) | j16) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10)) | 293636104);
        long j17 = -2080172037;
        long j18 = i9;
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j20 = (j19 >>> 48) & 21845;
        long j21 = ((j20 >>> 1) | j20) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 21845;
        long j24 = ((j23 >>> 1) | j23) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 21845;
        long j31 = ((j30 >>> 1) | j30) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        int i10 = 3;
        byte[] bArr = {-71, 3, 43, -120, (int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26)), -9, -125, 102, 50, -3, 109, -42, -79, -7, 84, 28};
        byte[] bArr2 = new byte[16];
        bArr2[0] = -20;
        bArr2[1] = 60;
        bArr2[2] = 94;
        bArr2[3] = -48;
        int i11 = ((~W1.class.getName().length()) | 555352531) & 629286528;
        int length2 = (W1.class.getName().length() & 78657032) | 3149836;
        int i12 = -i11;
        bArr2[((length2 ^ i12) - ((i12 & (~length2)) * 2)) ^ 632436360] = -102;
        long j33 = 103949580;
        long j34 = (~W1.class.getName().length()) | (-67157505);
        long j35 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j36 = (j35 >>> 48) & 43690;
        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
        long j38 = (j37 | (j37 >>> 2)) & 252645135;
        long j39 = (j35 >>> 32) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = ((j40 >>> 2) | j40) & 252645135;
        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + (((j38 | (j38 >>> 4)) & 16711935) << 24);
        long j43 = (j35 >>> 16) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = j35 & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = (j47 | (j47 >>> 2)) & 252645135;
        int i13 = (int) (((j48 | (j48 >>> 4)) & 16711935) | ((((j45 >>> 4) | j45) & 16711935) << 8) | j42);
        int length3 = (W1.class.getName().length() & 218735616) | 151634432;
        bArr2[5] = (((length3 & i13) * 2) + (length3 ^ i13)) ^ 255584098;
        bArr2[6] = 2;
        bArr2[7] = -16;
        bArr2[8] = 120;
        bArr2[9] = 93;
        bArr2[10] = 24;
        bArr2[11] = -96;
        bArr2[12] = -18;
        bArr2[13] = 96;
        bArr2[14] = 80;
        bArr2[15] = 98;
        byte[] bArr3 = null;
        int i14 = 1516727821;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i18 = ((i14 & 16777216) * (i14 | 16777216)) + ((i14 & (-16777217)) * ((~i14) & 16777216));
            int i19 = i14 >>> 8;
            int a2 = j3.a((~i18) & 650911840 & i19, i19, i18, (i18 | 650911840) & i19);
            int i20 = (a2 ^ 642535957) + ((a2 & 642535957) * i8);
            switch (((~i20) + ((i20 | 1) * i8)) ^ 962785775) {
                case -1896910703:
                    int i21 = i7;
                    int i22 = i8;
                    i3 = i16;
                    int length4 = bArr4.length;
                    int i23 = 0 - i15;
                    int i24 = (length4 ^ i23) + ((length4 & i23) * i22);
                    byte b4 = bArr3[i24];
                    int length5 = bArr4.length;
                    int i25 = 0 - i23;
                    int i26 = i25 | length5;
                    byte b5 = bArr3[D.a(i25, i22, i26, (length5 ^ i25) ^ i26)];
                    bArr3[i24] = (byte) (((byte) (((byte) i22) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i7 = i21;
                    i8 = i22;
                    i14 = -746753280;
                    i16 = i3;
                    i6 = -1;
                    i10 = 3;
                case -1725904394:
                    i4 = i8;
                    i3 = i16;
                    i17 = bArr4.length % 4;
                    i5 = 1;
                    if ((((i17 > 1 ? 1 : (i17 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i7 = 1;
                        i8 = i4;
                        i16 = i3;
                        i14 = -365117735;
                        i6 = -1;
                        i10 = 3;
                    }
                    i14 = -458924450;
                    i7 = i5;
                    i8 = i4;
                    i16 = i3;
                    i6 = -1;
                    i10 = 3;
                case -1399959314:
                    int i27 = i7;
                    int a4 = j3.a((-1205100636) & i16, i16, 3, (-1205100633) & i16);
                    byte b6 = bArr3[a4];
                    int i28 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i29 = i16 - 1;
                    int i30 = i29 - (i16 | (-3));
                    int i31 = bArr3[i30] & ForkServer.ERROR;
                    int i32 = i31 * ((~i31) & 65536);
                    int a5 = S.a(i32, i28, i27, ((-1) - i32) | ((-1) - i28));
                    int i33 = i29 - (i16 | (-2));
                    int i34 = bArr3[i33] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i36 = (i35 - 1) - ((~a5) | i35);
                    int i37 = bArr3[i16] & ForkServer.ERROR;
                    int a6 = S.a(i36, i37, 1, ((-1) - i36) | ((-1) - i37));
                    byte b7 = bArr4[a4];
                    int i38 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i39 = bArr4[i30] & ForkServer.ERROR;
                    int i40 = ((i39 * ((~i39) & 65536)) & (~i38)) + i38;
                    int i41 = bArr4[i33] & ForkServer.ERROR;
                    int i42 = i41 * ((~i41) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i43 = ~((((~i42) | 911399251) | i40) - ((i42 & 911399251) | i40));
                    int i44 = bArr4[i16] & ForkServer.ERROR;
                    int i45 = ~((((~i43) | 1433568692) | i44) - ((i43 & 1433568692) | i44));
                    i = i8;
                    int i46 = i16;
                    int i47 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i48 = (-1254002618) - ((i47 & i) | ((-1672003491) - i47));
                    int i49 = (i48 + i45) - ((i48 & i45) * i);
                    bArr4[i46] = (byte) i49;
                    bArr4[i33] = (byte) (i49 >>> 8);
                    bArr4[i30] = (byte) (i49 >>> 16);
                    bArr4[a4] = (byte) (i49 >>> 24);
                    i16 = (i46 ^ 4) + ((i46 & 4) * i);
                    int length6 = bArr4.length;
                    int length7 = 0 - (bArr4.length % 4);
                    int i50 = ((i16 > AbstractC0014b1.a((length6 & i) | D1.a(length7, length6), length7 * 3) ? 1 : (i16 == AbstractC0014b1.a((length6 & i) | D1.a(length7, length6), length7 * 3) ? 0 : -1)) >>> 31) & 1;
                    r19 = i50 != 0 ? -1605440657 : -365117735;
                    if (i50 == 0) {
                        i14 = -169475207;
                        i8 = i;
                        i6 = -1;
                        i10 = 3;
                        i7 = 1;
                    }
                    i14 = r19;
                    i8 = i;
                    i6 = -1;
                    i10 = 3;
                    i7 = 1;
                case -1135475043:
                    break;
                case 180635757:
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i16 = 0;
                    i14 = -1605440657;
                case 511524454:
                    int length8 = bArr4.length;
                    int i51 = 0 - i15;
                    int i52 = 0 - i51;
                    int i53 = ((~length8) & i52) * i8;
                    int length9 = bArr4.length;
                    byte b8 = bArr4[((length9 | i51) * i8) - (length9 ^ i51)];
                    int length10 = bArr4.length;
                    byte b9 = bArr3[(length10 ^ i51) + ((length10 & i51) * 2)];
                    int i54 = i7;
                    bArr4[(length8 ^ i52) - i53] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i8) * ((byte) ((~b9) & b8)))));
                    i17 = AbstractC0099x.a(i15, i10, (~i15) * i8);
                    if ((((i15 > i8 ? 1 : (i15 == i8 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i4 = i8;
                        i3 = i16;
                        i5 = i54;
                        i14 = -458924450;
                        i7 = i5;
                        i8 = i4;
                        i16 = i3;
                        i6 = -1;
                        i10 = 3;
                    } else {
                        i14 = -365117735;
                        i7 = i54;
                        i6 = -1;
                        i10 = 3;
                    }
                case 961838909:
                    int length11 = bArr4.length;
                    int i55 = 0 - i17;
                    int i56 = (((double) ((byte) bArr3[((length11 | i55) - (((~i55) & 165327505) & length11)) + ((i55 | 165327505) & length11)])) > Double.NaN ? 1 : (((double) ((byte) bArr3[((length11 | i55) - (((~i55) & 165327505) & length11)) + ((i55 | 165327505) & length11)])) == Double.NaN ? 0 : -1)) <= i6 ? 0 : i7;
                    i14 = i56 != 0 ? -746753280 : i56 == 0 ? 1093626513 : -365117735;
                    i15 = i17;
                default:
                    i = i8;
                    i14 = r19;
                    i8 = i;
                    i6 = -1;
                    i10 = 3;
                    i7 = 1;
            }
            new String(bArr, StandardCharsets.UTF_8).intern();
            return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W1(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = {-112, 122, 58, -36, -125, 101};
        long j2 = 700458014;
        long j3 = (~W1.class.getName().length()) | 1802548221;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j5 = (j4 >>> 48) & 43690;
        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
        long j7 = (j6 | (j6 >>> 2)) & 252645135;
        long j8 = (j4 >>> 32) & 43690;
        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 43690;
        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        byte[] bArr2 = new byte[(((int) (((j17 | (j17 >>> 4)) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) + ((W1.class.getName().length() & 8651778) | (-2043281344))) ^ (-1342823338)];
        bArr2[0] = 88;
        bArr2[1] = 7;
        int length = (((~W1.class.getName().length()) | (-432101335)) & (-1471143696)) + ((W1.class.getName().length() & 138413264) | 1090522114);
        bArr2[(length - 380621584) - ((length & (-380621584)) * 2)] = -53;
        bArr2[3] = 89;
        bArr2[4] = ((((~W1.class.getName().length()) | 1607958527) - 1524071919) + ((W1.class.getName().length() & (-1603764092)) | 4198532)) ^ 1519873394;
        bArr2[5] = 23;
        bArr2[6] = 10;
        bArr2[7] = 14;
        v(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr3 = new byte[8];
        bArr3[0] = 92;
        bArr3[1] = -93;
        bArr3[2] = -62;
        int length2 = (((~W1.class.getName().length()) | 1847272019) & 546865297) + ((W1.class.getName().length() & 75546752) | 71389186);
        bArr3[(length2 | 618254480) - (length2 & 618254480)] = -7;
        bArr3[4] = 116;
        bArr3[5] = -105;
        bArr3[870249001 ^ ((((~W1.class.getName().length()) | 1822409375) & 571916837) + ((W1.class.getName().length() & 46149664) | 298332170))] = -8;
        bArr3[7] = -38;
        v(bArr3, new byte[]{114, -12, 85, 63, 108, -20, 5, 83});
        new String(bArr3, charset).intern();
        this.f407f = c0054l1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void v(byte[] bArr, byte[] bArr2) {
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
