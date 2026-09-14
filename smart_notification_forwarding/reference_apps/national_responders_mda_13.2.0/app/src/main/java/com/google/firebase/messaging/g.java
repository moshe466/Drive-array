package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.iid.c0;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes.dex */
public abstract class g extends Service {

    /* renamed from: g, reason: collision with root package name */
    private Binder f7453g;

    /* renamed from: i, reason: collision with root package name */
    private int f7455i;

    /* renamed from: f, reason: collision with root package name */
    final ExecutorService f7452f = h.c();

    /* renamed from: h, reason: collision with root package name */
    private final Object f7454h = new Object();

    /* renamed from: j, reason: collision with root package name */
    private int f7456j = 0;

    /* loaded from: classes.dex */
    class a implements c0.a {
        a() {
        }

        @Override // com.google.firebase.iid.c0.a
        public z2.l<Void> a(Intent intent) {
            return g.this.h(intent);
        }
    }

    private void b(Intent intent) {
        if (intent != null) {
            com.google.firebase.iid.a0.b(intent);
        }
        synchronized (this.f7454h) {
            int i10 = this.f7456j - 1;
            this.f7456j = i10;
            if (i10 == 0) {
                i(this.f7455i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z2.l<Void> h(final Intent intent) {
        if (e(intent)) {
            return z2.o.e(null);
        }
        final z2.m mVar = new z2.m();
        this.f7452f.execute(new Runnable(this, intent, mVar) { // from class: com.google.firebase.messaging.d

            /* renamed from: f, reason: collision with root package name */
            private final g f7422f;

            /* renamed from: g, reason: collision with root package name */
            private final Intent f7423g;

            /* renamed from: h, reason: collision with root package name */
            private final z2.m f7424h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7422f = this;
                this.f7423g = intent;
                this.f7424h = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7422f.g(this.f7423g, this.f7424h);
            }
        });
        return mVar.a();
    }

    protected abstract Intent c(Intent intent);

    public abstract void d(Intent intent);

    public abstract boolean e(Intent intent);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f(Intent intent, z2.l lVar) {
        b(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void g(Intent intent, z2.m mVar) {
        try {
            d(intent);
        } finally {
            mVar.c(null);
        }
    }

    boolean i(int i10) {
        return stopSelfResult(i10);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.f7453g == null) {
            this.f7453g = new com.google.firebase.iid.c0(new a());
        }
        return this.f7453g;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f7452f.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i10, int i11) {
        synchronized (this.f7454h) {
            this.f7455i = i11;
            this.f7456j++;
        }
        Intent c10 = c(intent);
        if (c10 == null) {
            b(intent);
            return 2;
        }
        z2.l<Void> h10 = h(c10);
        if (h10.o()) {
            b(intent);
            return 2;
        }
        h10.b(e.f7430f, new z2.f(this, intent) { // from class: com.google.firebase.messaging.f

            /* renamed from: a, reason: collision with root package name */
            private final g f7440a;

            /* renamed from: b, reason: collision with root package name */
            private final Intent f7441b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7440a = this;
                this.f7441b = intent;
            }

            @Override // z2.f
            public void a(z2.l lVar) {
                this.f7440a.f(this.f7441b, lVar);
            }
        });
        return 3;
    }
}
