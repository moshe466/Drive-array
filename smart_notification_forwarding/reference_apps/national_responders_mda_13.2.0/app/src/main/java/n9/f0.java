package n9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ua.h;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final ab.n f12268a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f12269b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.g<la.b, g0> f12270c;

    /* renamed from: d, reason: collision with root package name */
    private final ab.g<a, e> f12271d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final la.a f12272a;

        /* renamed from: b, reason: collision with root package name */
        private final List<Integer> f12273b;

        public a(la.a aVar, List<Integer> list) {
            y8.k.e(aVar, "classId");
            y8.k.e(list, "typeParametersCount");
            this.f12272a = aVar;
            this.f12273b = list;
        }

        public final la.a a() {
            return this.f12272a;
        }

        public final List<Integer> b() {
            return this.f12273b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return y8.k.a(this.f12272a, aVar.f12272a) && y8.k.a(this.f12273b, aVar.f12273b);
        }

        public int hashCode() {
            return (this.f12272a.hashCode() * 31) + this.f12273b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.f12272a + ", typeParametersCount=" + this.f12273b + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends p9.g {

        /* renamed from: n, reason: collision with root package name */
        private final boolean f12274n;

        /* renamed from: o, reason: collision with root package name */
        private final List<a1> f12275o;

        /* renamed from: p, reason: collision with root package name */
        private final bb.i f12276p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ab.n nVar, m mVar, la.e eVar, boolean z10, int i10) {
            super(nVar, mVar, eVar, v0.f12324a, false);
            d9.c f10;
            int n10;
            Set a10;
            y8.k.e(nVar, "storageManager");
            y8.k.e(mVar, "container");
            y8.k.e(eVar, "name");
            this.f12274n = z10;
            f10 = d9.f.f(0, i10);
            n10 = m8.r.n(f10, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<Integer> it = f10.iterator();
            while (it.hasNext()) {
                int b10 = ((m8.g0) it).b();
                arrayList.add(p9.j0.c1(this, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), false, bb.h1.INVARIANT, la.e.r(y8.k.j("T", Integer.valueOf(b10))), b10, nVar));
            }
            this.f12275o = arrayList;
            List<a1> d10 = b1.d(this);
            a10 = m8.q0.a(ra.a.l(this).w().i());
            this.f12276p = new bb.i(this, d10, a10, nVar);
        }

        @Override // n9.e
        public e A0() {
            return null;
        }

        @Override // n9.e, n9.i
        public List<a1> B() {
            return this.f12275o;
        }

        @Override // n9.z
        public boolean H0() {
            return false;
        }

        @Override // p9.g, n9.z
        public boolean I() {
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
        /* renamed from: V0, reason: merged with bridge method [inline-methods] */
        public h.b x0() {
            return h.b.f14541b;
        }

        @Override // n9.e
        public boolean W() {
            return false;
        }

        @Override // n9.h
        /* renamed from: W0, reason: merged with bridge method [inline-methods] */
        public bb.i o() {
            return this.f12276p;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // p9.t
        /* renamed from: X0, reason: merged with bridge method [inline-methods] */
        public h.b v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "kotlinTypeRefiner");
            return h.b.f14541b;
        }

        @Override // n9.e
        public Collection<e> g0() {
            List d10;
            d10 = m8.q.d();
            return d10;
        }

        @Override // n9.e, n9.q, n9.z
        public u h() {
            u uVar = t.f12303e;
            y8.k.d(uVar, "PUBLIC");
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
            return this.f12274n;
        }

        @Override // n9.e, n9.z
        public a0 p() {
            return a0.FINAL;
        }

        @Override // n9.e
        public Collection<n9.d> q() {
            Set b10;
            b10 = m8.r0.b();
            return b10;
        }

        @Override // n9.e
        public f r() {
            return f.CLASS;
        }

        public String toString() {
            return "class " + c() + " (not found)";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        }

        @Override // n9.e
        public n9.d w0() {
            return null;
        }

        @Override // n9.e
        public boolean x() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<a, e> {
        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e h(a aVar) {
            List<Integer> D;
            g d10;
            y8.k.e(aVar, "$dstr$classId$typeParametersCount");
            la.a a10 = aVar.a();
            List<Integer> b10 = aVar.b();
            if (a10.k()) {
                throw new UnsupportedOperationException(y8.k.j("Unresolved local class: ", a10));
            }
            la.a g10 = a10.g();
            if (g10 == null) {
                d10 = null;
            } else {
                f0 f0Var = f0.this;
                D = m8.y.D(b10, 1);
                d10 = f0Var.d(g10, D);
            }
            if (d10 == null) {
                ab.g gVar = f0.this.f12270c;
                la.b h10 = a10.h();
                y8.k.d(h10, "classId.packageFqName");
                d10 = (g) gVar.h(h10);
            }
            g gVar2 = d10;
            boolean l10 = a10.l();
            ab.n nVar = f0.this.f12268a;
            la.e j10 = a10.j();
            y8.k.d(j10, "classId.shortClassName");
            Integer num = (Integer) m8.o.J(b10);
            return new b(nVar, gVar2, j10, l10, num == null ? 0 : num.intValue());
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<la.b, g0> {
        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 h(la.b bVar) {
            y8.k.e(bVar, "fqName");
            return new p9.m(f0.this.f12269b, bVar);
        }
    }

    public f0(ab.n nVar, d0 d0Var) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(d0Var, "module");
        this.f12268a = nVar;
        this.f12269b = d0Var;
        this.f12270c = nVar.i(new d());
        this.f12271d = nVar.i(new c());
    }

    public final e d(la.a aVar, List<Integer> list) {
        y8.k.e(aVar, "classId");
        y8.k.e(list, "typeParametersCount");
        return this.f12271d.h(new a(aVar, list));
    }
}
