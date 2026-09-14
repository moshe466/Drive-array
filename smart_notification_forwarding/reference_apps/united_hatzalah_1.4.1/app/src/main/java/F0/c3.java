package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class c3 {
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x034a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0013. Please report as an issue. */
    public static double a(W2 w22) {
        boolean z3 = false;
        String[] strArr = new String[0];
        int i = 0;
        int i3 = 0;
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            char c4 = 10735;
            while (true) {
                switch (c4) {
                    case 61020:
                        if (i < i3) {
                            c4 = 41733;
                        } else {
                            c4 = 61921;
                        }
                        z3 = false;
                    case 17689:
                        if (z4) {
                            c4 = 31637;
                        } else {
                            c4 = 24481;
                        }
                        z3 = false;
                    case 24481:
                        strArr = w22.f408a;
                        i3 = strArr.length;
                        c4 = 61020;
                        z3 = false;
                        i = 0;
                        i4 = 0;
                    case 61921:
                        return i4 / w22.f408a.length;
                    case 16789:
                        i4++;
                        z3 = false;
                        c4 = 31554;
                    case 31554:
                        i++;
                        c4 = 61020;
                        z3 = false;
                    case 31637:
                        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    case 41733:
                        String str = strArr[i];
                        char c5 = 39706;
                        int i5 = 0;
                        boolean z5 = false;
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            switch (c5) {
                                case 20183:
                                    c5 = 36604;
                                    z5 = true;
                                case 24541:
                                    i7 = str.length();
                                    c5 = 65319;
                                    i5 = 0;
                                    i6 = 0;
                                case 37936:
                                    z5 = false;
                                    break;
                                case 44811:
                                    int i8 = i6;
                                    if (i5 / str.length() >= 0.9d) {
                                        c5 = 20183;
                                    } else {
                                        c5 = 45155;
                                    }
                                    i6 = i8;
                                case 35646:
                                    i5++;
                                    c5 = 63093;
                                case 39706:
                                    if (str != null) {
                                        c5 = 50649;
                                    } else {
                                        c5 = 37936;
                                    }
                                case 36604:
                                    break;
                                case 65319:
                                    if (i6 < i7) {
                                        c5 = 17235;
                                    } else {
                                        c5 = 44811;
                                    }
                                case 45155:
                                    c5 = 36604;
                                    z5 = false;
                                case 17235:
                                    if (str.charAt(i6) >= 256) {
                                        c5 = 35646;
                                    } else {
                                        c5 = 63093;
                                    }
                                case 50649:
                                    if (str.length() >= 64) {
                                        c5 = 24541;
                                    } else {
                                        c5 = 37936;
                                    }
                                case 63093:
                                    i6++;
                                    c5 = 65319;
                                default:
                                    c5 = 37936;
                            }
                        }
                        if (z5) {
                            c4 = 16789;
                            z3 = false;
                        } else {
                            z3 = false;
                            c4 = 31554;
                        }
                    case 10735:
                        byte[] bArr = new byte[1];
                        int i9 = ((~c3.class.getName().length()) | (-314750974)) & (-1899752429);
                        int length = (c3.class.getName().length() & 1121524753) | 1075382336;
                        int a2 = V2.a(length, ~i9, ((~length) - i9) - 1);
                        bArr[(a2 - 824370093) - ((a2 & (-824370093)) * 2)] = -40;
                        byte[] bArr2 = new byte[8];
                        int length2 = (((~c3.class.getName().length()) | 1904949526) & 8930115) + ((c3.class.getName().length() & 2115269) | 69207172);
                        bArr2[((length2 & (-78137288)) * 2) + (78137287 - length2)] = -66;
                        bArr2[1] = 11;
                        bArr2[2] = -24;
                        bArr2[3] = -25;
                        int i10 = ((~c3.class.getName().length()) | (-1710689860)) & 1574965572;
                        long j2 = 1172440128;
                        long length3 = c3.class.getName().length();
                        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
                        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 8) | j10;
                        long j15 = j3 & 43690;
                        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                        long j17 = ((j16 >>> 2) | j16) & 252645135;
                        bArr2[4] = (((((int) ((((j17 >>> 4) | j17) & 16711935) | j14)) | 35259392) - (~i10)) - 1) ^ 1610224962;
                        long j18 = -1620561760;
                        long j19 = (~c3.class.getName().length()) + (((-r11) - 1) | (-827984701)) + 827984701;
                        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        long j31 = ((((j30 >>> 4) | j30) & 16711935) << 8) + j27;
                        long j32 = j20 & 43690;
                        long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                        long j34 = ((j33 >>> 2) | j33) & 252645135;
                        bArr2[5] = 1620102181 ^ ((((c3.class.getName().length() & (-1910165118)) | 459522) - (~((int) ((((j34 >>> 4) | j34) & 16711935) + j31)))) - 1);
                        bArr2[6] = 90;
                        bArr2[7] = 28;
                        e(bArr, bArr2);
                        kotlin.jvm.internal.j.e(w22, new String(bArr, StandardCharsets.UTF_8).intern());
                        if (w22.f408a.length == 0) {
                            c4 = 64009;
                        } else {
                            c4 = 6934;
                        }
                        z3 = false;
                    case 6934:
                        z4 = z3;
                        c4 = 17689;
                    case 64009:
                        c4 = 17689;
                        z4 = true;
                }
            }
        }
    }

    public static long b(long j2, long j3, long j4, long j5) {
        return AbstractC0008a.h(j2, j3, j4, j5);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x041f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x03a4. Please report as an issue. */
    public static d3 c(File file) {
        byte[] byteArray;
        byte[] bArr = {-17, -65, 75};
        byte[] bArr2 = new byte[8];
        bArr2[0] = -114;
        bArr2[1] = -49;
        bArr2[2] = 32;
        bArr2[3] = -65;
        bArr2[4] = -71;
        bArr2[5] = 116;
        bArr2[((((~c3.class.getName().length()) | 1405349047) & (-1610526444)) + ((c3.class.getName().length() & (-1610608384)) | 42992640)) ^ (-1567533806)] = -1;
        bArr2[7] = -83;
        e(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(file, new String(bArr, charset).intern());
        ZipFile zipFile = new ZipFile(file);
        try {
            long j2 = 1500015075;
            long length = (((~c3.class.getName().length()) | (-4718593)) - (-1212688577)) + ((c3.class.getName().length() & 289947904) | 287326504);
            long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
            byte[] bArr3 = new byte[(int) ((((j16 >>> 4) | j16) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10)];
            bArr3[0] = -98;
            bArr3[1] = -22;
            bArr3[2] = -40;
            bArr3[3] = -81;
            bArr3[4] = -117;
            bArr3[5] = -119;
            bArr3[6] = -29;
            bArr3[7] = 71;
            bArr3[8] = -95;
            bArr3[((((~c3.class.getName().length()) | 1468272177) & 1247110930) + ((c3.class.getName().length() & 743665986) | 604115136)) ^ 1851226075] = 91;
            bArr3[10] = 81;
            byte[] bArr4 = new byte[11];
            bArr4[0] = 33;
            bArr4[1] = -76;
            bArr4[2] = 43;
            bArr4[3] = 97;
            bArr4[4] = 92;
            bArr4[5] = 18;
            int i = ~c3.class.getName().length();
            int length2 = ((c3.class.getName().length() | 571085614) - (i | (-408019970))) + (((-945022468) | i) - c3.class.getName().length()) + (c3.class.getName().length() & 571085614);
            long j17 = 1677862403;
            long length3 = c3.class.getName().length();
            long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
            bArr4[(-435521687) ^ (length2 + (((int) ((((((j28 >>> 4) | j28) & 16711935) << 8) | j25) | (((j31 >>> 4) | j31) & 16711935))) | (-1006607295)))] = 38;
            bArr4[7] = -124;
            bArr4[8] = -59;
            bArr4[9] = 62;
            bArr4[10] = 41;
            f(bArr3, bArr4);
            ZipEntry entry = zipFile.getEntry(new String(bArr3, charset).intern());
            d3 d3Var = null;
            if (entry == null) {
                zipFile.close();
                byteArray = null;
            } else {
                InputStream inputStream = zipFile.getInputStream(entry);
                try {
                    Pattern pattern = f3.f513c;
                    kotlin.jvm.internal.j.b(inputStream);
                    long size = entry.getSize();
                    byte[] bArr5 = new byte[0];
                    char c4 = 27383;
                    ByteArrayOutputStream byteArrayOutputStream = null;
                    int i3 = 0;
                    int i4 = 0;
                    boolean z3 = false;
                    int i5 = 0;
                    while (true) {
                        switch (c4) {
                            case 25760:
                                byteArray = byteArrayOutputStream.toByteArray();
                                break;
                            case 53191:
                                i3 += i4;
                                if (i3 > 4194304) {
                                    c4 = 38588;
                                } else {
                                    c4 = 14164;
                                }
                            case 38588:
                                byteArray = null;
                                break;
                            case 51923:
                                i5 = UserMetadata.MAX_INTERNAL_KEY_SIZE;
                                c4 = 54894;
                            case 7409:
                            case 46134:
                                z3 = false;
                                c4 = 23997;
                            case 39997:
                                if (size < 4194305) {
                                    c4 = 23827;
                                } else {
                                    c4 = 7409;
                                }
                            case 14164:
                                byteArrayOutputStream.write(bArr5, 0, i4);
                                c4 = 43465;
                            case 43465:
                                i4 = inputStream.read(bArr5);
                                if (i4 == -1) {
                                    c4 = 35165;
                                } else {
                                    c4 = 53191;
                                }
                            case 23827:
                                c4 = 23997;
                                z3 = true;
                            case 35165:
                                c4 = 25760;
                            case 23997:
                                if (z3) {
                                    c4 = 23454;
                                } else {
                                    c4 = 51923;
                                }
                            case 54894:
                                byteArrayOutputStream = new ByteArrayOutputStream(i5);
                                bArr5 = new byte[16384];
                                i3 = 0;
                                c4 = 43465;
                            case 27383:
                                if (1 <= size) {
                                    c4 = 39997;
                                } else {
                                    c4 = 46134;
                                }
                            case 23454:
                                i5 = (int) size;
                                c4 = 54894;
                            default:
                                c4 = 46134;
                        }
                    }
                    inputStream.close();
                    zipFile.close();
                } finally {
                }
            }
            while (true) {
                char c5 = 5174;
                while (true) {
                    switch (c5) {
                        case 5174:
                            try {
                                d3Var = new f3(AbstractC0088u0.b(byteArray)).b();
                                c5 = 15895;
                            } catch (app.talsec.rasp.j2 unused) {
                                c5 = 57088;
                            }
                        case 57139:
                            d3Var = new d3();
                            c5 = 34892;
                        case 34892:
                            break;
                        case 57088:
                            c5 = 57139;
                        case 15895:
                            c5 = 34892;
                    }
                    return d3Var;
                }
            }
        } finally {
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
        int i7 = ~c3.class.getName().length();
        int length3 = (((~(((c3.class.getName().length() | 70245657) | i7) - (i7 | (c3.class.getName().length() & (-70245658))))) & (-1979440632)) + ((c3.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(c3.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((c3.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~c3.class.getName().length()) | (-576567005)) & 276971586) + ((c3.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~c3.class.getName().length()) | (-1157759625)) & 1755853004) + ((c3.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~c3.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = c3.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~c3.class.getName().length()) | (-1064961)) + 689325073) + ((c3.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~c3.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = c3.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~c3.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (c3.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((c3.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~c3.class.getName().length();
                    int length11 = (161497089 & (((((c3.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((c3.class.getName().length() | i14) & 797295576))) + ((c3.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~c3.class.getName().length()) | (-1085986263)) & 1078327440) + ((c3.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~c3.class.getName().length();
                    int length12 = length5 >>> ((((~(((c3.class.getName().length() | 626856794) | i15) - ((c3.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((c3.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~c3.class.getName().length()) | 1248713193) & 826417528) + ((c3.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~c3.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (c3.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~c3.class.getName().length()) | (-1005965450)) & 153223237) + ((c3.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((c3.class.getName().length() & (~length6)) & i9)) + ((c3.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~c3.class.getName().length()) | (-30261291)) & (-1534000062)) + ((c3.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~c3.class.getName().length()) | (-23496740)) & 827084804) + ((c3.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~c3.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (c3.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~c3.class.getName().length()) | (-961655275)) & 25184460) + ((c3.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~c3.class.getName().length()) | 1233459797) & 125923146) + ((c3.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~c3.class.getName().length()) | (-7107622)) & 402932290) + ((c3.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((c3.class.getName().length() | length15) - (b4 | length15)) + I2.a(c3.class, b4) + (c3.class.getName().length() & length15);
                    int length17 = ((((~c3.class.getName().length()) | (-81143879)) & 438583424) + ((c3.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~c3.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((c3.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(c3.class, 568748773 | i24) + (c3.class.getName().length() & (-2105278367)))) + ((c3.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~c3.class.getName().length()) | (-1592082969)) & 140665109) + ((c3.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~c3.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((c3.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~c3.class.getName().length()) | (-180811308));
                    int length19 = (c3.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((c3.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | c3.class.getName().length()))));
                    int i29 = ((~c3.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (c3.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~c3.class.getName().length()) | 75364313) & 1242301609) + ((c3.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = c3.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((c3.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~c3.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((c3.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~c3.class.getName().length();
                    int length24 = 1409942802 & (((((c3.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | c3.class.getName().length()) & 91135407));
                    int length25 = (c3.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~c3.class.getName().length()) | (-537919489)) - (-806798471)) + ((c3.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~c3.class.getName().length()) | (-382746167)) & 102532165) + ((c3.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~c3.class.getName().length()) | (-6036961)) & 1233145505) + ((c3.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~c3.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = c3.class.getName().length() & 268460041;
                    i5 = (((((c3.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | c3.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = c3.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((c3.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~c3.class.getName().length()) | (-1883938358)) & (-738125179)) + ((c3.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~c3.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (c3.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(c3.class, -1) | (-532481)) - (-67641369)) + ((c3.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~c3.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((c3.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(c3.class, -1) | (-33554434)) - (-1107366402)) + ((c3.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(c3.class, -1) | (-167014194)) & 1157999680) + ((c3.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = c3.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((c3.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(c3.class, -1) | 114408723) & 1183666176;
                    int length33 = c3.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~c3.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = c3.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~c3.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (c3.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~c3.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((c3.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~c3.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (c3.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~c3.class.getName().length()) | 991120067) & (-2113137661)) + ((c3.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(c3.class, -1) | 314136709) & 371231304) + (((c3.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~c3.class.getName().length()) | 366661365) & 1344150018) + ((c3.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~c3.class.getName().length()) | (-1359635359)) & 49026131) + ((c3.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~c3.class.getName().length();
                    if (length3 > 0) {
                        int length38 = c3.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (c3.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~c3.class.getName().length()) | 1110430873) & 1241612298) + ((c3.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~c3.class.getName().length()) | 1603962366) & 25199440) + (((c3.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~c3.class.getName().length()) | (-1388708984)) & 706816128) + ((c3.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~c3.class.getName().length()) | 367288948) & 548745488;
                    int length41 = c3.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~c3.class.getName().length()) | 2113158628) & 1026558002) + ((c3.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~c3.class.getName().length()) | 715175224) & 136512788) + ((c3.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~c3.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = c3.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~c3.class.getName().length()) | (-1084937228)) & 438503696) + ((c3.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~c3.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((c3.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(c3.class, 1197735420 | i53) + (c3.class.getName().length() & 674349280))) + ((c3.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~c3.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (c3.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~c3.class.getName().length()) | (-171976913)) & 318775824) + ((c3.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~c3.class.getName().length()) | (-616910267)) & 1303391760) + ((c3.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~c3.class.getName().length()) | 1297715640) & 556926729) + ((c3.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~c3.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((c3.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~c3.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (c3.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
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
    public static void f(byte[] bArr, byte[] bArr2) {
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
}
