package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseInAppMessagingDisplay$$Lambda$1 implements com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay {
    private final FirebaseInAppMessagingDisplay arg$1;
    private final Activity arg$2;

    private FirebaseInAppMessagingDisplay$$Lambda$1(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity) {
        this.arg$1 = firebaseInAppMessagingDisplay;
        this.arg$2 = activity;
    }

    public static com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay lambdaFactory$(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity) {
        return new FirebaseInAppMessagingDisplay$$Lambda$1(firebaseInAppMessagingDisplay, activity);
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        FirebaseInAppMessagingDisplay.lambda$onActivityStarted$0(this.arg$1, this.arg$2, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }
}
