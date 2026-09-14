package kotlin.reflect.jvm.internal.impl.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final int f11474f;

    /* renamed from: g, reason: collision with root package name */
    private List<v<K, V>.c> f11475g;

    /* renamed from: h, reason: collision with root package name */
    private Map<K, V> f11476h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11477i;

    /* renamed from: j, reason: collision with root package name */
    private volatile v<K, V>.e f11478j;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* loaded from: classes.dex */
    static class a<FieldDescriptorType> extends v<FieldDescriptorType, Object> {
        a(int i10) {
            super(i10, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.v
        public void n() {
            if (!m()) {
                for (int i10 = 0; i10 < i(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> h10 = h(i10);
                    if (((h.b) h10.getKey()).f()) {
                        h10.setValue(Collections.unmodifiableList((List) h10.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : j()) {
                    if (((h.b) entry.getKey()).f()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.n();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.p((h.b) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f11479a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f11480b = new C0234b();

        /* loaded from: classes.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.v$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0234b implements Iterable<Object> {
            C0234b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f11479a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f11480b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Comparable<v<K, V>.c>, Map.Entry<K, V> {

        /* renamed from: f, reason: collision with root package name */
        private final K f11481f;

        /* renamed from: g, reason: collision with root package name */
        private V f11482g;

        c(K k10, V v10) {
            this.f11481f = k10;
            this.f11482g = v10;
        }

        c(v vVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean k(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return k(this.f11481f, entry.getKey()) && k(this.f11482g, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f11482g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f11481f;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f11482g;
            return hashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(v<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f11481f;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            v.this.f();
            V v11 = this.f11482g;
            this.f11482g = v10;
            return v11;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f11481f);
            String valueOf2 = String.valueOf(this.f11482g);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("=");
            sb2.append(valueOf2);
            return sb2.toString();
        }
    }

    /* loaded from: classes.dex */
    private class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: f, reason: collision with root package name */
        private int f11484f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f11485g;

        /* renamed from: h, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f11486h;

        private d() {
            this.f11484f = -1;
        }

        /* synthetic */ d(v vVar, a aVar) {
            this();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f11486h == null) {
                this.f11486h = v.this.f11476h.entrySet().iterator();
            }
            return this.f11486h;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f11485g = true;
            int i10 = this.f11484f + 1;
            this.f11484f = i10;
            return i10 < v.this.f11475g.size() ? (Map.Entry<K, V>) v.this.f11475g.get(this.f11484f) : b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11484f + 1 < v.this.f11475g.size() || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f11485g) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f11485g = false;
            v.this.f();
            if (this.f11484f >= v.this.f11475g.size()) {
                b().remove();
                return;
            }
            v vVar = v.this;
            int i10 = this.f11484f;
            this.f11484f = i10 - 1;
            vVar.q(i10);
        }
    }

    /* loaded from: classes.dex */
    private class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        /* synthetic */ e(v vVar, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            v.this.p(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = v.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(v.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            v.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }
    }

    private v(int i10) {
        this.f11474f = i10;
        this.f11475g = Collections.emptyList();
        this.f11476h = Collections.emptyMap();
    }

    /* synthetic */ v(int i10, a aVar) {
        this(i10);
    }

    private int e(K k10) {
        int size = this.f11475g.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo(this.f11475g.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int compareTo2 = k10.compareTo(this.f11475g.get(i11).getKey());
            if (compareTo2 < 0) {
                size = i11 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i11;
                }
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f11477i) {
            throw new UnsupportedOperationException();
        }
    }

    private void g() {
        f();
        if (!this.f11475g.isEmpty() || (this.f11475g instanceof ArrayList)) {
            return;
        }
        this.f11475g = new ArrayList(this.f11474f);
    }

    private SortedMap<K, V> k() {
        f();
        if (this.f11476h.isEmpty() && !(this.f11476h instanceof TreeMap)) {
            this.f11476h = new TreeMap();
        }
        return (SortedMap) this.f11476h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends h.b<FieldDescriptorType>> v<FieldDescriptorType, Object> o(int i10) {
        return new a(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V q(int i10) {
        f();
        V value = this.f11475g.remove(i10).getValue();
        if (!this.f11476h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = k().entrySet().iterator();
            this.f11475g.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f11475g.isEmpty()) {
            this.f11475g.clear();
        }
        if (this.f11476h.isEmpty()) {
            return;
        }
        this.f11476h.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f11476h.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f11478j == null) {
            this.f11478j = new e(this, null);
        }
        return this.f11478j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e10 = e(comparable);
        return e10 >= 0 ? this.f11475g.get(e10).getValue() : this.f11476h.get(comparable);
    }

    public Map.Entry<K, V> h(int i10) {
        return this.f11475g.get(i10);
    }

    public int i() {
        return this.f11475g.size();
    }

    public Iterable<Map.Entry<K, V>> j() {
        return this.f11476h.isEmpty() ? b.b() : this.f11476h.entrySet();
    }

    public boolean m() {
        return this.f11477i;
    }

    public void n() {
        if (this.f11477i) {
            return;
        }
        this.f11476h = this.f11476h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f11476h);
        this.f11477i = true;
    }

    public V p(K k10, V v10) {
        f();
        int e10 = e(k10);
        if (e10 >= 0) {
            return this.f11475g.get(e10).setValue(v10);
        }
        g();
        int i10 = -(e10 + 1);
        if (i10 >= this.f11474f) {
            return k().put(k10, v10);
        }
        int size = this.f11475g.size();
        int i11 = this.f11474f;
        if (size == i11) {
            v<K, V>.c remove = this.f11475g.remove(i11 - 1);
            k().put(remove.getKey(), remove.getValue());
        }
        this.f11475g.add(i10, new c(k10, v10));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e10 = e(comparable);
        if (e10 >= 0) {
            return (V) q(e10);
        }
        if (this.f11476h.isEmpty()) {
            return null;
        }
        return this.f11476h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f11475g.size() + this.f11476h.size();
    }
}
