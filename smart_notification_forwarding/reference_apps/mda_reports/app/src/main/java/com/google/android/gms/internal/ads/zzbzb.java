package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzbzb implements zzdxg<zzbyu> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzbyl> zzepw;
    private final zzdxp<zzbzh> zzepy;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzdq> zzfky;
    private final zzdxp<com.google.android.gms.ads.internal.zza> zzfpp;
    private final zzdxp<zzsm> zzfpq;
    private final zzdxp<ScheduledExecutorService> zzfpr;

    public zzbzb(zzdxp<Context> zzdxpVar, zzdxp<zzbyl> zzdxpVar2, zzdxp<zzdq> zzdxpVar3, zzdxp<zzazb> zzdxpVar4, zzdxp<com.google.android.gms.ads.internal.zza> zzdxpVar5, zzdxp<zzsm> zzdxpVar6, zzdxp<Executor> zzdxpVar7, zzdxp<zzczu> zzdxpVar8, zzdxp<zzbzh> zzdxpVar9, zzdxp<ScheduledExecutorService> zzdxpVar10) {
        this.zzejv = zzdxpVar;
        this.zzepw = zzdxpVar2;
        this.zzfky = zzdxpVar3;
        this.zzfav = zzdxpVar4;
        this.zzfpp = zzdxpVar5;
        this.zzfpq = zzdxpVar6;
        this.zzfcv = zzdxpVar7;
        this.zzfep = zzdxpVar8;
        this.zzepy = zzdxpVar9;
        this.zzfpr = zzdxpVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbyu(this.zzejv.get(), this.zzepw.get(), this.zzfky.get(), this.zzfav.get(), this.zzfpp.get(), this.zzfpq.get(), this.zzfcv.get(), this.zzfep.get(), this.zzepy.get(), this.zzfpr.get());
    }
}
