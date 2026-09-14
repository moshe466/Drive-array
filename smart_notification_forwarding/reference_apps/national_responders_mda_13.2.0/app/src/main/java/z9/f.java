package z9;

import bb.b0;
import ca.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.o;
import m8.q;
import m8.r;
import m8.r0;
import n9.a0;
import n9.a1;
import n9.b1;
import n9.f0;
import n9.h1;
import n9.t;
import n9.t0;
import n9.u;
import n9.y0;
import pa.v;
import v9.d0;
import v9.y;
import xa.p;

/* loaded from: classes.dex */
public final class f extends p9.g implements x9.d {
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g A;
    private final ab.i<List<a1>> B;

    /* renamed from: n, reason: collision with root package name */
    private final y9.g f16274n;

    /* renamed from: o, reason: collision with root package name */
    private final ca.g f16275o;

    /* renamed from: p, reason: collision with root package name */
    private final n9.e f16276p;

    /* renamed from: q, reason: collision with root package name */
    private final y9.g f16277q;

    /* renamed from: r, reason: collision with root package name */
    private final n9.f f16278r;

    /* renamed from: s, reason: collision with root package name */
    private final a0 f16279s;

    /* renamed from: t, reason: collision with root package name */
    private final h1 f16280t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f16281u;

    /* renamed from: v, reason: collision with root package name */
    private final b f16282v;

    /* renamed from: w, reason: collision with root package name */
    private final g f16283w;

    /* renamed from: x, reason: collision with root package name */
    private final t0<g> f16284x;

    /* renamed from: y, reason: collision with root package name */
    private final ua.f f16285y;

