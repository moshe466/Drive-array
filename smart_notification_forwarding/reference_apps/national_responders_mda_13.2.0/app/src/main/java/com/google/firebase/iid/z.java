package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.y;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final long f7342f;

    /* renamed from: g, reason: collision with root package name */
    private final PowerManager.WakeLock f7343g;

    /* renamed from: h, reason: collision with root package name */
    private final FirebaseInstanceId f7344h;

    /* renamed from: i, reason: collision with root package name */
    ExecutorService f7345i = h.b();

    /* loaded from: classes.dex */
    static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private z f7346a;

        public a(z zVar) {
            this.f7346a = zVar;
        }

        public void a() {
            FirebaseInstanceId.r();
            this.f7346a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            z zVar = this.f7346a;
            if (zVar != null && zVar.d()) {
                FirebaseInstanceId.r();
                this.f7346a.f7344h.e(this.f7346a, 0L);
                this.f7346a.b().unregisterReceiver(this);
                this.f7346a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FirebaseInstanceId firebaseInstanceId, long j10) {
        this.f7344h = firebaseInstanceId;
        this.f7342f = j10;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f7343g = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private void c(String str) {
        if ("[DEFAULT]".equals(this.f7344h.f().i())) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(this.f7344h.f().i());
                if (valueOf.length() != 0) {
                    "Invoking onNewToken for app: ".concat(valueOf);
                }
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new f(b(), this.f7345i).g(intent);
        }
    }

    Context b() {
        return this.f7344h.f().g();
    }

    boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    boolean e() {
        y.a p10 = this.f7344h.p();
        if (!this.f7344h.F(p10)) {
            return true;
        }
        try {
            String c10 = this.f7344h.c();
            if (c10 == null) {
                return false;
            }
            Log.isLoggable("FirebaseInstanceId", 3);
            if (p10 == null || !c10.equals(p10.f7339a)) {
                c(c10);
            }
            return true;
        } catch (IOException e10) {
            if (!p.f(e10.getMessage())) {
                if (e10.getMessage() == null) {
                    return false;
                }
                throw e10;
            }
            String message = e10.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 52);
            sb2.append("Token retrieval failed: ");
            sb2.append(message);
            sb2.append(". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (x.b().e(b())) {
            this.f7343g.acquire();
        }
        try {
            try {
                this.f7344h.B(true);
                if (!this.f7344h.s()) {
                    this.f7344h.B(false);
                    if (!x.b().e(b())) {
                        return;
                    }
                } else if (!x.b().d(b()) || d()) {
                    if (e()) {
                        this.f7344h.B(false);
                    } else {
                        this.f7344h.E(this.f7342f);
                    }
                    if (!x.b().e(b())) {
                        return;
                    }
                } else {
                    new a(this).a();
                    if (!x.b().e(b())) {
                        return;
                    }
                }
            } catch (IOException e10) {
                String message = e10.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 93);
                sb2.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb2.append(message);
                sb2.append(". Won't retry the operation.");
                this.f7344h.B(false);
                if (!x.b().e(b())) {
                    return;
                }
            }
            this.f7343g.release();
        } catch (Throwable th) {
            if (x.b().e(b())) {
                this.f7343g.release();
            }
            throw th;
        }
    }
}
