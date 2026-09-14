package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;

/* loaded from: classes.dex */
public final class IsolatedProfileChecker {
    private static final String TAG = "IsolatedProfileChecker";

    private IsolatedProfileChecker() {
    }

    public static boolean isInIsolatedProfile(Context context) {
        boolean isManagedProfile;
        if (context != null) {
            try {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    isManagedProfile = userManager.isManagedProfile();
                    if (!isManagedProfile && !isPrivateProfile(userManager)) {
                        if (!userManager.isSystemUser()) {
                            return true;
                        }
                    }
                    return true;
                }
            } catch (Exception e4) {
                Log.e(TAG, "Error checking isolated profile", e4);
                return false;
            }
        }
        return false;
    }

    private static boolean isPrivateProfile(UserManager userManager) {
        if (Build.VERSION.SDK_INT >= 35 && userManager != null) {
            try {
                Object invoke = UserManager.class.getMethod("isPrivateProfile", null).invoke(userManager, null);
                if (invoke instanceof Boolean) {
                    if (((Boolean) invoke).booleanValue()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
