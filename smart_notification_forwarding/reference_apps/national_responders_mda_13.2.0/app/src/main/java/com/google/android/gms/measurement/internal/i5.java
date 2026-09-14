package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class i5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ q f6115f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ v9 f6116g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ y4 f6117h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5(y4 y4Var, q qVar, v9 v9Var) {
        this.f6117h = y4Var;
        this.f6115f = qVar;
        this.f6116g = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        q y02 = this.f6117h.y0(this.f6115f, this.f6116g);
        e9Var = this.f6117h.f6633a;
        e9Var.k0();
        e9Var2 = this.f6117h.f6633a;
        e9Var2.q(y02, this.f6116g);
    }
}
