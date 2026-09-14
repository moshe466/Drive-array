package com.groboot.mdaemergency.ptt;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.PttSettings;
import com.groboot.mdaemergency.ptt.PTTService;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.services.KeepAliveService;
import java.util.concurrent.TimeUnit;
import w6.d0;
import w6.l0;

/* loaded from: classes.dex */
public class PTTService extends Service {

    /* renamed from: h, reason: collision with root package name */
    static p f7748h;

    /* renamed from: i, reason: collision with root package name */
    static Object f7749i = "synchronized";

    /* renamed from: j, reason: collision with root package name */
    static boolean f7750j;

    /* renamed from: f, reason: collision with root package name */
    private IBinder f7751f = new c(this);

    /* renamed from: g, reason: collision with root package name */
    BroadcastReceiver f7752g = new a(this);

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a(PTTService pTTService) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (PTTService.f7748h != null) {
                if (l0.R0(p.C, intent.getAction())) {
                    PTTService.f7748h.C0();
                } else if (l0.R0(p.B, intent.getAction())) {
                    PTTService.f7748h.B0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b(PTTService pTTService) {
        }

        @Override // java.lang.Runnable
        public void run() {
            PTTService.f7748h.u0();
            PTTService.f7748h.g1();
            PTTService.f7748h.i1();
            PTTService.f7748h.I0();
        }
    }

    /* loaded from: classes.dex */
    public class c extends Binder {
        public c(PTTService pTTService) {
        }
    }

    public static p c() {
        return f7748h;
    }

    private void d() {
        synchronized (f7749i) {
            if (f7748h == null) {
                f7748h = new p(getApplicationContext());
            }
        }
        new Thread(new b(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e() {
        while (true) {
            p pVar = f7748h;
            if (pVar != null && pVar.i0() != p.a0.notReady && f7748h.i0() != p.a0.login) {
                f7748h.I0();
            }
            d0.a(5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(b.a aVar) {
    }

    public static PendingIntent g(Context context) {
        try {
            return PendingIntent.getService(context, 0, new Intent(context, (Class<?>) PTTService.class), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        } catch (Exception unused) {
            return null;
        }
    }

    private void h() {
        new Thread(new Runnable() { // from class: x5.l
            @Override // java.lang.Runnable
            public final void run() {
                PTTService.e();
            }
        }).start();
    }

    private static void i(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(2, SystemClock.elapsedRealtime(), TimeUnit.MINUTES.toMillis(1L), g(context));
    }

    public static void j(Context context) {
        boolean z10 = p.n0() && v5.a.a(context) != null;
        com.groboot.mdaemergency.async.d.v().p0(new PttSettings(z10), new b.InterfaceC0098b() { // from class: x5.k
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                PTTService.f(aVar);
            }
        });
        if (z10) {
            Intent intent = new Intent(context, (Class<?>) PTTService.class);
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
                if (f7750j) {
                    return;
                }
                f7750j = true;
                i(context);
            } catch (Exception unused) {
            }
        }
    }

    public static void k(Context context) {
        context.stopService(new Intent(context, (Class<?>) PTTService.class));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent g10 = g(context);
        if (g10 != null) {
            alarmManager.cancel(g10);
        }
        if (l0.j0(PTTService.class, context)) {
            context.stopService(new Intent(context, (Class<?>) PTTService.class));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7751f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Notification a10 = v5.a.a(getApplicationContext());
        if (a10 != null) {
            startForeground(v5.a.f14661a, a10);
        }
        if (p.n0()) {
            d();
            v5.a.b(getApplicationContext());
            IntentFilter intentFilter = new IntentFilter();
            for (String str : p.B) {
                intentFilter.addAction(str);
            }
            for (String str2 : p.C) {
                intentFilter.addAction(str2);
            }
            registerReceiver(this.f7752g, intentFilter);
            KeepAliveService.b(getApplicationContext());
            h();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            unregisterReceiver(this.f7752g);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        d();
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return true;
    }
}
