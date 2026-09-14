package com.crashlytics.android.answers;

/* loaded from: classes.dex */
public class ContentViewEvent extends PredefinedEvent<ContentViewEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "contentView";
    }

    public ContentViewEvent putContentId(String str) {
        this.c.a("contentId", str);
        return this;
    }

    public ContentViewEvent putContentName(String str) {
        this.c.a("contentName", str);
        return this;
    }

    public ContentViewEvent putContentType(String str) {
        this.c.a("contentType", str);
        return this;
    }
}
