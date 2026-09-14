package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
abstract class zzdwz<K, V, V2> implements zzdxg<Map<K, V2>> {
    private final Map<K, zzdxp<V>> zzhzx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwz(Map<K, zzdxp<V>> map) {
        this.zzhzx = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, zzdxp<V>> a() {
        return this.zzhzx;
    }
}
