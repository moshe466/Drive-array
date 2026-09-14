package com.google.firebase.inappmessaging.internal;

/* loaded from: classes2.dex */
final /* synthetic */ class ForegroundNotifier$$Lambda$1 implements Runnable {
    private final ForegroundNotifier arg$1;

    private ForegroundNotifier$$Lambda$1(ForegroundNotifier foregroundNotifier) {
        this.arg$1 = foregroundNotifier;
    }

    public static Runnable lambdaFactory$(ForegroundNotifier foregroundNotifier) {
        return new ForegroundNotifier$$Lambda$1(foregroundNotifier);
    }

    @Override // java.lang.Runnable
    public void run() {
        ForegroundNotifier.a(this.arg$1);
    }
}
