package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
final /* synthetic */ class DisplayCallbacksImpl$$Lambda$9 implements Action {
    private static final DisplayCallbacksImpl$$Lambda$9 instance = new DisplayCallbacksImpl$$Lambda$9();

    private DisplayCallbacksImpl$$Lambda$9() {
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        Logging.logd("Rate limiter client write success");
    }
}
