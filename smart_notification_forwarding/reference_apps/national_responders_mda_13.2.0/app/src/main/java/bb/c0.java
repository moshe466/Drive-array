package bb;

import bb.r0;
import java.util.List;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f4165a = new c0();

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l {

        /* renamed from: f, reason: collision with root package name */
        public static final a f4166f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "$noName_0");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final i0 f4167a;

        /* renamed from: b, reason: collision with root package name */
        private final t0 f4168b;

        public b(i0 i0Var, t0 t0Var) {
            this.f4167a = i0Var;
            this.f4168b = t0Var;
        }

        public final i0 a() {
            return this.f4167a;
        }

        public final t0 b() {
            return this.f4168b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, i0> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ t0 f4170g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List<v0> f4171h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f4172i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f4173j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(t0 t0Var, List<? extends v0> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10) {
            super(1);
            this.f4170g = t0Var;
            this.f4171h = list;
            this.f4172i = gVar;
            this.f4173j = z10;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "refiner");
            b f10 = c0.this.f(this.f4170g, gVar, this.f4171h);
            if (f10 == null) {
                return null;
            }
            i0 a10 = f10.a();
            if (a10 != null) {
                return a10;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2 = this.f4172i;
            t0 b10 = f10.b();
            y8.k.b(b10);
            return c0.h(gVar2, b10, this.f4171h, this.f4173j, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends y8.l implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, i0> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ t0 f4175g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List<v0> f4176h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f4177i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f4178j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ua.h f4179k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(t0 t0Var, List<? extends v0> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, ua.h hVar) {
            super(1);
            this.f4175g = t0Var;
            this.f4176h = list;
            this.f4177i = gVar;
            this.f4178j = z10;
            this.f4179k = hVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "kotlinTypeRefiner");
            b f10 = c0.this.f(this.f4175g, gVar, this.f4176h);
            if (f10 == null) {
                return null;
            }
            i0 a10 = f10.a();
            if (a10 != null) {
                return a10;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2 = this.f4177i;
            t0 b10 = f10.b();
            y8.k.b(b10);
            return c0.j(gVar2, b10, this.f4176h, this.f4178j, this.f4179k);
        }
    }

    static {
        a aVar = a.f4166f;
    }

    private c0() {
    }

    public static final i0 b(n9.z0 z0Var, List<? extends v0> list) {
        y8.k.e(z0Var, "<this>");
        y8.k.e(list, "arguments");
        return new p0(r0.a.f4252a, false).i(q0.f4247e.a(null, z0Var, list), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b());
    }

    private final ua.h c(t0 t0Var, List<? extends v0> list, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        n9.h o10 = t0Var.o();
        if (o10 instanceof n9.a1) {
            return o10.s().A();
        }
        if (o10 instanceof n9.e) {
            if (gVar == null) {
                gVar = ra.a.k(ra.a.l(o10));
            }
            n9.e eVar = (n9.e) o10;
            return list.isEmpty() ? p9.u.b(eVar, gVar) : p9.u.a(eVar, u0.f4270b.b(t0Var, list), gVar);
        }
        if (o10 instanceof n9.z0) {
            ua.h i10 = t.i(y8.k.j("Scope for abbreviation: ", ((n9.z0) o10).c()), true);
            y8.k.d(i10, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
            return i10;
        }
        if (t0Var instanceof a0) {
            return ((a0) t0Var).b();
        }
        throw new IllegalStateException("Unsupported classifier: " + o10 + " for constructor: " + t0Var);
    }

    public static final g1 d(i0 i0Var, i0 i0Var2) {
        y8.k.e(i0Var, "lowerBound");
        y8.k.e(i0Var2, "upperBound");
        return y8.k.a(i0Var, i0Var2) ? i0Var : new w(i0Var, i0Var2);
    }

    public static final i0 e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, pa.n nVar, boolean z10) {
        List d10;
        y8.k.e(gVar, "annotations");
        y8.k.e(nVar, "constructor");
        d10 = m8.q.d();
        ua.h i10 = t.i("Scope for integer literal type", true);
        y8.k.d(i10, "createErrorScope(\"Scope for integer literal type\", true)");
        return j(gVar, nVar, d10, z10, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b f(t0 t0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, List<? extends v0> list) {
        n9.h o10 = t0Var.o();
        n9.h e10 = o10 == null ? null : gVar.e(o10);
        if (e10 == null) {
            return null;
        }
        if (e10 instanceof n9.z0) {
            return new b(b((n9.z0) e10, list), null);
        }
        t0 y10 = e10.o().y(gVar);
        y8.k.d(y10, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
        return new b(null, y10);
    }

    public static final i0 g(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, n9.e eVar, List<? extends v0> list) {
        y8.k.e(gVar, "annotations");
        y8.k.e(eVar, "descriptor");
        y8.k.e(list, "arguments");
        t0 o10 = eVar.o();
        y8.k.d(o10, "descriptor.typeConstructor");
        return i(gVar, o10, list, false, null, 16, null);
    }

    public static final i0 h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, t0 t0Var, List<? extends v0> list, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.g gVar2) {
        y8.k.e(gVar, "annotations");
        y8.k.e(t0Var, "constructor");
        y8.k.e(list, "arguments");
        if (!gVar.isEmpty() || !list.isEmpty() || z10 || t0Var.o() == null) {
            c0 c0Var = f4165a;
            return k(gVar, t0Var, list, z10, c0Var.c(t0Var, list, gVar2), new c(t0Var, list, gVar, z10));
        }
        n9.h o10 = t0Var.o();
        y8.k.b(o10);
        i0 s10 = o10.s();
        y8.k.d(s10, "constructor.declarationDescriptor!!.defaultType");
        return s10;
    }

    public static /* synthetic */ i0 i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, t0 t0Var, List list, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.g gVar2, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            gVar2 = null;
        }
        return h(gVar, t0Var, list, z10, gVar2);
    }

    public static final i0 j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, t0 t0Var, List<? extends v0> list, boolean z10, ua.h hVar) {
        y8.k.e(gVar, "annotations");
        y8.k.e(t0Var, "constructor");
        y8.k.e(list, "arguments");
        y8.k.e(hVar, "memberScope");
        j0 j0Var = new j0(t0Var, list, z10, hVar, new d(t0Var, list, gVar, z10, hVar));
        return gVar.isEmpty() ? j0Var : new h(j0Var, gVar);
    }

    public static final i0 k(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, t0 t0Var, List<? extends v0> list, boolean z10, ua.h hVar, x8.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends i0> lVar) {
        y8.k.e(gVar, "annotations");
        y8.k.e(t0Var, "constructor");
        y8.k.e(list, "arguments");
        y8.k.e(hVar, "memberScope");
        y8.k.e(lVar, "refinedTypeFactory");
        j0 j0Var = new j0(t0Var, list, z10, hVar, lVar);
        return gVar.isEmpty() ? j0Var : new h(j0Var, gVar);
    }
}
