package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    final long b;

    /* loaded from: classes3.dex */
    static final class TakeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        boolean b;
        Disposable c;
        long d;

        TakeObserver(Observer<? super T> observer, long j) {
            this.a = observer;
            this.d = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.b) {
                return;
            }
            this.b = true;
            this.c.dispose();
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.b) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.b = true;
            this.c.dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            long j = this.d;
            this.d = j - 1;
            if (j > 0) {
                boolean z = this.d == 0;
                this.a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                if (this.d != 0) {
                    this.a.onSubscribe(this);
                    return;
                }
                this.b = true;
                disposable.dispose();
                EmptyDisposable.complete(this.a);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.b = j;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new TakeObserver(observer, this.b));
    }
}
