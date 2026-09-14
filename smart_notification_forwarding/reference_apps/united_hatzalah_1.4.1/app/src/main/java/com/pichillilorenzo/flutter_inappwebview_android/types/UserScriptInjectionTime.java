package com.pichillilorenzo.flutter_inappwebview_android.types;

import e0.a;

/* loaded from: classes.dex */
public enum UserScriptInjectionTime {
    AT_DOCUMENT_START(0),
    AT_DOCUMENT_END(1);

    private final int value;

    UserScriptInjectionTime(int i) {
        this.value = i;
    }

    public static UserScriptInjectionTime fromValue(int i) {
        for (UserScriptInjectionTime userScriptInjectionTime : values()) {
            if (i == userScriptInjectionTime.toValue()) {
                return userScriptInjectionTime;
            }
        }
        throw new IllegalArgumentException(a.c(i, "No enum constant: "));
    }

    public boolean equalsValue(int i) {
        if (this.value == i) {
            return true;
        }
        return false;
    }

    public int toValue() {
        return this.value;
    }
}
