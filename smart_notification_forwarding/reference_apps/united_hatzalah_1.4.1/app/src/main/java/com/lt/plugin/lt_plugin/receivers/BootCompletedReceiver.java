package com.lt.plugin.lt_plugin.receivers;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.service.notification.StatusBarNotification;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import com.lt.plugin.lt_plugin.services.a;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;
import w.n;

/* loaded from: classes.dex */
public class BootCompletedReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "AfterBootChannel";
    private static final int NOTIFICATION_ID = 4;

    private void showAfterBootNotification(Context context) {
        String str;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (Exception unused) {
            str = "App";
        }
        notificationManager.createNotificationChannel(a.f(str));
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        launchIntentForPackage.addFlags(335544320);
        PendingIntent activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 201326592);
        String localized = PluginConfig.getLocalized(context, "lt_boot_open_app", "Please open the app to start location tracking");
        int identifier = context.getResources().getIdentifier("ic_launcher", "mipmap", context.getPackageName());
        if (identifier == 0) {
            identifier = R.drawable.ic_dialog_info;
        }
        n nVar = new n(context, CHANNEL_ID);
        nVar.f6666v.icon = identifier;
        nVar.f6651e = n.b(str);
        nVar.f6652f = n.b(localized);
        nVar.f6653g = activity;
        nVar.d(16, true);
        nVar.f6655j = 1;
        notificationManager.notify(4, nVar.a());
    }

    public boolean isLocationServiceRunning(Context context) {
        String channelId;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                if (statusBarNotification.getId() == 2) {
                    channelId = statusBarNotification.getNotification().getChannelId();
                    if ("LocationServiceChannel".equals(channelId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            PluginConfig pluginConfig = PluginConfig.getInstance(context);
            if (!pluginConfig.isBootReceiverEnabled() || !pluginConfig.isLocationServiceEnabled() || context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.webview.trackingMode", "OFF").equals("OFF") || isLocationServiceRunning(context)) {
                return;
            }
            showAfterBootNotification(context);
        }
    }
}
