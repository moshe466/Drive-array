package com.google.firebase.crashlytics.ktx;

import F2.l;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class FirebaseCrashlyticsKt {
    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        j.d(firebaseCrashlytics, "getInstance()");
        return firebaseCrashlytics;
    }

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, l init) {
        j.e(firebaseCrashlytics, "<this>");
        j.e(init, "init");
        init.invoke(new KeyValueBuilder(firebaseCrashlytics));
    }
}
