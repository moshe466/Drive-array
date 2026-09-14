package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x8 {

    /* renamed from: a, reason: collision with root package name */
    private final g2.e f6626a;

    /* renamed from: b, reason: collision with root package name */
    private long f6627b;

    public x8(g2.e eVar) {
        b2.p.k(eVar);
        this.f6626a = eVar;
    }

    public final void a() {
        this.f6627b = this.f6626a.b();
    }

    public final boolean b(long j10) {
        return this.f6627b == 0 || this.f6626a.b() - this.f6627b >= 3600000;
    }

    public final void c() {
        this.f6627b = 0L;
    }
}
