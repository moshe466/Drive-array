package com.google.firebase.firestore.core;

import androidx.fragment.app.FragmentActivity;

/* loaded from: classes2.dex */
public final /* synthetic */ class ActivityScope$$Lambda$2 implements Runnable {
    private final FragmentActivity arg$1;
    private final Runnable arg$2;

    private ActivityScope$$Lambda$2(FragmentActivity fragmentActivity, Runnable runnable) {
        this.arg$1 = fragmentActivity;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(FragmentActivity fragmentActivity, Runnable runnable) {
        return new ActivityScope$$Lambda$2(fragmentActivity, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityScope.a(this.arg$1, this.arg$2);
    }
}
