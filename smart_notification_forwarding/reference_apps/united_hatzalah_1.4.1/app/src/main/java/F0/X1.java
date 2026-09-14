package F0;

import android.R;
import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class X1 {
    public static final C0072q i;

    /* renamed from: a, reason: collision with root package name */
    public final int f412a;

    /* renamed from: b, reason: collision with root package name */
    public final int f413b;

    /* renamed from: c, reason: collision with root package name */
    public final int f414c;

    /* renamed from: d, reason: collision with root package name */
    public final int f415d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f416e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f417f;

    /* renamed from: g, reason: collision with root package name */
    public final L2 f418g;

    /* renamed from: h, reason: collision with root package name */
    public final L2 f419h;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, F0.q] */
    static {
        long j2 = -1;
        long j3 = 3;
        long j4 = ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j5 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j6 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j7 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j6 + j5 + j4;
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
        int i3 = (((int) ((((j20 >>> 4) | j20) & 16711935) | ((((j17 >>> 4) | j17) & 16711935) << 8) | j14)) | 1170113642) & (-1285420992);
        long j21 = -1304393592;
        long j22 = (((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j6 + (j5 | j4);
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
        byte[] bArr = {11, 43, -17, 98, -11, -75, (i3 + (((int) ((((((j32 >>> 4) | j32) & 16711935) << 8) | j29) | (((j35 >>> 4) | j35) & 16711935))) | 33448)) ^ 1285387555, 73, -20, -34, -73, 51, -46, 52, 116, -50, -66, -92, -63, 108, -99, 41, -97, 32};
        byte[] bArr2 = new byte[24];
        bArr2[0] = 58;
        bArr2[1] = 5;
        bArr2[2] = -36;
        bArr2[3] = 76;
        bArr2[4] = -61;
        bArr2[5] = -101;
        bArr2[6] = -6;
        long j36 = 201347088;
        long j37 = 1;
        long j38 = (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j39 = (j38 >>> 48) & 43690;
        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
        long j41 = (j40 | (j40 >>> 2)) & 252645135;
        long j42 = (j38 >>> 32) & 43690;
        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
        long j44 = (j43 | (j43 >>> 2)) & 252645135;
        long j45 = (((j41 | (j41 >>> 4)) & 16711935) << 24) | (((j44 | (j44 >>> 4)) & 16711935) << 16);
        long j46 = (j38 >>> 16) & 43690;
        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
        long j48 = (j47 | (j47 >>> 2)) & 252645135;
        long j49 = j38 & 43690;
        long j50 = ((j49 >>> 2) | (j49 >>> 1)) & 858993459;
        long j51 = (j50 | (j50 >>> 2)) & 252645135;
        bArr2[(-1645062540) ^ (410124898 + (((int) (((j51 | (j51 >>> 4)) & 16711935) + (j45 | (((j48 | (j48 >>> 4)) & 16711935) << 8)))) | (-2055187439)))] = 103;
        bArr2[8] = -40;
        bArr2[9] = -16;
        bArr2[10] = -122;
        bArr2[11] = 29;
        bArr2[12] = -29;
        bArr2[13] = 5;
        bArr2[14] = 69;
        bArr2[15] = -4;
        bArr2[16] = -121;
        bArr2[17] = -118;
        bArr2[18] = -13;
        bArr2[19] = 66;
        bArr2[20] = -84;
        bArr2[21] = 7;
        bArr2[22] = -82;
        bArr2[23] = 23;
        d(bArr, bArr2);
        new String(bArr, StandardCharsets.UTF_8).intern();
        i = new Object();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00aa. Please report as an issue. */
    public X1(X509Certificate x509Certificate) {
        byte b4;
        char c4;
        char c5;
        char c6;
        char c7;
        byte b5;
        char c8;
        byte b6;
        char c9;
        char c10;
        char c11;
        long j2;
        byte b7 = 0;
        byte b8 = 1;
        int i3 = 2;
        char c12 = 3;
        char c13 = 4;
        char c14 = 5;
        byte[] bArr = {85, 73, 80, 70, 75, -117, -123, -103};
        byte[] bArr2 = {22, -84, 74, -104, -15, 29, -30, 6};
        byte[] bArr3 = null;
        int i4 = 0;
        int i5 = 1180709023;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i5 & 16777216) * (i5 | 16777216)) + ((i5 & (-16777217)) * ((~i5) & 16777216));
            int i9 = i5 >>> 8;
            int a2 = S.a(i9, i8, b8, ((-1) - i9) | ((-1) - i8));
            int i10 = (a2 ^ (-201803027)) + ((a2 & (-201803027)) * i3);
            switch ((i10 - 814310662) - ((i10 & (-814310662)) * i3)) {
                case -2000520841:
                    byte b9 = b7;
                    byte b10 = b8;
                    char c15 = c12;
                    char c16 = c14;
                    char c17 = c13;
                    int length = bArr4.length;
                    int i11 = 0 - (0 - i4);
                    byte b11 = (((double) ((byte) bArr3[((length & (~i11)) * 2) - (length ^ i11)])) > Double.NaN ? 1 : (((double) ((byte) bArr3[((length & (~i11)) * 2) - (length ^ i11)])) == Double.NaN ? 0 : -1)) <= -1 ? b9 : b10;
                    i5 = b11 != 0 ? b11 == 0 ? 1621215041 : 1565752577 : -1164716566;
                    i7 = i4;
                    c14 = c16;
                    c13 = c17;
                    c12 = c15;
                    b8 = b10;
                    b7 = b9;
                    i3 = 2;
                case -870579640:
                    byte b12 = b7;
                    char c18 = c12;
                    char c19 = c14;
                    char c20 = c13;
                    int i12 = (i6 - 1) - (i6 | (-4));
                    byte b13 = bArr3[i12];
                    int i13 = ((b13 & ForkServer.DONE) * (b13 | ForkServer.DONE)) + ((b13 & ForkServer.ERROR) * ((~b13) & 16777216));
                    int i14 = i6 + 3 + (((-1) - i6) | (-3));
                    int i15 = bArr3[i14] & ForkServer.ERROR;
                    int i16 = i15 * ((~i15) & 65536);
                    int i17 = ~((i13 | ((~i16) | (-1268032266))) - ((i16 & (-1268032266)) | i13));
                    int a4 = j3.a((-132004404) & i6, i6, 1, (-132004403) & i6);
                    int i18 = bArr3[a4] & ForkServer.ERROR;
                    int i19 = i18 * ((~i18) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i20 = (i19 + i17) - (i19 & i17);
                    int i21 = bArr3[i6] & ForkServer.ERROR;
                    int i22 = (i20 & (~i21)) + i21;
                    byte b14 = bArr4[i12];
                    int i23 = ((b14 & ForkServer.DONE) * (b14 | ForkServer.DONE)) + ((b14 & ForkServer.ERROR) * ((~b14) & 16777216));
                    int i24 = bArr4[i14] & ForkServer.ERROR;
                    int i25 = i24 * ((~i24) & 65536);
                    int i26 = ~((i23 | ((-1355861741) | (~i25))) - ((i25 & (-1355861741)) | i23));
                    int i27 = bArr4[a4] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int a5 = S.a(i28, i26, 1, ((-1) - i28) | ((-1) - i26));
                    int i29 = (a5 - 1) - ((~(bArr4[i6] & ForkServer.ERROR)) | a5);
                    int i30 = i22 << ((i22 > Double.NaN ? 1 : (i22 == Double.NaN ? 0 : -1)) >>> 31);
                    int i31 = (i30 ^ (-418000873)) + ((i30 & (-418000873)) * 2);
                    int i32 = (i31 + i29) - ((i31 & i29) * 2);
                    bArr4[i6] = (byte) i32;
                    bArr4[a4] = (byte) (i32 >>> 8);
                    bArr4[i14] = (byte) (i32 >>> 16);
                    bArr4[i12] = (byte) (i32 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length2 = bArr4.length;
                    int a6 = AbstractC0044j.a(bArr4.length);
                    i5 = (((((long) i6) > ((long) (((length2 & (~a6)) * 2) - (length2 ^ a6))) ? 1 : (((long) i6) == ((long) (((length2 & (~a6)) * 2) - (length2 ^ a6))) ? 0 : -1)) >>> 31) & 1) != 0 ? 1910359311 : 1621215041;
                    c14 = c19;
                    c13 = c20;
                    c12 = c18;
                    b8 = 1;
                    b7 = b12;
                    i3 = 2;
                case -97532338:
                    b4 = b7;
                    c7 = c12;
                    c5 = c14;
                    c4 = 6;
                    c6 = 4;
                    int length3 = bArr4.length % 4;
                    int i33 = ((length3 > 1 ? 1 : (length3 == 1 ? 0 : -1)) >>> 31) & 1;
                    int i34 = i33 == 0 ? 1621215041 : 986083301;
                    i4 = length3;
                    if (i33 != 0) {
                        i5 = i34;
                        c14 = c5;
                        c13 = c6;
                        c12 = c7;
                        b7 = b4;
                        i3 = 2;
                        b8 = 1;
                    }
                    i5 = -1138188205;
                    c14 = c5;
                    c13 = c6;
                    c12 = c7;
                    b7 = b4;
                    i3 = 2;
                    b8 = 1;
                case 298177592:
                    byte b15 = b7;
                    int i35 = i3;
                    char c21 = c12;
                    char c22 = c14;
                    int length4 = bArr4.length;
                    int i36 = 0 - i7;
                    int a7 = AbstractC0014b1.a((length4 & 2) | D1.a(i36, length4), i36 * 3);
                    byte b16 = bArr3[a7];
                    int length5 = bArr4.length;
                    int i37 = 0 - i36;
                    int i38 = i37 | length5;
                    byte b17 = bArr3[D.a(i37, i35, i38, (length5 ^ i37) ^ i38)];
                    bArr3[a7] = (byte) (((byte) (b17 ^ b16)) + ((byte) (((byte) i35) * ((byte) (b17 & b16)))));
                    i5 = 1565752577;
                    c14 = c22;
                    c12 = c21;
                    b7 = b15;
                    i3 = 2;
                    b8 = 1;
                    c13 = 4;
                case 373627814:
                    break;
                case 975213712:
                    int length6 = bArr4.length;
                    int i39 = 0 - i7;
                    int length7 = bArr4.length;
                    int i40 = ~i39;
                    byte b18 = bArr4[((length7 | i39) - ((i40 & (-656070458)) & length7)) + ((i39 | (-656070458)) & length7)];
                    int length8 = bArr4.length;
                    byte b19 = bArr3[(length8 ^ i40) + ((length8 | i39) * 2) + b8];
                    byte b20 = b8;
                    bArr4[((length6 | i39) * i3) - (length6 ^ i39)] = (byte) (((byte) (b19 - b18)) + ((byte) (((byte) i3) * ((byte) ((~b19) & b18)))));
                    i4 = (~i7) + (i7 * 2);
                    int i41 = ((i7 > i3 ? 1 : (i7 == i3 ? 0 : -1)) >>> 31) & 1;
                    i5 = i41 != 0 ? 986083301 : 1621215041;
                    if (i41 != 0) {
                        b8 = b20;
                        c12 = 3;
                        c14 = 5;
                        c13 = 4;
                    } else {
                        b4 = b7;
                        c4 = 6;
                        c5 = 5;
                        c6 = 4;
                        c7 = 3;
                        i5 = -1138188205;
                        c14 = c5;
                        c13 = c6;
                        c12 = c7;
                        b7 = b4;
                        i3 = 2;
                        b8 = 1;
                    }
                case 1548321255:
                    bArr4 = bArr;
                    i6 = b7;
                    bArr3 = bArr2;
                    i5 = 1910359311;
                default:
                    i5 = 1621215041;
            }
            kotlin.jvm.internal.j.e(x509Certificate, new String(bArr, StandardCharsets.UTF_8).intern());
            ArrayList g3 = D1.e(b(x509Certificate)).g();
            this.f412a = D1.g((M1) g3.get(b7));
            this.f413b = D1.g((M1) g3.get(b8));
            this.f414c = D1.g((M1) g3.get(i3));
            this.f415d = D1.g((M1) g3.get(3));
            this.f416e = D1.d((M1) g3.get(4));
            this.f417f = D1.d((M1) g3.get(5));
            this.f418g = new L2((M1) g3.get(6), b7);
            this.f419h = new L2((M1) g3.get(7), b7);
            HashSet hashSet = new HashSet();
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            byte b21 = 9;
            char c23 = ' ';
            if (criticalExtensionOIDs != null) {
                c8 = 23;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = criticalExtensionOIDs.iterator();
                while (true) {
                    b5 = b7;
                    if (it.hasNext()) {
                        Object next = it.next();
                        int i42 = this.f415d;
                        long j3 = -2025874673;
                        long j4 = (((((~i42) - i42) + i42) | 1875227325) & 118951968) + ((i42 & 3278850) | (-2144826622));
                        long j5 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j6 = (j5 >>> 48) & 21845;
                        long j7 = ((j6 >>> 1) | j6) & 858993459;
                        long j8 = ((j7 >>> i3) | j7) & 252645135;
                        long j9 = (j5 >>> 32) & 21845;
                        long j10 = ((j9 >>> 1) | j9) & 858993459;
                        long j11 = ((j10 >>> i3) | j10) & 252645135;
                        long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
                        long j13 = (j5 >>> 16) & 21845;
                        long j14 = ((j13 >>> 1) | j13) & 858993459;
                        long j15 = ((j14 >>> i3) | j14) & 252645135;
                        long j16 = j5 & 21845;
                        long j17 = ((j16 >>> 1) | j16) & 858993459;
                        long j18 = ((j17 >>> i3) | j17) & 252645135;
                        byte[] bArr5 = new byte[9];
                        bArr5[b5] = -115;
                        bArr5[1] = -72;
                        bArr5[i3] = -95;
                        bArr5[3] = -109;
                        bArr5[4] = 95;
                        bArr5[5] = -102;
                        bArr5[6] = 23;
                        bArr5[7] = (int) ((((((j15 >>> 4) | j15) & 16711935) << 8) + j12) | (((j18 >>> 4) | j18) & 16711935));
                        bArr5[8] = 99;
                        c(bArr5, new byte[]{3, -120, 38, -40, 49, -79, -89, -66, 86});
                        if (!kotlin.jvm.internal.j.a((String) next, new String(bArr5, StandardCharsets.UTF_8).intern())) {
                            arrayList.add(next);
                        }
                        b7 = b5;
                    } else {
                        b6 = -109;
                        c9 = '1';
                        c10 = 16;
                        c11 = '0';
                        j2 = 16711935;
                        hashSet.addAll(arrayList);
                    }
                }
            } else {
                b5 = b7;
                c8 = 23;
                b6 = -109;
                c9 = '1';
                c10 = 16;
                c11 = '0';
                j2 = 16711935;
            }
            Set<String> nonCriticalExtensionOIDs = x509Certificate.getNonCriticalExtensionOIDs();
            if (nonCriticalExtensionOIDs != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : nonCriticalExtensionOIDs) {
                    String str = (String) obj;
                    byte[] bArr6 = {-79, -60, -99, -73, 69, -3, -38, -72, 83, -42, 113, 53, 44, 47, 75, 10, -84, 10, 17, -59, -41, 88, -43, -51};
                    byte[] bArr7 = new byte[24];
                    bArr7[b5] = 100;
                    bArr7[1] = -100;
                    bArr7[i3] = 60;
                    bArr7[3] = 52;
                    bArr7[4] = -33;
                    bArr7[5] = -60;
                    bArr7[6] = 125;
                    bArr7[7] = 53;
                    bArr7[8] = -61;
                    bArr7[b21] = -19;
                    bArr7[10] = -46;
                    bArr7[11] = -71;
                    bArr7[12] = -31;
                    bArr7[13] = 45;
                    byte b22 = b21;
                    char c24 = c23;
                    long j19 = -1609299561;
                    long j20 = -2;
                    long j21 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c11) + (((((((((j19 >>> c10) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c24) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c10) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845)) + (((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c11) | ((((((((j20 >>> c10) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c24) | (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c10) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845)));
                    long j22 = (j21 >>> c11) & 43690;
                    long j23 = ((j22 >>> i3) | (j22 >>> 1)) & 858993459;
                    long j24 = ((j23 >>> i3) | j23) & 252645135;
                    long j25 = (j21 >>> c24) & 43690;
                    long j26 = ((j25 >>> i3) | (j25 >>> 1)) & 858993459;
                    long j27 = ((j26 >>> i3) | j26) & 252645135;
                    long j28 = ((((j27 >>> 4) | j27) & j2) << c10) | ((((j24 >>> 4) | j24) & j2) << 24);
                    long j29 = (j21 >>> c10) & 43690;
                    long j30 = ((j29 >>> i3) | (j29 >>> 1)) & 858993459;
                    long j31 = ((j30 >>> i3) | j30) & 252645135;
                    long j32 = j21 & 43690;
                    long j33 = ((j32 >>> i3) | (j32 >>> 1)) & 858993459;
                    long j34 = (j33 | (j33 >>> i3)) & 252645135;
                    bArr7[(-518743087) ^ (1090556489 + ((int) (((j34 | (j34 >>> 4)) & j2) | (((((j31 >>> 4) | j31) & j2) << 8) + j28))))] = -116;
                    bArr7[15] = 94;
                    bArr7[c10] = 105;
                    bArr7[17] = -42;
                    bArr7[18] = -80;
                    bArr7[19] = b22;
                    bArr7[20] = 74;
                    bArr7[21] = 104;
                    bArr7[22] = 118;
                    int i43 = this.f414c;
                    bArr7[889344465 ^ ((((~i43) | (-482296240)) & 285233478) + (((i43 + 335560966) - (i43 | 335560966)) | 604110976))] = 7;
                    c(bArr6, bArr7);
                    Charset charset = StandardCharsets.UTF_8;
                    if (kotlin.jvm.internal.j.a(str, new String(bArr6, charset).intern())) {
                        b21 = b22;
                        c23 = c24;
                    } else {
                        byte[] bArr8 = new byte[24];
                        bArr8[b5] = 88;
                        bArr8[1] = -32;
                        bArr8[i3] = -48;
                        bArr8[3] = 31;
                        bArr8[4] = -82;
                        bArr8[5] = 125;
                        bArr8[6] = 42;
                        bArr8[7] = 58;
                        bArr8[8] = 65;
                        bArr8[b22] = -114;
                        bArr8[10] = 114;
                        bArr8[11] = 4;
                        int i44 = this.f413b;
                        long j35 = 84770185;
                        int i45 = i3;
                        long j36 = ~i44;
                        long b23 = c3.b((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c11, ((((((((j35 >>> c10) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c24) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c10) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845)), ((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c11) | ((((((((j36 >>> c10) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c24) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c10) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845), 6148914691236517205L);
                        long j37 = (b23 >>> c11) & 43690;
                        long j38 = ((j37 >>> i45) | (j37 >>> 1)) & 858993459;
                        long j39 = ((j38 >>> i45) | j38) & 252645135;
                        long j40 = (b23 >>> c24) & 43690;
                        long j41 = ((j40 >>> i45) | (j40 >>> 1)) & 858993459;
                        long j42 = ((j41 >>> i45) | j41) & 252645135;
                        long j43 = ((((j42 >>> 4) | j42) & j2) << c10) + ((((j39 >>> 4) | j39) & j2) << 24);
                        long j44 = (b23 >>> c10) & 43690;
                        long j45 = ((j44 >>> i45) | (j44 >>> 1)) & 858993459;
                        long j46 = ((j45 >>> i45) | j45) & 252645135;
                        long j47 = b23 & 43690;
                        long j48 = ((j47 >>> i45) | (j47 >>> 1)) & 858993459;
                        long j49 = ((j48 >>> i45) | j48) & 252645135;
                        long j50 = 1296402918;
                        long j51 = (((int) ((((j49 >>> 4) | j49) & j2) | (((((j46 >>> 4) | j46) & j2) << 8) + j43))) & 88410402) + ((138444834 & i44) | 1207992520);
                        long j52 = (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c11) | ((((((((j50 >>> c10) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c24) | (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c10) + ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845))) + (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c11) | ((((((((j51 >>> c10) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c24) | (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845) << c10) + ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c9) & 21845)));
                        long j53 = (j52 >>> c11) & 21845;
                        long j54 = (j53 | (j53 >>> 1)) & 858993459;
                        long j55 = (j54 | (j54 >>> i45)) & 252645135;
                        long j56 = (j52 >>> c24) & 21845;
                        long j57 = ((j56 >>> 1) | j56) & 858993459;
                        long j58 = ((j57 >>> i45) | j57) & 252645135;
                        long j59 = (((j55 | (j55 >>> 4)) & j2) << 24) | ((((j58 >>> 4) | j58) & j2) << c10);
                        long j60 = (j52 >>> c10) & 21845;
                        long j61 = ((j60 >>> 1) | j60) & 858993459;
                        long j62 = ((j61 >>> i45) | j61) & 252645135;
                        long j63 = j52 & 21845;
                        long j64 = (j63 | (j63 >>> 1)) & 858993459;
                        long j65 = (j64 | (j64 >>> i45)) & 252645135;
                        bArr8[(int) (((j65 | (j65 >>> 4)) & j2) + (j59 | ((((j62 >>> 4) | j62) & j2) << 8)))] = 58;
                        bArr8[13] = 105;
                        bArr8[14] = b5;
                        bArr8[15] = -77;
                        bArr8[c10] = 31;
                        bArr8[17] = -78;
                        bArr8[18] = -125;
                        bArr8[19] = 80;
                        bArr8[20] = -117;
                        bArr8[21] = -103;
                        bArr8[22] = b6;
                        int a8 = V2.a(293743629, -1074283057, -1368026686);
                        bArr8[(((~a8) & 1368026665) - (1368026665 & a8)) + a8] = 41;
                        byte[] bArr9 = new byte[24];
                        bArr9[b5] = -51;
                        bArr9[1] = -29;
                        bArr9[i45] = 113;
                        bArr9[3] = -84;
                        bArr9[4] = 100;
                        bArr9[5] = 69;
                        bArr9[6] = -83;
                        bArr9[7] = -78;
                        bArr9[8] = -47;
                        bArr9[b22] = 85;
                        bArr9[10] = -43;
                        bArr9[11] = 72;
                        bArr9[12] = -17;
                        bArr9[13] = 103;
                        int i46 = this.f415d;
                        bArr9[1403051479 ^ ((((~i46) | (-1727828179)) & 1126206681) + ((i46 & 1377866192) | 276844800))] = 67;
                        bArr9[15] = 39;
                        bArr9[c10] = -6;
                        bArr9[17] = -79;
                        bArr9[18] = -57;
                        bArr9[19] = -100;
                        bArr9[20] = 30;
                        bArr9[21] = -87;
                        bArr9[22] = 55;
                        bArr9[c8] = -71;
                        c(bArr8, bArr9);
                        if (!kotlin.jvm.internal.j.a(str, new String(bArr8, charset).intern())) {
                            arrayList2.add(obj);
                        }
                        b21 = b22;
                        c23 = c24;
                        i3 = i45;
                    }
                }
                hashSet.addAll(arrayList2);
                return;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
        int length;
        int i3;
        int length2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ~X1.class.getName().length();
        int length3 = (((~(((X1.class.getName().length() | 70245657) | i8) - (i8 | (X1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((X1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(X1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((X1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~X1.class.getName().length()) | (-576567005)) & 276971586) + ((X1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~X1.class.getName().length()) | (-1157759625)) & 1755853004) + ((X1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i9 = ((~X1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = X1.class.getName().length();
        int i10 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i9);
        int length8 = ((((~X1.class.getName().length()) | (-1064961)) + 689325073) + ((X1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i11 = ((~X1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = X1.class.getName().length();
        int i12 = (i11 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i12) {
                case -2143294076:
                    int i13 = ~X1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (X1.class.getName().length() & 268439810) | 285217280;
                        int i14 = -((i13 | (-1553600102)) - (((-1553600360) | i13) ^ 536887698));
                        i6 = (((~i14) & length10) * 2) - (i14 ^ length10);
                        i7 = -1524017045;
                        i12 = i7 ^ i6;
                    } else {
                        length = ((i13 | (-747233512)) & (-1862204400)) + ((X1.class.getName().length() & 1073807362) | 1116733474);
                        i3 = -375509041;
                        i12 = length ^ i3;
                    }
                case -2038999444:
                    int i15 = ~X1.class.getName().length();
                    int length11 = (161497089 & (((((X1.class.getName().length() & (~i15)) & 797295576) + 797295576) + i15) - ((X1.class.getName().length() | i15) & 797295576))) + ((X1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~X1.class.getName().length()) | (-1085986263)) & 1078327440) + ((X1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i10);
                    int i16 = ~X1.class.getName().length();
                    int length12 = length5 >>> ((((~(((X1.class.getName().length() | 626856794) | i16) - ((X1.class.getName().length() & (-626856795)) | i16))) & 957405457) + ((X1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~X1.class.getName().length()) | 1248713193) & 826417528) + ((X1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i17 = -length12;
                    int i18 = i17 | s3;
                    int i19 = (i18 - (i17 * 2)) + ((i17 ^ s3) ^ i18);
                    int i20 = -B0.a(i19 | (~a2), i19 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i20) | (i20 & 2)), 1);
                    int i21 = ((~X1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (X1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i21) + (i21 | length13)))) + sArr[((((~X1.class.getName().length()) | (-1005965450)) & 153223237) + ((X1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i10 | length6) - ((X1.class.getName().length() & (~length6)) & i10)) + ((X1.class.getName().length() | length6) & i10))) ^ ((length6 >>> (((((~X1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((X1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~X1.class.getName().length()) | (-23496740)) & 827084804) + ((X1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i22 = ((~X1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (X1.class.getName().length() & 403838542) | 268582982;
                    int i23 = -i22;
                    int i24 = (((~i23) & length14) * 2) - (i23 ^ length14);
                    i10 = (short) U0.a(1691170566 & i24, (-1691170567) - i24, i10);
                    length8++;
                    length = (((~X1.class.getName().length()) | (-961655275)) & 25184460) + ((X1.class.getName().length() & 150995145) | 140771329);
                    i3 = 1965034008;
                    i12 = length ^ i3;
                case -1809249287:
                    byte b4 = bArr[(((((~X1.class.getName().length()) | 1233459797) & 125923146) + ((X1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~X1.class.getName().length()) | (-7107622)) & 402932290) + ((X1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((X1.class.getName().length() | length15) - (b4 | length15)) + I2.a(X1.class, b4) + (X1.class.getName().length() & length15);
                    int length17 = ((((~X1.class.getName().length()) | (-81143879)) & 438583424) + ((X1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i25 = ~X1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((X1.class.getName().length() | (-2105278367)) - (i25 | (-1545180443))) + (I2.a(X1.class, 568748773 | i25) + (X1.class.getName().length() & (-2105278367)))) + ((X1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~X1.class.getName().length()) | (-1592082969)) & 140665109) + ((X1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i26 = ~X1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i26) & (-569955033)) + i26) | 2038255548) - 2038255548) + ((X1.class.getName().length() & 144806464) | 136645376));
                    int i27 = -length3;
                    int i28 = i27 | length18;
                    byte b6 = bArr[(i28 - (i27 * 2)) + ((length18 ^ i27) ^ i28)];
                    int i29 = (((-199685676) | r7) - 1591672428) - ((~X1.class.getName().length()) | (-180811308));
                    int length19 = (X1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i29) - ((X1.class.getName().length() & (~i29)) & length19)) + (length19 & (i29 | X1.class.getName().length()))));
                    int i30 = ((~X1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (X1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i30) + (i30 | length21))) + length3] & (((((~X1.class.getName().length()) | 75364313) & 1242301609) + ((X1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = X1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((X1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i31 = ~X1.class.getName().length();
                    i10 = 758110381 ^ (((((-1343875612) | i31) + 311432716) - (i31 | (-1074391060))) + ((X1.class.getName().length() & 273678921) | (-1069545407)));
                    int i32 = ~X1.class.getName().length();
                    int length24 = 1409942802 & (((((X1.class.getName().length() & (~i32)) & 91135407) + 91135407) + i32) - ((i32 | X1.class.getName().length()) & 91135407));
                    int length25 = (X1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i33 = -length24;
                    length8 = (-684063310) ^ (((~i33) & length25) - (i33 & (~length25)));
                    length2 = (((~X1.class.getName().length()) | (-537919489)) - (-806798471)) + ((X1.class.getName().length() & 674768897) | 153626665);
                    i4 = 1174056570 - length2;
                    i5 = -1174056571;
                    i12 = ((length2 & i5) * 2) + i4;
                case -1740520186:
                    sArr = new short[((((~X1.class.getName().length()) | (-382746167)) & 102532165) + ((X1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~X1.class.getName().length()) | (-6036961)) & 1233145505) + ((X1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i34 = ((~X1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = X1.class.getName().length() & 268460041;
                    i6 = (((((X1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | X1.class.getName().length()) & 4218888)) + i34;
                    i7 = 434661073;
                    i12 = i7 ^ i6;
                case -1489518479:
                    int length27 = X1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((X1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~X1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((X1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i35 = ~X1.class.getName().length();
                    int i36 = 73539736 & (((~i35) & (-1772650326)) + i35);
                    int length30 = (X1.class.getName().length() & 35664144) | 33608448;
                    int i37 = -i36;
                    byte b7 = bArr2[((107148186 ^ ((((~i37) & length30) * 2) - (i37 ^ length30))) * length3) + ((((I2.a(X1.class, -1) | (-532481)) - (-67641369)) + ((X1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i38 = ~X1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i38 + 1314070430) - (i38 & 1314070430))) + ((X1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(X1.class, -1) | (-33554434)) - (-1107366402)) + ((X1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(X1.class, -1) | (-167014194)) & 1157999680) + ((X1.class.getName().length() & 159661328) | (-2004872944));
                    i3 = -533943416;
                    i12 = length ^ i3;
                case -473033593:
                    int i39 = -length3;
                    int i40 = -bArr.length;
                    int i41 = i40 | i39;
                    int i42 = (i41 - (i40 * 2)) + ((i40 ^ i39) ^ i41);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = X1.class.getName().length();
                    bArr[i42] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((X1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(X1.class, -1) | 114408723) & 1183666176;
                    int length33 = X1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i3 = 836032333;
                    i12 = length ^ i3;
                case 766056152:
                    int i43 = ((~X1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = X1.class.getName().length();
                    int i44 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i44) & 608439588) + i44) + i43))) {
                        int i45 = ((~X1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (X1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i45 | length35, 2, (~i45) ^ length35);
                        i3 = -717449014;
                    } else {
                        length = (((~X1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((X1.class.getName().length() & 1074350177) | 1342720098);
                        i3 = -887872332;
                    }
                    i12 = length ^ i3;
                case 974072829:
                    int length36 = bArr.length;
                    int i46 = ((~X1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (X1.class.getName().length() & 251684176) | 1694512896;
                    int i47 = -i46;
                    length3 = length36 % (1864794098 ^ (((~i47) & length37) - (i47 & (~length37))));
                    length = (((~X1.class.getName().length()) | 991120067) & (-2113137661)) + ((X1.class.getName().length() & (-1878240248)) | 285229064);
                    i3 = -195569723;
                    i12 = length ^ i3;
                case 998066383:
                    length3 = (((AbstractC0008a.f(X1.class, -1) | 314136709) & 371231304) + (((X1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~X1.class.getName().length()) | 366661365) & 1344150018) + ((X1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~X1.class.getName().length()) | (-1359635359)) & 49026131) + ((X1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i3 = 1002689495;
                    i12 = length ^ i3;
                case 1314339506:
                    break;
                case 1734050766:
                    int i48 = ~X1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = X1.class.getName().length();
                        length = ((i48 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i3 = -115901203;
                        i12 = length ^ i3;
                    } else {
                        int length39 = (X1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i49 = -((i48 | 1510858717) & 403833600);
                        i6 = ((~i49) & length39) - (i49 & (~length39));
                        i7 = 2001041846;
                        i12 = i7 ^ i6;
                    }
                case 1771480224:
                    bArr[(((((~X1.class.getName().length()) | 1110430873) & 1241612298) + ((X1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~X1.class.getName().length()) | 1603962366) & 25199440) + (((X1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~X1.class.getName().length()) | (-1388708984)) & 706816128) + ((X1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i50 = ((~X1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = X1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i50 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~X1.class.getName().length()) | 2113158628) & 1026558002) + ((X1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~X1.class.getName().length()) | 715175224) & 136512788) + ((X1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i51 = ((~X1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = X1.class.getName().length();
                    int i52 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i53 = -i51;
                    bArr[a4] = (byte) ((V2.a(~i53, i52, (i52 + i53) + 1) ^ 955811810) & length6);
                    int length44 = (((((~X1.class.getName().length()) | (-1084937228)) & 438503696) + ((X1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i54 = ~X1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((X1.class.getName().length() | 674349280) - (i54 | 1869872636)) + (AbstractC0008a.f(X1.class, 1197735420 | i54) + (X1.class.getName().length() & 674349280))) + ((X1.class.getName().length() & 1754529808) | 1418461202)));
                    int i55 = ((~X1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (X1.class.getName().length() & 545800290) | (-1442676670);
                    int i56 = -i55;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i56) & length46) - (i56 & (~length46)))));
                    length3 += 4;
                    length = (((~X1.class.getName().length()) | (-171976913)) & 318775824) + ((X1.class.getName().length() & 33562640) | 136194);
                    i3 = -1824662634;
                    i12 = length ^ i3;
                case 2093236949:
                    if (length8 < (((((~X1.class.getName().length()) | (-616910267)) & 1303391760) + ((X1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~X1.class.getName().length()) | 1297715640) & 556926729) + ((X1.class.getName().length() & 874653185) | 335552516);
                        i4 = (-1287294623) - length2;
                        i5 = 1287294622;
                        i12 = ((length2 & i5) * 2) + i4;
                    } else {
                        int i57 = ~X1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i57 + (((-i57) - 1) | 1207265904))) + ((X1.class.getName().length() & 1292960864) | 150996032);
                        i3 = 612868558;
                        i12 = length ^ i3;
                    }
                default:
                    int i58 = ~X1.class.getName().length();
                    int i59 = (((-313266948) | i58) + 45165696) - (i58 | (-269226756));
                    length = D.a(i59, 3, -D1.a(i59, (X1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i3 = -361272203;
                    i12 = length ^ i3;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
        boolean z3;
        int i3;
        byte[] bArr3 = null;
        int i4 = -1003175592;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i4 & 16777216) * (i4 | 16777216)) + ((i4 & (-16777217)) * ((~i4) & 16777216));
            int i9 = i4 >>> 8;
            int i10 = ~((((~i9) | (-1095531540)) | i8) - ((i9 & (-1095531540)) | i8));
            int i11 = (-1171264002) - ((i10 & 2) | ((-130029571) - i10));
            switch ((-1109882652) ^ ((~i11) + ((i11 | 1) * 2))) {
                case -1922532006:
                    byte[] bArr5 = bArr3;
                    int length = bArr4.length;
                    int i12 = 0 - i5;
                    if ((bArr5[AbstractC0014b1.a((length & 2) | D1.a(i12, length), i12 * 3)] > Double.NaN ? 1 : (bArr5[AbstractC0014b1.a((length & 2) | D1.a(i12, length), i12 * 3)] == Double.NaN ? 0 : -1)) <= -1) {
                        i4 = -1671996003;
                    } else {
                        i4 = 935800592;
                    }
                    i6 = i5;
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
                        i3 = -1515449616;
                    } else {
                        i3 = 935800592;
                    }
                    if (z3) {
                        i4 = i3;
                    } else {
                        i4 = -10521562;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i7 = 0;
                case -497756741:
                    byte[] bArr6 = bArr3;
                    int length4 = bArr4.length;
                    int i13 = 0 - i6;
                    int i14 = ((length4 | i13) * 2) - (length4 ^ i13);
                    byte b4 = bArr6[i14];
                    int length5 = bArr4.length;
                    byte b5 = bArr6[((i13 | length5) - ((1163302289 & (~i13)) & length5)) + ((i13 | 1163302289) & length5)];
                    bArr6[i14] = (byte) (((byte) (((byte) (b5 ^ (~b4))) + ((byte) (((byte) 2) * ((byte) (b5 | b4)))))) + ((byte) 1));
                    bArr3 = bArr6;
                    i4 = 935800592;
                case 256719606:
                    int i15 = (i7 - 1) - (i7 | (-4));
                    byte b6 = bArr3[i15];
                    int i16 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i17 = i7 + 2;
                    int i18 = i17 - (i7 & 2);
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int a2 = S.a(i20, i16, 1, ((-1) - i20) | ((-1) - i16));
                    int i21 = i17 + (((-1) - i7) | (-2));
                    int i22 = bArr3[i21] & ForkServer.ERROR;
                    int i23 = i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i24 = (i23 - 1) - ((~a2) | i23);
                    int i25 = bArr3[i7] & ForkServer.ERROR;
                    int i26 = ~((i25 | ((~i24) | (-755325340))) - ((i24 & (-755325340)) | i25));
                    byte b7 = bArr4[i15];
                    int i27 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i28 = bArr4[i18] & ForkServer.ERROR;
                    int i29 = i28 * ((~i28) & 65536);
                    int i30 = bArr4[i21] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i32 = bArr4[i7] & ForkServer.ERROR;
                    byte[] bArr7 = bArr3;
                    int i33 = i26 << ((i26 > Double.NaN ? 1 : (i26 == Double.NaN ? 0 : -1)) >>> 31);
                    int i34 = (-659933419) - ((1983400305 - i27) | (i27 & 2));
                    int i35 = (i34 ^ (~i29)) + ((i34 | i29) * 2) + 1;
                    int i36 = (i35 ^ i32) + ((i35 & i32) * 2);
                    int i37 = ((i36 | i31) - (((-2109111237) & (~i31)) & i36)) + ((i31 | (-2109111237)) & i36);
                    int a4 = E1.a(i33 | i37, i33, i37);
                    bArr4[i7] = (byte) a4;
                    bArr4[i21] = (byte) (a4 >>> 8);
                    bArr4[i18] = (byte) (a4 >>> 16);
                    bArr4[i15] = (byte) (a4 >>> 24);
                    i7 = (i7 ^ 4) + ((i7 & 4) * 2);
                    int length6 = bArr4.length;
                    int length7 = 0 - (bArr4.length % 4);
                    int i38 = ((i7 > (((length6 | length7) * 2) - (length6 ^ length7)) ? 1 : (i7 == (((length6 | length7) * 2) - (length6 ^ length7)) ? 0 : -1)) >>> 31) & 1;
                    if (i38 != 0) {
                        i4 = -1515449616;
                    } else {
                        i4 = 935800592;
                    }
                    bArr3 = bArr7;
                    if (i38 == 0) {
                        i4 = -10521562;
                    }
                case 1429728656:
                    i5 = bArr4.length % 4;
                    int i39 = 1 & ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31);
                    if (i39 != 0) {
                        i4 = -1216566512;
                    } else {
                        i4 = 935800592;
                    }
                    if (i39 == 0) {
                        i4 = -1058029970;
                    }
                case 1870596681:
                    break;
                case 1879000533:
                    int length8 = bArr4.length;
                    int i40 = 0 - i6;
                    int i41 = 0 - i40;
                    int i42 = i41 | length8;
                    int i43 = (length8 ^ i41) ^ i42;
                    int i44 = i41 * 2;
                    int length9 = bArr4.length;
                    byte b8 = bArr4[(i41 ^ length9) - (((~length9) & i41) * 2)];
                    int length10 = bArr4.length;
                    byte b9 = bArr3[((i40 | length10) * 2) - (length10 ^ i40)];
                    bArr4[(i42 - i44) + i43] = (byte) (((((byte) (~b9)) + ((byte) (((byte) 2) * ((byte) (b9 | 1))))) ^ b8) ^ 1);
                    i5 = (~i6) + (i6 * 2);
                    int i45 = 1 & ((i6 > 2 ? 1 : (i6 == 2 ? 0 : -1)) >>> 31);
                    if (i45 != 0) {
                        i4 = -1216566512;
                    } else {
                        i4 = 935800592;
                    }
                    if (i45 == 0) {
                        i4 = -1058029970;
                    }
                default:
                    i4 = 935800592;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
        int i3;
        byte[] bArr3 = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = -585497720;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i7 & 16777216) * (i7 | 16777216)) + ((i7 & (-16777217)) * ((~i7) & 16777216));
            int i9 = i7 >>> 8;
            int i10 = ~((((~i9) | (-238348293)) | i8) - ((i9 & (-238348293)) | i8));
            int i11 = (-1081514022) - ((i10 & 2) | ((-10362931) - i10));
            int a2 = E1.a(i11 | (-428181225), i11, -428181225);
            int i12 = 2100390411;
            int i13 = -897645243;
            boolean z3 = true;
            switch (a2) {
                case -1819084085:
                    int length = bArr3.length;
                    int i14 = 0 - i4;
                    int length2 = bArr3.length;
                    int i15 = 0 - i14;
                    byte b4 = bArr3[(length2 & (~i15)) - ((~length2) & i15)];
                    int length3 = bArr3.length;
                    byte b5 = bArr4[((length3 | i14) - (((-1678010279) & (~i14)) & length3)) + ((i14 | (-1678010279)) & length3)];
                    bArr3[((length | i14) * 2) - (length ^ i14)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - b5)) - b4);
                    i6 = 4 - ((5 - i4) | (i4 & 2));
                    int i16 = ((i4 > 2 ? 1 : (i4 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i16 == 0) {
                        i12 = -897645243;
                    }
                    if (i16 != 0) {
                        i7 = i12;
                    } else {
                        i7 = -2079636786;
                    }
                case -1350640889:
                    int length4 = bArr.length;
                    int length5 = 0 - (bArr.length % 4);
                    if (((length4 | length5) - ((942778902 & (~length5)) & length4)) + ((length5 | 942778902) & length4) <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i3 = -897645243;
                    } else {
                        i3 = 1251644638;
                    }
                    if (z3) {
                        i7 = -1469476344;
                    } else {
                        i7 = i3;
                    }
                    bArr4 = bArr2;
                    bArr3 = bArr;
                    i5 = 0;
                case -477594107:
                    int length6 = bArr3.length;
                    int i17 = 0 - i4;
                    int i18 = ((length6 | i17) - (((-515406864) & (~i17)) & length6)) + ((i17 | (-515406864)) & length6);
                    byte b6 = bArr4[i18];
                    int length7 = bArr3.length;
                    byte b7 = bArr4[((i17 | length7) * 2) - (length7 ^ i17)];
                    int i19 = ((byte) 0) - b6;
                    int i20 = i19 | b7;
                    bArr4[i18] = (byte) (((byte) (((byte) i20) - ((byte) (((byte) 2) * ((byte) i19))))) + ((byte) ((b7 ^ i19) ^ i20)));
                    i7 = -1057239115;
                case 769572960:
                    break;
                case 783648904:
                    int i21 = i5 + 4 + (((-1) - i5) | (-4));
                    byte b8 = bArr4[i21];
                    int i22 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                    int i23 = i5 & 2;
                    int i24 = (i5 + 2) - i23;
                    int i25 = bArr4[i24] & ForkServer.ERROR;
                    int i26 = i25 * ((~i25) & 65536);
                    int i27 = ~((i22 | ((~i26) | 467314697)) - ((i26 & 467314697) | i22));
                    int i28 = (i5 + 1) - (i5 & 1);
                    int i29 = bArr4[i28] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = ~((i27 | ((~i30) | 1328859631)) - ((i30 & 1328859631) | i27));
                    int i32 = bArr4[i5] & ForkServer.ERROR;
                    int a4 = S.a(i31, i32, 1, ((-1) - i31) | ((-1) - i32));
                    byte b9 = bArr3[i21];
                    int i33 = ((b9 & ForkServer.DONE) * (b9 | ForkServer.DONE)) + ((b9 & ForkServer.ERROR) * ((~b9) & 16777216));
                    int i34 = bArr3[i24] & ForkServer.ERROR;
                    int i35 = i34 * ((~i34) & 65536);
                    int a5 = j3.a((~i33) & 1647046022 & i35, i35, i33, (i33 | 1647046022) & i35);
                    int i36 = bArr3[i28] & ForkServer.ERROR;
                    int i37 = i36 * ((~i36) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i38 = ~((a5 | ((~i37) | (-2059442874))) - ((i37 & (-2059442874)) | a5));
                    int i39 = bArr3[i5] & ForkServer.ERROR;
                    int a6 = S.a(i38, i39, 1, ((-1) - i38) | ((-1) - i39));
                    int i40 = a4 << ((a4 > Double.NaN ? 1 : (a4 == Double.NaN ? 0 : -1)) >>> 31);
                    int i41 = (i40 + a6) - ((i40 & a6) * 2);
                    bArr3[i5] = (byte) i41;
                    bArr3[i28] = (byte) (i41 >>> 8);
                    bArr3[i24] = (byte) (i41 >>> 16);
                    bArr3[i21] = (byte) (i41 >>> 24);
                    i5 = (-11) - (((-15) - i5) | i23);
                    int length8 = bArr3.length;
                    int a7 = AbstractC0044j.a(bArr3.length);
                    int i42 = ((i5 > (((length8 & (~a7)) * 2) - (length8 ^ a7)) ? 1 : (i5 == (((length8 & (~a7)) * 2) - (length8 ^ a7)) ? 0 : -1)) >>> 31) & 1;
                    if (i42 == 0) {
                        i13 = 1251644638;
                    }
                    if (i42 == 0) {
                        i7 = i13;
                    } else {
                        i7 = -1469476344;
                    }
                case 1758587480:
                    int length9 = bArr3.length;
                    int i43 = 0 - i6;
                    if ((bArr4[((length9 | i43) - ((822835569 & (~i43)) & length9)) + ((i43 | 822835569) & length9)] > Double.NaN ? 1 : (bArr4[((length9 | i43) - ((822835569 & (~i43)) & length9)) + ((i43 | 822835569) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                        i7 = -897645243;
                    } else {
                        i7 = -1057239115;
                    }
                    i4 = i6;
                case 2013813686:
                    i6 = bArr3.length % 4;
                    int i44 = ((i6 > 1 ? 1 : (i6 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i44 == 0) {
                        i12 = -897645243;
                    }
                    if (i44 != 0) {
                        i7 = i12;
                    } else {
                        i7 = -2079636786;
                    }
                default:
                    i7 = i13;
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0ad8, code lost:
    
        if (r2 != null) goto L11;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0059. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] b(java.security.cert.X509Certificate r79) {
        /*
            Method dump skipped, instructions count: 2874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.X1.b(java.security.cert.X509Certificate):byte[]");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j2 = -2065145755;
        long j3 = -6;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        int i3 = (int) (((j17 | (j17 >>> 4)) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11));
        byte[] bArr = {36, 37, 26, 21, Byte.MIN_VALUE, 123, 118, -26, 3, -102, -31, 90, -97, 72, 2064686048 ^ ((459783 & i3) + (i3 | 459783)), 113};
        a(bArr, new byte[]{96, 56, 86, -72, -121, -126, 108, -86, -64, 29, 46, 53, 3, -7, 12, -32});
        Charset charset = StandardCharsets.UTF_8;
        sb.append(new String(bArr, charset).intern());
        sb.append(X1.class);
        byte[] bArr2 = {41, 122, 112, 45, 8, -4, 126, 20, -83, -104, 43, -127, 28, 52, 100, -18, 9};
        byte[] bArr3 = new byte[17];
        bArr3[0] = 89;
        bArr3[1] = 41;
        bArr3[2] = 29;
        long j18 = -1;
        long j19 = 7;
        long j20 = (((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j21 = (((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j22 = (((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j23 = (((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j24 = (((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j25 = (((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j26 = j25 + j24;
        long j27 = (((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j28 = (((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j29 = j28 | j27 | j26;
        long j30 = j29 + j23 + (j22 | j21 | j20);
        long j31 = (j30 >>> 48) & 21845;
        long j32 = ((j31 >>> 1) | j31) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = (j30 >>> 32) & 21845;
        long j35 = ((j34 >>> 1) | j34) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        long j37 = ((((j36 >>> 4) | j36) & 16711935) << 16) | ((((j33 >>> 4) | j33) & 16711935) << 24);
        long j38 = (j30 >>> 16) & 21845;
        long j39 = ((j38 >>> 1) | j38) & 858993459;
        long j40 = ((j39 >>> 2) | j39) & 252645135;
        long j41 = j30 & 21845;
        long j42 = ((j41 >>> 1) | j41) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        bArr3[(((((int) ((((j43 >>> 4) | j43) & 16711935) + (((((j40 >>> 4) | j40) & 16711935) << 8) + j37))) | 1624226933) & 244327461) - 2142601088) ^ (-1898273626)] = 32;
        bArr3[4] = 34;
        bArr3[5] = 94;
        bArr3[6] = -19;
        bArr3[7] = 78;
        bArr3[8] = 83;
        bArr3[9] = 109;
        bArr3[10] = 10;
        bArr3[11] = -31;
        bArr3[12] = -110;
        long j44 = 822102368;
        long j45 = j27 | j25 | j24;
        long j46 = j28 | j45;
        long j47 = (((((((((j44 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j44 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j44 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j44 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j46;
        long j48 = (j47 >>> 48) & 43690;
        long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
        long j50 = ((j49 >>> 2) | j49) & 252645135;
        long j51 = (j47 >>> 32) & 43690;
        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = ((((j53 >>> 4) | j53) & 16711935) << 16) + ((((j50 >>> 4) | j50) & 16711935) << 24);
        long j55 = (j47 >>> 16) & 43690;
        long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
        long j57 = ((j56 >>> 2) | j56) & 252645135;
        long j58 = j47 & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        bArr3[13] = (((int) ((((j60 >>> 4) | j60) & 16711935) + (((((j57 >>> 4) | j57) & 16711935) << 8) + j54))) + 1151631504) ^ 1973733853;
        bArr3[14] = 117;
        bArr3[15] = -84;
        bArr3[16] = 111;
        a(bArr2, bArr3);
        sb.append(new String(bArr2, charset).intern());
        sb.append(this.f412a);
        long j61 = -610383874;
        long j62 = -7;
        long b4 = c3.b((((((((j61 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j61 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j61 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j61 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j62 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j62 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j62 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j62 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
        long j63 = (b4 >>> 48) & 43690;
        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
        long j65 = ((j64 >>> 2) | j64) & 252645135;
        long j66 = (b4 >>> 32) & 43690;
        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
        long j68 = ((j67 >>> 2) | j67) & 252645135;
        long j69 = ((((j68 >>> 4) | j68) & 16711935) << 16) + ((((j65 >>> 4) | j65) & 16711935) << 24);
        long j70 = (b4 >>> 16) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = ((j71 >>> 2) | j71) & 252645135;
        long j73 = b4 & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        byte[] bArr4 = new byte[((((int) ((((j75 >>> 4) | j75) & 16711935) | (((((j72 >>> 4) | j72) & 16711935) << 8) | j69))) | (-562164497)) - (-562426870)) ^ 562426855];
        bArr4[0] = -55;
        bArr4[1] = -122;
        bArr4[2] = 84;
        bArr4[3] = 78;
        bArr4[4] = -2;
        bArr4[5] = -106;
        bArr4[6] = 96;
        bArr4[7] = 8;
        bArr4[8] = -92;
        bArr4[9] = 28;
        bArr4[10] = -107;
        bArr4[11] = 115;
        bArr4[12] = -80;
        bArr4[13] = 36;
        bArr4[14] = -6;
        bArr4[15] = 120;
        bArr4[16] = 99;
        bArr4[17] = 7;
        byte[] bArr5 = new byte[18];
        bArr5[0] = -33;
        bArr5[1] = 39;
        bArr5[2] = 89;
        bArr5[3] = -43;
        bArr5[4] = 45;
        bArr5[5] = 37;
        bArr5[6] = 21;
        bArr5[7] = -36;
        bArr5[8] = -25;
        bArr5[9] = -21;
        bArr5[10] = -104;
        bArr5[11] = -68;
        bArr5[12] = 79;
        long j76 = 6;
        long j77 = ((((((((j76 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j76 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j76 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j76 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j46;
        long j78 = (j77 >>> 48) & 21845;
        long j79 = ((j78 >>> 1) | j78) & 858993459;
        long j80 = ((j79 >>> 2) | j79) & 252645135;
        long j81 = (j77 >>> 32) & 21845;
        long j82 = ((j81 >>> 1) | j81) & 858993459;
        long j83 = ((j82 >>> 2) | j82) & 252645135;
        long j84 = ((((j83 >>> 4) | j83) & 16711935) << 16) | ((((j80 >>> 4) | j80) & 16711935) << 24);
        long j85 = (j77 >>> 16) & 21845;
        long j86 = ((j85 >>> 1) | j85) & 858993459;
        long j87 = ((j86 >>> 2) | j86) & 252645135;
        long j88 = j77 & 21845;
        long j89 = ((j88 >>> 1) | j88) & 858993459;
        long j90 = ((j89 >>> 2) | j89) & 252645135;
        int i4 = (int) ((((j90 >>> 4) | j90) & 16711935) + ((((j87 >>> 4) | j87) & 16711935) << 8) + j84);
        long j91 = -1739444467;
        long j92 = ((-1740502716) & (((-1691973522) ^ i4) + (i4 & (-1691973522)))) + 1058345;
        long j93 = ((((((((j91 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j91 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j91 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j91 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j92 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j92 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j92 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j92 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j94 = (j93 >>> 48) & 21845;
        long j95 = ((j94 >>> 1) | j94) & 858993459;
        long j96 = ((j95 >>> 2) | j95) & 252645135;
        long j97 = (j93 >>> 32) & 21845;
        long j98 = ((j97 >>> 1) | j97) & 858993459;
        long j99 = ((j98 >>> 2) | j98) & 252645135;
        long j100 = ((((j99 >>> 4) | j99) & 16711935) << 16) + ((((j96 >>> 4) | j96) & 16711935) << 24);
        long j101 = (j93 >>> 16) & 21845;
        long j102 = ((j101 >>> 1) | j101) & 858993459;
        long j103 = ((j102 >>> 2) | j102) & 252645135;
        long j104 = j93 & 21845;
        long j105 = ((j104 >>> 1) | j104) & 858993459;
        long j106 = ((j105 >>> 2) | j105) & 252645135;
        bArr5[13] = (int) ((((j106 >>> 4) | j106) & 16711935) + ((((j103 >>> 4) | j103) & 16711935) << 8) + j100);
        bArr5[14] = 5;
        bArr5[15] = -57;
        int i5 = this.f414c;
        long j107 = i5;
        long j108 = ((((((((j107 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j107 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j107 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j107 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j29;
        long j109 = (j108 >>> 48) & 21845;
        long j110 = ((j109 >>> 1) | j109) & 858993459;
        long j111 = ((j110 >>> 2) | j110) & 252645135;
        long j112 = (j108 >>> 32) & 21845;
        long j113 = ((j112 >>> 1) | j112) & 858993459;
        long j114 = ((j113 >>> 2) | j113) & 252645135;
        long j115 = ((((j114 >>> 4) | j114) & 16711935) << 16) | ((((j111 >>> 4) | j111) & 16711935) << 24);
        long j116 = (j108 >>> 16) & 21845;
        long j117 = ((j116 >>> 1) | j116) & 858993459;
        long j118 = ((j117 >>> 2) | j117) & 252645135;
        long j119 = j108 & 21845;
        long j120 = ((j119 >>> 1) | j119) & 858993459;
        long j121 = ((j120 >>> 2) | j120) & 252645135;
        bArr5[(((((int) ((((j121 >>> 4) | j121) & 16711935) | (((((j118 >>> 4) | j118) & 16711935) << 8) | j115))) | (-1500725263)) & 553857384) + ((16973852 & i5) | 1076396180)) ^ 1630253548] = 17;
        bArr5[17] = 19;
        a(bArr4, bArr5);
        sb.append(new String(bArr4, charset).intern());
        i.getClass();
        sb.append(C0072q.c(this.f413b));
        byte[] bArr6 = {-112, -105, 121, 125, 69, 67, -79, 88, -5, -53, 118, -68, -81};
        a(bArr6, new byte[]{14, -113, 62, -2, -33, 99, 3, 101, 56, 4, -59, -112, 69});
        sb.append(new String(bArr6, charset).intern());
        sb.append(i5);
        byte[] bArr7 = {-92, 78, -97, 99, -77, Byte.MAX_VALUE, -84, 15, 105, 0, -60, -75, -37, 124};
        byte[] bArr8 = new byte[14];
        bArr8[0] = -16;
        int i6 = this.f415d;
        bArr8[((((~i6) | (-1400852100)) & 429201186) + ((i6 & 290809346) | 38297608)) ^ 467498795] = 92;
        bArr8[2] = -31;
        bArr8[3] = -95;
        bArr8[4] = (((((-1) - i6) | (-1370308889)) & 1076154496) + ((i6 & 1092894720) | 21495808)) ^ 1097650388;
        bArr8[5] = 0;
        bArr8[6] = -110;
        long j122 = -1878944574;
        long j123 = -5;
        long j124 = ((((((((j122 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j122 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j122 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j122 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j123 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j123 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j123 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j123 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j125 = (j124 >>> 48) & 43690;
        long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
        long j127 = ((j126 >>> 2) | j126) & 252645135;
        long j128 = (j124 >>> 32) & 43690;
        long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
        long j130 = ((j129 >>> 2) | j129) & 252645135;
        long j131 = ((((j130 >>> 4) | j130) & 16711935) << 16) + ((((j127 >>> 4) | j127) & 16711935) << 24);
        long j132 = (j124 >>> 16) & 43690;
        long j133 = ((j132 >>> 2) | (j132 >>> 1)) & 858993459;
        long j134 = ((j133 >>> 2) | j133) & 252645135;
        long j135 = j124 & 43690;
        long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
        long j137 = ((j136 >>> 2) | j136) & 252645135;
        int i7 = (int) ((((((j134 >>> 4) | j134) & 16711935) << 8) + j131) | (((j137 >>> 4) | j137) & 16711935));
        long j138 = 302022976;
        long j139 = 4;
        long j140 = ((((((((j139 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j139 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j141 = (((((((j139 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j142 = (((((((j139 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j143 = ((((((((j138 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j138 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j138 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j138 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j142 + (j141 | j140);
        long j144 = (j143 >>> 48) & 43690;
        long j145 = ((j144 >>> 2) | (j144 >>> 1)) & 858993459;
        long j146 = ((j145 >>> 2) | j145) & 252645135;
        long j147 = (j143 >>> 32) & 43690;
        long j148 = ((j147 >>> 2) | (j147 >>> 1)) & 858993459;
        long j149 = ((j148 >>> 2) | j148) & 252645135;
        long j150 = ((((j149 >>> 4) | j149) & 16711935) << 16) | ((((j146 >>> 4) | j146) & 16711935) << 24);
        long j151 = (j143 >>> 16) & 43690;
        long j152 = ((j151 >>> 2) | (j151 >>> 1)) & 858993459;
        long j153 = ((j152 >>> 2) | j152) & 252645135;
        long j154 = j143 & 43690;
        long j155 = ((j154 >>> 2) | (j154 >>> 1)) & 858993459;
        long j156 = ((j155 >>> 2) | j155) & 252645135;
        bArr8[(i7 + (((int) ((((j156 >>> 4) | j156) & 16711935) | (((((j153 >>> 4) | j153) & 16711935) << 8) + j150))) | 1644176128)) ^ (-234768443)] = -37;
        bArr8[8] = -109;
        bArr8[9] = 92;
        bArr8[10] = -87;
        bArr8[11] = 18;
        bArr8[12] = 5;
        bArr8[13] = -65;
        a(bArr7, bArr8);
        sb.append(new String(bArr7, charset).intern());
        sb.append(C0072q.c(i6));
        byte[] bArr9 = new byte[10];
        bArr9[0] = 97;
        bArr9[1] = -60;
        long j157 = -1456859136;
        long j158 = ((-1) - i6) | (-17726250);
        long j159 = (((((((((j157 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j157 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j157 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j157 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j160 = (j159 >>> 48) & 43690;
        long j161 = ((j160 >>> 2) | (j160 >>> 1)) & 858993459;
        long j162 = ((j161 >>> 2) | j161) & 252645135;
        long j163 = (j159 >>> 32) & 43690;
        long j164 = ((j163 >>> 2) | (j163 >>> 1)) & 858993459;
        long j165 = ((j164 >>> 2) | j164) & 252645135;
        long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) + ((((j162 >>> 4) | j162) & 16711935) << 24);
        long j167 = (j159 >>> 16) & 43690;
        long j168 = ((j167 >>> 2) | (j167 >>> 1)) & 858993459;
        long j169 = ((j168 >>> 2) | j168) & 252645135;
        long j170 = j159 & 43690;
        long j171 = ((j170 >>> 2) | (j170 >>> 1)) & 858993459;
        long j172 = ((j171 >>> 2) | j171) & 252645135;
        int i8 = (int) ((((j172 >>> 4) | j172) & 16711935) + ((((j169 >>> 4) | j169) & 16711935) << 8) + j166);
        long j173 = -1188415166;
        long a2 = D.a(i8, 3, -D1.a(i8, (17438784 & i6) | 268443968), 1);
        long j174 = (((((((((j173 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j173 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j173 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j173 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j175 = (j174 >>> 48) & 21845;
        long j176 = ((j175 >>> 1) | j175) & 858993459;
        long j177 = ((j176 >>> 2) | j176) & 252645135;
        long j178 = (j174 >>> 32) & 21845;
        long j179 = ((j178 >>> 1) | j178) & 858993459;
        long j180 = ((j179 >>> 2) | j179) & 252645135;
        long j181 = ((((j180 >>> 4) | j180) & 16711935) << 16) | ((((j177 >>> 4) | j177) & 16711935) << 24);
        long j182 = (j174 >>> 16) & 21845;
        long j183 = ((j182 >>> 1) | j182) & 858993459;
        long j184 = ((j183 >>> 2) | j183) & 252645135;
        long j185 = j174 & 21845;
        long j186 = (j185 | (j185 >>> 1)) & 858993459;
        long j187 = (j186 | (j186 >>> 2)) & 252645135;
        bArr9[(int) (((j187 | (j187 >>> 4)) & 16711935) + ((((j184 >>> 4) | j184) & 16711935) << 8) + j181)] = -12;
        bArr9[3] = 53;
        bArr9[4] = 34;
        bArr9[5] = -86;
        bArr9[6] = 55;
        bArr9[7] = 28;
        bArr9[8] = -6;
        bArr9[9] = 31;
        int i9 = ((~i6) | (-345834539)) & 46268737;
        long j188 = -1996486644;
        long j189 = (-2004875264) & i6;
        long b5 = c3.b((((((((j188 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j188 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j188 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j188 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j189 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j189 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j189 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j189 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
        long j190 = (b5 >>> 48) & 43690;
        long j191 = ((j190 >>> 2) | (j190 >>> 1)) & 858993459;
        long j192 = ((j191 >>> 2) | j191) & 252645135;
        long j193 = (b5 >>> 32) & 43690;
        long j194 = ((j193 >>> 2) | (j193 >>> 1)) & 858993459;
        long j195 = ((j194 >>> 2) | j194) & 252645135;
        long j196 = ((((j195 >>> 4) | j195) & 16711935) << 16) | ((((j192 >>> 4) | j192) & 16711935) << 24);
        long j197 = (b5 >>> 16) & 43690;
        long j198 = ((j197 >>> 2) | (j197 >>> 1)) & 858993459;
        long j199 = ((j198 >>> 2) | j198) & 252645135;
        long j200 = b5 & 43690;
        long j201 = ((j200 >>> 2) | (j200 >>> 1)) & 858993459;
        long j202 = (j201 | (j201 >>> 2)) & 252645135;
        int i10 = (int) (((j202 | (j202 >>> 4)) & 16711935) | (((((j199 >>> 4) | j199) & 16711935) << 8) + j196));
        long j203 = 1950217936;
        long a4 = AbstractC0099x.a(i9 | i10, 2, (~i9) ^ i10);
        long j204 = (((((((((j203 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j203 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j203 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j203 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((a4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((a4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((a4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j205 = (j204 >>> 48) & 21845;
        long j206 = (j205 | (j205 >>> 1)) & 858993459;
        long j207 = (j206 | (j206 >>> 2)) & 252645135;
        long j208 = (j204 >>> 32) & 21845;
        long j209 = ((j208 >>> 1) | j208) & 858993459;
        long j210 = ((j209 >>> 2) | j209) & 252645135;
        long j211 = (((j207 | (j207 >>> 4)) & 16711935) << 24) | ((((j210 >>> 4) | j210) & 16711935) << 16);
        long j212 = (j204 >>> 16) & 21845;
        long j213 = ((j212 >>> 1) | j212) & 858993459;
        long j214 = ((j213 >>> 2) | j213) & 252645135;
        long j215 = ((((j214 >>> 4) | j214) & 16711935) << 8) + j211;
        long j216 = j204 & 21845;
        long j217 = (j216 | (j216 >>> 1)) & 858993459;
        long j218 = (j217 | (j217 >>> 2)) & 252645135;
        a(bArr9, new byte[]{48, 122, (int) (((j218 | (j218 >>> 4)) & 16711935) + j215), -111, -110, -6, -87, Byte.MIN_VALUE, -15, 111});
        sb.append(new String(bArr9, charset).intern());
        byte[] bArr10 = {-4, -116, 126, -14, 116, 42, 89, -39, -51, -46, 72, -9};
        byte[] bArr11 = new byte[12];
        bArr11[0] = -74;
        bArr11[1] = -35;
        bArr11[2] = -112;
        long b6 = c3.b(j27, j26, j28, j142 | (j141 + j140));
        long j219 = (b6 >>> 48) & 21845;
        long j220 = ((j219 >>> 1) | j219) & 858993459;
        long j221 = ((j220 >>> 2) | j220) & 252645135;
        long j222 = (b6 >>> 32) & 21845;
        long j223 = ((j222 >>> 1) | j222) & 858993459;
        long j224 = ((j223 >>> 2) | j223) & 252645135;
        long j225 = ((((j224 >>> 4) | j224) & 16711935) << 16) | ((((j221 >>> 4) | j221) & 16711935) << 24);
        long j226 = (b6 >>> 16) & 21845;
        long j227 = ((j226 >>> 1) | j226) & 858993459;
        long j228 = ((j227 >>> 2) | j227) & 252645135;
        long j229 = b6 & 21845;
        long j230 = ((j229 >>> 1) | j229) & 858993459;
        long j231 = ((j230 >>> 2) | j230) & 252645135;
        int i11 = (((int) ((((j231 >>> 4) | j231) & 16711935) | (((((j228 >>> 4) | j228) & 16711935) << 8) | j225))) | (-285212802)) - (-365039746);
        long j232 = 1075904834;
        long j233 = 0;
        long j234 = (((((((((j232 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j232 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j232 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j232 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j233 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j233 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j233 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j233 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j235 = (j234 >>> 48) & 43690;
        long j236 = ((j235 >>> 2) | (j235 >>> 1)) & 858993459;
        long j237 = ((j236 >>> 2) | j236) & 252645135;
        long j238 = (j234 >>> 32) & 43690;
        long j239 = ((j238 >>> 2) | (j238 >>> 1)) & 858993459;
        long j240 = ((j239 >>> 2) | j239) & 252645135;
        long j241 = ((((j240 >>> 4) | j240) & 16711935) << 16) + ((((j237 >>> 4) | j237) & 16711935) << 24);
        long j242 = (j234 >>> 16) & 43690;
        long j243 = ((j242 >>> 2) | (j242 >>> 1)) & 858993459;
        long j244 = ((j243 >>> 2) | j243) & 252645135;
        long j245 = j234 & 43690;
        long j246 = ((j245 >>> 2) | (j245 >>> 1)) & 858993459;
        long j247 = ((j246 >>> 2) | j246) & 252645135;
        bArr11[(i11 + ((int) ((((j247 >>> 4) | j247) & 16711935) + (((((j244 >>> 4) | j244) & 16711935) << 8) + j241)))) ^ 1440944576] = -23;
        bArr11[4] = -91;
        bArr11[5] = 17;
        bArr11[6] = 15;
        bArr11[7] = -62;
        bArr11[8] = 106;
        bArr11[9] = -120;
        bArr11[10] = 1;
        bArr11[11] = -28;
        a(bArr10, bArr11);
        sb.append(new String(bArr10, charset).intern());
        sb.append(Base64.encodeToString(this.f416e, 0));
        byte[] bArr12 = {-95};
        a(bArr12, new byte[]{126, -4, -79, 10, 41, 75, -49, -107});
        sb.append(new String(bArr12, charset).intern());
        long j248 = 945821728;
        long j249 = (~i6) | 1039420647;
        long j250 = ((((((((j248 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j248 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j248 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j248 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j249 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j249 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j249 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j249 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j251 = (j250 >>> 48) & 43690;
        long j252 = ((j251 >>> 2) | (j251 >>> 1)) & 858993459;
        long j253 = (j252 | (j252 >>> 2)) & 252645135;
        long j254 = (j250 >>> 32) & 43690;
        long j255 = ((j254 >>> 2) | (j254 >>> 1)) & 858993459;
        long j256 = ((j255 >>> 2) | j255) & 252645135;
        long j257 = (((j253 | (j253 >>> 4)) & 16711935) << 24) | ((((j256 >>> 4) | j256) & 16711935) << 16);
        long j258 = (j250 >>> 16) & 43690;
        long j259 = ((j258 >>> 2) | (j258 >>> 1)) & 858993459;
        long j260 = ((j259 >>> 2) | j259) & 252645135;
        long j261 = j250 & 43690;
        long j262 = ((j261 >>> 2) | (j261 >>> 1)) & 858993459;
        long j263 = (j262 | (j262 >>> 2)) & 252645135;
        byte[] bArr13 = {-35, -83, -65, 82, (((int) (((j263 | (j263 >>> 4)) & 16711935) + (((((j260 >>> 4) | j260) & 16711935) << 8) + j257))) + (((-2146954112) & i6) | (-2146630524))) ^ (-1200808789), -82, 71, 107, -40, -78, -119, 17, 74, 10, -31, 43, -21, 69, 88, 97, 83, -34};
        byte[] bArr14 = new byte[22];
        bArr14[0] = 78;
        bArr14[1] = -123;
        bArr14[2] = 115;
        bArr14[3] = -86;
        bArr14[4] = -89;
        bArr14[5] = 47;
        bArr14[6] = -99;
        bArr14[7] = -65;
        bArr14[8] = -75;
        bArr14[9] = -69;
        long j264 = -2062487712;
        long j265 = -4;
        long j266 = (((((((((j264 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j264 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j264 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j264 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j265 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j265 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j265 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j265 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j267 = (j266 >>> 48) & 43690;
        long j268 = ((j267 >>> 2) | (j267 >>> 1)) & 858993459;
        long j269 = ((j268 >>> 2) | j268) & 252645135;
        long j270 = (j266 >>> 32) & 43690;
        long j271 = ((j270 >>> 2) | (j270 >>> 1)) & 858993459;
        long j272 = ((j271 >>> 2) | j271) & 252645135;
        long j273 = ((((j272 >>> 4) | j272) & 16711935) << 16) + ((((j269 >>> 4) | j269) & 16711935) << 24);
        long j274 = (j266 >>> 16) & 43690;
        long j275 = ((j274 >>> 2) | (j274 >>> 1)) & 858993459;
        long j276 = ((j275 >>> 2) | j275) & 252645135;
        long j277 = j266 & 43690;
        long j278 = ((j277 >>> 2) | (j277 >>> 1)) & 858993459;
        long j279 = ((j278 >>> 2) | j278) & 252645135;
        bArr14[((((int) ((((j279 >>> 4) | j279) & 16711935) + (((((j276 >>> 4) | j276) & 16711935) << 8) + j273))) & (-1876303350)) + 68161874) ^ (-1808141488)] = -47;
        bArr14[11] = -64;
        long j280 = 1328885900;
        long j281 = -3;
        long j282 = (((((j281 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j283 = (((((((j281 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j284 = j283 + j282;
        long j285 = (((((((j281 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j286 = (((((((j281 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long b7 = c3.b((((((((j280 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j280 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j280 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j280 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j286 + j285 + j284, 6148914691236517205L);
        long j287 = (b7 >>> 48) & 43690;
        long j288 = ((j287 >>> 2) | (j287 >>> 1)) & 858993459;
        long j289 = ((j288 >>> 2) | j288) & 252645135;
        long j290 = (b7 >>> 32) & 43690;
        long j291 = ((j290 >>> 2) | (j290 >>> 1)) & 858993459;
        long j292 = ((j291 >>> 2) | j291) & 252645135;
        long j293 = ((((j292 >>> 4) | j292) & 16711935) << 16) + ((((j289 >>> 4) | j289) & 16711935) << 24);
        long j294 = (b7 >>> 16) & 43690;
        long j295 = ((j294 >>> 2) | (j294 >>> 1)) & 858993459;
        long j296 = ((j295 >>> 2) | j295) & 252645135;
        long j297 = b7 & 43690;
        long j298 = ((j297 >>> 2) | (j297 >>> 1)) & 858993459;
        long j299 = ((j298 >>> 2) | j298) & 252645135;
        int i12 = 274727180 + (((int) ((((j299 >>> 4) | j299) & 16711935) | (((((j296 >>> 4) | j296) & 16711935) << 8) + j293))) & 1770083408);
        bArr14[12] = B0.a((~i12) | 2044810527, 2044810527 - i12);
        bArr14[13] = -103;
        bArr14[14] = -8;
        bArr14[15] = -30;
        bArr14[16] = 34;
        bArr14[17] = 118;
        bArr14[18] = 51;
        bArr14[19] = 70;
        bArr14[20] = -22;
        bArr14[21] = 66;
        a(bArr13, bArr14);
        sb.append(new String(bArr13, charset).intern());
        sb.append(Base64.encodeToString(this.f417f, 0));
        byte[] bArr15 = {79};
        byte[] bArr16 = new byte[8];
        bArr16[0] = -39;
        bArr16[1] = 18;
        bArr16[604906751 ^ D.a(537788516, 3, -D1.a(537788516, 67118233), 1)] = -81;
        bArr16[3] = 6;
        bArr16[4] = 3;
        bArr16[5] = -86;
        bArr16[6] = 101;
        bArr16[7] = 82;
        a(bArr15, bArr16);
        sb.append(new String(bArr15, charset).intern());
        byte[] bArr17 = new byte[18];
        bArr17[0] = 70;
        bArr17[1] = 92;
        int i13 = this.f413b;
        long j300 = -1207424504;
        long j301 = (~i13) | (-1138832423);
        long j302 = ((((((((j300 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j300 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j300 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j300 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j301 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j301 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j301 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j301 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j303 = (j302 >>> 48) & 43690;
        long j304 = ((j303 >>> 2) | (j303 >>> 1)) & 858993459;
        long j305 = ((j304 >>> 2) | j304) & 252645135;
        long j306 = (j302 >>> 32) & 43690;
        long j307 = ((j306 >>> 2) | (j306 >>> 1)) & 858993459;
        long j308 = ((j307 >>> 2) | j307) & 252645135;
        long j309 = ((((j308 >>> 4) | j308) & 16711935) << 16) | ((((j305 >>> 4) | j305) & 16711935) << 24);
        long j310 = (j302 >>> 16) & 43690;
        long j311 = ((j310 >>> 2) | (j310 >>> 1)) & 858993459;
        long j312 = ((j311 >>> 2) | j311) & 252645135;
        long j313 = ((((j312 >>> 4) | j312) & 16711935) << 8) + j309;
        long j314 = j302 & 43690;
        long j315 = ((j314 >>> 2) | (j314 >>> 1)) & 858993459;
        long j316 = (j315 | (j315 >>> 2)) & 252645135;
        int i14 = (int) (((j316 | (j316 >>> 4)) & 16711935) + j313);
        long j317 = 446884;
        long j318 = 156064 & i13;
        long j319 = (((((((((j317 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j317 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j317 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j317 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j318 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j318 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j318 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j318 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
        long j320 = (j319 >>> 48) & 43690;
        long j321 = ((j320 >>> 2) | (j320 >>> 1)) & 858993459;
        long j322 = ((j321 >>> 2) | j321) & 252645135;
        long j323 = (j319 >>> 32) & 43690;
        long j324 = ((j323 >>> 2) | (j323 >>> 1)) & 858993459;
        long j325 = ((j324 >>> 2) | j324) & 252645135;
        long j326 = ((((j325 >>> 4) | j325) & 16711935) << 16) | ((((j322 >>> 4) | j322) & 16711935) << 24);
        long j327 = (j319 >>> 16) & 43690;
        long j328 = ((j327 >>> 2) | (j327 >>> 1)) & 858993459;
        long j329 = ((j328 >>> 2) | j328) & 252645135;
        long j330 = ((((j329 >>> 4) | j329) & 16711935) << 8) + j326;
        long j331 = j319 & 43690;
        long j332 = ((j331 >>> 2) | (j331 >>> 1)) & 858993459;
        long j333 = (j332 | (j332 >>> 2)) & 252645135;
        int i15 = i14 + ((int) (((j333 | (j333 >>> 4)) & 16711935) | j330));
        long j334 = -1206977557;
        long j335 = i15;
        long j336 = (((((((((j334 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j334 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j334 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j334 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j335 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j335 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j335 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j335 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j337 = (j336 >>> 48) & 21845;
        long j338 = ((j337 >>> 1) | j337) & 858993459;
        long j339 = ((j338 >>> 2) | j338) & 252645135;
        long j340 = (j336 >>> 32) & 21845;
        long j341 = ((j340 >>> 1) | j340) & 858993459;
        long j342 = ((j341 >>> 2) | j341) & 252645135;
        long j343 = ((((j342 >>> 4) | j342) & 16711935) << 16) | ((((j339 >>> 4) | j339) & 16711935) << 24);
        long j344 = (j336 >>> 16) & 21845;
        long j345 = ((j344 >>> 1) | j344) & 858993459;
        long j346 = ((j345 >>> 2) | j345) & 252645135;
        long j347 = j336 & 21845;
        long j348 = ((j347 >>> 1) | j347) & 858993459;
        long j349 = ((j348 >>> 2) | j348) & 252645135;
        bArr17[2] = (int) ((((j349 >>> 4) | j349) & 16711935) | ((((j346 >>> 4) | j346) & 16711935) << 8) | j343);
        bArr17[3] = -56;
        int i16 = ~i5;
        long j350 = 1611727106;
        long j351 = i5 & 18154497;
        long j352 = (((((((((j350 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j350 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j350 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j350 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j351 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j351 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j351 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j351 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j353 = (j352 >>> 48) & 43690;
        long j354 = ((j353 >>> 2) | (j353 >>> 1)) & 858993459;
        long j355 = ((j354 >>> 2) | j354) & 252645135;
        long j356 = (j352 >>> 32) & 43690;
        long j357 = ((j356 >>> 2) | (j356 >>> 1)) & 858993459;
        long j358 = ((j357 >>> 2) | j357) & 252645135;
        long j359 = ((((j358 >>> 4) | j358) & 16711935) << 16) | ((((j355 >>> 4) | j355) & 16711935) << 24);
        long j360 = (j352 >>> 16) & 43690;
        long j361 = ((j360 >>> 2) | (j360 >>> 1)) & 858993459;
        long j362 = ((j361 >>> 2) | j361) & 252645135;
        long j363 = ((((j362 >>> 4) | j362) & 16711935) << 8) + j359;
        long j364 = j352 & 43690;
        long j365 = ((j364 >>> 2) | (j364 >>> 1)) & 858993459;
        long j366 = (j365 | (j365 >>> 2)) & 252645135;
        bArr17[1930759459 ^ (((((-1707947402) | i16) + 319032357) - (i16 | (-1690907017))) + ((int) (((j366 | (j366 >>> 4)) & 16711935) | j363)))] = 45;
        bArr17[5] = -96;
        long j367 = -1718132653;
        long b8 = c3.b((((((((j367 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j367 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j367 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j367 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j286 | j285 | j284, 6148914691236517205L);
        long j368 = (b8 >>> 48) & 43690;
        long j369 = ((j368 >>> 2) | (j368 >>> 1)) & 858993459;
        long j370 = ((j369 >>> 2) | j369) & 252645135;
        long j371 = (b8 >>> 32) & 43690;
        long j372 = ((j371 >>> 2) | (j371 >>> 1)) & 858993459;
        long j373 = ((j372 >>> 2) | j372) & 252645135;
        long j374 = ((((j373 >>> 4) | j373) & 16711935) << 16) | ((((j370 >>> 4) | j370) & 16711935) << 24);
        long j375 = (b8 >>> 16) & 43690;
        long j376 = ((j375 >>> 2) | (j375 >>> 1)) & 858993459;
        long j377 = ((j376 >>> 2) | j376) & 252645135;
        long j378 = b8 & 43690;
        long j379 = ((j378 >>> 2) | (j378 >>> 1)) & 858993459;
        long j380 = ((j379 >>> 2) | j379) & 252645135;
        int i17 = ((int) ((((j380 >>> 4) | j380) & 16711935) + (((((j377 >>> 4) | j377) & 16711935) << 8) | j374))) & (-250607087);
        bArr17[6] = V2.a(138437664, ~i17, (-138437666) - i17) ^ 112169426;
        bArr17[7] = 29;
        bArr17[8] = -12;
        bArr17[9] = 32;
        bArr17[10] = 17;
        bArr17[11] = -99;
        bArr17[12] = 58;
        bArr17[13] = -46;
        bArr17[14] = -104;
        bArr17[15] = 66;
        bArr17[16] = -111;
        long j381 = 2;
        long j382 = ((((((((j381 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j381 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j381 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j383 = (((((((j381 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j384 = j383 + j382 + j46;
        long j385 = (j384 >>> 48) & 21845;
        long j386 = ((j385 >>> 1) | j385) & 858993459;
        long j387 = ((j386 >>> 2) | j386) & 252645135;
        long j388 = (j384 >>> 32) & 21845;
        long j389 = ((j388 >>> 1) | j388) & 858993459;
        long j390 = ((j389 >>> 2) | j389) & 252645135;
        long j391 = ((((j390 >>> 4) | j390) & 16711935) << 16) + ((((j387 >>> 4) | j387) & 16711935) << 24);
        long j392 = (j384 >>> 16) & 21845;
        long j393 = ((j392 >>> 1) | j392) & 858993459;
        long j394 = ((j393 >>> 2) | j393) & 252645135;
        long j395 = j384 & 21845;
        long j396 = ((j395 >>> 1) | j395) & 858993459;
        long j397 = ((j396 >>> 2) | j396) & 252645135;
        bArr17[17] = (((((int) ((((j397 >>> 4) | j397) & 16711935) + (((((j394 >>> 4) | j394) & 16711935) << 8) | j391))) | 731536354) & 1678315808) + 9603072) ^ (-1687918864);
        a(bArr17, new byte[]{-49, -3, -68, 101, 14, -36, 113, 5, 36, -16, 85, -111, -46, 88, 67, -104, -98, 101});
        sb.append(new String(bArr17, charset).intern());
        sb.append(this.f418g);
        byte[] bArr18 = new byte[19];
        bArr18[0] = -1;
        bArr18[1] = 81;
        bArr18[2] = 16;
        bArr18[3] = 41;
        bArr18[4] = 95;
        bArr18[5] = -2;
        bArr18[6] = -74;
        bArr18[7] = 57;
        bArr18[8] = -74;
        bArr18[9] = -122;
        long j398 = j29 + (j383 | j382);
        long j399 = (j398 >>> 48) & 21845;
        long j400 = (j399 | (j399 >>> 1)) & 858993459;
        long j401 = (j400 | (j400 >>> 2)) & 252645135;
        long j402 = (j398 >>> 32) & 21845;
        long j403 = ((j402 >>> 1) | j402) & 858993459;
        long j404 = ((j403 >>> 2) | j403) & 252645135;
        long j405 = (((j401 | (j401 >>> 4)) & 16711935) << 24) | ((((j404 >>> 4) | j404) & 16711935) << 16);
        long j406 = (j398 >>> 16) & 21845;
        long j407 = ((j406 >>> 1) | j406) & 858993459;
        long j408 = ((j407 >>> 2) | j407) & 252645135;
        long j409 = j405 | ((((j408 >>> 4) | j408) & 16711935) << 8);
        long j410 = j398 & 21845;
        long j411 = ((j410 >>> 1) | j410) & 858993459;
        long j412 = ((j411 >>> 2) | j411) & 252645135;
        bArr18[1260712578 ^ (33587719 - (~((((int) (j409 | (((j412 >>> 4) | j412) & 16711935))) | 676543692) & 1227124864)))] = -19;
        bArr18[11] = 62;
        bArr18[12] = -23;
        bArr18[13] = 76;
        bArr18[14] = 106;
        bArr18[15] = -107;
        bArr18[16] = -17;
        long j413 = j28 + j45 + j23 + (j22 | (j21 + j20));
        long j414 = (j413 >>> 48) & 21845;
        long j415 = (j414 | (j414 >>> 1)) & 858993459;
        long j416 = (j415 | (j415 >>> 2)) & 252645135;
        long j417 = (j413 >>> 32) & 21845;
        long j418 = ((j417 >>> 1) | j417) & 858993459;
        long j419 = ((j418 >>> 2) | j418) & 252645135;
        long j420 = (((j416 | (j416 >>> 4)) & 16711935) << 24) | ((((j419 >>> 4) | j419) & 16711935) << 16);
        long j421 = (j413 >>> 16) & 21845;
        long j422 = ((j421 >>> 1) | j421) & 858993459;
        long j423 = ((j422 >>> 2) | j422) & 252645135;
        long j424 = ((((j423 >>> 4) | j423) & 16711935) << 8) + j420;
        long j425 = j413 & 21845;
        long j426 = ((j425 >>> 1) | j425) & 858993459;
        long j427 = ((j426 >>> 2) | j426) & 252645135;
        int i18 = -((((int) ((((j427 >>> 4) | j427) & 16711935) + j424)) | 1988000564) & 1684036616);
        int i19 = i18 | (-2138471744);
        int i20 = (i19 - (i18 * 2)) + ((i18 ^ (-2138471744)) ^ i19);
        long j428 = -454435189;
        long j429 = i20;
        long j430 = ((((((((j428 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j428 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j428 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j428 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j429 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j429 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j429 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j429 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j431 = (j430 >>> 48) & 21845;
        long j432 = ((j431 >>> 1) | j431) & 858993459;
        long j433 = ((j432 >>> 2) | j432) & 252645135;
        long j434 = (j430 >>> 32) & 21845;
        long j435 = ((j434 >>> 1) | j434) & 858993459;
        long j436 = ((j435 >>> 2) | j435) & 252645135;
        long j437 = ((((j436 >>> 4) | j436) & 16711935) << 16) + ((((j433 >>> 4) | j433) & 16711935) << 24);
        long j438 = (j430 >>> 16) & 21845;
        long j439 = ((j438 >>> 1) | j438) & 858993459;
        long j440 = ((j439 >>> 2) | j439) & 252645135;
        long j441 = j430 & 21845;
        long j442 = ((j441 >>> 1) | j441) & 858993459;
        long j443 = ((j442 >>> 2) | j442) & 252645135;
        bArr18[17] = (int) ((((j443 >>> 4) | j443) & 16711935) + (((((j440 >>> 4) | j440) & 16711935) << 8) | j437));
        bArr18[18] = -127;
        byte[] bArr19 = new byte[19];
        bArr19[0] = 29;
        bArr19[1] = -84;
        long j444 = 121831941;
        long j445 = j286 | j285 | j283 | j282;
        long j446 = (((((((((j444 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j444 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j444 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j444 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j445;
        long j447 = (j446 >>> 48) & 43690;
        long j448 = ((j447 >>> 2) | (j447 >>> 1)) & 858993459;
        long j449 = (j448 | (j448 >>> 2)) & 252645135;
        long j450 = (j446 >>> 32) & 43690;
        long j451 = ((j450 >>> 2) | (j450 >>> 1)) & 858993459;
        long j452 = ((j451 >>> 2) | j451) & 252645135;
        long j453 = (((j449 | (j449 >>> 4)) & 16711935) << 24) | ((((j452 >>> 4) | j452) & 16711935) << 16);
        long j454 = (j446 >>> 16) & 43690;
        long j455 = ((j454 >>> 2) | (j454 >>> 1)) & 858993459;
        long j456 = ((j455 >>> 2) | j455) & 252645135;
        long j457 = j446 & 43690;
        long j458 = ((j457 >>> 2) | (j457 >>> 1)) & 858993459;
        long j459 = (j458 | (j458 >>> 2)) & 252645135;
        bArr19[2] = (((int) (((j459 | (j459 >>> 4)) & 16711935) + (j453 | ((((j456 >>> 4) | j456) & 16711935) << 8)))) + 1350571472) ^ 1472403387;
        bArr19[3] = -49;
        bArr19[4] = 26;
        bArr19[5] = -59;
        bArr19[6] = 54;
        bArr19[7] = -22;
        bArr19[8] = 66;
        bArr19[9] = 101;
        long j460 = -1163046995;
        long j461 = -1163047001;
        long j462 = (((((((((j460 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j460 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j460 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j460 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j461 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j461 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j461 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j461 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j463 = (j462 >>> 48) & 21845;
        long j464 = (j463 | (j463 >>> 1)) & 858993459;
        long j465 = (j464 | (j464 >>> 2)) & 252645135;
        long j466 = (j462 >>> 32) & 21845;
        long j467 = ((j466 >>> 1) | j466) & 858993459;
        long j468 = ((j467 >>> 2) | j467) & 252645135;
        long j469 = (((j465 | (j465 >>> 4)) & 16711935) << 24) | ((((j468 >>> 4) | j468) & 16711935) << 16);
        long j470 = (j462 >>> 16) & 21845;
        long j471 = ((j470 >>> 1) | j470) & 858993459;
        long j472 = ((j471 >>> 2) | j471) & 252645135;
        long j473 = j462 & 21845;
        long j474 = (j473 | (j473 >>> 1)) & 858993459;
        long j475 = (j474 | (j474 >>> 2)) & 252645135;
        bArr19[(int) (((j475 | (j475 >>> 4)) & 16711935) | (((((j472 >>> 4) | j472) & 16711935) << 8) + j469))] = -48;
        bArr19[11] = -44;
        bArr19[12] = 60;
        bArr19[13] = 18;
        bArr19[14] = -29;
        bArr19[15] = -70;
        bArr19[16] = -54;
        bArr19[17] = -111;
        bArr19[18] = -43;
        a(bArr18, bArr19);
        sb.append(new String(bArr18, charset).intern());
        sb.append(this.f419h);
        String sb2 = sb.toString();
        byte[] bArr20 = {82, 126, -79, 47, 90, -117, 39, 54, 7, 37, 98, 88, -54};
        long j476 = 1312796274;
        long b9 = c3.b((((((((j476 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j476 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j476 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j476 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j445, 6148914691236517205L);
        long j477 = (b9 >>> 48) & 43690;
        long j478 = ((j477 >>> 2) | (j477 >>> 1)) & 858993459;
        long j479 = (j478 | (j478 >>> 2)) & 252645135;
        long j480 = (b9 >>> 32) & 43690;
        long j481 = ((j480 >>> 2) | (j480 >>> 1)) & 858993459;
        long j482 = (j481 | (j481 >>> 2)) & 252645135;
        long j483 = (((j482 | (j482 >>> 4)) & 16711935) << 16) + (((j479 | (j479 >>> 4)) & 16711935) << 24);
        long j484 = (b9 >>> 16) & 43690;
        long j485 = ((j484 >>> 2) | (j484 >>> 1)) & 858993459;
        long j486 = (j485 | (j485 >>> 2)) & 252645135;
        long j487 = b9 & 43690;
        long j488 = ((j487 >>> 2) | (j487 >>> 1)) & 858993459;
        long j489 = (j488 | (j488 >>> 2)) & 252645135;
        a(bArr20, new byte[]{59, -29, -8, 47, 4, -40, 81, -79, 115, ((((int) (((j489 | (j489 >>> 4)) & 16711935) | ((((j486 | (j486 >>> 4)) & 16711935) << 8) + j483))) & (-2112741088)) + 539559936) ^ 1573181083, -67, 5, 31});
        kotlin.jvm.internal.j.d(sb2, new String(bArr20, charset).intern());
        return sb2;
    }
}
