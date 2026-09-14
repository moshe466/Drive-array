package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.BuildConfig;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SharedPreferencesUtils {
    private final FirebaseApp firebaseApp;

    @Inject
    public SharedPreferencesUtils(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public boolean getAndSetBooleanPreference(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z);
        }
        setBooleanPreference(str, z);
        return z;
    }

    public boolean getBooleanManifestValue(String str, boolean z) {
        ApplicationInfo applicationInfo;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z;
    }

    public boolean getBooleanPreference(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z) : z;
    }

    public boolean isManifestSet(String str) {
        ApplicationInfo applicationInfo;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return false;
            }
            return applicationInfo.metaData.containsKey(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean isPreferenceSet(String str) {
        return ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains(str);
    }

    public void setBooleanPreference(String str, boolean z) {
        SharedPreferences.Editor edit = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
