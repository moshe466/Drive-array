package com.crashlytics.android.answers;

/* loaded from: classes.dex */
public class RatingEvent extends PredefinedEvent<RatingEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "rating";
    }

    public RatingEvent putContentId(String str) {
        this.c.a("contentId", str);
        return this;
    }

    public RatingEvent putContentName(String str) {
        this.c.a("contentName", str);
        return this;
    }

    public RatingEvent putContentType(String str) {
        this.c.a("contentType", str);
        return this;
    }

    public RatingEvent putRating(int i) {
        this.c.a("rating", (Number) Integer.valueOf(i));
        return this;
    }
}
