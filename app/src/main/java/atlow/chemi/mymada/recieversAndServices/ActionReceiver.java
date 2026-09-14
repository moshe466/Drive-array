package atlow.chemi.mymada.recieversAndServices;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.fragments.MetroActivity;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class ActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager;
        Intent intent2 = new Intent(context, (Class<?>) MetroService.class);
        String stringExtra = intent.getStringExtra("action");
        if (stringExtra != null) {
            if (!stringExtra.equals("widget") || MetroService.running) {
                if (stringExtra.equals("runInBG")) {
                    context.stopService(intent2);
                    context.getSharedPreferences("Settings", 0).edit().putBoolean("Mapp", false).apply();
                    return;
                } else if (MetroActivity.bound) {
                    Toast.makeText(context, R.string.MetroBound, 0).show();
                    return;
                } else {
                    context.stopService(intent2);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class)) != null && notificationManager.getNotificationChannel("runInBg") == null) {
                NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup("grpOthers", "התראות שונות");
                NotificationChannel notificationChannel = new NotificationChannel("runInBg", "פעילות ברקע", 1);
                notificationChannel.enableVibration(false);
                notificationChannel.enableLights(false);
                notificationChannel.setShowBadge(false);
                notificationChannel.setImportance(1);
                notificationChannel.setDescription("חיוני כדי לאפשר זיהוי מקרים");
                notificationChannel.setGroup("grpOthers");
                notificationManager.createNotificationChannelGroup(notificationChannelGroup);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            try {
                ContextCompat.startForegroundService(context, intent2);
            } catch (Exception e) {
                Crashlytics.log("failed starting metronome widget");
                Crashlytics.logException(e);
            }
        }
    }
}
