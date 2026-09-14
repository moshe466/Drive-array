package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ s5 f6173f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ i f6174g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, s5 s5Var) {
        this.f6174g = iVar;
        this.f6173f = s5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6173f.n();
        if (ea.a()) {
            this.f6173f.e().z(this);
            return;
        }
        boolean d10 = this.f6174g.d();
        i.a(this.f6174g, 0L);
        if (d10) {
            this.f6174g.b();
        }
    }
}
