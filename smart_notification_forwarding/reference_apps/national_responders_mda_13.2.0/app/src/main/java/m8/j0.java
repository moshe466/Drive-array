package m8;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j0 {
    public static final <K, V> V a(Map<K, ? extends V> map, K k10) {
        y8.k.e(map, "<this>");
        if (map instanceof h0) {
            return (V) ((h0) map).l(k10);
        }
        V v10 = map.get(k10);
        if (v10 != null || map.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }
}
