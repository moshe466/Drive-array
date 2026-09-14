package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class ShareEvent extends PredefinedEvent<ShareEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return FirebaseAnalytics.Event.SHARE;
    }

    public ShareEvent putContentId(String str) {
        this.c.a("contentId", str);
        return this;
    }

    public ShareEvent putContentName(String str) {
        this.c.a("contentName", str);
        return this;
    }

    public ShareEvent putContentType(String str) {
        this.c.a("contentType", str);
        return this;
    }

    public ShareEvent putMethod(String str) {
        this.c.a(FirebaseAnalytics.Param.METHOD, str);
        return this;
    }
}
