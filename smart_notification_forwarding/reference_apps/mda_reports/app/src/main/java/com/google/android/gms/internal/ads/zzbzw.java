package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbzw implements zzdxg<zzbzh> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzcbn> zzfog;

    public zzbzw(zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2, zzdxp<Executor> zzdxpVar3, zzdxp<zzcbn> zzdxpVar4) {
        this.zzejv = zzdxpVar;
        this.zzfep = zzdxpVar2;
        this.zzfei = zzdxpVar3;
        this.zzfog = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbzh(this.zzejv.get(), this.zzfep.get(), this.zzfei.get(), this.zzfog.get());
    }
}
