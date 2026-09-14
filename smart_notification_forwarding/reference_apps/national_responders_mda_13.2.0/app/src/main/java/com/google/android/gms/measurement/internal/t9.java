package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
final class t9 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService.a f6509f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f6510g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t9(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.a aVar) {
        this.f6510g = appMeasurementDynamiteService;
        this.f6509f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6510g.f5790a.F().a0(this.f6509f);
    }
}
