package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcmp implements zzdxg<zzcmi> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzcbn> zzfog;
    private final zzdxp<zzcbi> zzfyl;

    public zzcmp(zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<Executor> zzdxpVar4, zzdxp<zzcbi> zzdxpVar5, zzdxp<zzcbn> zzdxpVar6) {
        this.zzejv = zzdxpVar;
        this.zzfdb = zzdxpVar2;
        this.zzfep = zzdxpVar3;
        this.zzfei = zzdxpVar4;
        this.zzfyl = zzdxpVar5;
        this.zzfog = zzdxpVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcmi(this.zzejv.get(), this.zzfdb.get(), this.zzfep.get(), this.zzfei.get(), this.zzfyl.get(), this.zzfog.get());
    }
}
