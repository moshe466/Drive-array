package ga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public final class q extends i.d<q> {

    /* renamed from: y, reason: collision with root package name */
    private static final q f10191y;

    /* renamed from: z, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<q> f10192z = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10193g;

    /* renamed from: h, reason: collision with root package name */
    private int f10194h;

    /* renamed from: i, reason: collision with root package name */
    private List<b> f10195i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10196j;

    /* renamed from: k, reason: collision with root package name */
    private int f10197k;

    /* renamed from: l, reason: collision with root package name */
    private q f10198l;

    /* renamed from: m, reason: collision with root package name */
    private int f10199m;

    /* renamed from: n, reason: collision with root package name */
    private int f10200n;

    /* renamed from: o, reason: collision with root package name */
    private int f10201o;

    /* renamed from: p, reason: collision with root package name */
    private int f10202p;

    /* renamed from: q, reason: collision with root package name */
    private int f10203q;

    /* renamed from: r, reason: collision with root package name */
    private q f10204r;

    /* renamed from: s, reason: collision with root package name */
    private int f10205s;

    /* renamed from: t, reason: collision with root package name */
    private q f10206t;

    /* renamed from: u, reason: collision with root package name */
    private int f10207u;

    /* renamed from: v, reason: collision with root package name */
    private int f10208v;

    /* renamed from: w, reason: collision with root package name */
    private byte f10209w;

    /* renamed from: x, reason: collision with root package name */
    private int f10210x;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<q> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public q c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new q(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: m, reason: collision with root package name */
        private static final b f10211m;

        /* renamed from: n, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<b> f10212n = new a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f10213f;

        /* renamed from: g, reason: collision with root package name */
        private int f10214g;

        /* renamed from: h, reason: collision with root package name */
        private c f10215h;

        /* renamed from: i, reason: collision with root package name */
        private q f10216i;

        /* renamed from: j, reason: collision with root package name */
        private int f10217j;

        /* renamed from: k, reason: collision with root package name */
        private byte f10218k;

        /* renamed from: l, reason: collision with root package name */
        private int f10219l;

        /* loaded from: classes.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<b> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                return new b(eVar, gVar);
            }
        }

        /* renamed from: ga.q$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0182b extends i.b<b, C0182b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* renamed from: g, reason: collision with root package name */
            private int f10220g;

            /* renamed from: h, reason: collision with root package name */
            private c f10221h = c.INV;

            /* renamed from: i, reason: collision with root package name */
            private q f10222i = q.Z();

            /* renamed from: j, reason: collision with root package name */
            private int f10223j;

            private C0182b() {
                x();
            }

            static /* synthetic */ C0182b r() {
                return w();
            }

            private static C0182b w() {
                return new C0182b();
            }

            private void x() {
            }

            public C0182b A(q qVar) {
                if ((this.f10220g & 2) == 2 && this.f10222i != q.Z()) {
                    qVar = q.A0(this.f10222i).p(qVar).y();
                }
                this.f10222i = qVar;
                this.f10220g |= 2;
                return this;
            }

            public C0182b B(c cVar) {
                Objects.requireNonNull(cVar);
                this.f10220g |= 1;
                this.f10221h = cVar;
                return this;
            }

            public C0182b C(int i10) {
                this.f10220g |= 4;
                this.f10223j = i10;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b c() {
                b t10 = t();
                if (t10.k()) {
                    return t10;
                }
                throw a.AbstractC0232a.m(t10);
            }

            public b t() {
                b bVar = new b(this);
                int i10 = this.f10220g;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.f10215h = this.f10221h;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.f10216i = this.f10222i;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                bVar.f10217j = this.f10223j;
                bVar.f10214g = i11;
                return bVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public C0182b n() {
                return w().p(t());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public C0182b p(b bVar) {
                if (bVar == b.x()) {
                    return this;
                }
                if (bVar.B()) {
                    B(bVar.y());
                }
                if (bVar.C()) {
                    A(bVar.z());
                }
                if (bVar.E()) {
                    C(bVar.A());
                }
                q(o().f(bVar.f10213f));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ga.q.b.C0182b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ga.q$b> r1 = ga.q.b.f10212n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ga.q$b r3 = (ga.q.b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ga.q$b r4 = (ga.q.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ga.q.b.C0182b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.q$b$b");
            }
        }

        /* loaded from: classes.dex */
        public enum c implements j.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);

            private static j.b<c> internalValueMap = new a();
            private final int value;

            /* loaded from: classes.dex */
            static class a implements j.b<c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public c a(int i10) {
                    return c.valueOf(i10);
                }
            }

            c(int i10, int i11) {
                this.value = i11;
            }

            public static c valueOf(int i10) {
                if (i10 == 0) {
                    return IN;
                }
                if (i10 == 1) {
                    return OUT;
                }
                if (i10 == 2) {
                    return INV;
                }
                if (i10 != 3) {
                    return null;
                }
                return STAR;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            b bVar = new b(true);
            f10211m = bVar;
            bVar.F();
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            this.f10218k = (byte) -1;
            this.f10219l = -1;
            F();
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
                                    int n10 = eVar.n();
                                    c valueOf = c.valueOf(n10);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n10);
                                    } else {
                                        this.f10214g |= 1;
                                        this.f10215h = valueOf;
                                    }
                                } else if (K == 18) {
                                    c d10 = (this.f10214g & 2) == 2 ? this.f10216i.d() : null;
                                    q qVar = (q) eVar.u(q.f10192z, gVar);
                                    this.f10216i = qVar;
                                    if (d10 != null) {
                                        d10.p(qVar);
                                        this.f10216i = d10.y();
                                    }
                                    this.f10214g |= 2;
                                } else if (K == 24) {
                                    this.f10214g |= 4;
                                    this.f10217j = eVar.s();
                                } else if (!q(eVar, J, gVar, K)) {
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
                        this.f10213f = A.j();
                        throw th2;
                    }
                    this.f10213f = A.j();
                    n();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f10213f = A.j();
                throw th3;
            }
            this.f10213f = A.j();
            n();
        }

        private b(i.b bVar) {
            super(bVar);
            this.f10218k = (byte) -1;
            this.f10219l = -1;
            this.f10213f = bVar.o();
        }

        private b(boolean z10) {
            this.f10218k = (byte) -1;
            this.f10219l = -1;
            this.f10213f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void F() {
            this.f10215h = c.INV;
            this.f10216i = q.Z();
            this.f10217j = 0;
        }

        public static C0182b G() {
            return C0182b.r();
        }

        public static C0182b H(b bVar) {
            return G().p(bVar);
        }

        public static b x() {
            return f10211m;
        }

        public int A() {
            return this.f10217j;
        }

        public boolean B() {
            return (this.f10214g & 1) == 1;
        }

        public boolean C() {
            return (this.f10214g & 2) == 2;
        }

        public boolean E() {
            return (this.f10214g & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public C0182b h() {
            return G();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public C0182b d() {
            return H(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f10219l;
            if (i10 != -1) {
                return i10;
            }
            int h10 = (this.f10214g & 1) == 1 ? 0 + kotlin.reflect.jvm.internal.impl.protobuf.f.h(1, this.f10215h.getNumber()) : 0;
            if ((this.f10214g & 2) == 2) {
                h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f10216i);
            }
            if ((this.f10214g & 4) == 4) {
                h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(3, this.f10217j);
            }
            int size = h10 + this.f10213f.size();
            this.f10219l = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            a();
            if ((this.f10214g & 1) == 1) {
                fVar.S(1, this.f10215h.getNumber());
            }
            if ((this.f10214g & 2) == 2) {
                fVar.d0(2, this.f10216i);
            }
            if ((this.f10214g & 4) == 4) {
                fVar.a0(3, this.f10217j);
            }
            fVar.i0(this.f10213f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<b> i() {
            return f10212n;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f10218k;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!C() || z().k()) {
                this.f10218k = (byte) 1;
                return true;
            }
            this.f10218k = (byte) 0;
            return false;
        }

        public c y() {
            return this.f10215h;
        }

        public q z() {
            return this.f10216i;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends i.c<q, c> {

        /* renamed from: i, reason: collision with root package name */
        private int f10224i;

        /* renamed from: k, reason: collision with root package name */
        private boolean f10226k;

        /* renamed from: l, reason: collision with root package name */
        private int f10227l;

        /* renamed from: n, reason: collision with root package name */
        private int f10229n;

        /* renamed from: o, reason: collision with root package name */
        private int f10230o;

        /* renamed from: p, reason: collision with root package name */
        private int f10231p;

        /* renamed from: q, reason: collision with root package name */
        private int f10232q;

        /* renamed from: r, reason: collision with root package name */
        private int f10233r;

        /* renamed from: t, reason: collision with root package name */
        private int f10235t;

        /* renamed from: v, reason: collision with root package name */
        private int f10237v;

        /* renamed from: w, reason: collision with root package name */
        private int f10238w;

        /* renamed from: j, reason: collision with root package name */
        private List<b> f10225j = Collections.emptyList();

        /* renamed from: m, reason: collision with root package name */
        private q f10228m = q.Z();

        /* renamed from: s, reason: collision with root package name */
        private q f10234s = q.Z();

        /* renamed from: u, reason: collision with root package name */
        private q f10236u = q.Z();

        private c() {
            C();
        }

        private static c A() {
            return new c();
        }

        private void B() {
            if ((this.f10224i & 1) != 1) {
                this.f10225j = new ArrayList(this.f10225j);
                this.f10224i |= 1;
            }
        }

        private void C() {
        }

        static /* synthetic */ c w() {
            return A();
        }

        public c E(q qVar) {
            if ((this.f10224i & 2048) == 2048 && this.f10236u != q.Z()) {
                qVar = q.A0(this.f10236u).p(qVar).y();
            }
            this.f10236u = qVar;
            this.f10224i |= 2048;
            return this;
        }

        public c F(q qVar) {
            if ((this.f10224i & 8) == 8 && this.f10228m != q.Z()) {
                qVar = q.A0(this.f10228m).p(qVar).y();
            }
            this.f10228m = qVar;
            this.f10224i |= 8;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public c p(q qVar) {
            if (qVar == q.Z()) {
                return this;
            }
            if (!qVar.f10195i.isEmpty()) {
                if (this.f10225j.isEmpty()) {
                    this.f10225j = qVar.f10195i;
                    this.f10224i &= -2;
                } else {
                    B();
                    this.f10225j.addAll(qVar.f10195i);
                }
            }
            if (qVar.s0()) {
                R(qVar.f0());
            }
            if (qVar.p0()) {
                P(qVar.c0());
            }
            if (qVar.q0()) {
                F(qVar.d0());
            }
            if (qVar.r0()) {
                Q(qVar.e0());
            }
            if (qVar.n0()) {
                L(qVar.Y());
            }
            if (qVar.w0()) {
                U(qVar.j0());
            }
            if (qVar.x0()) {
                V(qVar.k0());
            }
            if (qVar.v0()) {
                T(qVar.i0());
            }
            if (qVar.t0()) {
                J(qVar.g0());
            }
            if (qVar.u0()) {
                S(qVar.h0());
            }
            if (qVar.l0()) {
                E(qVar.T());
            }
            if (qVar.m0()) {
                K(qVar.U());
            }
            if (qVar.o0()) {
                O(qVar.b0());
            }
            u(qVar);
            q(o().f(qVar.f10193g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.q.c l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.q> r1 = ga.q.f10192z     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.q r3 = (ga.q) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.q r4 = (ga.q) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.q.c.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.q$c");
        }

        public c J(q qVar) {
            if ((this.f10224i & 512) == 512 && this.f10234s != q.Z()) {
                qVar = q.A0(this.f10234s).p(qVar).y();
            }
            this.f10234s = qVar;
            this.f10224i |= 512;
            return this;
        }

        public c K(int i10) {
            this.f10224i |= 4096;
            this.f10237v = i10;
            return this;
        }

        public c L(int i10) {
            this.f10224i |= 32;
            this.f10230o = i10;
            return this;
        }

        public c O(int i10) {
            this.f10224i |= 8192;
            this.f10238w = i10;
            return this;
        }

        public c P(int i10) {
            this.f10224i |= 4;
            this.f10227l = i10;
            return this;
        }

        public c Q(int i10) {
            this.f10224i |= 16;
            this.f10229n = i10;
            return this;
        }

        public c R(boolean z10) {
            this.f10224i |= 2;
            this.f10226k = z10;
            return this;
        }

        public c S(int i10) {
            this.f10224i |= 1024;
            this.f10235t = i10;
            return this;
        }

        public c T(int i10) {
            this.f10224i |= 256;
            this.f10233r = i10;
            return this;
        }

        public c U(int i10) {
            this.f10224i |= 64;
            this.f10231p = i10;
            return this;
        }

        public c V(int i10) {
            this.f10224i |= 128;
            this.f10232q = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public q c() {
            q y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public q y() {
            q qVar = new q(this);
            int i10 = this.f10224i;
            if ((i10 & 1) == 1) {
                this.f10225j = Collections.unmodifiableList(this.f10225j);
                this.f10224i &= -2;
            }
            qVar.f10195i = this.f10225j;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            qVar.f10196j = this.f10226k;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            qVar.f10197k = this.f10227l;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            qVar.f10198l = this.f10228m;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            qVar.f10199m = this.f10229n;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            qVar.f10200n = this.f10230o;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            qVar.f10201o = this.f10231p;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            qVar.f10202p = this.f10232q;
            if ((i10 & 256) == 256) {
                i11 |= 128;
            }
            qVar.f10203q = this.f10233r;
            if ((i10 & 512) == 512) {
                i11 |= 256;
            }
            qVar.f10204r = this.f10234s;
            if ((i10 & 1024) == 1024) {
                i11 |= 512;
            }
            qVar.f10205s = this.f10235t;
            if ((i10 & 2048) == 2048) {
                i11 |= 1024;
            }
            qVar.f10206t = this.f10236u;
            if ((i10 & 4096) == 4096) {
                i11 |= 2048;
            }
            qVar.f10207u = this.f10237v;
            if ((i10 & 8192) == 8192) {
                i11 |= 4096;
            }
            qVar.f10208v = this.f10238w;
            qVar.f10194h = i11;
            return qVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public c n() {
            return A().p(y());
        }
    }

    static {
        q qVar = new q(true);
        f10191y = qVar;
        qVar.y0();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private q(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        int i10;
        c d10;
        int i11;
        this.f10209w = (byte) -1;
        this.f10210x = -1;
        y0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        switch (K) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.f10194h |= 4096;
                                this.f10208v = eVar.s();
                            case 18:
                                if (!(z11 & true)) {
                                    this.f10195i = new ArrayList();
                                    z11 |= true;
                                }
                                this.f10195i.add(eVar.u(b.f10212n, gVar));
                            case 24:
                                this.f10194h |= 1;
                                this.f10196j = eVar.k();
                            case 32:
                                this.f10194h |= 2;
                                this.f10197k = eVar.s();
                            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                                i10 = 4;
                                d10 = (this.f10194h & 4) == 4 ? this.f10198l.d() : null;
                                q qVar = (q) eVar.u(f10192z, gVar);
                                this.f10198l = qVar;
                                if (d10 != null) {
                                    d10.p(qVar);
                                    this.f10198l = d10.y();
                                }
                                i11 = this.f10194h;
                                this.f10194h = i11 | i10;
                            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
                                this.f10194h |= 16;
                                this.f10200n = eVar.s();
                            case 56:
                                this.f10194h |= 32;
                                this.f10201o = eVar.s();
                            case 64:
                                this.f10194h |= 8;
                                this.f10199m = eVar.s();
                            case 72:
                                this.f10194h |= 64;
                                this.f10202p = eVar.s();
                            case 82:
                                i10 = 256;
                                d10 = (this.f10194h & 256) == 256 ? this.f10204r.d() : null;
                                q qVar2 = (q) eVar.u(f10192z, gVar);
                                this.f10204r = qVar2;
                                if (d10 != null) {
                                    d10.p(qVar2);
                                    this.f10204r = d10.y();
                                }
                                i11 = this.f10194h;
                                this.f10194h = i11 | i10;
                            case 88:
                                this.f10194h |= 512;
                                this.f10205s = eVar.s();
                            case 96:
                                this.f10194h |= 128;
                                this.f10203q = eVar.s();
                            case 106:
                                i10 = 1024;
                                d10 = (this.f10194h & 1024) == 1024 ? this.f10206t.d() : null;
                                q qVar3 = (q) eVar.u(f10192z, gVar);
                                this.f10206t = qVar3;
                                if (d10 != null) {
                                    d10.p(qVar3);
                                    this.f10206t = d10.y();
                                }
                                i11 = this.f10194h;
                                this.f10194h = i11 | i10;
                            case 112:
                                this.f10194h |= 2048;
                                this.f10207u = eVar.s();
                            default:
                                if (!q(eVar, J, gVar, K)) {
                                    z10 = true;
                                }
                        }
                    } catch (IOException e10) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                    throw e11.i(this);
                }
            } catch (Throwable th) {
                if (z11 & true) {
                    this.f10195i = Collections.unmodifiableList(this.f10195i);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10193g = A.j();
                    throw th2;
                }
                this.f10193g = A.j();
                n();
                throw th;
            }
        }
        if (z11 & true) {
            this.f10195i = Collections.unmodifiableList(this.f10195i);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10193g = A.j();
            throw th3;
        }
        this.f10193g = A.j();
        n();
    }

    private q(i.c<q, ?> cVar) {
        super(cVar);
        this.f10209w = (byte) -1;
        this.f10210x = -1;
        this.f10193g = cVar.o();
    }

    private q(boolean z10) {
        this.f10209w = (byte) -1;
        this.f10210x = -1;
        this.f10193g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static c A0(q qVar) {
        return z0().p(qVar);
    }

    public static q Z() {
        return f10191y;
    }

    private void y0() {
        this.f10195i = Collections.emptyList();
        this.f10196j = false;
        this.f10197k = 0;
        this.f10198l = Z();
        this.f10199m = 0;
        this.f10200n = 0;
        this.f10201o = 0;
        this.f10202p = 0;
        this.f10203q = 0;
        this.f10204r = Z();
        this.f10205s = 0;
        this.f10206t = Z();
        this.f10207u = 0;
        this.f10208v = 0;
    }

    public static c z0() {
        return c.w();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public c h() {
        return z0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public c d() {
        return A0(this);
    }

    public q T() {
        return this.f10206t;
    }

    public int U() {
        return this.f10207u;
    }

    public b V(int i10) {
        return this.f10195i.get(i10);
    }

    public int W() {
        return this.f10195i.size();
    }

    public List<b> X() {
        return this.f10195i;
    }

    public int Y() {
        return this.f10200n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10210x;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10194h & 4096) == 4096 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10208v) + 0 : 0;
        for (int i11 = 0; i11 < this.f10195i.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f10195i.get(i11));
        }
        if ((this.f10194h & 1) == 1) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.a(3, this.f10196j);
        }
        if ((this.f10194h & 2) == 2) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(4, this.f10197k);
        }
        if ((this.f10194h & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.f10198l);
        }
        if ((this.f10194h & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(6, this.f10200n);
        }
        if ((this.f10194h & 32) == 32) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.f10201o);
        }
        if ((this.f10194h & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(8, this.f10199m);
        }
        if ((this.f10194h & 64) == 64) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(9, this.f10202p);
        }
        if ((this.f10194h & 256) == 256) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(10, this.f10204r);
        }
        if ((this.f10194h & 512) == 512) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(11, this.f10205s);
        }
        if ((this.f10194h & 128) == 128) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(12, this.f10203q);
        }
        if ((this.f10194h & 1024) == 1024) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(13, this.f10206t);
        }
        if ((this.f10194h & 2048) == 2048) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(14, this.f10207u);
        }
        int u10 = o10 + u() + this.f10193g.size();
        this.f10210x = u10;
        return u10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public q b() {
        return f10191y;
    }

    public int b0() {
        return this.f10208v;
    }

    public int c0() {
        return this.f10197k;
    }

    public q d0() {
        return this.f10198l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10194h & 4096) == 4096) {
            fVar.a0(1, this.f10208v);
        }
        for (int i10 = 0; i10 < this.f10195i.size(); i10++) {
            fVar.d0(2, this.f10195i.get(i10));
        }
        if ((this.f10194h & 1) == 1) {
            fVar.L(3, this.f10196j);
        }
        if ((this.f10194h & 2) == 2) {
            fVar.a0(4, this.f10197k);
        }
        if ((this.f10194h & 4) == 4) {
            fVar.d0(5, this.f10198l);
        }
        if ((this.f10194h & 16) == 16) {
            fVar.a0(6, this.f10200n);
        }
        if ((this.f10194h & 32) == 32) {
            fVar.a0(7, this.f10201o);
        }
        if ((this.f10194h & 8) == 8) {
            fVar.a0(8, this.f10199m);
        }
        if ((this.f10194h & 64) == 64) {
            fVar.a0(9, this.f10202p);
        }
        if ((this.f10194h & 256) == 256) {
            fVar.d0(10, this.f10204r);
        }
        if ((this.f10194h & 512) == 512) {
            fVar.a0(11, this.f10205s);
        }
        if ((this.f10194h & 128) == 128) {
            fVar.a0(12, this.f10203q);
        }
        if ((this.f10194h & 1024) == 1024) {
            fVar.d0(13, this.f10206t);
        }
        if ((this.f10194h & 2048) == 2048) {
            fVar.a0(14, this.f10207u);
        }
        z10.a(200, fVar);
        fVar.i0(this.f10193g);
    }

    public int e0() {
        return this.f10199m;
    }

    public boolean f0() {
        return this.f10196j;
    }

    public q g0() {
        return this.f10204r;
    }

    public int h0() {
        return this.f10205s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<q> i() {
        return f10192z;
    }

    public int i0() {
        return this.f10203q;
    }

    public int j0() {
        return this.f10201o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10209w;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < W(); i10++) {
            if (!V(i10).k()) {
                this.f10209w = (byte) 0;
                return false;
            }
        }
        if (q0() && !d0().k()) {
            this.f10209w = (byte) 0;
            return false;
        }
        if (t0() && !g0().k()) {
            this.f10209w = (byte) 0;
            return false;
        }
        if (l0() && !T().k()) {
            this.f10209w = (byte) 0;
            return false;
        }
        if (t()) {
            this.f10209w = (byte) 1;
            return true;
        }
        this.f10209w = (byte) 0;
        return false;
    }

    public int k0() {
        return this.f10202p;
    }

    public boolean l0() {
        return (this.f10194h & 1024) == 1024;
    }

    public boolean m0() {
        return (this.f10194h & 2048) == 2048;
    }

    public boolean n0() {
        return (this.f10194h & 16) == 16;
    }

    public boolean o0() {
        return (this.f10194h & 4096) == 4096;
    }

    public boolean p0() {
        return (this.f10194h & 2) == 2;
    }

    public boolean q0() {
        return (this.f10194h & 4) == 4;
    }

    public boolean r0() {
        return (this.f10194h & 8) == 8;
    }

    public boolean s0() {
        return (this.f10194h & 1) == 1;
    }

    public boolean t0() {
        return (this.f10194h & 256) == 256;
    }

    public boolean u0() {
        return (this.f10194h & 512) == 512;
    }

    public boolean v0() {
        return (this.f10194h & 128) == 128;
    }

    public boolean w0() {
        return (this.f10194h & 32) == 32;
    }

    public boolean x0() {
        return (this.f10194h & 64) == 64;
    }
}
