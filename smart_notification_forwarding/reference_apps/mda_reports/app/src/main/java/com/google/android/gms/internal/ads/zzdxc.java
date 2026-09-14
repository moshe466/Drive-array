package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class zzdxc<K, V, V2> {
    final LinkedHashMap<K, zzdxp<V>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxc(int i) {
        this.a = zzdxb.zzhj(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzdxc<K, V, V2> zza(K k, zzdxp<V> zzdxpVar) {
        this.a.put(zzdxm.zza(k, "key"), zzdxm.zza(zzdxpVar, "provider"));
        return this;
    }
}
