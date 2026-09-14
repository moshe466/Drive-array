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
        if (context == null) return;
        Intent metroIntent = new Intent(context, (Class<?>) MetroService.class);
        String action = intent != null ? intent.getStringExtra("action") : null;

        if (action == null || action.equals("stopM") || action.equals("stop")) {
            try {
                context.stopService(metroIntent);
            } catch (Exception ignored) {
            }
            MetroService.running = false;
            MyTileService.updateTileState(context);
            return;
        }

        if (action.equals("runInBG")) {
            try {
                context.stopService(metroIntent);
            } catch (Exception ignored) {
            }
            context.getSharedPreferences("Settings", 0).edit().putBoolean("Mapp", false).apply();
            MetroService.running = false;
            MyTileService.updateTileState(context);
            return;
        }

        if (action.equals("widget")) {
            if (MetroService.running) {
                try {
                    context.stopService(metroIntent);
                } catch (Exception ignored) {
                }
                MetroService.running = false;
                MyTileService.updateTileState(context);
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationManager nm = (NotificationManager) context.getSystemService(NotificationManager.class);
                    if (nm != null && nm.getNotificationChannel("runInBg") == null) {
                        NotificationChannelGroup group = new NotificationChannelGroup("grpOthers", "התראות שונות");
                        NotificationChannel channel = new NotificationChannel("runInBg", "פעילות ברקע", NotificationManager.IMPORTANCE_LOW);
                        channel.enableVibration(false);
                        channel.enableLights(false);
                        channel.setShowBadge(false);
                        channel.setDescription("חיוני כדי לאפשר זיהוי מקרים");
                        channel.setGroup("grpOthers");
                        nm.createNotificationChannelGroup(group);
                        nm.createNotificationChannel(channel);
                    }
                }
                try {
                    ContextCompat.startForegroundService(context, metroIntent);
                    MetroService.running = true;
                    MyTileService.updateTileState(context);
                } catch (Exception e) {
                    Crashlytics.log("failed starting metronome widget");
                    Crashlytics.logException(e);
                }
            }
        }
    }
}
