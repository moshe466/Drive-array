package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.util.AsyncQueue;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$2 implements Runnable {
    private final TaskCompletionSource arg$1;
    private final Callable arg$2;

    private AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$2(TaskCompletionSource taskCompletionSource, Callable callable) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = callable;
    }

    public static Runnable lambdaFactory$(TaskCompletionSource taskCompletionSource, Callable callable) {
        return new AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$2(taskCompletionSource, callable);
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncQueue.SynchronizedShutdownAwareExecutor.a(this.arg$1, this.arg$2);
    }
}
