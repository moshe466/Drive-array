package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzdca<E, V> implements zzdhe<V> {
    private final E zzgpx;
    private final String zzgpy;
    private final zzdhe<V> zzgpz;

    @VisibleForTesting(otherwise = 3)
    public zzdca(E e, String str, zzdhe<V> zzdheVar) {
        this.zzgpx = e;
        this.zzgpy = str;
        this.zzgpz = zzdheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzgpz.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzgpz.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        return this.zzgpz.get();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        return this.zzgpz.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzgpz.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzgpz.isDone();
    }

    public final String toString() {
        String str = this.zzgpy;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zzaqd() {
        return this.zzgpx;
    }

    public final String zzaqe() {
        return this.zzgpy;
    }
}
