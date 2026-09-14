package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class zzdgo<V> extends zzder implements Future<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract Future<? extends V> a();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return a().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return a().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return a().get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return a().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return a().isDone();
    }
}
