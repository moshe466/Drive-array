package ib;

import java.util.Collection;
import java.util.LinkedHashSet;
import jb.i;
import ua.h;
import y8.k;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        k.e(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final i<h> b(Iterable<? extends h> iterable) {
        k.e(iterable, "scopes");
        i<h> iVar = new i<>();
        for (h hVar : iterable) {
            h hVar2 = hVar;
            if ((hVar2 == null || hVar2 == h.b.f14541b) ? false : true) {
                iVar.add(hVar);
            }
        }
        return iVar;
    }
}
