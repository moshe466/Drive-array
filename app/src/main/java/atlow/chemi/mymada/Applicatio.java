package atlow.chemi.mymada;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import atlow.chemi.mymada.helpers.FontsOverride;
import atlow.chemi.mymada.helpers.LocalHelper;
import atlow.chemi.mymada.recieversAndServices.BootCompleteReceiver;
import atlow.chemi.mymada.recieversAndServices.GrobootRec;
import atlow.chemi.mymada.recieversAndServices.SMSMonitorService;
import com.crashlytics.android.Crashlytics;
import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory;

/* loaded from: classes.dex */
public class Applicatio extends MultiDexApplication {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private void makeRec() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        GrobootRec grobootRec = new GrobootRec();
        IntentFilter intentFilter = new IntentFilter("MADA_APP");
        intentFilter.addAction("atlow.chemi.MyMada.MADA_APP");
        localBroadcastManager.registerReceiver(grobootRec, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.BOOT_COMPLETED");
        intentFilter2.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
        localBroadcastManager.registerReceiver(new BootCompleteReceiver(), intentFilter2);
    }

    public static void toggleNotificationListenerService(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, (Class<?>) NotificationService.class);
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static void tryConnectService(Context context) {
        toggleNotificationListenerService(context);
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationListenerService.requestRebind(new ComponentName(context, (Class<?>) NotificationService.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
        MultiDex.install(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        if (MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
            return;
        }
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/opensanshebrew.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/opensanshebrew.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/opensanshebrew.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/opensanshebrew.ttf");
        if (getSharedPreferences("Settings", 0).getBoolean("Mapp", false)) {
            ContextCompat.startForegroundService(getApplicationContext(), new Intent(getApplicationContext(), (Class<?>) SMSMonitorService.class));
            try {
                tryConnectService(getApplicationContext());
            } catch (NoClassDefFoundError e) {
                Crashlytics.log("Connecting service failed");
                Crashlytics.logException(e);
            }
        }
        makeRec();
    }
}
