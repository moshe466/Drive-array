package com.google.firebase.installations;

/* loaded from: classes.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final f f7356f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f7357g;

    private d(f fVar, boolean z10) {
        this.f7356f = fVar;
        this.f7357g = z10;
    }

    public static Runnable a(f fVar, boolean z10) {
        return new d(fVar, z10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7356f.g(this.f7357g);
    }
}
