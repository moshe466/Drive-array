package com.lt.plugin.lt_plugin.services;

import android.R;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import com.lt.plugin.lt_plugin.utils.LogHelper;
import com.lt.plugin.lt_plugin.utils.VibrationHelper;
import w.n;

/* loaded from: classes.dex */
public class BackgroundService extends Service {
    private static final String CHANNEL_ID = "BackgroundServiceChannel";
    private static final int NOTIFICATION_ID = 3;
    private static final String TAG = "BackgroundService";
    private String appName;
    private NotificationManager notificationManager;
    private PluginConfig pluginConfig;
    private VibrationHelper vibrationHelper;

    private Notification buildForegroundNotification() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        PendingIntent activity = PendingIntent.getActivity(this, 3, launchIntentForPackage, 67108864);
        int identifier = getResources().getIdentifier("ic_launcher", "mipmap", getPackageName());
        if (identifier == 0) {
            identifier = R.drawable.ic_menu_view;
        }
        n nVar = new n(this, CHANNEL_ID);
        nVar.f6651e = n.b(this.appName);
        nVar.f6652f = n.b(PluginConfig.getLocalized(this, "lt_online", "Online"));
        nVar.f6666v.icon = identifier;
        nVar.f6653g = activity;
        nVar.p = "service";
        nVar.f6655j = -2;
        nVar.d(2, true);
        return nVar.a();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            com.google.android.gms.common.wrappers.a.s();
            this.notificationManager.createNotificationChannel(a.e(this.appName));
        }
    }

    private void stopSelfSafely() {
        LogHelper.d(TAG, "stopSelfSafely called");
        try {
            stopForeground(true);
        } catch (Exception e4) {
            e4.getMessage();
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        LogHelper.d(TAG, "onCreate");
        PluginConfig pluginConfig = PluginConfig.getInstance(getApplicationContext());
        this.pluginConfig = pluginConfig;
        if (!pluginConfig.isBackgroundServiceEnabled()) {
            stopSelf();
            return;
        }
        try {
            PackageManager packageManager = getPackageManager();
            this.appName = packageManager.getApplicationLabel(packageManager.getApplicationInfo(getPackageName(), 0)).toString();
        } catch (Exception unused) {
            this.appName = "Background Service";
        }
        this.notificationManager = (NotificationManager) getSystemService("notification");
        this.vibrationHelper = VibrationHelper.Instance(getApplicationContext());
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogHelper.d(TAG, "onDestroy");
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        int i4;
        LogHelper.d(TAG, "onStartCommand");
        if (!this.pluginConfig.isBackgroundServiceEnabled()) {
            stopSelf();
            return 2;
        }
        createNotificationChannel();
        Notification buildForegroundNotification = buildForegroundNotification();
        try {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 34) {
                i4 = 2048;
            } else {
                i4 = 1;
            }
            if (i5 >= 31) {
                try {
                    startForeground(3, buildForegroundNotification, i4);
                } catch (ForegroundServiceStartNotAllowedException unused) {
                    stopSelfSafely();
                    return 2;
                }
            } else {
                startForeground(3, buildForegroundNotification, i4);
            }
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager != null && audioManager.getRingerMode() != 0) {
                this.vibrationHelper.vibrateNow("", 0);
            }
            stopSelf();
            return 2;
        } catch (Exception e4) {
            Log.e(TAG, "Failed to start foreground service", e4);
            stopSelfSafely();
            return 2;
        }
    }
}
