package com.google.firebase.firestore.util;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class AsyncQueue$$Lambda$2 implements Callable {
    private final Runnable arg$1;

    private AsyncQueue$$Lambda$2(Runnable runnable) {
        this.arg$1 = runnable;
    }

    public static Callable lambdaFactory$(Runnable runnable) {
        return new AsyncQueue$$Lambda$2(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return AsyncQueue.a(this.arg$1);
    }
}
