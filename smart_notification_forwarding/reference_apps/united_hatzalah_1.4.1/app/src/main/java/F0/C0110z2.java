package F0;

import a.AbstractC0228a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.lifecycle.AbstractC0305o;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import d0.AbstractC0356b;
import d0.C0357c;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k0.AbstractC0477a;
import l0.C0514d;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.z2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0110z2 implements F1.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f728a;

    /* renamed from: b, reason: collision with root package name */
    public Object f729b;

    /* renamed from: c, reason: collision with root package name */
    public Object f730c;

    /* renamed from: d, reason: collision with root package name */
    public Object f731d;

    public /* synthetic */ C0110z2(int i) {
        this.f728a = i;
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

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void h(byte[] bArr, byte[] bArr2) {
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

    public static final C0110z2 l(W1.g0 g0Var) {
        Integer valueOf;
        if (g0Var.z() > 0) {
            ArrayList arrayList = new ArrayList(g0Var.z());
            for (W1.f0 f0Var : g0Var.A()) {
                f0Var.getClass();
                int B3 = f0Var.B();
                if (f0Var.C() == W1.r0.RAW) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(B3);
                }
                try {
                    try {
                        K1.b a2 = R1.h.f1992b.a(R1.n.b(f0Var.A().B(), f0Var.A().C(), f0Var.A().A(), f0Var.C(), valueOf));
                        int ordinal = f0Var.D().ordinal();
                        if (ordinal != 1 && ordinal != 2 && ordinal != 3) {
                            throw new GeneralSecurityException("Unknown key status");
                            break;
                        }
                        arrayList.add(new K1.h(a2));
                    } catch (GeneralSecurityException unused) {
                        arrayList.add(null);
                    }
                } catch (GeneralSecurityException e4) {
                    throw new RuntimeException("Creating a protokey serialization failed", e4);
                }
            }
            return new C0110z2(g0Var, Collections.unmodifiableList(arrayList));
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static void s() {
        if (Build.VERSION.SDK_INT < 29) {
        } else {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }

    public static final C0110z2 t(K1.f fVar, Q1.b bVar) {
        byte[] bArr = new byte[0];
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) fVar.f1089b;
        try {
            W1.N A3 = W1.N.A(byteArrayInputStream, C0344p.a());
            byteArrayInputStream.close();
            if (A3.y().size() != 0) {
                try {
                    W1.g0 E3 = W1.g0.E(bVar.b(A3.y().k(), bArr), C0344p.a());
                    if (E3.z() > 0) {
                        return l(E3);
                    }
                    throw new GeneralSecurityException("empty keyset");
                } catch (InvalidProtocolBufferException unused) {
                    throw new GeneralSecurityException("invalid keyset, corrupted key material");
                }
            }
            throw new GeneralSecurityException("empty keyset");
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0766  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public F0.InterfaceC0106y2 a() {
        /*
            Method dump skipped, instructions count: 2052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0110z2.a():F0.y2");
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [L1.m, java.lang.Object] */
    public L1.m c() {
        G1 g12;
        L1.n nVar = (L1.n) this.f729b;
        if (nVar != null && (g12 = (G1) this.f730c) != null) {
            if (nVar.f1324b == ((Y1.a) g12.f218b).f2706a.length) {
                L1.j jVar = nVar.f1327e;
                L1.j jVar2 = L1.j.f1302m;
                if (jVar != jVar2 && ((Integer) this.f731d) == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (jVar != jVar2 || ((Integer) this.f731d) == null) {
                    if (jVar == jVar2) {
                        Y1.a.a(new byte[0]);
                    } else if (jVar == L1.j.f1301l) {
                        Y1.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f731d).intValue()).array());
                    } else if (jVar == L1.j.f1300k) {
                        Y1.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f731d).intValue()).array());
                    } else {
                        throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + ((L1.n) this.f729b).f1327e);
                    }
                    return new Object();
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [L1.s, java.lang.Object] */
    public L1.s d() {
        G1 g12;
        L1.t tVar = (L1.t) this.f729b;
        if (tVar != null && (g12 = (G1) this.f730c) != null) {
            if (tVar.f1340b == ((Y1.a) g12.f218b).f2706a.length) {
                L1.j jVar = tVar.f1341c;
                L1.j jVar2 = L1.j.f1307s;
                if (jVar != jVar2 && ((Integer) this.f731d) == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (jVar != jVar2 || ((Integer) this.f731d) == null) {
                    if (jVar == jVar2) {
                        Y1.a.a(new byte[0]);
                    } else if (jVar == L1.j.f1306r) {
                        Y1.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f731d).intValue()).array());
                    } else if (jVar == L1.j.f1305q) {
                        Y1.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f731d).intValue()).array());
                    } else {
                        throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + ((L1.t) this.f729b).f1341c);
                    }
                    return new Object();
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    public S1.a e() {
        G1 g12;
        Y1.a a2;
        S1.d dVar = (S1.d) this.f729b;
        if (dVar != null && (g12 = (G1) this.f730c) != null) {
            if (dVar.f2131b == ((Y1.a) g12.f218b).f2706a.length) {
                S1.c cVar = dVar.f2133d;
                S1.c cVar2 = S1.c.f2120f;
                if (cVar != cVar2 && ((Integer) this.f731d) == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (cVar != cVar2 || ((Integer) this.f731d) == null) {
                    if (cVar == cVar2) {
                        a2 = Y1.a.a(new byte[0]);
                    } else if (cVar != S1.c.f2119e && cVar != S1.c.f2118d) {
                        if (cVar == S1.c.f2117c) {
                            a2 = Y1.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f731d).intValue()).array());
                        } else {
                            throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + ((S1.d) this.f729b).f2133d);
                        }
                    } else {
                        a2 = Y1.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f731d).intValue()).array());
                    }
                    return new S1.a((S1.d) this.f729b, a2);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    public S1.i f() {
        G1 g12;
        Y1.a a2;
        S1.j jVar = (S1.j) this.f729b;
        if (jVar != null && (g12 = (G1) this.f730c) != null) {
            if (jVar.f2141b == ((Y1.a) g12.f218b).f2706a.length) {
                S1.c cVar = jVar.f2143d;
                S1.c cVar2 = S1.c.f2128o;
                if (cVar != cVar2 && ((Integer) this.f731d) == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (cVar != cVar2 || ((Integer) this.f731d) == null) {
                    if (cVar == cVar2) {
                        a2 = Y1.a.a(new byte[0]);
                    } else if (cVar != S1.c.f2127n && cVar != S1.c.f2126m) {
                        if (cVar == S1.c.f2125l) {
                            a2 = Y1.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f731d).intValue()).array());
                        } else {
                            throw new IllegalStateException("Unknown HmacParameters.Variant: " + ((S1.j) this.f729b).f2143d);
                        }
                    } else {
                        a2 = Y1.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f731d).intValue()).array());
                    }
                    return new S1.i((S1.j) this.f729b, a2);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    public t1.k g() {
        String str;
        if (((String) this.f729b) == null) {
            str = " backendName";
        } else {
            str = "";
        }
        if (((q1.d) this.f731d) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new t1.k((String) this.f729b, (byte[]) this.f730c, (q1.d) this.f731d);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public boolean i() {
        PackageManager packageManager = ((Context) this.f729b).getPackageManager();
        byte[] bArr = new byte[((((~C0110z2.class.getName().length()) | 160253756) & 421171206) + ((C0110z2.class.getName().length() & (-1877831518)) | (-1073741648))) ^ (-652570475)];
        bArr[0] = 95;
        bArr[1] = 19;
        bArr[2] = 83;
        bArr[3] = 24;
        bArr[4] = -106;
        bArr[5] = -2;
        int i = ~C0110z2.class.getName().length();
        long j2 = 948334418;
        long length = (((i | 2124249098) + 402926676) - (i | 2124250206)) + ((C0110z2.class.getName().length() & 18260) | 545407744);
        long j3 = ((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
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
        bArr[(int) ((((j16 >>> 4) | j16) & 16711935) + ((((j13 >>> 4) | j13) & 16711935) << 8) + j10)] = -61;
        bArr[7] = -117;
        int f4 = (AbstractC0008a.f(C0110z2.class, -1) | (-1457140659)) & (-1593653242);
        int length2 = (C0110z2.class.getName().length() & 36831490) | 37225217;
        bArr[D.a(f4, 3, -((length2 & 2) | D1.a(f4, length2)), 1) ^ (-1556428017)] = -123;
        bArr[9] = -28;
        bArr[10] = -107;
        bArr[11] = 12;
        bArr[12] = -112;
        bArr[13] = -20;
        bArr[14] = -13;
        bArr[15] = 53;
        bArr[16] = -16;
        bArr[17] = -108;
        int i3 = ((~C0110z2.class.getName().length()) | (-537169501)) & 403705878;
        long j17 = 603979796;
        long length3 = C0110z2.class.getName().length();
        long j18 = ((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j19 = (j18 >>> 48) & 43690;
        long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
        long j21 = ((j20 >>> 2) | j20) & 252645135;
        long j22 = (j18 >>> 32) & 43690;
        long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
        long j24 = ((j23 >>> 2) | j23) & 252645135;
        long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) | ((((j21 >>> 4) | j21) & 16711935) << 24);
        long j26 = (j18 >>> 16) & 43690;
        long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
        long j28 = ((j27 >>> 2) | j27) & 252645135;
        long j29 = j18 & 43690;
        long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
        long j31 = ((j30 >>> 2) | j30) & 252645135;
        bArr[(i3 + (((int) ((((((j28 >>> 4) | j28) & 16711935) << 8) | j25) | (((j31 >>> 4) | j31) & 16711935))) | 604250240)) ^ 1007956100] = 16;
        bArr[19] = -106;
        bArr[20] = -126;
        int f5 = AbstractC0008a.f(C0110z2.class, -1);
        int i4 = 143656648 & ((f5 ^ 396745992) + (f5 & 396745992));
        int length4 = (C0110z2.class.getName().length() & 135267008) | (-536346624);
        bArr[AbstractC0099x.a(i4 | length4, 2, (~i4) ^ length4) ^ (-392689955)] = -3;
        bArr[22] = 107;
        bArr[23] = 80;
        bArr[24] = 103;
        bArr[25] = -16;
        long j32 = 1917821009;
        long j33 = ~C0110z2.class.getName().length();
        long j34 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
        long j47 = (j46 | (j46 >>> 2)) & 252645135;
        bArr[((((int) (((j47 | (j47 >>> 4)) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41))) & 537420456) + ((C0110z2.class.getName().length() & 269632168) | 278003712)) ^ 815424178] = -103;
        bArr[27] = 118;
        bArr[28] = 43;
        long j48 = -307752933;
        long length5 = (((~C0110z2.class.getName().length()) | (-1990751830)) & 39264515) + ((C0110z2.class.getName().length() & 302048777) | 268488328);
        long j49 = (((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length5 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length5 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length5 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length5 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        bArr[29] = (int) ((((((j59 >>> 4) | j59) & 16711935) << 8) + j56) | (((j62 >>> 4) | j62) & 16711935));
        bArr[30] = 29;
        bArr[31] = 11;
        bArr[32] = -37;
        bArr[33] = 122;
        bArr[34] = 5;
        byte[] bArr2 = new byte[35];
        bArr2[0] = 85;
        bArr2[1] = 77;
        bArr2[2] = 77;
        bArr2[3] = 81;
        bArr2[4] = 16;
        bArr2[5] = 104;
        bArr2[6] = -67;
        bArr2[7] = -116;
        bArr2[8] = 4;
        bArr2[9] = 86;
        bArr2[10] = -3;
        bArr2[11] = 79;
        bArr2[12] = -2;
        bArr2[13] = 93;
        bArr2[14] = -105;
        bArr2[15] = 55;
        bArr2[16] = -11;
        bArr2[17] = -73;
        bArr2[18] = 122;
        bArr2[19] = -53;
        bArr2[20] = 4;
        bArr2[21] = 100;
        long j63 = -2146004159;
        long j64 = (~C0110z2.class.getName().length()) | 1209973337;
        long j65 = ((((((((j63 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j63 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j63 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j63 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
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
        int i5 = (int) (((j79 | (j79 >>> 4)) & 16711935) + j76);
        long j80 = 149438604;
        long length6 = (C0110z2.class.getName().length() | 2004877043) - 2004877043;
        long b4 = c3.b((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), 6148914691236517205L);
        long j81 = (b4 >>> 48) & 43690;
        long j82 = ((j81 >>> 2) | (j81 >>> 1)) & 858993459;
        long j83 = ((j82 >>> 2) | j82) & 252645135;
        long j84 = (b4 >>> 32) & 43690;
        long j85 = ((j84 >>> 2) | (j84 >>> 1)) & 858993459;
        long j86 = ((j85 >>> 2) | j85) & 252645135;
        long j87 = ((((j86 >>> 4) | j86) & 16711935) << 16) | ((((j83 >>> 4) | j83) & 16711935) << 24);
        long j88 = (b4 >>> 16) & 43690;
        long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
        long j90 = ((j89 >>> 2) | j89) & 252645135;
        long j91 = b4 & 43690;
        long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
        long j93 = ((j92 >>> 2) | j92) & 252645135;
        bArr2[(i5 + ((int) ((((j93 >>> 4) | j93) & 16711935) + (((((j90 >>> 4) | j90) & 16711935) << 8) | j87)))) ^ (-1996565541)] = 34;
        bArr2[23] = 25;
        bArr2[24] = 31;
        bArr2[25] = 88;
        int f6 = (AbstractC0008a.f(C0110z2.class, -1) | 1871882649) & 1610647683;
        long j94 = -2036333560;
        long length7 = C0110z2.class.getName().length() & (-2036333566);
        long j95 = (((((((((j94 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j94 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j94 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j94 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
        long j96 = (j95 >>> 48) & 43690;
        long j97 = ((j96 >>> 2) | (j96 >>> 1)) & 858993459;
        long j98 = (j97 | (j97 >>> 2)) & 252645135;
        long j99 = (j95 >>> 32) & 43690;
        long j100 = ((j99 >>> 2) | (j99 >>> 1)) & 858993459;
        long j101 = ((j100 >>> 2) | j100) & 252645135;
        long j102 = ((((j101 >>> 4) | j101) & 16711935) << 16) + (((j98 | (j98 >>> 4)) & 16711935) << 24);
        long j103 = (j95 >>> 16) & 43690;
        long j104 = ((j103 >>> 2) | (j103 >>> 1)) & 858993459;
        long j105 = ((j104 >>> 2) | j104) & 252645135;
        long j106 = j95 & 43690;
        long j107 = ((j106 >>> 2) | (j106 >>> 1)) & 858993459;
        long j108 = ((j107 >>> 2) | j107) & 252645135;
        bArr2[(f6 + ((int) (((j108 | (j108 >>> 4)) & 16711935) + (((((j105 >>> 4) | j105) & 16711935) << 8) + j102)))) ^ (-425685871)] = -36;
        bArr2[27] = 4;
        bArr2[28] = 101;
        bArr2[29] = -71;
        bArr2[30] = (-70262291) ^ ((((~C0110z2.class.getName().length()) | (-1275102394)) & 69210665) + ((C0110z2.class.getName().length() & 67109929) | 1051712));
        bArr2[31] = 102;
        bArr2[32] = -76;
        bArr2[33] = 8;
        bArr2[34] = 96;
        b(bArr, bArr2);
        return packageManager.hasSystemFeature(new String(bArr, StandardCharsets.UTF_8).intern());
    }

    public byte[] j(byte[] bArr) {
        int o2 = o();
        byte[] bArr2 = new byte[o2];
        ((SecureRandom) this.f730c).nextBytes(bArr2);
        AlgorithmParameterSpec p = p(bArr2);
        Cipher cipher = (Cipher) this.f729b;
        cipher.init(1, (Key) this.f731d, p);
        byte[] doFinal = cipher.doFinal(bArr);
        byte[] bArr3 = new byte[doFinal.length + o2];
        System.arraycopy(bArr2, 0, bArr3, 0, o2);
        System.arraycopy(doFinal, 0, bArr3, o2, doFinal.length);
        return bArr3;
    }

    public int k(int i, int i3) {
        ArrayList arrayList = (ArrayList) this.f731d;
        int size = arrayList.size();
        while (i3 < size) {
            ((AbstractC0477a) arrayList.get(i3)).getClass();
            i3++;
        }
        return i;
    }

    public String m() {
        return "VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK";
    }

    public Cipher n() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    public int o() {
        return 16;
    }

    public AlgorithmParameterSpec p(byte[] bArr) {
        return new IvParameterSpec(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0174  */
    /* JADX WARN: Type inference failed for: r4v2, types: [K1.m, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object q(java.lang.Class r17) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0110z2.q(java.lang.Class):java.lang.Object");
    }

    public androidx.lifecycle.V r(kotlin.jvm.internal.e eVar, String key) {
        androidx.lifecycle.V viewModel;
        androidx.lifecycle.X factory = (androidx.lifecycle.X) this.f730c;
        kotlin.jvm.internal.j.e(key, "key");
        androidx.lifecycle.Z z3 = (androidx.lifecycle.Z) this.f729b;
        z3.getClass();
        LinkedHashMap linkedHashMap = z3.f3594a;
        androidx.lifecycle.V v2 = (androidx.lifecycle.V) linkedHashMap.get(key);
        if (eVar.d(v2)) {
            if (factory instanceof androidx.lifecycle.T) {
                androidx.lifecycle.T t3 = (androidx.lifecycle.T) factory;
                kotlin.jvm.internal.j.b(v2);
                t3.getClass();
                AbstractC0305o abstractC0305o = t3.f3585d;
                if (abstractC0305o != null) {
                    C0514d c0514d = t3.f3586e;
                    kotlin.jvm.internal.j.b(c0514d);
                    androidx.lifecycle.P.a(v2, c0514d, abstractC0305o);
                }
            }
            kotlin.jvm.internal.j.c(v2, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
            return v2;
        }
        C0357c c0357c = new C0357c((AbstractC0356b) this.f731d);
        c0357c.f4412a.put(e0.c.f4447a, key);
        kotlin.jvm.internal.j.e(factory, "factory");
        try {
            try {
                viewModel = factory.b(eVar, c0357c);
            } catch (AbstractMethodError unused) {
                viewModel = factory.a(AbstractC0228a.s(eVar));
            }
        } catch (AbstractMethodError unused2) {
            viewModel = factory.c(AbstractC0228a.s(eVar), c0357c);
        }
        kotlin.jvm.internal.j.e(viewModel, "viewModel");
        androidx.lifecycle.V v3 = (androidx.lifecycle.V) linkedHashMap.put(key, viewModel);
        if (v3 != null) {
            v3.a();
        }
        return viewModel;
    }

    public String toString() {
        switch (this.f728a) {
            case 3:
                return K1.p.a((W1.g0) this.f729b).toString();
            default:
                return super.toString();
        }
    }

    public void u(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC0477a instance = (AbstractC0477a) arrayList.get(i);
            instance.getClass();
            C0092v0 c0092v0 = (C0092v0) this.f729b;
            Object[] objArr = (Object[]) c0092v0.f693b;
            kotlin.jvm.internal.j.e(instance, "instance");
            int i3 = c0092v0.f692a;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4] == instance) {
                    throw new IllegalStateException("Already in the pool!");
                }
            }
            int i5 = c0092v0.f692a;
            if (i5 < objArr.length) {
                objArr[i5] = instance;
                c0092v0.f692a = i5 + 1;
            }
        }
        arrayList.clear();
    }

    public void v(String str) {
        if (str != null) {
            this.f729b = str;
            return;
        }
        throw new NullPointerException("Null backendName");
    }

    @Override // F1.c
    public Object zza() {
        return new E1.d((E1.k) ((F1.c) this.f729b).zza(), (E1.c) ((F1.c) this.f730c).zza(), ((E1.e) ((C0047j2) this.f731d).f546b).f134a);
    }

    public C0110z2(F1.c cVar, F1.c cVar2, C0047j2 c0047j2) {
        this.f728a = 2;
        this.f729b = cVar;
        this.f730c = cVar2;
        this.f731d = c0047j2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public C0110z2(android.content.Context r39) {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0110z2.<init>(android.content.Context):void");
    }

    public C0110z2(Context context, C0018c1 c0018c1) {
        this.f728a = 9;
        this.f730c = new SecureRandom();
        String m4 = m();
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSecureKeyStorage", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString(m4, null);
        this.f729b = n();
        if (string != null) {
            try {
                this.f731d = c0018c1.k(Base64.decode(string, 0));
                return;
            } catch (Exception e4) {
                Log.e("StorageCipher18Impl", "unwrap key failed", e4);
            }
        }
        byte[] bArr = new byte[16];
        ((SecureRandom) this.f730c).nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f731d = secretKeySpec;
        c0018c1.getClass();
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        String str = (String) c0018c1.f476a;
        Certificate certificate = keyStore.getCertificate(str);
        if (certificate != null) {
            PublicKey publicKey = certificate.getPublicKey();
            if (publicKey != null) {
                Cipher f4 = c0018c1.f();
                f4.init(3, publicKey, c0018c1.e());
                edit.putString(m4, Base64.encodeToString(f4.wrap(secretKeySpec), 0));
                edit.apply();
                return;
            }
            throw new Exception(e0.a.d("No key found under alias: ", str));
        }
        throw new Exception(e0.a.d("No certificate found under alias: ", str));
    }

    public C0110z2(androidx.lifecycle.Z store, androidx.lifecycle.X factory, AbstractC0356b extras) {
        this.f728a = 8;
        kotlin.jvm.internal.j.e(store, "store");
        kotlin.jvm.internal.j.e(factory, "factory");
        kotlin.jvm.internal.j.e(extras, "extras");
        this.f729b = store;
        this.f730c = factory;
        this.f731d = extras;
    }

    public C0110z2(androidx.lifecycle.N n4) {
        this.f728a = 10;
        this.f729b = new C0092v0(30);
        this.f730c = new ArrayList();
        this.f731d = new ArrayList();
        new androidx.lifecycle.N(this, 19);
    }

    public C0110z2(q.y yVar) {
        this.f728a = 12;
        this.f731d = yVar;
    }

    public C0110z2(Signature signature) {
        this.f728a = 1;
        this.f729b = signature;
        this.f730c = null;
        this.f731d = null;
    }

    public C0110z2(Cipher cipher) {
        this.f728a = 1;
        this.f730c = cipher;
        this.f729b = null;
        this.f731d = null;
    }

    public C0110z2(Mac mac) {
        this.f728a = 1;
        this.f731d = mac;
        this.f730c = null;
        this.f729b = null;
    }

    public C0110z2(W1.g0 g0Var, List list) {
        this.f728a = 3;
        this.f729b = g0Var;
        this.f730c = list;
        this.f731d = U1.a.f2331b;
    }
}
