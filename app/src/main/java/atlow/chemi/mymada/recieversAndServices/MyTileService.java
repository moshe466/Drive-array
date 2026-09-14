package atlow.chemi.mymada.recieversAndServices;

import android.annotation.TargetApi;
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
        if (qsTile == null) return;

        if (MetroService.running || qsTile.getState() == Tile.STATE_ACTIVE) {
            // Stop metronome
            getApplicationContext().sendBroadcast(new Intent(this, ActionReceiver.class));
            setCurrentState(Tile.STATE_INACTIVE);
        } else {
            // Start metronome
            Intent intent = new Intent(this, MetroService.class);
            try {
                ContextCompat.startForegroundService(this, intent);
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
