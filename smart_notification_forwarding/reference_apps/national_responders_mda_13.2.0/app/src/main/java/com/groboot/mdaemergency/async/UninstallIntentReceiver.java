package com.groboot.mdaemergency.async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class UninstallIntentReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.PACKAGES");
        if (stringArrayExtra != null) {
            for (String str : stringArrayExtra) {
                if (str != null) {
                    str.equals("com.groboot.mdaemergency");
                }
            }
        }
    }
}
