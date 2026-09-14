package r5;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.groboot.mdaemergency.geolock.GeolocationService;
import w6.m;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f13780a;

    private a() {
    }

    public static a a() {
        if (f13780a == null) {
            f13780a = new a();
        }
        return f13780a;
    }

    private void e(Context context) {
        Intent intent = new Intent(context, (Class<?>) GeolocationService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public boolean b() {
        return m.f();
    }

    public boolean c() {
        return d(m.O());
    }

    public boolean d(com.groboot.mdaemergency.enums.b bVar) {
        return bVar == com.groboot.mdaemergency.enums.b.AVAILABLE || bVar == com.groboot.mdaemergency.enums.b.NATAN_ONLY || bVar == com.groboot.mdaemergency.enums.b.ARAN_ONLY;
    }

    public void f(Context context) {
        if (c()) {
            e(context);
        }
    }

    public void g(Context context) {
        context.stopService(new Intent(context, (Class<?>) GeolocationService.class));
    }

    public void h(Context context, com.groboot.mdaemergency.enums.b bVar) {
        if (b()) {
            if (d(bVar)) {
                e(context);
            } else {
                g(context);
            }
        }
    }
}
