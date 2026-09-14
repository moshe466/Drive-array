package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.a0;
import bb.b0;
import bb.c0;
import bb.c1;
import bb.e1;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class m implements l {

    /* renamed from: c, reason: collision with root package name */
    private final g f11587c;

    /* renamed from: d, reason: collision with root package name */
    private final na.j f11588d;

    public m(g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        this.f11587c = gVar;
        na.j p10 = na.j.p(d());
        y8.k.d(p10, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f11588d = p10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.l
    public na.j a() {
        return this.f11588d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.f
    public boolean b(b0 b0Var, b0 b0Var2) {
        y8.k.e(b0Var, "subtype");
        y8.k.e(b0Var2, "supertype");
        return f(new a(true, false, false, d(), 6, null), b0Var.Z0(), b0Var2.Z0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.f
    public boolean c(b0 b0Var, b0 b0Var2) {
        y8.k.e(b0Var, "a");
        y8.k.e(b0Var2, "b");
        return e(new a(false, false, false, d(), 6, null), b0Var.Z0(), b0Var2.Z0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.l
    public g d() {
        return this.f11587c;
    }

    public final boolean e(a aVar, g1 g1Var, g1 g1Var2) {
        y8.k.e(aVar, "<this>");
        y8.k.e(g1Var, "a");
        y8.k.e(g1Var2, "b");
        return bb.e.f4186a.i(aVar, g1Var, g1Var2);
    }

    public final boolean f(a aVar, g1 g1Var, g1 g1Var2) {
        y8.k.e(aVar, "<this>");
        y8.k.e(g1Var, "subType");
        y8.k.e(g1Var2, "superType");
        return bb.e.o(bb.e.f4186a, aVar, g1Var, g1Var2, false, 8, null);
    }

    public final i0 g(i0 i0Var) {
        int n10;
        int n11;
        List d10;
        b0 b10;
        int n12;
        y8.k.e(i0Var, "type");
        t0 W0 = i0Var.W0();
        boolean z10 = false;
        a0 a0Var = null;
        r6 = null;
        g1 Z0 = null;
        if (W0 instanceof oa.c) {
            oa.c cVar = (oa.c) W0;
            v0 a10 = cVar.a();
            if (!(a10.c() == h1.IN_VARIANCE)) {
                a10 = null;
            }
            if (a10 != null && (b10 = a10.b()) != null) {
                Z0 = b10.Z0();
            }
            g1 g1Var = Z0;
            if (cVar.c() == null) {
                v0 a11 = cVar.a();
                Collection<b0> x10 = cVar.x();
                n12 = m8.r.n(x10, 10);
                ArrayList arrayList = new ArrayList(n12);
                Iterator<T> it = x10.iterator();
                while (it.hasNext()) {
                    arrayList.add(((b0) it.next()).Z0());
                }
                cVar.e(new j(a11, arrayList, null, 4, null));
            }
            db.b bVar = db.b.FOR_SUBTYPING;
            j c10 = cVar.c();
            y8.k.b(c10);
            return new i(bVar, c10, g1Var, i0Var.u(), i0Var.X0(), false, 32, null);
        }
        if (W0 instanceof pa.p) {
            Collection<b0> x11 = ((pa.p) W0).x();
            n11 = m8.r.n(x11, 10);
            ArrayList arrayList2 = new ArrayList(n11);
            Iterator<T> it2 = x11.iterator();
            while (it2.hasNext()) {
                b0 p10 = c1.p((b0) it2.next(), i0Var.X0());
                y8.k.d(p10, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(p10);
            }
            a0 a0Var2 = new a0(arrayList2);
            c0 c0Var = c0.f4165a;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = i0Var.u();
            d10 = m8.q.d();
            return c0.j(u10, a0Var2, d10, false, i0Var.A());
        }
        if (!(W0 instanceof a0) || !i0Var.X0()) {
            return i0Var;
        }
        a0 a0Var3 = (a0) W0;
        Collection<b0> x12 = a0Var3.x();
        n10 = m8.r.n(x12, 10);
        ArrayList arrayList3 = new ArrayList(n10);
        Iterator<T> it3 = x12.iterator();
        while (it3.hasNext()) {
            arrayList3.add(eb.a.k((b0) it3.next()));
            z10 = true;
        }
        if (z10) {
            b0 d11 = a0Var3.d();
            a0Var = new a0(arrayList3).g(d11 != null ? eb.a.k(d11) : null);
        }
        if (a0Var != null) {
            a0Var3 = a0Var;
        }
        return a0Var3.c();
    }

    public g1 h(g1 g1Var) {
        g1 d10;
        y8.k.e(g1Var, "type");
        if (g1Var instanceof i0) {
            d10 = g((i0) g1Var);
        } else {
            if (!(g1Var instanceof bb.v)) {
                throw new l8.l();
            }
            bb.v vVar = (bb.v) g1Var;
            i0 g10 = g(vVar.e1());
            i0 g11 = g(vVar.f1());
            if (g10 == vVar.e1() && g11 == vVar.f1()) {
                d10 = g1Var;
            } else {
                c0 c0Var = c0.f4165a;
                d10 = c0.d(g10, g11);
            }
        }
        return e1.b(d10, g1Var);
    }
}
