package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class zzdsh<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzdsf> zzhoa;

    private zzdsh(Map.Entry<K, zzdsf> entry) {
        this.zzhoa = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzhoa.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzhoa.getValue() == null) {
            return null;
        }
        return zzdsf.zzbas();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzdte) {
            return this.zzhoa.getValue().zzn((zzdte) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzdsf zzbau() {
        return this.zzhoa.getValue();
    }
}
