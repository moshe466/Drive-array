package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c<ResultT> implements g<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    private OnFailureListener c;

    public c(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new d(this, task));
        }
    }
}
