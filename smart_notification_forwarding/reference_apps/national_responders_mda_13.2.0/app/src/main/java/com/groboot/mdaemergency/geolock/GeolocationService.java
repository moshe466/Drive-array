package com.groboot.mdaemergency.geolock;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.q;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.geolock.GeolocationService;
import java.util.ArrayList;
import java.util.List;
import s2.h;
import s2.n;
import s2.o;
import w6.m;
import z2.f;
import z2.i;
import z2.l;

/* loaded from: classes.dex */
public class GeolocationService extends Service {

    /* renamed from: g, reason: collision with root package name */
    private h f7689g;

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f7688f = new c(this);

    /* renamed from: i, reason: collision with root package name */
    private boolean f7691i = false;

    /* renamed from: j, reason: collision with root package name */
    private Location f7692j = null;

    /* renamed from: k, reason: collision with root package name */
    private final n f7693k = new a();

    /* renamed from: h, reason: collision with root package name */
    private final q<ArrayList<Location>> f7690h = new q<>(new ArrayList());

    /* loaded from: classes.dex */
    class a extends n {
        a() {
        }

        @Override // s2.n
        public void b(LocationResult locationResult) {
            if (locationResult == null) {
                return;
            }
            GeolocationService.this.h(locationResult.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends z2.a {
        b(GeolocationService geolocationService) {
        }

        @Override // z2.a
        public boolean a() {
            return false;
        }

        @Override // z2.a
        public z2.a b(i iVar) {
            return new z2.b().a();
        }
    }

    /* loaded from: classes.dex */
    public class c extends Binder {
        public c(GeolocationService geolocationService) {
        }
    }

    private void g() {
        this.f7689g.g(100, new b(this)).g(new z2.h() { // from class: r5.f
            @Override // z2.h
            public final void b(Object obj) {
                GeolocationService.this.o((Location) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<Location> list) {
        ArrayList<Location> e10 = this.f7690h.e();
        if (e10 != null) {
            e10.addAll(list);
        } else {
            e10 = (ArrayList) list;
        }
        r5.b.b().g(this);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleLocationUpdate: Time: ");
        sb2.append(i());
        sb2.append(" Distance: ");
        sb2.append(j(list.get(list.size() - 1)));
        if (i() || j(list.get(0)) || !r5.a.a().b()) {
            o(list.get(0));
        }
        this.f7690h.j(e10);
    }

    private boolean i() {
        return this.f7692j == null || SystemClock.elapsedRealtimeNanos() - this.f7692j.getElapsedRealtimeNanos() >= 300000000000L;
    }

    private boolean j(Location location) {
        Location location2 = this.f7692j;
        return location2 == null || location.distanceTo(location2) >= 300.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(l lVar) {
        if (lVar.p()) {
            this.f7691i = r5.a.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(l lVar) {
        this.f7689g.h(f(), this.f7693k, Looper.getMainLooper()).c(new f() { // from class: r5.d
            @Override // z2.f
            public final void a(l lVar2) {
                GeolocationService.this.k(lVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Location location, b.a aVar) {
        if (aVar.f7614b) {
            this.f7692j = location;
            r5.b.b().f(this);
        }
    }

    private void n() {
        if (r5.a.a().b() != this.f7691i) {
            this.f7689g.c(this.f7693k).c(new f() { // from class: r5.e
                @Override // z2.f
                public final void a(l lVar) {
                    GeolocationService.this.l(lVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final Location location) {
        if (r5.a.a().c()) {
            d.v().a0(location, m.O(), com.groboot.mdaemergency.locations.a.Fused.getValue(), new b.InterfaceC0098b() { // from class: r5.c
                @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                public final void a(b.a aVar) {
                    GeolocationService.this.m(location, aVar);
                }
            });
        }
    }

    private void p(Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("sp_send_current_location")) {
            return;
        }
        g();
    }

    private void q() {
        startForeground(v5.a.f14661a, v5.a.a(getApplicationContext()));
        v5.a.b(getApplicationContext());
    }

    protected LocationRequest f() {
        return new LocationRequest.a(r5.a.a().b() ? 30000L : 300000L).f(100).a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7688f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f7689g = o.a(this);
        q();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f7689g.c(this.f7693k);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (androidx.core.content.a.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && androidx.core.content.a.a(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return 2;
        }
        q();
        p(intent);
        n();
        return 1;
    }
}
