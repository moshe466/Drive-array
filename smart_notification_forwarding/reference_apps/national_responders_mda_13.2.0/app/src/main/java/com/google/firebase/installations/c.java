package com.google.firebase.installations;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final f f7355f;

    private c(f fVar) {
        this.f7355f = fVar;
    }

    public static Runnable a(f fVar) {
        return new c(fVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7355f.g(false);
    }
}
