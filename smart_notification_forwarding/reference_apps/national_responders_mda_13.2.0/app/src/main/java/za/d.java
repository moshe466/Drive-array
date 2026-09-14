package za;

import bb.b0;
import ga.c;
import ga.s;
import ga.t;
import ia.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m8.k0;
import m8.q;
import m8.r;
import m8.s0;
import m8.v;
import m8.y;
import n9.a0;
import n9.a1;
import n9.b1;
import n9.f0;
import n9.p0;
import n9.t0;
import n9.u;
import n9.u0;
import n9.v0;
import n9.y0;
import ua.h;
import ua.k;
import xa.p;
import xa.x;
import xa.z;
import y8.w;

/* loaded from: classes.dex */
public final class d extends p9.a implements n9.m {
    private final ab.i<Collection<n9.e>> A;
    private final x.a B;
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g C;

    /* renamed from: k, reason: collision with root package name */
    private final ga.c f16383k;

    /* renamed from: l, reason: collision with root package name */
    private final ia.a f16384l;

    /* renamed from: m, reason: collision with root package name */
    private final v0 f16385m;

    /* renamed from: n, reason: collision with root package name */
    private final la.a f16386n;

    /* renamed from: o, reason: collision with root package name */
    private final a0 f16387o;

    /* renamed from: p, reason: collision with root package name */
    private final u f16388p;

    /* renamed from: q, reason: collision with root package name */
    private final n9.f f16389q;

    /* renamed from: r, reason: collision with root package name */
    private final xa.l f16390r;

    /* renamed from: s, reason: collision with root package name */
    private final ua.i f16391s;

    /* renamed from: t, reason: collision with root package name */
    private final b f16392t;

    /* renamed from: u, reason: collision with root package name */
    private final t0<a> f16393u;

    /* renamed from: v, reason: collision with root package name */
    private final c f16394v;

    /* renamed from: w, reason: collision with root package name */
    private final n9.m f16395w;

    /* renamed from: x, reason: collision with root package name */
    private final ab.j<n9.d> f16396x;

    /* renamed from: y, reason: collision with root package name */
    private final ab.i<Collection<n9.d>> f16397y;

