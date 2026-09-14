package ea;

import bb.b1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m9.c;

/* loaded from: classes.dex */
public final class z {
    public static final <T> T a(k<T> kVar, T t10, boolean z10) {
        y8.k.e(kVar, "<this>");
        y8.k.e(t10, "possiblyPrimitiveType");
        return z10 ? kVar.e(t10) : t10;
    }

    public static final <T> T b(b1 b1Var, db.h hVar, k<T> kVar, y yVar) {
        y8.k.e(b1Var, "<this>");
        y8.k.e(hVar, "type");
        y8.k.e(kVar, "typeFactory");
        y8.k.e(yVar, "mode");
        db.l J = b1Var.J(hVar);
        if (!b1Var.h(J)) {
            return null;
        }
        k9.i N = b1Var.N(J);
        boolean z10 = true;
        if (N != null) {
            T c10 = kVar.c(N);
            if (!b1Var.M(hVar) && !da.r.b(b1Var, hVar)) {
                z10 = false;
            }
            return (T) a(kVar, c10, z10);
        }
        k9.i p10 = b1Var.p(J);
        if (p10 != null) {
            return kVar.a(y8.k.j("[", sa.d.get(p10).getDesc()));
        }
        if (b1Var.e0(J)) {
            la.c O = b1Var.O(J);
            la.a o10 = O == null ? null : m9.c.f12055a.o(O);
            if (o10 != null) {
                if (!yVar.a()) {
                    List<c.a> j10 = m9.c.f12055a.j();
                    if (!(j10 instanceof Collection) || !j10.isEmpty()) {
                        Iterator<T> it = j10.iterator();
                        while (it.hasNext()) {
                            if (y8.k.a(((c.a) it.next()).d(), o10)) {
                                break;
                            }
                        }
                    }
                    z10 = false;
                    if (z10) {
                        return null;
                    }
                }
                String f10 = sa.c.b(o10).f();
                y8.k.d(f10, "byClassId(classId).internalName");
                return kVar.b(f10);
            }
        }
        return null;
    }
}
