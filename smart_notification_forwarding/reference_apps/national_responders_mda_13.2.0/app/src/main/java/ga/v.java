package ga;

import java.io.IOException;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public final class v extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: p, reason: collision with root package name */
    private static final v f10314p;

    /* renamed from: q, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<v> f10315q = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10316f;

    /* renamed from: g, reason: collision with root package name */
    private int f10317g;

    /* renamed from: h, reason: collision with root package name */
    private int f10318h;

    /* renamed from: i, reason: collision with root package name */
    private int f10319i;

    /* renamed from: j, reason: collision with root package name */
    private c f10320j;

    /* renamed from: k, reason: collision with root package name */
    private int f10321k;

    /* renamed from: l, reason: collision with root package name */
    private int f10322l;

    /* renamed from: m, reason: collision with root package name */
    private d f10323m;

    /* renamed from: n, reason: collision with root package name */
    private byte f10324n;

    /* renamed from: o, reason: collision with root package name */
    private int f10325o;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<v> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public v c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new v(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<v, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10326g;

        /* renamed from: h, reason: collision with root package name */
        private int f10327h;

        /* renamed from: i, reason: collision with root package name */
        private int f10328i;

        /* renamed from: k, reason: collision with root package name */
        private int f10330k;

        /* renamed from: l, reason: collision with root package name */
        private int f10331l;

        /* renamed from: j, reason: collision with root package name */
        private c f10329j = c.ERROR;

        /* renamed from: m, reason: collision with root package name */
        private d f10332m = d.LANGUAGE_VERSION;

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

        public b A(int i10) {
            this.f10326g |= 8;
            this.f10330k = i10;
            return this;
        }

        public b B(c cVar) {
            Objects.requireNonNull(cVar);
            this.f10326g |= 4;
            this.f10329j = cVar;
            return this;
        }

        public b C(int i10) {
            this.f10326g |= 16;
            this.f10331l = i10;
            return this;
        }

        public b E(int i10) {
            this.f10326g |= 1;
            this.f10327h = i10;
            return this;
        }

        public b F(int i10) {
            this.f10326g |= 2;
            this.f10328i = i10;
            return this;
        }

        public b G(d dVar) {
            Objects.requireNonNull(dVar);
            this.f10326g |= 32;
            this.f10332m = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public v c() {
            v t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public v t() {
            v vVar = new v(this);
            int i10 = this.f10326g;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            vVar.f10318h = this.f10327h;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            vVar.f10319i = this.f10328i;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            vVar.f10320j = this.f10329j;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            vVar.f10321k = this.f10330k;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            vVar.f10322l = this.f10331l;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            vVar.f10323m = this.f10332m;
            vVar.f10317g = i11;
            return vVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public b p(v vVar) {
            if (vVar == v.A()) {
                return this;
            }
            if (vVar.L()) {
                E(vVar.F());
            }
            if (vVar.M()) {
                F(vVar.G());
            }
            if (vVar.J()) {
                B(vVar.C());
            }
            if (vVar.I()) {
                A(vVar.B());
            }
            if (vVar.K()) {
                C(vVar.E());
            }
            if (vVar.N()) {
                G(vVar.H());
            }
            q(o().f(vVar.f10316f));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.v.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.v> r1 = ga.v.f10315q     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.v r3 = (ga.v) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.v r4 = (ga.v) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.v.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.v$b");
        }
    }

    /* loaded from: classes.dex */
    public enum c implements j.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);

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
                return WARNING;
            }
            if (i10 == 1) {
                return ERROR;
            }
            if (i10 != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum d implements j.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);

        private static j.b<d> internalValueMap = new a();
        private final int value;

        /* loaded from: classes.dex */
        static class a implements j.b<d> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i10) {
                return d.valueOf(i10);
            }
        }

        d(int i10, int i11) {
            this.value = i11;
        }

        public static d valueOf(int i10) {
            if (i10 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i10 == 1) {
                return COMPILER_VERSION;
            }
            if (i10 != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        v vVar = new v(true);
        f10314p = vVar;
        vVar.O();
    }

    private v(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        int n10;
        this.f10324n = (byte) -1;
        this.f10325o = -1;
        O();
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
                                this.f10317g |= 1;
                                this.f10318h = eVar.s();
                            } else if (K == 16) {
                                this.f10317g |= 2;
                                this.f10319i = eVar.s();
                            } else if (K == 24) {
                                n10 = eVar.n();
                                c valueOf = c.valueOf(n10);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n10);
                                } else {
                                    this.f10317g |= 4;
                                    this.f10320j = valueOf;
                                }
                            } else if (K == 32) {
                                this.f10317g |= 8;
                                this.f10321k = eVar.s();
                            } else if (K == 40) {
                                this.f10317g |= 16;
                                this.f10322l = eVar.s();
                            } else if (K == 48) {
                                n10 = eVar.n();
                                d valueOf2 = d.valueOf(n10);
                                if (valueOf2 == null) {
                                    J.o0(K);
                                    J.o0(n10);
                                } else {
                                    this.f10317g |= 32;
                                    this.f10323m = valueOf2;
                                }
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
                    this.f10316f = A.j();
                    throw th2;
                }
                this.f10316f = A.j();
                n();
                throw th;
            }
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10316f = A.j();
            throw th3;
        }
        this.f10316f = A.j();
        n();
    }

    private v(i.b bVar) {
        super(bVar);
        this.f10324n = (byte) -1;
        this.f10325o = -1;
        this.f10316f = bVar.o();
    }

    private v(boolean z10) {
        this.f10324n = (byte) -1;
        this.f10325o = -1;
        this.f10316f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static v A() {
        return f10314p;
    }

    private void O() {
        this.f10318h = 0;
        this.f10319i = 0;
        this.f10320j = c.ERROR;
        this.f10321k = 0;
        this.f10322l = 0;
        this.f10323m = d.LANGUAGE_VERSION;
    }

    public static b P() {
        return b.r();
    }

    public static b Q(v vVar) {
        return P().p(vVar);
    }

    public int B() {
        return this.f10321k;
    }

    public c C() {
        return this.f10320j;
    }

    public int E() {
        return this.f10322l;
    }

    public int F() {
        return this.f10318h;
    }

    public int G() {
        return this.f10319i;
    }

    public d H() {
        return this.f10323m;
    }

    public boolean I() {
        return (this.f10317g & 8) == 8;
    }

    public boolean J() {
        return (this.f10317g & 4) == 4;
    }

    public boolean K() {
        return (this.f10317g & 16) == 16;
    }

    public boolean L() {
        return (this.f10317g & 1) == 1;
    }

    public boolean M() {
        return (this.f10317g & 2) == 2;
    }

    public boolean N() {
        return (this.f10317g & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public b h() {
        return P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public b d() {
        return Q(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10325o;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10317g & 1) == 1 ? 0 + kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10318h) : 0;
        if ((this.f10317g & 2) == 2) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10319i);
        }
        if ((this.f10317g & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.h(3, this.f10320j.getNumber());
        }
        if ((this.f10317g & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(4, this.f10321k);
        }
        if ((this.f10317g & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.f10322l);
        }
        if ((this.f10317g & 32) == 32) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.h(6, this.f10323m.getNumber());
        }
        int size = o10 + this.f10316f.size();
        this.f10325o = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        if ((this.f10317g & 1) == 1) {
            fVar.a0(1, this.f10318h);
        }
        if ((this.f10317g & 2) == 2) {
            fVar.a0(2, this.f10319i);
        }
        if ((this.f10317g & 4) == 4) {
            fVar.S(3, this.f10320j.getNumber());
        }
        if ((this.f10317g & 8) == 8) {
            fVar.a0(4, this.f10321k);
        }
        if ((this.f10317g & 16) == 16) {
            fVar.a0(5, this.f10322l);
        }
        if ((this.f10317g & 32) == 32) {
            fVar.S(6, this.f10323m.getNumber());
        }
        fVar.i0(this.f10316f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<v> i() {
        return f10315q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10324n;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f10324n = (byte) 1;
        return true;
    }
}
