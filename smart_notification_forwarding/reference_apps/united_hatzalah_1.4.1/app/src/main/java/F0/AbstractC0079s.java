package F0;

import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0079s {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f650a = {"com1", "Com1", "cOm1", "COm1", "coM1", "CoM1", "cOM1", "COM1", "com2", "Com2", "cOm2", "COm2", "coM2", "CoM2", "cOM2", "COM2", "com3", "Com3", "cOm3", "COm3", "coM3", "CoM3", "cOM3", "COM3", "com4", "Com4", "cOm4", "COm4", "coM4", "CoM4", "cOM4", "COM4"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f651b = {"LPT5", "lpt6", "Lpt6", "lPt6", "LPt6", "lpT6", "LpT6", "lPT6", "LPT6", "lpt7", "Lpt7", "lPt7", "LPt7", "lpT7", "LpT7", "lPT7", "LPT7", "lpt8", "Lpt8", "lPt8", "LPt8", "lpT8", "LpT8", "lPT8", "LPT8", "lpt9", "Lpt9", "lPt9", "LPt9", "lpT9", "LpT9", "lPT9", "LPT9"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f652c = {"rpt1", "Rpt1", "rPt1", "RPt1", "rpT1", "RpT1", "rPT1", "RPT1", "rpt2", "Rpt2", "rPt2", "RPt2", "rpT2", "RpT2", "rPT2", "RPT2", "rpt3", "Rpt3", "rPt3", "RPt3", "rpT3", "RpT3", "rPT3", "RPT3", "rpt4", "Rpt4", "rPt4", "RPt4", "rpT4", "RpT4", "rPT4", "RPT4"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f653d = {"wlt1", "Wlt1", "wLt1", "WLt1", "wlT1", "WlT1", "wLT1", "WLT1", "wlt2", "Wlt2", "wLt2", "WLt2", "wlT2", "WlT2", "wLT2", "WLT2", "wlt3", "Wlt3", "wLt3", "WLt3", "wlT3", "WlT3", "wLT3", "WLT3", "wlt4", "Wlt4", "wLt4", "WLt4", "wlT4", "WlT4", "wLT4", "WLT4"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f654e = {"fvr1", "Fvr1", "fVr1", "FVt1", "fvR1", "FrV1", "fVR1", "FVR1", "fvr2", "Fvr2", "fVr2", "FVt2", "fvR2", "FrV2", "fVR2", "FVR2", "fvr3", "Fvr3", "fVr3", "FVt3", "fvR3", "FrV3", "fVR3", "FVR3", "fvr4", "Fvr4", "fVr4", "FVt4", "fvR4", "FrV4", "fVR4", "FVR4"};

    /* JADX WARN: Type inference failed for: r1v4, types: [F0.n1, java.lang.Object] */
    public static C0062n1 a(Context context, C0035g2 c0035g2) {
        String str;
        byte[] bArr = {-118, 32, 47, 5, -82, -21, 43};
        d(bArr, new byte[]{-115, 125, -49, -45, -53, -109, 95, 109});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        byte[] bArr2 = {36, 60, 37, -50, 111, 91, 25, 21, -70, 46, 25, 70, -62, 83, -2};
        long j2 = 1204591587;
        long length = (((~AbstractC0079s.class.getName().length()) | (-315003179)) & 136528928) + ((AbstractC0079s.class.getName().length() & 268566560) | (-1341120508));
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j4 = (j3 >>> 48) & 21845;
        long j5 = ((j4 >>> 1) | j4) & 858993459;
        long j6 = ((j5 >>> 2) | j5) & 252645135;
        long j7 = (j3 >>> 32) & 21845;
        long j8 = ((j7 >>> 1) | j7) & 858993459;
        long j9 = ((j8 >>> 2) | j8) & 252645135;
        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
        long j11 = (j3 >>> 16) & 21845;
        long j12 = ((j11 >>> 1) | j11) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = j3 & 21845;
        long j15 = ((j14 >>> 1) | j14) & 858993459;
        long j16 = ((j15 >>> 2) | j15) & 252645135;
        d(bArr2, new byte[]{33, 98, (int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10)), 124, 121, 6, -15, -34, -83, 121, -8, -106, -85, 61, -103});
        kotlin.jvm.internal.j.e(c0035g2, new String(bArr2, charset).intern());
        String packageName = context.getPackageName();
        byte[] bArr3 = new byte[19];
        bArr3[0] = -47;
        bArr3[1] = 90;
        bArr3[2] = -119;
        bArr3[3] = 36;
        bArr3[4] = -38;
        bArr3[5] = -86;
        bArr3[6] = -103;
        bArr3[7] = 78;
        bArr3[8] = 89;
        bArr3[9] = -18;
        bArr3[10] = -59;
        bArr3[11] = 112;
        bArr3[12] = 101;
        bArr3[13] = 27;
        long j17 = -1;
        long length2 = AbstractC0079s.class.getName().length();
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j19 = (j18 >>> 48) & 21845;
        long j20 = ((j19 >>> 1) | j19) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> 32) & 21845;
        long j23 = ((j22 >>> 1) | j22) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << 24);
        long j26 = (j18 >>> 16) & 21845;
        long j27 = ((j26 >>> 1) | j26) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 21845;
        long j30 = ((j29 >>> 1) | j29) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        bArr3[(((((int) ((((j31 >>> 4) | j31) & 16711935) + (((((j28 >>> 4) | j28) & 16711935) << 8) + j25))) | 1780392476) & 1276674162) + (((AbstractC0079s.class.getName().length() | (-67117163)) - (-67117163)) | 272642312)) ^ 1549316468] = 19;
        bArr3[15] = 22;
        bArr3[16] = 67;
        bArr3[17] = -31;
        bArr3[18] = 36;
        int length3 = (((~AbstractC0079s.class.getName().length()) | (-1457840560)) & (-2000156207)) + ((AbstractC0079s.class.getName().length() & 315621761) | 370343936);
        byte a2 = B0.a((~length3) | (-1629812290), (-1629812290) - length3);
        byte length4 = ((((~AbstractC0079s.class.getName().length()) | 1607364283) & 167776802) + ((AbstractC0079s.class.getName().length() & 8400960) | 549462080)) ^ (-717238851);
        int f4 = (AbstractC0008a.f(AbstractC0079s.class, -1) | (-1919271043)) & (-2004831727);
        d(bArr3, new byte[]{-38, 9, a2, -106, length4, -5, 68, -115, 82, -67, 5, -77, 116, D.a(f4, 3, -D1.a(f4, (AbstractC0079s.class.getName().length() & 540574084) | 808976772), 1) ^ (-1195854883), -119, -122, 109, -49, 13});
        kotlin.jvm.internal.j.d(packageName, new String(bArr3, charset).intern());
        String b4 = b(context);
        String c4 = c(context);
        byte length5 = ((((~C0062n1.class.getName().length()) | 138081190) & 1749584067) + ((C0062n1.class.getName().length() & 1681918049) | 67245088)) ^ 1816829139;
        int i = ((~C0062n1.class.getName().length()) | (-749095169)) & 318907168;
        int length6 = C0062n1.class.getName().length();
        byte[] bArr4 = {-40, -16, length5, 65, 62, (i + (((length6 | 539361681) - (length6 ^ 539361681)) | 1612972177)) ^ 1931879324, 79, 37, 83, 16, -50, 92, -118, 113, -59, ((((~C0062n1.class.getName().length()) | (-1318455630)) & (-2104995836)) + ((C0062n1.class.getName().length() & 41943076) | 1358954592)) ^ (-746041293), 22, -43};
        C0062n1.a(bArr4, new byte[]{31, -85, ((((~C0062n1.class.getName().length()) | 2066615103) & 168069224) + ((C0062n1.class.getName().length() & 551600193) | 552091649)) ^ (-720160839), -47, -121, 116, -75, -41, -106, -98, 84, -34, 73, 58, 121, -37, 123, -80});
        Charset charset2 = StandardCharsets.UTF_8;
        new String(bArr4, charset2).intern();
        byte[] bArr5 = new byte[15];
        bArr5[0] = 31;
        bArr5[1] = -24;
        bArr5[2] = -75;
        bArr5[3] = 65;
        bArr5[2041047797 ^ ((((C0062n1.class.getName().length() & 1764108881) | 555780672) + (~(-((AbstractC0008a.f(C0062n1.class, -1) | 315708326) & 1485267121)))) + 1)] = 82;
        bArr5[5] = 26;
        bArr5[6] = -6;
        bArr5[7] = 10;
        bArr5[8] = 8;
        bArr5[9] = -14;
        bArr5[10] = -9;
        bArr5[11] = 91;
        bArr5[2140582585 ^ ((310641280 - ((~(C0062n1.class.getName().length() & 939561524)) | 310641281)) + (((~C0062n1.class.getName().length()) | (-943824629)) & 1829941300))] = 87;
        bArr5[13] = -77;
        bArr5[14] = -63;
        byte[] bArr6 = new byte[15];
        bArr6[0] = -94;
        bArr6[1] = -91;
        bArr6[2] = 87;
        long j32 = -924239772;
        long j33 = ~C0062n1.class.getName().length();
        long b5 = c3.b((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
        long j34 = (b5 >>> 48) & 43690;
        long j35 = ((j34 >>> 2) | (j34 >>> 1)) & 858993459;
        long j36 = ((j35 >>> 2) | j35) & 252645135;
        long j37 = (b5 >>> 32) & 43690;
        long j38 = ((j37 >>> 2) | (j37 >>> 1)) & 858993459;
        long j39 = ((j38 >>> 2) | j38) & 252645135;
        long j40 = ((((j39 >>> 4) | j39) & 16711935) << 16) + ((((j36 >>> 4) | j36) & 16711935) << 24);
        long j41 = (b5 >>> 16) & 43690;
        long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
        long j43 = ((j42 >>> 2) | j42) & 252645135;
        long j44 = b5 & 43690;
        long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
        long j46 = ((j45 >>> 2) | j45) & 252645135;
        int length7 = (((int) ((((j46 >>> 4) | j46) & 16711935) | ((((j43 >>> 4) | j43) & 16711935) << 8) | j40)) & 1285603492) + (((C0062n1.class.getName().length() | (-67684553)) + 67684553) | (-2146952888));
        bArr6[(length7 | (-861349393)) - (length7 & (-861349393))] = -12;
        bArr6[4] = -124;
        bArr6[5] = 104;
        bArr6[6] = 26;
        bArr6[7] = 4;
        bArr6[8] = -33;
        bArr6[((((~C0062n1.class.getName().length()) | 1777130734) & 1412990632) + ((C0062n1.class.getName().length() & 1007704576) | 683694084)) ^ 2096684709] = -74;
        bArr6[10] = 6;
        bArr6[11] = -48;
        bArr6[12] = 62;
        bArr6[13] = -35;
        bArr6[14] = -90;
        C0062n1.a(bArr5, bArr6);
        kotlin.jvm.internal.j.e(c0035g2, new String(bArr5, charset2).intern());
        ?? obj = new Object();
        obj.f586a = packageName;
        obj.f587b = b4;
        obj.f588c = c4;
        obj.f590e = c0035g2.q();
        G0.l lVar = ((C0051k2) c0035g2.f526b).f557a;
        String[] strArr = {lVar.f827a};
        obj.f591f = strArr;
        String[] strArr2 = lVar.f830d;
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        obj.f592g = strArr2;
        long j47 = -1;
        long length8 = C0062n1.class.getName().length();
        long j48 = (((((((((j47 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j47 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j47 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j47 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j49 = (j48 >>> 48) & 21845;
        long j50 = (j49 | (j49 >>> 1)) & 858993459;
        long j51 = (j50 | (j50 >>> 2)) & 252645135;
        long j52 = (j48 >>> 32) & 21845;
        long j53 = (j52 | (j52 >>> 1)) & 858993459;
        long j54 = (j53 | (j53 >>> 2)) & 252645135;
        long j55 = (((j51 | (j51 >>> 4)) & 16711935) << 24) | (((j54 | (j54 >>> 4)) & 16711935) << 16);
        long j56 = (j48 >>> 16) & 21845;
        long j57 = (j56 | (j56 >>> 1)) & 858993459;
        long j58 = (j57 | (j57 >>> 2)) & 252645135;
        long j59 = j48 & 21845;
        long j60 = (j59 | (j59 >>> 1)) & 858993459;
        long j61 = (j60 | (j60 >>> 2)) & 252645135;
        if (((((((int) (((j61 | (j61 >>> 4)) & 16711935) + (j55 | (((j58 | (j58 >>> 4)) & 16711935) << 8)))) | 1404304240) & (-939408220)) + ((C0062n1.class.getName().length() & (-1475869562)) | 537397266)) ^ (-402010953)) != 0) {
            str = strArr[0];
        } else {
            str = null;
        }
        obj.f589d = str;
        return obj;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public static java.lang.String b(android.content.Context r33) {
        /*
            Method dump skipped, instructions count: 1296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.AbstractC0079s.b(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0340, code lost:
    
        if (r2 != 0) goto L42;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0119. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0009. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r29) {
        /*
            Method dump skipped, instructions count: 980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.AbstractC0079s.c(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
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
}
