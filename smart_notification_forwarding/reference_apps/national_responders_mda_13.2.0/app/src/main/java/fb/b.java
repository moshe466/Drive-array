package fb;

import bb.b0;
import bb.c0;
import bb.c1;
import bb.e1;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.u0;
import bb.v0;
import bb.x0;
import bb.y;
import bb.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k9.h;
import l8.n;
import m8.r;
import n9.a1;
import oa.d;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9684a;

        static {
            int[] iArr = new int[h1.valuesCustom().length];
            iArr[h1.INVARIANT.ordinal()] = 1;
            iArr[h1.IN_VARIANCE.ordinal()] = 2;
            iArr[h1.OUT_VARIANCE.ordinal()] = 3;
            f9684a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: fb.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0171b extends l implements x8.l<g1, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final C0171b f9685f = new C0171b();

        C0171b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean h(g1 g1Var) {
            k.d(g1Var, "it");
            return Boolean.valueOf(d.d(g1Var));
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends u0 {
        c() {
        }

        @Override // bb.u0
        public v0 j(t0 t0Var) {
            k.e(t0Var, "key");
            oa.b bVar = t0Var instanceof oa.b ? (oa.b) t0Var : null;
            if (bVar == null) {
                return null;
            }
            return bVar.a().d() ? new x0(h1.OUT_VARIANCE, bVar.a().b()) : bVar.a();
        }
    }

    public static final fb.a<b0> a(b0 b0Var) {
        List<n> u02;
        Object e10;
        k.e(b0Var, "type");
        if (y.b(b0Var)) {
            fb.a<b0> a10 = a(y.c(b0Var));
            fb.a<b0> a11 = a(y.d(b0Var));
            c0 c0Var = c0.f4165a;
            return new fb.a<>(e1.b(c0.d(y.c(a10.c()), y.d(a11.c())), b0Var), e1.b(c0.d(y.c(a10.d()), y.d(a11.d())), b0Var));
        }
        t0 W0 = b0Var.W0();
        if (d.d(b0Var)) {
            v0 a12 = ((oa.b) W0).a();
            b0 b10 = a12.b();
            k.d(b10, "typeProjection.type");
            b0 b11 = b(b10, b0Var);
            int i10 = a.f9684a[a12.c().ordinal()];
            if (i10 == 2) {
                i0 I = eb.a.e(b0Var).I();
                k.d(I, "type.builtIns.nullableAnyType");
                return new fb.a<>(b11, I);
            }
            if (i10 != 3) {
                throw new AssertionError(k.j("Only nontrivial projections should have been captured, not: ", a12));
            }
            i0 H = eb.a.e(b0Var).H();
            k.d(H, "type.builtIns.nothingType");
            return new fb.a<>(b(H, b0Var), b11);
        }
        if (b0Var.V0().isEmpty() || b0Var.V0().size() != W0.B().size()) {
            return new fb.a<>(b0Var, b0Var);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<v0> V0 = b0Var.V0();
        List<a1> B = W0.B();
        k.d(B, "typeConstructor.parameters");
        u02 = m8.y.u0(V0, B);
        for (n nVar : u02) {
            v0 v0Var = (v0) nVar.a();
            a1 a1Var = (a1) nVar.b();
            k.d(a1Var, "typeParameter");
            fb.c g10 = g(v0Var, a1Var);
            if (v0Var.d()) {
                arrayList.add(g10);
            } else {
                fb.a<fb.c> d10 = d(g10);
                fb.c a13 = d10.a();
                g10 = d10.b();
                arrayList.add(a13);
            }
            arrayList2.add(g10);
        }
        boolean z10 = true;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((fb.c) it.next()).d()) {
                    break;
                }
            }
        }
        z10 = false;
        if (z10) {
            e10 = eb.a.e(b0Var).H();
            k.d(e10, "type.builtIns.nothingType");
        } else {
            e10 = e(b0Var, arrayList);
        }
        return new fb.a<>(e10, e(b0Var, arrayList2));
    }

    private static final b0 b(b0 b0Var, b0 b0Var2) {
        b0 q10 = c1.q(b0Var, b0Var2.X0());
        k.d(q10, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return q10;
    }

    public static final v0 c(v0 v0Var, boolean z10) {
        if (v0Var == null) {
            return null;
        }
        if (v0Var.d()) {
            return v0Var;
        }
        b0 b10 = v0Var.b();
        k.d(b10, "typeProjection.type");
        if (!c1.c(b10, C0171b.f9685f)) {
            return v0Var;
        }
        h1 c10 = v0Var.c();
        k.d(c10, "typeProjection.projectionKind");
        return c10 == h1.OUT_VARIANCE ? new x0(c10, a(b10).d()) : z10 ? new x0(c10, a(b10).c()) : f(v0Var);
    }

    private static final fb.a<fb.c> d(fb.c cVar) {
        fb.a<b0> a10 = a(cVar.a());
        b0 a11 = a10.a();
        b0 b10 = a10.b();
        fb.a<b0> a12 = a(cVar.b());
        return new fb.a<>(new fb.c(cVar.c(), b10, a12.a()), new fb.c(cVar.c(), a11, a12.b()));
    }

    private static final b0 e(b0 b0Var, List<fb.c> list) {
        int n10;
        b0Var.V0().size();
        list.size();
        n10 = r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(h((fb.c) it.next()));
        }
        return z0.e(b0Var, arrayList, null, null, 6, null);
    }

    private static final v0 f(v0 v0Var) {
        bb.a1 g10 = bb.a1.g(new c());
        k.d(g10, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return g10.t(v0Var);
    }

    private static final fb.c g(v0 v0Var, a1 a1Var) {
        int i10 = a.f9684a[bb.a1.c(a1Var.v(), v0Var).ordinal()];
        if (i10 == 1) {
            b0 b10 = v0Var.b();
            k.d(b10, "type");
            b0 b11 = v0Var.b();
            k.d(b11, "type");
            return new fb.c(a1Var, b10, b11);
        }
        if (i10 == 2) {
            b0 b12 = v0Var.b();
            k.d(b12, "type");
            i0 I = ra.a.g(a1Var).I();
            k.d(I, "typeParameter.builtIns.nullableAnyType");
            return new fb.c(a1Var, b12, I);
        }
        if (i10 != 3) {
            throw new l8.l();
        }
        i0 H = ra.a.g(a1Var).H();
        k.d(H, "typeParameter.builtIns.nothingType");
        b0 b13 = v0Var.b();
        k.d(b13, "type");
        return new fb.c(a1Var, H, b13);
    }

    private static final v0 h(fb.c cVar) {
        cVar.d();
        if (!k.a(cVar.a(), cVar.b())) {
            h1 v10 = cVar.c().v();
            h1 h1Var = h1.IN_VARIANCE;
            if (v10 != h1Var) {
                if ((!h.t0(cVar.a()) || cVar.c().v() == h1Var) && h.v0(cVar.b())) {
                    return new x0(i(cVar, h1Var), cVar.a());
                }
                return new x0(i(cVar, h1.OUT_VARIANCE), cVar.b());
            }
        }
        return new x0(cVar.a());
    }

    private static final h1 i(fb.c cVar, h1 h1Var) {
        return h1Var == cVar.c().v() ? h1.INVARIANT : h1Var;
    }
}
