package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public /* synthetic */ class CrashlyticsWorkers$Companion$checkBlockingThread$1 extends i implements F2.a {
    public CrashlyticsWorkers$Companion$checkBlockingThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isBlockingThread", "isBlockingThread()Z", 0);
    }

    @Override // F2.a
    public final Boolean invoke() {
        boolean isBlockingThread;
        isBlockingThread = ((CrashlyticsWorkers.Companion) this.receiver).isBlockingThread();
        return Boolean.valueOf(isBlockingThread);
    }
}
