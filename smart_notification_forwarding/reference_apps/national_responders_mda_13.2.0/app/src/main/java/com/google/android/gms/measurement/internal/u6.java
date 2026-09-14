package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rf;

/* loaded from: classes.dex */
final class u6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ rf f6527f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6528g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6529h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f6530i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f6531j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u6(AppMeasurementDynamiteService appMeasurementDynamiteService, rf rfVar, String str, String str2, boolean z10) {
        this.f6531j = appMeasurementDynamiteService;
        this.f6527f = rfVar;
        this.f6528g = str;
        this.f6529h = str2;
        this.f6530i = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6531j.f5790a.P().I(this.f6527f, this.f6528g, this.f6529h, this.f6530i);
    }
}
