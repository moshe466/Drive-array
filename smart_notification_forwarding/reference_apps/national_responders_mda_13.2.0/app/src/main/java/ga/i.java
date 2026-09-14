package ga;

import ga.e;
import ga.q;
import ga.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class i extends i.d<i> {

    /* renamed from: w, reason: collision with root package name */
    private static final i f10068w;

    /* renamed from: x, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<i> f10069x = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10070g;

    /* renamed from: h, reason: collision with root package name */
    private int f10071h;

    /* renamed from: i, reason: collision with root package name */
    private int f10072i;

    /* renamed from: j, reason: collision with root package name */
    private int f10073j;

    /* renamed from: k, reason: collision with root package name */
    private int f10074k;

    /* renamed from: l, reason: collision with root package name */
    private q f10075l;

    /* renamed from: m, reason: collision with root package name */
    private int f10076m;

    /* renamed from: n, reason: collision with root package name */
    private List<s> f10077n;

    /* renamed from: o, reason: collision with root package name */
    private q f10078o;

    /* renamed from: p, reason: collision with root package name */
    private int f10079p;

    /* renamed from: q, reason: collision with root package name */
    private List<u> f10080q;

    /* renamed from: r, reason: collision with root package name */
    private t f10081r;

    /* renamed from: s, reason: collision with root package name */
    private List<Integer> f10082s;

    /* renamed from: t, reason: collision with root package name */
    private e f10083t;

    /* renamed from: u, reason: collision with root package name */
    private byte f10084u;

    /* renamed from: v, reason: collision with root package name */
    private int f10085v;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<i> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public i c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new i(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<i, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10086i;

        /* renamed from: l, reason: collision with root package name */
        private int f10089l;

        /* renamed from: n, reason: collision with root package name */
        private int f10091n;

        /* renamed from: q, reason: collision with root package name */
        private int f10094q;

        /* renamed from: j, reason: collision with root package name */
        private int f10087j = 6;

        /* renamed from: k, reason: collision with root package name */
        private int f10088k = 6;

        /* renamed from: m, reason: collision with root package name */
        private q f10090m = q.Z();

        /* renamed from: o, reason: collision with root package name */
        private List<s> f10092o = Collections.emptyList();

        /* renamed from: p, reason: collision with root package name */
        private q f10093p = q.Z();

        /* renamed from: r, reason: collision with root package name */
        private List<u> f10095r = Collections.emptyList();

        /* renamed from: s, reason: collision with root package name */
        private t f10096s = t.x();

        /* renamed from: t, reason: collision with root package name */
        private List<Integer> f10097t = Collections.emptyList();

        /* renamed from: u, reason: collision with root package name */
        private e f10098u = e.v();

        private b() {
            F();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10086i & 32) != 32) {
                this.f10092o = new ArrayList(this.f10092o);
                this.f10086i |= 32;
            }
        }

        private void C() {
            if ((this.f10086i & 256) != 256) {
                this.f10095r = new ArrayList(this.f10095r);
                this.f10086i |= 256;
            }
        }

        private void E() {
            if ((this.f10086i & 1024) != 1024) {
                this.f10097t = new ArrayList(this.f10097t);
                this.f10086i |= 1024;
            }
        }

        private void F() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        public b G(e eVar) {
            if ((this.f10086i & 2048) == 2048 && this.f10098u != e.v()) {
                eVar = e.A(this.f10098u).p(eVar).t();
            }
            this.f10098u = eVar;
            this.f10086i |= 2048;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public b p(i iVar) {
            if (iVar == i.U()) {
                return this;
            }
            if (iVar.m0()) {
                P(iVar.W());
            }
            if (iVar.o0()) {
                R(iVar.Y());
            }
            if (iVar.n0()) {
                Q(iVar.X());
            }
            if (iVar.r0()) {
                L(iVar.b0());
            }
            if (iVar.s0()) {
                T(iVar.c0());
            }
            if (!iVar.f10077n.isEmpty()) {
                if (this.f10092o.isEmpty()) {
                    this.f10092o = iVar.f10077n;
                    this.f10086i &= -33;
                } else {
                    B();
                    this.f10092o.addAll(iVar.f10077n);
                }
            }
            if (iVar.p0()) {
                K(iVar.Z());
            }
            if (iVar.q0()) {
                S(iVar.a0());
            }
            if (!iVar.f10080q.isEmpty()) {
                if (this.f10095r.isEmpty()) {
                    this.f10095r = iVar.f10080q;
                    this.f10086i &= -257;
                } else {
                    C();
                    this.f10095r.addAll(iVar.f10080q);
                }
            }
            if (iVar.t0()) {
                O(iVar.g0());
            }
            if (!iVar.f10082s.isEmpty()) {
                if (this.f10097t.isEmpty()) {
                    this.f10097t = iVar.f10082s;
                    this.f10086i &= -1025;
                } else {
                    E();
                    this.f10097t.addAll(iVar.f10082s);
                }
            }
            if (iVar.l0()) {
                G(iVar.T());
            }
            u(iVar);
            q(o().f(iVar.f10070g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.i.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.i> r1 = ga.i.f10069x     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.i r3 = (ga.i) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.i r4 = (ga.i) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.i.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.i$b");
        }

        public b K(q qVar) {
            if ((this.f10086i & 64) == 64 && this.f10093p != q.Z()) {
                qVar = q.A0(this.f10093p).p(qVar).y();
            }
            this.f10093p = qVar;
            this.f10086i |= 64;
            return this;
        }

        public b L(q qVar) {
            if ((this.f10086i & 8) == 8 && this.f10090m != q.Z()) {
                qVar = q.A0(this.f10090m).p(qVar).y();
            }
            this.f10090m = qVar;
            this.f10086i |= 8;
            return this;
        }

        public b O(t tVar) {
            if ((this.f10086i & 512) == 512 && this.f10096s != t.x()) {
                tVar = t.G(this.f10096s).p(tVar).t();
            }
            this.f10096s = tVar;
            this.f10086i |= 512;
            return this;
        }

        public b P(int i10) {
            this.f10086i |= 1;
            this.f10087j = i10;
            return this;
        }

        public b Q(int i10) {
            this.f10086i |= 4;
            this.f10089l = i10;
            return this;
        }

        public b R(int i10) {
            this.f10086i |= 2;
            this.f10088k = i10;
            return this;
        }

        public b S(int i10) {
            this.f10086i |= 128;
            this.f10094q = i10;
            return this;
        }

        public b T(int i10) {
            this.f10086i |= 16;
            this.f10091n = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public i c() {
            i y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public i y() {
            i iVar = new i(this);
            int i10 = this.f10086i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            iVar.f10072i = this.f10087j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            iVar.f10073j = this.f10088k;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            iVar.f10074k = this.f10089l;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            iVar.f10075l = this.f10090m;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            iVar.f10076m = this.f10091n;
            if ((this.f10086i & 32) == 32) {
                this.f10092o = Collections.unmodifiableList(this.f10092o);
                this.f10086i &= -33;
            }
            iVar.f10077n = this.f10092o;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            iVar.f10078o = this.f10093p;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            iVar.f10079p = this.f10094q;
            if ((this.f10086i & 256) == 256) {
                this.f10095r = Collections.unmodifiableList(this.f10095r);
                this.f10086i &= -257;
            }
            iVar.f10080q = this.f10095r;
            if ((i10 & 512) == 512) {
                i11 |= 128;
            }
            iVar.f10081r = this.f10096s;
            if ((this.f10086i & 1024) == 1024) {
                this.f10097t = Collections.unmodifiableList(this.f10097t);
                this.f10086i &= -1025;
            }
            iVar.f10082s = this.f10097t;
            if ((i10 & 2048) == 2048) {
                i11 |= 256;
            }
            iVar.f10083t = this.f10098u;
            iVar.f10071h = i11;
            return iVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        i iVar = new i(true);
        f10068w = iVar;
        iVar.u0();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0023. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Integer] */
    private i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        int i10;
        int i11;
        List list;
        kotlin.reflect.jvm.internal.impl.protobuf.q qVar;
        this.f10084u = (byte) -1;
        this.f10085v = -1;
        u0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i12 = 0;
        while (true) {
            ?? r52 = 1024;
            if (z10) {
                if ((i12 & 32) == 32) {
                    this.f10077n = Collections.unmodifiableList(this.f10077n);
                }
                if ((i12 & 256) == 256) {
                    this.f10080q = Collections.unmodifiableList(this.f10080q);
                }
                if ((i12 & 1024) == 1024) {
                    this.f10082s = Collections.unmodifiableList(this.f10082s);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f10070g = A.j();
                    throw th;
                }
                this.f10070g = A.j();
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
                            this.f10071h |= 2;
                            this.f10073j = eVar.s();
                        case 16:
                            this.f10071h |= 4;
                            this.f10074k = eVar.s();
                        case 26:
                            i10 = 8;
                            q.c d10 = (this.f10071h & 8) == 8 ? this.f10075l.d() : null;
                            q qVar2 = (q) eVar.u(q.f10192z, gVar);
                            this.f10075l = qVar2;
                            if (d10 != null) {
                                d10.p(qVar2);
                                this.f10075l = d10.y();
                            }
                            i11 = this.f10071h;
                            this.f10071h = i11 | i10;
                        case 34:
                            if ((i12 & 32) != 32) {
                                this.f10077n = new ArrayList();
                                i12 |= 32;
                            }
                            list = this.f10077n;
                            qVar = eVar.u(s.f10265s, gVar);
                            list.add(qVar);
                        case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                            q.c d11 = (this.f10071h & 32) == 32 ? this.f10078o.d() : null;
                            q qVar3 = (q) eVar.u(q.f10192z, gVar);
                            this.f10078o = qVar3;
                            if (d11 != null) {
                                d11.p(qVar3);
                                this.f10078o = d11.y();
                            }
                            this.f10071h |= 32;
                        case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
                            if ((i12 & 256) != 256) {
                                this.f10080q = new ArrayList();
                                i12 |= 256;
                            }
                            list = this.f10080q;
                            qVar = eVar.u(u.f10296r, gVar);
                            list.add(qVar);
                        case 56:
                            this.f10071h |= 16;
                            this.f10076m = eVar.s();
                        case 64:
                            this.f10071h |= 64;
                            this.f10079p = eVar.s();
                        case 72:
                            this.f10071h |= 1;
                            this.f10072i = eVar.s();
                        case 242:
                            i10 = 128;
                            t.b d12 = (this.f10071h & 128) == 128 ? this.f10081r.d() : null;
                            t tVar = (t) eVar.u(t.f10285m, gVar);
                            this.f10081r = tVar;
                            if (d12 != null) {
                                d12.p(tVar);
                                this.f10081r = d12.t();
                            }
                            i11 = this.f10071h;
                            this.f10071h = i11 | i10;
                        case 248:
                            if ((i12 & 1024) != 1024) {
                                this.f10082s = new ArrayList();
                                i12 |= 1024;
                            }
                            list = this.f10082s;
                            qVar = Integer.valueOf(eVar.s());
                            list.add(qVar);
                        case 250:
                            int j10 = eVar.j(eVar.A());
                            if ((i12 & 1024) != 1024 && eVar.e() > 0) {
                                this.f10082s = new ArrayList();
                                i12 |= 1024;
                            }
                            while (eVar.e() > 0) {
                                this.f10082s.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j10);
                            break;
                        case 258:
                            e.b d13 = (this.f10071h & 256) == 256 ? this.f10083t.d() : null;
                            e eVar2 = (e) eVar.u(e.f10016k, gVar);
                            this.f10083t = eVar2;
                            if (d13 != null) {
                                d13.p(eVar2);
                                this.f10083t = d13.t();
                            }
                            this.f10071h |= 256;
                        default:
                            r52 = q(eVar, J, gVar, K);
                            if (r52 == 0) {
                                z10 = true;
                            }
                    }
                } catch (Throwable th2) {
                    if ((i12 & 32) == 32) {
                        this.f10077n = Collections.unmodifiableList(this.f10077n);
                    }
                    if ((i12 & 256) == 256) {
                        this.f10080q = Collections.unmodifiableList(this.f10080q);
                    }
                    if ((i12 & 1024) == r52) {
                        this.f10082s = Collections.unmodifiableList(this.f10082s);
                    }
                    try {
                        J.I();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.f10070g = A.j();
                        throw th3;
                    }
                    this.f10070g = A.j();
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

    private i(i.c<i, ?> cVar) {
        super(cVar);
        this.f10084u = (byte) -1;
        this.f10085v = -1;
        this.f10070g = cVar.o();
    }

    private i(boolean z10) {
        this.f10084u = (byte) -1;
        this.f10085v = -1;
        this.f10070g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static i U() {
        return f10068w;
    }

    private void u0() {
        this.f10072i = 6;
        this.f10073j = 6;
        this.f10074k = 0;
        this.f10075l = q.Z();
        this.f10076m = 0;
        this.f10077n = Collections.emptyList();
        this.f10078o = q.Z();
        this.f10079p = 0;
        this.f10080q = Collections.emptyList();
        this.f10081r = t.x();
        this.f10082s = Collections.emptyList();
        this.f10083t = e.v();
    }

    public static b v0() {
        return b.w();
    }

    public static b w0(i iVar) {
        return v0().p(iVar);
    }

    public static i y0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f10069x.b(inputStream, gVar);
    }

    public e T() {
        return this.f10083t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public i b() {
        return f10068w;
    }

    public int W() {
        return this.f10072i;
    }

    public int X() {
        return this.f10074k;
    }

    public int Y() {
        return this.f10073j;
    }

    public q Z() {
        return this.f10078o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10085v;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10071h & 2) == 2 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10073j) + 0 : 0;
        if ((this.f10071h & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10074k);
        }
        if ((this.f10071h & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10075l);
        }
        for (int i11 = 0; i11 < this.f10077n.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10077n.get(i11));
        }
        if ((this.f10071h & 32) == 32) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.f10078o);
        }
        for (int i12 = 0; i12 < this.f10080q.size(); i12++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.f10080q.get(i12));
        }
        if ((this.f10071h & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.f10076m);
        }
        if ((this.f10071h & 64) == 64) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(8, this.f10079p);
        }
        if ((this.f10071h & 1) == 1) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(9, this.f10072i);
        }
        if ((this.f10071h & 128) == 128) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(30, this.f10081r);
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.f10082s.size(); i14++) {
            i13 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f10082s.get(i14).intValue());
        }
        int size = o10 + i13 + (k0().size() * 2);
        if ((this.f10071h & 256) == 256) {
            size += kotlin.reflect.jvm.internal.impl.protobuf.f.s(32, this.f10083t);
        }
        int u10 = size + u() + this.f10070g.size();
        this.f10085v = u10;
        return u10;
    }

    public int a0() {
        return this.f10079p;
    }

    public q b0() {
        return this.f10075l;
    }

    public int c0() {
        return this.f10076m;
    }

    public s d0(int i10) {
        return this.f10077n.get(i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10071h & 2) == 2) {
            fVar.a0(1, this.f10073j);
        }
        if ((this.f10071h & 4) == 4) {
            fVar.a0(2, this.f10074k);
        }
        if ((this.f10071h & 8) == 8) {
            fVar.d0(3, this.f10075l);
        }
        for (int i10 = 0; i10 < this.f10077n.size(); i10++) {
            fVar.d0(4, this.f10077n.get(i10));
        }
        if ((this.f10071h & 32) == 32) {
            fVar.d0(5, this.f10078o);
        }
        for (int i11 = 0; i11 < this.f10080q.size(); i11++) {
            fVar.d0(6, this.f10080q.get(i11));
        }
        if ((this.f10071h & 16) == 16) {
            fVar.a0(7, this.f10076m);
        }
        if ((this.f10071h & 64) == 64) {
            fVar.a0(8, this.f10079p);
        }
        if ((this.f10071h & 1) == 1) {
            fVar.a0(9, this.f10072i);
        }
        if ((this.f10071h & 128) == 128) {
            fVar.d0(30, this.f10081r);
        }
        for (int i12 = 0; i12 < this.f10082s.size(); i12++) {
            fVar.a0(31, this.f10082s.get(i12).intValue());
        }
        if ((this.f10071h & 256) == 256) {
            fVar.d0(32, this.f10083t);
        }
        z10.a(19000, fVar);
        fVar.i0(this.f10070g);
    }

    public int e0() {
        return this.f10077n.size();
    }

    public List<s> f0() {
        return this.f10077n;
    }

    public t g0() {
        return this.f10081r;
    }

    public u h0(int i10) {
        return this.f10080q.get(i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<i> i() {
        return f10069x;
    }

    public int i0() {
        return this.f10080q.size();
    }

    public List<u> j0() {
        return this.f10080q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10084u;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!n0()) {
            this.f10084u = (byte) 0;
            return false;
        }
        if (r0() && !b0().k()) {
            this.f10084u = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < e0(); i10++) {
            if (!d0(i10).k()) {
                this.f10084u = (byte) 0;
                return false;
            }
        }
        if (p0() && !Z().k()) {
            this.f10084u = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < i0(); i11++) {
            if (!h0(i11).k()) {
                this.f10084u = (byte) 0;
                return false;
            }
        }
        if (t0() && !g0().k()) {
            this.f10084u = (byte) 0;
            return false;
        }
        if (l0() && !T().k()) {
            this.f10084u = (byte) 0;
            return false;
        }
        if (t()) {
            this.f10084u = (byte) 1;
            return true;
        }
        this.f10084u = (byte) 0;
        return false;
    }

    public List<Integer> k0() {
        return this.f10082s;
    }

    public boolean l0() {
        return (this.f10071h & 256) == 256;
    }

    public boolean m0() {
        return (this.f10071h & 1) == 1;
    }

    public boolean n0() {
        return (this.f10071h & 4) == 4;
    }

    public boolean o0() {
        return (this.f10071h & 2) == 2;
    }

    public boolean p0() {
        return (this.f10071h & 32) == 32;
    }

    public boolean q0() {
        return (this.f10071h & 64) == 64;
    }

    public boolean r0() {
        return (this.f10071h & 8) == 8;
    }

    public boolean s0() {
        return (this.f10071h & 16) == 16;
    }

    public boolean t0() {
        return (this.f10071h & 128) == 128;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return v0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return w0(this);
    }
}
