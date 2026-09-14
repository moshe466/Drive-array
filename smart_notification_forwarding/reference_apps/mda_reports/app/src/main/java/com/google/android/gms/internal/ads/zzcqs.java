package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcqs implements zzdxg<zzcqr> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzave> zzgev;

    private zzcqs(zzdxp<Executor> zzdxpVar, zzdxp<zzave> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzgev = zzdxpVar2;
    }

    public static zzcqs zzam(zzdxp<Executor> zzdxpVar, zzdxp<zzave> zzdxpVar2) {
        return new zzcqs(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqr(this.zzfcv.get(), this.zzgev.get());
    }
}
