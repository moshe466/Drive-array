package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f6199f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ n9 f6200g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ v9 f6201h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ k7 f6202i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l7(k7 k7Var, boolean z10, n9 n9Var, v9 v9Var) {
        this.f6202i = k7Var;
        this.f6199f = z10;
        this.f6200g = n9Var;
        this.f6201h = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6202i.f6164d;
        if (cVar == null) {
            this.f6202i.h().F().a("Discarding data. Failed to set user property");
        } else {
            this.f6202i.T(cVar, this.f6199f ? null : this.f6200g, this.f6201h);
            this.f6202i.e0();
        }
    }
}
