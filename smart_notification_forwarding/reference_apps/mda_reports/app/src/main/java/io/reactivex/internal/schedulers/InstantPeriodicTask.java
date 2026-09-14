package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> f = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    final Runnable a;
    final ExecutorService d;
    Thread e;
    final AtomicReference<Future<?>> c = new AtomicReference<>();
    final AtomicReference<Future<?>> b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.d = executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.c.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!this.c.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.b.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!this.b.compareAndSet(future2, future));
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.e = Thread.currentThread();
        try {
            this.a.run();
            b(this.d.submit(this));
            this.e = null;
        } catch (Throwable th) {
            this.e = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> andSet = this.c.getAndSet(f);
        if (andSet != null && andSet != f) {
            andSet.cancel(this.e != Thread.currentThread());
        }
        Future<?> andSet2 = this.b.getAndSet(f);
        if (andSet2 == null || andSet2 == f) {
            return;
        }
        andSet2.cancel(this.e != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.get() == f;
    }
}
