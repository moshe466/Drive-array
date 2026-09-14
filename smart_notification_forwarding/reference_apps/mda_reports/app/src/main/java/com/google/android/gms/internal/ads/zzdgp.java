package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdgp<V> extends zzdgn<V> {
    private final zzdhe<V> zzgwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgp(zzdhe<V> zzdheVar) {
        this.zzgwt = (zzdhe) zzdei.checkNotNull(zzdheVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfs, com.google.android.gms.internal.ads.zzdhe
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzgwt.addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdfs, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzgwt.cancel(z);
    }

    @Override // com.google.android.gms.internal.ads.zzdfs, java.util.concurrent.Future
    public final V get() {
        return this.zzgwt.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdfs, java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        return this.zzgwt.get(j, timeUnit);
    }

    @Override // com.google.android.gms.internal.ads.zzdfs, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzgwt.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzdfs, java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzgwt.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdfs
    public final String toString() {
        return this.zzgwt.toString();
    }
}
