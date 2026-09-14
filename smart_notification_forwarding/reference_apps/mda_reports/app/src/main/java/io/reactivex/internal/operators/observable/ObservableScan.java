package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> b;

    /* loaded from: classes3.dex */
    static final class ScanObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        final BiFunction<T, T, T> b;
        Disposable c;
        T d;
        boolean e;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.a = observer;
            this.b = biFunction;
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
            if (this.e) {
                return;
            }
            this.e = true;
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
            } else {
                this.e = true;
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.e) {
                return;
            }
            Observer<? super T> observer = this.a;
            T t2 = this.d;
            if (t2 != null) {
                try {
                    t = (T) ObjectHelper.requireNonNull(this.b.apply(t2, t), "The value returned by the accumulator is null");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.c.dispose();
                    onError(th);
                    return;
                }
            }
            this.d = t;
            observer.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.b = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new ScanObserver(observer, this.b));
    }
}
