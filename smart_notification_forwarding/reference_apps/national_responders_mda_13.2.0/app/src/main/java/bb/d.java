package bb;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4185a = new d();

    private d() {
    }

    private final boolean a(db.n nVar, db.i iVar, db.i iVar2) {
        int y10;
        if (nVar.y(iVar) == nVar.y(iVar2) && nVar.m(iVar) == nVar.m(iVar2)) {
            if ((nVar.L(iVar) == null) == (nVar.L(iVar2) == null) && nVar.W(nVar.a(iVar), nVar.a(iVar2))) {
                if (!nVar.Z(iVar, iVar2) && (y10 = nVar.y(iVar)) > 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        db.k f10 = nVar.f(iVar, i10);
                        db.k f11 = nVar.f(iVar2, i10);
                        if (nVar.x(f10) != nVar.x(f11)) {
                            return false;
                        }
                        if (!nVar.x(f10) && (nVar.o(f10) != nVar.o(f11) || !c(nVar, nVar.g(f10), nVar.g(f11)))) {
                            return false;
                        }
                        if (i11 >= y10) {
                            break;
                        }
                        i10 = i11;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(db.n nVar, db.h hVar, db.h hVar2) {
        if (hVar == hVar2) {
            return true;
        }
        db.i b10 = nVar.b(hVar);
        db.i b11 = nVar.b(hVar2);
        if (b10 != null && b11 != null) {
            return a(nVar, b10, b11);
        }
        db.f R = nVar.R(hVar);
        db.f R2 = nVar.R(hVar2);
        return R != null && R2 != null && a(nVar, nVar.c(R), nVar.c(R2)) && a(nVar, nVar.e(R), nVar.e(R2));
    }

    public final boolean b(db.n nVar, db.h hVar, db.h hVar2) {
        y8.k.e(nVar, "context");
        y8.k.e(hVar, "a");
        y8.k.e(hVar2, "b");
        return c(nVar, hVar, hVar2);
    }
}
