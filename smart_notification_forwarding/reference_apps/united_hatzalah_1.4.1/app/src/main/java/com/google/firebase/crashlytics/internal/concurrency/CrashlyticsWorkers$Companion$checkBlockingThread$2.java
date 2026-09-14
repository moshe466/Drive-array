package com.google.firebase.crashlytics.internal.concurrency;

import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class CrashlyticsWorkers$Companion$checkBlockingThread$2 extends k implements F2.a {
    public static final CrashlyticsWorkers$Companion$checkBlockingThread$2 INSTANCE = new CrashlyticsWorkers$Companion$checkBlockingThread$2();

    public CrashlyticsWorkers$Companion$checkBlockingThread$2() {
        super(0);
    }

    @Override // F2.a
    public final String invoke() {
        String threadName;
        StringBuilder sb = new StringBuilder("Must be called on a blocking thread, was called on ");
        threadName = CrashlyticsWorkers.Companion.getThreadName();
        sb.append(threadName);
        sb.append('.');
        return sb.toString();
    }
}
