package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class c6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f5899f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f5900g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c6(w5 w5Var, long j10) {
        this.f5900g = w5Var;
        this.f5899f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5900g.l().f5969p.b(this.f5899f);
        this.f5900g.h().M().b("Minimum session duration set", Long.valueOf(this.f5899f));
    }
}
