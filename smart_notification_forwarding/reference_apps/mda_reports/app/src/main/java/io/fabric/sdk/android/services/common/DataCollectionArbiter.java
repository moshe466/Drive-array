package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class DataCollectionArbiter {
    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    private static final String FIREBASE_CRASHLYTICS_PREFS = "com.google.firebase.crashlytics.prefs";
    private static DataCollectionArbiter instance;
    private static Object instanceLock = new Object();
    private volatile boolean crashlyticsDataCollectionEnabled;
    private volatile boolean crashlyticsDataCollectionExplicitlySet;
    private final FirebaseApp firebaseApp;
    private boolean isUnity;
    private final SharedPreferences sharedPreferences;

    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private DataCollectionArbiter(android.content.Context r7) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.isUnity = r0
            if (r7 == 0) goto L6a
            java.lang.String r1 = "com.google.firebase.crashlytics.prefs"
            android.content.SharedPreferences r1 = r7.getSharedPreferences(r1, r0)
            r6.sharedPreferences = r1
            io.fabric.sdk.android.services.common.FirebaseApp r1 = io.fabric.sdk.android.services.common.FirebaseAppImpl.getInstance(r7)
            r6.firebaseApp = r1
            android.content.SharedPreferences r1 = r6.sharedPreferences
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.contains(r2)
            r3 = 1
            if (r1 == 0) goto L29
            android.content.SharedPreferences r1 = r6.sharedPreferences
            boolean r1 = r1.getBoolean(r2, r3)
        L27:
            r2 = 1
            goto L5c
        L29:
            android.content.pm.PackageManager r1 = r7.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            if (r1 == 0) goto L5a
            java.lang.String r4 = r7.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r4, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            if (r1 == 0) goto L5a
            android.os.Bundle r4 = r1.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            if (r4 == 0) goto L5a
            android.os.Bundle r4 = r1.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            boolean r4 = r4.containsKey(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            if (r4 == 0) goto L5a
            android.os.Bundle r1 = r1.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            boolean r1 = r1.getBoolean(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4e
            goto L27
        L4e:
            r1 = move-exception
            io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.String r4 = "Fabric"
            java.lang.String r5 = "Unable to get PackageManager. Falling through"
            r2.d(r4, r5, r1)
        L5a:
            r1 = 1
            r2 = 0
        L5c:
            r6.crashlyticsDataCollectionEnabled = r1
            r6.crashlyticsDataCollectionExplicitlySet = r2
            java.lang.String r7 = io.fabric.sdk.android.services.common.CommonUtils.resolveUnityEditorVersion(r7)
            if (r7 == 0) goto L67
            r0 = 1
        L67:
            r6.isUnity = r0
            return
        L6a:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r7.<init>(r0)
            goto L73
        L72:
            throw r7
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.DataCollectionArbiter.<init>(android.content.Context):void");
    }

    public static DataCollectionArbiter getInstance(Context context) {
        DataCollectionArbiter dataCollectionArbiter;
        synchronized (instanceLock) {
            if (instance == null) {
                instance = new DataCollectionArbiter(context);
            }
            dataCollectionArbiter = instance;
        }
        return dataCollectionArbiter;
    }

    public static void resetForTesting(Context context) {
        synchronized (instanceLock) {
            instance = new DataCollectionArbiter(context);
        }
    }

    public boolean isDataCollectionEnabled() {
        if (this.isUnity && this.crashlyticsDataCollectionExplicitlySet) {
            return this.crashlyticsDataCollectionEnabled;
        }
        FirebaseApp firebaseApp = this.firebaseApp;
        if (firebaseApp != null) {
            return firebaseApp.isDataCollectionDefaultEnabled();
        }
        return true;
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void setCrashlyticsDataCollectionEnabled(boolean z) {
        this.crashlyticsDataCollectionEnabled = z;
        this.crashlyticsDataCollectionExplicitlySet = true;
        this.sharedPreferences.edit().putBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, z).commit();
    }

    public boolean shouldAutoInitialize() {
        return this.crashlyticsDataCollectionEnabled;
    }
}
