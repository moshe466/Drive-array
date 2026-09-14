package com.google.android.play.core.tasks;

/* loaded from: classes.dex */
final class d implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Task task) {
        this.b = cVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.b.b;
        synchronized (obj) {
            onFailureListener = this.b.c;
            if (onFailureListener != null) {
                onFailureListener2 = this.b.c;
                onFailureListener2.onFailure(this.a.getException());
            }
        }
    }
}
