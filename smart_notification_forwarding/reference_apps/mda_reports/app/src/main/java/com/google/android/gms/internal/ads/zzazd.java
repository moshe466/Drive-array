package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzazd {
    public static final zzdhd zzdwe = zza(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), zzfc("Default")));
    public static final zzdhd zzdwf;
    public static final zzdhd zzdwg;
    public static final ScheduledExecutorService zzdwh;
    public static final zzdhd zzdwi;
    public static final zzdhd zzdwj;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfc("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzdwf = zza(threadPoolExecutor);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfc("Activeview"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        zzdwg = zza(threadPoolExecutor2);
        zzdwh = new ScheduledThreadPoolExecutor(3, zzfc("Schedule"));
        zzdwi = zza(new zzazf());
        zzdwj = zza(zzdhg.zzarw());
    }

    private static zzdhd zza(Executor executor) {
        return new zzaze(executor, null);
    }

    private static ThreadFactory zzfc(String str) {
        return new zzazc(str);
    }
}
