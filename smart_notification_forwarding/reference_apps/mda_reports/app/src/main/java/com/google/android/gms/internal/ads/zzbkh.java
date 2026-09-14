package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzbkh implements zzdxg<zzbqp> {
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<ScheduledExecutorService> zzfdw;

    public zzbkh(zzdxp<ScheduledExecutorService> zzdxpVar, zzdxp<Clock> zzdxpVar2) {
        this.zzfdw = zzdxpVar;
        this.zzfcz = zzdxpVar2;
    }

    public static zzbqp zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbqp) zzdxm.zza(new zzbqp(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfdw.get(), this.zzfcz.get());
    }
}
