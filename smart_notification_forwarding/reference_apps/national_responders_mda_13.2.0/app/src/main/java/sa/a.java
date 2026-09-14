package sa;

import bb.b0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import n9.a1;
import n9.d1;
import n9.e;
import n9.h;
import n9.m;
import n9.t;
import na.f;
import y8.k;

/* loaded from: classes.dex */
public final class a {
    private static final boolean a(e eVar) {
        return k.a(ra.a.i(eVar), k9.k.f11242h);
    }

    public static final boolean b(b0 b0Var) {
        k.e(b0Var, "<this>");
        h o10 = b0Var.W0().o();
        return k.a(o10 == null ? null : Boolean.valueOf(c(o10)), Boolean.TRUE);
    }

    public static final boolean c(m mVar) {
        k.e(mVar, "<this>");
        return f.b(mVar) && !a((e) mVar);
    }

    private static final boolean d(b0 b0Var) {
        h o10 = b0Var.W0().o();
        a1 a1Var = o10 instanceof a1 ? (a1) o10 : null;
        if (a1Var == null) {
            return false;
        }
        return e(eb.a.f(a1Var));
    }

    private static final boolean e(b0 b0Var) {
        return b(b0Var) || d(b0Var);
    }

    public static final boolean f(n9.b bVar) {
        k.e(bVar, "descriptor");
        n9.d dVar = bVar instanceof n9.d ? (n9.d) bVar : null;
        if (dVar == null || t.g(dVar.h())) {
            return false;
        }
        e T = dVar.T();
        k.d(T, "constructorDescriptor.constructedClass");
        if (f.b(T) || na.d.G(dVar.T())) {
            return false;
        }
        List<d1> l10 = dVar.l();
        k.d(l10, "constructorDescriptor.valueParameters");
        if ((l10 instanceof Collection) && l10.isEmpty()) {
            return false;
        }
        Iterator<T> it = l10.iterator();
        while (it.hasNext()) {
            b0 b10 = ((d1) it.next()).b();
            k.d(b10, "it.type");
            if (e(b10)) {
                return true;
            }
        }
        return false;
    }
}
