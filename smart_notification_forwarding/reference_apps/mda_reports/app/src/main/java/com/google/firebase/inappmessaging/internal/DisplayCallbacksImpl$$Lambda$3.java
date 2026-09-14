package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import io.reactivex.functions.Action;

/* loaded from: classes2.dex */
public final /* synthetic */ class DisplayCallbacksImpl$$Lambda$3 implements Action {
    private final DisplayCallbacksImpl arg$1;
    private final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType arg$2;

    private DisplayCallbacksImpl$$Lambda$3(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        this.arg$1 = displayCallbacksImpl;
        this.arg$2 = inAppMessagingDismissType;
    }

    public static Action lambdaFactory$(DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        return new DisplayCallbacksImpl$$Lambda$3(displayCallbacksImpl, inAppMessagingDismissType);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        r0.metricsLoggerClient.logDismiss(this.arg$1.inAppMessage, this.arg$2);
    }
}
