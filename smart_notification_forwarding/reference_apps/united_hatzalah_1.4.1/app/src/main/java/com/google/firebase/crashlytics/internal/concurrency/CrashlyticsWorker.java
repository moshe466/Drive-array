package com.google.firebase.crashlytics.internal.concurrency;

import J0.d;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CrashlyticsWorker implements Executor {
    private final ExecutorService executor;
    private final Object tailLock = new Object();
    private Task<?> tail = Tasks.forResult(null);

    public CrashlyticsWorker(ExecutorService executorService) {
        this.executor = executorService;
    }

    public static /* synthetic */ void lambda$await$6() {
    }

    public static /* synthetic */ Task lambda$submit$0(Callable callable, Task task) {
        return Tasks.forResult(callable.call());
    }

    public static /* synthetic */ Task lambda$submit$1(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task lambda$submitTask$2(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public static /* synthetic */ Task lambda$submitTask$3(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public static /* synthetic */ Task lambda$submitTaskOnSuccess$4(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public static /* synthetic */ Task lambda$submitTaskOnSuccess$5(SuccessContinuation successContinuation, Task task) {
        if (task.isSuccessful()) {
            return successContinuation.then(task.getResult());
        }
        if (task.getException() != null) {
            return Tasks.forException(task.getException());
        }
        return Tasks.forCanceled();
    }

    public void await() {
        Tasks.await(submit(new b(0)), 30L, TimeUnit.SECONDS);
        Thread.sleep(1L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public <T> Task<T> submit(Callable<T> callable) {
        zzw zzwVar;
        synchronized (this.tailLock) {
            zzwVar = (Task<T>) this.tail.continueWithTask(this.executor, new a(callable, 0));
            this.tail = zzwVar;
        }
        return zzwVar;
    }

    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        zzw zzwVar;
        synchronized (this.tailLock) {
            zzwVar = (Task<T>) this.tail.continueWithTask(this.executor, new a(callable, 1));
            this.tail = zzwVar;
        }
        return zzwVar;
    }

    public <T, R> Task<R> submitTaskOnSuccess(Callable<Task<T>> callable, SuccessContinuation<T, R> successContinuation) {
        zzw zzwVar;
        synchronized (this.tailLock) {
            zzwVar = (Task<R>) this.tail.continueWithTask(this.executor, new a(callable, 3)).continueWithTask(this.executor, new d(successContinuation, 12));
            this.tail = zzwVar;
        }
        return zzwVar;
    }

    public Task<Void> submit(Runnable runnable) {
        Task continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new d(runnable, 11));
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }

    public <T, R> Task<R> submitTask(Callable<Task<T>> callable, Continuation<T, Task<R>> continuation) {
        zzw zzwVar;
        synchronized (this.tailLock) {
            zzwVar = (Task<R>) this.tail.continueWithTask(this.executor, new a(callable, 2)).continueWithTask(this.executor, continuation);
            this.tail = zzwVar;
        }
        return zzwVar;
    }
}
