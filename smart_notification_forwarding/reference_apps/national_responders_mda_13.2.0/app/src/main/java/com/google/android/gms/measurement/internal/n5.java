package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class n5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ n9 f6249f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ v9 f6250g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ y4 f6251h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n5(y4 y4Var, n9 n9Var, v9 v9Var) {
        this.f6251h = y4Var;
        this.f6249f = n9Var;
        this.f6250g = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9 e9Var3;
        e9Var = this.f6251h.f6633a;
        e9Var.k0();
        if (this.f6249f.g() == null) {
            e9Var3 = this.f6251h.f6633a;
            e9Var3.R(this.f6249f, this.f6250g);
        } else {
            e9Var2 = this.f6251h.f6633a;
            e9Var2.w(this.f6249f, this.f6250g);
        }
    }
}
