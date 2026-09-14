package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class e implements Executor {

    /* renamed from: f, reason: collision with root package name */
    static final Executor f7430f = new e();

    private e() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
