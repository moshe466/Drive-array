package L1;

import F0.AbstractC0083t;
import W1.C;
import W1.C0210h;
import W1.C0211i;
import W1.C0212j;
import W1.C0214l;
import W1.C0215m;
import W1.C0216n;
import W1.C0217o;
import W1.C0218p;
import W1.C0220s;
import W1.C0221t;
import W1.C0222u;
import W1.C0223v;
import W1.C0225x;
import W1.C0226y;
import W1.C0227z;
import W1.D;
import W1.F;
import W1.J;
import W1.O;
import W1.Q;
import W1.S;
import W1.T;
import W1.U;
import W1.V;
import W1.X;
import W1.m0;
import W1.p0;
import W1.u0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i extends R1.d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1292d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Class cls, g[] gVarArr, int i) {
        super(cls, gVarArr);
        this.f1292d = i;
    }

    public static R1.c h(int i, int i3) {
        C0220s A3 = C0221t.A();
        A3.e();
        C0221t.x((C0221t) A3.f4158b, i);
        C0222u z3 = C0223v.z();
        z3.e();
        C0223v.w((C0223v) z3.f4158b);
        C0223v c0223v = (C0223v) z3.b();
        A3.e();
        C0221t.w((C0221t) A3.f4158b, c0223v);
        return new R1.c((C0221t) A3.b(), i3);
    }

    public static R1.c i(int i, int i3, int i4) {
        C0215m B3 = C0216n.B();
        C0217o z3 = C0218p.z();
        z3.e();
        C0218p.w((C0218p) z3.f4158b);
        C0218p c0218p = (C0218p) z3.b();
        B3.e();
        C0216n.w((C0216n) B3.f4158b, c0218p);
        B3.e();
        C0216n.x((C0216n) B3.f4158b, i);
        C0216n c0216n = (C0216n) B3.b();
        S B4 = T.B();
        U B5 = V.B();
        B5.e();
        V.w((V) B5.f4158b, O.SHA256);
        B5.e();
        V.x((V) B5.f4158b, i3);
        V v2 = (V) B5.b();
        B4.e();
        T.w((T) B4.f4158b, v2);
        B4.e();
        T.x((T) B4.f4158b, 32);
        T t3 = (T) B4.b();
        C0211i A3 = C0212j.A();
        A3.e();
        C0212j.w((C0212j) A3.f4158b, c0216n);
        A3.e();
        C0212j.x((C0212j) A3.f4158b, t3);
        return new R1.c((C0212j) A3.b(), i4);
    }

    public static R1.c j(int i, int i3) {
        C0226y y = C0227z.y();
        y.e();
        C0227z.w((C0227z) y.f4158b, i);
        return new R1.c((C0227z) y.b(), i3);
    }

    public static R1.c k(int i, int i3) {
        C y = D.y();
        y.e();
        D.w((D) y.f4158b, i);
        return new R1.c((D) y.b(), i3);
    }

    @Override // R1.d
    public int a() {
        switch (this.f1292d) {
            case 0:
                return 2;
            case 1:
            default:
                return super.a();
            case 2:
                return 2;
        }
    }

    @Override // R1.d
    public final String b() {
        switch (this.f1292d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
            case 1:
                return "type.googleapis.com/google.crypto.tink.AesEaxKey";
            case 2:
                return "type.googleapis.com/google.crypto.tink.AesGcmKey";
            case 3:
                return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
            case 4:
                return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
            case 5:
                return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
            case 6:
                return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
            case 7:
                return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
            default:
                return "type.googleapis.com/google.crypto.tink.AesSivKey";
        }
    }

    @Override // R1.d
    public final AbstractC0083t d() {
        switch (this.f1292d) {
            case 0:
                return new h(this);
            case 1:
                return new h(this, (byte) 0);
            case 2:
                return new h(this, (char) 0);
            case 3:
                return new h(this, 0);
            case 4:
                return new h(this, (short) 0);
            case 5:
                return new h(this, (byte) 0, false);
            case 6:
                return new h(this, (byte) 0, (byte) 0);
            case 7:
                return new h(this, (byte) 0, (char) 0);
            default:
                return new h(this, (byte) 0, 0);
        }
    }

    @Override // R1.d
    public final X e() {
        switch (this.f1292d) {
            case 0:
                return X.SYMMETRIC;
            case 1:
                return X.SYMMETRIC;
            case 2:
                return X.SYMMETRIC;
            case 3:
                return X.SYMMETRIC;
            case 4:
                return X.SYMMETRIC;
            case 5:
                return X.REMOTE;
            case 6:
                return X.REMOTE;
            case 7:
                return X.SYMMETRIC;
            default:
                return X.SYMMETRIC;
        }
    }

    @Override // R1.d
    public final AbstractC0329a f(AbstractC0337i abstractC0337i) {
        switch (this.f1292d) {
            case 0:
                return C0210h.D(abstractC0337i, C0344p.a());
            case 1:
                return W1.r.D(abstractC0337i, C0344p.a());
            case 2:
                return C0225x.B(abstractC0337i, C0344p.a());
            case 3:
                return W1.B.B(abstractC0337i, C0344p.a());
            case 4:
                return J.B(abstractC0337i, C0344p.a());
            case 5:
                return m0.B(abstractC0337i, C0344p.a());
            case 6:
                return p0.B(abstractC0337i, C0344p.a());
            case 7:
                return u0.B(abstractC0337i, C0344p.a());
            default:
                return F.B(abstractC0337i, C0344p.a());
        }
    }

    @Override // R1.d
    public final void g(AbstractC0329a abstractC0329a) {
        switch (this.f1292d) {
            case 0:
                C0210h c0210h = (C0210h) abstractC0329a;
                X1.o.c(c0210h.B());
                g[] gVarArr = {new g(X1.j.class, 1)};
                HashMap hashMap = new HashMap();
                g gVar = gVarArr[0];
                Class cls = gVar.f1289a;
                if (!hashMap.containsKey(cls)) {
                    hashMap.put(cls, gVar);
                    Class cls2 = gVarArr[0].f1289a;
                    Collections.unmodifiableMap(hashMap);
                    C0214l z3 = c0210h.z();
                    X1.o.c(z3.C());
                    X1.o.a(z3.A().size());
                    C0218p B3 = z3.B();
                    if (B3.y() >= 12 && B3.y() <= 16) {
                        g[] gVarArr2 = {new g(K1.j.class, 11)};
                        HashMap hashMap2 = new HashMap();
                        g gVar2 = gVarArr2[0];
                        Class cls3 = gVar2.f1289a;
                        if (!hashMap2.containsKey(cls3)) {
                            hashMap2.put(cls3, gVar2);
                            Class cls4 = gVarArr2[0].f1289a;
                            Collections.unmodifiableMap(hashMap2);
                            Q A3 = c0210h.A();
                            X1.o.c(A3.C());
                            if (A3.A().size() >= 16) {
                                S1.b.j(A3.B());
                                return;
                            }
                            throw new GeneralSecurityException("key too short");
                        }
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                    }
                    throw new GeneralSecurityException("invalid IV size");
                }
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
            case 1:
                W1.r rVar = (W1.r) abstractC0329a;
                X1.o.c(rVar.B());
                X1.o.a(rVar.z().size());
                if (rVar.A().y() != 12 && rVar.A().y() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 2:
                C0225x c0225x = (C0225x) abstractC0329a;
                X1.o.c(c0225x.z());
                X1.o.a(c0225x.y().size());
                return;
            case 3:
                W1.B b4 = (W1.B) abstractC0329a;
                X1.o.c(b4.z());
                X1.o.a(b4.y().size());
                return;
            case 4:
                J j2 = (J) abstractC0329a;
                X1.o.c(j2.z());
                if (j2.y().size() == 32) {
                    return;
                } else {
                    throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
                }
            case 5:
                X1.o.c(((m0) abstractC0329a).z());
                return;
            case 6:
                X1.o.c(((p0) abstractC0329a).z());
                return;
            case 7:
                u0 u0Var = (u0) abstractC0329a;
                X1.o.c(u0Var.z());
                if (u0Var.y().size() == 32) {
                    return;
                } else {
                    throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
                }
            default:
                F f4 = (F) abstractC0329a;
                X1.o.c(f4.z());
                if (f4.y().size() == 64) {
                    return;
                }
                throw new InvalidKeyException("invalid key size: " + f4.y().size() + ". Valid keys must have 64 bytes.");
        }
    }
}
