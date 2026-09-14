package com.groboot.mdaemergency.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.AppUser;
import java.util.Timer;
import java.util.TimerTask;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class GoogleTokenService extends Service {

    /* renamed from: h, reason: collision with root package name */
    static int f7973h;

    /* renamed from: f, reason: collision with root package name */
    private IBinder f7974f = new b(this);

    /* renamed from: g, reason: collision with root package name */
    private Timer f7975g;

    /* loaded from: classes.dex */
    class a extends TimerTask {

        /* renamed from: com.groboot.mdaemergency.services.GoogleTokenService$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0115a implements b.InterfaceC0098b {
            C0115a() {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                if (aVar.f7615c) {
                    AppUser k10 = m.k();
                    if (k10 != null) {
                        k10.setPushID("");
                        m.U(k10);
                    }
                    if (GoogleTokenService.this.f7975g != null) {
                        GoogleTokenService.this.f7975g.cancel();
                    }
                    GoogleTokenService.this.f7975g = null;
                    GoogleTokenService.this.stopSelf();
                }
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            GoogleTokenService.f7973h = 0;
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get token from google. try counter:");
                sb2.append(GoogleTokenService.f7973h);
                if (!l0.l0("")) {
                    d.v().n0("", new C0115a());
                }
            } catch (Exception unused) {
            }
            GoogleTokenService.f7973h++;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Binder {
        public b(GoogleTokenService googleTokenService) {
        }
    }

    public static void c(Context context) {
        if (m.k() != null) {
            if ((m.k() != null && m.k().hasPushID()) || m.m() == com.groboot.mdaemergency.enums.a.POC || m.k().getDeviceID() == null || m.k().getDeviceID().isEmpty()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) GoogleTokenService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7974f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(v5.a.f14661a, v5.a.a(getApplicationContext()));
        if (m.k() == null || m.k().hasPushID() || f7973h >= 60) {
            stopSelf();
            return;
        }
        Timer timer = new Timer();
        this.f7975g = timer;
        timer.schedule(new a(), 30000L, 60000L);
    }

    @Override // android.app.Service
    public void onDestroy() {
    }
}
