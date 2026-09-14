package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.iid.f0;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class f0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7287a;

    /* renamed from: b, reason: collision with root package name */
    private final Intent f7288b;

    /* renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f7289c;

    /* renamed from: d, reason: collision with root package name */
    private final Queue<a> f7290d;

    /* renamed from: e, reason: collision with root package name */
    private c0 f7291e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7292f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Intent f7293a;

        /* renamed from: b, reason: collision with root package name */
        private final z2.m<Void> f7294b = new z2.m<>();

        a(Intent intent) {
            this.f7293a = intent;
        }

        void a(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.d0

                /* renamed from: f, reason: collision with root package name */
                private final f0.a f7280f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f7280f = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f7280f.d();
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            c().b(scheduledExecutorService, new z2.f(schedule) { // from class: com.google.firebase.iid.e0

                /* renamed from: a, reason: collision with root package name */
                private final ScheduledFuture f7282a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f7282a = schedule;
                }

                @Override // z2.f
                public void a(z2.l lVar) {
                    this.f7282a.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            this.f7294b.e(null);
        }

        z2.l<Void> c() {
            return this.f7294b.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void d() {
            String action = this.f7293a.getAction();
            StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 61);
            sb2.append("Service took too long to process intent: ");
            sb2.append(action);
            sb2.append(" App may get closed.");
            b();
        }
    }

    public f0(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new h2.b("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    f0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f7290d = new ArrayDeque();
        this.f7292f = false;
        Context applicationContext = context.getApplicationContext();
        this.f7287a = applicationContext;
        this.f7288b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f7289c = scheduledExecutorService;
    }

    private void a() {
        while (!this.f7290d.isEmpty()) {
            this.f7290d.poll().b();
        }
    }

    private synchronized void b() {
        Log.isLoggable("FirebaseInstanceId", 3);
        while (!this.f7290d.isEmpty()) {
            Log.isLoggable("FirebaseInstanceId", 3);
            c0 c0Var = this.f7291e;
            if (c0Var == null || !c0Var.isBinderAlive()) {
                d();
                return;
            } else {
                Log.isLoggable("FirebaseInstanceId", 3);
                this.f7291e.b(this.f7290d.poll());
            }
        }
    }

    private void d() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            boolean z10 = this.f7292f;
            StringBuilder sb2 = new StringBuilder(39);
            sb2.append("binder is dead. start connection? ");
            sb2.append(!z10);
        }
        if (this.f7292f) {
            return;
        }
        this.f7292f = true;
        try {
            if (f2.a.b().a(this.f7287a, this.f7288b, this, 65)) {
                return;
            }
        } catch (SecurityException unused) {
        }
        this.f7292f = false;
        a();
    }

    public synchronized z2.l<Void> c(Intent intent) {
        a aVar;
        Log.isLoggable("FirebaseInstanceId", 3);
        aVar = new a(intent);
        aVar.a(this.f7289c);
        this.f7290d.add(aVar);
        b();
        return aVar.c();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("onServiceConnected: ");
            sb2.append(valueOf);
        }
        this.f7292f = false;
        if (iBinder instanceof c0) {
            this.f7291e = (c0) iBinder;
            b();
            return;
        }
        String valueOf2 = String.valueOf(iBinder);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 28);
        sb3.append("Invalid service connection: ");
        sb3.append(valueOf2);
        a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("onServiceDisconnected: ");
            sb2.append(valueOf);
        }
        b();
    }
}
