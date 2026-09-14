package da;

import bb.b0;
import bb.c0;
import bb.c1;
import bb.d0;
import bb.e1;
import bb.g1;
import bb.h0;
import bb.h1;
import bb.i0;
import bb.l0;
import bb.t0;
import bb.v;
import bb.v0;
import bb.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final y9.c f8759a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f8760a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8761b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f8762c;

        public a(b0 b0Var, int i10, boolean z10) {
            y8.k.e(b0Var, "type");
            this.f8760a = b0Var;
            this.f8761b = i10;
            this.f8762c = z10;
        }

        public final int a() {
            return this.f8761b;
        }

        public b0 b() {
            return this.f8760a;
        }

        public final b0 c() {
            b0 b10 = b();
            if (d()) {
                return b10;
            }
            return null;
        }

        public final boolean d() {
            return this.f8762c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name */
        private final i0 f8763d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i0 i0Var, int i10, boolean z10) {
            super(i0Var, i10, z10);
            y8.k.e(i0Var, "type");
            this.f8763d = i0Var;
        }

        @Override // da.d.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public i0 b() {
            return this.f8763d;
        }
    }

    public d(y9.c cVar) {
        y8.k.e(cVar, "javaResolverSettings");
        this.f8759a = cVar;
    }

    private final b0 a(b0 b0Var, b0 b0Var2) {
        b0 a10 = e1.a(b0Var2);
        b0 a11 = e1.a(b0Var);
        if (a11 == null) {
            if (a10 == null) {
                return null;
            }
            a11 = a10;
        }
        if (a10 == null) {
            return a11;
        }
        c0 c0Var = c0.f4165a;
        return c0.d(y.c(a11), y.d(a10));
    }

    private final b c(i0 i0Var, x8.l<? super Integer, e> lVar, int i10, p pVar, boolean z10) {
        n9.h o10;
        c e10;
        int n10;
        c h10;
        List i11;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d10;
        v0 d11;
        if ((q.a(pVar) || !i0Var.V0().isEmpty()) && (o10 = i0Var.W0().o()) != null) {
            e h11 = lVar.h(Integer.valueOf(i10));
            e10 = t.e(o10, h11, pVar);
            n9.h hVar = (n9.h) e10.a();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = e10.b();
            t0 o11 = hVar.o();
            y8.k.d(o11, "enhancedClassifier.typeConstructor");
            int i12 = i10 + 1;
            boolean z11 = b10 != null;
            List<v0> V0 = i0Var.V0();
            n10 = m8.r.n(V0, 10);
            ArrayList arrayList = new ArrayList(n10);
            int i13 = 0;
            for (Object obj : V0) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    m8.q.m();
                }
                v0 v0Var = (v0) obj;
                if (v0Var.d()) {
                    e h12 = lVar.h(Integer.valueOf(i12));
                    int i15 = i12 + 1;
                    if (h12.c() != h.NOT_NULL || z10) {
                        d11 = c1.s(hVar.o().B().get(i13));
                        y8.k.d(d11, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                    } else {
                        b0 j10 = eb.a.j(v0Var.b().Z0());
                        h1 c10 = v0Var.c();
                        y8.k.d(c10, "arg.projectionKind");
                        d11 = eb.a.d(j10, c10, o11.B().get(i13));
                    }
                    i12 = i15;
                } else {
                    a e11 = e(v0Var.b().Z0(), lVar, i12);
                    z11 = z11 || e11.d();
                    i12 += e11.a();
                    b0 b11 = e11.b();
                    h1 c11 = v0Var.c();
                    y8.k.d(c11, "arg.projectionKind");
                    d11 = eb.a.d(b11, c11, o11.B().get(i13));
                }
                arrayList.add(d11);
                i13 = i14;
            }
            h10 = t.h(i0Var, h11, pVar);
            boolean booleanValue = ((Boolean) h10.a()).booleanValue();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b12 = h10.b();
            int i16 = i12 - i10;
            if (!(z11 || b12 != null)) {
                return new b(i0Var, i16, false);
            }
            boolean z12 = false;
            i11 = m8.q.i(i0Var.u(), b10, b12);
            d10 = t.d(i11);
            c0 c0Var = c0.f4165a;
            i0 i17 = c0.i(d10, o11, arrayList, booleanValue, null, 16, null);
            g1 g1Var = i17;
            if (h11.d()) {
                g1Var = f(i17);
            }
            if (b12 != null && h11.e()) {
                z12 = true;
            }
            if (z12) {
                g1Var = e1.d(i0Var, g1Var);
            }
            return new b((i0) g1Var, i16, true);
        }
        return new b(i0Var, 1, false);
    }

    static /* synthetic */ b d(d dVar, i0 i0Var, x8.l lVar, int i10, p pVar, boolean z10, int i11, Object obj) {
        return dVar.c(i0Var, lVar, i10, pVar, (i11 & 8) != 0 ? false : z10);
    }

    private final a e(g1 g1Var, x8.l<? super Integer, e> lVar, int i10) {
        g1 d10;
        if (d0.a(g1Var)) {
            return new a(g1Var, 1, false);
        }
        if (!(g1Var instanceof v)) {
            if (g1Var instanceof i0) {
                return d(this, (i0) g1Var, lVar, i10, p.INFLEXIBLE, false, 8, null);
            }
            throw new l8.l();
        }
        boolean z10 = g1Var instanceof h0;
        v vVar = (v) g1Var;
        b c10 = c(vVar.e1(), lVar, i10, p.FLEXIBLE_LOWER, z10);
        b c11 = c(vVar.f1(), lVar, i10, p.FLEXIBLE_UPPER, z10);
        c10.a();
        c11.a();
        boolean z11 = c10.d() || c11.d();
        b0 a10 = a(c10.b(), c11.b());
        if (z11) {
            if (g1Var instanceof aa.f) {
                d10 = new aa.f(c10.b(), c11.b());
            } else {
                c0 c0Var = c0.f4165a;
                d10 = c0.d(c10.b(), c11.b());
            }
            g1Var = e1.d(d10, a10);
        }
        return new a(g1Var, c10.a(), z11);
    }

    private final i0 f(i0 i0Var) {
        return this.f8759a.a() ? l0.h(i0Var, true) : new g(i0Var);
    }

    public final b0 b(b0 b0Var, x8.l<? super Integer, e> lVar) {
        y8.k.e(b0Var, "<this>");
        y8.k.e(lVar, "qualifiers");
        return e(b0Var.Z0(), lVar, 0).c();
    }
}
