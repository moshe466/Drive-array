package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzazf implements Executor {
    private final Handler zzdwl = new zzavv(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.zzdwl.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzkq();
            zzawb.zza(com.google.android.gms.ads.internal.zzq.zzku().getApplicationContext(), th);
            throw th;
        }
    }
}
