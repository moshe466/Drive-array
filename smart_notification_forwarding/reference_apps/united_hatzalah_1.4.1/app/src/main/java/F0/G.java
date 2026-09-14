package F0;

import P2.C0143b0;
import P2.C0161k0;
import P2.C0169t;
import android.content.Context;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import org.apache.tika.fork.ForkServer;
import org.json.JSONObject;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: h, reason: collision with root package name */
    public static G f208h;
    public static final ReentrantLock i = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public C0073q0 f209a;

    /* renamed from: b, reason: collision with root package name */
    public C0051k2 f210b;

    /* renamed from: c, reason: collision with root package name */
    public C0047j2 f211c;

    /* renamed from: d, reason: collision with root package name */
    public C0107z f212d;

    /* renamed from: e, reason: collision with root package name */
    public Q f213e;

    /* renamed from: f, reason: collision with root package name */
    public C0169t f214f;

    /* renamed from: g, reason: collision with root package name */
    public final U2.e f215g;

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x03c9. Please report as an issue. */
    public G(Context context, G0.l lVar, G0.m mVar) {
        int[] iArr;
        InterfaceC0768i interfaceC0768i;
        int[] iArr2;
        ExecutorService executorService;
        byte[] bArr;
        int[] iArr3 = E.f186a;
        int i3 = iArr3[mVar.ordinal()];
        int i4 = 2;
        if (i3 == 1) {
            iArr = iArr3;
            interfaceC0768i = null;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new B(0));
            byte[] bArr2 = {-105, 67, -115, -104, 112, 7, -58, -87, 35, -66, -109, 51, 60, -107, 31, 60, 3, -1, -110, -119, 78, 79, -51, -19, 1, 23, 55, 123};
            int i5 = 3;
            long j2 = 1597185822;
            long j3 = ~G.class.getName().length();
            long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
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
            long j16 = ((j15 >>> 2) | j15) & 252645135;
            int i6 = (int) ((((j16 >>> 4) | j16) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10);
            long j17 = 1099445617;
            long j18 = i6;
            long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
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
            int length = G.class.getName().length() & 8988771;
            byte[] bArr3 = {16, -9, 15, -77, 48, (((((G.class.getName().length() | (-153747969)) + 153747969) | 136708100) - (~(((~G.class.getName().length()) | (-1527322383)) & 21547520))) - 1) ^ 158255677, -73, -84, 93, -70, 17, 41, 112, -60, -111, 96, -110, 106, 7, -28, 81, -16, -44, -84, 1771650357 ^ ((((~length) & 672204802) + length) + ((int) ((((((j29 >>> 4) | j29) & 16711935) << 8) | j26) | (((j32 >>> 4) | j32) & 16711935)))), 9, 47, 57};
            int i7 = 1516727821;
            int i8 = 1;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            byte[] bArr4 = null;
            byte[] bArr5 = null;
            while (true) {
                int i12 = ((i7 & 16777216) * (i7 | 16777216)) + ((i7 & (-16777217)) * ((~i7) & 16777216));
                int i13 = i7 >>> 8;
                int i14 = i4;
                int a2 = j3.a((~i12) & 650911840 & i13, i13, i12, (i12 | 650911840) & i13);
                int i15 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
                switch (((~i15) + ((i15 | 1) * 2)) ^ 962785775) {
                    case -1896910703:
                        int[] iArr4 = iArr3;
                        ExecutorService executorService2 = newSingleThreadExecutor;
                        byte[] bArr6 = bArr3;
                        int length2 = bArr5.length;
                        int i16 = 0 - i9;
                        int i17 = (length2 ^ i16) + ((length2 & i16) * 2);
                        byte b5 = bArr4[i17];
                        int length3 = bArr5.length;
                        int i18 = 0 - i16;
                        int i19 = i18 | length3;
                        byte b6 = bArr4[D.a(i18, 2, i19, (length3 ^ i18) ^ i19)];
                        bArr4[i17] = (byte) (((byte) (((byte) 2) * ((byte) (b6 | b5)))) - ((byte) (b6 ^ b5)));
                        iArr3 = iArr4;
                        bArr3 = bArr6;
                        newSingleThreadExecutor = executorService2;
                        i7 = -746753280;
                        i4 = 2;
                        i8 = 1;
                        i5 = 3;
                    case -1725904394:
                        iArr2 = iArr3;
                        executorService = newSingleThreadExecutor;
                        bArr = bArr3;
                        i11 = bArr5.length % 4;
                        if ((((i11 > 1 ? 1 : (i11 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                            iArr3 = iArr2;
                            bArr3 = bArr;
                            newSingleThreadExecutor = executorService;
                            i7 = -365117735;
                            i4 = 2;
                            i8 = 1;
                            i5 = 3;
                        }
                        i7 = -458924450;
                        iArr3 = iArr2;
                        bArr3 = bArr;
                        newSingleThreadExecutor = executorService;
                        i4 = 2;
                        i8 = 1;
                        i5 = 3;
                    case -1399959314:
                        iArr2 = iArr3;
                        byte[] bArr7 = bArr3;
                        int a4 = j3.a((-1205100636) & i10, i10, 3, (-1205100633) & i10);
                        byte b7 = bArr4[a4];
                        int i20 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                        int i21 = i10 - 1;
                        int i22 = i21 - (i10 | (-3));
                        int i23 = bArr4[i22] & ForkServer.ERROR;
                        bArr = bArr7;
                        int i24 = i23 * ((~i23) & 65536);
                        executorService = newSingleThreadExecutor;
                        int a5 = S.a(i24, i20, i8, ((-1) - i24) | ((-1) - i20));
                        int i25 = i21 - (i10 | (-2));
                        int i26 = bArr4[i25] & ForkServer.ERROR;
                        int i27 = i26 * ((~i26) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                        int i28 = (i27 - 1) - ((~a5) | i27);
                        int i29 = bArr4[i10] & ForkServer.ERROR;
                        int a6 = S.a(i28, i29, 1, ((-1) - i28) | ((-1) - i29));
                        byte b8 = bArr5[a4];
                        int i30 = ((b8 & ForkServer.DONE) * (b8 | ForkServer.DONE)) + ((b8 & ForkServer.ERROR) * ((~b8) & 16777216));
                        int i31 = bArr5[i22] & ForkServer.ERROR;
                        int i32 = ((i31 * ((~i31) & 65536)) & (~i30)) + i30;
                        int i33 = bArr5[i25] & ForkServer.ERROR;
                        int i34 = i33 * ((~i33) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                        int i35 = ~((((~i34) | 911399251) | i32) - ((i34 & 911399251) | i32));
                        int i36 = bArr5[i10] & ForkServer.ERROR;
                        int i37 = ~((((~i35) | 1433568692) | i36) - ((i35 & 1433568692) | i36));
                        int i38 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                        int i39 = (-1254002618) - ((i38 & 2) | ((-1672003491) - i38));
                        int i40 = (i39 + i37) - ((i39 & i37) * 2);
                        bArr5[i10] = (byte) i40;
                        bArr5[i25] = (byte) (i40 >>> 8);
                        bArr5[i22] = (byte) (i40 >>> 16);
                        bArr5[a4] = (byte) (i40 >>> 24);
                        i10 = (i10 ^ 4) + ((i10 & 4) * 2);
                        int length4 = bArr5.length;
                        int length5 = 0 - (bArr5.length % 4);
                        int i41 = ((i10 > AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 1 : (i10 == AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 0 : -1)) >>> 31) & 1;
                        i7 = i41 != 0 ? i41 != 0 ? -1605440657 : -365117735 : -169475207;
                        iArr3 = iArr2;
                        bArr3 = bArr;
                        newSingleThreadExecutor = executorService;
                        i4 = 2;
                        i8 = 1;
                        i5 = 3;
                    case -1135475043:
                        break;
                    case 180635757:
                        bArr4 = bArr3;
                        bArr5 = bArr2;
                        iArr3 = iArr3;
                        i10 = 0;
                        i7 = -1605440657;
                        i4 = 2;
                        i5 = 3;
                    case 511524454:
                        int length6 = bArr5.length;
                        int i42 = 0 - i9;
                        int i43 = 0 - i42;
                        int i44 = ((~length6) & i43) * 2;
                        int length7 = bArr5.length;
                        byte b9 = bArr5[((length7 | i42) * 2) - (length7 ^ i42)];
                        int length8 = bArr5.length;
                        byte b10 = bArr4[(i42 ^ length8) + ((length8 & i42) * 2)];
                        iArr2 = iArr3;
                        bArr5[(length6 ^ i43) - i44] = (byte) (((byte) (b10 - b9)) + ((byte) (((byte) i14) * ((byte) ((~b10) & b9)))));
                        i11 = AbstractC0099x.a(i9, i5, (~i9) * 2);
                        byte[] bArr8 = bArr3;
                        if ((((i9 > 2 ? 1 : (i9 == 2 ? 0 : -1)) >>> 31) & 1) != 0) {
                            bArr = bArr8;
                            executorService = newSingleThreadExecutor;
                            i7 = -458924450;
                            iArr3 = iArr2;
                            bArr3 = bArr;
                            newSingleThreadExecutor = executorService;
                            i4 = 2;
                            i8 = 1;
                            i5 = 3;
                        } else {
                            bArr3 = bArr8;
                            iArr3 = iArr2;
                            i7 = -365117735;
                            i4 = 2;
                            i5 = 3;
                        }
                    case 961838909:
                        int length9 = bArr5.length;
                        int i45 = 0 - i11;
                        int i46 = (((double) ((byte) bArr4[((length9 | i45) - (((~i45) & 165327505) & length9)) + ((i45 | 165327505) & length9)])) > Double.NaN ? 1 : (((double) ((byte) bArr4[((length9 | i45) - (((~i45) & 165327505) & length9)) + ((i45 | 165327505) & length9)])) == Double.NaN ? 0 : -1)) <= -1 ? 0 : i8;
                        i7 = i46 != 0 ? -746753280 : i46 != 0 ? -365117735 : 1093626513;
                        i9 = i11;
                        i4 = i14;
                    default:
                        iArr2 = iArr3;
                        executorService = newSingleThreadExecutor;
                        bArr = bArr3;
                        i7 = -365117735;
                        iArr3 = iArr2;
                        bArr3 = bArr;
                        newSingleThreadExecutor = executorService;
                        i4 = 2;
                        i8 = 1;
                        i5 = 3;
                }
                iArr = iArr3;
                kotlin.jvm.internal.j.d(newSingleThreadExecutor, new String(bArr2, StandardCharsets.UTF_8).intern());
                interfaceC0768i = new C0143b0(newSingleThreadExecutor);
            }
        }
        C0161k0 c0161k0 = new C0161k0();
        if (interfaceC0768i == null) {
            W2.e eVar = P2.O.f1622a;
            interfaceC0768i = U2.n.f2372a;
        }
        U2.e b11 = P2.G.b(T.b.F(c0161k0, interfaceC0768i));
        this.f215g = b11;
        int i47 = iArr[mVar.ordinal()];
        if (i47 == 1) {
            this.f209a = new C0073q0(context);
            b(context, lVar);
        } else {
            if (i47 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            P2.G.r(b11, null, new C(this, context, lVar, null), 3);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -894652659;
        byte[] bArr4 = null;
        while (true) {
            int i7 = ((i6 & 16777216) * (i6 | 16777216)) + ((i6 & (-16777217)) * ((~i6) & 16777216));
            int i8 = i6 >>> 8;
            int i9 = (i8 + i7) - (i8 & i7);
            int i10 = (i9 ^ 1458005263) + ((i9 & 1458005263) * 2);
            int i11 = 145880015;
            int i12 = 1298988808;
            boolean z3 = true;
            switch ((i10 - 1434379843) + (((~i10) & 1434379843) * 2)) {
                case -1970406716:
                    int length = bArr4.length;
                    int i13 = 0 - i3;
                    int i14 = ~i13;
                    int i15 = ((length | i13) - ((602749225 & i14) & length)) + ((i13 | 602749225) & length);
                    byte b4 = bArr3[i15];
                    int length2 = bArr4.length;
                    byte b5 = bArr3[(length2 ^ i14) + ((i13 | length2) * 2) + 1];
                    int i16 = ((byte) 0) - b4;
                    bArr3[i15] = (byte) (((byte) (((byte) 2) * ((byte) (b5 & (~i16))))) - ((byte) (b5 ^ i16)));
                    i6 = -34715366;
                case -1882653318:
                    int i17 = (i4 - 1) - (i4 | (-4));
                    byte b6 = bArr3[i17];
                    int i18 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i19 = i4 + 3 + (((-1) - i4) | (-3));
                    int i20 = bArr3[i19] & ForkServer.ERROR;
                    int i21 = i20 * ((~i20) & 65536);
                    int i22 = ~((i18 | ((~i21) | 1169991170)) - ((i21 & 1169991170) | i18));
                    int a2 = j3.a(689061172 & i4, i4, 1, 689061173 & i4);
                    int i23 = bArr3[a2] & ForkServer.ERROR;
                    int i24 = ((~i22) & (i23 * ((~i23) & UserVerificationMethods.USER_VERIFY_HANDPRINT))) + i22;
                    int i25 = (i24 - 1) - ((~(bArr3[i4] & ForkServer.ERROR)) | i24);
                    byte b7 = bArr4[i17];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i19] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = ~((i26 | ((~i28) | (-445685625))) - ((i28 & (-445685625)) | i26));
                    int i30 = bArr4[a2] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i32 = (i31 + i29) - (i31 & i29);
                    int i33 = bArr4[i4] & ForkServer.ERROR;
                    int i34 = (i32 & (~i33)) + i33;
                    int i35 = i25 << ((i25 > Double.NaN ? 1 : (i25 == Double.NaN ? 0 : -1)) >>> 31);
                    int i36 = (i35 + i34) - ((i35 & i34) * 2);
                    int i37 = 659933421 - ((i36 & 2) | ((-1983400303) - i36));
                    bArr4[i4] = (byte) i37;
                    bArr4[a2] = (byte) (i37 >>> 8);
                    bArr4[i19] = (byte) (i37 >>> 16);
                    bArr4[i17] = (byte) (i37 >>> 24);
                    i4 = (i4 ^ 4) + ((i4 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i38 = ((i4 > ((length3 ^ length4) + ((length3 & length4) * 2)) ? 1 : (i4 == ((length3 ^ length4) + ((length3 & length4) * 2)) ? 0 : -1)) >>> 31) & 1;
                    if (i38 != 0) {
                        i11 = 196573321;
                    }
                    if (i38 != 0) {
                        i6 = -826922365;
                    } else {
                        i6 = i11;
                    }
                case -625567707:
                    break;
                case 172635213:
                    int length5 = bArr4.length;
                    int i39 = 0 - i5;
                    if ((bArr3[(length5 ^ i39) + ((length5 & i39) * 2)] > Double.NaN ? 1 : (bArr3[(length5 ^ i39) + ((length5 & i39) * 2)] == Double.NaN ? 0 : -1)) <= -1) {
                        i6 = 196573321;
                    } else {
                        i6 = -34715366;
                    }
                    i3 = i5;
                case 614184219:
                    int length6 = bArr4.length;
                    int i40 = 0 - i3;
                    int i41 = i40 * 3;
                    int a4 = D1.a(i40, length6);
                    int length7 = bArr4.length;
                    byte b8 = bArr4[(length7 ^ i40) + ((length7 & i40) * 2)];
                    int length8 = bArr4.length;
                    int i42 = 0 - i40;
                    byte b9 = bArr3[(((~i42) & length8) * 2) - (length8 ^ i42)];
                    bArr4[AbstractC0014b1.a((length6 & 2) | a4, i41)] = (byte) (((byte) (b9 + b8)) - ((byte) (((byte) 2) * ((byte) (b9 & b8)))));
                    i5 = ((-338014207) | i3) + (338014206 | i3);
                    int i43 = ((i3 > 2 ? 1 : (i3 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i43 != 0) {
                        i12 = 196573321;
                    }
                    if (i43 == 0) {
                        i6 = i12;
                    } else {
                        i6 = -518432968;
                    }
                case 835516413:
                    int length9 = bArr.length;
                    int length10 = 0 - (0 - (bArr.length % 4));
                    if ((length9 ^ length10) - (((~length9) & length10) * 2) <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i11 = 196573321;
                    }
                    if (z3) {
                        i6 = -826922365;
                    } else {
                        i6 = i11;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i4 = 0;
                case 1888416065:
                    i5 = bArr4.length % 4;
                    int i44 = ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i44 != 0) {
                        i12 = 196573321;
                    }
                    if (i44 == 0) {
                        i6 = i12;
                    } else {
                        i6 = -518432968;
                    }
                default:
                    i6 = 196573321;
            }
            return;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final java.lang.Object a(android.content.Context r61, G0.l r62, y2.AbstractC0787c r63) {
        /*
            Method dump skipped, instructions count: 2860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.G.a(android.content.Context, G0.l, y2.c):java.lang.Object");
    }

    public final void b(Context context, G0.l lVar) {
        C0051k2 c0051k2 = C0051k2.f555e;
        this.f210b = AbstractC0039h2.b(lVar);
        C0073q0 c0073q0 = this.f209a;
        if (c0073q0 != null) {
            this.f211c = new C0047j2(c0073q0.f608a);
            ReentrantLock reentrantLock = C0107z.f717h;
            C0073q0 c0073q02 = this.f209a;
            if (c0073q02 != null) {
                C0051k2 c0051k22 = this.f210b;
                if (c0051k22 != null) {
                    this.f212d = AbstractC0103y.a(c0073q02, context, c0051k22.a(), lVar.d());
                    C0047j2 c0047j2 = this.f211c;
                    if (c0047j2 == null) {
                        byte[] bArr = {-104, -79, 123, -67, 76, 102, 28, 83, 17, -28, -127};
                        c(bArr, new byte[]{Byte.MIN_VALUE, -2, -91, 104, 69, 55, -92, -99, 112, -125, -14});
                        kotlin.jvm.internal.j.i(new String(bArr, StandardCharsets.UTF_8).intern());
                        throw null;
                    }
                    C0021d0 a2 = c0047j2.a();
                    C0073q0 c0073q03 = this.f209a;
                    if (c0073q03 != null) {
                        String n4 = c0073q03.f608a.n();
                        C0107z c0107z = this.f212d;
                        if (c0107z != null) {
                            C0051k2 c0051k23 = this.f210b;
                            if (c0051k23 == null) {
                                int i3 = ((~G.class.getName().length()) | (-369265420)) & 33735317;
                                int length = G.class.getName().length() & 637702657;
                                byte[] bArr2 = new byte[906156702 ^ ((((((G.class.getName().length() & (~length)) & 872421376) + 872421376) + length) - ((length | G.class.getName().length()) & 872421376)) + i3)];
                                int i4 = (1208091808 - ((~(G.class.getName().length() & 738263049)) | 1208091809)) + (((~G.class.getName().length()) | 1542645703) & 891404360);
                                bArr2[0] = (((~i4) & (-2099496097)) - ((-2099496097) & i4)) + i4;
                                bArr2[1] = -55;
                                bArr2[2] = -118;
                                bArr2[3] = -63;
                                bArr2[4] = 85;
                                int i5 = ((~G.class.getName().length()) | (-1752106883)) & (-1873801179);
                                int length2 = G.class.getName().length() & 4219136;
                                int length3 = ((((G.class.getName().length() & (~length2)) & 8416528) + 8416528) + length2) - ((length2 | G.class.getName().length()) & 8416528);
                                int i6 = -i5;
                                bArr2[(-1865384656) ^ ((((~i6) & length3) * 2) - (i6 ^ length3))] = 46;
                                bArr2[6] = -61;
                                bArr2[7] = -78;
                                bArr2[8] = 33;
                                bArr2[9] = 1;
                                bArr2[10] = -8;
                                byte[] bArr3 = new byte[11];
                                bArr3[0] = -67;
                                bArr3[1354028711 ^ ((((G.class.getName().length() & 1074054306) | 1075085444) + (~(-(((~G.class.getName().length()) | (-1716315516)) & 278943266)))) + 1)] = -109;
                                bArr3[2] = ((((~G.class.getName().length()) | 206117583) & (-1540843440)) + ((G.class.getName().length() & (-1335853007)) | 423624737)) ^ (-1117218788);
                                bArr3[3] = 6;
                                bArr3[4] = 93;
                                bArr3[5] = 31;
                                bArr3[6] = 34;
                                bArr3[7] = 98;
                                bArr3[8] = 71;
                                bArr3[9] = 104;
                                bArr3[10] = -97;
                                c(bArr2, bArr3);
                                kotlin.jvm.internal.j.i(new String(bArr2, StandardCharsets.UTF_8).intern());
                                throw null;
                            }
                            C0073q0 c0073q04 = this.f209a;
                            if (c0073q04 == null) {
                                byte[] bArr4 = {-109, 68, 75, 0, -98, -101, -57};
                                byte[] bArr5 = new byte[8];
                                bArr5[0] = -124;
                                bArr5[1] = 38;
                                bArr5[2] = -86;
                                bArr5[3] = -44;
                                bArr5[4] = -1;
                                bArr5[5] = -4;
                                bArr5[((((~G.class.getName().length()) | 1863113582) & 1208008743) + ((G.class.getName().length() & 18886657) | 19020800)) ^ 1227029537] = -94;
                                int i7 = ~G.class.getName().length();
                                bArr5[7] = (-2040662040) ^ (((((-1026516636) | i7) + 5633212) - (i7 | (-1026163204))) + ((G.class.getName().length() & 33907864) | (-2046295296)));
                                c(bArr4, bArr5);
                                kotlin.jvm.internal.j.i(new String(bArr4, StandardCharsets.UTF_8).intern());
                                throw null;
                            }
                            JSONObject b4 = P2.b(context, c0073q04.f608a.q());
                            C0073q0 c0073q05 = this.f209a;
                            if (c0073q05 != null) {
                                this.f213e = new Q(context, a2, n4, c0107z, c0051k23, lVar, b4, c0073q05, this.f215g);
                                C0061n0 c0061n0 = C0061n0.f585a;
                                C0073q0 c0073q06 = this.f209a;
                                if (c0073q06 != null) {
                                    C0026e1 c0026e1 = c0073q06.f608a;
                                    c0061n0.getClass();
                                    C0061n0.f(context, lVar, c0026e1, this.f215g);
                                    return;
                                } else {
                                    int length4 = (939588816 & (1857263730 - ((~(~G.class.getName().length())) | 1857263731))) + ((G.class.getName().length() & 335570048) | 110362883);
                                    byte[] bArr6 = {87, -112, -93, (((~length4) & (-1049951723)) - ((-1049951723) & length4)) + length4, 34, -30, -25};
                                    c(bArr6, new byte[]{64, -14, 66, 18, 67, -123, -126, 104});
                                    kotlin.jvm.internal.j.i(new String(bArr6, StandardCharsets.UTF_8).intern());
                                    throw null;
                                }
                            }
                            byte[] bArr7 = new byte[7];
                            bArr7[0] = -34;
                            bArr7[1] = 107;
                            bArr7[2] = -105;
                            bArr7[3] = 19;
                            int i8 = ((~G.class.getName().length()) | (-663383210)) & 45254533;
                            long j2 = -2105391991;
                            long length5 = G.class.getName().length();
                            long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                            long j4 = (j3 >>> 48) & 43690;
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
                            long j16 = (j15 | (j15 >>> 2)) & 252645135;
                            bArr7[(i8 + (((int) (((j16 | (j16 >>> 4)) & 16711935) | (((((j13 >>> 4) | j13) & 16711935) << 8) + j10))) | (-2147458968))) ^ (-2102204439)] = 61;
                            bArr7[5] = 97;
                            bArr7[6] = -11;
                            byte[] bArr8 = new byte[((((~G.class.getName().length()) | 1838290888) & 547688967) + ((G.class.getName().length() & 2424855) | 151027984)) ^ 698716959];
                            bArr8[0] = -55;
                            bArr8[1] = 9;
                            bArr8[2] = 118;
                            bArr8[3] = -57;
                            bArr8[4] = 92;
                            bArr8[5] = 6;
                            bArr8[6] = -112;
                            bArr8[7] = -18;
                            c(bArr7, bArr8);
                            kotlin.jvm.internal.j.i(new String(bArr7, StandardCharsets.UTF_8).intern());
                            throw null;
                        }
                        byte[] bArr9 = new byte[16];
                        bArr9[0] = 92;
                        bArr9[1] = 39;
                        bArr9[2] = 105;
                        bArr9[3] = -98;
                        bArr9[4] = 24;
                        bArr9[5] = 31;
                        bArr9[6] = -101;
                        long j17 = 1962766281;
                        long j18 = ~G.class.getName().length();
                        long b5 = c3.b((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
                        long j19 = (b5 >>> 48) & 43690;
                        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
                        long j21 = ((j20 >>> 2) | j20) & 252645135;
                        long j22 = (b5 >>> 32) & 43690;
                        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                        long j24 = ((j23 >>> 2) | j23) & 252645135;
                        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) + ((((j21 >>> 4) | j21) & 16711935) << 24);
                        long j26 = (b5 >>> 16) & 43690;
                        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
                        long j28 = ((j27 >>> 2) | j27) & 252645135;
                        long j29 = b5 & 43690;
                        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                        long j31 = ((j30 >>> 2) | j30) & 252645135;
                        int i9 = (int) ((((j31 >>> 4) | j31) & 16711935) | (((((j28 >>> 4) | j28) & 16711935) << 8) + j25));
                        long j32 = -2146892129;
                        long j33 = i9;
                        long j34 = ((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j35 = (j34 >>> 48) & 43690;
                        long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                        long j37 = ((j36 >>> 2) | j36) & 252645135;
                        long j38 = (j34 >>> 32) & 43690;
                        long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                        long j40 = ((j39 >>> 2) | j39) & 252645135;
                        long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) | ((((j37 >>> 4) | j37) & 16711935) << 24);
                        long j42 = (j34 >>> 16) & 43690;
                        long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
                        long j44 = ((j43 >>> 2) | j43) & 252645135;
                        long j45 = j34 & 43690;
                        long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                        long j47 = ((j46 >>> 2) | j46) & 252645135;
                        int i10 = (int) ((((j47 >>> 4) | j47) & 16711935) + (((((j44 >>> 4) | j44) & 16711935) << 8) | j41));
                        long j48 = -1878630378;
                        long length6 = G.class.getName().length();
                        long j49 = (((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
                        long j50 = (j49 >>> 48) & 43690;
                        long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
                        long j52 = ((j51 >>> 2) | j51) & 252645135;
                        long j53 = (j49 >>> 32) & 43690;
                        long j54 = ((j53 >>> 2) | (j53 >>> 1)) & 858993459;
                        long j55 = ((j54 >>> 2) | j54) & 252645135;
                        long j56 = ((((j55 >>> 4) | j55) & 16711935) << 16) + ((((j52 >>> 4) | j52) & 16711935) << 24);
                        long j57 = (j49 >>> 16) & 43690;
                        long j58 = ((j57 >>> 2) | (j57 >>> 1)) & 858993459;
                        long j59 = ((j58 >>> 2) | j58) & 252645135;
                        long j60 = j49 & 43690;
                        long j61 = ((j60 >>> 2) | (j60 >>> 1)) & 858993459;
                        long j62 = ((j61 >>> 2) | j61) & 252645135;
                        int i11 = (i10 + (((int) ((((j62 >>> 4) | j62) & 16711935) + (((((j59 >>> 4) | j59) & 16711935) << 8) + j56))) | 805724224)) ^ (-1341167912);
                        long j63 = 1355526684;
                        long j64 = ~G.class.getName().length();
                        long j65 = (((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                        long j66 = (j65 >>> 48) & 43690;
                        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
                        long j68 = ((j67 >>> 2) | j67) & 252645135;
                        long j69 = (j65 >>> 32) & 43690;
                        long j70 = ((j69 >>> 2) | (j69 >>> 1)) & 858993459;
                        long j71 = ((j70 >>> 2) | j70) & 252645135;
                        long j72 = ((((j71 >>> 4) | j71) & 16711935) << 16) | ((((j68 >>> 4) | j68) & 16711935) << 24);
                        long j73 = (j65 >>> 16) & 43690;
                        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
                        long j75 = ((j74 >>> 2) | j74) & 252645135;
                        long j76 = ((((j75 >>> 4) | j75) & 16711935) << 8) + j72;
                        long j77 = j65 & 43690;
                        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
                        long j79 = (j78 | (j78 >>> 2)) & 252645135;
                        int i12 = ((int) (((j79 | (j79 >>> 4)) & 16711935) + j76)) & 1076044416;
                        long j80 = 427819012;
                        long length7 = G.class.getName().length() & 413139076;
                        long j81 = (((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                        long j82 = (j81 >>> 48) & 43690;
                        long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                        long j84 = ((j83 >>> 2) | j83) & 252645135;
                        long j85 = (j81 >>> 32) & 43690;
                        long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                        long j87 = ((j86 >>> 2) | j86) & 252645135;
                        long j88 = ((((j87 >>> 4) | j87) & 16711935) << 16) + ((((j84 >>> 4) | j84) & 16711935) << 24);
                        long j89 = (j81 >>> 16) & 43690;
                        long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                        long j91 = ((j90 >>> 2) | j90) & 252645135;
                        long j92 = j81 & 43690;
                        long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                        long j94 = ((j93 >>> 2) | j93) & 252645135;
                        int i13 = i12 + ((int) ((((j94 >>> 4) | j94) & 16711935) + ((((j91 >>> 4) | j91) & 16711935) << 8) + j88));
                        long j95 = 1503863537;
                        long j96 = i13;
                        long j97 = (((((((((j95 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j95 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j95 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j95 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j96 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j96 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j96 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j96 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j98 = (j97 >>> 48) & 21845;
                        long j99 = (j98 | (j98 >>> 1)) & 858993459;
                        long j100 = (j99 | (j99 >>> 2)) & 252645135;
                        long j101 = (j97 >>> 32) & 21845;
                        long j102 = ((j101 >>> 1) | j101) & 858993459;
                        long j103 = ((j102 >>> 2) | j102) & 252645135;
                        long j104 = (((j100 | (j100 >>> 4)) & 16711935) << 24) | ((((j103 >>> 4) | j103) & 16711935) << 16);
                        long j105 = (j97 >>> 16) & 21845;
                        long j106 = ((j105 >>> 1) | j105) & 858993459;
                        long j107 = ((j106 >>> 2) | j106) & 252645135;
                        long j108 = ((((j107 >>> 4) | j107) & 16711935) << 8) + j104;
                        long j109 = j97 & 21845;
                        long j110 = (j109 | (j109 >>> 1)) & 858993459;
                        long j111 = (j110 | (j110 >>> 2)) & 252645135;
                        bArr9[i11] = (int) (((j111 | (j111 >>> 4)) & 16711935) + j108);
                        bArr9[8] = -116;
                        bArr9[9] = -38;
                        bArr9[10] = 75;
                        int i14 = ((~G.class.getName().length()) | (-537019395)) - (-592630787);
                        long j112 = -662699872;
                        long length8 = G.class.getName().length() & (-134069118);
                        long b6 = c3.b((((((((j112 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j112 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j112 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j112 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                        long j113 = (b6 >>> 48) & 43690;
                        long j114 = ((j113 >>> 2) | (j113 >>> 1)) & 858993459;
                        long j115 = (j114 | (j114 >>> 2)) & 252645135;
                        long j116 = (b6 >>> 32) & 43690;
                        long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
                        long j118 = ((j117 >>> 2) | j117) & 252645135;
                        long j119 = ((((j118 >>> 4) | j118) & 16711935) << 16) + (((j115 | (j115 >>> 4)) & 16711935) << 24);
                        long j120 = (b6 >>> 16) & 43690;
                        long j121 = ((j120 >>> 2) | (j120 >>> 1)) & 858993459;
                        long j122 = ((j121 >>> 2) | j121) & 252645135;
                        long j123 = b6 & 43690;
                        long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                        long j125 = (j124 | (j124 >>> 2)) & 252645135;
                        bArr9[11] = (i14 + ((int) (((j125 | (j125 >>> 4)) & 16711935) | (((((j122 >>> 4) | j122) & 16711935) << 8) | j119)))) ^ 70069005;
                        bArr9[12] = -106;
                        bArr9[13] = 109;
                        bArr9[14] = -13;
                        bArr9[15] = 47;
                        byte[] bArr10 = new byte[16];
                        bArr10[0] = 81;
                        bArr10[1] = 117;
                        bArr10[(((I2.a(G.class, -1) | (-1304623636)) & 1361969412) + ((G.class.getName().length() & 1090715649) | 671154203)) ^ 2033123613] = -66;
                        bArr10[3] = 78;
                        bArr10[4] = 0;
                        bArr10[5] = 72;
                        bArr10[6] = 67;
                        bArr10[7] = -66;
                        int i15 = ~G.class.getName().length();
                        bArr10[(((-1975209855) & ((589676621 ^ i15) + (i15 & 589676621))) + ((G.class.getName().length() & (-2009058164)) | 1082131468)) ^ (-893078395)] = -123;
                        bArr10[9] = -70;
                        bArr10[10] = -82;
                        bArr10[11] = 26;
                        bArr10[12] = -114;
                        bArr10[13] = 34;
                        bArr10[14] = 21;
                        bArr10[15] = -24;
                        c(bArr9, bArr10);
                        kotlin.jvm.internal.j.i(new String(bArr9, StandardCharsets.UTF_8).intern());
                        throw null;
                    }
                    int i16 = ((~G.class.getName().length()) | 1482116252) & (-859756222);
                    long j126 = 2364544;
                    long length9 = G.class.getName().length() & (-2069880382);
                    long j127 = (((((((((j126 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j126 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j126 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j126 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j128 = (j127 >>> 48) & 43690;
                    long j129 = ((j128 >>> 2) | (j128 >>> 1)) & 858993459;
                    long j130 = (j129 | (j129 >>> 2)) & 252645135;
                    long j131 = (j127 >>> 32) & 43690;
                    long j132 = ((j131 >>> 2) | (j131 >>> 1)) & 858993459;
                    long j133 = ((j132 >>> 2) | j132) & 252645135;
                    long j134 = (((j130 | (j130 >>> 4)) & 16711935) << 24) | ((((j133 >>> 4) | j133) & 16711935) << 16);
                    long j135 = (j127 >>> 16) & 43690;
                    long j136 = ((j135 >>> 2) | (j135 >>> 1)) & 858993459;
                    long j137 = ((j136 >>> 2) | j136) & 252645135;
                    long j138 = j127 & 43690;
                    long j139 = ((j138 >>> 2) | (j138 >>> 1)) & 858993459;
                    long j140 = (j139 | (j139 >>> 2)) & 252645135;
                    byte[] bArr11 = {-107, 104, -8, 21, -73, (i16 + ((int) (((j140 | (j140 >>> 4)) & 16711935) + (((((j137 >>> 4) | j137) & 16711935) << 8) + j134)))) ^ (-857391619), -86};
                    byte[] bArr12 = new byte[8];
                    int i17 = ~G.class.getName().length();
                    long j141 = -1878899664;
                    long length10 = G.class.getName().length();
                    long j142 = ((((((((j141 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j141 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j141 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j141 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length10 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length10 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length10 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length10 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j143 = (j142 >>> 48) & 43690;
                    long j144 = ((j143 >>> 2) | (j143 >>> 1)) & 858993459;
                    long j145 = ((j144 >>> 2) | j144) & 252645135;
                    long j146 = (j142 >>> 32) & 43690;
                    long j147 = ((j146 >>> 2) | (j146 >>> 1)) & 858993459;
                    long j148 = ((j147 >>> 2) | j147) & 252645135;
                    long j149 = ((((j148 >>> 4) | j148) & 16711935) << 16) + ((((j145 >>> 4) | j145) & 16711935) << 24);
                    long j150 = (j142 >>> 16) & 43690;
                    long j151 = ((j150 >>> 2) | (j150 >>> 1)) & 858993459;
                    long j152 = ((j151 >>> 2) | j151) & 252645135;
                    long j153 = j142 & 43690;
                    long j154 = ((j153 >>> 2) | (j153 >>> 1)) & 858993459;
                    long j155 = ((j154 >>> 2) | j154) & 252645135;
                    int i18 = (540550209 & (((-92738821) + i17) - (i17 & (-92738821)))) + (((int) ((((j155 >>> 4) | j155) & 16711935) + ((((j152 >>> 4) | j152) & 16711935) << 8) + j149)) | (-1878900176));
                    long j156 = -1338349967;
                    long j157 = i18;
                    long j158 = (((((((((j156 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j156 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j156 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j156 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j157 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j157 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j157 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j157 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j159 = (j158 >>> 48) & 21845;
                    long j160 = (j159 | (j159 >>> 1)) & 858993459;
                    long j161 = (j160 | (j160 >>> 2)) & 252645135;
                    long j162 = (j158 >>> 32) & 21845;
                    long j163 = ((j162 >>> 1) | j162) & 858993459;
                    long j164 = ((j163 >>> 2) | j163) & 252645135;
                    long j165 = ((((j164 >>> 4) | j164) & 16711935) << 16) + (((j161 | (j161 >>> 4)) & 16711935) << 24);
                    long j166 = (j158 >>> 16) & 21845;
                    long j167 = ((j166 >>> 1) | j166) & 858993459;
                    long j168 = ((j167 >>> 2) | j167) & 252645135;
                    long j169 = j158 & 21845;
                    long j170 = (j169 | (j169 >>> 1)) & 858993459;
                    long j171 = (j170 | (j170 >>> 2)) & 252645135;
                    bArr12[(int) (((j171 | (j171 >>> 4)) & 16711935) + ((((j168 >>> 4) | j168) & 16711935) << 8) + j165)] = -126;
                    bArr12[1] = 10;
                    long j172 = -1;
                    long length11 = G.class.getName().length();
                    long j173 = (((((((((j172 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j172 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j172 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j172 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j174 = (j173 >>> 48) & 21845;
                    long j175 = (j174 | (j174 >>> 1)) & 858993459;
                    long j176 = (j175 | (j175 >>> 2)) & 252645135;
                    long j177 = (j173 >>> 32) & 21845;
                    long j178 = ((j177 >>> 1) | j177) & 858993459;
                    long j179 = ((j178 >>> 2) | j178) & 252645135;
                    long j180 = (((j176 | (j176 >>> 4)) & 16711935) << 24) | ((((j179 >>> 4) | j179) & 16711935) << 16);
                    long j181 = (j173 >>> 16) & 21845;
                    long j182 = ((j181 >>> 1) | j181) & 858993459;
                    long j183 = ((j182 >>> 2) | j182) & 252645135;
                    long j184 = j173 & 21845;
                    long j185 = (j184 | (j184 >>> 1)) & 858993459;
                    long j186 = (j185 | (j185 >>> 2)) & 252645135;
                    int length12 = ((((int) (((j186 | (j186 >>> 4)) & 16711935) + ((((j183 >>> 4) | j183) & 16711935) << 8) + j180)) | (-1698210624)) & 405477253) + ((G.class.getName().length() & 40370965) | 54790192);
                    bArr12[2] = (((~length12) & 460267436) - (460267436 & length12)) + length12;
                    bArr12[3] = -63;
                    bArr12[4] = -42;
                    bArr12[5] = 88;
                    bArr12[6] = -49;
                    bArr12[7] = -39;
                    c(bArr11, bArr12);
                    kotlin.jvm.internal.j.i(new String(bArr11, StandardCharsets.UTF_8).intern());
                    throw null;
                }
                byte[] bArr13 = new byte[11];
                bArr13[0] = 65;
                bArr13[1] = 71;
                bArr13[2] = -54;
                bArr13[3] = 111;
                bArr13[4] = Byte.MAX_VALUE;
                bArr13[5] = 53;
                bArr13[6] = -115;
                bArr13[7] = 98;
                bArr13[8] = -80;
                bArr13[9] = 60;
                int a4 = (I2.a(G.class, -1) | (-273170609)) + 306726333;
                int length13 = (G.class.getName().length() & 274221296) | 68290624;
                int i19 = -a4;
                int i20 = i19 | length13;
                bArr13[375016950 ^ ((i20 - (i19 * 2)) + ((i19 ^ length13) ^ i20))] = 57;
                byte[] bArr14 = new byte[11];
                bArr14[0] = 74;
                bArr14[1] = 29;
                bArr14[2] = 45;
                bArr14[3] = -88;
                bArr14[4] = ((((~G.class.getName().length()) | 1098775040) & 163912109) + ((G.class.getName().length() & 210239917) | 1711816706)) ^ 1875728856;
                int a5 = (I2.a(G.class, -1) | (-813264115)) & 1084556032;
                int length14 = G.class.getName().length() & 2171008;
                bArr14[1101341617 ^ ((((~length14) & 16785588) + length14) + a5)] = 4;
                bArr14[6] = 108;
                bArr14[7] = -78;
                bArr14[8] = -42;
                long j187 = 1236222827;
                long j188 = ~G.class.getName().length();
                long b7 = c3.b((((((((j187 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j187 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j187 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j187 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j188 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j188 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((j188 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j188 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)), 6148914691236517205L);
                long j189 = (b7 >>> 48) & 43690;
                long j190 = ((j189 >>> 2) | (j189 >>> 1)) & 858993459;
                long j191 = (j190 | (j190 >>> 2)) & 252645135;
                long j192 = (b7 >>> 32) & 43690;
                long j193 = ((j192 >>> 2) | (j192 >>> 1)) & 858993459;
                long j194 = (j193 | (j193 >>> 2)) & 252645135;
                long j195 = (((j194 | (j194 >>> 4)) & 16711935) << 16) + (((j191 | (j191 >>> 4)) & 16711935) << 24);
                long j196 = (b7 >>> 16) & 43690;
                long j197 = ((j196 >>> 2) | (j196 >>> 1)) & 858993459;
                long j198 = (j197 | (j197 >>> 2)) & 252645135;
                long j199 = b7 & 43690;
                long j200 = ((j199 >>> 2) | (j199 >>> 1)) & 858993459;
                long j201 = (j200 | (j200 >>> 2)) & 252645135;
                int i21 = (int) (((j201 | (j201 >>> 4)) & 16711935) + (((j198 | (j198 >>> 4)) & 16711935) << 8) + j195);
                int i22 = ((-1858053950) | i21) - (i21 ^ (-1858053950));
                int length15 = G.class.getName().length();
                long j202 = -775390997;
                long length16 = i22 + (1082662944 | (((G.class.getName().length() | (-1874323296)) - (length15 | (-1874323296))) + I2.a(G.class, length15) + (G.class.getName().length() & (-1874323296))));
                long j203 = (((((((((j202 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j202 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j202 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j202 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length16 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((length16 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((length16 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((length16 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32));
                long j204 = (j203 >>> 48) & 21845;
                long j205 = (j204 | (j204 >>> 1)) & 858993459;
                long j206 = (j205 | (j205 >>> 2)) & 252645135;
                long j207 = (j203 >>> 32) & 21845;
                long j208 = (j207 | (j207 >>> 1)) & 858993459;
                long j209 = (j208 | (j208 >>> 2)) & 252645135;
                long j210 = (((j206 | (j206 >>> 4)) & 16711935) << 24) | (((j209 | (j209 >>> 4)) & 16711935) << 16);
                long j211 = (j203 >>> 16) & 21845;
                long j212 = (j211 | (j211 >>> 1)) & 858993459;
                long j213 = (j212 | (j212 >>> 2)) & 252645135;
                long j214 = j203 & 21845;
                long j215 = (j214 | (j214 >>> 1)) & 858993459;
                long j216 = (j215 | (j215 >>> 2)) & 252645135;
                int i23 = (int) (((j216 | (j216 >>> 4)) & 16711935) | ((((j213 | (j213 >>> 4)) & 16711935) << 8) + j210));
                int i24 = ~G.class.getName().length();
                int length17 = ((G.class.getName().length() & 134524928) | 688144) + (~(-((((-956809102) | i24) + 142897154) - (i24 | (-822316942)))));
                bArr14[i23] = (length17 + 143585352) - (((length17 + 1) & 143585351) * 2);
                bArr14[10] = 94;
                c(bArr13, bArr14);
                kotlin.jvm.internal.j.i(new String(bArr13, StandardCharsets.UTF_8).intern());
                throw null;
            }
            byte[] bArr15 = new byte[7];
            bArr15[0] = 54;
            bArr15[1] = 68;
            bArr15[2] = -90;
            bArr15[3] = Byte.MAX_VALUE;
            bArr15[4] = -13;
            int i25 = ((~G.class.getName().length()) | (-1254465185)) & 593105046;
            int length18 = G.class.getName().length() & 239342208;
            bArr15[1870549659 ^ ((((~length18) & 1277444616) + length18) + i25)] = 30;
            int a6 = I2.a(G.class, -1);
            int length19 = ((-496688868) & (((~a6) & 239064501) + a6)) + ((G.class.getName().length() & (-523231224)) | 412090977);
            bArr15[6] = (84597895 | length19) - (length19 & 84597895);
            c(bArr15, new byte[]{33, 38, 71, -85, -110, 121, -97, -51});
            kotlin.jvm.internal.j.i(new String(bArr15, StandardCharsets.UTF_8).intern());
            throw null;
        }
        byte[] bArr16 = new byte[7];
        bArr16[0] = 93;
        bArr16[((((~G.class.getName().length()) | 1567728857) & 1073743752) + ((G.class.getName().length() & (-2147482880)) | (-2012217342))) ^ (-938473589)] = 108;
        bArr16[2] = 78;
        bArr16[3] = -92;
        bArr16[4] = -11;
        bArr16[5] = -30;
        long j217 = -864088335;
        long j218 = ~G.class.getName().length();
        long b8 = c3.b((((((((j217 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j217 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j217 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j217 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j218 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j218 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j218 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j218 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))), 6148914691236517205L);
        long j219 = (b8 >>> 48) & 43690;
        long j220 = ((j219 >>> 2) | (j219 >>> 1)) & 858993459;
        long j221 = (j220 | (j220 >>> 2)) & 252645135;
        long j222 = (b8 >>> 32) & 43690;
        long j223 = ((j222 >>> 2) | (j222 >>> 1)) & 858993459;
        long j224 = (j223 | (j223 >>> 2)) & 252645135;
        long j225 = (b8 >>> 16) & 43690;
        long j226 = ((j225 >>> 2) | (j225 >>> 1)) & 858993459;
        long j227 = (j226 | (j226 >>> 2)) & 252645135;
        long j228 = b8 & 43690;
        long j229 = ((j228 >>> 2) | (j228 >>> 1)) & 858993459;
        long j230 = (j229 | (j229 >>> 2)) & 252645135;
        bArr16[((((int) (((j230 | (j230 >>> 4)) & 16711935) + ((((j227 | (j227 >>> 4)) & 16711935) << 8) | ((((j224 | (j224 >>> 4)) & 16711935) << 16) + (((j221 | (j221 >>> 4)) & 16711935) << 24))))) & (-2142066526)) + ((G.class.getName().length() & 1183424523) | 1183383561)) ^ (-958682963)] = 34;
        c(bArr16, new byte[]{74, 14, -81, 112, -108, -123, 71, 10});
        kotlin.jvm.internal.j.i(new String(bArr16, StandardCharsets.UTF_8).intern());
        throw null;
    }
}
