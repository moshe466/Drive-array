package L1;

import F0.AbstractC0083t;
import W1.C0203a;
import W1.C0204b;
import W1.C0205c;
import W1.C0206d;
import W1.C0207e;
import W1.C0208f;
import W1.C0209g;
import W1.C0210h;
import W1.C0212j;
import W1.C0213k;
import W1.C0214l;
import W1.C0216n;
import W1.C0218p;
import W1.C0219q;
import W1.C0221t;
import W1.C0223v;
import W1.C0224w;
import W1.C0225x;
import W1.C0227z;
import W1.D;
import W1.E;
import W1.F;
import W1.G;
import W1.H;
import W1.I;
import W1.J;
import W1.L;
import W1.O;
import W1.P;
import W1.Q;
import W1.T;
import W1.V;
import W1.l0;
import W1.m0;
import W1.n0;
import W1.o0;
import W1.p0;
import W1.q0;
import W1.t0;
import W1.u0;
import W1.v0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends AbstractC0083t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1291b = 0;

    public /* synthetic */ h(Class cls) {
        super(cls);
    }

    @Override // F0.AbstractC0083t
    public final AbstractC0329a c(AbstractC0329a abstractC0329a) {
        switch (this.f1291b) {
            case 0:
                C0212j c0212j = (C0212j) abstractC0329a;
                g[] gVarArr = {new g(X1.j.class, 1)};
                HashMap hashMap = new HashMap();
                for (g gVar : gVarArr) {
                    Class cls = gVar.f1289a;
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, gVar);
                    } else {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
                    }
                }
                if (gVarArr.length > 0) {
                    Class cls2 = gVarArr[0].f1289a;
                }
                Collections.unmodifiableMap(hashMap);
                C0216n y = c0212j.y();
                C0213k D3 = C0214l.D();
                C0218p A3 = y.A();
                D3.e();
                C0214l.x((C0214l) D3.f4158b, A3);
                byte[] a2 = X1.n.a(y.z());
                C0336h i = AbstractC0337i.i(a2, 0, a2.length);
                D3.e();
                C0214l.y((C0214l) D3.f4158b, i);
                D3.e();
                C0214l.w((C0214l) D3.f4158b);
                C0214l c0214l = (C0214l) D3.b();
                g[] gVarArr2 = {new g(K1.j.class, 11)};
                HashMap hashMap2 = new HashMap();
                for (g gVar2 : gVarArr2) {
                    Class cls3 = gVar2.f1289a;
                    if (!hashMap2.containsKey(cls3)) {
                        hashMap2.put(cls3, gVar2);
                    } else {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                    }
                }
                if (gVarArr2.length > 0) {
                    Class cls4 = gVarArr2[0].f1289a;
                }
                Collections.unmodifiableMap(hashMap2);
                T z3 = c0212j.z();
                P D4 = Q.D();
                D4.e();
                Q.w((Q) D4.f4158b);
                V A4 = z3.A();
                D4.e();
                Q.x((Q) D4.f4158b, A4);
                byte[] a4 = X1.n.a(z3.z());
                C0336h i3 = AbstractC0337i.i(a4, 0, a4.length);
                D4.e();
                Q.y((Q) D4.f4158b, i3);
                Q q3 = (Q) D4.b();
                C0209g C3 = C0210h.C();
                C3.e();
                C0210h.x((C0210h) C3.f4158b, c0214l);
                C3.e();
                C0210h.y((C0210h) C3.f4158b, q3);
                C3.e();
                C0210h.w((C0210h) C3.f4158b);
                return (C0210h) C3.b();
            case 1:
                C0221t c0221t = (C0221t) abstractC0329a;
                C0219q C4 = W1.r.C();
                byte[] a5 = X1.n.a(c0221t.y());
                C0336h i4 = AbstractC0337i.i(a5, 0, a5.length);
                C4.e();
                W1.r.y((W1.r) C4.f4158b, i4);
                C0223v z4 = c0221t.z();
                C4.e();
                W1.r.x((W1.r) C4.f4158b, z4);
                C4.e();
                W1.r.w((W1.r) C4.f4158b);
                return (W1.r) C4.b();
            case 2:
                C0224w A5 = C0225x.A();
                byte[] a6 = X1.n.a(((C0227z) abstractC0329a).x());
                C0336h i5 = AbstractC0337i.i(a6, 0, a6.length);
                A5.e();
                C0225x.x((C0225x) A5.f4158b, i5);
                A5.e();
                C0225x.w((C0225x) A5.f4158b);
                return (C0225x) A5.b();
            case 3:
                W1.A A6 = W1.B.A();
                byte[] a7 = X1.n.a(((D) abstractC0329a).x());
                C0336h i6 = AbstractC0337i.i(a7, 0, a7.length);
                A6.e();
                W1.B.x((W1.B) A6.f4158b, i6);
                A6.e();
                W1.B.w((W1.B) A6.f4158b);
                return (W1.B) A6.b();
            case 4:
                I A7 = J.A();
                A7.e();
                J.w((J) A7.f4158b);
                byte[] a8 = X1.n.a(32);
                C0336h i7 = AbstractC0337i.i(a8, 0, a8.length);
                A7.e();
                J.x((J) A7.f4158b, i7);
                return (J) A7.b();
            case 5:
                l0 A8 = m0.A();
                A8.e();
                m0.x((m0) A8.f4158b, (n0) abstractC0329a);
                A8.e();
                m0.w((m0) A8.f4158b);
                return (m0) A8.b();
            case 6:
                o0 A9 = p0.A();
                A9.e();
                p0.x((p0) A9.f4158b, (q0) abstractC0329a);
                A9.e();
                p0.w((p0) A9.f4158b);
                return (p0) A9.b();
            case 7:
                t0 A10 = u0.A();
                A10.e();
                u0.w((u0) A10.f4158b);
                byte[] a9 = X1.n.a(32);
                C0336h i8 = AbstractC0337i.i(a9, 0, a9.length);
                A10.e();
                u0.x((u0) A10.f4158b, i8);
                return (u0) A10.b();
            case 8:
                E A11 = F.A();
                byte[] a10 = X1.n.a(((H) abstractC0329a).x());
                C0336h i9 = AbstractC0337i.i(a10, 0, a10.length);
                A11.e();
                F.x((F) A11.f4158b, i9);
                A11.e();
                F.w((F) A11.f4158b);
                return (F) A11.b();
            case 9:
                C0206d c0206d = (C0206d) abstractC0329a;
                C0203a C5 = C0204b.C();
                C5.e();
                C0204b.w((C0204b) C5.f4158b);
                byte[] a11 = X1.n.a(c0206d.y());
                C0336h i10 = AbstractC0337i.i(a11, 0, a11.length);
                C5.e();
                C0204b.x((C0204b) C5.f4158b, i10);
                C0208f z5 = c0206d.z();
                C5.e();
                C0204b.y((C0204b) C5.f4158b, z5);
                return (C0204b) C5.b();
            default:
                T t3 = (T) abstractC0329a;
                P D5 = Q.D();
                D5.e();
                Q.w((Q) D5.f4158b);
                V A12 = t3.A();
                D5.e();
                Q.x((Q) D5.f4158b, A12);
                byte[] a12 = X1.n.a(t3.z());
                C0336h i11 = AbstractC0337i.i(a12, 0, a12.length);
                D5.e();
                Q.y((Q) D5.f4158b, i11);
                return (Q) D5.b();
        }
    }

    @Override // F0.AbstractC0083t
    public Map m() {
        switch (this.f1291b) {
            case 0:
                HashMap hashMap = new HashMap();
                hashMap.put("AES128_CTR_HMAC_SHA256", i.i(16, 16, 1));
                hashMap.put("AES128_CTR_HMAC_SHA256_RAW", i.i(16, 16, 3));
                hashMap.put("AES256_CTR_HMAC_SHA256", i.i(32, 32, 1));
                hashMap.put("AES256_CTR_HMAC_SHA256_RAW", i.i(32, 32, 3));
                return Collections.unmodifiableMap(hashMap);
            case 1:
                HashMap hashMap2 = new HashMap();
                hashMap2.put("AES128_EAX", i.h(16, 1));
                hashMap2.put("AES128_EAX_RAW", i.h(16, 3));
                hashMap2.put("AES256_EAX", i.h(32, 1));
                hashMap2.put("AES256_EAX_RAW", i.h(32, 3));
                return Collections.unmodifiableMap(hashMap2);
            case 2:
                HashMap hashMap3 = new HashMap();
                hashMap3.put("AES128_GCM", i.j(16, 1));
                hashMap3.put("AES128_GCM_RAW", i.j(16, 3));
                hashMap3.put("AES256_GCM", i.j(32, 1));
                hashMap3.put("AES256_GCM_RAW", i.j(32, 3));
                return Collections.unmodifiableMap(hashMap3);
            case 3:
                HashMap hashMap4 = new HashMap();
                hashMap4.put("AES128_GCM_SIV", i.k(16, 1));
                hashMap4.put("AES128_GCM_SIV_RAW", i.k(16, 3));
                hashMap4.put("AES256_GCM_SIV", i.k(32, 1));
                hashMap4.put("AES256_GCM_SIV_RAW", i.k(32, 3));
                return Collections.unmodifiableMap(hashMap4);
            case 4:
                HashMap hashMap5 = new HashMap();
                hashMap5.put("CHACHA20_POLY1305", new R1.c(L.w(), 1));
                hashMap5.put("CHACHA20_POLY1305_RAW", new R1.c(L.w(), 3));
                return Collections.unmodifiableMap(hashMap5);
            case 5:
            case 6:
            default:
                return super.m();
            case 7:
                HashMap hashMap6 = new HashMap();
                hashMap6.put("XCHACHA20_POLY1305", new R1.c(v0.w(), 1));
                hashMap6.put("XCHACHA20_POLY1305_RAW", new R1.c(v0.w(), 3));
                return Collections.unmodifiableMap(hashMap6);
            case 8:
                HashMap hashMap7 = new HashMap();
                G y = H.y();
                y.e();
                H.w((H) y.f4158b);
                hashMap7.put("AES256_SIV", new R1.c((H) y.b(), 1));
                G y3 = H.y();
                y3.e();
                H.w((H) y3.f4158b);
                hashMap7.put("AES256_SIV_RAW", new R1.c((H) y3.b(), 3));
                return Collections.unmodifiableMap(hashMap7);
            case 9:
                HashMap hashMap8 = new HashMap();
                C0205c A3 = C0206d.A();
                A3.e();
                C0206d.w((C0206d) A3.f4158b);
                C0207e z3 = C0208f.z();
                z3.e();
                C0208f.w((C0208f) z3.f4158b);
                C0208f c0208f = (C0208f) z3.b();
                A3.e();
                C0206d.x((C0206d) A3.f4158b, c0208f);
                hashMap8.put("AES_CMAC", new R1.c((C0206d) A3.b(), 1));
                C0205c A4 = C0206d.A();
                A4.e();
                C0206d.w((C0206d) A4.f4158b);
                C0207e z4 = C0208f.z();
                z4.e();
                C0208f.w((C0208f) z4.f4158b);
                C0208f c0208f2 = (C0208f) z4.b();
                A4.e();
                C0206d.x((C0206d) A4.f4158b, c0208f2);
                hashMap8.put("AES256_CMAC", new R1.c((C0206d) A4.b(), 1));
                C0205c A5 = C0206d.A();
                A5.e();
                C0206d.w((C0206d) A5.f4158b);
                C0207e z5 = C0208f.z();
                z5.e();
                C0208f.w((C0208f) z5.f4158b);
                C0208f c0208f3 = (C0208f) z5.b();
                A5.e();
                C0206d.x((C0206d) A5.f4158b, c0208f3);
                hashMap8.put("AES256_CMAC_RAW", new R1.c((C0206d) A5.b(), 3));
                return Collections.unmodifiableMap(hashMap8);
            case 10:
                HashMap hashMap9 = new HashMap();
                O o2 = O.SHA256;
                hashMap9.put("HMAC_SHA256_128BITTAG", S1.b.h(32, 16, o2, 1));
                hashMap9.put("HMAC_SHA256_128BITTAG_RAW", S1.b.h(32, 16, o2, 3));
                hashMap9.put("HMAC_SHA256_256BITTAG", S1.b.h(32, 32, o2, 1));
                hashMap9.put("HMAC_SHA256_256BITTAG_RAW", S1.b.h(32, 32, o2, 3));
                O o4 = O.SHA512;
                hashMap9.put("HMAC_SHA512_128BITTAG", S1.b.h(64, 16, o4, 1));
                hashMap9.put("HMAC_SHA512_128BITTAG_RAW", S1.b.h(64, 16, o4, 3));
                hashMap9.put("HMAC_SHA512_256BITTAG", S1.b.h(64, 32, o4, 1));
                hashMap9.put("HMAC_SHA512_256BITTAG_RAW", S1.b.h(64, 32, o4, 3));
                hashMap9.put("HMAC_SHA512_512BITTAG", S1.b.h(64, 64, o4, 1));
                hashMap9.put("HMAC_SHA512_512BITTAG_RAW", S1.b.h(64, 64, o4, 3));
                return Collections.unmodifiableMap(hashMap9);
        }
    }

    @Override // F0.AbstractC0083t
    public final AbstractC0329a n(AbstractC0337i abstractC0337i) {
        switch (this.f1291b) {
            case 0:
                return C0212j.B(abstractC0337i, C0344p.a());
            case 1:
                return C0221t.B(abstractC0337i, C0344p.a());
            case 2:
                return C0227z.z(abstractC0337i, C0344p.a());
            case 3:
                return D.z(abstractC0337i, C0344p.a());
            case 4:
                return L.x(abstractC0337i, C0344p.a());
            case 5:
                return n0.y(abstractC0337i, C0344p.a());
            case 6:
                return q0.A(abstractC0337i, C0344p.a());
            case 7:
                return v0.x(abstractC0337i, C0344p.a());
            case 8:
                return H.z(abstractC0337i, C0344p.a());
            case 9:
                return C0206d.B(abstractC0337i, C0344p.a());
            default:
                return T.C(abstractC0337i, C0344p.a());
        }
    }

    @Override // F0.AbstractC0083t
    public final void o(AbstractC0329a abstractC0329a) {
        switch (this.f1291b) {
            case 0:
                C0212j c0212j = (C0212j) abstractC0329a;
                g[] gVarArr = {new g(X1.j.class, 1)};
                HashMap hashMap = new HashMap();
                for (g gVar : gVarArr) {
                    Class cls = gVar.f1289a;
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, gVar);
                    } else {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
                    }
                }
                if (gVarArr.length > 0) {
                    Class cls2 = gVarArr[0].f1289a;
                }
                Collections.unmodifiableMap(hashMap);
                C0216n y = c0212j.y();
                X1.o.a(y.z());
                C0218p A3 = y.A();
                if (A3.y() >= 12 && A3.y() <= 16) {
                    g[] gVarArr2 = {new g(K1.j.class, 11)};
                    HashMap hashMap2 = new HashMap();
                    for (g gVar2 : gVarArr2) {
                        Class cls3 = gVar2.f1289a;
                        if (!hashMap2.containsKey(cls3)) {
                            hashMap2.put(cls3, gVar2);
                        } else {
                            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                        }
                    }
                    if (gVarArr2.length > 0) {
                        Class cls4 = gVarArr2[0].f1289a;
                    }
                    Collections.unmodifiableMap(hashMap2);
                    T z3 = c0212j.z();
                    if (z3.z() >= 16) {
                        S1.b.j(z3.A());
                        X1.o.a(c0212j.y().z());
                        return;
                    }
                    throw new GeneralSecurityException("key too short");
                }
                throw new GeneralSecurityException("invalid IV size");
            case 1:
                C0221t c0221t = (C0221t) abstractC0329a;
                X1.o.a(c0221t.y());
                if (c0221t.z().y() != 12 && c0221t.z().y() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 2:
                X1.o.a(((C0227z) abstractC0329a).x());
                return;
            case 3:
                X1.o.a(((D) abstractC0329a).x());
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                q0 q0Var = (q0) abstractC0329a;
                if (!q0Var.y().isEmpty() && q0Var.z()) {
                    return;
                } else {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
            case 7:
                return;
            case 8:
                H h2 = (H) abstractC0329a;
                if (h2.x() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + h2.x() + ". Valid keys must have 64 bytes.");
            case 9:
                C0206d c0206d = (C0206d) abstractC0329a;
                S1.b.i(c0206d.z());
                if (c0206d.y() == 32) {
                    return;
                } else {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
            default:
                T t3 = (T) abstractC0329a;
                if (t3.z() >= 16) {
                    S1.b.j(t3.A());
                    return;
                }
                throw new GeneralSecurityException("key too short");
        }
    }

    public h(i iVar, byte b4, boolean z3) {
        super(n0.class);
    }

    public h(i iVar, byte b4, byte b5) {
        super(q0.class);
    }

    public h(i iVar, char c4) {
        super(C0227z.class);
    }

    public h(i iVar, byte b4) {
        super(C0221t.class);
    }

    public h(i iVar, int i) {
        super(D.class);
    }

    public h(i iVar, short s3) {
        super(L.class);
    }

    public h(i iVar, byte b4, char c4) {
        super(v0.class);
    }

    public h(i iVar, byte b4, int i) {
        super(H.class);
    }

    public h(i iVar) {
        super(C0212j.class);
    }

    public h(S1.b bVar) {
        super(T.class);
    }
}
