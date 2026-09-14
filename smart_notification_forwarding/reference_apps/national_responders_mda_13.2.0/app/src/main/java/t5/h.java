package t5;

import a2.f;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.locations.geofencing.GeofencingBroadcastReceiver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import s2.i;
import s2.k;
import s2.m;
import s2.o;

/* loaded from: classes.dex */
public class h implements f.b, f.c {

    /* renamed from: g, reason: collision with root package name */
    private static h f14297g;

    /* renamed from: a, reason: collision with root package name */
    private Context f14298a;

    /* renamed from: b, reason: collision with root package name */
    private a2.f f14299b;

    /* renamed from: c, reason: collision with root package name */
    private List<s2.i> f14300c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f14301d;

    /* renamed from: e, reason: collision with root package name */
    private i f14302e;

    /* renamed from: f, reason: collision with root package name */
    private k f14303f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements z2.g {
        a(h hVar) {
        }

        @Override // z2.g
        public void d(Exception exc) {
            g5.b.i(MdaEmergencyApplication.b()).f("lastLocFailGeofRem", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @F2:\n" + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements z2.h<Void> {
        b(h hVar) {
        }

        @Override // z2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r12) {
        }
    }

    private h(Context context) {
        this.f14298a = context;
    }

    private PendingIntent h() {
        PendingIntent pendingIntent = this.f14301d;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        Intent intent = new Intent(this.f14298a, (Class<?>) GeofencingBroadcastReceiver.class);
        intent.setAction("ACTION_PROCESS_UPDATES");
        return PendingIntent.getBroadcast(this.f14298a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
    }

    private m j() {
        m.a aVar = new m.a();
        aVar.d(2);
        aVar.b(this.f14300c);
        return aVar.c();
    }

    public static h k(Context context) {
        if (f14297g == null) {
            f14297g = new h(context);
        }
        return f14297g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Void r22) {
        if (this.f14300c != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Registerer: ");
            sb2.append(this.f14300c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i10) {
        f(i10 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(final int i10, Exception exc) {
        g5.b.i(MdaEmergencyApplication.b()).f("lastLocFailGeofReg", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @F1:\n" + exc.getMessage());
        if (i10 < 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Registerer onFailure();");
            sb2.append(exc);
            new Handler().postDelayed(new Runnable() { // from class: t5.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.m(i10);
                }
            }, TimeUnit.SECONDS.toMillis(5L));
        }
    }

    public void d(double d10, double d11) {
        e(d10, d11, 200);
    }

    public void e(double d10, double d11, int i10) {
        s2.i a10 = new i.a().d(d10 + " , " + d11).b(d10, d11, i10).c(-1L).e(3).a();
        if (this.f14300c == null) {
            this.f14300c = new ArrayList();
        }
        this.f14300c.add(a10);
    }

    public void f(final int i10) {
        List<s2.i> list;
        if (androidx.core.content.a.a(this.f14298a, "android.permission.ACCESS_FINE_LOCATION") != 0 || (list = this.f14300c) == null || list.isEmpty()) {
            return;
        }
        this.f14303f.b(j(), h()).g(new z2.h() { // from class: t5.g
            @Override // z2.h
            public final void b(Object obj) {
                h.this.l((Void) obj);
            }
        }).e(new z2.g() { // from class: t5.f
            @Override // z2.g
            public final void d(Exception exc) {
                h.this.o(i10, exc);
            }
        });
    }

    public void g() {
        k kVar = this.f14303f;
        if (kVar == null) {
            return;
        }
        kVar.a(h()).g(new b(this)).e(new a(this));
    }

    @Override // com.google.android.gms.common.api.internal.f
    public void i(int i10) {
        g5.b.i(MdaEmergencyApplication.b()).f("lastLocFailGeofConnSus", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @F4");
        i iVar = this.f14302e;
        if (iVar != null) {
            iVar.c();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Registerer onConnectionSuspended: ");
        sb2.append(i10);
    }

    @Override // com.google.android.gms.common.api.internal.o
    public void n(com.google.android.gms.common.a aVar) {
        g5.b.i(MdaEmergencyApplication.b()).f("lastLocFailGeofConn", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @F3:\n" + aVar.j());
        i iVar = this.f14302e;
        if (iVar != null) {
            iVar.a(aVar);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Registerer onConnectionFailed: ");
        sb2.append(aVar.g());
    }

    @Override // com.google.android.gms.common.api.internal.f
    public void p(Bundle bundle) {
        i iVar = this.f14302e;
        if (iVar != null) {
            iVar.b();
        }
        this.f14301d = h();
        g();
        f(0);
    }

    public void q() {
        a2.f d10 = new f.a(this.f14298a).a(o.f14053a).b(this).c(this).d();
        this.f14299b = d10;
        d10.d();
        this.f14303f = o.b(this.f14298a);
    }

    public void r() {
        this.f14300c = null;
        g();
    }
}
