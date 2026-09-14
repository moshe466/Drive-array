package l;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: m, reason: collision with root package name */
    f<K, V> f11712m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0244a extends f<K, V> {
        C0244a() {
        }

        @Override // l.f
        protected void a() {
            a.this.clear();
        }

        @Override // l.f
        protected Object b(int i10, int i11) {
            return a.this.f11761g[(i10 << 1) + i11];
        }

        @Override // l.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // l.f
        protected int d() {
            return a.this.f11762h;
        }

        @Override // l.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // l.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // l.f
        protected void g(K k10, V v10) {
            a.this.put(k10, v10);
        }

        @Override // l.f
        protected void h(int i10) {
            a.this.k(i10);
        }

        @Override // l.f
        protected V i(int i10, V v10) {
            return a.this.m(i10, v10);
        }
    }

    public a() {
    }

    public a(int i10) {
        super(i10);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> o() {
        if (this.f11712m == null) {
            this.f11712m = new C0244a();
        }
        return this.f11712m;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return o().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return o().m();
    }

    public boolean p(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f11762h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return o().n();
    }
}
