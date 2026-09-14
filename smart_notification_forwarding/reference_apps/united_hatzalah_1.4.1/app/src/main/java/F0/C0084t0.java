package F0;

import a.AbstractC0228a;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import f1.C0378A;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.tika.fork.ForkServer;
import s2.C0680e;
import s2.C0681f;
import s2.C0682g;

/* renamed from: F0.t0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0084t0 implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final Object f663a;

    /* renamed from: b, reason: collision with root package name */
    public Object f664b;

    public /* synthetic */ C0084t0(Object obj, Object obj2) {
        this.f663a = obj;
        this.f664b = obj2;
    }

    public static String a(Context context) {
        File filesDir = context.getFilesDir();
        byte[] bArr = new byte[3];
        bArr[0] = -124;
        bArr[1] = 56;
        int i = ~C0084t0.class.getName().length();
        bArr[((((i + (((-i) - 1) | (-97746933))) + 97746933) & 1085342256) + ((C0084t0.class.getName().length() & 1612748800) | 536910024)) ^ 1622252282] = -36;
        byte[] bArr2 = new byte[8];
        bArr2[0] = -16;
        bArr2[1] = 91;
        bArr2[2] = -66;
        long j2 = 2137558015;
        long j3 = ~C0084t0.class.getName().length();
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
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
        bArr2[(((((int) ((((((j14 >>> 4) | j14) & 16711935) << 8) | j11) | (((j17 >>> 4) | j17) & 16711935))) | 804757167) - 804757167) + ((C0084t0.class.getName().length() & (-2147459062)) | 5374986)) ^ (-799382183)] = -56;
        bArr2[4] = -5;
        bArr2[5] = 36;
        bArr2[6] = -123;
        bArr2[7] = 87;
        d(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        File file = new File(filesDir, new String(bArr, charset).intern());
        if (file.exists() && !file.delete()) {
            return null;
        }
        try {
            AssetManager assets = context.getAssets();
            byte[] bArr3 = {-26, 4, -112, Byte.MIN_VALUE, 100, 112, -50, 60};
            try {
                d(bArr3, new byte[]{-23, -105, 115, -105, 123, 112, 52, -20});
                InputStream open = assets.open(new String(bArr3, charset).intern());
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        kotlin.jvm.internal.j.b(open);
                        String encodeToString = Base64.encodeToString(c(open, fileOutputStream), 2);
                        byte[] bArr4 = new byte[44];
                        bArr4[0] = 8;
                        bArr4[1] = -49;
                        bArr4[2] = -96;
                        long j18 = -1;
                        long length = C0084t0.class.getName().length();
                        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
                        bArr4[3] = (((((int) ((((((j29 >>> 4) | j29) & 16711935) << 8) | j26) | (((j32 >>> 4) | j32) & 16711935))) | 2104513362) & 839141396) + ((C0084t0.class.getName().length() & 33826916) | 2236512)) ^ 841377821;
                        bArr4[4] = -29;
                        bArr4[5] = -43;
                        bArr4[6] = -7;
                        bArr4[7] = -95;
                        bArr4[8] = 117;
                        bArr4[9] = 35;
                        int length2 = C0084t0.class.getName().length();
                        int length3 = (((-1417526119) | (((~length2) - length2) + length2)) & 472271235) + ((C0084t0.class.getName().length() & 1412173090) | 1078461476);
                        bArr4[10] = (((~length3) & (-1550732772)) - ((-1550732772) & length3)) + length3;
                        bArr4[11] = 54;
                        bArr4[12] = 40;
                        bArr4[13] = -28;
                        bArr4[14] = -17;
                        bArr4[15] = 47;
                        bArr4[16] = -36;
                        bArr4[17] = 85;
                        bArr4[18] = -31;
                        bArr4[19] = 60;
                        bArr4[20] = -35;
                        bArr4[21] = 107;
                        bArr4[22] = -105;
                        bArr4[23] = 80;
                        bArr4[24] = -36;
                        bArr4[25] = 28;
                        bArr4[26] = 55;
                        bArr4[27] = -8;
                        bArr4[28] = 103;
                        bArr4[29] = 56;
                        bArr4[30] = 93;
                        bArr4[31] = -51;
                        bArr4[32] = Byte.MIN_VALUE;
                        bArr4[33] = 0;
                        bArr4[34] = 76;
                        bArr4[35] = -76;
                        bArr4[36] = 123;
                        bArr4[37] = 25;
                        bArr4[38] = 118;
                        bArr4[((((~C0084t0.class.getName().length()) | 538977830) & (-1744292092)) + ((C0084t0.class.getName().length() & (-1207428736)) | 537135232)) ^ (-1207156829)] = 74;
                        bArr4[40] = -36;
                        bArr4[41] = 84;
                        bArr4[42] = 13;
                        bArr4[43] = -42;
                        byte[] bArr5 = new byte[44];
                        bArr5[0] = -55;
                        bArr5[1] = -54;
                        bArr5[2] = 74;
                        bArr5[3] = -104;
                        bArr5[4] = -55;
                        bArr5[5] = -127;
                        bArr5[6] = 30;
                        bArr5[7] = 50;
                        bArr5[8] = 115;
                        bArr5[((((~C0084t0.class.getName().length()) | 1638983058) & 872461642) + ((C0084t0.class.getName().length() & 335548508) | (-2141191660))) ^ (-1268730025)] = 70;
                        bArr5[10] = 111;
                        bArr5[11] = -4;
                        bArr5[12] = -89;
                        bArr5[13] = -96;
                        bArr5[14] = 2;
                        bArr5[15] = -63;
                        bArr5[16] = -31;
                        bArr5[17] = 113;
                        bArr5[18] = 21;
                        bArr5[19] = -14;
                        bArr5[20] = -50;
                        bArr5[21] = 49;
                        bArr5[22] = 76;
                        bArr5[23] = -42;
                        bArr5[24] = -54;
                        bArr5[25] = 122;
                        int length4 = (((~C0084t0.class.getName().length()) | 1690644329) & 72428544) + ((C0084t0.class.getName().length() & 26214402) | 25297158);
                        bArr5[26] = B0.a((~length4) | (-97725715), (-97725715) - length4);
                        bArr5[27] = 27;
                        bArr5[28] = 111;
                        bArr5[29] = 65;
                        bArr5[30] = -74;
                        bArr5[31] = 73;
                        bArr5[32] = 84;
                        bArr5[33] = -126;
                        bArr5[34] = -53;
                        bArr5[35] = 33;
                        bArr5[36] = 82;
                        bArr5[37] = 52;
                        bArr5[38] = -57;
                        bArr5[39] = -12;
                        bArr5[40] = -42;
                        bArr5[41] = 53;
                        bArr5[42] = 12;
                        bArr5[43] = 5;
                        d(bArr4, bArr5);
                        if (!kotlin.jvm.internal.j.a(new String(bArr4, charset).intern(), encodeToString)) {
                            fileOutputStream.close();
                            open.close();
                            return null;
                        }
                        fileOutputStream.flush();
                        String absolutePath = file.getAbsolutePath();
                        fileOutputStream.close();
                        open.close();
                        return absolutePath;
                    } finally {
                    }
                } finally {
                }
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
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

    public static byte[] c(InputStream inputStream, FileOutputStream fileOutputStream) {
        int i;
        byte[] bArr = new byte[0];
        MessageDigest messageDigest = null;
        int i3 = 0;
        char c4 = 23546;
        while (c4 != 2633) {
            if (c4 != 44430) {
                if (c4 != 59446) {
                    if (c4 != 23546) {
                        i = i3;
                        i3 = i;
                        c4 = 2633;
                    } else {
                        byte[] bArr2 = {93, 107, -85, 106, -53, 71, -116};
                        byte[] bArr3 = new byte[8];
                        bArr3[0] = 37;
                        bArr3[1] = -13;
                        bArr3[2] = -1;
                        bArr3[((((~C0084t0.class.getName().length()) | 855551603) & 286296456) + (((C0084t0.class.getName().length() | (-1090520461)) - (-1090520461)) | 1074267204)) ^ 1360563663] = 46;
                        bArr3[4] = -7;
                        bArr3[5] = 114;
                        bArr3[6] = -70;
                        bArr3[7] = 113;
                        b(bArr2, bArr3);
                        messageDigest = MessageDigest.getInstance(new String(bArr2, StandardCharsets.UTF_8).intern());
                        bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                        i3 = 0;
                    }
                } else {
                    fileOutputStream.write(bArr, 0, i3);
                    messageDigest.update(bArr, 0, i3);
                }
                c4 = 44430;
            } else {
                i = inputStream.read(bArr);
                if (i > 0) {
                    i3 = i;
                    c4 = 59446;
                } else {
                    i3 = i;
                    c4 = 2633;
                }
            }
        }
        byte[] digest = messageDigest.digest();
        int length = C0084t0.class.getName().length();
        byte[] bArr4 = {-42, ((((-304900) | ((length - 1) - (length * 2))) & 85546026) + ((C0084t0.class.getName().length() & (-2138962798)) | (-2134507371))) ^ (-2048961365), 68, -67, -12, 5, -83, 124, 126, -100, -87};
        byte[] bArr5 = new byte[11];
        bArr5[0] = -55;
        bArr5[1] = 77;
        bArr5[2] = 57;
        bArr5[3] = -65;
        bArr5[4] = -98;
        bArr5[5] = 65;
        bArr5[6] = -101;
        bArr5[7] = 57;
        bArr5[8] = 80;
        bArr5[9] = -78;
        long j2 = -1;
        long length2 = C0084t0.class.getName().length();
        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        long j17 = 2025784754;
        long length3 = ((((int) ((((j16 >>> 4) | j16) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) | (-542442499)) & 1208943920) + ((C0084t0.class.getName().length() & 540345352) | 816840840);
        long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j19 = (j18 >>> 48) & 21845;
        long j20 = (j19 | (j19 >>> 1)) & 858993459;
        long j21 = (j20 | (j20 >>> 2)) & 252645135;
        long j22 = (j18 >>> 32) & 21845;
        long j23 = ((j22 >>> 1) | j22) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = (((j21 | (j21 >>> 4)) & 16711935) << 24) | ((((j24 >>> 4) | j24) & 16711935) << 16);
        long j26 = (j18 >>> 16) & 21845;
        long j27 = ((j26 >>> 1) | j26) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 21845;
        long j30 = (j29 | (j29 >>> 1)) & 858993459;
        long j31 = (j30 | (j30 >>> 2)) & 252645135;
        bArr5[(int) (((j31 | (j31 >>> 4)) & 16711935) + (j25 | ((((j28 >>> 4) | j28) & 16711935) << 8)))] = Byte.MIN_VALUE;
        b(bArr4, bArr5);
        kotlin.jvm.internal.j.d(digest, new String(bArr4, StandardCharsets.UTF_8).intern());
        return digest;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
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
    public static void f(byte[] bArr, byte[] bArr2) {
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

    public static String j(C0084t0 c0084t0, ArrayList arrayList) {
        Object g3;
        androidx.lifecycle.N n4 = new androidx.lifecycle.N(17);
        Object obj = ((C0681f) ((C0682g) c0084t0.f664b).a()).f6335a;
        if (!(obj instanceof C0680e)) {
            ((c1.g) obj).getClass();
            try {
                g3 = c1.g.a(n4, arrayList);
            } catch (Throwable th) {
                g3 = AbstractC0228a.g(th);
            }
            obj = new C0681f(g3);
        }
        Object n5 = m3.b.n(obj);
        Throwable a2 = C0681f.a(n5);
        if (a2 != null) {
            E1.b.l(a2);
        }
        if (n5 instanceof C0680e) {
            n5 = "";
        }
        return (String) n5;
    }

    public G0.d e() {
        G0.h hVar = (G0.h) this.f664b;
        if (hVar != null) {
            return hVar.f815e;
        }
        G0.g gVar = G0.g.f805a;
        ((G0.l) this.f663a).getClass();
        return new G0.d(gVar, null);
    }

    public G0.f g() {
        G0.h hVar = (G0.h) this.f664b;
        G0.f fVar = null;
        char c4 = 32870;
        while (c4 != 50304) {
            if (c4 != 12485) {
                if (c4 != 60657) {
                    if (c4 == 32870) {
                        if (hVar != null) {
                            c4 = 12485;
                        } else {
                            c4 = 60657;
                        }
                    }
                } else {
                    fVar = G0.f.f802a;
                }
            } else {
                fVar = hVar.f816f;
            }
            c4 = 50304;
        }
        return fVar;
    }

    public View h(int i, int i3, int i4, int i5) {
        int i6;
        k0.L l3 = (k0.L) this.f664b;
        k0.M m4 = (k0.M) this.f663a;
        int h2 = m4.h();
        int j2 = m4.j();
        if (i3 > i) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        View view = null;
        while (i != i3) {
            View o2 = m4.o(i);
            int c4 = m4.c(o2);
            int p = m4.p(o2);
            l3.f5198b = h2;
            l3.f5199c = j2;
            l3.f5200d = c4;
            l3.f5201e = p;
            if (i4 != 0) {
                l3.f5197a = i4;
                if (l3.a()) {
                    return o2;
                }
            }
            if (i5 != 0) {
                l3.f5197a = i5;
                if (l3.a()) {
                    view = o2;
                }
            }
            i += i6;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory i(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "."
            java.lang.String r1 = "Could not instantiate "
            java.lang.Object r2 = r12.f664b
            java.util.Map r2 = (java.util.Map) r2
            r3 = 0
            if (r2 != 0) goto L80
            java.lang.Object r2 = r12.f663a
            android.content.Context r2 = (android.content.Context) r2
            android.content.pm.PackageManager r4 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L15
            if (r4 != 0) goto L17
        L15:
            r2 = r3
            goto L29
        L17:
            android.content.ComponentName r5 = new android.content.ComponentName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L15
            java.lang.Class<com.google.android.datatransport.runtime.backends.TransportBackendDiscovery> r6 = com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.class
            r5.<init>(r2, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L15
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ServiceInfo r2 = r4.getServiceInfo(r5, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L15
            if (r2 != 0) goto L27
            goto L15
        L27:
            android.os.Bundle r2 = r2.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L15
        L29:
            if (r2 != 0) goto L2e
            java.util.Map r2 = java.util.Collections.EMPTY_MAP
            goto L7e
        L2e:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Set r5 = r2.keySet()
            java.util.Iterator r5 = r5.iterator()
        L3b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L7d
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.get(r6)
            boolean r8 = r7 instanceof java.lang.String
            if (r8 == 0) goto L3b
            java.lang.String r8 = "backend:"
            boolean r8 = r6.startsWith(r8)
            if (r8 == 0) goto L3b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = ","
            r9 = -1
            java.lang.String[] r7 = r7.split(r8, r9)
            int r8 = r7.length
            r9 = 0
        L62:
            if (r9 >= r8) goto L3b
            r10 = r7[r9]
            java.lang.String r10 = r10.trim()
            boolean r11 = r10.isEmpty()
            if (r11 == 0) goto L71
            goto L7a
        L71:
            r11 = 8
            java.lang.String r11 = r6.substring(r11)
            r4.put(r10, r11)
        L7a:
            int r9 = r9 + 1
            goto L62
        L7d:
            r2 = r4
        L7e:
            r12.f664b = r2
        L80:
            java.lang.Object r2 = r12.f664b
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r13 = r2.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            if (r13 != 0) goto L8d
            return r3
        L8d:
            java.lang.Class r2 = java.lang.Class.forName(r13)     // Catch: java.lang.reflect.InvocationTargetException -> La2 java.lang.NoSuchMethodException -> La6 java.lang.InstantiationException -> Laa java.lang.IllegalAccessException -> Lb6 java.lang.ClassNotFoundException -> Lc2
            java.lang.Class<com.google.android.datatransport.cct.CctBackendFactory> r4 = com.google.android.datatransport.cct.CctBackendFactory.class
            java.lang.Class r2 = r2.asSubclass(r4)     // Catch: java.lang.reflect.InvocationTargetException -> La2 java.lang.NoSuchMethodException -> La6 java.lang.InstantiationException -> Laa java.lang.IllegalAccessException -> Lb6 java.lang.ClassNotFoundException -> Lc2
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch: java.lang.reflect.InvocationTargetException -> La2 java.lang.NoSuchMethodException -> La6 java.lang.InstantiationException -> Laa java.lang.IllegalAccessException -> Lb6 java.lang.ClassNotFoundException -> Lc2
            java.lang.Object r2 = r2.newInstance(r3)     // Catch: java.lang.reflect.InvocationTargetException -> La2 java.lang.NoSuchMethodException -> La6 java.lang.InstantiationException -> Laa java.lang.IllegalAccessException -> Lb6 java.lang.ClassNotFoundException -> Lc2
            com.google.android.datatransport.cct.CctBackendFactory r2 = (com.google.android.datatransport.cct.CctBackendFactory) r2     // Catch: java.lang.reflect.InvocationTargetException -> La2 java.lang.NoSuchMethodException -> La6 java.lang.InstantiationException -> Laa java.lang.IllegalAccessException -> Lb6 java.lang.ClassNotFoundException -> Lc2
            return r2
        La2:
            r1.concat(r13)
            goto Ld1
        La6:
            r1.concat(r13)
            goto Ld1
        Laa:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r13)
            r2.append(r0)
            goto Ld1
        Lb6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r13)
            r2.append(r0)
            goto Ld1
        Lc2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Class "
            r0.<init>(r1)
            r0.append(r13)
            java.lang.String r13 = " is not found."
            r0.append(r13)
        Ld1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0084t0.i(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public C0378A k() {
        Object obj = ((C0681f) ((C0682g) this.f664b).a()).f6335a;
        if (!(obj instanceof C0680e)) {
            obj = ((c1.g) obj).f3879a;
        }
        Throwable a2 = C0681f.a(obj);
        if (a2 != null) {
            E1.b.l(a2);
        }
        if (obj instanceof C0680e) {
            obj = null;
        }
        return (C0378A) obj;
    }

    public void l(R1.k kVar) {
        HashMap hashMap = (HashMap) this.f663a;
        R1.l lVar = new R1.l(kVar.f1996a, S1.f.class);
        if (hashMap.containsKey(lVar)) {
            R1.k kVar2 = (R1.k) hashMap.get(lVar);
            if (kVar2.equals(kVar) && kVar.equals(kVar2)) {
                return;
            }
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + lVar);
        }
        hashMap.put(lVar, kVar);
    }

    public void m(K1.n nVar) {
        HashMap hashMap = (HashMap) this.f664b;
        if (nVar != null) {
            Class c4 = nVar.c();
            if (hashMap.containsKey(c4)) {
                K1.n nVar2 = (K1.n) hashMap.get(c4);
                if (nVar2.equals(nVar) && nVar.equals(nVar2)) {
                    return;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + c4);
            }
            hashMap.put(c4, nVar);
            return;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        F1.q qVar = (F1.q) this.f663a;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f664b;
        synchronized (qVar.f757f) {
            qVar.f756e.remove(taskCompletionSource);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x006a, code lost:
    
        if (r4 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0084t0(G0.l r49) {
        /*
            Method dump skipped, instructions count: 1817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0084t0.<init>(G0.l):void");
    }

    public C0084t0(Context context, int i) {
        String str;
        String str2 = null;
        switch (i) {
            case 7:
                this.f664b = null;
                this.f663a = context;
                return;
            default:
                byte[] bArr = {0, 40, 107, -99, 45, -12, -94};
                byte[] bArr2 = new byte[8];
                bArr2[0] = 76;
                bArr2[1] = 119;
                bArr2[2] = -17;
                int i3 = (((-1911911497) - ((~(~C0084t0.class.getName().length())) | (-1911911496))) | 2075653879) - 2075653879;
                int length = C0084t0.class.getName().length() & 21004288;
                bArr2[(-2057725653) ^ ((((((C0084t0.class.getName().length() & (~length)) & 17928224) + 17928224) + length) - ((length | C0084t0.class.getName().length()) & 17928224)) + i3)] = 1;
                bArr2[4] = 72;
                long j2 = 637024660;
                long j3 = ~C0084t0.class.getName().length();
                long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
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
                int length2 = C0084t0.class.getName().length() & (-905963864);
                bArr2[5] = 299878432 ^ ((((~length2) & 536875424) + length2) + (((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) & (-836753908)));
                bArr2[6] = -42;
                bArr2[7] = 20;
                f(bArr, bArr2);
                kotlin.jvm.internal.j.e(context, new String(bArr, StandardCharsets.UTF_8).intern());
                try {
                    str = a(context);
                } catch (Exception unused) {
                    str = null;
                }
                this.f663a = str;
                try {
                    AssetManager assets = context.getAssets();
                    byte[] bArr3 = {17, 91, 111, -23, 89, -122};
                    f(bArr3, new byte[]{102, 104, 6, -32, 45, -11, 69, -126});
                    InputStream open = assets.open(new String(bArr3, StandardCharsets.UTF_8).intern());
                    try {
                        kotlin.jvm.internal.j.b(open);
                        String obj = N2.f.e0(E1.b.y(new BufferedReader(new InputStreamReader(open, N2.a.f1508a), UserMetadata.MAX_INTERNAL_KEY_SIZE))).toString();
                        open.close();
                        str2 = obj;
                    } finally {
                    }
                } catch (Exception unused2) {
                }
                this.f664b = str2;
                return;
        }
    }

    public C0084t0(c1.c cVar) {
        this.f663a = cVar;
        this.f664b = T.b.A(new R.U(this, 3));
    }

    public C0084t0() {
        this.f663a = new HashMap();
        this.f664b = new HashMap();
    }

    public C0084t0(R1.m mVar) {
        this.f663a = new HashMap(mVar.f2000a);
        this.f664b = new HashMap(mVar.f2001b);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [k0.L, java.lang.Object] */
    public C0084t0(k0.M m4) {
        this.f663a = m4;
        ?? obj = new Object();
        obj.f5197a = 0;
        this.f664b = obj;
    }
}
