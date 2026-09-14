package F0;

import android.R;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import org.apache.tika.fork.ForkServer;
import s2.C0679d;
import t2.AbstractC0705g;
import t2.AbstractC0707i;
import t2.AbstractC0709k;
import t2.C0716r;

/* loaded from: classes.dex */
public final class D0 extends C2 {

    /* renamed from: j, reason: collision with root package name */
    public static final Set f183j;

    /* renamed from: g, reason: collision with root package name */
    public final C0084t0 f184g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f185h;
    public AppOpsManager i;

    static {
        int i = ((~D0.class.getName().length()) | 1006616571) - 460177401;
        long j2 = -1004514140;
        long length = D0.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
        byte[] bArr = {-24, 103, -120, -99, -37, -45, 68, (i + (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | 2110624)) ^ 458066784};
        k(bArr, new byte[]{98, 83, -49, 62, 21, -116, -55, 59});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr2 = new byte[9];
        bArr2[0] = -96;
        bArr2[1] = 69;
        bArr2[2] = 119;
        bArr2[3] = Byte.MIN_VALUE;
        bArr2[4] = -113;
        bArr2[5] = 103;
        bArr2[((((~D0.class.getName().length()) | (-2121087016)) & 47199026) + ((D0.class.getName().length() & 308293795) | 270533761)) ^ 317732789] = -92;
        bArr2[7] = 99;
        bArr2[8] = 124;
        k(bArr2, new byte[]{122, 83, 20, -9, -91, -91, 25, -84, -77});
        String intern2 = new String(bArr2, charset).intern();
        byte[] bArr3 = {-73, 12, 54, 39, -104, -1, 74, -9, 50, -17, 48, -28};
        byte[] bArr4 = new byte[12];
        bArr4[0] = -85;
        bArr4[1] = 27;
        bArr4[2] = -123;
        bArr4[3] = -112;
        bArr4[4] = 61;
        bArr4[5] = -16;
        long j17 = 829985773;
        long j18 = ~D0.class.getName().length();
        long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
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
        long j30 = j19 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = (j31 | (j31 >>> 2)) & 252645135;
        bArr4[((((int) (((j32 | (j32 >>> 4)) & 16711935) | (((((j29 >>> 4) | j29) & 16711935) << 8) + j26))) & 1376553626) + ((D0.class.getName().length() & (-502921198)) | (-1476193280))) ^ (-99639652)] = 82;
        bArr4[7] = (-1490881855) ^ ((((~D0.class.getName().length()) | (-1617385788)) & (-1560141584)) + ((D0.class.getName().length() & 606241328) | 69259784));
        bArr4[8] = 89;
        bArr4[9] = -111;
        bArr4[10] = -19;
        bArr4[11] = 48;
        k(bArr3, bArr4);
        String intern3 = new String(bArr3, charset).intern();
        byte[] bArr5 = {0, 88, 66, 115, 103};
        k(bArr5, new byte[]{-4, 72, 70, 48, -61, -65, -68, 37});
        String intern4 = new String(bArr5, charset).intern();
        byte[] bArr6 = {-53, 110, -49, -116, -66};
        k(bArr6, new byte[]{-100, -111, 95, 123, 5, 19, 18, 98});
        f183j = AbstractC0705g.T(new String[]{intern, intern2, intern3, intern4, new String(bArr6, charset).intern()});
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D0(C0093v1 c0093v1, C0054l1 c0054l1, C0084t0 c0084t0, boolean z3) {
        super(c0093v1, c0054l1);
        byte[] bArr = new byte[6];
        bArr[0] = -79;
        bArr[1] = 91;
        bArr[2] = -96;
        int i = ~(z3 ? 1 : 0);
        int i3 = ((z3 ? 1 : 0) + 604012928) - (604012928 | (z3 ? 1 : 0));
        bArr[(((61552297 | i) & 665354752) + (~((((-266632) | (z3 ? 1 : 0)) | i3) - (i3 | (266631 & (z3 ? 1 : 0)))))) ^ 665621380] = 101;
        bArr[4] = -45;
        long j2 = -1;
        long j3 = z3 ? 1L : 0L;
        long j4 = (((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
        long j5 = (((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
        long j6 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j7 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j8 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j7 + j6 + j5 + j4;
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
        long j22 = -1382705388;
        long j23 = ((((int) ((((j21 >>> 4) | j21) & 16711935) + ((((j18 >>> 4) | j18) & 16711935) << 8) + j15)) | (-1407699196)) & (-1542089728)) + ((17138448 & (z3 ? 1 : 0)) | 159384337);
        long j24 = ((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j23 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j23 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j23 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j23 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j36 = ((j35 >>> 1) | j35) & 858993459;
        long j37 = ((j36 >>> 2) | j36) & 252645135;
        int i4 = (int) ((((j37 >>> 4) | j37) & 16711935) + (((((j34 >>> 4) | j34) & 16711935) << 8) | j31));
        long j38 = 2071085489;
        long j39 = (((-66569) | i) - (-8731705)) + ((99338 & (z3 ? 1 : 0)) | (-2079817209));
        long j40 = (((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j41 = (j40 | (((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j39 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j39 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j39 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j39 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j42 = (j41 >>> 48) & 21845;
        long j43 = ((j42 >>> 1) | j42) & 858993459;
        long j44 = ((j43 >>> 2) | j43) & 252645135;
        long j45 = (j41 >>> 32) & 21845;
        long j46 = ((j45 >>> 1) | j45) & 858993459;
        long j47 = ((j46 >>> 2) | j46) & 252645135;
        long j48 = ((((j47 >>> 4) | j47) & 16711935) << 16) | ((((j44 >>> 4) | j44) & 16711935) << 24);
        long j49 = (j41 >>> 16) & 21845;
        long j50 = ((j49 >>> 1) | j49) & 858993459;
        long j51 = ((j50 >>> 2) | j50) & 252645135;
        long j52 = ((((j51 >>> 4) | j51) & 16711935) << 8) + j48;
        long j53 = j41 & 21845;
        long j54 = (j53 | (j53 >>> 1)) & 858993459;
        long j55 = (j54 | (j54 >>> 2)) & 252645135;
        bArr[i4] = (int) (((j55 | (j55 >>> 4)) & 16711935) + j52);
        r(bArr, new byte[]{-12, 4, -35, -23, -74, -4, 43, 111});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr2 = new byte[8];
        bArr2[0] = 73;
        bArr2[1] = 7;
        bArr2[2] = -8;
        bArr2[3] = -77;
        bArr2[4] = -64;
        bArr2[5] = 20;
        long j56 = 638263263;
        long j57 = i;
        long j58 = (((((((((j56 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j56 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j56 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j56 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j57 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j57 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j57 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j57 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j59 = (j58 >>> 48) & 43690;
        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
        long j61 = ((j60 >>> 2) | j60) & 252645135;
        long j62 = (j58 >>> 32) & 43690;
        long j63 = ((j62 >>> 2) | (j62 >>> 1)) & 858993459;
        long j64 = ((j63 >>> 2) | j63) & 252645135;
        long j65 = ((((j64 >>> 4) | j64) & 16711935) << 16) | ((((j61 >>> 4) | j61) & 16711935) << 24);
        long j66 = (j58 >>> 16) & 43690;
        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
        long j68 = ((j67 >>> 2) | j67) & 252645135;
        long j69 = j58 & 43690;
        long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
        long j71 = (j70 | (j70 >>> 2)) & 252645135;
        int i5 = (int) (((j71 | (j71 >>> 4)) & 16711935) + ((((j68 >>> 4) | j68) & 16711935) << 8) + j65);
        long j72 = 704808000;
        long j73 = i5;
        long j74 = (((((((((j72 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j72 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j73 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j73 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j73 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j73 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j75 = (j74 >>> 48) & 43690;
        long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
        long j77 = ((j76 >>> 2) | j76) & 252645135;
        long j78 = (j74 >>> 32) & 43690;
        long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
        long j80 = ((j79 >>> 2) | j79) & 252645135;
        long j81 = ((((j80 >>> 4) | j80) & 16711935) << 16) | ((((j77 >>> 4) | j77) & 16711935) << 24);
        long j82 = (j74 >>> 16) & 43690;
        long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
        long j84 = ((j83 >>> 2) | j83) & 252645135;
        long j85 = j74 & 43690;
        long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
        long j87 = (j86 | (j86 >>> 2)) & 252645135;
        int i6 = (int) (((j87 | (j87 >>> 4)) & 16711935) | (((((j84 >>> 4) | j84) & 16711935) << 8) + j81));
        long j88 = 134254593;
        long j89 = (((((((((j88 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j88 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j88 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j88 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j6 | j5 | j4 | j7);
        long j90 = (j89 >>> 48) & 43690;
        long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
        long j92 = (j91 | (j91 >>> 2)) & 252645135;
        long j93 = (j89 >>> 32) & 43690;
        long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
        long j95 = (j94 | (j94 >>> 2)) & 252645135;
        long j96 = (((j95 | (j95 >>> 4)) & 16711935) << 16) + (((j92 | (j92 >>> 4)) & 16711935) << 24);
        long j97 = (j89 >>> 16) & 43690;
        long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
        long j99 = (j98 | (j98 >>> 2)) & 252645135;
        long j100 = (((j99 | (j99 >>> 4)) & 16711935) << 8) | j96;
        long j101 = j89 & 43690;
        long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
        long j103 = (j102 | (j102 >>> 2)) & 252645135;
        bArr2[704814283 ^ (((((int) (((j103 | (j103 >>> 4)) & 16711935) | j100)) | 6285) - (~i6)) - 1)] = -79;
        bArr2[7] = -124;
        r(bArr2, new byte[]{82, 50, -81, -73, -53, 77, -12, -47});
        new String(bArr2, charset).intern();
        this.f184g = c0084t0;
        this.f185h = z3;
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

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    public static final F0.C0031f2 D(F0.D0 r106, android.content.pm.PackageManager r107, java.util.ArrayList r108, android.content.Context r109) {
        /*
            Method dump skipped, instructions count: 8556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.D0.D(F0.D0, android.content.pm.PackageManager, java.util.ArrayList, android.content.Context):F0.f2");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    public static String E(PackageManager packageManager, String str) {
        InstallSourceInfo installSourceInfo;
        String initiatingPackageName;
        char c4 = 16815;
        String str2 = null;
        String str3 = null;
        while (true) {
            switch (c4) {
                case 2342:
                    installSourceInfo = packageManager.getInstallSourceInfo(str);
                    initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                    str2 = initiatingPackageName;
                    c4 = 52587;
                case 16815:
                    if (Build.VERSION.SDK_INT < 30) {
                        c4 = 41325;
                    } else {
                        c4 = 2342;
                    }
                case 52876:
                    str3 = null;
                    c4 = 50902;
                case 52587:
                    str3 = str2;
                    c4 = 61868;
                case 41325:
                    try {
                        initiatingPackageName = packageManager.getInstallerPackageName(str);
                        str2 = initiatingPackageName;
                        c4 = 52587;
                    } catch (Exception unused) {
                        c4 = 52876;
                    }
                case 50902:
                    break;
                case 61868:
                    c4 = 50902;
                default:
                    c4 = 61868;
            }
            return str3;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001a. Please report as an issue. */
    public static boolean G(String str, G0.d dVar) {
        Object obj = null;
        G0.d dVar2 = null;
        boolean z3 = false;
        boolean z4 = false;
        char c4 = 24248;
        Object obj2 = null;
        while (true) {
            switch (c4) {
                case 31851:
                    dVar2 = dVar;
                    c4 = 14766;
                case 18172:
                    return false;
                case 47151:
                    z3 = true;
                    c4 = 892;
                case 49086:
                    if (obj != null) {
                        c4 = 14334;
                        obj2 = obj;
                    } else {
                        obj2 = obj;
                        c4 = 47151;
                    }
                case 892:
                    if (z3) {
                        c4 = 18172;
                    } else {
                        c4 = 31851;
                    }
                case 24248:
                    if (str != null) {
                        c4 = 15397;
                        obj2 = str;
                    } else {
                        obj2 = str;
                        c4 = 22487;
                    }
                case 22487:
                    z4 = true;
                    c4 = 39812;
                case 49312:
                    obj = dVar.f800b;
                    c4 = 49086;
                case 39812:
                    if (!z4) {
                        c4 = 49312;
                    } else {
                        c4 = 18172;
                    }
                case 11691:
                    z3 = false;
                    c4 = 892;
                case 15397:
                    if (N2.f.U((CharSequence) obj2)) {
                        c4 = 22487;
                    } else {
                        c4 = 42178;
                    }
                case 14334:
                    if (((Collection) obj2).isEmpty()) {
                        c4 = 47151;
                    } else {
                        c4 = 11691;
                    }
                case 42178:
                    z4 = false;
                    c4 = 39812;
                case 14766:
                    return dVar2.f800b.contains(str);
                default:
                    c4 = 14766;
            }
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
        int i7 = ~D0.class.getName().length();
        int length3 = (((~(((D0.class.getName().length() | 70245657) | i7) - (i7 | (D0.class.getName().length() & (-70245658))))) & (-1979440632)) + ((D0.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(D0.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((D0.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~D0.class.getName().length()) | (-576567005)) & 276971586) + ((D0.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~D0.class.getName().length()) | (-1157759625)) & 1755853004) + ((D0.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~D0.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = D0.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~D0.class.getName().length()) | (-1064961)) + 689325073) + ((D0.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~D0.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = D0.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~D0.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (D0.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((D0.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~D0.class.getName().length();
                    int length11 = (161497089 & (((((D0.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((D0.class.getName().length() | i14) & 797295576))) + ((D0.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~D0.class.getName().length()) | (-1085986263)) & 1078327440) + ((D0.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~D0.class.getName().length();
                    int length12 = length5 >>> ((((~(((D0.class.getName().length() | 626856794) | i15) - ((D0.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((D0.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~D0.class.getName().length()) | 1248713193) & 826417528) + ((D0.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~D0.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (D0.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~D0.class.getName().length()) | (-1005965450)) & 153223237) + ((D0.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((D0.class.getName().length() & (~length6)) & i9)) + ((D0.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~D0.class.getName().length()) | (-30261291)) & (-1534000062)) + ((D0.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~D0.class.getName().length()) | (-23496740)) & 827084804) + ((D0.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~D0.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (D0.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~D0.class.getName().length()) | (-961655275)) & 25184460) + ((D0.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~D0.class.getName().length()) | 1233459797) & 125923146) + ((D0.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~D0.class.getName().length()) | (-7107622)) & 402932290) + ((D0.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((D0.class.getName().length() | length15) - (b4 | length15)) + I2.a(D0.class, b4) + (D0.class.getName().length() & length15);
                    int length17 = ((((~D0.class.getName().length()) | (-81143879)) & 438583424) + ((D0.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~D0.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((D0.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(D0.class, 568748773 | i24) + (D0.class.getName().length() & (-2105278367)))) + ((D0.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~D0.class.getName().length()) | (-1592082969)) & 140665109) + ((D0.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~D0.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((D0.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~D0.class.getName().length()) | (-180811308));
                    int length19 = (D0.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((D0.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | D0.class.getName().length()))));
                    int i29 = ((~D0.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (D0.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~D0.class.getName().length()) | 75364313) & 1242301609) + ((D0.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = D0.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((D0.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~D0.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((D0.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~D0.class.getName().length();
                    int length24 = 1409942802 & (((((D0.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | D0.class.getName().length()) & 91135407));
                    int length25 = (D0.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~D0.class.getName().length()) | (-537919489)) - (-806798471)) + ((D0.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~D0.class.getName().length()) | (-382746167)) & 102532165) + ((D0.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~D0.class.getName().length()) | (-6036961)) & 1233145505) + ((D0.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~D0.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = D0.class.getName().length() & 268460041;
                    i5 = (((((D0.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | D0.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = D0.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((D0.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~D0.class.getName().length()) | (-1883938358)) & (-738125179)) + ((D0.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~D0.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (D0.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(D0.class, -1) | (-532481)) - (-67641369)) + ((D0.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~D0.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((D0.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(D0.class, -1) | (-33554434)) - (-1107366402)) + ((D0.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(D0.class, -1) | (-167014194)) & 1157999680) + ((D0.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = D0.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((D0.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(D0.class, -1) | 114408723) & 1183666176;
                    int length33 = D0.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~D0.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = D0.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~D0.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (D0.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~D0.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((D0.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~D0.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (D0.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~D0.class.getName().length()) | 991120067) & (-2113137661)) + ((D0.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(D0.class, -1) | 314136709) & 371231304) + (((D0.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~D0.class.getName().length()) | 366661365) & 1344150018) + ((D0.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~D0.class.getName().length()) | (-1359635359)) & 49026131) + ((D0.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~D0.class.getName().length();
                    if (length3 > 0) {
                        int length38 = D0.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (D0.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~D0.class.getName().length()) | 1110430873) & 1241612298) + ((D0.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~D0.class.getName().length()) | 1603962366) & 25199440) + (((D0.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~D0.class.getName().length()) | (-1388708984)) & 706816128) + ((D0.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~D0.class.getName().length()) | 367288948) & 548745488;
                    int length41 = D0.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~D0.class.getName().length()) | 2113158628) & 1026558002) + ((D0.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~D0.class.getName().length()) | 715175224) & 136512788) + ((D0.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~D0.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = D0.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~D0.class.getName().length()) | (-1084937228)) & 438503696) + ((D0.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~D0.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((D0.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(D0.class, 1197735420 | i53) + (D0.class.getName().length() & 674349280))) + ((D0.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~D0.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (D0.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~D0.class.getName().length()) | (-171976913)) & 318775824) + ((D0.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~D0.class.getName().length()) | (-616910267)) & 1303391760) + ((D0.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~D0.class.getName().length()) | 1297715640) & 556926729) + ((D0.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~D0.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((D0.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~D0.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (D0.class.getName().length() & 44040224) | (-1811807712)), 1);
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0019. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:58:0x0076. Please report as an issue. */
    public final C0085t1 C(PackageInfo packageInfo) {
        char c4 = 9363;
        Object obj = null;
        C0084t0 c0084t0 = null;
        D0 d02 = null;
        List list = null;
        String str = null;
        List list2 = null;
        boolean z3 = false;
        while (true) {
            switch (c4) {
                case 51599:
                    return new C0085t1(packageInfo, m3.b.D(C0030f1.f508b), (String) obj, null, 92);
                case 36845:
                    str = B0.b(packageInfo);
                    if (str == null) {
                        c4 = 63562;
                    } else {
                        c4 = 34141;
                    }
                case 15703:
                    G0.h hVar = (G0.h) c0084t0.f664b;
                    String[] strArr = new String[0];
                    Set set = null;
                    char c5 = 4743;
                    List list3 = null;
                    while (true) {
                        switch (c5) {
                            case 46942:
                            case 58363:
                                list3 = null;
                                c5 = 23831;
                            case 4743:
                                if (hVar != null) {
                                    c5 = 3450;
                                } else {
                                    c5 = 25597;
                                }
                            case 'i':
                                list3 = AbstractC0705g.B(strArr);
                                c5 = 23831;
                            case 8566:
                                list3 = AbstractC0707i.q0(set);
                                c5 = 23831;
                            case 3450:
                                set = hVar.f812b;
                                if (set != null) {
                                    c5 = 8566;
                                } else {
                                    c5 = 58363;
                                }
                            case 23831:
                                break;
                            case 25597:
                                ((G0.l) c0084t0.f663a).getClass();
                                c5 = 46942;
                                strArr = null;
                            default:
                                c5 = 8566;
                        }
                        list2 = list3;
                        c4 = 24778;
                    }
                case 61253:
                    if (((Collection) obj).isEmpty()) {
                        c4 = 26673;
                    } else {
                        c4 = 48991;
                    }
                case 9363:
                    c4 = 60594;
                    d02 = this;
                case 11600:
                    if (z3) {
                        c4 = 63488;
                    } else {
                        c4 = 36845;
                    }
                case 60594:
                    c0084t0 = d02.f184g;
                    if (c0084t0 != null) {
                        c4 = 15703;
                    } else {
                        c4 = 53507;
                    }
                case 34141:
                    if (list.contains(str)) {
                        c4 = 51599;
                        obj = str;
                    } else {
                        obj = str;
                        c4 = 63488;
                    }
                case 63562:
                case 63488:
                    return null;
                case 48991:
                    z3 = false;
                    c4 = 11600;
                case 53507:
                    list2 = null;
                    c4 = 24778;
                case 26673:
                    z3 = true;
                    c4 = 11600;
                case 24778:
                    if (list2 != null) {
                        c4 = 61253;
                        obj = list2;
                        list = obj;
                    } else {
                        obj = list2;
                        list = obj;
                        c4 = 26673;
                    }
                default:
                    c4 = 34141;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public final boolean F(PackageInfo packageInfo, String str, G0.d dVar) {
        char c4 = 7501;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            switch (c4) {
                case 40945:
                    if (!G(str, dVar)) {
                        c4 = 56776;
                    } else {
                        c4 = 6490;
                    }
                case 6490:
                case 2102:
                case 27122:
                case 7581:
                    z5 = false;
                    c4 = 29191;
                case 22866:
                    if (!G(str, dVar)) {
                        c4 = 57014;
                    } else {
                        c4 = 27122;
                    }
                case 6937:
                    if (L(packageInfo)) {
                        c4 = 58841;
                    } else {
                        c4 = 39926;
                    }
                case 35849:
                    if (!M(packageInfo)) {
                        c4 = 14668;
                    } else {
                        c4 = 6490;
                    }
                case 24084:
                    if (!z3) {
                        c4 = 60530;
                    } else {
                        c4 = 2102;
                    }
                case 56776:
                case 30061:
                case 57014:
                case 60530:
                case 59586:
                    c4 = 29191;
                    z5 = true;
                case 8524:
                    z3 = G(str, dVar);
                    if (z4) {
                        c4 = 24084;
                    } else {
                        c4 = 2102;
                    }
                case 44454:
                    if (!G(str, dVar)) {
                        c4 = 30061;
                    } else {
                        c4 = 7581;
                    }
                case 14668:
                    if (!L(packageInfo)) {
                        c4 = 40945;
                    } else {
                        c4 = 6490;
                    }
                case 39926:
                    z4 = false;
                    c4 = 8524;
                case 34480:
                    if (M(packageInfo)) {
                        c4 = 6937;
                    } else {
                        c4 = 58841;
                    }
                case 29191:
                    return z5;
                case 7501:
                    int i = C0.f179b[dVar.f799a.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i != 5) {
                                        c4 = 51994;
                                    } else {
                                        c4 = 59586;
                                    }
                                } else {
                                    c4 = 34480;
                                }
                            } else {
                                c4 = 38326;
                            }
                        } else {
                            c4 = 44454;
                        }
                    } else {
                        c4 = 35849;
                    }
                case 38326:
                    if (!L(packageInfo)) {
                        c4 = 22866;
                    } else {
                        c4 = 27122;
                    }
                case 58841:
                    c4 = 8524;
                    z4 = true;
                case 51994:
                    throw new NoWhenBranchMatchedException();
                default:
                    c4 = 57014;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x002f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0015. Please report as an issue. */
    public final C0085t1 H(PackageInfo packageInfo) {
        char c4;
        char c5 = 4095;
        List list = null;
        List list2 = null;
        List list3 = null;
        C0084t0 c0084t0 = null;
        boolean z3 = false;
        int i = 0;
        while (true) {
            switch (c5) {
                case 25035:
                    if (!z3) {
                        c4 = 52499;
                        c5 = c4;
                    }
                    c4 = 43783;
                    c5 = c4;
                case 52499:
                    i = list.indexOf(packageInfo.packageName);
                    if (i >= 0) {
                        c4 = 42768;
                        c5 = c4;
                    }
                    c4 = 43783;
                    c5 = c4;
                case 61222:
                    if (list2 != null) {
                        c5 = 61081;
                        list = list2;
                        list3 = list;
                    } else {
                        list = list2;
                        list3 = list;
                        c5 = 60871;
                    }
                case 61937:
                    list2 = null;
                    c5 = 61222;
                case 61081:
                    if (list3.isEmpty()) {
                        c5 = 60871;
                    } else {
                        c4 = 29503;
                        c5 = c4;
                    }
                case 43783:
                    return null;
                case 29503:
                    z3 = false;
                    c5 = 25035;
                case 4095:
                    c0084t0 = this.f184g;
                    if (c0084t0 != null) {
                        c4 = 56990;
                    } else {
                        c4 = 61937;
                    }
                    c5 = c4;
                case 42768:
                    return new C0085t1(packageInfo, m3.b.D(C0030f1.f508b), null, Integer.valueOf(i), 60);
                case 56990:
                    G0.h hVar = (G0.h) c0084t0.f664b;
                    Set set = null;
                    char c6 = 11619;
                    String[] strArr = new String[0];
                    list2 = null;
                    while (true) {
                        switch (c6) {
                            case 47807:
                                ((G0.l) c0084t0.f663a).getClass();
                                c6 = 63928;
                                strArr = null;
                            case 11619:
                                if (hVar != null) {
                                    c6 = 3340;
                                } else {
                                    c6 = 47807;
                                }
                            case 29384:
                                list2 = AbstractC0707i.q0(set);
                                c6 = 10160;
                            case 3340:
                                set = hVar.f811a;
                                if (set != null) {
                                    c6 = 29384;
                                } else {
                                    c6 = 35854;
                                }
                            case 63928:
                            case 35854:
                                list2 = null;
                                c6 = 10160;
                            case 10160:
                                break;
                            case 22702:
                                list2 = AbstractC0705g.B(strArr);
                                c6 = 10160;
                            default:
                                c6 = 35854;
                        }
                        c5 = 61222;
                    }
                case 60871:
                    z3 = true;
                    c5 = 25035;
                default:
                    c4 = 29503;
                    c5 = c4;
            }
        }
    }

    public final Set I(List list) {
        try {
            return t2.t.f6478a;
        } catch (Exception unused) {
            byte[] bArr = new byte[15];
            bArr[0] = 102;
            bArr[1] = -98;
            bArr[2] = 66;
            boolean z3 = this.f185h;
            int i = ~(z3 ? 1 : 0);
            bArr[3] = 699501095 ^ (((((-2113534800) & (z3 ? 1 : 0)) | 1077952785) - (~((1418228312 | i) & (-1777453920)))) - 1);
            bArr[4] = -114;
            bArr[5] = 36;
            bArr[6] = -55;
            bArr[7] = 57;
            bArr[8] = -49;
            bArr[9] = 60;
            bArr[10] = -11;
            bArr[11] = -49;
            bArr[12] = 75;
            bArr[13] = -122;
            long j2 = -1621848670;
            long j3 = ((i | (-1649965737)) & 39095724) + (((z3 ? 1 : 0) & 391121064) | (-1660944384));
            long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
            long j15 = ((((j14 >>> 4) | j14) & 16711935) << 8) + j11;
            long j16 = j4 & 21845;
            long j17 = (j16 | (j16 >>> 1)) & 858993459;
            long j18 = (j17 | (j17 >>> 2)) & 252645135;
            long j19 = 973785401;
            long j20 = (-1) - (z3 ? 1 : 0);
            long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
            long j22 = (j21 >>> 48) & 43690;
            long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
            long j24 = ((j23 >>> 2) | j23) & 252645135;
            long j25 = (j21 >>> 32) & 43690;
            long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
            long j27 = ((j26 >>> 2) | j26) & 252645135;
            long j28 = ((((j27 >>> 4) | j27) & 16711935) << 16) + ((((j24 >>> 4) | j24) & 16711935) << 24);
            long j29 = (j21 >>> 16) & 43690;
            long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
            long j31 = ((j30 >>> 2) | j30) & 252645135;
            long j32 = j21 & 43690;
            long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
            long j34 = ((j33 >>> 2) | j33) & 252645135;
            int i3 = ((int) ((((j34 >>> 4) | j34) & 16711935) + ((((j31 >>> 4) | j31) & 16711935) << 8) + j28)) & (-184480507);
            long j35 = -989788668;
            long j36 = z3 ? 1L : 0L;
            long j37 = ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j38 = (j37 >>> 48) & 43690;
            long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
            long j40 = ((j39 >>> 2) | j39) & 252645135;
            long j41 = (j37 >>> 32) & 43690;
            long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
            long j43 = ((j42 >>> 2) | j42) & 252645135;
            long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) + ((((j40 >>> 4) | j40) & 16711935) << 24);
            long j45 = (j37 >>> 16) & 43690;
            long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
            long j47 = ((j46 >>> 2) | j46) & 252645135;
            long j48 = j37 & 43690;
            long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
            long j50 = ((j49 >>> 2) | j49) & 252645135;
            bArr[(int) (((j18 | (j18 >>> 4)) & 16711935) + j15)] = (i3 + (((int) ((((j50 >>> 4) | j50) & 16711935) + (((((j47 >>> 4) | j47) & 16711935) << 8) + j44))) | 135271040)) ^ (-49209351);
            byte[] bArr2 = new byte[15];
            bArr2[0] = 20;
            bArr2[1] = 47;
            bArr2[2] = 25;
            bArr2[3] = -6;
            bArr2[4] = -40;
            bArr2[5] = -122;
            bArr2[6] = -106;
            bArr2[(((465519909 | i) & 6345989) + (((z3 ? 1 : 0) & 1077973056) | 1677729864)) ^ 1684075850] = -106;
            bArr2[8] = -109;
            bArr2[9] = 120;
            bArr2[10] = 122;
            long j51 = -347353336;
            long j52 = ((i | 1549446927) & 1615498496) + ((553730051 & (z3 ? 1 : 0)) | (-1962851837));
            long j53 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j52 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j52 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j52 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j52 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
            long j54 = (j53 >>> 48) & 21845;
            long j55 = ((j54 >>> 1) | j54) & 858993459;
            long j56 = ((j55 >>> 2) | j55) & 252645135;
            long j57 = (j53 >>> 32) & 21845;
            long j58 = ((j57 >>> 1) | j57) & 858993459;
            long j59 = ((j58 >>> 2) | j58) & 252645135;
            long j60 = ((((j59 >>> 4) | j59) & 16711935) << 16) | ((((j56 >>> 4) | j56) & 16711935) << 24);
            long j61 = (j53 >>> 16) & 21845;
            long j62 = ((j61 >>> 1) | j61) & 858993459;
            long j63 = ((j62 >>> 2) | j62) & 252645135;
            long j64 = ((((j63 >>> 4) | j63) & 16711935) << 8) + j60;
            long j65 = j53 & 21845;
            long j66 = (j65 | (j65 >>> 1)) & 858993459;
            long j67 = (j66 | (j66 >>> 2)) & 252645135;
            bArr2[(int) (((j67 | (j67 >>> 4)) & 16711935) + j64)] = -59;
            bArr2[12] = 63;
            bArr2[13] = -23;
            bArr2[14] = 14;
            y(bArr, bArr2);
            Charset charset = StandardCharsets.UTF_8;
            new String(bArr, charset).intern();
            byte[] bArr3 = new byte[33];
            bArr3[0] = -100;
            bArr3[1] = 35;
            bArr3[2] = -76;
            bArr3[3] = 49;
            bArr3[4] = -2;
            bArr3[5] = 28;
            bArr3[6] = -98;
            bArr3[7] = 119;
            bArr3[8] = 40;
            bArr3[9] = -58;
            bArr3[10] = 64;
            bArr3[11] = 65;
            bArr3[12] = -40;
            bArr3[13] = 97;
            bArr3[14] = -37;
            bArr3[15] = 115;
            bArr3[16] = -57;
            bArr3[17] = -83;
            bArr3[18] = -79;
            bArr3[19] = 110;
            bArr3[20] = Byte.MIN_VALUE;
            bArr3[21] = Byte.MIN_VALUE;
            bArr3[22] = 66;
            bArr3[23] = 12;
            bArr3[24] = -18;
            bArr3[25] = -124;
            int i4 = ~(z3 ? 1 : 0);
            int i5 = (((-875095020) | i4) & (-775683008)) + (671617159 | (((z3 ? 1 : 0) | 940048452) - (940048452 ^ (z3 ? 1 : 0))));
            bArr3[26] = (((~i5) & 104065841) - (104065841 & i5)) + i5;
            bArr3[27] = 61;
            int i6 = (354494842 | i4) & 537481906;
            int i7 = (843600512 & (z3 ? 1 : 0)) | 306192384;
            bArr3[843674286 ^ (((i7 | i6) - (((~i6) & (z3 ? 1 : 0)) & i7)) + (((z3 ? 1 : 0) | i6) & i7))] = 123;
            bArr3[29] = 45;
            bArr3[30] = -70;
            bArr3[(-1607129340) ^ (((((-1607137534) | (z3 ? 1 : 0)) - ((-1581807710) | i4)) + ((((-2121104734) | i4) - (z3 ? 1 : 0)) + ((z3 ? 1 : 0) & (-1607137534)))) + ((539297041 & (z3 ? 1 : 0)) | 8217))] = -84;
            bArr3[32] = -101;
            long j68 = 2426888;
            long j69 = (-1000075255) & (z3 ? 1 : 0);
            long b4 = c3.b((((((((j68 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j68 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j68 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j68 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
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
            byte b5 = (((159826422 | i4) & (-842919903)) + ((int) ((((j82 >>> 4) | j82) & 16711935) + (((((j79 >>> 4) | j79) & 16711935) << 8) | j76)))) ^ (-840493006);
            long j83 = -1;
            long j84 = z3 ? 1L : 0L;
            long j85 = (((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
            long j86 = (j85 >>> 48) & 21845;
            long j87 = ((j86 >>> 1) | j86) & 858993459;
            long j88 = ((j87 >>> 2) | j87) & 252645135;
            long j89 = (j85 >>> 32) & 21845;
            long j90 = ((j89 >>> 1) | j89) & 858993459;
            long j91 = ((j90 >>> 2) | j90) & 252645135;
            long j92 = ((((j91 >>> 4) | j91) & 16711935) << 16) | ((((j88 >>> 4) | j88) & 16711935) << 24);
            long j93 = (j85 >>> 16) & 21845;
            long j94 = ((j93 >>> 1) | j93) & 858993459;
            long j95 = ((j94 >>> 2) | j94) & 252645135;
            long j96 = j85 & 21845;
            long j97 = (j96 | (j96 >>> 1)) & 858993459;
            long j98 = (j97 | (j97 >>> 2)) & 252645135;
            byte b6 = ((1124215426 & (((-483546952) + ((int) (((j98 | (j98 >>> 4)) & 16711935) + (((((j95 >>> 4) | j95) & 16711935) << 8) + j92)))) + (((-r5) - 1) | 483546952))) + ((((-268568321) | (z3 ? 1 : 0)) + 268568321) | 403244293)) ^ (-1527459824);
            byte b7 = ((((i4 ^ (-1103692070)) + (i4 & (-1103692070))) & 184972295) + ((19431685 & (z3 ? 1 : 0)) | 616073504)) ^ 801045822;
            int i8 = (((-1) - (z3 ? 1 : 0)) | 1571183906) & 2359747;
            long j99 = 578830848;
            long j100 = (z3 ? 1 : 0) & 41943233;
            long b8 = c3.b((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j100 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j100 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j100 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j100 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
            long j101 = (b8 >>> 48) & 43690;
            long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
            long j103 = ((j102 >>> 2) | j102) & 252645135;
            long j104 = (b8 >>> 32) & 43690;
            long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
            long j106 = ((j105 >>> 2) | j105) & 252645135;
            long j107 = ((((j106 >>> 4) | j106) & 16711935) << 16) | ((((j103 >>> 4) | j103) & 16711935) << 24);
            long j108 = (b8 >>> 16) & 43690;
            long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
            long j110 = ((j109 >>> 2) | j109) & 252645135;
            long j111 = b8 & 43690;
            long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
            long j113 = ((j112 >>> 2) | j112) & 252645135;
            y(bArr3, new byte[]{-62, -127, -80, 119, 117, 108, -28, b5, 67, -33, 24, 63, -31, 62, -97, 56, b6, -13, -66, 103, -42, 17, b7, -108, 120, 38, 581190589 ^ (i8 + ((int) ((((j113 >>> 4) | j113) & 16711935) + (((((j110 >>> 4) | j110) & 16711935) << 8) | j107)))), 54, 1, 117, -55, -24, -16});
            new String(bArr3, charset).intern();
            ArrayList arrayList = new ArrayList(AbstractC0709k.Y(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C0679d((PackageInfo) it.next(), R1.f371a));
            }
            return AbstractC0707i.u0(arrayList);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0045. Please report as an issue. */
    public final ArrayList J(Context context) {
        List<PackageInfo> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        boolean z3;
        String[] strArr;
        int[] iArr;
        U u3;
        U u4;
        U u5;
        U u6;
        P0 p02 = new P0(context, this.i, new A0(this, 0));
        ArrayList arrayList6 = new ArrayList();
        try {
            PackageManager packageManager = p02.f356a.getPackageManager();
            if (packageManager == null || (list = packageManager.getInstalledPackages(4096)) == null) {
                list = C0716r.f6476a;
            }
            for (PackageInfo packageInfo : list) {
                char c4 = 28144;
                ApplicationInfo applicationInfo = null;
                while (true) {
                    boolean z4 = false;
                    while (true) {
                        switch (c4) {
                            case 26892:
                                z4 = true;
                                c4 = 58839;
                            case 3643:
                                break;
                            case 23123:
                                long j2 = 129;
                                long j3 = applicationInfo.flags;
                                long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
                                long j17 = (j16 | (j16 >>> 2)) & 252645135;
                                if (((int) ((((((j14 >>> 4) | j14) & 16711935) << 8) + j11) | ((j17 | (j17 >>> 4)) & 16711935))) != 0) {
                                    c4 = 26892;
                                } else {
                                    c4 = 3643;
                                }
                            case 28144:
                                applicationInfo = packageInfo.applicationInfo;
                                if (applicationInfo == null) {
                                    c4 = 19417;
                                } else {
                                    c4 = 23123;
                                }
                            case 19417:
                                z3 = false;
                                break;
                            case 58839:
                                z3 = z4;
                                break;
                            default:
                                c4 = 28144;
                        }
                    }
                    c4 = 58839;
                }
                if (!z3 && !p02.h(packageInfo) && (strArr = packageInfo.requestedPermissions) != null && (iArr = packageInfo.requestedPermissionsFlags) != null) {
                    Set e4 = P0.e(strArr, iArr);
                    long currentTimeMillis = System.currentTimeMillis();
                    G0.j i = p02.i(packageInfo, e4);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (i != null) {
                        u3 = new U(i, currentTimeMillis2, p02.c(i));
                    } else {
                        u3 = null;
                    }
                    if (u3 != null) {
                        arrayList6.add(u3);
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    G0.j r3 = p02.r(packageInfo, e4);
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    if (r3 != null) {
                        u4 = new U(r3, currentTimeMillis4, p02.c(r3));
                    } else {
                        u4 = null;
                    }
                    if (u4 != null) {
                        arrayList6.add(u4);
                    }
                    long currentTimeMillis5 = System.currentTimeMillis();
                    G0.j n4 = p02.n(packageInfo, e4);
                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                    if (n4 != null) {
                        u5 = new U(n4, currentTimeMillis6, p02.c(n4));
                    } else {
                        u5 = null;
                    }
                    if (u5 != null) {
                        arrayList6.add(u5);
                    }
                    long currentTimeMillis7 = System.currentTimeMillis();
                    G0.j a2 = P0.a(packageInfo, e4);
                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis7;
                    if (a2 != null) {
                        u6 = new U(a2, currentTimeMillis8, p02.c(a2));
                    } else {
                        u6 = null;
                    }
                    if (u6 != null) {
                        arrayList6.add(u6);
                    }
                }
            }
            long currentTimeMillis9 = System.currentTimeMillis();
            List<G0.j> o2 = p02.o();
            long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis9;
            if (o2 != null) {
                arrayList = new ArrayList(AbstractC0709k.Y(o2, 10));
                for (G0.j jVar : o2) {
                    arrayList.add(new U(jVar, currentTimeMillis10, p02.c(jVar)));
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                arrayList6.addAll(arrayList);
            }
            long currentTimeMillis11 = System.currentTimeMillis();
            List<G0.j> t3 = p02.t();
            long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis11;
            if (t3 != null) {
                int i3 = ~P0.class.getName().length();
                arrayList2 = new ArrayList(AbstractC0709k.Y(t3, (-1681309203) ^ ((436289958 & (((~i3) & 1835002070) + i3)) + ((P0.class.getName().length() & (-1824521888)) | (-2117599167)))));
                for (G0.j jVar2 : t3) {
                    arrayList2.add(new U(jVar2, currentTimeMillis12, p02.c(jVar2)));
                }
            } else {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                arrayList6.addAll(arrayList2);
            }
            long currentTimeMillis13 = System.currentTimeMillis();
            ArrayList x3 = p02.x();
            long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis13;
            if (x3 != null) {
                arrayList3 = new ArrayList(AbstractC0709k.Y(x3, 10));
                int size = x3.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = x3.get(i4);
                    i4++;
                    G0.j jVar3 = (G0.j) obj;
                    arrayList3.add(new U(jVar3, currentTimeMillis14, p02.c(jVar3)));
                }
            } else {
                arrayList3 = null;
            }
            if (arrayList3 != null) {
                arrayList6.addAll(arrayList3);
            }
            long currentTimeMillis15 = System.currentTimeMillis();
            List<G0.j> s3 = p02.s();
            long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis15;
            if (s3 != null) {
                arrayList4 = new ArrayList(AbstractC0709k.Y(s3, 10));
                for (G0.j jVar4 : s3) {
                    arrayList4.add(new U(jVar4, currentTimeMillis16, p02.c(jVar4)));
                }
            } else {
                arrayList4 = null;
            }
            if (arrayList4 != null) {
                arrayList6.addAll(arrayList4);
            }
            long currentTimeMillis17 = System.currentTimeMillis();
            ArrayList v2 = p02.v();
            long currentTimeMillis18 = System.currentTimeMillis() - currentTimeMillis17;
            if (v2 != null) {
                ArrayList arrayList7 = new ArrayList(AbstractC0709k.Y(v2, 10));
                int size2 = v2.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj2 = v2.get(i5);
                    i5++;
                    G0.j jVar5 = (G0.j) obj2;
                    arrayList7.add(new U(jVar5, currentTimeMillis18, p02.c(jVar5)));
                }
                arrayList5 = arrayList7;
            } else {
                arrayList5 = null;
            }
            if (arrayList5 != null) {
                arrayList6.addAll(arrayList5);
            }
        } catch (Exception unused) {
        }
        return arrayList6;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:162:0x0421. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0093. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:68:0x02ab. Please report as an issue. */
    public final Set K(PackageInfo packageInfo) {
        int[] iArr;
        C0084t0 c0084t0;
        Set set;
        int i;
        Set set2;
        int[] iArr2;
        C0084t0 c0084t02;
        Set set3;
        char c4;
        char c5;
        C0084t0 c0084t03;
        char c6;
        C0084t0 c0084t04;
        int i3 = 0;
        String[] strArr = new String[0];
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i6 = 0;
        String[] strArr2 = new String[0];
        String[] strArr3 = new String[0];
        int[] iArr3 = new int[0];
        char c7 = 13531;
        Collection collection = null;
        String str = null;
        C0084t0 c0084t05 = null;
        Set set4 = null;
        String str2 = null;
        List list = null;
        C0084t0 c0084t06 = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        Iterator it = null;
        Object obj = null;
        List list2 = null;
        ArrayList arrayList3 = null;
        Integer num = null;
        List list3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        Set set5 = null;
        ArrayList arrayList7 = null;
        int[] iArr4 = new int[0];
        Set set6 = null;
        while (true) {
            boolean z10 = z3;
            List list4 = list;
            C0084t0 c0084t07 = this.f184g;
            switch (c7) {
                case 11895:
                    i = i3;
                    set2 = set6;
                    iArr2 = iArr4;
                    c0084t02 = c0084t05;
                    set3 = set4;
                    if (it.hasNext()) {
                        c4 = 17821;
                    } else {
                        c4 = 37447;
                    }
                    set4 = set3;
                    z3 = z10;
                    list = list4;
                    iArr4 = iArr2;
                    c0084t05 = c0084t02;
                    set6 = set2;
                    c7 = c4;
                    i3 = i;
                case 58497:
                    i = i3;
                    set2 = set6;
                    iArr2 = iArr4;
                    c0084t02 = c0084t05;
                    Set set7 = set4;
                    list = (List) it.next();
                    if (!list.isEmpty()) {
                        c4 = 23570;
                    } else {
                        c4 = 33059;
                    }
                    set4 = set7;
                    z3 = z10;
                    iArr4 = iArr2;
                    c0084t05 = c0084t02;
                    set6 = set2;
                    c7 = c4;
                    i3 = i;
                case 29460:
                    i = i3;
                    collection = (Collection) obj;
                    c4 = 57010;
                    z3 = z10;
                    list = list4;
                    c7 = c4;
                    i3 = i;
                case 47714:
                    z3 = z10;
                    list = list4;
                    c7 = 62937;
                    z6 = false;
                case 35487:
                    z3 = z10;
                    list = list4;
                    c7 = 8637;
                    z5 = false;
                case 62393:
                    obj = list3.iterator();
                    z3 = z10;
                    list = list4;
                    c7 = 270;
                case 23585:
                case 22488:
                case 42992:
                    return null;
                case 23570:
                    z3 = z10;
                    list = list4;
                    c7 = 59034;
                    z7 = true;
                case 46457:
                    int i7 = i3;
                    iArr = iArr4;
                    c0084t0 = c0084t05;
                    Set set8 = set4;
                    set6 = AbstractC0705g.T(strArr3);
                    int[] iArr5 = packageInfo.requestedPermissionsFlags;
                    if (iArr5 != null) {
                        c5 = 9842;
                    } else {
                        c5 = 56643;
                    }
                    iArr3 = iArr5;
                    strArr = strArr3;
                    set4 = set8;
                    z3 = z10;
                    list = list4;
                    i3 = i7;
                    c0084t05 = c0084t0;
                    c7 = c5;
                    iArr4 = iArr;
                case 56643:
                    set5 = t2.t.f6478a;
                    z3 = z10;
                    list = list4;
                    c7 = 30365;
                case 59908:
                    i = i3;
                    set2 = set6;
                    iArr2 = iArr4;
                    c0084t02 = c0084t05;
                    Set set9 = set4;
                    if (c0084t07 != null) {
                        c4 = 65000;
                    } else {
                        c4 = 17812;
                    }
                    c0084t06 = c0084t07;
                    set4 = set9;
                    arrayList5 = arrayList6;
                    z3 = z10;
                    list = list4;
                    iArr4 = iArr2;
                    c0084t05 = c0084t02;
                    set6 = set2;
                    c7 = c4;
                    i3 = i;
                case 13734:
                    i = i3;
                    str2 = (String) ((Iterator) obj).next();
                    c4 = 44047;
                    z3 = z10;
                    list = list4;
                    c7 = c4;
                    i3 = i;
                case 45834:
                    i = i3;
                    set2 = set6;
                    iArr2 = iArr4;
                    c0084t02 = c0084t05;
                    set3 = set4;
                    if (z10) {
                        c4 = 10576;
                        set4 = set3;
                        z3 = z10;
                        list = list4;
                        iArr4 = iArr2;
                        c0084t05 = c0084t02;
                        set6 = set2;
                        c7 = c4;
                        i3 = i;
                    }
                    c4 = 21772;
                    set4 = set3;
                    z3 = z10;
                    list = list4;
                    iArr4 = iArr2;
                    c0084t05 = c0084t02;
                    set6 = set2;
                    c7 = c4;
                    i3 = i;
                case 43932:
                    c7 = 28140;
                    z3 = z10;
                    list = list4;
                    z4 = true;
                case 23852:
                    c7 = 33543;
                    z3 = z10;
                    list = list4;
                    z9 = true;
                case 51718:
                    c7 = 33543;
                    z3 = z10;
                    list = list4;
                    z9 = false;
                case 64516:
                    return AbstractC0707i.u0(list4);
                case 37392:
                    c7 = 28140;
                    z3 = z10;
                    list = list4;
                    z4 = false;
                case 54023:
                    z3 = z10;
                    list = list4;
                    c7 = 19124;
                case 9842:
                    obj = new ArrayList();
                    i3 = strArr.length;
                    strArr2 = strArr;
                    iArr4 = iArr3;
                    z3 = z10;
                    list = list4;
                    c7 = 30286;
                    i4 = 0;
                    i5 = 0;
                case 65000:
                    int[] iArr6 = iArr4;
                    C0084t0 c0084t08 = c0084t05;
                    Set set10 = set4;
                    c0084t06.getClass();
                    int i8 = 0;
                    Object[] objArr = new Object[0];
                    char c8 = 61628;
                    int i9 = i3;
                    Set set11 = set6;
                    String[] strArr4 = new String[0];
                    int i10 = 0;
                    Set set12 = null;
                    C0084t0 c0084t09 = null;
                    ArrayList arrayList8 = null;
                    arrayList7 = null;
                    Iterator it2 = null;
                    Set set13 = null;
                    while (true) {
                        switch (c8) {
                            case 46703:
                                break;
                            case 20854:
                                arrayList7 = null;
                                c8 = 46703;
                            case 53740:
                                c0084t03 = c0084t09;
                                ((G0.l) c0084t06.f663a).getClass();
                                c8 = 42140;
                                strArr4 = null;
                                c0084t09 = c0084t03;
                            case 13636:
                                arrayList7 = arrayList8;
                                c8 = 46703;
                            case 42140:
                                C0084t0 c0084t010 = c0084t09;
                                arrayList7 = null;
                                c0084t09 = c0084t010;
                                c8 = 46703;
                            case 40301:
                                c0084t03 = c0084t09;
                                if (i8 < i10) {
                                    c6 = 52661;
                                } else {
                                    c6 = 13636;
                                }
                                c8 = c6;
                                c0084t09 = c0084t03;
                            case 60252:
                                c8 = 23039;
                                c0084t09 = c0084t06;
                            case 53850:
                                objArr = (String[][]) strArr4;
                                arrayList8 = new ArrayList(objArr.length);
                                i10 = objArr.length;
                                c8 = 40301;
                                i8 = 0;
                            case 13209:
                                c0084t03 = c0084t09;
                                arrayList8 = new ArrayList(AbstractC0709k.Y(set12, 10));
                                c6 = 59340;
                                set13 = set12;
                                c8 = c6;
                                c0084t09 = c0084t03;
                            case 52661:
                                String[] strArr5 = (String[]) objArr[i8];
                                kotlin.jvm.internal.j.b(strArr5);
                                arrayList8.add(AbstractC0705g.B(strArr5));
                                i8++;
                                c8 = 40301;
                            case 61628:
                                if (((G0.h) c0084t06.f664b) != null) {
                                    c8 = 60252;
                                } else {
                                    c8 = 53740;
                                }
                            case 15781:
                                if (it2.hasNext()) {
                                    c8 = 2317;
                                } else {
                                    c8 = 54115;
                                }
                            case 54115:
                                arrayList7 = arrayList8;
                                c8 = 46703;
                            case 2317:
                                arrayList8.add(AbstractC0707i.q0((Set) it2.next()));
                                c8 = 15781;
                            case 59340:
                                it2 = set13.iterator();
                                c8 = 15781;
                            case 23039:
                                set12 = ((G0.h) c0084t09.f664b).f814d;
                                if (set12 != null) {
                                    c8 = 13209;
                                } else {
                                    c8 = 20854;
                                }
                            default:
                                c8 = 20854;
                        }
                        set4 = set10;
                        z3 = z10;
                        list = list4;
                        i3 = i9;
                        iArr4 = iArr6;
                        c0084t05 = c0084t08;
                        set6 = set11;
                        c7 = 13907;
                    }
                case 28140:
                    iArr = iArr4;
                    c0084t0 = c0084t05;
                    set = set4;
                    if (z4) {
                        c5 = 22488;
                        set4 = set;
                        z3 = z10;
                        list = list4;
                        c0084t05 = c0084t0;
                        c7 = c5;
                        iArr4 = iArr;
                    }
                    c5 = 19933;
                    set4 = set;
                    z3 = z10;
                    list = list4;
                    c0084t05 = c0084t0;
                    c7 = c5;
                    iArr4 = iArr;
                case 13531:
                    iArr = iArr4;
                    Set set14 = set4;
                    if (c0084t07 != null) {
                        c5 = 20853;
                    } else {
                        c5 = 7527;
                    }
                    c0084t05 = c0084t07;
                    set4 = set14;
                    z3 = z10;
                    list = list4;
                    c7 = c5;
                    iArr4 = iArr;
                case 51831:
                case 27508:
                    z3 = z10;
                    list = list4;
                    c7 = 8637;
                    z5 = true;
                case 43290:
                    iArr = iArr4;
                    c0084t0 = c0084t05;
                    set = set4;
                    if (arrayList.isEmpty()) {
                        set4 = set;
                        z3 = z10;
                        list = list4;
                        iArr4 = iArr;
                        c0084t05 = c0084t0;
                        c7 = 23852;
                    } else {
                        c5 = 51718;
                        set4 = set;
                        z3 = z10;
                        list = list4;
                        c0084t05 = c0084t0;
                        c7 = c5;
                        iArr4 = iArr;
                    }
                case 30286:
                    iArr = iArr4;
                    c0084t0 = c0084t05;
                    set = set4;
                    if (i4 < i3) {
                        c5 = 25360;
                    } else {
                        c5 = 47744;
                    }
                    set4 = set;
                    z3 = z10;
                    list = list4;
                    c0084t05 = c0084t0;
                    c7 = c5;
                    iArr4 = iArr;
                case 4712:
                    iArr = iArr4;
                    c0084t0 = c0084t05;
                    set = set4;
                    if (!set6.contains((String) ((Iterator) obj).next())) {
                        c5 = 47714;
                        set4 = set;
                        z3 = z10;
                        list = list4;
                        c0084t05 = c0084t0;
                        c7 = c5;
                        iArr4 = iArr;
                    } else {
                        set4 = set;
                        z3 = z10;
                        list = list4;
                        c7 = 270;
                        iArr4 = iArr;
                        c0084t05 = c0084t0;
                    }
                case 15753:
                    i4++;
                    z3 = z10;
                    list = list4;
                    c7 = 30286;
                case 57010:
                    collection.add(str);
                    z3 = z10;
                    list = list4;
                    c7 = 15753;
                case 37163:
                case 20138:
                    z3 = z10;
                    list = list4;
                    c7 = 62937;
                    z6 = true;
                case 10576:
                    iArr = iArr4;
                    c0084t0 = c0084t05;
                    Set set15 = set4;
                    if (list4 != null) {
                        c5 = 931;
                        set4 = set15;
                        z3 = z10;
                        list = list4;
                        list3 = list;
                        c0084t05 = c0084t0;
                        c7 = c5;
                        iArr4 = iArr;
                    } else {
                        set4 = set15;
                        z3 = z10;
                        list = list4;
                        list3 = list;
                        c7 = 27741;
                        iArr4 = iArr;
                        c0084t05 = c0084t0;
                    }
                case 20853:
                    G0.h hVar = (G0.h) c0084t05.f664b;
                    char c9 = 53843;
                    int[] iArr7 = iArr4;
                    Set set16 = null;
                    ArrayList arrayList9 = null;
                    arrayList6 = null;
                    Iterator it3 = null;
                    while (true) {
                        switch (c9) {
                            case 18262:
                                c0084t04 = c0084t05;
                                arrayList9 = new ArrayList(AbstractC0709k.Y(set16, 10));
                                it3 = set16.iterator();
                                set4 = set4;
                                c9 = 52581;
                                c0084t05 = c0084t04;
                            case 33631:
                            case 12748:
                                arrayList6 = null;
                                c9 = 14591;
                            case 53843:
                                c0084t04 = c0084t05;
                                if (hVar != null) {
                                    c9 = 38718;
                                } else {
                                    c9 = 12748;
                                }
                                c0084t05 = c0084t04;
                            case 31892:
                                arrayList6 = arrayList9;
                                c9 = 14591;
                            case 38718:
                                c0084t04 = c0084t05;
                                set16 = hVar.f813c;
                                if (set16 != null) {
                                    c9 = 18262;
                                } else {
                                    c9 = 33631;
                                }
                                c0084t05 = c0084t04;
                            case 14591:
                                break;
                            case 52581:
                                c0084t04 = c0084t05;
                                if (it3.hasNext()) {
                                    c9 = 27591;
                                } else {
                                    c9 = 31892;
                                }
                                c0084t05 = c0084t04;
                            case 27591:
                                c0084t04 = c0084t05;
                                arrayList9.add(AbstractC0707i.q0((Set) it3.next()));
                                c9 = 52581;
                                c0084t05 = c0084t04;
                            default:
                                c9 = 14591;
                        }
                        z3 = z10;
                        list = list4;
                        iArr4 = iArr7;
                        c7 = 59908;
                    }
                case 11807:
                    return AbstractC0707i.u0(list4);
                case 931:
                    c7 = 22048;
                    list2 = list3;
                    z3 = z10;
                    list = list4;
                case 45720:
                    list = list4;
                    c7 = 45834;
                    z3 = false;
                case 48953:
                    it = arrayList2.iterator();
                    z3 = z10;
                    list = list4;
                    c7 = 19124;
                case 10997:
                    z3 = z10;
                    list = list4;
                    c7 = 59236;
                    z8 = true;
                case 44047:
                    if (set4.contains(str2)) {
                        z3 = z10;
                        list = list4;
                        c7 = 13454;
                    } else {
                        c7 = 35487;
                        z3 = z10;
                        list = list4;
                    }
                case 22048:
                    if (list2.isEmpty()) {
                        c7 = 51831;
                        z3 = z10;
                        list = list4;
                    } else {
                        z3 = z10;
                        list = list4;
                        c7 = 27741;
                    }
                case 8637:
                    if (z5) {
                        c7 = 64516;
                        z3 = z10;
                        list = list4;
                    } else {
                        i = i3;
                        set2 = set6;
                        iArr2 = iArr4;
                        c0084t02 = c0084t05;
                        set3 = set4;
                        c4 = 21772;
                        set4 = set3;
                        z3 = z10;
                        list = list4;
                        iArr4 = iArr2;
                        c0084t05 = c0084t02;
                        set6 = set2;
                        c7 = c4;
                        i3 = i;
                    }
                case 34182:
                case 63114:
                    z3 = z10;
                    list = list4;
                    c7 = 59236;
                    z8 = false;
                case 61710:
                case 32810:
                    c7 = 23585;
                    z3 = z10;
                    list = list4;
                case 27741:
                    obj = list3.iterator();
                    z3 = z10;
                    list = list4;
                    c7 = 13454;
                case 62937:
                    if (z6) {
                        c7 = 11807;
                        z3 = z10;
                        list = list4;
                    }
                    c7 = 54023;
                    z3 = z10;
                    list = list4;
                case 30365:
                    if (arrayList3 != null) {
                        c7 = 13484;
                    } else {
                        c7 = 60944;
                    }
                    arrayList4 = arrayList3;
                    set4 = set5;
                    z3 = z10;
                    list = list4;
                case 31233:
                    i6 = num.intValue();
                    c7 = 2034;
                    z3 = z10;
                    list = list4;
                case 25360:
                    str = strArr2[i4];
                    int i11 = i5 + 1;
                    kotlin.jvm.internal.j.e(iArr4, "<this>");
                    if (i5 >= 0 && i5 < iArr4.length) {
                        num = Integer.valueOf(iArr4[i5]);
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        c7 = 31233;
                    } else {
                        c7 = 63114;
                    }
                    i5 = i11;
                    z3 = z10;
                    list = list4;
                    break;
                case 37447:
                case 60944:
                    c7 = 44167;
                    z3 = z10;
                    list = list4;
                case 33059:
                    z3 = z10;
                    list = list4;
                    c7 = 59034;
                    z7 = false;
                case 63530:
                    if (arrayList.isEmpty()) {
                        z3 = z10;
                        list = list4;
                        c7 = 43932;
                    } else {
                        c7 = 37392;
                        z3 = z10;
                        list = list4;
                    }
                case 13454:
                    if (((Iterator) obj).hasNext()) {
                        c7 = 13734;
                    } else {
                        c7 = 27508;
                    }
                    z3 = z10;
                    list = list4;
                case 59034:
                    if (z7) {
                        c7 = 50837;
                        z3 = z10;
                        list = list4;
                    }
                    c7 = 54023;
                    z3 = z10;
                    list = list4;
                case 50434:
                    if (list3.isEmpty()) {
                        c7 = 37163;
                        z3 = z10;
                        list = list4;
                    } else {
                        z3 = z10;
                        list = list4;
                        c7 = 62393;
                    }
                case 36165:
                    list = list4;
                    c7 = 45834;
                    z3 = true;
                case 13484:
                    it = arrayList4.iterator();
                    z3 = z10;
                    list = list4;
                    c7 = 11895;
                case 19933:
                    String[] strArr6 = packageInfo.requestedPermissions;
                    if (strArr6 == null) {
                        c7 = 42992;
                    } else {
                        c7 = 46457;
                    }
                    strArr3 = strArr6;
                    z3 = z10;
                    list = list4;
                case 17821:
                    list = (List) it.next();
                    if (!list.isEmpty()) {
                        c7 = 36165;
                    } else {
                        c7 = 45720;
                    }
                    z3 = z10;
                case 50837:
                    if (list4 != null) {
                        c7 = 50434;
                        z3 = z10;
                        list = list4;
                        list3 = list;
                    } else {
                        z3 = z10;
                        list = list4;
                        list3 = list;
                        c7 = 62393;
                    }
                case 21772:
                    z3 = z10;
                    list = list4;
                    c7 = 11895;
                case 59236:
                    if (z8) {
                        c7 = 29460;
                        z3 = z10;
                        list = list4;
                    } else {
                        z3 = z10;
                        list = list4;
                        c7 = 15753;
                    }
                case 62834:
                    if (arrayList3 != null) {
                        c7 = 63530;
                        arrayList = arrayList3;
                        z3 = z10;
                        list = list4;
                    } else {
                        arrayList = arrayList3;
                        z3 = z10;
                        list = list4;
                        c7 = 43932;
                    }
                case 19124:
                    if (it.hasNext()) {
                        c7 = 58497;
                    } else {
                        c7 = 61710;
                    }
                    z3 = z10;
                    list = list4;
                case 44167:
                    if (arrayList5 != null) {
                        c7 = 48953;
                    } else {
                        c7 = 32810;
                    }
                    arrayList2 = arrayList5;
                    z3 = z10;
                    list = list4;
                case 270:
                    if (((Iterator) obj).hasNext()) {
                        c7 = 4712;
                        z3 = z10;
                        list = list4;
                    }
                    c7 = 20138;
                    z3 = z10;
                    list = list4;
                case 13907:
                    if (arrayList5 != null) {
                        c7 = 43290;
                        arrayList = arrayList5;
                        arrayList3 = arrayList7;
                        z3 = z10;
                        list = list4;
                    } else {
                        arrayList = arrayList5;
                        arrayList3 = arrayList7;
                        z3 = z10;
                        list = list4;
                        c7 = 23852;
                    }
                case 7527:
                    arrayList6 = null;
                    z3 = z10;
                    list = list4;
                    c7 = 59908;
                case 47744:
                    set5 = AbstractC0707i.u0((List) obj);
                    z3 = z10;
                    list = list4;
                    c7 = 30365;
                case 17812:
                    arrayList7 = null;
                    z3 = z10;
                    list = list4;
                    c7 = 13907;
                case 33543:
                    if (z9) {
                        c7 = 62834;
                        z3 = z10;
                        list = list4;
                    } else {
                        iArr = iArr4;
                        c0084t0 = c0084t05;
                        set = set4;
                        c5 = 19933;
                        set4 = set;
                        z3 = z10;
                        list = list4;
                        c0084t05 = c0084t0;
                        c7 = c5;
                        iArr4 = iArr;
                    }
                case 2034:
                    if ((i6 & 2) != 0) {
                        c7 = 10997;
                    } else {
                        c7 = 34182;
                    }
                    z3 = z10;
                    list = list4;
                default:
                    c7 = 20138;
                    z3 = z10;
                    list = list4;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean L(PackageInfo packageInfo) {
        Set set = null;
        Object obj = null;
        String str = null;
        boolean z3 = false;
        char c4 = 49399;
        Iterator it = null;
        while (true) {
            switch (c4) {
                case 45933:
                    it = set.iterator();
                    c4 = 64521;
                case 64521:
                    if (it.hasNext()) {
                        c4 = 41525;
                    } else {
                        c4 = 4933;
                    }
                case 52719:
                    if (set.isEmpty()) {
                        c4 = 3740;
                    } else {
                        c4 = 45933;
                    }
                case 21003:
                    str = (String) obj;
                    set = f183j;
                    if (set != null) {
                        c4 = 52719;
                    } else {
                        c4 = 45933;
                    }
                case 6250:
                    return false;
                case 28531:
                    return z3;
                case 4933:
                    boolean z4 = this.f185h;
                    z3 = ((((~(z4 ? 1 : 0)) | (-1217824953)) & (-901641464)) + (((z4 ? 1 : 0) & 1225132104) | 84164674)) ^ (-817476790);
                    c4 = 28531;
                case 38631:
                    obj = ((ApplicationInfo) obj).sourceDir;
                    if (obj == null) {
                        c4 = 6250;
                    } else {
                        c4 = 21003;
                    }
                case 3740:
                    z3 = false;
                    c4 = 28531;
                case 54849:
                    z3 = true;
                    c4 = 28531;
                case 41525:
                    if (N2.n.M(str, (String) it.next())) {
                        c4 = 54849;
                    } else {
                        c4 = 64521;
                    }
                case 49399:
                    obj = packageInfo.applicationInfo;
                    if (obj != null) {
                        c4 = 38631;
                    } else {
                        c4 = 6250;
                    }
                default:
                    c4 = 6250;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x030b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:62:0x09aa. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    public final boolean M(PackageInfo packageInfo) {
        ?? r5;
        char c4;
        byte b4;
        char c5;
        char c6;
        Object obj;
        Object obj2;
        char c7 = 26976;
        ?? r3 = 0;
        while (true) {
            ApplicationInfo applicationInfo = null;
            PackageInfo packageInfo2 = null;
            byte b5 = -1;
            boolean z3 = this.f185h;
            long j2 = 43690;
            char c8 = '0';
            byte b6 = 24;
            char c9 = ' ';
            char c10 = '\b';
            switch (c7) {
                case 18964:
                    break;
                case 3076:
                    c7 = 18964;
                    r3 = 1;
                case 26976:
                    boolean z4 = 1490247420;
                    while (true) {
                        boolean z5 = false;
                        while (true) {
                            switch (z4) {
                                case true:
                                    z4 = 1923942099;
                                    z5 = true;
                                case true:
                                    break;
                                case true:
                                    long j3 = 129;
                                    long j4 = applicationInfo.flags;
                                    long j5 = (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                                    long j6 = (j5 >>> 48) & 43690;
                                    long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
                                    long j8 = (j7 | (j7 >>> 2)) & 252645135;
                                    long j9 = (j5 >>> 32) & 43690;
                                    long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                                    long j11 = (j10 | (j10 >>> 2)) & 252645135;
                                    long j12 = (((j11 | (j11 >>> 4)) & 16711935) << 16) + (((j8 | (j8 >>> 4)) & 16711935) << 24);
                                    long j13 = (j5 >>> 16) & 43690;
                                    long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                                    long j15 = (j14 | (j14 >>> 2)) & 252645135;
                                    long j16 = j5 & 43690;
                                    long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                                    long j18 = (j17 | (j17 >>> 2)) & 252645135;
                                    if (((int) (((j18 | (j18 >>> 4)) & 16711935) | ((((j15 | (j15 >>> 4)) & 16711935) << 8) + j12))) != 0) {
                                        r5 = 32127827;
                                        z4 = r5;
                                    }
                                    r5 = 534687581;
                                    z4 = r5;
                                case true:
                                    applicationInfo = packageInfo.applicationInfo;
                                    if (applicationInfo != null) {
                                        r5 = 1012930648;
                                        z4 = r5;
                                    }
                                    r5 = 534687581;
                                    z4 = r5;
                                case true:
                                    break;
                                default:
                                    z4 = 1490247420;
                            }
                            if (!z5) {
                                c7 = 33408;
                            }
                        }
                        z4 = 1923942099;
                    }
                    break;
                case 33408:
                    char c11 = 52781;
                    Object obj3 = null;
                    String str = null;
                    boolean z6 = false;
                    while (true) {
                        long j19 = j2;
                        switch (c11) {
                            case 36350:
                                c4 = c8;
                                b4 = b6;
                                c5 = c9;
                                c6 = c10;
                                Object obj4 = packageInfo2.applicationInfo;
                                obj = obj4;
                                if (obj4 != null) {
                                    c11 = 10354;
                                    obj2 = obj4;
                                    j2 = j19;
                                    c8 = c4;
                                    b6 = b4;
                                    c9 = c5;
                                    c10 = c6;
                                    obj3 = obj2;
                                    b5 = -1;
                                }
                                c11 = 44103;
                                obj2 = obj;
                                j2 = j19;
                                c8 = c4;
                                b6 = b4;
                                c9 = c5;
                                c10 = c6;
                                obj3 = obj2;
                                b5 = -1;
                            case 9166:
                                c4 = c8;
                                b4 = b6;
                                c5 = c9;
                                c6 = c10;
                                str = (String) obj3;
                                int i = ~(z3 ? 1 : 0);
                                long j20 = -585119419;
                                long j21 = ((1572953945 | i) & 1426393160) + (~((((-2146139904) & (z3 ? 1 : 0)) | (2011512575 | (z3 ? 1 : 0))) - ((-2011250432) & (z3 ? 1 : 0))));
                                long j22 = (((((((((j20 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) | ((((((((j20 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j21 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + (((((((((j21 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                                long j23 = (j22 >>> c4) & 21845;
                                long j24 = ((j23 >>> 1) | j23) & 858993459;
                                long j25 = ((j24 >>> 2) | j24) & 252645135;
                                long j26 = (j22 >>> c5) & 21845;
                                long j27 = ((j26 >>> 1) | j26) & 858993459;
                                long j28 = ((j27 >>> 2) | j27) & 252645135;
                                long j29 = ((((j28 >>> 4) | j28) & 16711935) << 16) + ((((j25 >>> 4) | j25) & 16711935) << b4);
                                long j30 = (j22 >>> 16) & 21845;
                                long j31 = ((j30 >>> 1) | j30) & 858993459;
                                long j32 = ((j31 >>> 2) | j31) & 252645135;
                                long j33 = j22 & 21845;
                                long j34 = ((j33 >>> 1) | j33) & 858993459;
                                long j35 = ((j34 >>> 2) | j34) & 252645135;
                                byte b7 = (int) ((((j35 >>> 4) | j35) & 16711935) | ((((j32 >>> 4) | j32) & 16711935) << c6) | j29);
                                byte[] bArr = new byte[12];
                                bArr[0] = b4;
                                bArr[1] = 81;
                                bArr[2] = 22;
                                bArr[3] = -87;
                                bArr[4] = -10;
                                bArr[5] = -76;
                                bArr[6] = -55;
                                bArr[7] = 100;
                                bArr[c6] = -95;
                                bArr[9] = -109;
                                bArr[10] = b7;
                                bArr[11] = -8;
                                byte[] bArr2 = new byte[12];
                                bArr2[0] = 55;
                                bArr2[1] = 34;
                                bArr2[2] = 111;
                                bArr2[3] = -38;
                                int i3 = 538579504 & ((i ^ 771218037) + (i & 771218037));
                                int i4 = (84411392 & (z3 ? 1 : 0)) | 92538240;
                                bArr2[4] = (-631117774) ^ (((i4 | i3) * 2) - (i3 ^ i4));
                                bArr2[5] = -47;
                                bArr2[6] = -92;
                                bArr2[7] = 75;
                                bArr2[c6] = -64;
                                long j36 = -1;
                                long j37 = z3 ? 1L : 0L;
                                long j38 = (((((j37 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                                long j39 = (((((((j37 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                                long j40 = (((((((j37 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5;
                                long j41 = (((((((j37 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4;
                                long j42 = (((((((((j36 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + ((((((((j36 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j41 + (j40 | j39 | j38);
                                long j43 = (j42 >>> c4) & 21845;
                                long j44 = ((j43 >>> 1) | j43) & 858993459;
                                long j45 = ((j44 >>> 2) | j44) & 252645135;
                                long j46 = (j42 >>> c5) & 21845;
                                long j47 = ((j46 >>> 1) | j46) & 858993459;
                                long j48 = ((j47 >>> 2) | j47) & 252645135;
                                long j49 = ((((j48 >>> 4) | j48) & 16711935) << 16) | ((((j45 >>> 4) | j45) & 16711935) << b4);
                                long j50 = (j42 >>> 16) & 21845;
                                long j51 = ((j50 >>> 1) | j50) & 858993459;
                                long j52 = ((j51 >>> 2) | j51) & 252645135;
                                long j53 = j42 & 21845;
                                long j54 = ((j53 >>> 1) | j53) & 858993459;
                                long j55 = ((j54 >>> 2) | j54) & 252645135;
                                long j56 = 2293763;
                                long j57 = (((((((((j56 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | (((((((((j56 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + ((((((((j56 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j56 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j41 | j40 | (j39 + j38));
                                long j58 = (j57 >>> c4) & j19;
                                long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                                long j60 = ((j59 >>> 2) | j59) & 252645135;
                                long j61 = (j57 >>> c5) & j19;
                                long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
                                long j63 = ((j62 >>> 2) | j62) & 252645135;
                                long j64 = ((((j63 >>> 4) | j63) & 16711935) << 16) + ((((j60 >>> 4) | j60) & 16711935) << b4);
                                long j65 = (j57 >>> 16) & j19;
                                long j66 = ((j65 >>> 2) | (j65 >>> 1)) & 858993459;
                                long j67 = ((j66 >>> 2) | j66) & 252645135;
                                long j68 = j57 & j19;
                                long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
                                long j70 = ((j69 >>> 2) | j69) & 252645135;
                                int i5 = ((int) ((((j70 >>> 4) | j70) & 16711935) | (((((j67 >>> 4) | j67) & 16711935) << c6) + j64))) | 84019201;
                                int i6 = -((((int) ((((j55 >>> 4) | j55) & 16711935) | ((((j52 >>> 4) | j52) & 16711935) << c6) | j49)) | 1310074725) & 1076953634);
                                int i7 = i6 | i5;
                                bArr2[1160972842 ^ ((i7 - (i6 * 2)) + ((i5 ^ i6) ^ i7))] = -29;
                                bArr2[10] = 125;
                                bArr2[11] = -41;
                                B(bArr, bArr2);
                                if (!N2.n.M(str, new String(bArr, StandardCharsets.UTF_8).intern())) {
                                    c11 = 64276;
                                    obj2 = obj3;
                                    j2 = j19;
                                    c8 = c4;
                                    b6 = b4;
                                    c9 = c5;
                                    c10 = c6;
                                    obj3 = obj2;
                                    b5 = -1;
                                }
                                c11 = 50630;
                                obj2 = obj3;
                                j2 = j19;
                                c8 = c4;
                                b6 = b4;
                                c9 = c5;
                                c10 = c6;
                                obj3 = obj2;
                                b5 = -1;
                            case 52781:
                                c11 = 36350;
                                packageInfo2 = packageInfo;
                                j2 = j19;
                                obj3 = obj3;
                                b5 = -1;
                            case 64276:
                                c4 = c8;
                                byte[] bArr3 = {-34, 72, 36, 30, -117, -68, -102, -9, 65, 10, -37, 93, -67, -59, 89, -28, 56};
                                byte[] bArr4 = new byte[17];
                                bArr4[0] = -15;
                                bArr4[1] = 59;
                                bArr4[2] = 93;
                                bArr4[3] = 109;
                                b4 = b6;
                                int i8 = ~(z3 ? 1 : 0);
                                bArr4[(((i8 | 10445775) & 1345643585) + (((z3 ? 1 : 0) & 1349158144) | 13238536)) ^ 1358882125] = b5;
                                bArr4[5] = -39;
                                c5 = c9;
                                int i9 = (((z3 ? 1 : 0) | 1747565008) - (i8 | 1765538269)) + ((i8 | 154814669) - (z3 ? 1 : 0)) + ((z3 ? 1 : 0) & 1747565008);
                                c6 = c10;
                                long j71 = 1883369753;
                                long j72 = z3 ? 1L : 0L;
                                long j73 = (((((((((j71 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) | ((((((((j71 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) | ((((((((j71 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j71 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j72 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + (((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) | ((((((((j72 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                                long j74 = (j73 >>> c4) & j19;
                                long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                                long j76 = ((j75 >>> 2) | j75) & 252645135;
                                long j77 = (j73 >>> c5) & j19;
                                long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                                long j79 = ((j78 >>> 2) | j78) & 252645135;
                                long j80 = ((((j79 >>> 4) | j79) & 16711935) << 16) | ((((j76 >>> 4) | j76) & 16711935) << b4);
                                long j81 = (j73 >>> 16) & j19;
                                long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
                                long j83 = ((j82 >>> 2) | j82) & 252645135;
                                long j84 = j73 & j19;
                                long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
                                long j86 = ((j85 >>> 2) | j85) & 252645135;
                                int i10 = ((int) ((((j86 >>> 4) | j86) & 16711935) | ((((j83 >>> 4) | j83) & 16711935) << c6) | j80)) | (-1874575351);
                                int i11 = -i9;
                                int i12 = i11 | i10;
                                bArr4[(-127010337) ^ ((i12 - (i11 * 2)) + ((i10 ^ i11) ^ i12))] = -9;
                                bArr4[7] = -40;
                                bArr4[c6] = 49;
                                bArr4[9] = 120;
                                bArr4[10] = -78;
                                bArr4[11] = 43;
                                bArr4[12] = -112;
                                bArr4[13] = -92;
                                bArr4[14] = 41;
                                bArr4[15] = -108;
                                int i13 = (166224733 | i8) & (-1876898683);
                                long j87 = 134488320;
                                long j88 = (-1878741632) & (z3 ? 1 : 0);
                                long b8 = c3.b((((((((j87 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4, ((((((((j87 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + ((((((((j87 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j87 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j88 >>> b4) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c4) + ((((((((j88 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + (((((((((j88 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j88 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                                long j89 = (b8 >>> c4) & j19;
                                long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                                long j91 = ((j90 >>> 2) | j90) & 252645135;
                                long j92 = (b8 >>> c5) & j19;
                                long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                                long j94 = ((j93 >>> 2) | j93) & 252645135;
                                long j95 = ((((j94 >>> 4) | j94) & 16711935) << 16) + ((((j91 >>> 4) | j91) & 16711935) << b4);
                                long j96 = (b8 >>> 16) & j19;
                                long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
                                long j98 = ((j97 >>> 2) | j97) & 252645135;
                                long j99 = b8 & j19;
                                long j100 = ((j99 >>> 2) | (j99 >>> 1)) & 858993459;
                                long j101 = ((j100 >>> 2) | j100) & 252645135;
                                bArr4[(i13 + ((int) ((((j101 >>> 4) | j101) & 16711935) | (((((j98 >>> 4) | j98) & 16711935) << c6) | j95)))) ^ (-1742410347)] = 23;
                                B(bArr3, bArr4);
                                if (!N2.n.M(str, new String(bArr3, StandardCharsets.UTF_8).intern())) {
                                    c11 = 4163;
                                    obj2 = obj3;
                                    j2 = j19;
                                    c8 = c4;
                                    b6 = b4;
                                    c9 = c5;
                                    c10 = c6;
                                    obj3 = obj2;
                                    b5 = -1;
                                }
                                c11 = 50630;
                                obj2 = obj3;
                                j2 = j19;
                                c8 = c4;
                                b6 = b4;
                                c9 = c5;
                                c10 = c6;
                                obj3 = obj2;
                                b5 = -1;
                            case 50630:
                                z6 = true;
                                j2 = j19;
                                c11 = 60592;
                            case 44103:
                                z6 = false;
                                break;
                            case 4163:
                                z6 = false;
                                j2 = j19;
                                c11 = 60592;
                            case 60592:
                                break;
                            case 10354:
                                obj3 = ((ApplicationInfo) obj3).sourceDir;
                                if (obj3 == null) {
                                    c4 = c8;
                                    b4 = b6;
                                    c5 = c9;
                                    c6 = c10;
                                    obj = obj3;
                                    c11 = 44103;
                                    obj2 = obj;
                                    j2 = j19;
                                    c8 = c4;
                                    b6 = b4;
                                    c9 = c5;
                                    c10 = c6;
                                    obj3 = obj2;
                                    b5 = -1;
                                } else {
                                    c11 = 9166;
                                    j2 = j19;
                                }
                            default:
                                c4 = c8;
                                b4 = b6;
                                c5 = c9;
                                c6 = c10;
                                c11 = 50630;
                                obj2 = obj3;
                                j2 = j19;
                                c8 = c4;
                                b6 = b4;
                                c9 = c5;
                                c10 = c6;
                                obj3 = obj2;
                                b5 = -1;
                        }
                    }
                    c7 = z6 ? (char) 3076 : (char) 32299;
                case 32299:
                    long j102 = -1;
                    long j103 = z3 ? 1L : 0L;
                    long j104 = (((((((((j102 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j102 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j102 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j102 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j103 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j103 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j103 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j103 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j105 = (j104 >>> 48) & 21845;
                    long j106 = ((j105 >>> 1) | j105) & 858993459;
                    long j107 = ((j106 >>> 2) | j106) & 252645135;
                    long j108 = (j104 >>> 32) & 21845;
                    long j109 = ((j108 >>> 1) | j108) & 858993459;
                    long j110 = ((j109 >>> 2) | j109) & 252645135;
                    long j111 = ((((j110 >>> 4) | j110) & 16711935) << 16) | ((((j107 >>> 4) | j107) & 16711935) << 24);
                    long j112 = (j104 >>> 16) & 21845;
                    long j113 = ((j112 >>> 1) | j112) & 858993459;
                    long j114 = ((j113 >>> 2) | j113) & 252645135;
                    long j115 = j104 & 21845;
                    long j116 = (j115 | (j115 >>> 1)) & 858993459;
                    long j117 = (j116 | (j116 >>> 2)) & 252645135;
                    long j118 = 1350350183;
                    long j119 = (int) (((j117 | (j117 >>> 4)) & 16711935) + ((((j114 >>> 4) | j114) & 16711935) << 8) + j111);
                    long j120 = (((((((((j118 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j118 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j118 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j118 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j119 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j119 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j119 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j119 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                    long j121 = (j120 >>> 48) & 43690;
                    long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                    long j123 = (j122 | (j122 >>> 2)) & 252645135;
                    long j124 = (j120 >>> 32) & 43690;
                    long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
                    long j126 = ((j125 >>> 2) | j125) & 252645135;
                    long j127 = ((((j126 >>> 4) | j126) & 16711935) << 16) + (((j123 | (j123 >>> 4)) & 16711935) << 24);
                    long j128 = (j120 >>> 16) & 43690;
                    long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
                    long j130 = ((j129 >>> 2) | j129) & 252645135;
                    long j131 = j120 & 43690;
                    long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
                    long j133 = (j132 | (j132 >>> 2)) & 252645135;
                    long j134 = -2100617020;
                    long j135 = (((int) ((((((j130 >>> 4) | j130) & 16711935) << 8) + j127) | ((j133 | (j133 >>> 4)) & 16711935))) & (-2109005824)) + (((-2105343808) & (z3 ? 1 : 0)) | 8388804);
                    long j136 = (((((((((j134 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j134 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j134 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j134 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j135 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j135 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j135 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j135 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                    long j137 = (j136 >>> 48) & 21845;
                    long j138 = (j137 | (j137 >>> 1)) & 858993459;
                    long j139 = (j138 | (j138 >>> 2)) & 252645135;
                    long j140 = (j136 >>> 32) & 21845;
                    long j141 = (j140 | (j140 >>> 1)) & 858993459;
                    long j142 = (j141 | (j141 >>> 2)) & 252645135;
                    long j143 = (((j139 | (j139 >>> 4)) & 16711935) << 24) | (((j142 | (j142 >>> 4)) & 16711935) << 16);
                    long j144 = (j136 >>> 16) & 21845;
                    long j145 = (j144 | (j144 >>> 1)) & 858993459;
                    long j146 = (j145 | (j145 >>> 2)) & 252645135;
                    long j147 = j136 & 21845;
                    long j148 = (j147 | (j147 >>> 1)) & 858993459;
                    long j149 = (j148 | (j148 >>> 2)) & 252645135;
                    r3 = (int) (((j149 | (j149 >>> 4)) & 16711935) + (j143 | (((j146 | (j146 >>> 4)) & 16711935) << 8)));
                    c7 = 18964;
                default:
                    c7 = 26976;
            }
            return r3;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x01b5. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00c0. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // F0.T2
    public final void a(Context context) {
        C0031f2 c0031f2;
        PackageManager packageManager;
        int i;
        D0 d02 = this;
        Context context2 = context;
        byte[] bArr = new byte[7];
        int i3 = 0;
        bArr[0] = -88;
        boolean z3 = d02.f185h;
        int i4 = ~(z3 ? 1 : 0);
        int i5 = (1401430552 & (z3 ? 1 : 0)) | 34181380;
        int i6 = -(((-1906387742) | i4) & (-711564744));
        int i7 = 2;
        byte b4 = (-677383344) ^ ((((~i6) & i5) * 2) - (i6 ^ i5));
        int i8 = 1;
        bArr[1] = b4;
        bArr[2] = -18;
        bArr[3] = 51;
        char c4 = 4;
        byte b5 = 94;
        bArr[4] = 94;
        bArr[(((i4 | (-1025)) + 1174440962) + ((538182788 & (z3 ? 1 : 0)) | 538181772)) ^ 1712622728] = -54;
        int i9 = 6;
        bArr[6] = -55;
        char c5 = '\b';
        byte[] bArr2 = new byte[8];
        bArr2[0] = -76;
        bArr2[1] = 51;
        bArr2[2] = 106;
        bArr2[3] = 96;
        byte b6 = 59;
        bArr2[4] = 59;
        bArr2[5] = -78;
        bArr2[6] = -67;
        bArr2[(((i4 | 1454164983) & 335575153) + (((z3 ? 1 : 0) & 17314688) | 51184516)) ^ 386759666] = -118;
        y(bArr, bArr2);
        kotlin.jvm.internal.j.e(context2, new String(bArr, StandardCharsets.UTF_8).intern());
        C0031f2 c0031f22 = null;
        ArrayList arrayList = null;
        char c6 = 63914;
        final PackageManager packageManager2 = null;
        Iterator it = null;
        while (true) {
            int i10 = i8;
            switch (c6) {
                case 53195:
                    d02.A(c0031f22, arrayList);
                    return;
                case 35774:
                    final D0 d03 = d02;
                    final Context context3 = context2;
                    boolean z4 = z3 ? 1 : 0;
                    final ArrayList arrayList2 = new ArrayList();
                    C0031f2 n4 = T0.n(new F2.a() { // from class: F0.z0
                        @Override // F2.a
                        public final Object invoke() {
                            return D0.D(D0.this, packageManager2, arrayList2, context3);
                        }
                    });
                    ArrayList arrayList3 = new ArrayList(arrayList2.size());
                    it = arrayList2.iterator();
                    z3 = z4;
                    context2 = context3;
                    c0031f22 = n4;
                    arrayList = arrayList3;
                    d02 = d03;
                    c6 = 15160;
                    i8 = i10;
                    i3 = i3;
                case 32973:
                    C0031f2 c0031f23 = c0031f22;
                    PackageManager packageManager3 = packageManager2;
                    byte b7 = b6;
                    char c7 = c4;
                    byte[] bArr3 = new byte[i9];
                    long j2 = -1;
                    long j3 = z3 ? 1L : 0L;
                    long j4 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j5 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j4;
                    long j6 = (j5 >>> 48) & 21845;
                    long j7 = ((j6 >>> i10) | j6) & 858993459;
                    long j8 = ((j7 >>> 2) | j7) & 252645135;
                    long j9 = (j5 >>> 32) & 21845;
                    long j10 = ((j9 >>> i10) | j9) & 858993459;
                    long j11 = ((j10 >>> 2) | j10) & 252645135;
                    long j12 = ((((j11 >>> c7) | j11) & 16711935) << 16) | ((((j8 >>> c7) | j8) & 16711935) << 24);
                    long j13 = (j5 >>> 16) & 21845;
                    long j14 = ((j13 >>> i10) | j13) & 858993459;
                    long j15 = ((j14 >>> 2) | j14) & 252645135;
                    long j16 = j5 & 21845;
                    long j17 = ((j16 >>> i10) | j16) & 858993459;
                    long j18 = ((j17 >>> 2) | j17) & 252645135;
                    int i11 = (((int) ((((j18 >>> c7) | j18) & 16711935) + ((((j15 >>> c7) | j15) & 16711935) << 8) + j12)) | 489612126) & 60901824;
                    int i12 = ((-1031600000) & (z3 ? 1 : 0)) | (-938860544);
                    bArr3[0] = AbstractC0099x.a(i11 | i12, 2, (~i11) ^ i12) ^ (-877958758);
                    long j19 = -106938562;
                    boolean z5 = z3 ? 1 : 0;
                    long j20 = i4;
                    long j21 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j20 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
                    long j22 = (j21 >>> 48) & 43690;
                    long j23 = ((j22 >>> 2) | (j22 >>> i10)) & 858993459;
                    long j24 = ((j23 >>> 2) | j23) & 252645135;
                    long j25 = (j21 >>> 32) & 43690;
                    long j26 = ((j25 >>> 2) | (j25 >>> i10)) & 858993459;
                    long j27 = ((j26 >>> 2) | j26) & 252645135;
                    long j28 = ((((j27 >>> c7) | j27) & 16711935) << 16) | ((((j24 >>> c7) | j24) & 16711935) << 24);
                    long j29 = (j21 >>> 16) & 43690;
                    long j30 = ((j29 >>> 2) | (j29 >>> i10)) & 858993459;
                    long j31 = ((j30 >>> 2) | j30) & 252645135;
                    long j32 = ((((j31 >>> c7) | j31) & 16711935) << 8) + j28;
                    long j33 = j21 & 43690;
                    long j34 = ((j33 >>> 2) | (j33 >>> i10)) & 858993459;
                    long j35 = (j34 | (j34 >>> 2)) & 252645135;
                    long j36 = 541736960;
                    long j37 = (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j4;
                    long j38 = (j37 >>> 48) & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> i10)) & 858993459;
                    long j40 = (j39 | (j39 >>> 2)) & 252645135;
                    long j41 = (j37 >>> 32) & 43690;
                    long j42 = ((j41 >>> 2) | (j41 >>> i10)) & 858993459;
                    long j43 = (j42 | (j42 >>> 2)) & 252645135;
                    long j44 = (((j43 | (j43 >>> c7)) & 16711935) << 16) + (((j40 | (j40 >>> c7)) & 16711935) << 24);
                    long j45 = (j37 >>> 16) & 43690;
                    long j46 = ((j45 >>> 2) | (j45 >>> i10)) & 858993459;
                    long j47 = (j46 | (j46 >>> 2)) & 252645135;
                    long j48 = j37 & 43690;
                    long j49 = ((j48 >>> 2) | (j48 >>> i10)) & 858993459;
                    long j50 = (j49 | (j49 >>> 2)) & 252645135;
                    bArr3[(((((int) (((j35 | (j35 >>> c7)) & 16711935) | j32)) | (-273301545)) + 273301545) + (((int) ((j44 | (((j47 | (j47 >>> c7)) & 16711935) << 8)) | ((j50 | (j50 >>> c7)) & 16711935))) | 553680896)) ^ 826982441] = 21;
                    bArr3[2] = -83;
                    bArr3[3] = -21;
                    bArr3[c7] = -79;
                    bArr3[5] = -31;
                    int i13 = (((-44185339) | i4) & (-1467993189)) + ((9712282 & z5) | 70533120);
                    byte b8 = (((~i13) & (-1397460009)) - ((-1397460009) & i13)) + i13;
                    byte[] bArr4 = new byte[8];
                    bArr4[0] = b7;
                    bArr4[i10] = 101;
                    bArr4[2] = -35;
                    bArr4[3] = -124;
                    bArr4[c7] = -63;
                    bArr4[5] = -110;
                    bArr4[6] = 16;
                    bArr4[7] = b8;
                    x(bArr3, bArr4);
                    this.i = (AppOpsManager) context.getSystemService(new String(bArr3, StandardCharsets.UTF_8).intern());
                    z3 = z5;
                    context2 = context;
                    d02 = this;
                    c5 = '\b';
                    i8 = i10;
                    c6 = 39834;
                    b6 = b7;
                    c4 = c7;
                    b5 = b5;
                    i3 = 0;
                    i7 = 2;
                    i9 = 6;
                    c0031f22 = c0031f23;
                    packageManager2 = packageManager3;
                case 15160:
                    C0031f2 c0031f24 = c0031f22;
                    PackageManager packageManager4 = packageManager2;
                    byte b9 = b6;
                    char c8 = c4;
                    byte b10 = b5;
                    int i14 = i9;
                    if (it.hasNext()) {
                        c6 = 10772;
                    } else {
                        c6 = 53195;
                    }
                    d02 = this;
                    context2 = context;
                    i8 = i10;
                    b6 = b9;
                    c4 = c8;
                    b5 = b10;
                    i9 = i14;
                    c0031f22 = c0031f24;
                    packageManager2 = packageManager4;
                    i3 = 0;
                    i7 = 2;
                    c5 = '\b';
                case 20029:
                    return;
                case 39834:
                    C0031f2 c0031f25 = c0031f22;
                    byte b11 = b6;
                    char c9 = c4;
                    byte b12 = b5;
                    int i15 = i9;
                    packageManager2 = context.getPackageManager();
                    if (packageManager2 == null) {
                        c6 = 20029;
                    } else {
                        c6 = 35774;
                    }
                    d02 = this;
                    context2 = context;
                    i8 = i10;
                    b6 = b11;
                    c4 = c9;
                    b5 = b12;
                    i9 = i15;
                    c0031f22 = c0031f25;
                    i3 = 0;
                    i7 = 2;
                    c5 = '\b';
                case 10772:
                    C0085t1 c0085t1 = (C0085t1) it.next();
                    byte b13 = b6;
                    char c10 = c4;
                    PackageInfo packageInfo = c0085t1.f665a;
                    byte b14 = b5;
                    Set set = c0085t1.f666b;
                    int i16 = i3;
                    char c11 = 54586;
                    char c12 = 54586;
                    int i17 = i7;
                    ArrayList arrayList4 = null;
                    Iterator it2 = null;
                    while (true) {
                        if (c12 != 16201) {
                            if (c12 != 52680) {
                                if (c12 != 41747) {
                                    if (c12 != c11) {
                                        c12 = 52680;
                                    } else {
                                        byte[] bArr5 = new byte[i9];
                                        bArr5[i16] = 101;
                                        bArr5[i10] = -124;
                                        bArr5[i17] = b14;
                                        bArr5[3] = -66;
                                        bArr5[c10] = -127;
                                        bArr5[5] = 61;
                                        byte[] bArr6 = new byte[8];
                                        int i18 = i9;
                                        bArr6[709967342 ^ ((((~B0.class.getName().length()) | (-1561272052)) & 541136238) + ((B0.class.getName().length() & 1119330) | 168831104))] = 89;
                                        bArr6[i10] = -16;
                                        bArr6[i17] = 54;
                                        bArr6[3] = -41;
                                        bArr6[c10] = -14;
                                        bArr6[5] = 3;
                                        bArr6[i18] = 86;
                                        bArr6[7] = -103;
                                        int i19 = -1850458006;
                                        int i20 = i16;
                                        int i21 = i20;
                                        byte[] bArr7 = null;
                                        byte[] bArr8 = null;
                                        while (true) {
                                            int i22 = ((i19 & 16777216) * (i19 | 16777216)) + ((i19 & (-16777217)) * ((~i19) & 16777216));
                                            int i23 = i19 >>> 8;
                                            int i24 = (i23 - 1) - ((~i22) | i23);
                                            int i25 = (-1700147435) - ((i24 & 2) | (2028104049 - i24));
                                            int i26 = -1396193641;
                                            switch ((-1363443157) ^ ((~i25) + ((i25 | 1) * 2))) {
                                                case -1940167324:
                                                    byte b15 = bArr8[i21];
                                                    int i27 = ((byte) i16) - b15;
                                                    bArr8[i21] = (byte) (((byte) (b15 & (~i27))) - ((byte) ((~b15) & i27)));
                                                    i19 = 614229416;
                                                    c0031f22 = c0031f22;
                                                    i16 = 0;
                                                    i17 = 2;
                                                case -360299937:
                                                    c0031f2 = c0031f22;
                                                    packageManager = packageManager2;
                                                    if ((bArr8[i20] > Double.NaN ? 1 : (bArr8[i20] == Double.NaN ? 0 : -1)) <= -1) {
                                                        i = i16;
                                                    } else {
                                                        i = i10;
                                                    }
                                                    if (i == 0) {
                                                        i26 = 427928065;
                                                    }
                                                    if (i != 0) {
                                                        i19 = 614229416;
                                                    } else {
                                                        i19 = i26;
                                                    }
                                                    i21 = i20;
                                                    c0031f22 = c0031f2;
                                                    packageManager2 = packageManager;
                                                    i17 = 2;
                                                case 399486784:
                                                    break;
                                                case 585276366:
                                                    bArr7 = bArr5;
                                                    i20 = i16;
                                                    bArr8 = bArr6;
                                                    i19 = 1985663266;
                                                    i17 = 2;
                                                case 1733787683:
                                                    byte b16 = bArr7[i21];
                                                    byte b17 = bArr8[i21];
                                                    c0031f2 = c0031f22;
                                                    packageManager = packageManager2;
                                                    bArr7[i21] = (byte) (((byte) (b17 + b16)) - ((byte) (((byte) i17) * ((byte) (b17 & b16)))));
                                                    int i28 = ((i21 & 1) * 2) + (i21 ^ 1);
                                                    if ((((i28 > bArr7.length ? 1 : (i28 == bArr7.length ? 0 : -1)) >>> 31) & 1) != 0) {
                                                        i20 = i28;
                                                        c0031f22 = c0031f2;
                                                        packageManager2 = packageManager;
                                                        i19 = 1985663266;
                                                        i17 = 2;
                                                    } else {
                                                        i20 = i28;
                                                        i19 = -1396193641;
                                                        c0031f22 = c0031f2;
                                                        packageManager2 = packageManager;
                                                        i17 = 2;
                                                    }
                                                default:
                                                    i19 = -1396193641;
                                            }
                                            kotlin.jvm.internal.j.e(set, new String(bArr5, StandardCharsets.UTF_8).intern());
                                            ArrayList arrayList5 = new ArrayList(AbstractC0709k.Y(set, 10));
                                            it2 = set.iterator();
                                            arrayList4 = arrayList5;
                                            i9 = i18;
                                            c11 = 54586;
                                            c12 = 52680;
                                            i17 = 2;
                                        }
                                    }
                                } else {
                                    arrayList.add(new G0.j(packageInfo, AbstractC0707i.u0(arrayList4), c0085t1.f667c));
                                    d02 = this;
                                    context2 = context;
                                    c6 = 15160;
                                    i8 = i10;
                                    b6 = b13;
                                    c4 = c10;
                                    b5 = b14;
                                    i3 = 0;
                                    i7 = 2;
                                    c5 = '\b';
                                }
                            } else {
                                C0031f2 c0031f26 = c0031f22;
                                PackageManager packageManager5 = packageManager2;
                                int i29 = i9;
                                if (it2.hasNext()) {
                                    i9 = i29;
                                    c0031f22 = c0031f26;
                                    packageManager2 = packageManager5;
                                    c11 = 54586;
                                    c12 = 16201;
                                } else {
                                    c12 = 41747;
                                    i9 = i29;
                                    c0031f22 = c0031f26;
                                    packageManager2 = packageManager5;
                                    c11 = 54586;
                                }
                                i16 = 0;
                                i17 = 2;
                            }
                        } else {
                            arrayList4.add(((AbstractC0046j1) it2.next()).f544a);
                            c11 = 54586;
                            c12 = 52680;
                            i16 = 0;
                            i17 = 2;
                        }
                    }
                case 63914:
                    if (d02.i == null) {
                        c6 = 32973;
                        i8 = i10;
                    } else {
                        i8 = i10;
                        c6 = 39834;
                    }
                default:
                    i8 = i10;
                    c6 = 63914;
            }
        }
    }
}
