package com.google.firebase.platforminfo;

import s2.C0677b;

/* loaded from: classes.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            C0677b.f6330b.getClass();
            return "2.2.20";
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
