package ga;

import ga.q;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class u extends i.d<u> {

    /* renamed from: q, reason: collision with root package name */
    private static final u f10295q;

    /* renamed from: r, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<u> f10296r = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10297g;

    /* renamed from: h, reason: collision with root package name */
    private int f10298h;

    /* renamed from: i, reason: collision with root package name */
    private int f10299i;

    /* renamed from: j, reason: collision with root package name */
    private int f10300j;

    /* renamed from: k, reason: collision with root package name */
    private q f10301k;

    /* renamed from: l, reason: collision with root package name */
    private int f10302l;

    /* renamed from: m, reason: collision with root package name */
    private q f10303m;

    /* renamed from: n, reason: collision with root package name */
    private int f10304n;

    /* renamed from: o, reason: collision with root package name */
    private byte f10305o;

    /* renamed from: p, reason: collision with root package name */
    private int f10306p;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<u> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public u c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new u(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<u, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10307i;

        /* renamed from: j, reason: collision with root package name */
        private int f10308j;

        /* renamed from: k, reason: collision with root package name */
        private int f10309k;

        /* renamed from: m, reason: collision with root package name */
        private int f10311m;

        /* renamed from: o, reason: collision with root package name */
        private int f10313o;

        /* renamed from: l, reason: collision with root package name */
        private q f10310l = q.Z();

        /* renamed from: n, reason: collision with root package name */
        private q f10312n = q.Z();

        private b() {
            B();
        }

        private static b A() {
            return new b();
        }

        private void B() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b p(u uVar) {
            if (uVar == u.K()) {
                return this;
            }
            if (uVar.S()) {
                I(uVar.M());
            }
            if (uVar.T()) {
                J(uVar.N());
            }
            if (uVar.U()) {
                F(uVar.O());
            }
            if (uVar.V()) {
                K(uVar.P());
            }
            if (uVar.W()) {
                G(uVar.Q());
            }
            if (uVar.X()) {
                L(uVar.R());
            }
            u(uVar);
            q(o().f(uVar.f10297g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.u.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.u> r1 = ga.u.f10296r     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.u r3 = (ga.u) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                if (r3 == 0) goto Le
                r2.p(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.q r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ga.u r4 = (ga.u) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.p(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.u.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.u$b");
        }

        public b F(q qVar) {
            if ((this.f10307i & 4) == 4 && this.f10310l != q.Z()) {
                qVar = q.A0(this.f10310l).p(qVar).y();
            }
            this.f10310l = qVar;
            this.f10307i |= 4;
            return this;
        }

        public b G(q qVar) {
            if ((this.f10307i & 16) == 16 && this.f10312n != q.Z()) {
                qVar = q.A0(this.f10312n).p(qVar).y();
            }
            this.f10312n = qVar;
            this.f10307i |= 16;
            return this;
        }

        public b I(int i10) {
            this.f10307i |= 1;
            this.f10308j = i10;
            return this;
        }

        public b J(int i10) {
            this.f10307i |= 2;
            this.f10309k = i10;
            return this;
        }

        public b K(int i10) {
            this.f10307i |= 8;
            this.f10311m = i10;
            return this;
        }

        public b L(int i10) {
            this.f10307i |= 32;
            this.f10313o = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public u c() {
            u y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public u y() {
            u uVar = new u(this);
            int i10 = this.f10307i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            uVar.f10299i = this.f10308j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            uVar.f10300j = this.f10309k;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            uVar.f10301k = this.f10310l;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            uVar.f10302l = this.f10311m;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            uVar.f10303m = this.f10312n;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            uVar.f10304n = this.f10313o;
            uVar.f10298h = i11;
            return uVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        u uVar = new u(true);
        f10295q = uVar;
        uVar.Y();
    }

    private u(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        q.c d10;
        this.f10305o = (byte) -1;
        this.f10306p = -1;
        Y();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f10298h |= 1;
                                this.f10299i = eVar.s();
                            } else if (K != 16) {
                                if (K == 26) {
                                    d10 = (this.f10298h & 4) == 4 ? this.f10301k.d() : null;
                                    q qVar = (q) eVar.u(q.f10192z, gVar);
                                    this.f10301k = qVar;
                                    if (d10 != null) {
                                        d10.p(qVar);
                                        this.f10301k = d10.y();
                                    }
                                    this.f10298h |= 4;
                                } else if (K == 34) {
                                    d10 = (this.f10298h & 16) == 16 ? this.f10303m.d() : null;
                                    q qVar2 = (q) eVar.u(q.f10192z, gVar);
                                    this.f10303m = qVar2;
                                    if (d10 != null) {
                                        d10.p(qVar2);
                                        this.f10303m = d10.y();
                                    }
                                    this.f10298h |= 16;
                                } else if (K == 40) {
                                    this.f10298h |= 8;
                                    this.f10302l = eVar.s();
                                } else if (K == 48) {
                                    this.f10298h |= 32;
                                    this.f10304n = eVar.s();
                                } else if (!q(eVar, J, gVar, K)) {
                                }
                            } else {
                                this.f10298h |= 2;
                                this.f10300j = eVar.s();
                            }
                        }
                        z10 = true;
                    } catch (IOException e10) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                    throw e11.i(this);
                }
            } catch (Throwable th) {
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10297g = A.j();
                    throw th2;
                }
                this.f10297g = A.j();
                n();
                throw th;
            }
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10297g = A.j();
            throw th3;
        }
        this.f10297g = A.j();
        n();
    }

    private u(i.c<u, ?> cVar) {
        super(cVar);
        this.f10305o = (byte) -1;
        this.f10306p = -1;
        this.f10297g = cVar.o();
    }

    private u(boolean z10) {
        this.f10305o = (byte) -1;
        this.f10306p = -1;
        this.f10297g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static u K() {
        return f10295q;
    }

    private void Y() {
        this.f10299i = 0;
        this.f10300j = 0;
        this.f10301k = q.Z();
        this.f10302l = 0;
        this.f10303m = q.Z();
        this.f10304n = 0;
    }

    public static b Z() {
        return b.w();
    }

    public static b a0(u uVar) {
        return Z().p(uVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public u b() {
        return f10295q;
    }

    public int M() {
        return this.f10299i;
    }

    public int N() {
        return this.f10300j;
    }

    public q O() {
        return this.f10301k;
    }

    public int P() {
        return this.f10302l;
    }

    public q Q() {
        return this.f10303m;
    }

    public int R() {
        return this.f10304n;
    }

    public boolean S() {
        return (this.f10298h & 1) == 1;
    }

    public boolean T() {
        return (this.f10298h & 2) == 2;
    }

    public boolean U() {
        return (this.f10298h & 4) == 4;
    }

    public boolean V() {
        return (this.f10298h & 8) == 8;
    }

    public boolean W() {
        return (this.f10298h & 16) == 16;
    }

    public boolean X() {
        return (this.f10298h & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10306p;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10298h & 1) == 1 ? 0 + kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10299i) : 0;
        if ((this.f10298h & 2) == 2) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10300j);
        }
        if ((this.f10298h & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10301k);
        }
        if ((this.f10298h & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10303m);
        }
        if ((this.f10298h & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.f10302l);
        }
        if ((this.f10298h & 32) == 32) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(6, this.f10304n);
        }
        int u10 = o10 + u() + this.f10297g.size();
        this.f10306p = u10;
        return u10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return Z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return a0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10298h & 1) == 1) {
            fVar.a0(1, this.f10299i);
        }
        if ((this.f10298h & 2) == 2) {
            fVar.a0(2, this.f10300j);
        }
        if ((this.f10298h & 4) == 4) {
            fVar.d0(3, this.f10301k);
        }
        if ((this.f10298h & 16) == 16) {
            fVar.d0(4, this.f10303m);
        }
        if ((this.f10298h & 8) == 8) {
            fVar.a0(5, this.f10302l);
        }
        if ((this.f10298h & 32) == 32) {
            fVar.a0(6, this.f10304n);
        }
        z10.a(200, fVar);
        fVar.i0(this.f10297g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<u> i() {
        return f10296r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10305o;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!T()) {
            this.f10305o = (byte) 0;
            return false;
        }
        if (U() && !O().k()) {
            this.f10305o = (byte) 0;
            return false;
        }
        if (W() && !Q().k()) {
            this.f10305o = (byte) 0;
            return false;
        }
        if (t()) {
            this.f10305o = (byte) 1;
            return true;
        }
        this.f10305o = (byte) 0;
        return false;
    }
}
