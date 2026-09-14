package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingImpressionListener {
    void impressionDetected(@NonNull InAppMessage inAppMessage);
}
