package atlow.chemi.mymada.recieversAndServices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.content.ContextCompat;

/* loaded from: classes.dex */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            if (action.equalsIgnoreCase("android.intent.action.BOOT_COMPLETED") || action.equalsIgnoreCase("android.intent.action.PACKAGE_ADDED") || action.equalsIgnoreCase("android.intent.action.PACKAGE_RESTARTED") || action.equalsIgnoreCase("android.intent.action.MY_PACKAGE_REPLACED")) {
                Log.d("started BCR", intent.getAction());
                if (context.getSharedPreferences("Settings", 0).getBoolean("Mapp", false)) {
                    ContextCompat.startForegroundService(context, new Intent(context, (Class<?>) SMSMonitorService.class));
                }
            }
        }
    }
}
