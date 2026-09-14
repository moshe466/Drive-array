package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseInAppMessaging$$Lambda$1 implements Consumer {
    private final FirebaseInAppMessaging arg$1;

    private FirebaseInAppMessaging$$Lambda$1(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.arg$1 = firebaseInAppMessaging;
    }

    public static Consumer lambdaFactory$(FirebaseInAppMessaging firebaseInAppMessaging) {
        return new FirebaseInAppMessaging$$Lambda$1(firebaseInAppMessaging);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        FirebaseInAppMessaging.a(this.arg$1, (TriggeredInAppMessage) obj);
    }
}
