package da;

import bb.b1;
import java.util.Set;
import m8.s0;
import v9.y;

/* loaded from: classes.dex */
public final class r {
    public static final e a(h hVar, f fVar, boolean z10, boolean z11) {
        return (z11 && hVar == h.NOT_NULL) ? new e(hVar, fVar, true, z10) : new e(hVar, fVar, false, z10);
    }

    public static final boolean b(b1 b1Var, db.h hVar) {
        y8.k.e(b1Var, "<this>");
        y8.k.e(hVar, "type");
        la.b bVar = y.f14827o;
        y8.k.d(bVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return b1Var.d0(hVar, bVar);
    }

    public static final h c(Set<? extends h> set, h hVar, boolean z10) {
        y8.k.e(set, "<this>");
        h hVar2 = h.FORCE_FLEXIBILITY;
        return hVar == hVar2 ? hVar2 : (h) d(set, h.NOT_NULL, h.NULLABLE, hVar, z10);
    }

    public static final <T> T d(Set<? extends T> set, T t10, T t11, T t12, boolean z10) {
        Set h10;
        Set<? extends T> r02;
        y8.k.e(set, "<this>");
        y8.k.e(t10, "low");
        y8.k.e(t11, "high");
        if (z10) {
            T t13 = set.contains(t10) ? t10 : set.contains(t11) ? t11 : null;
            if (y8.k.a(t13, t10) && y8.k.a(t12, t11)) {
                return null;
            }
            return t12 == null ? t13 : t12;
        }
        if (t12 != null) {
            h10 = s0.h(set, t12);
            r02 = m8.y.r0(h10);
            if (r02 != null) {
                set = r02;
            }
        }
        return (T) m8.o.e0(set);
    }
}
