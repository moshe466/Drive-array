package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import v2.o;

/* loaded from: classes.dex */
public final class j8<T extends Context & v2.o> {

    /* renamed from: a, reason: collision with root package name */
    private final T f6142a;

    public j8(T t10) {
        b2.p.k(t10);
        this.f6142a = t10;
    }

    private final void f(Runnable runnable) {
        e9 d10 = e9.d(this.f6142a);
        d10.e().z(new n8(this, d10, runnable));
    }

    private final r3 j() {
        return t4.b(this.f6142a, null, null).h();
    }

    public final int a(final Intent intent, int i10, final int i11) {
        final r3 h10 = t4.b(this.f6142a, null, null).h();
        if (intent == null) {
            h10.I().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        h10.N().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            f(new Runnable(this, i11, h10, intent) { // from class: com.google.android.gms.measurement.internal.m8

                /* renamed from: f, reason: collision with root package name */
                private final j8 f6233f;

                /* renamed from: g, reason: collision with root package name */
                private final int f6234g;

                /* renamed from: h, reason: collision with root package name */
                private final r3 f6235h;

                /* renamed from: i, reason: collision with root package name */
                private final Intent f6236i;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f6233f = this;
                    this.f6234g = i11;
                    this.f6235h = h10;
                    this.f6236i = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f6233f.d(this.f6234g, this.f6235h, this.f6236i);
                }
            });
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            j().F().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new y4(e9.d(this.f6142a));
        }
        j().I().b("onBind received unknown action", action);
        return null;
    }

    public final void c() {
        t4.b(this.f6142a, null, null).h().N().a("Local AppMeasurementService is starting up");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(int i10, r3 r3Var, Intent intent) {
        if (this.f6142a.b(i10)) {
            r3Var.N().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            j().N().a("Completed wakeful intent.");
            this.f6142a.a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(r3 r3Var, JobParameters jobParameters) {
        r3Var.N().a("AppMeasurementJobService processed last upload request.");
        this.f6142a.c(jobParameters, false);
    }

    @TargetApi(24)
    public final boolean g(final JobParameters jobParameters) {
        final r3 h10 = t4.b(this.f6142a, null, null).h();
        String string = jobParameters.getExtras().getString("action");
        h10.N().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        f(new Runnable(this, h10, jobParameters) { // from class: com.google.android.gms.measurement.internal.l8

            /* renamed from: f, reason: collision with root package name */
            private final j8 f6203f;

            /* renamed from: g, reason: collision with root package name */
            private final r3 f6204g;

            /* renamed from: h, reason: collision with root package name */
            private final JobParameters f6205h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f6203f = this;
                this.f6204g = h10;
                this.f6205h = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f6203f.e(this.f6204g, this.f6205h);
            }
        });
        return true;
    }

    public final void h() {
        t4.b(this.f6142a, null, null).h().N().a("Local AppMeasurementService is shutting down");
    }

    public final boolean i(Intent intent) {
        if (intent == null) {
            j().F().a("onUnbind called with null intent");
            return true;
        }
        j().N().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void k(Intent intent) {
        if (intent == null) {
            j().F().a("onRebind called with null intent");
        } else {
            j().N().b("onRebind called. action", intent.getAction());
        }
    }
}
