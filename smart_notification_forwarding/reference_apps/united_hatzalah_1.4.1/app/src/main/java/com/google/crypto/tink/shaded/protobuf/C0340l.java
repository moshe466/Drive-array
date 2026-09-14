package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;

/* renamed from: com.google.crypto.tink.shaded.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0340l {

    /* renamed from: a, reason: collision with root package name */
    public final M1.d f4125a;

    /* renamed from: b, reason: collision with root package name */
    public int f4126b;

    /* renamed from: c, reason: collision with root package name */
    public int f4127c;

    /* renamed from: d, reason: collision with root package name */
    public int f4128d = 0;

    public C0340l(M1.d dVar) {
        B.a(dVar, "input");
        this.f4125a = dVar;
        dVar.f1403b = this;
    }

    public static void w(int i) {
        if ((i & 3) == 0) {
        } else {
            throw InvalidProtocolBufferException.g();
        }
    }

    public static void x(int i) {
        if ((i & 7) == 0) {
        } else {
            throw InvalidProtocolBufferException.g();
        }
    }

    public final int a() {
        int i = this.f4128d;
        if (i != 0) {
            this.f4126b = i;
            this.f4128d = 0;
        } else {
            this.f4126b = this.f4125a.C();
        }
        int i3 = this.f4126b;
        if (i3 != 0 && i3 != this.f4127c) {
            return i3 >>> 3;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void b(Object obj, b0 b0Var, C0344p c0344p) {
        int i = this.f4127c;
        this.f4127c = ((this.f4126b >>> 3) << 3) | 4;
        try {
            b0Var.h(obj, this, c0344p);
            if (this.f4126b == this.f4127c) {
            } else {
                throw InvalidProtocolBufferException.g();
            }
        } finally {
            this.f4127c = i;
        }
    }

    public final void c(Object obj, b0 b0Var, C0344p c0344p) {
        M1.d dVar = this.f4125a;
        int D3 = dVar.D();
        if (dVar.f1402a < 100) {
            int l3 = dVar.l(D3);
            dVar.f1402a++;
            b0Var.h(obj, this, c0344p);
            dVar.b(0);
            dVar.f1402a--;
            dVar.j(l3);
            return;
        }
        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final void d(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0333e;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0333e abstractC0333e = (AbstractC0333e) list;
            int i = this.f4126b & 7;
            if (i != 0) {
                if (i == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        abstractC0333e.g(dVar.m());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                abstractC0333e.g(dVar.m());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Boolean.valueOf(dVar.m()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Boolean.valueOf(dVar.m()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final AbstractC0337i e() {
        v(2);
        return this.f4125a.o();
    }

    public final void f(List list) {
        int C3;
        if ((this.f4126b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(e());
            M1.d dVar = this.f4125a;
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void g(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0342n;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0342n abstractC0342n = (AbstractC0342n) list;
            int i = this.f4126b & 7;
            if (i != 1) {
                if (i == 2) {
                    int D3 = dVar.D();
                    x(D3);
                    int f4 = dVar.f() + D3;
                    do {
                        abstractC0342n.g(dVar.p());
                    } while (dVar.f() < f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                abstractC0342n.g(dVar.p());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int D4 = dVar.D();
                x(D4);
                int f5 = dVar.f() + D4;
                do {
                    list.add(Double.valueOf(dVar.p()));
                } while (dVar.f() < f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Double.valueOf(dVar.p()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void h(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0352y;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            int i = this.f4126b & 7;
            if (i != 0) {
                if (i == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        abstractC0352y.g(dVar.q());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                abstractC0352y.g(dVar.q());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Integer.valueOf(dVar.q()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Integer.valueOf(dVar.q()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void i(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0352y;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            int i = this.f4126b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw InvalidProtocolBufferException.c();
                }
                do {
                    abstractC0352y.g(dVar.r());
                    if (!dVar.g()) {
                        C4 = dVar.C();
                    } else {
                        return;
                    }
                } while (C4 == this.f4126b);
                this.f4128d = C4;
                return;
            }
            int D3 = dVar.D();
            w(D3);
            int f4 = dVar.f() + D3;
            do {
                abstractC0352y.g(dVar.r());
            } while (dVar.f() < f4);
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(dVar.r()));
                if (!dVar.g()) {
                    C3 = dVar.C();
                } else {
                    return;
                }
            } while (C3 == this.f4126b);
            this.f4128d = C3;
            return;
        }
        int D4 = dVar.D();
        w(D4);
        int f5 = dVar.f() + D4;
        do {
            list.add(Integer.valueOf(dVar.r()));
        } while (dVar.f() < f5);
    }

    public final void j(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof I;
        M1.d dVar = this.f4125a;
        if (z3) {
            I i = (I) list;
            int i3 = this.f4126b & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int D3 = dVar.D();
                    x(D3);
                    int f4 = dVar.f() + D3;
                    do {
                        i.g(dVar.s());
                    } while (dVar.f() < f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                i.g(dVar.s());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i4 = this.f4126b & 7;
        if (i4 != 1) {
            if (i4 == 2) {
                int D4 = dVar.D();
                x(D4);
                int f5 = dVar.f() + D4;
                do {
                    list.add(Long.valueOf(dVar.s()));
                } while (dVar.f() < f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Long.valueOf(dVar.s()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void k(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0347t;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0347t abstractC0347t = (AbstractC0347t) list;
            int i = this.f4126b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw InvalidProtocolBufferException.c();
                }
                do {
                    abstractC0347t.g(dVar.t());
                    if (!dVar.g()) {
                        C4 = dVar.C();
                    } else {
                        return;
                    }
                } while (C4 == this.f4126b);
                this.f4128d = C4;
                return;
            }
            int D3 = dVar.D();
            w(D3);
            int f4 = dVar.f() + D3;
            do {
                abstractC0347t.g(dVar.t());
            } while (dVar.f() < f4);
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Float.valueOf(dVar.t()));
                if (!dVar.g()) {
                    C3 = dVar.C();
                } else {
                    return;
                }
            } while (C3 == this.f4126b);
            this.f4128d = C3;
            return;
        }
        int D4 = dVar.D();
        w(D4);
        int f5 = dVar.f() + D4;
        do {
            list.add(Float.valueOf(dVar.t()));
        } while (dVar.f() < f5);
    }

    public final void l(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0352y;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            int i = this.f4126b & 7;
            if (i != 0) {
                if (i == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        abstractC0352y.g(dVar.u());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                abstractC0352y.g(dVar.u());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Integer.valueOf(dVar.u()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Integer.valueOf(dVar.u()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void m(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof I;
        M1.d dVar = this.f4125a;
        if (z3) {
            I i = (I) list;
            int i3 = this.f4126b & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        i.g(dVar.v());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                i.g(dVar.v());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i4 = this.f4126b & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Long.valueOf(dVar.v()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Long.valueOf(dVar.v()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void n(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0352y;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            int i = this.f4126b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw InvalidProtocolBufferException.c();
                }
                do {
                    abstractC0352y.g(dVar.w());
                    if (!dVar.g()) {
                        C4 = dVar.C();
                    } else {
                        return;
                    }
                } while (C4 == this.f4126b);
                this.f4128d = C4;
                return;
            }
            int D3 = dVar.D();
            w(D3);
            int f4 = dVar.f() + D3;
            do {
                abstractC0352y.g(dVar.w());
            } while (dVar.f() < f4);
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(dVar.w()));
                if (!dVar.g()) {
                    C3 = dVar.C();
                } else {
                    return;
                }
            } while (C3 == this.f4126b);
            this.f4128d = C3;
            return;
        }
        int D4 = dVar.D();
        w(D4);
        int f5 = dVar.f() + D4;
        do {
            list.add(Integer.valueOf(dVar.w()));
        } while (dVar.f() < f5);
    }

    public final void o(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof I;
        M1.d dVar = this.f4125a;
        if (z3) {
            I i = (I) list;
            int i3 = this.f4126b & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int D3 = dVar.D();
                    x(D3);
                    int f4 = dVar.f() + D3;
                    do {
                        i.g(dVar.x());
                    } while (dVar.f() < f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                i.g(dVar.x());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i4 = this.f4126b & 7;
        if (i4 != 1) {
            if (i4 == 2) {
                int D4 = dVar.D();
                x(D4);
                int f5 = dVar.f() + D4;
                do {
                    list.add(Long.valueOf(dVar.x()));
                } while (dVar.f() < f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Long.valueOf(dVar.x()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void p(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0352y;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            int i = this.f4126b & 7;
            if (i != 0) {
                if (i == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        abstractC0352y.g(dVar.y());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                abstractC0352y.g(dVar.y());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Integer.valueOf(dVar.y()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Integer.valueOf(dVar.y()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void q(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof I;
        M1.d dVar = this.f4125a;
        if (z3) {
            I i = (I) list;
            int i3 = this.f4126b & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        i.g(dVar.z());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                i.g(dVar.z());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i4 = this.f4126b & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Long.valueOf(dVar.z()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Long.valueOf(dVar.z()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void r(List list, boolean z3) {
        String A3;
        int C3;
        int C4;
        if ((this.f4126b & 7) == 2) {
            boolean z4 = list instanceof E;
            M1.d dVar = this.f4125a;
            if (z4 && !z3) {
                E e4 = (E) list;
                do {
                    e4.c(e());
                    if (!dVar.g()) {
                        C4 = dVar.C();
                    } else {
                        return;
                    }
                } while (C4 == this.f4126b);
                this.f4128d = C4;
                return;
            }
            do {
                if (z3) {
                    v(2);
                    A3 = dVar.B();
                } else {
                    v(2);
                    A3 = dVar.A();
                }
                list.add(A3);
                if (dVar.g()) {
                    return;
                } else {
                    C3 = dVar.C();
                }
            } while (C3 == this.f4126b);
            this.f4128d = C3;
            return;
        }
        throw InvalidProtocolBufferException.c();
    }

    public final void s(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof AbstractC0352y;
        M1.d dVar = this.f4125a;
        if (z3) {
            AbstractC0352y abstractC0352y = (AbstractC0352y) list;
            int i = this.f4126b & 7;
            if (i != 0) {
                if (i == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        abstractC0352y.g(dVar.D());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                abstractC0352y.g(dVar.D());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i3 = this.f4126b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Integer.valueOf(dVar.D()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Integer.valueOf(dVar.D()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void t(List list) {
        int C3;
        int C4;
        boolean z3 = list instanceof I;
        M1.d dVar = this.f4125a;
        if (z3) {
            I i = (I) list;
            int i3 = this.f4126b & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int f4 = dVar.f() + dVar.D();
                    do {
                        i.g(dVar.E());
                    } while (dVar.f() < f4);
                    u(f4);
                    return;
                }
                throw InvalidProtocolBufferException.c();
            }
            do {
                i.g(dVar.E());
                if (!dVar.g()) {
                    C4 = dVar.C();
                } else {
                    return;
                }
            } while (C4 == this.f4126b);
            this.f4128d = C4;
            return;
        }
        int i4 = this.f4126b & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int f5 = dVar.f() + dVar.D();
                do {
                    list.add(Long.valueOf(dVar.E()));
                } while (dVar.f() < f5);
                u(f5);
                return;
            }
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(Long.valueOf(dVar.E()));
            if (dVar.g()) {
                return;
            } else {
                C3 = dVar.C();
            }
        } while (C3 == this.f4126b);
        this.f4128d = C3;
    }

    public final void u(int i) {
        if (this.f4125a.f() == i) {
        } else {
            throw InvalidProtocolBufferException.h();
        }
    }

    public final void v(int i) {
        if ((this.f4126b & 7) == i) {
        } else {
            throw InvalidProtocolBufferException.c();
        }
    }
}
