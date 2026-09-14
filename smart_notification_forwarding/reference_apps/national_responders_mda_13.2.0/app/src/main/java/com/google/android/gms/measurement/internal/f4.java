package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class f4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f6045f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ c4 f6046g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f4(c4 c4Var, boolean z10) {
        this.f6046g = c4Var;
        this.f6045f = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9Var = this.f6046g.f5892a;
        e9Var.D(this.f6045f);
    }
}
