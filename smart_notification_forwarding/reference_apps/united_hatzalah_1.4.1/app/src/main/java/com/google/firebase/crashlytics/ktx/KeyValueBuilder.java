package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        j.e(crashlytics, "crashlytics");
        this.crashlytics = crashlytics;
    }

    public final void key(String key, boolean z3) {
        j.e(key, "key");
        this.crashlytics.setCustomKey(key, z3);
    }

    public final void key(String key, double d2) {
        j.e(key, "key");
        this.crashlytics.setCustomKey(key, d2);
    }

    public final void key(String key, float f4) {
        j.e(key, "key");
        this.crashlytics.setCustomKey(key, f4);
    }

    public final void key(String key, int i) {
        j.e(key, "key");
        this.crashlytics.setCustomKey(key, i);
    }

    public final void key(String key, long j2) {
        j.e(key, "key");
        this.crashlytics.setCustomKey(key, j2);
    }

    public final void key(String key, String value) {
        j.e(key, "key");
        j.e(value, "value");
        this.crashlytics.setCustomKey(key, value);
    }
}
