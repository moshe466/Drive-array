package com.crashlytics.android.answers;

/* loaded from: classes.dex */
public class LevelStartEvent extends PredefinedEvent<LevelStartEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return "levelStart";
    }

    public LevelStartEvent putLevelName(String str) {
        this.c.a("levelName", str);
        return this;
    }
}
