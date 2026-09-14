package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final /* synthetic */ class Executors$$Lambda$1 implements Executor {
    private static final Executors$$Lambda$1 instance = new Executors$$Lambda$1();

    private Executors$$Lambda$1() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
