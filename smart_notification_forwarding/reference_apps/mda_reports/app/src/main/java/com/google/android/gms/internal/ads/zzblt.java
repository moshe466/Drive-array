package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzblt implements zzdxg<zzblo> {
    private final zzdxp<zzbmg> zzetc;
    private final zzdxp<Runnable> zzexh;
    private final zzdxp<zzaea> zzfdd;
    private final zzdxp<Executor> zzfei;

    public zzblt(zzdxp<zzbmg> zzdxpVar, zzdxp<zzaea> zzdxpVar2, zzdxp<Runnable> zzdxpVar3, zzdxp<Executor> zzdxpVar4) {
        this.zzetc = zzdxpVar;
        this.zzfdd = zzdxpVar2;
        this.zzexh = zzdxpVar3;
        this.zzfei = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzblo(this.zzetc.get(), this.zzfdd.get(), this.zzexh.get(), this.zzfei.get());
    }
}
