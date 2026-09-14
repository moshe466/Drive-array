package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected Disposable c;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.c.dispose();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        T t = this.b;
        if (t == null) {
            complete();
        } else {
            this.b = null;
            complete(t);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.b = null;
        error(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.c, disposable)) {
            this.c = disposable;
            this.a.onSubscribe(this);
        }
    }
}
