package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v2.a f6502f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f6503g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f6504h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f6505i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ w5 f6506j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t6(w5 w5Var, v2.a aVar, int i10, long j10, boolean z10) {
        this.f6506j = w5Var;
        this.f6502f = aVar;
        this.f6503g = i10;
        this.f6504h = j10;
        this.f6505i = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6506j.X(this.f6502f);
        this.f6506j.Z(this.f6502f, this.f6503g, this.f6504h, false, this.f6505i);
    }
}
