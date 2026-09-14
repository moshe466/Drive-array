package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class r8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f6390f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ p8 f6391g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r8(p8 p8Var, long j10) {
        this.f6391g = p8Var;
        this.f6390f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6391g.J(this.f6390f);
    }
}
