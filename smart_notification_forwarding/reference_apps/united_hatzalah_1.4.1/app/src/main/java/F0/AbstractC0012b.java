package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0012b extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f464f;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x041f, code lost:
    
        if (r4 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0473, code lost:
    
        r8 = -1138188205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0470, code lost:
    
        if (r4 != 0) goto L12;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x03cb. Please report as an issue. */
    static {
        /*
            Method dump skipped, instructions count: 1444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.AbstractC0012b.<clinit>():void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0012b(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        long j2 = -1083349982;
        long length = (((~AbstractC0012b.class.getName().length()) | (-16777217)) - (-490824705)) + ((AbstractC0012b.class.getName().length() & 556269600) | (-1574174684));
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j4 = (j3 >>> 48) & 21845;
        long j5 = (j4 | (j4 >>> 1)) & 858993459;
        long j6 = (j5 | (j5 >>> 2)) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | (((j6 | (j6 >>> 4)) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = (j15 | (j15 >>> 2)) & 252645135;
        byte[] bArr = new byte[(int) (((j16 | (j16 >>> 4)) & 16711935) | ((((j13 >>> 4) | j13) & 16711935) << 8) | j10)];
        bArr[0] = 2;
        bArr[1] = 13;
        bArr[2] = -26;
        bArr[3] = 94;
        bArr[4] = -90;
        bArr[5] = -13;
        x(bArr, new byte[]{110, 98, -127, 57, -61, -127, 7, -98});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = {-72, 64, 6, -120, -18, -92, 124, -45};
        x(bArr2, new byte[]{-54, 37, 103, -21, -102, -51, 19, 1361582994 ^ ((((~AbstractC0012b.class.getName().length()) | 981987181) & 550952993) + ((AbstractC0012b.class.getName().length() & (-2041511936)) | (-1912536050)))});
        new String(bArr2, charset).intern();
        this.f464f = c0054l1;
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

    public final void A(C0031f2 c0031f2) {
        char c4;
        char c5;
        byte b4;
        char c6;
        char c7;
        byte[] bArr = new byte[6];
        bArr[0] = -4;
        bArr[1] = -39;
        bArr[2] = 35;
        long j2 = -1;
        long length = AbstractC0012b.class.getName().length();
        long j3 = ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j4 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j5 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j6 = j5 + (j4 | j3) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j7 = (j6 >>> 48) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = (j6 >>> 32) & 21845;
        long j11 = ((j10 >>> 1) | j10) & 858993459;
        long j12 = ((j11 >>> 2) | j11) & 252645135;
        long j13 = ((((j12 >>> 4) | j12) & 16711935) << 16) + ((((j9 >>> 4) | j9) & 16711935) << 24);
        long j14 = (j6 >>> 16) & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        long j17 = j6 & 21845;
        long j18 = ((j17 >>> 1) | j17) & 858993459;
        long j19 = ((j18 >>> 2) | j18) & 252645135;
        bArr[(((((int) ((((j19 >>> 4) | j19) & 16711935) + (((((j16 >>> 4) | j16) & 16711935) << 8) | j13))) | 973399783) & (-2138302740)) + ((AbstractC0012b.class.getName().length() & (-494258168)) | 1913792512)) ^ (-224510225)] = 5;
        bArr[4] = -98;
        bArr[5] = 87;
        byte[] bArr2 = new byte[8];
        int i = ((~AbstractC0012b.class.getName().length()) | 1272439873) & (-1906275807);
        int length2 = AbstractC0012b.class.getName().length() & (-2077155808);
        int i3 = ~(((AbstractC0012b.class.getName().length() | (-9507857)) | length2) - ((AbstractC0012b.class.getName().length() & 9507856) | length2));
        int i4 = -i;
        bArr2[(-1896767951) ^ (((~i4) & i3) - (i4 & (~i3)))] = -91;
        bArr2[1] = -116;
        int i5 = ~AbstractC0012b.class.getName().length();
        bArr2[2] = ((((AbstractC0012b.class.getName().length() | (-2139025263)) - (i5 | (-1551166243))) + (AbstractC0008a.f(AbstractC0012b.class, (-1551231779) | i5) + (AbstractC0012b.class.getName().length() & (-2139025263)))) + ((AbstractC0012b.class.getName().length() & 285835264) | 319324162)) ^ (-1819701003);
        bArr2[3] = 87;
        bArr2[4] = -14;
        bArr2[5] = 35;
        long j20 = 4375760;
        long j21 = (~AbstractC0012b.class.getName().length()) | (-86209636);
        long j22 = ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j23 = (j22 >>> 48) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = (j22 >>> 32) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = ((((j28 >>> 4) | j28) & 16711935) << 16) + ((((j25 >>> 4) | j25) & 16711935) << 24);
        long j30 = (j22 >>> 16) & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        long j33 = j22 & 43690;
        long j34 = ((j33 >>> 2) | (j33 >>> 1)) & 858993459;
        long j35 = ((j34 >>> 2) | j34) & 252645135;
        int length3 = AbstractC0012b.class.getName().length();
        int length4 = ((AbstractC0012b.class.getName().length() | 154690) - (length3 | 154690)) + AbstractC0008a.f(AbstractC0012b.class, length3) + (AbstractC0012b.class.getName().length() & 154690);
        int i6 = ((~length4) & 67115522) + length4 + ((int) ((((j35 >>> 4) | j35) & 16711935) + (((((j32 >>> 4) | j32) & 16711935) << 8) | j29)));
        bArr2[(i6 + 71491284) - ((71491284 & i6) * 2)] = 92;
        bArr2[7] = -91;
        r(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        C0054l1 c0054l1 = this.f464f;
        c0054l1.f573a.getClass();
        int i7 = AbstractC0041i0.f535a;
        byte[] bArr3 = {4, -124, 84, 58, 73, 66, -86, -83, 97, 117, -79, -39};
        byte[] bArr4 = new byte[12];
        int i8 = ((~AbstractC0012b.class.getName().length()) | (-105273436)) & 1896383617;
        int length5 = AbstractC0012b.class.getName().length();
        int length6 = 201595412 | (((AbstractC0012b.class.getName().length() | 4609) - (length5 | 4609)) + AbstractC0008a.f(AbstractC0012b.class, length5) + (AbstractC0012b.class.getName().length() & 4609));
        int i9 = -i8;
        int i10 = i9 | length6;
        bArr4[((i10 - (i9 * 2)) + ((length6 ^ i9) ^ i10)) ^ 2097979029] = -121;
        bArr4[1] = -67;
        bArr4[2] = 79;
        bArr4[3] = 70;
        bArr4[4] = 49;
        bArr4[5] = 2;
        bArr4[6] = -37;
        bArr4[7] = -87;
        bArr4[8] = 30;
        bArr4[9] = -20;
        bArr4[10] = -12;
        bArr4[11] = -91;
        r(bArr3, bArr4);
        d(new String(bArr3, charset).intern(), c0031f2);
        if (c0031f2.b()) {
            c4 = '\t';
            byte[] bArr5 = new byte[12];
            bArr5[0] = 12;
            bArr5[1] = -19;
            bArr5[2] = 95;
            bArr5[3] = -58;
            bArr5[4] = -20;
            bArr5[5] = -34;
            int i11 = ((~AbstractC0012b.class.getName().length()) | (-1087966738)) & 1241790473;
            c5 = 7;
            int length7 = AbstractC0012b.class.getName().length();
            bArr5[((((length7 & 1073744449) + 8390356) - (length7 & 576)) + i11) ^ 1250180827] = -27;
            bArr5[7] = 51;
            bArr5[8] = 2;
            bArr5[9] = -60;
            bArr5[10] = -100;
            int i12 = ~AbstractC0012b.class.getName().length();
            bArr5[((((i12 - 128682975) - (i12 & (-128682975))) & 169742728) + ((AbstractC0012b.class.getName().length() & 34210712) | (-2147483118))) ^ (-1977740399)] = -86;
            byte[] bArr6 = new byte[12];
            bArr6[0] = -113;
            b4 = -113;
            c6 = 11;
            long length8 = AbstractC0012b.class.getName().length();
            long j36 = (j5 | (j4 + j3)) + (((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
            long j47 = ((((j46 >>> 4) | j46) & 16711935) << 8) + j43;
            long j48 = j36 & 21845;
            long j49 = ((j48 >>> 1) | j48) & 858993459;
            long j50 = ((j49 >>> 2) | j49) & 252645135;
            bArr6[2117728698 ^ (((369688593 + (AbstractC0012b.class.getName().length() & 974188675)) + (((-r10) - 1) | (-369688593))) + ((((int) ((((j50 >>> 4) | j50) & 16711935) + j47)) | 1147998072) & 1748040107))] = 84;
            bArr6[2] = 72;
            bArr6[3] = -118;
            bArr6[4] = -42;
            int i13 = ~AbstractC0012b.class.getName().length();
            bArr6[((461505052 & (((~i13) & (-730942665)) + i13)) + ((AbstractC0012b.class.getName().length() & (-1954512855)) | (-2143256543))) ^ (-1681751496)] = 126;
            bArr6[6] = -96;
            bArr6[7] = 67;
            long j51 = 550603784;
            c7 = 5;
            long j52 = (~AbstractC0012b.class.getName().length()) | (-521339489);
            long j53 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j54 = (j53 >>> 48) & 43690;
            long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
            long j56 = (j55 | (j55 >>> 2)) & 252645135;
            long j57 = (j53 >>> 32) & 43690;
            long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
            long j59 = ((j58 >>> 2) | j58) & 252645135;
            long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) + (((j56 | (j56 >>> 4)) & 16711935) << 24);
            long j61 = (j53 >>> 16) & 43690;
            long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
            long j63 = ((j62 >>> 2) | j62) & 252645135;
            long j64 = j53 & 43690;
            long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
            long j66 = (j65 | (j65 >>> 2)) & 252645135;
            bArr6[8] = (((int) (((j66 | (j66 >>> 4)) & 16711935) | (((((j63 >>> 4) | j63) & 16711935) << 8) + j60))) + ((AbstractC0012b.class.getName().length() & 1122310) | 268460326)) ^ 819064149;
            bArr6[9] = 125;
            bArr6[10] = 8;
            bArr6[11] = -75;
            r(bArr5, bArr6);
            String intern = new String(bArr5, charset).intern();
            c0054l1.f573a.getClass();
            c(intern);
        } else {
            c4 = '\t';
            c5 = 7;
            b4 = -113;
            c6 = 11;
            c7 = 5;
        }
        if (c0031f2.a()) {
            c0054l1.f573a.getClass();
            byte[] bArr7 = {-34, -125, 31, -8, -116, -11, 22, -23, -58, -113, 34, -1};
            byte length9 = ((((~AbstractC0012b.class.getName().length()) | (-408332363)) & 1317153376) + ((AbstractC0012b.class.getName().length() & 135424192) | 537937034)) ^ 1855090311;
            byte[] bArr8 = new byte[12];
            bArr8[0] = -63;
            bArr8[1] = -70;
            bArr8[2] = -120;
            bArr8[3] = -124;
            bArr8[4] = -10;
            bArr8[c7] = 85;
            bArr8[6] = b4;
            bArr8[c5] = length9;
            bArr8[8] = -73;
            bArr8[c4] = -74;
            bArr8[10] = 98;
            bArr8[c6] = Byte.MAX_VALUE;
            r(bArr7, bArr8);
            c0054l1.c(new String(bArr7, charset).intern(), null);
        }
    }

    @Override // F0.T0, F0.T2
    public final boolean a() {
        return true;
    }
}
