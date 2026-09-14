package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdhk extends zzdhh implements zzdhd, ScheduledExecutorService {
    private final ScheduledExecutorService zzgxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhk(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzgxi = (ScheduledExecutorService) zzdei.checkNotNull(scheduledExecutorService);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzdhs a = zzdhs.a(runnable, (Object) null);
        return new zzdhj(a, this.zzgxi.schedule(a, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzdhs a = zzdhs.a(callable);
        return new zzdhj(a, this.zzgxi.schedule(a, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdhm zzdhmVar = new zzdhm(runnable);
        return new zzdhj(zzdhmVar, this.zzgxi.scheduleAtFixedRate(zzdhmVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdhm zzdhmVar = new zzdhm(runnable);
        return new zzdhj(zzdhmVar, this.zzgxi.scheduleWithFixedDelay(zzdhmVar, j, j2, timeUnit));
    }
}
