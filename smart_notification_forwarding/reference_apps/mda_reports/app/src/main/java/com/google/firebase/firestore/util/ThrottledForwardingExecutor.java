package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ThrottledForwardingExecutor implements Executor {
    private final Semaphore availableSlots;
    private final Executor executor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThrottledForwardingExecutor(int i, Executor executor) {
        this.availableSlots = new Semaphore(i);
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ThrottledForwardingExecutor throttledForwardingExecutor, Runnable runnable) {
        runnable.run();
        throttledForwardingExecutor.availableSlots.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.availableSlots.tryAcquire()) {
            try {
                this.executor.execute(ThrottledForwardingExecutor$$Lambda$1.lambdaFactory$(this, runnable));
                return;
            } catch (RejectedExecutionException unused) {
            }
        }
        runnable.run();
    }
}
