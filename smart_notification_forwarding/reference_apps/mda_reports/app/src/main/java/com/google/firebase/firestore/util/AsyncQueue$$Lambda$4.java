package com.google.firebase.firestore.util;

import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
final /* synthetic */ class AsyncQueue$$Lambda$4 implements Runnable {
    private final Runnable arg$1;
    private final Throwable[] arg$2;
    private final Semaphore arg$3;

    private AsyncQueue$$Lambda$4(Runnable runnable, Throwable[] thArr, Semaphore semaphore) {
        this.arg$1 = runnable;
        this.arg$2 = thArr;
        this.arg$3 = semaphore;
    }

    public static Runnable lambdaFactory$(Runnable runnable, Throwable[] thArr, Semaphore semaphore) {
        return new AsyncQueue$$Lambda$4(runnable, thArr, semaphore);
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncQueue.a(this.arg$1, this.arg$2, this.arg$3);
    }
}
