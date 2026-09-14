package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final /* synthetic */ class AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$3 implements Callable {
    private final Runnable arg$1;

    private AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$3(Runnable runnable) {
        this.arg$1 = runnable;
    }

    public static Callable lambdaFactory$(Runnable runnable) {
        return new AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$3(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return AsyncQueue.SynchronizedShutdownAwareExecutor.a(this.arg$1);
    }
}
