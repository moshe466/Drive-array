package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d9 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ l9 f5943f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ e9 f5944g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d9(e9 e9Var, l9 l9Var) {
        this.f5944g = e9Var;
        this.f5943f = l9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5944g.v(this.f5943f);
        this.f5944g.k();
    }
}
