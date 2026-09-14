package z9;

import bb.b0;
import bb.c1;
import ca.n;
import ca.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.KProperty;
import m8.k0;
import m8.l0;
import m8.o;
import m8.q;
import m8.y;
import n9.a0;
import n9.a1;
import n9.d1;
import n9.p0;
import n9.s0;
import n9.u0;
import ua.c;
import v9.d0;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public abstract class j extends ua.i {

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16335m = {w.g(new t(w.b(j.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), w.g(new t(w.b(j.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), w.g(new t(w.b(j.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};

    /* renamed from: b, reason: collision with root package name */
    private final y9.g f16336b;

    /* renamed from: c, reason: collision with root package name */
    private final j f16337c;

    /* renamed from: d, reason: collision with root package name */
    private final ab.i<Collection<n9.m>> f16338d;

    /* renamed from: e, reason: collision with root package name */
    private final ab.i<z9.b> f16339e;

    /* renamed from: f, reason: collision with root package name */
    private final ab.g<la.e, Collection<u0>> f16340f;

    /* renamed from: g, reason: collision with root package name */
    private final ab.h<la.e, p0> f16341g;

    /* renamed from: h, reason: collision with root package name */
    private final ab.g<la.e, Collection<u0>> f16342h;

    /* renamed from: i, reason: collision with root package name */
    private final ab.i f16343i;

    /* renamed from: j, reason: collision with root package name */
    private final ab.i f16344j;

    /* renamed from: k, reason: collision with root package name */
    private final ab.i f16345k;

    /* renamed from: l, reason: collision with root package name */
    private final ab.g<la.e, List<p0>> f16346l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f16347a;

        /* renamed from: b, reason: collision with root package name */
        private final b0 f16348b;

        /* renamed from: c, reason: collision with root package name */
        private final List<d1> f16349c;

        /* renamed from: d, reason: collision with root package name */
        private final List<a1> f16350d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f16351e;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f16352f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(b0 b0Var, b0 b0Var2, List<? extends d1> list, List<? extends a1> list2, boolean z10, List<String> list3) {
            y8.k.e(b0Var, "returnType");
            y8.k.e(list, "valueParameters");
            y8.k.e(list2, "typeParameters");
            y8.k.e(list3, "errors");
            this.f16347a = b0Var;
            this.f16348b = b0Var2;
            this.f16349c = list;
            this.f16350d = list2;
            this.f16351e = z10;
            this.f16352f = list3;
        }

        public final List<String> a() {
            return this.f16352f;
        }

        public final boolean b() {
            return this.f16351e;
        }

        public final b0 c() {
            return this.f16348b;
        }

        public final b0 d() {
            return this.f16347a;
        }

        public final List<a1> e() {
            return this.f16350d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return y8.k.a(this.f16347a, aVar.f16347a) && y8.k.a(this.f16348b, aVar.f16348b) && y8.k.a(this.f16349c, aVar.f16349c) && y8.k.a(this.f16350d, aVar.f16350d) && this.f16351e == aVar.f16351e && y8.k.a(this.f16352f, aVar.f16352f);
        }

        public final List<d1> f() {
            return this.f16349c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f16347a.hashCode() * 31;
            b0 b0Var = this.f16348b;
            int hashCode2 = (((((hashCode + (b0Var == null ? 0 : b0Var.hashCode())) * 31) + this.f16349c.hashCode()) * 31) + this.f16350d.hashCode()) * 31;
            boolean z10 = this.f16351e;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return ((hashCode2 + i10) * 31) + this.f16352f.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.f16347a + ", receiverType=" + this.f16348b + ", valueParameters=" + this.f16349c + ", typeParameters=" + this.f16350d + ", hasStableParameterNames=" + this.f16351e + ", errors=" + this.f16352f + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<d1> f16353a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f16354b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends d1> list, boolean z10) {
            y8.k.e(list, "descriptors");
            this.f16353a = list;
            this.f16354b = z10;
        }

        public final List<d1> a() {
            return this.f16353a;
        }

        public final boolean b() {
            return this.f16354b;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<Collection<? extends n9.m>> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<n9.m> b() {
            return j.this.m(ua.d.f14517o, ua.h.f14537a.a());
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.a<Set<? extends la.e>> {
        d() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<la.e> b() {
            return j.this.l(ua.d.f14519q, null);
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.l<la.e, p0> {
        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p0 h(la.e eVar) {
            y8.k.e(eVar, "name");
            if (j.this.B() != null) {
                return (p0) j.this.B().f16341g.h(eVar);
            }
            n f10 = j.this.y().b().f(eVar);
            if (f10 == null || f10.C()) {
                return null;
            }
            return j.this.J(f10);
        }
    }

    /* loaded from: classes.dex */
    static final class f extends y8.l implements x8.l<la.e, Collection<? extends u0>> {
        f() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            y8.k.e(eVar, "name");
            if (j.this.B() != null) {
                return (Collection) j.this.B().f16340f.h(eVar);
            }
            ArrayList arrayList = new ArrayList();
            for (r rVar : j.this.y().b().e(eVar)) {
                x9.f I = j.this.I(rVar);
                if (j.this.G(I)) {
                    j.this.w().a().g().b(rVar, I);
                    arrayList.add(I);
                }
            }
            j.this.o(arrayList, eVar);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    static final class g extends y8.l implements x8.a<z9.b> {
        g() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z9.b b() {
            return j.this.p();
        }
    }

    /* loaded from: classes.dex */
    static final class h extends y8.l implements x8.a<Set<? extends la.e>> {
        h() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<la.e> b() {
            return j.this.n(ua.d.f14520r, null);
        }
    }

    /* loaded from: classes.dex */
    static final class i extends y8.l implements x8.l<la.e, Collection<? extends u0>> {
        i() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            List n02;
            y8.k.e(eVar, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) j.this.f16340f.h(eVar));
            j.this.L(linkedHashSet);
            j.this.r(linkedHashSet, eVar);
            n02 = y.n0(j.this.w().a().q().e(j.this.w(), linkedHashSet));
            return n02;
        }
    }

    /* renamed from: z9.j$j, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0348j extends y8.l implements x8.l<la.e, List<? extends p0>> {
        C0348j() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<p0> h(la.e eVar) {
            List<p0> n02;
            List<p0> n03;
            y8.k.e(eVar, "name");
            ArrayList arrayList = new ArrayList();
            jb.a.a(arrayList, j.this.f16341g.h(eVar));
            j.this.s(eVar, arrayList);
            if (na.d.t(j.this.C())) {
                n03 = y.n0(arrayList);
                return n03;
            }
            n02 = y.n0(j.this.w().a().q().e(j.this.w(), arrayList));
            return n02;
        }
    }

    /* loaded from: classes.dex */
    static final class k extends y8.l implements x8.a<Set<? extends la.e>> {
        k() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<la.e> b() {
            return j.this.t(ua.d.f14521s, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class l extends y8.l implements x8.a<pa.g<?>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f16365g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ p9.b0 f16366h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(n nVar, p9.b0 b0Var) {
            super(0);
            this.f16365g = nVar;
            this.f16366h = b0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final pa.g<?> b() {
            return j.this.w().a().f().a(this.f16365g, this.f16366h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class m extends y8.l implements x8.l<u0, n9.a> {

        /* renamed from: f, reason: collision with root package name */
        public static final m f16367f = new m();

        m() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.a h(u0 u0Var) {
            y8.k.e(u0Var, "<this>");
            return u0Var;
        }
    }

    public j(y9.g gVar, j jVar) {
        List d10;
        y8.k.e(gVar, "c");
        this.f16336b = gVar;
        this.f16337c = jVar;
        ab.n e10 = gVar.e();
        c cVar = new c();
        d10 = q.d();
        this.f16338d = e10.e(cVar, d10);
        this.f16339e = gVar.e().a(new g());
        this.f16340f = gVar.e().i(new f());
        this.f16341g = gVar.e().c(new e());
        this.f16342h = gVar.e().i(new i());
        this.f16343i = gVar.e().a(new h());
        this.f16344j = gVar.e().a(new k());
        this.f16345k = gVar.e().a(new d());
        this.f16346l = gVar.e().i(new C0348j());
    }

    public /* synthetic */ j(y9.g gVar, j jVar, int i10, y8.g gVar2) {
        this(gVar, (i10 & 2) != 0 ? null : jVar);
    }

    private final Set<la.e> A() {
        return (Set) ab.m.a(this.f16343i, this, f16335m[0]);
    }

    private final Set<la.e> D() {
        return (Set) ab.m.a(this.f16344j, this, f16335m[1]);
    }

    private final b0 E(n nVar) {
        boolean z10 = false;
        b0 n10 = this.f16336b.g().n(nVar.b(), aa.d.f(w9.k.COMMON, false, null, 3, null));
        if ((k9.h.y0(n10) || k9.h.C0(n10)) && F(nVar) && nVar.R()) {
            z10 = true;
        }
        if (!z10) {
            return n10;
        }
        b0 n11 = c1.n(n10);
        y8.k.d(n11, "makeNotNullable(propertyType)");
        return n11;
    }

    private final boolean F(n nVar) {
        return nVar.B() && nVar.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p0 J(n nVar) {
        List<? extends a1> d10;
        p9.b0 u10 = u(nVar);
        u10.f1(null, null, null, null);
        b0 E = E(nVar);
        d10 = q.d();
        u10.k1(E, d10, z(), null);
        if (na.d.K(u10, u10.b())) {
            u10.V0(this.f16336b.e().h(new l(nVar, u10)));
        }
        this.f16336b.a().g().a(nVar, u10);
        return u10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(Set<u0> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c10 = ea.t.c((u0) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c10);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c10, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection<? extends u0> a10 = na.k.a(list, m.f16367f);
                set.removeAll(list);
                set.addAll(a10);
            }
        }
    }

    private final p9.b0 u(n nVar) {
        x9.g m12 = x9.g.m1(C(), y9.e.a(this.f16336b, nVar), a0.FINAL, d0.b(nVar.h()), !nVar.B(), nVar.c(), this.f16336b.a().s().a(nVar), F(nVar));
        y8.k.d(m12, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        return m12;
    }

    private final Set<la.e> x() {
        return (Set) ab.m.a(this.f16345k, this, f16335m[2]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final j B() {
        return this.f16337c;
    }

    protected abstract n9.m C();

    protected boolean G(x9.f fVar) {
        y8.k.e(fVar, "<this>");
        return true;
    }

    protected abstract a H(r rVar, List<? extends a1> list, b0 b0Var, List<? extends d1> list2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final x9.f I(r rVar) {
        int n10;
        y8.k.e(rVar, "method");
        x9.f A1 = x9.f.A1(C(), y9.e.a(this.f16336b, rVar), rVar.c(), this.f16336b.a().s().a(rVar), this.f16339e.b().c(rVar.c()) != null && rVar.l().isEmpty());
        y8.k.d(A1, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        y9.g f10 = y9.a.f(this.f16336b, A1, rVar, 0, 4, null);
        List<ca.y> m10 = rVar.m();
        n10 = m8.r.n(m10, 10);
        List<? extends a1> arrayList = new ArrayList<>(n10);
        Iterator<T> it = m10.iterator();
        while (it.hasNext()) {
            a1 a10 = f10.f().a((ca.y) it.next());
            y8.k.b(a10);
            arrayList.add(a10);
        }
        b K = K(f10, A1, rVar.l());
        a H = H(rVar, arrayList, q(rVar, f10), K.a());
        b0 c10 = H.c();
        A1.z1(c10 == null ? null : na.c.f(A1, c10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b()), z(), H.e(), H.f(), H.d(), a0.Companion.a(false, rVar.I(), !rVar.B()), d0.b(rVar.h()), H.c() != null ? k0.e(l8.t.a(x9.f.K, o.H(K.a()))) : l0.h());
        A1.D1(H.b(), K.b());
        if (!H.a().isEmpty()) {
            f10.a().r().a(A1, H.a());
        }
        return A1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final z9.j.b K(y9.g r23, n9.x r24, java.util.List<? extends ca.a0> r25) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.j.K(y9.g, n9.x, java.util.List):z9.j$b");
    }

    @Override // ua.i, ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        List d10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        if (d().contains(eVar)) {
            return this.f16346l.h(eVar);
        }
        d10 = q.d();
        return d10;
    }

    @Override // ua.i, ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        List d10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        if (c().contains(eVar)) {
            return this.f16342h.h(eVar);
        }
        d10 = q.d();
        return d10;
    }

    @Override // ua.i, ua.h
    public Set<la.e> c() {
        return A();
    }

    @Override // ua.i, ua.h
    public Set<la.e> d() {
        return D();
    }

    @Override // ua.i, ua.k
    public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        return this.f16338d.b();
    }

    @Override // ua.i, ua.h
    public Set<la.e> f() {
        return x();
    }

    protected abstract Set<la.e> l(ua.d dVar, x8.l<? super la.e, Boolean> lVar);

    protected final List<n9.m> m(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        List<n9.m> n02;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        u9.d dVar2 = u9.d.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (dVar.a(ua.d.f14505c.d())) {
            for (la.e eVar : l(dVar, lVar)) {
                if (lVar.h(eVar).booleanValue()) {
                    jb.a.a(linkedHashSet, g(eVar, dVar2));
                }
            }
        }
        if (dVar.a(ua.d.f14505c.e()) && !dVar.n().contains(c.a.f14502a)) {
            for (la.e eVar2 : n(dVar, lVar)) {
                if (lVar.h(eVar2).booleanValue()) {
                    linkedHashSet.addAll(b(eVar2, dVar2));
                }
            }
        }
        if (dVar.a(ua.d.f14505c.k()) && !dVar.n().contains(c.a.f14502a)) {
            for (la.e eVar3 : t(dVar, lVar)) {
                if (lVar.h(eVar3).booleanValue()) {
                    linkedHashSet.addAll(a(eVar3, dVar2));
                }
            }
        }
        n02 = y.n0(linkedHashSet);
        return n02;
    }

    protected abstract Set<la.e> n(ua.d dVar, x8.l<? super la.e, Boolean> lVar);

    protected void o(Collection<u0> collection, la.e eVar) {
        y8.k.e(collection, "result");
        y8.k.e(eVar, "name");
    }

    protected abstract z9.b p();

    /* JADX INFO: Access modifiers changed from: protected */
    public final b0 q(r rVar, y9.g gVar) {
        y8.k.e(rVar, "method");
        y8.k.e(gVar, "c");
        return gVar.g().n(rVar.i(), aa.d.f(w9.k.COMMON, rVar.T().E(), null, 2, null));
    }

    protected abstract void r(Collection<u0> collection, la.e eVar);

    protected abstract void s(la.e eVar, Collection<p0> collection);

    protected abstract Set<la.e> t(ua.d dVar, x8.l<? super la.e, Boolean> lVar);

    public String toString() {
        return y8.k.j("Lazy scope for ", C());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ab.i<Collection<n9.m>> v() {
        return this.f16338d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final y9.g w() {
        return this.f16336b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ab.i<z9.b> y() {
        return this.f16339e;
    }

    protected abstract s0 z();
}
