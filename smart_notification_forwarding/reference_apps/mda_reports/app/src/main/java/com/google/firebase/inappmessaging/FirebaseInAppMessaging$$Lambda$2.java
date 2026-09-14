package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseInAppMessaging$$Lambda$2 implements Consumer {
    private final FirebaseInAppMessaging arg$1;
    private final TriggeredInAppMessage arg$2;

    private FirebaseInAppMessaging$$Lambda$2(FirebaseInAppMessaging firebaseInAppMessaging, TriggeredInAppMessage triggeredInAppMessage) {
        this.arg$1 = firebaseInAppMessaging;
        this.arg$2 = triggeredInAppMessage;
    }

    public static Consumer lambdaFactory$(FirebaseInAppMessaging firebaseInAppMessaging, TriggeredInAppMessage triggeredInAppMessage) {
        return new FirebaseInAppMessaging$$Lambda$2(firebaseInAppMessaging, triggeredInAppMessage);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        ((FirebaseInAppMessagingDisplay) obj).displayMessage(r1.getInAppMessage(), this.arg$1.displayCallbacksFactory.generateDisplayCallback(r1.getInAppMessage(), this.arg$2.getTriggeringEvent()));
    }
}
