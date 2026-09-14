package com.groboot.mdaemergency.async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.ptt.PTTService;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import w6.d0;

/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            s5.d.n(context.getApplicationContext());
            s5.d.j().o();
            PTTService.j(context);
            if (MdaEmergencyApplication.f7534k) {
                d0.a(4000L);
                Intent intent2 = new Intent(context, (Class<?>) SplashActivity.class);
                intent2.setFlags(268435456);
                intent2.putExtra(p.f7896v, "");
                context.startActivity(intent2);
            }
        }
    }
}
