package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcty;

/* loaded from: classes.dex */
final class zzcrn<S extends zzcty<?>> {
    private final Clock zzbmq;
    public final zzdhe<S> zzgfq;
    private final long zzgfr;

    public zzcrn(zzdhe<S> zzdheVar, long j, Clock clock) {
        this.zzgfq = zzdheVar;
        this.zzbmq = clock;
        this.zzgfr = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzgfr < this.zzbmq.elapsedRealtime();
    }
}
