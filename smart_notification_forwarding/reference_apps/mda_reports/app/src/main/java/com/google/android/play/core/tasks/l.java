package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.ag;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class l<ResultT> extends Task<ResultT> {
    private final Object a = new Object();
    private final i<ResultT> b = new i<>();
    private boolean c;
    private ResultT d;
    private Exception e;

    private final void a() {
        ag.a(this.c, "Task is not yet complete");
    }

    private final void b() {
        ag.a(!this.c, "Task is already complete");
    }

    private final void c() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }

    public final void a(Exception exc) {
        ag.a(exc, "Exception must not be null");
        synchronized (this.a) {
            b();
            this.c = true;
            this.e = exc;
        }
        this.b.a(this);
    }

    public final void a(ResultT resultt) {
        synchronized (this.a) {
            b();
            this.c = true;
            this.d = resultt;
        }
        this.b.a(this);
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.b.a(new b(executor, onCompleteListener));
        c();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.b.a(new c(executor, onFailureListener));
        c();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.b.a(new f(executor, onSuccessListener));
        c();
        return this;
    }

    public final boolean b(Exception exc) {
        ag.a(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean b(ResultT resultt) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = resultt;
            this.b.a(this);
            return true;
        }
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.a) {
            a();
            if (this.e != null) {
                throw new RuntimeExecutionException(this.e);
            }
            resultt = this.d;
        }
        return resultt;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final <X extends Throwable> ResultT getResult(Class<X> cls) {
        ResultT resultt;
        synchronized (this.a) {
            a();
            if (cls.isInstance(this.e)) {
                throw cls.cast(this.e);
            }
            if (this.e != null) {
                throw new RuntimeExecutionException(this.e);
            }
            resultt = this.d;
        }
        return resultt;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.c && this.e == null;
        }
        return z;
    }
}
