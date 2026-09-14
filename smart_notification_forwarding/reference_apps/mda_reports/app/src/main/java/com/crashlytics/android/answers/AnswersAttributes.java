package com.crashlytics.android.answers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
class AnswersAttributes {
    final AnswersEventValidator a;
    final Map<String, Object> b = new ConcurrentHashMap();

    public AnswersAttributes(AnswersEventValidator answersEventValidator) {
        this.a = answersEventValidator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Number number) {
        if (this.a.isNull(str, "key") || this.a.isNull(number, "value")) {
            return;
        }
        a(this.a.limitStringLength(str), (Object) number);
    }

    void a(String str, Object obj) {
        if (this.a.isFullMap(this.b, str)) {
            return;
        }
        this.b.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (this.a.isNull(str, "key") || this.a.isNull(str2, "value")) {
            return;
        }
        a(this.a.limitStringLength(str), (Object) this.a.limitStringLength(str2));
    }

    public String toString() {
        return new JSONObject(this.b).toString();
    }
}
