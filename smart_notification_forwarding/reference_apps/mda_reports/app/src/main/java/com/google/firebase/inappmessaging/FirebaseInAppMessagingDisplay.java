package com.google.firebase.inappmessaging;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.model.InAppMessage;

@Keep
/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingDisplay {
    @Keep
    void displayMessage(@NonNull InAppMessage inAppMessage, @NonNull FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks);
}
