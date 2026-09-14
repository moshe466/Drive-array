package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcdx implements zzdxg<zzcdv> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzayy> zzepi;
    private final zzdxp<Executor> zzfcv;

    public zzcdx(zzdxp<Executor> zzdxpVar, zzdxp<zzayy> zzdxpVar2, zzdxp<Context> zzdxpVar3) {
        this.zzfcv = zzdxpVar;
        this.zzepi = zzdxpVar2;
        this.zzejv = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcdv(this.zzfcv.get(), this.zzepi.get(), this.zzejv.get());
    }
}
