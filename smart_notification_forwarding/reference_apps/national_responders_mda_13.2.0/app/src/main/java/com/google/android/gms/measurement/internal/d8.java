package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class d8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v2.c f5941f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ e8 f5942g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d8(e8 e8Var, v2.c cVar) {
        this.f5942g = e8Var;
        this.f5941f = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5942g) {
            e8.c(this.f5942g, false);
            if (!this.f5942g.f6000c.V()) {
                this.f5942g.f6000c.h().N().a("Connected to service");
                this.f5942g.f6000c.S(this.f5941f);
            }
        }
    }
}
