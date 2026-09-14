package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzcvt implements zzdxg<zzcvr> {
    private final zzdxp<zzakp> zzeqj;
    private final zzdxp<ScheduledExecutorService> zzfpr;
    private final zzdxp<ApplicationInfo> zzfvc;
    private final zzdxp<Boolean> zzgif;

    public zzcvt(zzdxp<zzakp> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<Boolean> zzdxpVar3, zzdxp<ApplicationInfo> zzdxpVar4) {
        this.zzeqj = zzdxpVar;
        this.zzfpr = zzdxpVar2;
        this.zzgif = zzdxpVar3;
        this.zzfvc = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcvr(this.zzeqj.get(), this.zzfpr.get(), this.zzgif.get().booleanValue(), this.zzfvc.get());
    }
}
