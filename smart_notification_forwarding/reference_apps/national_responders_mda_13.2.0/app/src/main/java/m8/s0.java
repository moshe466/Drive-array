package m8;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s0 extends r0 {
    public static <T> Set<T> f(Set<? extends T> set, Iterable<? extends T> iterable) {
        y8.k.e(set, "<this>");
        y8.k.e(iterable, "elements");
        Collection<?> a10 = m.a(iterable, set);
        if (a10.isEmpty()) {
            return o.r0(set);
        }
        if (!(a10 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(a10);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t10 : set) {
            if (!a10.contains(t10)) {
                linkedHashSet2.add(t10);
            }
        }
        return linkedHashSet2;
    }

    public static <T> Set<T> g(Set<? extends T> set, Iterable<? extends T> iterable) {
        int size;
        y8.k.e(set, "<this>");
        y8.k.e(iterable, "elements");
        Integer o10 = r.o(iterable);
        if (o10 != null) {
            size = set.size() + o10.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.d(size));
        linkedHashSet.addAll(set);
        o.r(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static <T> Set<T> h(Set<? extends T> set, T t10) {
        y8.k.e(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.d(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }
}
