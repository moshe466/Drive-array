package F0;

import android.app.NotificationChannel;
import android.app.NotificationManager;

/* loaded from: classes.dex */
public abstract /* synthetic */ class m3 {
    public static /* synthetic */ NotificationChannel c(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* bridge */ /* synthetic */ void v(NotificationManager notificationManager, NotificationChannel notificationChannel) {
        notificationManager.createNotificationChannel(notificationChannel);
    }
}
