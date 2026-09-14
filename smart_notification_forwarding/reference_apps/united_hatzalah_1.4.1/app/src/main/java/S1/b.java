package S1;

import F0.AbstractC0083t;
import J.C0119g;
import W1.C0204b;
import W1.C0206d;
import W1.C0208f;
import W1.O;
import W1.Q;
import W1.S;
import W1.T;
import W1.U;
import W1.V;
import W1.X;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class b extends R1.d {

    /* renamed from: e, reason: collision with root package name */
    public static final R1.k f2114e = new R1.k(a.class, new C0119g(9));

    /* renamed from: f, reason: collision with root package name */
    public static final R1.k f2115f = new R1.k(i.class, new C0119g(11));

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2116d = 1;

    public /* synthetic */ b(Class cls, L1.g[] gVarArr) {
        super(cls, gVarArr);
    }

    public static R1.c h(int i, int i3, O o2, int i4) {
        S B3 = T.B();
        U B4 = V.B();
        B4.e();
        V.w((V) B4.f4158b, o2);
        B4.e();
        V.x((V) B4.f4158b, i3);
        V v2 = (V) B4.b();
        B3.e();
        T.w((T) B3.f4158b, v2);
        B3.e();
        T.x((T) B3.f4158b, i);
        return new R1.c((T) B3.b(), i4);
    }

    public static void i(C0208f c0208f) {
        if (c0208f.y() >= 10) {
            if (c0208f.y() <= 16) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too long");
            }
        }
        throw new GeneralSecurityException("tag size too short");
    }

    public static void j(V v2) {
        if (v2.A() >= 10) {
            int ordinal = v2.z().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                if (v2.A() > 28) {
                                    throw new GeneralSecurityException("tag size too big");
                                }
                                return;
                            }
                            throw new GeneralSecurityException("unknown hash type");
                        }
                        if (v2.A() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                        return;
                    }
                    if (v2.A() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                }
                if (v2.A() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            }
            if (v2.A() <= 20) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too big");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }

    @Override // R1.d
    public int a() {
        switch (this.f2116d) {
            case 1:
                return 2;
            default:
                return super.a();
        }
    }

    @Override // R1.d
    public final String b() {
        switch (this.f2116d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCmacKey";
            default:
                return "type.googleapis.com/google.crypto.tink.HmacKey";
        }
    }

    @Override // R1.d
    public final AbstractC0083t d() {
        switch (this.f2116d) {
            case 0:
                return new L1.h(C0206d.class);
            default:
                return new L1.h(this);
        }
    }

    @Override // R1.d
    public final X e() {
        switch (this.f2116d) {
            case 0:
                return X.SYMMETRIC;
            default:
                return X.SYMMETRIC;
        }
    }

    @Override // R1.d
    public final AbstractC0329a f(AbstractC0337i abstractC0337i) {
        switch (this.f2116d) {
            case 0:
                return C0204b.D(abstractC0337i, C0344p.a());
            default:
                return Q.E(abstractC0337i, C0344p.a());
        }
    }

    @Override // R1.d
    public final void g(AbstractC0329a abstractC0329a) {
        switch (this.f2116d) {
            case 0:
                C0204b c0204b = (C0204b) abstractC0329a;
                X1.o.c(c0204b.B());
                if (c0204b.z().size() == 32) {
                    i(c0204b.A());
                    return;
                }
                throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
            default:
                Q q3 = (Q) abstractC0329a;
                X1.o.c(q3.C());
                if (q3.A().size() >= 16) {
                    j(q3.B());
                    return;
                }
                throw new GeneralSecurityException("key too short");
        }
    }

    public b() {
        super(Q.class, new L1.g(K1.j.class, 11));
    }
}
