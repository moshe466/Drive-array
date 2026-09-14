package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
final /* synthetic */ class AsyncQueue$$Lambda$3 implements Runnable {
    private final Throwable arg$1;

    private AsyncQueue$$Lambda$3(Throwable th) {
        this.arg$1 = th;
    }

    public static Runnable lambdaFactory$(Throwable th) {
        return new AsyncQueue$$Lambda$3(th);
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncQueue.a(this.arg$1);
        throw null;
    }
}
