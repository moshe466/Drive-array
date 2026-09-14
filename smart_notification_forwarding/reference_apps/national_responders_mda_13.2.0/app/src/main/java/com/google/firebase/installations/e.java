package com.google.firebase.installations;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final f f7358f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f7359g;

    private e(f fVar, boolean z10) {
        this.f7358f = fVar;
        this.f7359g = z10;
    }

    public static Runnable a(f fVar, boolean z10) {
        return new e(fVar, z10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7358f.f(this.f7359g);
    }
}
