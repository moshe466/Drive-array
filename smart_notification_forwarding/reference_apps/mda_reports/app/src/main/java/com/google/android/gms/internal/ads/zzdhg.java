package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzdhg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a(Executor executor, zzdfs<?> zzdfsVar) {
        zzdei.checkNotNull(executor);
        zzdei.checkNotNull(zzdfsVar);
        return executor == zzdgl.INSTANCE ? executor : new zzdhf(executor, zzdfsVar);
    }

    public static zzdhd zza(ExecutorService executorService) {
        return executorService instanceof zzdhd ? (zzdhd) executorService : executorService instanceof ScheduledExecutorService ? new zzdhk((ScheduledExecutorService) executorService) : new zzdhh(executorService);
    }

    public static Executor zzarw() {
        return zzdgl.INSTANCE;
    }
}