    /* renamed from: z, reason: collision with root package name */
    private final k f16286z;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends bb.b {

        /* renamed from: d, reason: collision with root package name */
        private final ab.i<List<a1>> f16287d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16288e;

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<List<? extends a1>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f16289f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f16289f = fVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<a1> b() {
                return b1.d(this.f16289f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar) {
            super(fVar.f16277q.e());
            y8.k.e(fVar, "this$0");
            this.f16288e = fVar;
            this.f16287d = fVar.f16277q.e().a(new a(fVar));
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x001b, code lost:
        
            if ((!r0.d() && r0.i(k9.k.f11245k)) != false) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final bb.b0 q() {
            /*
                r8 = this;
                la.b r0 = r8.r()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto La
            L8:
                r0 = r2
                goto L1d
            La:
                boolean r3 = r0.d()
                if (r3 != 0) goto L1a
                la.e r3 = k9.k.f11245k
                boolean r3 = r0.i(r3)
                if (r3 == 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 == 0) goto L8
            L1d:
                if (r0 != 0) goto L2e
                v9.o r3 = v9.o.f14796a
                z9.f r4 = r8.f16288e
                la.b r4 = ra.a.i(r4)
                la.b r3 = r3.b(r4)
                if (r3 != 0) goto L2f
                return r2
            L2e:
                r3 = r0
            L2f:
                z9.f r4 = r8.f16288e
                y9.g r4 = z9.f.W0(r4)
                n9.d0 r4 = r4.d()
                u9.d r5 = u9.d.FROM_JAVA_LOADER
                n9.e r3 = ra.a.r(r4, r3, r5)
                if (r3 != 0) goto L42
                return r2
            L42:
                bb.t0 r4 = r3.o()
                java.util.List r4 = r4.B()
                int r4 = r4.size()
                z9.f r5 = r8.f16288e
                bb.t0 r5 = r5.o()
                java.util.List r5 = r5.B()
                java.lang.String r6 = "getTypeConstructor().parameters"
                y8.k.d(r5, r6)
                int r6 = r5.size()
                r7 = 10
                if (r6 != r4) goto L8d
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = m8.o.n(r5, r7)
                r0.<init>(r1)
                java.util.Iterator r1 = r5.iterator()
            L72:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto Lc7
                java.lang.Object r2 = r1.next()
                n9.a1 r2 = (n9.a1) r2
                bb.x0 r4 = new bb.x0
                bb.h1 r5 = bb.h1.INVARIANT
                bb.i0 r2 = r2.s()
                r4.<init>(r5, r2)
                r0.add(r4)
                goto L72
            L8d:
                if (r6 != r1) goto Ld4
                if (r4 <= r1) goto Ld4
                if (r0 != 0) goto Ld4
                bb.x0 r0 = new bb.x0
                bb.h1 r2 = bb.h1.INVARIANT
                java.lang.Object r5 = m8.o.d0(r5)
                n9.a1 r5 = (n9.a1) r5
                bb.i0 r5 = r5.s()
                r0.<init>(r2, r5)
                d9.c r2 = new d9.c
                r2.<init>(r1, r4)
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = m8.o.n(r2, r7)
                r1.<init>(r4)
                java.util.Iterator r2 = r2.iterator()
            Lb6:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto Lc6
                r4 = r2
                m8.g0 r4 = (m8.g0) r4
                r4.b()
                r1.add(r0)
                goto Lb6
            Lc6:
                r0 = r1
            Lc7:
                bb.c0 r1 = bb.c0.f4165a
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r1 = r1.b()
                bb.i0 r0 = bb.c0.g(r1, r3, r0)
                return r0
            Ld4:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: z9.f.b.q():bb.b0");
        }

        private final la.b r() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = this.f16288e.u();
            la.b bVar = y.f14826n;
            y8.k.d(bVar, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e10 = u10.e(bVar);
            if (e10 == null) {
                return null;
            }
            Object e02 = o.e0(e10.a().values());
            v vVar = e02 instanceof v ? (v) e02 : null;
            String b10 = vVar == null ? null : vVar.b();
            if (b10 != null && la.d.c(b10)) {
                return new la.b(b10);
            }
            return null;
        }

        @Override // bb.t0
        public List<a1> B() {
            return this.f16287d.b();
        }

        @Override // bb.g
        protected Collection<b0> d() {
            List b10;
            List n02;
            int n10;
            Collection<ca.j> x10 = this.f16288e.a1().x();
            ArrayList arrayList = new ArrayList(x10.size());
            ArrayList arrayList2 = new ArrayList(0);
            b0 q10 = q();
            Iterator<ca.j> it = x10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ca.j next = it.next();
                b0 n11 = this.f16288e.f16277q.g().n(next, aa.d.f(w9.k.SUPERTYPE, false, null, 3, null));
                if (this.f16288e.f16277q.a().p().b()) {
                    n11 = this.f16288e.f16277q.a().q().f(n11, this.f16288e.f16277q);
                }
                if (n11.W0().o() instanceof f0.b) {
                    arrayList2.add(next);
                }
                if (!y8.k.a(n11.W0(), q10 != null ? q10.W0() : null) && !k9.h.a0(n11)) {
                    arrayList.add(n11);
                }
            }
            n9.e eVar = this.f16288e.f16276p;
            jb.a.a(arrayList, eVar != null ? m9.j.a(eVar, this.f16288e).c().p(eVar.s(), bb.h1.INVARIANT) : null);
            jb.a.a(arrayList, q10);
            if (!arrayList2.isEmpty()) {
                p c10 = this.f16288e.f16277q.a().c();
                n9.e o10 = o();
                n10 = r.n(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(n10);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((ca.j) ((x) it2.next())).D());
                }
                c10.b(o10, arrayList3);
            }
            if (!arrayList.isEmpty()) {
                n02 = m8.y.n0(arrayList);
                return n02;
            }
            b10 = m8.p.b(this.f16288e.f16277q.d().w().i());
            return b10;
        }

        @Override // bb.g
        protected y0 h() {
            return this.f16288e.f16277q.a().u();
        }

        @Override // bb.g, bb.t0
        public n9.e o() {
            return this.f16288e;
        }

        public String toString() {
            String k10 = this.f16288e.c().k();
            y8.k.d(k10, "name.asString()");
            return k10;
        }

        @Override // bb.t0
        public boolean z() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<List<? extends a1>> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<a1> b() {
            int n10;
            List<ca.y> m10 = f.this.a1().m();
            f fVar = f.this;
            n10 = r.n(m10, 10);
            ArrayList arrayList = new ArrayList(n10);
            for (ca.y yVar : m10) {
                a1 a10 = fVar.f16277q.f().a(yVar);
                if (a10 == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.a1() + ", so it must be resolved");
                }
                arrayList.add(a10);
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, g> {
        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "it");
            y9.g gVar2 = f.this.f16277q;
            f fVar = f.this;
            return new g(gVar2, fVar, fVar.a1(), f.this.f16276p != null, f.this.f16283w);
        }
    }

    static {
        new a(null);
        r0.e("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(y9.g gVar, n9.m mVar, ca.g gVar2, n9.e eVar) {
        super(gVar.e(), mVar, gVar2.c(), gVar.a().s().a(gVar2), false);
        a0 a0Var;
        y8.k.e(gVar, "outerContext");
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(gVar2, "jClass");
        this.f16274n = gVar;
        this.f16275o = gVar2;
        this.f16276p = eVar;
        y9.g d10 = y9.a.d(gVar, this, gVar2, 0, 4, null);
        this.f16277q = d10;
        d10.a().g().e(gVar2, this);
        gVar2.J();
        this.f16278r = gVar2.E() ? n9.f.ANNOTATION_CLASS : gVar2.H() ? n9.f.INTERFACE : gVar2.s() ? n9.f.ENUM_CLASS : n9.f.CLASS;
        if (gVar2.E() || gVar2.s()) {
            a0Var = a0.FINAL;
        } else {
            a0Var = a0.Companion.a(false, gVar2.z() || gVar2.I() || gVar2.H(), !gVar2.B());
        }
        this.f16279s = a0Var;
        this.f16280t = gVar2.h();
        this.f16281u = (gVar2.r() == null || gVar2.Y()) ? false : true;
        this.f16282v = new b(this);
        g gVar3 = new g(d10, this, gVar2, eVar != null, null, 16, null);
        this.f16283w = gVar3;
        this.f16284x = t0.f12315e.a(this, d10.e(), d10.a().j().d(), new d());
        this.f16285y = new ua.f(gVar3);
        this.f16286z = new k(d10, gVar2, this);
        this.A = y9.e.a(d10, gVar2);
        this.B = d10.e().a(new c());
    }

    public /* synthetic */ f(y9.g gVar, n9.m mVar, ca.g gVar2, n9.e eVar, int i10, y8.g gVar3) {
        this(gVar, mVar, gVar2, (i10 & 8) != 0 ? null : eVar);
    }

    @Override // n9.e
    public n9.e A0() {
        return null;
    }

    @Override // n9.e, n9.i
    public List<a1> B() {
        return this.B.b();
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.e
    public boolean N() {
        return false;
    }

    @Override // n9.e
    public boolean R0() {
        return false;
    }

    @Override // n9.e
    public boolean W() {
        return false;
    }

    public final f Y0(w9.g gVar, n9.e eVar) {
        y8.k.e(gVar, "javaResolverCache");
        y9.g gVar2 = this.f16277q;
        y9.g j10 = y9.a.j(gVar2, gVar2.a().v(gVar));
        n9.m d10 = d();
        y8.k.d(d10, "containingDeclaration");
        return new f(j10, d10, this.f16275o, eVar);
    }

    @Override // n9.e
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public List<n9.d> q() {
        return this.f16283w.w0().b();
    }

    public final ca.g a1() {
        return this.f16275o;
    }

    @Override // p9.a, n9.e
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public g E0() {
        return (g) super.E0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.t
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public g v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this.f16284x.c(gVar);
    }

    @Override // n9.e
    public Collection<n9.e> g0() {
        List d10;
        if (this.f16279s != a0.SEALED) {
            d10 = q.d();
            return d10;
        }
        aa.a f10 = aa.d.f(w9.k.COMMON, false, null, 3, null);
        Collection<ca.j> Q = this.f16275o.Q();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = Q.iterator();
        while (it.hasNext()) {
            n9.h o10 = this.f16277q.g().n((ca.j) it.next(), f10).W0().o();
            n9.e eVar = o10 instanceof n9.e ? (n9.e) o10 : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    @Override // n9.e, n9.q, n9.z
    public u h() {
        if (!y8.k.a(this.f16280t, t.f12299a) || this.f16275o.r() != null) {
            return d0.b(this.f16280t);
        }
        u uVar = v9.u.f14805a;
        y8.k.d(uVar, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return uVar;
    }

    @Override // n9.e
    public boolean j0() {
        return false;
    }

    @Override // n9.z
    public boolean l0() {
        return false;
    }

    @Override // n9.i
    public boolean m0() {
        return this.f16281u;
    }

    @Override // n9.h
    public bb.t0 o() {
        return this.f16282v;
    }

    @Override // n9.e, n9.z
    public a0 p() {
        return this.f16279s;
    }

    @Override // n9.e
    public n9.f r() {
        return this.f16278r;
    }

    public String toString() {
        return y8.k.j("Lazy Java class ", ra.a.j(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.A;
    }

    @Override // p9.a, n9.e
    public ua.h u0() {
        return this.f16285y;
    }

    @Override // n9.e
    public n9.d w0() {
        return null;
    }

    @Override // n9.e
    public boolean x() {
        return false;
    }

    @Override // n9.e
    public ua.h x0() {
        return this.f16286z;
    }
}
