package j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    c<K, V> f10850f;

    /* renamed from: g, reason: collision with root package name */
    private c<K, V> f10851g;

    /* renamed from: h, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f10852h = new WeakHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private int f10853i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f10857i;
        }

        @Override // j.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f10856h;
        }
    }

    /* renamed from: j.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0209b<K, V> extends e<K, V> {
        C0209b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f10856h;
        }

        @Override // j.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f10857i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: f, reason: collision with root package name */
        final K f10854f;

        /* renamed from: g, reason: collision with root package name */
        final V f10855g;

        /* renamed from: h, reason: collision with root package name */
        c<K, V> f10856h;

        /* renamed from: i, reason: collision with root package name */
        c<K, V> f10857i;

        c(K k10, V v10) {
            this.f10854f = k10;
            this.f10855g = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f10854f.equals(cVar.f10854f) && this.f10855g.equals(cVar.f10855g);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f10854f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f10855g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f10854f.hashCode() ^ this.f10855g.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f10854f + "=" + this.f10855g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: f, reason: collision with root package name */
        private c<K, V> f10858f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f10859g = true;

        d() {
        }

        @Override // j.b.f
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f10858f;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f10857i;
                this.f10858f = cVar3;
                this.f10859g = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f10859g) {
                this.f10859g = false;
                cVar = b.this.f10850f;
            } else {
                c<K, V> cVar2 = this.f10858f;
                cVar = cVar2 != null ? cVar2.f10856h : null;
            }
            this.f10858f = cVar;
            return this.f10858f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f10859g) {
                return b.this.f10850f != null;
            }
            c<K, V> cVar = this.f10858f;
            return (cVar == null || cVar.f10856h == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: f, reason: collision with root package name */
        c<K, V> f10861f;

        /* renamed from: g, reason: collision with root package name */
        c<K, V> f10862g;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f10861f = cVar2;
            this.f10862g = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.f10862g;
            c<K, V> cVar2 = this.f10861f;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // j.b.f
        public void b(c<K, V> cVar) {
            if (this.f10861f == cVar && cVar == this.f10862g) {
                this.f10862g = null;
                this.f10861f = null;
            }
            c<K, V> cVar2 = this.f10861f;
            if (cVar2 == cVar) {
                this.f10861f = c(cVar2);
            }
            if (this.f10862g == cVar) {
                this.f10862g = f();
            }
        }

        abstract c<K, V> c(c<K, V> cVar);

        abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f10862g;
            this.f10862g = f();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10862g != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void b(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> c() {
        C0209b c0209b = new C0209b(this.f10851g, this.f10850f);
        this.f10852h.put(c0209b, Boolean.FALSE);
        return c0209b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry<K, V> f() {
        return this.f10850f;
    }

    protected c<K, V> g(K k10) {
        c<K, V> cVar = this.f10850f;
        while (cVar != null && !cVar.f10854f.equals(k10)) {
            cVar = cVar.f10856h;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().hashCode();
        }
        return i10;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f10850f, this.f10851g);
        this.f10852h.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public b<K, V>.d j() {
        b<K, V>.d dVar = new d();
        this.f10852h.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> l() {
        return this.f10851g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> s(K k10, V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f10853i++;
        c<K, V> cVar2 = this.f10851g;
        if (cVar2 == null) {
            this.f10850f = cVar;
        } else {
            cVar2.f10856h = cVar;
            cVar.f10857i = cVar2;
        }
        this.f10851g = cVar;
        return cVar;
    }

    public int size() {
        return this.f10853i;
    }

    public V t(K k10, V v10) {
        c<K, V> g10 = g(k10);
        if (g10 != null) {
            return g10.f10855g;
        }
        s(k10, v10);
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public V u(K k10) {
        c<K, V> g10 = g(k10);
        if (g10 == null) {
            return null;
        }
        this.f10853i--;
        if (!this.f10852h.isEmpty()) {
            Iterator<f<K, V>> it = this.f10852h.keySet().iterator();
            while (it.hasNext()) {
                it.next().b(g10);
            }
        }
        c<K, V> cVar = g10.f10857i;
        c<K, V> cVar2 = g10.f10856h;
        if (cVar != null) {
            cVar.f10856h = cVar2;
        } else {
            this.f10850f = cVar2;
        }
        c<K, V> cVar3 = g10.f10856h;
        if (cVar3 != null) {
            cVar3.f10857i = cVar;
        } else {
            this.f10851g = cVar;
        }
        g10.f10856h = null;
        g10.f10857i = null;
        return g10.f10855g;
    }
}
