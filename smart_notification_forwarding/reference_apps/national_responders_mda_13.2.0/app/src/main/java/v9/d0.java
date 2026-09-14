package v9;

import n9.h1;

/* loaded from: classes.dex */
public final class d0 {
    public static final t a(bb.b0 b0Var, String str) {
        Object obj;
        y8.k.e(b0Var, "<this>");
        y8.k.e(str, "value");
        n9.h o10 = b0Var.W0().o();
        if (o10 instanceof n9.e) {
            n9.e eVar = (n9.e) o10;
            if (eVar.r() == n9.f.ENUM_CLASS) {
                ua.h u02 = eVar.u0();
                la.e r10 = la.e.r(str);
                y8.k.d(r10, "identifier(value)");
                n9.h g10 = u02.g(r10, u9.d.FROM_BACKEND);
                if (!(g10 instanceof n9.e)) {
                    return null;
                }
                n9.e eVar2 = (n9.e) g10;
                if (eVar2.r() == n9.f.ENUM_ENTRY) {
                    return new m(eVar2);
                }
                return null;
            }
        }
        bb.b0 j10 = eb.a.j(b0Var);
        jb.f a10 = jb.g.a(str);
        String a11 = a10.a();
        int b10 = a10.b();
        try {
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        if (k9.h.d0(j10)) {
            obj = Boolean.valueOf(Boolean.parseBoolean(str));
        } else if (k9.h.g0(j10)) {
            obj = mb.u.l0(str);
        } else if (k9.h.f0(j10)) {
            obj = mb.q.e(a11, b10);
        } else if (k9.h.A0(j10)) {
            obj = mb.q.j(a11, b10);
        } else if (k9.h.p0(j10)) {
            obj = mb.q.g(a11, b10);
        } else if (k9.h.r0(j10)) {
            obj = mb.q.i(a11, b10);
        } else if (k9.h.n0(j10)) {
            obj = mb.p.d(str);
        } else if (k9.h.l0(j10)) {
            obj = mb.p.c(str);
        } else {
            if (k9.h.C0(j10)) {
                obj = null;
            }
            obj = null;
        }
        if (obj != null) {
            return new j(obj);
        }
        return null;
    }

    public static final n9.u b(h1 h1Var) {
        y8.k.e(h1Var, "<this>");
        n9.u g10 = u.g(h1Var);
        y8.k.d(g10, "toDescriptorVisibility(this)");
        return g10;
    }
}
