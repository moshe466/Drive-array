package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class f6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f6051f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6052g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f6(w5 w5Var, long j10) {
        this.f6052g = w5Var;
        this.f6051f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6052g.D(this.f6051f, true);
        this.f6052g.r().P(new AtomicReference<>());
    }
}
