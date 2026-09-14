package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> b;
    final ObservableSource<? extends U> c;

    /* loaded from: classes3.dex */
    final class WithLastFrom implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> wlf;

        WithLastFrom(ObservableWithLatestFrom observableWithLatestFrom, WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.wlf = withLatestFromObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.wlf.otherError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            this.wlf.lazySet(u);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.wlf.setOther(disposable);
        }
    }

    /* loaded from: classes3.dex */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final Observer<? super R> a;
        final BiFunction<? super T, ? super U, ? extends R> b;
        final AtomicReference<Disposable> c = new AtomicReference<>();
        final AtomicReference<Disposable> d = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.a = observer;
            this.b = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.c);
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.c.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.d);
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.a.onNext(ObjectHelper.requireNonNull(this.b.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    this.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.c, disposable);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.c);
            this.a.onError(th);
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.b = biFunction;
        this.c = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.b);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.c.subscribe(new WithLastFrom(this, withLatestFromObserver));
        this.a.subscribe(withLatestFromObserver);
    }
}
