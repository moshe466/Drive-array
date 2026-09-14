package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$5 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$5 instance = new InAppMessageStreamManager$$Lambda$5();

    private InAppMessageStreamManager$$Lambda$5() {
    }

    public static Consumer lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        Logging.logi("App foreground rate limited ? : " + ((Boolean) obj));
    }
}
