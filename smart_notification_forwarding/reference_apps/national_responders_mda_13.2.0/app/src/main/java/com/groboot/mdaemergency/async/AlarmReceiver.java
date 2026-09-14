package com.groboot.mdaemergency.async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        intent.getAction();
        try {
            if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
                if (s5.d.j() == null) {
                    s5.d.n(context.getApplicationContext());
                }
                s5.d.j().b();
            }
        } catch (Exception e10) {
            e10.toString();
        }
    }
}
