package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.j8;
import h0.a;
import v2.o;

/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements o {

    /* renamed from: f, reason: collision with root package name */
    private j8<AppMeasurementService> f5789f;

    private final j8<AppMeasurementService> d() {
        if (this.f5789f == null) {
            this.f5789f = new j8<>(this);
        }
        return this.f5789f;
    }

    @Override // v2.o
    public final void a(Intent intent) {
        a.b(intent);
    }

    @Override // v2.o
    public final boolean b(int i10) {
        return stopSelfResult(i10);
    }

    @Override // v2.o
    public final void c(JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return d().b(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        d().c();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        d().h();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        d().k(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        return d().a(intent, i10, i11);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return d().i(intent);
    }
}
