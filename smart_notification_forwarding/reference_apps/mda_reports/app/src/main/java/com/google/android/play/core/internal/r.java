package com.google.android.play.core.internal;

/* loaded from: classes.dex */
public abstract class r implements Runnable {
    private final com.google.android.play.core.tasks.h<?> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r() {
        this.a = null;
    }

    public r(com.google.android.play.core.tasks.h<?> hVar) {
        this.a = hVar;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.play.core.tasks.h<?> b() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e) {
            com.google.android.play.core.tasks.h<?> hVar = this.a;
            if (hVar != null) {
                hVar.a(e);
            }
        }
    }
}
