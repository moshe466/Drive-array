package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c7 f6122f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f6123g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ b7 f6124h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i7(b7 b7Var, c7 c7Var, long j10) {
        this.f6124h = b7Var;
        this.f6122f = c7Var;
        this.f6123g = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6124h.Q(this.f6122f, false, this.f6123g);
        b7 b7Var = this.f6124h;
        b7Var.f5859e = null;
        b7Var.r().K(null);
    }
}
