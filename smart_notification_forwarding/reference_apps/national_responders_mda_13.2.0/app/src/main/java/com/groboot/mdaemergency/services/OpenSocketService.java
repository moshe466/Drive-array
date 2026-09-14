package com.groboot.mdaemergency.services;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.google.gson.e;
import com.groboot.mdaemergency.async.c;
import com.groboot.mdaemergency.models.NetworkSettings;
import com.groboot.mdaemergency.services.OpenSocketService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import mb.r;
import w6.l0;
import w6.m;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class OpenSocketService extends Service {

    /* renamed from: q, reason: collision with root package name */
    public static final a f7989q = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public com.groboot.mdaemergency.async.c f7993i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7995k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7996l;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f7998n;

    /* renamed from: f, reason: collision with root package name */
    private final String f7990f = "[OpenSocket].[Service]";

    /* renamed from: g, reason: collision with root package name */
    private String f7991g = "il.org.mda.vehicleptt.services.OpenSocketService.WAKEUP";

    /* renamed from: h, reason: collision with root package name */
    private final String f7992h = "mda";

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<String> f7994j = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private final NetworkSettings f7997m = m.m().defaultSocketSettings();

    /* renamed from: o, reason: collision with root package name */
    private d f7999o = new d();

    /* renamed from: p, reason: collision with root package name */
    private final c f8000p = new c();

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Context context) {
            k.e(context, "context");
            if (m.k() == null) {
                return;
            }
            l0.Q0(context, OpenSocketService.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e5.a<HashMap<String, Object>> {
        b() {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements c.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(OpenSocketService openSocketService, int i10) {
            k.e(openSocketService, "this$0");
            Thread.sleep(4000L);
            openSocketService.s(i10 + 1);
        }

        @Override // com.groboot.mdaemergency.async.c.a
        public void a(final int i10, c.b bVar) {
            if (bVar == c.b.close) {
                OpenSocketService.this.f7996l = false;
                final OpenSocketService openSocketService = OpenSocketService.this;
                new Thread(new Runnable() { // from class: z5.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        OpenSocketService.c.d(OpenSocketService.this, i10);
                    }
                }).start();
            }
            if (bVar == c.b.connect) {
                OpenSocketService.this.f7996l = true;
                OpenSocketService.this.f7995k = false;
            }
        }

        @Override // com.groboot.mdaemergency.async.c.a
        public void b(int i10, String str) {
            boolean w10;
            boolean o10;
            OpenSocketService.this.m();
            k.j("receive network data:", str);
            if (str == null || str.length() == 0) {
                return;
            }
            if (i10 != OpenSocketService.this.j().e()) {
                OpenSocketService.this.m();
                return;
            }
            w10 = r.w(str, '<' + OpenSocketService.this.l() + '>', false, 2, null);
            if (w10) {
                OpenSocketService.this.f7994j.clear();
            }
            OpenSocketService.this.f7994j.add(str);
            o10 = r.o(str, "</" + OpenSocketService.this.l() + '>', false, 2, null);
            if (o10) {
                OpenSocketService.this.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends BroadcastReceiver {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(OpenSocketService openSocketService) {
            k.e(openSocketService, "this$0");
            openSocketService.p();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.e(context, "context");
            k.e(intent, "intent");
            final OpenSocketService openSocketService = OpenSocketService.this;
            new Thread(new Runnable() { // from class: z5.h
                @Override // java.lang.Runnable
                public final void run() {
                    OpenSocketService.d.b(OpenSocketService.this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        try {
            String str = "";
            Iterator<String> it = this.f7994j.iterator();
            while (it.hasNext()) {
                str = k.j(str, it.next());
            }
            String o10 = o(n(str, '<' + this.f7992h + '>'), "</" + this.f7992h + '>');
            k.j("HandleNetworkMessage: ", o10);
            if (k.a(o10, "keepalive")) {
                this.f7995k = false;
                return;
            }
            Object j10 = new e().j(o10, new b().e());
            k.d(j10, "Gson().fromJson(\n       …ng, Any>>() {}.getType())");
            Map map = (Map) j10;
            j().b(k.j("messageId:", map.get(p5.d.f13069e)));
            p5.d.n(getApplicationContext(), map, false);
        } catch (Exception e10) {
            k.j("HandleNetworkMessage Error ", e10.getMessage());
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        try {
            if (this.f7996l) {
                if (j().b("keepalive")) {
                    v();
                } else {
                    this.f7996l = false;
                    j().c();
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void q() {
        Object systemService = getSystemService("alarm");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long valueOf = this.f7997m == null ? null : Long.valueOf(r0.keepAliveDuration);
        alarmManager.setInexactRepeating(0, elapsedRealtime, valueOf == null ? TimeUnit.MINUTES.toMillis(1L) : valueOf.longValue(), k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final int i10) {
        if (this.f7998n) {
            new Thread(new Runnable() { // from class: z5.f
                @Override // java.lang.Runnable
                public final void run() {
                    OpenSocketService.t(OpenSocketService.this, i10);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(OpenSocketService openSocketService, int i10) {
        k.e(openSocketService, "this$0");
        String str = openSocketService.f7990f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startNetworkTask(");
        sb2.append(i10);
        sb2.append(')');
        openSocketService.f7994j = new ArrayList<>();
        openSocketService.r(new com.groboot.mdaemergency.async.c(openSocketService.f7997m, i10));
        openSocketService.j().j(openSocketService.f8000p);
        openSocketService.j().i();
    }

    public static final void u(Context context) {
        f7989q.a(context);
    }

    private final void v() {
        this.f7995k = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: z5.e
            @Override // java.lang.Runnable
            public final void run() {
                OpenSocketService.w(OpenSocketService.this);
            }
        }, TimeUnit.SECONDS.toMillis(15L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(OpenSocketService openSocketService) {
        k.e(openSocketService, "this$0");
        String str = openSocketService.f7990f;
        if (openSocketService.f7995k) {
            openSocketService.f7995k = false;
            openSocketService.j().c();
        }
    }

    public final com.groboot.mdaemergency.async.c j() {
        com.groboot.mdaemergency.async.c cVar = this.f7993i;
        if (cVar != null) {
            return cVar;
        }
        k.o("networkTask");
        return null;
    }

    public final PendingIntent k() {
        PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(this.f7991g), Build.VERSION.SDK_INT >= 23 ? 67108864 : 0);
        k.d(broadcast, "getBroadcast(application…(WAKEUP_ACTION), piFlags)");
        return broadcast;
    }

    public final String l() {
        return this.f7992h;
    }

    public final String m() {
        return this.f7990f;
    }

    public final String n(String str, String str2) {
        k.e(str, "text");
        if (str2 != null && str2.length() != 0) {
            while (str.length() >= str2.length()) {
                String substring = str.substring(0, str2.length());
                k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (!k.a(str2, substring)) {
                    break;
                }
                str = str.substring(str2.length());
                k.d(str, "this as java.lang.String).substring(startIndex)");
            }
        }
        return str;
    }

    public final String o(String str, String str2) {
        k.e(str, "text");
        if (str2 != null && str2.length() != 0) {
            while (str.length() >= str2.length()) {
                String substring = str.substring(str.length() - str2.length());
                k.d(substring, "this as java.lang.String).substring(startIndex)");
                if (!k.a(str2, substring)) {
                    break;
                }
                str = str.substring(0, str.length() - str2.length());
                k.d(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
        }
        return str;
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
            startForeground(v5.a.f14661a, a10);
            v5.a.b(getApplicationContext());
        }
        s(1);
        q();
        registerReceiver(this.f7999o, new IntentFilter(this.f7991g));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f7999o);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 1;
    }

    public final void r(com.groboot.mdaemergency.async.c cVar) {
        k.e(cVar, "<set-?>");
        this.f7993i = cVar;
    }
}
