package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcof implements zzdxg<zzcob> {
    private final zzdxp<Executor> zzfcv;

    public zzcof(zzdxp<Executor> zzdxpVar) {
        this.zzfcv = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcob(this.zzfcv.get());
    }
}
