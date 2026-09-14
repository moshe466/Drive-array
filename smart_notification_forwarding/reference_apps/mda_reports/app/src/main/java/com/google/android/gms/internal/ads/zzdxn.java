package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class zzdxn<T> {
    private final List<zzdxp<T>> zziaf;
    private final List<zzdxp<Collection<T>>> zziag;

    private zzdxn(int i, int i2) {
        this.zziaf = zzdxb.zzhh(i);
        this.zziag = zzdxb.zzhh(i2);
    }

    public final zzdxn<T> zzap(zzdxp<? extends T> zzdxpVar) {
        this.zziaf.add(zzdxpVar);
        return this;
    }

    public final zzdxn<T> zzaq(zzdxp<? extends Collection<? extends T>> zzdxpVar) {
        this.zziag.add(zzdxpVar);
        return this;
    }

    public final zzdxl<T> zzbdp() {
        return new zzdxl<>(this.zziaf, this.zziag);
    }
}
