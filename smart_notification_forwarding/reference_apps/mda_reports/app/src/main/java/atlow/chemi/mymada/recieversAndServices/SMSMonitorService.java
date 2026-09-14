package atlow.chemi.mymada.recieversAndServices;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import atlow.chemi.mymada.HomePage;
import atlow.chemi.mymada.R;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class SMSMonitorService extends Service {
    public static Boolean testB = false;
    protected String a = "grpOthers";
    protected String b = "runInBg";
    public Context context;
    public NotificationManager manager;

    private void setNotifChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(this.a, "התראות שונות");
            NotificationChannel notificationChannel = new NotificationChannel(this.b, "פעילות ברקע", 1);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setImportance(1);
            notificationChannel.setDescription("חיוני כדי לאפשר זיהוי מקרים");
            notificationChannel.setGroup(this.a);
            this.manager = (NotificationManager) getSystemService(NotificationManager.class);
            NotificationManager notificationManager = this.manager;
            if (notificationManager != null) {
                notificationManager.createNotificationChannelGroup(notificationChannelGroup);
                this.manager.createNotificationChannel(notificationChannel);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, (Class<?>) HomePage.class);
        intent.setFlags(268468224);
        PendingIntent activity = PendingIntent.getActivity(this, 1, intent, 0);
        Intent intent2 = new Intent(this, (Class<?>) ActionReceiver.class);
        intent2.putExtra("action", "runInBG");
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 13, intent2, 134217728);
        Crashlytics.log("sending SmsMonitor notif");
        if (Build.VERSION.SDK_INT >= 26) {
            setNotifChannels();
        }
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(this, this.b).setContentTitle(getResources().getString(R.string.BGServiceTtl)).setTicker(getResources().getString(R.string.BGServiceTicker)).setContentText(getResources().getString(R.string.BGServiceTxt)).setContentIntent(activity).setGroup("BG").setPriority(1).addAction(R.drawable.ic_close, getString(R.string.MetroStop), broadcast).setShowWhen(false).setColor(Color.argb(50, 76, 119, 247)).setSound(null).setVibrate(null).setOngoing(true);
        try {
            ongoing.setSmallIcon(R.drawable.ic_noti);
            Crashlytics.log("Loaded small icon");
        } catch (Exception e) {
            Crashlytics.log("Error SmsMonitor Notification!");
            Crashlytics.logException(e);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            ongoing.setPriority(1);
        }
        startForeground(78, ongoing.build());
        Crashlytics.log("started foreground");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
