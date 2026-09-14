package z9;

import bb.b0;
import ca.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jb.b;
import l8.w;
import lb.n;
import m8.o;
import m8.p;
import m8.r;
import m8.r0;
import m8.v;
import m8.y;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: n, reason: collision with root package name */
    private final ca.g f16368n;

    /* renamed from: o, reason: collision with root package name */
    private final f f16369o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<q, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f16370f = new a();

        a() {
            super(1);
        }

        public final boolean a(q qVar) {
            y8.k.e(qVar, "it");
            return qVar.Y();
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(q qVar) {
            return Boolean.valueOf(a(qVar));
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<ua.h, Collection<? extends p0>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ la.e f16371f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(la.e eVar) {
            super(1);
            this.f16371f = eVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<? extends p0> h(ua.h hVar) {
            y8.k.e(hVar, "it");
            return hVar.a(this.f16371f, u9.d.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<ua.h, Collection<? extends la.e>> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f16372f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<la.e> h(ua.h hVar) {
            y8.k.e(hVar, "it");
            return hVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d implements b.c<n9.e> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f16373a = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends y8.l implements x8.l<b0, n9.e> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f16374f = new a();

            a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final n9.e h(b0 b0Var) {
                n9.h o10 = b0Var.W0().o();
                if (o10 instanceof n9.e) {
                    return (n9.e) o10;
                }
                return null;
            }
        }

        d() {
        }

        @Override // jb.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<n9.e> a(n9.e eVar) {
            lb.h A;
            lb.h r10;
            Iterable<n9.e> i10;
            Collection<b0> x10 = eVar.o().x();
            y8.k.d(x10, "it.typeConstructor.supertypes");
            A = y.A(x10);
            r10 = n.r(A, a.f16374f);
            i10 = n.i(r10);
            return i10;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends b.AbstractC0222b<n9.e, w> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n9.e f16375a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<R> f16376b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ x8.l<ua.h, Collection<R>> f16377c;

        /* JADX WARN: Multi-variable type inference failed */
        e(n9.e eVar, Set<R> set, x8.l<? super ua.h, ? extends Collection<? extends R>> lVar) {
            this.f16375a = eVar;
            this.f16376b = set;
            this.f16377c = lVar;
        }

        @Override // jb.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return w.f11824a;
        }

        @Override // jb.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(n9.e eVar) {
            y8.k.e(eVar, "current");
            if (eVar == this.f16375a) {
                return true;
            }
            ua.h x02 = eVar.x0();
            y8.k.d(x02, "current.staticScope");
            if (!(x02 instanceof l)) {
                return true;
            }
            this.f16376b.addAll((Collection) this.f16377c.h(x02));
            return false;
        }

        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(y9.g gVar, ca.g gVar2, f fVar) {
        super(gVar);
        y8.k.e(gVar, "c");
        y8.k.e(gVar2, "jClass");
        y8.k.e(fVar, "ownerDescriptor");
        this.f16368n = gVar2;
        this.f16369o = fVar;
    }

    private final <R> Set<R> N(n9.e eVar, Set<R> set, x8.l<? super ua.h, ? extends Collection<? extends R>> lVar) {
        List b10;
        b10 = p.b(eVar);
        jb.b.b(b10, d.f16373a, new e(eVar, set, lVar));
        return set;
    }

    private final p0 P(p0 p0Var) {
        int n10;
        List C;
        if (p0Var.r().isReal()) {
            return p0Var;
        }
        Collection<? extends p0> g10 = p0Var.g();
        y8.k.d(g10, "this.overriddenDescriptors");
        n10 = r.n(g10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (p0 p0Var2 : g10) {
            y8.k.d(p0Var2, "it");
            arrayList.add(P(p0Var2));
        }
        C = y.C(arrayList);
        return (p0) o.d0(C);
    }

    private final Set<u0> Q(la.e eVar, n9.e eVar2) {
        Set<u0> r02;
        Set<u0> b10;
        k c10 = x9.k.c(eVar2);
        if (c10 == null) {
            b10 = r0.b();
            return b10;
        }
        r02 = y.r0(c10.b(eVar, u9.d.WHEN_GET_SUPER_MEMBERS));
        return r02;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z9.j
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public z9.a p() {
        return new z9.a(this.f16368n, a.f16370f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z9.j
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public f C() {
        return this.f16369o;
    }

    @Override // ua.i, ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return null;
    }

    @Override // z9.j
    protected Set<la.e> l(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> b10;
        y8.k.e(dVar, "kindFilter");
        b10 = r0.b();
        return b10;
    }

    @Override // z9.j
    protected Set<la.e> n(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> q02;
        List g10;
        y8.k.e(dVar, "kindFilter");
        q02 = y.q0(y().b().a());
        k c10 = x9.k.c(C());
        Set<la.e> c11 = c10 == null ? null : c10.c();
        if (c11 == null) {
            c11 = r0.b();
        }
        q02.addAll(c11);
        if (this.f16368n.s()) {
            g10 = m8.q.g(k9.k.f11237c, k9.k.f11236b);
            q02.addAll(g10);
        }
        return q02;
    }

    @Override // z9.j
    protected void r(Collection<u0> collection, la.e eVar) {
        u0 e10;
        String str;
        y8.k.e(collection, "result");
        y8.k.e(eVar, "name");
        Collection<? extends u0> e11 = w9.a.e(eVar, Q(eVar, C()), collection, C(), w().a().c(), w().a().j().a());
        y8.k.d(e11, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(e11);
        if (this.f16368n.s()) {
            if (y8.k.a(eVar, k9.k.f11237c)) {
                e10 = na.c.d(C());
                str = "createEnumValueOfMethod(ownerDescriptor)";
            } else {
                if (!y8.k.a(eVar, k9.k.f11236b)) {
                    return;
                }
                e10 = na.c.e(C());
                str = "createEnumValuesMethod(ownerDescriptor)";
            }
            y8.k.d(e10, str);
            collection.add(e10);
        }
    }

    @Override // z9.l, z9.j
    protected void s(la.e eVar, Collection<p0> collection) {
        y8.k.e(eVar, "name");
        y8.k.e(collection, "result");
        Set N = N(C(), new LinkedHashSet(), new b(eVar));
        if (!collection.isEmpty()) {
            Collection<? extends p0> e10 = w9.a.e(eVar, N, collection, C(), w().a().c(), w().a().j().a());
            y8.k.d(e10, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(e10);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : N) {
            p0 P = P((p0) obj);
            Object obj2 = linkedHashMap.get(P);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(P, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection e11 = w9.a.e(eVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, C(), w().a().c(), w().a().j().a());
            y8.k.d(e11, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            v.r(arrayList, e11);
        }
        collection.addAll(arrayList);
    }

    @Override // z9.j
    protected Set<la.e> t(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> q02;
        y8.k.e(dVar, "kindFilter");
        q02 = y.q0(y().b().d());
        N(C(), q02, c.f16372f);
        return q02;
    }
}
