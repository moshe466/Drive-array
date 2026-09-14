package ga;

import ga.h;
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
public final class f extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: n, reason: collision with root package name */
    private static final f f10023n;

    /* renamed from: o, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<f> f10024o = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10025f;

    /* renamed from: g, reason: collision with root package name */
    private int f10026g;

    /* renamed from: h, reason: collision with root package name */
    private c f10027h;

    /* renamed from: i, reason: collision with root package name */
    private List<h> f10028i;

    /* renamed from: j, reason: collision with root package name */
    private h f10029j;

    /* renamed from: k, reason: collision with root package name */
    private d f10030k;

    /* renamed from: l, reason: collision with root package name */
    private byte f10031l;

    /* renamed from: m, reason: collision with root package name */
    private int f10032m;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<f> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public f c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new f(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<f, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10033g;

        /* renamed from: h, reason: collision with root package name */
        private c f10034h = c.RETURNS_CONSTANT;

        /* renamed from: i, reason: collision with root package name */
        private List<h> f10035i = Collections.emptyList();

        /* renamed from: j, reason: collision with root package name */
        private h f10036j = h.H();

        /* renamed from: k, reason: collision with root package name */
        private d f10037k = d.AT_MOST_ONCE;

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
            if ((this.f10033g & 2) != 2) {
                this.f10035i = new ArrayList(this.f10035i);
                this.f10033g |= 2;
            }
        }

        private void y() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b p(f fVar) {
            if (fVar == f.A()) {
                return this;
            }
            if (fVar.H()) {
                C(fVar.E());
            }
            if (!fVar.f10028i.isEmpty()) {
                if (this.f10035i.isEmpty()) {
                    this.f10035i = fVar.f10028i;
                    this.f10033g &= -3;
                } else {
                    x();
                    this.f10035i.addAll(fVar.f10028i);
                }
            }
            if (fVar.G()) {
                z(fVar.z());
            }
            if (fVar.I()) {
                E(fVar.F());
            }
            q(o().f(fVar.f10025f));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.f.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.f> r1 = ga.f.f10024o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.f r3 = (ga.f) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.f r4 = (ga.f) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.f.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.f$b");
        }

        public b C(c cVar) {
            Objects.requireNonNull(cVar);
            this.f10033g |= 1;
            this.f10034h = cVar;
            return this;
        }

        public b E(d dVar) {
            Objects.requireNonNull(dVar);
            this.f10033g |= 8;
            this.f10037k = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public f c() {
            f t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public f t() {
            f fVar = new f(this);
            int i10 = this.f10033g;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            fVar.f10027h = this.f10034h;
            if ((this.f10033g & 2) == 2) {
                this.f10035i = Collections.unmodifiableList(this.f10035i);
                this.f10033g &= -3;
            }
            fVar.f10028i = this.f10035i;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            fVar.f10029j = this.f10036j;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            fVar.f10030k = this.f10037k;
            fVar.f10026g = i11;
            return fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }

        public b z(h hVar) {
            if ((this.f10033g & 4) == 4 && this.f10036j != h.H()) {
                hVar = h.V(this.f10036j).p(hVar).t();
            }
            this.f10036j = hVar;
            this.f10033g |= 4;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c implements j.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);

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
                return RETURNS_CONSTANT;
            }
            if (i10 == 1) {
                return CALLS;
            }
            if (i10 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum d implements j.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);

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
                return AT_MOST_ONCE;
            }
            if (i10 == 1) {
                return EXACTLY_ONCE;
            }
            if (i10 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        f fVar = new f(true);
        f10023n = fVar;
        fVar.J();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        int n10;
        this.f10031l = (byte) -1;
        this.f10032m = -1;
        J();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 8) {
                            n10 = eVar.n();
                            c valueOf = c.valueOf(n10);
                            if (valueOf == null) {
                                J.o0(K);
                                J.o0(n10);
                            } else {
                                this.f10026g |= 1;
                                this.f10027h = valueOf;
                            }
                        } else if (K == 18) {
                            if ((i10 & 2) != 2) {
                                this.f10028i = new ArrayList();
                                i10 |= 2;
                            }
                            this.f10028i.add(eVar.u(h.f10048r, gVar));
                        } else if (K == 26) {
                            h.b d10 = (this.f10026g & 2) == 2 ? this.f10029j.d() : null;
                            h hVar = (h) eVar.u(h.f10048r, gVar);
                            this.f10029j = hVar;
                            if (d10 != null) {
                                d10.p(hVar);
                                this.f10029j = d10.t();
                            }
                            this.f10026g |= 2;
                        } else if (K == 32) {
                            n10 = eVar.n();
                            d valueOf2 = d.valueOf(n10);
                            if (valueOf2 == null) {
                                J.o0(K);
                                J.o0(n10);
                            } else {
                                this.f10026g |= 4;
                                this.f10030k = valueOf2;
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
                if ((i10 & 2) == 2) {
                    this.f10028i = Collections.unmodifiableList(this.f10028i);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10025f = A.j();
                    throw th2;
                }
                this.f10025f = A.j();
                n();
                throw th;
            }
        }
        if ((i10 & 2) == 2) {
            this.f10028i = Collections.unmodifiableList(this.f10028i);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10025f = A.j();
            throw th3;
        }
        this.f10025f = A.j();
        n();
    }

    private f(i.b bVar) {
        super(bVar);
        this.f10031l = (byte) -1;
        this.f10032m = -1;
        this.f10025f = bVar.o();
    }

    private f(boolean z10) {
        this.f10031l = (byte) -1;
        this.f10032m = -1;
        this.f10025f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static f A() {
        return f10023n;
    }

    private void J() {
        this.f10027h = c.RETURNS_CONSTANT;
        this.f10028i = Collections.emptyList();
        this.f10029j = h.H();
        this.f10030k = d.AT_MOST_ONCE;
    }

    public static b K() {
        return b.r();
    }

    public static b L(f fVar) {
        return K().p(fVar);
    }

    public h B(int i10) {
        return this.f10028i.get(i10);
    }

    public int C() {
        return this.f10028i.size();
    }

    public c E() {
        return this.f10027h;
    }

    public d F() {
        return this.f10030k;
    }

    public boolean G() {
        return (this.f10026g & 2) == 2;
    }

    public boolean H() {
        return (this.f10026g & 1) == 1;
    }

    public boolean I() {
        return (this.f10026g & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public b h() {
        return K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public b d() {
        return L(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10032m;
        if (i10 != -1) {
            return i10;
        }
        int h10 = (this.f10026g & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.h(1, this.f10027h.getNumber()) + 0 : 0;
        for (int i11 = 0; i11 < this.f10028i.size(); i11++) {
            h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f10028i.get(i11));
        }
        if ((this.f10026g & 2) == 2) {
            h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10029j);
        }
        if ((this.f10026g & 4) == 4) {
            h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.h(4, this.f10030k.getNumber());
        }
        int size = h10 + this.f10025f.size();
        this.f10032m = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        if ((this.f10026g & 1) == 1) {
            fVar.S(1, this.f10027h.getNumber());
        }
        for (int i10 = 0; i10 < this.f10028i.size(); i10++) {
            fVar.d0(2, this.f10028i.get(i10));
        }
        if ((this.f10026g & 2) == 2) {
            fVar.d0(3, this.f10029j);
        }
        if ((this.f10026g & 4) == 4) {
            fVar.S(4, this.f10030k.getNumber());
        }
        fVar.i0(this.f10025f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<f> i() {
        return f10024o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10031l;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < C(); i10++) {
            if (!B(i10).k()) {
                this.f10031l = (byte) 0;
                return false;
            }
        }
        if (!G() || z().k()) {
            this.f10031l = (byte) 1;
            return true;
        }
        this.f10031l = (byte) 0;
        return false;
    }

    public h z() {
        return this.f10029j;
    }
}
