package F0;

import android.content.Context;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.messaging.ServiceStarter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.fork.ForkServer;
import t2.AbstractC0705g;

/* loaded from: classes.dex */
public final class S2 extends Y {
    static {
        byte[] bArr = {-15, -81};
        z(bArr, new byte[]{-4, -91, 9, 1299163239 ^ ((((~S2.class.getName().length()) | (-235901365)) & (-1308618231)) + ((S2.class.getName().length() & 41948160) | 9455008)), 8, -23, -75, 34});
        new String(bArr, StandardCharsets.UTF_8).intern();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String A(InputStream inputStream) {
        byte b4;
        long j2;
        try {
            StringBuilder sb = new StringBuilder();
            byte[] bArr = {122, 55, 24, 0};
            long j3 = -2103266930;
            int i = -1;
            long j4 = -1;
            long j5 = 255;
            long j6 = (((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
            long j7 = (((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
            long j8 = (((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
            long j9 = (((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
            long j10 = (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j9 | j8 | (j7 + j6)) + 6148914691236517205L;
            long j11 = (j10 >>> 48) & 43690;
            int i3 = 2;
            long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
            long j13 = ((j12 >>> 2) | j12) & 252645135;
            long j14 = (j10 >>> 32) & 43690;
            long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
            long j16 = ((j15 >>> 2) | j15) & 252645135;
            long j17 = ((((j16 >>> 4) | j16) & 16711935) << 16) | ((((j13 >>> 4) | j13) & 16711935) << 24);
            long j18 = (j10 >>> 16) & 43690;
            long j19 = ((j18 >>> 2) | (j18 >>> 1)) & 858993459;
            long j20 = ((j19 >>> 2) | j19) & 252645135;
            long j21 = j10 & 43690;
            long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
            long j23 = ((j22 >>> 2) | j22) & 252645135;
            char c4 = 3;
            int i4 = 5;
            r(bArr, new byte[]{-114, 13, (-2019945295) ^ (50856978 + (((int) ((((j23 >>> 4) | j23) & 16711935) + (((((j20 >>> 4) | j20) & 16711935) << 8) | j17))) & (-2070802296))), -15, 87, -117, 21, 65});
            String intern = new String(bArr, StandardCharsets.UTF_8).intern();
            int i5 = -1;
            while (true) {
                int indexOf = sb.indexOf(intern);
                if (indexOf != i && i5 != i) {
                    int length = indexOf + intern.length();
                    if (i5 != 0) {
                        if (length < sb.length() && sb.substring(length).length() >= i5) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                byte[] bArr2 = new byte[1024];
                char c5 = c4;
                int read = inputStream.read(bArr2);
                if (read == i) {
                    break;
                }
                if (read > 0) {
                    byte[] G3 = AbstractC0705g.G(bArr2, 0, read);
                    Charset charset = StandardCharsets.UTF_8;
                    j2 = j5;
                    byte[] bArr3 = new byte[i4];
                    bArr3[0] = 14;
                    bArr3[1] = -111;
                    bArr3[i3] = -82;
                    b4 = i4;
                    bArr3[AbstractC0099x.a(970632238, i3, -970632239) ^ 970632237] = -62;
                    bArr3[4] = -100;
                    r(bArr3, new byte[]{114, -107, -2, -124, -92, 8, 124, 46});
                    kotlin.jvm.internal.j.d(charset, new String(bArr3, charset).intern());
                    sb.append(new String(G3, charset));
                } else {
                    b4 = i4;
                    j2 = j5;
                }
                String sb2 = sb.toString();
                byte[] bArr4 = new byte[13];
                bArr4[0] = 24;
                bArr4[1] = 68;
                bArr4[i3] = 61;
                bArr4[c5] = 26;
                bArr4[4] = 8;
                bArr4[b4] = 92;
                bArr4[6] = 81;
                bArr4[7] = -7;
                bArr4[8] = 106;
                bArr4[9] = -11;
                bArr4[10] = -84;
                bArr4[11] = -34;
                int i6 = i3;
                int i7 = i5;
                long j24 = 281215888;
                long j25 = j7 | j6;
                long j26 = (((((((((j24 >>> 24) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j24 >>> 16) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j24 >>> 8) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j24 & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j8 + j25 + j9;
                long j27 = (j26 >>> 48) & 43690;
                long j28 = ((j27 >>> i6) | (j27 >>> 1)) & 858993459;
                long j29 = ((j28 >>> i6) | j28) & 252645135;
                long j30 = (j26 >>> 32) & 43690;
                long j31 = ((j30 >>> i6) | (j30 >>> 1)) & 858993459;
                long j32 = ((j31 >>> i6) | j31) & 252645135;
                long j33 = ((((j32 >>> 4) | j32) & 16711935) << 16) | ((((j29 >>> 4) | j29) & 16711935) << 24);
                long j34 = (j26 >>> 16) & 43690;
                long j35 = ((j34 >>> i6) | (j34 >>> 1)) & 858993459;
                long j36 = ((j35 >>> i6) | j35) & 252645135;
                long j37 = j26 & 43690;
                long j38 = ((j37 >>> i6) | (j37 >>> 1)) & 858993459;
                long j39 = ((j38 >>> i6) | j38) & 252645135;
                long j40 = -502791136;
                long j41 = j9;
                long j42 = 0;
                long j43 = (((((j42 & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                long j44 = (((((((j42 >>> 8) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                long j45 = (((((((j42 >>> 16) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                long j46 = (((((((j42 >>> 24) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                long j47 = (((((((((j40 >>> 24) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j40 >>> 16) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j40 >>> 8) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j40 & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j46 + j45 + (j44 | j43) + 6148914691236517205L;
                long j48 = (j47 >>> 48) & 43690;
                long j49 = ((j48 >>> i6) | (j48 >>> 1)) & 858993459;
                long j50 = ((j49 >>> i6) | j49) & 252645135;
                long j51 = (j47 >>> 32) & 43690;
                long j52 = ((j51 >>> i6) | (j51 >>> 1)) & 858993459;
                long j53 = ((j52 >>> i6) | j52) & 252645135;
                long j54 = ((((j53 >>> 4) | j53) & 16711935) << 16) | ((((j50 >>> 4) | j50) & 16711935) << 24);
                long j55 = (j47 >>> 16) & 43690;
                long j56 = ((j55 >>> i6) | (j55 >>> 1)) & 858993459;
                long j57 = ((j56 >>> i6) | j56) & 252645135;
                long j58 = j47 & 43690;
                long j59 = ((j58 >>> i6) | (j58 >>> 1)) & 858993459;
                long j60 = (j59 | (j59 >>> i6)) & 252645135;
                bArr4[(((int) ((((j39 >>> 4) | j39) & 16711935) | (((((j36 >>> 4) | j36) & 16711935) << 8) | j33))) + ((int) (((j60 | (j60 >>> 4)) & 16711935) | (((((j57 >>> 4) | j57) & 16711935) << 8) + j54)))) ^ (-221575236)] = -96;
                long j61 = 575048728;
                long j62 = (((((((((j61 >>> 24) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j61 >>> 16) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j61 >>> 8) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j61 & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j41 + (j8 | j25);
                long j63 = (j62 >>> 48) & 43690;
                long j64 = ((j63 >>> i6) | (j63 >>> 1)) & 858993459;
                long j65 = ((j64 >>> i6) | j64) & 252645135;
                long j66 = (j62 >>> 32) & 43690;
                long j67 = ((j66 >>> i6) | (j66 >>> 1)) & 858993459;
                long j68 = ((j67 >>> i6) | j67) & 252645135;
                long j69 = ((((j68 >>> 4) | j68) & 16711935) << 16) | ((((j65 >>> 4) | j65) & 16711935) << 24);
                long j70 = (j62 >>> 16) & 43690;
                long j71 = ((j70 >>> i6) | (j70 >>> 1)) & 858993459;
                long j72 = ((j71 >>> i6) | j71) & 252645135;
                long j73 = j62 & 43690;
                long j74 = ((j73 >>> i6) | (j73 >>> 1)) & 858993459;
                long j75 = ((j74 >>> i6) | j74) & 252645135;
                int i8 = (int) ((((j75 >>> 4) | j75) & 16711935) | ((((j72 >>> 4) | j72) & 16711935) << 8) | j69);
                long j76 = 145248736;
                long b5 = c3.b((((((((j76 >>> 24) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j76 >>> 16) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j76 >>> 8) & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j76 & j2) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), AbstractC0008a.h(j44, j43, j45, j46), 6148914691236517205L);
                long j77 = (b5 >>> 48) & 43690;
                long j78 = ((j77 >>> i6) | (j77 >>> 1)) & 858993459;
                long j79 = ((j78 >>> i6) | j78) & 252645135;
                long j80 = (b5 >>> 32) & 43690;
                long j81 = ((j80 >>> i6) | (j80 >>> 1)) & 858993459;
                long j82 = ((j81 >>> i6) | j81) & 252645135;
                long j83 = ((((j82 >>> 4) | j82) & 16711935) << 16) + ((((j79 >>> 4) | j79) & 16711935) << 24);
                long j84 = (b5 >>> 16) & 43690;
                long j85 = ((j84 >>> i6) | (j84 >>> 1)) & 858993459;
                long j86 = ((j85 >>> i6) | j85) & 252645135;
                long j87 = b5 & 43690;
                long j88 = ((j87 >>> i6) | (j87 >>> 1)) & 858993459;
                long j89 = ((j88 >>> i6) | j88) & 252645135;
                byte b6 = (i8 + ((int) ((((j89 >>> 4) | j89) & 16711935) + (((((j86 >>> 4) | j86) & 16711935) << 8) + j83)))) ^ (-720297349);
                byte[] bArr5 = new byte[13];
                bArr5[0] = b6;
                bArr5[1] = -5;
                bArr5[i6] = -125;
                bArr5[c5] = 85;
                bArr5[4] = -111;
                bArr5[b4] = b4;
                bArr5[6] = 85;
                bArr5[7] = -123;
                bArr5[8] = 89;
                bArr5[9] = -85;
                bArr5[10] = -104;
                bArr5[11] = -41;
                bArr5[12] = -119;
                r(bArr4, bArr5);
                kotlin.jvm.internal.j.d(sb2, new String(bArr4, StandardCharsets.UTF_8).intern());
                Integer C3 = C(sb2);
                if (C3 != null) {
                    i5 = C3.intValue();
                    c4 = c5;
                    j5 = j2;
                    i4 = b4;
                    i3 = i6;
                } else {
                    c4 = c5;
                    j5 = j2;
                    i4 = b4;
                    i3 = i6;
                    i5 = i7;
                }
                j9 = j41;
                i = -1;
            }
            return sb.toString();
        } catch (IOException unused) {
            return null;
        }
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    public static java.lang.Integer C(java.lang.String r50) {
        /*
            Method dump skipped, instructions count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.S2.C(java.lang.String):java.lang.Integer");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0049. Please report as an issue. */
    public static void E(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x007d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    public final boolean B(Context context) {
        Object obj;
        Iterator it;
        List list;
        boolean z3;
        InstrumentationInfo instrumentationInfo;
        Object obj2;
        byte[] bArr;
        boolean z4;
        Object obj3;
        boolean z5;
        byte[] bArr2;
        boolean z6;
        char c4 = 65214;
        boolean z7 = false;
        Object obj4 = null;
        Iterator it2 = null;
        InstrumentationInfo instrumentationInfo2 = null;
        String str = null;
        InstrumentationInfo instrumentationInfo3 = null;
        List list2 = null;
        List list3 = null;
        Object obj5 = null;
        Object obj6 = 0;
        boolean z8 = false;
        List list4 = null;
        boolean z9 = false;
        boolean z10 = false;
        while (true) {
            switch (c4) {
                case 20659:
                    c4 = 45325;
                    str = null;
                case 373:
                    boolean z11 = z7;
                    obj = obj4;
                    it = it2;
                    InstrumentationInfo instrumentationInfo4 = instrumentationInfo3;
                    list = list2;
                    c4 = z11 ? (char) 41701 : (char) 643;
                    instrumentationInfo3 = instrumentationInfo4;
                    z7 = z11;
                    z10 = z7;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 28252:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    list = list2;
                    instrumentationInfo3 = (InstrumentationInfo) obj;
                    c4 = 49615;
                    z7 = z3;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 51405:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    instrumentationInfo = instrumentationInfo3;
                    list = list2;
                    c4 = it.hasNext() ? (char) 43393 : (char) 26182;
                    instrumentationInfo3 = instrumentationInfo;
                    z7 = z3;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 43281:
                    c4 = 25296;
                case 61351:
                    c4 = 20165;
                    list4 = null;
                case 11491:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    instrumentationInfo = instrumentationInfo3;
                    list = list2;
                    try {
                        str = instrumentationInfo2.packageName;
                        c4 = 45325;
                    } catch (Throwable th) {
                        obj5 = th;
                        c4 = 42525;
                        instrumentationInfo3 = instrumentationInfo;
                        z7 = z3;
                        it2 = it;
                        obj4 = obj;
                        obj6 = obj6;
                        list2 = list;
                    }
                    instrumentationInfo3 = instrumentationInfo;
                    z7 = z3;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 45325:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    instrumentationInfo = instrumentationInfo3;
                    list = list2;
                    try {
                        long j2 = -850988612;
                        long j3 = 850988644;
                        long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                        byte b4 = (int) (((j17 | (j17 >>> 4)) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11));
                        bArr = new byte[34];
                        try {
                            bArr[0] = -105;
                            bArr[1] = 38;
                            bArr[2] = 59;
                            bArr[3] = 41;
                            bArr[4] = 36;
                            bArr[5] = 70;
                            bArr[6] = -19;
                            bArr[7] = -40;
                            bArr[8] = 61;
                            bArr[9] = 41;
                            bArr[10] = -102;
                            bArr[11] = 118;
                            bArr[12] = -44;
                            bArr[13] = 108;
                            bArr[14] = -59;
                            bArr[15] = -74;
                            bArr[16] = -34;
                            bArr[17] = -73;
                            bArr[18] = -50;
                            bArr[19] = -59;
                            bArr[20] = 111;
                            bArr[21] = -22;
                            bArr[22] = 61;
                            bArr[23] = 36;
                            bArr[24] = 111;
                            bArr[25] = -39;
                            bArr[26] = -71;
                            bArr[27] = 93;
                            bArr[28] = -96;
                            bArr[29] = 35;
                            bArr[30] = -93;
                            bArr[31] = -23;
                            bArr[32] = b4;
                            bArr[33] = 1;
                            long j18 = -1;
                            long j19 = 0;
                            long j20 = ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j21 = (((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j22 = (((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                            long j23 = (((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                            long j24 = (((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j25 = (((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j26 = (j25 | (j24 + j23 + j22)) + (j21 | j20);
                            long j27 = (j26 >>> 48) & 21845;
                            long j28 = ((j27 >>> 1) | j27) & 858993459;
                            long j29 = ((j28 >>> 2) | j28) & 252645135;
                            long j30 = (j26 >>> 32) & 21845;
                            long j31 = ((j30 >>> 1) | j30) & 858993459;
                            long j32 = ((j31 >>> 2) | j31) & 252645135;
                            long j33 = ((((j32 >>> 4) | j32) & 16711935) << 16) | ((((j29 >>> 4) | j29) & 16711935) << 24);
                            long j34 = (j26 >>> 16) & 21845;
                            long j35 = ((j34 >>> 1) | j34) & 858993459;
                            long j36 = ((j35 >>> 2) | j35) & 252645135;
                            long j37 = ((((j36 >>> 4) | j36) & 16711935) << 8) + j33;
                            long j38 = j26 & 21845;
                            long j39 = ((j38 >>> 1) | j38) & 858993459;
                            long j40 = ((j39 >>> 2) | j39) & 252645135;
                            long j41 = 286845000;
                            long j42 = ((int) ((((j40 >>> 4) | j40) & 16711935) + j37)) | (-1786823168);
                            long j43 = (((((((((j41 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j41 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j41 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j41 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j42 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j42 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j42 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j42 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                            long j44 = (j43 >>> 48) & 43690;
                            long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                            long j46 = ((j45 >>> 2) | j45) & 252645135;
                            long j47 = (j43 >>> 32) & 43690;
                            long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
                            long j49 = ((j48 >>> 2) | j48) & 252645135;
                            long j50 = ((((j49 >>> 4) | j49) & 16711935) << 16) | ((((j46 >>> 4) | j46) & 16711935) << 24);
                            long j51 = (j43 >>> 16) & 43690;
                            long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                            long j53 = ((j52 >>> 2) | j52) & 252645135;
                            long j54 = ((((j53 >>> 4) | j53) & 16711935) << 8) + j50;
                            long j55 = j43 & 43690;
                            long j56 = ((j55 >>> 2) | (j55 >>> 1)) & 858993459;
                            long j57 = (j56 | (j56 >>> 2)) & 252645135;
                            byte b5 = (((int) (((j57 | (j57 >>> 4)) & 16711935) | j54)) - 973012478) ^ (-686167472);
                            long j58 = (j25 | j24 | j23 | j22) + j21 + j20;
                            long j59 = (j58 >>> 48) & 21845;
                            long j60 = ((j59 >>> 1) | j59) & 858993459;
                            long j61 = ((j60 >>> 2) | j60) & 252645135;
                            long j62 = (j58 >>> 32) & 21845;
                            long j63 = ((j62 >>> 1) | j62) & 858993459;
                            long j64 = ((j63 >>> 2) | j63) & 252645135;
                            long j65 = ((((j64 >>> 4) | j64) & 16711935) << 16) + ((((j61 >>> 4) | j61) & 16711935) << 24);
                            long j66 = (j58 >>> 16) & 21845;
                            long j67 = ((j66 >>> 1) | j66) & 858993459;
                            long j68 = ((j67 >>> 2) | j67) & 252645135;
                            long j69 = j58 & 21845;
                            long j70 = ((j69 >>> 1) | j69) & 858993459;
                            long j71 = ((j70 >>> 2) | j70) & 252645135;
                            int i = (int) ((((j71 >>> 4) | j71) & 16711935) + ((((j68 >>> 4) | j68) & 16711935) << 8) + j65);
                            long j72 = 400446675;
                            long j73 = i;
                            long j74 = (((((((((j72 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j72 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j72 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j72 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j73 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j73 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j73 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j73 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
                            byte b6 = ((((int) ((((j87 >>> 4) | j87) & 16711935) + (((((j84 >>> 4) | j84) & 16711935) << 8) + j81))) & 36001987) - 2013231588) ^ (-1977229580);
                            byte[] bArr3 = new byte[34];
                            bArr3[0] = 21;
                            bArr3[1] = b5;
                            bArr3[2] = b6;
                            bArr3[3] = 47;
                            bArr3[4] = 107;
                            bArr3[5] = 6;
                            bArr3[6] = -102;
                            bArr3[7] = -108;
                            bArr3[8] = 103;
                            bArr3[9] = -41;
                            bArr3[10] = 4;
                            bArr3[11] = 7;
                            bArr3[12] = -52;
                            bArr3[13] = -23;
                            bArr3[14] = -58;
                            bArr3[15] = -64;
                            bArr3[16] = -54;
                            bArr3[17] = -90;
                            bArr3[18] = -48;
                            bArr3[19] = -111;
                            bArr3[20] = 52;
                            bArr3[21] = -88;
                            bArr3[22] = 41;
                            bArr3[23] = 62;
                            bArr3[24] = 33;
                            bArr3[25] = 123;
                            bArr3[26] = -27;
                            bArr3[27] = 31;
                            bArr3[28] = -23;
                            bArr3[29] = -35;
                            bArr3[30] = -20;
                            bArr3[31] = 115;
                            bArr3[32] = -85;
                            bArr3[33] = 117;
                            r(bArr, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            obj5 = th;
                            obj2 = obj;
                            z6 = obj6;
                            c4 = 42525;
                            instrumentationInfo3 = instrumentationInfo;
                            z7 = z3;
                            it2 = it;
                            obj4 = obj2;
                            obj6 = z6;
                            list2 = list;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    if (kotlin.jvm.internal.j.a(str, new String(bArr, StandardCharsets.UTF_8).intern())) {
                        c4 = 33845;
                        instrumentationInfo3 = instrumentationInfo;
                        z7 = z3;
                        it2 = it;
                        obj4 = obj;
                        obj6 = obj6;
                        list2 = list;
                    } else {
                        it2 = it;
                        c4 = 51405;
                        instrumentationInfo3 = instrumentationInfo;
                        z7 = z3;
                        obj4 = obj;
                        obj6 = obj6;
                        list2 = list;
                    }
                case 49615:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    InstrumentationInfo instrumentationInfo5 = instrumentationInfo3;
                    list = list2;
                    if (instrumentationInfo5 != null) {
                        c4 = 11491;
                        instrumentationInfo2 = instrumentationInfo5;
                        instrumentationInfo3 = instrumentationInfo2;
                    } else {
                        instrumentationInfo2 = instrumentationInfo5;
                        instrumentationInfo3 = instrumentationInfo2;
                        c4 = 20659;
                    }
                    z7 = z3;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 15821:
                    boolean z12 = z7;
                    Object obj7 = obj4;
                    Iterator it3 = it2;
                    InstrumentationInfo instrumentationInfo6 = instrumentationInfo3;
                    List list5 = list2;
                    c4 = list5 != null ? (char) 42753 : (char) 19860;
                    instrumentationInfo3 = instrumentationInfo6;
                    z7 = z12;
                    it2 = it3;
                    obj4 = obj7;
                    list2 = list5;
                    list3 = list2;
                case 19860:
                    z3 = z7;
                    obj = obj4;
                    instrumentationInfo = instrumentationInfo3;
                    list = list2;
                    it2 = list3.iterator();
                    c4 = 51405;
                    instrumentationInfo3 = instrumentationInfo;
                    z7 = z3;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 42753:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    instrumentationInfo = instrumentationInfo3;
                    list = list2;
                    c4 = list3.isEmpty() ? (char) 23191 : (char) 19860;
                    instrumentationInfo3 = instrumentationInfo;
                    z7 = z3;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 42525:
                    obj5 = (Throwable) obj5;
                    c4 = 25296;
                    z9 = false;
                case 28914:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    instrumentationInfo = instrumentationInfo3;
                    list = list2;
                    try {
                        list4 = obj6;
                        c4 = 20165;
                    } catch (Throwable th4) {
                        obj5 = th4;
                        c4 = 42525;
                        instrumentationInfo3 = instrumentationInfo;
                        z7 = z3;
                        it2 = it;
                        obj4 = obj;
                        obj6 = obj6;
                        list2 = list;
                    }
                    instrumentationInfo3 = instrumentationInfo;
                    z7 = z3;
                    it2 = it;
                    obj4 = obj;
                    obj6 = obj6;
                    list2 = list;
                case 26182:
                case 23191:
                    c4 = 52163;
                    z8 = false;
                case 41701:
                    z3 = z7;
                    obj = obj4;
                    it = it2;
                    try {
                        byte[] bArr4 = {71, 110, 71, 108, 21, -118, 9, -55, -73, 125, -17, 52, 87, -93, 114};
                        r(bArr4, new byte[]{61, -18, 76, -20, 119, -73, 86, -114, -37, -39, -93, 63, 59, -58, 22});
                        Charset charset = StandardCharsets.UTF_8;
                        String intern = new String(bArr4, charset).intern();
                        byte[] bArr5 = {-95, 1, -18, -90};
                        byte[] bArr6 = new byte[8];
                        bArr6[0] = -20;
                        bArr6[1] = 67;
                        bArr6[2] = -79;
                        bArr6[3] = -86;
                        bArr6[4] = -92;
                        bArr6[5] = -4;
                        bArr6[6] = -8;
                        instrumentationInfo = instrumentationInfo3;
                        list = list2;
                        long j88 = 1826270407;
                        long j89 = -1;
                        try {
                            long b7 = c3.b((((((((j88 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j88 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j88 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j88 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j89 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j89 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j89 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j89 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                            long j90 = (b7 >>> 48) & 43690;
                            long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                            long j92 = ((j91 >>> 2) | j91) & 252645135;
                            long j93 = (b7 >>> 32) & 43690;
                            long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                            long j95 = ((j94 >>> 2) | j94) & 252645135;
                            long j96 = ((((j95 >>> 4) | j95) & 16711935) << 16) | ((((j92 >>> 4) | j92) & 16711935) << 24);
                            long j97 = (b7 >>> 16) & 43690;
                            long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                            long j99 = ((j98 >>> 2) | j98) & 252645135;
                            long j100 = b7 & 43690;
                            long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                            long j102 = ((j101 >>> 2) | j101) & 252645135;
                            int i3 = ((int) ((((j102 >>> 4) | j102) & 16711935) + (((((j99 >>> 4) | j99) & 16711935) << 8) | j96))) & (-2121237120);
                            bArr6[V2.a(1543667713, ~i3, (-1543667715) - i3) ^ (-577569402)] = -48;
                            r(bArr5, bArr6);
                            try {
                                t(intern, new String(bArr5, charset).intern());
                                c4 = 643;
                                instrumentationInfo3 = instrumentationInfo;
                                z7 = z3;
                                it2 = it;
                                obj4 = obj;
                                obj6 = obj6;
                            } catch (Throwable th5) {
                                th = th5;
                                obj5 = th;
                                z5 = obj6;
                                obj3 = obj;
                                z4 = z5;
                                obj2 = obj3;
                                z6 = z4;
                                c4 = 42525;
                                instrumentationInfo3 = instrumentationInfo;
                                z7 = z3;
                                it2 = it;
                                obj4 = obj2;
                                obj6 = z6;
                                list2 = list;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        instrumentationInfo = instrumentationInfo3;
                        list = list2;
                    }
                    list2 = list;
                case 33845:
                    c4 = 52163;
                    z8 = true;
                case 65214:
                    try {
                        z3 = z7;
                        try {
                            bArr2 = new byte[20];
                            bArr2[0] = -97;
                            obj = obj4;
                            it = it2;
                            long j103 = -1;
                            long j104 = 0;
                            long j105 = (((((j103 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                            long j106 = (((((((j103 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                            long j107 = (((((((j103 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j108 = (((((((j103 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j109 = j108 + j107 + j106 + j105 + (((((((((j104 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j104 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j104 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j104 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j110 = (j109 >>> 48) & 21845;
                            long j111 = ((j110 >>> 1) | j110) & 858993459;
                            long j112 = ((j111 >>> 2) | j111) & 252645135;
                            long j113 = (j109 >>> 32) & 21845;
                            long j114 = ((j113 >>> 1) | j113) & 858993459;
                            long j115 = ((j114 >>> 2) | j114) & 252645135;
                            long j116 = ((((j115 >>> 4) | j115) & 16711935) << 16) + ((((j112 >>> 4) | j112) & 16711935) << 24);
                            long j117 = (j109 >>> 16) & 21845;
                            long j118 = ((j117 >>> 1) | j117) & 858993459;
                            long j119 = ((j118 >>> 2) | j118) & 252645135;
                            long j120 = j109 & 21845;
                            long j121 = ((j120 >>> 1) | j120) & 858993459;
                            long j122 = ((j121 >>> 2) | j121) & 252645135;
                            int i4 = (int) ((((j122 >>> 4) | j122) & 16711935) + (((((j119 >>> 4) | j119) & 16711935) << 8) | j116));
                            int i5 = ((i4 | 1465825763) - ((341064163 | i4) ^ 1125820512)) + 337645577;
                            try {
                                bArr2[(i5 | 1463466088) - (i5 & 1463466088)] = -95;
                                bArr2[2] = 43;
                                bArr2[3] = -75;
                                bArr2[4] = -5;
                                bArr2[5] = -50;
                                bArr2[6] = 126;
                                bArr2[7] = 80;
                                bArr2[8] = -42;
                                bArr2[9] = -60;
                                bArr2[10] = -16;
                                bArr2[11] = -18;
                                bArr2[12] = -99;
                                long j123 = -1786689496;
                                long j124 = ((((((((j123 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j123 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j123 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j123 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j108 | (j107 + (j106 | j105)));
                                long j125 = (j124 >>> 48) & 43690;
                                long j126 = ((j125 >>> 2) | (j125 >>> 1)) & 858993459;
                                long j127 = ((j126 >>> 2) | j126) & 252645135;
                                long j128 = (j124 >>> 32) & 43690;
                                long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
                                long j130 = ((j129 >>> 2) | j129) & 252645135;
                                long j131 = ((((j130 >>> 4) | j130) & 16711935) << 16) + ((((j127 >>> 4) | j127) & 16711935) << 24);
                                long j132 = (j124 >>> 16) & 43690;
                                long j133 = ((j132 >>> 2) | (j132 >>> 1)) & 858993459;
                                long j134 = ((j133 >>> 2) | j133) & 252645135;
                                long j135 = j124 & 43690;
                                long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
                                long j137 = ((j136 >>> 2) | j136) & 252645135;
                                int i6 = ((int) ((((j137 >>> 4) | j137) & 16711935) + ((((j134 >>> 4) | j134) & 16711935) << 8) + j131)) + 136454161;
                                long j138 = -1650235340;
                                long j139 = i6;
                                long j140 = ((((((((j138 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j138 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j138 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j138 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((j139 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j139 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j139 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j139 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                long j141 = (j140 >>> 48) & 21845;
                                long j142 = ((j141 >>> 1) | j141) & 858993459;
                                long j143 = ((j142 >>> 2) | j142) & 252645135;
                                long j144 = (j140 >>> 32) & 21845;
                                long j145 = ((j144 >>> 1) | j144) & 858993459;
                                long j146 = ((j145 >>> 2) | j145) & 252645135;
                                long j147 = ((((j146 >>> 4) | j146) & 16711935) << 16) | ((((j143 >>> 4) | j143) & 16711935) << 24);
                                long j148 = (j140 >>> 16) & 21845;
                                long j149 = ((j148 >>> 1) | j148) & 858993459;
                                long j150 = ((j149 >>> 2) | j149) & 252645135;
                                long j151 = ((((j150 >>> 4) | j150) & 16711935) << 8) + j147;
                                long j152 = j140 & 21845;
                                long j153 = ((j152 >>> 1) | j152) & 858993459;
                                long j154 = ((j153 >>> 2) | j153) & 252645135;
                                bArr2[(int) ((((j154 >>> 4) | j154) & 16711935) + j151)] = 65;
                                bArr2[14] = 8;
                                bArr2[15] = 12;
                                bArr2[16] = 31;
                                bArr2[17] = -12;
                                bArr2[18] = -22;
                                bArr2[19] = -79;
                                r(bArr2, new byte[]{5, -91, 100, -82, -103, 87, 38, 10, -71, -122, -101, 106, 15, 0, -110, 84, -126, 109, -101, -58});
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            it = it2;
                            obj5 = th;
                            instrumentationInfo = instrumentationInfo3;
                            list = list2;
                            obj3 = obj4;
                            z4 = obj6;
                            obj2 = obj3;
                            z6 = z4;
                            c4 = 42525;
                            instrumentationInfo3 = instrumentationInfo;
                            z7 = z3;
                            it2 = it;
                            obj4 = obj2;
                            obj6 = z6;
                            list2 = list;
                        }
                        try {
                            obj6 = PackageManager.class.getMethod(new String(bArr2, StandardCharsets.UTF_8).intern(), String.class, Integer.TYPE).invoke(context.getPackageManager(), null, 0);
                            c4 = obj6 instanceof List ? (char) 28914 : (char) 61351;
                            z7 = z3;
                            it2 = it;
                            obj4 = obj;
                        } catch (Throwable th10) {
                            th = th10;
                            obj5 = th;
                            instrumentationInfo = instrumentationInfo3;
                            list = list2;
                            z5 = obj6;
                            obj3 = obj;
                            z4 = z5;
                            obj2 = obj3;
                            z6 = z4;
                            c4 = 42525;
                            instrumentationInfo3 = instrumentationInfo;
                            z7 = z3;
                            it2 = it;
                            obj4 = obj2;
                            obj6 = z6;
                            list2 = list;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        z3 = z7;
                    }
                case 50922:
                    c4 = 49615;
                    instrumentationInfo3 = null;
                case 52163:
                    z7 = z8;
                    c4 = 373;
                case 43393:
                    try {
                        obj4 = it2.next();
                        c4 = obj4 instanceof InstrumentationInfo ? (char) 28252 : (char) 50922;
                    } catch (Throwable th12) {
                        obj5 = th12;
                        z3 = z7;
                        it = it2;
                        instrumentationInfo = instrumentationInfo3;
                        list = list2;
                        obj2 = obj4;
                        z6 = obj6;
                        c4 = 42525;
                        instrumentationInfo3 = instrumentationInfo;
                        z7 = z3;
                        it2 = it;
                        obj4 = obj2;
                        obj6 = z6;
                        list2 = list;
                    }
                case 20165:
                    c4 = list4 != null ? (char) 15821 : (char) 30974;
                    list2 = list4;
                    obj5 = list2;
                case 25296:
                    break;
                case 30974:
                    z7 = false;
                    c4 = 373;
                case 643:
                    c4 = 43281;
                    z9 = z10;
                default:
                    c4 = 20659;
            }
            return z9;
        }
    }

    public final boolean D() {
        boolean z3;
        Throwable th;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Charset charset;
        byte[] bArr;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        int i;
        String A3;
        boolean z4;
        try {
            Socket socket = new Socket();
            try {
                try {
                    socket.setSoTimeout(ServiceStarter.ERROR_UNKNOWN);
                    byte[] bArr2 = {103, 0, 125, -126, -19, 45, -57, 51, -42};
                    long j16 = -1647360702;
                    long j17 = -1;
                    j2 = (((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    j3 = (((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j18 = j3 | j2;
                    j4 = (((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    j5 = j4 + j18;
                    j6 = (((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    j7 = j6 | j5;
                    long j19 = (((((((((j16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j7 + 6148914691236517205L;
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
                    long j32 = ((j31 >>> 2) | j31) & 252645135;
                    int i3 = (((int) ((((j32 >>> 4) | j32) & 16711935) + ((((j29 >>> 4) | j29) & 16711935) << 8) + j26)) & 270537856) + 9437696;
                    r(bArr2, new byte[]{109, E1.a(279975554 | i3, 279975554, i3), 96, -109, -12, -45, 12, 5, -25});
                    charset = StandardCharsets.UTF_8;
                    socket.connect(new InetSocketAddress(new String(bArr2, charset).intern(), 6790), ServiceStarter.ERROR_UNKNOWN);
                    bArr = new byte[41];
                    bArr[0] = -68;
                    bArr[1] = -48;
                    bArr[2] = 22;
                    bArr[3] = 80;
                    bArr[4] = 70;
                    bArr[5] = 69;
                    bArr[6] = 109;
                    bArr[7] = 47;
                    bArr[8] = 107;
                    bArr[9] = 82;
                    bArr[10] = -119;
                    bArr[11] = 34;
                    bArr[12] = 1;
                    bArr[13] = 80;
                    bArr[14] = -72;
                    bArr[15] = -48;
                    bArr[16] = 83;
                    bArr[17] = 113;
                    bArr[18] = 113;
                    bArr[19] = -110;
                    bArr[20] = 98;
                    bArr[21] = 80;
                    bArr[22] = 89;
                    bArr[23] = -39;
                    bArr[24] = -98;
                    bArr[25] = -61;
                    bArr[26] = 24;
                    bArr[27] = 76;
                    bArr[28] = -108;
                    bArr[29] = 115;
                    bArr[30] = 59;
                    bArr[31] = 109;
                    bArr[32] = 103;
                    bArr[33] = 33;
                    bArr[34] = -8;
                    long j33 = 0;
                    j8 = (((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    j9 = (((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    j10 = j9 | j8;
                    j11 = (((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    j12 = j11 + j10;
                    j13 = (((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    j14 = j13 + j12;
                    j15 = j6 | j4 | j18;
                    long j34 = j15 + j14;
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
                    long j45 = ((((j44 >>> 4) | j44) & 16711935) << 8) | j41;
                    long j46 = j34 & 21845;
                    long j47 = ((j46 >>> 1) | j46) & 858993459;
                    long j48 = ((j47 >>> 2) | j47) & 252645135;
                    z3 = false;
                    i = (int) ((((j48 >>> 4) | j48) & 16711935) + j45);
                } catch (Throwable th2) {
                    th = th2;
                    z3 = false;
                }
                try {
                    bArr[((((i + (((-i) - 1) | 945930678)) - 945930678) | 1877396927) - 1323336895) ^ (-1323336861)] = 88;
                    bArr[36] = -34;
                    bArr[37] = -95;
                    bArr[38] = 14;
                    bArr[39] = 42;
                    bArr[40] = 70;
                    byte[] bArr3 = new byte[41];
                    bArr3[0] = 18;
                    bArr3[1] = 102;
                    bArr3[2] = 88;
                    bArr3[3] = 87;
                    bArr3[4] = Byte.MIN_VALUE;
                    bArr3[5] = 6;
                    bArr3[6] = 47;
                    bArr3[7] = 53;
                    bArr3[8] = 54;
                    bArr3[9] = -9;
                    bArr3[10] = 15;
                    bArr3[11] = -22;
                    bArr3[12] = 96;
                    bArr3[13] = -44;
                    bArr3[14] = 1;
                    bArr3[15] = 104;
                    bArr3[16] = -109;
                    bArr3[17] = 16;
                    bArr3[18] = 117;
                    bArr3[19] = -118;
                    bArr3[20] = -122;
                    bArr3[21] = 42;
                    bArr3[22] = 39;
                    bArr3[23] = -99;
                    long j49 = 134218827;
                    long j50 = j13 + (j11 | (j9 + j8));
                    long j51 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + j50;
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
                    bArr3[(-1676488973) ^ ((-1945057086) + (((int) ((((j64 >>> 4) | j64) & 16711935) | (((((j61 >>> 4) | j61) & 16711935) << 8) + j58))) | 268568105))] = 4;
                    bArr3[25] = -120;
                    bArr3[26] = 56;
                    bArr3[27] = 83;
                    bArr3[28] = 15;
                    bArr3[29] = -19;
                    bArr3[30] = 109;
                    long j65 = 1145049209;
                    long j66 = -1145049206;
                    long j67 = (((((((((j65 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j65 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j65 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j65 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j66 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j66 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j66 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j66 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j68 = (j67 >>> 48) & 21845;
                    long j69 = ((j68 >>> 1) | j68) & 858993459;
                    long j70 = ((j69 >>> 2) | j69) & 252645135;
                    long j71 = (j67 >>> 32) & 21845;
                    long j72 = ((j71 >>> 1) | j71) & 858993459;
                    long j73 = ((j72 >>> 2) | j72) & 252645135;
                    long j74 = ((((j73 >>> 4) | j73) & 16711935) << 16) + ((((j70 >>> 4) | j70) & 16711935) << 24);
                    long j75 = (j67 >>> 16) & 21845;
                    long j76 = ((j75 >>> 1) | j75) & 858993459;
                    long j77 = ((j76 >>> 2) | j76) & 252645135;
                    long j78 = j67 & 21845;
                    long j79 = ((j78 >>> 1) | j78) & 858993459;
                    long j80 = ((j79 >>> 2) | j79) & 252645135;
                    bArr3[31] = (int) ((((j80 >>> 4) | j80) & 16711935) + (((((j77 >>> 4) | j77) & 16711935) << 8) | j74));
                    long j81 = 1948257509;
                    long j82 = ((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j50;
                    long j83 = (j82 >>> 48) & 43690;
                    long j84 = ((j83 >>> 2) | (j83 >>> 1)) & 858993459;
                    long j85 = ((j84 >>> 2) | j84) & 252645135;
                    long j86 = (j82 >>> 32) & 43690;
                    long j87 = ((j86 >>> 2) | (j86 >>> 1)) & 858993459;
                    long j88 = ((j87 >>> 2) | j87) & 252645135;
                    long j89 = ((((j88 >>> 4) | j88) & 16711935) << 16) + ((((j85 >>> 4) | j85) & 16711935) << 24);
                    long j90 = (j82 >>> 16) & 43690;
                    long j91 = ((j90 >>> 2) | (j90 >>> 1)) & 858993459;
                    long j92 = ((j91 >>> 2) | j91) & 252645135;
                    long j93 = j82 & 43690;
                    long j94 = ((j93 >>> 2) | (j93 >>> 1)) & 858993459;
                    long j95 = ((j94 >>> 2) | j94) & 252645135;
                    bArr3[2007559901 ^ (1890070265 + (((int) ((((j95 >>> 4) | j95) & 16711935) + (((((j92 >>> 4) | j92) & 16711935) << 8) + j89))) | 117489668))] = 34;
                    long j96 = j11 | j10;
                    long j97 = j13 + j96;
                    long j98 = j6 + j5 + j97;
                    long j99 = (j98 >>> 48) & 21845;
                    long j100 = ((j99 >>> 1) | j99) & 858993459;
                    long j101 = ((j100 >>> 2) | j100) & 252645135;
                    long j102 = (j98 >>> 32) & 21845;
                    long j103 = ((j102 >>> 1) | j102) & 858993459;
                    long j104 = ((j103 >>> 2) | j103) & 252645135;
                    long j105 = ((((j104 >>> 4) | j104) & 16711935) << 16) | ((((j101 >>> 4) | j101) & 16711935) << 24);
                    long j106 = (j98 >>> 16) & 21845;
                    long j107 = ((j106 >>> 1) | j106) & 858993459;
                    long j108 = ((j107 >>> 2) | j107) & 252645135;
                    long j109 = j98 & 21845;
                    long j110 = ((j109 >>> 1) | j109) & 858993459;
                    long j111 = ((j110 >>> 2) | j110) & 252645135;
                    int i4 = (int) ((((j111 >>> 4) | j111) & 16711935) | ((((j108 >>> 4) | j108) & 16711935) << 8) | j105);
                    long j112 = 566231328;
                    long j113 = (((((((((j112 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j112 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j112 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j112 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + j14 + 6148914691236517205L;
                    long j114 = (j113 >>> 48) & 43690;
                    long j115 = ((j114 >>> 2) | (j114 >>> 1)) & 858993459;
                    long j116 = ((j115 >>> 2) | j115) & 252645135;
                    long j117 = (j113 >>> 32) & 43690;
                    long j118 = ((j117 >>> 2) | (j117 >>> 1)) & 858993459;
                    long j119 = ((j118 >>> 2) | j118) & 252645135;
                    long j120 = ((((j119 >>> 4) | j119) & 16711935) << 16) + ((((j116 >>> 4) | j116) & 16711935) << 24);
                    long j121 = (j113 >>> 16) & 43690;
                    long j122 = ((j121 >>> 2) | (j121 >>> 1)) & 858993459;
                    long j123 = ((j122 >>> 2) | j122) & 252645135;
                    long j124 = j113 & 43690;
                    long j125 = ((j124 >>> 2) | (j124 >>> 1)) & 858993459;
                    long j126 = ((j125 >>> 2) | j125) & 252645135;
                    int i5 = (int) ((((j126 >>> 4) | j126) & 16711935) + (((((j123 >>> 4) | j123) & 16711935) << 8) | j120));
                    bArr3[V2.a(i5, ~((i4 | (-89148176)) - (((-492010320) | i4) ^ (-1708673984))), ((~i5) - r6) - 1) ^ (-1142442687)] = 25;
                    bArr3[34] = -83;
                    bArr3[35] = 18;
                    bArr3[36] = -63;
                    bArr3[37] = 124;
                    bArr3[38] = 26;
                    long j127 = 365035778;
                    long j128 = j3 + j2;
                    long j129 = (((((((((j127 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j127 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j127 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j127 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j4 | j128) + j6;
                    long j130 = (j129 >>> 48) & 43690;
                    long j131 = ((j130 >>> 2) | (j130 >>> 1)) & 858993459;
                    long j132 = (j131 | (j131 >>> 2)) & 252645135;
                    long j133 = (j129 >>> 32) & 43690;
                    long j134 = ((j133 >>> 2) | (j133 >>> 1)) & 858993459;
                    long j135 = ((j134 >>> 2) | j134) & 252645135;
                    long j136 = ((((j135 >>> 4) | j135) & 16711935) << 16) + (((j132 | (j132 >>> 4)) & 16711935) << 24);
                    long j137 = (j129 >>> 16) & 43690;
                    long j138 = ((j137 >>> 2) | (j137 >>> 1)) & 858993459;
                    long j139 = ((j138 >>> 2) | j138) & 252645135;
                    long j140 = j129 & 43690;
                    long j141 = ((j140 >>> 2) | (j140 >>> 1)) & 858993459;
                    long j142 = (j141 | (j141 >>> 2)) & 252645135;
                    bArr3[39] = (((int) (((j142 | (j142 >>> 4)) & 16711935) | (((((j139 >>> 4) | j139) & 16711935) << 8) + j136))) + 134283481) ^ 499319253;
                    bArr3[40] = 76;
                    r(bArr, bArr3);
                    String intern = new String(bArr, charset).intern();
                    OutputStream outputStream = socket.getOutputStream();
                    byte[] bytes = intern.getBytes(N2.a.f1508a);
                    long j143 = j7 + j97;
                    long j144 = (j143 >>> 48) & 21845;
                    long j145 = (j144 | (j144 >>> 1)) & 858993459;
                    long j146 = (j145 | (j145 >>> 2)) & 252645135;
                    long j147 = (j143 >>> 32) & 21845;
                    long j148 = ((j147 >>> 1) | j147) & 858993459;
                    long j149 = ((j148 >>> 2) | j148) & 252645135;
                    long j150 = ((((j149 >>> 4) | j149) & 16711935) << 16) + (((j146 | (j146 >>> 4)) & 16711935) << 24);
                    long j151 = (j143 >>> 16) & 21845;
                    long j152 = ((j151 >>> 1) | j151) & 858993459;
                    long j153 = ((j152 >>> 2) | j152) & 252645135;
                    long j154 = ((((j153 >>> 4) | j153) & 16711935) << 8) | j150;
                    long j155 = j143 & 21845;
                    long j156 = ((j155 >>> 1) | j155) & 858993459;
                    long j157 = ((j156 >>> 2) | j156) & 252645135;
                    int i6 = (((int) (j154 | (((j157 >>> 4) | j157) & 16711935))) | 1740340752) & 620960257;
                    long j158 = 134217761;
                    long j159 = (((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (j13 | j96);
                    long j160 = (j159 >>> 48) & 43690;
                    long j161 = ((j160 >>> 2) | (j160 >>> 1)) & 858993459;
                    long j162 = ((j161 >>> 2) | j161) & 252645135;
                    long j163 = (j159 >>> 32) & 43690;
                    long j164 = ((j163 >>> 2) | (j163 >>> 1)) & 858993459;
                    long j165 = ((j164 >>> 2) | j164) & 252645135;
                    long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) | ((((j162 >>> 4) | j162) & 16711935) << 24);
                    long j167 = (j159 >>> 16) & 43690;
                    long j168 = ((j167 >>> 2) | (j167 >>> 1)) & 858993459;
                    long j169 = ((j168 >>> 2) | j168) & 252645135;
                    long j170 = j159 & 43690;
                    long j171 = ((j170 >>> 2) | (j170 >>> 1)) & 858993459;
                    long j172 = (j171 | (j171 >>> 2)) & 252645135;
                    int i7 = ((int) (((j172 | (j172 >>> 4)) & 16711935) + ((((j169 >>> 4) | j169) & 16711935) << 8) + j166)) | 1476928552;
                    int i8 = -i6;
                    byte[] bArr4 = {73, 25, 52, -18, 32, -9, -61, -106, 24, -35, -120, 2097888808 ^ ((((~i8) & i7) * 2) - (i8 ^ i7)), 18};
                    long j173 = 1337754616;
                    long b4 = c3.b((((((((j173 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j173 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j173 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j173 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j128 + j4 + j6, 6148914691236517205L);
                    long j174 = (b4 >>> 48) & 43690;
                    long j175 = ((j174 >>> 2) | (j174 >>> 1)) & 858993459;
                    long j176 = ((j175 >>> 2) | j175) & 252645135;
                    long j177 = (b4 >>> 32) & 43690;
                    long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
                    long j179 = ((j178 >>> 2) | j178) & 252645135;
                    long j180 = ((((j179 >>> 4) | j179) & 16711935) << 16) + ((((j176 >>> 4) | j176) & 16711935) << 24);
                    long j181 = (b4 >>> 16) & 43690;
                    long j182 = ((j181 >>> 2) | (j181 >>> 1)) & 858993459;
                    long j183 = ((j182 >>> 2) | j182) & 252645135;
                    long j184 = b4 & 43690;
                    long j185 = ((j184 >>> 2) | (j184 >>> 1)) & 858993459;
                    long j186 = ((j185 >>> 2) | j185) & 252645135;
                    r(bArr4, new byte[]{69, 76, 86, -109, 112, 83, -68, -52, ((((int) ((((j186 >>> 4) | j186) & 16711935) | (((((j183 >>> 4) | j183) & 16711935) << 8) + j180))) & (-1718812158)) + 1086672) ^ (-1717725547), -61, -68, 22, 59});
                    kotlin.jvm.internal.j.d(bytes, new String(bArr4, charset).intern());
                    outputStream.write(bytes);
                    outputStream.flush();
                    InputStream inputStream = socket.getInputStream();
                    if (inputStream != null) {
                        try {
                            A3 = A(inputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            socket = socket;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                p3.h.h(socket, th);
                                throw th4;
                            }
                        }
                    } else {
                        A3 = null;
                    }
                    if (A3 != null) {
                        byte[] bArr5 = new byte[12];
                        bArr5[0] = 6;
                        bArr5[1] = 48;
                        bArr5[2] = 120;
                        bArr5[3] = -57;
                        long j187 = j15 + j97;
                        long j188 = (j187 >>> 48) & 21845;
                        long j189 = (j188 | (j188 >>> 1)) & 858993459;
                        long j190 = (j189 | (j189 >>> 2)) & 252645135;
                        long j191 = (j187 >>> 32) & 21845;
                        long j192 = (j191 | (j191 >>> 1)) & 858993459;
                        long j193 = (j192 | (j192 >>> 2)) & 252645135;
                        long j194 = (((j190 | (j190 >>> 4)) & 16711935) << 24) | (((j193 | (j193 >>> 4)) & 16711935) << 16);
                        long j195 = (j187 >>> 16) & 21845;
                        long j196 = (j195 | (j195 >>> 1)) & 858993459;
                        long j197 = (j196 | (j196 >>> 2)) & 252645135;
                        long j198 = (((j197 | (j197 >>> 4)) & 16711935) << 8) + j194;
                        long j199 = j187 & 21845;
                        long j200 = (j199 | (j199 >>> 1)) & 858993459;
                        long j201 = (j200 | (j200 >>> 2)) & 252645135;
                        int i9 = (int) (((j201 | (j201 >>> 4)) & 16711935) | j198);
                        bArr5[322323140 ^ ((((1515695566 | i9) + 269877888) - (i9 | 1515696078)) + 52445248)] = -93;
                        bArr5[5] = 119;
                        bArr5[6] = -72;
                        bArr5[7] = -57;
                        bArr5[8] = 98;
                        bArr5[9] = -27;
                        bArr5[10] = -72;
                        bArr5[11] = 46;
                        byte[] bArr6 = new byte[12];
                        bArr6[0] = 106;
                        bArr6[1] = 41;
                        bArr6[2] = 79;
                        bArr6[3] = -103;
                        long j202 = 4217086;
                        long j203 = (((((((((j202 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j202 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j202 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j202 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)))) + j15;
                        long j204 = (j203 >>> 48) & 43690;
                        long j205 = ((j204 >>> 2) | (j204 >>> 1)) & 858993459;
                        long j206 = (j205 | (j205 >>> 2)) & 252645135;
                        long j207 = (j203 >>> 32) & 43690;
                        long j208 = ((j207 >>> 2) | (j207 >>> 1)) & 858993459;
                        long j209 = (j208 | (j208 >>> 2)) & 252645135;
                        long j210 = (((j209 | (j209 >>> 4)) & 16711935) << 16) + (((j206 | (j206 >>> 4)) & 16711935) << 24);
                        long j211 = (j203 >>> 16) & 43690;
                        long j212 = ((j211 >>> 2) | (j211 >>> 1)) & 858993459;
                        long j213 = (j212 | (j212 >>> 2)) & 252645135;
                        long j214 = j203 & 43690;
                        long j215 = ((j214 >>> 2) | (j214 >>> 1)) & 858993459;
                        long j216 = (j215 | (j215 >>> 2)) & 252645135;
                        int i10 = -((int) (((j216 | (j216 >>> 4)) & 16711935) | (((j213 | (j213 >>> 4)) & 16711935) << 8) | j210));
                        int i11 = ((~i10) & 2106106880) - (i10 & (-2106106881));
                        bArr6[(2110323962 + i11) - ((i11 & 2110323962) * 2)] = -18;
                        bArr6[5] = -24;
                        bArr6[6] = -22;
                        bArr6[7] = -115;
                        bArr6[8] = 45;
                        bArr6[9] = 90;
                        bArr6[10] = -32;
                        bArr6[11] = 3;
                        r(bArr5, bArr6);
                        z4 = N2.f.N(A3, new String(bArr5, charset).intern(), false);
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        byte[] bArr7 = {60, -122, 92, -114, -48, 108, -120, 82, 8, 56, 12, 50, -1, 115, 95, E1.a(-585162245, -585162285, -585162309), -51, 26, 115, 67, -49, -109, -67, -71};
                        byte[] bArr8 = new byte[24];
                        bArr8[0] = 116;
                        bArr8[1] = -58;
                        bArr8[2] = 66;
                        bArr8[3] = -50;
                        bArr8[4] = -68;
                        bArr8[5] = -47;
                        bArr8[6] = -14;
                        bArr8[7] = 34;
                        long j217 = 278421760;
                        long j218 = (((((((((j217 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((j217 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j217 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j217 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)) + (j13 | j12) + 6148914691236517205L;
                        long j219 = (j218 >>> 48) & 43690;
                        long j220 = ((j219 >>> 2) | (j219 >>> 1)) & 858993459;
                        long j221 = (j220 | (j220 >>> 2)) & 252645135;
                        long j222 = (j218 >>> 32) & 43690;
                        long j223 = ((j222 >>> 2) | (j222 >>> 1)) & 858993459;
                        long j224 = (j223 | (j223 >>> 2)) & 252645135;
                        long j225 = (((j221 | (j221 >>> 4)) & 16711935) << 24) | (((j224 | (j224 >>> 4)) & 16711935) << 16);
                        long j226 = (j218 >>> 16) & 43690;
                        long j227 = ((j226 >>> 2) | (j226 >>> 1)) & 858993459;
                        long j228 = (j227 | (j227 >>> 2)) & 252645135;
                        long j229 = j218 & 43690;
                        long j230 = ((j229 >>> 2) | (j229 >>> 1)) & 858993459;
                        long j231 = (j230 | (j230 >>> 2)) & 252645135;
                        bArr8[(-728141464) ^ ((-1006563232) + ((int) (((j231 | (j231 >>> 4)) & 16711935) | ((((j228 | (j228 >>> 4)) & 16711935) << 8) + j225))))] = 96;
                        bArr8[9] = 29;
                        bArr8[10] = -114;
                        bArr8[11] = 68;
                        bArr8[12] = -87;
                        bArr8[13] = -30;
                        bArr8[14] = 64;
                        bArr8[B0.a(-15, -13)] = -18;
                        bArr8[16] = -42;
                        bArr8[17] = 24;
                        bArr8[18] = 28;
                        bArr8[19] = 20;
                        bArr8[20] = -72;
                        bArr8[21] = -54;
                        bArr8[22] = -23;
                        bArr8[23] = -59;
                        r(bArr7, bArr8);
                        String intern2 = new String(bArr7, charset).intern();
                        byte[] bArr9 = {108, 106, 24, -32};
                        r(bArr9, new byte[]{47, -24, -126, 108, 44, -108, 8, -113});
                        try {
                            t(intern2, new String(bArr9, charset).intern());
                        } catch (Throwable th5) {
                            th = th5;
                            th = th;
                            socket = socket;
                            throw th;
                        }
                    }
                    p3.h.h(socket, null);
                    return z4;
                } catch (Throwable th6) {
                    th = th6;
                    socket = socket;
                    th = th;
                    throw th;
                }
            } catch (Exception unused) {
                return z3;
            }
        } catch (Exception unused2) {
            return false;
        }
    }

    @Override // F0.T2
    public final void a(Context context) {
        char c4;
        char c5;
        char c6;
        byte[] bArr = {38, 115, -35, -25, -48, -106, 117};
        E(bArr, new byte[]{69, 28, -77, -109, -75, -18, 1, -21});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        C0031f2 n4 = T0.n(new C0016c(this, context, 11));
        byte[] bArr2 = {90, -91, -96, -99, -75, -71};
        Y.k(bArr2, new byte[]{-100, -51, -39, -66, 50, 8, -74, 40});
        new String(bArr2, charset).intern();
        C0054l1 c0054l1 = this.f428f;
        C0047j2 c0047j2 = c0054l1.f573a;
        C0047j2 c0047j22 = c0054l1.f573a;
        c0047j2.getClass();
        int i = AbstractC0041i0.f535a;
        byte[] bArr3 = {-9, -13, 60, 124, 117, -8, -126, -56, -51, -3};
        Y.k(bArr3, new byte[]{29, -109, -94, -117, 85, -74, 41, -65, 4, -108});
        d(new String(bArr3, charset).intern(), n4);
        if (n4.b()) {
            c4 = 7;
            byte[] bArr4 = {-50, -111, 48, 63, 33, 19, 23, -35, -46, 106};
            c5 = 6;
            byte[] bArr5 = new byte[10];
            bArr5[0] = -51;
            c6 = '\b';
            bArr5[((((~Y.class.getName().length()) | (-1333421246)) & 1887740379) + ((Y.class.getName().length() & 1076977821) | (-2077146588))) ^ (-189406210)] = 4;
            bArr5[2] = -67;
            bArr5[3] = 79;
            bArr5[4] = -15;
            bArr5[5] = -111;
            bArr5[6] = 124;
            bArr5[7] = -30;
            bArr5[8] = -127;
            bArr5[9] = 9;
            Y.k(bArr4, bArr5);
            String intern = new String(bArr4, charset).intern();
            c0047j22.getClass();
            c(intern);
        } else {
            c4 = 7;
            c5 = 6;
            c6 = '\b';
        }
        if (n4.a()) {
            c0047j22.getClass();
            byte[] bArr6 = {124, 17, -25, 79, 56, -14, 60, -32, 57, -103};
            byte[] bArr7 = new byte[10];
            bArr7[0] = -66;
            bArr7[1] = -9;
            bArr7[2] = 86;
            bArr7[3] = -57;
            bArr7[4] = -63;
            bArr7[5] = 17;
            bArr7[c5] = -74;
            bArr7[c4] = -79;
            long j2 = 278463521;
            long j3 = (~Y.class.getName().length()) | (-1514850575);
            long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
            long j5 = (j4 >>> 48) & 43690;
            long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
            long j7 = ((j6 >>> 2) | j6) & 252645135;
            long j8 = (j4 >>> 32) & 43690;
            long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
            long j10 = ((j9 >>> 2) | j9) & 252645135;
            long j11 = (j4 >>> 16) & 43690;
            long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
            long j13 = ((j12 >>> 2) | j12) & 252645135;
            long j14 = j4 & 43690;
            long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
            long j16 = (j15 | (j15 >>> 2)) & 252645135;
            int i3 = (int) (((j16 | (j16 >>> 4)) & 16711935) + (((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24) | ((((j13 >>> 4) | j13) & 16711935) << c6)));
            int length = (Y.class.getName().length() & (-1874329510)) | (-1069547430);
            bArr7[(-791083917) ^ (((length | i3) - ((Y.class.getName().length() & (~i3)) & length)) + ((i3 | Y.class.getName().length()) & length))] = -14;
            bArr7[9] = -60;
            Y.k(bArr6, bArr7);
            c0054l1.c(new String(bArr6, charset).intern(), null);
        }
    }
}
