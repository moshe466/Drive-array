package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.j8;
import v2.o;

@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements o {

    /* renamed from: f, reason: collision with root package name */
    private j8<AppMeasurementJobService> f5787f;

    private final j8<AppMeasurementJobService> d() {
        if (this.f5787f == null) {
            this.f5787f = new j8<>(this);
        }
        return this.f5787f;
    }

    @Override // v2.o
    public final void a(Intent intent) {
    }

    @Override // v2.o
    public final boolean b(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // v2.o
    @TargetApi(24)
    public final void c(JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return d().g(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return d().i(intent);
    }
}
