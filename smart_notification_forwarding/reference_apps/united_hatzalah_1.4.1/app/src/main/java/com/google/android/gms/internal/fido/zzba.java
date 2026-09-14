package com.google.android.gms.internal.fido;

import e0.a;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class zzba implements Map, Serializable {
    static final Map.Entry[] zza = new Map.Entry[0];
    private transient zzbc zzb;

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzbx.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
            sb.append('{');
            boolean z3 = true;
            for (Map.Entry entry : entrySet()) {
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
        throw new IllegalArgumentException(a.c(size, "size cannot be negative but was: "));
    }

    @Override // java.util.Map
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzav values() {
        throw null;
    }

    public abstract zzbc zzb();

    @Override // java.util.Map
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzbc entrySet() {
        zzbc zzbcVar = this.zzb;
        if (zzbcVar == null) {
            zzbc zzb = zzb();
            this.zzb = zzb;
            return zzb;
        }
        return zzbcVar;
    }

    @Override // java.util.Map
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public zzbc keySet() {
        throw null;
    }
}
