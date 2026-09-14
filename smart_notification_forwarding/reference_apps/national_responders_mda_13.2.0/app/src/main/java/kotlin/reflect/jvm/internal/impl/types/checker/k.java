package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.b0;
import bb.c0;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.u0;
import bb.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.y;
import n9.a1;

/* loaded from: classes.dex */
public final class k {
    private static final List<v0> a(g1 g1Var, db.b bVar) {
        List<l8.n> u02;
        int n10;
        if (g1Var.V0().size() != g1Var.W0().B().size()) {
            return null;
        }
        List<v0> V0 = g1Var.V0();
        int i10 = 0;
        boolean z10 = true;
        if (!(V0 instanceof Collection) || !V0.isEmpty()) {
            Iterator<T> it = V0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!(((v0) it.next()).c() == h1.INVARIANT)) {
                    z10 = false;
                    break;
                }
            }
        }
        if (z10) {
            return null;
        }
        List<a1> B = g1Var.W0().B();
        y8.k.d(B, "type.constructor.parameters");
        u02 = y.u0(V0, B);
        n10 = m8.r.n(u02, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (l8.n nVar : u02) {
            v0 v0Var = (v0) nVar.a();
            a1 a1Var = (a1) nVar.b();
            if (v0Var.c() != h1.INVARIANT) {
                g1 Z0 = (v0Var.d() || v0Var.c() != h1.IN_VARIANCE) ? null : v0Var.b().Z0();
                y8.k.d(a1Var, "parameter");
                v0Var = eb.a.a(new i(bVar, Z0, v0Var, a1Var));
            }
            arrayList.add(v0Var);
        }
        bb.a1 c10 = u0.f4270b.b(g1Var.W0(), arrayList).c();
        int size = V0.size() - 1;
        if (size >= 0) {
            while (true) {
                int i11 = i10 + 1;
                v0 v0Var2 = V0.get(i10);
                v0 v0Var3 = (v0) arrayList.get(i10);
                if (v0Var2.c() != h1.INVARIANT) {
                    List<b0> upperBounds = g1Var.W0().B().get(i10).getUpperBounds();
                    y8.k.d(upperBounds, "type.constructor.parameters[index].upperBounds");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it2 = upperBounds.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(l.f11584b.a().h(c10.n((b0) it2.next(), h1.INVARIANT).Z0()));
                    }
                    if (!v0Var2.d() && v0Var2.c() == h1.OUT_VARIANCE) {
                        arrayList2.add(l.f11584b.a().h(v0Var2.b().Z0()));
                    }
                    ((i) v0Var3.b()).W0().e(arrayList2);
                }
                if (i11 > size) {
                    break;
                }
                i10 = i11;
            }
        }
        return arrayList;
    }

    public static final i0 b(i0 i0Var, db.b bVar) {
        y8.k.e(i0Var, "type");
        y8.k.e(bVar, "status");
        List<v0> a10 = a(i0Var, bVar);
        if (a10 == null) {
            return null;
        }
        return c(i0Var, a10);
    }

    private static final i0 c(g1 g1Var, List<? extends v0> list) {
        c0 c0Var = c0.f4165a;
        return c0.i(g1Var.u(), g1Var.W0(), list, g1Var.X0(), null, 16, null);
    }
}
