package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzcuq implements zzdxg<zzcup> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzava> zzeqj;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<ScheduledExecutorService> zzfpr;

    public zzcuq(zzdxp<zzava> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<ScheduledExecutorService> zzdxpVar3, zzdxp<Executor> zzdxpVar4) {
        this.zzeqj = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfpr = zzdxpVar3;
        this.zzfcv = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcup(this.zzeqj.get(), this.zzejv.get(), this.zzfpr.get(), this.zzfcv.get());
    }
}
