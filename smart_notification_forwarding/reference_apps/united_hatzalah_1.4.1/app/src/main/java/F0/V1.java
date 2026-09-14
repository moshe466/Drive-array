package F0;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class V1 {
    public static int a(byte b4, ArrayList arrayList, int i) {
        arrayList.add(Byte.valueOf(b4));
        return i + 1;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public static final boolean b(android.content.pm.ApplicationInfo r36) {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.V1.b(android.content.pm.ApplicationInfo):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x004d. Please report as an issue. */
    public static final boolean c(ApplicationInfo applicationInfo, Context context) {
        Object obj;
        boolean z3;
        int i;
        boolean z4;
        long j2;
        long j3;
        char c4 = 61065;
        AppOpsManager appOpsManager = null;
        Object obj2 = null;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            AppOpsManager appOpsManager2 = null;
            while (true) {
                switch (c4) {
                    case 47391:
                        c4 = 64855;
                    case 15193:
                        return false;
                    case 712:
                        c4 = 33254;
                        z6 = false;
                    case 63101:
                        break;
                    case 57012:
                        byte[] bArr = {39, -35, 14, -27, 8, -31, -64, 44, -2, 38, 104, -69, -70, 77, -122, 111, 55, -103, 61, -104, -67};
                        byte[] bArr2 = new byte[21];
                        bArr2[0] = 70;
                        bArr2[1] = -77;
                        bArr2[2] = 106;
                        int i3 = ((~V1.class.getName().length()) | 800304054) & 2297349;
                        long j4 = 553911297;
                        obj = obj2;
                        z3 = z5;
                        long length = V1.class.getName().length();
                        long j5 = ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j6 = (j5 >>> 48) & 43690;
                        long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
                        long j8 = ((j7 >>> 2) | j7) & 252645135;
                        long j9 = (j5 >>> 32) & 43690;
                        long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                        long j11 = ((j10 >>> 2) | j10) & 252645135;
                        long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
                        long j13 = (j5 >>> 16) & 43690;
                        long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                        long j15 = ((j14 >>> 2) | j14) & 252645135;
                        long j16 = j5 & 43690;
                        long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                        long j18 = ((j17 >>> 2) | j17) & 252645135;
                        try {
                            bArr2[824692228 ^ (i3 + (((int) ((((((j15 >>> 4) | j15) & 16711935) << 8) + j12) | (((j18 >>> 4) | j18) & 16711935))) | 822394882))] = -105;
                            bArr2[4] = 103;
                            bArr2[5] = -120;
                            bArr2[6] = -92;
                            bArr2[7] = 22;
                            bArr2[8] = -109;
                            bArr2[9] = 73;
                            bArr2[10] = 11;
                            bArr2[11] = -48;
                            bArr2[12] = -27;
                            int i4 = ~V1.class.getName().length();
                            i = (((-1147675096) | i4) + 15869978) - (i4 | (-1141375430));
                            long j19 = 536985856;
                            z4 = z6;
                            long length2 = V1.class.getName().length() & 6381586;
                            long j20 = (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
                            j2 = ((((j30 >>> 4) | j30) & 16711935) << 8) + j27;
                            long j31 = j20 & 43690;
                            long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                            j3 = (j32 | (j32 >>> 2)) & 252645135;
                        } catch (Throwable unused) {
                            z4 = z6;
                            obj2 = obj;
                            c4 = 19051;
                            z6 = z4;
                            z5 = z3;
                        }
                        try {
                            bArr2[13] = 552855867 ^ (i + ((int) (((j3 | (j3 >>> 4)) & 16711935) | j2)));
                            int i5 = ((~V1.class.getName().length()) | (-643246195)) & (-1039155132);
                            long j33 = 562040336;
                            long length3 = V1.class.getName().length() & 579273280;
                            long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                            long j35 = (j34 >>> 48) & 43690;
                            long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                            long j37 = ((j36 >>> 2) | j36) & 252645135;
                            long j38 = (j34 >>> 32) & 43690;
                            long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                            long j40 = ((j39 >>> 2) | j39) & 252645135;
                            long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
                            long j42 = (j34 >>> 16) & 43690;
                            long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
                            long j44 = ((j43 >>> 2) | j43) & 252645135;
                            long j45 = j34 & 43690;
                            long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                            long j47 = ((j46 >>> 2) | j46) & 252645135;
                            int i6 = (int) ((((j47 >>> 4) | j47) & 16711935) + (((((j44 >>> 4) | j44) & 16711935) << 8) | j41));
                            int i7 = -i5;
                            bArr2[(-477114790) ^ (((~i7) & i6) - (i7 & (~i6)))] = -23;
                            bArr2[15] = 12;
                            bArr2[16] = 86;
                            bArr2[17] = -19;
                            bArr2[18] = 84;
                            bArr2[19] = -9;
                            bArr2[20] = -45;
                            d(bArr, bArr2);
                            if (appOpsManager.checkOpNoThrow(new String(bArr, StandardCharsets.UTF_8).intern(), applicationInfo.uid, applicationInfo.packageName) == 0) {
                                c4 = 49385;
                            } else {
                                c4 = 712;
                            }
                            z6 = z4;
                            obj2 = obj;
                        } catch (Throwable unused2) {
                            obj2 = obj;
                            c4 = 19051;
                            z6 = z4;
                            z5 = z3;
                        }
                        z5 = z3;
                    case 3692:
                        c4 = 64855;
                        z5 = false;
                    case 42324:
                        try {
                            appOpsManager2 = (AppOpsManager) obj2;
                            c4 = 16803;
                        } catch (Throwable unused3) {
                            c4 = 19051;
                        }
                    case 64855:
                        return z5;
                    case 49385:
                        c4 = 33254;
                        z6 = true;
                    case 33254:
                        c4 = 47391;
                        z5 = z6;
                    case 10006:
                        try {
                            byte[] bArr3 = {57, -52, -40, -115, -122, 90};
                            long j48 = 1882647684;
                            long length4 = (((~V1.class.getName().length()) | 1578558063) & 540470272) + ((V1.class.getName().length() & 1881148448) | 1342177445);
                            long j49 = (((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j50 = (j49 >>> 48) & 21845;
                            long j51 = ((j50 >>> 1) | j50) & 858993459;
                            long j52 = ((j51 >>> 2) | j51) & 252645135;
                            long j53 = (j49 >>> 32) & 21845;
                            long j54 = ((j53 >>> 1) | j53) & 858993459;
                            long j55 = ((j54 >>> 2) | j54) & 252645135;
                            long j56 = ((((j55 >>> 4) | j55) & 16711935) << 16) + ((((j52 >>> 4) | j52) & 16711935) << 24);
                            long j57 = (j49 >>> 16) & 21845;
                            long j58 = ((j57 >>> 1) | j57) & 858993459;
                            long j59 = ((j58 >>> 2) | j58) & 252645135;
                            long j60 = j49 & 21845;
                            long j61 = ((j60 >>> 1) | j60) & 858993459;
                            long j62 = ((j61 >>> 2) | j61) & 252645135;
                            d(bArr3, new byte[]{88, -68, -88, -30, -10, 41, -37, (int) ((((j62 >>> 4) | j62) & 16711935) | ((((j59 >>> 4) | j59) & 16711935) << 8) | j56)});
                            obj2 = context.getSystemService(new String(bArr3, StandardCharsets.UTF_8).intern());
                            try {
                                if (obj2 instanceof AppOpsManager) {
                                    c4 = 42324;
                                } else {
                                    c4 = 63101;
                                }
                            } catch (Throwable unused4) {
                                z3 = z5;
                                z4 = z6;
                                c4 = 19051;
                                z6 = z4;
                                z5 = z3;
                            }
                        } catch (Throwable unused5) {
                            obj = obj2;
                            z3 = z5;
                            z4 = z6;
                            obj2 = obj;
                            c4 = 19051;
                            z6 = z4;
                            z5 = z3;
                        }
                    case 61065:
                        byte[] bArr4 = {-90, 18, -28, 71, 39, 89};
                        byte[] bArr5 = new byte[8];
                        bArr5[0] = -102;
                        bArr5[1] = 102;
                        int i8 = ((~V1.class.getName().length()) | (-8513459)) & 555986340;
                        long j63 = -1006632886;
                        long length5 = V1.class.getName().length() & 1073849832;
                        long b4 = c3.b((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                        long j64 = (b4 >>> 48) & 43690;
                        long j65 = ((j64 >>> 2) | (j64 >>> 1)) & 858993459;
                        long j66 = ((j65 >>> 2) | j65) & 252645135;
                        long j67 = (b4 >>> 32) & 43690;
                        long j68 = ((j67 >>> 2) | (j67 >>> 1)) & 858993459;
                        long j69 = ((j68 >>> 2) | j68) & 252645135;
                        long j70 = ((((j69 >>> 4) | j69) & 16711935) << 16) + ((((j66 >>> 4) | j66) & 16711935) << 24);
                        long j71 = (b4 >>> 16) & 43690;
                        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
                        long j73 = ((j72 >>> 2) | j72) & 252645135;
                        long j74 = b4 & 43690;
                        long j75 = ((j74 >>> 2) | (j74 >>> 1)) & 858993459;
                        long j76 = ((j75 >>> 2) | j75) & 252645135;
                        bArr5[(-450646548) ^ (i8 + ((int) ((((j76 >>> 4) | j76) & 16711935) | (((((j73 >>> 4) | j73) & 16711935) << 8) | j70))))] = -116;
                        bArr5[3] = 46;
                        bArr5[4] = 84;
                        bArr5[5] = 103;
                        bArr5[6] = -88;
                        bArr5[7] = -108;
                        d(bArr4, bArr5);
                        Charset charset = StandardCharsets.UTF_8;
                        kotlin.jvm.internal.j.e(applicationInfo, new String(bArr4, charset).intern());
                        long j77 = -1810909835;
                        long j78 = ~V1.class.getName().length();
                        long b5 = c3.b((((((((j77 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j77 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j77 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j77 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j78 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j78 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j78 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j78 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                        long j79 = (b5 >>> 48) & 43690;
                        long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
                        long j81 = ((j80 >>> 2) | j80) & 252645135;
                        long j82 = (b5 >>> 32) & 43690;
                        long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                        long j84 = ((j83 >>> 2) | j83) & 252645135;
                        long j85 = ((((j84 >>> 4) | j84) & 16711935) << 16) + ((((j81 >>> 4) | j81) & 16711935) << 24);
                        long j86 = (b5 >>> 16) & 43690;
                        long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                        long j88 = ((j87 >>> 2) | j87) & 252645135;
                        long j89 = b5 & 43690;
                        long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                        long j91 = ((j90 >>> 2) | j90) & 252645135;
                        int length6 = (((int) ((((j91 >>> 4) | j91) & 16711935) | (((((j88 >>> 4) | j88) & 16711935) << 8) + j85))) & 1234567728) + ((V1.class.getName().length() & 1234223616) | 268492800);
                        byte[] bArr6 = {84, 46, -22, -12, 105, -87, (length6 + 1503060577) - ((length6 & 1503060577) * 2)};
                        d(bArr6, new byte[]{55, 65, -124, Byte.MIN_VALUE, 12, -47, 37, -10});
                        kotlin.jvm.internal.j.e(context, new String(bArr6, charset).intern());
                        c4 = 10006;
                    case 16803:
                        if (appOpsManager2 == null) {
                            c4 = 15193;
                        } else {
                            c4 = 57012;
                        }
                        appOpsManager = appOpsManager2;
                    default:
                        c4 = 3692;
                }
            }
            c4 = 16803;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void d(byte[] bArr, byte[] bArr2) {
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
