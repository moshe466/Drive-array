package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class c3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f5890f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ a f5891g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c3(a aVar, long j10) {
        this.f5891g = aVar;
        this.f5890f = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5891g.B(this.f5890f);
    }
}
