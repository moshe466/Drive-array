package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y3<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    private static final Object f5704o = new Object();

    /* renamed from: f, reason: collision with root package name */
    @NullableDecl
    private transient Object f5705f;

    /* renamed from: g, reason: collision with root package name */
    @NullableDecl
    transient int[] f5706g;

    /* renamed from: h, reason: collision with root package name */
    @NullableDecl
    transient Object[] f5707h;

    /* renamed from: i, reason: collision with root package name */
    @NullableDecl
    transient Object[] f5708i;

    /* renamed from: j, reason: collision with root package name */
    private transient int f5709j;

    /* renamed from: k, reason: collision with root package name */
    private transient int f5710k;

    /* renamed from: l, reason: collision with root package name */
    @NullableDecl
    private transient Set<K> f5711l;

    /* renamed from: m, reason: collision with root package name */
    @NullableDecl
    private transient Set<Map.Entry<K, V>> f5712m;

    /* renamed from: n, reason: collision with root package name */
    @NullableDecl
    private transient Collection<V> f5713n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y3() {
        n3.f(true, "Expected size must be >= 0");
        this.f5709j = m5.a(3, 1, 1073741823);
    }

    private final int b(int i10, int i11, int i12, int i13) {
        Object d10 = j4.d(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            j4.e(d10, i12 & i14, i13 + 1);
        }
        Object obj = this.f5705f;
        int[] iArr = this.f5706g;
        for (int i15 = 0; i15 <= i10; i15++) {
            int b10 = j4.b(obj, i15);
            while (b10 != 0) {
                int i16 = b10 - 1;
                int i17 = iArr[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int b11 = j4.b(d10, i19);
                j4.e(d10, i19, b10);
                iArr[i16] = j4.a(i18, b11, i14);
                b10 = i17 & i10;
            }
        }
        this.f5705f = d10;
        n(i14);
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(@NullableDecl Object obj) {
        if (g()) {
            return -1;
        }
        int b10 = l4.b(obj);
        int w10 = w();
        int b11 = j4.b(this.f5705f, b10 & w10);
        if (b11 == 0) {
            return -1;
        }
        int i10 = ~w10;
        int i11 = b10 & i10;
        do {
            int i12 = b11 - 1;
            int i13 = this.f5706g[i12];
            if ((i13 & i10) == i11 && l3.a(obj, this.f5707h[i12])) {
                return i12;
            }
            b11 = i13 & w10;
        } while (b11 != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i10, int i11) {
        return i10 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public final Object k(@NullableDecl Object obj) {
        if (g()) {
            return f5704o;
        }
        int w10 = w();
        int c10 = j4.c(obj, null, w10, this.f5705f, this.f5706g, this.f5707h, null);
        if (c10 == -1) {
            return f5704o;
        }
        Object obj2 = this.f5708i[c10];
        f(c10, w10);
        this.f5710k--;
        p();
        return obj2;
    }

    private final void n(int i10) {
        this.f5709j = j4.a(this.f5709j, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int r(y3 y3Var) {
        int i10 = y3Var.f5710k;
        y3Var.f5710k = i10 - 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w() {
        return (1 << (this.f5709j & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f5710k) {
            return i11;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (g()) {
            return;
        }
        p();
        Map<K, V> m10 = m();
        if (m10 != null) {
            this.f5709j = m5.a(size(), 3, 1073741823);
            m10.clear();
            this.f5705f = null;
        } else {
            Arrays.fill(this.f5707h, 0, this.f5710k, (Object) null);
            Arrays.fill(this.f5708i, 0, this.f5710k, (Object) null);
            Object obj = this.f5705f;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, (short) 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.f5706g, 0, this.f5710k, 0);
        }
        this.f5710k = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@NullableDecl Object obj) {
        Map<K, V> m10 = m();
        return m10 != null ? m10.containsKey(obj) : d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> m10 = m();
        if (m10 != null) {
            return m10.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f5710k; i10++) {
            if (l3.a(obj, this.f5708i[i10])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f5712m;
        if (set != null) {
            return set;
        }
        c4 c4Var = new c4(this);
        this.f5712m = c4Var;
        return c4Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i10, int i11) {
        int size = size() - 1;
        if (i10 >= size) {
            this.f5707h[i10] = null;
            this.f5708i[i10] = null;
            this.f5706g[i10] = 0;
            return;
        }
        Object[] objArr = this.f5707h;
        Object obj = objArr[size];
        objArr[i10] = obj;
        Object[] objArr2 = this.f5708i;
        objArr2[i10] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        int[] iArr = this.f5706g;
        iArr[i10] = iArr[size];
        iArr[size] = 0;
        int b10 = l4.b(obj) & i11;
        int b11 = j4.b(this.f5705f, b10);
        int i12 = size + 1;
        if (b11 == i12) {
            j4.e(this.f5705f, b10, i10 + 1);
            return;
        }
        while (true) {
            int i13 = b11 - 1;
            int[] iArr2 = this.f5706g;
            int i14 = iArr2[i13];
            int i15 = i14 & i11;
            if (i15 == i12) {
                iArr2[i13] = j4.a(i14, i10 + 1, i11);
                return;
            }
            b11 = i15;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.f5705f == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> m10 = m();
        if (m10 != null) {
            return m10.get(obj);
        }
        int d10 = d(obj);
        if (d10 == -1) {
            return null;
        }
        return (V) this.f5708i[d10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.f5711l;
        if (set != null) {
            return set;
        }
        e4 e4Var = new e4(this);
        this.f5711l = e4Var;
        return e4Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public final Map<K, V> m() {
        Object obj = this.f5705f;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p() {
        this.f5709j += 32;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k10, @NullableDecl V v10) {
        int length;
        int min;
        if (g()) {
            n3.h(g(), "Arrays already allocated");
            int i10 = this.f5709j;
            int max = Math.max(i10 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            int max2 = Math.max(4, (max <= ((int) (((double) highestOneBit) * 1.0d)) || (highestOneBit = highestOneBit << 1) > 0) ? highestOneBit : 1073741824);
            this.f5705f = j4.d(max2);
            n(max2 - 1);
            this.f5706g = new int[i10];
            this.f5707h = new Object[i10];
            this.f5708i = new Object[i10];
        }
        Map<K, V> m10 = m();
        if (m10 != null) {
            return m10.put(k10, v10);
        }
        int[] iArr = this.f5706g;
        Object[] objArr = this.f5707h;
        Object[] objArr2 = this.f5708i;
        int i11 = this.f5710k;
        int i12 = i11 + 1;
        int b10 = l4.b(k10);
        int w10 = w();
        int i13 = b10 & w10;
        int b11 = j4.b(this.f5705f, i13);
        if (b11 == 0) {
            if (i12 <= w10) {
                j4.e(this.f5705f, i13, i12);
                length = this.f5706g.length;
                if (i12 > length && (min = Math.min(1073741823, 1 | (Math.max(1, length >>> 1) + length))) != length) {
                    this.f5706g = Arrays.copyOf(this.f5706g, min);
                    this.f5707h = Arrays.copyOf(this.f5707h, min);
                    this.f5708i = Arrays.copyOf(this.f5708i, min);
                }
                this.f5706g[i11] = j4.a(b10, 0, w10);
                this.f5707h[i11] = k10;
                this.f5708i[i11] = v10;
                this.f5710k = i12;
                p();
                return null;
            }
            w10 = b(w10, j4.f(w10), b10, i11);
            length = this.f5706g.length;
            if (i12 > length) {
                this.f5706g = Arrays.copyOf(this.f5706g, min);
                this.f5707h = Arrays.copyOf(this.f5707h, min);
                this.f5708i = Arrays.copyOf(this.f5708i, min);
            }
            this.f5706g[i11] = j4.a(b10, 0, w10);
            this.f5707h[i11] = k10;
            this.f5708i[i11] = v10;
            this.f5710k = i12;
            p();
            return null;
        }
        int i14 = ~w10;
        int i15 = b10 & i14;
        int i16 = 0;
        while (true) {
            int i17 = b11 - 1;
            int i18 = iArr[i17];
            if ((i18 & i14) == i15 && l3.a(k10, objArr[i17])) {
                V v11 = (V) objArr2[i17];
                objArr2[i17] = v10;
                return v11;
            }
            int i19 = i18 & w10;
            Object[] objArr3 = objArr;
            int i20 = i16 + 1;
            if (i19 != 0) {
                i16 = i20;
                b11 = i19;
                objArr = objArr3;
            } else {
                if (i20 >= 9) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(w() + 1, 1.0f);
                    int q10 = q();
                    while (q10 >= 0) {
                        linkedHashMap.put(this.f5707h[q10], this.f5708i[q10]);
                        q10 = a(q10);
                    }
                    this.f5705f = linkedHashMap;
                    this.f5706g = null;
                    this.f5707h = null;
                    this.f5708i = null;
                    p();
                    return (V) linkedHashMap.put(k10, v10);
                }
                if (i12 <= w10) {
                    iArr[i17] = j4.a(i18, i12, w10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int q() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> m10 = m();
        if (m10 != null) {
            return m10.remove(obj);
        }
        V v10 = (V) k(obj);
        if (v10 == f5704o) {
            return null;
        }
        return v10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<K> s() {
        Map<K, V> m10 = m();
        return m10 != null ? m10.keySet().iterator() : new b4(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> m10 = m();
        return m10 != null ? m10.size() : this.f5710k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<K, V>> t() {
        Map<K, V> m10 = m();
        return m10 != null ? m10.entrySet().iterator() : new a4(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<V> u() {
        Map<K, V> m10 = m();
        return m10 != null ? m10.values().iterator() : new d4(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.f5713n;
        if (collection != null) {
            return collection;
        }
        g4 g4Var = new g4(this);
        this.f5713n = g4Var;
        return g4Var;
    }
}
