package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbwf implements zzdxg<zzbjq> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzpn> zzfld;

    public zzbwf(zzdxp<zzpn> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<Context> zzdxpVar3, zzdxp<Clock> zzdxpVar4) {
        this.zzfld = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzejv = zzdxpVar3;
        this.zzfcz = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzpn zzpnVar = this.zzfld.get();
        Executor executor = this.zzfcv.get();
        Context context = this.zzejv.get();
        return (zzbjq) zzdxm.zza(new zzbjq(executor, new zzbjb(context, zzpnVar), this.zzfcz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
