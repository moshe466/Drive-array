package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
class AnswersEventValidator {
    final int a;
    final int b;
    boolean c;

    public AnswersEventValidator(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    private void logOrThrowException(RuntimeException runtimeException) {
        if (this.c) {
            throw runtimeException;
        }
        Fabric.getLogger().e(Answers.TAG, "Invalid user input detected", runtimeException);
    }

    public boolean isFullMap(Map<String, Object> map, String str) {
        if (map.size() < this.a || map.containsKey(str)) {
            return false;
        }
        logOrThrowException(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", Integer.valueOf(this.a))));
        return true;
    }

    public boolean isNull(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        logOrThrowException(new NullPointerException(str + " must not be null"));
        return true;
    }

    public String limitStringLength(String str) {
        int length = str.length();
        int i = this.b;
        if (length <= i) {
            return str;
        }
        logOrThrowException(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", Integer.valueOf(i))));
        return str.substring(0, this.b);
    }
}
