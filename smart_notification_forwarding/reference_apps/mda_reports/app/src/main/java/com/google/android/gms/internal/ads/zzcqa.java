package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcqa implements zzcub<Object> {
    private final Executor executor;
    private final zzdhe<String> zzgeo;

    public zzcqa(zzdhe<String> zzdheVar, Executor executor) {
        this.zzgeo = zzdheVar;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<Object> zzanc() {
        return zzdgs.zzb(this.zzgeo, zzcqd.a, this.executor);
    }
}
