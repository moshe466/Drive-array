package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: classes.dex */
public abstract class zzan<K, V> implements Serializable, Map<K, V> {
    private transient zzas<Map.Entry<K, V>> zza;
    private transient zzas<K> zzb;
    private transient zzai<V> zzc;

    public static <K, V> zzan<K, V> zza(Map<? extends K, ? extends V> map) {
        if ((map instanceof zzan) && !(map instanceof SortedMap)) {
            zzan<K, V> zzanVar = (zzan) map;
            zzanVar.zzd();
            return zzanVar;
        }
        Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
        zzaq zzaqVar = new zzaq(entrySet != null ? entrySet.size() : 4);
        zzaqVar.zza(entrySet);
        return zzaqVar.zza();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return ((zzai) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzas<Map.Entry<K, V>> zzasVar = this.zza;
        if (zzasVar == null) {
            zzas<Map.Entry<K, V>> zzb = zzb();
            this.zza = zzb;
            return zzb;
        }
        return zzasVar;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v2) {
        V v3 = get(obj);
        if (v3 != null) {
            return v3;
        }
        return v2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzax.zza((zzas) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzas<K> zzasVar = this.zzb;
        if (zzasVar == null) {
            zzas<K> zzc = zzc();
            this.zzb = zzc;
            return zzc;
        }
        return zzasVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k4, V v2) {
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
        zzag.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size << 3, 1073741824L));
        sb.append('{');
        boolean z3 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z3 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzai<V> zzaiVar = this.zzc;
        if (zzaiVar == null) {
            zzai<V> zza = zza();
            this.zzc = zza;
            return zza;
        }
        return zzaiVar;
    }

    public abstract zzai<V> zza();

    public abstract zzas<Map.Entry<K, V>> zzb();

    public abstract zzas<K> zzc();

    public abstract boolean zzd();
}
