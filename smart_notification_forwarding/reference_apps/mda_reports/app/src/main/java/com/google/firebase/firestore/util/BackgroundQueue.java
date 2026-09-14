package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class BackgroundQueue implements Executor {
    private Semaphore completedTasks = new Semaphore(0);
    private int pendingTaskCount = 0;

    public static /* synthetic */ void a(BackgroundQueue backgroundQueue, Runnable runnable) {
        runnable.run();
        backgroundQueue.completedTasks.release();
    }

    public void drain() {
        this.completedTasks.acquire(this.pendingTaskCount);
        this.pendingTaskCount = 0;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.pendingTaskCount++;
        Executors.BACKGROUND_EXECUTOR.execute(BackgroundQueue$$Lambda$1.lambdaFactory$(this, runnable));
    }
}
