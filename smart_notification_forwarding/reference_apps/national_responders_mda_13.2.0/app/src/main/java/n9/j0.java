package n9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class j0 {
    public static final void a(h0 h0Var, la.b bVar, Collection<g0> collection) {
        y8.k.e(h0Var, "<this>");
        y8.k.e(bVar, "fqName");
        y8.k.e(collection, "packageFragments");
        if (h0Var instanceof k0) {
            ((k0) h0Var).b(bVar, collection);
        } else {
            collection.addAll(h0Var.a(bVar));
        }
    }

    public static final List<g0> b(h0 h0Var, la.b bVar) {
        y8.k.e(h0Var, "<this>");
        y8.k.e(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        a(h0Var, bVar, arrayList);
        return arrayList;
    }
}
