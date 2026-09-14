package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class zzdbw implements zzdxg<ScheduledExecutorService> {
    private final zzdxp<ThreadFactory> zzgpu;

    public zzdbw(zzdxp<ThreadFactory> zzdxpVar) {
        this.zzgpu = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzdxm.zza(new ScheduledThreadPoolExecutor(1, this.zzgpu.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
