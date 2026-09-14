package s5;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;
import s5.d;

/* loaded from: classes.dex */
public class g {

    /* renamed from: g, reason: collision with root package name */
    static String f14130g = "[Location][UpdateLocation]";

    /* renamed from: a, reason: collision with root package name */
    Context f14131a;

    /* renamed from: b, reason: collision with root package name */
    LocationManager f14132b;

    /* renamed from: c, reason: collision with root package name */
    a f14133c = new a();

    /* renamed from: d, reason: collision with root package name */
    Location f14134d;

    /* renamed from: e, reason: collision with root package name */
    Handler f14135e;

    /* renamed from: f, reason: collision with root package name */
    Runnable f14136f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        d.e f14137a;

        /* renamed from: b, reason: collision with root package name */
        boolean f14138b;

        a() {
        }

        public void a(Location location) {
            if (location == null) {
                return;
            }
            d.e eVar = this.f14137a;
            if (eVar == null) {
                String str = g.f14130g;
            } else {
                g.this.f14134d = location;
                eVar.a(location);
            }
        }

        public void b(boolean z10, d.e eVar) {
            this.f14138b = z10;
            this.f14137a = eVar;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            d.e eVar;
            if (location == null || (eVar = this.f14137a) == null) {
                return;
            }
            if (this.f14138b) {
                eVar.b(location);
                g.this.d();
                return;
            }
            g gVar = g.this;
            Handler handler = gVar.f14135e;
            if (handler != null) {
                handler.removeCallbacks(gVar.f14136f);
            }
            if (g.this.f14134d == null) {
                a(location);
                return;
            }
            long time = location.getTime() - g.this.f14134d.getTime();
            if (g.this.f14134d.distanceTo(location) > 200.0f && location.getAccuracy() < 300.0f) {
                String str = g.f14130g;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("user moved ");
                sb2.append(g.this.f14134d.distanceTo(location));
                sb2.append(" meter, location.getAccuracy:");
                sb2.append(location.getAccuracy());
                a(location);
                return;
            }
            if (time <= TimeUnit.MINUTES.toMillis(5L) || g.this.f14132b == null) {
                return;
            }
            String str2 = g.f14130g;
            g.this.f14132b.removeUpdates(this);
            g gVar2 = g.this;
            gVar2.f14132b = null;
            gVar2.f14134d = location;
            this.f14137a.b(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            String str2 = g.f14130g;
            Toast.makeText(g.this.f14131a, "שינוי הגדרות מיקום, לא תאפשר לקיחת מיקום בצורה טובה", 0);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            String str2 = g.f14130g;
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }
    }

    static {
        new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
    }

    public void c(Context context, boolean z10, d.e eVar) {
        try {
            this.f14131a = context;
            this.f14134d = null;
            if (androidx.core.content.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                if (this.f14132b == null) {
                    this.f14132b = (LocationManager) context.getSystemService("location");
                }
                if (this.f14133c == null) {
                    this.f14133c = new a();
                }
                if (this.f14132b.getAllProviders().contains("gps")) {
                    this.f14132b.requestLocationUpdates("gps", 0L, 0.0f, this.f14133c, Looper.getMainLooper());
                }
                if (this.f14132b.getAllProviders().contains("network") && this.f14132b.isProviderEnabled("network")) {
                    this.f14132b.requestLocationUpdates("network", 0L, 0.0f, this.f14133c, Looper.getMainLooper());
                }
                this.f14133c.b(z10, eVar);
                if (z10 || this.f14134d == null) {
                    return;
                }
                if (this.f14135e == null) {
                    this.f14135e = new Handler();
                }
                this.f14135e.postDelayed(this.f14136f, TimeUnit.SECONDS.toMillis(10L));
                this.f14136f = new Runnable() { // from class: s5.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b();
                    }
                };
                eVar.a(this.f14134d);
            }
        } catch (Exception unused) {
        }
    }

    public void d() {
        LocationManager locationManager = this.f14132b;
        if (locationManager != null) {
            locationManager.removeUpdates(this.f14133c);
        }
        a aVar = this.f14133c;
        if (aVar != null) {
            aVar.f14137a = null;
        }
    }
}
