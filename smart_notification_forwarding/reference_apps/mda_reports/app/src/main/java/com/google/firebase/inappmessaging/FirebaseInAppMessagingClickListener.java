package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingClickListener {
    void messageClicked(@NonNull InAppMessage inAppMessage, @NonNull Action action);
}
