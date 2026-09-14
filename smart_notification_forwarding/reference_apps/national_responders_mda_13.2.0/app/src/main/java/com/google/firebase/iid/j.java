package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class j implements Executor {

    /* renamed from: f, reason: collision with root package name */
    static final Executor f7300f = new j();

    private j() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
