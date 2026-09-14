package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbqp extends zzbrl<zzbqt> {
    private final Clock zzbmq;

    @GuardedBy("this")
    private boolean zzfco;
    private final ScheduledExecutorService zzfdi;

    @GuardedBy("this")
    private long zzfdk;

    @GuardedBy("this")
    private long zzfdl;

    @Nullable
    @GuardedBy("this")
    private ScheduledFuture<?> zzfhu;

    public zzbqp(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfdk = -1L;
        this.zzfdl = -1L;
        this.zzfco = false;
        this.zzfdi = scheduledExecutorService;
        this.zzbmq = clock;
    }

    public final void zzahk() {
        a(zzbqo.a);
    }

    private final synchronized void zzfd(long j) {
        if (this.zzfhu != null && !this.zzfhu.isDone()) {
            this.zzfhu.cancel(true);
        }
        this.zzfdk = this.zzbmq.elapsedRealtime() + j;
        this.zzfhu = this.zzfdi.schedule(new zzbqq(this), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.zzfco) {
            if (this.zzfhu == null || this.zzfhu.isCancelled()) {
                this.zzfdl = -1L;
            } else {
                this.zzfhu.cancel(true);
                this.zzfdl = this.zzfdk - this.zzbmq.elapsedRealtime();
            }
            this.zzfco = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfco) {
            if (this.zzfdl > 0 && this.zzfhu.isCancelled()) {
                zzfd(this.zzfdl);
            }
            this.zzfco = false;
        }
    }

    public final synchronized void zzahj() {
        this.zzfco = false;
        zzfd(0L);
    }

    public final synchronized void zzdg(int i) {
        if (i <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i);
        if (!this.zzfco) {
            if (this.zzbmq.elapsedRealtime() > this.zzfdk || this.zzfdk - this.zzbmq.elapsedRealtime() > millis) {
                zzfd(millis);
            }
        } else {
            if (this.zzfdl <= 0 || millis >= this.zzfdl) {
                millis = this.zzfdl;
            }
            this.zzfdl = millis;
        }
    }
}
