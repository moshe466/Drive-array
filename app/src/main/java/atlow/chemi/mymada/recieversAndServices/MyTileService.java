package atlow.chemi.mymada.recieversAndServices;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import androidx.core.content.ContextCompat;
import atlow.chemi.mymada.R;
import com.crashlytics.android.Crashlytics;

@TargetApi(24)
/* loaded from: classes.dex */
public class MyTileService extends TileService {

    public static void updateTileState(Context context) {
        if (Build.VERSION.SDK_INT >= 24 && context != null) {
            try {
                TileService.requestListeningState(context, new ComponentName(context, MyTileService.class));
            } catch (Exception ignored) {
            }
        }
    }

    private void setCurrentState(int state) {
        Tile qsTile = getQsTile();
        if (qsTile == null) return;
        try {
            qsTile.setState(state);
            qsTile.setLabel(getString(R.string.button_d));
            qsTile.setIcon(Icon.createWithResource(this, R.drawable.ic_tile_heart_metronome));
            qsTile.updateTile();
        } catch (Exception e) {
            Crashlytics.log("Error updating tile: " + e.getMessage());
            Crashlytics.logException(e);
        }
    }

    @Override
    public void onClick() {
        super.onClick();
        Tile qsTile = getQsTile();
        boolean isCurrentlyRunning = MetroService.running || (qsTile != null && qsTile.getState() == Tile.STATE_ACTIVE);

        if (isCurrentlyRunning) {
            // Stop metronome directly and via ActionReceiver
            try {
                stopService(new Intent(this, MetroService.class));
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            try {
                Intent stopIntent = new Intent(this, ActionReceiver.class);
                stopIntent.putExtra("action", "stopM");
                sendBroadcast(stopIntent);
            } catch (Exception ignored) {
            }
            MetroService.running = false;
            setCurrentState(Tile.STATE_INACTIVE);
        } else {
            // Start metronome
            Intent intent = new Intent(this, MetroService.class);
            try {
                ContextCompat.startForegroundService(this, intent);
                MetroService.running = true;
                setCurrentState(Tile.STATE_ACTIVE);
            } catch (Exception e) {
                Crashlytics.log("failed starting metronome tile");
                Crashlytics.logException(e);
            }
        }
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        setCurrentState(MetroService.running ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        setCurrentState(MetroService.running ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
    }
}
