package t9;

import n9.e;
import n9.g0;
import na.d;
import u9.b;
import u9.c;
import u9.f;
import y8.k;

/* loaded from: classes.dex */
public final class a {
    public static final void a(c cVar, b bVar, e eVar, la.e eVar2) {
        u9.a location;
        k.e(cVar, "<this>");
        k.e(bVar, "from");
        k.e(eVar, "scopeOwner");
        k.e(eVar2, "name");
        if (cVar == c.a.f14494a || (location = bVar.getLocation()) == null) {
            return;
        }
        u9.e a10 = cVar.a() ? location.a() : u9.e.f14495h.a();
        String b10 = location.b();
        String b11 = d.m(eVar).b();
        k.d(b11, "getFqName(scopeOwner).asString()");
        f fVar = f.CLASSIFIER;
        String k10 = eVar2.k();
        k.d(k10, "name.asString()");
        cVar.b(b10, a10, b11, fVar, k10);
    }

    public static final void b(c cVar, b bVar, g0 g0Var, la.e eVar) {
        k.e(cVar, "<this>");
        k.e(bVar, "from");
        k.e(g0Var, "scopeOwner");
        k.e(eVar, "name");
        String b10 = g0Var.f().b();
        k.d(b10, "scopeOwner.fqName.asString()");
        String k10 = eVar.k();
        k.d(k10, "name.asString()");
        c(cVar, bVar, b10, k10);
    }

    public static final void c(c cVar, b bVar, String str, String str2) {
        u9.a location;
        k.e(cVar, "<this>");
        k.e(bVar, "from");
        k.e(str, "packageFqName");
        k.e(str2, "name");
        if (cVar == c.a.f14494a || (location = bVar.getLocation()) == null) {
            return;
        }
        cVar.b(location.b(), cVar.a() ? location.a() : u9.e.f14495h.a(), str, f.PACKAGE, str2);
    }
}
