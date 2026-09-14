package atlow.chemi.mymada.recieversAndServices;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import androidx.core.content.ContextCompat;
import com.crashlytics.android.Crashlytics;

@TargetApi(24)
/* loaded from: classes.dex */
public class MyTileService extends TileService {
    private void setCurrentState(int i) {
        Tile qsTile = getQsTile();
        try {
            qsTile.setState(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            qsTile.setIcon(i != 0 ? i != 1 ? i != 2 ? qsTile.getIcon().setTint(-7829368) : qsTile.getIcon().setTint(-1) : qsTile.getIcon().setTint(-7829368) : qsTile.getIcon().setTint(-7829368));
        } catch (NullPointerException e2) {
            Crashlytics.log("Cant get tile icon!");
            Crashlytics.logException(e2);
        }
        if (qsTile != null) {
            qsTile.updateTile();
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        super.onClick();
        int state = getQsTile().getState();
        if (state != 1) {
            if (state != 2) {
                return;
            }
            getApplicationContext().sendBroadcast(new Intent(this, (Class<?>) ActionReceiver.class));
            setCurrentState(1);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) MetroService.class);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (Build.VERSION.SDK_INT >= 26 && notificationManager != null && notificationManager.getNotificationChannel("runInBg") == null) {
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
            ContextCompat.startForegroundService(this, intent);
        } catch (Exception e) {
            Crashlytics.log("failed starting metronome tile");
            Crashlytics.logException(e);
        }
        setCurrentState(2);
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
    }

    @Override // android.service.quicksettings.TileService
    public void onStopListening() {
        super.onStopListening();
    }

    @Override // android.service.quicksettings.TileService
    public void onTileAdded() {
        super.onTileAdded();
        setCurrentState(1);
    }

    @Override // android.service.quicksettings.TileService
    public void onTileRemoved() {
        try {
            setCurrentState(1);
        } catch (NullPointerException e) {
            Crashlytics.log("removing tile error");
            Crashlytics.logException(e);
        }
        super.onTileRemoved();
    }
}
