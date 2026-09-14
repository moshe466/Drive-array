package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzazl<T> implements zzdhe<T> {
    private final zzdhl<T> zzdwo = zzdhl.zzarx();

    private static boolean zzas(boolean z) {
        if (!z) {
            com.google.android.gms.ads.internal.zzq.zzku().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public void addListener(Runnable runnable, Executor executor) {
        this.zzdwo.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.zzdwo.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.zzdwo.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.zzdwo.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.zzdwo.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.zzdwo.isDone();
    }

    public final boolean set(@Nullable T t) {
        return zzas(this.zzdwo.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzas(this.zzdwo.setException(th));
    }
}
