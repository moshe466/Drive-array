package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected final Observer<? super R> a;
    protected Disposable b;
    protected QueueDisposable<T> c;
    protected boolean d;
    protected int e;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.a = observer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i) {
        QueueDisposable<T> queueDisposable = this.c;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i);
        if (requestFusion != 0) {
            this.e = requestFusion;
        }
        return requestFusion;
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.b.dispose();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.c.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.d) {
            RxJavaPlugins.onError(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.b, disposable)) {
            this.b = disposable;
            if (disposable instanceof QueueDisposable) {
                this.c = (QueueDisposable) disposable;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }
}
