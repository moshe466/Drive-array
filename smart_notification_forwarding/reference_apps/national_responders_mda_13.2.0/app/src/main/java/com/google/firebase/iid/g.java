package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final /* synthetic */ class g implements Executor {

    /* renamed from: f, reason: collision with root package name */
    static final Executor f7295f = new g();

    private g() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
