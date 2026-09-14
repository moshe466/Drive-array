package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v2.a f6382f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f6383g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f6384h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f6385i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f6386j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ w5 f6387k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r6(w5 w5Var, v2.a aVar, long j10, int i10, long j11, boolean z10) {
        this.f6387k = w5Var;
        this.f6382f = aVar;
        this.f6383g = j10;
        this.f6384h = i10;
        this.f6385i = j11;
        this.f6386j = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6387k.X(this.f6382f);
        this.f6387k.D(this.f6383g, false);
        this.f6387k.Z(this.f6382f, this.f6384h, this.f6385i, true, this.f6386j);
    }
}
