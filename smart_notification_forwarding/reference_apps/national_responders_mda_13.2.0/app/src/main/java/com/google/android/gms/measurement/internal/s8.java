package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rf;

/* loaded from: classes.dex */
final class s8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ rf f6454f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6455g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6456h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f6457i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s8(AppMeasurementDynamiteService appMeasurementDynamiteService, rf rfVar, String str, String str2) {
        this.f6457i = appMeasurementDynamiteService;
        this.f6454f = rfVar;
        this.f6455g = str;
        this.f6456h = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6457i.f5790a.P().H(this.f6454f, this.f6455g, this.f6456h);
    }
}
