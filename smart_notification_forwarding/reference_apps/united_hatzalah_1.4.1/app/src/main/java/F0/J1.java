package F0;

import android.R;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class J1 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0054l1 f232f;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    static {
        /*
            Method dump skipped, instructions count: 1474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.J1.<clinit>():void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J1(C0093v1 c0093v1, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = {125, ((((~J1.class.getName().length()) | 556645204) & 385915012) + ((J1.class.getName().length() & 369434752) | 352257)) ^ (-386267332), 67, -25, 74, -105};
        byte[] bArr2 = new byte[8];
        bArr2[0] = -6;
        bArr2[1] = 5;
        bArr2[2] = 15;
        bArr2[3] = -103;
        bArr2[4] = 47;
        bArr2[((((~J1.class.getName().length()) | (-1463661389)) & 1610703489) + ((J1.class.getName().length() & 1343300096) | 270270464)) ^ 1880973956] = -27;
        bArr2[6] = -44;
        bArr2[7] = 54;
        y(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        byte[] bArr3 = new byte[8];
        bArr3[0] = -64;
        int i = ((~J1.class.getName().length()) | (-561347165)) & (-2079710846);
        int length = J1.class.getName().length() & 28224;
        long j2 = -2070253613;
        long j3 = 9457233 + length + (((-length) - 1) | (-9457233)) + i;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        long j16 = (j15 | (j15 >>> 1)) & 858993459;
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        bArr3[(int) (((j17 | (j17 >>> 4)) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11))] = -28;
        long j18 = 444611840;
        long j19 = (~J1.class.getName().length()) | (-650122698);
        long j20 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
        bArr3[(((int) ((((j33 >>> 4) | j33) & 16711935) + (((((j30 >>> 4) | j30) & 16711935) << 8) | j27))) + ((J1.class.getName().length() & 646976768) | 605552640)) ^ 1050164482] = 30;
        bArr3[3] = 17;
        long j34 = -109964285;
        long j35 = ~J1.class.getName().length();
        long j36 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j50 = -843353658;
        long length2 = (((int) ((((j49 >>> 4) | j49) & 16711935) | ((((j46 >>> 4) | j46) & 16711935) << 8) | j43)) & (-1003400894)) + ((J1.class.getName().length() & 227230144) | 160047232);
        long j51 = (((((((((j50 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j50 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j50 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j50 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        bArr3[(int) ((((j64 >>> 4) | j64) & 16711935) + (((((j61 >>> 4) | j61) & 16711935) << 8) | j58))] = -84;
        bArr3[5] = 7;
        bArr3[6] = -16;
        bArr3[7] = -36;
        byte[] bArr4 = new byte[8];
        long j65 = 1568120942;
        long j66 = ~J1.class.getName().length();
        long j67 = (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j68 = (j67 >>> 48) & 43690;
        long j69 = ((j68 >>> 2) | (j68 >>> 1)) & 858993459;
        long j70 = (j69 | (j69 >>> 2)) & 252645135;
        long j71 = (j67 >>> 32) & 43690;
        long j72 = ((j71 >>> 2) | (j71 >>> 1)) & 858993459;
        long j73 = ((j72 >>> 2) | j72) & 252645135;
        long j74 = (((j70 | (j70 >>> 4)) & 16711935) << 24) | ((((j73 >>> 4) | j73) & 16711935) << 16);
        long j75 = (j67 >>> 16) & 43690;
        long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
        long j77 = ((j76 >>> 2) | j76) & 252645135;
        long j78 = j67 & 43690;
        long j79 = ((j78 >>> 2) | (j78 >>> 1)) & 858993459;
        long j80 = (j79 | (j79 >>> 2)) & 252645135;
        long j81 = 306356304;
        long j82 = (int) (((j80 | (j80 >>> 4)) & 16711935) + ((((j77 >>> 4) | j77) & 16711935) << 8) + j74);
        long j83 = (((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j82 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j82 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j82 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j82 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j84 = (j83 >>> 48) & 43690;
        long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
        long j86 = (j85 | (j85 >>> 2)) & 252645135;
        long j87 = (j83 >>> 32) & 43690;
        long j88 = ((j87 >>> 2) | (j87 >>> 1)) & 858993459;
        long j89 = ((j88 >>> 2) | j88) & 252645135;
        long j90 = ((((j89 >>> 4) | j89) & 16711935) << 16) + (((j86 | (j86 >>> 4)) & 16711935) << 24);
        long j91 = (j83 >>> 16) & 43690;
        long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
        long j93 = ((j92 >>> 2) | j92) & 252645135;
        long j94 = ((((j93 >>> 4) | j93) & 16711935) << 8) | j90;
        long j95 = j83 & 43690;
        long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
        long j97 = (j96 | (j96 >>> 2)) & 252645135;
        long j98 = -2113912430;
        long length3 = J1.class.getName().length();
        long j99 = ((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j98 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j100 = (j99 >>> 48) & 43690;
        long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
        long j102 = ((j101 >>> 2) | j101) & 252645135;
        long j103 = (j99 >>> 32) & 43690;
        long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
        long j105 = ((j104 >>> 2) | j104) & 252645135;
        long j106 = ((((j105 >>> 4) | j105) & 16711935) << 16) | ((((j102 >>> 4) | j102) & 16711935) << 24);
        long j107 = (j99 >>> 16) & 43690;
        long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
        long j109 = ((j108 >>> 2) | j108) & 252645135;
        long j110 = j99 & 43690;
        long j111 = ((j110 >>> 2) | (j110 >>> 1)) & 858993459;
        long j112 = (j111 | (j111 >>> 2)) & 252645135;
        int i3 = ~(((int) (((j112 | (j112 >>> 4)) & 16711935) | (((((j109 >>> 4) | j109) & 16711935) << 8) + j106))) | (-1543487102));
        int i4 = -((int) (((j97 | (j97 >>> 4)) & 16711935) + j94));
        bArr4[V2.a(~i4, i3, (i3 + i4) + 1) ^ (-1237130798)] = -101;
        bArr4[1] = -79;
        bArr4[2] = 105;
        bArr4[3] = -117;
        bArr4[4] = -63;
        bArr4[5] = -98;
        bArr4[6] = -119;
        bArr4[7] = -53;
        y(bArr3, bArr4);
        new String(bArr3, charset).intern();
        byte[] bArr5 = {41, -23, 55, -37, 37, 105};
        A(bArr5, new byte[]{69, -122, 80, -68, 64, 27, -51, 87});
        new String(bArr5, charset).intern();
        byte[] bArr6 = {Byte.MIN_VALUE, -14, 48, -82, 103, -123, -66, 49};
        A(bArr6, new byte[]{-14, -105, 81, -51, 19, -20, -47, 95});
        new String(bArr6, charset).intern();
        this.f232f = c0054l1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    public static void A(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~J1.class.getName().length();
        int length3 = (((~(((J1.class.getName().length() | 70245657) | i7) - (i7 | (J1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((J1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(J1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((J1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~J1.class.getName().length()) | (-576567005)) & 276971586) + ((J1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~J1.class.getName().length()) | (-1157759625)) & 1755853004) + ((J1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~J1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = J1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~J1.class.getName().length()) | (-1064961)) + 689325073) + ((J1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~J1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = J1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~J1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (J1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((J1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~J1.class.getName().length();
                    int length11 = (161497089 & (((((J1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((J1.class.getName().length() | i14) & 797295576))) + ((J1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~J1.class.getName().length()) | (-1085986263)) & 1078327440) + ((J1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~J1.class.getName().length();
                    int length12 = length5 >>> ((((~(((J1.class.getName().length() | 626856794) | i15) - ((J1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((J1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~J1.class.getName().length()) | 1248713193) & 826417528) + ((J1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~J1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (J1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~J1.class.getName().length()) | (-1005965450)) & 153223237) + ((J1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((J1.class.getName().length() & (~length6)) & i9)) + ((J1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~J1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((J1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~J1.class.getName().length()) | (-23496740)) & 827084804) + ((J1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~J1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (J1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~J1.class.getName().length()) | (-961655275)) & 25184460) + ((J1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~J1.class.getName().length()) | 1233459797) & 125923146) + ((J1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~J1.class.getName().length()) | (-7107622)) & 402932290) + ((J1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((J1.class.getName().length() | length15) - (b4 | length15)) + I2.a(J1.class, b4) + (J1.class.getName().length() & length15);
                    int length17 = ((((~J1.class.getName().length()) | (-81143879)) & 438583424) + ((J1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~J1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((J1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(J1.class, 568748773 | i24) + (J1.class.getName().length() & (-2105278367)))) + ((J1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~J1.class.getName().length()) | (-1592082969)) & 140665109) + ((J1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~J1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((J1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~J1.class.getName().length()) | (-180811308));
                    int length19 = (J1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((J1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | J1.class.getName().length()))));
                    int i29 = ((~J1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (J1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~J1.class.getName().length()) | 75364313) & 1242301609) + ((J1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = J1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((J1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~J1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((J1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~J1.class.getName().length();
                    int length24 = 1409942802 & (((((J1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | J1.class.getName().length()) & 91135407));
                    int length25 = (J1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~J1.class.getName().length()) | (-537919489)) - (-806798471)) + ((J1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~J1.class.getName().length()) | (-382746167)) & 102532165) + ((J1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~J1.class.getName().length()) | (-6036961)) & 1233145505) + ((J1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~J1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = J1.class.getName().length() & 268460041;
                    i5 = (((((J1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | J1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = J1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((J1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~J1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((J1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~J1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (J1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(J1.class, -1) | (-532481)) - (-67641369)) + ((J1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~J1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((J1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(J1.class, -1) | (-33554434)) - (-1107366402)) + ((J1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(J1.class, -1) | (-167014194)) & 1157999680) + ((J1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = J1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((J1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(J1.class, -1) | 114408723) & 1183666176;
                    int length33 = J1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~J1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = J1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~J1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (J1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~J1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((J1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~J1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (J1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~J1.class.getName().length()) | 991120067) & (-2113137661)) + ((J1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(J1.class, -1) | 314136709) & 371231304) + (((J1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~J1.class.getName().length()) | 366661365) & 1344150018) + ((J1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~J1.class.getName().length()) | (-1359635359)) & 49026131) + ((J1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~J1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = J1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (J1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~J1.class.getName().length()) | 1110430873) & 1241612298) + ((J1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~J1.class.getName().length()) | 1603962366) & 25199440) + (((J1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~J1.class.getName().length()) | (-1388708984)) & 706816128) + ((J1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~J1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = J1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~J1.class.getName().length()) | 2113158628) & 1026558002) + ((J1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~J1.class.getName().length()) | 715175224) & 136512788) + ((J1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~J1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = J1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~J1.class.getName().length()) | (-1084937228)) & 438503696) + ((J1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~J1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((J1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(J1.class, 1197735420 | i53) + (J1.class.getName().length() & 674349280))) + ((J1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~J1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (J1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~J1.class.getName().length()) | (-171976913)) & 318775824) + ((J1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~J1.class.getName().length()) | (-616910267)) & 1303391760) + ((J1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~J1.class.getName().length()) | 1297715640) & 556926729) + ((J1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~J1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((J1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~J1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (J1.class.getName().length() & 44040224) | (-1811807712)), 1);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v97, types: [java.lang.Object, java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r4v98, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v99 */
    public final boolean B() {
        boolean z3;
        Charset charset;
        String intern;
        byte[] bArr;
        char c4 = 12966;
        ?? r4 = 0;
        boolean z4 = false;
        while (true) {
            if (c4 == 52664) {
                z3 = z4;
                c4 = 46853;
                r4 = r4;
            } else if (c4 == 42453) {
                r4 = (Throwable) r4;
                c4 = 46853;
                z4 = false;
            } else {
                if (c4 == 46853) {
                    return z4;
                }
                if (c4 != 12966) {
                    c4 = 52664;
                } else {
                    try {
                        byte[] bArr2 = new byte[35];
                        long j2 = 1971358779;
                        long j3 = ~J1.class.getName().length();
                        try {
                            long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
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
                            bArr2[0] = ((((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) & (-665778152)) + ((J1.class.getName().length() & (-1991180286)) | 50348162)) ^ 615429919;
                            bArr2[1] = ((((~J1.class.getName().length()) | (-953768935)) & 1702905052) + ((J1.class.getName().length() & (-1601650489)) | (-2145812477))) ^ (-442907424);
                            bArr2[2] = -119;
                            bArr2[3] = 69;
                            bArr2[4] = 58;
                            bArr2[5] = 62;
                            bArr2[6] = -75;
                            bArr2[7] = 27;
                            bArr2[8] = -101;
                            bArr2[9] = 14;
                            long j17 = -1;
                            long length = J1.class.getName().length();
                            long j18 = (((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                            long j19 = (((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                            long j20 = (((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j21 = (((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j22 = (j21 | (j20 + (j19 | j18))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j23 = (j22 >>> 48) & 21845;
                            long j24 = ((j23 >>> 1) | j23) & 858993459;
                            long j25 = ((j24 >>> 2) | j24) & 252645135;
                            long j26 = (j22 >>> 32) & 21845;
                            long j27 = ((j26 >>> 1) | j26) & 858993459;
                            long j28 = ((j27 >>> 2) | j27) & 252645135;
                            long j29 = ((((j28 >>> 4) | j28) & 16711935) << 16) | ((((j25 >>> 4) | j25) & 16711935) << 24);
                            long j30 = (j22 >>> 16) & 21845;
                            long j31 = ((j30 >>> 1) | j30) & 858993459;
                            long j32 = ((j31 >>> 2) | j31) & 252645135;
                            long j33 = j22 & 21845;
                            long j34 = ((j33 >>> 1) | j33) & 858993459;
                            long j35 = ((j34 >>> 2) | j34) & 252645135;
                            int length2 = J1.class.getName().length();
                            bArr2[10] = (((((int) ((((j35 >>> 4) | j35) & 16711935) + (((((j32 >>> 4) | j32) & 16711935) << 8) | j29))) | 252087079) & 35603700) + (((length2 + 1660113) - (length2 | 1660113)) | 604016641)) ^ 639620304;
                            bArr2[11] = 84;
                            bArr2[12] = -125;
                            bArr2[13] = -18;
                            bArr2[14] = 84;
                            int length3 = (((~J1.class.getName().length()) | (-441868466)) & 379851786) + ((J1.class.getName().length() & 306462720) | 1078116672);
                            bArr2[E1.a(length3 | 1457968453, 1457968453, length3)] = 115;
                            bArr2[16] = 47;
                            bArr2[17] = -64;
                            int length4 = (-1) - J1.class.getName().length();
                            bArr2[18] = ((1082402063 - ((~((J1.class.getName().length() | (-1320337)) - (-1320337))) | 1082402064)) + ((~(((J1.class.getName().length() | (-1042510140)) | length4) - ((J1.class.getName().length() & 1042510139) | length4))) & 940589226)) ^ 2022991336;
                            bArr2[19] = -121;
                            bArr2[20] = 121;
                            bArr2[21] = 120;
                            bArr2[22] = 122;
                            bArr2[23] = 66;
                            bArr2[24] = 111;
                            bArr2[25] = 28;
                            bArr2[26] = 8;
                            bArr2[27] = -49;
                            bArr2[28] = 23;
                            bArr2[29] = -23;
                            bArr2[30] = -107;
                            bArr2[31] = -61;
                            int i = ((~J1.class.getName().length()) | (-2049123061)) & 145035326;
                            int length5 = (J1.class.getName().length() & 673776180) | 554213888;
                            bArr2[(((length5 | i) * 2) - (length5 ^ i)) ^ 699249182] = 111;
                            bArr2[33] = 48;
                            bArr2[((((~J1.class.getName().length()) | (-203784353)) & 1347473412) + ((J1.class.getName().length() & 33851392) | 36506112)) ^ 1383979558] = 91;
                            byte[] bArr3 = new byte[35];
                            bArr3[0] = 9;
                            bArr3[1] = 56;
                            bArr3[2] = 85;
                            bArr3[3] = 28;
                            bArr3[4] = 31;
                            bArr3[5] = 111;
                            long j36 = -644924882;
                            long length6 = (((~J1.class.getName().length()) | (-898868498)) & (-662099960)) + ((J1.class.getName().length() & 277029376) | 17175072);
                            long j37 = (((((((((j36 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j38 = (j37 >>> 48) & 21845;
                            long j39 = ((j38 >>> 1) | j38) & 858993459;
                            long j40 = ((j39 >>> 2) | j39) & 252645135;
                            long j41 = (j37 >>> 32) & 21845;
                            long j42 = ((j41 >>> 1) | j41) & 858993459;
                            long j43 = ((j42 >>> 2) | j42) & 252645135;
                            long j44 = ((((j43 >>> 4) | j43) & 16711935) << 16) + ((((j40 >>> 4) | j40) & 16711935) << 24);
                            long j45 = (j37 >>> 16) & 21845;
                            long j46 = ((j45 >>> 1) | j45) & 858993459;
                            long j47 = ((j46 >>> 2) | j46) & 252645135;
                            long j48 = j37 & 21845;
                            long j49 = ((j48 >>> 1) | j48) & 858993459;
                            long j50 = ((j49 >>> 2) | j49) & 252645135;
                            bArr3[(int) ((((((j47 >>> 4) | j47) & 16711935) << 8) + j44) | (((j50 >>> 4) | j50) & 16711935))] = -105;
                            bArr3[7] = 16;
                            bArr3[8] = -47;
                            bArr3[9] = 41;
                            bArr3[10] = 1;
                            bArr3[11] = -125;
                            bArr3[12] = -36;
                            bArr3[13] = 93;
                            bArr3[14] = -90;
                            bArr3[((((~J1.class.getName().length()) | 89184939) & 72392872) + ((J1.class.getName().length() & 50601984) | 52709377)) ^ 125102246] = -45;
                            bArr3[16] = -78;
                            bArr3[17] = 18;
                            bArr3[18] = 72;
                            bArr3[19] = -127;
                            bArr3[20] = ((((~J1.class.getName().length()) | 235846484) & (-1873947644)) + ((J1.class.getName().length() & (-1807662063)) | 101711889)) ^ (-1772235773);
                            bArr3[21] = -120;
                            bArr3[22] = -49;
                            bArr3[23] = -92;
                            int i3 = ~J1.class.getName().length();
                            int i4 = (~(((J1.class.getName().length() | (-941270520)) | i3) - ((J1.class.getName().length() & 941270519) | i3))) & (-1567355887);
                            z3 = z4;
                            long j51 = -2103162874;
                            long length7 = J1.class.getName().length();
                            long j52 = (((((((((j51 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j51 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j51 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j51 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                            try {
                                bArr3[(-1431024625) ^ (i4 + (((int) ((((((j62 >>> 4) | j62) & 16711935) << 8) + j59) | (((j65 >>> 4) | j65) & 16711935))) | 136331270))] = -51;
                                bArr3[25] = 113;
                                bArr3[26] = 83;
                                bArr3[27] = 9;
                                bArr3[28] = 25;
                                bArr3[29] = -64;
                                bArr3[30] = -124;
                                long j66 = 271327648;
                                long j67 = (-709744008) - ((~(~J1.class.getName().length())) | (-709744007));
                                long j68 = (((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j67 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j67 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j67 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j67 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                                long j69 = (j68 >>> 48) & 43690;
                                long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                                long j71 = ((j70 >>> 2) | j70) & 252645135;
                                long j72 = (j68 >>> 32) & 43690;
                                long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
                                long j74 = ((j73 >>> 2) | j73) & 252645135;
                                long j75 = ((((j74 >>> 4) | j74) & 16711935) << 16) | ((((j71 >>> 4) | j71) & 16711935) << 24);
                                long j76 = (j68 >>> 16) & 43690;
                                long j77 = ((j76 >>> 2) | (j76 >>> 1)) & 858993459;
                                long j78 = ((j77 >>> 2) | j77) & 252645135;
                                long j79 = ((((j78 >>> 4) | j78) & 16711935) << 8) + j75;
                                long j80 = j68 & 43690;
                                long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
                                long j82 = (j81 | (j81 >>> 2)) & 252645135;
                                int i5 = (int) (((j82 | (j82 >>> 4)) & 16711935) | j79);
                                int length8 = J1.class.getName().length();
                                long j83 = 1073872962;
                                long j84 = (786818 | length8) - (length8 ^ 786818);
                                long b5 = c3.b((((((((j83 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j83 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j83 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j83 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j84 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j84 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j84 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j84 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
                                long j85 = (b5 >>> 48) & 43690;
                                long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                                long j87 = ((j86 >>> 2) | j86) & 252645135;
                                long j88 = (b5 >>> 32) & 43690;
                                long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                                long j90 = ((j89 >>> 2) | j89) & 252645135;
                                long j91 = ((((j90 >>> 4) | j90) & 16711935) << 16) + ((((j87 >>> 4) | j87) & 16711935) << 24);
                                long j92 = (b5 >>> 16) & 43690;
                                long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                                long j94 = ((j93 >>> 2) | j93) & 252645135;
                                long j95 = b5 & 43690;
                                long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                                long j97 = ((j96 >>> 2) | j96) & 252645135;
                                int i6 = i5 + ((int) ((((j97 >>> 4) | j97) & 16711935) + ((((j94 >>> 4) | j94) & 16711935) << 8) + j91));
                                long j98 = 1345200637;
                                long j99 = i6;
                                long j100 = (((((((((j98 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j98 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j98 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j98 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                                long j101 = (j100 >>> 48) & 21845;
                                long j102 = ((j101 >>> 1) | j101) & 858993459;
                                long j103 = ((j102 >>> 2) | j102) & 252645135;
                                long j104 = (j100 >>> 32) & 21845;
                                long j105 = ((j104 >>> 1) | j104) & 858993459;
                                long j106 = ((j105 >>> 2) | j105) & 252645135;
                                long j107 = ((((j106 >>> 4) | j106) & 16711935) << 16) | ((((j103 >>> 4) | j103) & 16711935) << 24);
                                long j108 = (j100 >>> 16) & 21845;
                                long j109 = ((j108 >>> 1) | j108) & 858993459;
                                long j110 = ((j109 >>> 2) | j109) & 252645135;
                                long j111 = j100 & 21845;
                                long j112 = ((j111 >>> 1) | j111) & 858993459;
                                long j113 = ((j112 >>> 2) | j112) & 252645135;
                                bArr3[(int) ((((j113 >>> 4) | j113) & 16711935) + (((((j110 >>> 4) | j110) & 16711935) << 8) | j107))] = -95;
                                bArr3[32] = ((((~J1.class.getName().length()) | 981822172) & 1673789794) + ((J1.class.getName().length() & 1161863474) | 67151889)) ^ (-1740941618);
                                bArr3[33] = -29;
                                bArr3[34] = 7;
                                k(bArr2, bArr3);
                                charset = StandardCharsets.UTF_8;
                                Class<?> cls = Class.forName(new String(bArr2, charset).intern());
                                byte[] bArr4 = new byte[12];
                                bArr4[0] = -54;
                                bArr4[1] = -127;
                                bArr4[2] = -98;
                                bArr4[3] = 88;
                                long length9 = J1.class.getName().length();
                                long j114 = (j21 | (j19 + j18 + j20)) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                                long j115 = (j114 >>> 48) & 21845;
                                long j116 = ((j115 >>> 1) | j115) & 858993459;
                                long j117 = ((j116 >>> 2) | j116) & 252645135;
                                long j118 = (j114 >>> 32) & 21845;
                                long j119 = ((j118 >>> 1) | j118) & 858993459;
                                long j120 = ((j119 >>> 2) | j119) & 252645135;
                                long j121 = ((((j120 >>> 4) | j120) & 16711935) << 16) | ((((j117 >>> 4) | j117) & 16711935) << 24);
                                long j122 = (j114 >>> 16) & 21845;
                                long j123 = ((j122 >>> 1) | j122) & 858993459;
                                long j124 = ((j123 >>> 2) | j123) & 252645135;
                                long j125 = ((((j124 >>> 4) | j124) & 16711935) << 8) + j121;
                                long j126 = j114 & 21845;
                                long j127 = (j126 | (j126 >>> 1)) & 858993459;
                                long j128 = (j127 | (j127 >>> 2)) & 252645135;
                                int i7 = (((int) (((j128 | (j128 >>> 4)) & 16711935) | j125)) | (-1110492642)) & 96923652;
                                long j129 = 536986248;
                                long length10 = J1.class.getName().length();
                                long j130 = (((((((((j129 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j129 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j129 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j129 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length10 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length10 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length10 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length10 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                                long j131 = (j130 >>> 48) & 43690;
                                long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
                                long j133 = ((j132 >>> 2) | j132) & 252645135;
                                long j134 = (j130 >>> 32) & 43690;
                                long j135 = ((j134 >>> 2) | (j134 >>> 1)) & 858993459;
                                long j136 = ((j135 >>> 2) | j135) & 252645135;
                                long j137 = ((((j136 >>> 4) | j136) & 16711935) << 16) + ((((j133 >>> 4) | j133) & 16711935) << 24);
                                long j138 = (j130 >>> 16) & 43690;
                                long j139 = ((j138 >>> 2) | (j138 >>> 1)) & 858993459;
                                long j140 = ((j139 >>> 2) | j139) & 252645135;
                                long j141 = j130 & 43690;
                                long j142 = ((j141 >>> 2) | (j141 >>> 1)) & 858993459;
                                long j143 = ((j142 >>> 2) | j142) & 252645135;
                                bArr4[(i7 + (((int) ((((j143 >>> 4) | j143) & 16711935) + (((((j140 >>> 4) | j140) & 16711935) << 8) + j137))) | 571017866)) ^ 667941514] = -6;
                                bArr4[5] = -48;
                                bArr4[6] = -24;
                                bArr4[7] = 101;
                                bArr4[8] = 84;
                                bArr4[9] = -74;
                                bArr4[10] = 92;
                                bArr4[11] = 38;
                                try {
                                    k(bArr4, new byte[]{16, 93, 99, 116, -85, 1, -96, -46, 50, -31, 87, -41});
                                    new String(bArr4, charset).intern();
                                    int i8 = ((~J1.class.getName().length()) | (-285214785)) + 1493207489;
                                    long j144 = 285218880;
                                    long length11 = J1.class.getName().length();
                                    long j145 = ((((((((j144 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j144 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j144 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j144 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                    long j146 = (j145 >>> 48) & 43690;
                                    long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
                                    long j148 = ((j147 >>> 2) | j147) & 252645135;
                                    long j149 = (j145 >>> 32) & 43690;
                                    long j150 = ((j149 >>> 2) | (j149 >>> 1)) & 858993459;
                                    long j151 = ((j150 >>> 2) | j150) & 252645135;
                                    long j152 = ((((j151 >>> 4) | j151) & 16711935) << 16) | ((((j148 >>> 4) | j148) & 16711935) << 24);
                                    long j153 = (j145 >>> 16) & 43690;
                                    long j154 = ((j153 >>> 2) | (j153 >>> 1)) & 858993459;
                                    long j155 = ((j154 >>> 2) | j154) & 252645135;
                                    long j156 = j145 & 43690;
                                    long j157 = ((j156 >>> 2) | (j156 >>> 1)) & 858993459;
                                    long j158 = ((j157 >>> 2) | j157) & 252645135;
                                    byte[] bArr5 = {(i8 + (((int) ((((j158 >>> 4) | j158) & 16711935) | (((((j155 >>> 4) | j155) & 16711935) << 8) | j152))) | 542126084)) ^ (-2035333627), 98, 77, 30, 6, 88, 31, 116, 53, -58, -114, 104, 60, -78, 99, 39, -4, -82, -116, -2, 20, -77};
                                    byte[] bArr6 = new byte[22];
                                    bArr6[0] = 96;
                                    bArr6[1] = -41;
                                    bArr6[2] = 113;
                                    bArr6[3] = 103;
                                    bArr6[4] = 31;
                                    int i9 = ~J1.class.getName().length();
                                    bArr6[5] = ((((J1.class.getName().length() | 86212888) - (i9 | (-41966755))) + ((((-41999523) | i9) - J1.class.getName().length()) + (J1.class.getName().length() & 86212888))) + ((J1.class.getName().length() & 49312) | 1351108770)) ^ 1437321669;
                                    bArr6[6] = -127;
                                    bArr6[7] = 7;
                                    bArr6[((((J1.class.getName().length() & 35852352) + 268965953) + (((-r12) - 1) | (-268965953))) + (((~J1.class.getName().length()) | 2107382661) & 1109852545)) ^ 1378818505] = 79;
                                    bArr6[9] = 14;
                                    bArr6[10] = 14;
                                    bArr6[11] = -34;
                                    bArr6[12] = 88;
                                    bArr6[13] = -9;
                                    bArr6[14] = -59;
                                    bArr6[15] = -115;
                                    bArr6[16] = -81;
                                    bArr6[17] = 32;
                                    bArr6[18] = 50;
                                    bArr6[19] = -41;
                                    bArr6[20] = 18;
                                    bArr6[21] = 122;
                                    k(bArr5, bArr6);
                                    try {
                                        r4 = cls.getMethod(new String(bArr5, charset).intern(), null);
                                        byte[] bArr7 = new byte[14];
                                        bArr7[0] = -123;
                                        int i10 = ((~J1.class.getName().length()) | 846430961) & 36192484;
                                        int length12 = (J1.class.getName().length() & 9125900) | 1149435912;
                                        bArr7[1185628397 ^ (((length12 | i10) - ((J1.class.getName().length() & (~i10)) & length12)) + ((J1.class.getName().length() | i10) & length12))] = -96;
                                        bArr7[2] = 2;
                                        bArr7[3] = 74;
                                        bArr7[4] = 51;
                                        bArr7[5] = 81;
                                        bArr7[6] = -108;
                                        bArr7[7] = 48;
                                        bArr7[8] = -98;
                                        bArr7[9] = 93;
                                        bArr7[10] = -65;
                                        bArr7[11] = 56;
                                        bArr7[12] = ((((~J1.class.getName().length()) | (-91442813)) & 1644167491) + ((J1.class.getName().length() & 14688832) | 15245824)) ^ (-1659413302);
                                        bArr7[13] = -127;
                                        byte[] bArr8 = new byte[14];
                                        long j159 = -380272667;
                                        long j160 = ~J1.class.getName().length();
                                        long j161 = (((((((((j159 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j159 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j159 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j159 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j160 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j160 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j160 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j160 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
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
                                        int i11 = (int) ((((j174 >>> 4) | j174) & 16711935) + (((((j171 >>> 4) | j171) & 16711935) << 8) | j168));
                                        long j175 = 638226722;
                                        long j176 = i11;
                                        long j177 = ((((((((j175 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j175 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j175 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j175 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j176 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j176 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j176 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j176 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                                        long j178 = (j177 >>> 48) & 43690;
                                        long j179 = ((j178 >>> 2) | (j178 >>> 1)) & 858993459;
                                        long j180 = ((j179 >>> 2) | j179) & 252645135;
                                        long j181 = (j177 >>> 32) & 43690;
                                        long j182 = ((j181 >>> 2) | (j181 >>> 1)) & 858993459;
                                        long j183 = ((j182 >>> 2) | j182) & 252645135;
                                        long j184 = ((((j183 >>> 4) | j183) & 16711935) << 16) + ((((j180 >>> 4) | j180) & 16711935) << 24);
                                        long j185 = (j177 >>> 16) & 43690;
                                        long j186 = ((j185 >>> 2) | (j185 >>> 1)) & 858993459;
                                        long j187 = ((j186 >>> 2) | j186) & 252645135;
                                        long j188 = j177 & 43690;
                                        long j189 = ((j188 >>> 2) | (j188 >>> 1)) & 858993459;
                                        long j190 = ((j189 >>> 2) | j189) & 252645135;
                                        int i12 = (int) ((((j190 >>> 4) | j190) & 16711935) | (((((j187 >>> 4) | j187) & 16711935) << 8) + j184));
                                        int length13 = J1.class.getName().length();
                                        long j191 = 271589377;
                                        long j192 = (102400002 + length13) - (length13 | 102400002);
                                        long b6 = c3.b((((((((j191 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j191 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j191 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j191 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j192 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j192 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j192 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j192 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                                        long j193 = (b6 >>> 48) & 43690;
                                        long j194 = ((j193 >>> 2) | (j193 >>> 1)) & 858993459;
                                        long j195 = ((j194 >>> 2) | j194) & 252645135;
                                        long j196 = (b6 >>> 32) & 43690;
                                        long j197 = ((j196 >>> 2) | (j196 >>> 1)) & 858993459;
                                        long j198 = ((j197 >>> 2) | j197) & 252645135;
                                        long j199 = ((((j198 >>> 4) | j198) & 16711935) << 16) + ((((j195 >>> 4) | j195) & 16711935) << 24);
                                        long j200 = (b6 >>> 16) & 43690;
                                        long j201 = ((j200 >>> 2) | (j200 >>> 1)) & 858993459;
                                        long j202 = ((j201 >>> 2) | j201) & 252645135;
                                        long j203 = b6 & 43690;
                                        long j204 = ((j203 >>> 2) | (j203 >>> 1)) & 858993459;
                                        long j205 = ((j204 >>> 2) | j204) & 252645135;
                                        bArr8[(i12 + ((int) ((((j205 >>> 4) | j205) & 16711935) + (((((j202 >>> 4) | j202) & 16711935) << 8) | j199)))) ^ 909816099] = -82;
                                        bArr8[1] = -88;
                                        bArr8[2] = -89;
                                        bArr8[3] = -110;
                                        bArr8[4] = 108;
                                        bArr8[5] = 94;
                                        bArr8[6] = 1;
                                        bArr8[7] = -14;
                                        bArr8[8] = -9;
                                        bArr8[9] = 113;
                                        bArr8[10] = Byte.MIN_VALUE;
                                        bArr8[11] = -96;
                                        bArr8[12] = 2;
                                        bArr8[13] = -113;
                                        k(bArr7, bArr8);
                                        kotlin.jvm.internal.j.d(r4, new String(bArr7, charset).intern());
                                        try {
                                            r4.invoke(null, null);
                                            byte[] bArr9 = new byte[26];
                                            bArr9[0] = -22;
                                            bArr9[1] = -28;
                                            bArr9[2] = 69;
                                            bArr9[3] = -77;
                                            int i13 = ((~J1.class.getName().length()) | 2080892012) & (-2145255306);
                                            int length14 = (J1.class.getName().length() | 1071644653) - 1071644653;
                                            bArr9[4] = (i13 + (~(((J1.class.getName().length() | (-1207959562)) | length14) - (length14 | (J1.class.getName().length() & 1207959561))))) ^ 937295816;
                                            bArr9[5] = 92;
                                            bArr9[6] = 16;
                                            bArr9[7] = -26;
                                            bArr9[8] = -98;
                                            bArr9[9] = -96;
                                            bArr9[10] = -125;
                                            bArr9[11] = 98;
                                            bArr9[12] = -5;
                                            bArr9[13] = -80;
                                            bArr9[14] = -13;
                                            bArr9[15] = 107;
                                            bArr9[16] = 99;
                                            bArr9[17] = 35;
                                            bArr9[18] = 122;
                                            bArr9[19] = 35;
                                            long j206 = 851579908;
                                            long j207 = (~J1.class.getName().length()) | (-561630001);
                                            long j208 = ((((((((j206 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j206 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j206 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j206 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j207 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j207 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j207 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j207 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                            long j209 = (j208 >>> 48) & 43690;
                                            long j210 = ((j209 >>> 2) | (j209 >>> 1)) & 858993459;
                                            long j211 = (j210 | (j210 >>> 2)) & 252645135;
                                            long j212 = (j208 >>> 32) & 43690;
                                            long j213 = ((j212 >>> 2) | (j212 >>> 1)) & 858993459;
                                            long j214 = ((j213 >>> 2) | j213) & 252645135;
                                            long j215 = (((j211 | (j211 >>> 4)) & 16711935) << 24) | ((((j214 >>> 4) | j214) & 16711935) << 16);
                                            long j216 = (j208 >>> 16) & 43690;
                                            long j217 = ((j216 >>> 2) | (j216 >>> 1)) & 858993459;
                                            long j218 = ((j217 >>> 2) | j217) & 252645135;
                                            long j219 = j208 & 43690;
                                            long j220 = ((j219 >>> 2) | (j219 >>> 1)) & 858993459;
                                            long j221 = (j220 | (j220 >>> 2)) & 252645135;
                                            int length15 = J1.class.getName().length();
                                            bArr9[(((int) (((j221 | (j221 >>> 4)) & 16711935) | (j215 | ((((j218 >>> 4) | j218) & 16711935) << 8)))) + ((-2080366053) | (((J1.class.getName().length() | 541073922) - (length15 | 541073922)) + ((length15 - J1.class.getName().length()) + (J1.class.getName().length() & 541073922))))) ^ (-1228786165)] = -109;
                                            bArr9[21] = -35;
                                            bArr9[22] = 4;
                                            bArr9[23] = 108;
                                            bArr9[24] = -112;
                                            bArr9[25] = 10;
                                            byte[] bArr10 = new byte[26];
                                            bArr10[0] = 21;
                                            bArr10[1] = 110;
                                            bArr10[2] = -11;
                                            bArr10[3] = 48;
                                            bArr10[4] = 23;
                                            bArr10[5] = ((((-1525702817) | ((-1) - J1.class.getName().length())) & 1148551466) + ((J1.class.getName().length() & 1081606176) | 25706641)) ^ (-1174258050);
                                            bArr10[6] = -71;
                                            bArr10[7] = 47;
                                            bArr10[8] = 62;
                                            long j222 = 291749721;
                                            long length16 = (((~J1.class.getName().length()) | 1891849762) & 16955216) + (((J1.class.getName().length() | (-287353169)) + 287353169) | 274794496);
                                            long j223 = ((((((((j222 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j222 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j222 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j222 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + (((((((((length16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                            long j224 = (j223 >>> 48) & 21845;
                                            long j225 = (j224 | (j224 >>> 1)) & 858993459;
                                            long j226 = (j225 | (j225 >>> 2)) & 252645135;
                                            long j227 = (j223 >>> 32) & 21845;
                                            long j228 = ((j227 >>> 1) | j227) & 858993459;
                                            long j229 = ((j228 >>> 2) | j228) & 252645135;
                                            long j230 = (((j226 | (j226 >>> 4)) & 16711935) << 24) | ((((j229 >>> 4) | j229) & 16711935) << 16);
                                            long j231 = (j223 >>> 16) & 21845;
                                            long j232 = ((j231 >>> 1) | j231) & 858993459;
                                            long j233 = ((j232 >>> 2) | j232) & 252645135;
                                            long j234 = j223 & 21845;
                                            long j235 = (j234 | (j234 >>> 1)) & 858993459;
                                            long j236 = (j235 | (j235 >>> 2)) & 252645135;
                                            bArr10[(int) (((j236 | (j236 >>> 4)) & 16711935) | j230 | ((((j233 >>> 4) | j233) & 16711935) << 8))] = 97;
                                            bArr10[10] = 83;
                                            int i14 = ((~J1.class.getName().length()) | 302683733) & (-1803143104);
                                            int length17 = J1.class.getName().length();
                                            bArr10[11] = (i14 + (17826052 | (((J1.class.getName().length() | (-2054936316)) - (length17 | (-2054936316))) + ((length17 - J1.class.getName().length()) + (J1.class.getName().length() & (-2054936316)))))) ^ (-1785317074);
                                            bArr10[12] = -92;
                                            bArr10[13] = 106;
                                            int length18 = ((-37828275) | ((-1) - J1.class.getName().length())) & (-1668804590);
                                            int length19 = (J1.class.getName().length() & 1069586) | 542130689;
                                            bArr10[(-1126673891) ^ ((length19 & length18) + (length18 | length19))] = -63;
                                            bArr10[15] = ((((~J1.class.getName().length()) | (-1770535809)) & 1174438936) + ((J1.class.getName().length() & 1073743872) | 268978693)) ^ 1443417645;
                                            bArr10[16] = 16;
                                            bArr10[17] = -51;
                                            bArr10[18] = 109;
                                            bArr10[19] = -9;
                                            bArr10[20] = -39;
                                            int i15 = ((~J1.class.getName().length()) | 1358059956) & (-1860020064);
                                            int length20 = (J1.class.getName().length() & (-2063588603)) | 71312213;
                                            bArr10[21] = 1788707880 ^ ((length20 & i15) + (i15 | length20));
                                            bArr10[22] = 76;
                                            bArr10[23] = -42;
                                            bArr10[24] = 17;
                                            bArr10[25] = -27;
                                            k(bArr9, bArr10);
                                            intern = new String(bArr9, charset).intern();
                                            bArr = new byte[4];
                                            int i16 = ~J1.class.getName().length();
                                            bArr[0] = (((~(((J1.class.getName().length() | (-1933419707)) | i16) - (i16 | (J1.class.getName().length() & 1933419706)))) & 169175042) + ((J1.class.getName().length() & 144852996) | 547487812)) ^ 716662841;
                                            long j237 = 1979562223;
                                            long j238 = ~J1.class.getName().length();
                                            long b7 = c3.b((((((((j237 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j237 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j237 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j237 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)), ((((((((j238 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j238 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j238 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j238 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                                            long j239 = (b7 >>> 48) & 43690;
                                            long j240 = ((j239 >>> 2) | (j239 >>> 1)) & 858993459;
                                            long j241 = (j240 | (j240 >>> 2)) & 252645135;
                                            long j242 = (b7 >>> 32) & 43690;
                                            long j243 = ((j242 >>> 2) | (j242 >>> 1)) & 858993459;
                                            long j244 = ((j243 >>> 2) | j243) & 252645135;
                                            long j245 = ((((j244 >>> 4) | j244) & 16711935) << 16) + (((j241 | (j241 >>> 4)) & 16711935) << 24);
                                            long j246 = (b7 >>> 16) & 43690;
                                            long j247 = ((j246 >>> 2) | (j246 >>> 1)) & 858993459;
                                            long j248 = ((j247 >>> 2) | j247) & 252645135;
                                            long j249 = b7 & 43690;
                                            long j250 = ((j249 >>> 2) | (j249 >>> 1)) & 858993459;
                                            long j251 = (j250 | (j250 >>> 2)) & 252645135;
                                            int i17 = (int) (((j251 | (j251 >>> 4)) & 16711935) + (((((j248 >>> 4) | j248) & 16711935) << 8) | j245));
                                            long j252 = 1682051618;
                                            long j253 = i17;
                                            long j254 = (((((((((j252 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j252 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j252 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j252 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j253 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j253 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j253 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j253 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                            long j255 = (j254 >>> 48) & 43690;
                                            long j256 = ((j255 >>> 2) | (j255 >>> 1)) & 858993459;
                                            long j257 = (j256 | (j256 >>> 2)) & 252645135;
                                            long j258 = (j254 >>> 32) & 43690;
                                            long j259 = ((j258 >>> 2) | (j258 >>> 1)) & 858993459;
                                            long j260 = ((j259 >>> 2) | j259) & 252645135;
                                            long j261 = (((j257 | (j257 >>> 4)) & 16711935) << 24) | ((((j260 >>> 4) | j260) & 16711935) << 16);
                                            long j262 = (j254 >>> 16) & 43690;
                                            long j263 = ((j262 >>> 2) | (j262 >>> 1)) & 858993459;
                                            long j264 = ((j263 >>> 2) | j263) & 252645135;
                                            long j265 = j254 & 43690;
                                            long j266 = ((j265 >>> 2) | (j265 >>> 1)) & 858993459;
                                            long j267 = (j266 | (j266 >>> 2)) & 252645135;
                                            int i18 = (int) (((j267 | (j267 >>> 4)) & 16711935) + ((((j264 >>> 4) | j264) & 16711935) << 8) + j261);
                                            int length21 = (J1.class.getName().length() & 8528396) | (-1837096948);
                                            bArr[(((i18 & length21) * 2) + (length21 ^ i18)) ^ (-155045329)] = 102;
                                            bArr[2] = -64;
                                            bArr[3] = 18;
                                            byte[] bArr11 = new byte[8];
                                            bArr11[0] = -69;
                                            bArr11[1] = -87;
                                            bArr11[2] = 42;
                                            long j268 = -267898808;
                                            long j269 = (~J1.class.getName().length()) | 2022713038;
                                            long j270 = ((((((((j268 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j268 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j268 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j268 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j269 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j269 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j269 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j269 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                                            long j271 = (j270 >>> 48) & 43690;
                                            long j272 = ((j271 >>> 2) | (j271 >>> 1)) & 858993459;
                                            long j273 = (j272 | (j272 >>> 2)) & 252645135;
                                            long j274 = (j270 >>> 32) & 43690;
                                            long j275 = ((j274 >>> 2) | (j274 >>> 1)) & 858993459;
                                            long j276 = ((j275 >>> 2) | j275) & 252645135;
                                            long j277 = (((j273 | (j273 >>> 4)) & 16711935) << 24) | ((((j276 >>> 4) | j276) & 16711935) << 16);
                                            long j278 = (j270 >>> 16) & 43690;
                                            long j279 = ((j278 >>> 2) | (j278 >>> 1)) & 858993459;
                                            long j280 = ((j279 >>> 2) | j279) & 252645135;
                                            long j281 = j270 & 43690;
                                            long j282 = ((j281 >>> 2) | (j281 >>> 1)) & 858993459;
                                            long j283 = (j282 | (j282 >>> 2)) & 252645135;
                                            bArr11[3] = (((int) (((j283 | (j283 >>> 4)) & 16711935) + (j277 | ((((j280 >>> 4) | j280) & 16711935) << 8)))) + ((J1.class.getName().length() & (-2012735439)) | 151013425)) ^ (-116885457);
                                            bArr11[4] = 67;
                                            int length22 = (-1) - J1.class.getName().length();
                                            bArr11[((((414718635 ^ length22) + (414718635 & length22)) & 27333314) + ((J1.class.getName().length() & 1090586704) | 1140984848)) ^ 1168318167] = 112;
                                            long j284 = 1046378747;
                                            long j285 = ~J1.class.getName().length();
                                            long j286 = (((((((((j284 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j284 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j284 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j284 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j285 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j285 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j285 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j285 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                                            long j287 = (j286 >>> 48) & 43690;
                                            long j288 = ((j287 >>> 2) | (j287 >>> 1)) & 858993459;
                                            long j289 = (j288 | (j288 >>> 2)) & 252645135;
                                            long j290 = (j286 >>> 32) & 43690;
                                            long j291 = ((j290 >>> 2) | (j290 >>> 1)) & 858993459;
                                            long j292 = ((j291 >>> 2) | j291) & 252645135;
                                            long j293 = (((j289 | (j289 >>> 4)) & 16711935) << 24) | ((((j292 >>> 4) | j292) & 16711935) << 16);
                                            long j294 = (j286 >>> 16) & 43690;
                                            long j295 = ((j294 >>> 2) | (j294 >>> 1)) & 858993459;
                                            long j296 = ((j295 >>> 2) | j295) & 252645135;
                                            long j297 = j286 & 43690;
                                            long j298 = ((j297 >>> 2) | (j297 >>> 1)) & 858993459;
                                            long j299 = (j298 | (j298 >>> 2)) & 252645135;
                                            bArr11[((((int) (((j299 | (j299 >>> 4)) & 16711935) + (j293 | ((((j296 >>> 4) | j296) & 16711935) << 8)))) & 1614880824) + ((J1.class.getName().length() & 1124140288) | 185075008)) ^ 1799955838] = -56;
                                            bArr11[7] = 23;
                                            k(bArr, bArr11);
                                        } catch (Throwable th) {
                                            th = th;
                                            r4 = th;
                                            c4 = 42453;
                                            z4 = z3;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            z3 = z4;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z3 = z4;
                    }
                    try {
                        t(intern, new String(bArr, charset).intern());
                        z4 = true;
                        c4 = 52664;
                    } catch (Throwable th7) {
                        th = th7;
                        r4 = th;
                        c4 = 42453;
                        z4 = z3;
                    }
                }
            }
            z4 = z3;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00be. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // F0.T2
    public final void a(Context context) {
        int i;
        byte b4;
        char c4;
        Object[] objArr;
        char c5;
        int i3;
        char c6;
        char c7;
        boolean z3 = true;
        int i4 = 2;
        byte b5 = 3;
        char c8 = 4;
        char c9 = 5;
        int i5 = 6;
        byte[] bArr = {100, 73, -67, -2, -59, -41, 119};
        int i6 = ((~J1.class.getName().length()) | 583592608) & 616629536;
        byte[] bArr2 = new byte[D.a(i6, 3, -D1.a(i6, (J1.class.getName().length() & (-2080303740)) | (-2147479412)), 1) ^ (-1530849884)];
        bArr2[0] = 7;
        bArr2[1] = 38;
        bArr2[2] = -45;
        byte b6 = -118;
        bArr2[3] = -118;
        bArr2[4] = -96;
        bArr2[5] = -81;
        bArr2[6] = 3;
        bArr2[7] = -82;
        byte[] bArr3 = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1850458006;
        byte[] bArr4 = null;
        while (true) {
            int i10 = ((i9 & 16777216) * (i9 | 16777216)) + ((i9 & (-16777217)) * ((~i9) & 16777216));
            boolean z4 = z3;
            int i11 = i9 >>> 8;
            int i12 = (i11 - 1) - ((~i10) | i11);
            int i13 = (-1700147435) - ((2028104049 - i12) | (i12 & i4));
            int i14 = -1396193641;
            switch ((-1363443157) ^ ((~i13) + ((i13 | 1) * i4))) {
                case -1940167324:
                    i = i4;
                    b4 = b5;
                    c4 = c8;
                    byte b7 = bArr3[i7];
                    int i15 = ((byte) 0) - b7;
                    bArr3[i7] = (byte) (((byte) (b7 & (~i15))) - ((byte) ((~b7) & i15)));
                    z3 = z4 ? 1 : 0;
                    i9 = 614229416;
                    i4 = i;
                    b5 = b4;
                    c8 = c4;
                case -360299937:
                    int i16 = i4;
                    byte b8 = b5;
                    char c10 = c8;
                    char c11 = c9;
                    int i17 = i5;
                    byte b9 = b6;
                    if ((bArr3[i8] > Double.NaN ? 1 : (bArr3[i8] == Double.NaN ? 0 : -1)) <= -1) {
                        objArr = false;
                    } else {
                        objArr = z4 ? 1 : 0;
                    }
                    if (objArr == false) {
                        i14 = 427928065;
                    }
                    if (objArr != false) {
                        i9 = 614229416;
                    } else {
                        i9 = i14;
                    }
                    i7 = i8;
                    z3 = z4 ? 1 : 0;
                    i4 = i16;
                    b5 = b8;
                    c8 = c10;
                    c9 = c11;
                    i5 = i17;
                    b6 = b9;
                case 399486784:
                    break;
                case 585276366:
                    bArr4 = bArr;
                    bArr3 = bArr2;
                    i8 = 0;
                    z3 = z4 ? 1 : 0;
                    i9 = 1985663266;
                case 1733787683:
                    byte b10 = bArr4[i7];
                    byte b11 = bArr3[i7];
                    i = i4;
                    bArr4[i7] = (byte) (((byte) (b11 + b10)) - ((byte) (((byte) i4) * ((byte) (b11 & b10)))));
                    int i18 = ((i7 & 1) * 2) + (i7 ^ 1);
                    b4 = b5;
                    c4 = c8;
                    i8 = i18;
                    if ((((i18 > bArr4.length ? 1 : (i18 == bArr4.length ? 0 : -1)) >>> 31) & 1) != 0) {
                        z3 = z4 ? 1 : 0;
                        i9 = 1985663266;
                    } else {
                        z3 = z4 ? 1 : 0;
                        i9 = -1396193641;
                    }
                    i4 = i;
                    b5 = b4;
                    c8 = c4;
                default:
                    z3 = z4 ? 1 : 0;
                    i9 = -1396193641;
            }
            int i19 = i4;
            byte b12 = b5;
            char c12 = c8;
            Charset charset = StandardCharsets.UTF_8;
            kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
            C0031f2 n4 = T0.n(new I1(this, 0));
            byte[] bArr5 = new byte[i5];
            // fill-array-data instruction
            bArr5[0] = 11;
            bArr5[1] = 124;
            bArr5[2] = Byte.MAX_VALUE;
            bArr5[3] = -106;
            bArr5[4] = 23;
            bArr5[5] = -17;
            r(bArr5, new byte[]{-112, -23, 33, -54, 123, -101, 73, 49});
            new String(bArr5, charset).intern();
            C0054l1 c0054l1 = this.f232f;
            C0047j2 c0047j2 = c0054l1.f573a;
            c0047j2.m();
            byte[] bArr6 = {36, Byte.MAX_VALUE, 23, 8, -38, -7, -116, -28, 1, -66, 122, -31, -17, -94, 121, 13, 29};
            byte[] bArr7 = new byte[17];
            bArr7[0] = V2.a(231424, -346038315, -346269740) ^ 346269768;
            bArr7[z4 ? 1 : 0] = -19;
            bArr7[i19] = -122;
            bArr7[b12] = 100;
            bArr7[c12] = -64;
            bArr7[c9] = 106;
            bArr7[i5] = b12;
            bArr7[7] = 120;
            bArr7[8] = Byte.MAX_VALUE;
            bArr7[9] = -95;
            bArr7[10] = 42;
            bArr7[11] = -113;
            bArr7[12] = -77;
            bArr7[13] = -95;
            bArr7[14] = 34;
            bArr7[15] = 79;
            bArr7[16] = 110;
            r(bArr6, bArr7);
            d(new String(bArr6, charset).intern(), n4);
            if (n4.b()) {
                c6 = '1';
                byte[] bArr8 = {-50, 73, -35, 121, 31, -118, 115, -41, 82, 14, -19, 81, 76, -87, -41, -7, -108};
                c5 = c9;
                c7 = '0';
                long j2 = -1;
                i3 = i5;
                long j3 = 64;
                long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j5 = (j4 >>> 48) & 21845;
                long j6 = ((j5 >>> (z4 ? 1L : 0L)) | j5) & 858993459;
                long j7 = ((j6 >>> i19) | j6) & 252645135;
                long j8 = (j4 >>> 32) & 21845;
                long j9 = ((j8 >>> (z4 ? 1L : 0L)) | j8) & 858993459;
                long j10 = ((j9 >>> i19) | j9) & 252645135;
                long j11 = ((((j10 >>> c12) | j10) & 16711935) << 16) | ((((j7 >>> c12) | j7) & 16711935) << 24);
                long j12 = (j4 >>> 16) & 21845;
                long j13 = ((j12 >>> (z4 ? 1L : 0L)) | j12) & 858993459;
                long j14 = ((j13 >>> i19) | j13) & 252645135;
                long j15 = j4 & 21845;
                long j16 = ((j15 >>> (z4 ? 1L : 0L)) | j15) & 858993459;
                long j17 = ((j16 >>> i19) | j16) & 252645135;
                byte[] bArr9 = new byte[17];
                bArr9[0] = -72;
                bArr9[z4 ? 1 : 0] = -5;
                bArr9[i19] = -48;
                bArr9[b12] = -13;
                bArr9[c12] = -125;
                bArr9[c5] = -71;
                bArr9[i3] = 40;
                bArr9[7] = b6;
                bArr9[8] = 82;
                bArr9[9] = 49;
                bArr9[10] = -103;
                bArr9[11] = -1;
                bArr9[12] = 86;
                bArr9[13] = -86;
                bArr9[14] = (((((int) ((((j17 >>> c12) | j17) & 16711935) | (((((j14 >>> c12) | j14) & 16711935) << 8) | j11))) | (-1567730085)) & 1895895370) - 2143247232) ^ 247351922;
                bArr9[15] = -125;
                bArr9[16] = -25;
                r(bArr8, bArr9);
                String intern = new String(bArr8, charset).intern();
                c0047j2.m();
                c(intern);
            } else {
                c5 = c9;
                i3 = i5;
                c6 = '1';
                c7 = '0';
            }
            if (n4.a()) {
                Integer m4 = c0047j2.m();
                byte[] bArr10 = {119, -21, 12, 60, -64, 60, -103, 79, -7, 72, 64, -88, 84, 7, 96, -51, 41};
                long j18 = 1766766757;
                long j19 = 1766766763;
                long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << c7) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845))) + (((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << c7) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845)));
                long j21 = (j20 >>> c7) & 21845;
                long j22 = ((j21 >>> (z4 ? 1L : 0L)) | j21) & 858993459;
                long j23 = ((j22 >>> i19) | j22) & 252645135;
                long j24 = (j20 >>> 32) & 21845;
                long j25 = ((j24 >>> (z4 ? 1L : 0L)) | j24) & 858993459;
                long j26 = ((j25 >>> i19) | j25) & 252645135;
                long j27 = ((((j26 >>> c12) | j26) & 16711935) << 16) | ((((j23 >>> c12) | j23) & 16711935) << 24);
                long j28 = (j20 >>> 16) & 21845;
                long j29 = ((j28 >>> (z4 ? 1L : 0L)) | j28) & 858993459;
                long j30 = ((j29 >>> i19) | j29) & 252645135;
                long j31 = j20 & 21845;
                long j32 = (j31 | (j31 >>> (z4 ? 1L : 0L))) & 858993459;
                long j33 = (j32 | (j32 >>> i19)) & 252645135;
                byte b13 = (int) (((j33 | (j33 >>> c12)) & 16711935) | (((((j30 >>> c12) | j30) & 16711935) << 8) + j27));
                long j34 = 1074811398;
                long j35 = 0;
                long j36 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << c7) | ((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 32) | (((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845))) + ((((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << c7) + ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 32) + ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) << 16) + ((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> c6) & 21845) + 6148914691236517205L;
                long j37 = (j36 >>> c7) & 43690;
                long j38 = ((j37 >>> i19) | (j37 >>> (z4 ? 1L : 0L))) & 858993459;
                long j39 = ((j38 >>> i19) | j38) & 252645135;
                long j40 = (j36 >>> 32) & 43690;
                long j41 = ((j40 >>> i19) | (j40 >>> (z4 ? 1L : 0L))) & 858993459;
                long j42 = ((j41 >>> i19) | j41) & 252645135;
                long j43 = ((((j42 >>> c12) | j42) & 16711935) << 16) | ((((j39 >>> c12) | j39) & 16711935) << 24);
                long j44 = (j36 >>> 16) & 43690;
                long j45 = ((j44 >>> i19) | (j44 >>> (z4 ? 1L : 0L))) & 858993459;
                long j46 = ((j45 >>> i19) | j45) & 252645135;
                long j47 = j36 & 43690;
                long j48 = ((j47 >>> i19) | (j47 >>> (z4 ? 1L : 0L))) & 858993459;
                long j49 = (j48 | (j48 >>> i19)) & 252645135;
                byte[] bArr11 = new byte[17];
                bArr11[0] = 47;
                bArr11[z4 ? 1 : 0] = 89;
                bArr11[i19] = Byte.MIN_VALUE;
                bArr11[b12] = 48;
                bArr11[c12] = -54;
                bArr11[c5] = 47;
                bArr11[i3] = b13;
                bArr11[7] = 35;
                bArr11[8] = -89;
                bArr11[9] = -9;
                bArr11[10] = 67;
                bArr11[11] = -56;
                bArr11[12] = 62;
                bArr11[13] = 68;
                bArr11[14] = 43;
                bArr11[15] = (-1176458231) ^ (101646720 + ((int) (((j49 | (j49 >>> c12)) & 16711935) | (((((j46 >>> c12) | j46) & 16711935) << 8) + j43))));
                bArr11[16] = 90;
                r(bArr10, bArr11);
                c0054l1.c(new String(bArr10, charset).intern(), m4);
                return;
            }
            return;
        }
    }
}
