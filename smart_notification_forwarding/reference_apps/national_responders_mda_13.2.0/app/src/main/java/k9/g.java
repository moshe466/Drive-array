package k9;

import bb.b0;
import bb.c0;
import bb.i0;
import bb.v0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k9.k;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import l8.t;
import l9.c;
import m8.k0;
import m8.l0;
import m8.q;
import m8.y;
import pa.v;

/* loaded from: classes.dex */
public final class g {
    public static final i0 a(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, b0 b0Var, List<? extends b0> list, List<la.e> list2, b0 b0Var2, boolean z10) {
        y8.k.e(hVar, "builtIns");
        y8.k.e(gVar, "annotations");
        y8.k.e(list, "parameterTypes");
        y8.k.e(b0Var2, "returnType");
        List<v0> e10 = e(b0Var, list, list2, b0Var2, hVar);
        int size = list.size();
        if (b0Var != null) {
            size++;
        }
        n9.e d10 = d(hVar, size, z10);
        if (b0Var != null) {
            gVar = q(gVar, hVar);
        }
        c0 c0Var = c0.f4165a;
        return c0.g(gVar, d10, e10);
    }

    public static final la.e c(b0 b0Var) {
        String b10;
        y8.k.e(b0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e10 = b0Var.u().e(k.a.f11291y);
        if (e10 == null) {
            return null;
        }
        Object e02 = m8.o.e0(e10.a().values());
        v vVar = e02 instanceof v ? (v) e02 : null;
        if (vVar == null || (b10 = vVar.b()) == null || !la.e.t(b10)) {
            b10 = null;
        }
        if (b10 == null) {
            return null;
        }
        return la.e.r(b10);
    }

    public static final n9.e d(h hVar, int i10, boolean z10) {
        y8.k.e(hVar, "builtIns");
        n9.e W = z10 ? hVar.W(i10) : hVar.C(i10);
        y8.k.d(W, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return W;
    }

    public static final List<v0> e(b0 b0Var, List<? extends b0> list, List<la.e> list2, b0 b0Var2, h hVar) {
        la.e eVar;
        Map e10;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> Z;
        y8.k.e(list, "parameterTypes");
        y8.k.e(b0Var2, "returnType");
        y8.k.e(hVar, "builtIns");
        int i10 = 0;
        ArrayList arrayList = new ArrayList(list.size() + (b0Var != null ? 1 : 0) + 1);
        jb.a.a(arrayList, b0Var == null ? null : eb.a.a(b0Var));
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.m();
            }
            b0 b0Var3 = (b0) obj;
            if (list2 == null || (eVar = list2.get(i10)) == null || eVar.s()) {
                eVar = null;
            }
            if (eVar != null) {
                la.b bVar = k.a.f11291y;
                la.e r10 = la.e.r("name");
                String k10 = eVar.k();
                y8.k.d(k10, "name.asString()");
                e10 = k0.e(t.a(r10, new v(k10)));
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.j jVar = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(hVar, bVar, e10);
                g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
                Z = y.Z(b0Var3.u(), jVar);
                b0Var3 = eb.a.l(b0Var3, aVar.a(Z));
            }
            arrayList.add(eb.a.a(b0Var3));
            i10 = i11;
        }
        arrayList.add(eb.a.a(b0Var2));
        return arrayList;
    }

    private static final l9.c f(la.c cVar) {
        if (!cVar.f() || cVar.e()) {
            return null;
        }
        c.a aVar = l9.c.Companion;
        String k10 = cVar.i().k();
        y8.k.d(k10, "shortName().asString()");
        la.b e10 = cVar.l().e();
        y8.k.d(e10, "toSafe().parent()");
        return aVar.b(k10, e10);
    }

    public static final l9.c g(n9.m mVar) {
        y8.k.e(mVar, "<this>");
        if ((mVar instanceof n9.e) && h.I0(mVar)) {
            return f(ra.a.j(mVar));
        }
        return null;
    }

    public static final b0 h(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        m(b0Var);
        if (p(b0Var)) {
            return ((v0) m8.o.H(b0Var.V0())).b();
        }
        return null;
    }

    public static final b0 i(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        m(b0Var);
        b0 b10 = ((v0) m8.o.S(b0Var.V0())).b();
        y8.k.d(b10, "arguments.last().type");
        return b10;
    }

    public static final List<v0> j(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        m(b0Var);
        return b0Var.V0().subList(k(b0Var) ? 1 : 0, r0.size() - 1);
    }

    public static final boolean k(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        return m(b0Var) && p(b0Var);
    }

    public static final boolean l(n9.m mVar) {
        y8.k.e(mVar, "<this>");
        l9.c g10 = g(mVar);
        return g10 == l9.c.Function || g10 == l9.c.SuspendFunction;
    }

    public static final boolean m(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        n9.h o10 = b0Var.W0().o();
        return y8.k.a(o10 == null ? null : Boolean.valueOf(l(o10)), Boolean.TRUE);
    }

    public static final boolean n(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        n9.h o10 = b0Var.W0().o();
        return (o10 == null ? null : g(o10)) == l9.c.Function;
    }

    public static final boolean o(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        n9.h o10 = b0Var.W0().o();
        return (o10 == null ? null : g(o10)) == l9.c.SuspendFunction;
    }

    private static final boolean p(b0 b0Var) {
        return b0Var.u().e(k.a.f11290x) != null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g q(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, h hVar) {
        Map h10;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> Z;
        y8.k.e(gVar, "<this>");
        y8.k.e(hVar, "builtIns");
        la.b bVar = k.a.f11290x;
        if (gVar.r(bVar)) {
            return gVar;
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
        h10 = l0.h();
        Z = y.Z(gVar, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(hVar, bVar, h10));
        return aVar.a(Z);
    }
}
