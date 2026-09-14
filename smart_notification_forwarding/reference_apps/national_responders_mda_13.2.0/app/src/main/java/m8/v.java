package m8;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends u {
    public static <T> boolean r(Collection<? super T> collection, Iterable<? extends T> iterable) {
        y8.k.e(collection, "<this>");
        y8.k.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z10 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean s(Collection<? super T> collection, T[] tArr) {
        y8.k.e(collection, "<this>");
        y8.k.e(tArr, "elements");
        return collection.addAll(g.c(tArr));
    }

    public static final <T> boolean t(Collection<? super T> collection, Iterable<? extends T> iterable) {
        y8.k.e(collection, "<this>");
        y8.k.e(iterable, "elements");
        return y8.z.a(collection).retainAll(m.a(iterable, collection));
    }
}
