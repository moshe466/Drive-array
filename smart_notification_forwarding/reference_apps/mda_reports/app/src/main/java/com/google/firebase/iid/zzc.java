package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class zzc implements Executor {
    static final Executor a = new zzc();

    private zzc() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
