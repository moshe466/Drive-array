package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rf;

/* loaded from: classes.dex */
final class u9 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ rf f6538f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f6539g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u9(AppMeasurementDynamiteService appMeasurementDynamiteService, rf rfVar) {
        this.f6539g = appMeasurementDynamiteService;
        this.f6538f = rfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6539g.f5790a.G().T(this.f6538f, this.f6539g.f5790a.T());
    }
}
