package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f6053f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ b7 f6054g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f7(b7 b7Var, long j10) {
        this.f6054g = b7Var;
        this.f6053f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6054g.o().v(this.f6053f);
        this.f6054g.f5859e = null;
    }
}
