package xa;

import bb.c0;
import bb.h1;
import bb.i0;
import bb.m0;
import bb.n0;
import bb.t0;
import bb.v0;
import bb.x0;
import ga.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m8.l0;
import n9.a1;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final l f15550a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f15551b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15552c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15553d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f15554e;

    /* renamed from: f, reason: collision with root package name */
    private final x8.l<Integer, n9.h> f15555f;

    /* renamed from: g, reason: collision with root package name */
    private final x8.l<Integer, n9.h> f15556g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, a1> f15557h;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<Integer, n9.h> {
        a() {
            super(1);
        }

        public final n9.h a(int i10) {
            return b0.this.d(i10);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ n9.h h(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ga.q f15560g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ga.q qVar) {
            super(0);
            this.f15560g = qVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            return b0.this.f15550a.c().d().j(this.f15560g, b0.this.f15550a.g());
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<Integer, n9.h> {
        c() {
            super(1);
        }

        public final n9.h a(int i10) {
            return b0.this.f(i10);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ n9.h h(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class d extends y8.i implements x8.l<la.a, la.a> {

        /* renamed from: o, reason: collision with root package name */
        public static final d f15562o = new d();

        d() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "getOuterClassId";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(la.a.class);
        }

        @Override // y8.c
        public final String m() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final la.a h(la.a aVar) {
            y8.k.e(aVar, "p0");
            return aVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.l<ga.q, ga.q> {
        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ga.q h(ga.q qVar) {
            y8.k.e(qVar, "it");
            return ia.f.f(qVar, b0.this.f15550a.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.l<ga.q, Integer> {

        /* renamed from: f, reason: collision with root package name */
        public static final f f15564f = new f();

        f() {
            super(1);
        }

        public final int a(ga.q qVar) {
            y8.k.e(qVar, "it");
            return qVar.W();
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Integer h(ga.q qVar) {
            return Integer.valueOf(a(qVar));
        }
    }

    public b0(l lVar, b0 b0Var, List<ga.s> list, String str, String str2, boolean z10) {
        Map<Integer, a1> linkedHashMap;
        y8.k.e(lVar, "c");
        y8.k.e(list, "typeParameterProtos");
        y8.k.e(str, "debugName");
        y8.k.e(str2, "containerPresentableName");
        this.f15550a = lVar;
        this.f15551b = b0Var;
        this.f15552c = str;
        this.f15553d = str2;
        this.f15554e = z10;
        this.f15555f = lVar.h().c(new a());
        this.f15556g = lVar.h().c(new c());
        if (list.isEmpty()) {
            linkedHashMap = l0.h();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i10 = 0;
            for (ga.s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.O()), new za.m(this.f15550a, sVar, i10));
                i10++;
            }
        }
        this.f15557h = linkedHashMap;
    }

    public /* synthetic */ b0(l lVar, b0 b0Var, List list, String str, String str2, boolean z10, int i10, y8.g gVar) {
        this(lVar, b0Var, list, str, str2, (i10 & 32) != 0 ? false : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.h d(int i10) {
        la.a a10 = v.a(this.f15550a.g(), i10);
        return a10.k() ? this.f15550a.c().b(a10) : n9.w.b(this.f15550a.c().p(), a10);
    }

    private final i0 e(int i10) {
        if (v.a(this.f15550a.g(), i10).k()) {
            return this.f15550a.c().n().a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.h f(int i10) {
        la.a a10 = v.a(this.f15550a.g(), i10);
        if (a10.k()) {
            return null;
        }
        return n9.w.d(this.f15550a.c().p(), a10);
    }

    private final i0 g(bb.b0 b0Var, bb.b0 b0Var2) {
        List E;
        int n10;
        k9.h e10 = eb.a.e(b0Var);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = b0Var.u();
        bb.b0 h10 = k9.g.h(b0Var);
        E = m8.y.E(k9.g.j(b0Var), 1);
        n10 = m8.r.n(E, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = E.iterator();
        while (it.hasNext()) {
            arrayList.add(((v0) it.next()).b());
        }
        return k9.g.a(e10, u10, h10, arrayList, null, b0Var2, true).a1(b0Var.X0());
    }

    private final i0 h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, t0 t0Var, List<? extends v0> list, boolean z10) {
        int size;
        int size2 = t0Var.B().size() - list.size();
        i0 i0Var = null;
        if (size2 == 0) {
            i0Var = i(gVar, t0Var, list, z10);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            c0 c0Var = c0.f4165a;
            t0 o10 = t0Var.w().W(size).o();
            y8.k.d(o10, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
            i0Var = c0.i(gVar, o10, list, z10, null, 16, null);
        }
        if (i0Var != null) {
            return i0Var;
        }
        i0 n10 = bb.t.n(y8.k.j("Bad suspend function in metadata with constructor: ", t0Var), list);
        y8.k.d(n10, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
        return n10;
    }

    private final i0 i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, t0 t0Var, List<? extends v0> list, boolean z10) {
        c0 c0Var = c0.f4165a;
        i0 i10 = c0.i(gVar, t0Var, list, z10, null, 16, null);
        if (k9.g.n(i10)) {
            return o(i10);
        }
        return null;
    }

    private static final List<q.b> m(ga.q qVar, b0 b0Var) {
        List<q.b> a02;
        List<q.b> X = qVar.X();
        y8.k.d(X, "argumentList");
        ga.q f10 = ia.f.f(qVar, b0Var.f15550a.j());
        List<q.b> m10 = f10 == null ? null : m(f10, b0Var);
        if (m10 == null) {
            m10 = m8.q.d();
        }
        a02 = m8.y.a0(X, m10);
        return a02;
    }

    public static /* synthetic */ i0 n(b0 b0Var, ga.q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return b0Var.l(qVar, z10);
    }

    private final i0 o(bb.b0 b0Var) {
        boolean f10 = this.f15550a.c().g().f();
        v0 v0Var = (v0) m8.o.U(k9.g.j(b0Var));
        bb.b0 b10 = v0Var == null ? null : v0Var.b();
        if (b10 == null) {
            return null;
        }
        n9.h o10 = b10.W0().o();
        la.b i10 = o10 == null ? null : ra.a.i(o10);
        boolean z10 = true;
        if (b10.V0().size() != 1 || (!k9.l.a(i10, true) && !k9.l.a(i10, false))) {
            return (i0) b0Var;
        }
        bb.b0 b11 = ((v0) m8.o.d0(b10.V0())).b();
        y8.k.d(b11, "continuationArgumentType.arguments.single().type");
        n9.m e10 = this.f15550a.e();
        if (!(e10 instanceof n9.a)) {
            e10 = null;
        }
        n9.a aVar = (n9.a) e10;
        if (y8.k.a(aVar != null ? ra.a.e(aVar) : null, a0.f15549a)) {
            return g(b0Var, b11);
        }
        if (!this.f15554e && (!f10 || !k9.l.a(i10, !f10))) {
            z10 = false;
        }
        this.f15554e = z10;
        return g(b0Var, b11);
    }

    private final v0 q(a1 a1Var, q.b bVar) {
        if (bVar.y() == q.b.c.STAR) {
            return a1Var == null ? new m0(this.f15550a.c().p().w()) : new n0(a1Var);
        }
        y yVar = y.f15666a;
        q.b.c y10 = bVar.y();
        y8.k.d(y10, "typeArgumentProto.projection");
        h1 c10 = yVar.c(y10);
        ga.q l10 = ia.f.l(bVar, this.f15550a.j());
        return l10 == null ? new x0(bb.t.j("No type recorded")) : new x0(c10, p(l10));
    }

    private final t0 r(ga.q qVar) {
        t0 k10;
        String str;
        Object obj;
        if (qVar.n0()) {
            n9.h h10 = this.f15555f.h(Integer.valueOf(qVar.Y()));
            if (h10 == null) {
                h10 = s(this, qVar, qVar.Y());
            }
            k10 = h10.o();
            str = "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor";
        } else if (qVar.w0()) {
            t0 t10 = t(qVar.j0());
            if (t10 != null) {
                return t10;
            }
            k10 = bb.t.k("Unknown type parameter " + qVar.j0() + ". Please try recompiling module containing \"" + this.f15553d + '\"');
            str = "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )";
        } else if (qVar.x0()) {
            n9.m e10 = this.f15550a.e();
            String a10 = this.f15550a.g().a(qVar.k0());
            Iterator<T> it = k().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (y8.k.a(((a1) obj).c().k(), a10)) {
                    break;
                }
            }
            a1 a1Var = (a1) obj;
            t0 o10 = a1Var != null ? a1Var.o() : null;
            if (o10 == null) {
                k10 = bb.t.k("Deserialized type parameter " + a10 + " in " + e10);
            } else {
                k10 = o10;
            }
            str = "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }";
        } else if (qVar.v0()) {
            n9.h h11 = this.f15556g.h(Integer.valueOf(qVar.i0()));
            if (h11 == null) {
                h11 = s(this, qVar, qVar.i0());
            }
            k10 = h11.o();
            str = "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor";
        } else {
            k10 = bb.t.k("Unknown type");
            str = "createErrorTypeConstructor(\"Unknown type\")";
        }
        y8.k.d(k10, str);
        return k10;
    }

    private static final n9.e s(b0 b0Var, ga.q qVar, int i10) {
        lb.h f10;
        lb.h q10;
        List<Integer> x10;
        lb.h f11;
        int j10;
        la.a a10 = v.a(b0Var.f15550a.g(), i10);
        f10 = lb.l.f(qVar, new e());
        q10 = lb.n.q(f10, f.f15564f);
        x10 = lb.n.x(q10);
        f11 = lb.l.f(a10, d.f15562o);
        j10 = lb.n.j(f11);
        while (x10.size() < j10) {
            x10.add(0);
        }
        return b0Var.f15550a.c().q().d(a10, x10);
    }

    private final t0 t(int i10) {
        a1 a1Var = this.f15557h.get(Integer.valueOf(i10));
        t0 o10 = a1Var == null ? null : a1Var.o();
        if (o10 != null) {
            return o10;
        }
        b0 b0Var = this.f15551b;
        if (b0Var == null) {
            return null;
        }
        return b0Var.t(i10);
    }

    public final boolean j() {
        return this.f15554e;
    }

    public final List<a1> k() {
        List<a1> n02;
        n02 = m8.y.n0(this.f15557h.values());
        return n02;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final bb.i0 l(ga.q r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.b0.l(ga.q, boolean):bb.i0");
    }

    public final bb.b0 p(ga.q qVar) {
        y8.k.e(qVar, "proto");
        if (!qVar.p0()) {
            return l(qVar, true);
        }
        String a10 = this.f15550a.g().a(qVar.c0());
        i0 n10 = n(this, qVar, false, 2, null);
        ga.q c10 = ia.f.c(qVar, this.f15550a.j());
        y8.k.b(c10);
        return this.f15550a.c().l().a(qVar, a10, n10, n(this, c10, false, 2, null));
    }

    public String toString() {
        String str = this.f15552c;
        b0 b0Var = this.f15551b;
        return y8.k.j(str, b0Var == null ? "" : y8.k.j(". Child of ", b0Var.f15552c));
    }
}
