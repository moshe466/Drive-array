package ea;

import bb.b0;
import ea.j;
import java.util.Iterator;
import java.util.List;
import k9.k;
import n9.d1;
import n9.s0;
import n9.u0;

/* loaded from: classes.dex */
public final class t {
    private static final void a(StringBuilder sb2, b0 b0Var) {
        sb2.append(g(b0Var));
    }

    public static final String b(n9.x xVar, boolean z10, boolean z11) {
        String k10;
        y8.k.e(xVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            if (xVar instanceof n9.l) {
                k10 = "<init>";
            } else {
                k10 = xVar.c().k();
                y8.k.d(k10, "name.asString()");
            }
            sb2.append(k10);
        }
        sb2.append("(");
        s0 U = xVar.U();
        if (U != null) {
            b0 b10 = U.b();
            y8.k.d(b10, "it.type");
            a(sb2, b10);
        }
        Iterator<d1> it = xVar.l().iterator();
        while (it.hasNext()) {
            b0 b11 = it.next().b();
            y8.k.d(b11, "parameter.type");
            a(sb2, b11);
        }
        sb2.append(")");
        if (z10) {
            if (c.c(xVar)) {
                sb2.append("V");
            } else {
                b0 i10 = xVar.i();
                y8.k.b(i10);
                a(sb2, i10);
            }
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static /* synthetic */ String c(n9.x xVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return b(xVar, z10, z11);
    }

    public static final String d(n9.a aVar) {
        y8.k.e(aVar, "<this>");
        v vVar = v.f9330a;
        if (na.d.E(aVar)) {
            return null;
        }
        n9.m d10 = aVar.d();
        n9.e eVar = d10 instanceof n9.e ? (n9.e) d10 : null;
        if (eVar == null || eVar.c().s()) {
            return null;
        }
        n9.a a10 = aVar.a();
        u0 u0Var = a10 instanceof u0 ? (u0) a10 : null;
        if (u0Var == null) {
            return null;
        }
        return s.a(vVar, eVar, c(u0Var, false, false, 3, null));
    }

    public static final boolean e(n9.a aVar) {
        y8.k.e(aVar, "f");
        if (!(aVar instanceof n9.x)) {
            return false;
        }
        n9.x xVar = (n9.x) aVar;
        if (!y8.k.a(xVar.c().k(), "remove") || xVar.l().size() != 1 || v9.b0.h((n9.b) aVar)) {
            return false;
        }
        List<d1> l10 = xVar.a().l();
        y8.k.d(l10, "f.original.valueParameters");
        b0 b10 = ((d1) m8.o.d0(l10)).b();
        y8.k.d(b10, "f.original.valueParameters.single().type");
        j g10 = g(b10);
        j.d dVar = g10 instanceof j.d ? (j.d) g10 : null;
        if ((dVar != null ? dVar.i() : null) != sa.d.INT) {
            return false;
        }
        v9.f fVar = v9.f.f14781m;
        n9.x k10 = v9.f.k(xVar);
        if (k10 == null) {
            return false;
        }
        List<d1> l11 = k10.a().l();
        y8.k.d(l11, "overridden.original.valueParameters");
        b0 b11 = ((d1) m8.o.d0(l11)).b();
        y8.k.d(b11, "overridden.original.valueParameters.single().type");
        j g11 = g(b11);
        n9.m d10 = k10.d();
        y8.k.d(d10, "overridden.containingDeclaration");
        return y8.k.a(ra.a.j(d10), k.a.R.j()) && (g11 instanceof j.c) && y8.k.a(((j.c) g11).i(), "java/lang/Object");
    }

    public static final String f(n9.e eVar) {
        y8.k.e(eVar, "<this>");
        m9.c cVar = m9.c.f12055a;
        la.c j10 = ra.a.i(eVar).j();
        y8.k.d(j10, "fqNameSafe.toUnsafe()");
        la.a o10 = cVar.o(j10);
        if (o10 == null) {
            return c.b(eVar, null, 2, null);
        }
        String f10 = sa.c.b(o10).f();
        y8.k.d(f10, "byClassId(it).internalName");
        return f10;
    }

    public static final j g(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        return (j) c.e(b0Var, l.f9321a, y.f9335m, x.f9332a, null, null, 32, null);
    }
}
