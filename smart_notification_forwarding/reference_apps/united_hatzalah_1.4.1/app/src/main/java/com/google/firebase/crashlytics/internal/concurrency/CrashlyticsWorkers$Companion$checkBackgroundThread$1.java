package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public /* synthetic */ class CrashlyticsWorkers$Companion$checkBackgroundThread$1 extends i implements F2.a {
    public CrashlyticsWorkers$Companion$checkBackgroundThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
    }

    @Override // F2.a
    public final Boolean invoke() {
        boolean isBackgroundThread;
        isBackgroundThread = ((CrashlyticsWorkers.Companion) this.receiver).isBackgroundThread();
        return Boolean.valueOf(isBackgroundThread);
    }
}
