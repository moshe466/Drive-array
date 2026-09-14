package na;

import bb.a1;
import bb.b0;
import bb.h1;
import java.util.List;
import n9.d1;
import n9.e1;
import n9.p0;
import n9.q0;

/* loaded from: classes.dex */
public final class f {
    static {
        new la.b("kotlin.jvm.JvmInline");
    }

    public static final boolean a(n9.a aVar) {
        y8.k.e(aVar, "<this>");
        if (aVar instanceof q0) {
            p0 y02 = ((q0) aVar).y0();
            y8.k.d(y02, "correspondingProperty");
            if (d(y02)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(n9.m mVar) {
        y8.k.e(mVar, "<this>");
        if (mVar instanceof n9.e) {
            n9.e eVar = (n9.e) mVar;
            if (eVar.x() || eVar.j0()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        n9.h o10 = b0Var.W0().o();
        if (o10 == null) {
            return false;
        }
        return b(o10);
    }

    public static final boolean d(e1 e1Var) {
        y8.k.e(e1Var, "<this>");
        if (e1Var.U() != null) {
            return false;
        }
        n9.m d10 = e1Var.d();
        y8.k.d(d10, "this.containingDeclaration");
        if (!b(d10)) {
            return false;
        }
        d1 f10 = f((n9.e) d10);
        return y8.k.a(f10 == null ? null : f10.c(), e1Var.c());
    }

    public static final b0 e(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        d1 g10 = g(b0Var);
        if (g10 == null) {
            return null;
        }
        return a1.f(b0Var).p(g10.b(), h1.INVARIANT);
    }

    public static final d1 f(n9.e eVar) {
        n9.d w02;
        List<d1> l10;
        y8.k.e(eVar, "<this>");
        if (!b(eVar) || (w02 = eVar.w0()) == null || (l10 = w02.l()) == null) {
            return null;
        }
        return (d1) m8.o.f0(l10);
    }

    public static final d1 g(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        n9.h o10 = b0Var.W0().o();
        if (!(o10 instanceof n9.e)) {
            o10 = null;
        }
        n9.e eVar = (n9.e) o10;
        if (eVar == null) {
            return null;
        }
        return f(eVar);
    }
}
