package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    final ObservableSource<? extends T> a;
    final ObservableSource<U> b;

    /* loaded from: classes3.dex */
    final class DelayObserver implements Observer<U> {
        final SequentialDisposable a;
        final Observer<? super T> b;
        boolean c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                DelayObserver.this.b.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DelayObserver.this.b.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(T t) {
                DelayObserver.this.b.onNext(t);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.a.update(disposable);
            }
        }

        DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.a = sequentialDisposable;
            this.b = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            ObservableDelaySubscriptionOther.this.a.subscribe(new OnComplete());
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.a = observableSource;
        this.b = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.b.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
