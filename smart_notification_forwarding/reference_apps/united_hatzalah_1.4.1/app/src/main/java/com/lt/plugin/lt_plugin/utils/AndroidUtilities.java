package com.lt.plugin.lt_plugin.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes.dex */
public class AndroidUtilities {
    public static volatile Handler applicationHandler = new Handler(Looper.getMainLooper());

    public static void cancelRunOnUIThread(Runnable runnable) {
        if (applicationHandler == null) {
            return;
        }
        applicationHandler.removeCallbacks(runnable);
    }

    public static NotificationChannel createNotificationChannel(Context context, String str, String str2, String str3) {
        return createNotificationChannel(context, str, str2, str3, "default");
    }

    public static String getIMEIDeviceId(Context context) {
        String imei;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getDeviceId() != null) {
            if (i >= 26) {
                imei = telephonyManager.getImei();
                return imei;
            }
            return telephonyManager.getDeviceId();
        }
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static boolean isInstalledFromAppStore(Context context) {
        try {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            if (!"com.android.vending".equals(installerPackageName)) {
                if (!"com.google.android.feedback".equals(installerPackageName)) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void runOnUIThread(Runnable runnable) {
        runOnUIThread(runnable, 0L);
    }

    public static NotificationChannel createNotificationChannel(Context context, String str, String str2, String str3, String str4) {
        NotificationManager notificationManager;
        int identifier;
        if (Build.VERSION.SDK_INT < 26 || (notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class)) == null) {
            return null;
        }
        NotificationChannel g3 = com.lt.plugin.lt_plugin.services.a.g(str, str3);
        g3.setDescription(str2);
        g3.enableLights(true);
        if (str4 != null && !str4.equals("default") && !str4.isEmpty() && (identifier = context.getResources().getIdentifier(str4, "raw", context.getPackageName())) != 0) {
            g3.setSound(Uri.parse("android.resource://" + context.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + identifier), new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
        }
        notificationManager.createNotificationChannel(g3);
        return g3;
    }

    public static void runOnUIThread(Runnable runnable, long j2) {
        if (applicationHandler == null) {
            applicationHandler = new Handler(Looper.getMainLooper());
        }
        if (j2 == 0) {
            applicationHandler.post(runnable);
        } else {
            applicationHandler.postDelayed(runnable, j2);
        }
    }
}
