package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> b;
    final boolean c;

    /* loaded from: classes3.dex */
    static final class OnErrorNextObserver<T> implements Observer<T> {
        final Observer<? super T> a;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> b;
        final boolean c;
        final SequentialDisposable d = new SequentialDisposable();
        boolean e;
        boolean f;

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = z;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e = true;
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                if (this.f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.e = true;
            if (this.c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                ObservableSource<? extends T> apply = this.b.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d.replace(disposable);
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.b, this.c);
        observer.onSubscribe(onErrorNextObserver.d);
        this.a.subscribe(onErrorNextObserver);
    }
}
