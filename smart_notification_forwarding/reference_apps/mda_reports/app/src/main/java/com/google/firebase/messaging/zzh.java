package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class zzh implements Executor {
    static final Executor a = new zzh();

    private zzh() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
