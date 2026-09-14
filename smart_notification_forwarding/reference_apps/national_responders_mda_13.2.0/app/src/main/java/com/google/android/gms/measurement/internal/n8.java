package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e9 f6256f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Runnable f6257g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n8(j8 j8Var, e9 e9Var, Runnable runnable) {
        this.f6256f = e9Var;
        this.f6257g = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6256f.k0();
        this.f6256f.A(this.f6257g);
        this.f6256f.j0();
    }
}
