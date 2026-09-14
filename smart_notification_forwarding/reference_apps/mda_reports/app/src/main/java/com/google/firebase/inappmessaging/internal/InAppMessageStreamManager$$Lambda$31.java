package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$31 implements Action {
    private static final InAppMessageStreamManager$$Lambda$31 instance = new InAppMessageStreamManager$$Lambda$31();

    private InAppMessageStreamManager$$Lambda$31() {
    }

    public static Action lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        Logging.logd("Wrote to cache");
    }
}
