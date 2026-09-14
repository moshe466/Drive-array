package F0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import org.apache.tika.fork.ForkServer;
import t2.AbstractC0707i;
import t2.AbstractC0709k;

/* renamed from: F0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0044j {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f540a = {26, 0};

    public static int a(int i) {
        return 0 - (0 - (i % 4));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0066. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static final int b(String str) {
        char c4 = 15302;
        ?? r4 = 0;
        CharSequence charSequence = 0;
        String str2 = null;
        String str3 = null;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 53269:
                    r4 = (Exception) r4;
                case 8544:
                    try {
                        str2 = charSequence;
                        c4 = 47415;
                    } catch (Exception e4) {
                        e = e4;
                        r4 = e;
                        charSequence = charSequence;
                        c4 = 53269;
                    }
                case 50612:
                    c4 = 62143;
                    z3 = false;
                case 13951:
                    return 0;
                case 35215:
                    try {
                        byte[] bArr = new byte[27];
                        long j2 = 780771836;
                        long j3 = ~AbstractC0044j.class.getName().length();
                        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                        long j5 = (j4 >>> 48) & 43690;
                        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                        long j7 = (j6 | (j6 >>> 2)) & 252645135;
                        long j8 = (j4 >>> 32) & 43690;
                        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                        long j10 = ((j9 >>> 2) | j9) & 252645135;
                        long j11 = (((j7 | (j7 >>> 4)) & 16711935) << 24) | ((((j10 >>> 4) | j10) & 16711935) << 16);
                        long j12 = (j4 >>> 16) & 43690;
                        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                        long j14 = ((j13 >>> 2) | j13) & 252645135;
                        long j15 = ((((j14 >>> 4) | j14) & 16711935) << 8) + j11;
                        long j16 = j4 & 43690;
                        long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                        long j18 = (j17 | (j17 >>> 2)) & 252645135;
                        int i = (int) (((j18 | (j18 >>> 4)) & 16711935) + j15);
                        bArr[1028464235 ^ (((i | 424481355) - (i ^ 424481355)) + ((AbstractC0044j.class.getName().length() & 289673763) | 603982880))] = 111;
                        bArr[1] = ((((~AbstractC0044j.class.getName().length()) | (-197084338)) & (-794555344)) + ((AbstractC0044j.class.getName().length() & 10814714) | 65738)) ^ (-794489635);
                        bArr[2] = 13;
                        bArr[3] = 19;
                        long j19 = -114888561;
                        long j20 = ~AbstractC0044j.class.getName().length();
                        long b4 = c3.b((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                        long j21 = (b4 >>> 48) & 43690;
                        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
                        long j23 = ((j22 >>> 2) | j22) & 252645135;
                        long j24 = (b4 >>> 32) & 43690;
                        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                        long j26 = ((j25 >>> 2) | j25) & 252645135;
                        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
                        long j28 = (b4 >>> 16) & 43690;
                        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                        long j30 = ((j29 >>> 2) | j29) & 252645135;
                        long j31 = b4 & 43690;
                        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                        long j33 = ((j32 >>> 2) | j32) & 252645135;
                        int length = AbstractC0044j.class.getName().length() & 1112082000;
                        bArr[((((int) ((((j33 >>> 4) | j33) & 16711935) | (((((j30 >>> 4) | j30) & 16711935) << 8) + j27))) & (-1958534573)) + (~(((AbstractC0044j.class.getName().length() | (-1619543073)) | length) - (length | (AbstractC0044j.class.getName().length() & 1619543072))))) ^ (-338991497)] = -44;
                        bArr[5] = 81;
                        bArr[6] = 68;
                        bArr[7] = 32;
                        bArr[8] = -49;
                        bArr[9] = 23;
                        bArr[10] = -91;
                        bArr[11] = -69;
                        bArr[12] = 64;
                        bArr[13] = 17;
                        bArr[14] = 107;
                        bArr[15] = 42;
                        bArr[16] = -90;
                        bArr[17] = -19;
                        int i3 = ((~AbstractC0044j.class.getName().length()) | (-1695768755)) & 9002260;
                        long j34 = 1644430048;
                        long length2 = AbstractC0044j.class.getName().length() & 1644511344;
                        long j35 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
                        bArr[18] = (-1653432293) ^ (i3 + ((int) ((((j48 >>> 4) | j48) & 16711935) + (((((j45 >>> 4) | j45) & 16711935) << 8) | j42))));
                        bArr[19] = 105;
                        bArr[20] = -6;
                        bArr[21] = 96;
                        bArr[22] = -18;
                        bArr[23] = -5;
                        bArr[24] = 62;
                        bArr[25] = 49;
                        bArr[26] = -36;
                        byte[] bArr2 = new byte[27];
                        bArr2[0] = 14;
                        bArr2[1] = 73;
                        bArr2[2] = 105;
                        bArr2[3] = 97;
                        bArr2[4] = -69;
                        bArr2[5] = 56;
                        bArr2[6] = 32;
                        bArr2[7] = ((((~AbstractC0044j.class.getName().length()) | 1333966770) & 26285056) + ((AbstractC0044j.class.getName().length() & 34668608) | (-1979709376))) ^ (-1953424306);
                        bArr2[8] = -96;
                        bArr2[9] = 100;
                        bArr2[10] = -117;
                        bArr2[11] = -24;
                        bArr2[12] = 57;
                        bArr2[13] = 98;
                        bArr2[14] = 31;
                        bArr2[15] = 79;
                        bArr2[16] = -53;
                        bArr2[17] = -67;
                        bArr2[18] = -99;
                        bArr2[19] = 6;
                        bArr2[20] = -118;
                        bArr2[((((~AbstractC0044j.class.getName().length()) | (-1720507717)) & (-1860123385)) + ((AbstractC0044j.class.getName().length() & 443684) | 68026416)) ^ (-1792096990)] = 5;
                        bArr2[22] = -100;
                        bArr2[23] = ((((~AbstractC0044j.class.getName().length()) | (-8062374)) & (-2145647929)) + ((AbstractC0044j.class.getName().length() & 1605765) | 1348501504)) ^ 797146440;
                        bArr2[24] = 87;
                        bArr2[25] = 84;
                        bArr2[26] = -81;
                        e(bArr, bArr2);
                        Charset charset = StandardCharsets.UTF_8;
                        r4 = Class.forName(new String(bArr, charset).intern());
                        byte[] bArr3 = new byte[12];
                        bArr3[0] = -62;
                        bArr3[1] = -42;
                        bArr3[2] = 94;
                        bArr3[3] = -45;
                        bArr3[4] = 27;
                        bArr3[5] = 65;
                        bArr3[6] = -97;
                        bArr3[7] = 125;
                        bArr3[8] = 36;
                        int i4 = ~AbstractC0044j.class.getName().length();
                        int length3 = (((i4 + (((-i4) - 1) | 1140081827)) - 1140081827) & 1345528323) + ((AbstractC0044j.class.getName().length() & (-1070593981)) | (-2147480368));
                        bArr3[((length3 & 801952037) * 2) + ((-801952038) - length3)] = -10;
                        bArr3[10] = 2;
                        bArr3[11] = 117;
                        e(bArr3, new byte[]{-92, -71, 44, -99, 122, 44, -6, 85, 10, -40, 44, 92});
                        new String(bArr3, charset).intern();
                        byte[] bArr4 = {97, 71, 96};
                        e(bArr4, new byte[]{6, 34, 20, -96, 95, -85, -98, 96});
                        Method method = r4.getMethod(new String(bArr4, charset).intern(), String.class);
                        byte[] bArr5 = new byte[14];
                        bArr5[0] = 66;
                        bArr5[1] = 29;
                        int i5 = ((~AbstractC0044j.class.getName().length()) | 856828034) & 1431363954;
                        int length4 = (AbstractC0044j.class.getName().length() & 1279512944) | 143069184;
                        int length5 = (((length4 | i5) - ((AbstractC0044j.class.getName().length() & (~i5)) & length4)) + ((AbstractC0044j.class.getName().length() | i5) & length4)) ^ 1574433136;
                        int i6 = ((~AbstractC0044j.class.getName().length()) | (-1693227469)) & 1107323009;
                        int length6 = AbstractC0044j.class.getName().length();
                        bArr5[length5] = (i6 + (((length6 + 1208027264) - (length6 | 1208027264)) | 159449088)) ^ 1266772110;
                        long j49 = -1652125629;
                        long length7 = ((-1) - AbstractC0044j.class.getName().length()) | (-2133425519);
                        long j50 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        long j61 = ((((j60 >>> 4) | j60) & 16711935) << 8) + j57;
                        long j62 = j50 & 43690;
                        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                        long j64 = (j63 | (j63 >>> 2)) & 252645135;
                        bArr5[3] = (((int) (((j64 | (j64 >>> 4)) & 16711935) | j61)) + ((AbstractC0044j.class.getName().length() & 521164866) | 1108363904)) ^ 543761668;
                        bArr5[4] = -110;
                        bArr5[5] = -22;
                        bArr5[6] = 37;
                        bArr5[7] = -68;
                        bArr5[8] = 7;
                        bArr5[9] = 12;
                        bArr5[10] = -31;
                        bArr5[11] = -80;
                        bArr5[12] = 63;
                        bArr5[13] = -60;
                        e(bArr5, new byte[]{37, 120, 123, -118, -9, -98, 77, -45, 99, 36, -49, -98, 17, -19});
                        kotlin.jvm.internal.j.d(method, new String(bArr5, charset).intern());
                        Object[] objArr = new Object[1];
                        int i7 = ~AbstractC0044j.class.getName().length();
                        int length8 = (1346490200 & (((-1156385026) + i7) - (i7 & (-1156385026)))) + ((AbstractC0044j.class.getName().length() & 1279723808) | 203816995);
                        objArr[E1.a(1550307195 | length8, 1550307195, length8)] = str;
                        try {
                            charSequence = method.invoke(null, objArr);
                        } catch (Exception e5) {
                            e = e5;
                            r4 = e;
                            charSequence = charSequence;
                            c4 = 53269;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                    c4 = charSequence instanceof String ? (char) 8544 : (char) 20523;
                case 34588:
                    try {
                    } catch (Exception e7) {
                        r4 = e7;
                        charSequence = charSequence;
                        c4 = 53269;
                    }
                    c4 = N2.f.U(charSequence) ? (char) 22258 : (char) 50612;
                case 47415:
                    if (str2 != null) {
                        c4 = 34588;
                        charSequence = str2;
                        str3 = charSequence;
                    } else {
                        charSequence = str2;
                        str3 = charSequence;
                    }
                case 20523:
                    c4 = 47415;
                    str2 = null;
                case 50784:
                    try {
                        return Integer.parseInt(str3);
                    } catch (Exception e8) {
                        e = e8;
                        r4 = e;
                        charSequence = charSequence;
                        c4 = 53269;
                    }
                case 15302:
                    byte[] bArr6 = new byte[12];
                    bArr6[0] = -29;
                    bArr6[1] = -87;
                    bArr6[2] = 118;
                    bArr6[3] = -10;
                    bArr6[4] = -68;
                    bArr6[((((~AbstractC0044j.class.getName().length()) | 533069289) & 239098256) + ((AbstractC0044j.class.getName().length() & 806388240) | 1888780864)) ^ 2127879125] = 75;
                    bArr6[6] = -48;
                    bArr6[7] = 27;
                    bArr6[8] = -55;
                    bArr6[9] = -8;
                    bArr6[10] = 66;
                    bArr6[11] = 57;
                    byte[] bArr7 = new byte[12];
                    bArr7[0] = -109;
                    bArr7[1] = -37;
                    bArr7[2] = 25;
                    bArr7[3] = -122;
                    bArr7[4] = -39;
                    bArr7[5] = 57;
                    int i8 = ((~AbstractC0044j.class.getName().length()) | (-1354272953)) & 16811328;
                    long j65 = 872423428;
                    long length9 = AbstractC0044j.class.getName().length() & 335585284;
                    long j66 = (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j67 = (j66 >>> 48) & 43690;
                    long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                    long j69 = ((j68 >>> 2) | j68) & 252645135;
                    long j70 = (j66 >>> 32) & 43690;
                    long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
                    long j72 = ((j71 >>> 2) | j71) & 252645135;
                    long j73 = ((((j72 >>> 4) | j72) & 16711935) << 16) | ((((j69 >>> 4) | j69) & 16711935) << 24);
                    long j74 = (j66 >>> 16) & 43690;
                    long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    long j77 = ((((j76 >>> 4) | j76) & 16711935) << 8) + j73;
                    long j78 = j66 & 43690;
                    long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                    long j80 = ((j79 >>> 2) | j79) & 252645135;
                    int i9 = (int) ((((j80 >>> 4) | j80) & 16711935) + j77);
                    int i10 = -i8;
                    bArr7[6] = (-889234720) ^ ((((~i10) & i9) * 2) - (i10 ^ i9));
                    bArr7[7] = 98;
                    bArr7[8] = -121;
                    bArr7[9] = -103;
                    bArr7[((((~AbstractC0044j.class.getName().length()) | (-1464478326)) & (-1573830270)) + ((AbstractC0044j.class.getName().length() & 301994496) | 411604496)) ^ (-1162225768)] = 47;
                    bArr7[11] = 92;
                    e(bArr6, bArr7);
                    kotlin.jvm.internal.j.e(str, new String(bArr6, StandardCharsets.UTF_8).intern());
                    c4 = 35215;
                case 62143:
                    c4 = !z3 ? (char) 50784 : (char) 13951;
                case 22258:
                    z3 = true;
                    c4 = 62143;
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:152:0x00c2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x004f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [F0.u, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [F0.u, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [F0.d3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static ArrayList c(Context context) {
        boolean z3;
        ArrayList arrayList = null;
        ?? r3 = 0;
        Iterator it = null;
        ApplicationInfo applicationInfo = null;
        PackageManager packageManager = null;
        d3 d3Var = 0;
        char c4 = 51209;
        File file = null;
        while (true) {
            switch (c4) {
                case 60872:
                    try {
                        ZipFile zipFile = new ZipFile(file);
                        try {
                            long j2 = 1293526104;
                            long j3 = -262145;
                            long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
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
                            byte[] bArr = {-95, 38, 70, -94, 23, -5, 79, -111, -67, -64, ((((int) ((((j16 >>> 4) | j16) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) & (-1986507766)) + 1342505568) ^ (-644002272), 124, -111, -79};
                            long j17 = 6654721;
                            long j18 = 262144;
                            long j19 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
                            long j32 = (j31 | (j31 >>> 2)) & 252645135;
                            long j33 = 542474496;
                            long j34 = (int) (((j32 | (j32 >>> 4)) & 16711935) | (((((j29 >>> 4) | j29) & 16711935) << 8) + j26));
                            long b5 = c3.b((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                            long j35 = (b5 >>> 48) & 43690;
                            long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                            long j37 = ((j36 >>> 2) | j36) & 252645135;
                            long j38 = (b5 >>> 32) & 43690;
                            long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                            long j40 = ((j39 >>> 2) | j39) & 252645135;
                            long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
                            long j42 = (b5 >>> 16) & 43690;
                            long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
                            long j44 = ((j43 >>> 2) | j43) & 252645135;
                            long j45 = b5 & 43690;
                            long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                            long j47 = ((j46 >>> 2) | j46) & 252645135;
                            int i = (int) ((((j47 >>> 4) | j47) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41));
                            int i3 = (-86142465) | i;
                            int i4 = (i3 - (-172284930)) + ((i ^ (-86142465)) ^ i3);
                            long j48 = 628616990;
                            long j49 = i4;
                            long j50 = ((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j51 = (j50 >>> 48) & 21845;
                            long j52 = ((j51 >>> 1) | j51) & 858993459;
                            long j53 = ((j52 >>> 2) | j52) & 252645135;
                            long j54 = (j50 >>> 32) & 21845;
                            long j55 = ((j54 >>> 1) | j54) & 858993459;
                            long j56 = ((j55 >>> 2) | j55) & 252645135;
                            long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) | ((((j53 >>> 4) | j53) & 16711935) << 24);
                            long j58 = (j50 >>> 16) & 21845;
                            long j59 = ((j58 >>> 1) | j58) & 858993459;
                            long j60 = ((j59 >>> 2) | j59) & 252645135;
                            long j61 = j50 & 21845;
                            long j62 = ((j61 >>> 1) | j61) & 858993459;
                            long j63 = ((j62 >>> 2) | j62) & 252645135;
                            l(bArr, new byte[]{-68, 115, (int) ((((j63 >>> 4) | j63) & 16711935) | ((((j60 >>> 4) | j60) & 16711935) << 8) | j57), -26, 75, -71, 22, 13, -73, 30, 22, 39, -30, -46});
                            boolean z4 = zipFile.getEntry(new String(bArr, StandardCharsets.UTF_8).intern()) != null;
                            zipFile.close();
                            z3 = z4;
                        } catch (Throwable th) {
                            try {
                                throw th;
                                break;
                            } catch (Throwable th2) {
                                p3.h.h(zipFile, th);
                                throw th2;
                                break;
                            }
                        }
                    } catch (IOException unused) {
                        z3 = true;
                    }
                    c4 = z3 ? (char) 28114 : (char) 8582;
                case 27939:
                case 32175:
                case 63925:
                case 5963:
                case 28114:
                case 51209:
                    byte[] bArr2 = {-45, 83, 22};
                    k(bArr2, new byte[]{-80, 39, 110, -51, -86, 112, -25, 87});
                    kotlin.jvm.internal.j.e(context, new String(bArr2, StandardCharsets.UTF_8).intern());
                    packageManager = context.getPackageManager();
                    arrayList = new ArrayList();
                    kotlin.jvm.internal.j.b(packageManager);
                    it = d(packageManager).iterator();
                case 45068:
                    return arrayList;
                case 16697:
                    c4 = r3.f681c != null ? (char) 8626 : (char) 64518;
                case 60284:
                case 10255:
                    applicationInfo = (ApplicationInfo) it.next();
                    c4 = applicationInfo.sourceDir == null ? (char) 32175 : (char) 50009;
                case 46572:
                    file = new File(applicationInfo.sourceDir);
                    c4 = file.canRead() ? (char) 4283 : (char) 27939;
                case 7506:
                    c4 = kotlin.jvm.internal.j.a(applicationInfo.packageName, context.getPackageName()) ? (char) 5963 : (char) 46572;
                case 23726:
                    if (!r3.f682d) {
                        c4 = 16697;
                    }
                case 49853:
                    try {
                        r3.f680b = packageManager.getApplicationLabel(applicationInfo).toString();
                        c4 = 55418;
                    } catch (Exception e4) {
                        d3Var = e4;
                        c4 = 63234;
                    }
                case 17676:
                    String str = applicationInfo.packageName;
                    byte[] bArr3 = new byte[11];
                    bArr3[0] = -119;
                    bArr3[1] = 77;
                    bArr3[2] = 28;
                    bArr3[3] = -91;
                    bArr3[4] = 55;
                    long j64 = -1592786431;
                    long j65 = 0;
                    long j66 = (((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j67 = (j66 >>> 48) & 43690;
                    long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                    long j69 = ((j68 >>> 2) | j68) & 252645135;
                    long j70 = (j66 >>> 32) & 43690;
                    long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
                    long j72 = ((j71 >>> 2) | j71) & 252645135;
                    long j73 = ((((j72 >>> 4) | j72) & 16711935) << 16) + ((((j69 >>> 4) | j69) & 16711935) << 24);
                    long j74 = (j66 >>> 16) & 43690;
                    long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    long j77 = j66 & 43690;
                    long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                    long j79 = ((j78 >>> 2) | j78) & 252645135;
                    int i5 = 341840330 + ((int) ((((j79 >>> 4) | j79) & 16711935) | ((((j76 >>> 4) | j76) & 16711935) << 8) | j73));
                    long j80 = -1250946098;
                    long j81 = i5;
                    long j82 = (((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j83 = (j82 >>> 48) & 21845;
                    long j84 = ((j83 >>> 1) | j83) & 858993459;
                    long j85 = ((j84 >>> 2) | j84) & 252645135;
                    long j86 = (j82 >>> 32) & 21845;
                    long j87 = ((j86 >>> 1) | j86) & 858993459;
                    long j88 = ((j87 >>> 2) | j87) & 252645135;
                    long j89 = ((((j88 >>> 4) | j88) & 16711935) << 16) + ((((j85 >>> 4) | j85) & 16711935) << 24);
                    long j90 = (j82 >>> 16) & 21845;
                    long j91 = ((j90 >>> 1) | j90) & 858993459;
                    long j92 = ((j91 >>> 2) | j91) & 252645135;
                    long j93 = j82 & 21845;
                    long j94 = ((j93 >>> 1) | j93) & 858993459;
                    long j95 = ((j94 >>> 2) | j94) & 252645135;
                    bArr3[(int) ((((((j92 >>> 4) | j92) & 16711935) << 8) + j89) | (((j95 >>> 4) | j95) & 16711935))] = 89;
                    long j96 = 271141264;
                    long j97 = -1;
                    long j98 = (((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j97 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j97 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j97 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j97 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j99 = (j98 >>> 48) & 43690;
                    long j100 = ((j99 >>> 2) | (j99 >>> 1)) & 858993459;
                    long j101 = ((j100 >>> 2) | j100) & 252645135;
                    long j102 = (j98 >>> 32) & 43690;
                    long j103 = ((j102 >>> 2) | (j102 >>> 1)) & 858993459;
                    long j104 = ((j103 >>> 2) | j103) & 252645135;
                    long j105 = ((((j104 >>> 4) | j104) & 16711935) << 16) | ((((j101 >>> 4) | j101) & 16711935) << 24);
                    long j106 = (j98 >>> 16) & 43690;
                    long j107 = ((j106 >>> 2) | (j106 >>> 1)) & 858993459;
                    long j108 = ((j107 >>> 2) | j107) & 252645135;
                    long j109 = j98 & 43690;
                    long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
                    long j111 = (j110 | (j110 >>> 2)) & 252645135;
                    bArr3[6] = (((int) (((j111 | (j111 >>> 4)) & 16711935) + (((((j108 >>> 4) | j108) & 16711935) << 8) + j105))) - 2113887670) ^ (-1842746475);
                    bArr3[7] = 39;
                    bArr3[8] = -19;
                    bArr3[9] = 11;
                    bArr3[10] = -2;
                    byte[] bArr4 = new byte[11];
                    bArr4[0] = -7;
                    bArr4[1] = 44;
                    bArr4[2] = Byte.MAX_VALUE;
                    bArr4[3] = -50;
                    bArr4[4] = 86;
                    long j112 = 1322117624;
                    long j113 = 1322117629;
                    long j114 = ((((((((j112 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j112 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j112 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j112 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j115 = (j114 >>> 48) & 21845;
                    long j116 = ((j115 >>> 1) | j115) & 858993459;
                    long j117 = ((j116 >>> 2) | j116) & 252645135;
                    long j118 = (j114 >>> 32) & 21845;
                    long j119 = ((j118 >>> 1) | j118) & 858993459;
                    long j120 = ((j119 >>> 2) | j119) & 252645135;
                    long j121 = ((((j120 >>> 4) | j120) & 16711935) << 16) + ((((j117 >>> 4) | j117) & 16711935) << 24);
                    long j122 = (j114 >>> 16) & 21845;
                    long j123 = ((j122 >>> 1) | j122) & 858993459;
                    long j124 = ((j123 >>> 2) | j123) & 252645135;
                    long j125 = j114 & 21845;
                    long j126 = ((j125 >>> 1) | j125) & 858993459;
                    long j127 = ((j126 >>> 2) | j126) & 252645135;
                    bArr4[(int) ((((j127 >>> 4) | j127) & 16711935) | (((((j124 >>> 4) | j124) & 16711935) << 8) + j121))] = 62;
                    bArr4[6] = 42;
                    bArr4[7] = 105;
                    bArr4[8] = -116;
                    bArr4[9] = 102;
                    bArr4[10] = -101;
                    k(bArr3, bArr4);
                    kotlin.jvm.internal.j.d(str, new String(bArr3, StandardCharsets.UTF_8).intern());
                    r3.f682d = f(packageManager, str);
                    c4 = 11083;
                case 63234:
                    d3Var = (Exception) d3Var;
                    c4 = 17676;
                case 64518:
                    c4 = it.hasNext() ? (char) 10255 : (char) 45068;
                case 8626:
                    arrayList.add(r3);
                case 11083:
                    Pattern pattern = f3.f513c;
                    d3Var = c3.c(file);
                    d3Var.getClass();
                    char c5 = 3898;
                    boolean z5 = false;
                    boolean z6 = false;
                    boolean z7 = false;
                    while (true) {
                        switch (c5) {
                            case 15005:
                                z7 = true;
                                c5 = 19888;
                            case 13853:
                                z6 = true;
                                c5 = 54800;
                            case 65412:
                                z6 = false;
                                c5 = 54800;
                            case 27428:
                                c5 = !d3Var.f496b.isEmpty() ? (char) 15005 : (char) 17715;
                            case 5379:
                                break;
                            case 54800:
                                c5 = z6 ? (char) 27428 : (char) 64549;
                            case 64549:
                                z5 = false;
                                c5 = 5379;
                            case 17715:
                                z7 = false;
                                c5 = 19888;
                            case 47840:
                                z5 = true;
                                c5 = 5379;
                            case 3898:
                                c5 = !d3Var.f495a.isEmpty() ? (char) 13853 : (char) 65412;
                            case 19888:
                                if (z7) {
                                    c5 = 47840;
                                }
                            default:
                        }
                        c4 = z5 ? (char) 15233 : (char) 23726;
                    }
                case 50009:
                    c4 = (applicationInfo.flags & 1) != 0 ? (char) 63925 : (char) 7506;
                case 55418:
                    c4 = 17676;
                case 8582:
                    r3 = new Object();
                    r3.f679a = applicationInfo.packageName;
                    r3.f683e = true;
                    c4 = 49853;
                case 4283:
                    if (file.length() <= 262144) {
                        c4 = 60872;
                    }
                case 15233:
                    try {
                        r3.f681c = d3Var.f498d;
                        String str2 = d3Var.f497c;
                        r3.f684f = g(d3Var.f498d);
                        c4 = 60284;
                    } catch (IOException e5) {
                        d3Var = e5;
                        c4 = 17441;
                    }
                case 17441:
                    d3Var = (IOException) d3Var;
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public static ArrayList d(PackageManager packageManager) {
        Iterator<ResolveInfo> it = null;
        Parcelable parcelable = null;
        Iterator<ResolveInfo> it2 = null;
        char c4 = 22124;
        ArrayList arrayList = null;
        while (true) {
            switch (c4) {
                case 22124:
                    arrayList = new ArrayList();
                    long j2 = -1;
                    long j3 = 262144;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = j5 | j4;
                    long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j9 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j10 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j11 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j12 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j13 = j12 + (j11 | j10 | j9);
                    long j14 = j13 + j8 + (j7 | j6);
                    long j15 = (j14 >>> 48) & 21845;
                    long j16 = ((j15 >>> 1) | j15) & 858993459;
                    long j17 = ((j16 >>> 2) | j16) & 252645135;
                    long j18 = (j14 >>> 32) & 21845;
                    long j19 = ((j18 >>> 1) | j18) & 858993459;
                    long j20 = ((j19 >>> 2) | j19) & 252645135;
                    long j21 = ((((j20 >>> 4) | j20) & 16711935) << 16) + ((((j17 >>> 4) | j17) & 16711935) << 24);
                    long j22 = (j14 >>> 16) & 21845;
                    long j23 = ((j22 >>> 1) | j22) & 858993459;
                    long j24 = ((j23 >>> 2) | j23) & 252645135;
                    long j25 = j14 & 21845;
                    long j26 = ((j25 >>> 1) | j25) & 858993459;
                    long j27 = ((j26 >>> 2) | j26) & 252645135;
                    int i = (int) ((((j27 >>> 4) | j27) & 16711935) | ((((j24 >>> 4) | j24) & 16711935) << 8) | j21);
                    long j28 = 1082286804;
                    long j29 = ((~i) & (-1552816500)) + i;
                    long j30 = ((((((((j28 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j28 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j28 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j28 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j29 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j29 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j29 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j29 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j31 = (j30 >>> 48) & 43690;
                    long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                    long j33 = ((j32 >>> 2) | j32) & 252645135;
                    long j34 = (j30 >>> 32) & 43690;
                    long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                    long j36 = ((j35 >>> 2) | j35) & 252645135;
                    long j37 = ((((j36 >>> 4) | j36) & 16711935) << 16) | ((((j33 >>> 4) | j33) & 16711935) << 24);
                    long j38 = (j30 >>> 16) & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    long j41 = j30 & 43690;
                    long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                    long j43 = (j42 | (j42 >>> 2)) & 252645135;
                    byte[] bArr = {-101, 60, 85, -110, -34, 28, -103, 113, -79, 59, -107, -127, 101, 74, 32, 98, 90, 91, 29, -26, -78, 119, (((int) (((j43 | (j43 >>> 4)) & 16711935) + (((((j40 >>> 4) | j40) & 16711935) << 8) + j37))) + 370151426) ^ (-1452438207), -89, 19, 112};
                    byte[] bArr2 = new byte[26];
                    bArr2[0] = 94;
                    bArr2[1] = 68;
                    bArr2[2] = -93;
                    bArr2[3] = -122;
                    bArr2[4] = -19;
                    bArr2[5] = 99;
                    bArr2[6] = 111;
                    bArr2[7] = -6;
                    bArr2[8] = 60;
                    bArr2[9] = 71;
                    bArr2[10] = 115;
                    bArr2[11] = -127;
                    bArr2[12] = 103;
                    bArr2[13] = 76;
                    long j44 = 8541704;
                    long j45 = j5 + j4;
                    long j46 = (((((((((j44 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j44 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j44 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j44 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j8 | (j7 + j45));
                    long j47 = (j46 >>> 48) & 43690;
                    long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                    long j49 = ((j48 >>> 2) | j48) & 252645135;
                    long j50 = (j46 >>> 32) & 43690;
                    long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
                    long j52 = ((j51 >>> 2) | j51) & 252645135;
                    long j53 = ((((j52 >>> 4) | j52) & 16711935) << 16) + ((((j49 >>> 4) | j49) & 16711935) << 24);
                    long j54 = (j46 >>> 16) & 43690;
                    long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    long j57 = j46 & 43690;
                    long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
                    long j59 = ((j58 >>> 2) | j58) & 252645135;
                    bArr2[14] = (-415924107) ^ (281050369 + (((int) ((((j59 >>> 4) | j59) & 16711935) | (((((j56 >>> 4) | j56) & 16711935) << 8) | j53))) | 134873800));
                    long j60 = 57935104;
                    long j61 = j10 + j9;
                    long j62 = j12 | (j11 + j61);
                    long j63 = ((((((((j60 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j60 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j60 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j60 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j62;
                    long j64 = (j63 >>> 48) & 43690;
                    long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
                    long j66 = ((j65 >>> 2) | j65) & 252645135;
                    long j67 = (j63 >>> 32) & 43690;
                    long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                    long j69 = ((j68 >>> 2) | j68) & 252645135;
                    long j70 = ((((j69 >>> 4) | j69) & 16711935) << 16) + ((((j66 >>> 4) | j66) & 16711935) << 24);
                    long j71 = (j63 >>> 16) & 43690;
                    long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                    long j73 = ((j72 >>> 2) | j72) & 252645135;
                    long j74 = j63 & 43690;
                    long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    bArr2[(((int) ((((j76 >>> 4) | j76) & 16711935) + (((((j73 >>> 4) | j73) & 16711935) << 8) | j70))) + 1082131073) ^ 1140066190] = -91;
                    bArr2[16] = -99;
                    bArr2[17] = 60;
                    bArr2[18] = -26;
                    bArr2[19] = 39;
                    bArr2[20] = 56;
                    bArr2[21] = 75;
                    bArr2[22] = 68;
                    bArr2[23] = 75;
                    bArr2[24] = 90;
                    bArr2[25] = 62;
                    j(bArr, bArr2);
                    Charset charset = StandardCharsets.UTF_8;
                    Intent intent = new Intent(new String(bArr, charset).intern());
                    byte[] bArr3 = new byte[32];
                    bArr3[0] = -84;
                    bArr3[1] = -102;
                    bArr3[2] = -38;
                    bArr3[3] = 66;
                    bArr3[4] = 70;
                    bArr3[5] = -17;
                    long j77 = 2129436968;
                    long j78 = -262145;
                    long b4 = c3.b((((((((j77 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j77 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j77 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j77 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j78 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j78 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j78 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j78 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j79 = (b4 >>> 48) & 43690;
                    long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
                    long j81 = ((j80 >>> 2) | j80) & 252645135;
                    long j82 = (b4 >>> 32) & 43690;
                    long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                    long j84 = ((j83 >>> 2) | j83) & 252645135;
                    long j85 = ((((j84 >>> 4) | j84) & 16711935) << 16) + ((((j81 >>> 4) | j81) & 16711935) << 24);
                    long j86 = (b4 >>> 16) & 43690;
                    long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                    long j88 = ((j87 >>> 2) | j87) & 252645135;
                    long j89 = b4 & 43690;
                    long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                    long j91 = ((j90 >>> 2) | j90) & 252645135;
                    bArr3[6] = ((((int) ((((j91 >>> 4) | j91) & 16711935) + (((((j88 >>> 4) | j88) & 16711935) << 8) | j85))) & 161893897) + 69682) ^ 161963522;
                    bArr3[7] = -66;
                    bArr3[8] = -54;
                    bArr3[9] = 11;
                    bArr3[10] = 84;
                    bArr3[11] = 64;
                    bArr3[12] = 55;
                    bArr3[13] = -86;
                    bArr3[14] = -25;
                    bArr3[15] = -104;
                    bArr3[16] = -95;
                    bArr3[17] = 75;
                    bArr3[18] = -63;
                    bArr3[19] = -108;
                    bArr3[20] = -30;
                    bArr3[21] = -103;
                    bArr3[22] = -101;
                    bArr3[23] = -97;
                    bArr3[24] = -50;
                    bArr3[25] = -126;
                    bArr3[26] = -55;
                    long j92 = 33557818;
                    long j93 = j8 + (j7 | j45);
                    long j94 = ((((((((j92 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j92 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j92 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j92 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j93;
                    long j95 = (j94 >>> 48) & 43690;
                    long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                    long j97 = ((j96 >>> 2) | j96) & 252645135;
                    long j98 = (j94 >>> 32) & 43690;
                    long j99 = ((j98 >>> 2) | (j98 >>> 1)) & 858993459;
                    long j100 = ((j99 >>> 2) | j99) & 252645135;
                    long j101 = ((((j100 >>> 4) | j100) & 16711935) << 16) + ((((j97 >>> 4) | j97) & 16711935) << 24);
                    long j102 = (j94 >>> 16) & 43690;
                    long j103 = ((j102 >>> 2) | (j102 >>> 1)) & 858993459;
                    long j104 = ((j103 >>> 2) | j103) & 252645135;
                    long j105 = j94 & 43690;
                    long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
                    long j107 = ((j106 >>> 2) | j106) & 252645135;
                    bArr3[(-471847647) ^ ((-478139376) + (((int) ((((j107 >>> 4) | j107) & 16711935) | (((((j104 >>> 4) | j104) & 16711935) << 8) + j101))) | 6291754))] = 11;
                    bArr3[28] = 104;
                    bArr3[29] = -32;
                    bArr3[30] = 54;
                    bArr3[31] = 101;
                    byte[] bArr4 = new byte[32];
                    bArr4[0] = 49;
                    bArr4[1] = -26;
                    long j108 = -2143158016;
                    long j109 = 0;
                    long j110 = (((((((((j108 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j108 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j108 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j108 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j109 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j109 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j109 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j109 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
                    long j111 = (j110 >>> 48) & 43690;
                    long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
                    long j113 = ((j112 >>> 2) | j112) & 252645135;
                    long j114 = (j110 >>> 32) & 43690;
                    long j115 = ((j114 >>> 2) | (j114 >>> 1)) & 858993459;
                    long j116 = ((j115 >>> 2) | j115) & 252645135;
                    long j117 = ((((j116 >>> 4) | j116) & 16711935) << 16) + ((((j113 >>> 4) | j113) & 16711935) << 24);
                    long j118 = (j110 >>> 16) & 43690;
                    long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
                    long j120 = ((j119 >>> 2) | j119) & 252645135;
                    long j121 = j110 & 43690;
                    long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                    long j123 = ((j122 >>> 2) | j122) & 252645135;
                    int i3 = 1140946965 + ((int) ((((j123 >>> 4) | j123) & 16711935) + ((((j120 >>> 4) | j120) & 16711935) << 8) + j117));
                    long j124 = -1002211049;
                    long j125 = i3;
                    long j126 = ((((((((j124 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j124 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j124 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j124 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j125 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j125 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j125 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j125 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j127 = (j126 >>> 48) & 21845;
                    long j128 = ((j127 >>> 1) | j127) & 858993459;
                    long j129 = ((j128 >>> 2) | j128) & 252645135;
                    long j130 = (j126 >>> 32) & 21845;
                    long j131 = ((j130 >>> 1) | j130) & 858993459;
                    long j132 = ((j131 >>> 2) | j131) & 252645135;
                    long j133 = ((((j132 >>> 4) | j132) & 16711935) << 16) | ((((j129 >>> 4) | j129) & 16711935) << 24);
                    long j134 = (j126 >>> 16) & 21845;
                    long j135 = ((j134 >>> 1) | j134) & 858993459;
                    long j136 = ((j135 >>> 2) | j135) & 252645135;
                    long j137 = ((((j136 >>> 4) | j136) & 16711935) << 8) + j133;
                    long j138 = j126 & 21845;
                    long j139 = (j138 | (j138 >>> 1)) & 858993459;
                    long j140 = (j139 | (j139 >>> 2)) & 252645135;
                    bArr4[(int) (((j140 | (j140 >>> 4)) & 16711935) + j137)] = 40;
                    bArr4[3] = -41;
                    bArr4[4] = -123;
                    bArr4[5] = -75;
                    bArr4[6] = -49;
                    long j141 = j7 + j6 + j8;
                    long j142 = j62 + j141;
                    long j143 = (j142 >>> 48) & 21845;
                    long j144 = (j143 | (j143 >>> 1)) & 858993459;
                    long j145 = (j144 | (j144 >>> 2)) & 252645135;
                    long j146 = (j142 >>> 32) & 21845;
                    long j147 = ((j146 >>> 1) | j146) & 858993459;
                    long j148 = ((j147 >>> 2) | j147) & 252645135;
                    long j149 = (((j145 | (j145 >>> 4)) & 16711935) << 24) | ((((j148 >>> 4) | j148) & 16711935) << 16);
                    long j150 = (j142 >>> 16) & 21845;
                    long j151 = ((j150 >>> 1) | j150) & 858993459;
                    long j152 = ((j151 >>> 2) | j151) & 252645135;
                    long j153 = j149 | ((((j152 >>> 4) | j152) & 16711935) << 8);
                    long j154 = j142 & 21845;
                    long j155 = ((j154 >>> 1) | j154) & 858993459;
                    long j156 = ((j155 >>> 2) | j155) & 252645135;
                    int i4 = (int) ((((j156 >>> 4) | j156) & 16711935) + j153);
                    long j157 = 1593950600;
                    long j158 = i4;
                    long b5 = c3.b((((((((j157 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j157 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j157 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j157 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j159 = (b5 >>> 48) & 43690;
                    long j160 = ((j159 >>> 2) | (j159 >>> 1)) & 858993459;
                    long j161 = ((j160 >>> 2) | j160) & 252645135;
                    long j162 = (b5 >>> 32) & 43690;
                    long j163 = ((j162 >>> 2) | (j162 >>> 1)) & 858993459;
                    long j164 = ((j163 >>> 2) | j163) & 252645135;
                    long j165 = ((((j164 >>> 4) | j164) & 16711935) << 16) + ((((j161 >>> 4) | j161) & 16711935) << 24);
                    long j166 = (b5 >>> 16) & 43690;
                    long j167 = ((j166 >>> 2) | (j166 >>> 1)) & 858993459;
                    long j168 = ((j167 >>> 2) | j167) & 252645135;
                    long j169 = b5 & 43690;
                    long j170 = ((j169 >>> 2) | (j169 >>> 1)) & 858993459;
                    long j171 = ((j170 >>> 2) | j170) & 252645135;
                    bArr4[7] = ((((int) ((((j171 >>> 4) | j171) & 16711935) + (((((j168 >>> 4) | j168) & 16711935) << 8) | j165))) & 1353778176) + 67125762) ^ 1420903948;
                    bArr4[8] = 7;
                    bArr4[9] = -105;
                    bArr4[10] = -79;
                    bArr4[11] = -57;
                    bArr4[12] = -75;
                    bArr4[13] = -29;
                    bArr4[14] = 119;
                    bArr4[15] = -104;
                    long j172 = -1824406916;
                    long j173 = -1824406952;
                    long j174 = (((((((((j172 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j172 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j172 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j172 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j173 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j173 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j173 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j173 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j175 = (j174 >>> 48) & 21845;
                    long j176 = ((j175 >>> 1) | j175) & 858993459;
                    long j177 = ((j176 >>> 2) | j176) & 252645135;
                    long j178 = (j174 >>> 32) & 21845;
                    long j179 = ((j178 >>> 1) | j178) & 858993459;
                    long j180 = ((j179 >>> 2) | j179) & 252645135;
                    long j181 = ((((j180 >>> 4) | j180) & 16711935) << 16) + ((((j177 >>> 4) | j177) & 16711935) << 24);
                    long j182 = (j174 >>> 16) & 21845;
                    long j183 = ((j182 >>> 1) | j182) & 858993459;
                    long j184 = ((j183 >>> 2) | j183) & 252645135;
                    long j185 = j174 & 21845;
                    long j186 = ((j185 >>> 1) | j185) & 858993459;
                    long j187 = ((j186 >>> 2) | j186) & 252645135;
                    bArr4[16] = (int) ((((j187 >>> 4) | j187) & 16711935) + (((((j184 >>> 4) | j184) & 16711935) << 8) | j181));
                    bArr4[17] = 77;
                    bArr4[18] = 86;
                    bArr4[19] = -112;
                    bArr4[20] = -23;
                    bArr4[21] = -11;
                    bArr4[22] = 116;
                    bArr4[23] = 44;
                    bArr4[24] = 62;
                    bArr4[25] = 49;
                    bArr4[26] = 110;
                    bArr4[27] = 32;
                    bArr4[28] = 79;
                    bArr4[29] = -122;
                    bArr4[30] = -19;
                    bArr4[31] = -107;
                    j(bArr3, bArr4);
                    Intent addCategory = intent.addCategory(new String(bArr3, charset).intern());
                    long j188 = j13 + j141;
                    long j189 = (j188 >>> 48) & 21845;
                    long j190 = (j189 | (j189 >>> 1)) & 858993459;
                    long j191 = (j190 | (j190 >>> 2)) & 252645135;
                    long j192 = (j188 >>> 32) & 21845;
                    long j193 = ((j192 >>> 1) | j192) & 858993459;
                    long j194 = ((j193 >>> 2) | j193) & 252645135;
                    long j195 = (((j191 | (j191 >>> 4)) & 16711935) << 24) | ((((j194 >>> 4) | j194) & 16711935) << 16);
                    long j196 = (j188 >>> 16) & 21845;
                    long j197 = ((j196 >>> 1) | j196) & 858993459;
                    long j198 = ((j197 >>> 2) | j197) & 252645135;
                    long j199 = ((((j198 >>> 4) | j198) & 16711935) << 8) + j195;
                    long j200 = j188 & 21845;
                    long j201 = ((j200 >>> 1) | j200) & 858993459;
                    long j202 = ((j201 >>> 2) | j201) & 252645135;
                    byte[] bArr5 = new byte[(((((int) ((((j202 >>> 4) | j202) & 16711935) | j199)) | 199423284) & 545302276) + 155271216) ^ 700573476];
                    bArr5[0] = -55;
                    bArr5[1] = 64;
                    bArr5[2] = 110;
                    bArr5[3] = Byte.MAX_VALUE;
                    bArr5[4] = -113;
                    bArr5[5] = 74;
                    bArr5[6] = 1;
                    bArr5[7] = -72;
                    bArr5[8] = -74;
                    bArr5[9] = 88;
                    bArr5[10] = 55;
                    bArr5[11] = -111;
                    bArr5[12] = -56;
                    bArr5[13] = -123;
                    bArr5[14] = -1;
                    long j203 = 220924930;
                    long j204 = -220924970;
                    long j205 = (((((((((j203 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j203 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j203 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j203 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j204 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j204 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j204 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j204 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j206 = (j205 >>> 48) & 21845;
                    long j207 = ((j206 >>> 1) | j206) & 858993459;
                    long j208 = ((j207 >>> 2) | j207) & 252645135;
                    long j209 = (j205 >>> 32) & 21845;
                    long j210 = ((j209 >>> 1) | j209) & 858993459;
                    long j211 = ((j210 >>> 2) | j210) & 252645135;
                    long j212 = ((((j211 >>> 4) | j211) & 16711935) << 16) | ((((j208 >>> 4) | j208) & 16711935) << 24);
                    long j213 = (j205 >>> 16) & 21845;
                    long j214 = ((j213 >>> 1) | j213) & 858993459;
                    long j215 = ((j214 >>> 2) | j214) & 252645135;
                    long j216 = j205 & 21845;
                    long j217 = (j216 | (j216 >>> 1)) & 858993459;
                    long j218 = (j217 | (j217 >>> 2)) & 252645135;
                    bArr5[15] = (int) (((j218 | (j218 >>> 4)) & 16711935) | (((((j215 >>> 4) | j215) & 16711935) << 8) + j212));
                    long j219 = j11 | j61;
                    long j220 = (j12 | j219) + j93;
                    long j221 = (j220 >>> 48) & 21845;
                    long j222 = ((j221 >>> 1) | j221) & 858993459;
                    long j223 = ((j222 >>> 2) | j222) & 252645135;
                    long j224 = (j220 >>> 32) & 21845;
                    long j225 = ((j224 >>> 1) | j224) & 858993459;
                    long j226 = ((j225 >>> 2) | j225) & 252645135;
                    long j227 = ((((j226 >>> 4) | j226) & 16711935) << 16) | ((((j223 >>> 4) | j223) & 16711935) << 24);
                    long j228 = (j220 >>> 16) & 21845;
                    long j229 = ((j228 >>> 1) | j228) & 858993459;
                    long j230 = ((j229 >>> 2) | j229) & 252645135;
                    long j231 = ((((j230 >>> 4) | j230) & 16711935) << 8) + j227;
                    long j232 = j220 & 21845;
                    long j233 = (j232 | (j232 >>> 1)) & 858993459;
                    long j234 = (j233 | (j233 >>> 2)) & 252645135;
                    long j235 = 1099087968;
                    long j236 = ((((((((j235 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j235 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j235 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j235 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j12 + j219;
                    long j237 = (j236 >>> 48) & 43690;
                    long j238 = ((j237 >>> 2) | (j237 >>> 1)) & 858993459;
                    long j239 = (j238 | (j238 >>> 2)) & 252645135;
                    long j240 = (j236 >>> 32) & 43690;
                    long j241 = ((j240 >>> 2) | (j240 >>> 1)) & 858993459;
                    long j242 = ((j241 >>> 2) | j241) & 252645135;
                    long j243 = (((j239 | (j239 >>> 4)) & 16711935) << 24) | ((((j242 >>> 4) | j242) & 16711935) << 16);
                    long j244 = (j236 >>> 16) & 43690;
                    long j245 = ((j244 >>> 2) | (j244 >>> 1)) & 858993459;
                    long j246 = ((j245 >>> 2) | j245) & 252645135;
                    long j247 = ((((j246 >>> 4) | j246) & 16711935) << 8) + j243;
                    long j248 = j236 & 43690;
                    long j249 = ((j248 >>> 2) | (j248 >>> 1)) & 858993459;
                    long j250 = (j249 | (j249 >>> 2)) & 252645135;
                    j(bArr5, new byte[]{12, S.a(0, -1, 34635801, (((int) (((j234 | (j234 >>> 4)) & 16711935) | j231)) | (-2102046975)) & (-1929312510)) ^ (-1894676656), -124, -94, 1942405171 ^ (843317249 + ((int) (((j250 | (j250 >>> 4)) & 16711935) + j247))), 76, 22, 125, 53, 52, -48, -37, 66, 93, 95, 30});
                    kotlin.jvm.internal.j.d(addCategory, new String(bArr5, charset).intern());
                    it2 = packageManager.queryIntentActivities(addCategory, 0).iterator();
                    c4 = 16011;
                case 60861:
                    parcelable = it.next().activityInfo;
                    c4 = parcelable != null ? (char) 35744 : (char) 56711;
                case 56711:
                    c4 = 16011;
                case 11805:
                    arrayList.addAll(packageManager.getInstalledApplications(0));
                case 12269:
                    break;
                case 8718:
                    arrayList.add((ApplicationInfo) parcelable);
                    c4 = 16011;
                case 9691:
                    c4 = 60861;
                    it = it2;
                case 35744:
                    parcelable = ((ActivityInfo) parcelable).applicationInfo;
                    if (parcelable != null) {
                        c4 = 8718;
                    }
                case 16011:
                    c4 = it2.hasNext() ? (char) 9691 : (char) 52460;
                case 52460:
                    c4 = arrayList.isEmpty() ? (char) 11805 : (char) 12269;
                default:
                    c4 = 8718;
            }
            return arrayList;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
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
                    int a7 = a(bArr3.length);
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

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public static boolean f(android.content.pm.PackageManager r43, java.lang.String r44) {
        /*
            Method dump skipped, instructions count: 13366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.AbstractC0044j.f(android.content.pm.PackageManager, java.lang.String):boolean");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public static boolean g(java.lang.String r40) {
        /*
            Method dump skipped, instructions count: 1264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.AbstractC0044j.g(java.lang.String):boolean");
    }

    public static boolean h(String str, String str2) {
        return kotlin.jvm.internal.j.a(i(str), i(str2));
    }

    public static String i(String str) {
        ArrayList arrayList = null;
        Iterator it = null;
        char c4 = 20656;
        while (true) {
            if (c4 != 6324) {
                if (c4 != 20656) {
                    if (c4 != 11059) {
                        if (c4 == 33528) {
                            List k02 = AbstractC0707i.k0(arrayList);
                            byte[] bArr = {-114};
                            long j2 = -1;
                            long j3 = 262144;
                            long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j5 = (j4 >>> 48) & 21845;
                            long j6 = (j5 | (j5 >>> 1)) & 858993459;
                            long j7 = ((j6 >>> 2) | j6) & 252645135;
                            long j8 = (j4 >>> 32) & 21845;
                            long j9 = ((j8 >>> 1) | j8) & 858993459;
                            long j10 = ((j9 >>> 2) | j9) & 252645135;
                            long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
                            long j12 = (j4 >>> 16) & 21845;
                            long j13 = ((j12 >>> 1) | j12) & 858993459;
                            long j14 = ((j13 >>> 2) | j13) & 252645135;
                            long j15 = j4 & 21845;
                            long j16 = (j15 | (j15 >>> 1)) & 858993459;
                            long j17 = (j16 | (j16 >>> 2)) & 252645135;
                            long j18 = -1957265523;
                            long j19 = (((int) (((j17 | (j17 >>> 4)) & 16711935) + ((((j14 >>> 4) | j14) & 16711935) << 8) + j11)) | (-1073741857)) + 1957265454;
                            long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j21 = (j20 >>> 48) & 21845;
                            long j22 = (j21 | (j21 >>> 1)) & 858993459;
                            long j23 = (j22 | (j22 >>> 2)) & 252645135;
                            long j24 = (j20 >>> 32) & 21845;
                            long j25 = (j24 | (j24 >>> 1)) & 858993459;
                            long j26 = (j25 | (j25 >>> 2)) & 252645135;
                            long j27 = (((j23 | (j23 >>> 4)) & 16711935) << 24) | (((j26 | (j26 >>> 4)) & 16711935) << 16);
                            long j28 = (j20 >>> 16) & 21845;
                            long j29 = (j28 | (j28 >>> 1)) & 858993459;
                            long j30 = (j29 | (j29 >>> 2)) & 252645135;
                            long j31 = j20 & 21845;
                            long j32 = (j31 | (j31 >>> 1)) & 858993459;
                            long j33 = (j32 | (j32 >>> 2)) & 252645135;
                            l(bArr, new byte[]{-94, 30, 80, -91, (int) (((j33 | (j33 >>> 4)) & 16711935) | j27 | (((j30 | (j30 >>> 4)) & 16711935) << 8)), 101, 102, -76});
                            return AbstractC0707i.h0(k02, new String(bArr, StandardCharsets.UTF_8).intern(), null, null, null, 62);
                        }
                    } else if (!it.hasNext()) {
                        c4 = 33528;
                    }
                    c4 = 6324;
                } else {
                    byte[] bArr2 = {-55};
                    l(bArr2, new byte[]{-27, 118, 23, -66, -78, -29, -13, -70});
                    List b02 = N2.f.b0(str, new String[]{new String(bArr2, StandardCharsets.UTF_8).intern()}, 6);
                    ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(b02, 10));
                    it = b02.iterator();
                    arrayList = arrayList2;
                }
            } else {
                String upperCase = N2.f.e0((String) it.next()).toString().toUpperCase(Locale.ROOT);
                byte[] bArr3 = {37, 46, 55, 14, -9, -59, 117, 102, -37, -99, 53, -58, 101, 51, -44, -52};
                l(bArr3, new byte[]{58, 113, 76, -105, 112, -48, -15, 61, -93, 30, 59, 7, 52, 77, -28, -2});
                kotlin.jvm.internal.j.d(upperCase, new String(bArr3, StandardCharsets.UTF_8).intern());
                arrayList.add(upperCase);
            }
            c4 = 11059;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void j(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void l(byte[] bArr, byte[] bArr2) {
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
                    int a6 = a(bArr4.length);
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
}
