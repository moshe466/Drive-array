package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class DisplayCallbacksImpl$$Lambda$6 implements Consumer {
    private static final DisplayCallbacksImpl$$Lambda$6 instance = new DisplayCallbacksImpl$$Lambda$6();

    private DisplayCallbacksImpl$$Lambda$6() {
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        DisplayCallbacksImpl.a((Throwable) obj);
    }
}
