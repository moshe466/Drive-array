package xa;

import bb.v0;
import ga.v;
import ia.b;
import ia.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import m8.l0;
import n9.a;
import n9.a1;
import n9.b;
import n9.d1;
import n9.g0;
import n9.p0;
import n9.s0;
import n9.u0;
import n9.z0;
import p9.c0;
import p9.d0;
import xa.x;
import za.g;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final l f15632a;

    /* renamed from: b, reason: collision with root package name */
    private final xa.e f15633b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.q f15636g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ xa.b f15637h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar) {
            super(0);
            this.f15636g = qVar;
            this.f15637h = bVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n02;
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d10;
            u uVar = u.this;
            x c10 = uVar.c(uVar.f15632a.e());
            if (c10 == null) {
                n02 = null;
            } else {
                u uVar2 = u.this;
                n02 = m8.y.n0(uVar2.f15632a.c().d().c(c10, this.f15636g, this.f15637h));
            }
            if (n02 != null) {
                return n02;
            }
            d10 = m8.q.d();
            return d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f15639g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ga.n f15640h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z10, ga.n nVar) {
            super(0);
            this.f15639g = z10;
            this.f15640h = nVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n02;
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d10;
            u uVar = u.this;
            x c10 = uVar.c(uVar.f15632a.e());
            if (c10 == null) {
                n02 = null;
            } else {
                boolean z10 = this.f15639g;
                u uVar2 = u.this;
                ga.n nVar = this.f15640h;
                n02 = m8.y.n0(z10 ? uVar2.f15632a.c().d().e(c10, nVar) : uVar2.f15632a.c().d().i(c10, nVar));
            }
            if (n02 != null) {
                return n02;
            }
            d10 = m8.q.d();
            return d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.q f15642g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ xa.b f15643h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar) {
            super(0);
            this.f15642g = qVar;
            this.f15643h = bVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> g10;
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d10;
            u uVar = u.this;
            x c10 = uVar.c(uVar.f15632a.e());
            if (c10 == null) {
                g10 = null;
            } else {
                u uVar2 = u.this;
                g10 = uVar2.f15632a.c().d().g(c10, this.f15642g, this.f15643h);
            }
            if (g10 != null) {
                return g10;
            }
            d10 = m8.q.d();
            return d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.a<pa.g<?>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ga.n f15645g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ za.j f15646h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ga.n nVar, za.j jVar) {
            super(0);
            this.f15645g = nVar;
            this.f15646h = jVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final pa.g<?> b() {
            u uVar = u.this;
            x c10 = uVar.c(uVar.f15632a.e());
            y8.k.b(c10);
            xa.c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, pa.g<?>> d10 = u.this.f15632a.c().d();
            ga.n nVar = this.f15645g;
            bb.b0 i10 = this.f15646h.i();
            y8.k.d(i10, "property.returnType");
            return d10.b(c10, nVar, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ x f15648g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.q f15649h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ xa.b f15650i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f15651j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ga.u f15652k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar, int i10, ga.u uVar) {
            super(0);
            this.f15648g = xVar;
            this.f15649h = qVar;
            this.f15650i = bVar;
            this.f15651j = i10;
            this.f15652k = uVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n02;
            n02 = m8.y.n0(u.this.f15632a.c().d().d(this.f15648g, this.f15649h, this.f15650i, this.f15651j, this.f15652k));
            return n02;
        }
    }

    public u(l lVar) {
        y8.k.e(lVar, "c");
        this.f15632a = lVar;
        this.f15633b = new xa.e(lVar.c().p(), lVar.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x c(n9.m mVar) {
        if (mVar instanceof g0) {
            return new x.b(((g0) mVar).f(), this.f15632a.g(), this.f15632a.j(), this.f15632a.d());
        }
        if (mVar instanceof za.d) {
            return ((za.d) mVar).m1();
        }
        return null;
    }

    private final g.a d(za.g gVar, b0 b0Var) {
        if (!s(gVar)) {
            return g.a.COMPATIBLE;
        }
        g(b0Var);
        return b0Var.j() ? g.a.INCOMPATIBLE : g.a.COMPATIBLE;
    }

    private final g.a e(za.b bVar, s0 s0Var, Collection<? extends d1> collection, Collection<? extends a1> collection2, bb.b0 b0Var, boolean z10) {
        int n10;
        List h10;
        List<bb.b0> a02;
        boolean z11;
        boolean z12;
        int n11;
        g.a aVar;
        boolean z13;
        if (s(bVar) && !y8.k.a(ra.a.e(bVar), a0.f15549a)) {
            n10 = m8.r.n(collection, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((d1) it.next()).b());
            }
            h10 = m8.q.h(s0Var == null ? null : s0Var.b());
            a02 = m8.y.a0(arrayList, h10);
            if (y8.k.a(b0Var != null ? Boolean.valueOf(f(b0Var)) : null, Boolean.TRUE)) {
                return g.a.INCOMPATIBLE;
            }
            if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                Iterator<T> it2 = collection2.iterator();
                while (it2.hasNext()) {
                    List<bb.b0> upperBounds = ((a1) it2.next()).getUpperBounds();
                    y8.k.d(upperBounds, "typeParameter.upperBounds");
                    if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                        for (bb.b0 b0Var2 : upperBounds) {
                            y8.k.d(b0Var2, "it");
                            if (f(b0Var2)) {
                                z11 = true;
                                break;
                            }
                        }
                    }
                    z11 = false;
                    if (z11) {
                        z12 = true;
                        break;
                    }
                }
            }
            z12 = false;
            if (z12) {
                return g.a.INCOMPATIBLE;
            }
            n11 = m8.r.n(a02, 10);
            ArrayList arrayList2 = new ArrayList(n11);
            for (bb.b0 b0Var3 : a02) {
                y8.k.d(b0Var3, "type");
                if (!k9.g.o(b0Var3) || b0Var3.V0().size() > 3) {
                    if (!f(b0Var3)) {
                        aVar = g.a.COMPATIBLE;
                    }
                    aVar = g.a.INCOMPATIBLE;
                } else {
                    List<v0> V0 = b0Var3.V0();
                    if (!(V0 instanceof Collection) || !V0.isEmpty()) {
                        Iterator<T> it3 = V0.iterator();
                        while (it3.hasNext()) {
                            bb.b0 b10 = ((v0) it3.next()).b();
                            y8.k.d(b10, "it.type");
                            if (f(b10)) {
                                z13 = true;
                                break;
                            }
                        }
                    }
                    z13 = false;
                    if (!z13) {
                        aVar = g.a.NEEDS_WRAPPER;
                    }
                    aVar = g.a.INCOMPATIBLE;
                }
                arrayList2.add(aVar);
            }
            g.a aVar2 = (g.a) m8.o.W(arrayList2);
            if (aVar2 == null) {
                aVar2 = g.a.COMPATIBLE;
            }
            return (g.a) o8.a.b(z10 ? g.a.NEEDS_WRAPPER : g.a.COMPATIBLE, aVar2);
        }
        return g.a.COMPATIBLE;
    }

    private final boolean f(bb.b0 b0Var) {
        return eb.a.b(b0Var, new y8.s() { // from class: xa.u.a
            @Override // y8.c, e9.a
            public String c() {
                return "isSuspendFunctionType";
            }

            @Override // e9.i
            public Object get(Object obj) {
                return Boolean.valueOf(k9.g.o((bb.b0) obj));
            }

            @Override // y8.c
            public e9.d k() {
                return y8.w.d(k9.g.class, "deserialization");
            }

            @Override // y8.c
            public String m() {
                return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }
        });
    }

    private final void g(b0 b0Var) {
        Iterator<T> it = b0Var.k().iterator();
        while (it.hasNext()) {
            ((a1) it.next()).getUpperBounds();
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g h(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, int i10, xa.b bVar) {
        return !ia.b.f10796b.d(i10).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b() : new za.n(this.f15632a.h(), new b(qVar, bVar));
    }

    private final s0 i() {
        n9.m e10 = this.f15632a.e();
        n9.e eVar = e10 instanceof n9.e ? (n9.e) e10 : null;
        if (eVar == null) {
            return null;
        }
        return eVar.T0();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g j(ga.n nVar, boolean z10) {
        return !ia.b.f10796b.d(nVar.U()).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b() : new za.n(this.f15632a.h(), new c(z10, nVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g k(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar) {
        return new za.a(this.f15632a.h(), new d(qVar, bVar));
    }

    private final void l(za.k kVar, s0 s0Var, s0 s0Var2, List<? extends a1> list, List<? extends d1> list2, bb.b0 b0Var, n9.a0 a0Var, n9.u uVar, Map<? extends a.InterfaceC0257a<?>, ?> map, boolean z10) {
        kVar.C1(s0Var, s0Var2, list, list2, b0Var, a0Var, uVar, map, e(kVar, s0Var, list2, list, b0Var, z10));
    }

    private final int o(int i10) {
        return (i10 & 63) + ((i10 >> 8) << 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<n9.d1> r(java.util.List<ga.u> r26, kotlin.reflect.jvm.internal.impl.protobuf.q r27, xa.b r28) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.u.r(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.q, xa.b):java.util.List");
    }

    private final boolean s(za.g gVar) {
        boolean z10;
        if (!this.f15632a.c().g().f()) {
            return false;
        }
        List<ia.h> S0 = gVar.S0();
        if (!(S0 instanceof Collection) || !S0.isEmpty()) {
            for (ia.h hVar : S0) {
                if (y8.k.a(hVar.b(), new h.b(1, 3, 0, 4, null)) && hVar.a() == v.d.LANGUAGE_VERSION) {
                    z10 = false;
                    break;
                }
            }
        }
        z10 = true;
        return z10;
    }

    public final n9.d m(ga.d dVar, boolean z10) {
        List d10;
        za.c cVar;
        g.a e10;
        b0 i10;
        y8.k.e(dVar, "proto");
        n9.e eVar = (n9.e) this.f15632a.e();
        int L = dVar.L();
        xa.b bVar = xa.b.FUNCTION;
        za.c cVar2 = new za.c(eVar, null, h(dVar, L, bVar), z10, b.a.DECLARATION, dVar, this.f15632a.g(), this.f15632a.j(), this.f15632a.k(), this.f15632a.d(), null, 1024, null);
        l lVar = this.f15632a;
        d10 = m8.q.d();
        u f10 = l.b(lVar, cVar2, d10, null, null, null, null, 60, null).f();
        List<ga.u> O = dVar.O();
        y8.k.d(O, "proto.valueParameterList");
        cVar2.A1(f10.r(O, dVar, bVar), z.a(y.f15666a, ia.b.f10797c.d(dVar.L())));
        cVar2.r1(eVar.s());
        cVar2.j1(!ia.b.f10807m.d(dVar.L()).booleanValue());
        n9.m e11 = this.f15632a.e();
        Boolean bool = null;
        za.d dVar2 = e11 instanceof za.d ? (za.d) e11 : null;
        l h12 = dVar2 == null ? null : dVar2.h1();
        if (h12 != null && (i10 = h12.i()) != null) {
            bool = Boolean.valueOf(i10.j());
        }
        if (y8.k.a(bool, Boolean.TRUE) && s(cVar2)) {
            e10 = g.a.INCOMPATIBLE;
            cVar = cVar2;
        } else {
            Collection<? extends d1> l10 = cVar2.l();
            y8.k.d(l10, "descriptor.valueParameters");
            Collection<? extends a1> m10 = cVar2.m();
            y8.k.d(m10, "descriptor.typeParameters");
            cVar = cVar2;
            e10 = e(cVar2, null, l10, m10, cVar2.i(), false);
        }
        cVar.F1(e10);
        return cVar;
    }

    public final u0 n(ga.i iVar) {
        Map<? extends a.InterfaceC0257a<?>, ?> h10;
        bb.b0 p10;
        y8.k.e(iVar, "proto");
        int W = iVar.m0() ? iVar.W() : o(iVar.Y());
        xa.b bVar = xa.b.FUNCTION;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g h11 = h(iVar, W, bVar);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g k10 = ia.f.d(iVar) ? k(iVar, bVar) : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        ia.i b10 = y8.k.a(ra.a.i(this.f15632a.e()).c(v.b(this.f15632a.g(), iVar.X())), a0.f15549a) ? ia.i.f10840b.b() : this.f15632a.k();
        la.e b11 = v.b(this.f15632a.g(), iVar.X());
        y yVar = y.f15666a;
        za.k kVar = new za.k(this.f15632a.e(), null, h11, b11, z.b(yVar, ia.b.f10808n.d(W)), iVar, this.f15632a.g(), this.f15632a.j(), b10, this.f15632a.d(), null, 1024, null);
        l lVar = this.f15632a;
        List<ga.s> f02 = iVar.f0();
        y8.k.d(f02, "proto.typeParameterList");
        l b12 = l.b(lVar, kVar, f02, null, null, null, null, 60, null);
        ga.q g10 = ia.f.g(iVar, this.f15632a.j());
        s0 s0Var = null;
        if (g10 != null && (p10 = b12.i().p(g10)) != null) {
            s0Var = na.c.f(kVar, p10, k10);
        }
        s0 i10 = i();
        List<a1> k11 = b12.i().k();
        u f10 = b12.f();
        List<ga.u> j02 = iVar.j0();
        y8.k.d(j02, "proto.valueParameterList");
        List<d1> r10 = f10.r(j02, iVar, bVar);
        bb.b0 p11 = b12.i().p(ia.f.i(iVar, this.f15632a.j()));
        n9.a0 b13 = yVar.b(ia.b.f10798d.d(W));
        n9.u a10 = z.a(yVar, ia.b.f10797c.d(W));
        h10 = l0.h();
        b.C0207b c0207b = ia.b.f10814t;
        Boolean d10 = c0207b.d(W);
        y8.k.d(d10, "IS_SUSPEND.get(flags)");
        l(kVar, s0Var, i10, k11, r10, p11, b13, a10, h10, d10.booleanValue());
        Boolean d11 = ia.b.f10809o.d(W);
        y8.k.d(d11, "IS_OPERATOR.get(flags)");
        kVar.q1(d11.booleanValue());
        Boolean d12 = ia.b.f10810p.d(W);
        y8.k.d(d12, "IS_INFIX.get(flags)");
        kVar.n1(d12.booleanValue());
        Boolean d13 = ia.b.f10813s.d(W);
        y8.k.d(d13, "IS_EXTERNAL_FUNCTION.get(flags)");
        kVar.i1(d13.booleanValue());
        Boolean d14 = ia.b.f10811q.d(W);
        y8.k.d(d14, "IS_INLINE.get(flags)");
        kVar.p1(d14.booleanValue());
        Boolean d15 = ia.b.f10812r.d(W);
        y8.k.d(d15, "IS_TAILREC.get(flags)");
        kVar.t1(d15.booleanValue());
        Boolean d16 = c0207b.d(W);
        y8.k.d(d16, "IS_SUSPEND.get(flags)");
        kVar.s1(d16.booleanValue());
        Boolean d17 = ia.b.f10815u.d(W);
        y8.k.d(d17, "IS_EXPECT_FUNCTION.get(flags)");
        kVar.h1(d17.booleanValue());
        kVar.j1(!ia.b.f10816v.d(W).booleanValue());
        l8.n<a.InterfaceC0257a<?>, Object> a11 = this.f15632a.c().h().a(iVar, kVar, this.f15632a.j(), b12.i());
        if (a11 != null) {
            kVar.f1(a11.c(), a11.d());
        }
        return kVar;
    }

    public final p0 p(ga.n nVar) {
        ga.n nVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10;
        bb.b0 p10;
        za.j jVar;
        s0 f10;
        b.d<ga.k> dVar;
        b.d<ga.x> dVar2;
        c0 c0Var;
        za.j jVar2;
        ga.n nVar3;
        int i10;
        boolean z10;
        d0 d0Var;
        List d10;
        List<ga.u> b11;
        c0 b12;
        y8.k.e(nVar, "proto");
        int U = nVar.i0() ? nVar.U() : o(nVar.X());
        n9.m e10 = this.f15632a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g h10 = h(nVar, U, xa.b.PROPERTY);
        y yVar = y.f15666a;
        b.d<ga.k> dVar3 = ia.b.f10798d;
        n9.a0 b13 = yVar.b(dVar3.d(U));
        b.d<ga.x> dVar4 = ia.b.f10797c;
        n9.u a10 = z.a(yVar, dVar4.d(U));
        Boolean d11 = ia.b.f10817w.d(U);
        y8.k.d(d11, "IS_VAR.get(flags)");
        boolean booleanValue = d11.booleanValue();
        la.e b14 = v.b(this.f15632a.g(), nVar.W());
        b.a b15 = z.b(yVar, ia.b.f10808n.d(U));
        Boolean d12 = ia.b.A.d(U);
        y8.k.d(d12, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = d12.booleanValue();
        Boolean d13 = ia.b.f10820z.d(U);
        y8.k.d(d13, "IS_CONST.get(flags)");
        boolean booleanValue3 = d13.booleanValue();
        Boolean d14 = ia.b.C.d(U);
        y8.k.d(d14, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = d14.booleanValue();
        Boolean d15 = ia.b.D.d(U);
        y8.k.d(d15, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = d15.booleanValue();
        Boolean d16 = ia.b.E.d(U);
        y8.k.d(d16, "IS_EXPECT_PROPERTY.get(flags)");
        y yVar2 = yVar;
        za.j jVar3 = new za.j(e10, null, h10, b13, a10, booleanValue, b14, b15, booleanValue2, booleanValue3, booleanValue4, booleanValue5, d16.booleanValue(), nVar, this.f15632a.g(), this.f15632a.j(), this.f15632a.k(), this.f15632a.d());
        l lVar = this.f15632a;
        List<ga.s> g02 = nVar.g0();
        y8.k.d(g02, "proto.typeParameterList");
        l b16 = l.b(lVar, jVar3, g02, null, null, null, null, 60, null);
        Boolean d17 = ia.b.f10818x.d(U);
        y8.k.d(d17, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = d17.booleanValue();
        if (booleanValue6 && ia.f.e(nVar)) {
            nVar2 = nVar;
            b10 = k(nVar2, xa.b.PROPERTY_GETTER);
        } else {
            nVar2 = nVar;
            b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        }
        bb.b0 p11 = b16.i().p(ia.f.j(nVar2, this.f15632a.j()));
        List<a1> k10 = b16.i().k();
        s0 i11 = i();
        ga.q h11 = ia.f.h(nVar2, this.f15632a.j());
        if (h11 == null || (p10 = b16.i().p(h11)) == null) {
            jVar = jVar3;
            f10 = null;
        } else {
            jVar = jVar3;
            f10 = na.c.f(jVar, p10, b10);
        }
        jVar.k1(p11, k10, i11, f10);
        Boolean d18 = ia.b.f10796b.d(U);
        y8.k.d(d18, "HAS_ANNOTATIONS.get(flags)");
        int b17 = ia.b.b(d18.booleanValue(), dVar4.d(U), dVar3.d(U), false, false, false);
        if (booleanValue6) {
            int V = nVar.j0() ? nVar.V() : b17;
            Boolean d19 = ia.b.I.d(V);
            y8.k.d(d19, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = d19.booleanValue();
            Boolean d20 = ia.b.J.d(V);
            y8.k.d(d20, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = d20.booleanValue();
            Boolean d21 = ia.b.K.d(V);
            y8.k.d(d21, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = d21.booleanValue();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g h12 = h(nVar2, V, xa.b.PROPERTY_GETTER);
            if (booleanValue7) {
                yVar2 = yVar2;
                dVar = dVar3;
                dVar2 = dVar4;
                b12 = new c0(jVar, h12, yVar2.b(dVar3.d(V)), z.a(yVar2, dVar4.d(V)), !booleanValue7, booleanValue8, booleanValue9, jVar.r(), null, n9.v0.f12324a);
            } else {
                dVar = dVar3;
                dVar2 = dVar4;
                b12 = na.c.b(jVar, h12);
                y8.k.d(b12, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            b12.b1(jVar.i());
            c0Var = b12;
        } else {
            dVar = dVar3;
            dVar2 = dVar4;
            c0Var = null;
        }
        Boolean d22 = ia.b.f10819y.d(U);
        y8.k.d(d22, "HAS_SETTER.get(flags)");
        if (d22.booleanValue()) {
            if (nVar.q0()) {
                b17 = nVar.c0();
            }
            int i12 = b17;
            Boolean d23 = ia.b.I.d(i12);
            y8.k.d(d23, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = d23.booleanValue();
            Boolean d24 = ia.b.J.d(i12);
            y8.k.d(d24, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = d24.booleanValue();
            Boolean d25 = ia.b.K.d(i12);
            y8.k.d(d25, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = d25.booleanValue();
            xa.b bVar = xa.b.PROPERTY_SETTER;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g h13 = h(nVar2, i12, bVar);
            if (booleanValue10) {
                y yVar3 = yVar2;
                d0 d0Var2 = new d0(jVar, h13, yVar3.b(dVar.d(i12)), z.a(yVar3, dVar2.d(i12)), !booleanValue10, booleanValue11, booleanValue12, jVar.r(), null, n9.v0.f12324a);
                d10 = m8.q.d();
                z10 = true;
                jVar2 = jVar;
                nVar3 = nVar2;
                i10 = U;
                u f11 = l.b(b16, d0Var2, d10, null, null, null, null, 60, null).f();
                b11 = m8.p.b(nVar.d0());
                d0Var2.c1((d1) m8.o.d0(f11.r(b11, nVar3, bVar)));
                d0Var = d0Var2;
            } else {
                jVar2 = jVar;
                nVar3 = nVar2;
                i10 = U;
                z10 = true;
                d0Var = na.c.c(jVar2, h13, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b());
                y8.k.d(d0Var, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
            }
        } else {
            jVar2 = jVar;
            nVar3 = nVar2;
            i10 = U;
            z10 = true;
            d0Var = null;
        }
        Boolean d26 = ia.b.B.d(i10);
        y8.k.d(d26, "HAS_CONSTANT.get(flags)");
        if (d26.booleanValue()) {
            jVar2.V0(this.f15632a.h().h(new e(nVar3, jVar2)));
        }
        jVar2.n1(c0Var, d0Var, new p9.o(j(nVar3, false), jVar2), new p9.o(j(nVar3, z10), jVar2), d(jVar2, b16.i()));
        return jVar2;
    }

    public final z0 q(ga.r rVar) {
        int n10;
        y8.k.e(rVar, "proto");
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
        List<ga.b> S = rVar.S();
        y8.k.d(S, "proto.annotationList");
        n10 = m8.r.n(S, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (ga.b bVar : S) {
            xa.e eVar = this.f15633b;
            y8.k.d(bVar, "it");
            arrayList.add(eVar.a(bVar, this.f15632a.g()));
        }
        za.l lVar = new za.l(this.f15632a.h(), this.f15632a.e(), aVar.a(arrayList), v.b(this.f15632a.g(), rVar.Y()), z.a(y.f15666a, ia.b.f10797c.d(rVar.X())), rVar, this.f15632a.g(), this.f15632a.j(), this.f15632a.k(), this.f15632a.d());
        l lVar2 = this.f15632a;
        List<ga.s> b02 = rVar.b0();
        y8.k.d(b02, "proto.typeParameterList");
        l b10 = l.b(lVar2, lVar, b02, null, null, null, null, 60, null);
        lVar.b1(b10.i().k(), b10.i().l(ia.f.n(rVar, this.f15632a.j()), false), b10.i().l(ia.f.b(rVar, this.f15632a.j()), false), d(lVar, b10.i()));
        return lVar;
    }
}
