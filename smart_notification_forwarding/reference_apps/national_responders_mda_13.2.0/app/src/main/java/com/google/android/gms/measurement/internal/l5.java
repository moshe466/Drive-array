package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class l5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ q f6191f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6192g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ y4 f6193h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l5(y4 y4Var, q qVar, String str) {
        this.f6193h = y4Var;
        this.f6191f = qVar;
        this.f6192g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6193h.f6633a;
        e9Var.k0();
        e9Var2 = this.f6193h.f6633a;
        e9Var2.r(this.f6191f, this.f6192g);
    }
}
