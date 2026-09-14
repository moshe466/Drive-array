package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzckm implements zzdxg<zzckk> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzbup> zzfyl;

    public zzckm(zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzbup> zzdxpVar3, zzdxp<Executor> zzdxpVar4) {
        this.zzejv = zzdxpVar;
        this.zzfdb = zzdxpVar2;
        this.zzfyl = zzdxpVar3;
        this.zzfei = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzckk(this.zzejv.get(), this.zzfdb.get(), this.zzfyl.get(), this.zzfei.get());
    }
}
