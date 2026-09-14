package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzcvx implements zzdxg<zzcvv> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzaoz> zzeqj;
    private final zzdxp<ScheduledExecutorService> zzfpr;

    public zzcvx(zzdxp<zzaoz> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<Context> zzdxpVar3) {
        this.zzeqj = zzdxpVar;
        this.zzfpr = zzdxpVar2;
        this.zzejv = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcvv(this.zzeqj.get(), this.zzfpr.get(), this.zzejv.get());
    }
}
