package com.google.firebase.remoteconfig;

import F2.l;
import S2.z;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.CustomSignals;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class RemoteConfigKt {
    public static final CustomSignals customSignals(l builder) {
        j.e(builder, "builder");
        CustomSignals.Builder builder2 = new CustomSignals.Builder();
        builder.invoke(builder2);
        CustomSignals build = builder2.build();
        j.d(build, "Builder().apply(builder).build()");
        return build;
    }

    public static final FirebaseRemoteConfigValue get(FirebaseRemoteConfig firebaseRemoteConfig, String key) {
        j.e(firebaseRemoteConfig, "<this>");
        j.e(key, "key");
        FirebaseRemoteConfigValue value = firebaseRemoteConfig.getValue(key);
        j.d(value, "this.getValue(key)");
        return value;
    }

    public static final S2.d getConfigUpdates(FirebaseRemoteConfig firebaseRemoteConfig) {
        j.e(firebaseRemoteConfig, "<this>");
        return z.b(new RemoteConfigKt$configUpdates$1(firebaseRemoteConfig, null));
    }

    public static final FirebaseRemoteConfig getRemoteConfig(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        j.d(firebaseRemoteConfig, "getInstance()");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfig remoteConfig(Firebase firebase, FirebaseApp app2) {
        j.e(firebase, "<this>");
        j.e(app2, "app");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance(app2);
        j.d(firebaseRemoteConfig, "getInstance(app)");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfigSettings remoteConfigSettings(l init) {
        j.e(init, "init");
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        init.invoke(builder);
        FirebaseRemoteConfigSettings build = builder.build();
        j.d(build, "builder.build()");
        return build;
    }
}
