package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class d5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ha f5929f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ y4 f5930g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d5(y4 y4Var, ha haVar) {
        this.f5930g = y4Var;
        this.f5929f = haVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9 e9Var3;
        e9Var = this.f5930g.f6633a;
        e9Var.k0();
        if (this.f5929f.f6093h.g() == null) {
            e9Var3 = this.f5930g.f6633a;
            e9Var3.T(this.f5929f);
        } else {
            e9Var2 = this.f5930g.f6633a;
            e9Var2.y(this.f5929f);
        }
    }
}
