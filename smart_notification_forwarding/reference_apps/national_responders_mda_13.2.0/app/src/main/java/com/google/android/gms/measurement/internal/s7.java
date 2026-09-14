package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rf;

/* loaded from: classes.dex */
final class s7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ rf f6450f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ q f6451g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6452h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f6453i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s7(AppMeasurementDynamiteService appMeasurementDynamiteService, rf rfVar, q qVar, String str) {
        this.f6453i = appMeasurementDynamiteService;
        this.f6450f = rfVar;
        this.f6451g = qVar;
        this.f6452h = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6453i.f5790a.P().G(this.f6450f, this.f6451g, this.f6452h);
    }
}
