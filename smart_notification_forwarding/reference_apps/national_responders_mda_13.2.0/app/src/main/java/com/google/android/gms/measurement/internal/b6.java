package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class b6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f5855f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f5856g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b6(w5 w5Var, long j10) {
        this.f5856g = w5Var;
        this.f5855f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5856g.l().f5970q.b(this.f5855f);
        this.f5856g.h().M().b("Session timeout duration set", Long.valueOf(this.f5855f));
    }
}
