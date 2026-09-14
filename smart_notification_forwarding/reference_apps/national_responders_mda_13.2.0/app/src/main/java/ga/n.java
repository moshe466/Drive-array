package ga;

import ga.q;
import ga.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class n extends i.d<n> {

    /* renamed from: w, reason: collision with root package name */
    private static final n f10131w;

    /* renamed from: x, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<n> f10132x = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10133g;

    /* renamed from: h, reason: collision with root package name */
    private int f10134h;

    /* renamed from: i, reason: collision with root package name */
    private int f10135i;

    /* renamed from: j, reason: collision with root package name */
    private int f10136j;

    /* renamed from: k, reason: collision with root package name */
    private int f10137k;

    /* renamed from: l, reason: collision with root package name */
    private q f10138l;

    /* renamed from: m, reason: collision with root package name */
    private int f10139m;

    /* renamed from: n, reason: collision with root package name */
    private List<s> f10140n;

    /* renamed from: o, reason: collision with root package name */
    private q f10141o;

    /* renamed from: p, reason: collision with root package name */
    private int f10142p;

    /* renamed from: q, reason: collision with root package name */
    private u f10143q;

    /* renamed from: r, reason: collision with root package name */
    private int f10144r;

    /* renamed from: s, reason: collision with root package name */
    private int f10145s;

    /* renamed from: t, reason: collision with root package name */
    private List<Integer> f10146t;

    /* renamed from: u, reason: collision with root package name */
    private byte f10147u;

    /* renamed from: v, reason: collision with root package name */
    private int f10148v;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<n> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public n c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new n(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<n, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10149i;

        /* renamed from: l, reason: collision with root package name */
        private int f10152l;

        /* renamed from: n, reason: collision with root package name */
        private int f10154n;

        /* renamed from: q, reason: collision with root package name */
        private int f10157q;

        /* renamed from: s, reason: collision with root package name */
        private int f10159s;

        /* renamed from: t, reason: collision with root package name */
        private int f10160t;

        /* renamed from: j, reason: collision with root package name */
        private int f10150j = 518;

        /* renamed from: k, reason: collision with root package name */
        private int f10151k = 2054;

        /* renamed from: m, reason: collision with root package name */
        private q f10153m = q.Z();

        /* renamed from: o, reason: collision with root package name */
        private List<s> f10155o = Collections.emptyList();

        /* renamed from: p, reason: collision with root package name */
        private q f10156p = q.Z();

        /* renamed from: r, reason: collision with root package name */
        private u f10158r = u.K();

        /* renamed from: u, reason: collision with root package name */
        private List<Integer> f10161u = Collections.emptyList();

        private b() {
            E();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10149i & 32) != 32) {
                this.f10155o = new ArrayList(this.f10155o);
                this.f10149i |= 32;
            }
        }

        private void C() {
            if ((this.f10149i & 2048) != 2048) {
                this.f10161u = new ArrayList(this.f10161u);
                this.f10149i |= 2048;
            }
        }

        private void E() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b p(n nVar) {
            if (nVar == n.S()) {
                return this;
            }
            if (nVar.i0()) {
                L(nVar.U());
            }
            if (nVar.l0()) {
                Q(nVar.X());
            }
            if (nVar.k0()) {
                P(nVar.W());
            }
            if (nVar.o0()) {
                J(nVar.a0());
            }
            if (nVar.p0()) {
                S(nVar.b0());
            }
            if (!nVar.f10140n.isEmpty()) {
                if (this.f10155o.isEmpty()) {
                    this.f10155o = nVar.f10140n;
                    this.f10149i &= -33;
                } else {
                    B();
                    this.f10155o.addAll(nVar.f10140n);
                }
            }
            if (nVar.m0()) {
                I(nVar.Y());
            }
            if (nVar.n0()) {
                R(nVar.Z());
            }
            if (nVar.r0()) {
                K(nVar.d0());
            }
            if (nVar.j0()) {
                O(nVar.V());
            }
            if (nVar.q0()) {
                T(nVar.c0());
            }
            if (!nVar.f10146t.isEmpty()) {
                if (this.f10161u.isEmpty()) {
                    this.f10161u = nVar.f10146t;
                    this.f10149i &= -2049;
                } else {
                    C();
                    this.f10161u.addAll(nVar.f10146t);
                }
            }
            u(nVar);
            q(o().f(nVar.f10133g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.n.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.n> r1 = ga.n.f10132x     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.n r3 = (ga.n) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.n r4 = (ga.n) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.n.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.n$b");
        }

        public b I(q qVar) {
            if ((this.f10149i & 64) == 64 && this.f10156p != q.Z()) {
                qVar = q.A0(this.f10156p).p(qVar).y();
            }
            this.f10156p = qVar;
            this.f10149i |= 64;
            return this;
        }

        public b J(q qVar) {
            if ((this.f10149i & 8) == 8 && this.f10153m != q.Z()) {
                qVar = q.A0(this.f10153m).p(qVar).y();
            }
            this.f10153m = qVar;
            this.f10149i |= 8;
            return this;
        }

        public b K(u uVar) {
            if ((this.f10149i & 256) == 256 && this.f10158r != u.K()) {
                uVar = u.a0(this.f10158r).p(uVar).y();
            }
            this.f10158r = uVar;
            this.f10149i |= 256;
            return this;
        }

        public b L(int i10) {
            this.f10149i |= 1;
            this.f10150j = i10;
            return this;
        }

        public b O(int i10) {
            this.f10149i |= 512;
            this.f10159s = i10;
            return this;
        }

        public b P(int i10) {
            this.f10149i |= 4;
            this.f10152l = i10;
            return this;
        }

        public b Q(int i10) {
            this.f10149i |= 2;
            this.f10151k = i10;
            return this;
        }

        public b R(int i10) {
            this.f10149i |= 128;
            this.f10157q = i10;
            return this;
        }

        public b S(int i10) {
            this.f10149i |= 16;
            this.f10154n = i10;
            return this;
        }

        public b T(int i10) {
            this.f10149i |= 1024;
            this.f10160t = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public n c() {
            n y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public n y() {
            n nVar = new n(this);
            int i10 = this.f10149i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            nVar.f10135i = this.f10150j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            nVar.f10136j = this.f10151k;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            nVar.f10137k = this.f10152l;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            nVar.f10138l = this.f10153m;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            nVar.f10139m = this.f10154n;
            if ((this.f10149i & 32) == 32) {
                this.f10155o = Collections.unmodifiableList(this.f10155o);
                this.f10149i &= -33;
            }
            nVar.f10140n = this.f10155o;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            nVar.f10141o = this.f10156p;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            nVar.f10142p = this.f10157q;
            if ((i10 & 256) == 256) {
                i11 |= 128;
            }
            nVar.f10143q = this.f10158r;
            if ((i10 & 512) == 512) {
                i11 |= 256;
            }
            nVar.f10144r = this.f10159s;
            if ((i10 & 1024) == 1024) {
                i11 |= 512;
            }
            nVar.f10145s = this.f10160t;
            if ((this.f10149i & 2048) == 2048) {
                this.f10161u = Collections.unmodifiableList(this.f10161u);
                this.f10149i &= -2049;
            }
            nVar.f10146t = this.f10161u;
            nVar.f10134h = i11;
            return nVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        n nVar = new n(true);
        f10131w = nVar;
        nVar.s0();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0021. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Integer] */
    private n(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        int i10;
        int i11;
        List list;
        kotlin.reflect.jvm.internal.impl.protobuf.q qVar;
        this.f10147u = (byte) -1;
        this.f10148v = -1;
        s0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i12 = 0;
        while (true) {
            ?? r52 = 2048;
            if (z10) {
                if ((i12 & 32) == 32) {
                    this.f10140n = Collections.unmodifiableList(this.f10140n);
                }
                if ((i12 & 2048) == 2048) {
                    this.f10146t = Collections.unmodifiableList(this.f10146t);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f10133g = A.j();
                    throw th;
                }
                this.f10133g = A.j();
                n();
                return;
            }
            try {
                try {
                    int K = eVar.K();
                    switch (K) {
                        case 0:
                            z10 = true;
                        case 8:
                            this.f10134h |= 2;
                            this.f10136j = eVar.s();
                        case 16:
                            this.f10134h |= 4;
                            this.f10137k = eVar.s();
                        case 26:
                            i10 = 8;
                            q.c d10 = (this.f10134h & 8) == 8 ? this.f10138l.d() : null;
                            q qVar2 = (q) eVar.u(q.f10192z, gVar);
                            this.f10138l = qVar2;
                            if (d10 != null) {
                                d10.p(qVar2);
                                this.f10138l = d10.y();
                            }
                            i11 = this.f10134h;
                            this.f10134h = i11 | i10;
                        case 34:
                            if ((i12 & 32) != 32) {
                                this.f10140n = new ArrayList();
                                i12 |= 32;
                            }
                            list = this.f10140n;
                            qVar = eVar.u(s.f10265s, gVar);
                            list.add(qVar);
                        case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                            q.c d11 = (this.f10134h & 32) == 32 ? this.f10141o.d() : null;
                            q qVar3 = (q) eVar.u(q.f10192z, gVar);
                            this.f10141o = qVar3;
                            if (d11 != null) {
                                d11.p(qVar3);
                                this.f10141o = d11.y();
                            }
                            this.f10134h |= 32;
                        case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
                            i10 = 128;
                            u.b d12 = (this.f10134h & 128) == 128 ? this.f10143q.d() : null;
                            u uVar = (u) eVar.u(u.f10296r, gVar);
                            this.f10143q = uVar;
                            if (d12 != null) {
                                d12.p(uVar);
                                this.f10143q = d12.y();
                            }
                            i11 = this.f10134h;
                            this.f10134h = i11 | i10;
                        case 56:
                            this.f10134h |= 256;
                            this.f10144r = eVar.s();
                        case 64:
                            this.f10134h |= 512;
                            this.f10145s = eVar.s();
                        case 72:
                            this.f10134h |= 16;
                            this.f10139m = eVar.s();
                        case 80:
                            this.f10134h |= 64;
                            this.f10142p = eVar.s();
                        case 88:
                            this.f10134h |= 1;
                            this.f10135i = eVar.s();
                        case 248:
                            if ((i12 & 2048) != 2048) {
                                this.f10146t = new ArrayList();
                                i12 |= 2048;
                            }
                            list = this.f10146t;
                            qVar = Integer.valueOf(eVar.s());
                            list.add(qVar);
                        case 250:
                            int j10 = eVar.j(eVar.A());
                            if ((i12 & 2048) != 2048 && eVar.e() > 0) {
                                this.f10146t = new ArrayList();
                                i12 |= 2048;
                            }
                            while (eVar.e() > 0) {
                                this.f10146t.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j10);
                            break;
                        default:
                            r52 = q(eVar, J, gVar, K);
                            if (r52 == 0) {
                                z10 = true;
                            }
                    }
                } catch (Throwable th2) {
                    if ((i12 & 32) == 32) {
                        this.f10140n = Collections.unmodifiableList(this.f10140n);
                    }
                    if ((i12 & 2048) == r52) {
                        this.f10146t = Collections.unmodifiableList(this.f10146t);
                    }
                    try {
                        J.I();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.f10133g = A.j();
                        throw th3;
                    }
                    this.f10133g = A.j();
                    n();
                    throw th2;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
            }
        }
    }

    private n(i.c<n, ?> cVar) {
        super(cVar);
        this.f10147u = (byte) -1;
        this.f10148v = -1;
        this.f10133g = cVar.o();
    }

    private n(boolean z10) {
        this.f10147u = (byte) -1;
        this.f10148v = -1;
        this.f10133g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static n S() {
        return f10131w;
    }

    private void s0() {
        this.f10135i = 518;
        this.f10136j = 2054;
        this.f10137k = 0;
        this.f10138l = q.Z();
        this.f10139m = 0;
        this.f10140n = Collections.emptyList();
        this.f10141o = q.Z();
        this.f10142p = 0;
        this.f10143q = u.K();
        this.f10144r = 0;
        this.f10145s = 0;
        this.f10146t = Collections.emptyList();
    }

    public static b t0() {
        return b.w();
    }

    public static b u0(n nVar) {
        return t0().p(nVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public n b() {
        return f10131w;
    }

    public int U() {
        return this.f10135i;
    }

    public int V() {
        return this.f10144r;
    }

    public int W() {
        return this.f10137k;
    }

    public int X() {
        return this.f10136j;
    }

    public q Y() {
        return this.f10141o;
    }

    public int Z() {
        return this.f10142p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10148v;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10134h & 2) == 2 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10136j) + 0 : 0;
        if ((this.f10134h & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10137k);
        }
        if ((this.f10134h & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10138l);
        }
        for (int i11 = 0; i11 < this.f10140n.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10140n.get(i11));
        }
        if ((this.f10134h & 32) == 32) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.f10141o);
        }
        if ((this.f10134h & 128) == 128) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.f10143q);
        }
        if ((this.f10134h & 256) == 256) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.f10144r);
        }
        if ((this.f10134h & 512) == 512) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(8, this.f10145s);
        }
        if ((this.f10134h & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(9, this.f10139m);
        }
        if ((this.f10134h & 64) == 64) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(10, this.f10142p);
        }
        if ((this.f10134h & 1) == 1) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(11, this.f10135i);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f10146t.size(); i13++) {
            i12 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f10146t.get(i13).intValue());
        }
        int size = o10 + i12 + (h0().size() * 2) + u() + this.f10133g.size();
        this.f10148v = size;
        return size;
    }

    public q a0() {
        return this.f10138l;
    }

    public int b0() {
        return this.f10139m;
    }

    public int c0() {
        return this.f10145s;
    }

    public u d0() {
        return this.f10143q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10134h & 2) == 2) {
            fVar.a0(1, this.f10136j);
        }
        if ((this.f10134h & 4) == 4) {
            fVar.a0(2, this.f10137k);
        }
        if ((this.f10134h & 8) == 8) {
            fVar.d0(3, this.f10138l);
        }
        for (int i10 = 0; i10 < this.f10140n.size(); i10++) {
            fVar.d0(4, this.f10140n.get(i10));
        }
        if ((this.f10134h & 32) == 32) {
            fVar.d0(5, this.f10141o);
        }
        if ((this.f10134h & 128) == 128) {
            fVar.d0(6, this.f10143q);
        }
        if ((this.f10134h & 256) == 256) {
            fVar.a0(7, this.f10144r);
        }
        if ((this.f10134h & 512) == 512) {
            fVar.a0(8, this.f10145s);
        }
        if ((this.f10134h & 16) == 16) {
            fVar.a0(9, this.f10139m);
        }
        if ((this.f10134h & 64) == 64) {
            fVar.a0(10, this.f10142p);
        }
        if ((this.f10134h & 1) == 1) {
            fVar.a0(11, this.f10135i);
        }
        for (int i11 = 0; i11 < this.f10146t.size(); i11++) {
            fVar.a0(31, this.f10146t.get(i11).intValue());
        }
        z10.a(19000, fVar);
        fVar.i0(this.f10133g);
    }

    public s e0(int i10) {
        return this.f10140n.get(i10);
    }

    public int f0() {
        return this.f10140n.size();
    }

    public List<s> g0() {
        return this.f10140n;
    }

    public List<Integer> h0() {
        return this.f10146t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<n> i() {
        return f10132x;
    }

    public boolean i0() {
        return (this.f10134h & 1) == 1;
    }

    public boolean j0() {
        return (this.f10134h & 256) == 256;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10147u;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!k0()) {
            this.f10147u = (byte) 0;
            return false;
        }
        if (o0() && !a0().k()) {
            this.f10147u = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < f0(); i10++) {
            if (!e0(i10).k()) {
                this.f10147u = (byte) 0;
                return false;
            }
        }
        if (m0() && !Y().k()) {
            this.f10147u = (byte) 0;
            return false;
        }
        if (r0() && !d0().k()) {
            this.f10147u = (byte) 0;
            return false;
        }
        if (t()) {
            this.f10147u = (byte) 1;
            return true;
        }
        this.f10147u = (byte) 0;
        return false;
    }

    public boolean k0() {
        return (this.f10134h & 4) == 4;
    }

    public boolean l0() {
        return (this.f10134h & 2) == 2;
    }

    public boolean m0() {
        return (this.f10134h & 32) == 32;
    }

    public boolean n0() {
        return (this.f10134h & 64) == 64;
    }

    public boolean o0() {
        return (this.f10134h & 8) == 8;
    }

    public boolean p0() {
        return (this.f10134h & 16) == 16;
    }

    public boolean q0() {
        return (this.f10134h & 512) == 512;
    }

    public boolean r0() {
        return (this.f10134h & 128) == 128;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return t0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return u0(this);
    }
}
