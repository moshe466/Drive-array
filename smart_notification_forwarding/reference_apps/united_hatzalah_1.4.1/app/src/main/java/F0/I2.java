package F0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class I2 {
    public static int a(Class cls, int i) {
        return AbstractC0008a.f(cls, i);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0011. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final ApplicationInfo b(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageManager.ApplicationInfoFlags of;
        ApplicationInfo applicationInfo2 = null;
        PackageManager packageManager = 0;
        ApplicationInfo applicationInfo3 = null;
        PackageManager packageManager2 = null;
        while (true) {
            char c4 = 4100;
            while (true) {
                switch (c4) {
                    case 4100:
                        int i = ~I2.class.getName().length();
                        byte[] bArr = new byte[1068494077 ^ ((((I2.class.getName().length() | 657442890) - (i | (-1354760370))) + (AbstractC0008a.f(I2.class, (-1407975674) | i) + (I2.class.getName().length() & 657442890))) + ((I2.class.getName().length() & 464257240) | 411051184))];
                        bArr[0] = 8;
                        bArr[1] = -2;
                        bArr[2] = 80;
                        bArr[3] = -99;
                        int i3 = ((~I2.class.getName().length()) | (-1104880912)) & (-1440413632);
                        int length = (I2.class.getName().length() & 594464) | 579112;
                        bArr[4] = V2.a(length, ~i3, ((~length) - i3) - 1) ^ 1439834511;
                        bArr[5] = -100;
                        bArr[6] = -106;
                        byte[] bArr2 = new byte[((((~I2.class.getName().length()) | (-88213641)) - (-121870537)) + ((I2.class.getName().length() & (-1925052264)) | (-2010120176))) ^ (-1888249648)];
                        bArr2[0] = -126;
                        bArr2[1] = 97;
                        bArr2[2] = 84;
                        bArr2[3] = -48;
                        bArr2[4] = -126;
                        bArr2[5] = -28;
                        bArr2[6] = -30;
                        int i4 = ((~I2.class.getName().length()) | 1375972515) & 1124270224;
                        int length2 = (I2.class.getName().length() & 285745168) | 277356612;
                        int i5 = -i4;
                        int i6 = ((~i5) & length2) - ((~length2) & i5);
                        long j2 = 1401626835;
                        long j3 = i6;
                        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        long j17 = (j16 | (j16 >>> 2)) & 252645135;
                        bArr2[(int) (((j17 | (j17 >>> 4)) & 16711935) | ((((j14 >>> 4) | j14) & 16711935) << 8) | j11)] = 56;
                        c(bArr, bArr2);
                        Charset charset = StandardCharsets.UTF_8;
                        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
                        byte[] bArr3 = {85, -118, -75, 65, -40, -8, -7, -34, 35, 53, -34};
                        c(bArr3, new byte[]{60, -69, -20, 17, -48, 111, -78, 119, 66, 88, -69});
                        kotlin.jvm.internal.j.e(str, new String(bArr3, charset).intern());
                        c4 = 41164;
                        applicationInfo2 = null;
                    case 57209:
                        try {
                            if (Build.VERSION.SDK_INT >= 33) {
                                c4 = 12128;
                            } else {
                                c4 = 6954;
                            }
                            packageManager = packageManager2;
                        } catch (PackageManager.NameNotFoundException unused) {
                            packageManager = packageManager2;
                            c4 = 21825;
                        }
                    case 14742:
                        return (ApplicationInfo) packageManager;
                    case 6954:
                        applicationInfo = packageManager.getApplicationInfo(str, 0);
                        applicationInfo3 = applicationInfo;
                        c4 = 35261;
                    case 60596:
                        return applicationInfo2;
                    case 35261:
                        c4 = 46428;
                        packageManager = applicationInfo3;
                    case 21825:
                        packageManager = applicationInfo2;
                        c4 = 14742;
                    case 12128:
                        of = PackageManager.ApplicationInfoFlags.of(0L);
                        applicationInfo = packageManager.getApplicationInfo(str, of);
                        applicationInfo3 = applicationInfo;
                        c4 = 35261;
                    case 41164:
                        try {
                            packageManager2 = context.getPackageManager();
                            if (packageManager2 == null) {
                                c4 = 60596;
                            } else {
                                c4 = 57209;
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            c4 = 21825;
                        }
                    case 46428:
                        c4 = 14742;
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
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
}
