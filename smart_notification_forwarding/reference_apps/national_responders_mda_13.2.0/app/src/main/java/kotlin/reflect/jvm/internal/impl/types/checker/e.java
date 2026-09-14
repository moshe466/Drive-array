package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.c0;
import bb.d0;
import bb.g1;
import bb.i0;
import bb.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e {
    public static final g1 a(List<? extends g1> list) {
        int n10;
        int n11;
        i0 e12;
        y8.k.e(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        }
        if (size == 1) {
            return (g1) m8.o.d0(list);
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        boolean z10 = false;
        boolean z11 = false;
        for (g1 g1Var : list) {
            z10 = z10 || d0.a(g1Var);
            if (g1Var instanceof i0) {
                e12 = (i0) g1Var;
            } else {
                if (!(g1Var instanceof bb.v)) {
                    throw new l8.l();
                }
                if (bb.r.a(g1Var)) {
                    return g1Var;
                }
                e12 = ((bb.v) g1Var).e1();
                z11 = true;
            }
            arrayList.add(e12);
        }
        if (z10) {
            i0 j10 = bb.t.j(y8.k.j("Intersection of error types: ", list));
            y8.k.d(j10, "createErrorType(\"Intersection of error types: $types\")");
            return j10;
        }
        if (!z11) {
            return v.f11595a.c(arrayList);
        }
        n11 = m8.r.n(list, 10);
        ArrayList arrayList2 = new ArrayList(n11);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(y.d((g1) it.next()));
        }
        c0 c0Var = c0.f4165a;
        v vVar = v.f11595a;
        return c0.d(vVar.c(arrayList), vVar.c(arrayList2));
    }
}
