package com.google.firebase.firestore.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class ExponentialBackoff$$Lambda$1 implements Runnable {
    private final ExponentialBackoff arg$1;
    private final Runnable arg$2;

    private ExponentialBackoff$$Lambda$1(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        this.arg$1 = exponentialBackoff;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        return new ExponentialBackoff$$Lambda$1(exponentialBackoff, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ExponentialBackoff.a(this.arg$1, this.arg$2);
    }
}
