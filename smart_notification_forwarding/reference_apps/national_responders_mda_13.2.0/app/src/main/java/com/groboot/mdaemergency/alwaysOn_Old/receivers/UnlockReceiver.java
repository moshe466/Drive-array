package com.groboot.mdaemergency.alwaysOn_Old.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.groboot.mdaemergency.alwaysOn_Old.services.AlwaysOnOldMainService;
import h5.a;

/* loaded from: classes.dex */
public class UnlockReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.USER_PRESENT") && a.f10461c) {
            return;
        }
        AlwaysOnOldMainService.A = true;
        AlwaysOnOldMainService.x(context);
    }
}
