package F0;

import android.R;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.apache.tika.fork.ForkServer;
import t2.AbstractC0705g;

/* loaded from: classes.dex */
public abstract class B0 {
    public static int a(int i, int i3) {
        return (i3 - (i * 2)) - 2;
    }

    public static String b(PackageInfo packageInfo) {
        String str = null;
        char c4 = 62162;
        Object obj = null;
        char c5 = 62162;
        while (true) {
            if (c5 != c4) {
                if (c5 != 54437) {
                    if (c5 != 13848) {
                        if (c5 == 41194) {
                            return c(new File((String) obj));
                        }
                    } else {
                        obj = ((ApplicationInfo) obj).sourceDir;
                        if (obj != null) {
                            c5 = 41194;
                        }
                    }
                    c5 = 54437;
                    str = null;
                    c4 = 62162;
                } else {
                    return str;
                }
            } else {
                byte[] bArr = new byte[11];
                bArr[0] = -58;
                int i = ((~B0.class.getName().length()) | (-773887739)) & 411060010;
                int length = (B0.class.getName().length() & 671221418) | (-1576927104);
                int i3 = -i;
                long j2 = -1165867093;
                long j3 = (length ^ i3) - ((i3 & (~length)) * 2);
                long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                bArr[(int) ((((j17 >>> 4) | j17) & 16711935) + ((((j14 >>> 4) | j14) & 16711935) << 8) + j11)] = 5;
                bArr[2] = -14;
                long j18 = 810419547;
                long length2 = (((~B0.class.getName().length()) | (-541468068)) & 87154708) + ((B0.class.getName().length() & (-939515390)) | (-897574270));
                long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                long j20 = (j19 >>> 48) & 21845;
                long j21 = ((j20 >>> 1) | j20) & 858993459;
                long j22 = ((j21 >>> 2) | j21) & 252645135;
                long j23 = (j19 >>> 32) & 21845;
                long j24 = ((j23 >>> 1) | j23) & 858993459;
                long j25 = ((j24 >>> 2) | j24) & 252645135;
                long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
                long j27 = (j19 >>> 16) & 21845;
                long j28 = ((j27 >>> 1) | j27) & 858993459;
                long j29 = ((j28 >>> 2) | j28) & 252645135;
                long j30 = j19 & 21845;
                long j31 = ((j30 >>> 1) | j30) & 858993459;
                long j32 = ((j31 >>> 2) | j31) & 252645135;
                bArr[3] = (int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26));
                bArr[4] = -49;
                long j33 = -1;
                long length3 = B0.class.getName().length();
                long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                long j35 = (j34 >>> 48) & 21845;
                long j36 = ((j35 >>> 1) | j35) & 858993459;
                long j37 = ((j36 >>> 2) | j36) & 252645135;
                long j38 = (j34 >>> 32) & 21845;
                long j39 = ((j38 >>> 1) | j38) & 858993459;
                long j40 = ((j39 >>> 2) | j39) & 252645135;
                long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
                long j42 = (j34 >>> 16) & 21845;
                long j43 = ((j42 >>> 1) | j42) & 858993459;
                long j44 = ((j43 >>> 2) | j43) & 252645135;
                long j45 = j34 & 21845;
                long j46 = ((j45 >>> 1) | j45) & 858993459;
                long j47 = ((j46 >>> 2) | j46) & 252645135;
                int i4 = (((int) ((((((j44 >>> 4) | j44) & 16711935) << 8) + j41) | (((j47 >>> 4) | j47) & 16711935))) | 1876294594) & (-788525907);
                int i5 = ~((B0.class.getName().length() & (-1308490707)) | 570589440);
                int i6 = -i4;
                bArr[V2.a(~i6, i5, (i5 + i6) + 1) ^ (-217936472)] = 112;
                bArr[6] = -87;
                bArr[7] = 90;
                bArr[8] = -54;
                bArr[9] = -58;
                bArr[10] = 33;
                long j48 = -870320692;
                long j49 = ~B0.class.getName().length();
                long b4 = c3.b((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                long j50 = (b4 >>> 48) & 43690;
                long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
                long j52 = ((j51 >>> 2) | j51) & 252645135;
                long j53 = (b4 >>> 32) & 43690;
                long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
                long j55 = ((j54 >>> 2) | j54) & 252645135;
                long j56 = ((((j55 >>> 4) | j55) & 16711935) << 16) | ((((j52 >>> 4) | j52) & 16711935) << 24);
                long j57 = (b4 >>> 16) & 43690;
                long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
                long j59 = ((j58 >>> 2) | j58) & 252645135;
                long j60 = b4 & 43690;
                long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
                long j62 = (j61 | (j61 >>> 2)) & 252645135;
                int length4 = (((B0.class.getName().length() & 538977792) | 811607172) - (~(((int) (((j62 | (j62 >>> 4)) & 16711935) + (((((j59 >>> 4) | j59) & 16711935) << 8) + j56))) & 68752136))) - 1;
                byte[] bArr2 = new byte[((length4 & (-880359304)) * 2) + (880359303 - length4)];
                bArr2[0] = 86;
                bArr2[1] = 78;
                bArr2[2] = -96;
                bArr2[3] = -92;
                bArr2[4] = 88;
                bArr2[5] = -72;
                bArr2[6] = 49;
                bArr2[7] = -6;
                bArr2[8] = 78;
                bArr2[9] = 11;
                bArr2[10] = -125;
                d(bArr, bArr2);
                kotlin.jvm.internal.j.e(packageInfo, new String(bArr, StandardCharsets.UTF_8).intern());
                obj = packageInfo.applicationInfo;
                if (obj != null) {
                    str = null;
                    c4 = 62162;
                    c5 = 13848;
                } else {
                    c5 = 54437;
                    str = null;
                    c4 = 62162;
                }
            }
        }
    }

    public static String c(File file) {
        int i = ((~B0.class.getName().length()) | 1639260694) & 688931982;
        long j2 = 134235272;
        long length = B0.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j4 = (j3 >>> 48) & 43690;
        int i3 = 1;
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
        int i4 = ((int) ((((j16 >>> 4) | j16) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) | (-1006624256);
        int i5 = -i;
        byte[] bArr = {82, 54, 317692183 ^ ((((~i5) & i4) * 2) - (i5 ^ i4)), 85};
        e(bArr, new byte[]{52, 95, -11, 48, -42, 84, 86, -18});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        try {
            int length2 = (-1) - B0.class.getName().length();
            long j17 = 52757000;
            long length3 = (B0.class.getName().length() | (-50692609)) - (-50692609);
            long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
            long j19 = (j18 >>> 48) & 43690;
            long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
            long j21 = ((j20 >>> 2) | j20) & 252645135;
            long j22 = (j18 >>> 32) & 43690;
            long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
            long j24 = ((j23 >>> 2) | j23) & 252645135;
            long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << 24);
            long j26 = (j18 >>> 16) & 43690;
            long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
            long j28 = ((j27 >>> 2) | j27) & 252645135;
            long j29 = j18 & 43690;
            long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
            long j31 = ((j30 >>> 2) | j30) & 252645135;
            int i6 = (((length2 ^ (-288878953)) + (length2 & (-288878953))) & 35987) + ((int) ((((j31 >>> 4) | j31) & 16711935) | (((((j28 >>> 4) | j28) & 16711935) << 8) + j25)));
            byte[] bArr2 = {(i6 | (-52793009)) - ((-52793009) & i6), 75, -119, 107, 76, -45, 71};
            e(bArr2, new byte[]{-121, 3, -56, 70, 126, -26, 113, 33});
            MessageDigest messageDigest = MessageDigest.getInstance(new String(bArr2, charset).intern());
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr3 = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr3);
                    if (read != -1) {
                        messageDigest.update(bArr3, 0, read);
                    } else {
                        fileInputStream.close();
                        byte[] digest = messageDigest.digest();
                        int i7 = ((~B0.class.getName().length()) | 1426742703) & 17106555;
                        int length4 = (B0.class.getName().length() | (-281346641)) + 281346641;
                        int i8 = ~(((B0.class.getName().length() | (-1354895361)) | length4) - ((B0.class.getName().length() & 1354895360) | length4));
                        int i9 = -i7;
                        byte[] bArr4 = {-66, 76, 60, -51, 105, 25, 1372001815 ^ ((((~i9) & i8) * 2) - (i9 ^ i8)), 31, 7, -66, -25};
                        int i10 = ((~B0.class.getName().length()) | (-643397061)) & (-2006576624);
                        long j32 = 25206980;
                        long length5 = B0.class.getName().length() & 12619780;
                        long j33 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                        long j34 = (j33 >>> 48) & 43690;
                        long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
                        long j36 = (j35 | (j35 >>> 2)) & 252645135;
                        long j37 = (j33 >>> 32) & 43690;
                        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
                        long j39 = (j38 | (j38 >>> 2)) & 252645135;
                        long j40 = (((j36 | (j36 >>> 4)) & 16711935) << 24) | (((j39 | (j39 >>> 4)) & 16711935) << 16);
                        long j41 = (j33 >>> 16) & 43690;
                        long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                        long j43 = (j42 | (j42 >>> 2)) & 252645135;
                        long j44 = j33 & 43690;
                        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                        long j46 = (j45 | (j45 >>> 2)) & 252645135;
                        byte[] bArr5 = new byte[((((int) ((j40 | (((j43 | (j43 >>> 4)) & 16711935) << 8)) | ((j46 | (j46 >>> 4)) & 16711935))) - (~i10)) - 1) ^ (-1981369633)];
                        bArr5[0] = -38;
                        bArr5[1] = 37;
                        int i11 = ((~B0.class.getName().length()) | 40627831) & 336225893;
                        int length6 = B0.class.getName().length() & 1548812296;
                        bArr5[1549533039 ^ (i11 + (~(((B0.class.getName().length() | (-1213307145)) | length6) - ((B0.class.getName().length() & 1213307144) | length6))))] = 91;
                        bArr5[3] = -88;
                        bArr5[4] = 26;
                        bArr5[5] = 109;
                        bArr5[6] = 68;
                        bArr5[7] = 49;
                        bArr5[8] = 41;
                        bArr5[9] = -112;
                        bArr5[10] = -50;
                        e(bArr4, bArr5);
                        kotlin.jvm.internal.j.d(digest, new String(bArr4, StandardCharsets.UTF_8).intern());
                        return AbstractC0705g.L(digest, "", new C0029f0(i3), 30);
                    }
                }
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~B0.class.getName().length();
        int length3 = (((~(((B0.class.getName().length() | 70245657) | i7) - (i7 | (B0.class.getName().length() & (-70245658))))) & (-1979440632)) + ((B0.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(B0.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((B0.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~B0.class.getName().length()) | (-576567005)) & 276971586) + ((B0.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~B0.class.getName().length()) | (-1157759625)) & 1755853004) + ((B0.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~B0.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = B0.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~B0.class.getName().length()) | (-1064961)) + 689325073) + ((B0.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~B0.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = B0.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~B0.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (B0.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((B0.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~B0.class.getName().length();
                    int length11 = (161497089 & (((((B0.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((B0.class.getName().length() | i14) & 797295576))) + ((B0.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~B0.class.getName().length()) | (-1085986263)) & 1078327440) + ((B0.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~B0.class.getName().length();
                    int length12 = length5 >>> ((((~(((B0.class.getName().length() | 626856794) | i15) - ((B0.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((B0.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~B0.class.getName().length()) | 1248713193) & 826417528) + ((B0.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~B0.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (B0.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~B0.class.getName().length()) | (-1005965450)) & 153223237) + ((B0.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((B0.class.getName().length() & (~length6)) & i9)) + ((B0.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~B0.class.getName().length()) | (-30261291)) & (-1534000062)) + ((B0.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~B0.class.getName().length()) | (-23496740)) & 827084804) + ((B0.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~B0.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (B0.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~B0.class.getName().length()) | (-961655275)) & 25184460) + ((B0.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~B0.class.getName().length()) | 1233459797) & 125923146) + ((B0.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~B0.class.getName().length()) | (-7107622)) & 402932290) + ((B0.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((B0.class.getName().length() | length15) - (b4 | length15)) + I2.a(B0.class, b4) + (B0.class.getName().length() & length15);
                    int length17 = ((((~B0.class.getName().length()) | (-81143879)) & 438583424) + ((B0.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~B0.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((B0.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(B0.class, 568748773 | i24) + (B0.class.getName().length() & (-2105278367)))) + ((B0.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~B0.class.getName().length()) | (-1592082969)) & 140665109) + ((B0.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~B0.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((B0.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~B0.class.getName().length()) | (-180811308));
                    int length19 = (B0.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((B0.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | B0.class.getName().length()))));
                    int i29 = ((~B0.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (B0.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~B0.class.getName().length()) | 75364313) & 1242301609) + ((B0.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = B0.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((B0.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~B0.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((B0.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~B0.class.getName().length();
                    int length24 = 1409942802 & (((((B0.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | B0.class.getName().length()) & 91135407));
                    int length25 = (B0.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~B0.class.getName().length()) | (-537919489)) - (-806798471)) + ((B0.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~B0.class.getName().length()) | (-382746167)) & 102532165) + ((B0.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~B0.class.getName().length()) | (-6036961)) & 1233145505) + ((B0.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~B0.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = B0.class.getName().length() & 268460041;
                    i5 = (((((B0.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | B0.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = B0.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((B0.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~B0.class.getName().length()) | (-1883938358)) & (-738125179)) + ((B0.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~B0.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (B0.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(B0.class, -1) | (-532481)) - (-67641369)) + ((B0.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~B0.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((B0.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(B0.class, -1) | (-33554434)) - (-1107366402)) + ((B0.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(B0.class, -1) | (-167014194)) & 1157999680) + ((B0.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = B0.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((B0.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(B0.class, -1) | 114408723) & 1183666176;
                    int length33 = B0.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~B0.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = B0.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~B0.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (B0.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~B0.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((B0.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~B0.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (B0.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~B0.class.getName().length()) | 991120067) & (-2113137661)) + ((B0.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(B0.class, -1) | 314136709) & 371231304) + (((B0.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~B0.class.getName().length()) | 366661365) & 1344150018) + ((B0.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~B0.class.getName().length()) | (-1359635359)) & 49026131) + ((B0.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~B0.class.getName().length();
                    if (length3 > 0) {
                        int length38 = B0.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (B0.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~B0.class.getName().length()) | 1110430873) & 1241612298) + ((B0.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~B0.class.getName().length()) | 1603962366) & 25199440) + (((B0.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~B0.class.getName().length()) | (-1388708984)) & 706816128) + ((B0.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~B0.class.getName().length()) | 367288948) & 548745488;
                    int length41 = B0.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~B0.class.getName().length()) | 2113158628) & 1026558002) + ((B0.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~B0.class.getName().length()) | 715175224) & 136512788) + ((B0.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~B0.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = B0.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~B0.class.getName().length()) | (-1084937228)) & 438503696) + ((B0.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~B0.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((B0.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(B0.class, 1197735420 | i53) + (B0.class.getName().length() & 674349280))) + ((B0.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~B0.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (B0.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~B0.class.getName().length()) | (-171976913)) & 318775824) + ((B0.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~B0.class.getName().length()) | (-616910267)) & 1303391760) + ((B0.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~B0.class.getName().length()) | 1297715640) & 556926729) + ((B0.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~B0.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((B0.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~B0.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (B0.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
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
}
