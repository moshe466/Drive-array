package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;

/* loaded from: classes2.dex */
final /* synthetic */ class AsyncQueue$$Lambda$5 implements Runnable {
    private final AsyncQueue arg$1;
    private final AsyncQueue.TimerId arg$2;

    private AsyncQueue$$Lambda$5(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        this.arg$1 = asyncQueue;
        this.arg$2 = timerId;
    }

    public static Runnable lambdaFactory$(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        return new AsyncQueue$$Lambda$5(asyncQueue, timerId);
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncQueue.a(this.arg$1, this.arg$2);
    }
}
