package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Calendar;

/* loaded from: classes.dex */
class m {

    /* renamed from: d, reason: collision with root package name */
    private static m f709d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f710a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f711b;

    /* renamed from: c, reason: collision with root package name */
    private final a f712c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f713a;

        /* renamed from: b, reason: collision with root package name */
        long f714b;

        a() {
        }
    }

    m(Context context, LocationManager locationManager) {
        this.f710a = context;
        this.f711b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Context context) {
        if (f709d == null) {
            Context applicationContext = context.getApplicationContext();
            f709d = new m(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f709d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location c10 = androidx.core.content.d.b(this.f710a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c11 = androidx.core.content.d.b(this.f710a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c11 == null || c10 == null) ? c11 != null ? c11 : c10 : c11.getTime() > c10.getTime() ? c11 : c10;
    }

    private Location c(String str) {
        try {
            if (this.f711b.isProviderEnabled(str)) {
                return this.f711b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean e() {
        return this.f712c.f714b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j10;
        a aVar = this.f712c;
        long currentTimeMillis = System.currentTimeMillis();
        l b10 = l.b();
        b10.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b10.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = b10.f708c == 1;
        long j11 = b10.f707b;
        long j12 = b10.f706a;
        b10.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j13 = b10.f707b;
        if (j11 == -1 || j12 == -1) {
            j10 = 43200000 + currentTimeMillis;
        } else {
            j10 = (currentTimeMillis > j12 ? j13 + 0 : currentTimeMillis > j11 ? j12 + 0 : j11 + 0) + 60000;
        }
        aVar.f713a = z10;
        aVar.f714b = j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f712c;
        if (e()) {
            return aVar.f713a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f713a;
        }
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }
}
