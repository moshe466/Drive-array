package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$32 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$32 instance = new InAppMessageStreamManager$$Lambda$32();

    private InAppMessageStreamManager$$Lambda$32() {
    }

    public static Consumer lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        Logging.logw("Cache write error: " + ((Throwable) obj).getMessage());
    }
}
