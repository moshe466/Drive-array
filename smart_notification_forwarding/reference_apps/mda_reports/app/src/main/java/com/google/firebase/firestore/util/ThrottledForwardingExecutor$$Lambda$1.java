package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
final /* synthetic */ class ThrottledForwardingExecutor$$Lambda$1 implements Runnable {
    private final ThrottledForwardingExecutor arg$1;
    private final Runnable arg$2;

    private ThrottledForwardingExecutor$$Lambda$1(ThrottledForwardingExecutor throttledForwardingExecutor, Runnable runnable) {
        this.arg$1 = throttledForwardingExecutor;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(ThrottledForwardingExecutor throttledForwardingExecutor, Runnable runnable) {
        return new ThrottledForwardingExecutor$$Lambda$1(throttledForwardingExecutor, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ThrottledForwardingExecutor.a(this.arg$1, this.arg$2);
    }
}
