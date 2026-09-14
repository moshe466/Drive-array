package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzdxi<K, V> extends zzdwz<K, V, V> {
    private static final zzdxp<Map<Object, Object>> zziad = zzdxf.zzbe(Collections.emptyMap());

    private zzdxi(Map<K, zzdxp<V>> map) {
        super(map);
    }

    public static <K, V> zzdxk<K, V> zzhl(int i) {
        return new zzdxk<>(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        LinkedHashMap zzhj = zzdxb.zzhj(a().size());
        for (Map.Entry<K, zzdxp<V>> entry : a().entrySet()) {
            zzhj.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(zzhj);
    }
}
