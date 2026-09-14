package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.LruGarbageCollector;

/* loaded from: classes2.dex */
final /* synthetic */ class LruGarbageCollector$Scheduler$$Lambda$1 implements Runnable {
    private final LruGarbageCollector.Scheduler arg$1;

    private LruGarbageCollector$Scheduler$$Lambda$1(LruGarbageCollector.Scheduler scheduler) {
        this.arg$1 = scheduler;
    }

    public static Runnable lambdaFactory$(LruGarbageCollector.Scheduler scheduler) {
        return new LruGarbageCollector$Scheduler$$Lambda$1(scheduler);
    }

    @Override // java.lang.Runnable
    public void run() {
        LruGarbageCollector.Scheduler.a(this.arg$1);
    }
}
