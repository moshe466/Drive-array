package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
class ManifestUnityVersionProvider implements UnityVersionProvider {
    private final Context context;
    private final String packageName;

    public ManifestUnityVersionProvider(Context context, String str) {
        this.context = context;
        this.packageName = str;
    }

    @Override // com.crashlytics.android.core.UnityVersionProvider
    public String getUnityVersion() {
        try {
            Bundle bundle = this.context.getPackageManager().getApplicationInfo(this.packageName, 128).metaData;
            if (bundle != null) {
                return bundle.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
