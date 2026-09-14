package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class KeyValueBuilder {
    private final CustomKeysAndValues.Builder builder;
    private final FirebaseCrashlytics crashlytics;

    private KeyValueBuilder(FirebaseCrashlytics firebaseCrashlytics, CustomKeysAndValues.Builder builder) {
        this.crashlytics = firebaseCrashlytics;
        this.builder = builder;
    }

    public final CustomKeysAndValues build$com_google_firebase_firebase_crashlytics() {
        CustomKeysAndValues build = this.builder.build();
        j.d(build, "builder.build()");
        return build;
    }

    public final void key(String key, boolean z3) {
        j.e(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(key, z3);
        } else {
            j.d(this.builder.putBoolean(key, z3), "builder.putBoolean(key, value)");
        }
    }

    public final void key(String key, double d2) {
        j.e(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(key, d2);
        } else {
            j.d(this.builder.putDouble(key, d2), "builder.putDouble(key, value)");
        }
    }

    public final void key(String key, float f4) {
        j.e(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(key, f4);
        } else {
            j.d(this.builder.putFloat(key, f4), "builder.putFloat(key, value)");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        this(crashlytics, new CustomKeysAndValues.Builder());
        j.e(crashlytics, "crashlytics");
    }

    public final void key(String key, int i) {
        j.e(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(key, i);
        } else {
            j.d(this.builder.putInt(key, i), "builder.putInt(key, value)");
        }
    }

    public KeyValueBuilder() {
        this(null, new CustomKeysAndValues.Builder());
    }

    public final void key(String key, long j2) {
        j.e(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(key, j2);
        } else {
            j.d(this.builder.putLong(key, j2), "builder.putLong(key, value)");
        }
    }

    public final void key(String key, String value) {
        j.e(key, "key");
        j.e(value, "value");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(key, value);
        } else {
            j.d(this.builder.putString(key, value), "builder.putString(key, value)");
        }
    }
}
