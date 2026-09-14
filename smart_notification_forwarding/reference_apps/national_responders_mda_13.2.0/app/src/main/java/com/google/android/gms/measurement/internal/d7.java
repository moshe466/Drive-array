package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c7 f5936f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ c7 f5937g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f5938h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f5939i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ b7 f5940j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d7(b7 b7Var, c7 c7Var, c7 c7Var2, long j10, boolean z10) {
        this.f5940j = b7Var;
        this.f5936f = c7Var;
        this.f5937g = c7Var2;
        this.f5938h = j10;
        this.f5939i = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5940j.P(this.f5936f, this.f5937g, this.f5938h, this.f5939i, null);
    }
}
