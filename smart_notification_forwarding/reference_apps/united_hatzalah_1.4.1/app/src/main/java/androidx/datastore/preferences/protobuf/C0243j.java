package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.firebase.remoteconfig.internal.Code;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0243j {

    /* renamed from: a, reason: collision with root package name */
    public final M1.d f3192a;

    /* renamed from: b, reason: collision with root package name */
    public int f3193b;

    /* renamed from: c, reason: collision with root package name */
    public int f3194c;

    /* renamed from: d, reason: collision with root package name */
    public int f3195d = 0;

    public C0243j(M1.d dVar) {
        Charset charset = AbstractC0255w.f3236a;
        this.f3192a = dVar;
        dVar.f1403b = this;
    }

    public final int a() {
        int i = this.f3195d;
        if (i != 0) {
            this.f3193b = i;
            this.f3195d = 0;
        } else {
            this.f3193b = this.f3192a.C();
        }
        int i3 = this.f3193b;
        if (i3 != 0 && i3 != this.f3194c) {
            return i3 >>> 3;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void b(Object obj, S s3, C0246m c0246m) {
        int i = this.f3194c;
        this.f3194c = ((this.f3193b >>> 3) << 3) | 4;
        try {
            s3.h(obj, this, c0246m);
            if (this.f3193b == this.f3194c) {
            } else {
                throw new IOException("Failed to parse the message.");
            }
        } finally {
            this.f3194c = i;
        }
    }

    public final void c(Object obj, S s3, C0246m c0246m) {
        M1.d dVar = this.f3192a;
        int D3 = dVar.D();
        if (dVar.f1402a < 100) {
            int l3 = dVar.l(D3);
            dVar.f1402a++;
            s3.h(obj, this, c0246m);
            dVar.b(0);
            dVar.f1402a--;
            dVar.j(l3);
            return;
        }
        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public final void d(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Boolean.valueOf(dVar.m()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Boolean.valueOf(dVar.m()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final C0240g e() {
        w(2);
        return this.f3192a.n();
    }

    public final void f(InterfaceC0254v interfaceC0254v) {
        int C3;
        if ((this.f3193b & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(e());
            M1.d dVar = this.f3192a;
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void g(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 1) {
            if (i == 2) {
                int D3 = dVar.D();
                if ((D3 & 7) == 0) {
                    int f4 = dVar.f() + D3;
                    do {
                        ((P) interfaceC0254v).add(Double.valueOf(dVar.p()));
                    } while (dVar.f() < f4);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Double.valueOf(dVar.p()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void h(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Integer.valueOf(dVar.q()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Integer.valueOf(dVar.q()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final Object i(n0 n0Var, Class cls, C0246m c0246m) {
        int ordinal = n0Var.ordinal();
        M1.d dVar = this.f3192a;
        switch (ordinal) {
            case 0:
                w(1);
                return Double.valueOf(dVar.p());
            case 1:
                w(5);
                return Float.valueOf(dVar.t());
            case 2:
                w(0);
                return Long.valueOf(dVar.v());
            case 3:
                w(0);
                return Long.valueOf(dVar.E());
            case 4:
                w(0);
                return Integer.valueOf(dVar.u());
            case 5:
                w(1);
                return Long.valueOf(dVar.s());
            case 6:
                w(5);
                return Integer.valueOf(dVar.r());
            case 7:
                w(0);
                return Boolean.valueOf(dVar.m());
            case 8:
                w(2);
                return dVar.B();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                w(2);
                S a2 = O.f3120c.a(cls);
                AbstractC0253u newInstance = a2.newInstance();
                c(newInstance, a2, c0246m);
                a2.b(newInstance);
                return newInstance;
            case 11:
                return e();
            case Code.UNIMPLEMENTED /* 12 */:
                w(0);
                return Integer.valueOf(dVar.D());
            case 13:
                w(0);
                return Integer.valueOf(dVar.q());
            case 14:
                w(5);
                return Integer.valueOf(dVar.w());
            case 15:
                w(1);
                return Long.valueOf(dVar.x());
            case 16:
                w(0);
                return Integer.valueOf(dVar.y());
            case 17:
                w(0);
                return Long.valueOf(dVar.z());
        }
    }

    public final void j(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 2) {
            if (i != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                ((P) interfaceC0254v).add(Integer.valueOf(dVar.r()));
                if (!dVar.g()) {
                    C3 = dVar.C();
                } else {
                    return;
                }
            } while (C3 == this.f3193b);
            this.f3195d = C3;
            return;
        }
        int D3 = dVar.D();
        if ((D3 & 3) == 0) {
            int f4 = dVar.f() + D3;
            do {
                ((P) interfaceC0254v).add(Integer.valueOf(dVar.r()));
            } while (dVar.f() < f4);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void k(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 1) {
            if (i == 2) {
                int D3 = dVar.D();
                if ((D3 & 7) == 0) {
                    int f4 = dVar.f() + D3;
                    do {
                        ((P) interfaceC0254v).add(Long.valueOf(dVar.s()));
                    } while (dVar.f() < f4);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Long.valueOf(dVar.s()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void l(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 2) {
            if (i != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                ((P) interfaceC0254v).add(Float.valueOf(dVar.t()));
                if (!dVar.g()) {
                    C3 = dVar.C();
                } else {
                    return;
                }
            } while (C3 == this.f3193b);
            this.f3195d = C3;
            return;
        }
        int D3 = dVar.D();
        if ((D3 & 3) == 0) {
            int f4 = dVar.f() + D3;
            do {
                ((P) interfaceC0254v).add(Float.valueOf(dVar.t()));
            } while (dVar.f() < f4);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void m(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Integer.valueOf(dVar.u()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Integer.valueOf(dVar.u()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void n(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Long.valueOf(dVar.v()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Long.valueOf(dVar.v()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void o(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 2) {
            if (i != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                ((P) interfaceC0254v).add(Integer.valueOf(dVar.w()));
                if (!dVar.g()) {
                    C3 = dVar.C();
                } else {
                    return;
                }
            } while (C3 == this.f3193b);
            this.f3195d = C3;
            return;
        }
        int D3 = dVar.D();
        if ((D3 & 3) == 0) {
            int f4 = dVar.f() + D3;
            do {
                ((P) interfaceC0254v).add(Integer.valueOf(dVar.w()));
            } while (dVar.f() < f4);
            return;
        }
        throw new IOException("Failed to parse the message.");
    }

    public final void p(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 1) {
            if (i == 2) {
                int D3 = dVar.D();
                if ((D3 & 7) == 0) {
                    int f4 = dVar.f() + D3;
                    do {
                        ((P) interfaceC0254v).add(Long.valueOf(dVar.x()));
                    } while (dVar.f() < f4);
                    return;
                }
                throw new IOException("Failed to parse the message.");
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Long.valueOf(dVar.x()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void q(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Integer.valueOf(dVar.y()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Integer.valueOf(dVar.y()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void r(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Long.valueOf(dVar.z()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Long.valueOf(dVar.z()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void s(InterfaceC0254v interfaceC0254v, boolean z3) {
        String A3;
        int C3;
        if ((this.f3193b & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            M1.d dVar = this.f3192a;
            if (z3) {
                w(2);
                A3 = dVar.B();
            } else {
                w(2);
                A3 = dVar.A();
            }
            ((P) interfaceC0254v).add(A3);
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void t(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Integer.valueOf(dVar.D()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Integer.valueOf(dVar.D()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void u(InterfaceC0254v interfaceC0254v) {
        int C3;
        int i = this.f3193b & 7;
        M1.d dVar = this.f3192a;
        if (i != 0) {
            if (i == 2) {
                int f4 = dVar.f() + dVar.D();
                do {
                    ((P) interfaceC0254v).add(Long.valueOf(dVar.E()));
                } while (dVar.f() < f4);
                v(f4);
                return;
            }
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((P) interfaceC0254v).add(Long.valueOf(dVar.E()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f3193b);
        this.f3195d = C3;
    }

    public final void v(int i) {
        if (this.f3192a.f() == i) {
        } else {
            throw InvalidProtocolBufferException.f();
        }
    }

    public final void w(int i) {
        if ((this.f3193b & 7) == i) {
        } else {
            throw InvalidProtocolBufferException.b();
        }
    }

    public final boolean x() {
        int i;
        M1.d dVar = this.f3192a;
        if (!dVar.g() && (i = this.f3193b) != this.f3194c) {
            return dVar.F(i);
        }
        return false;
    }
}
