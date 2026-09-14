package m8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class m {
    public static final <T> Collection<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        List n02;
        y8.k.e(iterable, "<this>");
        y8.k.e(iterable2, "source");
        if (!(iterable instanceof Set)) {
            if (iterable instanceof Collection) {
                if (!(iterable2 instanceof Collection) || ((Collection) iterable2).size() >= 2) {
                    Collection<T> collection = (Collection) iterable;
                    if (!b(collection)) {
                        return collection;
                    }
                }
            } else if (!n.f12046a) {
                n02 = y.n0(iterable);
                return n02;
            }
            return y.l0(iterable);
        }
        return (Collection) iterable;
    }

    private static final <T> boolean b(Collection<? extends T> collection) {
        return n.f12046a && collection.size() > 2 && (collection instanceof ArrayList);
    }
}
