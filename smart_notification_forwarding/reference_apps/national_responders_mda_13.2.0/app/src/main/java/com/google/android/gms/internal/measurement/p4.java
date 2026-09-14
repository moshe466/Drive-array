package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class p4<K, V> implements Serializable, Map<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private transient t4<Map.Entry<K, V>> f5529f;

    /* renamed from: g, reason: collision with root package name */
    private transient t4<K> f5530g;

    /* renamed from: h, reason: collision with root package name */
    private transient k4<V> f5531h;

    abstract t4<Map.Entry<K, V>> a();

    abstract t4<K> b();

    abstract k4<V> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((k4) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        t4<Map.Entry<K, V>> t4Var = this.f5529f;
        if (t4Var != null) {
            return t4Var;
        }
        t4<Map.Entry<K, V>> a10 = a();
        this.f5529f = a10;
        return a10;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    @Override // java.util.Map
    public int hashCode() {
        return i5.a((t4) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        t4<K> t4Var = this.f5530g;
        if (t4Var != null) {
            return t4Var;
        }
        t4<K> b10 = b();
        this.f5530g = b10;
        return b10;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        if (size < 0) {
            StringBuilder sb2 = new StringBuilder("size".length() + 40);
            sb2.append("size");
            sb2.append(" cannot be negative but was: ");
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder((int) Math.min(size << 3, 1073741824L));
        sb3.append('{');
        boolean z10 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z10) {
                sb3.append(", ");
            }
            z10 = false;
            sb3.append(entry.getKey());
            sb3.append('=');
            sb3.append(entry.getValue());
        }
        sb3.append('}');
        return sb3.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        k4<V> k4Var = this.f5531h;
        if (k4Var != null) {
            return k4Var;
        }
        k4<V> c10 = c();
        this.f5531h = c10;
        return c10;
    }
}
