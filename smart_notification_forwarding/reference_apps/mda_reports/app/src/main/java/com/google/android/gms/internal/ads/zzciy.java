package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzciy implements zzdxg<zzciu> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzcbn> zzfog;
    private final zzdxp<zzbka> zzfyl;

    public zzciy(zzdxp<zzbka> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<Executor> zzdxpVar3, zzdxp<zzcbn> zzdxpVar4, zzdxp<zzczu> zzdxpVar5) {
        this.zzfyl = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfei = zzdxpVar3;
        this.zzfog = zzdxpVar4;
        this.zzfep = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzciu(this.zzfyl.get(), this.zzejv.get(), this.zzfei.get(), this.zzfog.get(), this.zzfep.get());
    }
}
