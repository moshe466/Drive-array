package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbju implements zzqj {
    private final Clock zzbmq;
    private final ScheduledExecutorService zzfdi;

    @Nullable
    @GuardedBy("this")
    private ScheduledFuture<?> zzfdj;

    @GuardedBy("this")
    private long zzfdk = -1;

    @GuardedBy("this")
    private long zzfdl = -1;

    @GuardedBy("this")
    private Runnable zzdro = null;

    @GuardedBy("this")
    private boolean zzfdm = false;

    public zzbju(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfdi = scheduledExecutorService;
        this.zzbmq = clock;
        com.google.android.gms.ads.internal.zzq.zzkt().zza(this);
    }

    @VisibleForTesting
    private final synchronized void zzafr() {
        if (!this.zzfdm) {
            if (this.zzfdj == null || this.zzfdj.isDone()) {
                this.zzfdl = -1L;
            } else {
                this.zzfdj.cancel(true);
                this.zzfdl = this.zzfdk - this.zzbmq.elapsedRealtime();
            }
            this.zzfdm = true;
        }
    }

    @VisibleForTesting
    private final synchronized void zzafs() {
        if (this.zzfdm) {
            if (this.zzfdl > 0 && this.zzfdj != null && this.zzfdj.isCancelled()) {
                this.zzfdj = this.zzfdi.schedule(this.zzdro, this.zzfdl, TimeUnit.MILLISECONDS);
            }
            this.zzfdm = false;
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzdro = runnable;
        long j = i;
        this.zzfdk = this.zzbmq.elapsedRealtime() + j;
        this.zzfdj = this.zzfdi.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zzp(boolean z) {
        if (z) {
            zzafs();
        } else {
            zzafr();
        }
    }
}
