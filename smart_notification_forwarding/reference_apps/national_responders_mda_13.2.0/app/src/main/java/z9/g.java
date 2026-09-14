package z9;

import bb.c1;
import ca.n;
import ca.q;
import ea.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jb.j;
import m8.k0;
import m8.o;
import m8.p;
import m8.r;
import m8.s0;
import m8.y;
import n9.a0;
import n9.a1;
import n9.d1;
import n9.p0;
import n9.q0;
import n9.u;
import n9.u0;
import n9.x;
import na.j;
import p9.c0;
import v9.b0;
import v9.d0;
import v9.q;
import v9.v;
import w9.j;
import y8.w;
import z9.j;

/* loaded from: classes.dex */
public final class g extends z9.j {

    /* renamed from: n, reason: collision with root package name */
    private final n9.e f16292n;

    /* renamed from: o, reason: collision with root package name */
    private final ca.g f16293o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f16294p;

    /* renamed from: q, reason: collision with root package name */
    private final ab.i<List<n9.d>> f16295q;

    /* renamed from: r, reason: collision with root package name */
    private final ab.i<Set<la.e>> f16296r;

    /* renamed from: s, reason: collision with root package name */
    private final ab.i<Map<la.e, n>> f16297s;

    /* renamed from: t, reason: collision with root package name */
    private final ab.h<la.e, p9.g> f16298t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<q, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f16299f = new a();

        a() {
            super(1);
        }

        public final boolean a(q qVar) {
            y8.k.e(qVar, "it");
            return !qVar.Y();
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(q qVar) {
            return Boolean.valueOf(a(qVar));
        }
    }

