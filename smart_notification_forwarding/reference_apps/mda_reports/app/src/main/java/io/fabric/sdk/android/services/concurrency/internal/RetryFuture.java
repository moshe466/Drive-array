package io.fabric.sdk.android.services.concurrency.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class RetryFuture<T> extends AbstractFuture<T> implements Runnable {
    RetryState a;
    private final RetryThreadPoolExecutor executor;
    private final AtomicReference<Thread> runner = new AtomicReference<>();
    private final Callable<T> task;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryFuture(Callable<T> callable, RetryState retryState, RetryThreadPoolExecutor retryThreadPoolExecutor) {
        this.task = callable;
        this.a = retryState;
        this.executor = retryThreadPoolExecutor;
    }

    private Backoff getBackoff() {
        return this.a.getBackoff();
    }

    private int getRetryCount() {
        return this.a.getRetryCount();
    }

    private RetryPolicy getRetryPolicy() {
        return this.a.getRetryPolicy();
    }

    @Override // io.fabric.sdk.android.services.concurrency.internal.AbstractFuture
    protected void a() {
        Thread andSet = this.runner.getAndSet(null);
        if (andSet != null) {
            andSet.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDone()) {
            return;
        }
        if (this.runner.compareAndSet(null, Thread.currentThread())) {
            try {
                a((RetryFuture<T>) this.task.call());
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
