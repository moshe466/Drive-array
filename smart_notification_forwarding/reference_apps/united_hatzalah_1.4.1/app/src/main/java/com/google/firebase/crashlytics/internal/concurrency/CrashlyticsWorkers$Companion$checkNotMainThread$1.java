package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public /* synthetic */ class CrashlyticsWorkers$Companion$checkNotMainThread$1 extends i implements F2.a {
    public CrashlyticsWorkers$Companion$checkNotMainThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isNotMainThread", "isNotMainThread()Z", 0);
    }

    @Override // F2.a
    public final Boolean invoke() {
        boolean isNotMainThread;
        isNotMainThread = ((CrashlyticsWorkers.Companion) this.receiver).isNotMainThread();
        return Boolean.valueOf(isNotMainThread);
    }
}
