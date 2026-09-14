package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class LevelEndEvent extends PredefinedEvent<LevelEndEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "levelEnd";
    }

    public LevelEndEvent putLevelName(String str) {
        this.c.a("levelName", str);
        return this;
    }

    public LevelEndEvent putScore(Number number) {
        this.c.a(FirebaseAnalytics.Param.SCORE, number);
        return this;
    }

    public LevelEndEvent putSuccess(boolean z) {
        this.c.a(FirebaseAnalytics.Param.SUCCESS, z ? "true" : "false");
        return this;
    }
}
