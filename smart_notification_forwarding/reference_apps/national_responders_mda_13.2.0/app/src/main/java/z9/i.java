package z9;

import ca.c0;
import ca.u;
import ea.m;
import ea.n;
import ea.o;
import fa.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import m8.r0;
import n9.p0;
import n9.u0;
import v9.q;
import z9.b;

/* loaded from: classes.dex */
public final class i extends l {

    /* renamed from: n, reason: collision with root package name */
    private final u f16322n;

    /* renamed from: o, reason: collision with root package name */
    private final h f16323o;

    /* renamed from: p, reason: collision with root package name */
    private final ab.j<Set<String>> f16324p;

    /* renamed from: q, reason: collision with root package name */
    private final ab.h<a, n9.e> f16325q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final la.e f16326a;

        /* renamed from: b, reason: collision with root package name */
        private final ca.g f16327b;

        public a(la.e eVar, ca.g gVar) {
            y8.k.e(eVar, "name");
            this.f16326a = eVar;
            this.f16327b = gVar;
        }

        public final ca.g a() {
            return this.f16327b;
        }

        public final la.e b() {
            return this.f16326a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && y8.k.a(this.f16326a, ((a) obj).f16326a);
        }

        public int hashCode() {
            return this.f16326a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b {

        /* loaded from: classes.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final n9.e f16328a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(n9.e eVar) {
                super(null);
                y8.k.e(eVar, "descriptor");
                this.f16328a = eVar;
            }

            public final n9.e a() {
                return this.f16328a;
            }
        }

        /* renamed from: z9.i$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0347b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C0347b f16329a = new C0347b();

            private C0347b() {
                super(null);
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f16330a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<a, n9.e> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ y9.g f16332g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(y9.g gVar) {
            super(1);
            this.f16332g = gVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.e h(a aVar) {
            byte[] b10;
            y8.k.e(aVar, "request");
            la.a aVar2 = new la.a(i.this.C().f(), aVar.b());
            m.a a10 = aVar.a() != null ? this.f16332g.a().i().a(aVar.a()) : this.f16332g.a().i().c(aVar2);
            o a11 = a10 == null ? null : a10.a();
            la.a d10 = a11 == null ? null : a11.d();
            if (d10 != null && (d10.l() || d10.k())) {
                return null;
            }
            b R = i.this.R(a11);
            if (R instanceof b.a) {
                return ((b.a) R).a();
            }
            if (R instanceof b.c) {
                return null;
            }
            if (!(R instanceof b.C0347b)) {
                throw new l8.l();
            }
            ca.g a12 = aVar.a();
            if (a12 == null) {
                q d11 = this.f16332g.a().d();
                if (a10 != null) {
                    if (!(a10 instanceof m.a.C0155a)) {
                        a10 = null;
                    }
                    m.a.C0155a c0155a = (m.a.C0155a) a10;
                    if (c0155a != null) {
                        b10 = c0155a.b();
                        a12 = d11.b(new q.a(aVar2, b10, null, 4, null));
                    }
                }
                b10 = null;
                a12 = d11.b(new q.a(aVar2, b10, null, 4, null));
            }
            ca.g gVar = a12;
            if ((gVar == null ? null : gVar.J()) != c0.BINARY) {
                la.b f10 = gVar == null ? null : gVar.f();
                if (f10 == null || f10.d() || !y8.k.a(f10.e(), i.this.C().f())) {
                    return null;
                }
                f fVar = new f(this.f16332g, i.this.C(), gVar, null, 8, null);
                this.f16332g.a().e().a(fVar);
                return fVar;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + aVar2 + "\nfindKotlinClass(JavaClass) = " + n.a(this.f16332g.a().i(), gVar) + "\nfindKotlinClass(ClassId) = " + n.b(this.f16332g.a().i(), aVar2) + '\n');
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.a<Set<? extends String>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ y9.g f16333f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ i f16334g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(y9.g gVar, i iVar) {
            super(0);
            this.f16333f = gVar;
            this.f16334g = iVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<String> b() {
            return this.f16333f.a().d().c(this.f16334g.C().f());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(y9.g gVar, u uVar, h hVar) {
        super(gVar);
        y8.k.e(gVar, "c");
        y8.k.e(uVar, "jPackage");
        y8.k.e(hVar, "ownerDescriptor");
        this.f16322n = uVar;
        this.f16323o = hVar;
        this.f16324p = gVar.e().h(new d(gVar, this));
        this.f16325q = gVar.e().c(new c(gVar));
    }

    private final n9.e N(la.e eVar, ca.g gVar) {
        if (!la.g.b(eVar)) {
            return null;
        }
        Set<String> b10 = this.f16324p.b();
        if (gVar != null || b10 == null || b10.contains(eVar.k())) {
            return this.f16325q.h(new a(eVar, gVar));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b R(o oVar) {
        if (oVar != null) {
            if (oVar.a().c() != a.EnumC0166a.CLASS) {
                return b.c.f16330a;
            }
            n9.e m10 = w().a().b().m(oVar);
            if (m10 != null) {
                return new b.a(m10);
            }
        }
        return b.C0347b.f16329a;
    }

    public final n9.e O(ca.g gVar) {
        y8.k.e(gVar, "javaClass");
        return N(gVar.c(), gVar);
    }

    @Override // ua.i, ua.k
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public n9.e g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return N(eVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z9.j
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public h C() {
        return this.f16323o;
    }

    @Override // z9.j, ua.i, ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        List d10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        d10 = m8.q.d();
        return d10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[SYNTHETIC] */
    @Override // z9.j, ua.i, ua.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<n9.m> e(ua.d r5, x8.l<? super la.e, java.lang.Boolean> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "kindFilter"
            y8.k.e(r5, r0)
            java.lang.String r0 = "nameFilter"
            y8.k.e(r6, r0)
            ua.d$a r0 = ua.d.f14505c
            int r1 = r0.d()
            int r0 = r0.f()
            r0 = r0 | r1
            boolean r5 = r5.a(r0)
            if (r5 != 0) goto L20
            java.util.List r5 = m8.o.d()
            goto L65
        L20:
            ab.i r5 = r4.v()
            java.lang.Object r5 = r5.b()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L33:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r5.next()
            r2 = r1
            n9.m r2 = (n9.m) r2
            boolean r3 = r2 instanceof n9.e
            if (r3 == 0) goto L5d
            n9.e r2 = (n9.e) r2
            la.e r2 = r2.c()
            java.lang.String r3 = "it.name"
            y8.k.d(r2, r3)
            java.lang.Object r2 = r6.h(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L5d
            r2 = 1
            goto L5e
        L5d:
            r2 = 0
        L5e:
            if (r2 == 0) goto L33
            r0.add(r1)
            goto L33
        L64:
            r5 = r0
        L65:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.i.e(ua.d, x8.l):java.util.Collection");
    }

    @Override // z9.j
    protected Set<la.e> l(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> b10;
        y8.k.e(dVar, "kindFilter");
        if (!dVar.a(ua.d.f14505c.f())) {
            b10 = r0.b();
            return b10;
        }
        Set<String> b11 = this.f16324p.b();
        if (b11 != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = b11.iterator();
            while (it.hasNext()) {
                hashSet.add(la.e.r((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.f16322n;
        if (lVar == null) {
            lVar = jb.d.a();
        }
        Collection<ca.g> S = uVar.S(lVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ca.g gVar : S) {
            la.e c10 = gVar.J() == c0.SOURCE ? null : gVar.c();
            if (c10 != null) {
                linkedHashSet.add(c10);
            }
        }
        return linkedHashSet;
    }

    @Override // z9.j
    protected Set<la.e> n(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> b10;
        y8.k.e(dVar, "kindFilter");
        b10 = r0.b();
        return b10;
    }

    @Override // z9.j
    protected z9.b p() {
        return b.a.f16255a;
    }

    @Override // z9.j
    protected void r(Collection<u0> collection, la.e eVar) {
        y8.k.e(collection, "result");
        y8.k.e(eVar, "name");
    }

    @Override // z9.j
    protected Set<la.e> t(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> b10;
        y8.k.e(dVar, "kindFilter");
        b10 = r0.b();
        return b10;
    }
}
