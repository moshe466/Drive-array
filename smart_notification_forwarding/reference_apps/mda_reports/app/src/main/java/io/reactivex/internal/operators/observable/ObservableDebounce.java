package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        final Function<? super T, ? extends ObservableSource<U>> b;
        Disposable c;
        final AtomicReference<Disposable> d = new AtomicReference<>();
        volatile long e;
        boolean f;

        /* loaded from: classes3.dex */
        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            final DebounceObserver<T, U> b;
            final long c;
            final T d;
            boolean e;
            final AtomicBoolean f = new AtomicBoolean();

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j, T t) {
                this.b = debounceObserver;
                this.c = j;
                this.d = t;
            }

            void b() {
                if (this.f.compareAndSet(false, true)) {
                    this.b.a(this.c, this.d);
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.e) {
                    return;
                }
                this.e = true;
                b();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (this.e) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.e = true;
                    this.b.onError(th);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                if (this.e) {
                    return;
                }
                this.e = true;
                dispose();
                b();
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.a = observer;
            this.b = function;
        }

        void a(long j, T t) {
            if (j == this.e) {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            Disposable disposable = this.d.get();
            if (disposable != DisposableHelper.DISPOSED) {
                ((DebounceInnerObserver) disposable).b();
                DisposableHelper.dispose(this.d);
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            long j = this.e + 1;
            this.e = j;
            Disposable disposable = this.d.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The ObservableSource supplied is null");
                DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j, t);
                if (this.d.compareAndSet(disposable, debounceInnerObserver)) {
                    observableSource.subscribe(debounceInnerObserver);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.b = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new DebounceObserver(new SerializedObserver(observer), this.b));
    }
}
