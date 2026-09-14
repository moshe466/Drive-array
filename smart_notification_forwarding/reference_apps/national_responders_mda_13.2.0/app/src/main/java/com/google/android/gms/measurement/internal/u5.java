package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rf;

/* loaded from: classes.dex */
final class u5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ rf f6525f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f6526g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5(AppMeasurementDynamiteService appMeasurementDynamiteService, rf rfVar) {
        this.f6526g = appMeasurementDynamiteService;
        this.f6525f = rfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6526g.f5790a.P().F(this.f6525f);
    }
}
