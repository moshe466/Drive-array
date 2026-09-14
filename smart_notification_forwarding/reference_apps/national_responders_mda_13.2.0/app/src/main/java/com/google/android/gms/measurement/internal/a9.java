package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;

/* loaded from: classes.dex */
public final class a9 extends b9 {

    /* renamed from: d, reason: collision with root package name */
    private final AlarmManager f5816d;

    /* renamed from: e, reason: collision with root package name */
    private final i f5817e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f5818f;

    /* JADX INFO: Access modifiers changed from: protected */
    public a9(e9 e9Var) {
        super(e9Var);
        this.f5816d = (AlarmManager) i().getSystemService("alarm");
        this.f5817e = new z8(this, e9Var.m0(), e9Var);
    }

    private final int A() {
        if (this.f5818f == null) {
            String valueOf = String.valueOf(i().getPackageName());
            this.f5818f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f5818f.intValue();
    }

    private final PendingIntent B() {
        Context i10 = i();
        return PendingIntent.getBroadcast(i10, 0, new Intent().setClassName(i10, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @TargetApi(24)
    private final void z() {
        ((JobScheduler) i().getSystemService("jobscheduler")).cancel(A());
    }

    @Override // com.google.android.gms.measurement.internal.b9
    protected final boolean w() {
        this.f5816d.cancel(B());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        z();
        return false;
    }

    public final void x(long j10) {
        u();
        Context i10 = i();
        if (!v2.e.b(i10)) {
            h().M().a("Receiver not registered/enabled");
        }
        if (!o9.Z(i10, false)) {
            h().M().a("Service not registered/enabled");
        }
        y();
        h().N().b("Scheduling upload, millis", Long.valueOf(j10));
        long b10 = f().b() + j10;
        if (j10 < Math.max(0L, s.f6438x.a(null).longValue()) && !this.f5817e.d()) {
            this.f5817e.c(j10);
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.f5816d.setInexactRepeating(2, b10, Math.max(s.f6428s.a(null).longValue(), j10), B());
            return;
        }
        Context i11 = i();
        ComponentName componentName = new ComponentName(i11, "com.google.android.gms.measurement.AppMeasurementJobService");
        int A = A();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.o6.b(i11, new JobInfo.Builder(A, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void y() {
        u();
        h().N().a("Unscheduling upload");
        this.f5816d.cancel(B());
        this.f5817e.e();
        if (Build.VERSION.SDK_INT >= 24) {
            z();
        }
    }
}
