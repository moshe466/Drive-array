package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;

/* loaded from: classes2.dex */
public class FirebaseInfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Context context) {
        int resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, "google_app_id", "string");
        if (resourcesIdentifier == 0) {
            return null;
        }
        Fabric.getLogger().d(Fabric.TAG, "Generating Crashlytics ApiKey from google_app_id in Strings");
        return a(context.getResources().getString(resourcesIdentifier));
    }

    String a(String str) {
        return CommonUtils.sha256(str).substring(0, 40);
    }

    boolean b(Context context) {
        if (TextUtils.isEmpty(new ApiKey().b(context))) {
            return !TextUtils.isEmpty(new ApiKey().c(context));
        }
        return true;
    }

    boolean c(Context context) {
        if (CommonUtils.getResourcesIdentifier(context, "google_app_id", "string") == 0) {
            return false;
        }
        return !TextUtils.isEmpty(context.getResources().getString(r0));
    }

    public boolean isAutoInitializeFlagEnabled(Context context) {
        int resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, "io.fabric.auto_initialize", "bool");
        if (resourcesIdentifier == 0) {
            return false;
        }
        boolean z = context.getResources().getBoolean(resourcesIdentifier);
        if (z) {
            Fabric.getLogger().d(Fabric.TAG, "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
        }
        return z;
    }

    public boolean isFirebaseCrashlyticsEnabled(Context context) {
        if (CommonUtils.getBooleanResourceValue(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        return c(context) && !b(context);
    }
}
