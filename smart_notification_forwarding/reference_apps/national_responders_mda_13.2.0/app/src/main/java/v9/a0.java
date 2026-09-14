package v9;

import java.util.List;

/* loaded from: classes.dex */
public final class a0 {
    public static final List<la.e> a(la.e eVar) {
        List<la.e> h10;
        y8.k.e(eVar, "name");
        String k10 = eVar.k();
        y8.k.d(k10, "name.asString()");
        x xVar = x.f14811a;
        if (!x.b(k10)) {
            return x.c(k10) ? f(eVar) : g.f14784a.b(eVar);
        }
        h10 = m8.q.h(b(eVar));
        return h10;
    }

    public static final la.e b(la.e eVar) {
        y8.k.e(eVar, "methodName");
        la.e e10 = e(eVar, "get", false, null, 12, null);
        return e10 == null ? e(eVar, "is", false, null, 8, null) : e10;
    }

    public static final la.e c(la.e eVar, boolean z10) {
        y8.k.e(eVar, "methodName");
        return e(eVar, "set", false, z10 ? "is" : null, 4, null);
    }

    private static final la.e d(la.e eVar, String str, boolean z10, String str2) {
        boolean w10;
        String S;
        String S2;
        if (eVar.s()) {
            return null;
        }
        String n10 = eVar.n();
        y8.k.d(n10, "methodName.identifier");
        boolean z11 = false;
        w10 = mb.r.w(n10, str, false, 2, null);
        if (!w10 || n10.length() == str.length()) {
            return null;
        }
        char charAt = n10.charAt(str.length());
        if ('a' <= charAt && charAt <= 'z') {
            z11 = true;
        }
        if (z11) {
            return null;
        }
        if (str2 != null) {
            S2 = mb.s.S(n10, str);
            return la.e.r(y8.k.j(str2, S2));
        }
        if (!z10) {
            return eVar;
        }
        S = mb.s.S(n10, str);
        String c10 = hb.a.c(S, true);
        if (la.e.t(c10)) {
            return la.e.r(c10);
        }
        return null;
    }

    static /* synthetic */ la.e e(la.e eVar, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return d(eVar, str, z10, str2);
    }

    public static final List<la.e> f(la.e eVar) {
        List<la.e> i10;
        y8.k.e(eVar, "methodName");
        i10 = m8.q.i(c(eVar, false), c(eVar, true));
        return i10;
    }
}
