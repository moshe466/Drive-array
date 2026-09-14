package bb;

/* loaded from: classes.dex */
public final class s0 {
    public static final j a(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        db.h Z0 = b0Var.Z0();
        j jVar = Z0 instanceof j ? (j) Z0 : null;
        if (jVar != null && jVar.c()) {
            return jVar;
        }
        return null;
    }

    public static final boolean b(b0 b0Var) {
        y8.k.e(b0Var, "<this>");
        db.h Z0 = b0Var.Z0();
        j jVar = Z0 instanceof j ? (j) Z0 : null;
        if (jVar == null) {
            return false;
        }
        return jVar.c();
    }
}
