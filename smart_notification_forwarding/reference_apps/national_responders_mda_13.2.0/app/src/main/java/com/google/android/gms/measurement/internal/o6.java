package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Boolean f6289f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6290g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o6(w5 w5Var, Boolean bool) {
        this.f6290g = w5Var;
        this.f6289f = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6290g.M(this.f6289f, true);
    }
}
