package s5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.groboot.mdaemergency.locations.SchedulingLocationsService;
import com.groboot.mdaemergency.locations.geofencing.GeofenceService;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    Context f14092a;

    public void a(Context context) {
        m.m0(false);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d10 = d();
        if (d10 != null) {
            alarmManager.cancel(d10);
        }
        if (l0.j0(GeofenceService.class, context)) {
            context.stopService(new Intent(context, (Class<?>) GeofenceService.class));
        }
        b();
    }

    public void b() {
        SchedulingLocationsService.b(this.f14092a);
    }

    public boolean c(Context context) {
        return l0.j0(GeofenceService.class, context);
    }

    public PendingIntent d() {
        try {
            return PendingIntent.getService(this.f14092a, 0, new Intent(this.f14092a, (Class<?>) GeofenceService.class), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        } catch (Exception unused) {
            return null;
        }
    }

    public void e(Context context, com.groboot.mdaemergency.enums.b bVar) {
        this.f14092a = context;
        bVar.getMinTimeInterval();
        try {
            a(context);
            b();
        } catch (Exception unused) {
        }
    }
}
