package m8;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k0 extends j0 {
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        y8.k.e(map, "builder");
        return ((n8.c) map).j();
    }

    public static <K, V> Map<K, V> c() {
        return new n8.c();
    }

    public static int d(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> Map<K, V> e(l8.n<? extends K, ? extends V> nVar) {
        y8.k.e(nVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(nVar.c(), nVar.d());
        y8.k.d(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> f(Map<? extends K, ? extends V> map) {
        y8.k.e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        y8.k.d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static <K, V> SortedMap<K, V> g(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        y8.k.e(map, "<this>");
        y8.k.e(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
