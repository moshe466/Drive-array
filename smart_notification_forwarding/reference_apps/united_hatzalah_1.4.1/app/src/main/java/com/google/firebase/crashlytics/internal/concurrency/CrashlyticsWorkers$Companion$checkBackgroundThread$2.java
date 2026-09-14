package com.google.firebase.crashlytics.internal.concurrency;

import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class CrashlyticsWorkers$Companion$checkBackgroundThread$2 extends k implements F2.a {
    public static final CrashlyticsWorkers$Companion$checkBackgroundThread$2 INSTANCE = new CrashlyticsWorkers$Companion$checkBackgroundThread$2();

    public CrashlyticsWorkers$Companion$checkBackgroundThread$2() {
        super(0);
    }

    @Override // F2.a
    public final String invoke() {
        String threadName;
        StringBuilder sb = new StringBuilder("Must be called on a background thread, was called on ");
        threadName = CrashlyticsWorkers.Companion.getThreadName();
        sb.append(threadName);
        sb.append('.');
        return sb.toString();
    }
}
