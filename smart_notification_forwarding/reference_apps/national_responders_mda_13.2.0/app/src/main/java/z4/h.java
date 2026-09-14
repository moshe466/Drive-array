package z4;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    private static final Comparator<Comparable> f16193m = new a();

    /* renamed from: f, reason: collision with root package name */
    Comparator<? super K> f16194f;

    /* renamed from: g, reason: collision with root package name */
    e<K, V> f16195g;

    /* renamed from: h, reason: collision with root package name */
    int f16196h;

    /* renamed from: i, reason: collision with root package name */
    int f16197i;

    /* renamed from: j, reason: collision with root package name */
    final e<K, V> f16198j;

    /* renamed from: k, reason: collision with root package name */
    private h<K, V>.b f16199k;

    /* renamed from: l, reason: collision with root package name */
    private h<K, V>.c f16200l;

    /* loaded from: classes.dex */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes.dex */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return b();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c10;
            if (!(obj instanceof Map.Entry) || (c10 = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(c10, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f16196h;
        }
    }

    /* loaded from: classes.dex */
    final class c extends AbstractSet<K> {

        /* loaded from: classes.dex */
        class a extends h<K, V>.d<K> {
            a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f16212k;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f16196h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: f, reason: collision with root package name */
        e<K, V> f16203f;

        /* renamed from: g, reason: collision with root package name */
        e<K, V> f16204g = null;

        /* renamed from: h, reason: collision with root package name */
        int f16205h;

        d() {
            this.f16203f = h.this.f16198j.f16210i;
            this.f16205h = h.this.f16197i;
        }

        final e<K, V> b() {
            e<K, V> eVar = this.f16203f;
            h hVar = h.this;
            if (eVar == hVar.f16198j) {
                throw new NoSuchElementException();
            }
            if (hVar.f16197i != this.f16205h) {
                throw new ConcurrentModificationException();
            }
            this.f16203f = eVar.f16210i;
            this.f16204g = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f16203f != h.this.f16198j;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f16204g;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f16204g = null;
            this.f16205h = h.this.f16197i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: f, reason: collision with root package name */
        e<K, V> f16207f;

        /* renamed from: g, reason: collision with root package name */
        e<K, V> f16208g;

        /* renamed from: h, reason: collision with root package name */
        e<K, V> f16209h;

        /* renamed from: i, reason: collision with root package name */
        e<K, V> f16210i;

        /* renamed from: j, reason: collision with root package name */
        e<K, V> f16211j;

        /* renamed from: k, reason: collision with root package name */
        final K f16212k;

        /* renamed from: l, reason: collision with root package name */
        V f16213l;

        /* renamed from: m, reason: collision with root package name */
        int f16214m;

        e() {
            this.f16212k = null;
            this.f16211j = this;
            this.f16210i = this;
        }

        e(e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f16207f = eVar;
            this.f16212k = k10;
            this.f16214m = 1;
            this.f16210i = eVar2;
            this.f16211j = eVar3;
            eVar3.f16210i = this;
            eVar2.f16211j = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f16208g; eVar2 != null; eVar2 = eVar2.f16208g) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f16209h; eVar2 != null; eVar2 = eVar2.f16209h) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f16212k;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f16213l;
            Object value = entry.getValue();
            if (v10 == null) {
                if (value != null) {
                    return false;
                }
            } else if (!v10.equals(value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f16212k;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f16213l;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f16212k;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f16213l;
            return hashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = this.f16213l;
            this.f16213l = v10;
            return v11;
        }

        public String toString() {
            return this.f16212k + "=" + this.f16213l;
        }
    }

    public h() {
        this(f16193m);
    }

    public h(Comparator<? super K> comparator) {
        this.f16196h = 0;
        this.f16197i = 0;
        this.f16198j = new e<>();
        this.f16194f = comparator == null ? f16193m : comparator;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z10) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f16208g;
            e<K, V> eVar3 = eVar.f16209h;
            int i10 = eVar2 != null ? eVar2.f16214m : 0;
            int i11 = eVar3 != null ? eVar3.f16214m : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e<K, V> eVar4 = eVar3.f16208g;
                e<K, V> eVar5 = eVar3.f16209h;
                int i13 = (eVar4 != null ? eVar4.f16214m : 0) - (eVar5 != null ? eVar5.f16214m : 0);
                if (i13 != -1 && (i13 != 0 || z10)) {
                    j(eVar3);
                }
                i(eVar);
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                e<K, V> eVar6 = eVar2.f16208g;
                e<K, V> eVar7 = eVar2.f16209h;
                int i14 = (eVar6 != null ? eVar6.f16214m : 0) - (eVar7 != null ? eVar7.f16214m : 0);
                if (i14 != 1 && (i14 != 0 || z10)) {
                    i(eVar2);
                }
                j(eVar);
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f16214m = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f16214m = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f16207f;
        }
    }

    private void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f16207f;
        eVar.f16207f = null;
        if (eVar2 != null) {
            eVar2.f16207f = eVar3;
        }
        if (eVar3 == null) {
            this.f16195g = eVar2;
        } else if (eVar3.f16208g == eVar) {
            eVar3.f16208g = eVar2;
        } else {
            eVar3.f16209h = eVar2;
        }
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f16208g;
        e<K, V> eVar3 = eVar.f16209h;
        e<K, V> eVar4 = eVar3.f16208g;
        e<K, V> eVar5 = eVar3.f16209h;
        eVar.f16209h = eVar4;
        if (eVar4 != null) {
            eVar4.f16207f = eVar;
        }
        h(eVar, eVar3);
        eVar3.f16208g = eVar;
        eVar.f16207f = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f16214m : 0, eVar4 != null ? eVar4.f16214m : 0) + 1;
        eVar.f16214m = max;
        eVar3.f16214m = Math.max(max, eVar5 != null ? eVar5.f16214m : 0) + 1;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f16208g;
        e<K, V> eVar3 = eVar.f16209h;
        e<K, V> eVar4 = eVar2.f16208g;
        e<K, V> eVar5 = eVar2.f16209h;
        eVar.f16208g = eVar5;
        if (eVar5 != null) {
            eVar5.f16207f = eVar;
        }
        h(eVar, eVar2);
        eVar2.f16209h = eVar;
        eVar.f16207f = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f16214m : 0, eVar5 != null ? eVar5.f16214m : 0) + 1;
        eVar.f16214m = max;
        eVar2.f16214m = Math.max(max, eVar4 != null ? eVar4.f16214m : 0) + 1;
    }

    e<K, V> b(K k10, boolean z10) {
        int i10;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f16194f;
        e<K, V> eVar2 = this.f16195g;
        if (eVar2 != null) {
            Comparable comparable = comparator == f16193m ? (Comparable) k10 : null;
            while (true) {
                K k11 = eVar2.f16212k;
                i10 = comparable != null ? comparable.compareTo(k11) : comparator.compare(k10, k11);
                if (i10 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i10 < 0 ? eVar2.f16208g : eVar2.f16209h;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.f16198j;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k10, eVar4, eVar4.f16211j);
            if (i10 < 0) {
                eVar2.f16208g = eVar;
            } else {
                eVar2.f16209h = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f16193m && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k10, eVar4, eVar4.f16211j);
            this.f16195g = eVar;
        }
        this.f16196h++;
        this.f16197i++;
        return eVar;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> d10 = d(entry.getKey());
        if (d10 != null && a(d10.f16213l, entry.getValue())) {
            return d10;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f16195g = null;
        this.f16196h = 0;
        this.f16197i++;
        e<K, V> eVar = this.f16198j;
        eVar.f16211j = eVar;
        eVar.f16210i = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f16199k;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f16199k = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z10) {
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f16211j;
            eVar2.f16210i = eVar.f16210i;
            eVar.f16210i.f16211j = eVar2;
        }
        e<K, V> eVar3 = eVar.f16208g;
        e<K, V> eVar4 = eVar.f16209h;
        e<K, V> eVar5 = eVar.f16207f;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f16208g = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f16209h = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f16196h--;
            this.f16197i++;
            return;
        }
        e<K, V> b10 = eVar3.f16214m > eVar4.f16214m ? eVar3.b() : eVar4.a();
        f(b10, false);
        e<K, V> eVar6 = eVar.f16208g;
        if (eVar6 != null) {
            i10 = eVar6.f16214m;
            b10.f16208g = eVar6;
            eVar6.f16207f = b10;
            eVar.f16208g = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar7 = eVar.f16209h;
        if (eVar7 != null) {
            i11 = eVar7.f16214m;
            b10.f16209h = eVar7;
            eVar7.f16207f = b10;
            eVar.f16209h = null;
        }
        b10.f16214m = Math.max(i10, i11) + 1;
        h(eVar, b10);
    }

    e<K, V> g(Object obj) {
        e<K, V> d10 = d(obj);
        if (d10 != null) {
            f(d10, true);
        }
        return d10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> d10 = d(obj);
        if (d10 != null) {
            return d10.f16213l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f16200l;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f16200l = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        Objects.requireNonNull(k10, "key == null");
        e<K, V> b10 = b(k10, true);
        V v11 = b10.f16213l;
        b10.f16213l = v10;
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> g10 = g(obj);
        if (g10 != null) {
            return g10.f16213l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f16196h;
    }
}
