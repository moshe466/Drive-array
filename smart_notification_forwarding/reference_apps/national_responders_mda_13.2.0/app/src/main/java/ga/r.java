package ga;

import ga.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class r extends i.d<r> {

    /* renamed from: t, reason: collision with root package name */
    private static final r f10239t;

    /* renamed from: u, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<r> f10240u = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10241g;

    /* renamed from: h, reason: collision with root package name */
    private int f10242h;

    /* renamed from: i, reason: collision with root package name */
    private int f10243i;

    /* renamed from: j, reason: collision with root package name */
    private int f10244j;

    /* renamed from: k, reason: collision with root package name */
    private List<s> f10245k;

    /* renamed from: l, reason: collision with root package name */
    private q f10246l;

    /* renamed from: m, reason: collision with root package name */
    private int f10247m;

    /* renamed from: n, reason: collision with root package name */
    private q f10248n;

    /* renamed from: o, reason: collision with root package name */
    private int f10249o;

    /* renamed from: p, reason: collision with root package name */
    private List<ga.b> f10250p;

    /* renamed from: q, reason: collision with root package name */
    private List<Integer> f10251q;

    /* renamed from: r, reason: collision with root package name */
    private byte f10252r;

    /* renamed from: s, reason: collision with root package name */
    private int f10253s;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<r> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public r c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new r(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<r, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10254i;

        /* renamed from: k, reason: collision with root package name */
        private int f10256k;

        /* renamed from: n, reason: collision with root package name */
        private int f10259n;

        /* renamed from: p, reason: collision with root package name */
        private int f10261p;

        /* renamed from: j, reason: collision with root package name */
        private int f10255j = 6;

        /* renamed from: l, reason: collision with root package name */
        private List<s> f10257l = Collections.emptyList();

        /* renamed from: m, reason: collision with root package name */
        private q f10258m = q.Z();

        /* renamed from: o, reason: collision with root package name */
        private q f10260o = q.Z();

        /* renamed from: q, reason: collision with root package name */
        private List<ga.b> f10262q = Collections.emptyList();

        /* renamed from: r, reason: collision with root package name */
        private List<Integer> f10263r = Collections.emptyList();

        private b() {
            F();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10254i & 128) != 128) {
                this.f10262q = new ArrayList(this.f10262q);
                this.f10254i |= 128;
            }
        }

        private void C() {
            if ((this.f10254i & 4) != 4) {
                this.f10257l = new ArrayList(this.f10257l);
                this.f10254i |= 4;
            }
        }

        private void E() {
            if ((this.f10254i & 256) != 256) {
                this.f10263r = new ArrayList(this.f10263r);
                this.f10254i |= 256;
            }
        }

        private void F() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        public b G(q qVar) {
            if ((this.f10254i & 32) == 32 && this.f10260o != q.Z()) {
                qVar = q.A0(this.f10260o).p(qVar).y();
            }
            this.f10260o = qVar;
            this.f10254i |= 32;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public b p(r rVar) {
            if (rVar == r.T()) {
                return this;
            }
            if (rVar.h0()) {
                O(rVar.X());
            }
            if (rVar.i0()) {
                P(rVar.Y());
            }
            if (!rVar.f10245k.isEmpty()) {
                if (this.f10257l.isEmpty()) {
                    this.f10257l = rVar.f10245k;
                    this.f10254i &= -5;
                } else {
                    C();
                    this.f10257l.addAll(rVar.f10245k);
                }
            }
            if (rVar.j0()) {
                K(rVar.c0());
            }
            if (rVar.k0()) {
                Q(rVar.d0());
            }
            if (rVar.f0()) {
                G(rVar.V());
            }
            if (rVar.g0()) {
                L(rVar.W());
            }
            if (!rVar.f10250p.isEmpty()) {
                if (this.f10262q.isEmpty()) {
                    this.f10262q = rVar.f10250p;
                    this.f10254i &= -129;
                } else {
                    B();
                    this.f10262q.addAll(rVar.f10250p);
                }
            }
            if (!rVar.f10251q.isEmpty()) {
                if (this.f10263r.isEmpty()) {
                    this.f10263r = rVar.f10251q;
                    this.f10254i &= -257;
                } else {
                    E();
                    this.f10263r.addAll(rVar.f10251q);
                }
            }
            u(rVar);
            q(o().f(rVar.f10241g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.r.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.r> r1 = ga.r.f10240u     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.r r3 = (ga.r) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.r r4 = (ga.r) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.r.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.r$b");
        }

        public b K(q qVar) {
            if ((this.f10254i & 8) == 8 && this.f10258m != q.Z()) {
                qVar = q.A0(this.f10258m).p(qVar).y();
            }
            this.f10258m = qVar;
            this.f10254i |= 8;
            return this;
        }

        public b L(int i10) {
            this.f10254i |= 64;
            this.f10261p = i10;
            return this;
        }

        public b O(int i10) {
            this.f10254i |= 1;
            this.f10255j = i10;
            return this;
        }

        public b P(int i10) {
            this.f10254i |= 2;
            this.f10256k = i10;
            return this;
        }

        public b Q(int i10) {
            this.f10254i |= 16;
            this.f10259n = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public r c() {
            r y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public r y() {
            r rVar = new r(this);
            int i10 = this.f10254i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            rVar.f10243i = this.f10255j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            rVar.f10244j = this.f10256k;
            if ((this.f10254i & 4) == 4) {
                this.f10257l = Collections.unmodifiableList(this.f10257l);
                this.f10254i &= -5;
            }
            rVar.f10245k = this.f10257l;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            rVar.f10246l = this.f10258m;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            rVar.f10247m = this.f10259n;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            rVar.f10248n = this.f10260o;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            rVar.f10249o = this.f10261p;
            if ((this.f10254i & 128) == 128) {
                this.f10262q = Collections.unmodifiableList(this.f10262q);
                this.f10254i &= -129;
            }
            rVar.f10250p = this.f10262q;
            if ((this.f10254i & 256) == 256) {
                this.f10263r = Collections.unmodifiableList(this.f10263r);
                this.f10254i &= -257;
            }
            rVar.f10251q = this.f10263r;
            rVar.f10242h = i11;
            return rVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        r rVar = new r(true);
        f10239t = rVar;
        rVar.l0();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0022. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private r(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        List list;
        Object u10;
        q.c d10;
        this.f10252r = (byte) -1;
        this.f10253s = -1;
        l0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ?? r52 = 128;
            if (z10) {
                if ((i10 & 4) == 4) {
                    this.f10245k = Collections.unmodifiableList(this.f10245k);
                }
                if ((i10 & 128) == 128) {
                    this.f10250p = Collections.unmodifiableList(this.f10250p);
                }
                if ((i10 & 256) == 256) {
                    this.f10251q = Collections.unmodifiableList(this.f10251q);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f10241g = A.j();
                    throw th;
                }
                this.f10241g = A.j();
                n();
                return;
            }
            try {
                try {
                    try {
                        int K = eVar.K();
                        switch (K) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.f10242h |= 1;
                                this.f10243i = eVar.s();
                            case 16:
                                this.f10242h |= 2;
                                this.f10244j = eVar.s();
                            case 26:
                                if ((i10 & 4) != 4) {
                                    this.f10245k = new ArrayList();
                                    i10 |= 4;
                                }
                                list = this.f10245k;
                                u10 = eVar.u(s.f10265s, gVar);
                                list.add(u10);
                            case 34:
                                d10 = (this.f10242h & 4) == 4 ? this.f10246l.d() : null;
                                q qVar = (q) eVar.u(q.f10192z, gVar);
                                this.f10246l = qVar;
                                if (d10 != null) {
                                    d10.p(qVar);
                                    this.f10246l = d10.y();
                                }
                                this.f10242h |= 4;
                            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
                                this.f10242h |= 8;
                                this.f10247m = eVar.s();
                            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
                                d10 = (this.f10242h & 16) == 16 ? this.f10248n.d() : null;
                                q qVar2 = (q) eVar.u(q.f10192z, gVar);
                                this.f10248n = qVar2;
                                if (d10 != null) {
                                    d10.p(qVar2);
                                    this.f10248n = d10.y();
                                }
                                this.f10242h |= 16;
                            case 56:
                                this.f10242h |= 32;
                                this.f10249o = eVar.s();
                            case 66:
                                if ((i10 & 128) != 128) {
                                    this.f10250p = new ArrayList();
                                    i10 |= 128;
                                }
                                list = this.f10250p;
                                u10 = eVar.u(ga.b.f9915m, gVar);
                                list.add(u10);
                            case 248:
                                if ((i10 & 256) != 256) {
                                    this.f10251q = new ArrayList();
                                    i10 |= 256;
                                }
                                list = this.f10251q;
                                u10 = Integer.valueOf(eVar.s());
                                list.add(u10);
                            case 250:
                                int j10 = eVar.j(eVar.A());
                                if ((i10 & 256) != 256 && eVar.e() > 0) {
                                    this.f10251q = new ArrayList();
                                    i10 |= 256;
                                }
                                while (eVar.e() > 0) {
                                    this.f10251q.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j10);
                                break;
                            default:
                                r52 = q(eVar, J, gVar, K);
                                if (r52 == 0) {
                                    z10 = true;
                                }
                        }
                    } catch (IOException e10) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                    throw e11.i(this);
                }
            } catch (Throwable th2) {
                if ((i10 & 4) == 4) {
                    this.f10245k = Collections.unmodifiableList(this.f10245k);
                }
                if ((i10 & 128) == r52) {
                    this.f10250p = Collections.unmodifiableList(this.f10250p);
                }
                if ((i10 & 256) == 256) {
                    this.f10251q = Collections.unmodifiableList(this.f10251q);
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f10241g = A.j();
                    throw th3;
                }
                this.f10241g = A.j();
                n();
                throw th2;
            }
        }
    }

    private r(i.c<r, ?> cVar) {
        super(cVar);
        this.f10252r = (byte) -1;
        this.f10253s = -1;
        this.f10241g = cVar.o();
    }

    private r(boolean z10) {
        this.f10252r = (byte) -1;
        this.f10253s = -1;
        this.f10241g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static r T() {
        return f10239t;
    }

    private void l0() {
        this.f10243i = 6;
        this.f10244j = 0;
        this.f10245k = Collections.emptyList();
        this.f10246l = q.Z();
        this.f10247m = 0;
        this.f10248n = q.Z();
        this.f10249o = 0;
        this.f10250p = Collections.emptyList();
        this.f10251q = Collections.emptyList();
    }

    public static b m0() {
        return b.w();
    }

    public static b n0(r rVar) {
        return m0().p(rVar);
    }

    public static r p0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f10240u.a(inputStream, gVar);
    }

    public ga.b Q(int i10) {
        return this.f10250p.get(i10);
    }

    public int R() {
        return this.f10250p.size();
    }

    public List<ga.b> S() {
        return this.f10250p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public r b() {
        return f10239t;
    }

    public q V() {
        return this.f10248n;
    }

    public int W() {
        return this.f10249o;
    }

    public int X() {
        return this.f10243i;
    }

    public int Y() {
        return this.f10244j;
    }

    public s Z(int i10) {
        return this.f10245k.get(i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10253s;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10242h & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10243i) + 0 : 0;
        if ((this.f10242h & 2) == 2) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10244j);
        }
        for (int i11 = 0; i11 < this.f10245k.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10245k.get(i11));
        }
        if ((this.f10242h & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10246l);
        }
        if ((this.f10242h & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.f10247m);
        }
        if ((this.f10242h & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.f10248n);
        }
        if ((this.f10242h & 32) == 32) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.f10249o);
        }
        for (int i12 = 0; i12 < this.f10250p.size(); i12++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(8, this.f10250p.get(i12));
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.f10251q.size(); i14++) {
            i13 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f10251q.get(i14).intValue());
        }
        int size = o10 + i13 + (e0().size() * 2) + u() + this.f10241g.size();
        this.f10253s = size;
        return size;
    }

    public int a0() {
        return this.f10245k.size();
    }

    public List<s> b0() {
        return this.f10245k;
    }

    public q c0() {
        return this.f10246l;
    }

    public int d0() {
        return this.f10247m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10242h & 1) == 1) {
            fVar.a0(1, this.f10243i);
        }
        if ((this.f10242h & 2) == 2) {
            fVar.a0(2, this.f10244j);
        }
        for (int i10 = 0; i10 < this.f10245k.size(); i10++) {
            fVar.d0(3, this.f10245k.get(i10));
        }
        if ((this.f10242h & 4) == 4) {
            fVar.d0(4, this.f10246l);
        }
        if ((this.f10242h & 8) == 8) {
            fVar.a0(5, this.f10247m);
        }
        if ((this.f10242h & 16) == 16) {
            fVar.d0(6, this.f10248n);
        }
        if ((this.f10242h & 32) == 32) {
            fVar.a0(7, this.f10249o);
        }
        for (int i11 = 0; i11 < this.f10250p.size(); i11++) {
            fVar.d0(8, this.f10250p.get(i11));
        }
        for (int i12 = 0; i12 < this.f10251q.size(); i12++) {
            fVar.a0(31, this.f10251q.get(i12).intValue());
        }
        z10.a(200, fVar);
        fVar.i0(this.f10241g);
    }

    public List<Integer> e0() {
        return this.f10251q;
    }

    public boolean f0() {
        return (this.f10242h & 16) == 16;
    }

    public boolean g0() {
        return (this.f10242h & 32) == 32;
    }

    public boolean h0() {
        return (this.f10242h & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<r> i() {
        return f10240u;
    }

    public boolean i0() {
        return (this.f10242h & 2) == 2;
    }

    public boolean j0() {
        return (this.f10242h & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10252r;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!i0()) {
            this.f10252r = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < a0(); i10++) {
            if (!Z(i10).k()) {
                this.f10252r = (byte) 0;
                return false;
            }
        }
        if (j0() && !c0().k()) {
            this.f10252r = (byte) 0;
            return false;
        }
        if (f0() && !V().k()) {
            this.f10252r = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < R(); i11++) {
            if (!Q(i11).k()) {
                this.f10252r = (byte) 0;
                return false;
            }
        }
        if (t()) {
            this.f10252r = (byte) 1;
            return true;
        }
        this.f10252r = (byte) 0;
        return false;
    }

    public boolean k0() {
        return (this.f10242h & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return m0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return n0(this);
    }
}
