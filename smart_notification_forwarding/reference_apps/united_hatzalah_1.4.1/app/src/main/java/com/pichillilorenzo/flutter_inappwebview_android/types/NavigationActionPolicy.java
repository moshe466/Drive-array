package com.pichillilorenzo.flutter_inappwebview_android.types;

import e0.a;

/* loaded from: classes.dex */
public enum NavigationActionPolicy {
    CANCEL(0),
    ALLOW(1);

    private final int value;

    NavigationActionPolicy(int i) {
        this.value = i;
    }

    public static NavigationActionPolicy fromValue(int i) {
        for (NavigationActionPolicy navigationActionPolicy : values()) {
            if (i == navigationActionPolicy.value) {
                return navigationActionPolicy;
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

    public int rawValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.value);
    }
}
