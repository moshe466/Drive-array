package n8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import m8.g0;
import m8.j;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class c<K, V> implements Map<K, V>, Serializable, z8.a {

    /* renamed from: r, reason: collision with root package name */
    private static final a f12240r = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private K[] f12241f;

    /* renamed from: g, reason: collision with root package name */
    private V[] f12242g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f12243h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f12244i;

    /* renamed from: j, reason: collision with root package name */
    private int f12245j;

    /* renamed from: k, reason: collision with root package name */
    private int f12246k;

    /* renamed from: l, reason: collision with root package name */
    private int f12247l;

    /* renamed from: m, reason: collision with root package name */
    private int f12248m;

    /* renamed from: n, reason: collision with root package name */
    private n8.e<K> f12249n;

    /* renamed from: o, reason: collision with root package name */
    private n8.f<V> f12250o;

    /* renamed from: p, reason: collision with root package name */
    private n8.d<K, V> f12251p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12252q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i10) {
            int a10;
            a10 = d9.f.a(i10, 1);
            return Integer.highestOneBit(a10 * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }
    }

    /* loaded from: classes.dex */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, z8.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c<K, V> cVar) {
            super(cVar);
            k.e(cVar, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C0256c<K, V> next() {
            if (b() >= ((c) d()).f12246k) {
                throw new NoSuchElementException();
            }
            int b10 = b();
            g(b10 + 1);
            h(b10);
            C0256c<K, V> c0256c = new C0256c<>(d(), c());
            f();
            return c0256c;
        }

        public final void j(StringBuilder sb2) {
            k.e(sb2, "sb");
            if (b() >= ((c) d()).f12246k) {
                throw new NoSuchElementException();
            }
            int b10 = b();
            g(b10 + 1);
            h(b10);
            Object obj = ((c) d()).f12241f[c()];
            if (k.a(obj, d())) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = ((c) d()).f12242g;
            k.b(objArr);
            Object obj2 = objArr[c()];
            if (k.a(obj2, d())) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            f();
        }

        public final int k() {
            if (b() >= ((c) d()).f12246k) {
                throw new NoSuchElementException();
            }
            int b10 = b();
            g(b10 + 1);
            h(b10);
            Object obj = ((c) d()).f12241f[c()];
            int hashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((c) d()).f12242g;
            k.b(objArr);
            Object obj2 = objArr[c()];
            int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            f();
            return hashCode2;
        }
    }

    /* renamed from: n8.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0256c<K, V> implements Map.Entry<K, V>, z8.a {

        /* renamed from: f, reason: collision with root package name */
        private final c<K, V> f12253f;

        /* renamed from: g, reason: collision with root package name */
        private final int f12254g;

        public C0256c(c<K, V> cVar, int i10) {
            k.e(cVar, "map");
            this.f12253f = cVar;
            this.f12254g = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (k.a(entry.getKey(), getKey()) && k.a(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((c) this.f12253f).f12241f[this.f12254g];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((c) this.f12253f).f12242g;
            k.b(objArr);
            return (V) objArr[this.f12254g];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            this.f12253f.k();
            Object[] i10 = this.f12253f.i();
            int i11 = this.f12254g;
            V v11 = (V) i10[i11];
            i10[i11] = v10;
            return v11;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class d<K, V> {

        /* renamed from: f, reason: collision with root package name */
        private final c<K, V> f12255f;

        /* renamed from: g, reason: collision with root package name */
        private int f12256g;

        /* renamed from: h, reason: collision with root package name */
        private int f12257h;

        public d(c<K, V> cVar) {
            k.e(cVar, "map");
            this.f12255f = cVar;
            this.f12257h = -1;
            f();
        }

        public final int b() {
            return this.f12256g;
        }

        public final int c() {
            return this.f12257h;
        }

        public final c<K, V> d() {
            return this.f12255f;
        }

        public final void f() {
            while (this.f12256g < ((c) this.f12255f).f12246k) {
                int[] iArr = ((c) this.f12255f).f12243h;
                int i10 = this.f12256g;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f12256g = i10 + 1;
                }
            }
        }

        public final void g(int i10) {
            this.f12256g = i10;
        }

        public final void h(int i10) {
            this.f12257h = i10;
        }

        public final boolean hasNext() {
            return this.f12256g < ((c) this.f12255f).f12246k;
        }

        public final void remove() {
            if (!(this.f12257h != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f12255f.k();
            this.f12255f.L(this.f12257h);
            this.f12257h = -1;
        }
    }

    /* loaded from: classes.dex */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, z8.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c<K, V> cVar) {
            super(cVar);
            k.e(cVar, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (b() >= ((c) d()).f12246k) {
                throw new NoSuchElementException();
            }
            int b10 = b();
            g(b10 + 1);
            h(b10);
            K k10 = (K) ((c) d()).f12241f[c()];
            f();
            return k10;
        }
    }

    /* loaded from: classes.dex */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, z8.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c<K, V> cVar) {
            super(cVar);
            k.e(cVar, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (b() >= ((c) d()).f12246k) {
                throw new NoSuchElementException();
            }
            int b10 = b();
            g(b10 + 1);
            h(b10);
            Object[] objArr = ((c) d()).f12242g;
            k.b(objArr);
            V v10 = (V) objArr[c()];
            f();
            return v10;
        }
    }

    public c() {
        this(8);
    }

    public c(int i10) {
        this(n8.b.a(i10), null, new int[i10], new int[f12240r.c(i10)], 2, 0);
    }

    private c(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.f12241f = kArr;
        this.f12242g = vArr;
        this.f12243h = iArr;
        this.f12244i = iArr2;
        this.f12245j = i10;
        this.f12246k = i11;
        this.f12247l = f12240r.d(y());
    }

    private final int C(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * (-1640531527)) >>> this.f12247l;
    }

    private final boolean E(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        s(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (F(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    private final boolean F(Map.Entry<? extends K, ? extends V> entry) {
        int h10 = h(entry.getKey());
        V[] i10 = i();
        if (h10 >= 0) {
            i10[h10] = entry.getValue();
            return true;
        }
        int i11 = (-h10) - 1;
        if (k.a(entry.getValue(), i10[i11])) {
            return false;
        }
        i10[i11] = entry.getValue();
        return true;
    }

    private final boolean G(int i10) {
        int C = C(this.f12241f[i10]);
        int i11 = this.f12245j;
        while (true) {
            int[] iArr = this.f12244i;
            if (iArr[C] == 0) {
                iArr[C] = i10 + 1;
                this.f12243h[i10] = C;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            C = C == 0 ? y() - 1 : C - 1;
        }
    }

    private final void H(int i10) {
        if (this.f12246k > size()) {
            m();
        }
        int i11 = 0;
        if (i10 != y()) {
            this.f12244i = new int[i10];
            this.f12247l = f12240r.d(i10);
        } else {
            j.g(this.f12244i, 0, 0, y());
        }
        while (i11 < this.f12246k) {
            int i12 = i11 + 1;
            if (!G(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    private final void J(int i10) {
        int c10;
        c10 = d9.f.c(this.f12245j * 2, y() / 2);
        int i11 = c10;
        int i12 = 0;
        int i13 = i10;
        do {
            i10 = i10 == 0 ? y() - 1 : i10 - 1;
            i12++;
            if (i12 > this.f12245j) {
                this.f12244i[i13] = 0;
                return;
            }
            int[] iArr = this.f12244i;
            int i14 = iArr[i10];
            if (i14 == 0) {
                iArr[i13] = 0;
                return;
            }
            if (i14 < 0) {
                iArr[i13] = -1;
            } else {
                int i15 = i14 - 1;
                if (((C(this.f12241f[i15]) - i10) & (y() - 1)) >= i12) {
                    this.f12244i[i13] = i14;
                    this.f12243h[i15] = i13;
                }
                i11--;
            }
            i13 = i10;
            i12 = 0;
            i11--;
        } while (i11 >= 0);
        this.f12244i[i13] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int i10) {
        n8.b.c(this.f12241f, i10);
        J(this.f12243h[i10]);
        this.f12243h[i10] = -1;
        this.f12248m = size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] i() {
        V[] vArr = this.f12242g;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) n8.b.a(w());
        this.f12242g = vArr2;
        return vArr2;
    }

    private final void m() {
        int i10;
        V[] vArr = this.f12242g;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f12246k;
            if (i11 >= i10) {
                break;
            }
            if (this.f12243h[i11] >= 0) {
                K[] kArr = this.f12241f;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                i12++;
            }
            i11++;
        }
        n8.b.d(this.f12241f, i12, i10);
        if (vArr != null) {
            n8.b.d(vArr, i12, this.f12246k);
        }
        this.f12246k = i12;
    }

    private final boolean p(Map<?, ?> map) {
        return size() == map.size() && n(map.entrySet());
    }

    private final void q(int i10) {
        int y10;
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        if (i10 > w()) {
            int w10 = (w() * 3) / 2;
            if (i10 <= w10) {
                i10 = w10;
            }
            this.f12241f = (K[]) n8.b.b(this.f12241f, i10);
            V[] vArr = this.f12242g;
            this.f12242g = vArr != null ? (V[]) n8.b.b(vArr, i10) : null;
            int[] copyOf = Arrays.copyOf(this.f12243h, i10);
            k.d(copyOf, "copyOf(this, newSize)");
            this.f12243h = copyOf;
            y10 = f12240r.c(i10);
            if (y10 <= y()) {
                return;
            }
        } else if ((this.f12246k + i10) - size() <= w()) {
            return;
        } else {
            y10 = y();
        }
        H(y10);
    }

    private final void s(int i10) {
        q(this.f12246k + i10);
    }

    private final int u(K k10) {
        int C = C(k10);
        int i10 = this.f12245j;
        while (true) {
            int i11 = this.f12244i[C];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (k.a(this.f12241f[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            C = C == 0 ? y() - 1 : C - 1;
        }
    }

    private final int v(V v10) {
        int i10 = this.f12246k;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f12243h[i10] >= 0) {
                V[] vArr = this.f12242g;
                k.b(vArr);
                if (k.a(vArr[i10], v10)) {
                    return i10;
                }
            }
        }
    }

    private final int w() {
        return this.f12241f.length;
    }

    private final int y() {
        return this.f12244i.length;
    }

    public int A() {
        return this.f12248m;
    }

    public Collection<V> B() {
        n8.f<V> fVar = this.f12250o;
        if (fVar != null) {
            return fVar;
        }
        n8.f<V> fVar2 = new n8.f<>(this);
        this.f12250o = fVar2;
        return fVar2;
    }

    public final e<K, V> D() {
        return new e<>(this);
    }

    public final boolean I(Map.Entry<? extends K, ? extends V> entry) {
        k.e(entry, "entry");
        k();
        int u10 = u(entry.getKey());
        if (u10 < 0) {
            return false;
        }
        V[] vArr = this.f12242g;
        k.b(vArr);
        if (!k.a(vArr[u10], entry.getValue())) {
            return false;
        }
        L(u10);
        return true;
    }

    public final int K(K k10) {
        k();
        int u10 = u(k10);
        if (u10 < 0) {
            return -1;
        }
        L(u10);
        return u10;
    }

    public final boolean M(V v10) {
        k();
        int v11 = v(v10);
        if (v11 < 0) {
            return false;
        }
        L(v11);
        return true;
    }

    public final f<K, V> N() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        k();
        g0 it = new d9.c(0, this.f12246k - 1).iterator();
        while (it.hasNext()) {
            int b10 = it.b();
            int[] iArr = this.f12243h;
            int i10 = iArr[b10];
            if (i10 >= 0) {
                this.f12244i[i10] = 0;
                iArr[b10] = -1;
            }
        }
        n8.b.d(this.f12241f, 0, this.f12246k);
        V[] vArr = this.f12242g;
        if (vArr != null) {
            n8.b.d(vArr, 0, this.f12246k);
        }
        this.f12248m = 0;
        this.f12246k = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return u(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return v(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return x();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && p((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int u10 = u(obj);
        if (u10 < 0) {
            return null;
        }
        V[] vArr = this.f12242g;
        k.b(vArr);
        return vArr[u10];
    }

    public final int h(K k10) {
        int c10;
        k();
        while (true) {
            int C = C(k10);
            c10 = d9.f.c(this.f12245j * 2, y() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.f12244i[C];
                if (i11 <= 0) {
                    if (this.f12246k < w()) {
                        int i12 = this.f12246k;
                        int i13 = i12 + 1;
                        this.f12246k = i13;
                        this.f12241f[i12] = k10;
                        this.f12243h[i12] = C;
                        this.f12244i[C] = i13;
                        this.f12248m = size() + 1;
                        if (i10 > this.f12245j) {
                            this.f12245j = i10;
                        }
                        return i12;
                    }
                    s(1);
                } else {
                    if (k.a(this.f12241f[i11 - 1], k10)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > c10) {
                        H(y() * 2);
                        break;
                    }
                    C = C == 0 ? y() - 1 : C - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> t10 = t();
        int i10 = 0;
        while (t10.hasNext()) {
            i10 += t10.k();
        }
        return i10;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map<K, V> j() {
        k();
        this.f12252q = true;
        return this;
    }

    public final void k() {
        if (this.f12252q) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return z();
    }

    public final boolean n(Collection<?> collection) {
        k.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!o((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean o(Map.Entry<? extends K, ? extends V> entry) {
        k.e(entry, "entry");
        int u10 = u(entry.getKey());
        if (u10 < 0) {
            return false;
        }
        V[] vArr = this.f12242g;
        k.b(vArr);
        return k.a(vArr[u10], entry.getValue());
    }

    @Override // java.util.Map
    public V put(K k10, V v10) {
        k();
        int h10 = h(k10);
        V[] i10 = i();
        if (h10 >= 0) {
            i10[h10] = v10;
            return null;
        }
        int i11 = (-h10) - 1;
        V v11 = i10[i11];
        i10[i11] = v10;
        return v11;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        k.e(map, "from");
        k();
        E(map.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int K = K(obj);
        if (K < 0) {
            return null;
        }
        V[] vArr = this.f12242g;
        k.b(vArr);
        V v10 = vArr[K];
        n8.b.c(vArr, K);
        return v10;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return A();
    }

    public final b<K, V> t() {
        return new b<>(this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b<K, V> t10 = t();
        int i10 = 0;
        while (t10.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            t10.j(sb2);
            i10++;
        }
        sb2.append("}");
        String sb3 = sb2.toString();
        k.d(sb3, "sb.toString()");
        return sb3;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return B();
    }

    public Set<Map.Entry<K, V>> x() {
        n8.d<K, V> dVar = this.f12251p;
        if (dVar != null) {
            return dVar;
        }
        n8.d<K, V> dVar2 = new n8.d<>(this);
        this.f12251p = dVar2;
        return dVar2;
    }

    public Set<K> z() {
        n8.e<K> eVar = this.f12249n;
        if (eVar != null) {
            return eVar;
        }
        n8.e<K> eVar2 = new n8.e<>(this);
        this.f12249n = eVar2;
        return eVar2;
    }
}
