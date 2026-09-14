package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class DisplayCallbacksImpl$$Lambda$8 implements Consumer {
    private static final DisplayCallbacksImpl$$Lambda$8 instance = new DisplayCallbacksImpl$$Lambda$8();

    private DisplayCallbacksImpl$$Lambda$8() {
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        Logging.loge("Rate limiter client write failure");
    }
}
