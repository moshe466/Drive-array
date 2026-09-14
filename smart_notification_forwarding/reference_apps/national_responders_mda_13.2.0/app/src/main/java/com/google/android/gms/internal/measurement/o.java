package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private ThreadFactory f5510a = Executors.defaultThreadFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f5510a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
