package com.groboot.mdaemergency.locations.geofencing;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.enums.b;
import com.groboot.mdaemergency.locations.geofencing.GeofenceService;
import com.groboot.mdaemergency.models.AppUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import s5.d;
import s5.g;
import t5.h;
import t5.i;
import w6.m;

/* loaded from: classes.dex */
public class GeofenceService extends Service {

    /* renamed from: q, reason: collision with root package name */
    private static boolean f7698q;

    /* renamed from: f, reason: collision with root package name */
    h f7699f;

    /* renamed from: g, reason: collision with root package name */
    Location f7700g;

    /* renamed from: h, reason: collision with root package name */
    g f7701h;

    /* renamed from: i, reason: collision with root package name */
    com.groboot.mdaemergency.enums.b f7702i;

    /* renamed from: j, reason: collision with root package name */
    Handler f7703j = new Handler();

    /* renamed from: k, reason: collision with root package name */
    Runnable f7704k;

    /* renamed from: l, reason: collision with root package name */
    int f7705l;

    /* renamed from: m, reason: collision with root package name */
    int f7706m;

    /* renamed from: n, reason: collision with root package name */
    final Handler f7707n;

    /* renamed from: o, reason: collision with root package name */
    Runnable f7708o;

    /* renamed from: p, reason: collision with root package name */
    BroadcastReceiver f7709p;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            boolean z10;
            if (m.k() == null || (action = intent.getAction()) == null) {
                return;
            }
            com.groboot.mdaemergency.locations.a aVar = com.groboot.mdaemergency.locations.a.unknown;
            if (intent.hasExtra("GeofencingReceiver_Extra_Provider")) {
                aVar = com.groboot.mdaemergency.locations.a.get(intent.getIntExtra("GeofencingReceiver_Extra_Provider", 0));
            }
            if (aVar == com.groboot.mdaemergency.locations.a.transitionRecognition) {
                z10 = action.equals("ransitionRecognition_Enter");
                if (intent.hasExtra("TransitionRecognition_EXTRA_ACTIVITY_TYPE")) {
                    GeofenceService.this.v(intent.getIntExtra("TransitionRecognition_EXTRA_ACTIVITY_TYPE", -1));
                    if (GeofenceService.this.w(action, aVar)) {
                        return;
                    }
                }
            } else if (aVar == com.groboot.mdaemergency.locations.a.geofence) {
                z10 = action.equals("GeofencingReceiver_Exit");
                GeofenceService.this.l(intent, aVar);
                GeofenceService.this.v(-1);
            } else {
                z10 = false;
            }
            if (z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exit Recognition by ");
                sb2.append(aVar.name());
                GeofenceService geofenceService = GeofenceService.this;
                if (geofenceService.f7702i == null) {
                    geofenceService.f7702i = m.O();
                }
                if (GeofenceService.this.f7702i.getTrackingType() != b.a.FULL) {
                    if (GeofenceService.this.f7702i.getTrackingType() != b.a.SLEEPY) {
                        return;
                    }
                    GeofenceService.this.f7699f.r();
                    GeofenceService geofenceService2 = GeofenceService.this;
                    com.groboot.mdaemergency.enums.b bVar = com.groboot.mdaemergency.enums.b.AVAILABLE;
                    geofenceService2.f7702i = bVar;
                    AppUser k10 = m.k();
                    if (k10 != null) {
                        k10.getLocation().setStatusAvailability(bVar);
                        m.U(k10);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Save status - ");
                    sb3.append(bVar.getTitle());
                    sb3.append(" to localData");
                }
                GeofenceService.this.x(false, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements d.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.locations.a f7711a;

        b(com.groboot.mdaemergency.locations.a aVar) {
            this.f7711a = aVar;
        }

        @Override // s5.d.e
        public void a(Location location) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @6");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Service updateGeofence location = ");
            sb2.append(location.getLatitude());
            sb2.append(" , ");
            sb2.append(location.getLongitude());
            GeofenceService geofenceService = GeofenceService.this;
            geofenceService.f7700g = location;
            geofenceService.u(location, 0, this.f7711a);
            GeofenceService.this.s();
            boolean unused = GeofenceService.f7698q = true;
        }

        @Override // s5.d.e
        public void b(Location location) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLoc", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @7");
            GeofenceService.this.k(location);
            GeofenceService geofenceService = GeofenceService.this;
            geofenceService.f7700g = location;
            geofenceService.u(location, 0, this.f7711a);
            GeofenceService.this.s();
            GeofenceService.this.f7699f.d(location.getLatitude(), location.getLongitude());
            GeofenceService.this.q();
            boolean unused = GeofenceService.f7698q = false;
            GeofenceService.this.r();
        }
    }

    /* loaded from: classes.dex */
    class c implements i {
        c(GeofenceService geofenceService) {
        }

        @Override // t5.i
        public void a(com.google.android.gms.common.a aVar) {
        }

        @Override // t5.i
        public void b() {
        }

        @Override // t5.i
        public void c() {
        }
    }

    public GeofenceService() {
        u5.d dVar = u5.d.f14386a;
        this.f7705l = -1;
        this.f7706m = -1;
        this.f7707n = new Handler();
        this.f7708o = new Runnable() { // from class: t5.d
            @Override // java.lang.Runnable
            public final void run() {
                GeofenceService.this.n();
            }
        };
        this.f7709p = new a();
        new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Location location) {
        Location location2;
        if (this.f7706m != 7 || this.f7705l != 7 || (location2 = this.f7700g) == null || location2.distanceTo(location) <= 30.0f) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: t5.c
            @Override // java.lang.Runnable
            public final void run() {
                GeofenceService.this.m();
            }
        }, TimeUnit.SECONDS.toMillis(5L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Intent intent, com.groboot.mdaemergency.locations.a aVar) {
        ArrayList<String> stringArrayListExtra;
        if (aVar == com.groboot.mdaemergency.locations.a.geofence && intent.getAction().equals("GeofencingReceiver_Exit") && intent.hasExtra("GeofencingReceiver_Extra_GeofenceIds") && (stringArrayListExtra = intent.getStringArrayListExtra("GeofencingReceiver_Extra_GeofenceIds")) != null) {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Service detect EXIT ");
                sb2.append(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        if (this.f7705l == 7) {
            x(false, com.groboot.mdaemergency.locations.a.transitionRecognition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        if (f7698q) {
            t();
        } else {
            s();
            x(true, com.groboot.mdaemergency.locations.a.unknown);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (this.f7705l != 7 || f7698q) {
            return;
        }
        v(this.f7705l);
        x(true, com.groboot.mdaemergency.locations.a.transitionRecognition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f7707n.postDelayed(this.f7708o, TimeUnit.HOURS.toMillis(2));
    }

    private void t() {
        this.f7707n.removeCallbacks(this.f7708o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i10) {
        this.f7706m = this.f7705l;
        this.f7705l = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(String str, com.groboot.mdaemergency.locations.a aVar) {
        if (this.f7705l != 7 || !str.equals("ransitionRecognition_Enter")) {
            return false;
        }
        x(true, aVar);
        new Handler().postDelayed(new Runnable() { // from class: t5.b
            @Override // java.lang.Runnable
            public final void run() {
                GeofenceService.this.p();
            }
        }, TimeUnit.MINUTES.toMillis(1L));
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Notification a10 = v5.a.a(getApplicationContext());
        if (a10 != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(v5.a.f14661a, a10, 8);
            } else {
                startForeground(v5.a.f14661a, a10);
            }
            v5.a.b(getApplicationContext());
        }
        this.f7701h.d();
        unregisterReceiver(this.f7709p);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (m.v().booleanValue() && this.f7700g != null) {
            this.f7699f.d(this.f7700g.getLatitude(), this.f7700g.getLongitude());
            this.f7699f.q();
        }
        this.f7701h.d();
        unregisterReceiver(this.f7709p);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        m.O();
        return 1;
    }

    public void q() {
        this.f7699f.q();
    }

    public void s() {
        this.f7699f.r();
    }

    public void u(Location location, int i10, com.groboot.mdaemergency.locations.a aVar) {
        Runnable runnable = this.f7704k;
        if (runnable != null && i10 == 0) {
            this.f7703j.removeCallbacks(runnable);
        }
        com.groboot.mdaemergency.enums.b bVar = this.f7702i;
        if (bVar == null) {
            this.f7702i = m.O();
        } else if (bVar != m.O()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Service sendLocationToServer provider:");
        sb2.append(location.getProvider());
        com.groboot.mdaemergency.async.d.v().a0(location, this.f7702i, aVar.getValue(), new b.InterfaceC0098b() { // from class: t5.a
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar2) {
                aVar2.f7614b;
            }
        });
    }

    public void x(boolean z10, com.groboot.mdaemergency.locations.a aVar) {
        f7698q = !z10;
        if (!z10) {
            t();
        }
        this.f7701h.c(this, z10, new b(aVar));
    }
}
