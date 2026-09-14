package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcjg implements zzdxg<zzcix> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzcbn> zzfog;
    private final zzdxp<zzblg> zzfyl;
    private final zzdxp<zzded<zzczl, zzawt>> zzfyo;

    public zzcjg(zzdxp<zzblg> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<Executor> zzdxpVar3, zzdxp<zzcbn> zzdxpVar4, zzdxp<zzczu> zzdxpVar5, zzdxp<zzded<zzczl, zzawt>> zzdxpVar6) {
        this.zzfyl = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfei = zzdxpVar3;
        this.zzfog = zzdxpVar4;
        this.zzfep = zzdxpVar5;
        this.zzfyo = zzdxpVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcix(this.zzfyl.get(), this.zzejv.get(), this.zzfei.get(), this.zzfog.get(), this.zzfep.get(), this.zzfyo.get());
    }
}
