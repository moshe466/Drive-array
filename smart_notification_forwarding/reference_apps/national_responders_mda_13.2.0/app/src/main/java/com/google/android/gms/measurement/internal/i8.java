package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes.dex */
final class i8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e8 f6125f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i8(e8 e8Var) {
        this.f6125f = e8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6125f.f6000c.D(new ComponentName(this.f6125f.f6000c.i(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
