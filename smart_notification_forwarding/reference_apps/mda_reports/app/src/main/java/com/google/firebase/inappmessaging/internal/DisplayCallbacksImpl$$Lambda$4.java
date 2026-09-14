package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
public final /* synthetic */ class DisplayCallbacksImpl$$Lambda$4 implements Action {
    private final DisplayCallbacksImpl arg$1;
    private final com.google.firebase.inappmessaging.model.Action arg$2;

    private DisplayCallbacksImpl$$Lambda$4(DisplayCallbacksImpl displayCallbacksImpl, com.google.firebase.inappmessaging.model.Action action) {
        this.arg$1 = displayCallbacksImpl;
        this.arg$2 = action;
    }

    public static Action lambdaFactory$(DisplayCallbacksImpl displayCallbacksImpl, com.google.firebase.inappmessaging.model.Action action) {
        return new DisplayCallbacksImpl$$Lambda$4(displayCallbacksImpl, action);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        r0.metricsLoggerClient.logMessageClick(this.arg$1.inAppMessage, this.arg$2);
    }
}
