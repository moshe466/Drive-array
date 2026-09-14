package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class zzdey<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzguk = new Map.Entry[0];
    private transient zzdfb<Map.Entry<K, V>> zzgul;
    private transient zzdfb<K> zzgum;
    private transient zzdet<V> zzgun;

    public static <K, V> zzdey<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        zzdeo.a(k, v);
        zzdeo.a(k2, v2);
        zzdeo.a(k3, v3);
        zzdeo.a(k4, v4);
        zzdeo.a(k5, v5);
        return zzdfh.a(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    abstract zzdfb<Map.Entry<K, V>> a();

    abstract zzdfb<K> b();

    abstract zzdet<V> c();

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
        return ((zzdet) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdfb<Map.Entry<K, V>> zzdfbVar = this.zzgul;
        if (zzdfbVar != null) {
            return zzdfbVar;
        }
        zzdfb<Map.Entry<K, V>> a = a();
        this.zzgul = a;
        return a;
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

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzdfn.a((zzdfb) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdfb<K> zzdfbVar = this.zzgum;
        if (zzdfbVar != null) {
            return zzdfbVar;
        }
        zzdfb<K> b = b();
        this.zzgum = b;
        return b;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
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
        zzdeo.a(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size << 3, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdet<V> zzdetVar = this.zzgun;
        if (zzdetVar != null) {
            return zzdetVar;
        }
        zzdet<V> c = c();
        this.zzgun = c;
        return c;
    }
}
