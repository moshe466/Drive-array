package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
final /* synthetic */ class OnlineStateTracker$$Lambda$1 implements Runnable {
    private final OnlineStateTracker arg$1;

    private OnlineStateTracker$$Lambda$1(OnlineStateTracker onlineStateTracker) {
        this.arg$1 = onlineStateTracker;
    }

    public static Runnable lambdaFactory$(OnlineStateTracker onlineStateTracker) {
        return new OnlineStateTracker$$Lambda$1(onlineStateTracker);
    }

    @Override // java.lang.Runnable
    public void run() {
        OnlineStateTracker.a(this.arg$1);
    }
}
