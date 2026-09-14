package com.crashlytics.android.answers;

import com.crashlytics.android.answers.PredefinedEvent;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public abstract class PredefinedEvent<T extends PredefinedEvent> extends AnswersEvent<T> {
    final AnswersAttributes c = new AnswersAttributes(this.a);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> b() {
        return this.c.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String c();

    public String toString() {
        return "{type:\"" + c() + Typography.quote + ", predefinedAttributes:" + this.c + ", customAttributes:" + this.b + "}";
    }
}
