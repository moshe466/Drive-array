package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b<ResultT> implements g<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    private OnCompleteListener<ResultT> c;

    public b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<ResultT> task) {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new a(this, task));
        }
    }
}
