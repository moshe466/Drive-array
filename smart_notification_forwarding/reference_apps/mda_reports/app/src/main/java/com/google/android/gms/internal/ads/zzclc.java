package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzclc implements zzdxg<zzckz> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzbvm> zzfyl;

    public zzclc(zzdxp<Context> zzdxpVar, zzdxp<zzbvm> zzdxpVar2, zzdxp<Executor> zzdxpVar3) {
        this.zzejv = zzdxpVar;
        this.zzfyl = zzdxpVar2;
        this.zzfei = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzckz(this.zzejv.get(), this.zzfyl.get(), this.zzfei.get());
    }
}
