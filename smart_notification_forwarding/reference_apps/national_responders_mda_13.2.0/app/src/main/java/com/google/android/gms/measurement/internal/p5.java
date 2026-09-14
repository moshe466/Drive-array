package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class p5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6317f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ y4 f6318g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p5(y4 y4Var, v9 v9Var) {
        this.f6318g = y4Var;
        this.f6317f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6318g.f6633a;
        e9Var.k0();
        e9Var2 = this.f6318g.f6633a;
        e9Var2.S(this.f6317f);
    }
}