    /* renamed from: z, reason: collision with root package name */
    private final ab.j<n9.e> f16398z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a extends za.h {

        /* renamed from: g, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f16399g;

        /* renamed from: h, reason: collision with root package name */
        private final ab.i<Collection<n9.m>> f16400h;

        /* renamed from: i, reason: collision with root package name */
        private final ab.i<Collection<b0>> f16401i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f16402j;

        /* renamed from: za.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0349a extends y8.l implements x8.a<List<? extends la.e>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ List<la.e> f16403f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0349a(List<la.e> list) {
                super(0);
                this.f16403f = list;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<la.e> b() {
                return this.f16403f;
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<Collection<? extends n9.m>> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<n9.m> b() {
                return a.this.k(ua.d.f14517o, ua.h.f14537a.a(), u9.d.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends na.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List<D> f16405a;

            c(List<D> list) {
                this.f16405a = list;
            }

            @Override // na.i
            public void a(n9.b bVar) {
                y8.k.e(bVar, "fakeOverride");
                na.j.N(bVar, null);
                this.f16405a.add(bVar);
            }

            @Override // na.h
            protected void e(n9.b bVar, n9.b bVar2) {
                y8.k.e(bVar, "fromSuper");
                y8.k.e(bVar2, "fromCurrent");
            }
        }

        /* renamed from: za.d$a$d, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0350d extends y8.l implements x8.a<Collection<? extends b0>> {
            C0350d() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<b0> b() {
                return a.this.f16399g.f(a.this.C());
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(za.d r8, kotlin.reflect.jvm.internal.impl.types.checker.g r9) {
            /*
                r7 = this;
                java.lang.String r0 = "this$0"
                y8.k.e(r8, r0)
                java.lang.String r0 = "kotlinTypeRefiner"
                y8.k.e(r9, r0)
                r7.f16402j = r8
                xa.l r2 = r8.h1()
                ga.c r0 = r8.i1()
                java.util.List r3 = r0.s0()
                java.lang.String r0 = "classProto.functionList"
                y8.k.d(r3, r0)
                ga.c r0 = r8.i1()
                java.util.List r4 = r0.w0()
                java.lang.String r0 = "classProto.propertyList"
                y8.k.d(r4, r0)
                ga.c r0 = r8.i1()
                java.util.List r5 = r0.E0()
                java.lang.String r0 = "classProto.typeAliasList"
                y8.k.d(r5, r0)
                ga.c r0 = r8.i1()
                java.util.List r0 = r0.t0()
                java.lang.String r1 = "classProto.nestedClassNameList"
                y8.k.d(r0, r1)
                xa.l r8 = r8.h1()
                ia.c r8 = r8.g()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = m8.o.n(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L5b:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L73
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                la.e r6 = xa.v.b(r8, r6)
                r1.add(r6)
                goto L5b
            L73:
                za.d$a$a r6 = new za.d$a$a
                r6.<init>(r1)
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f16399g = r9
                xa.l r8 = r7.q()
                ab.n r8 = r8.h()
                za.d$a$b r9 = new za.d$a$b
                r9.<init>()
                ab.i r8 = r8.a(r9)
                r7.f16400h = r8
                xa.l r8 = r7.q()
                ab.n r8 = r8.h()
                za.d$a$d r9 = new za.d$a$d
                r9.<init>()
                ab.i r8 = r8.a(r9)
                r7.f16401i = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: za.d.a.<init>(za.d, kotlin.reflect.jvm.internal.impl.types.checker.g):void");
        }

        private final <D extends n9.b> void B(la.e eVar, Collection<? extends D> collection, List<D> list) {
            q().c().m().a().y(eVar, collection, new ArrayList(list), C(), new c(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d C() {
            return this.f16402j;
        }

        public void D(la.e eVar, u9.b bVar) {
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            t9.a.a(q().c().o(), bVar, C(), eVar);
        }

        @Override // za.h, ua.i, ua.h
        public Collection<p0> a(la.e eVar, u9.b bVar) {
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            D(eVar, bVar);
            return super.a(eVar, bVar);
        }

        @Override // za.h, ua.i, ua.h
        public Collection<u0> b(la.e eVar, u9.b bVar) {
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            D(eVar, bVar);
            return super.b(eVar, bVar);
        }

        @Override // ua.i, ua.k
        public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
            y8.k.e(dVar, "kindFilter");
            y8.k.e(lVar, "nameFilter");
            return this.f16400h.b();
        }

        @Override // za.h, ua.i, ua.k
        public n9.h g(la.e eVar, u9.b bVar) {
            n9.e f10;
            y8.k.e(eVar, "name");
            y8.k.e(bVar, "location");
            D(eVar, bVar);
            c cVar = C().f16394v;
            return (cVar == null || (f10 = cVar.f(eVar)) == null) ? super.g(eVar, bVar) : f10;
        }

        @Override // za.h
        protected void j(Collection<n9.m> collection, x8.l<? super la.e, Boolean> lVar) {
            y8.k.e(collection, "result");
            y8.k.e(lVar, "nameFilter");
            c cVar = C().f16394v;
            Collection<n9.e> d10 = cVar == null ? null : cVar.d();
            if (d10 == null) {
                d10 = q.d();
            }
            collection.addAll(d10);
        }

        @Override // za.h
        protected void l(la.e eVar, List<u0> list) {
            y8.k.e(eVar, "name");
            y8.k.e(list, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator<b0> it = this.f16401i.b().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().A().b(eVar, u9.d.FOR_ALREADY_TRACKED));
            }
            list.addAll(q().c().c().e(eVar, this.f16402j));
            B(eVar, arrayList, list);
        }

        @Override // za.h
        protected void m(la.e eVar, List<p0> list) {
            y8.k.e(eVar, "name");
            y8.k.e(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator<b0> it = this.f16401i.b().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().A().a(eVar, u9.d.FOR_ALREADY_TRACKED));
            }
            B(eVar, arrayList, list);
        }

        @Override // za.h
        protected la.a n(la.e eVar) {
            y8.k.e(eVar, "name");
            la.a d10 = this.f16402j.f16386n.d(eVar);
            y8.k.d(d10, "classId.createNestedClassId(name)");
            return d10;
        }

        @Override // za.h
        protected Set<la.e> t() {
            List<b0> x10 = C().f16392t.x();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = x10.iterator();
            while (it.hasNext()) {
                Set<la.e> f10 = ((b0) it.next()).A().f();
                if (f10 == null) {
                    return null;
                }
                v.r(linkedHashSet, f10);
            }
            return linkedHashSet;
        }

        @Override // za.h
        protected Set<la.e> u() {
            List<b0> x10 = C().f16392t.x();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = x10.iterator();
            while (it.hasNext()) {
                v.r(linkedHashSet, ((b0) it.next()).A().c());
            }
            linkedHashSet.addAll(q().c().c().b(this.f16402j));
            return linkedHashSet;
        }

        @Override // za.h
        protected Set<la.e> v() {
            List<b0> x10 = C().f16392t.x();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = x10.iterator();
            while (it.hasNext()) {
                v.r(linkedHashSet, ((b0) it.next()).A().d());
            }
            return linkedHashSet;
        }

        @Override // za.h
        protected boolean y(u0 u0Var) {
            y8.k.e(u0Var, "function");
            return q().c().s().c(this.f16402j, u0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends bb.b {

        /* renamed from: d, reason: collision with root package name */
        private final ab.i<List<a1>> f16407d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f16408e;

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<List<? extends a1>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f16409f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.f16409f = dVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<a1> b() {
                return b1.d(this.f16409f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar.h1().h());
            y8.k.e(dVar, "this$0");
            this.f16408e = dVar;
            this.f16407d = dVar.h1().h().a(new a(dVar));
        }

        @Override // bb.t0
        public List<a1> B() {
            return this.f16407d.b();
        }

        @Override // bb.g
        protected Collection<b0> d() {
            int n10;
            List a02;
            List n02;
            int n11;
            la.b b10;
            List<ga.q> k10 = ia.f.k(this.f16408e.i1(), this.f16408e.h1().j());
            d dVar = this.f16408e;
            n10 = r.n(k10, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = k10.iterator();
            while (it.hasNext()) {
                arrayList.add(dVar.h1().i().p((ga.q) it.next()));
            }
            a02 = y.a0(arrayList, this.f16408e.h1().c().c().d(this.f16408e));
            ArrayList<f0.b> arrayList2 = new ArrayList();
            Iterator it2 = a02.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                n9.h o10 = ((b0) it2.next()).W0().o();
                f0.b bVar = o10 instanceof f0.b ? (f0.b) o10 : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                p i10 = this.f16408e.h1().c().i();
                d dVar2 = this.f16408e;
                n11 = r.n(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(n11);
                for (f0.b bVar2 : arrayList2) {
                    la.a h10 = ra.a.h(bVar2);
                    String b11 = (h10 == null || (b10 = h10.b()) == null) ? null : b10.b();
                    if (b11 == null) {
                        b11 = bVar2.c().k();
                    }
                    arrayList3.add(b11);
                }
                i10.b(dVar2, arrayList3);
            }
            n02 = y.n0(a02);
            return n02;
        }

        @Override // bb.g
        protected y0 h() {
            return y0.a.f12328a;
        }

        @Override // bb.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public d o() {
            return this.f16408e;
        }

        public String toString() {
            String eVar = this.f16408e.c().toString();
            y8.k.d(eVar, "name.toString()");
            return eVar;
        }

        @Override // bb.t0
        public boolean z() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Map<la.e, ga.g> f16410a;

        /* renamed from: b, reason: collision with root package name */
        private final ab.h<la.e, n9.e> f16411b;

        /* renamed from: c, reason: collision with root package name */
        private final ab.i<Set<la.e>> f16412c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f16413d;

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.l<la.e, n9.e> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f16415g;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: za.d$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0351a extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ d f16416f;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ ga.g f16417g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0351a(d dVar, ga.g gVar) {
                    super(0);
                    this.f16416f = dVar;
                    this.f16417g = gVar;
                }

                @Override // x8.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n02;
                    n02 = y.n0(this.f16416f.h1().c().d().f(this.f16416f.m1(), this.f16417g));
                    return n02;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(1);
                this.f16415g = dVar;
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final n9.e h(la.e eVar) {
                y8.k.e(eVar, "name");
                ga.g gVar = (ga.g) c.this.f16410a.get(eVar);
                if (gVar == null) {
                    return null;
                }
                d dVar = this.f16415g;
                return p9.n.W0(dVar.h1().h(), dVar, eVar, c.this.f16412c, new za.a(dVar.h1().h(), new C0351a(dVar, gVar)), v0.f12324a);
            }
        }

