package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbyn implements zzdxg<zzbyl> {
    private final zzdxp<zzaxk> zzepv;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<Clock> zzfcz;

    public zzbyn(zzdxp<zzaxk> zzdxpVar, zzdxp<Clock> zzdxpVar2, zzdxp<Executor> zzdxpVar3) {
        this.zzepv = zzdxpVar;
        this.zzfcz = zzdxpVar2;
        this.zzfcv = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbyl(this.zzepv.get(), this.zzfcz.get(), this.zzfcv.get());
    }
}
