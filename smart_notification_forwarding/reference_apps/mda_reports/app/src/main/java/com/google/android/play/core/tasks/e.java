package com.google.android.play.core.tasks;

/* loaded from: classes.dex */
final class e implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, Task task) {
        this.b = fVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.b.b;
        synchronized (obj) {
            onSuccessListener = this.b.c;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.b.c;
                onSuccessListener2.onSuccess(this.a.getResult());
            }
        }
    }
}
