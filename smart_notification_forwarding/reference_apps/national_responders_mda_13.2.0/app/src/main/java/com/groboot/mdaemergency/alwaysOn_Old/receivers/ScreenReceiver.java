package com.groboot.mdaemergency.alwaysOn_Old.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.groboot.mdaemergency.alwaysOn_Old.services.AlwaysOnOldMainService;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {
    public static void a(Context context, boolean z10) {
        if (z10) {
            try {
                AlwaysOnOldMainService.x(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(268435466, "ScreenOnWakeLock");
        newWakeLock.acquire();
        newWakeLock.release();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
