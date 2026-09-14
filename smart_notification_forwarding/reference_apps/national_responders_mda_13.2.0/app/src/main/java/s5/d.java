package s5;

import a6.h;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.a;
import com.groboot.mdaemergency.app_authorization.ConfigurationAuthActivity;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.enums.b;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.poc.Device;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    public static int f14097g = 1234;

    /* renamed from: h, reason: collision with root package name */
    private static d f14098h;

    /* renamed from: i, reason: collision with root package name */
    public static com.groboot.mdaemergency.enums.b f14099i;

    /* renamed from: j, reason: collision with root package name */
    static boolean f14100j;

    /* renamed from: k, reason: collision with root package name */
    static LocationManager f14101k;

    /* renamed from: a, reason: collision with root package name */
    Context f14102a;

    /* renamed from: b, reason: collision with root package name */
    s5.a f14103b = new s5.a();

    /* renamed from: c, reason: collision with root package name */
    boolean f14104c = true;

    /* renamed from: d, reason: collision with root package name */
    BroadcastReceiver f14105d;

    /* renamed from: e, reason: collision with root package name */
    f f14106e;

    /* renamed from: f, reason: collision with root package name */
    Location f14107f;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == "com.groboot.mdaemergency.gps_service.gps_enabled") {
                d.this.f14104c = intent.getBooleanExtra(s5.b.f14093h, false);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("gpsEnabled: ");
                sb2.append(d.this.f14104c);
                d dVar = d.this;
                boolean z10 = dVar.f14104c;
                s5.a aVar = dVar.f14103b;
                if (z10) {
                    aVar.e(context, d.f14099i);
                } else {
                    aVar.a(context);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f14109a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f14110b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppUser.Location f14111c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.enums.b f14112d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f14113e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f14114f;

        b(g gVar, g gVar2, AppUser.Location location, com.groboot.mdaemergency.enums.b bVar, Activity activity, boolean z10) {
            this.f14109a = gVar;
            this.f14110b = gVar2;
            this.f14111c = location;
            this.f14112d = bVar;
            this.f14113e = activity;
            this.f14114f = z10;
        }

        @Override // s5.d.e
        public void a(Location location) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @2");
        }

        @Override // s5.d.e
        public void b(Location location) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @3");
            if (location == null) {
                if (this.f14109a != null) {
                    this.f14110b.c(R.string.get_location_not_success_try_again);
                }
            } else {
                if (this.f14111c.toAndroidLocation().distanceTo(location) <= this.f14112d.getDistance()) {
                    d.this.r(this.f14113e, this.f14111c.toAndroidLocation(), this.f14112d, this.f14114f, this.f14110b);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getCurrentLocationToVerifySleepyStatus distance bigger than ");
                sb2.append(this.f14112d.getDistance());
                this.f14110b.b();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f14116a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f14117b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f14118c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f14119d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.enums.b f14120e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f14121f;

        c(g gVar, g gVar2, Activity activity, Context context, com.groboot.mdaemergency.enums.b bVar, boolean z10) {
            this.f14116a = gVar;
            this.f14117b = gVar2;
            this.f14118c = activity;
            this.f14119d = context;
            this.f14120e = bVar;
            this.f14121f = z10;
        }

        @Override // s5.d.e
        public void a(Location location) {
            if (location != null) {
                r5.b.b().g(this.f14119d);
                d.this.r(this.f14118c, location, this.f14120e, this.f14121f, this.f14117b);
            } else if (this.f14116a != null) {
                this.f14117b.a(this.f14118c.getString(R.string.change_status_possible_when_location_data_work));
            }
        }

        @Override // s5.d.e
        public void b(Location location) {
            if (location != null) {
                r5.b.b().g(this.f14119d);
                d.this.r(this.f14118c, location, this.f14120e, this.f14121f, this.f14117b);
            } else if (this.f14116a != null) {
                this.f14117b.a(this.f14118c.getString(R.string.change_status_possible_when_location_data_work));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s5.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0288d implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f14123a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.enums.b f14124b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f14125c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f14126d;

        C0288d(g gVar, com.groboot.mdaemergency.enums.b bVar, boolean z10, Activity activity) {
            this.f14123a = gVar;
            this.f14124b = bVar;
            this.f14125c = z10;
            this.f14126d = activity;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (!aVar.f7614b) {
                if (aVar.f7618f == 69) {
                    Intent intent = new Intent(d.this.f14102a, (Class<?>) ConfigurationAuthActivity.class);
                    intent.setFlags(268435456);
                    intent.putExtra("failedConfig", "mockLocation");
                    d.this.f14102a.startActivity(intent);
                }
                Activity activity = this.f14126d;
                if (activity != null) {
                    h.o(activity, activity.getString(R.string.status_not_change_try_again));
                }
                g gVar = this.f14123a;
                if (gVar != null) {
                    gVar.a("");
                    return;
                }
                return;
            }
            r5.b.b().f(d.this.f14102a);
            d.this.u();
            g gVar2 = this.f14123a;
            if (gVar2 != null) {
                gVar2.e();
            }
            if (this.f14124b.getTrackingType() == b.a.NONE && !Device.isTC25()) {
                d.this.D();
                v5.a.b(d.this.f14102a);
            } else {
                if (this.f14124b.getTrackingType() == b.a.FULL) {
                    if (this.f14125c) {
                        d.this.t();
                    }
                    g gVar3 = this.f14123a;
                    if (gVar3 != null) {
                        gVar3.e();
                        return;
                    }
                    return;
                }
                if (this.f14124b.getTrackingType() == b.a.SLEEPY) {
                    AppUser.Location location = m.k().getLocation(this.f14124b);
                    if (location == null || location.getAddress() == null || location.getAddress().isEmpty()) {
                        g gVar4 = this.f14123a;
                        if (gVar4 != null) {
                            gVar4.d("");
                            return;
                        }
                        return;
                    }
                    d.this.B();
                }
            }
            g gVar5 = this.f14123a;
            if (gVar5 != null) {
                gVar5.e();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(Location location);

        void b(Location location);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(String str);

        void b();

        void c(int i10);

        void d(String str);

        void e();
    }

    public d(Context context) {
        this.f14102a = context;
        f14101k = (LocationManager) context.getSystemService("location");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.groboot.mdaemergency.gps_service.gps_enabled");
        a aVar = new a();
        this.f14105d = aVar;
        context.registerReceiver(aVar, intentFilter);
        com.groboot.mdaemergency.enums.b bVar = f14099i;
        f14099i = bVar == null ? m.O() : bVar;
        o();
    }

    private void C() {
        this.f14102a.stopService(new Intent(this.f14102a, (Class<?>) s5.b.class));
    }

    public static Location f(Context context) {
        f14100j = false;
        if (androidx.core.content.a.a(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && androidx.core.content.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return null;
        }
        if (f14101k == null) {
            f14101k = (LocationManager) context.getSystemService("location");
        }
        if (f14099i == null) {
            f14099i = m.O();
        }
        Location lastKnownLocation = f14101k.getLastKnownLocation("gps");
        if (lastKnownLocation != null) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @4");
            long time = new Date().getTime() - lastKnownLocation.getTime();
            b.a trackingType = f14099i.getTrackingType();
            b.a aVar = b.a.SLEEPY;
            if ((trackingType != aVar && time < f14099i.getTimeIntervalSendToServer()) || (f14099i.getTrackingType() == aVar && time < TimeUnit.MINUTES.toMillis(2L))) {
                return lastKnownLocation;
            }
        }
        Location lastKnownLocation2 = f14101k.getLastKnownLocation("network");
        if (lastKnownLocation2 != null) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @5");
            return lastKnownLocation == null ? lastKnownLocation2 : (lastKnownLocation2.getTime() <= lastKnownLocation.getTime() + TimeUnit.MINUTES.toMillis(2L) || lastKnownLocation2.getAccuracy() >= 1500.0f) ? lastKnownLocation : lastKnownLocation2;
        }
        if (lastKnownLocation != null) {
            return lastKnownLocation;
        }
        if (lastKnownLocation == null && lastKnownLocation2 == null) {
            f14100j = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" failed to send location ");
            sb2.append(lastKnownLocation);
        }
        return null;
    }

    public static void h(Context context, AppUser.Location location, e eVar) {
        Location f10 = f(context);
        if (f10 == null || f10.getAccuracy() >= 1000.0f || new Date().getTime() - f10.getTime() > TimeUnit.MINUTES.toMillis(2L) || location.toAndroidLocation().distanceTo(f10) >= m.O().getDistance()) {
            new s5.g().c(context, true, eVar);
        } else {
            eVar.b(f10);
        }
    }

    public static d j() {
        return f14098h;
    }

    public static d k(Context context) {
        if (f14098h == null) {
            f14098h = new d(context);
        }
        return f14098h;
    }

    public static void n(Context context) {
        d dVar = f14098h;
        if (dVar == null) {
            f14098h = new d(context);
        } else {
            dVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(a.c cVar) {
        if (cVar == a.c.ALLOWED && f14099i.getTrackingType() == b.a.FULL) {
            u5.d.f14386a.k(this.f14102a.getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Activity activity, Location location, com.groboot.mdaemergency.enums.b bVar, boolean z10, g gVar) {
        com.groboot.mdaemergency.async.d.v().c0(bVar.getNum(), location, 3, new C0288d(gVar, bVar, z10, activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        AppUser k10 = m.k();
        if (k10 != null) {
            k10.getLocation().setStatusAvailability(f14099i);
            m.U(k10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Save status - ");
        sb2.append(f14099i.getTitle());
        sb2.append(" to localData");
    }

    private void z() {
        this.f14103b.e(this.f14102a, f14099i);
    }

    public void A() {
        if (m.k() != null && m.t() && com.groboot.mdaemergency.a.m(this.f14102a)) {
            e();
            com.groboot.mdaemergency.enums.b bVar = f14099i;
            if (bVar == null) {
                bVar = m.O();
            }
            f14099i = bVar;
            if (bVar.getTrackingType() == b.a.FULL) {
                z();
            } else if (f14099i.getTrackingType() == b.a.SLEEPY) {
                B();
            }
        }
    }

    public void B() {
        AppUser.Location location = m.k().getLocation(f14099i);
        if (location != null) {
            location.toAndroidLocation();
            this.f14103b.e(this.f14102a, f14099i);
        }
    }

    public void D() {
        s5.a aVar = this.f14103b;
        if (aVar != null) {
            aVar.a(this.f14102a);
        }
        t5.h.k(this.f14102a).r();
        u5.d.f14386a.l();
        C();
    }

    public void b() {
        boolean p10 = p();
        f fVar = this.f14106e;
        if (fVar != null) {
            fVar.a(p10);
        }
        if (p10) {
            A();
            l0.i(this.f14102a, f14097g);
        } else {
            this.f14103b.a(this.f14102a);
            y();
        }
    }

    public void e() {
    }

    public void g(Activity activity, e eVar) {
        Location f10 = f(this.f14102a);
        if (f10 == null || f10.getAccuracy() >= 1000.0f || new Date().getTime() - f10.getTime() > TimeUnit.MINUTES.toMillis(2L)) {
            new s5.g().c(this.f14102a, true, eVar);
        } else {
            eVar.b(f10);
        }
    }

    public boolean i() {
        return f14100j;
    }

    public Location l() {
        return this.f14107f;
    }

    public void m(e eVar) {
        AppUser.Location location;
        if (f14099i.getTrackingType() == b.a.SLEEPY && (location = m.k().getLocation(f14099i)) != null) {
            eVar.b(location.toAndroidLocation());
            return;
        }
        Location f10 = f(this.f14102a);
        if (f10 == null || f10.getAccuracy() >= 1500.0f) {
            new s5.g().c(this.f14102a, true, eVar);
        } else {
            eVar.b(f10);
        }
    }

    public void o() {
        if (com.groboot.mdaemergency.a.m(this.f14102a)) {
            if (m.k() == null) {
                if (this.f14103b.c(this.f14102a)) {
                    this.f14103b.a(this.f14102a);
                }
            } else {
                if (!m.t() || this.f14103b.c(this.f14102a)) {
                    return;
                }
                com.groboot.mdaemergency.enums.b O = m.O();
                f14099i = O;
                if (O != com.groboot.mdaemergency.enums.b.NOT_AVAILABLE) {
                    A();
                }
            }
        }
    }

    public boolean p() {
        try {
            if (!f14101k.isProviderEnabled("network")) {
                if (!f14101k.isProviderEnabled("gps")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void s(Activity activity) {
        com.groboot.mdaemergency.enums.b bVar;
        if (!com.groboot.mdaemergency.a.q(activity) && (bVar = f14099i) != null && bVar.getTrackingType() == b.a.FULL && Build.VERSION.SDK_INT >= 29) {
            com.groboot.mdaemergency.a.i(activity, new a.InterfaceC0096a() { // from class: s5.c
                @Override // com.groboot.mdaemergency.a.InterfaceC0096a
                public final void a(a.c cVar) {
                    d.this.q(cVar);
                }
            });
        }
    }

    public void t() {
        if (p()) {
            C();
            A();
        }
    }

    public void v(Activity activity, com.groboot.mdaemergency.enums.b bVar, boolean z10, g gVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setAvailability");
        sb2.append(this.f14102a.getString(bVar.getResTitle()));
        f14099i = bVar;
        Context applicationContext = (activity == null || activity.getApplicationContext() == null) ? this.f14102a : activity.getApplicationContext();
        if (activity != null && !l0.k0(activity)) {
            if (gVar == null) {
                gVar.a(activity.getString(R.string.no_internet_no_change_status));
                return;
            }
            return;
        }
        if (m.O() == bVar && bVar.getTrackingType() != b.a.SLEEPY) {
            if (gVar != null) {
                gVar.e();
                return;
            }
            return;
        }
        if (bVar == com.groboot.mdaemergency.enums.b.NOT_AVAILABLE) {
            r(activity, new Location("network"), bVar, z10, gVar);
            return;
        }
        if (m.k() == null) {
            if (gVar != null) {
                gVar.a("");
                return;
            }
            return;
        }
        if (bVar.getTrackingType() != b.a.SLEEPY) {
            if (p()) {
                m(new c(gVar, gVar, activity, applicationContext, bVar, z10));
                return;
            } else {
                if (gVar != null) {
                    gVar.a(applicationContext.getString(R.string.change_status__enabled_location_service));
                    return;
                }
                return;
            }
        }
        AppUser.Location location = m.k().getLocation(bVar);
        if (location != null) {
            h(applicationContext, location, new b(gVar, gVar, location, bVar, activity, z10));
        } else if (gVar != null) {
            gVar.d("");
        }
    }

    public void w(f fVar) {
        this.f14106e = fVar;
    }

    public void x(Location location) {
        if (location == null) {
            return;
        }
        new Date();
        this.f14107f = location;
    }

    public void y() {
        if (f14099i.getTrackingType() == b.a.FULL) {
            l0.B0(this.f14102a.getResources().getString(R.string.no_location_broadcast), "", false, f14097g, "android.settings.LOCATION_SOURCE_SETTINGS");
        }
    }
}
