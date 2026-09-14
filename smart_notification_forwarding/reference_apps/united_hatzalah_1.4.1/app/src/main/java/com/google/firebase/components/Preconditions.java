package com.google.firebase.components;

/* loaded from: classes.dex */
public final class Preconditions {
    public static void checkArgument(boolean z3, String str) {
        if (z3) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }

    public static void checkState(boolean z3, String str) {
        if (z3) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T checkNotNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }
}
