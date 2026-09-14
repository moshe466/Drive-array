package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class zzdhj<V> extends zzdgq<V> implements zzdhe<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zzgxh;

    public zzdhj(zzdhe<V> zzdheVar, ScheduledFuture<?> scheduledFuture) {
        super(zzdheVar);
        this.zzgxh = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzdgo, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zzgxh.cancel(z);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return this.zzgxh.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zzgxh.getDelay(timeUnit);
    }
}
