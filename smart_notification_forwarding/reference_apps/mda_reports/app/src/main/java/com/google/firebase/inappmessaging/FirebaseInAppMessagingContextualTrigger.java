package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class FirebaseInAppMessagingContextualTrigger {
    private final String triggerName;

    public FirebaseInAppMessagingContextualTrigger(@NonNull String str) {
        this.triggerName = str;
    }

    @NonNull
    public String getTriggerName() {
        return this.triggerName;
    }
}
