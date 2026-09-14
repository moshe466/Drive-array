package bb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l0 {
    public static final a a(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        g1 Z0 = b0Var.Z0();
        if (Z0 instanceof a) {
            return (a) Z0;
        }
        return null;
    }

    public static final i0 b(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        a a10 = a(b0Var);
        if (a10 == null) {
            return null;
        }
        return a10.i1();
    }

    public static final boolean c(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        return b0Var.Z0() instanceof k;
    }

    private static final a0 d(a0 a0Var) {
        int n10;
        b0 b0Var;
        Collection<b0> x10 = a0Var.x();
        n10 = m8.r.n(x10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = x10.iterator();
        boolean z10 = false;
        while (true) {
            b0Var = null;
            if (!it.hasNext()) {
                break;
            }
            b0 b0Var2 = (b0) it.next();
            if (c1.l(b0Var2)) {
                b0Var2 = f(b0Var2.Z0(), false, 1, null);
                z10 = true;
            }
            arrayList.add(b0Var2);
        }
        if (!z10) {
            return null;
        }
        b0 d10 = a0Var.d();
        if (d10 != null) {
            if (c1.l(d10)) {
                d10 = f(d10.Z0(), false, 1, null);
            }
            b0Var = d10;
        }
        return new a0(arrayList).g(b0Var);
    }

    public static final g1 e(g1 g1Var, boolean z10) {
        y8.k.e(g1Var, "<this>");
        k b10 = k.f4228i.b(g1Var, z10);
        if (b10 != null) {
            return b10;
        }
        i0 g10 = g(g1Var);
        return g10 == null ? g1Var.a1(false) : g10;
    }

    public static /* synthetic */ g1 f(g1 g1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return e(g1Var, z10);
    }

    private static final i0 g(b0 b0Var) {
        a0 d10;
        t0 W0 = b0Var.W0();
        a0 a0Var = W0 instanceof a0 ? (a0) W0 : null;
        if (a0Var == null || (d10 = d(a0Var)) == null) {
            return null;
        }
        return d10.c();
    }

    public static final i0 h(i0 i0Var, boolean z10) {
        y8.k.e(i0Var, "<this>");
        k b10 = k.f4228i.b(i0Var, z10);
        if (b10 != null) {
            return b10;
        }
        i0 g10 = g(i0Var);
        return g10 == null ? i0Var.a1(false) : g10;
    }

    public static /* synthetic */ i0 i(i0 i0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(i0Var, z10);
    }

    public static final i0 j(i0 i0Var, i0 i0Var2) {
        y8.k.e(i0Var, "<this>");
        y8.k.e(i0Var2, "abbreviatedType");
        return d0.a(i0Var) ? i0Var : new a(i0Var, i0Var2);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.checker.i k(kotlin.reflect.jvm.internal.impl.types.checker.i iVar) {
        y8.k.e(iVar, "<this>");
        return new kotlin.reflect.jvm.internal.impl.types.checker.i(iVar.f1(), iVar.W0(), iVar.h1(), iVar.u(), iVar.X0(), true);
    }
}
