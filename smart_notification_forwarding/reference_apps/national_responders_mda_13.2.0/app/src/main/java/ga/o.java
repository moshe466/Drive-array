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
public final class o extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: j, reason: collision with root package name */
    private static final o f10162j;

    /* renamed from: k, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<o> f10163k = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10164f;

    /* renamed from: g, reason: collision with root package name */
    private List<c> f10165g;

    /* renamed from: h, reason: collision with root package name */
    private byte f10166h;

    /* renamed from: i, reason: collision with root package name */
    private int f10167i;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<o> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public o c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new o(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<o, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10168g;

        /* renamed from: h, reason: collision with root package name */
        private List<c> f10169h = Collections.emptyList();

        private b() {
            y();
        }

        static /* synthetic */ b r() {
            return w();
        }

        private static b w() {
            return new b();
        }

        private void x() {
            if ((this.f10168g & 1) != 1) {
                this.f10169h = new ArrayList(this.f10169h);
                this.f10168g |= 1;
            }
        }

        private void y() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.o.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.o> r1 = ga.o.f10163k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.o r3 = (ga.o) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.o r4 = (ga.o) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.o.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.o$b");
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public o c() {
            o t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public o t() {
            o oVar = new o(this);
            if ((this.f10168g & 1) == 1) {
                this.f10169h = Collections.unmodifiableList(this.f10169h);
                this.f10168g &= -2;
            }
            oVar.f10165g = this.f10169h;
            return oVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b p(o oVar) {
            if (oVar == o.v()) {
                return this;
            }
            if (!oVar.f10165g.isEmpty()) {
                if (this.f10169h.isEmpty()) {
                    this.f10169h = oVar.f10165g;
                    this.f10168g &= -2;
                } else {
                    x();
                    this.f10169h.addAll(oVar.f10165g);
                }
            }
            q(o().f(oVar.f10164f));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: m, reason: collision with root package name */
        private static final c f10170m;

        /* renamed from: n, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f10171n = new a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f10172f;

        /* renamed from: g, reason: collision with root package name */
        private int f10173g;

        /* renamed from: h, reason: collision with root package name */
        private int f10174h;

        /* renamed from: i, reason: collision with root package name */
        private int f10175i;

        /* renamed from: j, reason: collision with root package name */
        private EnumC0181c f10176j;

        /* renamed from: k, reason: collision with root package name */
        private byte f10177k;

        /* renamed from: l, reason: collision with root package name */
        private int f10178l;

        /* loaded from: classes.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public c c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                return new c(eVar, gVar);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends i.b<c, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* renamed from: g, reason: collision with root package name */
            private int f10179g;

            /* renamed from: i, reason: collision with root package name */
            private int f10181i;

            /* renamed from: h, reason: collision with root package name */
            private int f10180h = -1;

            /* renamed from: j, reason: collision with root package name */
            private EnumC0181c f10182j = EnumC0181c.PACKAGE;

            private b() {
                x();
            }

            static /* synthetic */ b r() {
                return w();
            }

            private static b w() {
                return new b();
            }

            private void x() {
            }

            public b A(EnumC0181c enumC0181c) {
                Objects.requireNonNull(enumC0181c);
                this.f10179g |= 4;
                this.f10182j = enumC0181c;
                return this;
            }

            public b B(int i10) {
                this.f10179g |= 1;
                this.f10180h = i10;
                return this;
            }

            public b C(int i10) {
                this.f10179g |= 2;
                this.f10181i = i10;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public c c() {
                c t10 = t();
                if (t10.k()) {
                    return t10;
                }
                throw a.AbstractC0232a.m(t10);
            }

            public c t() {
                c cVar = new c(this);
                int i10 = this.f10179g;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.f10174h = this.f10180h;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.f10175i = this.f10181i;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                cVar.f10176j = this.f10182j;
                cVar.f10173g = i11;
                return cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b n() {
                return w().p(t());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b p(c cVar) {
                if (cVar == c.x()) {
                    return this;
                }
                if (cVar.C()) {
                    B(cVar.z());
                }
                if (cVar.E()) {
                    C(cVar.A());
                }
                if (cVar.B()) {
                    A(cVar.y());
                }
                q(o().f(cVar.f10172f));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ga.o.c.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ga.o$c> r1 = ga.o.c.f10171n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ga.o$c r3 = (ga.o.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ga.o$c r4 = (ga.o.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ga.o.c.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.o$c$b");
            }
        }

        /* renamed from: ga.o$c$c, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0181c implements j.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);

            private static j.b<EnumC0181c> internalValueMap = new a();
            private final int value;

            /* renamed from: ga.o$c$c$a */
            /* loaded from: classes.dex */
            static class a implements j.b<EnumC0181c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0181c a(int i10) {
                    return EnumC0181c.valueOf(i10);
                }
            }

            EnumC0181c(int i10, int i11) {
                this.value = i11;
            }

            public static EnumC0181c valueOf(int i10) {
                if (i10 == 0) {
                    return CLASS;
                }
                if (i10 == 1) {
                    return PACKAGE;
                }
                if (i10 != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            c cVar = new c(true);
            f10170m = cVar;
            cVar.F();
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            this.f10177k = (byte) -1;
            this.f10178l = -1;
            F();
            d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
            kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f10173g |= 1;
                                this.f10174h = eVar.s();
                            } else if (K == 16) {
                                this.f10173g |= 2;
                                this.f10175i = eVar.s();
                            } else if (K == 24) {
                                int n10 = eVar.n();
                                EnumC0181c valueOf = EnumC0181c.valueOf(n10);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n10);
                                } else {
                                    this.f10173g |= 4;
                                    this.f10176j = valueOf;
                                }
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                        }
                        z10 = true;
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f10172f = A.j();
                        throw th2;
                    }
                    this.f10172f = A.j();
                    n();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f10172f = A.j();
                throw th3;
            }
            this.f10172f = A.j();
            n();
        }

        private c(i.b bVar) {
            super(bVar);
            this.f10177k = (byte) -1;
            this.f10178l = -1;
            this.f10172f = bVar.o();
        }

        private c(boolean z10) {
            this.f10177k = (byte) -1;
            this.f10178l = -1;
            this.f10172f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void F() {
            this.f10174h = -1;
            this.f10175i = 0;
            this.f10176j = EnumC0181c.PACKAGE;
        }

        public static b G() {
            return b.r();
        }

        public static b H(c cVar) {
            return G().p(cVar);
        }

        public static c x() {
            return f10170m;
        }

        public int A() {
            return this.f10175i;
        }

        public boolean B() {
            return (this.f10173g & 4) == 4;
        }

        public boolean C() {
            return (this.f10173g & 1) == 1;
        }

        public boolean E() {
            return (this.f10173g & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public b h() {
            return G();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public b d() {
            return H(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f10178l;
            if (i10 != -1) {
                return i10;
            }
            int o10 = (this.f10173g & 1) == 1 ? 0 + kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10174h) : 0;
            if ((this.f10173g & 2) == 2) {
                o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10175i);
            }
            if ((this.f10173g & 4) == 4) {
                o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.h(3, this.f10176j.getNumber());
            }
            int size = o10 + this.f10172f.size();
            this.f10178l = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            a();
            if ((this.f10173g & 1) == 1) {
                fVar.a0(1, this.f10174h);
            }
            if ((this.f10173g & 2) == 2) {
                fVar.a0(2, this.f10175i);
            }
            if ((this.f10173g & 4) == 4) {
                fVar.S(3, this.f10176j.getNumber());
            }
            fVar.i0(this.f10172f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<c> i() {
            return f10171n;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f10177k;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (E()) {
                this.f10177k = (byte) 1;
                return true;
            }
            this.f10177k = (byte) 0;
            return false;
        }

        public EnumC0181c y() {
            return this.f10176j;
        }

        public int z() {
            return this.f10174h;
        }
    }

    static {
        o oVar = new o(true);
        f10162j = oVar;
        oVar.y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private o(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.f10166h = (byte) -1;
        this.f10167i = -1;
        y();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 10) {
                                if (!(z11 & true)) {
                                    this.f10165g = new ArrayList();
                                    z11 |= true;
                                }
                                this.f10165g.add(eVar.u(c.f10171n, gVar));
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
                if (z11 & true) {
                    this.f10165g = Collections.unmodifiableList(this.f10165g);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10164f = A.j();
                    throw th2;
                }
                this.f10164f = A.j();
                n();
                throw th;
            }
        }
        if (z11 & true) {
            this.f10165g = Collections.unmodifiableList(this.f10165g);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10164f = A.j();
            throw th3;
        }
        this.f10164f = A.j();
        n();
    }

    private o(i.b bVar) {
        super(bVar);
        this.f10166h = (byte) -1;
        this.f10167i = -1;
        this.f10164f = bVar.o();
    }

    private o(boolean z10) {
        this.f10166h = (byte) -1;
        this.f10167i = -1;
        this.f10164f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static b A(o oVar) {
        return z().p(oVar);
    }

    public static o v() {
        return f10162j;
    }

    private void y() {
        this.f10165g = Collections.emptyList();
    }

    public static b z() {
        return b.r();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public b h() {
        return z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public b d() {
        return A(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10167i;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10165g.size(); i12++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.f10165g.get(i12));
        }
        int size = i11 + this.f10164f.size();
        this.f10167i = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        for (int i10 = 0; i10 < this.f10165g.size(); i10++) {
            fVar.d0(1, this.f10165g.get(i10));
        }
        fVar.i0(this.f10164f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<o> i() {
        return f10163k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10166h;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < x(); i10++) {
            if (!w(i10).k()) {
                this.f10166h = (byte) 0;
                return false;
            }
        }
        this.f10166h = (byte) 1;
        return true;
    }

    public c w(int i10) {
        return this.f10165g.get(i10);
    }

    public int x() {
        return this.f10165g.size();
    }
}
