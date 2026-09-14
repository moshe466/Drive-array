package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class o8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f6294f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ p8 f6295g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o8(p8 p8Var, long j10) {
        this.f6295g = p8Var;
        this.f6294f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6295g.H(this.f6294f);
    }
}
