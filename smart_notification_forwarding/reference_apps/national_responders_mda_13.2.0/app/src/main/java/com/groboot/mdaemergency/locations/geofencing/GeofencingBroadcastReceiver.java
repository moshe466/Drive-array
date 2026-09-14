package com.groboot.mdaemergency.locations.geofencing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.groboot.mdaemergency.enums.b;
import java.util.ArrayList;
import java.util.Arrays;
import m0.a;
import s2.l;
import s5.d;
import w6.m;

/* loaded from: classes.dex */
public class GeofencingBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    Context f7713a;

    protected void a(String[] strArr) {
        for (String str : strArr) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onEnter ");
            sb2.append(str);
        }
        d("GeofencingReceiver_Enter", strArr);
    }

    protected void b(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error: ");
        sb2.append(i10);
    }

    protected void c(String[] strArr) {
        for (String str : strArr) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onExit ");
            sb2.append(str);
        }
        d("GeofencingReceiver_Exit", strArr);
    }

    public void d(String str, String[] strArr) {
        if (m.O() == b.NOT_AVAILABLE) {
            return;
        }
        if (m.O() != null && m.O().getTrackingType() == b.a.SLEEPY) {
            if (d.j() == null) {
                d.k(this.f7713a).o();
            } else {
                Intent intent = new Intent("com.groboot.mdaemergency.CHANGE_STATUS");
                b bVar = b.AVAILABLE;
                intent.putExtra("new_status", bVar);
                if (!a.b(this.f7713a.getApplicationContext()).d(intent)) {
                    d.j().v(null, bVar, false, null);
                }
            }
        }
        Intent intent2 = new Intent(str);
        intent2.putStringArrayListExtra("GeofencingReceiver_Extra_GeofenceIds", new ArrayList<>(Arrays.asList(strArr)));
        intent2.putExtra("GeofencingReceiver_Extra_Provider", com.groboot.mdaemergency.locations.a.geofence.ordinal());
        this.f7713a.sendBroadcast(intent2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f7713a = context;
        l a10 = l.a(intent);
        if (a10 == null || a10.e() || m.k() == null) {
            return;
        }
        if (a10.e()) {
            b(a10.b());
            return;
        }
        int c10 = a10.c();
        if (c10 == 1 || c10 == 4 || c10 == 2) {
            String[] strArr = new String[a10.d().size()];
            for (int i10 = 0; i10 < a10.d().size(); i10++) {
                strArr[i10] = a10.d().get(i10).f();
            }
            if (c10 == 1 || c10 == 4) {
                a(strArr);
            } else if (c10 == 2) {
                c(strArr);
            }
        }
    }
}
