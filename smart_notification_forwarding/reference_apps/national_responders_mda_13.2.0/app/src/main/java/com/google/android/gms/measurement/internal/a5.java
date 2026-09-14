package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class a5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ha f5805f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ v9 f5806g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ y4 f5807h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a5(y4 y4Var, ha haVar, v9 v9Var) {
        this.f5807h = y4Var;
        this.f5805f = haVar;
        this.f5806g = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        e9 e9Var3;
        e9Var = this.f5807h.f6633a;
        e9Var.k0();
        if (this.f5805f.f6093h.g() == null) {
            e9Var3 = this.f5807h.f6633a;
            e9Var3.U(this.f5805f, this.f5806g);
        } else {
            e9Var2 = this.f5807h.f6633a;
            e9Var2.z(this.f5805f, this.f5806g);
        }
    }
}
