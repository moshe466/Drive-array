package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: i, reason: collision with root package name */
    private static final long f7431i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a, reason: collision with root package name */
    private final FirebaseInstanceId f7432a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7433b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.iid.s f7434c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.iid.p f7435d;

    /* renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f7437f;

    /* renamed from: h, reason: collision with root package name */
    private final c0 f7439h;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, ArrayDeque<z2.m<Void>>> f7436e = new l.a();

    /* renamed from: g, reason: collision with root package name */
    private boolean f7438g = false;

    private e0(FirebaseInstanceId firebaseInstanceId, com.google.firebase.iid.s sVar, c0 c0Var, com.google.firebase.iid.p pVar, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f7432a = firebaseInstanceId;
        this.f7434c = sVar;
        this.f7439h = c0Var;
        this.f7435d = pVar;
        this.f7433b = context;
        this.f7437f = scheduledExecutorService;
    }

    private static <T> T a(z2.l<T> lVar) {
        try {
            return (T) z2.o.b(lVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            e = e10;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e11);
        } catch (TimeoutException e12) {
            e = e12;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void b(String str) {
        com.google.firebase.iid.q qVar = (com.google.firebase.iid.q) a(this.f7432a.j());
        a(this.f7435d.j(qVar.e(), qVar.f(), str));
    }

    private void c(String str) {
        com.google.firebase.iid.q qVar = (com.google.firebase.iid.q) a(this.f7432a.j());
        a(this.f7435d.k(qVar.e(), qVar.f(), str));
    }

    static z2.l<e0> d(final FirebaseInstanceId firebaseInstanceId, final com.google.firebase.iid.s sVar, final com.google.firebase.iid.p pVar, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return z2.o.c(scheduledExecutorService, new Callable(context, scheduledExecutorService, firebaseInstanceId, sVar, pVar) { // from class: com.google.firebase.messaging.d0

            /* renamed from: a, reason: collision with root package name */
            private final Context f7425a;

            /* renamed from: b, reason: collision with root package name */
            private final ScheduledExecutorService f7426b;

            /* renamed from: c, reason: collision with root package name */
            private final FirebaseInstanceId f7427c;

            /* renamed from: d, reason: collision with root package name */
            private final com.google.firebase.iid.s f7428d;

            /* renamed from: e, reason: collision with root package name */
            private final com.google.firebase.iid.p f7429e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7425a = context;
                this.f7426b = scheduledExecutorService;
                this.f7427c = firebaseInstanceId;
                this.f7428d = sVar;
                this.f7429e = pVar;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return e0.i(this.f7425a, this.f7426b, this.f7427c, this.f7428d, this.f7429e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z2.l<e0> e(o3.c cVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.iid.s sVar, r4.b<x4.i> bVar, r4.b<p4.f> bVar2, com.google.firebase.installations.g gVar, Context context, ScheduledExecutorService scheduledExecutorService) {
        return d(firebaseInstanceId, sVar, new com.google.firebase.iid.p(cVar, sVar, bVar, bVar2, gVar), context, scheduledExecutorService);
    }

    static boolean g() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ e0 i(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, com.google.firebase.iid.s sVar, com.google.firebase.iid.p pVar) {
        return new e0(firebaseInstanceId, sVar, c0.a(context, scheduledExecutorService), pVar, context, scheduledExecutorService);
    }

    private void j(b0 b0Var) {
        synchronized (this.f7436e) {
            String e10 = b0Var.e();
            if (this.f7436e.containsKey(e10)) {
                ArrayDeque<z2.m<Void>> arrayDeque = this.f7436e.get(e10);
                z2.m<Void> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.c(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.f7436e.remove(e10);
                }
            }
        }
    }

    private void n() {
        if (h()) {
            return;
        }
        q(0L);
    }

    boolean f() {
        return this.f7439h.b() != null;
    }

    synchronized boolean h() {
        return this.f7438g;
    }

    boolean k(b0 b0Var) {
        char c10;
        StringBuilder sb2;
        try {
            String b10 = b0Var.b();
            int hashCode = b10.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85 && b10.equals("U")) {
                    c10 = 1;
                }
                c10 = 65535;
            } else {
                if (b10.equals("S")) {
                    c10 = 0;
                }
                c10 = 65535;
            }
            if (c10 == 0) {
                b(b0Var.c());
                if (g()) {
                    String c11 = b0Var.c();
                    sb2 = new StringBuilder(String.valueOf(c11).length() + 31);
                    sb2.append("Subscribe to topic: ");
                    sb2.append(c11);
                    sb2.append(" succeeded.");
                }
            } else if (c10 == 1) {
                c(b0Var.c());
                if (g()) {
                    String c12 = b0Var.c();
                    sb2 = new StringBuilder(String.valueOf(c12).length() + 35);
                    sb2.append("Unsubscribe from topic: ");
                    sb2.append(c12);
                    sb2.append(" succeeded.");
                }
            } else if (g()) {
                String valueOf = String.valueOf(b0Var);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 24);
                sb3.append("Unknown topic operation");
                sb3.append(valueOf);
                sb3.append(".");
            }
            return true;
        } catch (IOException e10) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e10.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e10.getMessage())) {
                if (e10.getMessage() == null) {
                    return false;
                }
                throw e10;
            }
            String message = e10.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
            sb4.append("Topic operation failed: ");
            sb4.append(message);
            sb4.append(". Will retry Topic operation.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Runnable runnable, long j10) {
        this.f7437f.schedule(runnable, j10, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void m(boolean z10) {
        this.f7438g = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (f()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        while (true) {
            synchronized (this) {
                b0 b10 = this.f7439h.b();
                if (b10 == null) {
                    g();
                    return true;
                }
                if (!k(b10)) {
                    return false;
                }
                this.f7439h.d(b10);
                j(b10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(long j10) {
        l(new f0(this, this.f7433b, this.f7434c, Math.min(Math.max(30L, j10 + j10), f7431i)), j10);
        m(true);
    }
}
