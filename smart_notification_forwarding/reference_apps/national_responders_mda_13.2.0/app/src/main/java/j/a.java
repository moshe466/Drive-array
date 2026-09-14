package j;

import j.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: j, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f10849j = new HashMap<>();

    public boolean contains(K k10) {
        return this.f10849j.containsKey(k10);
    }

    @Override // j.b
    protected b.c<K, V> g(K k10) {
        return this.f10849j.get(k10);
    }

    @Override // j.b
    public V t(K k10, V v10) {
        b.c<K, V> g10 = g(k10);
        if (g10 != null) {
            return g10.f10855g;
        }
        this.f10849j.put(k10, s(k10, v10));
        return null;
    }

    @Override // j.b
    public V u(K k10) {
        V v10 = (V) super.u(k10);
        this.f10849j.remove(k10);
        return v10;
    }

    public Map.Entry<K, V> v(K k10) {
        if (contains(k10)) {
            return this.f10849j.get(k10).f10857i;
        }
        return null;
    }
}
