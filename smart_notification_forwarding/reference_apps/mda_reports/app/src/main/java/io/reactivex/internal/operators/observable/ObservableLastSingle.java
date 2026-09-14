package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class ObservableLastSingle<T> extends Single<T> {
    final ObservableSource<T> a;
    final T b;

    /* loaded from: classes3.dex */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> a;
        final T b;
        Disposable c;
        T d;

        LastObserver(SingleObserver<? super T> singleObserver, T t) {
            this.a = singleObserver;
            this.b = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c = DisposableHelper.DISPOSED;
            T t = this.d;
            if (t != null) {
                this.d = null;
            } else {
                t = this.b;
                if (t == null) {
                    this.a.onError(new NoSuchElementException());
                    return;
                }
            }
            this.a.onSuccess(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.c = DisposableHelper.DISPOSED;
            this.d = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.d = t;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t) {
        this.a = observableSource;
        this.b = t;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new LastObserver(singleObserver, this.b));
    }
}
