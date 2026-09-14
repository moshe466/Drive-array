package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class LoginEvent extends PredefinedEvent<LoginEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return FirebaseAnalytics.Event.LOGIN;
    }

    public LoginEvent putMethod(String str) {
        this.c.a(FirebaseAnalytics.Param.METHOD, str);
        return this;
    }

    public LoginEvent putSuccess(boolean z) {
        this.c.a(FirebaseAnalytics.Param.SUCCESS, Boolean.toString(z));
        return this;
    }
}
