package com.crashlytics.android.answers;

import kotlin.text.Typography;

/* loaded from: classes.dex */
public class CustomEvent extends AnswersEvent<CustomEvent> {
    private final String eventName;

    public CustomEvent(String str) {
        if (str == null) {
            throw new NullPointerException("eventName must not be null");
        }
        this.eventName = this.a.limitStringLength(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.eventName;
    }

    public String toString() {
        return "{eventName:\"" + this.eventName + Typography.quote + ", customAttributes:" + this.b + "}";
    }
}
