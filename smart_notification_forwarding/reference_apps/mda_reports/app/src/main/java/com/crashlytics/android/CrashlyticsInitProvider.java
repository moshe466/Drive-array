package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.FirebaseInfo;

/* loaded from: classes.dex */
public class CrashlyticsInitProvider extends ContentProvider {
    private static final String NDK_MANIFEST_FLAG = "firebase_crashlytics_ndk_enabled";
    private static final String TAG = "CrashlyticsInitProvider";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface EnabledCheckStrategy {
        boolean isCrashlyticsEnabled(Context context);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.fabric.sdk.android.Kit[] createCrashlyticsKits(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Fabric"
            r1 = 1
            r2 = 0
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            java.lang.String r7 = r7.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r7 = r3.getApplicationInfo(r7, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            android.os.Bundle r7 = r7.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            if (r7 == 0) goto L2a
            java.lang.String r3 = "firebase_crashlytics_ndk_enabled"
            boolean r7 = r7.getBoolean(r3, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            if (r7 == 0) goto L2a
            r7 = 1
            goto L2b
        L20:
            r7 = move-exception
            io.fabric.sdk.android.Logger r3 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.String r4 = "Unable to get PackageManager while determining if Crashlytics NDK should be initialized"
            r3.d(r0, r4, r7)
        L2a:
            r7 = 0
        L2b:
            com.crashlytics.android.Crashlytics r3 = new com.crashlytics.android.Crashlytics
            r3.<init>()
            if (r7 == 0) goto L52
            io.fabric.sdk.android.Logger r7 = io.fabric.sdk.android.Fabric.getLogger()     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = "Crashlytics is initializing NDK crash reporter."
            r7.i(r0, r4)     // Catch: java.lang.Throwable -> L48
            r7 = 2
            io.fabric.sdk.android.Kit[] r7 = new io.fabric.sdk.android.Kit[r7]     // Catch: java.lang.Throwable -> L48
            r7[r2] = r3     // Catch: java.lang.Throwable -> L48
            com.crashlytics.android.ndk.CrashlyticsNdk r4 = new com.crashlytics.android.ndk.CrashlyticsNdk     // Catch: java.lang.Throwable -> L48
            r4.<init>()     // Catch: java.lang.Throwable -> L48
            r7[r1] = r4     // Catch: java.lang.Throwable -> L48
            return r7
        L48:
            r7 = move-exception
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.String r5 = "Crashlytics failed to initialize NDK crash reporting. Attempting to intialize SDK..."
            r4.e(r0, r5, r7)
        L52:
            io.fabric.sdk.android.Kit[] r7 = new io.fabric.sdk.android.Kit[r1]
            r7[r2] = r3
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.CrashlyticsInitProvider.createCrashlyticsKits(android.content.Context):io.fabric.sdk.android.Kit[]");
    }

    boolean a(Context context, FirebaseInfo firebaseInfo, EnabledCheckStrategy enabledCheckStrategy) {
        return firebaseInfo.isFirebaseCrashlyticsEnabled(context) ? enabledCheckStrategy.isCrashlyticsEnabled(context) : firebaseInfo.isAutoInitializeFlagEnabled(context);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (!a(context, new FirebaseInfo(), new ManifestEnabledCheckStrategy())) {
            Fabric.getLogger().i(TAG, "CrashlyticsInitProvider skipping initialization");
            return true;
        }
        try {
            Fabric.with(context, createCrashlyticsKits(context.getApplicationContext()));
            Fabric.getLogger().i(TAG, "CrashlyticsInitProvider initialization successful");
            return true;
        } catch (IllegalStateException unused) {
            Fabric.getLogger().i(TAG, "CrashlyticsInitProvider initialization unsuccessful");
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
