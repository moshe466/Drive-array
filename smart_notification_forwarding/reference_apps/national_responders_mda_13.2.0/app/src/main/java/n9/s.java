package n9;

/* loaded from: classes.dex */
public final class s {
    public static final e a(d0 d0Var, la.b bVar, u9.b bVar2) {
        ua.h u02;
        h g10;
        y8.k.e(d0Var, "<this>");
        y8.k.e(bVar, "fqName");
        y8.k.e(bVar2, "lookupLocation");
        if (bVar.d()) {
            return null;
        }
        la.b e10 = bVar.e();
        y8.k.d(e10, "fqName.parent()");
        ua.h A = d0Var.C(e10).A();
        la.e g11 = bVar.g();
        y8.k.d(g11, "fqName.shortName()");
        h g12 = A.g(g11, bVar2);
        e eVar = g12 instanceof e ? (e) g12 : null;
        if (eVar != null) {
            return eVar;
        }
        la.b e11 = bVar.e();
        y8.k.d(e11, "fqName.parent()");
        e a10 = a(d0Var, e11, bVar2);
        if (a10 == null || (u02 = a10.u0()) == null) {
            g10 = null;
        } else {
            la.e g13 = bVar.g();
            y8.k.d(g13, "fqName.shortName()");
            g10 = u02.g(g13, bVar2);
        }
        if (g10 instanceof e) {
            return (e) g10;
        }
        return null;
    }
}
