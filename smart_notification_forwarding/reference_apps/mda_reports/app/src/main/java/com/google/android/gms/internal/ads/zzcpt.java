package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcpt implements zzdxg<zzcpr> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzcgm> zzgei;

    public zzcpt(zzdxp<Executor> zzdxpVar, zzdxp<zzcgm> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzgei = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcpr(this.zzfcv.get(), this.zzgei.get());
    }
}
