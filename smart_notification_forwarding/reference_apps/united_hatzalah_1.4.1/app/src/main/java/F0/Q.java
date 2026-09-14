package F0;

import P2.C0161k0;
import a.AbstractC0228a;
import android.content.Context;
import android.os.SystemClock;
import c2.C0328a;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.instacart.truetime.InvalidNtpServerResponseException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.tika.fork.ForkServer;
import org.json.JSONObject;
import s2.C0684i;
import t2.AbstractC0708j;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    public final Object f360a;

    /* renamed from: b, reason: collision with root package name */
    public Object f361b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f362c;

    /* renamed from: d, reason: collision with root package name */
    public Object f363d;

    /* renamed from: e, reason: collision with root package name */
    public Object f364e;

    public Q(Context context, C0021d0 c0021d0, String str, C0107z c0107z, Z1 z12, G0.l lVar, JSONObject jSONObject, C0073q0 c0073q0, U2.e eVar) {
        byte[] bArr = new byte[7];
        bArr[0] = 82;
        long j2 = -1;
        long length = Q.class.getName().length();
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 8) + j10;
        long j15 = j3 & 21845;
        long j16 = (j15 | (j15 >>> 1)) & 858993459;
        long j17 = (j16 | (j16 >>> 2)) & 252645135;
        int i = (int) (((j17 | (j17 >>> 4)) & 16711935) + j14);
        long j18 = 557926848;
        long length2 = Q.class.getName().length();
        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j20 = (j19 >>> 48) & 43690;
        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
        long j22 = ((j21 >>> 2) | j21) & 252645135;
        long j23 = (j19 >>> 32) & 43690;
        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
        long j25 = ((j24 >>> 2) | j24) & 252645135;
        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) + ((((j22 >>> 4) | j22) & 16711935) << 24);
        long j27 = (j19 >>> 16) & 43690;
        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = j19 & 43690;
        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
        long j32 = ((j31 >>> 2) | j31) & 252645135;
        bArr[702892480 ^ ((148981953 & ((i ^ 1051362059) + (i & 1051362059))) + (((int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) + j26))) | 553910528))] = 8;
        bArr[2] = -82;
        int f4 = (AbstractC0008a.f(Q.class, -1) | (-1934395957)) & 352348228;
        long j33 = 1073807394;
        long length3 = Q.class.getName().length() & 285214756;
        long j34 = (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        int i3 = (int) ((((j47 >>> 4) | j47) & 16711935) + ((((j44 >>> 4) | j44) & 16711935) << 8) + j41);
        int i4 = -f4;
        bArr[3] = 1426155523 ^ (((~i4) & i3) - (i4 & (~i3)));
        bArr[4] = -7;
        bArr[5] = 57;
        bArr[6] = 115;
        byte[] bArr2 = new byte[8];
        bArr2[0] = -107;
        bArr2[1] = -102;
        bArr2[2] = 113;
        bArr2[((((~Q.class.getName().length()) | (-1778508365)) & 170132708) + ((Q.class.getName().length() & 705757252) | (-1609497856))) ^ (-1439365145)] = -68;
        bArr2[4] = -100;
        bArr2[5] = 65;
        bArr2[6] = 7;
        bArr2[7] = -22;
        b(bArr, bArr2);
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(context, new String(bArr, charset).intern());
        byte[] bArr3 = {45, 93, 52, 119, -99, -15};
        b(bArr3, new byte[]{-76, 46, -49, -83, -14, -125, -96, 13});
        kotlin.jvm.internal.j.e(c0021d0, new String(bArr3, charset).intern());
        byte[] bArr4 = {-34, -102, 67, -99, 28, -5, -97, 66, -68, 1, 102, -72, 43, -85, 24, 121};
        byte[] bArr5 = new byte[16];
        bArr5[0] = -21;
        int i5 = ((~Q.class.getName().length()) | (-1697831579)) & 92906792;
        int length4 = (Q.class.getName().length() | (-84197897)) - (-84197897);
        bArr5[1] = (i5 + (~(((Q.class.getName().length() | 1874574779) | length4) - ((Q.class.getName().length() & (-1874574780)) | length4)))) ^ 1781667968;
        bArr5[2] = -48;
        bArr5[3] = -111;
        bArr5[4] = -76;
        bArr5[5] = -127;
        bArr5[6] = 119;
        bArr5[7] = -52;
        bArr5[8] = 5;
        long j48 = 660762332;
        long j49 = ~Q.class.getName().length();
        long j50 = (((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
        long j51 = (j50 >>> 48) & 43690;
        long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
        long j53 = ((j52 >>> 2) | j52) & 252645135;
        long j54 = (j50 >>> 32) & 43690;
        long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
        long j56 = ((j55 >>> 2) | j55) & 252645135;
        long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) + ((((j53 >>> 4) | j53) & 16711935) << 24);
        long j58 = (j50 >>> 16) & 43690;
        long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
        long j60 = ((j59 >>> 2) | j59) & 252645135;
        long j61 = j50 & 43690;
        long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
        long j63 = ((j62 >>> 2) | j62) & 252645135;
        int i6 = ((int) ((((j63 >>> 4) | j63) & 16711935) + ((((j60 >>> 4) | j60) & 16711935) << 8) + j57)) & 908657728;
        long j64 = -1861550080;
        long length5 = Q.class.getName().length();
        long j65 = (((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j66 = (j65 >>> 48) & 43690;
        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
        long j68 = ((j67 >>> 2) | j67) & 252645135;
        long j69 = (j65 >>> 32) & 43690;
        long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
        long j71 = ((j70 >>> 2) | j70) & 252645135;
        long j72 = ((((j71 >>> 4) | j71) & 16711935) << 16) + ((((j68 >>> 4) | j68) & 16711935) << 24);
        long j73 = (j65 >>> 16) & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        long j76 = ((((j75 >>> 4) | j75) & 16711935) << 8) | j72;
        long j77 = j65 & 43690;
        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
        long j79 = ((j78 >>> 2) | j78) & 252645135;
        bArr5[(-1221655095) ^ (((((int) (j76 | (((j79 >>> 4) | j79) & 16711935))) | (-2130312832)) - (~i6)) - 1)] = -99;
        long j80 = 38887249;
        long f5 = AbstractC0008a.f(Q.class, -1) | (-1095907602);
        long j81 = (((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((f5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((f5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((f5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((f5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
        long j82 = (j81 >>> 48) & 43690;
        long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
        long j84 = ((j83 >>> 2) | j83) & 252645135;
        long j85 = (j81 >>> 32) & 43690;
        long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
        long j87 = ((j86 >>> 2) | j86) & 252645135;
        long j88 = ((((j87 >>> 4) | j87) & 16711935) << 16) | ((((j84 >>> 4) | j84) & 16711935) << 24);
        long j89 = (j81 >>> 16) & 43690;
        long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
        long j91 = ((j90 >>> 2) | j90) & 252645135;
        long j92 = j81 & 43690;
        long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
        long j94 = (j93 | (j93 >>> 2)) & 252645135;
        int i7 = (int) (((j94 | (j94 >>> 4)) & 16711935) + ((((j91 >>> 4) | j91) & 16711935) << 8) + j88);
        long j95 = 30972179;
        long length6 = Q.class.getName().length();
        long j96 = ((((((((j95 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j95 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j95 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j95 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j97 = (j96 >>> 48) & 43690;
        long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
        long j99 = ((j98 >>> 2) | j98) & 252645135;
        long j100 = (j96 >>> 32) & 43690;
        long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
        long j102 = ((j101 >>> 2) | j101) & 252645135;
        long j103 = ((((j102 >>> 4) | j102) & 16711935) << 16) + ((((j99 >>> 4) | j99) & 16711935) << 24);
        long j104 = (j96 >>> 16) & 43690;
        long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
        long j106 = ((j105 >>> 2) | j105) & 252645135;
        long j107 = j96 & 43690;
        long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
        long j109 = ((j108 >>> 2) | j108) & 252645135;
        int i8 = ((int) ((((j109 >>> 4) | j109) & 16711935) + ((((j106 >>> 4) | j106) & 16711935) << 8) + j103)) | 25723014;
        bArr5[64610269 ^ (((i8 | i7) * 2) - (i7 ^ i8))] = -92;
        bArr5[11] = 73;
        bArr5[12] = -69;
        bArr5[13] = -7;
        bArr5[14] = -2;
        bArr5[15] = ((((~Q.class.getName().length()) | (-5698839)) & (-1876884183)) + ((Q.class.getName().length() & 68158720) | 206604368)) ^ 1670279879;
        b(bArr4, bArr5);
        kotlin.jvm.internal.j.e(c0107z, new String(bArr4, charset).intern());
        byte[] bArr6 = {16, -26, -78, -66, -56, -29, 91, -87, 18, -54, 72};
        byte[] bArr7 = new byte[11];
        bArr7[0] = -45;
        bArr7[1] = -65;
        bArr7[2] = 81;
        bArr7[3] = 68;
        int i9 = ((~Q.class.getName().length()) | 1243724515) & (-1071573952);
        bArr7[D.a(i9, 3, -D1.a(i9, (Q.class.getName().length() & (-1988098944)) | 159383936), 1) ^ (-912190012)] = 8;
        bArr7[5] = -110;
        bArr7[6] = -94;
        bArr7[7] = 101;
        bArr7[8] = 116;
        bArr7[9] = -93;
        bArr7[10] = 47;
        b(bArr6, bArr7);
        kotlin.jvm.internal.j.e(z12, new String(bArr6, charset).intern());
        byte[] bArr8 = {-65, -115, 74, -38, 46, 43, -44, -36, 41, 108, 86, 118};
        b(bArr8, new byte[]{23, 26, -48, 79, -73, 123, 5, 80, -93, 63, -95, -65});
        kotlin.jvm.internal.j.e(lVar, new String(bArr8, charset).intern());
        byte[] bArr9 = new byte[7];
        bArr9[0] = -47;
        int i10 = ~Q.class.getName().length();
        bArr9[1] = (((((i10 + (((-i10) - 1) | 1080259468)) - 1080259468) | 198695919) - 198695919) + ((Q.class.getName().length() & 1080045568) | 12669568)) ^ (-186026294);
        int i11 = ~Q.class.getName().length();
        bArr9[(((-932593532) & ((i11 - 151139757) - (i11 & (-151139757)))) + ((Q.class.getName().length() & 403701957) | 336601921)) ^ (-595991609)] = 78;
        bArr9[3] = -33;
        bArr9[4] = 54;
        bArr9[5] = -36;
        bArr9[6] = -64;
        b(bArr9, new byte[]{6, 60, -81, 51, 87, -69, -91, -121});
        kotlin.jvm.internal.j.e(c0073q0, new String(bArr9, charset).intern());
        byte[] bArr10 = {-31, 65, -59, -124, 25};
        byte[] bArr11 = new byte[8];
        bArr11[0] = -10;
        bArr11[1] = 76;
        bArr11[2] = 88;
        bArr11[3] = -105;
        bArr11[4] = 124;
        int i12 = ((~Q.class.getName().length()) | 1819748558) & 673329300;
        long j110 = -1879044072;
        long length7 = Q.class.getName().length();
        long j111 = ((((((((j110 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j110 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j110 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j110 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j112 = (j111 >>> 48) & 43690;
        long j113 = ((j112 >>> 2) | (j112 >>> 1)) & 858993459;
        long j114 = ((j113 >>> 2) | j113) & 252645135;
        long j115 = (j111 >>> 32) & 43690;
        long j116 = ((j115 >>> 2) | (j115 >>> 1)) & 858993459;
        long j117 = ((j116 >>> 2) | j116) & 252645135;
        long j118 = ((((j117 >>> 4) | j117) & 16711935) << 16) | ((((j114 >>> 4) | j114) & 16711935) << 24);
        long j119 = (j111 >>> 16) & 43690;
        long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
        long j121 = ((j120 >>> 2) | j120) & 252645135;
        long j122 = j111 & 43690;
        long j123 = ((j122 >>> 2) | (j122 >>> 1)) & 858993459;
        long j124 = ((j123 >>> 2) | j123) & 252645135;
        bArr11[(i12 + (((int) ((((j124 >>> 4) | j124) & 16711935) + (((((j121 >>> 4) | j121) & 16711935) << 8) | j118))) | (-1845459959))) ^ (-1172130664)] = -22;
        bArr11[6] = 10;
        bArr11[7] = 106;
        b(bArr10, bArr11);
        kotlin.jvm.internal.j.e(eVar, new String(bArr10, charset).intern());
        this.f360a = c0073q0;
        this.f361b = eVar;
        C0093v1 c0093v1 = new C0093v1(c0107z, new Z(context), str, z12, this, jSONObject);
        this.f362c = c0093v1;
        C0054l1 c0054l1 = new C0054l1(context, ((C0051k2) z12).f560d, new C0077r1(context, lVar.f833g));
        this.f363d = c0054l1;
        this.f364e = new r3(context, c0021d0, c0093v1, c0107z, z12, c0054l1);
        P2.G.r((P2.E) this.f361b, P2.O.f1622a, new L(context, this, lVar, null), 2);
        P2.G.r((P2.E) this.f361b, P2.O.f1622a, new O(this, context, null), 2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable c(F0.Q r23, F0.C0035g2 r24, y2.AbstractC0787c r25) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.Q.c(F0.Q, F0.g2, y2.c):java.io.Serializable");
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

    public static final /* synthetic */ C0073q0 f(Q q3) {
        return (C0073q0) q3.f360a;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0061. Please report as an issue. */
    public Object a(Context context, AbstractC0787c abstractC0787c) {
        Context context2;
        char c4;
        char c5 = 53309;
        Iterator it = null;
        M m4 = null;
        T2 t22 = null;
        Object obj = null;
        EnumC0779a enumC0779a = null;
        Context context3 = context;
        while (true) {
            int i = 0;
            switch (c5) {
                case 29695:
                    context2 = context3;
                    t22 = (T2) it.next();
                    c4 = t22 == null ? (char) 63861 : (char) 51367;
                    context3 = context2;
                    c5 = c4;
                case 40237:
                    c4 = 62399;
                    c5 = c4;
                case 55940:
                    m4 = new M(this, abstractC0787c);
                    c4 = 33783;
                    c5 = c4;
                case 17844:
                    context2 = context3;
                    m4.f286e -= Integer.MIN_VALUE;
                    c4 = 33783;
                    context3 = context2;
                    c5 = c4;
                case 17114:
                    t22.a(context3);
                    c4 = 9734;
                    c5 = c4;
                case 62399:
                    context2 = context3;
                    c4 = it.hasNext() ? (char) 29695 : (char) 45399;
                    context3 = context2;
                    c5 = c4;
                case 50708:
                    it = m4.f283b;
                    context3 = m4.f282a;
                    AbstractC0228a.C(obj);
                    c5 = 51419;
                case 9734:
                case 63861:
                    c4 = 40237;
                    c5 = c4;
                case 33783:
                    context2 = context3;
                    obj = m4.f284c;
                    m3.b.o();
                    enumC0779a = EnumC0779a.f6740a;
                    int i3 = m4.f286e;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            c4 = 50708;
                        }
                        c4 = 52987;
                    } else {
                        c4 = 7934;
                    }
                    context3 = context2;
                    c5 = c4;
                case 45399:
                    return C0684i.f6340a;
                case 21332:
                    context2 = context3;
                    m4 = (M) abstractC0787c;
                    long j2 = Integer.MIN_VALUE;
                    long j3 = m4.f286e;
                    long j4 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j5 = (j4 >>> 48) & 43690;
                    long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                    long j7 = (j6 | (j6 >>> 2)) & 252645135;
                    long j8 = (j4 >>> 32) & 43690;
                    long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = (((j7 | (j7 >>> 4)) & 16711935) << 24) | ((((j10 >>> 4) | j10) & 16711935) << 16);
                    long j12 = (j4 >>> 16) & 43690;
                    long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = j4 & 43690;
                    long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                    long j17 = (j16 | (j16 >>> 2)) & 252645135;
                    if (((int) (((j17 | (j17 >>> 4)) & 16711935) + (j11 | ((((j14 >>> 4) | j14) & 16711935) << 8)))) != 0) {
                        c4 = 17844;
                        context3 = context2;
                        c5 = c4;
                    }
                    c4 = 55940;
                    context3 = context2;
                    c5 = c4;
                case 26129:
                    return enumC0779a;
                case 51367:
                    context2 = context3;
                    c4 = t22.a() ? (char) 33276 : (char) 17114;
                    context3 = context2;
                    c5 = c4;
                case 52987:
                    byte[] bArr = new byte[47];
                    bArr[0] = -84;
                    bArr[1] = -25;
                    bArr[2] = -103;
                    bArr[3] = -93;
                    bArr[4] = 63;
                    bArr[5] = -20;
                    bArr[6] = 61;
                    bArr[7] = 39;
                    bArr[8] = 57;
                    bArr[9] = -58;
                    int i4 = ~Q.class.getName().length();
                    long j18 = 142621440;
                    long length = Q.class.getName().length() & 1590730304;
                    long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
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
                    bArr[10] = ((1985135699 & ((673399195 ^ i4) + (i4 & 673399195))) + ((int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26)))) ^ 2127757155;
                    bArr[11] = -3;
                    bArr[12] = -115;
                    bArr[13] = -58;
                    int i5 = ((~Q.class.getName().length()) | (-200595237)) & 805712012;
                    int length2 = Q.class.getName().length();
                    int i6 = 121668096 | ((100929540 + length2) - (length2 | 100929540));
                    int i7 = -i5;
                    int i8 = ((~i7) & i6) - (i7 & (~i6));
                    bArr[B0.a((~i8) | 927380098, 927380098 - i8)] = -81;
                    bArr[15] = -11;
                    bArr[16] = 100;
                    bArr[17] = -82;
                    bArr[18] = 115;
                    bArr[19] = 27;
                    bArr[20] = 11;
                    bArr[21] = 102;
                    long j33 = -1;
                    long length3 = Q.class.getName().length();
                    long j34 = (((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                    long j35 = (((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                    long j36 = (((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                    long j37 = (((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                    long j38 = j37 + (j36 | j35 | j34);
                    long j39 = j38 + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j40 = (j39 >>> 48) & 21845;
                    long j41 = ((j40 >>> 1) | j40) & 858993459;
                    long j42 = ((j41 >>> 2) | j41) & 252645135;
                    long j43 = (j39 >>> 32) & 21845;
                    long j44 = ((j43 >>> 1) | j43) & 858993459;
                    long j45 = ((j44 >>> 2) | j44) & 252645135;
                    long j46 = ((((j45 >>> 4) | j45) & 16711935) << 16) | ((((j42 >>> 4) | j42) & 16711935) << 24);
                    long j47 = (j39 >>> 16) & 21845;
                    long j48 = ((j47 >>> 1) | j47) & 858993459;
                    long j49 = ((j48 >>> 2) | j48) & 252645135;
                    long j50 = j39 & 21845;
                    long j51 = ((j50 >>> 1) | j50) & 858993459;
                    long j52 = ((j51 >>> 2) | j51) & 252645135;
                    int i9 = (int) ((((j52 >>> 4) | j52) & 16711935) + (((((j49 >>> 4) | j49) & 16711935) << 8) | j46));
                    int length4 = (1182793749 & (((-1107567366) ^ i9) + (i9 & (-1107567366)))) + (((Q.class.getName().length() | (-1107886086)) + 1107886086) | 593984);
                    bArr[22] = (((~length4) & 1183387750) - (1183387750 & length4)) + length4;
                    bArr[23] = -112;
                    bArr[24] = 96;
                    bArr[25] = 69;
                    bArr[26] = 79;
                    bArr[27] = 21;
                    bArr[28] = 48;
                    bArr[29] = -99;
                    bArr[30] = Byte.MIN_VALUE;
                    bArr[31] = 1;
                    bArr[32] = -102;
                    bArr[33] = -41;
                    long length5 = Q.class.getName().length();
                    long j53 = ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j38;
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
                    long j64 = j53 & 21845;
                    long j65 = ((j64 >>> 1) | j64) & 858993459;
                    long j66 = ((j65 >>> 2) | j65) & 252645135;
                    int length6 = (((((int) ((((j66 >>> 4) | j66) & 16711935) + (((((j63 >>> 4) | j63) & 16711935) << 8) | j60))) | (-1141138479)) & 662721832) + ((Q.class.getName().length() & 1143096936) | 1075970626)) ^ 1738692424;
                    long length7 = Q.class.getName().length();
                    long j67 = (j37 | (j35 + j34 + j36)) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
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
                    int i10 = (int) ((((((j77 >>> 4) | j77) & 16711935) << 8) + j74) | (((j80 >>> 4) | j80) & 16711935));
                    long j81 = 6579200;
                    long length8 = Q.class.getName().length();
                    long j82 = (((((((((j81 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j81 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j81 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j81 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
                    int i11 = ((i10 | (-402945295)) - (((-405042447) | i10) ^ 581075457)) + (((int) ((((((j92 >>> 4) | j92) & 16711935) << 8) + j89) | (((j95 >>> 4) | j95) & 16711935))) | 4484352);
                    bArr[length6] = (((~i11) & 585559903) - (585559903 & i11)) + i11;
                    bArr[35] = -88;
                    bArr[36] = -126;
                    bArr[37] = 45;
                    bArr[38] = 109;
                    bArr[39] = -64;
                    bArr[40] = 125;
                    bArr[41] = -33;
                    bArr[42] = -104;
                    bArr[43] = 67;
                    bArr[44] = -62;
                    bArr[45] = -58;
                    bArr[46] = 34;
                    byte[] bArr2 = new byte[47];
                    bArr2[0] = -49;
                    bArr2[1] = -122;
                    bArr2[2] = -11;
                    bArr2[3] = -49;
                    bArr2[4] = 31;
                    bArr2[5] = -104;
                    bArr2[6] = 82;
                    bArr2[7] = 7;
                    bArr2[8] = 30;
                    bArr2[9] = -76;
                    bArr2[10] = 85;
                    bArr2[11] = -114;
                    bArr2[12] = -8;
                    bArr2[13] = -85;
                    bArr2[14] = -54;
                    bArr2[15] = -46;
                    bArr2[16] = 68;
                    bArr2[17] = -52;
                    bArr2[18] = 22;
                    bArr2[19] = 125;
                    bArr2[20] = 100;
                    bArr2[21] = 20;
                    bArr2[22] = 86;
                    bArr2[23] = -80;
                    bArr2[24] = 71;
                    bArr2[25] = 44;
                    long j96 = -2058689060;
                    long j97 = ~Q.class.getName().length();
                    long b4 = c3.b((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j97 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j97 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j97 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j97 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j98 = (b4 >>> 48) & 43690;
                    long j99 = ((j98 >>> 2) | (j98 >>> 1)) & 858993459;
                    long j100 = (j99 | (j99 >>> 2)) & 252645135;
                    long j101 = (b4 >>> 32) & 43690;
                    long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
                    long j103 = (j102 | (j102 >>> 2)) & 252645135;
                    long j104 = (((j100 | (j100 >>> 4)) & 16711935) << 24) | (((j103 | (j103 >>> 4)) & 16711935) << 16);
                    long j105 = (b4 >>> 16) & 43690;
                    long j106 = ((j105 >>> 2) | (j105 >>> 1)) & 858993459;
                    long j107 = (j106 | (j106 >>> 2)) & 252645135;
                    long j108 = b4 & 43690;
                    long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                    long j110 = (j109 | (j109 >>> 2)) & 252645135;
                    int i12 = ((int) (((j110 | (j110 >>> 4)) & 16711935) + (j104 | (((j107 | (j107 >>> 4)) & 16711935) << 8)))) & 596445524;
                    long j111 = 646256640;
                    long length9 = Q.class.getName().length();
                    long j112 = (((((((((j111 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j111 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j111 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j111 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j113 = (j112 >>> 48) & 43690;
                    long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
                    long j115 = (j114 | (j114 >>> 2)) & 252645135;
                    long j116 = (j112 >>> 32) & 43690;
                    long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
                    long j118 = (j117 | (j117 >>> 2)) & 252645135;
                    long j119 = (((j118 | (j118 >>> 4)) & 16711935) << 16) + (((j115 | (j115 >>> 4)) & 16711935) << 24);
                    long j120 = (j112 >>> 16) & 43690;
                    long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
                    long j122 = (j121 | (j121 >>> 2)) & 252645135;
                    long j123 = j112 & 43690;
                    long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                    long j125 = (j124 | (j124 >>> 2)) & 252645135;
                    long j126 = 335581187;
                    long j127 = (int) (((j125 | (j125 >>> 4)) & 16711935) + (((j122 | (j122 >>> 4)) & 16711935) << 8) + j119);
                    long j128 = (((((((((j126 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j126 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j126 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j126 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j127 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j127 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j127 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j127 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j129 = (j128 >>> 48) & 43690;
                    long j130 = ((j129 >>> 2) | (j129 >>> 1)) & 858993459;
                    long j131 = (j130 | (j130 >>> 2)) & 252645135;
                    long j132 = (j128 >>> 32) & 43690;
                    long j133 = ((j132 >>> 2) | (j132 >>> 1)) & 858993459;
                    long j134 = (j133 | (j133 >>> 2)) & 252645135;
                    long j135 = (((j134 | (j134 >>> 4)) & 16711935) << 16) + (((j131 | (j131 >>> 4)) & 16711935) << 24);
                    long j136 = (j128 >>> 16) & 43690;
                    long j137 = ((j136 >>> 2) | (j136 >>> 1)) & 858993459;
                    long j138 = (j137 | (j137 >>> 2)) & 252645135;
                    long j139 = j128 & 43690;
                    long j140 = ((j139 >>> 2) | (j139 >>> 1)) & 858993459;
                    long j141 = (j140 | (j140 >>> 2)) & 252645135;
                    int i13 = (int) (((j141 | (j141 >>> 4)) & 16711935) | ((((j138 | (j138 >>> 4)) & 16711935) << 8) + j135));
                    bArr2[26] = 932026742 ^ (((i13 | i12) * 2) - (i12 ^ i13));
                    bArr2[27] = 99;
                    bArr2[28] = 95;
                    long j142 = 1976404231;
                    long j143 = ~Q.class.getName().length();
                    long b5 = c3.b((((((((j142 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j142 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j142 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j142 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j143 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((j143 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j143 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j143 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32)), 6148914691236517205L);
                    long j144 = (b5 >>> 48) & 43690;
                    long j145 = ((j144 >>> 2) | (j144 >>> 1)) & 858993459;
                    long j146 = (j145 | (j145 >>> 2)) & 252645135;
                    long j147 = (b5 >>> 32) & 43690;
                    long j148 = ((j147 >>> 2) | (j147 >>> 1)) & 858993459;
                    long j149 = (j148 | (j148 >>> 2)) & 252645135;
                    long j150 = (((j149 | (j149 >>> 4)) & 16711935) << 16) + (((j146 | (j146 >>> 4)) & 16711935) << 24);
                    long j151 = (b5 >>> 16) & 43690;
                    long j152 = ((j151 >>> 2) | (j151 >>> 1)) & 858993459;
                    long j153 = (j152 | (j152 >>> 2)) & 252645135;
                    long j154 = b5 & 43690;
                    long j155 = ((j154 >>> 2) | (j154 >>> 1)) & 858993459;
                    long j156 = (j155 | (j155 >>> 2)) & 252645135;
                    bArr2[((((int) (((j156 | (j156 >>> 4)) & 16711935) + ((((j153 | (j153 >>> 4)) & 16711935) << 8) | j150))) & 621936800) + ((Q.class.getName().length() & 1179814) | 32774)) ^ 621969595] = -10;
                    bArr2[30] = -27;
                    bArr2[31] = 38;
                    bArr2[32] = -70;
                    bArr2[33] = -96;
                    bArr2[34] = 55;
                    bArr2[35] = -36;
                    bArr2[36] = -22;
                    bArr2[37] = 13;
                    bArr2[38] = 14;
                    bArr2[39] = -81;
                    bArr2[40] = 15;
                    bArr2[41] = -80;
                    bArr2[42] = -19;
                    bArr2[43] = 55;
                    bArr2[44] = -85;
                    bArr2[45] = -88;
                    bArr2[46] = 71;
                    e(bArr, bArr2);
                    throw new IllegalStateException(new String(bArr, StandardCharsets.UTF_8).intern());
                case 51419:
                    c4 = 9734;
                    c5 = c4;
                case 33276:
                    W2.d dVar = P2.O.f1623b;
                    context2 = context3;
                    N n4 = new N(t22, context2, null, i);
                    m4.f282a = context2;
                    m4.f283b = it;
                    m4.f286e = 1;
                    c4 = P2.G.z(dVar, n4, m4) == enumC0779a ? (char) 26129 : (char) 51419;
                    context3 = context2;
                    c5 = c4;
                case 7934:
                    AbstractC0228a.C(obj);
                    ArrayList b6 = ((r3) this.f364e).b();
                    int i14 = ((~Q.class.getName().length()) | 723908432) & 1007488034;
                    int length10 = Q.class.getName().length();
                    byte[] bArr3 = {-78, 89, 24, -64, (i14 + (((length10 | 357042210) - (length10 ^ 357042210)) | 1128276480)) ^ 2135764499, 45, 38, -37, 5, -20, 53, -72, 104, -114, -57, -87, 123};
                    byte[] bArr4 = new byte[17];
                    bArr4[0] = -43;
                    bArr4[1] = 60;
                    bArr4[2] = 108;
                    bArr4[3] = -124;
                    bArr4[4] = 84;
                    bArr4[5] = 89;
                    bArr4[6] = 67;
                    bArr4[7] = -72;
                    bArr4[8] = 113;
                    bArr4[((((~Q.class.getName().length()) | 1807534783) & 1678690304) + ((Q.class.getName().length() & 68354178) | 135332290)) ^ 1814022603] = -125;
                    int i15 = ((~Q.class.getName().length()) | 306592451) & (-2090563281);
                    long j157 = 746594432;
                    long length11 = Q.class.getName().length() & (-1918852692);
                    long j158 = (((((((((j157 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j157 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j157 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j157 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                    long j159 = (j158 >>> 48) & 43690;
                    long j160 = ((j159 >>> 2) | (j159 >>> 1)) & 858993459;
                    long j161 = ((j160 >>> 2) | j160) & 252645135;
                    long j162 = (j158 >>> 32) & 43690;
                    long j163 = ((j162 >>> 2) | (j162 >>> 1)) & 858993459;
                    long j164 = ((j163 >>> 2) | j163) & 252645135;
                    long j165 = ((((j164 >>> 4) | j164) & 16711935) << 16) + ((((j161 >>> 4) | j161) & 16711935) << 24);
                    long j166 = (j158 >>> 16) & 43690;
                    long j167 = ((j166 >>> 2) | (j166 >>> 1)) & 858993459;
                    long j168 = ((j167 >>> 2) | j167) & 252645135;
                    long j169 = j158 & 43690;
                    long j170 = ((j169 >>> 2) | (j169 >>> 1)) & 858993459;
                    long j171 = ((j170 >>> 2) | j170) & 252645135;
                    bArr4[(-1343968859) ^ (i15 + ((int) ((((j171 >>> 4) | j171) & 16711935) | (((((j168 >>> 4) | j168) & 16711935) << 8) | j165))))] = 71;
                    bArr4[11] = -53;
                    int i16 = ((~Q.class.getName().length()) | (-1681842682)) & 135069696;
                    long j172 = 12416;
                    long length12 = (Q.class.getName().length() | (-794753)) + 794753;
                    long j173 = (((((((((j172 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j172 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j172 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j172 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length12 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length12 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length12 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length12 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j174 = (j173 >>> 48) & 43690;
                    long j175 = ((j174 >>> 2) | (j174 >>> 1)) & 858993459;
                    long j176 = ((j175 >>> 2) | j175) & 252645135;
                    long j177 = (j173 >>> 32) & 43690;
                    long j178 = ((j177 >>> 2) | (j177 >>> 1)) & 858993459;
                    long j179 = ((j178 >>> 2) | j178) & 252645135;
                    long j180 = ((((j179 >>> 4) | j179) & 16711935) << 16) + ((((j176 >>> 4) | j176) & 16711935) << 24);
                    long j181 = (j173 >>> 16) & 43690;
                    long j182 = ((j181 >>> 2) | (j181 >>> 1)) & 858993459;
                    long j183 = ((j182 >>> 2) | j182) & 252645135;
                    long j184 = j173 & 43690;
                    long j185 = ((j184 >>> 2) | (j184 >>> 1)) & 858993459;
                    long j186 = (j185 | (j185 >>> 2)) & 252645135;
                    bArr4[(i16 + ((int) ((((((j183 >>> 4) | j183) & 16711935) << 8) | j180) | ((j186 | (j186 >>> 4)) & 16711935)))) ^ 135082124] = 64;
                    bArr4[13] = -96;
                    bArr4[14] = -23;
                    bArr4[15] = -121;
                    bArr4[16] = 82;
                    e(bArr3, bArr4);
                    new String(bArr3, StandardCharsets.UTF_8).intern();
                    it = b6.iterator();
                    c5 = 62399;
                    context3 = context3;
                case 53309:
                    if (abstractC0787c instanceof M) {
                        c5 = 21332;
                    } else {
                        context2 = context3;
                        c4 = 55940;
                        context3 = context2;
                        c5 = c4;
                    }
                default:
                    context2 = context3;
                    c4 = 52987;
                    context3 = context2;
                    c5 = c4;
            }
        }
    }

    public void d(Object obj, Object obj2, W1.f0 f0Var, boolean z3) {
        byte[] array;
        if (((ConcurrentHashMap) this.f361b) != null) {
            if (obj == null && obj2 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            }
            if (f0Var.D() == W1.Z.ENABLED) {
                Integer valueOf = Integer.valueOf(f0Var.B());
                byte[] bArr = null;
                if (f0Var.C() == W1.r0.RAW) {
                    valueOf = null;
                }
                K1.b a2 = R1.h.f1992b.a(R1.n.b(f0Var.A().B(), f0Var.A().C(), f0Var.A().A(), f0Var.C(), valueOf));
                int ordinal = f0Var.C().ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal != 4) {
                                throw new GeneralSecurityException("unknown output prefix type");
                            }
                        } else {
                            array = K1.b.f1081a;
                        }
                    }
                    array = ByteBuffer.allocate(5).put((byte) 0).putInt(f0Var.B()).array();
                } else {
                    array = ByteBuffer.allocate(5).put((byte) 1).putInt(f0Var.B()).array();
                }
                K1.k kVar = new K1.k(obj, obj2, array, f0Var.D(), f0Var.C(), f0Var.B(), f0Var.A().B(), a2);
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f361b;
                ArrayList arrayList = (ArrayList) this.f362c;
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(kVar);
                byte[] bArr2 = kVar.f1095c;
                if (bArr2 != null) {
                    bArr = Arrays.copyOf(bArr2, bArr2.length);
                }
                K1.l lVar = new K1.l(bArr);
                List list = (List) concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList2));
                if (list != null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(list);
                    arrayList3.add(kVar);
                    concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList3));
                }
                arrayList.add(kVar);
                if (z3) {
                    if (((K1.k) this.f363d) == null) {
                        this.f363d = kVar;
                        return;
                    }
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                return;
            }
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        throw new IllegalStateException("addPrimitive cannot be called after build");
    }

    public Date g() {
        G1 g12 = (G1) this.f363d;
        if (((AtomicReference) g12.f218b).get() != null) {
            long[] ntpResult = (long[]) ((AtomicReference) g12.f218b).get();
            kotlin.jvm.internal.j.d(ntpResult, "ntpResult");
            return new Date((SystemClock.elapsedRealtime() - ntpResult[7]) + ntpResult[3] + androidx.lifecycle.N.e(ntpResult));
        }
        throw new IllegalStateException("TrueTime was not initialized successfully yet");
    }

    public long[] h(C0035g2 c0035g2, InetAddress address) {
        DatagramSocket datagramSocket;
        long[] jArr;
        androidx.lifecycle.N n4 = (androidx.lifecycle.N) this.f362c;
        c0035g2.getClass();
        C0328a c0328a = (C0328a) this.f361b;
        synchronized (n4) {
            c0328a.getClass();
            kotlin.jvm.internal.j.e(address, "address");
            DatagramSocket datagramSocket2 = null;
            try {
                try {
                    datagramSocket = new DatagramSocket();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    datagramSocket.setSoTimeout(30000);
                    byte[] bArr = new byte[48];
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, address, 123);
                    bArr[0] = 27;
                    long currentTimeMillis = System.currentTimeMillis();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    androidx.lifecycle.N.o(bArr, currentTimeMillis);
                    datagramSocket.send(datagramPacket);
                    jArr = new long[8];
                    datagramSocket.receive(new DatagramPacket(bArr, 48));
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    jArr[7] = elapsedRealtime2;
                    long m4 = androidx.lifecycle.N.m(bArr, 24);
                    long m5 = androidx.lifecycle.N.m(bArr, 32);
                    long m6 = androidx.lifecycle.N.m(bArr, 40);
                    long j2 = (elapsedRealtime2 - elapsedRealtime) + currentTimeMillis;
                    jArr[0] = m4;
                    jArr[1] = m5;
                    jArr[2] = m6;
                    jArr[3] = j2;
                    long l3 = androidx.lifecycle.N.l(bArr, 4);
                    jArr[4] = l3;
                    double d2 = l3 / 65.536d;
                    double d4 = 100.0f;
                    if (d2 <= d4) {
                        long l4 = androidx.lifecycle.N.l(bArr, 8);
                        jArr[5] = l4;
                        double d5 = l4 / 65.536d;
                        if (d5 <= d4) {
                            byte b4 = bArr[0];
                            byte b5 = (byte) (b4 & 7);
                            if (b5 != 4 && b5 != 5) {
                                throw new InvalidNtpServerResponseException("untrusted mode value for TrueTime: " + ((int) b5));
                            }
                            int i = bArr[1] & ForkServer.ERROR;
                            jArr[6] = i;
                            if (i >= 1 && i <= 15) {
                                if (((byte) ((b4 >> 6) & 3)) != 3) {
                                    double abs = Math.abs((j2 - m4) - (m6 - m5));
                                    if (abs < 750) {
                                        long abs2 = Math.abs(m4 - System.currentTimeMillis());
                                        if (abs2 < 10000) {
                                            datagramSocket.close();
                                        } else {
                                            throw new InvalidNtpServerResponseException("Request was sent more than 10 seconds back " + abs2);
                                        }
                                    } else {
                                        throw new InvalidNtpServerResponseException("%s too large for comfort %f [actual] >= %f [expected]", "server_response_delay", (float) abs, 750);
                                    }
                                } else {
                                    throw new IOException("unsynchronized server responded for TrueTime");
                                }
                            } else {
                                throw new InvalidNtpServerResponseException("untrusted stratum value for TrueTime: " + i);
                            }
                        } else {
                            throw new InvalidNtpServerResponseException("Invalid response from NTP server. %s violation. %f [actual] > %f [expected]", "root_dispersion", (float) d5, 100.0f);
                        }
                    } else {
                        throw new InvalidNtpServerResponseException("Invalid response from NTP server. %s violation. %f [actual] > %f [expected]", "root_delay", (float) d2, 100.0f);
                    }
                } catch (Exception e4) {
                    throw e4;
                } catch (Throwable th2) {
                    th = th2;
                    datagramSocket2 = datagramSocket;
                    if (datagramSocket2 != null) {
                        datagramSocket2.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                throw e5;
            }
        }
        return jArr;
    }

    public Q() {
        C0035g2 c0035g2 = new C0035g2(AbstractC0708j.V("time.google.com"), 10);
        W2.d dispatcher = P2.O.f1623b;
        kotlin.jvm.internal.j.e(dispatcher, "dispatcher");
        this.f360a = c0035g2;
        C0328a c0328a = C0328a.f3881a;
        this.f361b = c0328a;
        androidx.lifecycle.N n4 = new androidx.lifecycle.N(5);
        this.f362c = n4;
        this.f363d = new G1(n4, c0328a);
        this.f364e = P2.G.b(T.b.F(new C0161k0(), dispatcher).plus(new e2.c(this)));
    }

    public Q(Class cls) {
        this.f361b = new ConcurrentHashMap();
        this.f362c = new ArrayList();
        this.f360a = cls;
        this.f364e = U1.a.f2331b;
    }
}
