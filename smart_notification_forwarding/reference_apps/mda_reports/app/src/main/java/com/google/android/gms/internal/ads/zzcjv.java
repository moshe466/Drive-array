package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzcjv implements zzdxg<zzcjr> {
    private final zzdxp<zzblg> zzewm;
    private final zzdxp<zzcix> zzewq;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<ScheduledExecutorService> zzfpr;
    private final zzdxp<zzbou> zzfzc;

    public zzcjv(zzdxp<zzblg> zzdxpVar, zzdxp<zzcix> zzdxpVar2, zzdxp<zzbou> zzdxpVar3, zzdxp<ScheduledExecutorService> zzdxpVar4, zzdxp<zzdhd> zzdxpVar5) {
        this.zzewm = zzdxpVar;
        this.zzewq = zzdxpVar2;
        this.zzfzc = zzdxpVar3;
        this.zzfpr = zzdxpVar4;
        this.zzfcv = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcjr(this.zzewm.get(), this.zzewq.get(), this.zzfzc.get(), this.zzfpr.get(), this.zzfcv.get());
    }
}
