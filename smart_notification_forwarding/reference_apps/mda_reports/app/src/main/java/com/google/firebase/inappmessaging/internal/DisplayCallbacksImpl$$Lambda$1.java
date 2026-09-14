package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
final /* synthetic */ class DisplayCallbacksImpl$$Lambda$1 implements Action {
    private final DisplayCallbacksImpl arg$1;

    private DisplayCallbacksImpl$$Lambda$1(DisplayCallbacksImpl displayCallbacksImpl) {
        this.arg$1 = displayCallbacksImpl;
    }

    public static Action lambdaFactory$(DisplayCallbacksImpl displayCallbacksImpl) {
        return new DisplayCallbacksImpl$$Lambda$1(displayCallbacksImpl);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        DisplayCallbacksImpl.a(this.arg$1);
    }
}
