package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class FirebaseMessaging {

    /* renamed from: g, reason: collision with root package name */
    @SuppressLint({"FirebaseUnknownNullness"})
    static i1.g f7387g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f7388a;

    /* renamed from: b, reason: collision with root package name */
    private final o3.c f7389b;

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseInstanceId f7390c;

    /* renamed from: d, reason: collision with root package name */
    private final a f7391d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f7392e;

    /* renamed from: f, reason: collision with root package name */
    private final z2.l<e0> f7393f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final o4.d f7394a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7395b;

        /* renamed from: c, reason: collision with root package name */
        private o4.b<o3.a> f7396c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f7397d;

        a(o4.d dVar) {
            this.f7394a = dVar;
        }

        private Boolean f() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context g10 = FirebaseMessaging.this.f7389b.g();
            SharedPreferences sharedPreferences = g10.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = g10.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(g10.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void a() {
            if (this.f7395b) {
                return;
            }
            Boolean f10 = f();
            this.f7397d = f10;
            if (f10 == null) {
                o4.b<o3.a> bVar = new o4.b(this) { // from class: com.google.firebase.messaging.l

                    /* renamed from: a, reason: collision with root package name */
                    private final FirebaseMessaging.a f7462a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f7462a = this;
                    }

                    @Override // o4.b
                    public void a(o4.a aVar) {
                        this.f7462a.d(aVar);
                    }
                };
                this.f7396c = bVar;
                this.f7394a.a(o3.a.class, bVar);
            }
            this.f7395b = true;
        }

        synchronized boolean b() {
            Boolean bool;
            a();
            bool = this.f7397d;
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f7389b.p();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void c() {
            FirebaseMessaging.this.f7390c.n();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void d(o4.a aVar) {
            if (b()) {
                FirebaseMessaging.this.f7392e.execute(new Runnable(this) { // from class: com.google.firebase.messaging.n

                    /* renamed from: f, reason: collision with root package name */
                    private final FirebaseMessaging.a f7464f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f7464f = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f7464f.c();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void e() {
            FirebaseMessaging.this.f7390c.n();
        }

        synchronized void g(boolean z10) {
            a();
            o4.b<o3.a> bVar = this.f7396c;
            if (bVar != null) {
                this.f7394a.c(o3.a.class, bVar);
                this.f7396c = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.f7389b.g().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z10);
            edit.apply();
            if (z10) {
                FirebaseMessaging.this.f7392e.execute(new Runnable(this) { // from class: com.google.firebase.messaging.m

                    /* renamed from: f, reason: collision with root package name */
                    private final FirebaseMessaging.a f7463f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f7463f = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f7463f.e();
                    }
                });
            }
            this.f7397d = Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(o3.c cVar, final FirebaseInstanceId firebaseInstanceId, r4.b<x4.i> bVar, r4.b<p4.f> bVar2, com.google.firebase.installations.g gVar, i1.g gVar2, o4.d dVar) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            f7387g = gVar2;
            this.f7389b = cVar;
            this.f7390c = firebaseInstanceId;
            this.f7391d = new a(dVar);
            Context g10 = cVar.g();
            this.f7388a = g10;
            ScheduledExecutorService b10 = h.b();
            this.f7392e = b10;
            b10.execute(new Runnable(this, firebaseInstanceId) { // from class: com.google.firebase.messaging.i

                /* renamed from: f, reason: collision with root package name */
                private final FirebaseMessaging f7458f;

                /* renamed from: g, reason: collision with root package name */
                private final FirebaseInstanceId f7459g;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f7458f = this;
                    this.f7459g = firebaseInstanceId;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f7458f.i(this.f7459g);
                }
            });
            z2.l<e0> e10 = e0.e(cVar, firebaseInstanceId, new com.google.firebase.iid.s(g10), bVar, bVar2, gVar, g10, h.e());
            this.f7393f = e10;
            e10.f(h.f(), new z2.h(this) { // from class: com.google.firebase.messaging.j

                /* renamed from: a, reason: collision with root package name */
                private final FirebaseMessaging f7460a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f7460a = this;
                }

                @Override // z2.h
                public void b(Object obj) {
                    this.f7460a.j((e0) obj);
                }
            });
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    public static synchronized FirebaseMessaging d() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(o3.c.h());
        }
        return firebaseMessaging;
    }

    public static i1.g f() {
        return f7387g;
    }

    @Keep
    static synchronized FirebaseMessaging getInstance(o3.c cVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) cVar.f(FirebaseMessaging.class);
            b2.p.l(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public z2.l<String> e() {
        return this.f7390c.j().i(k.f7461a);
    }

    public boolean g() {
        return this.f7391d.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(FirebaseInstanceId firebaseInstanceId) {
        if (this.f7391d.b()) {
            firebaseInstanceId.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j(e0 e0Var) {
        if (g()) {
            e0Var.o();
        }
    }

    public void k(boolean z10) {
        this.f7391d.g(z10);
    }
}
