package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f0 implements Runnable {

    /* renamed from: k, reason: collision with root package name */
    private static final Object f7442k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static Boolean f7443l;

    /* renamed from: m, reason: collision with root package name */
    private static Boolean f7444m;

    /* renamed from: f, reason: collision with root package name */
    private final Context f7445f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.firebase.iid.s f7446g;

    /* renamed from: h, reason: collision with root package name */
    private final PowerManager.WakeLock f7447h;

    /* renamed from: i, reason: collision with root package name */
    private final e0 f7448i;

    /* renamed from: j, reason: collision with root package name */
    private final long f7449j;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private f0 f7450a;

        public a(f0 f0Var) {
            this.f7450a = f0Var;
        }

        public void a() {
            f0.b();
            f0.this.f7445f.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            f0 f0Var = this.f7450a;
            if (f0Var == null) {
                return;
            }
            if (f0Var.i()) {
                f0.b();
                this.f7450a.f7448i.l(this.f7450a, 0L);
                context.unregisterReceiver(this);
                this.f7450a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(e0 e0Var, Context context, com.google.firebase.iid.s sVar, long j10) {
        this.f7448i = e0Var;
        this.f7445f = context;
        this.f7449j = j10;
        this.f7446g = sVar;
        this.f7447h = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    static /* synthetic */ boolean b() {
        return j();
    }

    private static String e(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 142);
        sb2.append("Missing Permission: ");
        sb2.append(str);
        sb2.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return sb2.toString();
    }

    private static boolean f(Context context) {
        boolean booleanValue;
        synchronized (f7442k) {
            Boolean bool = f7444m;
            Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            f7444m = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = context.checkCallingOrSelfPermission(str) == 0;
        if (z10 || !Log.isLoggable("FirebaseMessaging", 3)) {
            return z10;
        }
        e(str);
        return false;
    }

    private static boolean h(Context context) {
        boolean booleanValue;
        synchronized (f7442k) {
            Boolean bool = f7443l;
            Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            f7443l = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean i() {
        boolean z10;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f7445f.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            z10 = activeNetworkInfo.isConnected();
        }
        return z10;
    }

    private static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (h(this.f7445f)) {
            this.f7447h.acquire(b.f7410a);
        }
        try {
            try {
                this.f7448i.m(true);
                if (!this.f7446g.g()) {
                    this.f7448i.m(false);
                    if (h(this.f7445f)) {
                        try {
                            this.f7447h.release();
                            return;
                        } catch (RuntimeException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (f(this.f7445f) && !i()) {
                    new a(this).a();
                    if (h(this.f7445f)) {
                        try {
                            this.f7447h.release();
                            return;
                        } catch (RuntimeException unused2) {
                            return;
                        }
                    }
                    return;
                }
                if (this.f7448i.p()) {
                    this.f7448i.m(false);
                } else {
                    this.f7448i.q(this.f7449j);
                }
                if (h(this.f7445f)) {
                    try {
                        this.f7447h.release();
                    } catch (RuntimeException unused3) {
                    }
                }
            } catch (IOException e10) {
                String valueOf = String.valueOf(e10.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to sync topics. Won't retry sync. ".concat(valueOf);
                }
                this.f7448i.m(false);
                if (h(this.f7445f)) {
                    try {
                        this.f7447h.release();
                    } catch (RuntimeException unused4) {
                    }
                }
            }
        } catch (Throwable th) {
            if (h(this.f7445f)) {
                try {
                    this.f7447h.release();
                } catch (RuntimeException unused5) {
                }
            }
            throw th;
        }
    }
}