        /* loaded from: classes.dex */
        static final class b extends y8.l implements x8.a<Set<? extends la.e>> {
            b() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<la.e> b() {
                return c.this.e();
            }
        }

        public c(d dVar) {
            int n10;
            int d10;
            int a10;
            y8.k.e(dVar, "this$0");
            this.f16413d = dVar;
            List<ga.g> n02 = dVar.i1().n0();
            y8.k.d(n02, "classProto.enumEntryList");
            n10 = r.n(n02, 10);
            d10 = k0.d(n10);
            a10 = d9.f.a(d10, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
            for (Object obj : n02) {
                linkedHashMap.put(xa.v.b(dVar.h1().g(), ((ga.g) obj).H()), obj);
            }
            this.f16410a = linkedHashMap;
            this.f16411b = this.f16413d.h1().h().c(new a(this.f16413d));
            this.f16412c = this.f16413d.h1().h().a(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<la.e> e() {
            Set<la.e> g10;
            HashSet hashSet = new HashSet();
            Iterator<b0> it = this.f16413d.o().x().iterator();
            while (it.hasNext()) {
                for (n9.m mVar : k.a.a(it.next().A(), null, null, 3, null)) {
                    if ((mVar instanceof u0) || (mVar instanceof p0)) {
                        hashSet.add(mVar.c());
                    }
                }
            }
            List<ga.i> s02 = this.f16413d.i1().s0();
            y8.k.d(s02, "classProto.functionList");
            d dVar = this.f16413d;
            Iterator<T> it2 = s02.iterator();
            while (it2.hasNext()) {
                hashSet.add(xa.v.b(dVar.h1().g(), ((ga.i) it2.next()).X()));
            }
            List<ga.n> w02 = this.f16413d.i1().w0();
            y8.k.d(w02, "classProto.propertyList");
            d dVar2 = this.f16413d;
            Iterator<T> it3 = w02.iterator();
            while (it3.hasNext()) {
                hashSet.add(xa.v.b(dVar2.h1().g(), ((ga.n) it3.next()).W()));
            }
            g10 = s0.g(hashSet, hashSet);
            return g10;
        }

        public final Collection<n9.e> d() {
            Set<la.e> keySet = this.f16410a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                n9.e f10 = f((la.e) it.next());
                if (f10 != null) {
                    arrayList.add(f10);
                }
            }
            return arrayList;
        }

        public final n9.e f(la.e eVar) {
            y8.k.e(eVar, "name");
            return this.f16411b.h(eVar);
        }
    }

    /* renamed from: za.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0352d extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        C0352d() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n02;
            n02 = y.n0(d.this.h1().c().d().h(d.this.m1()));
            return n02;
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.a<n9.e> {
        e() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.e b() {
            return d.this.c1();
        }
    }

    /* loaded from: classes.dex */
    static final class f extends y8.l implements x8.a<Collection<? extends n9.d>> {
        f() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<n9.d> b() {
            return d.this.d1();
        }
    }

    /* loaded from: classes.dex */
    /* synthetic */ class g extends y8.i implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, a> {
        g(d dVar) {
            super(1, dVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "<init>";
        }

        @Override // y8.c
        public final e9.d k() {
            return w.b(a.class);
        }

        @Override // y8.c
        public final String m() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final a h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "p0");
            return new a((d) this.f15934g, gVar);
        }
    }

