package m9;

import bb.b0;
import bb.c1;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import m8.q;
import m8.q0;
import m8.r0;
import y8.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static final d f12071a = new d();

    private d() {
    }

    public static /* synthetic */ n9.e h(d dVar, la.b bVar, k9.h hVar, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        return dVar.g(bVar, hVar, num);
    }

    public final n9.e a(n9.e eVar) {
        k.e(eVar, "mutable");
        la.b p10 = c.f12055a.p(na.d.m(eVar));
        if (p10 != null) {
            n9.e o10 = ra.a.g(eVar).o(p10);
            k.d(o10, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return o10;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a mutable collection");
    }

    public final n9.e b(n9.e eVar) {
        k.e(eVar, "readOnly");
        la.b q10 = c.f12055a.q(na.d.m(eVar));
        if (q10 != null) {
            n9.e o10 = ra.a.g(eVar).o(q10);
            k.d(o10, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return o10;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a read-only collection");
    }

    public final boolean c(b0 b0Var) {
        k.e(b0Var, "type");
        n9.e f10 = c1.f(b0Var);
        return f10 != null && d(f10);
    }

    public final boolean d(n9.e eVar) {
        k.e(eVar, "mutable");
        return c.f12055a.l(na.d.m(eVar));
    }

    public final boolean e(b0 b0Var) {
        k.e(b0Var, "type");
        n9.e f10 = c1.f(b0Var);
        return f10 != null && f(f10);
    }

    public final boolean f(n9.e eVar) {
        k.e(eVar, "readOnly");
        return c.f12055a.m(na.d.m(eVar));
    }

    public final n9.e g(la.b bVar, k9.h hVar, Integer num) {
        la.a n10;
        k.e(bVar, "fqName");
        k.e(hVar, "builtIns");
        if (num == null || !k.a(bVar, c.f12055a.i())) {
            n10 = c.f12055a.n(bVar);
        } else {
            k9.k kVar = k9.k.f11235a;
            n10 = k9.k.a(num.intValue());
        }
        if (n10 != null) {
            return hVar.o(n10.b());
        }
        return null;
    }

    public final Collection<n9.e> i(la.b bVar, k9.h hVar) {
        List g10;
        Set a10;
        Set b10;
        k.e(bVar, "fqName");
        k.e(hVar, "builtIns");
        n9.e h10 = h(this, bVar, hVar, null, 4, null);
        if (h10 == null) {
            b10 = r0.b();
            return b10;
        }
        la.b q10 = c.f12055a.q(ra.a.j(h10));
        if (q10 == null) {
            a10 = q0.a(h10);
            return a10;
        }
        n9.e o10 = hVar.o(q10);
        k.d(o10, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        g10 = q.g(h10, o10);
        return g10;
    }
}
