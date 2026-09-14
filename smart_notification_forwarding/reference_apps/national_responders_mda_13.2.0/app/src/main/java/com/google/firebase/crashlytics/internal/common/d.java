package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

/* loaded from: classes.dex */
public abstract class d implements Runnable {
    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
