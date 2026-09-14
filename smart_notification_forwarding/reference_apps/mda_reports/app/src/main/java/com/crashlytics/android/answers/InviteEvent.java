package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class InviteEvent extends PredefinedEvent<InviteEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "invite";
    }

    public InviteEvent putMethod(String str) {
        this.c.a(FirebaseAnalytics.Param.METHOD, str);
        return this;
    }
}
