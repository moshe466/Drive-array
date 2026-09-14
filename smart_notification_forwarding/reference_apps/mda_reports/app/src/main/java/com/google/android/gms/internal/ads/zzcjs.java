package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcjs implements zzdxg<zzcjn> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzbup> zzfyl;
    private final zzdxp<zzczj> zzfza;

    public zzcjs(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzbup> zzdxpVar3, zzdxp<zzczj> zzdxpVar4) {
        this.zzejv = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzfyl = zzdxpVar3;
        this.zzfza = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcjn(this.zzejv.get(), this.zzfei.get(), this.zzfyl.get(), this.zzfza.get());
    }
}
