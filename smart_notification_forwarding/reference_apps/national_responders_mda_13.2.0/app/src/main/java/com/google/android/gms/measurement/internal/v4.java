package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ t5 f6548f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ t4 f6549g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v4(t4 t4Var, t5 t5Var) {
        this.f6549g = t4Var;
        this.f6548f = t5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6549g.l(this.f6548f);
        this.f6549g.c(this.f6548f.f6499g);
    }
}