    /* loaded from: classes.dex */
    /* synthetic */ class b extends y8.i implements x8.l<la.e, Collection<? extends u0>> {
        b(g gVar) {
            super(1, gVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // y8.c
        public final e9.d k() {
            return w.b(g.class);
        }

        @Override // y8.c
        public final String m() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            y8.k.e(eVar, "p0");
            return ((g) this.f15934g).I0(eVar);
        }
    }

    /* loaded from: classes.dex */
    /* synthetic */ class c extends y8.i implements x8.l<la.e, Collection<? extends u0>> {
        c(g gVar) {
            super(1, gVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // y8.c
        public final e9.d k() {
            return w.b(g.class);
        }

        @Override // y8.c
        public final String m() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            y8.k.e(eVar, "p0");
            return ((g) this.f15934g).J0(eVar);
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<la.e, Collection<? extends u0>> {
        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            y8.k.e(eVar, "it");
            return g.this.I0(eVar);
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements x8.l<la.e, Collection<? extends u0>> {
        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            y8.k.e(eVar, "it");
            return g.this.J0(eVar);
        }
    }

    /* loaded from: classes.dex */
    static final class f extends y8.l implements x8.a<List<? extends n9.d>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ y9.g f16303g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(y9.g gVar) {
            super(0);
            this.f16303g = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<n9.d> b() {
            List<n9.d> n02;
            ?? h10;
            Collection<ca.k> q10 = g.this.f16293o.q();
            ArrayList arrayList = new ArrayList(q10.size());
            Iterator<ca.k> it = q10.iterator();
            while (it.hasNext()) {
                arrayList.add(g.this.G0(it.next()));
            }
            if (g.this.f16293o.L()) {
                n9.d e02 = g.this.e0();
                boolean z10 = false;
                String c10 = t.c(e02, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (y8.k.a(t.c((n9.d) it2.next(), false, false, 2, null), c10)) {
                            break;
                        }
                    }
                }
                z10 = true;
                if (z10) {
                    arrayList.add(e02);
                    this.f16303g.a().g().c(g.this.f16293o, e02);
                }
            }
            da.l q11 = this.f16303g.a().q();
            y9.g gVar = this.f16303g;
            g gVar2 = g.this;
            boolean isEmpty = arrayList.isEmpty();
            ArrayList arrayList2 = arrayList;
            if (isEmpty) {
                h10 = m8.q.h(gVar2.d0());
                arrayList2 = h10;
            }
            n02 = y.n0(q11.e(gVar, arrayList2));
            return n02;
        }
    }

    /* renamed from: z9.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0346g extends y8.l implements x8.a<Map<la.e, ? extends n>> {
        C0346g() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<la.e, n> b() {
            int n10;
            int d10;
            int a10;
            Collection<n> w10 = g.this.f16293o.w();
            ArrayList arrayList = new ArrayList();
            for (Object obj : w10) {
                if (((n) obj).C()) {
                    arrayList.add(obj);
                }
            }
            n10 = r.n(arrayList, 10);
            d10 = k0.d(n10);
            a10 = d9.f.a(d10, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((n) obj2).c(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class h extends y8.l implements x8.l<la.e, Collection<? extends u0>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ u0 f16305f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f16306g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(u0 u0Var, g gVar) {
            super(1);
            this.f16305f = u0Var;
            this.f16306g = gVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<u0> h(la.e eVar) {
            List a02;
            List b10;
            y8.k.e(eVar, "accessorName");
            if (y8.k.a(this.f16305f.c(), eVar)) {
                b10 = p.b(this.f16305f);
                return b10;
            }
            a02 = y.a0(this.f16306g.I0(eVar), this.f16306g.J0(eVar));
            return a02;
        }
    }

    /* loaded from: classes.dex */
    static final class i extends y8.l implements x8.a<Set<? extends la.e>> {
        i() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<la.e> b() {
            Set<la.e> r02;
            r02 = y.r0(g.this.f16293o.M());
            return r02;
        }
    }

    /* loaded from: classes.dex */
    static final class j extends y8.l implements x8.l<la.e, p9.g> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ y9.g f16309g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends y8.l implements x8.a<Set<? extends la.e>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f16310f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.f16310f = gVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<la.e> b() {
                Set<la.e> g10;
                g10 = s0.g(this.f16310f.c(), this.f16310f.d());
                return g10;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(y9.g gVar) {
            super(1);
            this.f16309g = gVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p9.g h(la.e eVar) {
            y8.k.e(eVar, "name");
            if (!((Set) g.this.f16296r.b()).contains(eVar)) {
                n nVar = (n) ((Map) g.this.f16297s.b()).get(eVar);
                if (nVar == null) {
                    return null;
                }
                return p9.n.W0(this.f16309g.e(), g.this.C(), eVar, this.f16309g.e().a(new a(g.this)), y9.e.a(this.f16309g, nVar), this.f16309g.a().s().a(nVar));
            }
            v9.q d10 = this.f16309g.a().d();
            la.a h10 = ra.a.h(g.this.C());
            y8.k.b(h10);
            la.a d11 = h10.d(eVar);
            y8.k.d(d11, "ownerDescriptor.classId!!.createNestedClassId(name)");
            ca.g b10 = d10.b(new q.a(d11, null, g.this.f16293o, 2, null));
            if (b10 == null) {
                return null;
            }
            y9.g gVar = this.f16309g;
            z9.f fVar = new z9.f(gVar, g.this.C(), b10, null, 8, null);
            gVar.a().e().a(fVar);
            return fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(y9.g gVar, n9.e eVar, ca.g gVar2, boolean z10, g gVar3) {
        super(gVar, gVar3);
        y8.k.e(gVar, "c");
        y8.k.e(eVar, "ownerDescriptor");
        y8.k.e(gVar2, "jClass");
        this.f16292n = eVar;
        this.f16293o = gVar2;
        this.f16294p = z10;
        this.f16295q = gVar.e().a(new f(gVar));
        this.f16296r = gVar.e().a(new i());
        this.f16297s = gVar.e().a(new C0346g());
        this.f16298t = gVar.e().c(new j(gVar));
    }

    public /* synthetic */ g(y9.g gVar, n9.e eVar, ca.g gVar2, boolean z10, g gVar3, int i10, y8.g gVar4) {
        this(gVar, eVar, gVar2, z10, (i10 & 16) != 0 ? null : gVar3);
    }

    private final boolean A0(u0 u0Var, x xVar) {
        String c10 = t.c(u0Var, false, false, 2, null);
        x a10 = xVar.a();
        y8.k.d(a10, "builtinWithErasedParameters.original");
        return y8.k.a(c10, t.c(a10, false, false, 2, null)) && !o0(u0Var, xVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        if (v9.x.c(r4) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:1: B:31:0x003f->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean B0(n9.u0 r7) {
        /*
            r6 = this;
            la.e r0 = r7.c()
            java.lang.String r1 = "function.name"
            y8.k.d(r0, r1)
            java.util.List r0 = v9.a0.a(r0)
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1b
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L1b
        L19:
            r0 = 0
            goto L7a
        L1b:
            java.util.Iterator r0 = r0.iterator()
        L1f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L19
            java.lang.Object r1 = r0.next()
            la.e r1 = (la.e) r1
            java.util.Set r1 = r6.z0(r1)
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L3b
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L3b
        L39:
            r1 = 0
            goto L77
        L3b:
            java.util.Iterator r1 = r1.iterator()
        L3f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L39
            java.lang.Object r4 = r1.next()
            n9.p0 r4 = (n9.p0) r4
            z9.g$h r5 = new z9.g$h
            r5.<init>(r7, r6)
            boolean r5 = r6.n0(r4, r5)
            if (r5 == 0) goto L73
            boolean r4 = r4.P()
            if (r4 != 0) goto L71
            v9.x r4 = v9.x.f14811a
            la.e r4 = r7.c()
            java.lang.String r4 = r4.k()
            java.lang.String r5 = "function.name.asString()"
            y8.k.d(r4, r5)
            boolean r4 = v9.x.c(r4)
            if (r4 != 0) goto L73
        L71:
            r4 = 1
            goto L74
        L73:
            r4 = 0
        L74:
            if (r4 == 0) goto L3f
            r1 = 1
        L77:
            if (r1 == 0) goto L1f
            r0 = 1
        L7a:
            if (r0 == 0) goto L7d
            return r3
        L7d:
            boolean r0 = r6.p0(r7)
            if (r0 != 0) goto L90
            boolean r0 = r6.K0(r7)
            if (r0 != 0) goto L90
            boolean r7 = r6.r0(r7)
            if (r7 != 0) goto L90
            goto L91
        L90:
            r2 = 0
        L91:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.g.B0(n9.u0):boolean");
    }

    private final u0 C0(u0 u0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar, Collection<? extends u0> collection) {
        u0 g02;
        v9.f fVar = v9.f.f14781m;
        x k10 = v9.f.k(u0Var);
        if (k10 == null || (g02 = g0(k10, lVar)) == null) {
            return null;
        }
        if (!B0(g02)) {
            g02 = null;
        }
        if (g02 == null) {
            return null;
        }
        return f0(g02, k10, collection);
    }

    private final u0 D0(u0 u0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar, la.e eVar, Collection<? extends u0> collection) {
        u0 u0Var2 = (u0) b0.d(u0Var);
        if (u0Var2 == null) {
            return null;
        }
        String b10 = b0.b(u0Var2);
        y8.k.b(b10);
        la.e r10 = la.e.r(b10);
        y8.k.d(r10, "identifier(nameInJava)");
        Iterator<? extends u0> it = lVar.h(r10).iterator();
        while (it.hasNext()) {
            u0 l02 = l0(it.next(), eVar);
            if (q0(u0Var2, l02)) {
                return f0(l02, u0Var2, collection);
            }
        }
        return null;
    }

    private final u0 E0(u0 u0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        if (!u0Var.q0()) {
            return null;
        }
        la.e c10 = u0Var.c();
        y8.k.d(c10, "descriptor.name");
        Iterator<T> it = lVar.h(c10).iterator();
        while (it.hasNext()) {
            u0 m02 = m0((u0) it.next());
            if (m02 == null || !o0(m02, u0Var)) {
                m02 = null;
            }
            if (m02 != null) {
                return m02;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x9.c G0(ca.k kVar) {
        int n10;
        List<a1> a02;
        n9.e C = C();
        x9.c D1 = x9.c.D1(C, y9.e.a(w(), kVar), false, w().a().s().a(kVar));
        y8.k.d(D1, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        y9.g e10 = y9.a.e(w(), D1, kVar, C.B().size());
        j.b K = K(e10, D1, kVar.l());
        List<a1> B = C.B();
        y8.k.d(B, "classDescriptor.declaredTypeParameters");
        List<ca.y> m10 = kVar.m();
        n10 = r.n(m10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = m10.iterator();
        while (it.hasNext()) {
            a1 a10 = e10.f().a((ca.y) it.next());
            y8.k.b(a10);
            arrayList.add(a10);
        }
        a02 = y.a0(B, arrayList);
        D1.B1(K.a(), d0.b(kVar.h()), a02);
        D1.j1(false);
        D1.k1(K.b());
        D1.r1(C.s());
        e10.a().g().c(kVar, D1);
        return D1;
    }

    private final x9.f H0(ca.w wVar) {
        List<? extends a1> d10;
        List<d1> d11;
        x9.f A1 = x9.f.A1(C(), y9.e.a(w(), wVar), wVar.c(), w().a().s().a(wVar), true);
        y8.k.d(A1, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
        bb.b0 n10 = w().g().n(wVar.b(), aa.d.f(w9.k.COMMON, false, null, 2, null));
        n9.s0 z10 = z();
        d10 = m8.q.d();
        d11 = m8.q.d();
        A1.z1(null, z10, d10, d11, n10, a0.Companion.a(false, false, true), n9.t.f12303e, null);
        A1.D1(false, false);
        w().a().g().b(wVar, A1);
        return A1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<u0> I0(la.e eVar) {
        int n10;
        Collection<ca.r> e10 = y().b().e(eVar);
        n10 = r.n(e10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = e10.iterator();
        while (it.hasNext()) {
            arrayList.add(I((ca.r) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection<n9.u0> J0(la.e r5) {
        /*
            r4 = this;
            java.util.Set r5 = r4.x0(r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        Ld:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L32
            java.lang.Object r1 = r5.next()
            r2 = r1
            n9.u0 r2 = (n9.u0) r2
            boolean r3 = v9.b0.a(r2)
            if (r3 != 0) goto L2b
            v9.f r3 = v9.f.f14781m
            n9.x r2 = v9.f.k(r2)
            if (r2 == 0) goto L29
            goto L2b
        L29:
            r2 = 0
            goto L2c
        L2b:
            r2 = 1
        L2c:
            if (r2 != 0) goto Ld
            r0.add(r1)
            goto Ld
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.g.J0(la.e):java.util.Collection");
    }

    private final boolean K0(u0 u0Var) {
        v9.f fVar = v9.f.f14781m;
        la.e c10 = u0Var.c();
        y8.k.d(c10, "name");
        if (!fVar.l(c10)) {
            return false;
        }
        la.e c11 = u0Var.c();
        y8.k.d(c11, "name");
        Set<u0> x02 = x0(c11);
        ArrayList arrayList = new ArrayList();
        for (u0 u0Var2 : x02) {
            v9.f fVar2 = v9.f.f14781m;
            x k10 = v9.f.k(u0Var2);
            if (k10 != null) {
                arrayList.add(k10);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (A0(u0Var, (x) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final void U(List<d1> list, n9.l lVar, int i10, ca.r rVar, bb.b0 b0Var, bb.b0 b0Var2) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        la.e c10 = rVar.c();
        bb.b0 n10 = c1.n(b0Var);
        y8.k.d(n10, "makeNotNullable(returnType)");
        list.add(new p9.k0(lVar, null, i10, b10, c10, n10, rVar.N(), false, false, b0Var2 == null ? null : c1.n(b0Var2), w().a().s().a(rVar)));
    }

    private final void V(Collection<u0> collection, la.e eVar, Collection<? extends u0> collection2, boolean z10) {
        List a02;
        int n10;
        Collection<? extends u0> d10 = w9.a.d(eVar, collection2, collection, C(), w().a().c(), w().a().j().a());
        y8.k.d(d10, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z10) {
            collection.addAll(d10);
            return;
        }
        a02 = y.a0(collection, d10);
        n10 = r.n(d10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (u0 u0Var : d10) {
            u0 u0Var2 = (u0) b0.e(u0Var);
            y8.k.d(u0Var, "resolvedOverride");
            if (u0Var2 != null) {
                u0Var = f0(u0Var, u0Var2, a02);
            }
            arrayList.add(u0Var);
        }
        collection.addAll(arrayList);
    }

    private final void W(la.e eVar, Collection<? extends u0> collection, Collection<? extends u0> collection2, Collection<u0> collection3, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        for (u0 u0Var : collection2) {
            jb.a.a(collection3, D0(u0Var, lVar, eVar, collection));
            jb.a.a(collection3, C0(u0Var, lVar, collection));
            jb.a.a(collection3, E0(u0Var, lVar));
        }
    }

    private final void X(Set<? extends p0> set, Collection<p0> collection, Set<p0> set2, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        for (p0 p0Var : set) {
            x9.g h02 = h0(p0Var, lVar);
            if (h02 != null) {
                collection.add(h02);
                if (set2 == null) {
                    return;
                }
                set2.add(p0Var);
                return;
            }
        }
    }

    private final void Y(la.e eVar, Collection<p0> collection) {
        ca.r rVar = (ca.r) o.e0(y().b().e(eVar));
        if (rVar == null) {
            return;
        }
        collection.add(j0(this, rVar, null, a0.FINAL, 2, null));
    }

    private final Collection<bb.b0> b0() {
        if (!this.f16294p) {
            return w().a().j().d().f(C());
        }
        Collection<bb.b0> x10 = C().o().x();
        y8.k.d(x10, "ownerDescriptor.typeConstructor.supertypes");
        return x10;
    }

    private final List<d1> c0(p9.f fVar) {
        l8.n nVar;
        Collection<ca.r> O = this.f16293o.O();
        ArrayList arrayList = new ArrayList(O.size());
        aa.a f10 = aa.d.f(w9.k.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : O) {
            if (y8.k.a(((ca.r) obj).c(), v9.y.f14814b)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        l8.n nVar2 = new l8.n(arrayList2, arrayList3);
        List list = (List) nVar2.a();
        List<ca.r> list2 = (List) nVar2.b();
        list.size();
        ca.r rVar = (ca.r) o.J(list);
        if (rVar != null) {
            ca.x i10 = rVar.i();
            if (i10 instanceof ca.f) {
                ca.f fVar2 = (ca.f) i10;
                nVar = new l8.n(w().g().j(fVar2, f10, true), w().g().n(fVar2.p(), f10));
            } else {
                nVar = new l8.n(w().g().n(i10, f10), null);
            }
            U(arrayList, fVar, 0, rVar, (bb.b0) nVar.a(), (bb.b0) nVar.b());
        }
        int i11 = 0;
        int i12 = rVar == null ? 0 : 1;
        for (ca.r rVar2 : list2) {
            U(arrayList, fVar, i11 + i12, rVar2, w().g().n(rVar2.i(), f10), null);
            i11++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.d d0() {
        boolean E = this.f16293o.E();
        if ((this.f16293o.H() || !this.f16293o.P()) && !E) {
            return null;
        }
        n9.e C = C();
        x9.c D1 = x9.c.D1(C, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), true, w().a().s().a(this.f16293o));
        y8.k.d(D1, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        List<d1> c02 = E ? c0(D1) : Collections.emptyList();
        D1.k1(false);
        D1.A1(c02, v0(C));
        D1.j1(true);
        D1.r1(C.s());
        w().a().g().c(this.f16293o, D1);
        return D1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.d e0() {
        n9.e C = C();
        x9.c D1 = x9.c.D1(C, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), true, w().a().s().a(this.f16293o));
        y8.k.d(D1, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        List<d1> k02 = k0(D1);
        D1.k1(false);
        D1.A1(k02, v0(C));
        D1.j1(false);
        D1.r1(C.s());
        return D1;
    }

    private final u0 f0(u0 u0Var, n9.a aVar, Collection<? extends u0> collection) {
        boolean z10 = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (u0 u0Var2 : collection) {
                if (!y8.k.a(u0Var, u0Var2) && u0Var2.H() == null && o0(u0Var2, aVar)) {
                    break;
                }
            }
        }
        z10 = true;
        if (z10) {
            return u0Var;
        }
        u0 c10 = u0Var.y().m().c();
        y8.k.b(c10);
        return c10;
    }

    private final u0 g0(x xVar, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        Object obj;
        int n10;
        la.e c10 = xVar.c();
        y8.k.d(c10, "overridden.name");
        Iterator<T> it = lVar.h(c10).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (A0((u0) obj, xVar)) {
                break;
            }
        }
        u0 u0Var = (u0) obj;
        if (u0Var == null) {
            return null;
        }
        x.a<? extends u0> y10 = u0Var.y();
        List<d1> l10 = xVar.l();
        y8.k.d(l10, "overridden.valueParameters");
        n10 = r.n(l10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (d1 d1Var : l10) {
            bb.b0 b10 = d1Var.b();
            y8.k.d(b10, "it.type");
            arrayList.add(new x9.l(b10, d1Var.k0()));
        }
        List<d1> l11 = u0Var.l();
        y8.k.d(l11, "override.valueParameters");
        y10.f(x9.k.a(arrayList, l11, xVar));
        y10.t();
        y10.n();
        return y10.c();
    }

    private final x9.g h0(p0 p0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        u0 u0Var;
        List<? extends a1> d10;
        p9.d0 d0Var = null;
        if (!n0(p0Var, lVar)) {
            return null;
        }
        u0 t02 = t0(p0Var, lVar);
        y8.k.b(t02);
        if (p0Var.P()) {
            u0Var = u0(p0Var, lVar);
            y8.k.b(u0Var);
        } else {
            u0Var = null;
        }
        if (u0Var != null) {
            u0Var.p();
            t02.p();
        }
        x9.e eVar = new x9.e(C(), t02, u0Var, p0Var);
        bb.b0 i10 = t02.i();
        y8.k.b(i10);
        d10 = m8.q.d();
        eVar.k1(i10, d10, z(), null);
        c0 h10 = na.c.h(eVar, t02.u(), false, false, false, t02.k());
        h10.Y0(t02);
        h10.b1(eVar.b());
        y8.k.d(h10, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
        if (u0Var != null) {
            List<d1> l10 = u0Var.l();
            y8.k.d(l10, "setterMethod.valueParameters");
            d1 d1Var = (d1) o.J(l10);
            if (d1Var == null) {
                throw new AssertionError(y8.k.j("No parameter found for ", u0Var));
            }
            d0Var = na.c.j(eVar, u0Var.u(), d1Var.u(), false, false, false, u0Var.h(), u0Var.k());
            d0Var.Y0(u0Var);
        }
        eVar.e1(h10, d0Var);
        return eVar;
    }

    private final x9.g i0(ca.r rVar, bb.b0 b0Var, a0 a0Var) {
        List<? extends a1> d10;
        x9.g m12 = x9.g.m1(C(), y9.e.a(w(), rVar), a0Var, d0.b(rVar.h()), false, rVar.c(), w().a().s().a(rVar), false);
        y8.k.d(m12, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
        c0 b10 = na.c.b(m12, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b());
        y8.k.d(b10, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
        m12.e1(b10, null);
        bb.b0 q10 = b0Var == null ? q(rVar, y9.a.f(w(), m12, rVar, 0, 4, null)) : b0Var;
        d10 = m8.q.d();
        m12.k1(q10, d10, z(), null);
        b10.b1(q10);
        return m12;
    }

    static /* synthetic */ x9.g j0(g gVar, ca.r rVar, bb.b0 b0Var, a0 a0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            b0Var = null;
        }
        return gVar.i0(rVar, b0Var, a0Var);
    }

    private final List<d1> k0(p9.f fVar) {
        Collection<ca.w> t10 = this.f16293o.t();
        ArrayList arrayList = new ArrayList(t10.size());
        bb.b0 b0Var = null;
        aa.a f10 = aa.d.f(w9.k.COMMON, false, null, 2, null);
        int i10 = 0;
        for (ca.w wVar : t10) {
            int i11 = i10 + 1;
            bb.b0 n10 = w().g().n(wVar.b(), f10);
            arrayList.add(new p9.k0(fVar, null, i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), wVar.c(), n10, false, false, false, wVar.g() ? w().a().l().w().k(n10) : b0Var, w().a().s().a(wVar)));
            i10 = i11;
            b0Var = null;
        }
        return arrayList;
    }

    private final u0 l0(u0 u0Var, la.e eVar) {
        x.a<? extends u0> y10 = u0Var.y();
        y10.j(eVar);
        y10.t();
        y10.n();
        u0 c10 = y10.c();
        y8.k.b(c10);
        return c10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        if (k9.l.a(r3, w().a().p().c()) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final n9.u0 m0(n9.u0 r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.l()
            java.lang.String r1 = "valueParameters"
            y8.k.d(r0, r1)
            java.lang.Object r0 = m8.o.U(r0)
            n9.d1 r0 = (n9.d1) r0
            r2 = 0
            if (r0 != 0) goto L14
        L12:
            r0 = r2
            goto L51
        L14:
            bb.b0 r3 = r0.b()
            bb.t0 r3 = r3.W0()
            n9.h r3 = r3.o()
            if (r3 != 0) goto L24
            r3 = r2
            goto L28
        L24:
            la.c r3 = ra.a.j(r3)
        L28:
            if (r3 != 0) goto L2c
        L2a:
            r3 = r2
            goto L3b
        L2c:
            boolean r4 = r3.f()
            if (r4 == 0) goto L33
            goto L34
        L33:
            r3 = r2
        L34:
            if (r3 != 0) goto L37
            goto L2a
        L37:
            la.b r3 = r3.l()
        L3b:
            y9.g r4 = r5.w()
            y9.b r4 = r4.a()
            y9.c r4 = r4.p()
            boolean r4 = r4.c()
            boolean r3 = k9.l.a(r3, r4)
            if (r3 == 0) goto L12
        L51:
            if (r0 != 0) goto L54
            return r2
        L54:
            n9.x$a r2 = r6.y()
            java.util.List r6 = r6.l()
            y8.k.d(r6, r1)
            r1 = 1
            java.util.List r6 = m8.o.E(r6, r1)
            n9.x$a r6 = r2.f(r6)
            bb.b0 r0 = r0.b()
            java.util.List r0 = r0.V0()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            bb.v0 r0 = (bb.v0) r0
            bb.b0 r0 = r0.b()
            n9.x$a r6 = r6.k(r0)
            n9.x r6 = r6.c()
            n9.u0 r6 = (n9.u0) r6
            r0 = r6
            p9.f0 r0 = (p9.f0) r0
            if (r0 != 0) goto L8b
            goto L8e
        L8b:
            r0.s1(r1)
        L8e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.g.m0(n9.u0):n9.u0");
    }

    private final boolean n0(p0 p0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        if (z9.c.a(p0Var)) {
            return false;
        }
        u0 t02 = t0(p0Var, lVar);
        u0 u02 = u0(p0Var, lVar);
        if (t02 == null) {
            return false;
        }
        if (p0Var.P()) {
            return u02 != null && u02.p() == t02.p();
        }
        return true;
    }

    private final boolean o0(n9.a aVar, n9.a aVar2) {
        j.i.a c10 = na.j.f12341d.I(aVar2, aVar, true).c();
        y8.k.d(c10, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        return c10 == j.i.a.OVERRIDABLE && !v.f14809a.a(aVar2, aVar);
    }

    private final boolean p0(u0 u0Var) {
        boolean z10;
        v9.e eVar = v9.e.f14779m;
        la.e c10 = u0Var.c();
        y8.k.d(c10, "name");
        List<la.e> i10 = eVar.i(c10);
        if (!(i10 instanceof Collection) || !i10.isEmpty()) {
            for (la.e eVar2 : i10) {
                Set<u0> x02 = x0(eVar2);
                ArrayList arrayList = new ArrayList();
                for (Object obj : x02) {
                    if (b0.a((u0) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    u0 l02 = l0(u0Var, eVar2);
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (q0((u0) it.next(), l02)) {
                                z10 = true;
                                break;
                            }
                        }
                    }
                }
                z10 = false;
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean q0(u0 u0Var, x xVar) {
        if (v9.e.f14779m.m(u0Var)) {
            xVar = xVar.a();
        }
        y8.k.d(xVar, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return o0(xVar, u0Var);
    }

    private final boolean r0(u0 u0Var) {
        u0 m02 = m0(u0Var);
        if (m02 == null) {
            return false;
        }
        la.e c10 = u0Var.c();
        y8.k.d(c10, "name");
        Set<u0> x02 = x0(c10);
        if ((x02 instanceof Collection) && x02.isEmpty()) {
            return false;
        }
        for (u0 u0Var2 : x02) {
            if (u0Var2.q0() && o0(m02, u0Var2)) {
                return true;
            }
        }
        return false;
    }

    private final u0 s0(p0 p0Var, String str, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        u0 u0Var;
        la.e r10 = la.e.r(str);
        y8.k.d(r10, "identifier(getterName)");
        Iterator<T> it = lVar.h(r10).iterator();
        do {
            u0Var = null;
            if (!it.hasNext()) {
                break;
            }
            u0 u0Var2 = (u0) it.next();
            if (u0Var2.l().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.f fVar = kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a;
                bb.b0 i10 = u0Var2.i();
                if (i10 == null ? false : fVar.b(i10, p0Var.b())) {
                    u0Var = u0Var2;
                }
            }
        } while (u0Var == null);
        return u0Var;
    }

    private final u0 t0(p0 p0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        q0 t10 = p0Var.t();
        q0 q0Var = t10 == null ? null : (q0) b0.d(t10);
        String a10 = q0Var != null ? v9.i.f14789a.a(q0Var) : null;
        if (a10 != null && !b0.f(C(), q0Var)) {
            return s0(p0Var, a10, lVar);
        }
        v9.x xVar = v9.x.f14811a;
        String k10 = p0Var.c().k();
        y8.k.d(k10, "name.asString()");
        return s0(p0Var, v9.x.a(k10), lVar);
    }

    private final u0 u0(p0 p0Var, x8.l<? super la.e, ? extends Collection<? extends u0>> lVar) {
        u0 u0Var;
        bb.b0 i10;
        v9.x xVar = v9.x.f14811a;
        String k10 = p0Var.c().k();
        y8.k.d(k10, "name.asString()");
        la.e r10 = la.e.r(v9.x.d(k10));
        y8.k.d(r10, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = lVar.h(r10).iterator();
        do {
            u0Var = null;
            if (!it.hasNext()) {
                break;
            }
            u0 u0Var2 = (u0) it.next();
            if (u0Var2.l().size() == 1 && (i10 = u0Var2.i()) != null && k9.h.J0(i10)) {
                kotlin.reflect.jvm.internal.impl.types.checker.f fVar = kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a;
                List<d1> l10 = u0Var2.l();
                y8.k.d(l10, "descriptor.valueParameters");
                if (fVar.c(((d1) o.d0(l10)).b(), p0Var.b())) {
                    u0Var = u0Var2;
                }
            }
        } while (u0Var == null);
        return u0Var;
    }

    private final u v0(n9.e eVar) {
        u h10 = eVar.h();
        y8.k.d(h10, "classDescriptor.visibility");
        if (!y8.k.a(h10, v9.u.f14806b)) {
            return h10;
        }
        u uVar = v9.u.f14807c;
        y8.k.d(uVar, "PROTECTED_AND_PACKAGE");
        return uVar;
    }

    private final Set<u0> x0(la.e eVar) {
        Collection<bb.b0> b02 = b0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = b02.iterator();
        while (it.hasNext()) {
            m8.v.r(linkedHashSet, ((bb.b0) it.next()).A().b(eVar, u9.d.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<p0> z0(la.e eVar) {
        Set<p0> r02;
        int n10;
        Collection<bb.b0> b02 = b0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = b02.iterator();
        while (it.hasNext()) {
            Collection<? extends p0> a10 = ((bb.b0) it.next()).A().a(eVar, u9.d.WHEN_GET_SUPER_MEMBERS);
            n10 = r.n(a10, 10);
            ArrayList arrayList2 = new ArrayList(n10);
            Iterator<T> it2 = a10.iterator();
            while (it2.hasNext()) {
                arrayList2.add((p0) it2.next());
            }
            m8.v.r(arrayList, arrayList2);
        }
        r02 = y.r0(arrayList);
        return r02;
    }

    public void F0(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        t9.a.a(w().a().k(), bVar, C(), eVar);
    }

    @Override // z9.j
    protected boolean G(x9.f fVar) {
        y8.k.e(fVar, "<this>");
        if (this.f16293o.E()) {
            return false;
        }
        return B0(fVar);
    }

    @Override // z9.j
    protected j.a H(ca.r rVar, List<? extends a1> list, bb.b0 b0Var, List<? extends d1> list2) {
        y8.k.e(rVar, "method");
        y8.k.e(list, "methodTypeParameters");
        y8.k.e(b0Var, "returnType");
        y8.k.e(list2, "valueParameters");
        j.b b10 = w().a().r().b(rVar, C(), b0Var, null, list2, list);
        y8.k.d(b10, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        bb.b0 d10 = b10.d();
        y8.k.d(d10, "propagated.returnType");
        bb.b0 c10 = b10.c();
        List<d1> f10 = b10.f();
        y8.k.d(f10, "propagated.valueParameters");
        List<a1> e10 = b10.e();
        y8.k.d(e10, "propagated.typeParameters");
        boolean g10 = b10.g();
        List<String> b11 = b10.b();
        y8.k.d(b11, "propagated.errors");
        return new j.a(d10, c10, f10, e10, g10, b11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z9.j
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<la.e> n(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(dVar, "kindFilter");
        Collection<bb.b0> x10 = C().o().x();
        y8.k.d(x10, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<la.e> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = x10.iterator();
        while (it.hasNext()) {
            m8.v.r(linkedHashSet, ((bb.b0) it.next()).A().c());
        }
        linkedHashSet.addAll(y().b().a());
        linkedHashSet.addAll(y().b().b());
        linkedHashSet.addAll(l(dVar, lVar));
        return linkedHashSet;
    }

    @Override // z9.j, ua.i, ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        F0(eVar, bVar);
        return super.a(eVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z9.j
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public z9.a p() {
        return new z9.a(this.f16293o, a.f16299f);
    }

    @Override // z9.j, ua.i, ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        F0(eVar, bVar);
        return super.b(eVar, bVar);
    }

    @Override // ua.i, ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        ab.h<la.e, p9.g> hVar;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        F0(eVar, bVar);
        g gVar = (g) B();
        p9.g gVar2 = null;
        if (gVar != null && (hVar = gVar.f16298t) != null) {
            gVar2 = hVar.h(eVar);
        }
        return gVar2 == null ? this.f16298t.h(eVar) : gVar2;
    }

    @Override // z9.j
    protected Set<la.e> l(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set<la.e> g10;
        y8.k.e(dVar, "kindFilter");
        g10 = s0.g(this.f16296r.b(), this.f16297s.b().keySet());
        return g10;
    }

    @Override // z9.j
    protected void o(Collection<u0> collection, la.e eVar) {
        y8.k.e(collection, "result");
        y8.k.e(eVar, "name");
        if (!this.f16293o.L() || y().b().c(eVar) == null) {
            return;
        }
        boolean z10 = true;
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((u0) it.next()).l().isEmpty()) {
                    z10 = false;
                    break;
                }
            }
        }
        if (z10) {
            ca.w c10 = y().b().c(eVar);
            y8.k.b(c10);
            collection.add(H0(c10));
        }
    }

    @Override // z9.j
    protected void r(Collection<u0> collection, la.e eVar) {
        List d10;
        List a02;
        boolean z10;
        y8.k.e(collection, "result");
        y8.k.e(eVar, "name");
        Set<u0> x02 = x0(eVar);
        if (!v9.e.f14779m.k(eVar) && !v9.f.f14781m.l(eVar)) {
            if (!(x02 instanceof Collection) || !x02.isEmpty()) {
                Iterator<T> it = x02.iterator();
                while (it.hasNext()) {
                    if (((x) it.next()).q0()) {
                        z10 = false;
                        break;
                    }
                }
            }
            z10 = true;
            if (z10) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : x02) {
                    if (B0((u0) obj)) {
                        arrayList.add(obj);
                    }
                }
                V(collection, eVar, arrayList, false);
                return;
            }
        }
        jb.j a10 = jb.j.f11086h.a();
        d10 = m8.q.d();
        Collection<? extends u0> d11 = w9.a.d(eVar, x02, d10, C(), xa.p.f15625a, w().a().j().a());
        y8.k.d(d11, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        W(eVar, collection, d11, collection, new b(this));
        W(eVar, collection, d11, a10, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : x02) {
            if (B0((u0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        a02 = y.a0(arrayList2, a10);
        V(collection, eVar, a02, true);
    }

    @Override // z9.j
    protected void s(la.e eVar, Collection<p0> collection) {
        Set<? extends p0> f10;
        Set g10;
        y8.k.e(eVar, "name");
        y8.k.e(collection, "result");
        if (this.f16293o.E()) {
            Y(eVar, collection);
        }
        Set<p0> z02 = z0(eVar);
        if (z02.isEmpty()) {
            return;
        }
        j.b bVar = jb.j.f11086h;
        jb.j a10 = bVar.a();
        jb.j a11 = bVar.a();
        X(z02, collection, a10, new d());
        f10 = s0.f(z02, a10);
        X(f10, a11, null, new e());
        g10 = s0.g(z02, a11);
        Collection<? extends p0> d10 = w9.a.d(eVar, g10, collection, C(), w().a().c(), w().a().j().a());
        y8.k.d(d10, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
        collection.addAll(d10);
    }

    @Override // z9.j
    protected Set<la.e> t(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(dVar, "kindFilter");
        if (this.f16293o.E()) {
            return c();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(y().b().d());
        Collection<bb.b0> x10 = C().o().x();
        y8.k.d(x10, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = x10.iterator();
        while (it.hasNext()) {
            m8.v.r(linkedHashSet, ((bb.b0) it.next()).A().d());
        }
        return linkedHashSet;
    }

    @Override // z9.j
    public String toString() {
        return y8.k.j("Lazy Java member scope for ", this.f16293o.f());
    }

    public final ab.i<List<n9.d>> w0() {
        return this.f16295q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z9.j
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public n9.e C() {
        return this.f16292n;
    }

    @Override // z9.j
    protected n9.s0 z() {
        return na.d.l(C());
    }
}
