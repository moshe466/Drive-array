package ga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class t extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: l, reason: collision with root package name */
    private static final t f10284l;

    /* renamed from: m, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<t> f10285m = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10286f;

    /* renamed from: g, reason: collision with root package name */
    private int f10287g;

    /* renamed from: h, reason: collision with root package name */
    private List<q> f10288h;

    /* renamed from: i, reason: collision with root package name */
    private int f10289i;

    /* renamed from: j, reason: collision with root package name */
    private byte f10290j;

    /* renamed from: k, reason: collision with root package name */
    private int f10291k;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<t> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public t c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new t(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<t, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10292g;

        /* renamed from: h, reason: collision with root package name */
        private List<q> f10293h = Collections.emptyList();

        /* renamed from: i, reason: collision with root package name */
        private int f10294i = -1;

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
            if ((this.f10292g & 1) != 1) {
                this.f10293h = new ArrayList(this.f10293h);
                this.f10292g |= 1;
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
        public ga.t.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.t> r1 = ga.t.f10285m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.t r3 = (ga.t) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.t r4 = (ga.t) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.t.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.t$b");
        }

        public b B(int i10) {
            this.f10292g |= 2;
            this.f10294i = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public t c() {
            t t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public t t() {
            t tVar = new t(this);
            int i10 = this.f10292g;
            if ((i10 & 1) == 1) {
                this.f10293h = Collections.unmodifiableList(this.f10293h);
                this.f10292g &= -2;
            }
            tVar.f10288h = this.f10293h;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            tVar.f10289i = this.f10294i;
            tVar.f10287g = i11;
            return tVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b p(t tVar) {
            if (tVar == t.x()) {
                return this;
            }
            if (!tVar.f10288h.isEmpty()) {
                if (this.f10293h.isEmpty()) {
                    this.f10293h = tVar.f10288h;
                    this.f10292g &= -2;
                } else {
                    x();
                    this.f10293h.addAll(tVar.f10288h);
                }
            }
            if (tVar.C()) {
                B(tVar.y());
            }
            q(o().f(tVar.f10286f));
            return this;
        }
    }

    static {
        t tVar = new t(true);
        f10284l = tVar;
        tVar.E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private t(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.f10290j = (byte) -1;
        this.f10291k = -1;
        E();
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
                                    this.f10288h = new ArrayList();
                                    z11 |= true;
                                }
                                this.f10288h.add(eVar.u(q.f10192z, gVar));
                            } else if (K == 16) {
                                this.f10287g |= 1;
                                this.f10289i = eVar.s();
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
                    this.f10288h = Collections.unmodifiableList(this.f10288h);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10286f = A.j();
                    throw th2;
                }
                this.f10286f = A.j();
                n();
                throw th;
            }
        }
        if (z11 & true) {
            this.f10288h = Collections.unmodifiableList(this.f10288h);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10286f = A.j();
            throw th3;
        }
        this.f10286f = A.j();
        n();
    }

    private t(i.b bVar) {
        super(bVar);
        this.f10290j = (byte) -1;
        this.f10291k = -1;
        this.f10286f = bVar.o();
    }

    private t(boolean z10) {
        this.f10290j = (byte) -1;
        this.f10291k = -1;
        this.f10286f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    private void E() {
        this.f10288h = Collections.emptyList();
        this.f10289i = -1;
    }

    public static b F() {
        return b.r();
    }

    public static b G(t tVar) {
        return F().p(tVar);
    }

    public static t x() {
        return f10284l;
    }

    public int A() {
        return this.f10288h.size();
    }

    public List<q> B() {
        return this.f10288h;
    }

    public boolean C() {
        return (this.f10287g & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public b h() {
        return F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public b d() {
        return G(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10291k;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10288h.size(); i12++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.f10288h.get(i12));
        }
        if ((this.f10287g & 1) == 1) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10289i);
        }
        int size = i11 + this.f10286f.size();
        this.f10291k = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        for (int i10 = 0; i10 < this.f10288h.size(); i10++) {
            fVar.d0(1, this.f10288h.get(i10));
        }
        if ((this.f10287g & 1) == 1) {
            fVar.a0(2, this.f10289i);
        }
        fVar.i0(this.f10286f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<t> i() {
        return f10285m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10290j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < A(); i10++) {
            if (!z(i10).k()) {
                this.f10290j = (byte) 0;
                return false;
            }
        }
        this.f10290j = (byte) 1;
        return true;
    }

    public int y() {
        return this.f10289i;
    }

    public q z(int i10) {
        return this.f10288h.get(i10);
    }
}
