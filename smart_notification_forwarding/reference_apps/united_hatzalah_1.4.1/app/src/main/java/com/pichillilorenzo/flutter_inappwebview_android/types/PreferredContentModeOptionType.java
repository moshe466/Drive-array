package com.pichillilorenzo.flutter_inappwebview_android.types;

import e0.a;

/* loaded from: classes.dex */
public enum PreferredContentModeOptionType {
    RECOMMENDED(0),
    MOBILE(1),
    DESKTOP(2);

    private final int value;

    PreferredContentModeOptionType(int i) {
        this.value = i;
    }

    public static PreferredContentModeOptionType fromValue(int i) {
        for (PreferredContentModeOptionType preferredContentModeOptionType : values()) {
            if (i == preferredContentModeOptionType.toValue()) {
                return preferredContentModeOptionType;
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
