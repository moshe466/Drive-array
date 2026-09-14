package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$13 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$13 instance = new InAppMessageStreamManager$$Lambda$13();

    private InAppMessageStreamManager$$Lambda$13() {
    }

    public static Consumer lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        Logging.logd("Fetched from cache");
    }
}
