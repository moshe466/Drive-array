package bb;

import bb.r0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import ua.h;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4243c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final r0 f4244a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4245b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i10, n9.z0 z0Var) {
            if (i10 > 100) {
                throw new AssertionError(y8.k.j("Too deep recursion while expanding type alias ", z0Var.c()));
            }
        }

        public final void c(r0 r0Var, b0 b0Var, b0 b0Var2, n9.a1 a1Var, a1 a1Var2) {
            y8.k.e(r0Var, "reportStrategy");
            y8.k.e(b0Var, "unsubstitutedArgument");
            y8.k.e(b0Var2, "typeArgument");
            y8.k.e(a1Var, "typeParameterDescriptor");
            y8.k.e(a1Var2, "substitutor");
            Iterator<b0> it = a1Var.getUpperBounds().iterator();
            while (it.hasNext()) {
                b0 n10 = a1Var2.n(it.next(), h1.INVARIANT);
                y8.k.d(n10, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a.b(b0Var2, n10)) {
                    r0Var.b(n10, b0Var, b0Var2, a1Var);
                }
            }
        }
    }

    static {
        new p0(r0.a.f4252a, false);
    }

    public p0(r0 r0Var, boolean z10) {
        y8.k.e(r0Var, "reportStrategy");
        this.f4244a = r0Var;
        this.f4245b = z10;
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().f());
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : gVar2) {
            if (hashSet.contains(cVar.f())) {
                this.f4244a.a(cVar);
            }
        }
    }

    private final void b(b0 b0Var, b0 b0Var2) {
        a1 f10 = a1.f(b0Var2);
        y8.k.d(f10, "create(substitutedType)");
        int i10 = 0;
        for (Object obj : b0Var2.V0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                m8.q.m();
            }
            v0 v0Var = (v0) obj;
            if (!v0Var.d()) {
                b0 b10 = v0Var.b();
                y8.k.d(b10, "substitutedArgument.type");
                if (!eb.a.c(b10)) {
                    v0 v0Var2 = b0Var.V0().get(i10);
                    n9.a1 a1Var = b0Var.W0().B().get(i10);
                    if (this.f4245b) {
                        a aVar = f4243c;
                        r0 r0Var = this.f4244a;
                        b0 b11 = v0Var2.b();
                        y8.k.d(b11, "unsubstitutedArgument.type");
                        b0 b12 = v0Var.b();
                        y8.k.d(b12, "substitutedArgument.type");
                        y8.k.d(a1Var, "typeParameter");
                        aVar.c(r0Var, b11, b12, a1Var, f10);
                    }
                }
            }
            i10 = i11;
        }
    }

    private final q c(q qVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        return qVar.c1(h(qVar, gVar));
    }

    private final i0 d(i0 i0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        return d0.a(i0Var) ? i0Var : z0.f(i0Var, null, h(i0Var, gVar), 1, null);
    }

    private final i0 e(i0 i0Var, b0 b0Var) {
        i0 r10 = c1.r(i0Var, b0Var.X0());
        y8.k.d(r10, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
        return r10;
    }

    private final i0 f(i0 i0Var, b0 b0Var) {
        return d(e(i0Var, b0Var), b0Var.u());
    }

    private final i0 g(q0 q0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10) {
        c0 c0Var = c0.f4165a;
        t0 o10 = q0Var.b().o();
        y8.k.d(o10, "descriptor.typeConstructor");
        return c0.j(gVar, o10, q0Var.a(), z10, h.b.f14541b);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g h(b0 b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        boolean a10 = d0.a(b0Var);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = b0Var.u();
        return a10 ? u10 : kotlin.reflect.jvm.internal.impl.descriptors.annotations.i.a(gVar, u10);
    }

    private final v0 j(v0 v0Var, q0 q0Var, int i10) {
        int n10;
        g1 Z0 = v0Var.b().Z0();
        if (r.a(Z0)) {
            return v0Var;
        }
        i0 a10 = z0.a(Z0);
        if (d0.a(a10) || !eb.a.n(a10)) {
            return v0Var;
        }
        t0 W0 = a10.W0();
        n9.h o10 = W0.o();
        W0.B().size();
        a10.V0().size();
        if (o10 instanceof n9.a1) {
            return v0Var;
        }
        if (!(o10 instanceof n9.z0)) {
            i0 m10 = m(a10, q0Var, i10);
            b(a10, m10);
            return new x0(v0Var.c(), m10);
        }
        n9.z0 z0Var = (n9.z0) o10;
        if (q0Var.d(z0Var)) {
            this.f4244a.d(z0Var);
            return new x0(h1.INVARIANT, t.j(y8.k.j("Recursive type alias: ", z0Var.c())));
        }
        List<v0> V0 = a10.V0();
        n10 = m8.r.n(V0, 10);
        ArrayList arrayList = new ArrayList(n10);
        int i11 = 0;
        for (Object obj : V0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                m8.q.m();
            }
            arrayList.add(l((v0) obj, q0Var, W0.B().get(i11), i10 + 1));
            i11 = i12;
        }
        i0 k10 = k(q0.f4247e.a(q0Var, z0Var, arrayList), a10.u(), a10.X0(), i10 + 1, false);
        i0 m11 = m(a10, q0Var, i10);
        if (!r.a(k10)) {
            k10 = l0.j(k10, m11);
        }
        return new x0(v0Var.c(), k10);
    }

    private final i0 k(q0 q0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, int i10, boolean z11) {
        v0 l10 = l(new x0(h1.INVARIANT, q0Var.b().L()), q0Var, null, i10);
        b0 b10 = l10.b();
        y8.k.d(b10, "expandedProjection.type");
        i0 a10 = z0.a(b10);
        if (d0.a(a10)) {
            return a10;
        }
        l10.c();
        a(a10.u(), gVar);
        i0 r10 = c1.r(d(a10, gVar), z10);
        y8.k.d(r10, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        return z11 ? l0.j(r10, g(q0Var, gVar, z10)) : r10;
    }

    private final v0 l(v0 v0Var, q0 q0Var, n9.a1 a1Var, int i10) {
        h1 h1Var;
        h1 h1Var2;
        f4243c.b(i10, q0Var.b());
        if (!v0Var.d()) {
            b0 b10 = v0Var.b();
            y8.k.d(b10, "underlyingProjection.type");
            v0 c10 = q0Var.c(b10.W0());
            if (c10 == null) {
                return j(v0Var, q0Var, i10);
            }
            if (!c10.d()) {
                g1 Z0 = c10.b().Z0();
                h1 c11 = c10.c();
                y8.k.d(c11, "argument.projectionKind");
                h1 c12 = v0Var.c();
                y8.k.d(c12, "underlyingProjection.projectionKind");
                if (c12 != c11 && c12 != (h1Var2 = h1.INVARIANT)) {
                    if (c11 == h1Var2) {
                        c11 = c12;
                    } else {
                        this.f4244a.c(q0Var.b(), a1Var, Z0);
                    }
                }
                h1 v10 = a1Var == null ? null : a1Var.v();
                if (v10 == null) {
                    v10 = h1.INVARIANT;
                }
                y8.k.d(v10, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
                if (v10 != c11 && v10 != (h1Var = h1.INVARIANT)) {
                    if (c11 == h1Var) {
                        c11 = h1Var;
                    } else {
                        this.f4244a.c(q0Var.b(), a1Var, Z0);
                    }
                }
                a(b10.u(), Z0.u());
                return new x0(c11, Z0 instanceof q ? c((q) Z0, b10.u()) : f(z0.a(Z0), b10));
            }
        }
        y8.k.b(a1Var);
        v0 s10 = c1.s(a1Var);
        y8.k.d(s10, "makeStarProjection(typeParameterDescriptor!!)");
        return s10;
    }

    private final i0 m(i0 i0Var, q0 q0Var, int i10) {
        int n10;
        t0 W0 = i0Var.W0();
        List<v0> V0 = i0Var.V0();
        n10 = m8.r.n(V0, 10);
        ArrayList arrayList = new ArrayList(n10);
        int i11 = 0;
        for (Object obj : V0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                m8.q.m();
            }
            v0 v0Var = (v0) obj;
            v0 l10 = l(v0Var, q0Var, W0.B().get(i11), i10 + 1);
            if (!l10.d()) {
                l10 = new x0(l10.c(), c1.q(l10.b(), v0Var.b().X0()));
            }
            arrayList.add(l10);
            i11 = i12;
        }
        return z0.f(i0Var, arrayList, null, 2, null);
    }

    public final i0 i(q0 q0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(q0Var, "typeAliasExpansion");
        y8.k.e(gVar, "annotations");
        return k(q0Var, gVar, false, 0, true);
    }
}
