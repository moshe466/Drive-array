package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzcfc implements zzdxg<zzceq> {
    private final zzdxp<zzcka> zzejs;
    private final zzdxp<zzcea> zzeko;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<ScheduledExecutorService> zzfpr;
    private final zzdxp<Context> zzfuf;
    private final zzdxp<WeakReference<Context>> zzfug;

    public zzcfc(zzdxp<Executor> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<WeakReference<Context>> zzdxpVar3, zzdxp<Executor> zzdxpVar4, zzdxp<zzcka> zzdxpVar5, zzdxp<ScheduledExecutorService> zzdxpVar6, zzdxp<zzcea> zzdxpVar7, zzdxp<zzazb> zzdxpVar8) {
        this.zzfei = zzdxpVar;
        this.zzfuf = zzdxpVar2;
        this.zzfug = zzdxpVar3;
        this.zzfcv = zzdxpVar4;
        this.zzejs = zzdxpVar5;
        this.zzfpr = zzdxpVar6;
        this.zzeko = zzdxpVar7;
        this.zzfdb = zzdxpVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzceq(this.zzfei.get(), this.zzfuf.get(), this.zzfug.get(), this.zzfcv.get(), this.zzejs.get(), this.zzfpr.get(), this.zzeko.get(), this.zzfdb.get());
    }
}
