package F0;

import a.AbstractC0228a;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.n1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0062n1 {

    /* renamed from: g, reason: collision with root package name */
    public Object f592g;

    /* renamed from: d, reason: collision with root package name */
    public Object f589d = null;

    /* renamed from: a, reason: collision with root package name */
    public String f586a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f587b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f588c = null;

    /* renamed from: e, reason: collision with root package name */
    public Object f590e = null;

    /* renamed from: f, reason: collision with root package name */
    public Object f591f = null;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void a(byte[] bArr, byte[] bArr2) {
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

    public static byte[] g(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (str != null) {
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            } else {
                sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
            }
            try {
                String string = sharedPreferences.getString(str, null);
                if (string == null) {
                    return null;
                }
                return AbstractC0228a.i(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(e0.a.e("can't read keyset; the pref value ", str, " is not a valid hex string"));
            }
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }

    public static K1.f h(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            W1.g0 D3 = W1.g0.D(byteArrayInputStream, C0344p.a());
            byteArrayInputStream.close();
            return new K1.f((W1.d0) ((W1.g0) C0110z2.l(D3).f729b).v(), 3);
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    public String[] b() {
        return (String[]) this.f591f;
    }

    public synchronized Q1.a c() {
        K1.f h2;
        Q1.a aVar;
        try {
            if (this.f586a != null) {
                synchronized (Q1.a.f1722b) {
                    try {
                        byte[] g3 = g((Context) this.f589d, this.f586a, this.f587b);
                        if (g3 == null) {
                            if (this.f588c != null) {
                                this.f590e = i();
                            }
                            this.f592g = f();
                        } else if (this.f588c != null) {
                            try {
                                this.f590e = new Q1.c().c(this.f588c);
                                try {
                                    h2 = new K1.f((W1.d0) ((W1.g0) C0110z2.t(new K1.f(new ByteArrayInputStream(g3), 1), (Q1.b) this.f590e).f729b).v(), 3);
                                } catch (IOException | GeneralSecurityException e4) {
                                    try {
                                        h2 = h(g3);
                                    } catch (IOException unused) {
                                        throw e4;
                                    }
                                }
                            } catch (GeneralSecurityException | ProviderException e5) {
                                try {
                                    h2 = h(g3);
                                } catch (IOException unused2) {
                                    throw e5;
                                }
                            }
                            this.f592g = h2;
                        } else {
                            this.f592g = h(g3);
                        }
                        aVar = new Q1.a(this);
                    } finally {
                    }
                }
            } else {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public String d() {
        return this.f588c;
    }

    public String e() {
        return this.f586a;
    }

    public K1.f f() {
        SharedPreferences.Editor edit;
        if (((K1.g) this.f591f) != null) {
            K1.f fVar = new K1.f(W1.g0.C(), 3);
            K1.g gVar = (K1.g) this.f591f;
            synchronized (fVar) {
                fVar.a(gVar.f1090a);
            }
            int A3 = K1.p.a((W1.g0) fVar.c().f729b).y().A();
            synchronized (fVar) {
                for (int i = 0; i < ((W1.g0) ((W1.d0) fVar.f1089b).f4158b).z(); i++) {
                    try {
                        W1.f0 y = ((W1.g0) ((W1.d0) fVar.f1089b).f4158b).y(i);
                        if (y.B() == A3) {
                            if (y.D().equals(W1.Z.ENABLED)) {
                                W1.d0 d0Var = (W1.d0) fVar.f1089b;
                                d0Var.e();
                                W1.g0.w((W1.g0) d0Var.f4158b, A3);
                            } else {
                                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + A3);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                throw new GeneralSecurityException("key not found: " + A3);
            }
            Context context = (Context) this.f589d;
            String str = this.f586a;
            String str2 = this.f587b;
            if (str != null) {
                Context applicationContext = context.getApplicationContext();
                if (str2 == null) {
                    edit = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
                } else {
                    edit = applicationContext.getSharedPreferences(str2, 0).edit();
                }
                if (((Q1.b) this.f590e) != null) {
                    C0110z2 c4 = fVar.c();
                    Q1.b bVar = (Q1.b) this.f590e;
                    byte[] bArr = new byte[0];
                    W1.g0 g0Var = (W1.g0) c4.f729b;
                    byte[] a2 = bVar.a(g0Var.e(), bArr);
                    try {
                        if (W1.g0.E(bVar.b(a2, bArr), C0344p.a()).equals(g0Var)) {
                            W1.M z3 = W1.N.z();
                            C0336h i3 = AbstractC0337i.i(a2, 0, a2.length);
                            z3.e();
                            W1.N.w((W1.N) z3.f4158b, i3);
                            W1.k0 a4 = K1.p.a(g0Var);
                            z3.e();
                            W1.N.x((W1.N) z3.f4158b, a4);
                            if (!edit.putString(str, AbstractC0228a.n(((W1.N) z3.b()).e())).commit()) {
                                throw new IOException("Failed to write to SharedPreferences");
                            }
                        } else {
                            throw new GeneralSecurityException("cannot encrypt keyset");
                        }
                    } catch (InvalidProtocolBufferException unused) {
                        throw new GeneralSecurityException("invalid keyset, corrupted key material");
                    }
                } else if (!edit.putString(str, AbstractC0228a.n(((W1.g0) fVar.c().f729b).e())).commit()) {
                    throw new IOException("Failed to write to SharedPreferences");
                }
                return fVar;
            }
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        throw new GeneralSecurityException("cannot read or generate keyset");
    }

    public Q1.b i() {
        Q1.c cVar = new Q1.c();
        try {
            boolean a2 = Q1.c.a(this.f588c);
            try {
                return cVar.c(this.f588c);
            } catch (GeneralSecurityException | ProviderException e4) {
                if (a2) {
                    return null;
                }
                throw new KeyStoreException(e0.a.e("the master key ", this.f588c, " exists but is unusable"), e4);
            }
        } catch (GeneralSecurityException | ProviderException unused) {
            return null;
        }
    }
}