    /* loaded from: classes.dex */
    static final class h extends y8.l implements x8.a<n9.d> {
        h() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.d b() {
            return d.this.e1();
        }
    }

    /* loaded from: classes.dex */
    static final class i extends y8.l implements x8.a<Collection<? extends n9.e>> {
        i() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<n9.e> b() {
            return d.this.g1();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(xa.l lVar, ga.c cVar, ia.c cVar2, ia.a aVar, v0 v0Var) {
        super(lVar.h(), xa.v.a(cVar2, cVar.p0()).j());
        y8.k.e(lVar, "outerContext");
        y8.k.e(cVar, "classProto");
        y8.k.e(cVar2, "nameResolver");
        y8.k.e(aVar, "metadataVersion");
        y8.k.e(v0Var, "sourceElement");
        this.f16383k = cVar;
        this.f16384l = aVar;
        this.f16385m = v0Var;
        this.f16386n = xa.v.a(cVar2, cVar.p0());
        xa.y yVar = xa.y.f15666a;
        this.f16387o = yVar.b(ia.b.f10798d.d(cVar.o0()));
        this.f16388p = z.a(yVar, ia.b.f10797c.d(cVar.o0()));
        n9.f a10 = yVar.a(ia.b.f10799e.d(cVar.o0()));
        this.f16389q = a10;
        List<s> H0 = cVar.H0();
        y8.k.d(H0, "classProto.typeParameterList");
        t I0 = cVar.I0();
        y8.k.d(I0, "classProto.typeTable");
        ia.g gVar = new ia.g(I0);
        i.a aVar2 = ia.i.f10840b;
        ga.w K0 = cVar.K0();
        y8.k.d(K0, "classProto.versionRequirementTable");
        xa.l a11 = lVar.a(this, H0, cVar2, gVar, aVar2.a(K0), aVar);
        this.f16390r = a11;
        n9.f fVar = n9.f.ENUM_CLASS;
        this.f16391s = a10 == fVar ? new ua.l(a11.h(), this) : h.b.f14541b;
        this.f16392t = new b(this);
        this.f16393u = t0.f12315e.a(this, a11.h(), a11.c().m().d(), new g(this));
        this.f16394v = a10 == fVar ? new c(this) : null;
        n9.m e10 = lVar.e();
        this.f16395w = e10;
        this.f16396x = a11.h().h(new h());
        this.f16397y = a11.h().a(new f());
        this.f16398z = a11.h().h(new e());
        this.A = a11.h().a(new i());
        ia.c g10 = a11.g();
        ia.g j10 = a11.j();
        d dVar = e10 instanceof d ? (d) e10 : null;
        this.B = new x.a(cVar, g10, j10, v0Var, dVar != null ? dVar.B : null);
        this.C = !ia.b.f10796b.d(cVar.o0()).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b() : new n(a11.h(), new C0352d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.e c1() {
        if (!this.f16383k.L0()) {
            return null;
        }
        n9.h g10 = j1().g(xa.v.b(this.f16390r.g(), this.f16383k.f0()), u9.d.FROM_DESERIALIZATION);
        if (g10 instanceof n9.e) {
            return (n9.e) g10;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<n9.d> d1() {
        List h10;
        List a02;
        List a03;
        List<n9.d> f12 = f1();
        h10 = q.h(w0());
        a02 = y.a0(f12, h10);
        a03 = y.a0(a02, this.f16390r.c().c().a(this));
        return a03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.d e1() {
        Object obj;
        if (this.f16389q.isSingleton()) {
            p9.f i10 = na.c.i(this, v0.f12324a);
            i10.r1(s());
            return i10;
        }
        List<ga.d> i02 = this.f16383k.i0();
        y8.k.d(i02, "classProto.constructorList");
        Iterator<T> it = i02.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!ia.b.f10806l.d(((ga.d) obj).L()).booleanValue()) {
                break;
            }
        }
        ga.d dVar = (ga.d) obj;
        if (dVar == null) {
            return null;
        }
        return h1().f().m(dVar, true);
    }

    private final List<n9.d> f1() {
        int n10;
        List<ga.d> i02 = this.f16383k.i0();
        y8.k.d(i02, "classProto.constructorList");
        ArrayList<ga.d> arrayList = new ArrayList();
        for (Object obj : i02) {
            Boolean d10 = ia.b.f10806l.d(((ga.d) obj).L());
            y8.k.d(d10, "IS_SECONDARY.get(it.flags)");
            if (d10.booleanValue()) {
                arrayList.add(obj);
            }
        }
        n10 = r.n(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(n10);
        for (ga.d dVar : arrayList) {
            xa.u f10 = h1().f();
            y8.k.d(dVar, "it");
            arrayList2.add(f10.m(dVar, false));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<n9.e> g1() {
        List d10;
        if (this.f16387o != a0.SEALED) {
            d10 = q.d();
            return d10;
        }
        List<Integer> x02 = this.f16383k.x0();
        y8.k.d(x02, "fqNames");
        if (!(!x02.isEmpty())) {
            return na.a.f12329a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : x02) {
            xa.j c10 = h1().c();
            ia.c g10 = h1().g();
            y8.k.d(num, "index");
            n9.e b10 = c10.b(xa.v.a(g10, num.intValue()));
            if (b10 != null) {
                arrayList.add(b10);
            }
        }
        return arrayList;
    }

    private final a j1() {
        return this.f16393u.c(this.f16390r.c().m().d());
    }

    @Override // n9.e
    public n9.e A0() {
        return this.f16398z.b();
    }

    @Override // n9.e, n9.i
    public List<a1> B() {
        return this.f16390r.i().k();
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.z
    public boolean I() {
        Boolean d10 = ia.b.f10802h.d(this.f16383k.o0());
        y8.k.d(d10, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return d10.booleanValue();
    }

    @Override // n9.e
    public boolean N() {
        return ia.b.f10799e.d(this.f16383k.o0()) == c.EnumC0180c.COMPANION_OBJECT;
    }

    @Override // n9.e
    public boolean R0() {
        Boolean d10 = ia.b.f10801g.d(this.f16383k.o0());
        y8.k.d(d10, "IS_DATA.get(classProto.flags)");
        return d10.booleanValue();
    }

    @Override // n9.e
    public boolean W() {
        Boolean d10 = ia.b.f10805k.d(this.f16383k.o0());
        y8.k.d(d10, "IS_FUN_INTERFACE.get(classProto.flags)");
        return d10.booleanValue();
    }

    @Override // n9.e, n9.n, n9.m
    public n9.m d() {
        return this.f16395w;
    }

    @Override // n9.e
    public Collection<n9.e> g0() {
        return this.A.b();
    }

    @Override // n9.e, n9.q, n9.z
    public u h() {
        return this.f16388p;
    }

    public final xa.l h1() {
        return this.f16390r;
    }

    public final ga.c i1() {
        return this.f16383k;
    }

    @Override // n9.e
    public boolean j0() {
        Boolean d10 = ia.b.f10804j.d(this.f16383k.o0());
        y8.k.d(d10, "IS_INLINE_CLASS.get(classProto.flags)");
        return d10.booleanValue() && this.f16384l.c(1, 4, 2);
    }

    @Override // n9.p
    public v0 k() {
        return this.f16385m;
    }

    public final ia.a k1() {
        return this.f16384l;
    }

    @Override // n9.z
    public boolean l0() {
        Boolean d10 = ia.b.f10803i.d(this.f16383k.o0());
        y8.k.d(d10, "IS_EXPECT_CLASS.get(classProto.flags)");
        return d10.booleanValue();
    }

    @Override // n9.e
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public ua.i x0() {
        return this.f16391s;
    }

    @Override // n9.i
    public boolean m0() {
        Boolean d10 = ia.b.f10800f.d(this.f16383k.o0());
        y8.k.d(d10, "IS_INNER.get(classProto.flags)");
        return d10.booleanValue();
    }

    public final x.a m1() {
        return this.B;
    }

    public final boolean n1(la.e eVar) {
        y8.k.e(eVar, "name");
        return j1().r().contains(eVar);
    }

    @Override // n9.h
    public bb.t0 o() {
        return this.f16392t;
    }

    @Override // n9.e, n9.z
    public a0 p() {
        return this.f16387o;
    }

    @Override // n9.e
    public Collection<n9.d> q() {
        return this.f16397y.b();
    }

    @Override // n9.e
    public n9.f r() {
        return this.f16389q;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deserialized ");
        sb2.append(l0() ? "expect " : "");
        sb2.append("class ");
        sb2.append(c());
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.t
    public ua.h v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this.f16393u.c(gVar);
    }

    @Override // n9.e
    public n9.d w0() {
        return this.f16396x.b();
    }

    @Override // n9.e
    public boolean x() {
        Boolean d10 = ia.b.f10804j.d(this.f16383k.o0());
        y8.k.d(d10, "IS_INLINE_CLASS.get(classProto.flags)");
        return d10.booleanValue() && this.f16384l.e(1, 4, 1);
    }
}
