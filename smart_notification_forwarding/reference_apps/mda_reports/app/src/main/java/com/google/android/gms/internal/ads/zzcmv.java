package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcmv implements zzdxg<zzcms> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzcbi> zzfyl;

    public zzcmv(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzcbi> zzdxpVar3) {
        this.zzejv = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzfyl = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcms(this.zzejv.get(), this.zzfei.get(), this.zzfyl.get());
    }
}
