package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v2.a f6352f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f6353g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f6354h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f6355i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ w5 f6356j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q6(w5 w5Var, v2.a aVar, int i10, long j10, boolean z10) {
        this.f6356j = w5Var;
        this.f6352f = aVar;
        this.f6353g = i10;
        this.f6354h = j10;
        this.f6355i = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6356j.X(this.f6352f);
        this.f6356j.Z(this.f6352f, this.f6353g, this.f6354h, false, this.f6355i);
    }
}
