package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class g5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6070f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ y4 f6071g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5(y4 y4Var, v9 v9Var) {
        this.f6071g = y4Var;
        this.f6070f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6071g.f6633a;
        e9Var.k0();
        e9Var2 = this.f6071g.f6633a;
        e9Var2.x(this.f6070f);
    }
}
