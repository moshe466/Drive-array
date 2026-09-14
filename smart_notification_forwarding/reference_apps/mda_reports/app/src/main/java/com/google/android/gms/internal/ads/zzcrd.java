package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzcrd implements zzdxg<zzcqz> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<ScheduledExecutorService> zzfpr;

    private zzcrd(zzdxp<Context> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<Executor> zzdxpVar3) {
        this.zzejv = zzdxpVar;
        this.zzfpr = zzdxpVar2;
        this.zzfcv = zzdxpVar3;
    }

    public static zzcrd zzn(zzdxp<Context> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<Executor> zzdxpVar3) {
        return new zzcrd(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqz(this.zzejv.get(), this.zzfpr.get(), this.zzfcv.get());
    }
}
