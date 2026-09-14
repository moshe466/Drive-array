package com.groboot.mdaemergency.locations;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.locations.SchedulingLocationsService;
import java.text.SimpleDateFormat;
import java.util.Date;
import s5.d;
import s5.g;
import w6.m;
import y8.k;

/* loaded from: classes.dex */
public final class SchedulingLocationsService extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static final a f7695b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final String f7696c = "[Location][SchedulingLocations]";

    /* renamed from: a, reason: collision with root package name */
    private final g f7697a = new g();

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        private final PendingIntent b(Context context) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) SchedulingLocationsService.class), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
            k.d(broadcast, "getBroadcast(\n          …piFlags\n                )");
            return broadcast;
        }

        public final void a(Context context) {
            k.e(context, "context");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent b10 = b(context);
            k.b(alarmManager);
            alarmManager.cancel(b10);
            b10.cancel();
            c();
        }

        public final String c() {
            return SchedulingLocationsService.f7696c;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements d.e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b.a aVar) {
            boolean z10 = aVar.f7614b;
            SchedulingLocationsService.f7695b.c();
        }

        @Override // s5.d.e
        public void a(Location location) {
        }

        @Override // s5.d.e
        public void b(Location location) {
            com.groboot.mdaemergency.enums.b O;
            if (location == null || (O = m.O()) == null) {
                return;
            }
            com.groboot.mdaemergency.async.d.v().a0(location, O, com.groboot.mdaemergency.locations.a.SchedulingLocations.getValue(), new b.InterfaceC0098b() { // from class: s5.e
                @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                public final void a(b.a aVar) {
                    SchedulingLocationsService.b.d(aVar);
                }
            });
        }
    }

    public static final void b(Context context) {
        f7695b.a(context);
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f7697a.c(context, true, new b());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", k.j(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()), " @1"));
        if (context == null) {
            return;
        }
        c(context);
    }
}
