package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class h8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e8 f6089f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h8(e8 e8Var) {
        this.f6089f = e8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k7.C(this.f6089f.f6000c, null);
        this.f6089f.f6000c.h0();
    }
}
