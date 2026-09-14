package com.google.android.gms.internal.ads;

import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzaya {
    private long zzdut;

    @GuardedBy("lock")
    private long zzduu = Long.MIN_VALUE;
    private final Object lock = new Object();

    public zzaya(long j) {
        this.zzdut = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
            if (this.zzduu + this.zzdut > elapsedRealtime) {
                return false;
            }
            this.zzduu = elapsedRealtime;
            return true;
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzdut = j;
        }
    }
}
