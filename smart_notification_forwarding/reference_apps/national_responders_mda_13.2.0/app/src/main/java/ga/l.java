package ga;

import ga.t;
import ga.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class l extends i.d<l> {

    /* renamed from: p, reason: collision with root package name */
    private static final l f10099p;

    /* renamed from: q, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<l> f10100q = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10101g;

    /* renamed from: h, reason: collision with root package name */
    private int f10102h;

    /* renamed from: i, reason: collision with root package name */
    private List<i> f10103i;

    /* renamed from: j, reason: collision with root package name */
    private List<n> f10104j;

    /* renamed from: k, reason: collision with root package name */
    private List<r> f10105k;

    /* renamed from: l, reason: collision with root package name */
    private t f10106l;

    /* renamed from: m, reason: collision with root package name */
    private w f10107m;

    /* renamed from: n, reason: collision with root package name */
    private byte f10108n;

    /* renamed from: o, reason: collision with root package name */
    private int f10109o;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<l> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public l c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new l(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<l, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10110i;

        /* renamed from: j, reason: collision with root package name */
        private List<i> f10111j = Collections.emptyList();

        /* renamed from: k, reason: collision with root package name */
        private List<n> f10112k = Collections.emptyList();

        /* renamed from: l, reason: collision with root package name */
        private List<r> f10113l = Collections.emptyList();

        /* renamed from: m, reason: collision with root package name */
        private t f10114m = t.x();

        /* renamed from: n, reason: collision with root package name */
        private w f10115n = w.v();

        private b() {
            F();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10110i & 1) != 1) {
                this.f10111j = new ArrayList(this.f10111j);
                this.f10110i |= 1;
            }
        }

        private void C() {
            if ((this.f10110i & 2) != 2) {
                this.f10112k = new ArrayList(this.f10112k);
                this.f10110i |= 2;
            }
        }

        private void E() {
            if ((this.f10110i & 4) != 4) {
                this.f10113l = new ArrayList(this.f10113l);
                this.f10110i |= 4;
            }
        }

        private void F() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b p(l lVar) {
            if (lVar == l.M()) {
                return this;
            }
            if (!lVar.f10103i.isEmpty()) {
                if (this.f10111j.isEmpty()) {
                    this.f10111j = lVar.f10103i;
                    this.f10110i &= -2;
                } else {
                    B();
                    this.f10111j.addAll(lVar.f10103i);
                }
            }
            if (!lVar.f10104j.isEmpty()) {
                if (this.f10112k.isEmpty()) {
                    this.f10112k = lVar.f10104j;
                    this.f10110i &= -3;
                } else {
                    C();
                    this.f10112k.addAll(lVar.f10104j);
                }
            }
            if (!lVar.f10105k.isEmpty()) {
                if (this.f10113l.isEmpty()) {
                    this.f10113l = lVar.f10105k;
                    this.f10110i &= -5;
                } else {
                    E();
                    this.f10113l.addAll(lVar.f10105k);
                }
            }
            if (lVar.Z()) {
                J(lVar.X());
            }
            if (lVar.a0()) {
                K(lVar.Y());
            }
            u(lVar);
            q(o().f(lVar.f10101g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.l.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.l> r1 = ga.l.f10100q     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.l r3 = (ga.l) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.l r4 = (ga.l) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.l.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.l$b");
        }

        public b J(t tVar) {
            if ((this.f10110i & 8) == 8 && this.f10114m != t.x()) {
                tVar = t.G(this.f10114m).p(tVar).t();
            }
            this.f10114m = tVar;
            this.f10110i |= 8;
            return this;
        }

        public b K(w wVar) {
            if ((this.f10110i & 16) == 16 && this.f10115n != w.v()) {
                wVar = w.A(this.f10115n).p(wVar).t();
            }
            this.f10115n = wVar;
            this.f10110i |= 16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public l c() {
            l y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public l y() {
            l lVar = new l(this);
            int i10 = this.f10110i;
            if ((i10 & 1) == 1) {
                this.f10111j = Collections.unmodifiableList(this.f10111j);
                this.f10110i &= -2;
            }
            lVar.f10103i = this.f10111j;
            if ((this.f10110i & 2) == 2) {
                this.f10112k = Collections.unmodifiableList(this.f10112k);
                this.f10110i &= -3;
            }
            lVar.f10104j = this.f10112k;
            if ((this.f10110i & 4) == 4) {
                this.f10113l = Collections.unmodifiableList(this.f10113l);
                this.f10110i &= -5;
            }
            lVar.f10105k = this.f10113l;
            int i11 = (i10 & 8) != 8 ? 0 : 1;
            lVar.f10106l = this.f10114m;
            if ((i10 & 16) == 16) {
                i11 |= 2;
            }
            lVar.f10107m = this.f10115n;
            lVar.f10102h = i11;
            return lVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        l lVar = new l(true);
        f10099p = lVar;
        lVar.b0();
    }

    private l(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        List list;
        kotlin.reflect.jvm.internal.impl.protobuf.q u10;
        this.f10108n = (byte) -1;
        this.f10109o = -1;
        b0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 26) {
                                if ((i10 & 1) != 1) {
                                    this.f10103i = new ArrayList();
                                    i10 |= 1;
                                }
                                list = this.f10103i;
                                u10 = eVar.u(i.f10069x, gVar);
                            } else if (K == 34) {
                                if ((i10 & 2) != 2) {
                                    this.f10104j = new ArrayList();
                                    i10 |= 2;
                                }
                                list = this.f10104j;
                                u10 = eVar.u(n.f10132x, gVar);
                            } else if (K != 42) {
                                if (K == 242) {
                                    t.b d10 = (this.f10102h & 1) == 1 ? this.f10106l.d() : null;
                                    t tVar = (t) eVar.u(t.f10285m, gVar);
                                    this.f10106l = tVar;
                                    if (d10 != null) {
                                        d10.p(tVar);
                                        this.f10106l = d10.t();
                                    }
                                    this.f10102h |= 1;
                                } else if (K == 258) {
                                    w.b d11 = (this.f10102h & 2) == 2 ? this.f10107m.d() : null;
                                    w wVar = (w) eVar.u(w.f10334k, gVar);
                                    this.f10107m = wVar;
                                    if (d11 != null) {
                                        d11.p(wVar);
                                        this.f10107m = d11.t();
                                    }
                                    this.f10102h |= 2;
                                } else if (!q(eVar, J, gVar, K)) {
                                }
                            } else {
                                if ((i10 & 4) != 4) {
                                    this.f10105k = new ArrayList();
                                    i10 |= 4;
                                }
                                list = this.f10105k;
                                u10 = eVar.u(r.f10240u, gVar);
                            }
                            list.add(u10);
                        }
                        z10 = true;
                    } catch (IOException e10) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                    throw e11.i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 1) == 1) {
                    this.f10103i = Collections.unmodifiableList(this.f10103i);
                }
                if ((i10 & 2) == 2) {
                    this.f10104j = Collections.unmodifiableList(this.f10104j);
                }
                if ((i10 & 4) == 4) {
                    this.f10105k = Collections.unmodifiableList(this.f10105k);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10101g = A.j();
                    throw th2;
                }
                this.f10101g = A.j();
                n();
                throw th;
            }
        }
        if ((i10 & 1) == 1) {
            this.f10103i = Collections.unmodifiableList(this.f10103i);
        }
        if ((i10 & 2) == 2) {
            this.f10104j = Collections.unmodifiableList(this.f10104j);
        }
        if ((i10 & 4) == 4) {
            this.f10105k = Collections.unmodifiableList(this.f10105k);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10101g = A.j();
            throw th3;
        }
        this.f10101g = A.j();
        n();
    }

    private l(i.c<l, ?> cVar) {
        super(cVar);
        this.f10108n = (byte) -1;
        this.f10109o = -1;
        this.f10101g = cVar.o();
    }

    private l(boolean z10) {
        this.f10108n = (byte) -1;
        this.f10109o = -1;
        this.f10101g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static l M() {
        return f10099p;
    }

    private void b0() {
        this.f10103i = Collections.emptyList();
        this.f10104j = Collections.emptyList();
        this.f10105k = Collections.emptyList();
        this.f10106l = t.x();
        this.f10107m = w.v();
    }

    public static b c0() {
        return b.w();
    }

    public static b d0(l lVar) {
        return c0().p(lVar);
    }

    public static l f0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f10100q.b(inputStream, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public l b() {
        return f10099p;
    }

    public i O(int i10) {
        return this.f10103i.get(i10);
    }

    public int P() {
        return this.f10103i.size();
    }

    public List<i> Q() {
        return this.f10103i;
    }

    public n R(int i10) {
        return this.f10104j.get(i10);
    }

    public int S() {
        return this.f10104j.size();
    }

    public List<n> T() {
        return this.f10104j;
    }

    public r U(int i10) {
        return this.f10105k.get(i10);
    }

    public int V() {
        return this.f10105k.size();
    }

    public List<r> W() {
        return this.f10105k;
    }

    public t X() {
        return this.f10106l;
    }

    public w Y() {
        return this.f10107m;
    }

    public boolean Z() {
        return (this.f10102h & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10109o;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10103i.size(); i12++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10103i.get(i12));
        }
        for (int i13 = 0; i13 < this.f10104j.size(); i13++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10104j.get(i13));
        }
        for (int i14 = 0; i14 < this.f10105k.size(); i14++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.f10105k.get(i14));
        }
        if ((this.f10102h & 1) == 1) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(30, this.f10106l);
        }
        if ((this.f10102h & 2) == 2) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(32, this.f10107m);
        }
        int u10 = i11 + u() + this.f10101g.size();
        this.f10109o = u10;
        return u10;
    }

    public boolean a0() {
        return (this.f10102h & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        for (int i10 = 0; i10 < this.f10103i.size(); i10++) {
            fVar.d0(3, this.f10103i.get(i10));
        }
        for (int i11 = 0; i11 < this.f10104j.size(); i11++) {
            fVar.d0(4, this.f10104j.get(i11));
        }
        for (int i12 = 0; i12 < this.f10105k.size(); i12++) {
            fVar.d0(5, this.f10105k.get(i12));
        }
        if ((this.f10102h & 1) == 1) {
            fVar.d0(30, this.f10106l);
        }
        if ((this.f10102h & 2) == 2) {
            fVar.d0(32, this.f10107m);
        }
        z10.a(200, fVar);
        fVar.i0(this.f10101g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return c0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return d0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<l> i() {
        return f10100q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10108n;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < P(); i10++) {
            if (!O(i10).k()) {
                this.f10108n = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < S(); i11++) {
            if (!R(i11).k()) {
                this.f10108n = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < V(); i12++) {
            if (!U(i12).k()) {
                this.f10108n = (byte) 0;
                return false;
            }
        }
        if (Z() && !X().k()) {
            this.f10108n = (byte) 0;
            return false;
        }
        if (t()) {
            this.f10108n = (byte) 1;
            return true;
        }
        this.f10108n = (byte) 0;
        return false;
    }
}
