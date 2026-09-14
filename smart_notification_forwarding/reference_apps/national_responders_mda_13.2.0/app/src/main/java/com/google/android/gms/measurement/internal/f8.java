package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class f8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v2.c f6055f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ e8 f6056g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f8(e8 e8Var, v2.c cVar) {
        this.f6056g = e8Var;
        this.f6055f = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6056g) {
            e8.c(this.f6056g, false);
            if (!this.f6056g.f6000c.V()) {
                this.f6056g.f6000c.h().M().a("Connected to remote service");
                this.f6056g.f6000c.S(this.f6055f);
            }
        }
    }
}
