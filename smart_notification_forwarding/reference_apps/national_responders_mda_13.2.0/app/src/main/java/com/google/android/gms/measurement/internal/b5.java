package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class b5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f5853f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ y4 f5854g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b5(y4 y4Var, v9 v9Var) {
        this.f5854g = y4Var;
        this.f5853f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f5854g.f6633a;
        e9Var.k0();
        e9Var2 = this.f5854g.f6633a;
        v9 v9Var = this.f5853f;
        e9Var2.e().c();
        e9Var2.i0();
        b2.p.g(v9Var.f6560f);
        e9Var2.V(v9Var);
    }
}
