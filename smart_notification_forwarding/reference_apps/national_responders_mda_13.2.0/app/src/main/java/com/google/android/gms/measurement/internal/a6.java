package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class a6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f5808f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f5809g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a6(w5 w5Var, boolean z10) {
        this.f5809g = w5Var;
        this.f5808f = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean p10 = this.f5809g.f6381a.p();
        boolean T = this.f5809g.f6381a.T();
        this.f5809g.f6381a.o(this.f5808f);
        if (T == this.f5808f) {
            this.f5809g.f6381a.h().N().b("Default data collection state already set to", Boolean.valueOf(this.f5808f));
        }
        if (this.f5809g.f6381a.p() == p10 || this.f5809g.f6381a.p() != this.f5809g.f6381a.T()) {
            this.f5809g.f6381a.h().K().c("Default data collection is different than actual status", Boolean.valueOf(this.f5808f), Boolean.valueOf(p10));
        }
        this.f5809g.n0();
    }
}
