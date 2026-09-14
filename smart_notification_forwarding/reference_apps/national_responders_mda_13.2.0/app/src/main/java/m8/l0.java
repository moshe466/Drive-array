package m8;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l0 extends k0 {
    public static <K, V> Map<K, V> h() {
        b0 b0Var = b0.f12033f;
        y8.k.c(b0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return b0Var;
    }

    public static <K, V> V i(Map<K, ? extends V> map, K k10) {
        y8.k.e(map, "<this>");
        return (V) j0.a(map, k10);
    }

    public static <K, V> HashMap<K, V> j(Pair<? extends K, ? extends V>... pairArr) {
        y8.k.e(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(i0.d(pairArr.length));
        o(hashMap, pairArr);
        return hashMap;
    }

    public static <K, V> Map<K, V> k(Pair<? extends K, ? extends V>... pairArr) {
        y8.k.e(pairArr, "pairs");
        return pairArr.length > 0 ? s(pairArr, new LinkedHashMap(i0.d(pairArr.length))) : i0.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> l(Map<K, ? extends V> map) {
        y8.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : k0.f(map) : i0.h();
    }

    public static <K, V> Map<K, V> m(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        y8.k.e(map, "<this>");
        y8.k.e(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void n(Map<? super K, ? super V> map, Iterable<? extends l8.n<? extends K, ? extends V>> iterable) {
        y8.k.e(map, "<this>");
        y8.k.e(iterable, "pairs");
        for (l8.n<? extends K, ? extends V> nVar : iterable) {
            map.put(nVar.a(), nVar.b());
        }
    }

    public static final <K, V> void o(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        y8.k.e(map, "<this>");
        y8.k.e(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((Object) pair.a(), (Object) pair.b());
        }
    }

    public static <K, V> Map<K, V> p(Iterable<? extends l8.n<? extends K, ? extends V>> iterable) {
        y8.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return l(q(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i0.h();
        }
        if (size != 1) {
            return q(iterable, new LinkedHashMap(i0.d(collection.size())));
        }
        return i0.e(iterable instanceof List ? (l8.n<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M q(Iterable<? extends l8.n<? extends K, ? extends V>> iterable, M m10) {
        y8.k.e(iterable, "<this>");
        y8.k.e(m10, "destination");
        n(m10, iterable);
        return m10;
    }

    public static <K, V> Map<K, V> r(Map<? extends K, ? extends V> map) {
        y8.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? i0.t(map) : k0.f(map) : i0.h();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M s(Pair<? extends K, ? extends V>[] pairArr, M m10) {
        y8.k.e(pairArr, "<this>");
        y8.k.e(m10, "destination");
        o(m10, pairArr);
        return m10;
    }

    public static <K, V> Map<K, V> t(Map<? extends K, ? extends V> map) {
        y8.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
