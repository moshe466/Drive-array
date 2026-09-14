package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes3.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> b;

    /* loaded from: classes3.dex */
    static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final Observer<? super T> a;
        final ObservableSource<? extends T> b;
        boolean d = true;
        final SequentialDisposable c = new SequentialDisposable();

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.b = observableSource;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.d) {
                this.a.onComplete();
            } else {
                this.d = false;
                this.b.subscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                this.d = false;
            }
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.c.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.b = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.b);
        observer.onSubscribe(switchIfEmptyObserver.c);
        this.a.subscribe(switchIfEmptyObserver);
    }
}
