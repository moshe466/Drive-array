package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q9<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final int f5552f;

    /* renamed from: g, reason: collision with root package name */
    private List<z9> f5553g;

    /* renamed from: h, reason: collision with root package name */
    private Map<K, V> f5554h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5555i;

    /* renamed from: j, reason: collision with root package name */
    private volatile ba f5556j;

    /* renamed from: k, reason: collision with root package name */
    private Map<K, V> f5557k;

    /* renamed from: l, reason: collision with root package name */
    private volatile v9 f5558l;

    private q9(int i10) {
        this.f5552f = i10;
        this.f5553g = Collections.emptyList();
        this.f5554h = Collections.emptyMap();
        this.f5557k = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q9(int i10, t9 t9Var) {
        this(i10);
    }

    private final int a(K k10) {
        int size = this.f5553g.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo((Comparable) this.f5553g.get(size).getKey());
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
            int compareTo2 = k10.compareTo((Comparable) this.f5553g.get(i11).getKey());
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends g7<FieldDescriptorType>> q9<FieldDescriptorType, Object> b(int i10) {
        return new t9(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V k(int i10) {
        q();
        V v10 = (V) this.f5553g.remove(i10).getValue();
        if (!this.f5554h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = r().entrySet().iterator();
            this.f5553g.add(new z9(this, it.next()));
            it.remove();
        }
        return v10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.f5555i) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> r() {
        q();
        if (this.f5554h.isEmpty() && !(this.f5554h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f5554h = treeMap;
            this.f5557k = treeMap.descendingMap();
        }
        return (SortedMap) this.f5554h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        q();
        if (!this.f5553g.isEmpty()) {
            this.f5553g.clear();
        }
        if (this.f5554h.isEmpty()) {
            return;
        }
        this.f5554h.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f5554h.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final V put(K k10, V v10) {
        q();
        int a10 = a(k10);
        if (a10 >= 0) {
            return (V) this.f5553g.get(a10).setValue(v10);
        }
        q();
        if (this.f5553g.isEmpty() && !(this.f5553g instanceof ArrayList)) {
            this.f5553g = new ArrayList(this.f5552f);
        }
        int i10 = -(a10 + 1);
        if (i10 >= this.f5552f) {
            return r().put(k10, v10);
        }
        int size = this.f5553g.size();
        int i11 = this.f5552f;
        if (size == i11) {
            z9 remove = this.f5553g.remove(i11 - 1);
            r().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f5553g.add(i10, new z9(this, k10, v10));
        return null;
    }

    public void e() {
        if (this.f5555i) {
            return;
        }
        this.f5554h = this.f5554h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f5554h);
        this.f5557k = this.f5557k.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f5557k);
        this.f5555i = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f5556j == null) {
            this.f5556j = new ba(this, null);
        }
        return this.f5556j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q9)) {
            return super.equals(obj);
        }
        q9 q9Var = (q9) obj;
        int size = size();
        if (size != q9Var.size()) {
            return false;
        }
        int j10 = j();
        if (j10 != q9Var.j()) {
            return entrySet().equals(q9Var.entrySet());
        }
        for (int i10 = 0; i10 < j10; i10++) {
            if (!h(i10).equals(q9Var.h(i10))) {
                return false;
            }
        }
        if (j10 != size) {
            return this.f5554h.equals(q9Var.f5554h);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a10 = a(comparable);
        return a10 >= 0 ? (V) this.f5553g.get(a10).getValue() : this.f5554h.get(comparable);
    }

    public final Map.Entry<K, V> h(int i10) {
        return this.f5553g.get(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int j10 = j();
        int i10 = 0;
        for (int i11 = 0; i11 < j10; i11++) {
            i10 += this.f5553g.get(i11).hashCode();
        }
        return this.f5554h.size() > 0 ? i10 + this.f5554h.hashCode() : i10;
    }

    public final boolean i() {
        return this.f5555i;
    }

    public final int j() {
        return this.f5553g.size();
    }

    public final Iterable<Map.Entry<K, V>> n() {
        return this.f5554h.isEmpty() ? u9.a() : this.f5554h.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> p() {
        if (this.f5558l == null) {
            this.f5558l = new v9(this, null);
        }
        return this.f5558l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        q();
        Comparable comparable = (Comparable) obj;
        int a10 = a(comparable);
        if (a10 >= 0) {
            return (V) k(a10);
        }
        if (this.f5554h.isEmpty()) {
            return null;
        }
        return this.f5554h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f5553g.size() + this.f5554h.size();
    }
}
