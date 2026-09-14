package com.crashlytics.android.answers;

import com.crashlytics.android.answers.AnswersEvent;
import io.fabric.sdk.android.Fabric;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AnswersEvent<T extends AnswersEvent> {
    public static final int MAX_NUM_ATTRIBUTES = 20;
    public static final int MAX_STRING_LENGTH = 100;
    final AnswersEventValidator a = new AnswersEventValidator(20, 100, Fabric.isDebuggable());
    final AnswersAttributes b = new AnswersAttributes(this.a);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> a() {
        return this.b.b;
    }

    public T putCustomAttribute(String str, Number number) {
        this.b.a(str, number);
        return this;
    }

    public T putCustomAttribute(String str, String str2) {
        this.b.a(str, str2);
        return this;
    }
}
