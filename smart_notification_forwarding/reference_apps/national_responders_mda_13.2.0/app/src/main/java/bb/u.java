package bb;

import java.util.HashSet;

/* loaded from: classes.dex */
public final class u {
    public static final db.h a(b1 b1Var, db.h hVar) {
        y8.k.e(b1Var, "<this>");
        y8.k.e(hVar, "inlineClassType");
        return b(b1Var, hVar, new HashSet());
    }

    private static final db.h b(b1 b1Var, db.h hVar, HashSet<db.l> hashSet) {
        db.h b10;
        db.l J = b1Var.J(hVar);
        if (!hashSet.add(J)) {
            return null;
        }
        db.m P = b1Var.P(J);
        if (P != null) {
            b10 = b(b1Var, b1Var.K(P), hashSet);
            if (b10 == null) {
                return null;
            }
            if (!b1Var.M(b10) && b1Var.V(hVar)) {
                return b1Var.b0(b10);
            }
        } else {
            if (!b1Var.w(J)) {
                return hVar;
            }
            db.h t10 = b1Var.t(hVar);
            if (t10 == null || (b10 = b(b1Var, t10, hashSet)) == null) {
                return null;
            }
            if (b1Var.M(hVar)) {
                return b1Var.M(b10) ? hVar : ((b10 instanceof db.i) && b1Var.f0((db.i) b10)) ? hVar : b1Var.b0(b10);
            }
        }
        return b10;
    }
}
