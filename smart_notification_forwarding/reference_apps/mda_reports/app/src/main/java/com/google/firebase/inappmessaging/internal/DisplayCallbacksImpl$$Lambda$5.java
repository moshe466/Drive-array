package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
final /* synthetic */ class DisplayCallbacksImpl$$Lambda$5 implements Action {
    private final DisplayCallbacksImpl arg$1;
    private final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason arg$2;

    private DisplayCallbacksImpl$$Lambda$5(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        this.arg$1 = displayCallbacksImpl;
        this.arg$2 = inAppMessagingErrorReason;
    }

    public static Action lambdaFactory$(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        return new DisplayCallbacksImpl$$Lambda$5(displayCallbacksImpl, inAppMessagingErrorReason);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        r0.metricsLoggerClient.logRenderError(this.arg$1.inAppMessage, this.arg$2);
    }
}
