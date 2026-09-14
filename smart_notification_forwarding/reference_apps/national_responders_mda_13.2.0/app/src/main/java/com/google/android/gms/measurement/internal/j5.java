package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.bc;

/* loaded from: classes.dex */
final class j5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6137f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ y4 f6138g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j5(y4 y4Var, v9 v9Var) {
        this.f6138g = y4Var;
        this.f6137f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6138g.f6633a;
        e9Var.k0();
        e9Var2 = this.f6138g.f6633a;
        v9 v9Var = this.f6137f;
        if (bc.a() && e9Var2.L().t(s.J0)) {
            e9Var2.e().c();
            e9Var2.i0();
            b2.p.g(v9Var.f6560f);
            v2.a f10 = v2.a.f(v9Var.B);
            v2.a j10 = e9Var2.j(v9Var.f6560f);
            e9Var2.h().N().c("Setting consent, package, consent", v9Var.f6560f, f10);
            e9Var2.C(v9Var.f6560f, f10);
            if (f10.h(j10)) {
                e9Var2.x(v9Var);
            }
        }
    }
}
