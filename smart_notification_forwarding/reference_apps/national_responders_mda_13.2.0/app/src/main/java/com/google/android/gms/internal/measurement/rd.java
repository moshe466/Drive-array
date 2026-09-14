package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class rd implements qc {
    @Override // com.google.android.gms.internal.measurement.qc
    public final <V> Callable<V> a(Callable<V> callable) {
        return callable;
    }

    @Override // com.google.android.gms.internal.measurement.qc
    public final Runnable b(Runnable runnable) {
        return runnable;
    }
}
